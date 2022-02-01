package com.tencent.mm.plugin.appbrand.ae.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.d;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.h;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/video/widget/ThumbVideoViewWrapper;", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView;", "context", "Landroid/content/Context;", "thumbVideoView", "Lcom/tencent/mm/plugin/appbrand/video/widget/ThumbVideoView;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/video/widget/ThumbVideoView;)V", "getCacheTimeSec", "", "getCurrPosMs", "getCurrPosSec", "getPlayerType", "getVideoDurationSec", "getView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "isLive", "", "isPlaying", "onSingleTap", "onUIDestroy", "", "onUIPause", "onUIResume", "pause", "play", "preloadVideo", "removeVideoFooterView", "seekTo", "p0", "", "p1", "setCover", "Landroid/graphics/Bitmap;", "setFullDirection", "setIMMVideoViewCallback", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView$IMMVideoViewCallback;", "setIsShowBasicControls", "setMute", "setPlayRate", "", "setScaleType", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView$ScaleType;", "setVideoFooterView", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView$IMMVideoFooter;", "setVideoPath", "", "p2", "setVideoSource", "start", "stop", "plugin-appbrand-integration_release"})
public final class f
  implements d
{
  public f(Context paramContext, byte paramByte)
  {
    this(paramContext);
  }
  
  private f(Context paramContext, e parame)
  {
    AppMethodBeat.i(278428);
    this.rkq = parame;
    AppMethodBeat.o(278428);
  }
  
  public final boolean a(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(278449);
    paramBoolean = this.rkq.a(paramDouble, paramBoolean);
    AppMethodBeat.o(278449);
    return paramBoolean;
  }
  
  public final boolean aO(float paramFloat)
  {
    AppMethodBeat.i(278456);
    boolean bool = this.rkq.aO(paramFloat);
    AppMethodBeat.o(278456);
    return bool;
  }
  
  public final void bUF()
  {
    AppMethodBeat.i(278447);
    this.rkq.bUF();
    AppMethodBeat.o(278447);
  }
  
  public final void c(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(278459);
    this.rkq.c(paramBoolean, paramString, paramInt);
    AppMethodBeat.o(278459);
  }
  
  public final int getCacheTimeSec()
  {
    AppMethodBeat.i(278432);
    int i = this.rkq.getCacheTimeSec();
    AppMethodBeat.o(278432);
    return i;
  }
  
  public final int getCurrPosMs()
  {
    AppMethodBeat.i(278434);
    int i = this.rkq.getCurrPosMs();
    AppMethodBeat.o(278434);
    return i;
  }
  
  public final int getCurrPosSec()
  {
    AppMethodBeat.i(278436);
    int i = this.rkq.getCurrPosSec();
    AppMethodBeat.o(278436);
    return i;
  }
  
  public final int getPlayerType()
  {
    AppMethodBeat.i(278437);
    int i = this.rkq.getPlayerType();
    AppMethodBeat.o(278437);
    return i;
  }
  
  public final int getVideoDurationSec()
  {
    AppMethodBeat.i(278439);
    int i = this.rkq.getVideoDurationSec();
    AppMethodBeat.o(278439);
    return i;
  }
  
  public final View getView()
  {
    AppMethodBeat.i(278440);
    View localView = this.rkq.getView();
    AppMethodBeat.o(278440);
    return localView;
  }
  
  public final boolean isLive()
  {
    AppMethodBeat.i(278441);
    boolean bool = this.rkq.isLive();
    AppMethodBeat.o(278441);
    return bool;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(278442);
    boolean bool = this.rkq.isPlaying();
    AppMethodBeat.o(278442);
    return bool;
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(278443);
    this.rkq.onUIDestroy();
    AppMethodBeat.o(278443);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(278444);
    this.rkq.onUIPause();
    AppMethodBeat.o(278444);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(278445);
    this.rkq.onUIResume();
    AppMethodBeat.o(278445);
  }
  
  public final boolean p(double paramDouble)
  {
    AppMethodBeat.i(278448);
    boolean bool = this.rkq.p(paramDouble);
    AppMethodBeat.o(278448);
    return bool;
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(278446);
    boolean bool = this.rkq.pause();
    AppMethodBeat.o(278446);
    return bool;
  }
  
  public final void setCover(Bitmap paramBitmap)
  {
    AppMethodBeat.i(278450);
    this.rkq.setCover(paramBitmap);
    AppMethodBeat.o(278450);
  }
  
  public final void setFullDirection(int paramInt)
  {
    AppMethodBeat.i(278451);
    this.rkq.setFullDirection(paramInt);
    AppMethodBeat.o(278451);
  }
  
  public final void setIMMVideoViewCallback(d.c paramc)
  {
    AppMethodBeat.i(278452);
    this.rkq.setIMMVideoViewCallback(paramc);
    AppMethodBeat.o(278452);
  }
  
  public final void setIsShowBasicControls(boolean paramBoolean)
  {
    AppMethodBeat.i(278453);
    this.rkq.setIsShowBasicControls(paramBoolean);
    AppMethodBeat.o(278453);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(278455);
    this.rkq.setMute(paramBoolean);
    AppMethodBeat.o(278455);
  }
  
  public final void setScaleType(d.h paramh)
  {
    AppMethodBeat.i(278457);
    this.rkq.setScaleType(paramh);
    AppMethodBeat.o(278457);
  }
  
  public final void setVideoFooterView(d.b paramb)
  {
    AppMethodBeat.i(278458);
    this.rkq.setVideoFooterView(paramb);
    AppMethodBeat.o(278458);
  }
  
  public final void setVideoSource(int paramInt)
  {
    AppMethodBeat.i(278460);
    this.rkq.setVideoSource(paramInt);
    AppMethodBeat.o(278460);
  }
  
  public final void start()
  {
    AppMethodBeat.i(278461);
    this.rkq.start();
    AppMethodBeat.o(278461);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(278462);
    this.rkq.stop();
    AppMethodBeat.o(278462);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ae.b.f
 * JD-Core Version:    0.7.0.1
 */