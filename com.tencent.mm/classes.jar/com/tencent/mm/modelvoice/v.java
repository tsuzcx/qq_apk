package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.m.a;
import com.tencent.mm.audio.b.a;
import com.tencent.mm.audio.b.b;
import com.tencent.mm.audio.b.b.a;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.compatible.b.c.a;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class v
  implements a
{
  private static int ftG = 100;
  String fileName;
  private b ftE;
  private m.a mll;
  private int status;
  
  public v(c.a parama)
  {
    AppMethodBeat.i(148500);
    this.fileName = "";
    this.mll = null;
    this.status = 0;
    this.ftE = new b(parama);
    AppMethodBeat.o(148500);
  }
  
  public final void a(m.a parama)
  {
    this.mll = parama;
  }
  
  public final boolean aeJ()
  {
    AppMethodBeat.i(148502);
    if (this.ftE == null)
    {
      AppMethodBeat.o(148502);
      return true;
    }
    try
    {
      this.ftE.TV();
      this.ftE.release();
      this.fileName = "";
      this.status = 0;
      AppMethodBeat.o(148502);
      return true;
    }
    catch (Exception localException)
    {
      Log.e("VoiceRecorder", "StopRecord File[" + this.fileName + "] ErrMsg[" + localException.getMessage() + "]");
      this.status = -1;
      AppMethodBeat.o(148502);
    }
    return false;
  }
  
  public final int aeK()
  {
    AppMethodBeat.i(148503);
    if (this.status == 1)
    {
      int i = this.ftE.aeK();
      if (i > ftG) {
        ftG = i;
      }
      i = i * 100 / ftG;
      AppMethodBeat.o(148503);
      return i;
    }
    AppMethodBeat.o(148503);
    return 0;
  }
  
  public final int aeL()
  {
    b localb = this.ftE;
    if (((localb.fry == c.a.jmS) || (localb.fry == c.a.jmU)) && (localb.frx != null)) {
      return localb.frx.fsp;
    }
    return 1;
  }
  
  public final int getStatus()
  {
    return this.status;
  }
  
  public final boolean ik(String paramString)
  {
    AppMethodBeat.i(148501);
    if (Util.isNullOrNil(paramString)) {}
    f.a locala;
    for (int i = 0;; i = paramString.length())
    {
      Log.i("VoiceRecorder", "[startRecord] fileName:%s size:%s", new Object[] { paramString, Integer.valueOf(i) });
      locala = new f.a();
      if ((Util.isNullOrNil(this.fileName)) || (this.fileName.length() <= 0)) {
        break;
      }
      Log.e("VoiceRecorder", "Duplicate Call startRecord , maybe Stop Fail Before");
      AppMethodBeat.o(148501);
      return false;
    }
    this.fileName = paramString;
    try
    {
      this.ftE.a(new b.a()
      {
        public final void onError()
        {
          AppMethodBeat.i(148499);
          if (v.a(v.this) != null) {
            v.a(v.this).onError();
          }
          try
          {
            v.b(v.this).release();
            v.c(v.this);
            AppMethodBeat.o(148499);
            return;
          }
          catch (Exception localException)
          {
            Log.e("VoiceRecorder", "setErrorListener File[" + v.this.fileName + "] ErrMsg[" + localException.getStackTrace() + "]");
            AppMethodBeat.o(148499);
          }
        }
      });
      this.ftE.aeN();
      this.ftE.aeO();
      this.ftE.aeM();
      this.ftE.setOutputFile(this.fileName);
      this.ftE.kC(70000);
      this.ftE.prepare();
      this.ftE.start();
      Log.d("VoiceRecorder", "StartRecord File[" + this.fileName + "] start time:" + locala.avE());
      this.status = 1;
      AppMethodBeat.o(148501);
      return true;
    }
    catch (Exception paramString)
    {
      Log.e("VoiceRecorder", "StartRecord File[" + this.fileName + "] ErrMsg[" + paramString.getMessage() + "]");
      this.status = -1;
      AppMethodBeat.o(148501);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.modelvoice.v
 * JD-Core Version:    0.7.0.1
 */