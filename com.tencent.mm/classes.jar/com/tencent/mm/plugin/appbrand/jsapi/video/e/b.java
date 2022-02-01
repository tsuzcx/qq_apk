package com.tencent.mm.plugin.appbrand.jsapi.video.e;

import android.view.Surface;

public abstract interface b
{
  public abstract void a(b.a parama);
  
  public abstract void a(b.b paramb);
  
  public abstract void a(b.c paramc);
  
  public abstract void a(b.d paramd);
  
  public abstract void a(b.e parame);
  
  public abstract void a(b.f paramf);
  
  public abstract void a(b.g paramg);
  
  public abstract boolean aC(float paramFloat);
  
  public abstract void dB(String paramString1, String paramString2);
  
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.b
 * JD-Core Version:    0.7.0.1
 */