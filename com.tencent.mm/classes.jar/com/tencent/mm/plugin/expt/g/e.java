package com.tencent.mm.plugin.expt.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.dt;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.expt.b.e.a;
import com.tencent.mm.plugin.expt.d.d.a.2;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

public final class e
{
  private static e riS;
  
  private static ay LD()
  {
    AppMethodBeat.i(122392);
    int i = com.tencent.mm.kernel.a.ajc();
    if (i == 0)
    {
      AppMethodBeat.o(122392);
      return null;
    }
    ay localay = ay.aRW(i + "_WxPageFlowMerge");
    AppMethodBeat.o(122392);
    return localay;
  }
  
  private void a(b.a parama, dt paramdt)
  {
    AppMethodBeat.i(122391);
    if (!ak.cpe())
    {
      AppMethodBeat.o(122391);
      return;
    }
    long l1 = bu.HQ();
    int i = a.b(parama);
    if (i <= 0)
    {
      AppMethodBeat.o(122391);
      return;
    }
    ay localay = LD();
    if (localay == null)
    {
      AppMethodBeat.o(122391);
      return;
    }
    String str = localay.getString(parama.name(), "");
    str = str + "|" + paramdt.ny(";");
    long l2 = localay.getLong(parama.name() + "_rpttime", 0L);
    if (((str.length() >= i) || (bu.rZ(l2) > 3600L)) && (paramdt.dZW % 2L == 0L))
    {
      localay.putLong(parama.name() + "_rpttime", bu.aRi());
      localay.putString(parama.name(), "");
      com.tencent.mm.plugin.report.service.g.yxI.kvStat(16562, str);
      if (parama == b.a.qBz) {
        agw(str);
      }
    }
    for (;;)
    {
      ae.v("MicroMsg.MMPageReporter", "handle merge cost[%d]", new Object[] { Long.valueOf(bu.aO(l1)) });
      AppMethodBeat.o(122391);
      return;
      localay.putString(parama.name(), str);
    }
  }
  
  private void agw(final String paramString)
  {
    AppMethodBeat.i(122393);
    com.tencent.mm.sdk.g.b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(122387);
        Object localObject1 = e.this;
        localObject2 = paramString;
        if (!bu.isNullOrNil((String)localObject2))
        {
          long l2 = bu.HQ();
          Object localObject3 = ((String)localObject2).split("\\|");
          localObject2 = new ArrayList();
          j = localObject3.length;
          i = 0;
          Object localObject4;
          while (i < j)
          {
            localObject4 = localObject3[i];
            if (!bu.isNullOrNil((String)localObject4))
            {
              localObject4 = new dt(((String)localObject4).replace(';', ','));
              if ((((dt)localObject4).efZ > 0L) && (((dt)localObject4).dZW > 0L)) {
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
                ae.printErrStackTrace("MicroMsg.MMPageReporter", localException1, "reportWeixinAppTime error", new Object[0]);
                continue;
                l1 = System.currentTimeMillis();
                ((com.tencent.mm.plugin.expt.d.d.a)localObject2).qXo.execute(new a.2((com.tencent.mm.plugin.expt.d.d.a)localObject2, l1, localException1));
                continue;
              }
              try
              {
                localObject4 = (dt)((List)localObject2).get(j);
                if (j + 1 < k) {
                  localObject1 = (dt)((List)localObject2).get(j + 1);
                }
                if ((localObject4 == null) || (localObject1 == null)) {
                  break label678;
                }
                if ((((dt)localObject4).dZW != 7L) || (((dt)localObject1).dZW != 8L) || (((dt)localObject4).efZ >= ((dt)localObject1).efZ) || (((dt)localObject4).dYC != ((dt)localObject1).dYC)) {
                  continue;
                }
                if (l1 <= 0L) {
                  break label681;
                }
                l1 = ((dt)localObject4).efZ - l1;
              }
              catch (Exception localException2)
              {
                continue;
                continue;
                l1 = 0L;
                continue;
              }
              ((StringBuffer)localObject3).append(String.format("{\"tbe\":%d.\"ten\":%d.\"in\":%d.\"inbg\":%d}", new Object[] { Long.valueOf(((dt)localObject4).efZ), Long.valueOf(((dt)localObject1).efZ), Long.valueOf(((dt)localObject1).efZ - ((dt)localObject4).efZ), Long.valueOf(l1) })).append(";");
              l1 = ((dt)localObject1).efZ;
              i += 1;
              j += 2;
              continue;
              if (((dt)localObject4).dZW != 8L) {
                break label678;
              }
              l1 = ((dt)localObject4).efZ;
              j += 1;
            }
          }
          localObject3 = ((StringBuffer)localObject3).toString();
          if (!bu.isNullOrNil((String)localObject3))
          {
            localObject2 = ((String)localObject3).replace(".", ",").replace(";", ",");
            localObject1 = localObject2;
            if (org.apache.commons.b.g.equals(((String)localObject2).substring(((String)localObject2).length() - 1), ",")) {
              localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 1);
            }
            localObject1 = "[" + (String)localObject1 + "]";
            localObject2 = com.tencent.mm.plugin.expt.d.a.cow().qXi;
            if (com.tencent.mm.plugin.expt.d.b.coz())
            {
              if (org.apache.commons.b.g.ef((String)localObject1)) {
                ae.e("EdgeComputingDataSourceService", "[EdgeComputingDataSourceService] sendForeBack data isEmpty!");
              }
            }
            else
            {
              com.tencent.mm.plugin.report.service.g.yxI.f(16563, new Object[] { localObject3, Long.valueOf(bu.aO(l2)), Integer.valueOf(i) });
              ae.i("MicroMsg.MMPageReporter", "reportWeixinAppTime [%s]", new Object[] { localObject3 });
            }
          }
          else
          {
            ae.i("MicroMsg.MMPageReporter", "reportWeixinAppTime cost[%d] count[%d]", new Object[] { Long.valueOf(bu.aO(l2)), Integer.valueOf(i) });
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
  
  public static e csR()
  {
    AppMethodBeat.i(122389);
    if (riS == null) {
      riS = new e();
    }
    e locale = riS;
    AppMethodBeat.o(122389);
    return locale;
  }
  
  public final void a(dt paramdt)
  {
    AppMethodBeat.i(122390);
    if (paramdt == null)
    {
      AppMethodBeat.o(122390);
      return;
    }
    int i = (int)paramdt.dZW;
    if ((i == e.a.qWW.value) || (i == e.a.qWX.value))
    {
      a(b.a.qBx, paramdt);
      if (a.csJ()) {
        paramdt.aLH();
      }
    }
    if ((i == e.a.qWY.value) || (i == e.a.qWZ.value))
    {
      a(b.a.qBy, paramdt);
      if (a.csK()) {
        paramdt.aLH();
      }
    }
    if (((i == e.a.qXc.value) || (i == e.a.qXd.value)) && (com.tencent.mm.plugin.expt.hellhound.a.coV()) && (com.tencent.mm.plugin.expt.hellhound.a.coW()))
    {
      a(b.a.qBz, paramdt);
      if (a.csL()) {
        paramdt.aLH();
      }
    }
    AppMethodBeat.o(122390);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.g.e
 * JD-Core Version:    0.7.0.1
 */