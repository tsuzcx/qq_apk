package com.tencent.luggage.sdk.customize.impl;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.ui.s;

public final class a
  implements s
{
  public final void a(Activity paramActivity, AppBrandInitConfig paramAppBrandInitConfig) {}
  
  public final void a(i parami1, i parami2) {}
  
  public final void a(i parami1, i parami2, Runnable paramRunnable)
  {
    AppMethodBeat.i(140096);
    paramRunnable.run();
    AppMethodBeat.o(140096);
  }
  
  public final void j(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.luggage.sdk.customize.impl.a
 * JD-Core Version:    0.7.0.1
 */