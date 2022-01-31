package com.tencent.mm.plugin.expt.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.y;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class e$1
  implements Runnable
{
  e$1(e parame, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(73554);
    Object localObject1 = this.mcq;
    Object localObject2 = this.fpJ;
    if (!bo.isNullOrNil((String)localObject2))
    {
      long l2 = bo.yB();
      Object localObject3 = ((String)localObject2).split("\\|");
      localObject2 = new ArrayList();
      j = localObject3.length;
      i = 0;
      Object localObject4;
      while (i < j)
      {
        localObject4 = localObject3[i];
        if (!bo.isNullOrNil((String)localObject4))
        {
          localObject4 = new y(((String)localObject4).replace(';', ','));
          if ((((y)localObject4).cSI > 0L) && (((y)localObject4).cSH > 0L)) {
            ((List)localObject2).add(localObject4);
          }
        }
        i += 1;
      }
      localObject3 = new StringBuffer();
      j = 0;
      i = 0;
      if (!((List)localObject2).isEmpty())
      {
        Collections.sort((List)localObject2, new e.2((e)localObject1));
        for (;;)
        {
          try
          {
            k = ((List)localObject2).size();
            localObject1 = null;
            l1 = 0L;
            j = 0;
            i = 0;
            if (j >= k) {
              break;
            }
          }
          catch (Exception localException1)
          {
            int k;
            i = j;
            ab.printErrStackTrace("MicroMsg.MMPageReporter", localException1, "reportWeixinAppTime error", new Object[0]);
            continue;
          }
          try
          {
            localObject4 = (y)((List)localObject2).get(j);
            if (j + 1 < k) {
              localObject1 = (y)((List)localObject2).get(j + 1);
            }
            if ((localObject4 == null) || (localObject1 == null)) {
              break label539;
            }
            if ((((y)localObject4).cSH != 7L) || (((y)localObject1).cSH != 8L) || (((y)localObject4).cSI >= ((y)localObject1).cSI) || (((y)localObject4).cRR != ((y)localObject1).cRR)) {
              continue;
            }
            if (l1 <= 0L) {
              break label542;
            }
            l1 = ((y)localObject4).cSI - l1;
          }
          catch (Exception localException2)
          {
            continue;
            continue;
            l1 = 0L;
            continue;
          }
          ((StringBuffer)localObject3).append(String.format("{\"tbe\":%d.\"ten\":%d.\"in\":%d.\"inbg\":%d}", new Object[] { Long.valueOf(((y)localObject4).cSI), Long.valueOf(((y)localObject1).cSI), Long.valueOf(((y)localObject1).cSI - ((y)localObject4).cSI), Long.valueOf(l1) })).append(";");
          l1 = ((y)localObject1).cSI;
          i += 1;
          j += 2;
          continue;
          if (((y)localObject4).cSH != 8L) {
            break label539;
          }
          l1 = ((y)localObject4).cSI;
          j += 1;
        }
      }
      localObject1 = ((StringBuffer)localObject3).toString();
      if (!bo.isNullOrNil((String)localObject1))
      {
        h.qsU.e(16563, new Object[] { localObject1, Long.valueOf(bo.av(l2)), Integer.valueOf(i) });
        ab.i("MicroMsg.MMPageReporter", "reportWeixinAppTime [%s]", new Object[] { localObject1 });
      }
      ab.i("MicroMsg.MMPageReporter", "reportWeixinAppTime cost[%d] count[%d]", new Object[] { Long.valueOf(bo.av(l2)), Integer.valueOf(i) });
    }
    AppMethodBeat.o(73554);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.c.e.1
 * JD-Core Version:    0.7.0.1
 */