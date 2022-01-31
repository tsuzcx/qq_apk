package com.tencent.mm.modelvoice;

import android.content.Context;
import android.media.MediaPlayer;
import com.tencent.mm.compatible.b.j;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.b.a;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;

public final class s
  implements d
{
  d.b eKA = null;
  boolean eKt = true;
  d.a eKz = null;
  MediaPlayer eLh = new j();
  com.tencent.mm.compatible.util.b eLi;
  String fileName = "";
  int status = 0;
  
  public s()
  {
    Tn();
    To();
    y.d("MicroMsg.VoicePlayer", "VoicePlayer");
  }
  
  public s(Context paramContext)
  {
    this();
    this.eLi = new com.tencent.mm.compatible.util.b(paramContext);
    y.d("MicroMsg.VoicePlayer", "VoicePlayer context");
  }
  
  private void Tn()
  {
    this.eLh.setOnCompletionListener(new s.1(this));
  }
  
  private void To()
  {
    this.eLh.setOnErrorListener(new s.2(this));
  }
  
  private void d(boolean paramBoolean, int paramInt)
  {
    int j = 3;
    if (!e.bK(this.fileName)) {
      return;
    }
    int i;
    if (paramBoolean) {
      i = 3;
    }
    label229:
    for (;;)
    {
      try
      {
        y.d("MicroMsg.VoicePlayer", "playImp speakerOn:%s,seekTo:%s,type:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), Integer.valueOf(i) });
        if (!q.dye.duN) {
          break label229;
        }
        q.dye.dump();
        if (q.dye.duU != 1) {
          break label229;
        }
        i = j;
        if ((this.eLi != null) && (this.eKt))
        {
          y.d("MicroMsg.VoicePlayer", "playImp audioFocusHelper.requestFocus");
          this.eLi.requestFocus();
        }
        this.eLh.setAudioStreamType(i);
        this.eLh.setDataSource(this.fileName);
        this.eLh.prepare();
        if (paramInt > 0) {
          this.eLh.seekTo(paramInt);
        }
        this.eLh.start();
        return;
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.VoicePlayer", "playImp : fail, exception = " + localException.getMessage());
        y.e("MicroMsg.VoicePlayer", "exception:%s", new Object[] { bk.j(localException) });
      }
      if ((this.eLi == null) || (!this.eKt)) {
        break;
      }
      this.eLi.zE();
      return;
      i = 0;
    }
  }
  
  private boolean d(String paramString, boolean paramBoolean, int paramInt)
  {
    if (this.status != 0)
    {
      y.e("MicroMsg.VoicePlayer", "startPlay error status:" + this.status);
      return false;
    }
    y.i("MicroMsg.VoicePlayer", "startPlay speakerOn:%s,seekTo:%s,", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    this.fileName = paramString;
    try
    {
      d(paramBoolean, paramInt);
      this.status = 1;
      return true;
    }
    catch (Exception paramString)
    {
      try
      {
        d(true, paramInt);
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.VoicePlayer", "startPlay File[" + this.fileName + "] failed");
        y.e("MicroMsg.VoicePlayer", "exception:%s", new Object[] { bk.j(paramString) });
        this.status = -1;
      }
    }
    return false;
  }
  
  public final boolean P(String paramString, boolean paramBoolean)
  {
    return d(paramString, paramBoolean, 0);
  }
  
  public final void SX()
  {
    this.eKt = false;
  }
  
  public final void a(d.a parama)
  {
    this.eKz = parama;
  }
  
  public final void a(d.b paramb)
  {
    this.eKA = paramb;
  }
  
  public final boolean aU(boolean paramBoolean)
  {
    if (this.status != 1) {
      y.e("MicroMsg.VoicePlayer", "pause not STATUS_PLAYING error status:" + this.status);
    }
    for (;;)
    {
      return false;
      try
      {
        y.d("MicroMsg.VoicePlayer", "pause mediaPlayer.pause()");
        this.eLh.pause();
        if ((this.eLi != null) && (paramBoolean) && (this.eKt))
        {
          y.d("MicroMsg.VoicePlayer", "pause audioFocusHelper.abandonFocus()");
          this.eLi.zE();
        }
        this.status = 2;
        return true;
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.VoicePlayer", "pause File[" + this.fileName + "] ErrMsg[" + localException.getStackTrace() + "]");
        this.status = -1;
        return false;
      }
      finally
      {
        if ((this.eLi != null) && (paramBoolean) && (this.eKt))
        {
          y.d("MicroMsg.VoicePlayer", "pause audioFocusHelper.abandonFocus()");
          this.eLi.zE();
        }
      }
    }
  }
  
  public final void aV(boolean paramBoolean)
  {
    y.d("MicroMsg.VoicePlayer", "setSpeakerOn=" + paramBoolean);
    if (this.eLh == null) {
      return;
    }
    if (at.uc())
    {
      y.v("MicroMsg.VoicePlayer", "setSpeakOn return when calling");
      return;
    }
    int i = this.eLh.getCurrentPosition();
    un();
    this.eLh = new j();
    Tn();
    To();
    d(this.fileName, paramBoolean, i);
  }
  
  public final void b(b.a parama)
  {
    if ((this.eLi != null) && (parama != null)) {
      this.eLi.a(parama);
    }
  }
  
  public final boolean c(String paramString, boolean paramBoolean, int paramInt)
  {
    return d(paramString, paramBoolean, paramInt);
  }
  
  public final int getStatus()
  {
    return this.status;
  }
  
  public final boolean isPlaying()
  {
    return this.status == 1;
  }
  
  public final boolean ub()
  {
    if (this.status != 2) {
      y.e("MicroMsg.VoicePlayer", "resume not STATUS_PAUSE error status:" + this.status);
    }
    for (;;)
    {
      return false;
      try
      {
        y.d("MicroMsg.VoicePlayer", "resume mediaPlayer.start()");
        this.eLh.start();
        if ((this.eLi != null) && (this.eKt))
        {
          y.d("MicroMsg.VoicePlayer", "resume audioFocusHelper.requestFocus()");
          this.eLi.requestFocus();
        }
        this.status = 1;
        return true;
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.VoicePlayer", "resume File[" + this.fileName + "] ErrMsg[" + localException.getStackTrace() + "]");
        this.status = -1;
        return false;
      }
      finally
      {
        if ((this.eLi != null) && (this.eKt))
        {
          y.d("MicroMsg.VoicePlayer", "resume audioFocusHelper.requestFocus()");
          this.eLi.requestFocus();
        }
      }
    }
  }
  
  public final double ue()
  {
    if ((this.status != 1) && (this.status != 2)) {
      return 0.0D;
    }
    int i;
    int j;
    try
    {
      i = this.eLh.getCurrentPosition();
      j = this.eLh.getDuration();
      if (j == 0)
      {
        y.e("MicroMsg.VoicePlayer", "getDuration File[" + this.fileName + "] Failed");
        return 0.0D;
      }
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.VoicePlayer", "getNowProgress File[" + this.fileName + "] ErrMsg[" + localException.getStackTrace() + "]");
      un();
      return 0.0D;
    }
    return i / j;
  }
  
  public final boolean un()
  {
    if ((this.status != 1) && (this.status != 2)) {
      y.e("MicroMsg.VoicePlayer", "stop not STATUS_PLAYING or STATUS_PAUSE error status:" + this.status);
    }
    for (;;)
    {
      return false;
      try
      {
        y.d("MicroMsg.VoicePlayer", "stop mediaPlayer.stop()");
        this.eLh.stop();
        this.eLh.release();
        if ((this.eLi != null) && (this.eKt))
        {
          y.d("MicroMsg.VoicePlayer", "stop audioFocusHelper.abandonFocus()");
          this.eLi.zE();
        }
        this.status = 0;
        return true;
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.VoicePlayer", "stop File[" + this.fileName + "] ErrMsg[" + localException.getStackTrace() + "]");
        this.status = -1;
        return false;
      }
      finally
      {
        if ((this.eLi != null) && (this.eKt))
        {
          y.d("MicroMsg.VoicePlayer", "stop audioFocusHelper.abandonFocus()");
          this.eLi.zE();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelvoice.s
 * JD-Core Version:    0.7.0.1
 */