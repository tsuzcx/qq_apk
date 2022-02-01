package com.tencent.mm.plugin.appbrand.report;

import com.tencent.luggage.sdk.config.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.l;
import org.apache.commons.b.g;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/report/PVReportIDFactory;", "Lcom/tencent/luggage/sdk/config/MPInstanceIdFactory;", "Lcom/tencent/luggage/sdk/config/MPSessionIdFactory;", "()V", "createInstanceId", "", "createSessionId", "getUINString", "init", "", "plugin-appbrand-integration_release"})
public final class s
  implements c, com.tencent.luggage.sdk.config.d
{
  public static final s qJY;
  
  static
  {
    AppMethodBeat.i(270892);
    qJY = new s();
    AppMethodBeat.o(270892);
  }
  
  public static final void init()
  {
    com.tencent.luggage.sdk.config.d.a.cxV = (com.tencent.luggage.sdk.config.d)qJY;
    com.tencent.luggage.sdk.config.c.a.cxT = (c)qJY;
  }
  
  public final String QD()
  {
    AppMethodBeat.i(270889);
    StringBuilder localStringBuilder = new StringBuilder("hash=");
    String str;
    if (MMApplicationContext.isMainProcess())
    {
      kotlin.g.b.p.j(h.aHE(), "MMKernel.account()");
      str = b.aGq();
      kotlin.g.b.p.j(str, "MMKernel.account().uinString");
    }
    for (;;)
    {
      str = g.a(new String[] { str, "ts=" + Util.nowMilliSecond(), "host=", "version=" + com.tencent.mm.protocal.d.RAD, "device=2" }, "&");
      kotlin.g.b.p.j(str, "StringUtils.join(arrayOf…2-android\n        ), \"&\")");
      AppMethodBeat.o(270889);
      return str;
      str = com.tencent.mm.b.p.getString(b.aGr());
      kotlin.g.b.p.j(str, "UIN.getString(CoreAccoun…dOnlyUinInOtherProcess())");
    }
  }
  
  public final String QE()
  {
    AppMethodBeat.i(270890);
    String str = QD();
    AppMethodBeat.o(270890);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.s
 * JD-Core Version:    0.7.0.1
 */