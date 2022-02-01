package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ui.v;

final class AppBrandRuntime$3
  implements Runnable
{
  AppBrandRuntime$3(AppBrandRuntime paramAppBrandRuntime, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(134444);
    if (AppBrandRuntime.j(this.iEc) != null) {
      AppBrandRuntime.j(this.iEc).setProgress(this.val$progress);
    }
    AppMethodBeat.o(134444);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.AppBrandRuntime.3
 * JD-Core Version:    0.7.0.1
 */