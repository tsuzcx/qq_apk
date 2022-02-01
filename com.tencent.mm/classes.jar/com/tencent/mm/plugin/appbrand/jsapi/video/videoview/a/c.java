package com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.d;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.h;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/video/videoview/exo/AppBrandExoVideoViewWrapper;", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView;", "context", "Landroid/content/Context;", "videoView", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView;)V", "getCacheTimeSec", "", "getCurrPosMs", "getCurrPosSec", "getPlayerType", "getVideoDurationSec", "getView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "isLive", "", "isPlaying", "onSingleTap", "onUIDestroy", "", "onUIPause", "onUIResume", "pause", "play", "preloadVideo", "removeVideoFooterView", "seekTo", "seconds", "", "afterPlay", "setCover", "bitmap", "Landroid/graphics/Bitmap;", "setFullDirection", "direction", "setIMMVideoViewCallback", "callback", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView$IMMVideoViewCallback;", "setIsShowBasicControls", "isShow", "setMute", "mute", "setPlayRate", "playRate", "", "setScaleType", "scaleType", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView$ScaleType;", "setVideoFooterView", "footer", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView$IMMVideoFooter;", "setVideoPath", "url", "", "durationSec", "setVideoSource", "videoSource", "start", "stop", "luggage-commons-jsapi-video-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  implements d
{
  private final d sAi;
  
  public c(Context paramContext, byte paramByte)
  {
    this(paramContext);
  }
  
  private c(d paramd)
  {
    AppMethodBeat.i(328915);
    this.sAi = paramd;
    AppMethodBeat.o(328915);
  }
  
  public final boolean G(double paramDouble)
  {
    AppMethodBeat.i(328996);
    boolean bool = this.sAi.G(paramDouble);
    AppMethodBeat.o(328996);
    return bool;
  }
  
  public final void b(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(329065);
    this.sAi.b(paramBoolean, paramString, paramInt);
    AppMethodBeat.o(329065);
  }
  
  public final boolean b(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(329003);
    paramBoolean = this.sAi.b(paramDouble, paramBoolean);
    AppMethodBeat.o(329003);
    return paramBoolean;
  }
  
  public final boolean bM(float paramFloat)
  {
    AppMethodBeat.i(329046);
    boolean bool = this.sAi.bM(paramFloat);
    AppMethodBeat.o(329046);
    return bool;
  }
  
  public final void cuV()
  {
    AppMethodBeat.i(328992);
    this.sAi.cuV();
    AppMethodBeat.o(328992);
  }
  
  public final int getCacheTimeSec()
  {
    AppMethodBeat.i(328929);
    int i = this.sAi.getCacheTimeSec();
    AppMethodBeat.o(328929);
    return i;
  }
  
  public final int getCurrPosMs()
  {
    AppMethodBeat.i(328938);
    int i = this.sAi.getCurrPosMs();
    AppMethodBeat.o(328938);
    return i;
  }
  
  public final int getCurrPosSec()
  {
    AppMethodBeat.i(328945);
    int i = this.sAi.getCurrPosSec();
    AppMethodBeat.o(328945);
    return i;
  }
  
  public final int getPlayerType()
  {
    AppMethodBeat.i(328949);
    int i = this.sAi.getPlayerType();
    AppMethodBeat.o(328949);
    return i;
  }
  
  public final int getVideoDurationSec()
  {
    AppMethodBeat.i(328954);
    int i = this.sAi.getVideoDurationSec();
    AppMethodBeat.o(328954);
    return i;
  }
  
  public final View getView()
  {
    AppMethodBeat.i(328957);
    View localView = this.sAi.getView();
    AppMethodBeat.o(328957);
    return localView;
  }
  
  public final boolean isLive()
  {
    AppMethodBeat.i(328962);
    boolean bool = this.sAi.isLive();
    AppMethodBeat.o(328962);
    return bool;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(328967);
    boolean bool = this.sAi.isPlaying();
    AppMethodBeat.o(328967);
    return bool;
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(328972);
    this.sAi.onUIDestroy();
    AppMethodBeat.o(328972);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(328976);
    this.sAi.onUIPause();
    AppMethodBeat.o(328976);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(328980);
    this.sAi.onUIResume();
    AppMethodBeat.o(328980);
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(328986);
    boolean bool = this.sAi.pause();
    AppMethodBeat.o(328986);
    return bool;
  }
  
  public final void setCover(Bitmap paramBitmap)
  {
    AppMethodBeat.i(329009);
    this.sAi.setCover(paramBitmap);
    AppMethodBeat.o(329009);
  }
  
  public final void setFullDirection(int paramInt)
  {
    AppMethodBeat.i(329018);
    this.sAi.setFullDirection(paramInt);
    AppMethodBeat.o(329018);
  }
  
  public final void setIMMVideoViewCallback(d.c paramc)
  {
    AppMethodBeat.i(329026);
    this.sAi.setIMMVideoViewCallback(paramc);
    AppMethodBeat.o(329026);
  }
  
  public final void setIsShowBasicControls(boolean paramBoolean)
  {
    AppMethodBeat.i(329034);
    this.sAi.setIsShowBasicControls(paramBoolean);
    AppMethodBeat.o(329034);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(329039);
    this.sAi.setMute(paramBoolean);
    AppMethodBeat.o(329039);
  }
  
  public final void setScaleType(d.h paramh)
  {
    AppMethodBeat.i(329055);
    this.sAi.setScaleType(paramh);
    AppMethodBeat.o(329055);
  }
  
  public final void setVideoFooterView(d.b paramb)
  {
    AppMethodBeat.i(329062);
    this.sAi.setVideoFooterView(paramb);
    AppMethodBeat.o(329062);
  }
  
  public final void setVideoSource(int paramInt)
  {
    AppMethodBeat.i(329071);
    this.sAi.setVideoSource(paramInt);
    AppMethodBeat.o(329071);
  }
  
  public final void start()
  {
    AppMethodBeat.i(329077);
    this.sAi.start();
    AppMethodBeat.o(329077);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(329080);
    this.sAi.stop();
    AppMethodBeat.o(329080);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a.c
 * JD-Core Version:    0.7.0.1
 */