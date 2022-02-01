package com.tencent.tmassistantbase.a;

import android.content.Context;
import android.os.Handler;
import android.os.Process;
import android.util.Log;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

class n
  extends Thread
{
  n(m paramm, String paramString)
  {
    super(paramString);
  }
  
  public void run()
  {
    int i = 0;
    if ((k.g()) && (k.t.compareAndSet(false, true))) {
      try
      {
        k.j();
        try
        {
          k.o = k.h.getPackageName();
          k.j = new LinkedBlockingQueue(15000);
          k.n = Process.myPid();
          Log.d("TMLog", "TMLog init start ");
          k.k();
          k.y.setName("logWriteThread");
          k.y.start();
          k.w.removeCallbacks(k.x);
          return;
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            k.o = "unknow";
          }
        }
        int j;
        return;
      }
      catch (Exception localException2)
      {
        k.t.set(false);
        localException2.printStackTrace();
        j = k.v.get();
        Log.d("TMLog", "TMLog init post retry " + j + " times, interval " + k.u[j]);
        k.w.removeCallbacks(k.x);
        k.w.postDelayed(k.x, k.u[j] * 60000);
        j += 1;
        if (j >= k.u.length) {}
        for (;;)
        {
          k.v.set(i);
          return;
          i = j;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistantbase.a.n
 * JD-Core Version:    0.7.0.1
 */