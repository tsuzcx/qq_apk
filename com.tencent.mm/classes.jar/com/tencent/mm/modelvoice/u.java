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
import com.tencent.mm.vfs.y;

public final class u
  implements d
{
  String fileName;
  boolean pdV;
  MediaPlayer peU;
  com.tencent.mm.compatible.util.b peV;
  d.a pej;
  d.b pek;
  int status;
  
  public u()
  {
    AppMethodBeat.i(130095);
    this.fileName = "";
    this.pej = null;
    this.pek = null;
    this.status = 0;
    this.pdV = true;
    this.peU = new k();
    bPo();
    bPp();
    Log.d("MicroMsg.VoicePlayer", "VoicePlayer");
    AppMethodBeat.o(130095);
  }
  
  public u(Context paramContext)
  {
    this();
    AppMethodBeat.i(130096);
    this.peV = new com.tencent.mm.compatible.util.b(paramContext);
    Log.d("MicroMsg.VoicePlayer", "VoicePlayer context");
    AppMethodBeat.o(130096);
  }
  
  private void bPo()
  {
    AppMethodBeat.i(130097);
    this.peU.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
    {
      public final void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
      {
        AppMethodBeat.i(130093);
        Log.d("MicroMsg.VoicePlayer", "OnCompletionListener");
        if ((u.this.peV != null) && (u.this.pdV))
        {
          Log.d("MicroMsg.VoicePlayer", "OnCompletionListener abandonFocus");
          u.this.peV.aPS();
        }
        if (u.this.pej != null)
        {
          Log.d("MicroMsg.VoicePlayer", "OnCompletionListener onCompletion");
          u.this.pej.onCompletion();
        }
        try
        {
          Log.d("MicroMsg.VoicePlayer", "OnCompletionListener release");
          u.this.peU.reset();
          u.this.peU.release();
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
  
  private void bPp()
  {
    AppMethodBeat.i(130098);
    this.peU.setOnErrorListener(new MediaPlayer.OnErrorListener()
    {
      public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(130094);
        Log.d("MicroMsg.VoicePlayer", "OnErrorListener");
        if ((u.this.peV != null) && (u.this.pdV))
        {
          Log.d("MicroMsg.VoicePlayer", "OnErrorListener abandonFocus");
          u.this.peV.aPS();
        }
        if (u.this.pek != null)
        {
          Log.d("MicroMsg.VoicePlayer", "OnErrorListener onError");
          u.this.pek.atR();
        }
        try
        {
          Log.d("MicroMsg.VoicePlayer", "OnErrorListener release");
          u.this.peU.reset();
          u.this.peU.release();
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
    if (!y.ZC(this.fileName))
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
        if (!af.lXZ.lQS) {
          break label249;
        }
        af.lXZ.aQ();
        if (af.lXZ.lQZ != 1) {
          break label249;
        }
        i = j;
        if ((this.peV != null) && (this.pdV))
        {
          Log.d("MicroMsg.VoicePlayer", "playImp audioFocusHelper.requestFocus");
          this.peV.requestFocus();
        }
        this.peU.setAudioStreamType(i);
        this.peU.setDataSource(this.fileName);
        this.peU.prepare();
        if (paramInt > 0) {
          this.peU.seekTo(paramInt);
        }
        this.peU.start();
        AppMethodBeat.o(130103);
        return;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.VoicePlayer", "playImp : fail, exception = " + localException.getMessage());
        Log.e("MicroMsg.VoicePlayer", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
        if ((this.peV == null) || (!this.pdV)) {
          continue;
        }
        this.peV.aPS();
        AppMethodBeat.o(130103);
        return;
      }
      i = 0;
    }
  }
  
  public final void a(d.a parama)
  {
    this.pej = parama;
  }
  
  public final void a(d.b paramb)
  {
    this.pek = paramb;
  }
  
  public final void a(d.c paramc)
  {
    AppMethodBeat.i(234471);
    Log.e("MicroMsg.VoicePlayer", "seek not support");
    AppMethodBeat.o(234471);
  }
  
  public final double aGG()
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
      i = this.peU.getCurrentPosition();
      j = this.peU.getDuration();
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
      stop();
      AppMethodBeat.o(130107);
      return 0.0D;
    }
    double d = i / j;
    AppMethodBeat.o(130107);
    return d;
  }
  
  public final void bOU()
  {
    this.pdV = false;
  }
  
  public final void c(b.a parama)
  {
    AppMethodBeat.i(130108);
    if ((this.peV != null) && (parama != null)) {
      this.peV.a(parama);
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
  
  public final boolean ea(long paramLong)
  {
    AppMethodBeat.i(234468);
    Log.e("MicroMsg.VoicePlayer", "seek not support");
    AppMethodBeat.o(234468);
    return false;
  }
  
  public final void ed(boolean paramBoolean)
  {
    AppMethodBeat.i(130099);
    Log.d("MicroMsg.VoicePlayer", "setSpeakerOn=".concat(String.valueOf(paramBoolean)));
    if (this.peU == null)
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
    int i = this.peU.getCurrentPosition();
    stop();
    this.peU = new k();
    bPo();
    bPp();
    d(this.fileName, paramBoolean, i);
    AppMethodBeat.o(130099);
  }
  
  public final boolean em(boolean paramBoolean)
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
      this.peU.pause();
      if ((this.peV != null) && (paramBoolean) && (this.pdV))
      {
        Log.d("MicroMsg.VoicePlayer", "pause audioFocusHelper.abandonFocus()");
        this.peV.aPS();
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
      if ((this.peV != null) && (paramBoolean) && (this.pdV))
      {
        Log.d("MicroMsg.VoicePlayer", "pause audioFocusHelper.abandonFocus()");
        this.peV.aPS();
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
      this.peU.start();
      if ((this.peV != null) && (this.pdV))
      {
        Log.d("MicroMsg.VoicePlayer", "resume audioFocusHelper.requestFocus()");
        this.peV.requestFocus();
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
      if ((this.peV != null) && (this.pdV))
      {
        Log.d("MicroMsg.VoicePlayer", "resume audioFocusHelper.requestFocus()");
        this.peV.requestFocus();
      }
      AppMethodBeat.o(130105);
    }
  }
  
  public final boolean stop()
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
      this.peU.stop();
      this.peU.release();
      if ((this.peV != null) && (this.pdV))
      {
        Log.d("MicroMsg.VoicePlayer", "stop audioFocusHelper.abandonFocus()");
        this.peV.aPS();
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
      if ((this.peV != null) && (this.pdV))
      {
        Log.d("MicroMsg.VoicePlayer", "stop audioFocusHelper.abandonFocus()");
        this.peV.aPS();
      }
      AppMethodBeat.o(130106);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.modelvoice.u
 * JD-Core Version:    0.7.0.1
 */