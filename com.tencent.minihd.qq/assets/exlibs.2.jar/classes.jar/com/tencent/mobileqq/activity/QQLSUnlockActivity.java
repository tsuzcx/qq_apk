package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.provider.Settings.System;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;

public class QQLSUnlockActivity
  extends Activity
  implements Handler.Callback
{
  static final int jdField_a_of_type_Int = 0;
  public static final String a = "QQLSActivity";
  Handler jdField_a_of_type_AndroidOsHandler;
  
  private int a()
  {
    int j = 10000;
    try
    {
      i = Settings.System.getInt(getContentResolver(), "screen_off_timeout");
      if (QLog.isDevelopLevel()) {
        QLog.d("QQLSActivity", 4, "getScreenOffTime " + i);
      }
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = j;
        if (QLog.isDevelopLevel())
        {
          QLog.d("QQLSActivity", 4, "getScreenOffTime e=" + localException.getMessage());
          i = j;
        }
      }
    }
  }
  
  public SharedPreferences getSharedPreferences(String paramString, int paramInt)
  {
    return SharedPreferencesProxyManager.getInstance().getProxy(paramString, paramInt);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      finish();
    }
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    try
    {
      Object localObject = getWindow().getAttributes().token;
      String str = getClass().getName();
      localObject = localObject.toString() + "----->" + str;
      StatisticCollector.a(this).a("WindowToken2Activity", (String)localObject);
      return;
    }
    catch (Exception localException) {}
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    StatisticCollector.a(this).a(this);
    getWindow().addFlags(4718592);
    this.a = new Handler(this);
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "enter QQLSUnlockActivity");
    }
    if (Build.MANUFACTURER.equalsIgnoreCase("xiaomi")) {
      ((PowerManager)getSystemService("power")).newWakeLock(268435462, "test").acquire(a());
    }
    this.a.sendEmptyMessageDelayed(0, 1500L);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    StatisticCollector.a(this).d(this);
  }
  
  protected void onPause()
  {
    super.onPause();
    StatisticCollector.a(this).c(this);
  }
  
  protected void onResume()
  {
    super.onResume();
    StatisticCollector.a(this).b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQLSUnlockActivity
 * JD-Core Version:    0.7.0.1
 */