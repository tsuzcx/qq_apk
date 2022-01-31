package com.tencent.mm.plugin.appbrand.jsapi.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;

final class a$4
  implements f.c
{
  a$4(a parama, AppBrandLivePlayerView paramAppBrandLivePlayerView, e parame) {}
  
  public final void onDestroy()
  {
    AppMethodBeat.i(96073);
    this.hNC.onExit();
    this.hEL.b(this);
    AppMethodBeat.o(96073);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.a.4
 * JD-Core Version:    0.7.0.1
 */