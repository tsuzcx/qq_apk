package com.tencent.mm.audio.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.c.a;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;

public final class j
{
  public static int cXn = 100;
  private com.tencent.mm.compatible.util.b cXk;
  public b cXl;
  public j.a cXm;
  String fileName;
  public int status;
  
  public j()
  {
    AppMethodBeat.i(148365);
    this.fileName = "";
    this.cXm = null;
    this.status = 0;
    this.cXl = new b(c.a.fCn);
    this.cXk = new com.tencent.mm.compatible.util.b(ai.getContext());
    AppMethodBeat.o(148365);
  }
  
  public final boolean NX()
  {
    AppMethodBeat.i(148367);
    this.cXk.YC();
    if (this.cXl == null)
    {
      AppMethodBeat.o(148367);
      return true;
    }
    try
    {
      this.cXl.Fb();
      this.cXl.release();
      this.fileName = "";
      this.status = 0;
      AppMethodBeat.o(148367);
      return true;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.SimpleVoiceRecorder", "StopRecord File[" + this.fileName + "] ErrMsg[" + localException.getMessage() + "]");
      this.status = -1;
      AppMethodBeat.o(148367);
    }
    return false;
  }
  
  public final boolean fG(String paramString)
  {
    AppMethodBeat.i(148366);
    f.a locala = new f.a();
    if (this.fileName.length() > 0)
    {
      ac.e("MicroMsg.SimpleVoiceRecorder", "Duplicate Call startRecord , maybe Stop Fail Before");
      AppMethodBeat.o(148366);
      return false;
    }
    this.fileName = paramString;
    try
    {
      this.cXk.requestFocus();
      this.cXl.a(new b.a()
      {
        public final void onError()
        {
          AppMethodBeat.i(148364);
          j.a(j.this).YC();
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
            ac.e("MicroMsg.SimpleVoiceRecorder", "setErrorListener File[" + j.this.fileName + "] ErrMsg[" + localException.getStackTrace() + "]");
            AppMethodBeat.o(148364);
          }
        }
      });
      this.cXl.Oa();
      this.cXl.Ob();
      this.cXl.NZ();
      this.cXl.setOutputFile(this.fileName);
      this.cXl.setMaxDuration(3600010);
      this.cXl.prepare();
      this.cXl.start();
      ac.d("MicroMsg.SimpleVoiceRecorder", "StartRecord File[" + this.fileName + "] start time:" + locala.YH());
      this.status = 1;
      AppMethodBeat.o(148366);
      return true;
    }
    catch (Exception paramString)
    {
      this.cXk.YC();
      ac.e("MicroMsg.SimpleVoiceRecorder", "StartRecord File[" + this.fileName + "] ErrMsg[" + paramString.getMessage() + "]");
      this.status = -1;
      AppMethodBeat.o(148366);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.audio.b.j
 * JD-Core Version:    0.7.0.1
 */