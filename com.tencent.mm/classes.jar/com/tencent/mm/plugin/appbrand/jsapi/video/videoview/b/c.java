package com.tencent.mm.plugin.appbrand.jsapi.video.videoview.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.d;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.h;

public final class c
  implements d
{
  private b sJA;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(328885);
    this.sJA = new b(paramContext);
    AppMethodBeat.o(328885);
  }
  
  public final boolean G(double paramDouble)
  {
    AppMethodBeat.i(328902);
    boolean bool = this.sJA.G(paramDouble);
    AppMethodBeat.o(328902);
    return bool;
  }
  
  public final void b(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(328955);
    this.sJA.b(paramBoolean, paramString, paramInt);
    AppMethodBeat.o(328955);
  }
  
  public final boolean b(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(328907);
    paramBoolean = this.sJA.b(paramDouble, paramBoolean);
    AppMethodBeat.o(328907);
    return paramBoolean;
  }
  
  public final boolean bM(float paramFloat)
  {
    AppMethodBeat.i(329023);
    boolean bool = this.sJA.bM(paramFloat);
    AppMethodBeat.o(329023);
    return bool;
  }
  
  public final void cuV()
  {
    AppMethodBeat.i(328894);
    this.sJA.cuV();
    AppMethodBeat.o(328894);
  }
  
  public final int getCacheTimeSec()
  {
    AppMethodBeat.i(328934);
    int i = this.sJA.getCacheTimeSec();
    AppMethodBeat.o(328934);
    return i;
  }
  
  public final int getCurrPosMs()
  {
    AppMethodBeat.i(328926);
    int i = this.sJA.getCurrPosMs();
    AppMethodBeat.o(328926);
    return i;
  }
  
  public final int getCurrPosSec()
  {
    AppMethodBeat.i(328928);
    int i = this.sJA.getCurrPosSec();
    AppMethodBeat.o(328928);
    return i;
  }
  
  public final int getPlayerType()
  {
    AppMethodBeat.i(328899);
    int i = this.sJA.getPlayerType();
    AppMethodBeat.o(328899);
    return i;
  }
  
  public final int getVideoDurationSec()
  {
    AppMethodBeat.i(328920);
    int i = this.sJA.getVideoDurationSec();
    AppMethodBeat.o(328920);
    return i;
  }
  
  public final View getView()
  {
    return this.sJA;
  }
  
  public final boolean isLive()
  {
    AppMethodBeat.i(328948);
    boolean bool = this.sJA.isLive();
    AppMethodBeat.o(328948);
    return bool;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(328942);
    boolean bool = this.sJA.isPlaying();
    AppMethodBeat.o(328942);
    return bool;
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(328999);
    this.sJA.onUIDestroy();
    AppMethodBeat.o(328999);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(328994);
    this.sJA.onUIPause();
    AppMethodBeat.o(328994);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(328990);
    this.sJA.onUIResume();
    AppMethodBeat.o(328990);
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(328978);
    boolean bool = this.sJA.pause();
    AppMethodBeat.o(328978);
    return bool;
  }
  
  public final void setCover(Bitmap paramBitmap)
  {
    AppMethodBeat.i(328951);
    this.sJA.setCover(paramBitmap);
    AppMethodBeat.o(328951);
  }
  
  public final void setFullDirection(int paramInt)
  {
    AppMethodBeat.i(328917);
    this.sJA.setFullDirection(paramInt);
    AppMethodBeat.o(328917);
  }
  
  public final void setIMMVideoViewCallback(d.c paramc)
  {
    AppMethodBeat.i(329015);
    this.sJA.setIMMVideoViewCallback(paramc);
    AppMethodBeat.o(329015);
  }
  
  public final void setIsShowBasicControls(boolean paramBoolean)
  {
    AppMethodBeat.i(328911);
    this.sJA.setIsShowBasicControls(paramBoolean);
    AppMethodBeat.o(328911);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(328983);
    this.sJA.setMute(paramBoolean);
    AppMethodBeat.o(328983);
  }
  
  public final void setScaleType(d.h paramh)
  {
    AppMethodBeat.i(329006);
    this.sJA.setScaleType(paramh);
    AppMethodBeat.o(329006);
  }
  
  public final void setVideoFooterView(d.b paramb)
  {
    AppMethodBeat.i(328964);
    this.sJA.setVideoFooterView(paramb);
    AppMethodBeat.o(328964);
  }
  
  public final void setVideoSource(int paramInt)
  {
    AppMethodBeat.i(328959);
    this.sJA.setVideoSource(paramInt);
    AppMethodBeat.o(328959);
  }
  
  public final void start()
  {
    AppMethodBeat.i(328969);
    this.sJA.start();
    AppMethodBeat.o(328969);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(328974);
    this.sJA.stop();
    AppMethodBeat.o(328974);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.videoview.b.c
 * JD-Core Version:    0.7.0.1
 */