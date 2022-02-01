package com.tencent.mm.audio.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.c.a;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;

public final class j
{
  public static int djH = 100;
  private com.tencent.mm.compatible.util.b djE;
  public b djF;
  public a djG;
  String fileName;
  public int status;
  
  public j()
  {
    AppMethodBeat.i(148365);
    this.fileName = "";
    this.djG = null;
    this.status = 0;
    this.djF = new b(c.a.fXH);
    this.djE = new com.tencent.mm.compatible.util.b(ak.getContext());
    AppMethodBeat.o(148365);
  }
  
  public final boolean PF()
  {
    AppMethodBeat.i(148367);
    this.djE.abn();
    if (this.djF == null)
    {
      AppMethodBeat.o(148367);
      return true;
    }
    try
    {
      this.djF.GB();
      this.djF.release();
      this.fileName = "";
      this.status = 0;
      AppMethodBeat.o(148367);
      return true;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.SimpleVoiceRecorder", "StopRecord File[" + this.fileName + "] ErrMsg[" + localException.getMessage() + "]");
      this.status = -1;
      AppMethodBeat.o(148367);
    }
    return false;
  }
  
  public final boolean gH(String paramString)
  {
    AppMethodBeat.i(148366);
    f.a locala = new f.a();
    if (this.fileName.length() > 0)
    {
      ae.e("MicroMsg.SimpleVoiceRecorder", "Duplicate Call startRecord , maybe Stop Fail Before");
      AppMethodBeat.o(148366);
      return false;
    }
    this.fileName = paramString;
    try
    {
      this.djE.requestFocus();
      this.djF.a(new b.a()
      {
        public final void onError()
        {
          AppMethodBeat.i(148364);
          j.a(j.this).abn();
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
            ae.e("MicroMsg.SimpleVoiceRecorder", "setErrorListener File[" + j.this.fileName + "] ErrMsg[" + localException.getStackTrace() + "]");
            AppMethodBeat.o(148364);
          }
        }
      });
      this.djF.PI();
      this.djF.PJ();
      this.djF.PH();
      this.djF.setOutputFile(this.fileName);
      this.djF.setMaxDuration(3600010);
      this.djF.prepare();
      this.djF.start();
      ae.d("MicroMsg.SimpleVoiceRecorder", "StartRecord File[" + this.fileName + "] start time:" + locala.abs());
      this.status = 1;
      AppMethodBeat.o(148366);
      return true;
    }
    catch (Exception paramString)
    {
      this.djE.abn();
      ae.e("MicroMsg.SimpleVoiceRecorder", "StartRecord File[" + this.fileName + "] ErrMsg[" + paramString.getMessage() + "]");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.audio.b.j
 * JD-Core Version:    0.7.0.1
 */