package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class AppBrandRuntime$8
  implements Runnable
{
  AppBrandRuntime$8(AppBrandRuntime paramAppBrandRuntime, Object paramObject) {}
  
  public final void run()
  {
    AppMethodBeat.i(134450);
    if ((!this.jxm.mInitialized) || (this.jxm.isDestroyed()))
    {
      if (AppBrandRuntime.t(this.jxm) == null)
      {
        this.jxm.dispatchDestroy();
        AppMethodBeat.o(134450);
        return;
      }
      AppBrandRuntime.t(this.jxm).y(this.jxm);
      AppMethodBeat.o(134450);
      return;
    }
    if (AppBrandRuntime.t(this.jxm) == null)
    {
      this.jxm.dispatchPause();
      AppMethodBeat.o(134450);
      return;
    }
    AppBrandRuntime.t(this.jxm).a(this.jxm, this.NB);
    AppMethodBeat.o(134450);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.AppBrandRuntime.8
 * JD-Core Version:    0.7.0.1
 */