package com.tencent.mm.plugin.appbrand.jsapi.video;

import com.tencent.mm.plugin.appbrand.page.aj;
import com.tencent.mm.sdk.platformtools.y;

final class e$1
  implements aj
{
  e$1(e parame, AppBrandVideoView paramAppBrandVideoView) {}
  
  public final void ajc()
  {
    AppBrandVideoView localAppBrandVideoView = this.gEI;
    y.i("MicroMsg.AppBrandVideoView", "onExitFullScreen");
    if (localAppBrandVideoView.gDm.akK()) {
      localAppBrandVideoView.gDm.aiZ();
    }
    localAppBrandVideoView.dt(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.1
 * JD-Core Version:    0.7.0.1
 */