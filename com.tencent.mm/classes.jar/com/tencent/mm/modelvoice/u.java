package com.tencent.mm.modelvoice;

import android.content.Context;
import android.media.MediaPlayer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.k;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.compatible.util.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;

public final class u
  implements d
{
  boolean fZY;
  String fileName;
  MediaPlayer gaO;
  com.tencent.mm.compatible.util.b gaP;
  d.a gaf;
  d.b gag;
  int status;
  
  public u()
  {
    AppMethodBeat.i(55841);
    this.fileName = "";
    this.gaf = null;
    this.gag = null;
    this.status = 0;
    this.fZY = true;
    this.gaO = new k();
    amz();
    amA();
    ab.d("MicroMsg.VoicePlayer", "VoicePlayer");
    AppMethodBeat.o(55841);
  }
  
  public u(Context paramContext)
  {
    this();
    AppMethodBeat.i(55842);
    this.gaP = new com.tencent.mm.compatible.util.b(paramContext);
    ab.d("MicroMsg.VoicePlayer", "VoicePlayer context");
    AppMethodBeat.o(55842);
  }
  
  private void amA()
  {
    AppMethodBeat.i(55844);
    this.gaO.setOnErrorListener(new u.2(this));
    AppMethodBeat.o(55844);
  }
  
  private void amz()
  {
    AppMethodBeat.i(55843);
    this.gaO.setOnCompletionListener(new u.1(this));
    AppMethodBeat.o(55843);
  }
  
  private boolean e(String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(55848);
    if (this.status != 0)
    {
      ab.e("MicroMsg.VoicePlayer", "startPlay error status:" + this.status);
      AppMethodBeat.o(55848);
      return false;
    }
    ab.i("MicroMsg.VoicePlayer", "startPlay speakerOn:%s,seekTo:%s,", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    this.fileName = paramString;
    try
    {
      h(paramBoolean, paramInt);
      this.status = 1;
      AppMethodBeat.o(55848);
      return true;
    }
    catch (Exception paramString)
    {
      try
      {
        h(true, paramInt);
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.VoicePlayer", "startPlay File[" + this.fileName + "] failed");
        ab.e("MicroMsg.VoicePlayer", "exception:%s", new Object[] { bo.l(paramString) });
        this.status = -1;
        AppMethodBeat.o(55848);
      }
    }
    return false;
  }
  
  private void h(boolean paramBoolean, int paramInt)
  {
    int j = 3;
    AppMethodBeat.i(55849);
    if (!e.cN(this.fileName))
    {
      AppMethodBeat.o(55849);
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
        ab.d("MicroMsg.VoicePlayer", "playImp speakerOn:%s,seekTo:%s,type:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), Integer.valueOf(i) });
        if (!ac.erv.emD) {
          break label249;
        }
        ac.erv.dump();
        if (ac.erv.emK != 1) {
          break label249;
        }
        i = j;
        if ((this.gaP != null) && (this.fZY))
        {
          ab.d("MicroMsg.VoicePlayer", "playImp audioFocusHelper.requestFocus");
          this.gaP.requestFocus();
        }
        this.gaO.setAudioStreamType(i);
        this.gaO.setDataSource(this.fileName);
        this.gaO.prepare();
        if (paramInt > 0) {
          this.gaO.seekTo(paramInt);
        }
        this.gaO.start();
        AppMethodBeat.o(55849);
        return;
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.VoicePlayer", "playImp : fail, exception = " + localException.getMessage());
        ab.e("MicroMsg.VoicePlayer", "exception:%s", new Object[] { bo.l(localException) });
        if ((this.gaP == null) || (!this.fZY)) {
          continue;
        }
        this.gaP.Mh();
        AppMethodBeat.o(55849);
        return;
      }
      i = 0;
    }
  }
  
  public final boolean Eo()
  {
    AppMethodBeat.i(55851);
    if (this.status != 2)
    {
      ab.e("MicroMsg.VoicePlayer", "resume not STATUS_PAUSE error status:" + this.status);
      AppMethodBeat.o(55851);
      return false;
    }
    try
    {
      ab.d("MicroMsg.VoicePlayer", "resume mediaPlayer.start()");
      this.gaO.start();
      if ((this.gaP != null) && (this.fZY))
      {
        ab.d("MicroMsg.VoicePlayer", "resume audioFocusHelper.requestFocus()");
        this.gaP.requestFocus();
      }
      this.status = 1;
      AppMethodBeat.o(55851);
      return true;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.VoicePlayer", "resume File[" + this.fileName + "] ErrMsg[" + localException.getStackTrace() + "]");
      this.status = -1;
      return false;
    }
    finally
    {
      if ((this.gaP != null) && (this.fZY))
      {
        ab.d("MicroMsg.VoicePlayer", "resume audioFocusHelper.requestFocus()");
        this.gaP.requestFocus();
      }
      AppMethodBeat.o(55851);
    }
  }
  
  public final double Er()
  {
    AppMethodBeat.i(55853);
    if ((this.status != 1) && (this.status != 2))
    {
      AppMethodBeat.o(55853);
      return 0.0D;
    }
    int i;
    int j;
    try
    {
      i = this.gaO.getCurrentPosition();
      j = this.gaO.getDuration();
      if (j == 0)
      {
        ab.e("MicroMsg.VoicePlayer", "getDuration File[" + this.fileName + "] Failed");
        AppMethodBeat.o(55853);
        return 0.0D;
      }
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.VoicePlayer", "getNowProgress File[" + this.fileName + "] ErrMsg[" + localException.getStackTrace() + "]");
      Ez();
      AppMethodBeat.o(55853);
      return 0.0D;
    }
    double d = i / j;
    AppMethodBeat.o(55853);
    return d;
  }
  
  public final boolean Ez()
  {
    AppMethodBeat.i(55852);
    if ((this.status != 1) && (this.status != 2))
    {
      ab.e("MicroMsg.VoicePlayer", "stop not STATUS_PLAYING or STATUS_PAUSE error status:" + this.status);
      AppMethodBeat.o(55852);
      return false;
    }
    try
    {
      ab.d("MicroMsg.VoicePlayer", "stop mediaPlayer.stop()");
      this.gaO.stop();
      this.gaO.release();
      if ((this.gaP != null) && (this.fZY))
      {
        ab.d("MicroMsg.VoicePlayer", "stop audioFocusHelper.abandonFocus()");
        this.gaP.Mh();
      }
      this.status = 0;
      AppMethodBeat.o(55852);
      return true;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.VoicePlayer", "stop File[" + this.fileName + "] ErrMsg[" + localException.getStackTrace() + "]");
      this.status = -1;
      return false;
    }
    finally
    {
      if ((this.gaP != null) && (this.fZY))
      {
        ab.d("MicroMsg.VoicePlayer", "stop audioFocusHelper.abandonFocus()");
        this.gaP.Mh();
      }
      AppMethodBeat.o(55852);
    }
  }
  
  public final boolean T(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(55846);
    paramBoolean = e(paramString, paramBoolean, 0);
    AppMethodBeat.o(55846);
    return paramBoolean;
  }
  
  public final void a(d.a parama)
  {
    this.gaf = parama;
  }
  
  public final void a(d.b paramb)
  {
    this.gag = paramb;
  }
  
  public final void ami()
  {
    this.fZY = false;
  }
  
  public final void b(b.a parama)
  {
    AppMethodBeat.i(55854);
    if ((this.gaP != null) && (parama != null)) {
      this.gaP.a(parama);
    }
    AppMethodBeat.o(55854);
  }
  
  public final boolean bw(boolean paramBoolean)
  {
    AppMethodBeat.i(55850);
    if (this.status != 1)
    {
      ab.e("MicroMsg.VoicePlayer", "pause not STATUS_PLAYING error status:" + this.status);
      AppMethodBeat.o(55850);
      return false;
    }
    try
    {
      ab.d("MicroMsg.VoicePlayer", "pause mediaPlayer.pause()");
      this.gaO.pause();
      if ((this.gaP != null) && (paramBoolean) && (this.fZY))
      {
        ab.d("MicroMsg.VoicePlayer", "pause audioFocusHelper.abandonFocus()");
        this.gaP.Mh();
      }
      this.status = 2;
      AppMethodBeat.o(55850);
      return true;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.VoicePlayer", "pause File[" + this.fileName + "] ErrMsg[" + localException.getStackTrace() + "]");
      this.status = -1;
      return false;
    }
    finally
    {
      if ((this.gaP != null) && (paramBoolean) && (this.fZY))
      {
        ab.d("MicroMsg.VoicePlayer", "pause audioFocusHelper.abandonFocus()");
        this.gaP.Mh();
      }
      AppMethodBeat.o(55850);
    }
  }
  
  public final void bx(boolean paramBoolean)
  {
    AppMethodBeat.i(55845);
    ab.d("MicroMsg.VoicePlayer", "setSpeakerOn=".concat(String.valueOf(paramBoolean)));
    if (this.gaO == null)
    {
      AppMethodBeat.o(55845);
      return;
    }
    if (ax.Ep())
    {
      ab.v("MicroMsg.VoicePlayer", "setSpeakOn return when calling");
      AppMethodBeat.o(55845);
      return;
    }
    int i = this.gaO.getCurrentPosition();
    Ez();
    this.gaO = new k();
    amz();
    amA();
    e(this.fileName, paramBoolean, i);
    AppMethodBeat.o(55845);
  }
  
  public final boolean d(String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(55847);
    paramBoolean = e(paramString, paramBoolean, paramInt);
    AppMethodBeat.o(55847);
    return paramBoolean;
  }
  
  public final int getStatus()
  {
    return this.status;
  }
  
  public final boolean isPlaying()
  {
    return this.status == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvoice.u
 * JD-Core Version:    0.7.0.1
 */