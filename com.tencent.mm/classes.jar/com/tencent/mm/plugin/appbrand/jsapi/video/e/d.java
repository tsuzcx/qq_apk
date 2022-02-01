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
  private MediaPlayer lqh;
  private MediaPlayer.OnPreparedListener lqi;
  private MediaPlayer.OnVideoSizeChangedListener lqj;
  private MediaPlayer.OnCompletionListener lqk;
  private MediaPlayer.OnInfoListener lql;
  private MediaPlayer.OnSeekCompleteListener lqm;
  private MediaPlayer.OnErrorListener lqn;
  private MediaPlayer.OnBufferingUpdateListener lqo;
  
  public d()
  {
    AppMethodBeat.i(206245);
    this.lqi = new MediaPlayer.OnPreparedListener()
    {
      public final void onPrepared(MediaPlayer paramAnonymousMediaPlayer)
      {
        AppMethodBeat.i(206238);
        d.this.lpU = 2;
        d.this.bok();
        AppMethodBeat.o(206238);
      }
    };
    this.lqj = new MediaPlayer.OnVideoSizeChangedListener()
    {
      public final void onVideoSizeChanged(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(206239);
        d.this.dW(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(206239);
      }
    };
    this.lqk = new MediaPlayer.OnCompletionListener()
    {
      public final void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
      {
        AppMethodBeat.i(206240);
        d.this.lpU = 6;
        d.this.bol();
        AppMethodBeat.o(206240);
      }
    };
    this.lql = new MediaPlayer.OnInfoListener()
    {
      public final boolean onInfo(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(206241);
        boolean bool = d.this.dY(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(206241);
        return bool;
      }
    };
    this.lqm = new MediaPlayer.OnSeekCompleteListener()
    {
      public final void onSeekComplete(MediaPlayer paramAnonymousMediaPlayer)
      {
        AppMethodBeat.i(206242);
        d.this.bom();
        AppMethodBeat.o(206242);
      }
    };
    this.lqn = new MediaPlayer.OnErrorListener()
    {
      public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(206243);
        boolean bool = d.this.dX(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(206243);
        return bool;
      }
    };
    this.lqo = new MediaPlayer.OnBufferingUpdateListener()
    {
      public final void onBufferingUpdate(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt)
      {
        AppMethodBeat.i(206244);
        d.this.tC(paramAnonymousInt);
        AppMethodBeat.o(206244);
      }
    };
    this.lqh = new k();
    this.lqh.setScreenOnWhilePlaying(true);
    this.lqh.setAudioStreamType(3);
    this.lqh.setOnInfoListener(this.lql);
    this.lqh.setOnErrorListener(this.lqn);
    this.lqh.setOnPreparedListener(this.lqi);
    this.lqh.setOnCompletionListener(this.lqk);
    this.lqh.setOnSeekCompleteListener(this.lqm);
    this.lqh.setOnVideoSizeChangedListener(this.lqj);
    this.lqh.setOnBufferingUpdateListener(this.lqo);
    AppMethodBeat.o(206245);
  }
  
  private boolean available()
  {
    return this.lqh != null;
  }
  
  private void tD(int paramInt)
  {
    AppMethodBeat.i(206265);
    if (this.lqn != null) {
      this.lqn.onError(this.lqh, -1024, paramInt);
    }
    AppMethodBeat.o(206265);
  }
  
  public final boolean aF(float paramFloat)
  {
    AppMethodBeat.i(206250);
    if (paramFloat <= 0.0F)
    {
      AppMethodBeat.o(206250);
      return false;
    }
    try
    {
      if ((available()) && (Build.VERSION.SDK_INT >= 23))
      {
        PlaybackParams localPlaybackParams = this.lqh.getPlaybackParams();
        localPlaybackParams.setSpeed(paramFloat);
        if (!this.lqh.isPlaying())
        {
          this.lqh.setPlaybackParams(localPlaybackParams);
          this.lqh.pause();
        }
        for (;;)
        {
          AppMethodBeat.o(206250);
          return true;
          this.lqh.setPlaybackParams(localPlaybackParams);
        }
        AppMethodBeat.o(206250);
      }
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s setSpeed fail", new Object[] { Integer.valueOf(hashCode()) });
      tD(-14);
    }
    for (;;)
    {
      return false;
      ad.w("MicroMsg.SameLayer.SystemMediaPlayer", "%s setSpeed, current system(%d) not support play speed setting", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(Build.VERSION.SDK_INT) });
    }
  }
  
  public final void dD(String paramString1, String paramString2)
  {
    AppMethodBeat.i(206247);
    try
    {
      if (available())
      {
        if (paramString2 != null) {
          break label35;
        }
        this.lqh.setDataSource(paramString1);
      }
      for (;;)
      {
        this.lpU = 1;
        AppMethodBeat.o(206247);
        return;
        label35:
        ad.i("MicroMsg.SameLayer.SystemMediaPlayer", "setDataSource, referrer: ".concat(String.valueOf(paramString2)));
        paramString2 = com.tencent.mm.plugin.appbrand.jsapi.s.d.Qv(paramString2);
        this.lqh.setDataSource(aj.getContext(), Uri.parse(paramString1), paramString2);
      }
      return;
    }
    catch (Exception paramString1)
    {
      ad.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", paramString1, "%s setDataSource fail", new Object[] { Integer.valueOf(hashCode()) });
      tD(-11);
      AppMethodBeat.o(206247);
    }
  }
  
  public final int getCurrentPosition()
  {
    AppMethodBeat.i(206254);
    try
    {
      if ((available()) && ((this.lpU == 2) || (this.lpU == 3) || (this.lpU == 4) || (this.lpU == 6)))
      {
        int i = this.lqh.getCurrentPosition();
        AppMethodBeat.o(206254);
        return i;
      }
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s getCurrentPosition fail", new Object[] { Integer.valueOf(hashCode()) });
      tD(-15);
      AppMethodBeat.o(206254);
    }
    return 0;
  }
  
  public final int getDuration()
  {
    AppMethodBeat.i(206255);
    try
    {
      if ((available()) && (this.lpU != -1) && (this.lpU != 1) && (this.lpU != 0))
      {
        int i = this.lqh.getDuration();
        AppMethodBeat.o(206255);
        return i;
      }
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s getDuration fail", new Object[] { Integer.valueOf(hashCode()) });
      tD(-16);
      AppMethodBeat.o(206255);
    }
    return 0;
  }
  
  public final int getVideoHeight()
  {
    AppMethodBeat.i(206257);
    try
    {
      if (available())
      {
        int i = this.lqh.getVideoHeight();
        AppMethodBeat.o(206257);
        return i;
      }
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s getVideoHeight fail", new Object[] { Integer.valueOf(hashCode()) });
      tD(-18);
      AppMethodBeat.o(206257);
    }
    return 0;
  }
  
  public final int getVideoWidth()
  {
    AppMethodBeat.i(206256);
    try
    {
      if (available())
      {
        int i = this.lqh.getVideoWidth();
        AppMethodBeat.o(206256);
        return i;
      }
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s getVideoWidth fail", new Object[] { Integer.valueOf(hashCode()) });
      tD(-17);
      AppMethodBeat.o(206256);
    }
    return 0;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(206253);
    try
    {
      if ((available()) && (this.lpU != -1) && (this.lpU != -2) && (this.lpU != 0) && (this.lpU != 1))
      {
        boolean bool = this.lqh.isPlaying();
        AppMethodBeat.o(206253);
        return bool;
      }
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s isPlaying fail", new Object[] { Integer.valueOf(hashCode()) });
      tD(-9);
      AppMethodBeat.o(206253);
    }
    return false;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(206260);
    try
    {
      if ((available()) && ((this.lpU == 2) || (this.lpU == 3) || (this.lpU == 6)))
      {
        this.lqh.pause();
        this.lpU = 4;
      }
      AppMethodBeat.o(206260);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s pause fail", new Object[] { Integer.valueOf(hashCode()) });
      tD(-2);
      AppMethodBeat.o(206260);
    }
  }
  
  public final void prepareAsync()
  {
    AppMethodBeat.i(206258);
    try
    {
      if (available()) {
        this.lqh.prepareAsync();
      }
      AppMethodBeat.o(206258);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s prepareAsync fail", new Object[] { Integer.valueOf(hashCode()) });
      tD(-6);
      AppMethodBeat.o(206258);
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(206264);
    try
    {
      if (available())
      {
        if (this.lqh != null)
        {
          this.lqh.setOnInfoListener(null);
          this.lqh.setOnErrorListener(null);
          this.lqh.setOnPreparedListener(null);
          this.lqh.setOnCompletionListener(null);
          this.lqh.setOnSeekCompleteListener(null);
          this.lqh.setOnBufferingUpdateListener(null);
          this.lqh.setOnVideoSizeChangedListener(null);
        }
        this.lqh.release();
        this.lpU = -2;
        super.release();
      }
      AppMethodBeat.o(206264);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s release fail", new Object[] { Integer.valueOf(hashCode()) });
      tD(-8);
      AppMethodBeat.o(206264);
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(206263);
    try
    {
      if (available())
      {
        this.lqh.reset();
        this.lpU = 0;
      }
      AppMethodBeat.o(206263);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s reset fail", new Object[] { Integer.valueOf(hashCode()) });
      tD(-7);
      AppMethodBeat.o(206263);
    }
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(206261);
    try
    {
      if ((available()) && ((this.lpU == 2) || (this.lpU == 3) || (this.lpU == 4) || (this.lpU == 6))) {
        this.lqh.seekTo((int)paramLong);
      }
      AppMethodBeat.o(206261);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s seekTo fail", new Object[] { Integer.valueOf(hashCode()) });
      tD(-3);
      AppMethodBeat.o(206261);
    }
  }
  
  public final void setDataSource(String paramString)
  {
    AppMethodBeat.i(206246);
    dD(paramString, null);
    AppMethodBeat.o(206246);
  }
  
  public final void setLooping(boolean paramBoolean)
  {
    AppMethodBeat.i(206252);
    try
    {
      if (available()) {
        this.lqh.setLooping(paramBoolean);
      }
      AppMethodBeat.o(206252);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s setLooping fail", new Object[] { Integer.valueOf(hashCode()) });
      tD(-10);
      AppMethodBeat.o(206252);
    }
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(206251);
    if (available())
    {
      if (paramBoolean)
      {
        setVolume(0.0F, 0.0F);
        AppMethodBeat.o(206251);
        return;
      }
      setVolume(1.0F, 1.0F);
    }
    AppMethodBeat.o(206251);
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(206248);
    try
    {
      if (available()) {
        this.lqh.setSurface(paramSurface);
      }
      AppMethodBeat.o(206248);
      return;
    }
    catch (Exception paramSurface)
    {
      ad.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", paramSurface, "%s setSurface fail", new Object[] { Integer.valueOf(hashCode()) });
      tD(-12);
      AppMethodBeat.o(206248);
    }
  }
  
  public final void setVolume(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(206249);
    try
    {
      if (available()) {
        this.lqh.setVolume(paramFloat1, paramFloat2);
      }
      AppMethodBeat.o(206249);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s setVolume fail", new Object[] { Integer.valueOf(hashCode()) });
      tD(-13);
      AppMethodBeat.o(206249);
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(206259);
    try
    {
      if ((available()) && ((this.lpU == 2) || (this.lpU == 4) || (this.lpU == 6)))
      {
        this.lqh.start();
        this.lpU = 3;
      }
      AppMethodBeat.o(206259);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s start fail", new Object[] { Integer.valueOf(hashCode()) });
      tD(-1);
      AppMethodBeat.o(206259);
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(206262);
    try
    {
      if ((available()) && ((this.lpU == 2) || (this.lpU == 3) || (this.lpU == 4) || (this.lpU == 6)))
      {
        this.lqh.stop();
        this.lpU = 5;
      }
      AppMethodBeat.o(206262);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s stop fail", new Object[] { Integer.valueOf(hashCode()) });
      tD(-4);
      AppMethodBeat.o(206262);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.d
 * JD-Core Version:    0.7.0.1
 */