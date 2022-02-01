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
import com.tencent.mm.plugin.appbrand.jsapi.v.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class i
  extends a
{
  private MediaPlayer.OnCompletionListener pAa;
  private MediaPlayer.OnInfoListener pAb;
  private MediaPlayer.OnSeekCompleteListener pAc;
  private MediaPlayer.OnErrorListener pAd;
  private MediaPlayer.OnBufferingUpdateListener pAe;
  private MediaPlayer pzX;
  private MediaPlayer.OnPreparedListener pzY;
  private MediaPlayer.OnVideoSizeChangedListener pzZ;
  
  public i()
  {
    AppMethodBeat.i(227318);
    this.pzY = new MediaPlayer.OnPreparedListener()
    {
      public final void onPrepared(MediaPlayer paramAnonymousMediaPlayer)
      {
        AppMethodBeat.i(228081);
        i.this.pzp = 2;
        i.this.bWi();
        AppMethodBeat.o(228081);
      }
    };
    this.pzZ = new MediaPlayer.OnVideoSizeChangedListener()
    {
      public final void onVideoSizeChanged(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(228799);
        i.this.eG(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(228799);
      }
    };
    this.pAa = new MediaPlayer.OnCompletionListener()
    {
      public final void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
      {
        AppMethodBeat.i(228377);
        i.this.pzp = 6;
        i.this.bWj();
        AppMethodBeat.o(228377);
      }
    };
    this.pAb = new MediaPlayer.OnInfoListener()
    {
      public final boolean onInfo(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(228117);
        boolean bool = i.this.eI(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(228117);
        return bool;
      }
    };
    this.pAc = new MediaPlayer.OnSeekCompleteListener()
    {
      public final void onSeekComplete(MediaPlayer paramAnonymousMediaPlayer)
      {
        AppMethodBeat.i(229812);
        i.this.bWk();
        AppMethodBeat.o(229812);
      }
    };
    this.pAd = new MediaPlayer.OnErrorListener()
    {
      public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(229377);
        boolean bool = i.this.eH(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(229377);
        return bool;
      }
    };
    this.pAe = new MediaPlayer.OnBufferingUpdateListener()
    {
      public final void onBufferingUpdate(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt)
      {
        AppMethodBeat.i(230409);
        i.this.Bc(paramAnonymousInt);
        AppMethodBeat.o(230409);
      }
    };
    this.pzX = new k();
    this.pzX.setScreenOnWhilePlaying(true);
    this.pzX.setAudioStreamType(3);
    this.pzX.setOnInfoListener(this.pAb);
    this.pzX.setOnErrorListener(this.pAd);
    this.pzX.setOnPreparedListener(this.pzY);
    this.pzX.setOnCompletionListener(this.pAa);
    this.pzX.setOnSeekCompleteListener(this.pAc);
    this.pzX.setOnVideoSizeChangedListener(this.pzZ);
    this.pzX.setOnBufferingUpdateListener(this.pAe);
    AppMethodBeat.o(227318);
  }
  
  private void Bd(int paramInt)
  {
    AppMethodBeat.i(227383);
    if (this.pAd != null) {
      this.pAd.onError(this.pzX, -1024, paramInt);
    }
    AppMethodBeat.o(227383);
  }
  
  private boolean available()
  {
    return this.pzX != null;
  }
  
  public final boolean aP(float paramFloat)
  {
    AppMethodBeat.i(227332);
    if (paramFloat <= 0.0F)
    {
      AppMethodBeat.o(227332);
      return false;
    }
    try
    {
      if ((available()) && (Build.VERSION.SDK_INT >= 23))
      {
        PlaybackParams localPlaybackParams = this.pzX.getPlaybackParams();
        localPlaybackParams.setSpeed(paramFloat);
        if (!this.pzX.isPlaying())
        {
          this.pzX.setPlaybackParams(localPlaybackParams);
          this.pzX.pause();
        }
        for (;;)
        {
          AppMethodBeat.o(227332);
          return true;
          this.pzX.setPlaybackParams(localPlaybackParams);
        }
        AppMethodBeat.o(227332);
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s setSpeed fail", new Object[] { Integer.valueOf(hashCode()) });
      Bd(-14);
    }
    for (;;)
    {
      return false;
      Log.w("MicroMsg.SameLayer.SystemMediaPlayer", "%s setSpeed, current system(%d) not support play speed setting", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(Build.VERSION.SDK_INT) });
    }
  }
  
  public final void ef(String paramString1, String paramString2)
  {
    AppMethodBeat.i(227324);
    try
    {
      if (available())
      {
        if (paramString2 != null) {
          break label35;
        }
        this.pzX.setDataSource(paramString1);
      }
      for (;;)
      {
        this.pzp = 1;
        AppMethodBeat.o(227324);
        return;
        label35:
        Log.i("MicroMsg.SameLayer.SystemMediaPlayer", "setDataSource, referrer: ".concat(String.valueOf(paramString2)));
        paramString2 = d.aiy(paramString2);
        this.pzX.setDataSource(MMApplicationContext.getContext(), Uri.parse(paramString1), paramString2);
      }
      return;
    }
    catch (Exception paramString1)
    {
      Log.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", paramString1, "%s setDataSource fail", new Object[] { Integer.valueOf(hashCode()) });
      Bd(-11);
      AppMethodBeat.o(227324);
    }
  }
  
  public final int getCurrentPosition()
  {
    AppMethodBeat.i(227346);
    try
    {
      if ((available()) && ((this.pzp == 2) || (this.pzp == 3) || (this.pzp == 4) || (this.pzp == 6)))
      {
        int i = this.pzX.getCurrentPosition();
        AppMethodBeat.o(227346);
        return i;
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s getCurrentPosition fail", new Object[] { Integer.valueOf(hashCode()) });
      Bd(-15);
      AppMethodBeat.o(227346);
    }
    return 0;
  }
  
  public final int getDuration()
  {
    AppMethodBeat.i(227350);
    try
    {
      if ((available()) && (this.pzp != -1) && (this.pzp != 1) && (this.pzp != 0))
      {
        int i = this.pzX.getDuration();
        AppMethodBeat.o(227350);
        return i;
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s getDuration fail", new Object[] { Integer.valueOf(hashCode()) });
      Bd(-16);
      AppMethodBeat.o(227350);
    }
    return 0;
  }
  
  public final int getVideoHeight()
  {
    AppMethodBeat.i(227353);
    try
    {
      if (available())
      {
        int i = this.pzX.getVideoHeight();
        AppMethodBeat.o(227353);
        return i;
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s getVideoHeight fail", new Object[] { Integer.valueOf(hashCode()) });
      Bd(-18);
      AppMethodBeat.o(227353);
    }
    return 0;
  }
  
  public final int getVideoWidth()
  {
    AppMethodBeat.i(227351);
    try
    {
      if (available())
      {
        int i = this.pzX.getVideoWidth();
        AppMethodBeat.o(227351);
        return i;
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s getVideoWidth fail", new Object[] { Integer.valueOf(hashCode()) });
      Bd(-17);
      AppMethodBeat.o(227351);
    }
    return 0;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(227344);
    try
    {
      if ((available()) && (this.pzp != -1) && (this.pzp != -2) && (this.pzp != 0) && (this.pzp != 1))
      {
        boolean bool = this.pzX.isPlaying();
        AppMethodBeat.o(227344);
        return bool;
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s isPlaying fail", new Object[] { Integer.valueOf(hashCode()) });
      Bd(-9);
      AppMethodBeat.o(227344);
    }
    return false;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(227369);
    try
    {
      if ((available()) && ((this.pzp == 2) || (this.pzp == 3) || (this.pzp == 6)))
      {
        this.pzX.pause();
        this.pzp = 4;
      }
      AppMethodBeat.o(227369);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s pause fail", new Object[] { Integer.valueOf(hashCode()) });
      Bd(-2);
      AppMethodBeat.o(227369);
    }
  }
  
  public final void prepareAsync()
  {
    AppMethodBeat.i(227356);
    try
    {
      if (available()) {
        this.pzX.prepareAsync();
      }
      AppMethodBeat.o(227356);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s prepareAsync fail", new Object[] { Integer.valueOf(hashCode()) });
      Bd(-6);
      AppMethodBeat.o(227356);
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(227382);
    try
    {
      if (available())
      {
        if (this.pzX != null)
        {
          this.pzX.setOnInfoListener(null);
          this.pzX.setOnErrorListener(null);
          this.pzX.setOnPreparedListener(null);
          this.pzX.setOnCompletionListener(null);
          this.pzX.setOnSeekCompleteListener(null);
          this.pzX.setOnBufferingUpdateListener(null);
          this.pzX.setOnVideoSizeChangedListener(null);
        }
        this.pzX.release();
        this.pzp = -2;
        super.release();
      }
      AppMethodBeat.o(227382);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s release fail", new Object[] { Integer.valueOf(hashCode()) });
      Bd(-8);
      AppMethodBeat.o(227382);
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(227379);
    try
    {
      if (available())
      {
        this.pzX.reset();
        this.pzp = 0;
      }
      AppMethodBeat.o(227379);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s reset fail", new Object[] { Integer.valueOf(hashCode()) });
      Bd(-7);
      AppMethodBeat.o(227379);
    }
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(227372);
    try
    {
      if ((available()) && ((this.pzp == 2) || (this.pzp == 3) || (this.pzp == 4) || (this.pzp == 6))) {
        this.pzX.seekTo((int)paramLong);
      }
      AppMethodBeat.o(227372);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s seekTo fail", new Object[] { Integer.valueOf(hashCode()) });
      Bd(-3);
      AppMethodBeat.o(227372);
    }
  }
  
  public final void setDataSource(String paramString)
  {
    AppMethodBeat.i(227320);
    ef(paramString, null);
    AppMethodBeat.o(227320);
  }
  
  public final void setLooping(boolean paramBoolean)
  {
    AppMethodBeat.i(227340);
    try
    {
      if (available()) {
        this.pzX.setLooping(paramBoolean);
      }
      AppMethodBeat.o(227340);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s setLooping fail", new Object[] { Integer.valueOf(hashCode()) });
      Bd(-10);
      AppMethodBeat.o(227340);
    }
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(227335);
    if (available())
    {
      if (paramBoolean)
      {
        setVolume(0.0F, 0.0F);
        AppMethodBeat.o(227335);
        return;
      }
      setVolume(1.0F, 1.0F);
    }
    AppMethodBeat.o(227335);
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(227325);
    try
    {
      if (available()) {
        this.pzX.setSurface(paramSurface);
      }
      AppMethodBeat.o(227325);
      return;
    }
    catch (Exception paramSurface)
    {
      Log.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", paramSurface, "%s setSurface fail", new Object[] { Integer.valueOf(hashCode()) });
      Bd(-12);
      AppMethodBeat.o(227325);
    }
  }
  
  public final void setVolume(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(227326);
    try
    {
      if (available()) {
        this.pzX.setVolume(paramFloat1, paramFloat2);
      }
      AppMethodBeat.o(227326);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s setVolume fail", new Object[] { Integer.valueOf(hashCode()) });
      Bd(-13);
      AppMethodBeat.o(227326);
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(227364);
    try
    {
      if ((available()) && ((this.pzp == 2) || (this.pzp == 4) || (this.pzp == 6)))
      {
        this.pzX.start();
        this.pzp = 3;
      }
      AppMethodBeat.o(227364);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s start fail", new Object[] { Integer.valueOf(hashCode()) });
      Bd(-1);
      AppMethodBeat.o(227364);
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(227377);
    try
    {
      if ((available()) && ((this.pzp == 2) || (this.pzp == 3) || (this.pzp == 4) || (this.pzp == 6)))
      {
        this.pzX.stop();
        this.pzp = 5;
      }
      AppMethodBeat.o(227377);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s stop fail", new Object[] { Integer.valueOf(hashCode()) });
      Bd(-4);
      AppMethodBeat.o(227377);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.i
 * JD-Core Version:    0.7.0.1
 */