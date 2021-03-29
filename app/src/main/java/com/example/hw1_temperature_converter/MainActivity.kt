package com.example.hw1_temperature_converter

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.example.hw1_temperature_converter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.convert.setOnClickListener {
            convertTemp(it)
        }
    }
    private fun convertTemp(view: View) {
        binding.apply {
            val inputTemp = input.text.toString()?.toDouble()
            val outputTemp = (inputTemp - 32) * 5 / 9
            output.text = "%.2f".format(outputTemp)
        }

        // Hide the keyboard.
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}