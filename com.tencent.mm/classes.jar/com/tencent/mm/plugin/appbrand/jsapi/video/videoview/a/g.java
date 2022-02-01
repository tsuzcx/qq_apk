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
  private e sJz;
  
  public g(Context paramContext)
  {
    AppMethodBeat.i(328901);
    this.sJz = new e(paramContext);
    AppMethodBeat.o(328901);
  }
  
  public final boolean G(double paramDouble)
  {
    AppMethodBeat.i(328921);
    boolean bool = this.sJz.G(paramDouble);
    AppMethodBeat.o(328921);
    return bool;
  }
  
  public final void b(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(328977);
    this.sJz.b(paramBoolean, paramString, paramInt);
    AppMethodBeat.o(328977);
  }
  
  public final boolean b(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(328925);
    paramBoolean = this.sJz.b(paramDouble, paramBoolean);
    AppMethodBeat.o(328925);
    return paramBoolean;
  }
  
  public final boolean bM(float paramFloat)
  {
    AppMethodBeat.i(329056);
    boolean bool = this.sJz.bM(paramFloat);
    AppMethodBeat.o(329056);
    return bool;
  }
  
  public final void cuV()
  {
    AppMethodBeat.i(328912);
    this.sJz.cuV();
    AppMethodBeat.o(328912);
  }
  
  public final int getCacheTimeSec()
  {
    AppMethodBeat.i(328956);
    int i = this.sJz.getCacheTimeSec();
    AppMethodBeat.o(328956);
    return i;
  }
  
  public final int getCurrPosMs()
  {
    AppMethodBeat.i(328947);
    int i = this.sJz.getCurrPosMs();
    AppMethodBeat.o(328947);
    return i;
  }
  
  public final int getCurrPosSec()
  {
    AppMethodBeat.i(328952);
    int i = this.sJz.getCurrPosSec();
    AppMethodBeat.o(328952);
    return i;
  }
  
  public final int getPlayerType()
  {
    AppMethodBeat.i(328918);
    int i = this.sJz.getPlayerType();
    AppMethodBeat.o(328918);
    return i;
  }
  
  public final int getVideoDurationSec()
  {
    AppMethodBeat.i(328941);
    int i = this.sJz.getVideoDurationSec();
    AppMethodBeat.o(328941);
    return i;
  }
  
  public final View getView()
  {
    return this.sJz;
  }
  
  public final boolean isLive()
  {
    AppMethodBeat.i(328966);
    boolean bool = this.sJz.isLive();
    AppMethodBeat.o(328966);
    return bool;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(328960);
    boolean bool = this.sJz.isPlaying();
    AppMethodBeat.o(328960);
    return bool;
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(329032);
    this.sJz.onUIDestroy();
    AppMethodBeat.o(329032);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(329027);
    this.sJz.onUIPause();
    AppMethodBeat.o(329027);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(329019);
    this.sJz.onUIResume();
    AppMethodBeat.o(329019);
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(329004);
    boolean bool = this.sJz.pause();
    AppMethodBeat.o(329004);
    return bool;
  }
  
  public final void setCover(Bitmap paramBitmap)
  {
    AppMethodBeat.i(328971);
    this.sJz.setCover(paramBitmap);
    AppMethodBeat.o(328971);
  }
  
  public final void setFullDirection(int paramInt)
  {
    AppMethodBeat.i(328933);
    this.sJz.setFullDirection(paramInt);
    AppMethodBeat.o(328933);
  }
  
  public final void setIMMVideoViewCallback(d.c paramc)
  {
    AppMethodBeat.i(329048);
    this.sJz.setIMMVideoViewCallback(paramc);
    AppMethodBeat.o(329048);
  }
  
  public final void setIsShowBasicControls(boolean paramBoolean)
  {
    AppMethodBeat.i(328927);
    this.sJz.setIsShowBasicControls(paramBoolean);
    AppMethodBeat.o(328927);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(329012);
    this.sJz.setMute(paramBoolean);
    AppMethodBeat.o(329012);
  }
  
  public final void setScaleType(d.h paramh)
  {
    AppMethodBeat.i(329040);
    this.sJz.setScaleType(paramh);
    AppMethodBeat.o(329040);
  }
  
  public final void setVideoFooterView(d.b paramb)
  {
    AppMethodBeat.i(328987);
    this.sJz.setVideoFooterView(paramb);
    AppMethodBeat.o(328987);
  }
  
  public final void setVideoSource(int paramInt)
  {
    AppMethodBeat.i(328982);
    this.sJz.setVideoSource(paramInt);
    AppMethodBeat.o(328982);
  }
  
  public final void start()
  {
    AppMethodBeat.i(328993);
    this.sJz.start();
    AppMethodBeat.o(328993);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(328997);
    this.sJz.stop();
    AppMethodBeat.o(328997);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a.g
 * JD-Core Version:    0.7.0.1
 */