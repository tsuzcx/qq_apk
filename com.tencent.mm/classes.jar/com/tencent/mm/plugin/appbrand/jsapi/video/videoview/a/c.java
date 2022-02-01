package com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.d;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.h;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/video/videoview/exo/AppBrandExoVideoViewWrapper;", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView;", "context", "Landroid/content/Context;", "videoView", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView;)V", "getCacheTimeSec", "", "getCurrPosMs", "getCurrPosSec", "getPlayerType", "getVideoDurationSec", "getView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "isLive", "", "isPlaying", "onSingleTap", "onUIDestroy", "", "onUIPause", "onUIResume", "pause", "play", "preloadVideo", "removeVideoFooterView", "seekTo", "seconds", "", "afterPlay", "setCover", "bitmap", "Landroid/graphics/Bitmap;", "setFullDirection", "direction", "setIMMVideoViewCallback", "callback", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView$IMMVideoViewCallback;", "setIsShowBasicControls", "isShow", "setMute", "mute", "setPlayRate", "playRate", "", "setScaleType", "scaleType", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView$ScaleType;", "setVideoFooterView", "footer", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView$IMMVideoFooter;", "setVideoPath", "url", "", "durationSec", "setVideoSource", "videoSource", "start", "stop", "luggage-commons-jsapi-video-ext_release"})
public final class c
  implements d
{
  private final d pvc;
  
  public c(Context paramContext, byte paramByte)
  {
    this(paramContext);
  }
  
  private c(d paramd)
  {
    AppMethodBeat.i(226892);
    this.pvc = paramd;
    AppMethodBeat.o(226892);
  }
  
  public final boolean a(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(226917);
    paramBoolean = this.pvc.a(paramDouble, paramBoolean);
    AppMethodBeat.o(226917);
    return paramBoolean;
  }
  
  public final boolean aO(float paramFloat)
  {
    AppMethodBeat.i(226929);
    boolean bool = this.pvc.aO(paramFloat);
    AppMethodBeat.o(226929);
    return bool;
  }
  
  public final void bUF()
  {
    AppMethodBeat.i(226914);
    this.pvc.bUF();
    AppMethodBeat.o(226914);
  }
  
  public final void c(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(226935);
    this.pvc.c(paramBoolean, paramString, paramInt);
    AppMethodBeat.o(226935);
  }
  
  public final int getCacheTimeSec()
  {
    AppMethodBeat.i(226896);
    int i = this.pvc.getCacheTimeSec();
    AppMethodBeat.o(226896);
    return i;
  }
  
  public final int getCurrPosMs()
  {
    AppMethodBeat.i(226899);
    int i = this.pvc.getCurrPosMs();
    AppMethodBeat.o(226899);
    return i;
  }
  
  public final int getCurrPosSec()
  {
    AppMethodBeat.i(226900);
    int i = this.pvc.getCurrPosSec();
    AppMethodBeat.o(226900);
    return i;
  }
  
  public final int getPlayerType()
  {
    AppMethodBeat.i(226902);
    int i = this.pvc.getPlayerType();
    AppMethodBeat.o(226902);
    return i;
  }
  
  public final int getVideoDurationSec()
  {
    AppMethodBeat.i(226903);
    int i = this.pvc.getVideoDurationSec();
    AppMethodBeat.o(226903);
    return i;
  }
  
  public final View getView()
  {
    AppMethodBeat.i(226904);
    View localView = this.pvc.getView();
    AppMethodBeat.o(226904);
    return localView;
  }
  
  public final boolean isLive()
  {
    AppMethodBeat.i(226906);
    boolean bool = this.pvc.isLive();
    AppMethodBeat.o(226906);
    return bool;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(226907);
    boolean bool = this.pvc.isPlaying();
    AppMethodBeat.o(226907);
    return bool;
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(226908);
    this.pvc.onUIDestroy();
    AppMethodBeat.o(226908);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(226909);
    this.pvc.onUIPause();
    AppMethodBeat.o(226909);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(226910);
    this.pvc.onUIResume();
    AppMethodBeat.o(226910);
  }
  
  public final boolean p(double paramDouble)
  {
    AppMethodBeat.i(226915);
    boolean bool = this.pvc.p(paramDouble);
    AppMethodBeat.o(226915);
    return bool;
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(226911);
    boolean bool = this.pvc.pause();
    AppMethodBeat.o(226911);
    return bool;
  }
  
  public final void setCover(Bitmap paramBitmap)
  {
    AppMethodBeat.i(226920);
    this.pvc.setCover(paramBitmap);
    AppMethodBeat.o(226920);
  }
  
  public final void setFullDirection(int paramInt)
  {
    AppMethodBeat.i(226921);
    this.pvc.setFullDirection(paramInt);
    AppMethodBeat.o(226921);
  }
  
  public final void setIMMVideoViewCallback(d.c paramc)
  {
    AppMethodBeat.i(226924);
    this.pvc.setIMMVideoViewCallback(paramc);
    AppMethodBeat.o(226924);
  }
  
  public final void setIsShowBasicControls(boolean paramBoolean)
  {
    AppMethodBeat.i(226926);
    this.pvc.setIsShowBasicControls(paramBoolean);
    AppMethodBeat.o(226926);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(226928);
    this.pvc.setMute(paramBoolean);
    AppMethodBeat.o(226928);
  }
  
  public final void setScaleType(d.h paramh)
  {
    AppMethodBeat.i(226930);
    this.pvc.setScaleType(paramh);
    AppMethodBeat.o(226930);
  }
  
  public final void setVideoFooterView(d.b paramb)
  {
    AppMethodBeat.i(226933);
    this.pvc.setVideoFooterView(paramb);
    AppMethodBeat.o(226933);
  }
  
  public final void setVideoSource(int paramInt)
  {
    AppMethodBeat.i(226937);
    this.pvc.setVideoSource(paramInt);
    AppMethodBeat.o(226937);
  }
  
  public final void start()
  {
    AppMethodBeat.i(226941);
    this.pvc.start();
    AppMethodBeat.o(226941);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(226942);
    this.pvc.stop();
    AppMethodBeat.o(226942);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a.c
 * JD-Core Version:    0.7.0.1
 */