package com.tencent.mm.plugin.expt.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.dr;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.expt.b.e.a;
import com.tencent.mm.plugin.expt.d.d.a.2;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

public final class e
{
  private static e raM;
  
  private static ax Lv()
  {
    AppMethodBeat.i(122392);
    int i = com.tencent.mm.kernel.a.aiN();
    if (i == 0)
    {
      AppMethodBeat.o(122392);
      return null;
    }
    ax localax = ax.aQz(i + "_WxPageFlowMerge");
    AppMethodBeat.o(122392);
    return localax;
  }
  
  private void a(b.a parama, dr paramdr)
  {
    AppMethodBeat.i(122391);
    if (!aj.cnC())
    {
      AppMethodBeat.o(122391);
      return;
    }
    long l1 = bt.HI();
    int i = a.b(parama);
    if (i <= 0)
    {
      AppMethodBeat.o(122391);
      return;
    }
    ax localax = Lv();
    if (localax == null)
    {
      AppMethodBeat.o(122391);
      return;
    }
    String str = localax.getString(parama.name(), "");
    str = str + "|" + paramdr.nd(";");
    long l2 = localax.getLong(parama.name() + "_rpttime", 0L);
    if (((str.length() >= i) || (bt.rM(l2) > 3600L)) && (paramdr.dYD % 2L == 0L))
    {
      localax.putLong(parama.name() + "_rpttime", bt.aQJ());
      localax.putString(parama.name(), "");
      com.tencent.mm.plugin.report.service.g.yhR.kvStat(16562, str);
      if (parama == b.a.quG) {
        afA(str);
      }
    }
    for (;;)
    {
      ad.v("MicroMsg.MMPageReporter", "handle merge cost[%d]", new Object[] { Long.valueOf(bt.aO(l1)) });
      AppMethodBeat.o(122391);
      return;
      localax.putString(parama.name(), str);
    }
  }
  
  private void afA(final String paramString)
  {
    AppMethodBeat.i(122393);
    com.tencent.mm.sdk.g.b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(122387);
        Object localObject1 = e.this;
        localObject2 = paramString;
        if (!bt.isNullOrNil((String)localObject2))
        {
          long l2 = bt.HI();
          Object localObject3 = ((String)localObject2).split("\\|");
          localObject2 = new ArrayList();
          j = localObject3.length;
          i = 0;
          Object localObject4;
          while (i < j)
          {
            localObject4 = localObject3[i];
            if (!bt.isNullOrNil((String)localObject4))
            {
              localObject4 = new dr(((String)localObject4).replace(';', ','));
              if ((((dr)localObject4).eez > 0L) && (((dr)localObject4).dYD > 0L)) {
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
                ad.printErrStackTrace("MicroMsg.MMPageReporter", localException1, "reportWeixinAppTime error", new Object[0]);
                continue;
                l1 = System.currentTimeMillis();
                ((com.tencent.mm.plugin.expt.d.d.a)localObject2).qPs.execute(new a.2((com.tencent.mm.plugin.expt.d.d.a)localObject2, l1, localException1));
                continue;
              }
              try
              {
                localObject4 = (dr)((List)localObject2).get(j);
                if (j + 1 < k) {
                  localObject1 = (dr)((List)localObject2).get(j + 1);
                }
                if ((localObject4 == null) || (localObject1 == null)) {
                  break label678;
                }
                if ((((dr)localObject4).dYD != 7L) || (((dr)localObject1).dYD != 8L) || (((dr)localObject4).eez >= ((dr)localObject1).eez) || (((dr)localObject4).dXl != ((dr)localObject1).dXl)) {
                  continue;
                }
                if (l1 <= 0L) {
                  break label681;
                }
                l1 = ((dr)localObject4).eez - l1;
              }
              catch (Exception localException2)
              {
                continue;
                continue;
                l1 = 0L;
                continue;
              }
              ((StringBuffer)localObject3).append(String.format("{\"tbe\":%d.\"ten\":%d.\"in\":%d.\"inbg\":%d}", new Object[] { Long.valueOf(((dr)localObject4).eez), Long.valueOf(((dr)localObject1).eez), Long.valueOf(((dr)localObject1).eez - ((dr)localObject4).eez), Long.valueOf(l1) })).append(";");
              l1 = ((dr)localObject1).eez;
              i += 1;
              j += 2;
              continue;
              if (((dr)localObject4).dYD != 8L) {
                break label678;
              }
              l1 = ((dr)localObject4).eez;
              j += 1;
            }
          }
          localObject3 = ((StringBuffer)localObject3).toString();
          if (!bt.isNullOrNil((String)localObject3))
          {
            localObject2 = ((String)localObject3).replace(".", ",").replace(";", ",");
            localObject1 = localObject2;
            if (org.apache.commons.b.g.equals(((String)localObject2).substring(((String)localObject2).length() - 1), ",")) {
              localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 1);
            }
            localObject1 = "[" + (String)localObject1 + "]";
            localObject2 = com.tencent.mm.plugin.expt.d.a.cng().qPn;
            if (com.tencent.mm.plugin.expt.d.b.cni())
            {
              if (org.apache.commons.b.g.ea((String)localObject1)) {
                ad.e("EdgeComputingDataSourceService", "[EdgeComputingDataSourceService] sendForeBack data isEmpty!");
              }
            }
            else
            {
              com.tencent.mm.plugin.report.service.g.yhR.f(16563, new Object[] { localObject3, Long.valueOf(bt.aO(l2)), Integer.valueOf(i) });
              ad.i("MicroMsg.MMPageReporter", "reportWeixinAppTime [%s]", new Object[] { localObject3 });
            }
          }
          else
          {
            ad.i("MicroMsg.MMPageReporter", "reportWeixinAppTime cost[%d] count[%d]", new Object[] { Long.valueOf(bt.aO(l2)), Integer.valueOf(i) });
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
  
  public static e crp()
  {
    AppMethodBeat.i(122389);
    if (raM == null) {
      raM = new e();
    }
    e locale = raM;
    AppMethodBeat.o(122389);
    return locale;
  }
  
  public final void a(dr paramdr)
  {
    AppMethodBeat.i(122390);
    if (paramdr == null)
    {
      AppMethodBeat.o(122390);
      return;
    }
    int i = (int)paramdr.dYD;
    if ((i == e.a.qPb.value) || (i == e.a.qPc.value))
    {
      a(b.a.quE, paramdr);
      if (a.crh()) {
        paramdr.aLk();
      }
    }
    if ((i == e.a.qPd.value) || (i == e.a.qPe.value))
    {
      a(b.a.quF, paramdr);
      if (a.cri()) {
        paramdr.aLk();
      }
    }
    if (((i == e.a.qPh.value) || (i == e.a.qPi.value)) && (com.tencent.mm.plugin.expt.hellhound.a.cnt()) && (com.tencent.mm.plugin.expt.hellhound.a.cnu()))
    {
      a(b.a.quG, paramdr);
      if (a.crj()) {
        paramdr.aLk();
      }
    }
    AppMethodBeat.o(122390);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.g.e
 * JD-Core Version:    0.7.0.1
 */