package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;

public abstract interface d
{
  public abstract boolean G(double paramDouble);
  
  public abstract void b(boolean paramBoolean, String paramString, int paramInt);
  
  public abstract boolean b(double paramDouble, boolean paramBoolean);
  
  public abstract boolean bM(float paramFloat);
  
  public abstract void cuV();
  
  public abstract int getCacheTimeSec();
  
  public abstract int getCurrPosMs();
  
  public abstract int getCurrPosSec();
  
  public abstract int getPlayerType();
  
  public abstract int getVideoDurationSec();
  
  public abstract View getView();
  
  public abstract boolean isLive();
  
  public abstract boolean isPlaying();
  
  public abstract void onUIDestroy();
  
  public abstract void onUIPause();
  
  public abstract void onUIResume();
  
  public abstract boolean pause();
  
  public abstract void setCover(Bitmap paramBitmap);
  
  public abstract void setFullDirection(int paramInt);
  
  public abstract void setIMMVideoViewCallback(d.c paramc);
  
  public abstract void setIsShowBasicControls(boolean paramBoolean);
  
  public abstract void setMute(boolean paramBoolean);
  
  public abstract void setScaleType(d.h paramh);
  
  public abstract void setVideoFooterView(d.b paramb);
  
  public abstract void setVideoSource(int paramInt);
  
  public abstract void start();
  
  public abstract void stop();
  
  public static abstract interface a
  {
    public abstract void a(d.f paramf);
    
    public abstract void anJ();
    
    public abstract void csz();
    
    public abstract void cuX();
    
    public abstract boolean cvA();
    
    public abstract boolean cvq();
    
    public abstract void cvr();
    
    public abstract void cvs();
    
    public abstract boolean cvt();
    
    public abstract boolean cvu();
    
    public abstract boolean cvv();
    
    public abstract void cvw();
    
    public abstract void cvx();
    
    public abstract void cvy();
    
    public abstract void cvz();
    
    public abstract void hide();
    
    public abstract void onDestroy();
    
    public abstract void seek(int paramInt);
    
    public abstract void setDanmakuBtnOnClickListener(d.g paramg);
    
    public abstract void setDanmakuBtnOpen(boolean paramBoolean);
    
    public abstract void setExitFullScreenBtnOnClickListener(View.OnClickListener paramOnClickListener);
    
    public abstract void setFullScreenBtnOnClickListener(View.OnClickListener paramOnClickListener);
    
    public abstract void setIplaySeekCallback(d.d paramd);
    
    public abstract void setIsPlay(boolean paramBoolean);
    
    public abstract void setMuteBtnOnClickListener(View.OnClickListener paramOnClickListener);
    
    public abstract void setMuteBtnState(boolean paramBoolean);
    
    public abstract void setOnPlayButtonClickListener(View.OnClickListener paramOnClickListener);
    
    public abstract void setOnUpdateProgressLenListener(d.e parame);
    
    public abstract void setPlayBtnInCenterPosition(boolean paramBoolean);
    
    public abstract void setShowControlProgress(boolean paramBoolean);
    
    public abstract void setShowDanmakuBtn(boolean paramBoolean);
    
    public abstract void setShowFullScreenBtn(boolean paramBoolean);
    
    public abstract void setShowMuteBtn(boolean paramBoolean);
    
    public abstract void setShowPlayBtn(boolean paramBoolean);
    
    public abstract void setShowProgress(boolean paramBoolean);
    
    public abstract void setStatePorter(d.i parami);
    
    public abstract void setTitle(String paramString);
  }
  
  public static abstract interface d
  {
    public abstract void blc();
    
    public abstract void tS(int paramInt);
  }
  
  public static abstract interface e
  {
    public abstract void onProgressChanged(int paramInt1, int paramInt2);
  }
  
  public static abstract interface f
  {
    public abstract void onVisibilityChanged(boolean paramBoolean);
  }
  
  public static abstract interface g
  {
    public abstract void jI(boolean paramBoolean);
  }
  
  public static abstract interface i
  {
    public abstract int cvf();
    
    public abstract int cvg();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.d
 * JD-Core Version:    0.7.0.1
 */