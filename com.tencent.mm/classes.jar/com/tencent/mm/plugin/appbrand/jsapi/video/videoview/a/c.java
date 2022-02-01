package com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.h;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/video/videoview/exo/AppBrandExoVideoViewWrapper;", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView;", "context", "Landroid/content/Context;", "videoView", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView;)V", "getCacheTimeSec", "", "getCurrPosMs", "getCurrPosSec", "getPlayerType", "getVideoDurationSec", "getView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "isLive", "", "isPlaying", "onSingleTap", "onUIDestroy", "", "onUIPause", "onUIResume", "pause", "play", "preloadVideo", "removeVideoFooterView", "seekTo", "seconds", "", "afterPlay", "setCover", "bitmap", "Landroid/graphics/Bitmap;", "setFullDirection", "direction", "setIMMVideoViewCallback", "callback", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView$IMMVideoViewCallback;", "setIsShowBasicControls", "isShow", "setMute", "mute", "setPlayRate", "playRate", "", "setScaleType", "scaleType", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView$ScaleType;", "setVideoFooterView", "footer", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView$IMMVideoFooter;", "setVideoPath", "url", "", "durationSec", "setVideoSource", "videoSource", "start", "stop", "luggage-commons-jsapi-video-ext_release"})
public final class c
  implements e
{
  private final e mwC;
  
  public c(Context paramContext, byte paramByte)
  {
    this(paramContext);
  }
  
  private c(e parame)
  {
    AppMethodBeat.i(235249);
    this.mwC = parame;
    AppMethodBeat.o(235249);
  }
  
  public final boolean aO(float paramFloat)
  {
    AppMethodBeat.i(235271);
    boolean bool = this.mwC.aO(paramFloat);
    AppMethodBeat.o(235271);
    return bool;
  }
  
  public final void bIW()
  {
    AppMethodBeat.i(235263);
    this.mwC.bIW();
    AppMethodBeat.o(235263);
  }
  
  public final void c(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(235274);
    this.mwC.c(paramBoolean, paramString, paramInt);
    AppMethodBeat.o(235274);
  }
  
  public final boolean c(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(235265);
    paramBoolean = this.mwC.c(paramDouble, paramBoolean);
    AppMethodBeat.o(235265);
    return paramBoolean;
  }
  
  public final int getCacheTimeSec()
  {
    AppMethodBeat.i(235251);
    int i = this.mwC.getCacheTimeSec();
    AppMethodBeat.o(235251);
    return i;
  }
  
  public final int getCurrPosMs()
  {
    AppMethodBeat.i(235252);
    int i = this.mwC.getCurrPosMs();
    AppMethodBeat.o(235252);
    return i;
  }
  
  public final int getCurrPosSec()
  {
    AppMethodBeat.i(235253);
    int i = this.mwC.getCurrPosSec();
    AppMethodBeat.o(235253);
    return i;
  }
  
  public final int getPlayerType()
  {
    AppMethodBeat.i(235254);
    int i = this.mwC.getPlayerType();
    AppMethodBeat.o(235254);
    return i;
  }
  
  public final int getVideoDurationSec()
  {
    AppMethodBeat.i(235255);
    int i = this.mwC.getVideoDurationSec();
    AppMethodBeat.o(235255);
    return i;
  }
  
  public final View getView()
  {
    AppMethodBeat.i(235256);
    View localView = this.mwC.getView();
    AppMethodBeat.o(235256);
    return localView;
  }
  
  public final boolean isLive()
  {
    AppMethodBeat.i(235257);
    boolean bool = this.mwC.isLive();
    AppMethodBeat.o(235257);
    return bool;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(235258);
    boolean bool = this.mwC.isPlaying();
    AppMethodBeat.o(235258);
    return bool;
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(235259);
    this.mwC.onUIDestroy();
    AppMethodBeat.o(235259);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(235260);
    this.mwC.onUIPause();
    AppMethodBeat.o(235260);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(235261);
    this.mwC.onUIResume();
    AppMethodBeat.o(235261);
  }
  
  public final boolean p(double paramDouble)
  {
    AppMethodBeat.i(235264);
    boolean bool = this.mwC.p(paramDouble);
    AppMethodBeat.o(235264);
    return bool;
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(235262);
    boolean bool = this.mwC.pause();
    AppMethodBeat.o(235262);
    return bool;
  }
  
  public final void setCover(Bitmap paramBitmap)
  {
    AppMethodBeat.i(235266);
    this.mwC.setCover(paramBitmap);
    AppMethodBeat.o(235266);
  }
  
  public final void setFullDirection(int paramInt)
  {
    AppMethodBeat.i(235267);
    this.mwC.setFullDirection(paramInt);
    AppMethodBeat.o(235267);
  }
  
  public final void setIMMVideoViewCallback(e.c paramc)
  {
    AppMethodBeat.i(235268);
    this.mwC.setIMMVideoViewCallback(paramc);
    AppMethodBeat.o(235268);
  }
  
  public final void setIsShowBasicControls(boolean paramBoolean)
  {
    AppMethodBeat.i(235269);
    this.mwC.setIsShowBasicControls(paramBoolean);
    AppMethodBeat.o(235269);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(235270);
    this.mwC.setMute(paramBoolean);
    AppMethodBeat.o(235270);
  }
  
  public final void setScaleType(e.h paramh)
  {
    AppMethodBeat.i(235272);
    this.mwC.setScaleType(paramh);
    AppMethodBeat.o(235272);
  }
  
  public final void setVideoFooterView(e.b paramb)
  {
    AppMethodBeat.i(235273);
    this.mwC.setVideoFooterView(paramb);
    AppMethodBeat.o(235273);
  }
  
  public final void setVideoSource(int paramInt)
  {
    AppMethodBeat.i(235275);
    this.mwC.setVideoSource(paramInt);
    AppMethodBeat.o(235275);
  }
  
  public final void start()
  {
    AppMethodBeat.i(235276);
    this.mwC.start();
    AppMethodBeat.o(235276);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(235277);
    this.mwC.stop();
    AppMethodBeat.o(235277);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a.c
 * JD-Core Version:    0.7.0.1
 */