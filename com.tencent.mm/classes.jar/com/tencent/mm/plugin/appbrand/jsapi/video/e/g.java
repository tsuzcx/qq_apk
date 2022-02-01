package com.tencent.mm.plugin.appbrand.jsapi.video.e;

import android.view.Surface;

public abstract interface g
{
  public abstract void M(String paramString1, String paramString2, String paramString3);
  
  public abstract void a(a parama);
  
  public abstract void a(b paramb);
  
  public abstract void a(g.d paramd);
  
  public abstract void a(e parame);
  
  public abstract void a(f paramf);
  
  public abstract void a(g paramg);
  
  public abstract void a(h paramh);
  
  public abstract void a(i parami);
  
  public abstract void a(j paramj);
  
  public abstract void a(String paramString1, String paramString2, g.c paramc);
  
  public abstract <PlayerImpl extends g> PlayerImpl aU(Class<PlayerImpl> paramClass);
  
  public abstract boolean bN(float paramFloat);
  
  public abstract void cM(String paramString, int paramInt);
  
  public abstract void ey(String paramString1, String paramString2);
  
  public abstract int getCurrentPosition();
  
  public abstract int getDuration();
  
  public abstract int getPlayerType();
  
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
    public abstract void onBufferingUpdate(g paramg, int paramInt);
  }
  
  public static abstract interface b
  {
    public abstract void onCompletion(g paramg);
  }
  
  public static abstract interface e
  {
    public abstract boolean onError(g paramg, int paramInt1, int paramInt2);
  }
  
  public static abstract interface f
  {
    public abstract void onHitPreload(Boolean paramBoolean);
  }
  
  public static abstract interface g
  {
    public abstract boolean onInfo(g paramg, int paramInt1, int paramInt2);
  }
  
  public static abstract interface h
  {
    public abstract void onPrepared(g paramg);
  }
  
  public static abstract interface i
  {
    public abstract void onSeekComplete(g paramg);
  }
  
  public static abstract interface j
  {
    public abstract void onVideoSizeChanged(g paramg, int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.g
 * JD-Core Version:    0.7.0.1
 */