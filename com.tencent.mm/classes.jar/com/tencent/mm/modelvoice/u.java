package com.tencent.mm.modelvoice;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.k;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.util.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bc;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;

public final class u
  implements d
{
  String fileName;
  boolean hCL;
  d.a hCS;
  d.b hCT;
  MediaPlayer hDA;
  com.tencent.mm.compatible.util.b hDB;
  int status;
  
  public u()
  {
    AppMethodBeat.i(130095);
    this.fileName = "";
    this.hCS = null;
    this.hCT = null;
    this.status = 0;
    this.hCL = true;
    this.hDA = new k();
    aDF();
    aDG();
    ad.d("MicroMsg.VoicePlayer", "VoicePlayer");
    AppMethodBeat.o(130095);
  }
  
  public u(Context paramContext)
  {
    this();
    AppMethodBeat.i(130096);
    this.hDB = new com.tencent.mm.compatible.util.b(paramContext);
    ad.d("MicroMsg.VoicePlayer", "VoicePlayer context");
    AppMethodBeat.o(130096);
  }
  
  private void aDF()
  {
    AppMethodBeat.i(130097);
    this.hDA.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
    {
      public final void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
      {
        AppMethodBeat.i(130093);
        ad.d("MicroMsg.VoicePlayer", "OnCompletionListener");
        if ((u.this.hDB != null) && (u.this.hCL))
        {
          ad.d("MicroMsg.VoicePlayer", "OnCompletionListener abandonFocus");
          u.this.hDB.XF();
        }
        if (u.this.hCS != null)
        {
          ad.d("MicroMsg.VoicePlayer", "OnCompletionListener onCompletion");
          u.this.hCS.onCompletion();
        }
        try
        {
          ad.d("MicroMsg.VoicePlayer", "OnCompletionListener release");
          u.this.hDA.reset();
          u.this.hDA.release();
          u.this.status = 0;
          AppMethodBeat.o(130093);
          return;
        }
        catch (Exception paramAnonymousMediaPlayer)
        {
          ad.e("MicroMsg.VoicePlayer", "setCompletion File[" + u.this.fileName + "] ErrMsg[" + paramAnonymousMediaPlayer.getStackTrace() + "]");
          AppMethodBeat.o(130093);
        }
      }
    });
    AppMethodBeat.o(130097);
  }
  
  private void aDG()
  {
    AppMethodBeat.i(130098);
    this.hDA.setOnErrorListener(new MediaPlayer.OnErrorListener()
    {
      public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(130094);
        ad.d("MicroMsg.VoicePlayer", "OnErrorListener");
        if ((u.this.hDB != null) && (u.this.hCL))
        {
          ad.d("MicroMsg.VoicePlayer", "OnErrorListener abandonFocus");
          u.this.hDB.XF();
        }
        if (u.this.hCT != null)
        {
          ad.d("MicroMsg.VoicePlayer", "OnErrorListener onError");
          u.this.hCT.onError();
        }
        try
        {
          ad.d("MicroMsg.VoicePlayer", "OnErrorListener release");
          u.this.hDA.reset();
          u.this.hDA.release();
          u.this.status = -1;
          AppMethodBeat.o(130094);
          return false;
        }
        catch (Exception paramAnonymousMediaPlayer)
        {
          for (;;)
          {
            ad.e("MicroMsg.VoicePlayer", "setErrorListener File[" + u.this.fileName + "] ErrMsg[" + paramAnonymousMediaPlayer.getStackTrace() + "]");
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
      ad.e("MicroMsg.VoicePlayer", "startPlay error status:" + this.status);
      AppMethodBeat.o(130102);
      return false;
    }
    ad.i("MicroMsg.VoicePlayer", "startPlay speakerOn:%s,seekTo:%s,", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
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
        ad.e("MicroMsg.VoicePlayer", "startPlay File[" + this.fileName + "] failed");
        ad.e("MicroMsg.VoicePlayer", "exception:%s", new Object[] { bt.m(paramString) });
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
    if (!i.eK(this.fileName))
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
        ad.d("MicroMsg.VoicePlayer", "playImp speakerOn:%s,seekTo:%s,type:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), Integer.valueOf(i) });
        if (!ae.fFx.fzm) {
          break label249;
        }
        ae.fFx.dump();
        if (ae.fFx.fzt != 1) {
          break label249;
        }
        i = j;
        if ((this.hDB != null) && (this.hCL))
        {
          ad.d("MicroMsg.VoicePlayer", "playImp audioFocusHelper.requestFocus");
          this.hDB.requestFocus();
        }
        this.hDA.setAudioStreamType(i);
        this.hDA.setDataSource(this.fileName);
        this.hDA.prepare();
        if (paramInt > 0) {
          this.hDA.seekTo(paramInt);
        }
        this.hDA.start();
        AppMethodBeat.o(130103);
        return;
      }
      catch (Exception localException)
      {
        ad.e("MicroMsg.VoicePlayer", "playImp : fail, exception = " + localException.getMessage());
        ad.e("MicroMsg.VoicePlayer", "exception:%s", new Object[] { bt.m(localException) });
        if ((this.hDB == null) || (!this.hCL)) {
          continue;
        }
        this.hDB.XF();
        AppMethodBeat.o(130103);
        return;
      }
      i = 0;
    }
  }
  
  public final boolean Ft()
  {
    AppMethodBeat.i(130106);
    if ((this.status != 1) && (this.status != 2))
    {
      ad.e("MicroMsg.VoicePlayer", "stop not STATUS_PLAYING or STATUS_PAUSE error status:" + this.status);
      AppMethodBeat.o(130106);
      return false;
    }
    try
    {
      ad.d("MicroMsg.VoicePlayer", "stop mediaPlayer.stop()");
      this.hDA.stop();
      this.hDA.release();
      if ((this.hDB != null) && (this.hCL))
      {
        ad.d("MicroMsg.VoicePlayer", "stop audioFocusHelper.abandonFocus()");
        this.hDB.XF();
      }
      this.status = 0;
      AppMethodBeat.o(130106);
      return true;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.VoicePlayer", "stop File[" + this.fileName + "] ErrMsg[" + localException.getStackTrace() + "]");
      this.status = -1;
      return false;
    }
    finally
    {
      if ((this.hDB != null) && (this.hCL))
      {
        ad.d("MicroMsg.VoicePlayer", "stop audioFocusHelper.abandonFocus()");
        this.hDB.XF();
      }
      AppMethodBeat.o(130106);
    }
  }
  
  public final double Oa()
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
      i = this.hDA.getCurrentPosition();
      j = this.hDA.getDuration();
      if (j == 0)
      {
        ad.e("MicroMsg.VoicePlayer", "getDuration File[" + this.fileName + "] Failed");
        AppMethodBeat.o(130107);
        return 0.0D;
      }
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.VoicePlayer", "getNowProgress File[" + this.fileName + "] ErrMsg[" + localException.getStackTrace() + "]");
      Ft();
      AppMethodBeat.o(130107);
      return 0.0D;
    }
    double d = i / j;
    AppMethodBeat.o(130107);
    return d;
  }
  
  public final void a(d.a parama)
  {
    this.hCS = parama;
  }
  
  public final void a(d.b paramb)
  {
    this.hCT = paramb;
  }
  
  public final void aDn()
  {
    this.hCL = false;
  }
  
  public final void b(b.a parama)
  {
    AppMethodBeat.i(130108);
    if ((this.hDB != null) && (parama != null)) {
      this.hDB.a(parama);
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
  
  public final void cj(boolean paramBoolean)
  {
    AppMethodBeat.i(130099);
    ad.d("MicroMsg.VoicePlayer", "setSpeakerOn=".concat(String.valueOf(paramBoolean)));
    if (this.hDA == null)
    {
      AppMethodBeat.o(130099);
      return;
    }
    if (bc.NY())
    {
      ad.v("MicroMsg.VoicePlayer", "setSpeakOn return when calling");
      AppMethodBeat.o(130099);
      return;
    }
    int i = this.hDA.getCurrentPosition();
    Ft();
    this.hDA = new k();
    aDF();
    aDG();
    d(this.fileName, paramBoolean, i);
    AppMethodBeat.o(130099);
  }
  
  public final boolean cp(boolean paramBoolean)
  {
    AppMethodBeat.i(130104);
    if (this.status != 1)
    {
      ad.e("MicroMsg.VoicePlayer", "pause not STATUS_PLAYING error status:" + this.status);
      AppMethodBeat.o(130104);
      return false;
    }
    try
    {
      ad.d("MicroMsg.VoicePlayer", "pause mediaPlayer.pause()");
      this.hDA.pause();
      if ((this.hDB != null) && (paramBoolean) && (this.hCL))
      {
        ad.d("MicroMsg.VoicePlayer", "pause audioFocusHelper.abandonFocus()");
        this.hDB.XF();
      }
      this.status = 2;
      AppMethodBeat.o(130104);
      return true;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.VoicePlayer", "pause File[" + this.fileName + "] ErrMsg[" + localException.getStackTrace() + "]");
      this.status = -1;
      return false;
    }
    finally
    {
      if ((this.hDB != null) && (paramBoolean) && (this.hCL))
      {
        ad.d("MicroMsg.VoicePlayer", "pause audioFocusHelper.abandonFocus()");
        this.hDB.XF();
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
      ad.e("MicroMsg.VoicePlayer", "resume not STATUS_PAUSE error status:" + this.status);
      AppMethodBeat.o(130105);
      return false;
    }
    try
    {
      ad.d("MicroMsg.VoicePlayer", "resume mediaPlayer.start()");
      this.hDA.start();
      if ((this.hDB != null) && (this.hCL))
      {
        ad.d("MicroMsg.VoicePlayer", "resume audioFocusHelper.requestFocus()");
        this.hDB.requestFocus();
      }
      this.status = 1;
      AppMethodBeat.o(130105);
      return true;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.VoicePlayer", "resume File[" + this.fileName + "] ErrMsg[" + localException.getStackTrace() + "]");
      this.status = -1;
      return false;
    }
    finally
    {
      if ((this.hDB != null) && (this.hCL))
      {
        ad.d("MicroMsg.VoicePlayer", "resume audioFocusHelper.requestFocus()");
        this.hDB.requestFocus();
      }
      AppMethodBeat.o(130105);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelvoice.u
 * JD-Core Version:    0.7.0.1
 */