package com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.d;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.h;

public final class g
  implements d
{
  private e pEo;
  
  public g(Context paramContext)
  {
    AppMethodBeat.i(227770);
    this.pEo = new e(paramContext);
    AppMethodBeat.o(227770);
  }
  
  public final boolean a(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(227781);
    paramBoolean = this.pEo.a(paramDouble, paramBoolean);
    AppMethodBeat.o(227781);
    return paramBoolean;
  }
  
  public final boolean aO(float paramFloat)
  {
    AppMethodBeat.i(227822);
    boolean bool = this.pEo.aO(paramFloat);
    AppMethodBeat.o(227822);
    return bool;
  }
  
  public final void bUF()
  {
    AppMethodBeat.i(227774);
    this.pEo.bUF();
    AppMethodBeat.o(227774);
  }
  
  public final void c(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(227800);
    this.pEo.c(paramBoolean, paramString, paramInt);
    AppMethodBeat.o(227800);
  }
  
  public final int getCacheTimeSec()
  {
    AppMethodBeat.i(227794);
    int i = this.pEo.getCacheTimeSec();
    AppMethodBeat.o(227794);
    return i;
  }
  
  public final int getCurrPosMs()
  {
    AppMethodBeat.i(227791);
    int i = this.pEo.getCurrPosMs();
    AppMethodBeat.o(227791);
    return i;
  }
  
  public final int getCurrPosSec()
  {
    AppMethodBeat.i(227793);
    int i = this.pEo.getCurrPosSec();
    AppMethodBeat.o(227793);
    return i;
  }
  
  public final int getPlayerType()
  {
    AppMethodBeat.i(227777);
    int i = this.pEo.getPlayerType();
    AppMethodBeat.o(227777);
    return i;
  }
  
  public final int getVideoDurationSec()
  {
    AppMethodBeat.i(227788);
    int i = this.pEo.getVideoDurationSec();
    AppMethodBeat.o(227788);
    return i;
  }
  
  public final View getView()
  {
    return this.pEo;
  }
  
  public final boolean isLive()
  {
    AppMethodBeat.i(227798);
    boolean bool = this.pEo.isLive();
    AppMethodBeat.o(227798);
    return bool;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(227797);
    boolean bool = this.pEo.isPlaying();
    AppMethodBeat.o(227797);
    return bool;
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(227817);
    this.pEo.onUIDestroy();
    AppMethodBeat.o(227817);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(227815);
    this.pEo.onUIPause();
    AppMethodBeat.o(227815);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(227813);
    this.pEo.onUIResume();
    AppMethodBeat.o(227813);
  }
  
  public final boolean p(double paramDouble)
  {
    AppMethodBeat.i(227779);
    boolean bool = this.pEo.p(paramDouble);
    AppMethodBeat.o(227779);
    return bool;
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(227810);
    boolean bool = this.pEo.pause();
    AppMethodBeat.o(227810);
    return bool;
  }
  
  public final void setCover(Bitmap paramBitmap)
  {
    AppMethodBeat.i(227799);
    this.pEo.setCover(paramBitmap);
    AppMethodBeat.o(227799);
  }
  
  public final void setFullDirection(int paramInt)
  {
    AppMethodBeat.i(227785);
    this.pEo.setFullDirection(paramInt);
    AppMethodBeat.o(227785);
  }
  
  public final void setIMMVideoViewCallback(d.c paramc)
  {
    AppMethodBeat.i(227821);
    this.pEo.setIMMVideoViewCallback(paramc);
    AppMethodBeat.o(227821);
  }
  
  public final void setIsShowBasicControls(boolean paramBoolean)
  {
    AppMethodBeat.i(227782);
    this.pEo.setIsShowBasicControls(paramBoolean);
    AppMethodBeat.o(227782);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(227811);
    this.pEo.setMute(paramBoolean);
    AppMethodBeat.o(227811);
  }
  
  public final void setScaleType(d.h paramh)
  {
    AppMethodBeat.i(227818);
    this.pEo.setScaleType(paramh);
    AppMethodBeat.o(227818);
  }
  
  public final void setVideoFooterView(d.b paramb)
  {
    AppMethodBeat.i(227805);
    this.pEo.setVideoFooterView(paramb);
    AppMethodBeat.o(227805);
  }
  
  public final void setVideoSource(int paramInt)
  {
    AppMethodBeat.i(227802);
    this.pEo.setVideoSource(paramInt);
    AppMethodBeat.o(227802);
  }
  
  public final void start()
  {
    AppMethodBeat.i(227807);
    this.pEo.start();
    AppMethodBeat.o(227807);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(227809);
    this.pEo.stop();
    AppMethodBeat.o(227809);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a.g
 * JD-Core Version:    0.7.0.1
 */