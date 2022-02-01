package com.tencent.mm.plugin.expt.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.gw;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.expt.b.e.a;
import com.tencent.mm.plugin.expt.d.b;
import com.tencent.mm.plugin.expt.d.d.a.2;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;
import org.apache.commons.b.g;

public final class e
{
  private static e sKu;
  
  private static MultiProcessMMKV VQ()
  {
    AppMethodBeat.i(122392);
    int i = com.tencent.mm.kernel.a.azs();
    if (i == 0)
    {
      AppMethodBeat.o(122392);
      return null;
    }
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV(i + "_WxPageFlowMerge");
    AppMethodBeat.o(122392);
    return localMultiProcessMMKV;
  }
  
  private void a(b.a parama, gw paramgw)
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
    MultiProcessMMKV localMultiProcessMMKV = VQ();
    if (localMultiProcessMMKV == null)
    {
      AppMethodBeat.o(122391);
      return;
    }
    String str = localMultiProcessMMKV.getString(parama.name(), "");
    str = str + "|" + paramgw.uL(";");
    long l2 = localMultiProcessMMKV.getLong(parama.name() + "_rpttime", 0L);
    if (((str.length() >= i) || (Util.secondsToNow(l2) > 3600L)) && (paramgw.erY % 2L == 0L))
    {
      localMultiProcessMMKV.putLong(parama.name() + "_rpttime", Util.nowSecond());
      localMultiProcessMMKV.putString(parama.name(), "");
      h.CyF.kvStat(16562, str);
      if (parama == b.a.rUj) {
        arh(str);
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
  
  private void arh(final String paramString)
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
              localObject4 = new gw(((String)localObject4).replace(';', ','));
              if ((((gw)localObject4).eHw > 0L) && (((gw)localObject4).erY > 0L)) {
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
                ((com.tencent.mm.plugin.expt.d.d.a)localObject2).sxy.execute(new a.2((com.tencent.mm.plugin.expt.d.d.a)localObject2, l1, localException1));
                continue;
              }
              try
              {
                localObject4 = (gw)((List)localObject2).get(j);
                if (j + 1 < k) {
                  localObject1 = (gw)((List)localObject2).get(j + 1);
                }
                if ((localObject4 == null) || (localObject1 == null)) {
                  break label678;
                }
                if ((((gw)localObject4).erY != 7L) || (((gw)localObject1).erY != 8L) || (((gw)localObject4).eHw >= ((gw)localObject1).eHw) || (((gw)localObject4).euv != ((gw)localObject1).euv)) {
                  continue;
                }
                if (l1 <= 0L) {
                  break label681;
                }
                l1 = ((gw)localObject4).eHw - l1;
              }
              catch (Exception localException2)
              {
                continue;
                continue;
                l1 = 0L;
                continue;
              }
              ((StringBuffer)localObject3).append(String.format("{\"tbe\":%d.\"ten\":%d.\"in\":%d.\"inbg\":%d}", new Object[] { Long.valueOf(((gw)localObject4).eHw), Long.valueOf(((gw)localObject1).eHw), Long.valueOf(((gw)localObject1).eHw - ((gw)localObject4).eHw), Long.valueOf(l1) })).append(";");
              l1 = ((gw)localObject1).eHw;
              i += 1;
              j += 2;
              continue;
              if (((gw)localObject4).erY != 8L) {
                break label678;
              }
              l1 = ((gw)localObject4).eHw;
              j += 1;
            }
          }
          localObject3 = ((StringBuffer)localObject3).toString();
          if (!Util.isNullOrNil((String)localObject3))
          {
            localObject2 = ((String)localObject3).replace(".", ",").replace(";", ",");
            localObject1 = localObject2;
            if (g.equals(((String)localObject2).substring(((String)localObject2).length() - 1), ",")) {
              localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 1);
            }
            localObject1 = "[" + (String)localObject1 + "]";
            localObject2 = com.tencent.mm.plugin.expt.d.a.cMI().sxs;
            if (b.cML())
            {
              if (g.eP((String)localObject1)) {
                Log.e("EdgeComputingDataSourceService", "[EdgeComputingDataSourceService] sendForeBack data isEmpty!");
              }
            }
            else
            {
              h.CyF.a(16563, new Object[] { localObject3, Long.valueOf(Util.ticksToNow(l2)), Integer.valueOf(i) });
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
  
  public static e cRy()
  {
    AppMethodBeat.i(122389);
    if (sKu == null) {
      sKu = new e();
    }
    e locale = sKu;
    AppMethodBeat.o(122389);
    return locale;
  }
  
  public final void a(gw paramgw)
  {
    AppMethodBeat.i(122390);
    if (paramgw == null)
    {
      AppMethodBeat.o(122390);
      return;
    }
    int i = (int)paramgw.erY;
    if ((i == e.a.sxa.value) || (i == e.a.sxb.value))
    {
      a(b.a.rUh, paramgw);
      if (a.cRq()) {
        paramgw.bfK();
      }
    }
    if ((i == e.a.sxc.value) || (i == e.a.sxd.value))
    {
      a(b.a.rUi, paramgw);
      if (a.cRr()) {
        paramgw.bfK();
      }
    }
    if (((i == e.a.sxg.value) || (i == e.a.sxh.value)) && (com.tencent.mm.plugin.expt.hellhound.a.cNo()) && (com.tencent.mm.plugin.expt.hellhound.a.cNp()))
    {
      a(b.a.rUj, paramgw);
      if (a.cRs()) {
        paramgw.bfK();
      }
    }
    AppMethodBeat.o(122390);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.g.e
 * JD-Core Version:    0.7.0.1
 */