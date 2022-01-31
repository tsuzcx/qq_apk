package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AppBrandVideoWrapper$1
  implements AppBrandVideoView.b
{
  public final AppBrandVideoView cO(Context paramContext)
  {
    AppMethodBeat.i(131585);
    AppBrandVideoWrapper localAppBrandVideoWrapper = new AppBrandVideoWrapper(paramContext);
    AppBrandVideoView localAppBrandVideoView = new AppBrandVideoView(paramContext, localAppBrandVideoWrapper);
    paramContext = new AppBrandVideoViewControlBar(paramContext);
    localAppBrandVideoView.a(paramContext);
    localAppBrandVideoWrapper.setVideoFooterView(paramContext);
    AppMethodBeat.o(131585);
    return localAppBrandVideoView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoWrapper.1
 * JD-Core Version:    0.7.0.1
 */