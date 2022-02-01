package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s.a.e.a;
import com.tencent.mm.plugin.appbrand.s.a.e.b;
import com.tencent.mm.sdk.platformtools.ad;

final class AppBrandRuntime$18
  implements e.a
{
  AppBrandRuntime$18(AppBrandRuntime paramAppBrandRuntime) {}
  
  public final void a(e.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(176499);
    ad.i("MicroMsg.AppBrandRuntime", "tryResetPageOrientationAndHideSplash, onOrientationChanged, orientation:%s, success:%s", new Object[] { paramb, Boolean.valueOf(paramBoolean) });
    AppBrandRuntime.y(this.iEc);
    AppMethodBeat.o(176499);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.AppBrandRuntime.18
 * JD-Core Version:    0.7.0.1
 */