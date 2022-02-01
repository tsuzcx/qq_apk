package com.tencent.mobileqq.msf.core;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.qphone.base.util.BaseApplication;

public class m
{
  private static boolean a;
  
  public static boolean a()
  {
    if (!a) {
      if (Build.VERSION.SDK_INT < 23) {
        break label44;
      }
    }
    label44:
    for (a = TextUtils.equals(BaseApplication.getContext().getSharedPreferences("c_profile_sharepreference", 4).getString("privacypolicy_state", "0"), "1");; a = true) {
      return a;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.m
 * JD-Core Version:    0.7.0.1
 */