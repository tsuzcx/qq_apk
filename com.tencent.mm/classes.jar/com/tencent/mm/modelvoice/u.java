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
  boolean iwI;
  d.a iwP;
  d.b iwQ;
  MediaPlayer ixx;
  com.tencent.mm.compatible.util.b ixy;
  int status;
  
  public u()
  {
    AppMethodBeat.i(130095);
    this.fileName = "";
    this.iwP = null;
    this.iwQ = null;
    this.status = 0;
    this.iwI = true;
    this.ixx = new k();
    aNF();
    aNG();
    ad.d("MicroMsg.VoicePlayer", "VoicePlayer");
    AppMethodBeat.o(130095);
  }
  
  public u(Context paramContext)
  {
    this();
    AppMethodBeat.i(130096);
    this.ixy = new com.tencent.mm.compatible.util.b(paramContext);
    ad.d("MicroMsg.VoicePlayer", "VoicePlayer context");
    AppMethodBeat.o(130096);
  }
  
  private void aNF()
  {
    AppMethodBeat.i(130097);
    this.ixx.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
    {
      public final void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
      {
        AppMethodBeat.i(130093);
        ad.d("MicroMsg.VoicePlayer", "OnCompletionListener");
        if ((u.this.ixy != null) && (u.this.iwI))
        {
          ad.d("MicroMsg.VoicePlayer", "OnCompletionListener abandonFocus");
          u.this.ixy.abe();
        }
        if (u.this.iwP != null)
        {
          ad.d("MicroMsg.VoicePlayer", "OnCompletionListener onCompletion");
          u.this.iwP.onCompletion();
        }
        try
        {
          ad.d("MicroMsg.VoicePlayer", "OnCompletionListener release");
          u.this.ixx.reset();
          u.this.ixx.release();
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
  
  private void aNG()
  {
    AppMethodBeat.i(130098);
    this.ixx.setOnErrorListener(new MediaPlayer.OnErrorListener()
    {
      public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(130094);
        ad.d("MicroMsg.VoicePlayer", "OnErrorListener");
        if ((u.this.ixy != null) && (u.this.iwI))
        {
          ad.d("MicroMsg.VoicePlayer", "OnErrorListener abandonFocus");
          u.this.ixy.abe();
        }
        if (u.this.iwQ != null)
        {
          ad.d("MicroMsg.VoicePlayer", "OnErrorListener onError");
          u.this.iwQ.onError();
        }
        try
        {
          ad.d("MicroMsg.VoicePlayer", "OnErrorListener release");
          u.this.ixx.reset();
          u.this.ixx.release();
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
        ad.e("MicroMsg.VoicePlayer", "startPlay File[" + this.fileName + "] failed");
        ad.e("MicroMsg.VoicePlayer", "exception:%s", new Object[] { bt.n(paramString) });
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
    if (!i.fv(this.fileName))
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
        if (!ae.gcF.fWh) {
          break label249;
        }
        ae.gcF.dump();
        if (ae.gcF.fWo != 1) {
          break label249;
        }
        i = j;
        if ((this.ixy != null) && (this.iwI))
        {
          ad.d("MicroMsg.VoicePlayer", "playImp audioFocusHelper.requestFocus");
          this.ixy.requestFocus();
        }
        this.ixx.setAudioStreamType(i);
        this.ixx.setDataSource(this.fileName);
        this.ixx.prepare();
        if (paramInt > 0) {
          this.ixx.seekTo(paramInt);
        }
        this.ixx.start();
        AppMethodBeat.o(130103);
        return;
      }
      catch (Exception localException)
      {
        ad.e("MicroMsg.VoicePlayer", "playImp : fail, exception = " + localException.getMessage());
        ad.e("MicroMsg.VoicePlayer", "exception:%s", new Object[] { bt.n(localException) });
        if ((this.ixy == null) || (!this.iwI)) {
          continue;
        }
        this.ixy.abe();
        AppMethodBeat.o(130103);
        return;
      }
      i = 0;
    }
  }
  
  public final boolean Gv()
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
      this.ixx.stop();
      this.ixx.release();
      if ((this.ixy != null) && (this.iwI))
      {
        ad.d("MicroMsg.VoicePlayer", "stop audioFocusHelper.abandonFocus()");
        this.ixy.abe();
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
      if ((this.ixy != null) && (this.iwI))
      {
        ad.d("MicroMsg.VoicePlayer", "stop audioFocusHelper.abandonFocus()");
        this.ixy.abe();
      }
      AppMethodBeat.o(130106);
    }
  }
  
  public final double PF()
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
      i = this.ixx.getCurrentPosition();
      j = this.ixx.getDuration();
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
      Gv();
      AppMethodBeat.o(130107);
      return 0.0D;
    }
    double d = i / j;
    AppMethodBeat.o(130107);
    return d;
  }
  
  public final void a(d.a parama)
  {
    this.iwP = parama;
  }
  
  public final void a(d.b paramb)
  {
    this.iwQ = paramb;
  }
  
  public final void aNn()
  {
    this.iwI = false;
  }
  
  public final void b(b.a parama)
  {
    AppMethodBeat.i(130108);
    if ((this.ixy != null) && (parama != null)) {
      this.ixy.a(parama);
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
    ad.d("MicroMsg.VoicePlayer", "setSpeakerOn=".concat(String.valueOf(paramBoolean)));
    if (this.ixx == null)
    {
      AppMethodBeat.o(130099);
      return;
    }
    if (bc.PD())
    {
      ad.v("MicroMsg.VoicePlayer", "setSpeakOn return when calling");
      AppMethodBeat.o(130099);
      return;
    }
    int i = this.ixx.getCurrentPosition();
    Gv();
    this.ixx = new k();
    aNF();
    aNG();
    d(this.fileName, paramBoolean, i);
    AppMethodBeat.o(130099);
  }
  
  public final boolean cs(boolean paramBoolean)
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
      this.ixx.pause();
      if ((this.ixy != null) && (paramBoolean) && (this.iwI))
      {
        ad.d("MicroMsg.VoicePlayer", "pause audioFocusHelper.abandonFocus()");
        this.ixy.abe();
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
      if ((this.ixy != null) && (paramBoolean) && (this.iwI))
      {
        ad.d("MicroMsg.VoicePlayer", "pause audioFocusHelper.abandonFocus()");
        this.ixy.abe();
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
      this.ixx.start();
      if ((this.ixy != null) && (this.iwI))
      {
        ad.d("MicroMsg.VoicePlayer", "resume audioFocusHelper.requestFocus()");
        this.ixy.requestFocus();
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
      if ((this.ixy != null) && (this.iwI))
      {
        ad.d("MicroMsg.VoicePlayer", "resume audioFocusHelper.requestFocus()");
        this.ixy.requestFocus();
      }
      AppMethodBeat.o(130105);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelvoice.u
 * JD-Core Version:    0.7.0.1
 */