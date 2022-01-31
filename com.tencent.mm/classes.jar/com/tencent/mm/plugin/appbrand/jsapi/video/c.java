package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.view.View.OnClickListener;

public abstract interface c
{
  public abstract void Se();
  
  public abstract void Sf();
  
  public abstract boolean aj(float paramFloat);
  
  public abstract void akT();
  
  public abstract void c(boolean paramBoolean, String paramString, int paramInt);
  
  public abstract int getCacheTimeSec();
  
  public abstract int getCurrPosMs();
  
  public abstract int getCurrPosSec();
  
  public abstract int getVideoDurationSec();
  
  public abstract boolean isLive();
  
  public abstract boolean isPlaying();
  
  public abstract boolean lF(int paramInt);
  
  public abstract boolean pause();
  
  public abstract void setControlBar(a parama);
  
  public abstract void setIMMVideoViewCallback(c.b paramb);
  
  public abstract void setMute(boolean paramBoolean);
  
  public abstract void setScaleType(c.g paramg);
  
  public abstract void setVideoSource(int paramInt);
  
  public abstract void start();
  
  public abstract void stop();
  
  public abstract boolean y(int paramInt, boolean paramBoolean);
  
  public static abstract interface a
  {
    public abstract void aiZ();
    
    public abstract void akB();
    
    public abstract boolean akD();
    
    public abstract void akG();
    
    public abstract boolean akH();
    
    public abstract void akI();
    
    public abstract void akJ();
    
    public abstract boolean akK();
    
    public abstract void akM();
    
    public abstract void akN();
    
    public abstract void akd();
    
    public abstract boolean cVl();
    
    public abstract void hide();
    
    public abstract void onDestroy();
    
    public abstract void seek(int paramInt);
    
    public abstract void setDanmakuBtnOnClickListener(c.f paramf);
    
    public abstract void setDanmakuBtnOpen(boolean paramBoolean);
    
    public abstract void setExitFullScreenBtnOnClickListener(View.OnClickListener paramOnClickListener);
    
    public abstract void setFullScreenBtnOnClickListener(View.OnClickListener paramOnClickListener);
    
    public abstract void setIplaySeekCallback(c.c paramc);
    
    public abstract void setMuteBtnOnClickListener(View.OnClickListener paramOnClickListener);
    
    public abstract void setMuteBtnState(boolean paramBoolean);
    
    public abstract void setOnPlayButtonClickListener(View.OnClickListener paramOnClickListener);
    
    public abstract void setOnUpdateProgressLenListener(c.d paramd);
    
    public abstract void setOnVisibilityChangedListener(c.e parame);
    
    public abstract void setPlayBtnInCenterPosition(boolean paramBoolean);
    
    public abstract void setShowControlProgress(boolean paramBoolean);
    
    public abstract void setShowDanmakuBtn(boolean paramBoolean);
    
    public abstract void setShowFullScreenBtn(boolean paramBoolean);
    
    public abstract void setShowMuteBtn(boolean paramBoolean);
    
    public abstract void setShowPlayBtn(boolean paramBoolean);
    
    public abstract void setShowProgress(boolean paramBoolean);
    
    public abstract void setStatePorter(c.h paramh);
    
    public abstract void setTitle(String paramString);
  }
  
  public static abstract interface c
  {
    public abstract void akz();
    
    public abstract void lE(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.c
 * JD-Core Version:    0.7.0.1
 */