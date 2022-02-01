package com.tencent.mm.audio.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.c.a;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class j
{
  public static int dAR = 100;
  private com.tencent.mm.compatible.util.b dAO;
  public b dAP;
  public a dAQ;
  String fileName;
  public int status;
  
  public j()
  {
    AppMethodBeat.i(148365);
    this.fileName = "";
    this.dAQ = null;
    this.status = 0;
    this.dAP = new b(c.a.gCN);
    this.dAO = new com.tencent.mm.compatible.util.b(MMApplicationContext.getContext());
    AppMethodBeat.o(148365);
  }
  
  public final boolean ZZ()
  {
    AppMethodBeat.i(148367);
    this.dAO.apm();
    if (this.dAP == null)
    {
      AppMethodBeat.o(148367);
      return true;
    }
    try
    {
      this.dAP.Qt();
      this.dAP.release();
      this.fileName = "";
      this.status = 0;
      AppMethodBeat.o(148367);
      return true;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.SimpleVoiceRecorder", "StopRecord File[" + this.fileName + "] ErrMsg[" + localException.getMessage() + "]");
      this.status = -1;
      AppMethodBeat.o(148367);
    }
    return false;
  }
  
  public final boolean hy(String paramString)
  {
    AppMethodBeat.i(148366);
    f.a locala = new f.a();
    if (this.fileName.length() > 0)
    {
      Log.e("MicroMsg.SimpleVoiceRecorder", "Duplicate Call startRecord , maybe Stop Fail Before");
      AppMethodBeat.o(148366);
      return false;
    }
    this.fileName = paramString;
    try
    {
      this.dAO.requestFocus();
      this.dAP.a(new b.a()
      {
        public final void onError()
        {
          AppMethodBeat.i(148364);
          j.a(j.this).apm();
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
            Log.e("MicroMsg.SimpleVoiceRecorder", "setErrorListener File[" + j.this.fileName + "] ErrMsg[" + localException.getStackTrace() + "]");
            AppMethodBeat.o(148364);
          }
        }
      });
      this.dAP.aac();
      this.dAP.aad();
      this.dAP.aab();
      this.dAP.setOutputFile(this.fileName);
      this.dAP.setMaxDuration(3600010);
      this.dAP.prepare();
      this.dAP.start();
      Log.d("MicroMsg.SimpleVoiceRecorder", "StartRecord File[" + this.fileName + "] start time:" + locala.apr());
      this.status = 1;
      AppMethodBeat.o(148366);
      return true;
    }
    catch (Exception paramString)
    {
      this.dAO.apm();
      Log.e("MicroMsg.SimpleVoiceRecorder", "StartRecord File[" + this.fileName + "] ErrMsg[" + paramString.getMessage() + "]");
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