package com.tencent.mm.plugin.expt.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.bk;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.expt.a.e.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class e
{
  private static e pIM;
  
  private static ax Km()
  {
    AppMethodBeat.i(122392);
    int i = com.tencent.mm.kernel.a.aeL();
    if (i == 0)
    {
      AppMethodBeat.o(122392);
      return null;
    }
    ax localax = ax.aFC(i + "_WxPageFlowMerge");
    AppMethodBeat.o(122392);
    return localax;
  }
  
  private void Xp(final String paramString)
  {
    AppMethodBeat.i(122393);
    b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(122387);
        Object localObject1 = e.this;
        Object localObject2 = paramString;
        if (!bt.isNullOrNil((String)localObject2))
        {
          long l2 = bt.GC();
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
              localObject4 = new bk(((String)localObject4).replace(';', ','));
              if ((((bk)localObject4).dNJ > 0L) && (((bk)localObject4).dNI > 0L)) {
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
              }
              try
              {
                localObject4 = (bk)((List)localObject2).get(j);
                if (j + 1 < k) {
                  localObject1 = (bk)((List)localObject2).get(j + 1);
                }
                if ((localObject4 == null) || (localObject1 == null)) {
                  break label539;
                }
                if ((((bk)localObject4).dNI != 7L) || (((bk)localObject1).dNI != 8L) || (((bk)localObject4).dNJ >= ((bk)localObject1).dNJ) || (((bk)localObject4).dKu != ((bk)localObject1).dKu)) {
                  continue;
                }
                if (l1 <= 0L) {
                  break label542;
                }
                l1 = ((bk)localObject4).dNJ - l1;
              }
              catch (Exception localException2)
              {
                continue;
                continue;
                l1 = 0L;
                continue;
              }
              ((StringBuffer)localObject3).append(String.format("{\"tbe\":%d.\"ten\":%d.\"in\":%d.\"inbg\":%d}", new Object[] { Long.valueOf(((bk)localObject4).dNJ), Long.valueOf(((bk)localObject1).dNJ), Long.valueOf(((bk)localObject1).dNJ - ((bk)localObject4).dNJ), Long.valueOf(l1) })).append(";");
              l1 = ((bk)localObject1).dNJ;
              i += 1;
              j += 2;
              continue;
              if (((bk)localObject4).dNI != 8L) {
                break label539;
              }
              l1 = ((bk)localObject4).dNJ;
              j += 1;
            }
          }
          localObject1 = ((StringBuffer)localObject3).toString();
          if (!bt.isNullOrNil((String)localObject1))
          {
            h.vKh.f(16563, new Object[] { localObject1, Long.valueOf(bt.aS(l2)), Integer.valueOf(i) });
            ad.i("MicroMsg.MMPageReporter", "reportWeixinAppTime [%s]", new Object[] { localObject1 });
          }
          ad.i("MicroMsg.MMPageReporter", "reportWeixinAppTime cost[%d] count[%d]", new Object[] { Long.valueOf(bt.aS(l2)), Integer.valueOf(i) });
        }
        AppMethodBeat.o(122387);
      }
    }, "report_weixin_app_time");
    AppMethodBeat.o(122393);
  }
  
  private void a(b.a parama, bk parambk)
  {
    AppMethodBeat.i(122391);
    if (!aj.cbv())
    {
      AppMethodBeat.o(122391);
      return;
    }
    long l1 = bt.GC();
    int i = a.b(parama);
    if (i <= 0)
    {
      AppMethodBeat.o(122391);
      return;
    }
    ax localax = Km();
    if (localax == null)
    {
      AppMethodBeat.o(122391);
      return;
    }
    String str = localax.getString(parama.name(), "");
    str = str + "|" + parambk.il(";");
    long l2 = localax.getLong(parama.name() + "_rpttime", 0L);
    if (((str.length() >= i) || (bt.lZ(l2) > 3600L)) && (parambk.dNI % 2L == 0L))
    {
      localax.putLong(parama.name() + "_rpttime", bt.aGK());
      localax.putString(parama.name(), "");
      h.vKh.kvStat(16562, str);
      if (parama == b.a.pmR) {
        Xp(str);
      }
    }
    for (;;)
    {
      ad.v("MicroMsg.MMPageReporter", "handle merge cost[%d]", new Object[] { Long.valueOf(bt.aS(l1)) });
      AppMethodBeat.o(122391);
      return;
      localax.putString(parama.name(), str);
    }
  }
  
  public static e cel()
  {
    AppMethodBeat.i(122389);
    if (pIM == null) {
      pIM = new e();
    }
    e locale = pIM;
    AppMethodBeat.o(122389);
    return locale;
  }
  
  public final void a(bk parambk)
  {
    AppMethodBeat.i(122390);
    if (parambk == null)
    {
      AppMethodBeat.o(122390);
      return;
    }
    int i = (int)parambk.dNI;
    if ((i == e.a.pDB.value) || (i == e.a.pDC.value))
    {
      a(b.a.pmP, parambk);
      if (a.ced()) {
        parambk.aBj();
      }
    }
    if ((i == e.a.pDD.value) || (i == e.a.pDE.value))
    {
      a(b.a.pmQ, parambk);
      if (a.cee()) {
        parambk.aBj();
      }
    }
    if (((i == e.a.pDH.value) || (i == e.a.pDI.value)) && (com.tencent.mm.plugin.expt.hellhound.a.cbn()) && (com.tencent.mm.plugin.expt.hellhound.a.cbo()))
    {
      a(b.a.pmR, parambk);
      if (a.cef()) {
        parambk.aBj();
      }
    }
    AppMethodBeat.o(122390);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.d.e
 * JD-Core Version:    0.7.0.1
 */