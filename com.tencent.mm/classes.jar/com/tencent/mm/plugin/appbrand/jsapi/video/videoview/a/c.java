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
  private b lyd;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(211513);
    this.lyd = new b(paramContext);
    AppMethodBeat.o(211513);
  }
  
  public final boolean aE(float paramFloat)
  {
    AppMethodBeat.i(211539);
    boolean bool = this.lyd.aE(paramFloat);
    AppMethodBeat.o(211539);
    return bool;
  }
  
  public final boolean bip()
  {
    AppMethodBeat.i(211525);
    boolean bool = this.lyd.bip();
    AppMethodBeat.o(211525);
    return bool;
  }
  
  public final void bns()
  {
    AppMethodBeat.i(211514);
    this.lyd.bns();
    AppMethodBeat.o(211514);
  }
  
  public final void c(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(211527);
    this.lyd.c(paramBoolean, paramString, paramInt);
    AppMethodBeat.o(211527);
  }
  
  public final boolean c(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(211517);
    paramBoolean = this.lyd.c(paramDouble, paramBoolean);
    AppMethodBeat.o(211517);
    return paramBoolean;
  }
  
  public final int getCacheTimeSec()
  {
    AppMethodBeat.i(211523);
    int i = this.lyd.getCacheTimeSec();
    AppMethodBeat.o(211523);
    return i;
  }
  
  public final int getCurrPosMs()
  {
    AppMethodBeat.i(211521);
    int i = this.lyd.getCurrPosMs();
    AppMethodBeat.o(211521);
    return i;
  }
  
  public final int getCurrPosSec()
  {
    AppMethodBeat.i(211522);
    int i = this.lyd.getCurrPosSec();
    AppMethodBeat.o(211522);
    return i;
  }
  
  public final int getPlayerType()
  {
    AppMethodBeat.i(211515);
    int i = this.lyd.getPlayerType();
    AppMethodBeat.o(211515);
    return i;
  }
  
  public final int getVideoDurationSec()
  {
    AppMethodBeat.i(211520);
    int i = this.lyd.getVideoDurationSec();
    AppMethodBeat.o(211520);
    return i;
  }
  
  public final View getView()
  {
    return this.lyd;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(211524);
    boolean bool = this.lyd.isPlaying();
    AppMethodBeat.o(211524);
    return bool;
  }
  
  public final boolean o(double paramDouble)
  {
    AppMethodBeat.i(211516);
    boolean bool = this.lyd.o(paramDouble);
    AppMethodBeat.o(211516);
    return bool;
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(211536);
    this.lyd.onUIDestroy();
    AppMethodBeat.o(211536);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(211535);
    this.lyd.onUIPause();
    AppMethodBeat.o(211535);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(211534);
    this.lyd.onUIResume();
    AppMethodBeat.o(211534);
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(211532);
    boolean bool = this.lyd.pause();
    AppMethodBeat.o(211532);
    return bool;
  }
  
  public final void setCover(Bitmap paramBitmap)
  {
    AppMethodBeat.i(211526);
    this.lyd.setCover(paramBitmap);
    AppMethodBeat.o(211526);
  }
  
  public final void setFullDirection(int paramInt)
  {
    AppMethodBeat.i(211519);
    this.lyd.setFullDirection(paramInt);
    AppMethodBeat.o(211519);
  }
  
  public final void setIMMVideoViewCallback(e.c paramc)
  {
    AppMethodBeat.i(211538);
    this.lyd.setIMMVideoViewCallback(paramc);
    AppMethodBeat.o(211538);
  }
  
  public final void setIsShowBasicControls(boolean paramBoolean)
  {
    AppMethodBeat.i(211518);
    this.lyd.setIsShowBasicControls(paramBoolean);
    AppMethodBeat.o(211518);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(211533);
    this.lyd.setMute(paramBoolean);
    AppMethodBeat.o(211533);
  }
  
  public final void setScaleType(e.h paramh)
  {
    AppMethodBeat.i(211537);
    this.lyd.setScaleType(paramh);
    AppMethodBeat.o(211537);
  }
  
  public final void setVideoFooterView(e.b paramb)
  {
    AppMethodBeat.i(211529);
    this.lyd.setVideoFooterView(paramb);
    AppMethodBeat.o(211529);
  }
  
  public final void setVideoSource(int paramInt)
  {
    AppMethodBeat.i(211528);
    this.lyd.setVideoSource(paramInt);
    AppMethodBeat.o(211528);
  }
  
  public final void start()
  {
    AppMethodBeat.i(211530);
    this.lyd.start();
    AppMethodBeat.o(211530);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(211531);
    this.lyd.stop();
    AppMethodBeat.o(211531);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a.c
 * JD-Core Version:    0.7.0.1
 */