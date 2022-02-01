package com.tencent.mm.plugin.appbrand.jsapi.video;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class AppBrandVideoView$2
  implements e.i
{
  AppBrandVideoView$2(AppBrandVideoView paramAppBrandVideoView) {}
  
  public final int bcl()
  {
    AppMethodBeat.i(193719);
    int i = AppBrandVideoView.b(this.kny).getCacheTimeSec();
    AppMethodBeat.o(193719);
    return i;
  }
  
  public final int bcm()
  {
    AppMethodBeat.i(193720);
    int i = AppBrandVideoView.b(this.kny).getVideoDurationSec();
    AppMethodBeat.o(193720);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView.2
 * JD-Core Version:    0.7.0.1
 */