package com.tencent.mobileqq.msf.core;

import android.content.Context;
import android.net.wifi.WifiManager;
import com.tencent.qphone.base.util.QLog;

class r
  extends Thread
{
  r(p paramp) {}
  
  public void run()
  {
    p.b(this.a, true);
    int i = 0;
    for (;;)
    {
      if (i < p.b(this.a).g)
      {
        i += 1;
        if (p.c(this.a))
        {
          ((WifiManager)p.d(this.a).getSystemService("wifi")).startScan();
          if (QLog.isColorLevel()) {
            QLog.d("QQWiFiScanManager", 2, "accScan, launch count=" + i);
          }
        }
      }
      try
      {
        Thread.sleep(p.b(this.a).h);
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQWiFiScanManager", 2, "accScan, count=" + i + ", stopped");
      }
      p.b(this.a, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.r
 * JD-Core Version:    0.7.0.1
 */