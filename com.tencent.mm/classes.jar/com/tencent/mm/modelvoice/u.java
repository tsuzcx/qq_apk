package com.tencent.mm.modelvoice;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.k;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.util.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bb;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;

public final class u
  implements d
{
  String fileName;
  boolean idm;
  d.a idt;
  d.b idu;
  MediaPlayer iec;
  com.tencent.mm.compatible.util.b ied;
  int status;
  
  public u()
  {
    AppMethodBeat.i(130095);
    this.fileName = "";
    this.idt = null;
    this.idu = null;
    this.status = 0;
    this.idm = true;
    this.iec = new k();
    aKw();
    aKx();
    ac.d("MicroMsg.VoicePlayer", "VoicePlayer");
    AppMethodBeat.o(130095);
  }
  
  public u(Context paramContext)
  {
    this();
    AppMethodBeat.i(130096);
    this.ied = new com.tencent.mm.compatible.util.b(paramContext);
    ac.d("MicroMsg.VoicePlayer", "VoicePlayer context");
    AppMethodBeat.o(130096);
  }
  
  private void aKw()
  {
    AppMethodBeat.i(130097);
    this.iec.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
    {
      public final void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
      {
        AppMethodBeat.i(130093);
        ac.d("MicroMsg.VoicePlayer", "OnCompletionListener");
        if ((u.this.ied != null) && (u.this.idm))
        {
          ac.d("MicroMsg.VoicePlayer", "OnCompletionListener abandonFocus");
          u.this.ied.YC();
        }
        if (u.this.idt != null)
        {
          ac.d("MicroMsg.VoicePlayer", "OnCompletionListener onCompletion");
          u.this.idt.onCompletion();
        }
        try
        {
          ac.d("MicroMsg.VoicePlayer", "OnCompletionListener release");
          u.this.iec.reset();
          u.this.iec.release();
          u.this.status = 0;
          AppMethodBeat.o(130093);
          return;
        }
        catch (Exception paramAnonymousMediaPlayer)
        {
          ac.e("MicroMsg.VoicePlayer", "setCompletion File[" + u.this.fileName + "] ErrMsg[" + paramAnonymousMediaPlayer.getStackTrace() + "]");
          AppMethodBeat.o(130093);
        }
      }
    });
    AppMethodBeat.o(130097);
  }
  
  private void aKx()
  {
    AppMethodBeat.i(130098);
    this.iec.setOnErrorListener(new MediaPlayer.OnErrorListener()
    {
      public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(130094);
        ac.d("MicroMsg.VoicePlayer", "OnErrorListener");
        if ((u.this.ied != null) && (u.this.idm))
        {
          ac.d("MicroMsg.VoicePlayer", "OnErrorListener abandonFocus");
          u.this.ied.YC();
        }
        if (u.this.idu != null)
        {
          ac.d("MicroMsg.VoicePlayer", "OnErrorListener onError");
          u.this.idu.onError();
        }
        try
        {
          ac.d("MicroMsg.VoicePlayer", "OnErrorListener release");
          u.this.iec.reset();
          u.this.iec.release();
          u.this.status = -1;
          AppMethodBeat.o(130094);
          return false;
        }
        catch (Exception paramAnonymousMediaPlayer)
        {
          for (;;)
          {
            ac.e("MicroMsg.VoicePlayer", "setErrorListener File[" + u.this.fileName + "] ErrMsg[" + paramAnonymousMediaPlayer.getStackTrace() + "]");
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
      ac.e("MicroMsg.VoicePlayer", "startPlay error status:" + this.status);
      AppMethodBeat.o(130102);
      return false;
    }
    ac.i("MicroMsg.VoicePlayer", "startPlay speakerOn:%s,seekTo:%s,", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
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
        ac.e("MicroMsg.VoicePlayer", "startPlay File[" + this.fileName + "] failed");
        ac.e("MicroMsg.VoicePlayer", "exception:%s", new Object[] { bs.m(paramString) });
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
    if (!i.eA(this.fileName))
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
        ac.d("MicroMsg.VoicePlayer", "playImp speakerOn:%s,seekTo:%s,type:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), Integer.valueOf(i) });
        if (!ae.fJe.fCT) {
          break label249;
        }
        ae.fJe.dump();
        if (ae.fJe.fDa != 1) {
          break label249;
        }
        i = j;
        if ((this.ied != null) && (this.idm))
        {
          ac.d("MicroMsg.VoicePlayer", "playImp audioFocusHelper.requestFocus");
          this.ied.requestFocus();
        }
        this.iec.setAudioStreamType(i);
        this.iec.setDataSource(this.fileName);
        this.iec.prepare();
        if (paramInt > 0) {
          this.iec.seekTo(paramInt);
        }
        this.iec.start();
        AppMethodBeat.o(130103);
        return;
      }
      catch (Exception localException)
      {
        ac.e("MicroMsg.VoicePlayer", "playImp : fail, exception = " + localException.getMessage());
        ac.e("MicroMsg.VoicePlayer", "exception:%s", new Object[] { bs.m(localException) });
        if ((this.ied == null) || (!this.idm)) {
          continue;
        }
        this.ied.YC();
        AppMethodBeat.o(130103);
        return;
      }
      i = 0;
    }
  }
  
  public final boolean Fb()
  {
    AppMethodBeat.i(130106);
    if ((this.status != 1) && (this.status != 2))
    {
      ac.e("MicroMsg.VoicePlayer", "stop not STATUS_PLAYING or STATUS_PAUSE error status:" + this.status);
      AppMethodBeat.o(130106);
      return false;
    }
    try
    {
      ac.d("MicroMsg.VoicePlayer", "stop mediaPlayer.stop()");
      this.iec.stop();
      this.iec.release();
      if ((this.ied != null) && (this.idm))
      {
        ac.d("MicroMsg.VoicePlayer", "stop audioFocusHelper.abandonFocus()");
        this.ied.YC();
      }
      this.status = 0;
      AppMethodBeat.o(130106);
      return true;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.VoicePlayer", "stop File[" + this.fileName + "] ErrMsg[" + localException.getStackTrace() + "]");
      this.status = -1;
      return false;
    }
    finally
    {
      if ((this.ied != null) && (this.idm))
      {
        ac.d("MicroMsg.VoicePlayer", "stop audioFocusHelper.abandonFocus()");
        this.ied.YC();
      }
      AppMethodBeat.o(130106);
    }
  }
  
  public final double NW()
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
      i = this.iec.getCurrentPosition();
      j = this.iec.getDuration();
      if (j == 0)
      {
        ac.e("MicroMsg.VoicePlayer", "getDuration File[" + this.fileName + "] Failed");
        AppMethodBeat.o(130107);
        return 0.0D;
      }
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.VoicePlayer", "getNowProgress File[" + this.fileName + "] ErrMsg[" + localException.getStackTrace() + "]");
      Fb();
      AppMethodBeat.o(130107);
      return 0.0D;
    }
    double d = i / j;
    AppMethodBeat.o(130107);
    return d;
  }
  
  public final void a(d.a parama)
  {
    this.idt = parama;
  }
  
  public final void a(d.b paramb)
  {
    this.idu = paramb;
  }
  
  public final void aKe()
  {
    this.idm = false;
  }
  
  public final void b(b.a parama)
  {
    AppMethodBeat.i(130108);
    if ((this.ied != null) && (parama != null)) {
      this.ied.a(parama);
    }
    AppMethodBeat.o(130108);
  }
  
  public final boolean bF(boolean paramBoolean)
  {
    AppMethodBeat.i(130104);
    if (this.status != 1)
    {
      ac.e("MicroMsg.VoicePlayer", "pause not STATUS_PLAYING error status:" + this.status);
      AppMethodBeat.o(130104);
      return false;
    }
    try
    {
      ac.d("MicroMsg.VoicePlayer", "pause mediaPlayer.pause()");
      this.iec.pause();
      if ((this.ied != null) && (paramBoolean) && (this.idm))
      {
        ac.d("MicroMsg.VoicePlayer", "pause audioFocusHelper.abandonFocus()");
        this.ied.YC();
      }
      this.status = 2;
      AppMethodBeat.o(130104);
      return true;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.VoicePlayer", "pause File[" + this.fileName + "] ErrMsg[" + localException.getStackTrace() + "]");
      this.status = -1;
      return false;
    }
    finally
    {
      if ((this.ied != null) && (paramBoolean) && (this.idm))
      {
        ac.d("MicroMsg.VoicePlayer", "pause audioFocusHelper.abandonFocus()");
        this.ied.YC();
      }
      AppMethodBeat.o(130104);
    }
  }
  
  public final boolean c(String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(130101);
    paramBoolean = d(paramString, paramBoolean, paramInt);
    AppMethodBeat.o(130101);
    return paramBoolean;
  }
  
  public final void cl(boolean paramBoolean)
  {
    AppMethodBeat.i(130099);
    ac.d("MicroMsg.VoicePlayer", "setSpeakerOn=".concat(String.valueOf(paramBoolean)));
    if (this.iec == null)
    {
      AppMethodBeat.o(130099);
      return;
    }
    if (bb.NU())
    {
      ac.v("MicroMsg.VoicePlayer", "setSpeakOn return when calling");
      AppMethodBeat.o(130099);
      return;
    }
    int i = this.iec.getCurrentPosition();
    Fb();
    this.iec = new k();
    aKw();
    aKx();
    d(this.fileName, paramBoolean, i);
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
      ac.e("MicroMsg.VoicePlayer", "resume not STATUS_PAUSE error status:" + this.status);
      AppMethodBeat.o(130105);
      return false;
    }
    try
    {
      ac.d("MicroMsg.VoicePlayer", "resume mediaPlayer.start()");
      this.iec.start();
      if ((this.ied != null) && (this.idm))
      {
        ac.d("MicroMsg.VoicePlayer", "resume audioFocusHelper.requestFocus()");
        this.ied.requestFocus();
      }
      this.status = 1;
      AppMethodBeat.o(130105);
      return true;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.VoicePlayer", "resume File[" + this.fileName + "] ErrMsg[" + localException.getStackTrace() + "]");
      this.status = -1;
      return false;
    }
    finally
    {
      if ((this.ied != null) && (this.idm))
      {
        ac.d("MicroMsg.VoicePlayer", "resume audioFocusHelper.requestFocus()");
        this.ied.requestFocus();
      }
      AppMethodBeat.o(130105);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelvoice.u
 * JD-Core Version:    0.7.0.1
 */