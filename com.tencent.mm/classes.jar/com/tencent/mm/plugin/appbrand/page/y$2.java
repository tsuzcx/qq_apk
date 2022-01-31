package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.performance.c;
import com.tencent.mm.sdk.platformtools.bo;

final class y$2
  implements Runnable
{
  y$2(y paramy) {}
  
  public final void run()
  {
    AppMethodBeat.i(143483);
    this.ixC.getRuntime().gRn.C(3, bo.av(y.a(this.ixC)));
    c.a(this.ixC.getAppId(), "Native", "WebViewInit+PageFrameLoad", y.a(this.ixC), System.currentTimeMillis(), "");
    AppMethodBeat.o(143483);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.y.2
 * JD-Core Version:    0.7.0.1
 */