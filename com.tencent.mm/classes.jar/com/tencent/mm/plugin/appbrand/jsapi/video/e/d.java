package com.tencent.mm.plugin.appbrand.jsapi.video.e;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.media.PlaybackParams;
import android.net.Uri;
import android.os.Build.VERSION;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;

public final class d
  extends a
{
  private MediaPlayer kTD;
  private MediaPlayer.OnPreparedListener kTE;
  private MediaPlayer.OnVideoSizeChangedListener kTF;
  private MediaPlayer.OnCompletionListener kTG;
  private MediaPlayer.OnInfoListener kTH;
  private MediaPlayer.OnSeekCompleteListener kTI;
  private MediaPlayer.OnErrorListener kTJ;
  private MediaPlayer.OnBufferingUpdateListener kTK;
  
  public d()
  {
    AppMethodBeat.i(194433);
    this.kTE = new MediaPlayer.OnPreparedListener()
    {
      public final void onPrepared(MediaPlayer paramAnonymousMediaPlayer)
      {
        AppMethodBeat.i(194426);
        d.this.kTr = 2;
        d.this.bkz();
        AppMethodBeat.o(194426);
      }
    };
    this.kTF = new MediaPlayer.OnVideoSizeChangedListener()
    {
      public final void onVideoSizeChanged(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(194427);
        d.this.dU(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(194427);
      }
    };
    this.kTG = new MediaPlayer.OnCompletionListener()
    {
      public final void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
      {
        AppMethodBeat.i(194428);
        d.this.kTr = 6;
        d.this.bkA();
        AppMethodBeat.o(194428);
      }
    };
    this.kTH = new MediaPlayer.OnInfoListener()
    {
      public final boolean onInfo(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(194429);
        boolean bool = d.this.dW(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(194429);
        return bool;
      }
    };
    this.kTI = new MediaPlayer.OnSeekCompleteListener()
    {
      public final void onSeekComplete(MediaPlayer paramAnonymousMediaPlayer)
      {
        AppMethodBeat.i(194430);
        d.this.bkB();
        AppMethodBeat.o(194430);
      }
    };
    this.kTJ = new MediaPlayer.OnErrorListener()
    {
      public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(194431);
        boolean bool = d.this.dV(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(194431);
        return bool;
      }
    };
    this.kTK = new MediaPlayer.OnBufferingUpdateListener()
    {
      public final void onBufferingUpdate(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt)
      {
        AppMethodBeat.i(194432);
        d.this.sZ(paramAnonymousInt);
        AppMethodBeat.o(194432);
      }
    };
    this.kTD = new k();
    this.kTD.setScreenOnWhilePlaying(true);
    this.kTD.setAudioStreamType(3);
    this.kTD.setOnInfoListener(this.kTH);
    this.kTD.setOnErrorListener(this.kTJ);
    this.kTD.setOnPreparedListener(this.kTE);
    this.kTD.setOnCompletionListener(this.kTG);
    this.kTD.setOnSeekCompleteListener(this.kTI);
    this.kTD.setOnVideoSizeChangedListener(this.kTF);
    this.kTD.setOnBufferingUpdateListener(this.kTK);
    AppMethodBeat.o(194433);
  }
  
  private boolean available()
  {
    return this.kTD != null;
  }
  
  private void ta(int paramInt)
  {
    AppMethodBeat.i(194453);
    if (this.kTJ != null) {
      this.kTJ.onError(this.kTD, -1024, paramInt);
    }
    AppMethodBeat.o(194453);
  }
  
  public final boolean aC(float paramFloat)
  {
    AppMethodBeat.i(194438);
    if (paramFloat <= 0.0F)
    {
      AppMethodBeat.o(194438);
      return false;
    }
    try
    {
      if ((available()) && (Build.VERSION.SDK_INT >= 23))
      {
        PlaybackParams localPlaybackParams = this.kTD.getPlaybackParams();
        localPlaybackParams.setSpeed(paramFloat);
        if (!this.kTD.isPlaying())
        {
          this.kTD.setPlaybackParams(localPlaybackParams);
          this.kTD.pause();
        }
        for (;;)
        {
          AppMethodBeat.o(194438);
          return true;
          this.kTD.setPlaybackParams(localPlaybackParams);
        }
        AppMethodBeat.o(194438);
      }
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s setSpeed fail", new Object[] { Integer.valueOf(hashCode()) });
      ta(-14);
    }
    for (;;)
    {
      return false;
      ac.w("MicroMsg.SameLayer.SystemMediaPlayer", "%s setSpeed, current system(%d) not support play speed setting", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(Build.VERSION.SDK_INT) });
    }
  }
  
  public final void dB(String paramString1, String paramString2)
  {
    AppMethodBeat.i(194435);
    try
    {
      if (available())
      {
        if (paramString2 != null) {
          break label35;
        }
        this.kTD.setDataSource(paramString1);
      }
      for (;;)
      {
        this.kTr = 1;
        AppMethodBeat.o(194435);
        return;
        label35:
        ac.i("MicroMsg.SameLayer.SystemMediaPlayer", "setDataSource, referrer: ".concat(String.valueOf(paramString2)));
        paramString2 = com.tencent.mm.plugin.appbrand.jsapi.p.d.MY(paramString2);
        this.kTD.setDataSource(ai.getContext(), Uri.parse(paramString1), paramString2);
      }
      return;
    }
    catch (Exception paramString1)
    {
      ac.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", paramString1, "%s setDataSource fail", new Object[] { Integer.valueOf(hashCode()) });
      ta(-11);
      AppMethodBeat.o(194435);
    }
  }
  
  public final int getCurrentPosition()
  {
    AppMethodBeat.i(194442);
    try
    {
      if ((available()) && ((this.kTr == 2) || (this.kTr == 3) || (this.kTr == 4) || (this.kTr == 6)))
      {
        int i = this.kTD.getCurrentPosition();
        AppMethodBeat.o(194442);
        return i;
      }
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s getCurrentPosition fail", new Object[] { Integer.valueOf(hashCode()) });
      ta(-15);
      AppMethodBeat.o(194442);
    }
    return 0;
  }
  
  public final int getDuration()
  {
    AppMethodBeat.i(194443);
    try
    {
      if ((available()) && (this.kTr != -1) && (this.kTr != 1) && (this.kTr != 0))
      {
        int i = this.kTD.getDuration();
        AppMethodBeat.o(194443);
        return i;
      }
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s getDuration fail", new Object[] { Integer.valueOf(hashCode()) });
      ta(-16);
      AppMethodBeat.o(194443);
    }
    return 0;
  }
  
  public final int getVideoHeight()
  {
    AppMethodBeat.i(194445);
    try
    {
      if (available())
      {
        int i = this.kTD.getVideoHeight();
        AppMethodBeat.o(194445);
        return i;
      }
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s getVideoHeight fail", new Object[] { Integer.valueOf(hashCode()) });
      ta(-18);
      AppMethodBeat.o(194445);
    }
    return 0;
  }
  
  public final int getVideoWidth()
  {
    AppMethodBeat.i(194444);
    try
    {
      if (available())
      {
        int i = this.kTD.getVideoWidth();
        AppMethodBeat.o(194444);
        return i;
      }
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s getVideoWidth fail", new Object[] { Integer.valueOf(hashCode()) });
      ta(-17);
      AppMethodBeat.o(194444);
    }
    return 0;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(194441);
    try
    {
      if ((available()) && (this.kTr != -1) && (this.kTr != -2) && (this.kTr != 0) && (this.kTr != 1))
      {
        boolean bool = this.kTD.isPlaying();
        AppMethodBeat.o(194441);
        return bool;
      }
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s isPlaying fail", new Object[] { Integer.valueOf(hashCode()) });
      ta(-9);
      AppMethodBeat.o(194441);
    }
    return false;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(194448);
    try
    {
      if ((available()) && ((this.kTr == 2) || (this.kTr == 3) || (this.kTr == 6)))
      {
        this.kTD.pause();
        this.kTr = 4;
      }
      AppMethodBeat.o(194448);
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s pause fail", new Object[] { Integer.valueOf(hashCode()) });
      ta(-2);
      AppMethodBeat.o(194448);
    }
  }
  
  public final void prepareAsync()
  {
    AppMethodBeat.i(194446);
    try
    {
      if (available()) {
        this.kTD.prepareAsync();
      }
      AppMethodBeat.o(194446);
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s prepareAsync fail", new Object[] { Integer.valueOf(hashCode()) });
      ta(-6);
      AppMethodBeat.o(194446);
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(194452);
    try
    {
      if (available())
      {
        if (this.kTD != null)
        {
          this.kTD.setOnInfoListener(null);
          this.kTD.setOnErrorListener(null);
          this.kTD.setOnPreparedListener(null);
          this.kTD.setOnCompletionListener(null);
          this.kTD.setOnSeekCompleteListener(null);
          this.kTD.setOnBufferingUpdateListener(null);
          this.kTD.setOnVideoSizeChangedListener(null);
        }
        this.kTD.release();
        this.kTr = -2;
        super.release();
      }
      AppMethodBeat.o(194452);
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s release fail", new Object[] { Integer.valueOf(hashCode()) });
      ta(-8);
      AppMethodBeat.o(194452);
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(194451);
    try
    {
      if (available())
      {
        this.kTD.reset();
        this.kTr = 0;
      }
      AppMethodBeat.o(194451);
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s reset fail", new Object[] { Integer.valueOf(hashCode()) });
      ta(-7);
      AppMethodBeat.o(194451);
    }
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(194449);
    try
    {
      if ((available()) && ((this.kTr == 2) || (this.kTr == 3) || (this.kTr == 4) || (this.kTr == 6))) {
        this.kTD.seekTo((int)paramLong);
      }
      AppMethodBeat.o(194449);
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s seekTo fail", new Object[] { Integer.valueOf(hashCode()) });
      ta(-3);
      AppMethodBeat.o(194449);
    }
  }
  
  public final void setDataSource(String paramString)
  {
    AppMethodBeat.i(194434);
    dB(paramString, null);
    AppMethodBeat.o(194434);
  }
  
  public final void setLooping(boolean paramBoolean)
  {
    AppMethodBeat.i(194440);
    try
    {
      if (available()) {
        this.kTD.setLooping(paramBoolean);
      }
      AppMethodBeat.o(194440);
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s setLooping fail", new Object[] { Integer.valueOf(hashCode()) });
      ta(-10);
      AppMethodBeat.o(194440);
    }
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(194439);
    if (available())
    {
      if (paramBoolean)
      {
        setVolume(0.0F, 0.0F);
        AppMethodBeat.o(194439);
        return;
      }
      setVolume(1.0F, 1.0F);
    }
    AppMethodBeat.o(194439);
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(194436);
    try
    {
      if (available()) {
        this.kTD.setSurface(paramSurface);
      }
      AppMethodBeat.o(194436);
      return;
    }
    catch (Exception paramSurface)
    {
      ac.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", paramSurface, "%s setSurface fail", new Object[] { Integer.valueOf(hashCode()) });
      ta(-12);
      AppMethodBeat.o(194436);
    }
  }
  
  public final void setVolume(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(194437);
    try
    {
      if (available()) {
        this.kTD.setVolume(paramFloat1, paramFloat2);
      }
      AppMethodBeat.o(194437);
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s setVolume fail", new Object[] { Integer.valueOf(hashCode()) });
      ta(-13);
      AppMethodBeat.o(194437);
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(194447);
    try
    {
      if ((available()) && ((this.kTr == 2) || (this.kTr == 4) || (this.kTr == 6)))
      {
        this.kTD.start();
        this.kTr = 3;
      }
      AppMethodBeat.o(194447);
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s start fail", new Object[] { Integer.valueOf(hashCode()) });
      ta(-1);
      AppMethodBeat.o(194447);
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(194450);
    try
    {
      if ((available()) && ((this.kTr == 2) || (this.kTr == 3) || (this.kTr == 4) || (this.kTr == 6)))
      {
        this.kTD.stop();
        this.kTr = 5;
      }
      AppMethodBeat.o(194450);
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s stop fail", new Object[] { Integer.valueOf(hashCode()) });
      ta(-4);
      AppMethodBeat.o(194450);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.d
 * JD-Core Version:    0.7.0.1
 */