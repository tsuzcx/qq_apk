package com.google.android.exoplayer2;

import com.google.android.exoplayer2.g.g;
import com.google.android.exoplayer2.source.r;

public abstract interface q$a
{
  public abstract void onLoadingChanged(boolean paramBoolean);
  
  public abstract void onPlaybackParametersChanged(p paramp);
  
  public abstract void onPlayerError(e parame);
  
  public abstract void onPlayerStateChanged(boolean paramBoolean, int paramInt);
  
  public abstract void onPositionDiscontinuity();
  
  public abstract void onRepeatModeChanged(int paramInt);
  
  public abstract void onTimelineChanged(w paramw, Object paramObject);
  
  public abstract void onTracksChanged(r paramr, g paramg);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.google.android.exoplayer2.q.a
 * JD-Core Version:    0.7.0.1
 */