package com.tencent.mm.plugin.finder.video;

import android.view.MotionEvent;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/video/IFinderVideoSeekBar;", "", "dismissProgressBar", "", "enterSeekMode", "exitSeekMode", "reason", "", "getCurrentProgress", "", "isSeekingMode", "", "isShownSeekBar", "setProgress", "progress", "setSeekBarCallback", "callback", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoSeekBar$SeekBarCallback;", "setVisibility", "visibility", "showProgressBar", "isShowThumb", "updateProgressMs", "percent", "", "offsetMs", "", "allMs", "updateProgressSec", "offsetSec", "allSec", "SeekBarCallback", "plugin-finder_release"})
public abstract interface q
{
  public abstract void awG(String paramString);
  
  public abstract void bm(float paramFloat);
  
  public abstract void dEX();
  
  public abstract boolean dEY();
  
  public abstract boolean dEZ();
  
  public abstract void dFa();
  
  public abstract int getCurrentProgress();
  
  public abstract void gs(int paramInt1, int paramInt2);
  
  public abstract void oI(boolean paramBoolean);
  
  public abstract void setProgress(int paramInt);
  
  public abstract void setSeekBarCallback(a parama);
  
  public abstract void setVisibility(int paramInt);
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/video/IFinderVideoSeekBar$SeekBarCallback;", "", "getCurrentPosMs", "", "getCurrentPosSec", "", "getVideoDurationSec", "isEnableSeek", "", "onEnterSeekMode", "", "isEnter", "showPauseTips", "onNeedIgnoreTouchEvent", "event", "Landroid/view/MotionEvent;", "onStartSeek", "onStopSeek", "percent", "", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void Q(boolean paramBoolean1, boolean paramBoolean2);
    
    public abstract boolean W(MotionEvent paramMotionEvent);
    
    public abstract void bn(float paramFloat);
    
    public abstract void dFH();
    
    public abstract boolean dFI();
    
    public abstract int getCurrentPosSec();
    
    public abstract int getVideoDurationSec();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.q
 * JD-Core Version:    0.7.0.1
 */