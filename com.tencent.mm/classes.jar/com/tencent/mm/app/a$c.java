package com.tencent.mm.app;

import android.os.Debug;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.p;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

final class a$c
  implements Runnable
{
  int bXg;
  private final Runnable bXh;
  
  a$c()
  {
    AppMethodBeat.i(15357);
    this.bXg = 0;
    this.bXh = new a.c.1(this);
    AppMethodBeat.o(15357);
  }
  
  public final void run()
  {
    AppMethodBeat.i(15358);
    h.qsU.idkeyStat(510L, 0L, 1L, true);
    Thread localThread = Thread.currentThread();
    ab.i("MicroMsg.ANRWatchDog.summeranr", "summeranr ANRWatchDog run thread[%s]", new Object[] { localThread });
    int i = -1;
    for (;;)
    {
      if (!localThread.isInterrupted())
      {
        int j = this.bXg;
        a.AN().post(this.bXh);
        try
        {
          Thread.sleep(a.AL());
          if (this.bXg != j) {
            continue;
          }
          if ((!a.access$900()) && (Debug.isDebuggerConnected()))
          {
            if (this.bXg != i) {
              ab.w("MicroMsg.ANRWatchDog.summeranr", "summeranr An ANR was detected but ignored because the debugger is connected (you can prevent this with setIgnoreDebugger(true))");
            }
            i = this.bXg;
          }
        }
        catch (InterruptedException localInterruptedException1)
        {
          a.AO().a(localInterruptedException1);
          ab.i("MicroMsg.ANRWatchDog.summeranr", "summeranr ANRWatchDog run thread sleep and interrupted[%b]", new Object[] { Boolean.valueOf(localThread.isInterrupted()) });
          AppMethodBeat.o(15358);
          return;
        }
        a.AN().removeCallbacks(this.bXh);
        ab.i("MicroMsg.ANRWatchDog.summeranr", "summeranr ANRWatchDog run thread detect anr CpuUsage[%d, %d, %d]", new Object[] { Long.valueOf(a.AP().LA()), Long.valueOf(a.AP().LB()), Long.valueOf(a.AP().Lz()) });
        try
        {
          Thread.sleep(1000L);
          ab.i("MicroMsg.ANRWatchDog.summeranr", "summeranr ANRWatchDog run thread detect anr new sThreadNamePrefix[%s],lastTick tick[%d, %d], current[%d]", new Object[] { a.access$1100(), Integer.valueOf(j), Integer.valueOf(this.bXg), Long.valueOf(System.currentTimeMillis()) });
          if (a.access$1100() != null)
          {
            a.a locala1 = a.a.k(a.access$1100(), a.AQ());
            h.qsU.idkeyStat(510L, 1L, 1L, true);
            switch (a.AR())
            {
            default: 
              if (a.AS() > 0) {
                h.qsU.idkeyStat(510L, 7L, 1L, true);
              }
              a.AT().c(locala1);
              a.AU();
              if (a.AS() >= 10) {
                a.AV();
              }
              l = a.gc(a.AS()) * 5 * 60 * 1000L;
              this.bXg = 0;
              ab.i("MicroMsg.ANRWatchDog.summeranr", "summeranr ANRWatchDog run thread set next detect sFibIndex[%d], sleepTime[%d], lastTick, tick[%d, %d]", new Object[] { Integer.valueOf(a.AS()), Long.valueOf(l), Integer.valueOf(0), Integer.valueOf(this.bXg) });
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
              ab.i("MicroMsg.ANRWatchDog.summeranr", "summeranr ANRWatchDog run thread set next detect sFibIndex[%d], sleepTime[%d], lastTick, tick[%d, %d] wakeup", new Object[] { Integer.valueOf(a.AS()), Long.valueOf(l), Integer.valueOf(0), Integer.valueOf(this.bXg) });
            }
            catch (InterruptedException localInterruptedException3)
            {
              a.a locala2;
              a.AO().a(localInterruptedException3);
              ab.i("MicroMsg.ANRWatchDog.summeranr", "summeranr ANRWatchDog run thread sleep and interrupted when wait for next detect[%b]", new Object[] { Boolean.valueOf(localThread.isInterrupted()) });
              AppMethodBeat.o(15358);
              return;
            }
            localInterruptedException2 = localInterruptedException2;
            ab.i("MicroMsg.ANRWatchDog.summeranr", "summeranr ANRWatchDog run thread detect anr wait for GetCpuUsage interrupted[%b]", new Object[] { Boolean.valueOf(localThread.isInterrupted()) });
            continue;
            locala2 = a.a.AW();
            continue;
            h.qsU.idkeyStat(510L, 2L, 1L, true);
            continue;
            h.qsU.idkeyStat(510L, 3L, 1L, true);
            continue;
            h.qsU.idkeyStat(510L, 4L, 1L, true);
            continue;
            h.qsU.idkeyStat(510L, 5L, 1L, true);
            continue;
            h.qsU.idkeyStat(510L, 6L, 1L, true);
            continue;
            h.qsU.idkeyStat(510L, 13L, 1L, true);
          }
        }
      }
    }
    ab.i("MicroMsg.ANRWatchDog.summeranr", "summeranr ANRWatchDog run thread isInterrupted[%b]", new Object[] { Boolean.valueOf(localThread.isInterrupted()) });
    AppMethodBeat.o(15358);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.app.a.c
 * JD-Core Version:    0.7.0.1
 */