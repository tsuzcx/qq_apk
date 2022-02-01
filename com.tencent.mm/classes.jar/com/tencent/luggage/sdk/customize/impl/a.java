package com.tencent.luggage.sdk.customize.impl;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.ui.aa;

public final class a
  implements aa
{
  public final void a(Activity paramActivity, AppBrandInitConfig paramAppBrandInitConfig) {}
  
  public final void a(AppBrandRuntime paramAppBrandRuntime1, AppBrandRuntime paramAppBrandRuntime2) {}
  
  public final void a(AppBrandRuntime paramAppBrandRuntime1, AppBrandRuntime paramAppBrandRuntime2, Runnable paramRunnable)
  {
    AppMethodBeat.i(139819);
    if (paramRunnable != null) {
      paramRunnable.run();
    }
    AppMethodBeat.o(139819);
  }
  
  public final void m(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.sdk.customize.impl.a
 * JD-Core Version:    0.7.0.1
 */