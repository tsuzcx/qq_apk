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
  private b pEp;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(227949);
    this.pEp = new b(paramContext);
    AppMethodBeat.o(227949);
  }
  
  public final boolean a(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(227956);
    paramBoolean = this.pEp.a(paramDouble, paramBoolean);
    AppMethodBeat.o(227956);
    return paramBoolean;
  }
  
  public final boolean aO(float paramFloat)
  {
    AppMethodBeat.i(227998);
    boolean bool = this.pEp.aO(paramFloat);
    AppMethodBeat.o(227998);
    return bool;
  }
  
  public final void bUF()
  {
    AppMethodBeat.i(227950);
    this.pEp.bUF();
    AppMethodBeat.o(227950);
  }
  
  public final void c(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(227972);
    this.pEp.c(paramBoolean, paramString, paramInt);
    AppMethodBeat.o(227972);
  }
  
  public final int getCacheTimeSec()
  {
    AppMethodBeat.i(227965);
    int i = this.pEp.getCacheTimeSec();
    AppMethodBeat.o(227965);
    return i;
  }
  
  public final int getCurrPosMs()
  {
    AppMethodBeat.i(227963);
    int i = this.pEp.getCurrPosMs();
    AppMethodBeat.o(227963);
    return i;
  }
  
  public final int getCurrPosSec()
  {
    AppMethodBeat.i(227964);
    int i = this.pEp.getCurrPosSec();
    AppMethodBeat.o(227964);
    return i;
  }
  
  public final int getPlayerType()
  {
    AppMethodBeat.i(227952);
    int i = this.pEp.getPlayerType();
    AppMethodBeat.o(227952);
    return i;
  }
  
  public final int getVideoDurationSec()
  {
    AppMethodBeat.i(227961);
    int i = this.pEp.getVideoDurationSec();
    AppMethodBeat.o(227961);
    return i;
  }
  
  public final View getView()
  {
    return this.pEp;
  }
  
  public final boolean isLive()
  {
    AppMethodBeat.i(227970);
    boolean bool = this.pEp.isLive();
    AppMethodBeat.o(227970);
    return bool;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(227967);
    boolean bool = this.pEp.isPlaying();
    AppMethodBeat.o(227967);
    return bool;
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(227990);
    this.pEp.onUIDestroy();
    AppMethodBeat.o(227990);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(227988);
    this.pEp.onUIPause();
    AppMethodBeat.o(227988);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(227986);
    this.pEp.onUIResume();
    AppMethodBeat.o(227986);
  }
  
  public final boolean p(double paramDouble)
  {
    AppMethodBeat.i(227954);
    boolean bool = this.pEp.p(paramDouble);
    AppMethodBeat.o(227954);
    return bool;
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(227982);
    boolean bool = this.pEp.pause();
    AppMethodBeat.o(227982);
    return bool;
  }
  
  public final void setCover(Bitmap paramBitmap)
  {
    AppMethodBeat.i(227971);
    this.pEp.setCover(paramBitmap);
    AppMethodBeat.o(227971);
  }
  
  public final void setFullDirection(int paramInt)
  {
    AppMethodBeat.i(227960);
    this.pEp.setFullDirection(paramInt);
    AppMethodBeat.o(227960);
  }
  
  public final void setIMMVideoViewCallback(d.c paramc)
  {
    AppMethodBeat.i(227997);
    this.pEp.setIMMVideoViewCallback(paramc);
    AppMethodBeat.o(227997);
  }
  
  public final void setIsShowBasicControls(boolean paramBoolean)
  {
    AppMethodBeat.i(227958);
    this.pEp.setIsShowBasicControls(paramBoolean);
    AppMethodBeat.o(227958);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(227983);
    this.pEp.setMute(paramBoolean);
    AppMethodBeat.o(227983);
  }
  
  public final void setScaleType(d.h paramh)
  {
    AppMethodBeat.i(227994);
    this.pEp.setScaleType(paramh);
    AppMethodBeat.o(227994);
  }
  
  public final void setVideoFooterView(d.b paramb)
  {
    AppMethodBeat.i(227975);
    this.pEp.setVideoFooterView(paramb);
    AppMethodBeat.o(227975);
  }
  
  public final void setVideoSource(int paramInt)
  {
    AppMethodBeat.i(227974);
    this.pEp.setVideoSource(paramInt);
    AppMethodBeat.o(227974);
  }
  
  public final void start()
  {
    AppMethodBeat.i(227979);
    this.pEp.start();
    AppMethodBeat.o(227979);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(227980);
    this.pEp.stop();
    AppMethodBeat.o(227980);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.videoview.b.c
 * JD-Core Version:    0.7.0.1
 */