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
  private b kvr;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(194324);
    this.kvr = new b(paramContext);
    AppMethodBeat.o(194324);
  }
  
  public final boolean aXf()
  {
    AppMethodBeat.i(194336);
    boolean bool = this.kvr.aXf();
    AppMethodBeat.o(194336);
    return bool;
  }
  
  public final boolean ax(float paramFloat)
  {
    AppMethodBeat.i(194350);
    boolean bool = this.kvr.ax(paramFloat);
    AppMethodBeat.o(194350);
    return bool;
  }
  
  public final void bcc()
  {
    AppMethodBeat.i(194325);
    this.kvr.bcc();
    AppMethodBeat.o(194325);
  }
  
  public final void c(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(194338);
    this.kvr.c(paramBoolean, paramString, paramInt);
    AppMethodBeat.o(194338);
  }
  
  public final boolean c(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(194328);
    paramBoolean = this.kvr.c(paramDouble, paramBoolean);
    AppMethodBeat.o(194328);
    return paramBoolean;
  }
  
  public final int getCacheTimeSec()
  {
    AppMethodBeat.i(194334);
    int i = this.kvr.getCacheTimeSec();
    AppMethodBeat.o(194334);
    return i;
  }
  
  public final int getCurrPosMs()
  {
    AppMethodBeat.i(194332);
    int i = this.kvr.getCurrPosMs();
    AppMethodBeat.o(194332);
    return i;
  }
  
  public final int getCurrPosSec()
  {
    AppMethodBeat.i(194333);
    int i = this.kvr.getCurrPosSec();
    AppMethodBeat.o(194333);
    return i;
  }
  
  public final int getPlayerType()
  {
    AppMethodBeat.i(194326);
    int i = this.kvr.getPlayerType();
    AppMethodBeat.o(194326);
    return i;
  }
  
  public final int getVideoDurationSec()
  {
    AppMethodBeat.i(194331);
    int i = this.kvr.getVideoDurationSec();
    AppMethodBeat.o(194331);
    return i;
  }
  
  public final View getView()
  {
    return this.kvr;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(194335);
    boolean bool = this.kvr.isPlaying();
    AppMethodBeat.o(194335);
    return bool;
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(194347);
    this.kvr.onUIDestroy();
    AppMethodBeat.o(194347);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(194346);
    this.kvr.onUIPause();
    AppMethodBeat.o(194346);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(194345);
    this.kvr.onUIResume();
    AppMethodBeat.o(194345);
  }
  
  public final boolean p(double paramDouble)
  {
    AppMethodBeat.i(194327);
    boolean bool = this.kvr.p(paramDouble);
    AppMethodBeat.o(194327);
    return bool;
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(194343);
    boolean bool = this.kvr.pause();
    AppMethodBeat.o(194343);
    return bool;
  }
  
  public final void setCover(Bitmap paramBitmap)
  {
    AppMethodBeat.i(194337);
    this.kvr.setCover(paramBitmap);
    AppMethodBeat.o(194337);
  }
  
  public final void setFullDirection(int paramInt)
  {
    AppMethodBeat.i(194330);
    this.kvr.setFullDirection(paramInt);
    AppMethodBeat.o(194330);
  }
  
  public final void setIMMVideoViewCallback(e.c paramc)
  {
    AppMethodBeat.i(194349);
    this.kvr.setIMMVideoViewCallback(paramc);
    AppMethodBeat.o(194349);
  }
  
  public final void setIsShowBasicControls(boolean paramBoolean)
  {
    AppMethodBeat.i(194329);
    this.kvr.setIsShowBasicControls(paramBoolean);
    AppMethodBeat.o(194329);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(194344);
    this.kvr.setMute(paramBoolean);
    AppMethodBeat.o(194344);
  }
  
  public final void setScaleType(e.h paramh)
  {
    AppMethodBeat.i(194348);
    this.kvr.setScaleType(paramh);
    AppMethodBeat.o(194348);
  }
  
  public final void setVideoFooterView(e.b paramb)
  {
    AppMethodBeat.i(194340);
    this.kvr.setVideoFooterView(paramb);
    AppMethodBeat.o(194340);
  }
  
  public final void setVideoSource(int paramInt)
  {
    AppMethodBeat.i(194339);
    this.kvr.setVideoSource(paramInt);
    AppMethodBeat.o(194339);
  }
  
  public final void start()
  {
    AppMethodBeat.i(194341);
    this.kvr.start();
    AppMethodBeat.o(194341);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(194342);
    this.kvr.stop();
    AppMethodBeat.o(194342);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a.c
 * JD-Core Version:    0.7.0.1
 */