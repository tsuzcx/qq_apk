package com.tencent.mm.plugin.appbrand.page;

import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.k;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.widget.recentview.d.a;

final class ae$11
  implements d.a
{
  ae$11(ae paramae) {}
  
  public final LocalUsageInfo bkg()
  {
    AppMethodBeat.i(47877);
    if (!this.lbG.isRunning())
    {
      AppMethodBeat.o(47877);
      return null;
    }
    LocalUsageInfo localLocalUsageInfo = new LocalUsageInfo(this.lbG.getRuntime().aNc().username, this.lbG.getRuntime().aNb().appId, this.lbG.getRuntime().aNb().jdS.iOQ, this.lbG.getRuntime().aNb().jdS.pkgVersion, this.lbG.getRuntime().aNb().dfM, this.lbG.getRuntime().aNb().cfp, this.lbG.getRuntime().aNb().hGe, false, this.lbG.getRuntime().aNb().cfT, 0L);
    AppMethodBeat.o(47877);
    return localLocalUsageInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ae.11
 * JD-Core Version:    0.7.0.1
 */