package com.tencent.mm.plugin.expt.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.cy;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.expt.a.e.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class e
{
  private static e qrt;
  
  private static aw JW()
  {
    AppMethodBeat.i(122392);
    int i = com.tencent.mm.kernel.a.agb();
    if (i == 0)
    {
      AppMethodBeat.o(122392);
      return null;
    }
    aw localaw = aw.aKT(i + "_WxPageFlowMerge");
    AppMethodBeat.o(122392);
    return localaw;
  }
  
  private void a(b.a parama, cy paramcy)
  {
    AppMethodBeat.i(122391);
    if (!ai.ciE())
    {
      AppMethodBeat.o(122391);
      return;
    }
    long l1 = bs.Gn();
    int i = a.b(parama);
    if (i <= 0)
    {
      AppMethodBeat.o(122391);
      return;
    }
    aw localaw = JW();
    if (localaw == null)
    {
      AppMethodBeat.o(122391);
      return;
    }
    String str = localaw.getString(parama.name(), "");
    str = str + "|" + paramcy.la(";");
    long l2 = localaw.getLong(parama.name() + "_rpttime", 0L);
    if (((str.length() >= i) || (bs.pN(l2) > 3600L)) && (paramcy.dKB % 2L == 0L))
    {
      localaw.putLong(parama.name() + "_rpttime", bs.aNx());
      localaw.putString(parama.name(), "");
      h.wUl.kvStat(16562, str);
      if (parama == b.a.pQr) {
        abM(str);
      }
    }
    for (;;)
    {
      ac.v("MicroMsg.MMPageReporter", "handle merge cost[%d]", new Object[] { Long.valueOf(bs.aO(l1)) });
      AppMethodBeat.o(122391);
      return;
      localaw.putString(parama.name(), str);
    }
  }
  
  private void abM(final String paramString)
  {
    AppMethodBeat.i(122393);
    b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(122387);
        Object localObject1 = e.this;
        Object localObject2 = paramString;
        if (!bs.isNullOrNil((String)localObject2))
        {
          long l2 = bs.Gn();
          Object localObject3 = ((String)localObject2).split("\\|");
          localObject2 = new ArrayList();
          j = localObject3.length;
          i = 0;
          Object localObject4;
          while (i < j)
          {
            localObject4 = localObject3[i];
            if (!bs.isNullOrNil((String)localObject4))
            {
              localObject4 = new cy(((String)localObject4).replace(';', ','));
              if ((((cy)localObject4).dPk > 0L) && (((cy)localObject4).dKB > 0L)) {
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
                ac.printErrStackTrace("MicroMsg.MMPageReporter", localException1, "reportWeixinAppTime error", new Object[0]);
                continue;
              }
              try
              {
                localObject4 = (cy)((List)localObject2).get(j);
                if (j + 1 < k) {
                  localObject1 = (cy)((List)localObject2).get(j + 1);
                }
                if ((localObject4 == null) || (localObject1 == null)) {
                  break label539;
                }
                if ((((cy)localObject4).dKB != 7L) || (((cy)localObject1).dKB != 8L) || (((cy)localObject4).dPk >= ((cy)localObject1).dPk) || (((cy)localObject4).dJu != ((cy)localObject1).dJu)) {
                  continue;
                }
                if (l1 <= 0L) {
                  break label542;
                }
                l1 = ((cy)localObject4).dPk - l1;
              }
              catch (Exception localException2)
              {
                continue;
                continue;
                l1 = 0L;
                continue;
              }
              ((StringBuffer)localObject3).append(String.format("{\"tbe\":%d.\"ten\":%d.\"in\":%d.\"inbg\":%d}", new Object[] { Long.valueOf(((cy)localObject4).dPk), Long.valueOf(((cy)localObject1).dPk), Long.valueOf(((cy)localObject1).dPk - ((cy)localObject4).dPk), Long.valueOf(l1) })).append(";");
              l1 = ((cy)localObject1).dPk;
              i += 1;
              j += 2;
              continue;
              if (((cy)localObject4).dKB != 8L) {
                break label539;
              }
              l1 = ((cy)localObject4).dPk;
              j += 1;
            }
          }
          localObject1 = ((StringBuffer)localObject3).toString();
          if (!bs.isNullOrNil((String)localObject1))
          {
            h.wUl.f(16563, new Object[] { localObject1, Long.valueOf(bs.aO(l2)), Integer.valueOf(i) });
            ac.i("MicroMsg.MMPageReporter", "reportWeixinAppTime [%s]", new Object[] { localObject1 });
          }
          ac.i("MicroMsg.MMPageReporter", "reportWeixinAppTime cost[%d] count[%d]", new Object[] { Long.valueOf(bs.aO(l2)), Integer.valueOf(i) });
        }
        AppMethodBeat.o(122387);
      }
    }, "report_weixin_app_time");
    AppMethodBeat.o(122393);
  }
  
  public static e clS()
  {
    AppMethodBeat.i(122389);
    if (qrt == null) {
      qrt = new e();
    }
    e locale = qrt;
    AppMethodBeat.o(122389);
    return locale;
  }
  
  public final void a(cy paramcy)
  {
    AppMethodBeat.i(122390);
    if (paramcy == null)
    {
      AppMethodBeat.o(122390);
      return;
    }
    int i = (int)paramcy.dKB;
    if ((i == e.a.qio.value) || (i == e.a.qip.value))
    {
      a(b.a.pQp, paramcy);
      if (a.clK()) {
        paramcy.aHZ();
      }
    }
    if ((i == e.a.qiq.value) || (i == e.a.qir.value))
    {
      a(b.a.pQq, paramcy);
      if (a.clL()) {
        paramcy.aHZ();
      }
    }
    if (((i == e.a.qiu.value) || (i == e.a.qiv.value)) && (com.tencent.mm.plugin.expt.hellhound.a.ciw()) && (com.tencent.mm.plugin.expt.hellhound.a.cix()))
    {
      a(b.a.pQr, paramcy);
      if (a.clM()) {
        paramcy.aHZ();
      }
    }
    AppMethodBeat.o(122390);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.d.e
 * JD-Core Version:    0.7.0.1
 */