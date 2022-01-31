package com.tencent.mm.plugin.appbrand.jsapi.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.e.c;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;

final class b$6
  implements f.c
{
  b$6(b paramb, AppBrandLivePusherView paramAppBrandLivePusherView, com.tencent.mm.plugin.appbrand.jsapi.e parame, e.c paramc) {}
  
  public final void onDestroy()
  {
    AppMethodBeat.i(96094);
    this.hNI.onExit();
    this.hEL.b(this);
    com.tencent.mm.plugin.appbrand.e.b(this.hEL.getAppId(), this.hNL);
    AppMethodBeat.o(96094);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.b.6
 * JD-Core Version:    0.7.0.1
 */