package com.tencent.mm.plugin.expt.g;

import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.jb;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.expt.b.e.a;
import com.tencent.mm.plugin.expt.d.e.a.2;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.apache.commons.b.g;

public final class e
{
  private static e wqs;
  
  private void a(b.a parama, jb paramjb)
  {
    AppMethodBeat.i(122391);
    if (!MMApplicationContext.isMMProcess())
    {
      AppMethodBeat.o(122391);
      return;
    }
    long l1 = Util.currentTicks();
    int i = a.b(parama);
    if (i <= 0)
    {
      AppMethodBeat.o(122391);
      return;
    }
    MultiProcessMMKV localMultiProcessMMKV = aal();
    if (localMultiProcessMMKV == null)
    {
      AppMethodBeat.o(122391);
      return;
    }
    String str = localMultiProcessMMKV.getString(parama.name(), "");
    str = str + "|" + paramjb.Ai(";");
    long l2 = localMultiProcessMMKV.getLong(parama.name() + "_rpttime", 0L);
    if (((str.length() >= i) || (Util.secondsToNow(l2) > 3600L)) && (paramjb.goe % 2L == 0L))
    {
      localMultiProcessMMKV.putLong(parama.name() + "_rpttime", Util.nowSecond());
      localMultiProcessMMKV.putString(parama.name(), "");
      com.tencent.mm.plugin.report.service.h.IzE.kvStat(16562, str);
      if (parama == b.a.vAT) {
        azi(str);
      }
    }
    for (;;)
    {
      Log.v("MicroMsg.MMPageReporter", "handle merge cost[%d]", new Object[] { Long.valueOf(Util.ticksToNow(l1)) });
      AppMethodBeat.o(122391);
      return;
      localMultiProcessMMKV.putString(parama.name(), str);
    }
  }
  
  private static MultiProcessMMKV aal()
  {
    AppMethodBeat.i(122392);
    int i = com.tencent.mm.kernel.b.aGP();
    if (i == 0)
    {
      AppMethodBeat.o(122392);
      return null;
    }
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV(i + "_WxPageFlowMerge");
    AppMethodBeat.o(122392);
    return localMultiProcessMMKV;
  }
  
  private void azi(final String paramString)
  {
    AppMethodBeat.i(122393);
    ThreadPool.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(122387);
        Object localObject1 = e.this;
        localObject2 = paramString;
        if (!Util.isNullOrNil((String)localObject2))
        {
          long l2 = Util.currentTicks();
          Object localObject3 = ((String)localObject2).split("\\|");
          localObject2 = new ArrayList();
          j = localObject3.length;
          i = 0;
          Object localObject4;
          while (i < j)
          {
            localObject4 = localObject3[i];
            if (!Util.isNullOrNil((String)localObject4))
            {
              localObject4 = new jb(((String)localObject4).replace(';', ','));
              if ((((jb)localObject4).gFX > 0L) && (((jb)localObject4).goe > 0L)) {
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
                Log.printErrStackTrace("MicroMsg.MMPageReporter", localException1, "reportWeixinAppTime error", new Object[0]);
                continue;
                l1 = System.currentTimeMillis();
                com.tencent.e.h.ZvG.be(new a.2((com.tencent.mm.plugin.expt.d.e.a)localObject2, l1, localException1));
                continue;
              }
              try
              {
                localObject4 = (jb)((List)localObject2).get(j);
                if (j + 1 < k) {
                  localObject1 = (jb)((List)localObject2).get(j + 1);
                }
                if ((localObject4 == null) || (localObject1 == null)) {
                  break label679;
                }
                if ((((jb)localObject4).goe != 7L) || (((jb)localObject1).goe != 8L) || (((jb)localObject4).gFX >= ((jb)localObject1).gFX) || (((jb)localObject4).gqB != ((jb)localObject1).gqB)) {
                  continue;
                }
                if (l1 <= 0L) {
                  break label682;
                }
                l1 = ((jb)localObject4).gFX - l1;
              }
              catch (Exception localException2)
              {
                continue;
                continue;
                l1 = 0L;
                continue;
              }
              ((StringBuffer)localObject3).append(String.format("{\"tbe\":%d.\"ten\":%d.\"in\":%d.\"inbg\":%d}", new Object[] { Long.valueOf(((jb)localObject4).gFX), Long.valueOf(((jb)localObject1).gFX), Long.valueOf(((jb)localObject1).gFX - ((jb)localObject4).gFX), Long.valueOf(l1) })).append(";");
              l1 = ((jb)localObject1).gFX;
              i += 1;
              j += 2;
              continue;
              if (((jb)localObject4).goe != 8L) {
                break label679;
              }
              l1 = ((jb)localObject4).gFX;
              j += 1;
            }
          }
          localObject3 = ((StringBuffer)localObject3).toString();
          if (!Util.isNullOrNil((String)localObject3))
          {
            localObject2 = ((String)localObject3).replace(".", ",").replace(";", ",");
            localObject1 = localObject2;
            if (g.oC(((String)localObject2).substring(((String)localObject2).length() - 1), ",")) {
              localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 1);
            }
            localObject1 = "[" + (String)localObject1 + "]";
            localObject2 = com.tencent.mm.plugin.expt.d.a.dbw().wcY;
            if (com.tencent.mm.plugin.expt.d.b.dby())
            {
              if (g.fK((String)localObject1)) {
                Log.e("EdgeComputingDataSourceService", "[EdgeComputingDataSourceService] sendForeBack data isEmpty!");
              }
            }
            else
            {
              com.tencent.mm.plugin.report.service.h.IzE.a(16563, new Object[] { localObject3, Long.valueOf(Util.ticksToNow(l2)), Integer.valueOf(i) });
              Log.i("MicroMsg.MMPageReporter", "reportWeixinAppTime [%s]", new Object[] { localObject3 });
            }
          }
          else
          {
            Log.i("MicroMsg.MMPageReporter", "reportWeixinAppTime cost[%d] count[%d]", new Object[] { Long.valueOf(Util.ticksToNow(l2)), Integer.valueOf(i) });
          }
        }
        else
        {
          AppMethodBeat.o(122387);
          return;
        }
      }
    }, "report_weixin_app_time");
    AppMethodBeat.o(122393);
  }
  
  public static e dgt()
  {
    AppMethodBeat.i(122389);
    if (wqs == null) {
      wqs = new e();
    }
    e locale = wqs;
    AppMethodBeat.o(122389);
    return locale;
  }
  
  public final void a(jb paramjb)
  {
    AppMethodBeat.i(122390);
    if (paramjb == null)
    {
      AppMethodBeat.o(122390);
      return;
    }
    int i = (int)paramjb.goe;
    if ((i == e.a.wcC.value) || (i == e.a.wcD.value))
    {
      a(b.a.vAR, paramjb);
      if (a.dgl()) {
        paramjb.bpa();
      }
    }
    if ((i == e.a.wcE.value) || (i == e.a.wcF.value))
    {
      a(b.a.vAS, paramjb);
      if (a.dgm()) {
        paramjb.bpa();
      }
    }
    if (((i == e.a.wcI.value) || (i == e.a.wcJ.value)) && (com.tencent.mm.plugin.expt.hellhound.a.dcg()) && (com.tencent.mm.plugin.expt.hellhound.a.dch()))
    {
      a(b.a.vAT, paramjb);
      if (a.dgn()) {
        paramjb.bpa();
      }
    }
    AppMethodBeat.o(122390);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.g.e
 * JD-Core Version:    0.7.0.1
 */