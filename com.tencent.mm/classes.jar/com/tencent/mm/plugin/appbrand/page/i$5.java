package com.tencent.mm.plugin.appbrand.page;

import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.luggage.sdk.launching.ActivityStarterIpcDelegate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.plugin.appbrand.game.e.b.b;
import com.tencent.mm.plugin.appbrand.game.e.b.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.op_report.AppBrandOpReportLogic.a;
import com.tencent.mm.plugin.appbrand.report.h;
import com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI;
import com.tencent.mm.sdk.platformtools.bt;

final class i$5
  implements Runnable
{
  i$5(i parami, AppBrandInitConfigLU paramAppBrandInitConfigLU, com.tencent.luggage.sdk.b.a.c paramc, AppBrandSysConfigLU paramAppBrandSysConfigLU) {}
  
  public final void run()
  {
    AppMethodBeat.i(47786);
    String str1 = "";
    if (((com.tencent.luggage.sdk.d.c)i.a(this.lZm)).Fb().cmC != null) {
      str1 = this.lZq.Ec();
    }
    new b().a(this.liR.Eo(), b.a.klW, 0);
    AppBrandOpReportLogic.a.d(this.liR);
    WxaExposedParams.a locala = new WxaExposedParams.a();
    locala.appId = this.lZr.appId;
    locala.from = 3;
    if (this.liR.lYc == null) {}
    for (String str2 = "";; str2 = this.liR.kuf)
    {
      locala.pageId = str2;
      locala.jIU = this.lZr.jYh.jIU;
      locala.pkgVersion = this.lZr.jYh.pkgVersion;
      AppBrandProfileUI.a(this.liR.getContext(), this.lZq.username, 3, str1, locala.bet(), null, ActivityStarterIpcDelegate.az(this.liR.getContext()));
      h.a(this.liR.getAppId(), this.liR.kuf, 6, "", bt.aQJ(), 1, 0);
      AppMethodBeat.o(47786);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.i.5
 * JD-Core Version:    0.7.0.1
 */