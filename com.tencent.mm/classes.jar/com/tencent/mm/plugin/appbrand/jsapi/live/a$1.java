package com.tencent.mm.plugin.appbrand.jsapi.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.bc;
import com.tencent.mm.sdk.platformtools.ab;

final class a$1
  implements bc
{
  a$1(a parama, AppBrandLivePlayerView paramAppBrandLivePlayerView) {}
  
  public final void aDk()
  {
    AppMethodBeat.i(96070);
    AppBrandLivePlayerView localAppBrandLivePlayerView = this.hNC;
    ab.i("MicroMsg.AppBrandLivePlayerView", "onExitFullScreen");
    localAppBrandLivePlayerView.eg(false);
    AppMethodBeat.o(96070);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.a.1
 * JD-Core Version:    0.7.0.1
 */