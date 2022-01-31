package com.tencent.mm.plugin.appbrand.jsapi.live;

import com.tencent.mm.plugin.appbrand.page.aj;
import com.tencent.mm.sdk.platformtools.y;

final class b$1
  implements aj
{
  b$1(b paramb, AppBrandLivePlayerView paramAppBrandLivePlayerView) {}
  
  public final void ajc()
  {
    AppBrandLivePlayerView localAppBrandLivePlayerView = this.gsg;
    y.i("MicroMsg.AppBrandLivePlayerView", "onExitFullScreen");
    localAppBrandLivePlayerView.dd(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.b.1
 * JD-Core Version:    0.7.0.1
 */