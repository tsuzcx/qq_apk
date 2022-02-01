package com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.h;

public final class c
  implements e
{
  private b kWF;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(194669);
    this.kWF = new b(paramContext);
    AppMethodBeat.o(194669);
  }
  
  public final boolean aB(float paramFloat)
  {
    AppMethodBeat.i(194695);
    boolean bool = this.kWF.aB(paramFloat);
    AppMethodBeat.o(194695);
    return bool;
  }
  
  public final boolean bed()
  {
    AppMethodBeat.i(194681);
    boolean bool = this.kWF.bed();
    AppMethodBeat.o(194681);
    return bool;
  }
  
  public final void biX()
  {
    AppMethodBeat.i(194670);
    this.kWF.biX();
    AppMethodBeat.o(194670);
  }
  
  public final void c(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(194683);
    this.kWF.c(paramBoolean, paramString, paramInt);
    AppMethodBeat.o(194683);
  }
  
  public final boolean c(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(194673);
    paramBoolean = this.kWF.c(paramDouble, paramBoolean);
    AppMethodBeat.o(194673);
    return paramBoolean;
  }
  
  public final int getCacheTimeSec()
  {
    AppMethodBeat.i(194679);
    int i = this.kWF.getCacheTimeSec();
    AppMethodBeat.o(194679);
    return i;
  }
  
  public final int getCurrPosMs()
  {
    AppMethodBeat.i(194677);
    int i = this.kWF.getCurrPosMs();
    AppMethodBeat.o(194677);
    return i;
  }
  
  public final int getCurrPosSec()
  {
    AppMethodBeat.i(194678);
    int i = this.kWF.getCurrPosSec();
    AppMethodBeat.o(194678);
    return i;
  }
  
  public final int getPlayerType()
  {
    AppMethodBeat.i(194671);
    int i = this.kWF.getPlayerType();
    AppMethodBeat.o(194671);
    return i;
  }
  
  public final int getVideoDurationSec()
  {
    AppMethodBeat.i(194676);
    int i = this.kWF.getVideoDurationSec();
    AppMethodBeat.o(194676);
    return i;
  }
  
  public final View getView()
  {
    return this.kWF;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(194680);
    boolean bool = this.kWF.isPlaying();
    AppMethodBeat.o(194680);
    return bool;
  }
  
  public final boolean o(double paramDouble)
  {
    AppMethodBeat.i(194672);
    boolean bool = this.kWF.o(paramDouble);
    AppMethodBeat.o(194672);
    return bool;
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(194692);
    this.kWF.onUIDestroy();
    AppMethodBeat.o(194692);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(194691);
    this.kWF.onUIPause();
    AppMethodBeat.o(194691);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(194690);
    this.kWF.onUIResume();
    AppMethodBeat.o(194690);
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(194688);
    boolean bool = this.kWF.pause();
    AppMethodBeat.o(194688);
    return bool;
  }
  
  public final void setCover(Bitmap paramBitmap)
  {
    AppMethodBeat.i(194682);
    this.kWF.setCover(paramBitmap);
    AppMethodBeat.o(194682);
  }
  
  public final void setFullDirection(int paramInt)
  {
    AppMethodBeat.i(194675);
    this.kWF.setFullDirection(paramInt);
    AppMethodBeat.o(194675);
  }
  
  public final void setIMMVideoViewCallback(e.c paramc)
  {
    AppMethodBeat.i(194694);
    this.kWF.setIMMVideoViewCallback(paramc);
    AppMethodBeat.o(194694);
  }
  
  public final void setIsShowBasicControls(boolean paramBoolean)
  {
    AppMethodBeat.i(194674);
    this.kWF.setIsShowBasicControls(paramBoolean);
    AppMethodBeat.o(194674);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(194689);
    this.kWF.setMute(paramBoolean);
    AppMethodBeat.o(194689);
  }
  
  public final void setScaleType(e.h paramh)
  {
    AppMethodBeat.i(194693);
    this.kWF.setScaleType(paramh);
    AppMethodBeat.o(194693);
  }
  
  public final void setVideoFooterView(e.b paramb)
  {
    AppMethodBeat.i(194685);
    this.kWF.setVideoFooterView(paramb);
    AppMethodBeat.o(194685);
  }
  
  public final void setVideoSource(int paramInt)
  {
    AppMethodBeat.i(194684);
    this.kWF.setVideoSource(paramInt);
    AppMethodBeat.o(194684);
  }
  
  public final void start()
  {
    AppMethodBeat.i(194686);
    this.kWF.start();
    AppMethodBeat.o(194686);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(194687);
    this.kWF.stop();
    AppMethodBeat.o(194687);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a.c
 * JD-Core Version:    0.7.0.1
 */