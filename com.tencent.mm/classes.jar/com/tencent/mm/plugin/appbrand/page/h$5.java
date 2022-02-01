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
import com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI;
import com.tencent.mm.sdk.platformtools.bt;

final class h$5
  implements Runnable
{
  h$5(h paramh, AppBrandInitConfigLU paramAppBrandInitConfigLU, com.tencent.luggage.sdk.b.a.c paramc, AppBrandSysConfigLU paramAppBrandSysConfigLU) {}
  
  public final void run()
  {
    AppMethodBeat.i(47786);
    String str1 = "";
    if (((com.tencent.luggage.sdk.d.c)h.a(this.kYe)).DZ().cfo != null) {
      str1 = this.kYi.Da();
    }
    new b().a(this.kkW.Dm(), b.a.jrq, 0);
    AppBrandOpReportLogic.a.e(this.kkW);
    WxaExposedParams.a locala = new WxaExposedParams.a();
    locala.appId = this.kYj.appId;
    locala.from = 3;
    if (this.kkW.kWU == null) {}
    for (String str2 = "";; str2 = this.kkW.jzm)
    {
      locala.pageId = str2;
      locala.iOQ = this.kYj.jdS.iOQ;
      locala.pkgVersion = this.kYj.jdS.pkgVersion;
      AppBrandProfileUI.a(this.kkW.getContext(), this.kYi.username, 3, str1, locala.aTV(), null, ActivityStarterIpcDelegate.ay(this.kkW.getContext()));
      com.tencent.mm.plugin.appbrand.report.h.a(this.kkW.getAppId(), this.kkW.jzm, 6, "", bt.aGK(), 1, 0);
      AppMethodBeat.o(47786);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.h.5
 * JD-Core Version:    0.7.0.1
 */