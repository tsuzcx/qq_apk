package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface e
{
  public abstract boolean aO(float paramFloat);
  
  public abstract void bIW();
  
  public abstract void c(boolean paramBoolean, String paramString, int paramInt);
  
  public abstract boolean c(double paramDouble, boolean paramBoolean);
  
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
    public abstract void KD();
    
    public abstract void a(e.f paramf);
    
    public abstract void bGL();
    
    public abstract void bIZ();
    
    public abstract void bJA();
    
    public abstract void bJB();
    
    public abstract void bJC();
    
    public abstract boolean bJD();
    
    public abstract boolean bJt();
    
    public abstract void bJu();
    
    public abstract void bJv();
    
    public abstract boolean bJw();
    
    public abstract boolean bJx();
    
    public abstract boolean bJy();
    
    public abstract void bJz();
    
    public abstract void hide();
    
    public abstract void onDestroy();
    
    public abstract void seek(int paramInt);
    
    public abstract void setDanmakuBtnOnClickListener(e.g paramg);
    
    public abstract void setDanmakuBtnOpen(boolean paramBoolean);
    
    public abstract void setExitFullScreenBtnOnClickListener(View.OnClickListener paramOnClickListener);
    
    public abstract void setFullScreenBtnOnClickListener(View.OnClickListener paramOnClickListener);
    
    public abstract void setIplaySeekCallback(e.d paramd);
    
    public abstract void setIsPlay(boolean paramBoolean);
    
    public abstract void setMuteBtnOnClickListener(View.OnClickListener paramOnClickListener);
    
    public abstract void setMuteBtnState(boolean paramBoolean);
    
    public abstract void setOnPlayButtonClickListener(View.OnClickListener paramOnClickListener);
    
    public abstract void setOnUpdateProgressLenListener(e.e parame);
    
    public abstract void setPlayBtnInCenterPosition(boolean paramBoolean);
    
    public abstract void setShowControlProgress(boolean paramBoolean);
    
    public abstract void setShowDanmakuBtn(boolean paramBoolean);
    
    public abstract void setShowFullScreenBtn(boolean paramBoolean);
    
    public abstract void setShowMuteBtn(boolean paramBoolean);
    
    public abstract void setShowPlayBtn(boolean paramBoolean);
    
    public abstract void setShowProgress(boolean paramBoolean);
    
    public abstract void setStatePorter(e.i parami);
    
    public abstract void setTitle(String paramString);
  }
  
  public static abstract interface b
  {
    public abstract int getVideoTotalTime();
    
    public abstract void hP(boolean paramBoolean);
    
    public abstract void setVideoTotalTime(int paramInt);
    
    public abstract void xv(int paramInt);
  }
  
  public static abstract interface c
  {
    public abstract void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2);
    
    public abstract void d(String paramString1, String paramString2, int paramInt1, int paramInt2);
    
    public abstract void dH(String paramString1, String paramString2);
    
    public abstract void dI(String paramString1, String paramString2);
    
    public abstract void dJ(String paramString1, String paramString2);
    
    public abstract void dK(String paramString1, String paramString2);
    
    public abstract void dL(String paramString1, String paramString2);
    
    public abstract void dM(String paramString1, String paramString2);
  }
  
  public static enum h
  {
    static
    {
      AppMethodBeat.i(137806);
      mwR = new h("DEFAULT", 0);
      mwS = new h("FILL", 1);
      mwT = new h("CONTAIN", 2);
      mwU = new h("COVER", 3);
      mwV = new h[] { mwR, mwS, mwT, mwU };
      AppMethodBeat.o(137806);
    }
    
    private h() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e
 * JD-Core Version:    0.7.0.1
 */