package com.tencent.mm.plugin.appbrand.jsapi.video.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.a;
import com.tencent.mm.plugin.appbrand.page.bq;
import com.tencent.mm.sdk.platformtools.ac;

final class a$1
  implements bq
{
  a$1(a parama, AppBrandVideoView paramAppBrandVideoView) {}
  
  public final void Cb()
  {
    AppMethodBeat.i(194405);
    AppBrandVideoView localAppBrandVideoView = this.kTn;
    ac.i("MicroMsg.Video.AppBrandVideoView", "onExitFullScreen");
    if (localAppBrandVideoView.kOf.bjy()) {
      localAppBrandVideoView.kOf.bha();
    }
    localAppBrandVideoView.gJ(false);
    AppMethodBeat.o(194405);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.d.a.1
 * JD-Core Version:    0.7.0.1
 */