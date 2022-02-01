package com.tencent.mm.plugin.finder.video;

import android.view.MotionEvent;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/video/IFinderVideoSeekBar;", "", "dismissProgressBar", "", "enterSeekMode", "exitSeekMode", "reason", "", "getCurrentProgress", "", "getMaxProgress", "isSeekingMode", "", "isShownSeekBar", "setProgress", "progress", "setSeekBarCallback", "callback", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoSeekBar$SeekBarCallback;", "setVisibility", "visibility", "showProgressBar", "isShowThumb", "updateProgressMs", "percent", "", "offsetMs", "", "allMs", "updateProgressSec", "offsetSec", "allSec", "SeekBarCallback", "plugin-finder_release"})
public abstract interface r
{
  public abstract void aGh(String paramString);
  
  public abstract void bk(float paramFloat);
  
  public abstract void egH();
  
  public abstract boolean egI();
  
  public abstract boolean egJ();
  
  public abstract void egK();
  
  public abstract int getCurrentProgress();
  
  public abstract int getMaxProgress();
  
  public abstract void he(int paramInt1, int paramInt2);
  
  public abstract void qW(boolean paramBoolean);
  
  public abstract void setProgress(int paramInt);
  
  public abstract void setSeekBarCallback(a parama);
  
  public abstract void setVisibility(int paramInt);
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/video/IFinderVideoSeekBar$SeekBarCallback;", "", "getCurrentPosMs", "", "getCurrentPosSec", "", "getVideoDurationSec", "isEnableSeek", "", "onEnterSeekMode", "", "isEnter", "showPauseTips", "onNeedIgnoreTouchEvent", "event", "Landroid/view/MotionEvent;", "onPlayAfterSeek", "onStartSeek", "onStopSeek", "percent", "", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract boolean ac(MotionEvent paramMotionEvent);
    
    public abstract void bl(float paramFloat);
    
    public abstract void ehv();
    
    public abstract boolean ehw();
    
    public abstract int getCurrentPosSec();
    
    public abstract int getVideoDurationSec();
    
    public abstract void rf(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.r
 * JD-Core Version:    0.7.0.1
 */