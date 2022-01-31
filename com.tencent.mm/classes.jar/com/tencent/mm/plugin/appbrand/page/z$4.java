package com.tencent.mm.plugin.appbrand.page;

import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.h;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.widget.recentview.d.a;

final class z$4
  implements d.a
{
  z$4(z paramz) {}
  
  public final LocalUsageInfo aJB()
  {
    AppMethodBeat.i(143497);
    if (!this.ixG.isRunning())
    {
      AppMethodBeat.o(143497);
      return null;
    }
    LocalUsageInfo localLocalUsageInfo = new LocalUsageInfo(this.ixG.getRuntime().atS().username, this.ixG.getRuntime().atR().appId, this.ixG.getRuntime().atR().hiX.gXe, this.ixG.getRuntime().atR().hiX.gXf, this.ixG.getRuntime().atR().cqQ, this.ixG.getRuntime().atR().bDi, this.ixG.getRuntime().atR().hiQ, false, this.ixG.getRuntime().atR().bDL, 0L);
    AppMethodBeat.o(143497);
    return localLocalUsageInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.z.4
 * JD-Core Version:    0.7.0.1
 */