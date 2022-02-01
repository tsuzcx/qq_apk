package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class AppBrandRuntime$9
  implements Runnable
{
  AppBrandRuntime$9(AppBrandRuntime paramAppBrandRuntime, Object paramObject) {}
  
  public final void run()
  {
    AppMethodBeat.i(176493);
    if ((!this.iEc.mInitialized) || (this.iEc.isDestroyed()))
    {
      if (AppBrandRuntime.t(this.iEc) == null)
      {
        this.iEc.dispatchDestroy();
        AppMethodBeat.o(176493);
        return;
      }
      AppBrandRuntime.t(this.iEc).B(this.iEc);
      AppMethodBeat.o(176493);
      return;
    }
    if (AppBrandRuntime.t(this.iEc) == null)
    {
      this.iEc.dispatchPause();
      AppMethodBeat.o(176493);
      return;
    }
    AppBrandRuntime.t(this.iEc).a(this.iEc, this.KO);
    AppMethodBeat.o(176493);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.AppBrandRuntime.9
 * JD-Core Version:    0.7.0.1
 */