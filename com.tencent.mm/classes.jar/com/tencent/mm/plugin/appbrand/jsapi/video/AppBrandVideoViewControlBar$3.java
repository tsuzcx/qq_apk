package com.tencent.mm.plugin.appbrand.jsapi.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;

final class AppBrandVideoViewControlBar$3
  implements ap.a
{
  AppBrandVideoViewControlBar$3(AppBrandVideoViewControlBar paramAppBrandVideoViewControlBar) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(131536);
    this.idw.setVisibility(8);
    AppBrandVideoViewControlBar.c(this.idw).stopTimer();
    AppMethodBeat.o(131536);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoViewControlBar.3
 * JD-Core Version:    0.7.0.1
 */