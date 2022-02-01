package com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.h;

public final class g
  implements com.tencent.mm.plugin.appbrand.jsapi.video.e
{
  private e mFc;
  
  public g(Context paramContext)
  {
    AppMethodBeat.i(235192);
    this.mFc = new e(paramContext);
    AppMethodBeat.o(235192);
  }
  
  public final boolean aO(float paramFloat)
  {
    AppMethodBeat.i(235218);
    boolean bool = this.mFc.aO(paramFloat);
    AppMethodBeat.o(235218);
    return bool;
  }
  
  public final void bIW()
  {
    AppMethodBeat.i(235193);
    this.mFc.bIW();
    AppMethodBeat.o(235193);
  }
  
  public final void c(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(235206);
    this.mFc.c(paramBoolean, paramString, paramInt);
    AppMethodBeat.o(235206);
  }
  
  public final boolean c(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(235196);
    paramBoolean = this.mFc.c(paramDouble, paramBoolean);
    AppMethodBeat.o(235196);
    return paramBoolean;
  }
  
  public final int getCacheTimeSec()
  {
    AppMethodBeat.i(235202);
    int i = this.mFc.getCacheTimeSec();
    AppMethodBeat.o(235202);
    return i;
  }
  
  public final int getCurrPosMs()
  {
    AppMethodBeat.i(235200);
    int i = this.mFc.getCurrPosMs();
    AppMethodBeat.o(235200);
    return i;
  }
  
  public final int getCurrPosSec()
  {
    AppMethodBeat.i(235201);
    int i = this.mFc.getCurrPosSec();
    AppMethodBeat.o(235201);
    return i;
  }
  
  public final int getPlayerType()
  {
    AppMethodBeat.i(235194);
    int i = this.mFc.getPlayerType();
    AppMethodBeat.o(235194);
    return i;
  }
  
  public final int getVideoDurationSec()
  {
    AppMethodBeat.i(235199);
    int i = this.mFc.getVideoDurationSec();
    AppMethodBeat.o(235199);
    return i;
  }
  
  public final View getView()
  {
    return this.mFc;
  }
  
  public final boolean isLive()
  {
    AppMethodBeat.i(235204);
    boolean bool = this.mFc.isLive();
    AppMethodBeat.o(235204);
    return bool;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(235203);
    boolean bool = this.mFc.isPlaying();
    AppMethodBeat.o(235203);
    return bool;
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(235215);
    this.mFc.onUIDestroy();
    AppMethodBeat.o(235215);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(235214);
    this.mFc.onUIPause();
    AppMethodBeat.o(235214);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(235213);
    this.mFc.onUIResume();
    AppMethodBeat.o(235213);
  }
  
  public final boolean p(double paramDouble)
  {
    AppMethodBeat.i(235195);
    boolean bool = this.mFc.p(paramDouble);
    AppMethodBeat.o(235195);
    return bool;
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(235211);
    boolean bool = this.mFc.pause();
    AppMethodBeat.o(235211);
    return bool;
  }
  
  public final void setCover(Bitmap paramBitmap)
  {
    AppMethodBeat.i(235205);
    this.mFc.setCover(paramBitmap);
    AppMethodBeat.o(235205);
  }
  
  public final void setFullDirection(int paramInt)
  {
    AppMethodBeat.i(235198);
    this.mFc.setFullDirection(paramInt);
    AppMethodBeat.o(235198);
  }
  
  public final void setIMMVideoViewCallback(e.c paramc)
  {
    AppMethodBeat.i(235217);
    this.mFc.setIMMVideoViewCallback(paramc);
    AppMethodBeat.o(235217);
  }
  
  public final void setIsShowBasicControls(boolean paramBoolean)
  {
    AppMethodBeat.i(235197);
    this.mFc.setIsShowBasicControls(paramBoolean);
    AppMethodBeat.o(235197);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(235212);
    this.mFc.setMute(paramBoolean);
    AppMethodBeat.o(235212);
  }
  
  public final void setScaleType(e.h paramh)
  {
    AppMethodBeat.i(235216);
    this.mFc.setScaleType(paramh);
    AppMethodBeat.o(235216);
  }
  
  public final void setVideoFooterView(e.b paramb)
  {
    AppMethodBeat.i(235208);
    this.mFc.setVideoFooterView(paramb);
    AppMethodBeat.o(235208);
  }
  
  public final void setVideoSource(int paramInt)
  {
    AppMethodBeat.i(235207);
    this.mFc.setVideoSource(paramInt);
    AppMethodBeat.o(235207);
  }
  
  public final void start()
  {
    AppMethodBeat.i(235209);
    this.mFc.start();
    AppMethodBeat.o(235209);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(235210);
    this.mFc.stop();
    AppMethodBeat.o(235210);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a.g
 * JD-Core Version:    0.7.0.1
 */