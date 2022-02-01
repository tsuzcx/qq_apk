package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class AppBrandRuntime$8
  implements Runnable
{
  AppBrandRuntime$8(AppBrandRuntime paramAppBrandRuntime) {}
  
  public final void run()
  {
    AppMethodBeat.i(134450);
    if (AppBrandRuntime.t(this.iEc) == null)
    {
      this.iEc.dispatchDestroy();
      AppMethodBeat.o(134450);
      return;
    }
    AppBrandRuntime.t(this.iEc).B(this.iEc);
    AppMethodBeat.o(134450);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.AppBrandRuntime.8
 * JD-Core Version:    0.7.0.1
 */