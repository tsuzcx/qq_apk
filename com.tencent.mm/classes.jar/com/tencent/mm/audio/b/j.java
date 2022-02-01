package com.tencent.mm.audio.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.c.a;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;

public final class j
{
  public static int diF = 100;
  private com.tencent.mm.compatible.util.b diC;
  public b diD;
  public a diE;
  String fileName;
  public int status;
  
  public j()
  {
    AppMethodBeat.i(148365);
    this.fileName = "";
    this.diE = null;
    this.status = 0;
    this.diD = new b(c.a.fVB);
    this.diC = new com.tencent.mm.compatible.util.b(aj.getContext());
    AppMethodBeat.o(148365);
  }
  
  public final boolean PG()
  {
    AppMethodBeat.i(148367);
    this.diC.abe();
    if (this.diD == null)
    {
      AppMethodBeat.o(148367);
      return true;
    }
    try
    {
      this.diD.Gv();
      this.diD.release();
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
  
  public final boolean gB(String paramString)
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
      this.diC.requestFocus();
      this.diD.a(new b.a()
      {
        public final void onError()
        {
          AppMethodBeat.i(148364);
          j.a(j.this).abe();
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
      this.diD.PJ();
      this.diD.PK();
      this.diD.PI();
      this.diD.setOutputFile(this.fileName);
      this.diD.setMaxDuration(3600010);
      this.diD.prepare();
      this.diD.start();
      ad.d("MicroMsg.SimpleVoiceRecorder", "StartRecord File[" + this.fileName + "] start time:" + locala.abj());
      this.status = 1;
      AppMethodBeat.o(148366);
      return true;
    }
    catch (Exception paramString)
    {
      this.diC.abe();
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