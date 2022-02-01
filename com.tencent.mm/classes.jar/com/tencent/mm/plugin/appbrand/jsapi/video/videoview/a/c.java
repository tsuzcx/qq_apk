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
  private b ltE;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(206483);
    this.ltE = new b(paramContext);
    AppMethodBeat.o(206483);
  }
  
  public final boolean aE(float paramFloat)
  {
    AppMethodBeat.i(206509);
    boolean bool = this.ltE.aE(paramFloat);
    AppMethodBeat.o(206509);
    return bool;
  }
  
  public final boolean bhH()
  {
    AppMethodBeat.i(206495);
    boolean bool = this.ltE.bhH();
    AppMethodBeat.o(206495);
    return bool;
  }
  
  public final void bmJ()
  {
    AppMethodBeat.i(206484);
    this.ltE.bmJ();
    AppMethodBeat.o(206484);
  }
  
  public final void c(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(206497);
    this.ltE.c(paramBoolean, paramString, paramInt);
    AppMethodBeat.o(206497);
  }
  
  public final boolean c(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(206487);
    paramBoolean = this.ltE.c(paramDouble, paramBoolean);
    AppMethodBeat.o(206487);
    return paramBoolean;
  }
  
  public final int getCacheTimeSec()
  {
    AppMethodBeat.i(206493);
    int i = this.ltE.getCacheTimeSec();
    AppMethodBeat.o(206493);
    return i;
  }
  
  public final int getCurrPosMs()
  {
    AppMethodBeat.i(206491);
    int i = this.ltE.getCurrPosMs();
    AppMethodBeat.o(206491);
    return i;
  }
  
  public final int getCurrPosSec()
  {
    AppMethodBeat.i(206492);
    int i = this.ltE.getCurrPosSec();
    AppMethodBeat.o(206492);
    return i;
  }
  
  public final int getPlayerType()
  {
    AppMethodBeat.i(206485);
    int i = this.ltE.getPlayerType();
    AppMethodBeat.o(206485);
    return i;
  }
  
  public final int getVideoDurationSec()
  {
    AppMethodBeat.i(206490);
    int i = this.ltE.getVideoDurationSec();
    AppMethodBeat.o(206490);
    return i;
  }
  
  public final View getView()
  {
    return this.ltE;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(206494);
    boolean bool = this.ltE.isPlaying();
    AppMethodBeat.o(206494);
    return bool;
  }
  
  public final boolean o(double paramDouble)
  {
    AppMethodBeat.i(206486);
    boolean bool = this.ltE.o(paramDouble);
    AppMethodBeat.o(206486);
    return bool;
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(206506);
    this.ltE.onUIDestroy();
    AppMethodBeat.o(206506);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(206505);
    this.ltE.onUIPause();
    AppMethodBeat.o(206505);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(206504);
    this.ltE.onUIResume();
    AppMethodBeat.o(206504);
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(206502);
    boolean bool = this.ltE.pause();
    AppMethodBeat.o(206502);
    return bool;
  }
  
  public final void setCover(Bitmap paramBitmap)
  {
    AppMethodBeat.i(206496);
    this.ltE.setCover(paramBitmap);
    AppMethodBeat.o(206496);
  }
  
  public final void setFullDirection(int paramInt)
  {
    AppMethodBeat.i(206489);
    this.ltE.setFullDirection(paramInt);
    AppMethodBeat.o(206489);
  }
  
  public final void setIMMVideoViewCallback(e.c paramc)
  {
    AppMethodBeat.i(206508);
    this.ltE.setIMMVideoViewCallback(paramc);
    AppMethodBeat.o(206508);
  }
  
  public final void setIsShowBasicControls(boolean paramBoolean)
  {
    AppMethodBeat.i(206488);
    this.ltE.setIsShowBasicControls(paramBoolean);
    AppMethodBeat.o(206488);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(206503);
    this.ltE.setMute(paramBoolean);
    AppMethodBeat.o(206503);
  }
  
  public final void setScaleType(e.h paramh)
  {
    AppMethodBeat.i(206507);
    this.ltE.setScaleType(paramh);
    AppMethodBeat.o(206507);
  }
  
  public final void setVideoFooterView(e.b paramb)
  {
    AppMethodBeat.i(206499);
    this.ltE.setVideoFooterView(paramb);
    AppMethodBeat.o(206499);
  }
  
  public final void setVideoSource(int paramInt)
  {
    AppMethodBeat.i(206498);
    this.ltE.setVideoSource(paramInt);
    AppMethodBeat.o(206498);
  }
  
  public final void start()
  {
    AppMethodBeat.i(206500);
    this.ltE.start();
    AppMethodBeat.o(206500);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(206501);
    this.ltE.stop();
    AppMethodBeat.o(206501);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a.c
 * JD-Core Version:    0.7.0.1
 */