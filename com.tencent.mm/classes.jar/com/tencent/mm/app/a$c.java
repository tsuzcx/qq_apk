package com.tencent.mm.app;

import android.os.Debug;
import android.os.Handler;
import com.tencent.mm.compatible.e.p;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;

final class a$c
  implements Runnable
{
  int bvV = 0;
  private final Runnable bvW = new a.c.1(this);
  
  public final void run()
  {
    h.nFQ.a(510L, 0L, 1L, true);
    Thread localThread = Thread.currentThread();
    y.i("MicroMsg.ANRWatchDog.summeranr", "summeranr ANRWatchDog run thread[%s]", new Object[] { localThread });
    int i = -1;
    for (;;)
    {
      if (!localThread.isInterrupted())
      {
        int j = this.bvV;
        a.sw().post(this.bvW);
        try
        {
          Thread.sleep(a.su());
          if (this.bvV != j) {
            continue;
          }
          if ((!a.access$900()) && (Debug.isDebuggerConnected()))
          {
            if (this.bvV != i) {
              y.w("MicroMsg.ANRWatchDog.summeranr", "summeranr An ANR was detected but ignored because the debugger is connected (you can prevent this with setIgnoreDebugger(true))");
            }
            i = this.bvV;
          }
        }
        catch (InterruptedException localInterruptedException1)
        {
          a.sx().a(localInterruptedException1);
          y.i("MicroMsg.ANRWatchDog.summeranr", "summeranr ANRWatchDog run thread sleep and interrupted[%b]", new Object[] { Boolean.valueOf(localThread.isInterrupted()) });
          return;
        }
        a.sw().removeCallbacks(this.bvW);
        y.i("MicroMsg.ANRWatchDog.summeranr", "summeranr ANRWatchDog run thread detect anr CpuUsage[%d, %d, %d]", new Object[] { Long.valueOf(a.sy().zd()), Long.valueOf(a.sy().ze()), Long.valueOf(a.sy().zc()) });
        try
        {
          Thread.sleep(1000L);
          y.i("MicroMsg.ANRWatchDog.summeranr", "summeranr ANRWatchDog run thread detect anr new sThreadNamePrefix[%s],lastTick tick[%d, %d], current[%d]", new Object[] { a.sz(), Integer.valueOf(j), Integer.valueOf(this.bvV), Long.valueOf(System.currentTimeMillis()) });
          if (a.sz() != null)
          {
            a.a locala1 = a.a.i(a.sz(), a.sA());
            h.nFQ.a(510L, 1L, 1L, true);
            switch (a.sB())
            {
            default: 
              if (a.access$1400() > 0) {
                h.nFQ.a(510L, 7L, 1L, true);
              }
              a.sC().c(locala1);
              a.sD();
              if (a.access$1400() >= 10) {
                a.sE();
              }
              l = a.ep(a.access$1400()) * 5 * 60 * 1000L;
              this.bvV = 0;
              y.i("MicroMsg.ANRWatchDog.summeranr", "summeranr ANRWatchDog run thread set next detect sFibIndex[%d], sleepTime[%d], lastTick, tick[%d, %d]", new Object[] { Integer.valueOf(a.access$1400()), Long.valueOf(l), Integer.valueOf(0), Integer.valueOf(this.bvV) });
            }
          }
        }
        catch (InterruptedException localInterruptedException2)
        {
          for (;;)
          {
            try
            {
              long l;
              Thread.sleep(l);
              y.i("MicroMsg.ANRWatchDog.summeranr", "summeranr ANRWatchDog run thread set next detect sFibIndex[%d], sleepTime[%d], lastTick, tick[%d, %d] wakeup", new Object[] { Integer.valueOf(a.access$1400()), Long.valueOf(l), Integer.valueOf(0), Integer.valueOf(this.bvV) });
            }
            catch (InterruptedException localInterruptedException3)
            {
              a.a locala2;
              a.sx().a(localInterruptedException3);
              y.i("MicroMsg.ANRWatchDog.summeranr", "summeranr ANRWatchDog run thread sleep and interrupted when wait for next detect[%b]", new Object[] { Boolean.valueOf(localThread.isInterrupted()) });
              return;
            }
            localInterruptedException2 = localInterruptedException2;
            y.i("MicroMsg.ANRWatchDog.summeranr", "summeranr ANRWatchDog run thread detect anr wait for GetCpuUsage interrupted[%b]", new Object[] { Boolean.valueOf(localThread.isInterrupted()) });
            continue;
            locala2 = a.a.sF();
            continue;
            h.nFQ.a(510L, 2L, 1L, true);
            continue;
            h.nFQ.a(510L, 3L, 1L, true);
            continue;
            h.nFQ.a(510L, 4L, 1L, true);
            continue;
            h.nFQ.a(510L, 5L, 1L, true);
            continue;
            h.nFQ.a(510L, 6L, 1L, true);
            continue;
            h.nFQ.a(510L, 13L, 1L, true);
          }
        }
      }
    }
    y.i("MicroMsg.ANRWatchDog.summeranr", "summeranr ANRWatchDog run thread isInterrupted[%b]", new Object[] { Boolean.valueOf(localThread.isInterrupted()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.app.a.c
 * JD-Core Version:    0.7.0.1
 */