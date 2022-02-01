package com.tencent.mm.plugin.appbrand.jsapi.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.bu;
import com.tencent.mm.sdk.platformtools.Log;

final class a$1
  implements bu
{
  a$1(a parama, AppBrandLivePlayerView paramAppBrandLivePlayerView) {}
  
  public final void Na()
  {
    AppMethodBeat.i(145844);
    AppBrandLivePlayerView localAppBrandLivePlayerView = this.lXN;
    Log.i("MicroMsg.AppBrandLivePlayerView", "onExitFullScreen");
    localAppBrandLivePlayerView.ht(false);
    AppMethodBeat.o(145844);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.a.1
 * JD-Core Version:    0.7.0.1
 */