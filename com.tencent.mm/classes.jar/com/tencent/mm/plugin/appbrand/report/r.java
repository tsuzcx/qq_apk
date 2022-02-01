package com.tencent.mm.plugin.appbrand.report;

import com.tencent.luggage.sdk.config.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/report/PVReportIDFactory;", "Lcom/tencent/luggage/sdk/config/MPInstanceIdFactory;", "Lcom/tencent/luggage/sdk/config/MPSessionIdFactory;", "()V", "createInstanceId", "", "createSessionId", "getUINString", "init", "", "plugin-appbrand-integration_release"})
public final class r
  implements c, com.tencent.luggage.sdk.config.d
{
  public static final r nHM;
  
  static
  {
    AppMethodBeat.i(229306);
    nHM = new r();
    AppMethodBeat.o(229306);
  }
  
  public static final void init()
  {
    com.tencent.luggage.sdk.config.d.a.czj = (com.tencent.luggage.sdk.config.d)nHM;
    com.tencent.luggage.sdk.config.c.a.czh = (c)nHM;
  }
  
  public final String NI()
  {
    AppMethodBeat.i(229304);
    StringBuilder localStringBuilder = new StringBuilder("hash=");
    String str;
    if (MMApplicationContext.isMainProcess())
    {
      kotlin.g.b.p.g(com.tencent.mm.kernel.g.aAf(), "MMKernel.account()");
      str = a.ayV();
      kotlin.g.b.p.g(str, "MMKernel.account().uinString");
    }
    for (;;)
    {
      str = org.apache.commons.b.g.a(new String[] { str, "ts=" + Util.nowMilliSecond(), "host=", "version=" + com.tencent.mm.protocal.d.KyO, "device=2" }, "&");
      kotlin.g.b.p.g(str, "StringUtils.join(arrayOf…2-android\n        ), \"&\")");
      AppMethodBeat.o(229304);
      return str;
      str = com.tencent.mm.b.p.getString(a.ayW());
      kotlin.g.b.p.g(str, "UIN.getString(CoreAccoun…dOnlyUinInOtherProcess())");
    }
  }
  
  public final String NJ()
  {
    AppMethodBeat.i(229305);
    String str = NI();
    AppMethodBeat.o(229305);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.r
 * JD-Core Version:    0.7.0.1
 */