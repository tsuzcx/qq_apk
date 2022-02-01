package com.tencent.mm.plugin.appbrand.jsapi.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.bv;
import com.tencent.mm.sdk.platformtools.ad;

final class a$1
  implements bv
{
  a$1(a parama, AppBrandLivePlayerView paramAppBrandLivePlayerView) {}
  
  public final void Cx()
  {
    AppMethodBeat.i(145844);
    AppBrandLivePlayerView localAppBrandLivePlayerView = this.jSS;
    ad.i("MicroMsg.AppBrandLivePlayerView", "onExitFullScreen");
    localAppBrandLivePlayerView.fV(false);
    AppMethodBeat.o(145844);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.a.1
 * JD-Core Version:    0.7.0.1
 */