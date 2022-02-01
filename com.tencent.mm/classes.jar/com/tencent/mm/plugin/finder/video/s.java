package com.tencent.mm.plugin.finder.video;

import android.view.MotionEvent;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/IFinderVideoSeekBar;", "", "dismissProgressBar", "", "enterSeekMode", "exitSeekMode", "reason", "", "getCurrentProgress", "", "getMaxProgress", "isSeekingMode", "", "isShownSeekBar", "setProgress", "progress", "setSeekBarCallback", "callback", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoSeekBar$SeekBarCallback;", "setVisibility", "visibility", "showProgressBar", "isShowThumb", "updateProgressMs", "percent", "", "offsetMs", "", "allMs", "updateProgressSec", "offsetSec", "allSec", "SeekBarCallback", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface s
{
  public abstract void aCk(String paramString);
  
  public abstract void co(float paramFloat);
  
  public abstract void fiE();
  
  public abstract boolean fiF();
  
  public abstract boolean fiG();
  
  public abstract void fiH();
  
  public abstract int getCurrentProgress();
  
  public abstract int getMaxProgress();
  
  public abstract void iw(int paramInt1, int paramInt2);
  
  public abstract void setProgress(int paramInt);
  
  public abstract void setSeekBarCallback(a parama);
  
  public abstract void setVisibility(int paramInt);
  
  public abstract void ux(boolean paramBoolean);
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/IFinderVideoSeekBar$SeekBarCallback;", "", "getCurrentPosMs", "", "getCurrentPosSec", "", "getVideoDurationSec", "isEnableSeek", "", "onEnterSeekMode", "", "isEnter", "showPauseTips", "onNeedIgnoreTouchEvent", "event", "Landroid/view/MotionEvent;", "onPlayAfterSeek", "onStartSeek", "onStopSeek", "percent", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract boolean ad(MotionEvent paramMotionEvent);
    
    public abstract void cq(float paramFloat);
    
    public abstract boolean fjA();
    
    public abstract void fjz();
    
    public abstract int getCurrentPosSec();
    
    public abstract int getVideoDurationSec();
    
    public abstract void uG(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.s
 * JD-Core Version:    0.7.0.1
 */