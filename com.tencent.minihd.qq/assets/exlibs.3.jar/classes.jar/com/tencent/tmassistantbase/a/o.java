package com.tencent.tmassistantbase.a;

import android.util.Log;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

final class o
  extends Thread
{
  public void run()
  {
    try
    {
      for (;;)
      {
        String str = (String)k.j.take();
        if (str != null) {
          k.b(str);
        }
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        Log.d("TMLog", "write log file error." + localInterruptedException);
      }
    }
    catch (Throwable localThrowable1)
    {
      if (((localThrowable1 instanceof IOException)) && (localThrowable1.getMessage().contains("ENOSPC")))
      {
        if (k.s.compareAndSet(false, true)) {
          localThrowable1.printStackTrace();
        }
        return;
      }
      k.s.compareAndSet(true, false);
      localThrowable1.printStackTrace();
      try
      {
        k.k();
        return;
      }
      catch (Throwable localThrowable2)
      {
        localThrowable2.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistantbase.a.o
 * JD-Core Version:    0.7.0.1
 */