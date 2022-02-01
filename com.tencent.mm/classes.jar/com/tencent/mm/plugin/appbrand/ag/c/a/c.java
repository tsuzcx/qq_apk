package com.tencent.mm.plugin.appbrand.ag.c.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.d;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.h;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/video/thumb/widget/AppBrandThumbVideoViewWrapper;", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView;", "context", "Landroid/content/Context;", "thumbVideoView", "Lcom/tencent/mm/plugin/appbrand/video/thumb/widget/AppBrandThumbVideoView;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/video/thumb/widget/AppBrandThumbVideoView;)V", "getCacheTimeSec", "", "getCurrPosMs", "getCurrPosSec", "getPlayerType", "getVideoDurationSec", "getView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "isLive", "", "isPlaying", "onSingleTap", "onUIDestroy", "", "onUIPause", "onUIResume", "pause", "play", "preloadVideo", "removeVideoFooterView", "seekTo", "p0", "", "p1", "setCover", "Landroid/graphics/Bitmap;", "setFullDirection", "setIMMVideoViewCallback", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView$IMMVideoViewCallback;", "setIsShowBasicControls", "setMute", "setPlayRate", "", "setScaleType", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView$ScaleType;", "setVideoFooterView", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView$IMMVideoFooter;", "setVideoPath", "", "p2", "setVideoSource", "start", "stop", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  implements d
{
  public c(Context paramContext, byte paramByte)
  {
    this(paramContext);
    AppMethodBeat.i(317939);
    AppMethodBeat.o(317939);
  }
  
  private c(Context paramContext, b paramb)
  {
    AppMethodBeat.i(317920);
    this.utY = paramb;
    AppMethodBeat.o(317920);
  }
  
  public final boolean G(double paramDouble)
  {
    AppMethodBeat.i(318022);
    boolean bool = this.utY.G(paramDouble);
    AppMethodBeat.o(318022);
    return bool;
  }
  
  public final void b(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(318090);
    this.utY.b(paramBoolean, paramString, paramInt);
    AppMethodBeat.o(318090);
  }
  
  public final boolean b(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(318028);
    paramBoolean = this.utY.b(paramDouble, paramBoolean);
    AppMethodBeat.o(318028);
    return paramBoolean;
  }
  
  public final boolean bM(float paramFloat)
  {
    AppMethodBeat.i(318069);
    boolean bool = this.utY.bM(paramFloat);
    AppMethodBeat.o(318069);
    return bool;
  }
  
  public final void cuV()
  {
    AppMethodBeat.i(318015);
    this.utY.cuV();
    AppMethodBeat.o(318015);
  }
  
  public final int getCacheTimeSec()
  {
    AppMethodBeat.i(317943);
    int i = this.utY.getCacheTimeSec();
    AppMethodBeat.o(317943);
    return i;
  }
  
  public final int getCurrPosMs()
  {
    AppMethodBeat.i(317950);
    int i = this.utY.getCurrPosMs();
    AppMethodBeat.o(317950);
    return i;
  }
  
  public final int getCurrPosSec()
  {
    AppMethodBeat.i(317958);
    int i = this.utY.getCurrPosSec();
    AppMethodBeat.o(317958);
    return i;
  }
  
  public final int getPlayerType()
  {
    AppMethodBeat.i(317964);
    int i = this.utY.getPlayerType();
    AppMethodBeat.o(317964);
    return i;
  }
  
  public final int getVideoDurationSec()
  {
    AppMethodBeat.i(317970);
    int i = this.utY.getVideoDurationSec();
    AppMethodBeat.o(317970);
    return i;
  }
  
  public final View getView()
  {
    AppMethodBeat.i(317975);
    View localView = this.utY.getView();
    AppMethodBeat.o(317975);
    return localView;
  }
  
  public final boolean isLive()
  {
    AppMethodBeat.i(317984);
    boolean bool = this.utY.isLive();
    AppMethodBeat.o(317984);
    return bool;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(317990);
    boolean bool = this.utY.isPlaying();
    AppMethodBeat.o(317990);
    return bool;
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(317995);
    this.utY.onUIDestroy();
    AppMethodBeat.o(317995);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(317998);
    this.utY.onUIPause();
    AppMethodBeat.o(317998);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(318005);
    this.utY.onUIResume();
    AppMethodBeat.o(318005);
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(318009);
    boolean bool = this.utY.pause();
    AppMethodBeat.o(318009);
    return bool;
  }
  
  public final void setCover(Bitmap paramBitmap)
  {
    AppMethodBeat.i(318033);
    this.utY.setCover(paramBitmap);
    AppMethodBeat.o(318033);
  }
  
  public final void setFullDirection(int paramInt)
  {
    AppMethodBeat.i(318039);
    this.utY.setFullDirection(paramInt);
    AppMethodBeat.o(318039);
  }
  
  public final void setIMMVideoViewCallback(d.c paramc)
  {
    AppMethodBeat.i(318046);
    this.utY.setIMMVideoViewCallback(paramc);
    AppMethodBeat.o(318046);
  }
  
  public final void setIsShowBasicControls(boolean paramBoolean)
  {
    AppMethodBeat.i(318054);
    this.utY.setIsShowBasicControls(paramBoolean);
    AppMethodBeat.o(318054);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(318062);
    this.utY.setMute(paramBoolean);
    AppMethodBeat.o(318062);
  }
  
  public final void setScaleType(d.h paramh)
  {
    AppMethodBeat.i(318076);
    this.utY.setScaleType(paramh);
    AppMethodBeat.o(318076);
  }
  
  public final void setVideoFooterView(d.b paramb)
  {
    AppMethodBeat.i(318083);
    this.utY.setVideoFooterView(paramb);
    AppMethodBeat.o(318083);
  }
  
  public final void setVideoSource(int paramInt)
  {
    AppMethodBeat.i(318097);
    this.utY.setVideoSource(paramInt);
    AppMethodBeat.o(318097);
  }
  
  public final void start()
  {
    AppMethodBeat.i(318103);
    this.utY.start();
    AppMethodBeat.o(318103);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(318108);
    this.utY.stop();
    AppMethodBeat.o(318108);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ag.c.a.c
 * JD-Core Version:    0.7.0.1
 */