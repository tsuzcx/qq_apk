package com.tencent.mm.plugin.appbrand.jsapi.video.videoview;

public abstract interface a
{
  public abstract void H(double paramDouble);
  
  public abstract void c(double paramDouble, boolean paramBoolean);
  
  public abstract int getCurrentPosition();
  
  public abstract int getDuration();
  
  public abstract long getLastSurfaceUpdateTime();
  
  public abstract String getVideoPath();
  
  public abstract boolean isPlaying();
  
  public abstract void pause();
  
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
    public abstract void Qz();
    
    public abstract void fG(int paramInt1, int paramInt2);
    
    public abstract void onCompletion();
    
    public abstract void onError(int paramInt1, int paramInt2);
  }
  
  public static abstract interface b
  {
    public abstract void onInfo(int paramInt1, int paramInt2);
  }
  
  public static abstract interface c
  {
    public abstract void onSeekComplete(boolean paramBoolean);
  }
  
  public static abstract interface d
  {
    public abstract void bNV();
  }
  
  public static abstract interface e
  {
    public abstract void onTextureUpdate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a
 * JD-Core Version:    0.7.0.1
 */