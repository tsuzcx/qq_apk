package com.tencent.matrix;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.e.a;
import com.tencent.matrix.e.a.a;
import com.tencent.matrix.report.k;
import com.tencent.matrix.report.k.b;
import com.tencent.matrix.trace.f.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.concurrent.ConcurrentLinkedDeque;
import org.json.JSONObject;

final class d$4
  implements c.a
{
  d$4(d paramd) {}
  
  public final void a(int paramInt, final String paramString, final long paramLong)
  {
    h.ZvG.be(new Runnable()
    {
      public final void run()
      {
        int i = 4;
        int j = 1;
        for (;;)
        {
          try
          {
            long l1 = System.currentTimeMillis() - paramLong;
            if (l1 <= 0L) {
              break;
            }
            Log.i("MatrixDelegate", "happens dropFrames : dropFrame = %d, scene = %s, lastResumeTime = %d, timeAfterResume = %d", new Object[] { Integer.valueOf(paramString), this.cQM, Long.valueOf(paramLong), Long.valueOf(l1) });
            if ((l1 <= 2000L) || (!this.cQM.contains("Finder"))) {
              break;
            }
            if (paramString < 15)
            {
              i = 1;
              int k = a.bx(MMApplicationContext.getContext()).value;
              long l2 = Math.min(paramString * 16, 2000);
              Thread.sleep(l2);
              if ((d.cQA.cQB == null) || (d.cQA.cQB.dar == null)) {
                break label370;
              }
              k.b localb = (k.b)d.cQA.cQB.dar.getFirst();
              if (localb != null)
              {
                long l3 = localb.cZZ.getLong("time");
                if (System.currentTimeMillis() - l3 < l2 * 2L)
                {
                  String str = "";
                  if (j != 0) {
                    str = localb.cZZ.toString();
                  }
                  com.tencent.mm.plugin.report.f.Iyx.a(20502, new Object[] { Integer.valueOf(paramString), this.cQM, Integer.valueOf(i), Integer.valueOf(k), Long.valueOf(l1), str });
                }
              }
            }
            else
            {
              if (paramString < 30)
              {
                i = 2;
                continue;
              }
              if (paramString < 60)
              {
                i = 3;
                continue;
              }
              if (paramString < 90) {
                continue;
              }
              i = paramString;
              if (i < 120)
              {
                i = 5;
                continue;
              }
              i = 6;
              continue;
            }
            j = 0;
          }
          catch (Throwable localThrowable)
          {
            Log.i("MatrixDelegate", "report dropFrame error = " + localThrowable.getMessage());
            return;
          }
          continue;
          label370:
          Object localObject = null;
        }
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.d.4
 * JD-Core Version:    0.7.0.1
 */