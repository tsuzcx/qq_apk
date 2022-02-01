package com.tencent.mm.modelvoice;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.k;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.util.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.PhoneStatusWatcher;
import com.tencent.mm.sdk.platformtools.Util;

public final class u
  implements d
{
  String fileName;
  boolean mkr;
  d.a mky;
  d.b mkz;
  MediaPlayer mli;
  com.tencent.mm.compatible.util.b mlj;
  int status;
  
  public u()
  {
    AppMethodBeat.i(130095);
    this.fileName = "";
    this.mky = null;
    this.mkz = null;
    this.status = 0;
    this.mkr = true;
    this.mli = new k();
    brI();
    brJ();
    Log.d("MicroMsg.VoicePlayer", "VoicePlayer");
    AppMethodBeat.o(130095);
  }
  
  public u(Context paramContext)
  {
    this();
    AppMethodBeat.i(130096);
    this.mlj = new com.tencent.mm.compatible.util.b(paramContext);
    Log.d("MicroMsg.VoicePlayer", "VoicePlayer context");
    AppMethodBeat.o(130096);
  }
  
  private void brI()
  {
    AppMethodBeat.i(130097);
    this.mli.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
    {
      public final void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
      {
        AppMethodBeat.i(130093);
        Log.d("MicroMsg.VoicePlayer", "OnCompletionListener");
        if ((u.this.mlj != null) && (u.this.mkr))
        {
          Log.d("MicroMsg.VoicePlayer", "OnCompletionListener abandonFocus");
          u.this.mlj.avz();
        }
        if (u.this.mky != null)
        {
          Log.d("MicroMsg.VoicePlayer", "OnCompletionListener onCompletion");
          u.this.mky.onCompletion();
        }
        try
        {
          Log.d("MicroMsg.VoicePlayer", "OnCompletionListener release");
          u.this.mli.reset();
          u.this.mli.release();
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
  
  private void brJ()
  {
    AppMethodBeat.i(130098);
    this.mli.setOnErrorListener(new MediaPlayer.OnErrorListener()
    {
      public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(130094);
        Log.d("MicroMsg.VoicePlayer", "OnErrorListener");
        if ((u.this.mlj != null) && (u.this.mkr))
        {
          Log.d("MicroMsg.VoicePlayer", "OnErrorListener abandonFocus");
          u.this.mlj.avz();
        }
        if (u.this.mkz != null)
        {
          Log.d("MicroMsg.VoicePlayer", "OnErrorListener onError");
          u.this.mkz.onError();
        }
        try
        {
          Log.d("MicroMsg.VoicePlayer", "OnErrorListener release");
          u.this.mli.reset();
          u.this.mli.release();
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
  
  private boolean e(String paramString, boolean paramBoolean, int paramInt)
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
      n(paramBoolean, paramInt);
      this.status = 1;
      AppMethodBeat.o(130102);
      return true;
    }
    catch (Exception paramString)
    {
      try
      {
        n(true, paramInt);
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
  
  private void n(boolean paramBoolean, int paramInt)
  {
    int j = 3;
    AppMethodBeat.i(130103);
    if (!com.tencent.mm.vfs.u.agG(this.fileName))
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
        if (!af.juI.jnK) {
          break label249;
        }
        af.juI.Y();
        if (af.juI.jnR != 1) {
          break label249;
        }
        i = j;
        if ((this.mlj != null) && (this.mkr))
        {
          Log.d("MicroMsg.VoicePlayer", "playImp audioFocusHelper.requestFocus");
          this.mlj.avy();
        }
        this.mli.setAudioStreamType(i);
        this.mli.setDataSource(this.fileName);
        this.mli.prepare();
        if (paramInt > 0) {
          this.mli.seekTo(paramInt);
        }
        this.mli.start();
        AppMethodBeat.o(130103);
        return;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.VoicePlayer", "playImp : fail, exception = " + localException.getMessage());
        Log.e("MicroMsg.VoicePlayer", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
        if ((this.mlj == null) || (!this.mkr)) {
          continue;
        }
        this.mlj.avz();
        AppMethodBeat.o(130103);
        return;
      }
      i = 0;
    }
  }
  
  public final boolean TV()
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
      this.mli.stop();
      this.mli.release();
      if ((this.mlj != null) && (this.mkr))
      {
        Log.d("MicroMsg.VoicePlayer", "stop audioFocusHelper.abandonFocus()");
        this.mlj.avz();
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
      if ((this.mlj != null) && (this.mkr))
      {
        Log.d("MicroMsg.VoicePlayer", "stop audioFocusHelper.abandonFocus()");
        this.mlj.avz();
      }
      AppMethodBeat.o(130106);
    }
  }
  
  public final void a(d.a parama)
  {
    this.mky = parama;
  }
  
  public final void a(d.b paramb)
  {
    this.mkz = paramb;
  }
  
  public final double aeI()
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
      i = this.mli.getCurrentPosition();
      j = this.mli.getDuration();
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
      TV();
      AppMethodBeat.o(130107);
      return 0.0D;
    }
    double d = i / j;
    AppMethodBeat.o(130107);
    return d;
  }
  
  public final void bro()
  {
    this.mkr = false;
  }
  
  public final void c(b.a parama)
  {
    AppMethodBeat.i(130108);
    if ((this.mlj != null) && (parama != null)) {
      this.mlj.a(parama);
    }
    AppMethodBeat.o(130108);
  }
  
  public final boolean d(String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(130101);
    paramBoolean = e(paramString, paramBoolean, paramInt);
    AppMethodBeat.o(130101);
    return paramBoolean;
  }
  
  public final boolean dA(boolean paramBoolean)
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
      this.mli.pause();
      if ((this.mlj != null) && (paramBoolean) && (this.mkr))
      {
        Log.d("MicroMsg.VoicePlayer", "pause audioFocusHelper.abandonFocus()");
        this.mlj.avz();
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
      if ((this.mlj != null) && (paramBoolean) && (this.mkr))
      {
        Log.d("MicroMsg.VoicePlayer", "pause audioFocusHelper.abandonFocus()");
        this.mlj.avz();
      }
      AppMethodBeat.o(130104);
    }
  }
  
  public final void dr(boolean paramBoolean)
  {
    AppMethodBeat.i(130099);
    Log.d("MicroMsg.VoicePlayer", "setSpeakerOn=".concat(String.valueOf(paramBoolean)));
    if (this.mli == null)
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
    int i = this.mli.getCurrentPosition();
    TV();
    this.mli = new k();
    brI();
    brJ();
    e(this.fileName, paramBoolean, i);
    AppMethodBeat.o(130099);
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
      this.mli.start();
      if ((this.mlj != null) && (this.mkr))
      {
        Log.d("MicroMsg.VoicePlayer", "resume audioFocusHelper.requestFocus()");
        this.mlj.avy();
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
      if ((this.mlj != null) && (this.mkr))
      {
        Log.d("MicroMsg.VoicePlayer", "resume audioFocusHelper.requestFocus()");
        this.mlj.avy();
      }
      AppMethodBeat.o(130105);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.modelvoice.u
 * JD-Core Version:    0.7.0.1
 */