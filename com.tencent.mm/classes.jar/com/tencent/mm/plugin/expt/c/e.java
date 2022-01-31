package com.tencent.mm.plugin.expt.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.y;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.plugin.expt.a.c.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bo;

public final class e
{
  private static e mcp;
  
  private void MW(String paramString)
  {
    AppMethodBeat.i(73559);
    d.post(new e.1(this, paramString), "report_weixin_app_time");
    AppMethodBeat.o(73559);
  }
  
  private void a(a.a parama, y paramy)
  {
    AppMethodBeat.i(73557);
    if (!ah.brt())
    {
      AppMethodBeat.o(73557);
      return;
    }
    long l1 = bo.yB();
    int i = a.c(parama);
    if (i <= 0)
    {
      AppMethodBeat.o(73557);
      return;
    }
    as localas = aND();
    if (localas == null)
    {
      AppMethodBeat.o(73557);
      return;
    }
    String str = localas.getString(parama.name(), "");
    str = str + "|" + paramy.fw(";");
    long l2 = localas.getLong(parama.name() + "_rpttime", 0L);
    if (((str.length() >= i) || (bo.gz(l2) > 3600L)) && (paramy.cSH % 2L == 0L))
    {
      localas.putLong(parama.name() + "_rpttime", bo.aox());
      localas.putString(parama.name(), "");
      h.qsU.kvStat(16562, str);
      if (parama == a.a.lUB) {
        MW(str);
      }
    }
    for (;;)
    {
      ab.v("MicroMsg.MMPageReporter", "handle merge cost[%d]", new Object[] { Long.valueOf(bo.av(l1)) });
      AppMethodBeat.o(73557);
      return;
      localas.putString(parama.name(), str);
    }
  }
  
  private static as aND()
  {
    AppMethodBeat.i(73558);
    int i = com.tencent.mm.kernel.a.QW();
    if (i == 0)
    {
      AppMethodBeat.o(73558);
      return null;
    }
    as localas = as.apq(i + "_WxPageFlowMerge");
    AppMethodBeat.o(73558);
    return localas;
  }
  
  public static e bsT()
  {
    AppMethodBeat.i(73555);
    if (mcp == null) {
      mcp = new e();
    }
    e locale = mcp;
    AppMethodBeat.o(73555);
    return locale;
  }
  
  public final void a(y paramy)
  {
    AppMethodBeat.i(73556);
    if (paramy == null)
    {
      AppMethodBeat.o(73556);
      return;
    }
    int i = (int)paramy.cSH;
    if ((i == c.a.lZn.value) || (i == c.a.lZo.value))
    {
      a(a.a.lUz, paramy);
      if (a.bsL()) {
        paramy.ake();
      }
    }
    if ((i == c.a.lZp.value) || (i == c.a.lZq.value))
    {
      a(a.a.lUA, paramy);
      if (a.bsM()) {
        paramy.ake();
      }
    }
    if (((i == c.a.lZt.value) || (i == c.a.lZu.value)) && (com.tencent.mm.plugin.expt.hellhound.a.brn()) && (com.tencent.mm.plugin.expt.hellhound.a.bro()))
    {
      a(a.a.lUB, paramy);
      if (a.bsN()) {
        paramy.ake();
      }
    }
    AppMethodBeat.o(73556);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.c.e
 * JD-Core Version:    0.7.0.1
 */