package com.tencent.mm.plugin.appbrand.jsapi.u.a.b;

import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;

public abstract class b
  implements c
{
  protected MediaPlayer.OnInfoListener gIi;
  protected MediaPlayer.OnErrorListener gIj;
  protected MediaPlayer.OnPreparedListener gIk;
  protected MediaPlayer.OnCompletionListener gIl;
  protected MediaPlayer.OnSeekCompleteListener gIm;
  protected MediaPlayer.OnBufferingUpdateListener gIn;
  protected MediaPlayer.OnVideoSizeChangedListener gIo;
  int mCurrentState = 0;
  
  public final int getState()
  {
    return this.mCurrentState;
  }
  
  public final void setOnBufferingUpdateListener(MediaPlayer.OnBufferingUpdateListener paramOnBufferingUpdateListener)
  {
    this.gIn = paramOnBufferingUpdateListener;
  }
  
  public final void setOnCompletionListener(MediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    this.gIl = paramOnCompletionListener;
  }
  
  public final void setOnErrorListener(MediaPlayer.OnErrorListener paramOnErrorListener)
  {
    this.gIj = paramOnErrorListener;
  }
  
  public final void setOnInfoListener(MediaPlayer.OnInfoListener paramOnInfoListener)
  {
    this.gIi = paramOnInfoListener;
  }
  
  public final void setOnPreparedListener(MediaPlayer.OnPreparedListener paramOnPreparedListener)
  {
    this.gIk = paramOnPreparedListener;
  }
  
  public final void setOnSeekCompleteListener(MediaPlayer.OnSeekCompleteListener paramOnSeekCompleteListener)
  {
    this.gIm = paramOnSeekCompleteListener;
  }
  
  public final void setOnVideoSizeChangedListener(MediaPlayer.OnVideoSizeChangedListener paramOnVideoSizeChangedListener)
  {
    this.gIo = paramOnVideoSizeChangedListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.u.a.b.b
 * JD-Core Version:    0.7.0.1
 */