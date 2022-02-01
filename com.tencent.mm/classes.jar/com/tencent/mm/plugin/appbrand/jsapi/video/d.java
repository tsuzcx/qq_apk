package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface d
{
  public abstract boolean a(double paramDouble, boolean paramBoolean);
  
  public abstract boolean aO(float paramFloat);
  
  public abstract void bUF();
  
  public abstract void c(boolean paramBoolean, String paramString, int paramInt);
  
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
  
  public static abstract interface a
  {
    public abstract void Nq();
    
    public abstract void a(d.f paramf);
    
    public abstract void bSs();
    
    public abstract void bUI();
    
    public abstract boolean bVa();
    
    public abstract void bVb();
    
    public abstract void bVc();
    
    public abstract boolean bVd();
    
    public abstract boolean bVe();
    
    public abstract boolean bVf();
    
    public abstract void bVg();
    
    public abstract void bVh();
    
    public abstract void bVi();
    
    public abstract void bVj();
    
    public abstract boolean bVk();
    
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
  
  public static abstract interface b
  {
    public abstract void AS(int paramInt);
    
    public abstract int getVideoTotalTime();
    
    public abstract void iF(boolean paramBoolean);
    
    public abstract void setVideoTotalTime(int paramInt);
  }
  
  public static abstract interface c
  {
    public abstract void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2);
    
    public abstract void d(String paramString1, String paramString2, int paramInt1, int paramInt2);
    
    public abstract void dS(String paramString1, String paramString2);
    
    public abstract void dT(String paramString1, String paramString2);
    
    public abstract void dU(String paramString1, String paramString2);
    
    public abstract void dV(String paramString1, String paramString2);
    
    public abstract void dW(String paramString1, String paramString2);
    
    public abstract void dX(String paramString1, String paramString2);
  }
  
  public static abstract interface d
  {
    public abstract void aRo();
    
    public abstract void tY(int paramInt);
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
    public abstract void iE(boolean paramBoolean);
  }
  
  public static enum h
  {
    static
    {
      AppMethodBeat.i(137806);
      pvl = new h("DEFAULT", 0);
      pvm = new h("FILL", 1);
      pvn = new h("CONTAIN", 2);
      pvo = new h("COVER", 3);
      pvp = new h[] { pvl, pvm, pvn, pvo };
      AppMethodBeat.o(137806);
    }
    
    private h() {}
  }
  
  public static abstract interface i
  {
    public abstract int bUQ();
    
    public abstract int bUR();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.d
 * JD-Core Version:    0.7.0.1
 */