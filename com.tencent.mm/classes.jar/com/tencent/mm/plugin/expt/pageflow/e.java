package com.tencent.mm.plugin.expt.pageflow;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.ll;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.expt.b.f.a;
import com.tencent.mm.plugin.expt.edge.d.a.2;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.apache.commons.c.i;

public final class e
{
  private static e zMu;
  
  private void a(c.a parama, ll paramll)
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
    MultiProcessMMKV localMultiProcessMMKV = aBP();
    if (localMultiProcessMMKV == null)
    {
      AppMethodBeat.o(122391);
      return;
    }
    String str = localMultiProcessMMKV.getString(parama.name(), "");
    str = str + "|" + paramll.ut(";");
    long l2 = localMultiProcessMMKV.getLong(parama.name() + "_rpttime", 0L);
    if (((str.length() >= i) || (Util.secondsToNow(l2) > 3600L)) && (paramll.ixB % 2L == 0L))
    {
      localMultiProcessMMKV.putLong(parama.name() + "_rpttime", Util.nowSecond());
      localMultiProcessMMKV.putString(parama.name(), "");
      h.OAn.kvStat(16562, str);
      if (parama == c.a.yOH) {
        atp(str);
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
  
  private static MultiProcessMMKV aBP()
  {
    AppMethodBeat.i(122392);
    int i = com.tencent.mm.kernel.b.aZP();
    if (i == 0)
    {
      AppMethodBeat.o(122392);
      return null;
    }
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV(i + "_WxPageFlowMerge");
    AppMethodBeat.o(122392);
    return localMultiProcessMMKV;
  }
  
  private void atp(final String paramString)
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
              localObject4 = new ll(((String)localObject4).replace(';', ','));
              if ((((ll)localObject4).iSV > 0L) && (((ll)localObject4).ixB > 0L)) {
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
                com.tencent.mm.plugin.expt.edge.b.hf("EdgeComputingDataSourceService", "[EdgeComputingDataSourceService] sendForeBack data : ".concat(String.valueOf(localException1)));
                l1 = System.currentTimeMillis();
                ((com.tencent.mm.plugin.expt.edge.d.a)localObject2).zzP.post(new a.2((com.tencent.mm.plugin.expt.edge.d.a)localObject2, l1, localException1));
                continue;
              }
              try
              {
                localObject4 = (ll)((List)localObject2).get(j);
                if (j + 1 < k) {
                  localObject1 = (ll)((List)localObject2).get(j + 1);
                }
                if ((localObject4 == null) || (localObject1 == null)) {
                  break label694;
                }
                if ((((ll)localObject4).ixB != 7L) || (((ll)localObject1).ixB != 8L) || (((ll)localObject4).iSV >= ((ll)localObject1).iSV) || (((ll)localObject4).iAo != ((ll)localObject1).iAo)) {
                  continue;
                }
                if (l1 <= 0L) {
                  break label697;
                }
                l1 = ((ll)localObject4).iSV - l1;
              }
              catch (Exception localException2)
              {
                continue;
                continue;
                l1 = 0L;
                continue;
              }
              ((StringBuffer)localObject3).append(String.format("{\"tbe\":%d.\"ten\":%d.\"in\":%d.\"inbg\":%d}", new Object[] { Long.valueOf(((ll)localObject4).iSV), Long.valueOf(((ll)localObject1).iSV), Long.valueOf(((ll)localObject1).iSV - ((ll)localObject4).iSV), Long.valueOf(l1) })).append(";");
              l1 = ((ll)localObject1).iSV;
              i += 1;
              j += 2;
              continue;
              if (((ll)localObject4).ixB != 8L) {
                break label694;
              }
              l1 = ((ll)localObject4).iSV;
              j += 1;
            }
          }
          localObject3 = ((StringBuffer)localObject3).toString();
          if (!Util.isNullOrNil((String)localObject3))
          {
            localObject2 = ((String)localObject3).replace(".", ",").replace(";", ",");
            localObject1 = localObject2;
            if (i.qA(((String)localObject2).substring(((String)localObject2).length() - 1), ",")) {
              localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 1);
            }
            localObject1 = "[" + (String)localObject1 + "]";
            localObject2 = com.tencent.mm.plugin.expt.edge.a.dHT().zxY;
            if (com.tencent.mm.plugin.expt.edge.b.dHV())
            {
              if (i.hm((String)localObject1)) {
                Log.e("EdgeComputingDataSourceService", "[EdgeComputingDataSourceService] sendForeBack data isEmpty!");
              }
            }
            else
            {
              h.OAn.b(16563, new Object[] { localObject3, Long.valueOf(Util.ticksToNow(l2)), Integer.valueOf(i) });
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
  
  public static e dNe()
  {
    AppMethodBeat.i(122389);
    if (zMu == null) {
      zMu = new e();
    }
    e locale = zMu;
    AppMethodBeat.o(122389);
    return locale;
  }
  
  public final void a(ll paramll)
  {
    AppMethodBeat.i(122390);
    if (paramll == null)
    {
      AppMethodBeat.o(122390);
      return;
    }
    int i = (int)paramll.ixB;
    if ((i == f.a.zxt.value) || (i == f.a.zxu.value))
    {
      a(c.a.yOF, paramll);
      if (a.dMW()) {
        paramll.bMH();
      }
    }
    if ((i == f.a.zxv.value) || (i == f.a.zxw.value))
    {
      a(c.a.yOG, paramll);
      if (a.dMX()) {
        paramll.bMH();
      }
    }
    if (((i == f.a.zxz.value) || (i == f.a.zxA.value)) && (com.tencent.mm.plugin.expt.hellhound.a.dIK()) && (com.tencent.mm.plugin.expt.hellhound.a.dIL()))
    {
      a(c.a.yOH, paramll);
      if (a.dMY()) {
        paramll.bMH();
      }
    }
    AppMethodBeat.o(122390);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.pageflow.e
 * JD-Core Version:    0.7.0.1
 */