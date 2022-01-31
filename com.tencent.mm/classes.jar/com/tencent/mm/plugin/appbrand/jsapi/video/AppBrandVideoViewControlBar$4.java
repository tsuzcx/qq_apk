package com.tencent.mm.plugin.appbrand.jsapi.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap.a;

final class AppBrandVideoViewControlBar$4
  implements ap.a
{
  AppBrandVideoViewControlBar$4(AppBrandVideoViewControlBar paramAppBrandVideoViewControlBar) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(131537);
    if (!AppBrandVideoViewControlBar.d(this.idw))
    {
      AppMethodBeat.o(131537);
      return false;
    }
    AppMethodBeat.o(131537);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoViewControlBar.4
 * JD-Core Version:    0.7.0.1
 */