package com.tencent.luggage.xweb_ext.extendplugin.component.video.b;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.media.PlaybackParams;
import android.os.Build.VERSION;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.k;
import com.tencent.mm.sdk.platformtools.ab;

public final class d
  extends a
{
  private MediaPlayer bIo;
  private MediaPlayer.OnPreparedListener bIp;
  private MediaPlayer.OnVideoSizeChangedListener bIq;
  private MediaPlayer.OnCompletionListener bIr;
  private MediaPlayer.OnInfoListener bIs;
  private MediaPlayer.OnSeekCompleteListener bIt;
  private MediaPlayer.OnErrorListener bIu;
  private MediaPlayer.OnBufferingUpdateListener bIv;
  
  public d()
  {
    AppMethodBeat.i(139915);
    this.bIp = new d.1(this);
    this.bIq = new d.2(this);
    this.bIr = new d.3(this);
    this.bIs = new d.4(this);
    this.bIt = new d.5(this);
    this.bIu = new MediaPlayer.OnErrorListener()
    {
      public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(139913);
        boolean bool = d.this.bN(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(139913);
        return bool;
      }
    };
    this.bIv = new d.7(this);
    this.bIo = new k();
    this.bIo.setScreenOnWhilePlaying(true);
    this.bIo.setAudioStreamType(3);
    this.bIo.setOnInfoListener(this.bIs);
    this.bIo.setOnErrorListener(this.bIu);
    this.bIo.setOnPreparedListener(this.bIp);
    this.bIo.setOnCompletionListener(this.bIr);
    this.bIo.setOnSeekCompleteListener(this.bIt);
    this.bIo.setOnVideoSizeChangedListener(this.bIq);
    this.bIo.setOnBufferingUpdateListener(this.bIv);
    AppMethodBeat.o(139915);
  }
  
  private void fF(int paramInt)
  {
    AppMethodBeat.i(139933);
    if (this.bIu != null) {
      this.bIu.onError(this.bIo, -1024, paramInt);
    }
    AppMethodBeat.o(139933);
  }
  
  private void setVolume(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(139918);
    try
    {
      if (yb()) {
        this.bIo.setVolume(paramFloat1, paramFloat2);
      }
      AppMethodBeat.o(139918);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s setVolume fail", new Object[] { Integer.valueOf(hashCode()) });
      fF(-13);
      AppMethodBeat.o(139918);
    }
  }
  
  private boolean yb()
  {
    return this.bIo != null;
  }
  
  public final boolean Y(float paramFloat)
  {
    AppMethodBeat.i(139919);
    if (paramFloat <= 0.0F)
    {
      AppMethodBeat.o(139919);
      return false;
    }
    try
    {
      if ((yb()) && (Build.VERSION.SDK_INT >= 23))
      {
        PlaybackParams localPlaybackParams = this.bIo.getPlaybackParams();
        localPlaybackParams.setSpeed(paramFloat);
        if (!this.bIo.isPlaying())
        {
          this.bIo.setPlaybackParams(localPlaybackParams);
          this.bIo.pause();
        }
        for (;;)
        {
          AppMethodBeat.o(139919);
          return true;
          this.bIo.setPlaybackParams(localPlaybackParams);
        }
        AppMethodBeat.o(139919);
      }
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s setSpeed fail", new Object[] { Integer.valueOf(hashCode()) });
      fF(-14);
    }
    for (;;)
    {
      return false;
      ab.w("MicroMsg.SameLayer.SystemMediaPlayer", "%s setSpeed, current system(%d) not support play speed setting", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(Build.VERSION.SDK_INT) });
    }
  }
  
  public final int getCurrentPosition()
  {
    AppMethodBeat.i(139922);
    try
    {
      if ((yb()) && ((this.mCurrentState == 2) || (this.mCurrentState == 3) || (this.mCurrentState == 4) || (this.mCurrentState == 6)))
      {
        int i = this.bIo.getCurrentPosition();
        AppMethodBeat.o(139922);
        return i;
      }
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s getCurrentPosition fail", new Object[] { Integer.valueOf(hashCode()) });
      fF(-15);
      AppMethodBeat.o(139922);
    }
    return 0;
  }
  
  public final int getDuration()
  {
    AppMethodBeat.i(139923);
    try
    {
      if ((yb()) && (this.mCurrentState != -1) && (this.mCurrentState != 1) && (this.mCurrentState != 0))
      {
        int i = this.bIo.getDuration();
        AppMethodBeat.o(139923);
        return i;
      }
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s getDuration fail", new Object[] { Integer.valueOf(hashCode()) });
      fF(-16);
      AppMethodBeat.o(139923);
    }
    return 0;
  }
  
  public final int getVideoHeight()
  {
    AppMethodBeat.i(139925);
    try
    {
      if (yb())
      {
        int i = this.bIo.getVideoHeight();
        AppMethodBeat.o(139925);
        return i;
      }
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s getVideoHeight fail", new Object[] { Integer.valueOf(hashCode()) });
      fF(-18);
      AppMethodBeat.o(139925);
    }
    return 0;
  }
  
  public final int getVideoWidth()
  {
    AppMethodBeat.i(139924);
    try
    {
      if (yb())
      {
        int i = this.bIo.getVideoWidth();
        AppMethodBeat.o(139924);
        return i;
      }
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s getVideoWidth fail", new Object[] { Integer.valueOf(hashCode()) });
      fF(-17);
      AppMethodBeat.o(139924);
    }
    return 0;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(139921);
    try
    {
      if ((yb()) && (this.mCurrentState != -1))
      {
        boolean bool = this.bIo.isPlaying();
        AppMethodBeat.o(139921);
        return bool;
      }
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s isPlaying fail", new Object[] { Integer.valueOf(hashCode()) });
      fF(-9);
      AppMethodBeat.o(139921);
    }
    return false;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(139928);
    try
    {
      if (yb())
      {
        this.bIo.pause();
        this.mCurrentState = 4;
      }
      AppMethodBeat.o(139928);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s pause fail", new Object[] { Integer.valueOf(hashCode()) });
      fF(-2);
      AppMethodBeat.o(139928);
    }
  }
  
  public final void prepareAsync()
  {
    AppMethodBeat.i(139926);
    try
    {
      if (yb()) {
        this.bIo.prepareAsync();
      }
      AppMethodBeat.o(139926);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s prepareAsync fail", new Object[] { Integer.valueOf(hashCode()) });
      fF(-6);
      AppMethodBeat.o(139926);
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(139932);
    try
    {
      if (yb())
      {
        if (this.bIo != null)
        {
          this.bIo.setOnInfoListener(null);
          this.bIo.setOnErrorListener(null);
          this.bIo.setOnPreparedListener(null);
          this.bIo.setOnCompletionListener(null);
          this.bIo.setOnSeekCompleteListener(null);
          this.bIo.setOnBufferingUpdateListener(null);
          this.bIo.setOnVideoSizeChangedListener(null);
        }
        this.bIo.release();
        this.mCurrentState = -2;
        super.release();
      }
      AppMethodBeat.o(139932);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s release fail", new Object[] { Integer.valueOf(hashCode()) });
      fF(-8);
      AppMethodBeat.o(139932);
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(139931);
    try
    {
      if (yb())
      {
        this.bIo.reset();
        this.mCurrentState = 0;
      }
      AppMethodBeat.o(139931);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s reset fail", new Object[] { Integer.valueOf(hashCode()) });
      fF(-7);
      AppMethodBeat.o(139931);
    }
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(139929);
    try
    {
      if ((yb()) && ((this.mCurrentState == 2) || (this.mCurrentState == 3) || (this.mCurrentState == 4) || (this.mCurrentState == 6))) {
        this.bIo.seekTo((int)paramLong);
      }
      AppMethodBeat.o(139929);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s seekTo fail", new Object[] { Integer.valueOf(hashCode()) });
      fF(-3);
      AppMethodBeat.o(139929);
    }
  }
  
  public final void setDataSource(String paramString)
  {
    AppMethodBeat.i(139916);
    try
    {
      if (yb())
      {
        this.bIo.setDataSource(paramString);
        this.mCurrentState = 1;
      }
      AppMethodBeat.o(139916);
      return;
    }
    catch (Exception paramString)
    {
      ab.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", paramString, "%s setDataSource fail", new Object[] { Integer.valueOf(hashCode()) });
      fF(-11);
      AppMethodBeat.o(139916);
    }
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(139920);
    if (yb())
    {
      if (paramBoolean)
      {
        setVolume(0.0F, 0.0F);
        AppMethodBeat.o(139920);
        return;
      }
      setVolume(1.0F, 1.0F);
    }
    AppMethodBeat.o(139920);
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(139917);
    try
    {
      if (yb()) {
        this.bIo.setSurface(paramSurface);
      }
      AppMethodBeat.o(139917);
      return;
    }
    catch (Exception paramSurface)
    {
      ab.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", paramSurface, "%s setSurface fail", new Object[] { Integer.valueOf(hashCode()) });
      fF(-12);
      AppMethodBeat.o(139917);
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(139927);
    try
    {
      if ((yb()) && ((this.mCurrentState == 2) || (this.mCurrentState == 4) || (this.mCurrentState == 6)))
      {
        this.bIo.start();
        this.mCurrentState = 3;
      }
      AppMethodBeat.o(139927);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s start fail", new Object[] { Integer.valueOf(hashCode()) });
      fF(-1);
      AppMethodBeat.o(139927);
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(139930);
    try
    {
      if ((yb()) && ((this.mCurrentState == 2) || (this.mCurrentState == 3) || (this.mCurrentState == 4) || (this.mCurrentState == 6)))
      {
        this.bIo.stop();
        this.mCurrentState = 5;
      }
      AppMethodBeat.o(139930);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s stop fail", new Object[] { Integer.valueOf(hashCode()) });
      fF(-4);
      AppMethodBeat.o(139930);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.b.d
 * JD-Core Version:    0.7.0.1
 */