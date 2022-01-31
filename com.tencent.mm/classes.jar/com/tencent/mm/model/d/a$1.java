package com.tencent.mm.model.d;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ah.b;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

public final class a$1
  implements ah.b
{
  public a$1(a parama) {}
  
  public final void onLog(Message paramMessage, Runnable paramRunnable, Thread paramThread, long paramLong1, long paramLong2, float paramFloat)
  {
    if (paramThread == null) {}
    Object localObject1;
    label597:
    do
    {
      do
      {
        return;
        long l = paramThread.getId();
        Object localObject2 = null;
        if (paramLong1 > a.a(this.dZq)) {
          if (paramMessage != null) {
            localObject1 = "|HMonitor dispatch|msg = " + paramMessage + "|handler = " + paramMessage.getTarget() + "|threadName = " + paramThread.getName() + "|threadId = " + paramThread.getId() + "|priority = " + paramThread.getPriority() + "|usedTime = " + paramLong1 + "|cpuTime = " + paramLong2;
          }
        }
        while (au.DS().mnU.getLooper() == null)
        {
          y.w("MicroMsg.HandlerTraceManager", "worker thread's looper is dead");
          return;
          localObject1 = localObject2;
          if (paramRunnable != null)
          {
            localObject1 = "|HMonitor run task|" + ah.dump(paramRunnable, true);
            continue;
            localObject1 = localObject2;
            if (paramLong1 > a.b(this.dZq))
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
                    localObject1 = "|HMonitor run task|" + ah.dump(paramRunnable, true);
                  }
                }
              }
            }
          }
        }
        paramLong2 = au.DS().mnU.getLooper().getThread().getId();
        if ((paramRunnable != null) && (paramLong1 > a.c(this.dZq)) && (l == paramLong2))
        {
          paramMessage = new a.a();
          paramMessage.dZr = paramLong1;
          paramMessage.info = ah.dump(paramRunnable, false);
          if (a.d(this.dZq).size() >= a.e(this.dZq)) {
            a.d(this.dZq).pop();
          }
          a.d(this.dZq).add(paramMessage);
        }
        int i;
        if ((paramRunnable != null) && (l == paramLong2) && (paramFloat > 0.0F) && (paramFloat <= 100.0F))
        {
          if (paramFloat >= 30.0F) {
            break label597;
          }
          paramMessage = a.f(this.dZq);
          i = (int)(paramFloat / 2.0F);
          paramMessage[i] = Long.valueOf(paramMessage[i].longValue() + 1L);
        }
        while (System.currentTimeMillis() - a.g(this.dZq) > a.h(this.dZq))
        {
          a.a(this.dZq, System.currentTimeMillis());
          i = 0;
          while (i < 18)
          {
            if (a.f(this.dZq)[i].longValue() > 0L) {
              h.nFQ.a(230L, i, a.f(this.dZq)[i].longValue(), false);
            }
            i += 1;
          }
          if (paramFloat < 40.0F)
          {
            paramMessage = a.f(this.dZq);
            paramMessage[15] = Long.valueOf(paramMessage[15].longValue() + 1L);
          }
          else if (paramFloat < 50.0F)
          {
            paramMessage = a.f(this.dZq);
            paramMessage[16] = Long.valueOf(paramMessage[16].longValue() + 1L);
          }
          else
          {
            paramMessage = a.f(this.dZq);
            paramMessage[17] = Long.valueOf(paramMessage[17].longValue() + 1L);
          }
        }
      } while (localObject1 == null);
      if (!b.foreground) {
        y.i("MicroMsg.HandlerTraceManager", (String)localObject1);
      }
    } while (a.i(this.dZq));
    a.a(this.dZq, a.Jd().format(new Date()) + (String)localObject1 + "\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.model.d.a.1
 * JD-Core Version:    0.7.0.1
 */