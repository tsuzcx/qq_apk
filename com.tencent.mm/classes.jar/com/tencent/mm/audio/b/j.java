package com.tencent.mm.audio.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.c.a;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class j
{
  public static int hxV = 100;
  String fileName;
  private com.tencent.mm.compatible.util.b hxS;
  public b hxT;
  public a hxU;
  public int status;
  
  public j()
  {
    AppMethodBeat.i(148365);
    this.fileName = "";
    this.hxU = null;
    this.status = 0;
    this.hxT = new b(c.a.lQe);
    this.hxS = new com.tencent.mm.compatible.util.b(MMApplicationContext.getContext());
    AppMethodBeat.o(148365);
  }
  
  public final boolean aGH()
  {
    AppMethodBeat.i(148367);
    this.hxS.aPS();
    if (this.hxT == null)
    {
      AppMethodBeat.o(148367);
      return true;
    }
    try
    {
      this.hxT.stop();
      this.hxT.release();
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
  
  public final boolean jN(String paramString)
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
      this.hxS.requestFocus();
      this.hxT.a(new b.b()
      {
        public final void atR()
        {
          AppMethodBeat.i(148364);
          j.a(j.this).aPS();
          if (j.b(j.this) != null) {
            j.b(j.this).atR();
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
      this.hxT.aGL();
      this.hxT.aGM();
      this.hxT.aGK();
      this.hxT.setOutputFile(this.fileName);
      this.hxT.oj(3600010);
      this.hxT.prepare();
      this.hxT.start();
      Log.d("MicroMsg.SimpleVoiceRecorder", "StartRecord File[" + this.fileName + "] start time:" + locala.aPY());
      this.status = 1;
      AppMethodBeat.o(148366);
      return true;
    }
    catch (Exception paramString)
    {
      this.hxS.aPS();
      Log.e("MicroMsg.SimpleVoiceRecorder", "StartRecord File[" + this.fileName + "] ErrMsg[" + paramString.getMessage() + "]");
      this.status = -1;
      AppMethodBeat.o(148366);
    }
    return false;
  }
  
  public static abstract interface a
  {
    public abstract void atR();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.audio.b.j
 * JD-Core Version:    0.7.0.1
 */