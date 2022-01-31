package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.media.ThumbnailUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.al;

final class AppBrandVideoView$8
  implements Runnable
{
  AppBrandVideoView$8(AppBrandVideoView paramAppBrandVideoView, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(126450);
    al.d(new AppBrandVideoView.8.1(this, ThumbnailUtils.createVideoThumbnail(this.hRL, 1)));
    AppMethodBeat.o(126450);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView.8
 * JD-Core Version:    0.7.0.1
 */