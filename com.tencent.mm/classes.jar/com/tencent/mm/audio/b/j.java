package com.tencent.mm.audio.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.c.a;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;

public final class j
{
  public static int cZR = 100;
  private com.tencent.mm.compatible.util.b cZO;
  public b cZP;
  public a cZQ;
  String fileName;
  public int status;
  
  public j()
  {
    AppMethodBeat.i(148365);
    this.fileName = "";
    this.cZQ = null;
    this.status = 0;
    this.cZP = new b(c.a.fyG);
    this.cZO = new com.tencent.mm.compatible.util.b(aj.getContext());
    AppMethodBeat.o(148365);
  }
  
  public final boolean Ob()
  {
    AppMethodBeat.i(148367);
    this.cZO.XF();
    if (this.cZP == null)
    {
      AppMethodBeat.o(148367);
      return true;
    }
    try
    {
      this.cZP.Ft();
      this.cZP.release();
      this.fileName = "";
      this.status = 0;
      AppMethodBeat.o(148367);
      return true;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.SimpleVoiceRecorder", "StopRecord File[" + this.fileName + "] ErrMsg[" + localException.getMessage() + "]");
      this.status = -1;
      AppMethodBeat.o(148367);
    }
    return false;
  }
  
  public final boolean fQ(String paramString)
  {
    AppMethodBeat.i(148366);
    f.a locala = new f.a();
    if (this.fileName.length() > 0)
    {
      ad.e("MicroMsg.SimpleVoiceRecorder", "Duplicate Call startRecord , maybe Stop Fail Before");
      AppMethodBeat.o(148366);
      return false;
    }
    this.fileName = paramString;
    try
    {
      this.cZO.requestFocus();
      this.cZP.a(new b.a()
      {
        public final void onError()
        {
          AppMethodBeat.i(148364);
          j.a(j.this).XF();
          if (j.b(j.this) != null) {
            j.b(j.this).onError();
          }
          try
          {
            j.c(j.this).release();
            j.d(j.this);
            AppMethodBeat.o(148364);
            return;
          }
          catch (Exception localException)
          {
            ad.e("MicroMsg.SimpleVoiceRecorder", "setErrorListener File[" + j.this.fileName + "] ErrMsg[" + localException.getStackTrace() + "]");
            AppMethodBeat.o(148364);
          }
        }
      });
      this.cZP.Oe();
      this.cZP.Of();
      this.cZP.Od();
      this.cZP.setOutputFile(this.fileName);
      this.cZP.setMaxDuration(3600010);
      this.cZP.prepare();
      this.cZP.start();
      ad.d("MicroMsg.SimpleVoiceRecorder", "StartRecord File[" + this.fileName + "] start time:" + locala.XK());
      this.status = 1;
      AppMethodBeat.o(148366);
      return true;
    }
    catch (Exception paramString)
    {
      this.cZO.XF();
      ad.e("MicroMsg.SimpleVoiceRecorder", "StartRecord File[" + this.fileName + "] ErrMsg[" + paramString.getMessage() + "]");
      this.status = -1;
      AppMethodBeat.o(148366);
    }
    return false;
  }
  
  public static abstract interface a
  {
    public abstract void onError();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.audio.b.j
 * JD-Core Version:    0.7.0.1
 */