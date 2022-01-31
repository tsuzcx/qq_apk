package com.tencent.mm.plugin.appbrand.jsapi.video;

public abstract interface d
{
  public abstract void aEM();
  
  public abstract void alo();
  
  public abstract void alp();
  
  public abstract boolean ay(float paramFloat);
  
  public abstract void c(boolean paramBoolean, String paramString, int paramInt);
  
  public abstract boolean d(double paramDouble, boolean paramBoolean);
  
  public abstract int getCacheTimeSec();
  
  public abstract int getCurrPosMs();
  
  public abstract int getCurrPosSec();
  
  public abstract int getVideoDurationSec();
  
  public abstract boolean isLive();
  
  public abstract boolean isPlaying();
  
  public abstract boolean pause();
  
  public abstract boolean r(double paramDouble);
  
  public abstract void setControlBar(d.a parama);
  
  public abstract void setIMMVideoViewCallback(d.b paramb);
  
  public abstract void setMute(boolean paramBoolean);
  
  public abstract void setScaleType(d.g paramg);
  
  public abstract void setVideoSource(int paramInt);
  
  public abstract void start();
  
  public abstract void stop();
  
  public static abstract interface c
  {
    public abstract void aFf();
    
    public abstract void on(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.d
 * JD-Core Version:    0.7.0.1
 */