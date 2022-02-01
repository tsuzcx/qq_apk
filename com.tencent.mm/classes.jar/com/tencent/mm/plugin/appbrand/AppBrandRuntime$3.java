package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class AppBrandRuntime$3
  implements Runnable
{
  AppBrandRuntime$3(AppBrandRuntime paramAppBrandRuntime) {}
  
  public final void run()
  {
    AppMethodBeat.i(134444);
    if (this.jxm.isDestroyed())
    {
      AppMethodBeat.o(134444);
      return;
    }
    AppBrandRuntime.k(this.jxm);
    AppBrandRuntime.l(this.jxm);
    AppBrandRuntime.m(this.jxm);
    AppBrandRuntime.n(this.jxm);
    AppMethodBeat.o(134444);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.AppBrandRuntime.3
 * JD-Core Version:    0.7.0.1
 */