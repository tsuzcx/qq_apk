package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class AppBrandRuntime$7
  implements Runnable
{
  AppBrandRuntime$7(AppBrandRuntime paramAppBrandRuntime) {}
  
  public final void run()
  {
    AppMethodBeat.i(134449);
    if (AppBrandRuntime.t(this.jxm) == null)
    {
      this.jxm.dispatchDestroy();
      AppMethodBeat.o(134449);
      return;
    }
    AppBrandRuntime.t(this.jxm).y(this.jxm);
    AppMethodBeat.o(134449);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.AppBrandRuntime.7
 * JD-Core Version:    0.7.0.1
 */