package com.tencent.mm.plugin.appbrand.jsapi.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.bc;
import com.tencent.mm.sdk.platformtools.ab;

final class f$1
  implements bc
{
  f$1(f paramf, AppBrandVideoView paramAppBrandVideoView) {}
  
  public final void aDk()
  {
    AppMethodBeat.i(126549);
    AppBrandVideoView localAppBrandVideoView = this.idM;
    ab.i("MicroMsg.AppBrandVideoView", "onExitFullScreen");
    if (localAppBrandVideoView.ico.aFq()) {
      localAppBrandVideoView.ico.aDh();
    }
    localAppBrandVideoView.ey(false);
    AppMethodBeat.o(126549);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.f.1
 * JD-Core Version:    0.7.0.1
 */