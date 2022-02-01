package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.page.u.f;
import com.tencent.mm.plugin.appbrand.widget.d;

final class AppBrandRuntime$4
  implements Runnable
{
  AppBrandRuntime$4(AppBrandRuntime paramAppBrandRuntime) {}
  
  public final void run()
  {
    AppMethodBeat.i(134446);
    AppBrandRuntime.a(this.jxm, this.jxm.aWb());
    AppBrandRuntime.p(this.jxm).setOnReadyListener(new u.f()
    {
      public final void aWp()
      {
        AppMethodBeat.i(134445);
        AppBrandRuntime.o(AppBrandRuntime.4.this.jxm);
        AppBrandRuntime.a(AppBrandRuntime.4.this.jxm, null);
        AppMethodBeat.o(134445);
      }
    });
    AppBrandRuntime.q(this.jxm).addView(AppBrandRuntime.p(this.jxm), 0);
    AppBrandRuntime.p(this.jxm).Sd(AppBrandRuntime.r(this.jxm).jCN);
    AppMethodBeat.o(134446);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.AppBrandRuntime.4
 * JD-Core Version:    0.7.0.1
 */