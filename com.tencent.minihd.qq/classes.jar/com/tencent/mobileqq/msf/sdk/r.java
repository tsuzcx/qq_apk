package com.tencent.mobileqq.msf.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.Process;
import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

class r
  extends Thread
{
  r(q paramq, String paramString)
  {
    super(paramString);
  }
  
  public void run()
  {
    int i = 0;
    if ((o.c) && (o.j().compareAndSet(false, true))) {
      try
      {
        o.b(MsfSdkUtils.getProcessName(o.i()));
        try
        {
          o.c(o.i().getPackageName());
          o.c(Process.myPid());
          o.a(System.currentTimeMillis());
          o.m.setName("logWriteThread");
          o.m.start();
          o.k().removeCallbacks(o.j);
          return;
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            o.c("unknow");
          }
        }
        int j;
        return;
      }
      catch (Exception localException2)
      {
        o.j().set(false);
        localException2.printStackTrace();
        j = o.l().get();
        Log.d("appMemory", "QLog init post retry " + j + " times, interval " + o.m()[j]);
        o.k().removeCallbacks(o.j);
        o.k().postDelayed(o.j, o.m()[j] * 60000);
        j += 1;
        if (j >= o.m().length) {}
        for (;;)
        {
          o.l().set(i);
          return;
          i = j;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.r
 * JD-Core Version:    0.7.0.1
 */