package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ui.w;

final class AppBrandRuntime$2
  implements Runnable
{
  AppBrandRuntime$2(AppBrandRuntime paramAppBrandRuntime, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(134443);
    if (AppBrandRuntime.j(this.jAl) != null) {
      AppBrandRuntime.j(this.jAl).setProgress(this.val$progress);
    }
    AppMethodBeat.o(134443);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.AppBrandRuntime.2
 * JD-Core Version:    0.7.0.1
 */