package com.tencent.mm.plugin.appbrand;

import com.tencent.luggage.sdk.g.c;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AppBrandRuntime$6
  implements Runnable
{
  AppBrandRuntime$6(AppBrandRuntime paramAppBrandRuntime) {}
  
  public final void run()
  {
    AppMethodBeat.i(134448);
    Runnable local1 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(197168);
        AppBrandRuntime.6.this.jxm.aVV();
        AppMethodBeat.o(197168);
      }
    };
    if (!this.jxm.K(local1)) {
      local1.run();
    }
    c.a("onReady", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(197169);
        AppBrandRuntime.6.this.jxm.onReady();
        AppMethodBeat.o(197169);
      }
    });
    AppMethodBeat.o(134448);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.AppBrandRuntime.6
 * JD-Core Version:    0.7.0.1
 */