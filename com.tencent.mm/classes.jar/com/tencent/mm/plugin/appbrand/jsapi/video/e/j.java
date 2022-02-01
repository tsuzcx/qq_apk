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
import com.tencent.mm.plugin.appbrand.jsapi.y.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class j
  extends a
{
  private MediaPlayer sFf;
  private MediaPlayer.OnPreparedListener sFg;
  private MediaPlayer.OnVideoSizeChangedListener sFh;
  private MediaPlayer.OnCompletionListener sFi;
  private MediaPlayer.OnInfoListener sFj;
  private MediaPlayer.OnSeekCompleteListener sFk;
  private MediaPlayer.OnErrorListener sFl;
  private MediaPlayer.OnBufferingUpdateListener sFm;
  
  public j()
  {
    AppMethodBeat.i(328654);
    this.sFg = new MediaPlayer.OnPreparedListener()
    {
      public final void onPrepared(MediaPlayer paramAnonymousMediaPlayer)
      {
        AppMethodBeat.i(328618);
        j.this.sEu = 2;
        j.this.cwu();
        AppMethodBeat.o(328618);
      }
    };
    this.sFh = new MediaPlayer.OnVideoSizeChangedListener()
    {
      public final void onVideoSizeChanged(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(328615);
        j.this.fA(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(328615);
      }
    };
    this.sFi = new MediaPlayer.OnCompletionListener()
    {
      public final void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
      {
        AppMethodBeat.i(328613);
        j.this.sEu = 6;
        j.this.cwv();
        AppMethodBeat.o(328613);
      }
    };
    this.sFj = new MediaPlayer.OnInfoListener()
    {
      public final boolean onInfo(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(328627);
        boolean bool = j.this.fC(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(328627);
        return bool;
      }
    };
    this.sFk = new MediaPlayer.OnSeekCompleteListener()
    {
      public final void onSeekComplete(MediaPlayer paramAnonymousMediaPlayer)
      {
        AppMethodBeat.i(328621);
        j.this.cww();
        AppMethodBeat.o(328621);
      }
    };
    this.sFl = new MediaPlayer.OnErrorListener()
    {
      public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(328619);
        boolean bool = j.this.fB(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(328619);
        return bool;
      }
    };
    this.sFm = new MediaPlayer.OnBufferingUpdateListener()
    {
      public final void onBufferingUpdate(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt)
      {
        AppMethodBeat.i(328620);
        j.this.Bq(paramAnonymousInt);
        AppMethodBeat.o(328620);
      }
    };
    this.sFf = new k();
    this.sFf.setScreenOnWhilePlaying(true);
    this.sFf.setAudioStreamType(3);
    this.sFf.setOnInfoListener(this.sFj);
    this.sFf.setOnErrorListener(this.sFl);
    this.sFf.setOnPreparedListener(this.sFg);
    this.sFf.setOnCompletionListener(this.sFi);
    this.sFf.setOnSeekCompleteListener(this.sFk);
    this.sFf.setOnVideoSizeChangedListener(this.sFh);
    this.sFf.setOnBufferingUpdateListener(this.sFm);
    AppMethodBeat.o(328654);
  }
  
  private void Br(int paramInt)
  {
    AppMethodBeat.i(328669);
    if (this.sFl != null) {
      this.sFl.onError(this.sFf, -1024, paramInt);
    }
    AppMethodBeat.o(328669);
  }
  
  private boolean available()
  {
    return this.sFf != null;
  }
  
  public final <PlayerImpl extends g> PlayerImpl aU(Class<PlayerImpl> paramClass)
  {
    AppMethodBeat.i(328681);
    if (j.class.isAssignableFrom(paramClass))
    {
      AppMethodBeat.o(328681);
      return this;
    }
    AppMethodBeat.o(328681);
    return null;
  }
  
  public final boolean bN(float paramFloat)
  {
    AppMethodBeat.i(328716);
    if (paramFloat <= 0.0F)
    {
      AppMethodBeat.o(328716);
      return false;
    }
    try
    {
      if ((available()) && (Build.VERSION.SDK_INT >= 23))
      {
        PlaybackParams localPlaybackParams = this.sFf.getPlaybackParams();
        localPlaybackParams.setSpeed(paramFloat);
        if (!this.sFf.isPlaying())
        {
          this.sFf.setPlaybackParams(localPlaybackParams);
          this.sFf.pause();
        }
        for (;;)
        {
          AppMethodBeat.o(328716);
          return true;
          this.sFf.setPlaybackParams(localPlaybackParams);
        }
        AppMethodBeat.o(328716);
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s setSpeed fail", new Object[] { Integer.valueOf(hashCode()) });
      Br(-14);
    }
    for (;;)
    {
      return false;
      Log.w("MicroMsg.SameLayer.SystemMediaPlayer", "%s setSpeed, current system(%d) not support play speed setting", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(Build.VERSION.SDK_INT) });
    }
  }
  
  public final void cM(String paramString, int paramInt)
  {
    AppMethodBeat.i(328692);
    ey(paramString, null);
    AppMethodBeat.o(328692);
  }
  
  public final void ey(String paramString1, String paramString2)
  {
    AppMethodBeat.i(328697);
    try
    {
      if (available())
      {
        if (paramString2 != null) {
          break label35;
        }
        this.sFf.setDataSource(paramString1);
      }
      for (;;)
      {
        this.sEu = 1;
        AppMethodBeat.o(328697);
        return;
        label35:
        Log.i("MicroMsg.SameLayer.SystemMediaPlayer", "setDataSource, referrer: ".concat(String.valueOf(paramString2)));
        paramString2 = d.abw(paramString2);
        this.sFf.setDataSource(MMApplicationContext.getContext(), Uri.parse(paramString1), paramString2);
      }
      return;
    }
    catch (Exception paramString1)
    {
      Log.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", paramString1, "%s setDataSource fail", new Object[] { Integer.valueOf(hashCode()) });
      Br(-11);
      AppMethodBeat.o(328697);
    }
  }
  
  public final int getCurrentPosition()
  {
    AppMethodBeat.i(328740);
    try
    {
      if ((available()) && ((getState() == 2) || (getState() == 3) || (getState() == 4) || (getState() == 6)))
      {
        int i = this.sFf.getCurrentPosition();
        AppMethodBeat.o(328740);
        return i;
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s getCurrentPosition fail", new Object[] { Integer.valueOf(hashCode()) });
      Br(-15);
      AppMethodBeat.o(328740);
    }
    return 0;
  }
  
  public final int getDuration()
  {
    AppMethodBeat.i(328746);
    try
    {
      if ((available()) && (getState() != -1) && (getState() != 1) && (getState() != 0))
      {
        int i = this.sFf.getDuration();
        AppMethodBeat.o(328746);
        return i;
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s getDuration fail", new Object[] { Integer.valueOf(hashCode()) });
      Br(-16);
      AppMethodBeat.o(328746);
    }
    return 0;
  }
  
  public final int getPlayerType()
  {
    return 1;
  }
  
  public final int getVideoHeight()
  {
    AppMethodBeat.i(328759);
    try
    {
      if (available())
      {
        int i = this.sFf.getVideoHeight();
        AppMethodBeat.o(328759);
        return i;
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s getVideoHeight fail", new Object[] { Integer.valueOf(hashCode()) });
      Br(-18);
      AppMethodBeat.o(328759);
    }
    return 0;
  }
  
  public final int getVideoWidth()
  {
    AppMethodBeat.i(328754);
    try
    {
      if (available())
      {
        int i = this.sFf.getVideoWidth();
        AppMethodBeat.o(328754);
        return i;
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s getVideoWidth fail", new Object[] { Integer.valueOf(hashCode()) });
      Br(-17);
      AppMethodBeat.o(328754);
    }
    return 0;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(328735);
    try
    {
      if ((available()) && (getState() != -1) && (getState() != -2) && (getState() != 0) && (getState() != 1))
      {
        boolean bool = this.sFf.isPlaying();
        AppMethodBeat.o(328735);
        return bool;
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s isPlaying fail", new Object[] { Integer.valueOf(hashCode()) });
      Br(-9);
      AppMethodBeat.o(328735);
    }
    return false;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(328783);
    try
    {
      if ((available()) && ((getState() == 2) || (getState() == 3) || (getState() == 6)))
      {
        this.sFf.pause();
        this.sEu = 4;
      }
      AppMethodBeat.o(328783);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s pause fail", new Object[] { Integer.valueOf(hashCode()) });
      Br(-2);
      AppMethodBeat.o(328783);
    }
  }
  
  public final void prepareAsync()
  {
    AppMethodBeat.i(328768);
    try
    {
      if (available()) {
        this.sFf.prepareAsync();
      }
      AppMethodBeat.o(328768);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s prepareAsync fail", new Object[] { Integer.valueOf(hashCode()) });
      Br(-6);
      AppMethodBeat.o(328768);
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(328814);
    try
    {
      if (available())
      {
        if (this.sFf != null)
        {
          this.sFf.setOnInfoListener(null);
          this.sFf.setOnErrorListener(null);
          this.sFf.setOnPreparedListener(null);
          this.sFf.setOnCompletionListener(null);
          this.sFf.setOnSeekCompleteListener(null);
          this.sFf.setOnBufferingUpdateListener(null);
          this.sFf.setOnVideoSizeChangedListener(null);
        }
        this.sFf.release();
        this.sEu = -2;
        super.release();
      }
      AppMethodBeat.o(328814);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s release fail", new Object[] { Integer.valueOf(hashCode()) });
      Br(-8);
      AppMethodBeat.o(328814);
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(328807);
    try
    {
      if (available())
      {
        this.sFf.reset();
        this.sEu = 0;
      }
      AppMethodBeat.o(328807);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s reset fail", new Object[] { Integer.valueOf(hashCode()) });
      Br(-7);
      AppMethodBeat.o(328807);
    }
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(328792);
    try
    {
      if ((available()) && ((getState() == 2) || (getState() == 3) || (getState() == 4) || (getState() == 6))) {
        this.sFf.seekTo((int)paramLong);
      }
      AppMethodBeat.o(328792);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s seekTo fail", new Object[] { Integer.valueOf(hashCode()) });
      Br(-3);
      AppMethodBeat.o(328792);
    }
  }
  
  public final void setDataSource(String paramString)
  {
    AppMethodBeat.i(328685);
    ey(paramString, null);
    AppMethodBeat.o(328685);
  }
  
  public final void setLooping(boolean paramBoolean)
  {
    AppMethodBeat.i(328731);
    try
    {
      if (available()) {
        this.sFf.setLooping(paramBoolean);
      }
      AppMethodBeat.o(328731);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s setLooping fail", new Object[] { Integer.valueOf(hashCode()) });
      Br(-10);
      AppMethodBeat.o(328731);
    }
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(328721);
    if (available())
    {
      if (paramBoolean)
      {
        setVolume(0.0F, 0.0F);
        AppMethodBeat.o(328721);
        return;
      }
      setVolume(1.0F, 1.0F);
    }
    AppMethodBeat.o(328721);
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(328703);
    try
    {
      if (available()) {
        this.sFf.setSurface(paramSurface);
      }
      AppMethodBeat.o(328703);
      return;
    }
    catch (Exception paramSurface)
    {
      Log.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", paramSurface, "%s setSurface fail", new Object[] { Integer.valueOf(hashCode()) });
      Br(-12);
      AppMethodBeat.o(328703);
    }
  }
  
  public final void setVolume(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(328708);
    try
    {
      if (available()) {
        this.sFf.setVolume(paramFloat1, paramFloat2);
      }
      AppMethodBeat.o(328708);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s setVolume fail", new Object[] { Integer.valueOf(hashCode()) });
      Br(-13);
      AppMethodBeat.o(328708);
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(328776);
    try
    {
      if ((available()) && ((getState() == 2) || (getState() == 4) || (getState() == 6)))
      {
        this.sFf.start();
        this.sEu = 3;
      }
      AppMethodBeat.o(328776);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s start fail", new Object[] { Integer.valueOf(hashCode()) });
      Br(-1);
      AppMethodBeat.o(328776);
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(328801);
    try
    {
      if ((available()) && ((getState() == 2) || (getState() == 3) || (getState() == 4) || (getState() == 6)))
      {
        this.sFf.stop();
        this.sEu = 5;
      }
      AppMethodBeat.o(328801);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s stop fail", new Object[] { Integer.valueOf(hashCode()) });
      Br(-4);
      AppMethodBeat.o(328801);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.j
 * JD-Core Version:    0.7.0.1
 */