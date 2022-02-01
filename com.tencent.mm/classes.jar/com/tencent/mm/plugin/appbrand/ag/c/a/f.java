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

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/video/thumb/widget/ThumbVideoViewWrapper;", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView;", "context", "Landroid/content/Context;", "mp4Only", "", "thumbVideoView", "Lcom/tencent/mm/plugin/appbrand/video/thumb/widget/ThumbVideoView;", "(Landroid/content/Context;ZLcom/tencent/mm/plugin/appbrand/video/thumb/widget/ThumbVideoView;)V", "getCacheTimeSec", "", "getCurrPosMs", "getCurrPosSec", "getPlayerType", "getVideoDurationSec", "getView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "isLive", "isPlaying", "onSingleTap", "onUIDestroy", "", "onUIPause", "onUIResume", "pause", "play", "preloadVideo", "removeVideoFooterView", "seekTo", "p0", "", "p1", "setCover", "Landroid/graphics/Bitmap;", "setFullDirection", "setIMMVideoViewCallback", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView$IMMVideoViewCallback;", "setIsShowBasicControls", "setMute", "setPlayRate", "", "setScaleType", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView$ScaleType;", "setVideoFooterView", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView$IMMVideoFooter;", "setVideoPath", "", "p2", "setVideoSource", "start", "stop", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  implements d
{
  public f(Context paramContext, byte paramByte)
  {
    this(paramContext);
    AppMethodBeat.i(317941);
    AppMethodBeat.o(317941);
  }
  
  private f(Context paramContext, e parame)
  {
    AppMethodBeat.i(317931);
    this.utZ = parame;
    AppMethodBeat.o(317931);
  }
  
  public final boolean G(double paramDouble)
  {
    AppMethodBeat.i(318025);
    boolean bool = this.utZ.G(paramDouble);
    AppMethodBeat.o(318025);
    return bool;
  }
  
  public final void b(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(318096);
    this.utZ.b(paramBoolean, paramString, paramInt);
    AppMethodBeat.o(318096);
  }
  
  public final boolean b(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(318032);
    paramBoolean = this.utZ.b(paramDouble, paramBoolean);
    AppMethodBeat.o(318032);
    return paramBoolean;
  }
  
  public final boolean bM(float paramFloat)
  {
    AppMethodBeat.i(318074);
    boolean bool = this.utZ.bM(paramFloat);
    AppMethodBeat.o(318074);
    return bool;
  }
  
  public final void cuV()
  {
    AppMethodBeat.i(318019);
    this.utZ.cuV();
    AppMethodBeat.o(318019);
  }
  
  public final int getCacheTimeSec()
  {
    AppMethodBeat.i(317946);
    int i = this.utZ.getCacheTimeSec();
    AppMethodBeat.o(317946);
    return i;
  }
  
  public final int getCurrPosMs()
  {
    AppMethodBeat.i(317957);
    int i = this.utZ.getCurrPosMs();
    AppMethodBeat.o(317957);
    return i;
  }
  
  public final int getCurrPosSec()
  {
    AppMethodBeat.i(317963);
    int i = this.utZ.getCurrPosSec();
    AppMethodBeat.o(317963);
    return i;
  }
  
  public final int getPlayerType()
  {
    AppMethodBeat.i(317969);
    int i = this.utZ.getPlayerType();
    AppMethodBeat.o(317969);
    return i;
  }
  
  public final int getVideoDurationSec()
  {
    AppMethodBeat.i(317973);
    int i = this.utZ.getVideoDurationSec();
    AppMethodBeat.o(317973);
    return i;
  }
  
  public final View getView()
  {
    AppMethodBeat.i(317982);
    View localView = this.utZ.getView();
    AppMethodBeat.o(317982);
    return localView;
  }
  
  public final boolean isLive()
  {
    AppMethodBeat.i(317989);
    boolean bool = this.utZ.isLive();
    AppMethodBeat.o(317989);
    return bool;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(317994);
    boolean bool = this.utZ.isPlaying();
    AppMethodBeat.o(317994);
    return bool;
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(317997);
    this.utZ.onUIDestroy();
    AppMethodBeat.o(317997);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(318003);
    this.utZ.onUIPause();
    AppMethodBeat.o(318003);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(318008);
    this.utZ.onUIResume();
    AppMethodBeat.o(318008);
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(318013);
    boolean bool = this.utZ.pause();
    AppMethodBeat.o(318013);
    return bool;
  }
  
  public final void setCover(Bitmap paramBitmap)
  {
    AppMethodBeat.i(318038);
    this.utZ.setCover(paramBitmap);
    AppMethodBeat.o(318038);
  }
  
  public final void setFullDirection(int paramInt)
  {
    AppMethodBeat.i(318043);
    this.utZ.setFullDirection(paramInt);
    AppMethodBeat.o(318043);
  }
  
  public final void setIMMVideoViewCallback(d.c paramc)
  {
    AppMethodBeat.i(318052);
    this.utZ.setIMMVideoViewCallback(paramc);
    AppMethodBeat.o(318052);
  }
  
  public final void setIsShowBasicControls(boolean paramBoolean)
  {
    AppMethodBeat.i(318060);
    this.utZ.setIsShowBasicControls(paramBoolean);
    AppMethodBeat.o(318060);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(318066);
    this.utZ.setMute(paramBoolean);
    AppMethodBeat.o(318066);
  }
  
  public final void setScaleType(d.h paramh)
  {
    AppMethodBeat.i(318081);
    this.utZ.setScaleType(paramh);
    AppMethodBeat.o(318081);
  }
  
  public final void setVideoFooterView(d.b paramb)
  {
    AppMethodBeat.i(318087);
    this.utZ.setVideoFooterView(paramb);
    AppMethodBeat.o(318087);
  }
  
  public final void setVideoSource(int paramInt)
  {
    AppMethodBeat.i(318102);
    this.utZ.setVideoSource(paramInt);
    AppMethodBeat.o(318102);
  }
  
  public final void start()
  {
    AppMethodBeat.i(318106);
    this.utZ.start();
    AppMethodBeat.o(318106);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(318113);
    this.utZ.stop();
    AppMethodBeat.o(318113);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ag.c.a.f
 * JD-Core Version:    0.7.0.1
 */