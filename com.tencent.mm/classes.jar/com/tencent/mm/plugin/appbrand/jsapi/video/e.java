package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface e
{
  public abstract boolean aXf();
  
  public abstract boolean ax(float paramFloat);
  
  public abstract void bcc();
  
  public abstract void c(boolean paramBoolean, String paramString, int paramInt);
  
  public abstract boolean c(double paramDouble, boolean paramBoolean);
  
  public abstract int getCacheTimeSec();
  
  public abstract int getCurrPosMs();
  
  public abstract int getCurrPosSec();
  
  public abstract int getPlayerType();
  
  public abstract int getVideoDurationSec();
  
  public abstract View getView();
  
  public abstract boolean isPlaying();
  
  public abstract void onUIDestroy();
  
  public abstract void onUIPause();
  
  public abstract void onUIResume();
  
  public abstract boolean p(double paramDouble);
  
  public abstract boolean pause();
  
  public abstract void setCover(Bitmap paramBitmap);
  
  public abstract void setFullDirection(int paramInt);
  
  public abstract void setIMMVideoViewCallback(c paramc);
  
  public abstract void setIsShowBasicControls(boolean paramBoolean);
  
  public abstract void setMute(boolean paramBoolean);
  
  public abstract void setScaleType(h paramh);
  
  public abstract void setVideoFooterView(b paramb);
  
  public abstract void setVideoSource(int paramInt);
  
  public abstract void start();
  
  public abstract void stop();
  
  public static abstract interface b
  {
    public abstract int getVideoTotalTime();
    
    public abstract void gp(boolean paramBoolean);
    
    public abstract void sa(int paramInt);
    
    public abstract void setVideoTotalTime(int paramInt);
  }
  
  public static abstract interface c
  {
    public abstract void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2);
    
    public abstract void d(String paramString1, String paramString2, int paramInt1, int paramInt2);
    
    public abstract void db(String paramString1, String paramString2);
    
    public abstract void dc(String paramString1, String paramString2);
    
    public abstract void dd(String paramString1, String paramString2);
    
    public abstract void de(String paramString1, String paramString2);
    
    public abstract void dg(String paramString1, String paramString2);
    
    public abstract void dh(String paramString1, String paramString2);
  }
  
  public static enum h
  {
    static
    {
      AppMethodBeat.i(137806);
      knP = new h("DEFAULT", 0);
      knQ = new h("FILL", 1);
      knR = new h("CONTAIN", 2);
      knS = new h("COVER", 3);
      knT = new h[] { knP, knQ, knR, knS };
      AppMethodBeat.o(137806);
    }
    
    private h() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e
 * JD-Core Version:    0.7.0.1
 */