package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.keylogger.c;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;

final class AppBrandRuntime$5
  implements Runnable
{
  AppBrandRuntime$5(AppBrandRuntime paramAppBrandRuntime) {}
  
  public final void run()
  {
    AppMethodBeat.i(134447);
    c.a(this.jAl.mAppId, KSProcessWeAppLaunch.stepServiceInit);
    AppBrandRuntime.r(this.jAl).init();
    AppMethodBeat.o(134447);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.AppBrandRuntime.5
 * JD-Core Version:    0.7.0.1
 */