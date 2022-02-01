package com.tencent.mm.plugin.appbrand.jsapi.webview;

import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.xweb.v;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/webview/AppBrandXWVideoJsCallbackIMPL;", "Lcom/tencent/xweb/VideoJsCallback;", "()V", "webView", "Lcom/tencent/mm/plugin/appbrand/jsapi/webview/HTMLWebViewContract$IView;", "getWebView", "()Lcom/tencent/mm/plugin/appbrand/jsapi/webview/HTMLWebViewContract$IView;", "setWebView", "(Lcom/tencent/mm/plugin/appbrand/jsapi/webview/HTMLWebViewContract$IView;)V", "onVideoEmptied", "", "onVideoEnded", "onVideoEnterFullscreen", "isVideoTag", "", "id", "", "width", "", "height", "paused", "seeking", "currentTime", "duration", "buffered", "", "onVideoError", "error", "", "msg", "", "onVideoExitFullscreen", "onVideoPause", "onVideoPlay", "onVideoPlaying", "onVideoSeeked", "onVideoSeeking", "onVideoSizeUpdate", "onVideoTimeUpdate", "onVideoWaiting", "Companion", "plugin-appbrand-integration_release"})
public abstract class f
  implements v
{
  @Deprecated
  public static final a pGj = new a((byte)0);
  private g.c pGi;
  
  public final void bXx() {}
  
  public final void onVideoEnded() {}
  
  public final void onVideoEnterFullscreen(boolean paramBoolean1, long paramLong, double paramDouble1, double paramDouble2, boolean paramBoolean2, boolean paramBoolean3, double paramDouble3, double paramDouble4, double[] paramArrayOfDouble)
  {
    paramArrayOfDouble = new StringBuilder("onVideoEnterFullScreen isVideoTag:").append(paramBoolean1).append(", view[");
    g.c localc = this.pGi;
    if (localc != null) {}
    for (int i = localc.hashCode();; i = 0)
    {
      Log.i("MicroMsg.AppBrandXWVideoJsCallbackIMPL", i + ']');
      return;
    }
  }
  
  public final void onVideoError(int paramInt, String paramString)
  {
    paramString = new StringBuilder("onVideoError error:").append(paramInt).append(" msg:").append(paramString).append(", view[");
    g.c localc = this.pGi;
    if (localc != null) {}
    for (paramInt = localc.hashCode();; paramInt = 0)
    {
      Log.e("MicroMsg.AppBrandXWVideoJsCallbackIMPL", paramInt + ']');
      return;
    }
  }
  
  public final void onVideoExitFullscreen()
  {
    StringBuilder localStringBuilder = new StringBuilder("onVideoExitFullscreen, view[");
    g.c localc = this.pGi;
    if (localc != null) {}
    for (int i = localc.hashCode();; i = 0)
    {
      Log.i("MicroMsg.AppBrandXWVideoJsCallbackIMPL", i + ']');
      return;
    }
  }
  
  public final void onVideoPause() {}
  
  public final void onVideoPlay() {}
  
  public final void onVideoPlaying() {}
  
  public final void onVideoSeeked() {}
  
  public final void onVideoSeeking() {}
  
  public final void onVideoSizeUpdate(double paramDouble1, double paramDouble2) {}
  
  public final void onVideoTimeUpdate(double paramDouble1, double paramDouble2, double[] paramArrayOfDouble) {}
  
  public final void onVideoWaiting() {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/webview/AppBrandXWVideoJsCallbackIMPL$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.webview.f
 * JD-Core Version:    0.7.0.1
 */