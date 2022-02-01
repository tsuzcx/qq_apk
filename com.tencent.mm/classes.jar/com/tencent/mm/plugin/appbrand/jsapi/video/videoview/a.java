package com.tencent.mm.plugin.appbrand.jsapi.video.videoview;

public abstract interface a
{
  public abstract void d(double paramDouble, boolean paramBoolean);
  
  public abstract int getCurrentPosition();
  
  public abstract int getDuration();
  
  public abstract String getVideoPath();
  
  public abstract boolean isPlaying();
  
  public abstract void pause();
  
  public abstract void q(double paramDouble);
  
  public abstract void setMute(boolean paramBoolean);
  
  public abstract void setOnInfoCallback(b paramb);
  
  public abstract void setOnSeekCompleteCallback(c paramc);
  
  public abstract void setOnSurfaceCallback(d paramd);
  
  public abstract void setOneTimeVideoTextureUpdateCallback(e parame);
  
  public abstract void setVideoCallback(a parama);
  
  public abstract void setVideoPath(String paramString);
  
  public abstract boolean start();
  
  public abstract void stop();
  
  public static abstract interface a
  {
    public abstract void dY(int paramInt1, int paramInt2);
    
    public abstract void onCompletion();
    
    public abstract void onError(int paramInt1, int paramInt2);
    
    public abstract void rq();
  }
  
  public static abstract interface b
  {
    public abstract void dZ(int paramInt1, int paramInt2);
  }
  
  public static abstract interface c
  {
    public abstract void ey(boolean paramBoolean);
  }
  
  public static abstract interface d
  {
    public abstract void aCw();
  }
  
  public static abstract interface e
  {
    public abstract void beo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a
 * JD-Core Version:    0.7.0.1
 */