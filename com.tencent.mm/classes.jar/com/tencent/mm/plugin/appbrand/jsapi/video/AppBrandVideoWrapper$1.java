package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.content.Context;

final class AppBrandVideoWrapper$1
  implements AppBrandVideoView.b
{
  public final AppBrandVideoView cm(Context paramContext)
  {
    AppBrandVideoWrapper localAppBrandVideoWrapper = new AppBrandVideoWrapper(paramContext);
    AppBrandVideoView localAppBrandVideoView = new AppBrandVideoView(paramContext, localAppBrandVideoWrapper);
    paramContext = new AppBrandVideoViewControlBar(paramContext);
    localAppBrandVideoView.gDm = paramContext;
    localAppBrandVideoView.gDm.hide();
    localAppBrandVideoView.gDm.setFullScreenBtnOnClickListener(new AppBrandVideoView.13(localAppBrandVideoView));
    localAppBrandVideoView.gDm.setIplaySeekCallback(new AppBrandVideoView.14(localAppBrandVideoView));
    localAppBrandVideoView.gDm.setOnPlayButtonClickListener(new AppBrandVideoView.2(localAppBrandVideoView));
    localAppBrandVideoView.gDm.setStatePorter(new AppBrandVideoView.3(localAppBrandVideoView));
    localAppBrandVideoView.gDm.setMuteBtnOnClickListener(new AppBrandVideoView.4(localAppBrandVideoView));
    localAppBrandVideoView.gDm.setExitFullScreenBtnOnClickListener(new AppBrandVideoView.5(localAppBrandVideoView));
    localAppBrandVideoView.gDm.setOnVisibilityChangedListener(new AppBrandVideoView.6(localAppBrandVideoView));
    localAppBrandVideoView.gDm.setOnUpdateProgressLenListener(new AppBrandVideoView.7(localAppBrandVideoView));
    localAppBrandVideoView.gDj.setControlBar(paramContext);
    localAppBrandVideoWrapper.setVideoFooterView(paramContext);
    return localAppBrandVideoView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoWrapper.1
 * JD-Core Version:    0.7.0.1
 */