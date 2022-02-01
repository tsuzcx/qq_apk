package com.tencent.mm.modelvoice;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.k;
import com.tencent.mm.compatible.util.b.a;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;

public final class u
  implements d
{
  String fileName;
  MediaPlayer iAq;
  com.tencent.mm.compatible.util.b iAr;
  boolean izB;
  d.a izI;
  d.b izJ;
  int status;
  
  public u()
  {
    AppMethodBeat.i(130095);
    this.fileName = "";
    this.izI = null;
    this.izJ = null;
    this.status = 0;
    this.izB = true;
    this.iAq = new k();
    aOd();
    aOe();
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.VoicePlayer", "VoicePlayer");
    AppMethodBeat.o(130095);
  }
  
  public u(Context paramContext)
  {
    this();
    AppMethodBeat.i(130096);
    this.iAr = new com.tencent.mm.compatible.util.b(paramContext);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.VoicePlayer", "VoicePlayer context");
    AppMethodBeat.o(130096);
  }
  
  private void aOd()
  {
    AppMethodBeat.i(130097);
    this.iAq.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
    {
      public final void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
      {
        AppMethodBeat.i(130093);
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.VoicePlayer", "OnCompletionListener");
        if ((u.this.iAr != null) && (u.this.izB))
        {
          com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.VoicePlayer", "OnCompletionListener abandonFocus");
          u.this.iAr.abn();
        }
        if (u.this.izI != null)
        {
          com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.VoicePlayer", "OnCompletionListener onCompletion");
          u.this.izI.onCompletion();
        }
        try
        {
          com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.VoicePlayer", "OnCompletionListener release");
          u.this.iAq.reset();
          u.this.iAq.release();
          u.this.status = 0;
          AppMethodBeat.o(130093);
          return;
        }
        catch (Exception paramAnonymousMediaPlayer)
        {
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.VoicePlayer", "setCompletion File[" + u.this.fileName + "] ErrMsg[" + paramAnonymousMediaPlayer.getStackTrace() + "]");
          AppMethodBeat.o(130093);
        }
      }
    });
    AppMethodBeat.o(130097);
  }
  
  private void aOe()
  {
    AppMethodBeat.i(130098);
    this.iAq.setOnErrorListener(new MediaPlayer.OnErrorListener()
    {
      public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(130094);
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.VoicePlayer", "OnErrorListener");
        if ((u.this.iAr != null) && (u.this.izB))
        {
          com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.VoicePlayer", "OnErrorListener abandonFocus");
          u.this.iAr.abn();
        }
        if (u.this.izJ != null)
        {
          com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.VoicePlayer", "OnErrorListener onError");
          u.this.izJ.onError();
        }
        try
        {
          com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.VoicePlayer", "OnErrorListener release");
          u.this.iAq.reset();
          u.this.iAq.release();
          u.this.status = -1;
          AppMethodBeat.o(130094);
          return false;
        }
        catch (Exception paramAnonymousMediaPlayer)
        {
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.VoicePlayer", "setErrorListener File[" + u.this.fileName + "] ErrMsg[" + paramAnonymousMediaPlayer.getStackTrace() + "]");
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
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.VoicePlayer", "startPlay error status:" + this.status);
      AppMethodBeat.o(130102);
      return false;
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.VoicePlayer", "startPlay speakerOn:%s,seekTo:%s,", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    this.fileName = paramString;
    try
    {
      l(paramBoolean, paramInt);
      this.status = 1;
      AppMethodBeat.o(130102);
      return true;
    }
    catch (Exception paramString)
    {
      try
      {
        l(true, paramInt);
      }
      catch (Exception localException)
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.VoicePlayer", "startPlay File[" + this.fileName + "] failed");
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.VoicePlayer", "exception:%s", new Object[] { bu.o(paramString) });
        this.status = -1;
        AppMethodBeat.o(130102);
      }
    }
    return false;
  }
  
  private void l(boolean paramBoolean, int paramInt)
  {
    int j = 3;
    AppMethodBeat.i(130103);
    if (!o.fB(this.fileName))
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
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.VoicePlayer", "playImp speakerOn:%s,seekTo:%s,type:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), Integer.valueOf(i) });
        if (!com.tencent.mm.compatible.deviceinfo.ae.geN.fYn) {
          break label249;
        }
        com.tencent.mm.compatible.deviceinfo.ae.geN.dump();
        if (com.tencent.mm.compatible.deviceinfo.ae.geN.fYu != 1) {
          break label249;
        }
        i = j;
        if ((this.iAr != null) && (this.izB))
        {
          com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.VoicePlayer", "playImp audioFocusHelper.requestFocus");
          this.iAr.requestFocus();
        }
        this.iAq.setAudioStreamType(i);
        this.iAq.setDataSource(this.fileName);
        this.iAq.prepare();
        if (paramInt > 0) {
          this.iAq.seekTo(paramInt);
        }
        this.iAq.start();
        AppMethodBeat.o(130103);
        return;
      }
      catch (Exception localException)
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.VoicePlayer", "playImp : fail, exception = " + localException.getMessage());
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.VoicePlayer", "exception:%s", new Object[] { bu.o(localException) });
        if ((this.iAr == null) || (!this.izB)) {
          continue;
        }
        this.iAr.abn();
        AppMethodBeat.o(130103);
        return;
      }
      i = 0;
    }
  }
  
  public final boolean GB()
  {
    AppMethodBeat.i(130106);
    if ((this.status != 1) && (this.status != 2))
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.VoicePlayer", "stop not STATUS_PLAYING or STATUS_PAUSE error status:" + this.status);
      AppMethodBeat.o(130106);
      return false;
    }
    try
    {
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.VoicePlayer", "stop mediaPlayer.stop()");
      this.iAq.stop();
      this.iAq.release();
      if ((this.iAr != null) && (this.izB))
      {
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.VoicePlayer", "stop audioFocusHelper.abandonFocus()");
        this.iAr.abn();
      }
      this.status = 0;
      AppMethodBeat.o(130106);
      return true;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.VoicePlayer", "stop File[" + this.fileName + "] ErrMsg[" + localException.getStackTrace() + "]");
      this.status = -1;
      return false;
    }
    finally
    {
      if ((this.iAr != null) && (this.izB))
      {
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.VoicePlayer", "stop audioFocusHelper.abandonFocus()");
        this.iAr.abn();
      }
      AppMethodBeat.o(130106);
    }
  }
  
  public final double PE()
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
      i = this.iAq.getCurrentPosition();
      j = this.iAq.getDuration();
      if (j == 0)
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.VoicePlayer", "getDuration File[" + this.fileName + "] Failed");
        AppMethodBeat.o(130107);
        return 0.0D;
      }
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.VoicePlayer", "getNowProgress File[" + this.fileName + "] ErrMsg[" + localException.getStackTrace() + "]");
      GB();
      AppMethodBeat.o(130107);
      return 0.0D;
    }
    double d = i / j;
    AppMethodBeat.o(130107);
    return d;
  }
  
  public final void a(d.a parama)
  {
    this.izI = parama;
  }
  
  public final void a(d.b paramb)
  {
    this.izJ = paramb;
  }
  
  public final void aNL()
  {
    this.izB = false;
  }
  
  public final void b(b.a parama)
  {
    AppMethodBeat.i(130108);
    if ((this.iAr != null) && (parama != null)) {
      this.iAr.a(parama);
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
  
  public final void cm(boolean paramBoolean)
  {
    AppMethodBeat.i(130099);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.VoicePlayer", "setSpeakerOn=".concat(String.valueOf(paramBoolean)));
    if (this.iAq == null)
    {
      AppMethodBeat.o(130099);
      return;
    }
    if (bd.PC())
    {
      com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.VoicePlayer", "setSpeakOn return when calling");
      AppMethodBeat.o(130099);
      return;
    }
    int i = this.iAq.getCurrentPosition();
    GB();
    this.iAq = new k();
    aOd();
    aOe();
    d(this.fileName, paramBoolean, i);
    AppMethodBeat.o(130099);
  }
  
  public final boolean cs(boolean paramBoolean)
  {
    AppMethodBeat.i(130104);
    if (this.status != 1)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.VoicePlayer", "pause not STATUS_PLAYING error status:" + this.status);
      AppMethodBeat.o(130104);
      return false;
    }
    try
    {
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.VoicePlayer", "pause mediaPlayer.pause()");
      this.iAq.pause();
      if ((this.iAr != null) && (paramBoolean) && (this.izB))
      {
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.VoicePlayer", "pause audioFocusHelper.abandonFocus()");
        this.iAr.abn();
      }
      this.status = 2;
      AppMethodBeat.o(130104);
      return true;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.VoicePlayer", "pause File[" + this.fileName + "] ErrMsg[" + localException.getStackTrace() + "]");
      this.status = -1;
      return false;
    }
    finally
    {
      if ((this.iAr != null) && (paramBoolean) && (this.izB))
      {
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.VoicePlayer", "pause audioFocusHelper.abandonFocus()");
        this.iAr.abn();
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
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.VoicePlayer", "resume not STATUS_PAUSE error status:" + this.status);
      AppMethodBeat.o(130105);
      return false;
    }
    try
    {
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.VoicePlayer", "resume mediaPlayer.start()");
      this.iAq.start();
      if ((this.iAr != null) && (this.izB))
      {
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.VoicePlayer", "resume audioFocusHelper.requestFocus()");
        this.iAr.requestFocus();
      }
      this.status = 1;
      AppMethodBeat.o(130105);
      return true;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.VoicePlayer", "resume File[" + this.fileName + "] ErrMsg[" + localException.getStackTrace() + "]");
      this.status = -1;
      return false;
    }
    finally
    {
      if ((this.iAr != null) && (this.izB))
      {
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.VoicePlayer", "resume audioFocusHelper.requestFocus()");
        this.iAr.requestFocus();
      }
      AppMethodBeat.o(130105);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelvoice.u
 * JD-Core Version:    0.7.0.1
 */