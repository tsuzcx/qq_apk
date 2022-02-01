package com.tencent.luggage.sdk.customize.impl;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.ui.ah;

public final class a
  implements ah
{
  public final void a(Activity paramActivity, AppBrandInitConfig paramAppBrandInitConfig) {}
  
  public final void a(AppBrandRuntime paramAppBrandRuntime1, AppBrandRuntime paramAppBrandRuntime2, Runnable paramRunnable)
  {
    AppMethodBeat.i(139819);
    if (paramRunnable != null) {
      paramRunnable.run();
    }
    AppMethodBeat.o(139819);
  }
  
  public final void a(AppBrandRuntime paramAppBrandRuntime1, Runnable paramRunnable, AppBrandRuntime paramAppBrandRuntime2)
  {
    AppMethodBeat.i(230538);
    paramRunnable.run();
    AppMethodBeat.o(230538);
  }
  
  public final void m(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.sdk.customize.impl.a
 * JD-Core Version:    0.7.0.1
 */