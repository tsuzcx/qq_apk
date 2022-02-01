package com.tencent.luggage.sdk.customize.impl;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.ui.ah;

public final class d
  implements ah
{
  public final void a(Activity paramActivity, AppBrandInitConfig paramAppBrandInitConfig) {}
  
  public final void a(AppBrandRuntime paramAppBrandRuntime1, AppBrandRuntime paramAppBrandRuntime2, Runnable paramRunnable)
  {
    AppMethodBeat.i(139819);
    paramRunnable.run();
    AppMethodBeat.o(139819);
  }
  
  public final void a(AppBrandRuntime paramAppBrandRuntime1, Runnable paramRunnable, AppBrandRuntime paramAppBrandRuntime2)
  {
    AppMethodBeat.i(199266);
    paramRunnable.run();
    AppMethodBeat.o(199266);
  }
  
  public final void k(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.sdk.customize.impl.d
 * JD-Core Version:    0.7.0.1
 */