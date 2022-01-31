package com.tencent.mm.d.a;

import com.eclipsesource.v8.MultiContextV8;
import com.eclipsesource.v8.V8Locker;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.util.concurrent.ConcurrentLinkedQueue;

final class h$1
  extends Thread
{
  h$1(h paramh) {}
  
  public final void run()
  {
    ai.Fd(-2);
    boolean bool;
    synchronized (this.bzE.bzA)
    {
      bool = this.bzE.ahC;
      if (!bool)
      {
        y.i("MicroMsg.J2V8.V8EngineLooper", "stop break");
        return;
      }
    }
    synchronized (this.bzE.bzC)
    {
      for (;;)
      {
        if (!this.bzE.sn)
        {
          bool = this.bzE.bzC.isEmpty();
          if (!bool) {}
        }
        else
        {
          try
          {
            this.bzE.bzC.wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            y.e("MicroMsg.J2V8.V8EngineLooper", "wait exp:%s", new Object[] { localInterruptedException.getLocalizedMessage() });
          }
        }
      }
    }
    ??? = this.bzE;
    V8Locker localV8Locker = ((h)???).bzA.getV8Locker();
    localV8Locker.acquire();
    for (;;)
    {
      Runnable localRunnable = (Runnable)((h)???).bzC.poll();
      if (localRunnable != null)
      {
        if (!((h)???).ahC) {
          y.i("MicroMsg.J2V8.V8EngineLooper", "processTasks stop already, rest:%s", new Object[] { Integer.valueOf(((h)???).bzC.size()) });
        }
      }
      else
      {
        localV8Locker.release();
        break;
      }
      ((h)???).j(localRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.d.a.h.1
 * JD-Core Version:    0.7.0.1
 */