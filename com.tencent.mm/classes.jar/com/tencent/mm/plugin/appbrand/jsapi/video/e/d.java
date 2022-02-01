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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;

public final class d
  extends a
{
  private MediaPlayer ksn;
  private MediaPlayer.OnPreparedListener kso;
  private MediaPlayer.OnVideoSizeChangedListener ksp;
  private MediaPlayer.OnCompletionListener ksq;
  private MediaPlayer.OnInfoListener ksr;
  private MediaPlayer.OnSeekCompleteListener kss;
  private MediaPlayer.OnErrorListener kst;
  private MediaPlayer.OnBufferingUpdateListener ksu;
  
  public d()
  {
    AppMethodBeat.i(194088);
    this.kso = new MediaPlayer.OnPreparedListener()
    {
      public final void onPrepared(MediaPlayer paramAnonymousMediaPlayer)
      {
        AppMethodBeat.i(194081);
        d.this.ksb = 2;
        d.this.bdF();
        AppMethodBeat.o(194081);
      }
    };
    this.ksp = new MediaPlayer.OnVideoSizeChangedListener()
    {
      public final void onVideoSizeChanged(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(194082);
        d.this.dT(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(194082);
      }
    };
    this.ksq = new MediaPlayer.OnCompletionListener()
    {
      public final void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
      {
        AppMethodBeat.i(194083);
        d.this.ksb = 6;
        d.this.bdG();
        AppMethodBeat.o(194083);
      }
    };
    this.ksr = new MediaPlayer.OnInfoListener()
    {
      public final boolean onInfo(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(194084);
        boolean bool = d.this.dV(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(194084);
        return bool;
      }
    };
    this.kss = new MediaPlayer.OnSeekCompleteListener()
    {
      public final void onSeekComplete(MediaPlayer paramAnonymousMediaPlayer)
      {
        AppMethodBeat.i(194085);
        d.this.bdH();
        AppMethodBeat.o(194085);
      }
    };
    this.kst = new MediaPlayer.OnErrorListener()
    {
      public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(194086);
        boolean bool = d.this.dU(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(194086);
        return bool;
      }
    };
    this.ksu = new MediaPlayer.OnBufferingUpdateListener()
    {
      public final void onBufferingUpdate(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt)
      {
        AppMethodBeat.i(194087);
        d.this.sj(paramAnonymousInt);
        AppMethodBeat.o(194087);
      }
    };
    this.ksn = new k();
    this.ksn.setScreenOnWhilePlaying(true);
    this.ksn.setAudioStreamType(3);
    this.ksn.setOnInfoListener(this.ksr);
    this.ksn.setOnErrorListener(this.kst);
    this.ksn.setOnPreparedListener(this.kso);
    this.ksn.setOnCompletionListener(this.ksq);
    this.ksn.setOnSeekCompleteListener(this.kss);
    this.ksn.setOnVideoSizeChangedListener(this.ksp);
    this.ksn.setOnBufferingUpdateListener(this.ksu);
    AppMethodBeat.o(194088);
  }
  
  private boolean available()
  {
    return this.ksn != null;
  }
  
  private void sk(int paramInt)
  {
    AppMethodBeat.i(194108);
    if (this.kst != null) {
      this.kst.onError(this.ksn, -1024, paramInt);
    }
    AppMethodBeat.o(194108);
  }
  
  public final boolean ay(float paramFloat)
  {
    AppMethodBeat.i(194093);
    if (paramFloat <= 0.0F)
    {
      AppMethodBeat.o(194093);
      return false;
    }
    try
    {
      if ((available()) && (Build.VERSION.SDK_INT >= 23))
      {
        PlaybackParams localPlaybackParams = this.ksn.getPlaybackParams();
        localPlaybackParams.setSpeed(paramFloat);
        if (!this.ksn.isPlaying())
        {
          this.ksn.setPlaybackParams(localPlaybackParams);
          this.ksn.pause();
        }
        for (;;)
        {
          AppMethodBeat.o(194093);
          return true;
          this.ksn.setPlaybackParams(localPlaybackParams);
        }
        AppMethodBeat.o(194093);
      }
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s setSpeed fail", new Object[] { Integer.valueOf(hashCode()) });
      sk(-14);
    }
    for (;;)
    {
      return false;
      ad.w("MicroMsg.SameLayer.SystemMediaPlayer", "%s setSpeed, current system(%d) not support play speed setting", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(Build.VERSION.SDK_INT) });
    }
  }
  
  public final void dp(String paramString1, String paramString2)
  {
    AppMethodBeat.i(194090);
    try
    {
      if (available())
      {
        if (paramString2 != null) {
          break label35;
        }
        this.ksn.setDataSource(paramString1);
      }
      for (;;)
      {
        this.ksb = 1;
        AppMethodBeat.o(194090);
        return;
        label35:
        ad.i("MicroMsg.SameLayer.SystemMediaPlayer", "setDataSource, referrer: ".concat(String.valueOf(paramString2)));
        paramString2 = com.tencent.mm.plugin.appbrand.jsapi.q.d.IV(paramString2);
        this.ksn.setDataSource(aj.getContext(), Uri.parse(paramString1), paramString2);
      }
      return;
    }
    catch (Exception paramString1)
    {
      ad.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", paramString1, "%s setDataSource fail", new Object[] { Integer.valueOf(hashCode()) });
      sk(-11);
      AppMethodBeat.o(194090);
    }
  }
  
  public final int getCurrentPosition()
  {
    AppMethodBeat.i(194097);
    try
    {
      if ((available()) && ((this.ksb == 2) || (this.ksb == 3) || (this.ksb == 4) || (this.ksb == 6)))
      {
        int i = this.ksn.getCurrentPosition();
        AppMethodBeat.o(194097);
        return i;
      }
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s getCurrentPosition fail", new Object[] { Integer.valueOf(hashCode()) });
      sk(-15);
      AppMethodBeat.o(194097);
    }
    return 0;
  }
  
  public final int getDuration()
  {
    AppMethodBeat.i(194098);
    try
    {
      if ((available()) && (this.ksb != -1) && (this.ksb != 1) && (this.ksb != 0))
      {
        int i = this.ksn.getDuration();
        AppMethodBeat.o(194098);
        return i;
      }
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s getDuration fail", new Object[] { Integer.valueOf(hashCode()) });
      sk(-16);
      AppMethodBeat.o(194098);
    }
    return 0;
  }
  
  public final int getVideoHeight()
  {
    AppMethodBeat.i(194100);
    try
    {
      if (available())
      {
        int i = this.ksn.getVideoHeight();
        AppMethodBeat.o(194100);
        return i;
      }
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s getVideoHeight fail", new Object[] { Integer.valueOf(hashCode()) });
      sk(-18);
      AppMethodBeat.o(194100);
    }
    return 0;
  }
  
  public final int getVideoWidth()
  {
    AppMethodBeat.i(194099);
    try
    {
      if (available())
      {
        int i = this.ksn.getVideoWidth();
        AppMethodBeat.o(194099);
        return i;
      }
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s getVideoWidth fail", new Object[] { Integer.valueOf(hashCode()) });
      sk(-17);
      AppMethodBeat.o(194099);
    }
    return 0;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(194096);
    try
    {
      if ((available()) && (this.ksb != -1) && (this.ksb != -2) && (this.ksb != 0) && (this.ksb != 1))
      {
        boolean bool = this.ksn.isPlaying();
        AppMethodBeat.o(194096);
        return bool;
      }
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s isPlaying fail", new Object[] { Integer.valueOf(hashCode()) });
      sk(-9);
      AppMethodBeat.o(194096);
    }
    return false;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(194103);
    try
    {
      if ((available()) && ((this.ksb == 2) || (this.ksb == 3) || (this.ksb == 6)))
      {
        this.ksn.pause();
        this.ksb = 4;
      }
      AppMethodBeat.o(194103);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s pause fail", new Object[] { Integer.valueOf(hashCode()) });
      sk(-2);
      AppMethodBeat.o(194103);
    }
  }
  
  public final void prepareAsync()
  {
    AppMethodBeat.i(194101);
    try
    {
      if (available()) {
        this.ksn.prepareAsync();
      }
      AppMethodBeat.o(194101);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s prepareAsync fail", new Object[] { Integer.valueOf(hashCode()) });
      sk(-6);
      AppMethodBeat.o(194101);
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(194107);
    try
    {
      if (available())
      {
        if (this.ksn != null)
        {
          this.ksn.setOnInfoListener(null);
          this.ksn.setOnErrorListener(null);
          this.ksn.setOnPreparedListener(null);
          this.ksn.setOnCompletionListener(null);
          this.ksn.setOnSeekCompleteListener(null);
          this.ksn.setOnBufferingUpdateListener(null);
          this.ksn.setOnVideoSizeChangedListener(null);
        }
        this.ksn.release();
        this.ksb = -2;
        super.release();
      }
      AppMethodBeat.o(194107);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s release fail", new Object[] { Integer.valueOf(hashCode()) });
      sk(-8);
      AppMethodBeat.o(194107);
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(194106);
    try
    {
      if (available())
      {
        this.ksn.reset();
        this.ksb = 0;
      }
      AppMethodBeat.o(194106);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s reset fail", new Object[] { Integer.valueOf(hashCode()) });
      sk(-7);
      AppMethodBeat.o(194106);
    }
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(194104);
    try
    {
      if ((available()) && ((this.ksb == 2) || (this.ksb == 3) || (this.ksb == 4) || (this.ksb == 6))) {
        this.ksn.seekTo((int)paramLong);
      }
      AppMethodBeat.o(194104);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s seekTo fail", new Object[] { Integer.valueOf(hashCode()) });
      sk(-3);
      AppMethodBeat.o(194104);
    }
  }
  
  public final void setDataSource(String paramString)
  {
    AppMethodBeat.i(194089);
    dp(paramString, null);
    AppMethodBeat.o(194089);
  }
  
  public final void setLooping(boolean paramBoolean)
  {
    AppMethodBeat.i(194095);
    try
    {
      if (available()) {
        this.ksn.setLooping(paramBoolean);
      }
      AppMethodBeat.o(194095);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s setLooping fail", new Object[] { Integer.valueOf(hashCode()) });
      sk(-10);
      AppMethodBeat.o(194095);
    }
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(194094);
    if (available())
    {
      if (paramBoolean)
      {
        setVolume(0.0F, 0.0F);
        AppMethodBeat.o(194094);
        return;
      }
      setVolume(1.0F, 1.0F);
    }
    AppMethodBeat.o(194094);
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(194091);
    try
    {
      if (available()) {
        this.ksn.setSurface(paramSurface);
      }
      AppMethodBeat.o(194091);
      return;
    }
    catch (Exception paramSurface)
    {
      ad.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", paramSurface, "%s setSurface fail", new Object[] { Integer.valueOf(hashCode()) });
      sk(-12);
      AppMethodBeat.o(194091);
    }
  }
  
  public final void setVolume(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(194092);
    try
    {
      if (available()) {
        this.ksn.setVolume(paramFloat1, paramFloat2);
      }
      AppMethodBeat.o(194092);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s setVolume fail", new Object[] { Integer.valueOf(hashCode()) });
      sk(-13);
      AppMethodBeat.o(194092);
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(194102);
    try
    {
      if ((available()) && ((this.ksb == 2) || (this.ksb == 4) || (this.ksb == 6)))
      {
        this.ksn.start();
        this.ksb = 3;
      }
      AppMethodBeat.o(194102);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s start fail", new Object[] { Integer.valueOf(hashCode()) });
      sk(-1);
      AppMethodBeat.o(194102);
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(194105);
    try
    {
      if ((available()) && ((this.ksb == 2) || (this.ksb == 3) || (this.ksb == 4) || (this.ksb == 6)))
      {
        this.ksn.stop();
        this.ksb = 5;
      }
      AppMethodBeat.o(194105);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s stop fail", new Object[] { Integer.valueOf(hashCode()) });
      sk(-4);
      AppMethodBeat.o(194105);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.d
 * JD-Core Version:    0.7.0.1
 */