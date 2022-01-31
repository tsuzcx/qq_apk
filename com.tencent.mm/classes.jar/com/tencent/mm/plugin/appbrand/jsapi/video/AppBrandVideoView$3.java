package com.tencent.mm.plugin.appbrand.jsapi.video;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class AppBrandVideoView$3
  implements d.h
{
  AppBrandVideoView$3(AppBrandVideoView paramAppBrandVideoView) {}
  
  public final int aEV()
  {
    AppMethodBeat.i(126443);
    int i = AppBrandVideoView.b(this.icX).getCacheTimeSec();
    AppMethodBeat.o(126443);
    return i;
  }
  
  public final int aEW()
  {
    AppMethodBeat.i(126444);
    int i = AppBrandVideoView.b(this.icX).getVideoDurationSec();
    AppMethodBeat.o(126444);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView.3
 * JD-Core Version:    0.7.0.1
 */