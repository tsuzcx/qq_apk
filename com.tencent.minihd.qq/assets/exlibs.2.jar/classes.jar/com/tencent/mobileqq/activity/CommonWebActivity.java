package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class CommonWebActivity
  extends QQBrowserActivity
{
  protected boolean onBackEvent()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    if ((localInputMethodManager != null) && (getCurrentFocus() != null)) {
      localInputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
    }
    setResult(-1, new Intent());
    finish();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.CommonWebActivity
 * JD-Core Version:    0.7.0.1
 */