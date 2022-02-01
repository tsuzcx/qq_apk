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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;

public final class d
  extends a
{
  private MediaPlayer luF;
  private MediaPlayer.OnPreparedListener luG;
  private MediaPlayer.OnVideoSizeChangedListener luH;
  private MediaPlayer.OnCompletionListener luI;
  private MediaPlayer.OnInfoListener luJ;
  private MediaPlayer.OnSeekCompleteListener luK;
  private MediaPlayer.OnErrorListener luL;
  private MediaPlayer.OnBufferingUpdateListener luM;
  
  public d()
  {
    AppMethodBeat.i(211273);
    this.luG = new MediaPlayer.OnPreparedListener()
    {
      public final void onPrepared(MediaPlayer paramAnonymousMediaPlayer)
      {
        AppMethodBeat.i(211266);
        d.this.lur = 2;
        d.this.boU();
        AppMethodBeat.o(211266);
      }
    };
    this.luH = new MediaPlayer.OnVideoSizeChangedListener()
    {
      public final void onVideoSizeChanged(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(211267);
        d.this.dW(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(211267);
      }
    };
    this.luI = new MediaPlayer.OnCompletionListener()
    {
      public final void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
      {
        AppMethodBeat.i(211268);
        d.this.lur = 6;
        d.this.boV();
        AppMethodBeat.o(211268);
      }
    };
    this.luJ = new MediaPlayer.OnInfoListener()
    {
      public final boolean onInfo(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(211269);
        boolean bool = d.this.dY(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(211269);
        return bool;
      }
    };
    this.luK = new MediaPlayer.OnSeekCompleteListener()
    {
      public final void onSeekComplete(MediaPlayer paramAnonymousMediaPlayer)
      {
        AppMethodBeat.i(211270);
        d.this.boW();
        AppMethodBeat.o(211270);
      }
    };
    this.luL = new MediaPlayer.OnErrorListener()
    {
      public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(211271);
        boolean bool = d.this.dX(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(211271);
        return bool;
      }
    };
    this.luM = new MediaPlayer.OnBufferingUpdateListener()
    {
      public final void onBufferingUpdate(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt)
      {
        AppMethodBeat.i(211272);
        d.this.tH(paramAnonymousInt);
        AppMethodBeat.o(211272);
      }
    };
    this.luF = new k();
    this.luF.setScreenOnWhilePlaying(true);
    this.luF.setAudioStreamType(3);
    this.luF.setOnInfoListener(this.luJ);
    this.luF.setOnErrorListener(this.luL);
    this.luF.setOnPreparedListener(this.luG);
    this.luF.setOnCompletionListener(this.luI);
    this.luF.setOnSeekCompleteListener(this.luK);
    this.luF.setOnVideoSizeChangedListener(this.luH);
    this.luF.setOnBufferingUpdateListener(this.luM);
    AppMethodBeat.o(211273);
  }
  
  private boolean available()
  {
    return this.luF != null;
  }
  
  private void tI(int paramInt)
  {
    AppMethodBeat.i(211293);
    if (this.luL != null) {
      this.luL.onError(this.luF, -1024, paramInt);
    }
    AppMethodBeat.o(211293);
  }
  
  public final boolean aF(float paramFloat)
  {
    AppMethodBeat.i(211278);
    if (paramFloat <= 0.0F)
    {
      AppMethodBeat.o(211278);
      return false;
    }
    try
    {
      if ((available()) && (Build.VERSION.SDK_INT >= 23))
      {
        PlaybackParams localPlaybackParams = this.luF.getPlaybackParams();
        localPlaybackParams.setSpeed(paramFloat);
        if (!this.luF.isPlaying())
        {
          this.luF.setPlaybackParams(localPlaybackParams);
          this.luF.pause();
        }
        for (;;)
        {
          AppMethodBeat.o(211278);
          return true;
          this.luF.setPlaybackParams(localPlaybackParams);
        }
        AppMethodBeat.o(211278);
      }
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s setSpeed fail", new Object[] { Integer.valueOf(hashCode()) });
      tI(-14);
    }
    for (;;)
    {
      return false;
      ae.w("MicroMsg.SameLayer.SystemMediaPlayer", "%s setSpeed, current system(%d) not support play speed setting", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(Build.VERSION.SDK_INT) });
    }
  }
  
  public final void dF(String paramString1, String paramString2)
  {
    AppMethodBeat.i(211275);
    try
    {
      if (available())
      {
        if (paramString2 != null) {
          break label35;
        }
        this.luF.setDataSource(paramString1);
      }
      for (;;)
      {
        this.lur = 1;
        AppMethodBeat.o(211275);
        return;
        label35:
        ae.i("MicroMsg.SameLayer.SystemMediaPlayer", "setDataSource, referrer: ".concat(String.valueOf(paramString2)));
        paramString2 = com.tencent.mm.plugin.appbrand.jsapi.s.d.Re(paramString2);
        this.luF.setDataSource(ak.getContext(), Uri.parse(paramString1), paramString2);
      }
      return;
    }
    catch (Exception paramString1)
    {
      ae.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", paramString1, "%s setDataSource fail", new Object[] { Integer.valueOf(hashCode()) });
      tI(-11);
      AppMethodBeat.o(211275);
    }
  }
  
  public final int getCurrentPosition()
  {
    AppMethodBeat.i(211282);
    try
    {
      if ((available()) && ((this.lur == 2) || (this.lur == 3) || (this.lur == 4) || (this.lur == 6)))
      {
        int i = this.luF.getCurrentPosition();
        AppMethodBeat.o(211282);
        return i;
      }
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s getCurrentPosition fail", new Object[] { Integer.valueOf(hashCode()) });
      tI(-15);
      AppMethodBeat.o(211282);
    }
    return 0;
  }
  
  public final int getDuration()
  {
    AppMethodBeat.i(211283);
    try
    {
      if ((available()) && (this.lur != -1) && (this.lur != 1) && (this.lur != 0))
      {
        int i = this.luF.getDuration();
        AppMethodBeat.o(211283);
        return i;
      }
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s getDuration fail", new Object[] { Integer.valueOf(hashCode()) });
      tI(-16);
      AppMethodBeat.o(211283);
    }
    return 0;
  }
  
  public final int getVideoHeight()
  {
    AppMethodBeat.i(211285);
    try
    {
      if (available())
      {
        int i = this.luF.getVideoHeight();
        AppMethodBeat.o(211285);
        return i;
      }
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s getVideoHeight fail", new Object[] { Integer.valueOf(hashCode()) });
      tI(-18);
      AppMethodBeat.o(211285);
    }
    return 0;
  }
  
  public final int getVideoWidth()
  {
    AppMethodBeat.i(211284);
    try
    {
      if (available())
      {
        int i = this.luF.getVideoWidth();
        AppMethodBeat.o(211284);
        return i;
      }
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s getVideoWidth fail", new Object[] { Integer.valueOf(hashCode()) });
      tI(-17);
      AppMethodBeat.o(211284);
    }
    return 0;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(211281);
    try
    {
      if ((available()) && (this.lur != -1) && (this.lur != -2) && (this.lur != 0) && (this.lur != 1))
      {
        boolean bool = this.luF.isPlaying();
        AppMethodBeat.o(211281);
        return bool;
      }
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s isPlaying fail", new Object[] { Integer.valueOf(hashCode()) });
      tI(-9);
      AppMethodBeat.o(211281);
    }
    return false;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(211288);
    try
    {
      if ((available()) && ((this.lur == 2) || (this.lur == 3) || (this.lur == 6)))
      {
        this.luF.pause();
        this.lur = 4;
      }
      AppMethodBeat.o(211288);
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s pause fail", new Object[] { Integer.valueOf(hashCode()) });
      tI(-2);
      AppMethodBeat.o(211288);
    }
  }
  
  public final void prepareAsync()
  {
    AppMethodBeat.i(211286);
    try
    {
      if (available()) {
        this.luF.prepareAsync();
      }
      AppMethodBeat.o(211286);
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s prepareAsync fail", new Object[] { Integer.valueOf(hashCode()) });
      tI(-6);
      AppMethodBeat.o(211286);
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(211292);
    try
    {
      if (available())
      {
        if (this.luF != null)
        {
          this.luF.setOnInfoListener(null);
          this.luF.setOnErrorListener(null);
          this.luF.setOnPreparedListener(null);
          this.luF.setOnCompletionListener(null);
          this.luF.setOnSeekCompleteListener(null);
          this.luF.setOnBufferingUpdateListener(null);
          this.luF.setOnVideoSizeChangedListener(null);
        }
        this.luF.release();
        this.lur = -2;
        super.release();
      }
      AppMethodBeat.o(211292);
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s release fail", new Object[] { Integer.valueOf(hashCode()) });
      tI(-8);
      AppMethodBeat.o(211292);
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(211291);
    try
    {
      if (available())
      {
        this.luF.reset();
        this.lur = 0;
      }
      AppMethodBeat.o(211291);
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s reset fail", new Object[] { Integer.valueOf(hashCode()) });
      tI(-7);
      AppMethodBeat.o(211291);
    }
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(211289);
    try
    {
      if ((available()) && ((this.lur == 2) || (this.lur == 3) || (this.lur == 4) || (this.lur == 6))) {
        this.luF.seekTo((int)paramLong);
      }
      AppMethodBeat.o(211289);
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s seekTo fail", new Object[] { Integer.valueOf(hashCode()) });
      tI(-3);
      AppMethodBeat.o(211289);
    }
  }
  
  public final void setDataSource(String paramString)
  {
    AppMethodBeat.i(211274);
    dF(paramString, null);
    AppMethodBeat.o(211274);
  }
  
  public final void setLooping(boolean paramBoolean)
  {
    AppMethodBeat.i(211280);
    try
    {
      if (available()) {
        this.luF.setLooping(paramBoolean);
      }
      AppMethodBeat.o(211280);
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s setLooping fail", new Object[] { Integer.valueOf(hashCode()) });
      tI(-10);
      AppMethodBeat.o(211280);
    }
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(211279);
    if (available())
    {
      if (paramBoolean)
      {
        setVolume(0.0F, 0.0F);
        AppMethodBeat.o(211279);
        return;
      }
      setVolume(1.0F, 1.0F);
    }
    AppMethodBeat.o(211279);
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(211276);
    try
    {
      if (available()) {
        this.luF.setSurface(paramSurface);
      }
      AppMethodBeat.o(211276);
      return;
    }
    catch (Exception paramSurface)
    {
      ae.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", paramSurface, "%s setSurface fail", new Object[] { Integer.valueOf(hashCode()) });
      tI(-12);
      AppMethodBeat.o(211276);
    }
  }
  
  public final void setVolume(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(211277);
    try
    {
      if (available()) {
        this.luF.setVolume(paramFloat1, paramFloat2);
      }
      AppMethodBeat.o(211277);
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s setVolume fail", new Object[] { Integer.valueOf(hashCode()) });
      tI(-13);
      AppMethodBeat.o(211277);
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(211287);
    try
    {
      if ((available()) && ((this.lur == 2) || (this.lur == 4) || (this.lur == 6)))
      {
        this.luF.start();
        this.lur = 3;
      }
      AppMethodBeat.o(211287);
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s start fail", new Object[] { Integer.valueOf(hashCode()) });
      tI(-1);
      AppMethodBeat.o(211287);
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(211290);
    try
    {
      if ((available()) && ((this.lur == 2) || (this.lur == 3) || (this.lur == 4) || (this.lur == 6)))
      {
        this.luF.stop();
        this.lur = 5;
      }
      AppMethodBeat.o(211290);
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s stop fail", new Object[] { Integer.valueOf(hashCode()) });
      tI(-4);
      AppMethodBeat.o(211290);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.d
 * JD-Core Version:    0.7.0.1
 */