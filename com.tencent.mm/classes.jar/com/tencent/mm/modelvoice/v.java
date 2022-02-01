package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.j.a;
import com.tencent.mm.audio.b.a;
import com.tencent.mm.audio.b.b;
import com.tencent.mm.audio.b.b.a;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.compatible.b.c.a;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class v
  implements a
{
  private static int djH = 100;
  private b djF;
  String fileName;
  private j.a iAt;
  private int status;
  
  public v(c.a parama)
  {
    AppMethodBeat.i(148500);
    this.fileName = "";
    this.iAt = null;
    this.status = 0;
    this.djF = new b(parama);
    AppMethodBeat.o(148500);
  }
  
  public final boolean PF()
  {
    AppMethodBeat.i(148502);
    if (this.djF == null)
    {
      AppMethodBeat.o(148502);
      return true;
    }
    try
    {
      this.djF.GB();
      this.djF.release();
      this.fileName = "";
      this.status = 0;
      AppMethodBeat.o(148502);
      return true;
    }
    catch (Exception localException)
    {
      ae.e("VoiceRecorder", "StopRecord File[" + this.fileName + "] ErrMsg[" + localException.getMessage() + "]");
      this.status = -1;
      AppMethodBeat.o(148502);
    }
    return false;
  }
  
  public final int PG()
  {
    b localb = this.djF;
    if (((localb.dhx == c.a.fXG) || (localb.dhx == c.a.fXI)) && (localb.dhw != null)) {
      return localb.dhw.dio;
    }
    return 1;
  }
  
  public final void a(j.a parama)
  {
    this.iAt = parama;
  }
  
  public final boolean gF(String paramString)
  {
    AppMethodBeat.i(148501);
    if (bu.isNullOrNil(paramString)) {}
    f.a locala;
    for (int i = 0;; i = paramString.length())
    {
      ae.i("VoiceRecorder", "[startRecord] fileName:%s size:%s", new Object[] { paramString, Integer.valueOf(i) });
      locala = new f.a();
      if ((bu.isNullOrNil(this.fileName)) || (this.fileName.length() <= 0)) {
        break;
      }
      ae.e("VoiceRecorder", "Duplicate Call startRecord , maybe Stop Fail Before");
      AppMethodBeat.o(148501);
      return false;
    }
    this.fileName = paramString;
    try
    {
      this.djF.a(new b.a()
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
            ae.e("VoiceRecorder", "setErrorListener File[" + v.this.fileName + "] ErrMsg[" + localException.getStackTrace() + "]");
            AppMethodBeat.o(148499);
          }
        }
      });
      this.djF.PI();
      this.djF.PJ();
      this.djF.PH();
      this.djF.setOutputFile(this.fileName);
      this.djF.setMaxDuration(70000);
      this.djF.prepare();
      this.djF.start();
      ae.d("VoiceRecorder", "StartRecord File[" + this.fileName + "] start time:" + locala.abs());
      this.status = 1;
      AppMethodBeat.o(148501);
      return true;
    }
    catch (Exception paramString)
    {
      ae.e("VoiceRecorder", "StartRecord File[" + this.fileName + "] ErrMsg[" + paramString.getMessage() + "]");
      this.status = -1;
      AppMethodBeat.o(148501);
    }
    return false;
  }
  
  public final int getMaxAmplitude()
  {
    AppMethodBeat.i(148503);
    if (this.status == 1)
    {
      int i = this.djF.getMaxAmplitude();
      if (i > djH) {
        djH = i;
      }
      i = i * 100 / djH;
      AppMethodBeat.o(148503);
      return i;
    }
    AppMethodBeat.o(148503);
    return 0;
  }
  
  public final int getStatus()
  {
    return this.status;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelvoice.v
 * JD-Core Version:    0.7.0.1
 */