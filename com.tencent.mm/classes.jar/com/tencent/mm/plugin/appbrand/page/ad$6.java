package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.performance.c;
import com.tencent.mm.sdk.platformtools.bt;

final class ad$6
  implements Runnable
{
  ad$6(ad paramad) {}
  
  public final void run()
  {
    AppMethodBeat.i(47843);
    this.lbt.getRuntime().iGe.F(3, bt.aS(ad.b(this.lbt)));
    c.a(this.lbt.getAppId(), "Native", "WebViewInit+PageFrameLoad", ad.b(this.lbt), System.currentTimeMillis(), "");
    AppMethodBeat.o(47843);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ad.6
 * JD-Core Version:    0.7.0.1
 */