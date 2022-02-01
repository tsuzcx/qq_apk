package com.tencent.mobileqq.msf.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class q
  extends BroadcastReceiver
{
  q(p paramp) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d("QQWiFiScanManager", 2, "onReceive broadcast action = " + paramContext);
    }
    if (paramContext.equals("android.intent.action.SCREEN_ON")) {
      p.a(this.a, true);
    }
    do
    {
      do
      {
        return;
        if (paramContext.equals("android.intent.action.SCREEN_OFF"))
        {
          p.a(this.a, false);
          return;
        }
      } while (!paramContext.equals("android.net.wifi.SCAN_RESULTS"));
      try
      {
        p.a(this.a);
        return;
      }
      catch (Throwable paramContext) {}
    } while (!QLog.isColorLevel());
    QLog.e("QQWiFiScanManager", 2, "onReceive, SCAN_RESULTS_AVAILABLE_ACTION", paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.q
 * JD-Core Version:    0.7.0.1
 */