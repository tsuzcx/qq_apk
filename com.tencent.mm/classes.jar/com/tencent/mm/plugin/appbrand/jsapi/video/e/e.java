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
import com.tencent.mm.plugin.appbrand.jsapi.u.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class e
  extends a
{
  private MediaPlayer mBq;
  private MediaPlayer.OnPreparedListener mBr;
  private MediaPlayer.OnVideoSizeChangedListener mBs;
  private MediaPlayer.OnCompletionListener mBt;
  private MediaPlayer.OnInfoListener mBu;
  private MediaPlayer.OnSeekCompleteListener mBv;
  private MediaPlayer.OnErrorListener mBw;
  private MediaPlayer.OnBufferingUpdateListener mBx;
  
  public e()
  {
    AppMethodBeat.i(234942);
    this.mBr = new MediaPlayer.OnPreparedListener()
    {
      public final void onPrepared(MediaPlayer paramAnonymousMediaPlayer)
      {
        AppMethodBeat.i(234935);
        e.this.mAT = 2;
        e.this.bKx();
        AppMethodBeat.o(234935);
      }
    };
    this.mBs = new MediaPlayer.OnVideoSizeChangedListener()
    {
      public final void onVideoSizeChanged(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(234936);
        e.this.ei(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(234936);
      }
    };
    this.mBt = new MediaPlayer.OnCompletionListener()
    {
      public final void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
      {
        AppMethodBeat.i(234937);
        e.this.mAT = 6;
        e.this.bKy();
        AppMethodBeat.o(234937);
      }
    };
    this.mBu = new MediaPlayer.OnInfoListener()
    {
      public final boolean onInfo(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(234938);
        boolean bool = e.this.ek(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(234938);
        return bool;
      }
    };
    this.mBv = new MediaPlayer.OnSeekCompleteListener()
    {
      public final void onSeekComplete(MediaPlayer paramAnonymousMediaPlayer)
      {
        AppMethodBeat.i(234939);
        e.this.bKz();
        AppMethodBeat.o(234939);
      }
    };
    this.mBw = new MediaPlayer.OnErrorListener()
    {
      public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(234940);
        boolean bool = e.this.ej(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(234940);
        return bool;
      }
    };
    this.mBx = new MediaPlayer.OnBufferingUpdateListener()
    {
      public final void onBufferingUpdate(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt)
      {
        AppMethodBeat.i(234941);
        e.this.xF(paramAnonymousInt);
        AppMethodBeat.o(234941);
      }
    };
    this.mBq = new k();
    this.mBq.setScreenOnWhilePlaying(true);
    this.mBq.setAudioStreamType(3);
    this.mBq.setOnInfoListener(this.mBu);
    this.mBq.setOnErrorListener(this.mBw);
    this.mBq.setOnPreparedListener(this.mBr);
    this.mBq.setOnCompletionListener(this.mBt);
    this.mBq.setOnSeekCompleteListener(this.mBv);
    this.mBq.setOnVideoSizeChangedListener(this.mBs);
    this.mBq.setOnBufferingUpdateListener(this.mBx);
    AppMethodBeat.o(234942);
  }
  
  private boolean available()
  {
    return this.mBq != null;
  }
  
  private void xG(int paramInt)
  {
    AppMethodBeat.i(234962);
    if (this.mBw != null) {
      this.mBw.onError(this.mBq, -1024, paramInt);
    }
    AppMethodBeat.o(234962);
  }
  
  public final boolean aP(float paramFloat)
  {
    AppMethodBeat.i(234947);
    if (paramFloat <= 0.0F)
    {
      AppMethodBeat.o(234947);
      return false;
    }
    try
    {
      if ((available()) && (Build.VERSION.SDK_INT >= 23))
      {
        PlaybackParams localPlaybackParams = this.mBq.getPlaybackParams();
        localPlaybackParams.setSpeed(paramFloat);
        if (!this.mBq.isPlaying())
        {
          this.mBq.setPlaybackParams(localPlaybackParams);
          this.mBq.pause();
        }
        for (;;)
        {
          AppMethodBeat.o(234947);
          return true;
          this.mBq.setPlaybackParams(localPlaybackParams);
        }
        AppMethodBeat.o(234947);
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s setSpeed fail", new Object[] { Integer.valueOf(hashCode()) });
      xG(-14);
    }
    for (;;)
    {
      return false;
      Log.w("MicroMsg.SameLayer.SystemMediaPlayer", "%s setSpeed, current system(%d) not support play speed setting", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(Build.VERSION.SDK_INT) });
    }
  }
  
  public final void dU(String paramString1, String paramString2)
  {
    AppMethodBeat.i(234944);
    try
    {
      if (available())
      {
        if (paramString2 != null) {
          break label35;
        }
        this.mBq.setDataSource(paramString1);
      }
      for (;;)
      {
        this.mAT = 1;
        AppMethodBeat.o(234944);
        return;
        label35:
        Log.i("MicroMsg.SameLayer.SystemMediaPlayer", "setDataSource, referrer: ".concat(String.valueOf(paramString2)));
        paramString2 = d.aaG(paramString2);
        this.mBq.setDataSource(MMApplicationContext.getContext(), Uri.parse(paramString1), paramString2);
      }
      return;
    }
    catch (Exception paramString1)
    {
      Log.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", paramString1, "%s setDataSource fail", new Object[] { Integer.valueOf(hashCode()) });
      xG(-11);
      AppMethodBeat.o(234944);
    }
  }
  
  public final int getCurrentPosition()
  {
    AppMethodBeat.i(234951);
    try
    {
      if ((available()) && ((this.mAT == 2) || (this.mAT == 3) || (this.mAT == 4) || (this.mAT == 6)))
      {
        int i = this.mBq.getCurrentPosition();
        AppMethodBeat.o(234951);
        return i;
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s getCurrentPosition fail", new Object[] { Integer.valueOf(hashCode()) });
      xG(-15);
      AppMethodBeat.o(234951);
    }
    return 0;
  }
  
  public final int getDuration()
  {
    AppMethodBeat.i(234952);
    try
    {
      if ((available()) && (this.mAT != -1) && (this.mAT != 1) && (this.mAT != 0))
      {
        int i = this.mBq.getDuration();
        AppMethodBeat.o(234952);
        return i;
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s getDuration fail", new Object[] { Integer.valueOf(hashCode()) });
      xG(-16);
      AppMethodBeat.o(234952);
    }
    return 0;
  }
  
  public final int getVideoHeight()
  {
    AppMethodBeat.i(234954);
    try
    {
      if (available())
      {
        int i = this.mBq.getVideoHeight();
        AppMethodBeat.o(234954);
        return i;
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s getVideoHeight fail", new Object[] { Integer.valueOf(hashCode()) });
      xG(-18);
      AppMethodBeat.o(234954);
    }
    return 0;
  }
  
  public final int getVideoWidth()
  {
    AppMethodBeat.i(234953);
    try
    {
      if (available())
      {
        int i = this.mBq.getVideoWidth();
        AppMethodBeat.o(234953);
        return i;
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s getVideoWidth fail", new Object[] { Integer.valueOf(hashCode()) });
      xG(-17);
      AppMethodBeat.o(234953);
    }
    return 0;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(234950);
    try
    {
      if ((available()) && (this.mAT != -1) && (this.mAT != -2) && (this.mAT != 0) && (this.mAT != 1))
      {
        boolean bool = this.mBq.isPlaying();
        AppMethodBeat.o(234950);
        return bool;
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s isPlaying fail", new Object[] { Integer.valueOf(hashCode()) });
      xG(-9);
      AppMethodBeat.o(234950);
    }
    return false;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(234957);
    try
    {
      if ((available()) && ((this.mAT == 2) || (this.mAT == 3) || (this.mAT == 6)))
      {
        this.mBq.pause();
        this.mAT = 4;
      }
      AppMethodBeat.o(234957);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s pause fail", new Object[] { Integer.valueOf(hashCode()) });
      xG(-2);
      AppMethodBeat.o(234957);
    }
  }
  
  public final void prepareAsync()
  {
    AppMethodBeat.i(234955);
    try
    {
      if (available()) {
        this.mBq.prepareAsync();
      }
      AppMethodBeat.o(234955);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s prepareAsync fail", new Object[] { Integer.valueOf(hashCode()) });
      xG(-6);
      AppMethodBeat.o(234955);
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(234961);
    try
    {
      if (available())
      {
        if (this.mBq != null)
        {
          this.mBq.setOnInfoListener(null);
          this.mBq.setOnErrorListener(null);
          this.mBq.setOnPreparedListener(null);
          this.mBq.setOnCompletionListener(null);
          this.mBq.setOnSeekCompleteListener(null);
          this.mBq.setOnBufferingUpdateListener(null);
          this.mBq.setOnVideoSizeChangedListener(null);
        }
        this.mBq.release();
        this.mAT = -2;
        super.release();
      }
      AppMethodBeat.o(234961);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s release fail", new Object[] { Integer.valueOf(hashCode()) });
      xG(-8);
      AppMethodBeat.o(234961);
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(234960);
    try
    {
      if (available())
      {
        this.mBq.reset();
        this.mAT = 0;
      }
      AppMethodBeat.o(234960);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s reset fail", new Object[] { Integer.valueOf(hashCode()) });
      xG(-7);
      AppMethodBeat.o(234960);
    }
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(234958);
    try
    {
      if ((available()) && ((this.mAT == 2) || (this.mAT == 3) || (this.mAT == 4) || (this.mAT == 6))) {
        this.mBq.seekTo((int)paramLong);
      }
      AppMethodBeat.o(234958);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s seekTo fail", new Object[] { Integer.valueOf(hashCode()) });
      xG(-3);
      AppMethodBeat.o(234958);
    }
  }
  
  public final void setDataSource(String paramString)
  {
    AppMethodBeat.i(234943);
    dU(paramString, null);
    AppMethodBeat.o(234943);
  }
  
  public final void setLooping(boolean paramBoolean)
  {
    AppMethodBeat.i(234949);
    try
    {
      if (available()) {
        this.mBq.setLooping(paramBoolean);
      }
      AppMethodBeat.o(234949);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s setLooping fail", new Object[] { Integer.valueOf(hashCode()) });
      xG(-10);
      AppMethodBeat.o(234949);
    }
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(234948);
    if (available())
    {
      if (paramBoolean)
      {
        setVolume(0.0F, 0.0F);
        AppMethodBeat.o(234948);
        return;
      }
      setVolume(1.0F, 1.0F);
    }
    AppMethodBeat.o(234948);
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(234945);
    try
    {
      if (available()) {
        this.mBq.setSurface(paramSurface);
      }
      AppMethodBeat.o(234945);
      return;
    }
    catch (Exception paramSurface)
    {
      Log.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", paramSurface, "%s setSurface fail", new Object[] { Integer.valueOf(hashCode()) });
      xG(-12);
      AppMethodBeat.o(234945);
    }
  }
  
  public final void setVolume(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(234946);
    try
    {
      if (available()) {
        this.mBq.setVolume(paramFloat1, paramFloat2);
      }
      AppMethodBeat.o(234946);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s setVolume fail", new Object[] { Integer.valueOf(hashCode()) });
      xG(-13);
      AppMethodBeat.o(234946);
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(234956);
    try
    {
      if ((available()) && ((this.mAT == 2) || (this.mAT == 4) || (this.mAT == 6)))
      {
        this.mBq.start();
        this.mAT = 3;
      }
      AppMethodBeat.o(234956);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s start fail", new Object[] { Integer.valueOf(hashCode()) });
      xG(-1);
      AppMethodBeat.o(234956);
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(234959);
    try
    {
      if ((available()) && ((this.mAT == 2) || (this.mAT == 3) || (this.mAT == 4) || (this.mAT == 6)))
      {
        this.mBq.stop();
        this.mAT = 5;
      }
      AppMethodBeat.o(234959);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s stop fail", new Object[] { Integer.valueOf(hashCode()) });
      xG(-4);
      AppMethodBeat.o(234959);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.e
 * JD-Core Version:    0.7.0.1
 */