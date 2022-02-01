package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface e
{
  public abstract boolean aE(float paramFloat);
  
  public abstract boolean bip();
  
  public abstract void bns();
  
  public abstract void c(boolean paramBoolean, String paramString, int paramInt);
  
  public abstract boolean c(double paramDouble, boolean paramBoolean);
  
  public abstract int getCacheTimeSec();
  
  public abstract int getCurrPosMs();
  
  public abstract int getCurrPosSec();
  
  public abstract int getPlayerType();
  
  public abstract int getVideoDurationSec();
  
  public abstract View getView();
  
  public abstract boolean isPlaying();
  
  public abstract boolean o(double paramDouble);
  
  public abstract void onUIDestroy();
  
  public abstract void onUIPause();
  
  public abstract void onUIResume();
  
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
    public abstract void a(e.f paramf);
    
    public abstract void blp();
    
    public abstract boolean bnP();
    
    public abstract void bnQ();
    
    public abstract void bnR();
    
    public abstract boolean bnS();
    
    public abstract void bnT();
    
    public abstract boolean bnU();
    
    public abstract boolean bnV();
    
    public abstract void bnW();
    
    public abstract void bnX();
    
    public abstract void bnY();
    
    public abstract void bnZ();
    
    public abstract void bnv();
    
    public abstract boolean boa();
    
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
    public abstract void gS(boolean paramBoolean);
    
    public abstract int getVideoTotalTime();
    
    public abstract void setVideoTotalTime(int paramInt);
    
    public abstract void tx(int paramInt);
  }
  
  public static abstract interface c
  {
    public abstract void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2);
    
    public abstract void d(String paramString1, String paramString2, int paramInt1, int paramInt2);
    
    public abstract void ds(String paramString1, String paramString2);
    
    public abstract void dt(String paramString1, String paramString2);
    
    public abstract void du(String paramString1, String paramString2);
    
    public abstract void dv(String paramString1, String paramString2);
    
    public abstract void dw(String paramString1, String paramString2);
    
    public abstract void dx(String paramString1, String paramString2);
  }
  
  public static abstract interface d
  {
    public abstract void aqS();
    
    public abstract void nP(int paramInt);
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
    public abstract void gR(boolean paramBoolean);
  }
  
  public static enum h
  {
    static
    {
      AppMethodBeat.i(137806);
      lqm = new h("DEFAULT", 0);
      lqn = new h("FILL", 1);
      lqo = new h("CONTAIN", 2);
      lqp = new h("COVER", 3);
      lqq = new h[] { lqm, lqn, lqo, lqp };
      AppMethodBeat.o(137806);
    }
    
    private h() {}
  }
  
  public static abstract interface i
  {
    public abstract int bnD();
    
    public abstract int bnE();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e
 * JD-Core Version:    0.7.0.1
 */