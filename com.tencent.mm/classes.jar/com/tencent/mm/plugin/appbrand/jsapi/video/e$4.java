package com.tencent.mm.plugin.appbrand.jsapi.video;

import com.tencent.mm.plugin.appbrand.jsapi.e.b;
import com.tencent.mm.plugin.appbrand.jsapi.e.c;
import com.tencent.mm.plugin.appbrand.jsapi.e.d;
import com.tencent.mm.sdk.platformtools.y;

final class e$4
  implements e.c
{
  e$4(e parame, AppBrandVideoView paramAppBrandVideoView, com.tencent.mm.plugin.appbrand.jsapi.e parame1, e.d paramd, e.b paramb) {}
  
  public final void onDestroy()
  {
    AppBrandVideoView localAppBrandVideoView = this.gEI;
    y.i("MicroMsg.AppBrandVideoView", "onUIDestroy");
    localAppBrandVideoView.clean();
    this.gkV.b(this.gsk);
    this.gkV.b(this.gsj);
    this.gkV.b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.4
 * JD-Core Version:    0.7.0.1
 */