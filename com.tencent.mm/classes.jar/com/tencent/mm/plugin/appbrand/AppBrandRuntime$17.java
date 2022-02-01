package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ui.v;
import com.tencent.mm.sdk.platformtools.ad;

final class AppBrandRuntime$17
  implements Runnable
{
  AppBrandRuntime$17(AppBrandRuntime paramAppBrandRuntime, long paramLong) {}
  
  public final void run()
  {
    AppMethodBeat.i(176498);
    if (this.iEc.isDestroyed())
    {
      ad.i("MicroMsg.AppBrandRuntime", "hideSplashInternal, finished appId:%s", new Object[] { this.iEc.mAppId });
      AppBrandRuntime.x(this.iEc);
      AppMethodBeat.o(176498);
      return;
    }
    if (AppBrandRuntime.j(this.iEc) != null)
    {
      ad.i("MicroMsg.AppBrandRuntime", "hideSplashInternal, delayTime:%s", new Object[] { Long.valueOf(this.iEn) });
      AppBrandRuntime.j(this.iEc).bhu();
      AppBrandRuntime.x(this.iEc);
    }
    AppMethodBeat.o(176498);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.AppBrandRuntime.17
 * JD-Core Version:    0.7.0.1
 */