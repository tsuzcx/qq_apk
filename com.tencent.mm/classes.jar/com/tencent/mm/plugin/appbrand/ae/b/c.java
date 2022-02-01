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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/video/widget/AppBrandThumbVideoViewWrapper;", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView;", "context", "Landroid/content/Context;", "thumbVideoView", "Lcom/tencent/mm/plugin/appbrand/video/widget/AppBrandThumbVideoView;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/video/widget/AppBrandThumbVideoView;)V", "getCacheTimeSec", "", "getCurrPosMs", "getCurrPosSec", "getPlayerType", "getVideoDurationSec", "getView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "isLive", "", "isPlaying", "onSingleTap", "onUIDestroy", "", "onUIPause", "onUIResume", "pause", "play", "preloadVideo", "removeVideoFooterView", "seekTo", "p0", "", "p1", "setCover", "Landroid/graphics/Bitmap;", "setFullDirection", "setIMMVideoViewCallback", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView$IMMVideoViewCallback;", "setIsShowBasicControls", "setMute", "setPlayRate", "", "setScaleType", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView$ScaleType;", "setVideoFooterView", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView$IMMVideoFooter;", "setVideoPath", "", "p2", "setVideoSource", "start", "stop", "plugin-appbrand-integration_release"})
public final class c
  implements d
{
  public c(Context paramContext, byte paramByte)
  {
    this(paramContext);
  }
  
  private c(Context paramContext, b paramb)
  {
    AppMethodBeat.i(264605);
    this.rkp = paramb;
    AppMethodBeat.o(264605);
  }
  
  public final boolean a(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(264622);
    paramBoolean = this.rkp.a(paramDouble, paramBoolean);
    AppMethodBeat.o(264622);
    return paramBoolean;
  }
  
  public final boolean aO(float paramFloat)
  {
    AppMethodBeat.i(264628);
    boolean bool = this.rkp.aO(paramFloat);
    AppMethodBeat.o(264628);
    return bool;
  }
  
  public final void bUF()
  {
    AppMethodBeat.i(264620);
    this.rkp.bUF();
    AppMethodBeat.o(264620);
  }
  
  public final void c(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(264631);
    this.rkp.c(paramBoolean, paramString, paramInt);
    AppMethodBeat.o(264631);
  }
  
  public final int getCacheTimeSec()
  {
    AppMethodBeat.i(264607);
    int i = this.rkp.getCacheTimeSec();
    AppMethodBeat.o(264607);
    return i;
  }
  
  public final int getCurrPosMs()
  {
    AppMethodBeat.i(264608);
    int i = this.rkp.getCurrPosMs();
    AppMethodBeat.o(264608);
    return i;
  }
  
  public final int getCurrPosSec()
  {
    AppMethodBeat.i(264609);
    int i = this.rkp.getCurrPosSec();
    AppMethodBeat.o(264609);
    return i;
  }
  
  public final int getPlayerType()
  {
    AppMethodBeat.i(264610);
    int i = this.rkp.getPlayerType();
    AppMethodBeat.o(264610);
    return i;
  }
  
  public final int getVideoDurationSec()
  {
    AppMethodBeat.i(264612);
    int i = this.rkp.getVideoDurationSec();
    AppMethodBeat.o(264612);
    return i;
  }
  
  public final View getView()
  {
    AppMethodBeat.i(264613);
    View localView = this.rkp.getView();
    AppMethodBeat.o(264613);
    return localView;
  }
  
  public final boolean isLive()
  {
    AppMethodBeat.i(264614);
    boolean bool = this.rkp.isLive();
    AppMethodBeat.o(264614);
    return bool;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(264615);
    boolean bool = this.rkp.isPlaying();
    AppMethodBeat.o(264615);
    return bool;
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(264616);
    this.rkp.onUIDestroy();
    AppMethodBeat.o(264616);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(264617);
    this.rkp.onUIPause();
    AppMethodBeat.o(264617);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(264618);
    this.rkp.onUIResume();
    AppMethodBeat.o(264618);
  }
  
  public final boolean p(double paramDouble)
  {
    AppMethodBeat.i(264621);
    boolean bool = this.rkp.p(paramDouble);
    AppMethodBeat.o(264621);
    return bool;
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(264619);
    boolean bool = this.rkp.pause();
    AppMethodBeat.o(264619);
    return bool;
  }
  
  public final void setCover(Bitmap paramBitmap)
  {
    AppMethodBeat.i(264623);
    this.rkp.setCover(paramBitmap);
    AppMethodBeat.o(264623);
  }
  
  public final void setFullDirection(int paramInt)
  {
    AppMethodBeat.i(264624);
    this.rkp.setFullDirection(paramInt);
    AppMethodBeat.o(264624);
  }
  
  public final void setIMMVideoViewCallback(d.c paramc)
  {
    AppMethodBeat.i(264625);
    this.rkp.setIMMVideoViewCallback(paramc);
    AppMethodBeat.o(264625);
  }
  
  public final void setIsShowBasicControls(boolean paramBoolean)
  {
    AppMethodBeat.i(264626);
    this.rkp.setIsShowBasicControls(paramBoolean);
    AppMethodBeat.o(264626);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(264627);
    this.rkp.setMute(paramBoolean);
    AppMethodBeat.o(264627);
  }
  
  public final void setScaleType(d.h paramh)
  {
    AppMethodBeat.i(264629);
    this.rkp.setScaleType(paramh);
    AppMethodBeat.o(264629);
  }
  
  public final void setVideoFooterView(d.b paramb)
  {
    AppMethodBeat.i(264630);
    this.rkp.setVideoFooterView(paramb);
    AppMethodBeat.o(264630);
  }
  
  public final void setVideoSource(int paramInt)
  {
    AppMethodBeat.i(264632);
    this.rkp.setVideoSource(paramInt);
    AppMethodBeat.o(264632);
  }
  
  public final void start()
  {
    AppMethodBeat.i(264633);
    this.rkp.start();
    AppMethodBeat.o(264633);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(264634);
    this.rkp.stop();
    AppMethodBeat.o(264634);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ae.b.c
 * JD-Core Version:    0.7.0.1
 */