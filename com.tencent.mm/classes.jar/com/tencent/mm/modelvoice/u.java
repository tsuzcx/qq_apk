package com.tencent.mm.modelvoice;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.k;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.util.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.PhoneStatusWatcher;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;

public final class u
  implements d
{
  String fileName;
  boolean juP;
  d.a juW;
  d.b juX;
  MediaPlayer jvF;
  com.tencent.mm.compatible.util.b jvG;
  int status;
  
  public u()
  {
    AppMethodBeat.i(130095);
    this.fileName = "";
    this.juW = null;
    this.juX = null;
    this.status = 0;
    this.juP = true;
    this.jvF = new k();
    bik();
    bil();
    Log.d("MicroMsg.VoicePlayer", "VoicePlayer");
    AppMethodBeat.o(130095);
  }
  
  public u(Context paramContext)
  {
    this();
    AppMethodBeat.i(130096);
    this.jvG = new com.tencent.mm.compatible.util.b(paramContext);
    Log.d("MicroMsg.VoicePlayer", "VoicePlayer context");
    AppMethodBeat.o(130096);
  }
  
  private void bik()
  {
    AppMethodBeat.i(130097);
    this.jvF.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
    {
      public final void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
      {
        AppMethodBeat.i(130093);
        Log.d("MicroMsg.VoicePlayer", "OnCompletionListener");
        if ((u.this.jvG != null) && (u.this.juP))
        {
          Log.d("MicroMsg.VoicePlayer", "OnCompletionListener abandonFocus");
          u.this.jvG.apm();
        }
        if (u.this.juW != null)
        {
          Log.d("MicroMsg.VoicePlayer", "OnCompletionListener onCompletion");
          u.this.juW.onCompletion();
        }
        try
        {
          Log.d("MicroMsg.VoicePlayer", "OnCompletionListener release");
          u.this.jvF.reset();
          u.this.jvF.release();
          u.this.status = 0;
          AppMethodBeat.o(130093);
          return;
        }
        catch (Exception paramAnonymousMediaPlayer)
        {
          Log.e("MicroMsg.VoicePlayer", "setCompletion File[" + u.this.fileName + "] ErrMsg[" + paramAnonymousMediaPlayer.getStackTrace() + "]");
          AppMethodBeat.o(130093);
        }
      }
    });
    AppMethodBeat.o(130097);
  }
  
  private void bil()
  {
    AppMethodBeat.i(130098);
    this.jvF.setOnErrorListener(new MediaPlayer.OnErrorListener()
    {
      public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(130094);
        Log.d("MicroMsg.VoicePlayer", "OnErrorListener");
        if ((u.this.jvG != null) && (u.this.juP))
        {
          Log.d("MicroMsg.VoicePlayer", "OnErrorListener abandonFocus");
          u.this.jvG.apm();
        }
        if (u.this.juX != null)
        {
          Log.d("MicroMsg.VoicePlayer", "OnErrorListener onError");
          u.this.juX.onError();
        }
        try
        {
          Log.d("MicroMsg.VoicePlayer", "OnErrorListener release");
          u.this.jvF.reset();
          u.this.jvF.release();
          u.this.status = -1;
          AppMethodBeat.o(130094);
          return false;
        }
        catch (Exception paramAnonymousMediaPlayer)
        {
          for (;;)
          {
            Log.e("MicroMsg.VoicePlayer", "setErrorListener File[" + u.this.fileName + "] ErrMsg[" + paramAnonymousMediaPlayer.getStackTrace() + "]");
          }
        }
      }
    });
    AppMethodBeat.o(130098);
  }
  
  private boolean d(String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(130102);
    if (this.status != 0)
    {
      Log.e("MicroMsg.VoicePlayer", "startPlay error status:" + this.status);
      AppMethodBeat.o(130102);
      return false;
    }
    Log.i("MicroMsg.VoicePlayer", "startPlay speakerOn:%s,seekTo:%s,", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    this.fileName = paramString;
    try
    {
      k(paramBoolean, paramInt);
      this.status = 1;
      AppMethodBeat.o(130102);
      return true;
    }
    catch (Exception paramString)
    {
      try
      {
        k(true, paramInt);
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.VoicePlayer", "startPlay File[" + this.fileName + "] failed");
        Log.e("MicroMsg.VoicePlayer", "exception:%s", new Object[] { Util.stackTraceToString(paramString) });
        this.status = -1;
        AppMethodBeat.o(130102);
      }
    }
    return false;
  }
  
  private void k(boolean paramBoolean, int paramInt)
  {
    int j = 3;
    AppMethodBeat.i(130103);
    if (!s.YS(this.fileName))
    {
      AppMethodBeat.o(130103);
      return;
    }
    int i;
    if (paramBoolean) {
      i = 3;
    }
    label249:
    for (;;)
    {
      try
      {
        Log.d("MicroMsg.VoicePlayer", "playImp speakerOn:%s,seekTo:%s,type:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), Integer.valueOf(i) });
        if (!ae.gKu.gDA) {
          break label249;
        }
        ae.gKu.dump();
        if (ae.gKu.gDH != 1) {
          break label249;
        }
        i = j;
        if ((this.jvG != null) && (this.juP))
        {
          Log.d("MicroMsg.VoicePlayer", "playImp audioFocusHelper.requestFocus");
          this.jvG.requestFocus();
        }
        this.jvF.setAudioStreamType(i);
        this.jvF.setDataSource(this.fileName);
        this.jvF.prepare();
        if (paramInt > 0) {
          this.jvF.seekTo(paramInt);
        }
        this.jvF.start();
        AppMethodBeat.o(130103);
        return;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.VoicePlayer", "playImp : fail, exception = " + localException.getMessage());
        Log.e("MicroMsg.VoicePlayer", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
        if ((this.jvG == null) || (!this.juP)) {
          continue;
        }
        this.jvG.apm();
        AppMethodBeat.o(130103);
        return;
      }
      i = 0;
    }
  }
  
  public final boolean Qt()
  {
    AppMethodBeat.i(130106);
    if ((this.status != 1) && (this.status != 2))
    {
      Log.e("MicroMsg.VoicePlayer", "stop not STATUS_PLAYING or STATUS_PAUSE error status:" + this.status);
      AppMethodBeat.o(130106);
      return false;
    }
    try
    {
      Log.d("MicroMsg.VoicePlayer", "stop mediaPlayer.stop()");
      this.jvF.stop();
      this.jvF.release();
      if ((this.jvG != null) && (this.juP))
      {
        Log.d("MicroMsg.VoicePlayer", "stop audioFocusHelper.abandonFocus()");
        this.jvG.apm();
      }
      this.status = 0;
      AppMethodBeat.o(130106);
      return true;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.VoicePlayer", "stop File[" + this.fileName + "] ErrMsg[" + localException.getStackTrace() + "]");
      this.status = -1;
      return false;
    }
    finally
    {
      if ((this.jvG != null) && (this.juP))
      {
        Log.d("MicroMsg.VoicePlayer", "stop audioFocusHelper.abandonFocus()");
        this.jvG.apm();
      }
      AppMethodBeat.o(130106);
    }
  }
  
  public final double ZY()
  {
    AppMethodBeat.i(130107);
    if ((this.status != 1) && (this.status != 2))
    {
      AppMethodBeat.o(130107);
      return 0.0D;
    }
    int i;
    int j;
    try
    {
      i = this.jvF.getCurrentPosition();
      j = this.jvF.getDuration();
      if (j == 0)
      {
        Log.e("MicroMsg.VoicePlayer", "getDuration File[" + this.fileName + "] Failed");
        AppMethodBeat.o(130107);
        return 0.0D;
      }
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.VoicePlayer", "getNowProgress File[" + this.fileName + "] ErrMsg[" + localException.getStackTrace() + "]");
      Qt();
      AppMethodBeat.o(130107);
      return 0.0D;
    }
    double d = i / j;
    AppMethodBeat.o(130107);
    return d;
  }
  
  public final void a(d.a parama)
  {
    this.juW = parama;
  }
  
  public final void a(d.b paramb)
  {
    this.juX = paramb;
  }
  
  public final void bhQ()
  {
    this.juP = false;
  }
  
  public final void c(b.a parama)
  {
    AppMethodBeat.i(130108);
    if ((this.jvG != null) && (parama != null)) {
      this.jvG.a(parama);
    }
    AppMethodBeat.o(130108);
  }
  
  public final boolean c(String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(130101);
    paramBoolean = d(paramString, paramBoolean, paramInt);
    AppMethodBeat.o(130101);
    return paramBoolean;
  }
  
  public final void cU(boolean paramBoolean)
  {
    AppMethodBeat.i(130099);
    Log.d("MicroMsg.VoicePlayer", "setSpeakerOn=".concat(String.valueOf(paramBoolean)));
    if (this.jvF == null)
    {
      AppMethodBeat.o(130099);
      return;
    }
    if (PhoneStatusWatcher.isCalling())
    {
      Log.v("MicroMsg.VoicePlayer", "setSpeakOn return when calling");
      AppMethodBeat.o(130099);
      return;
    }
    int i = this.jvF.getCurrentPosition();
    Qt();
    this.jvF = new k();
    bik();
    bil();
    d(this.fileName, paramBoolean, i);
    AppMethodBeat.o(130099);
  }
  
  public final boolean da(boolean paramBoolean)
  {
    AppMethodBeat.i(130104);
    if (this.status != 1)
    {
      Log.e("MicroMsg.VoicePlayer", "pause not STATUS_PLAYING error status:" + this.status);
      AppMethodBeat.o(130104);
      return false;
    }
    try
    {
      Log.d("MicroMsg.VoicePlayer", "pause mediaPlayer.pause()");
      this.jvF.pause();
      if ((this.jvG != null) && (paramBoolean) && (this.juP))
      {
        Log.d("MicroMsg.VoicePlayer", "pause audioFocusHelper.abandonFocus()");
        this.jvG.apm();
      }
      this.status = 2;
      AppMethodBeat.o(130104);
      return true;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.VoicePlayer", "pause File[" + this.fileName + "] ErrMsg[" + localException.getStackTrace() + "]");
      this.status = -1;
      return false;
    }
    finally
    {
      if ((this.jvG != null) && (paramBoolean) && (this.juP))
      {
        Log.d("MicroMsg.VoicePlayer", "pause audioFocusHelper.abandonFocus()");
        this.jvG.apm();
      }
      AppMethodBeat.o(130104);
    }
  }
  
  public final int getStatus()
  {
    return this.status;
  }
  
  public final boolean isPlaying()
  {
    return this.status == 1;
  }
  
  public final boolean resume()
  {
    AppMethodBeat.i(130105);
    if (this.status != 2)
    {
      Log.e("MicroMsg.VoicePlayer", "resume not STATUS_PAUSE error status:" + this.status);
      AppMethodBeat.o(130105);
      return false;
    }
    try
    {
      Log.d("MicroMsg.VoicePlayer", "resume mediaPlayer.start()");
      this.jvF.start();
      if ((this.jvG != null) && (this.juP))
      {
        Log.d("MicroMsg.VoicePlayer", "resume audioFocusHelper.requestFocus()");
        this.jvG.requestFocus();
      }
      this.status = 1;
      AppMethodBeat.o(130105);
      return true;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.VoicePlayer", "resume File[" + this.fileName + "] ErrMsg[" + localException.getStackTrace() + "]");
      this.status = -1;
      return false;
    }
    finally
    {
      if ((this.jvG != null) && (this.juP))
      {
        Log.d("MicroMsg.VoicePlayer", "resume audioFocusHelper.requestFocus()");
        this.jvG.requestFocus();
      }
      AppMethodBeat.o(130105);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelvoice.u
 * JD-Core Version:    0.7.0.1
 */