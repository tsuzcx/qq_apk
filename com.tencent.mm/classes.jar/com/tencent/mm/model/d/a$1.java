package com.tencent.mm.model.d;

import android.os.HandlerThread;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ak.b;
import com.tencent.mm.sdk.platformtools.al;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

public final class a$1
  implements ak.b
{
  public a$1(a parama) {}
  
  public final void a(Message paramMessage, Runnable paramRunnable, Thread paramThread, long paramLong1, long paramLong2, float paramFloat)
  {
    AppMethodBeat.i(16372);
    if (paramThread == null)
    {
      AppMethodBeat.o(16372);
      return;
    }
    long l = paramThread.getId();
    Object localObject2 = null;
    Object localObject1;
    if (paramLong1 > a.a(this.fpv)) {
      if (paramMessage != null) {
        localObject1 = "|HMonitor dispatch|msg = " + paramMessage + "|handler = " + paramMessage.getTarget() + "|threadName = " + paramThread.getName() + "|threadId = " + paramThread.getId() + "|priority = " + paramThread.getPriority() + "|usedTime = " + paramLong1 + "|cpuTime = " + paramLong2;
      }
    }
    while (aw.RO().oNc.getLooper() == null)
    {
      ab.w("MicroMsg.HandlerTraceManager", "worker thread's looper is dead");
      AppMethodBeat.o(16372);
      return;
      localObject1 = localObject2;
      if (paramRunnable != null)
      {
        localObject1 = "|HMonitor run task|" + ak.dump(paramRunnable, true);
        continue;
        localObject1 = localObject2;
        if (paramLong1 > a.b(this.fpv))
        {
          localObject1 = localObject2;
          if (l == a.access$200()) {
            if (paramMessage != null)
            {
              localObject1 = "|HMonitor dispatch|msg = " + paramMessage + "|handler = " + paramMessage.getTarget() + "|threadName = " + paramThread.getName() + "|threadId = " + paramThread.getId() + "|priority = " + paramThread.getPriority() + "|usedTime = " + paramLong1 + "|cpuTime = " + paramLong2;
            }
            else
            {
              localObject1 = localObject2;
              if (paramRunnable != null) {
                localObject1 = "|HMonitor run task|" + ak.dump(paramRunnable, true);
              }
            }
          }
        }
      }
    }
    if ((paramRunnable != null) && (paramLong1 > a.c(this.fpv)) && (l == a.d(this.fpv)))
    {
      paramMessage = new a.a();
      paramMessage.fpw = paramLong1;
      paramMessage.info = ak.dump(paramRunnable, false);
      if (a.e(this.fpv).size() >= a.f(this.fpv)) {
        a.e(this.fpv).pop();
      }
      a.e(this.fpv).add(paramMessage);
    }
    int i;
    if ((paramRunnable != null) && (l == a.d(this.fpv)) && (paramFloat > 0.0F) && (paramFloat <= 100.0F))
    {
      if (paramFloat >= 30.0F) {
        break label608;
      }
      paramMessage = a.g(this.fpv);
      i = (int)(paramFloat / 2.0F);
      paramMessage[i] = Long.valueOf(paramMessage[i].longValue() + 1L);
    }
    while (System.currentTimeMillis() - a.h(this.fpv) > a.i(this.fpv))
    {
      a.a(this.fpv, System.currentTimeMillis());
      i = 0;
      while (i < 18)
      {
        if (a.g(this.fpv)[i].longValue() > 0L) {
          h.qsU.idkeyStat(230L, i, a.g(this.fpv)[i].longValue(), false);
        }
        i += 1;
      }
      label608:
      if (paramFloat < 40.0F)
      {
        paramMessage = a.g(this.fpv);
        paramMessage[15] = Long.valueOf(paramMessage[15].longValue() + 1L);
      }
      else if (paramFloat < 50.0F)
      {
        paramMessage = a.g(this.fpv);
        paramMessage[16] = Long.valueOf(paramMessage[16].longValue() + 1L);
      }
      else
      {
        paramMessage = a.g(this.fpv);
        paramMessage[17] = Long.valueOf(paramMessage[17].longValue() + 1L);
      }
    }
    if (localObject1 == null)
    {
      AppMethodBeat.o(16372);
      return;
    }
    if (!b.foreground) {
      ab.i("MicroMsg.HandlerTraceManager", (String)localObject1);
    }
    if (!a.j(this.fpv))
    {
      a.a(this.fpv, a.aca().format(new Date()) + (String)localObject1 + "\n");
      AppMethodBeat.o(16372);
      return;
    }
    AppMethodBeat.o(16372);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.d.a.1
 * JD-Core Version:    0.7.0.1
 */