package com.tencent.mm.plugin.appbrand.jsapi.video.e;

import android.view.Surface;

public abstract interface b
{
  public abstract void a(a parama);
  
  public abstract void a(b paramb);
  
  public abstract void a(c paramc);
  
  public abstract void a(d paramd);
  
  public abstract void a(e parame);
  
  public abstract void a(f paramf);
  
  public abstract void a(g paramg);
  
  public abstract boolean ay(float paramFloat);
  
  public abstract void dp(String paramString1, String paramString2);
  
  public abstract int getCurrentPosition();
  
  public abstract int getDuration();
  
  public abstract int getState();
  
  public abstract int getVideoHeight();
  
  public abstract int getVideoWidth();
  
  public abstract boolean isPlaying();
  
  public abstract void pause();
  
  public abstract void prepareAsync();
  
  public abstract void release();
  
  public abstract void reset();
  
  public abstract void seekTo(long paramLong);
  
  public abstract void setDataSource(String paramString);
  
  public abstract void setLooping(boolean paramBoolean);
  
  public abstract void setMute(boolean paramBoolean);
  
  public abstract void setSurface(Surface paramSurface);
  
  public abstract void setVolume(float paramFloat1, float paramFloat2);
  
  public abstract void start();
  
  public abstract void stop();
  
  public static abstract interface a
  {
    public abstract void gX(int paramInt);
  }
  
  public static abstract interface b
  {
    public abstract void Fz();
  }
  
  public static abstract interface c
  {
    public abstract boolean cc(int paramInt1, int paramInt2);
  }
  
  public static abstract interface d
  {
    public abstract boolean cb(int paramInt1, int paramInt2);
  }
  
  public static abstract interface e
  {
    public abstract void a(b paramb);
  }
  
  public static abstract interface f
  {
    public abstract void b(b paramb);
  }
  
  public static abstract interface g
  {
    public abstract void a(b paramb, int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.b
 * JD-Core Version:    0.7.0.1
 */