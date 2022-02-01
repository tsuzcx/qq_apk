package com.tencent.mobileqq.vas;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.MobileQQ;

public class ThemeChangeBroadcastReceiver
  extends BroadcastReceiver
{
  private QQAppInterface a;
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    ((MobileQQ)paramContext.getApplicationContext()).waitAppRuntime(null);
    if ("com.tencent.qplus.THEME_INVALIDATE".equals(paramIntent.getAction())) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ThemeChangeBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */