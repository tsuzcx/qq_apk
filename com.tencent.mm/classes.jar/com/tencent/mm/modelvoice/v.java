package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.l.a;
import com.tencent.mm.audio.b.a;
import com.tencent.mm.audio.b.b;
import com.tencent.mm.audio.b.b.b;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.compatible.b.c.a;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class v
  implements a
{
  private static int hxV = 100;
  String fileName;
  private b hxT;
  private l.a peX;
  private int status;
  
  public v(c.a parama)
  {
    AppMethodBeat.i(148500);
    this.fileName = "";
    this.peX = null;
    this.status = 0;
    this.hxT = new b(parama);
    AppMethodBeat.o(148500);
  }
  
  public final void a(l.a parama)
  {
    this.peX = parama;
  }
  
  public final boolean aGH()
  {
    AppMethodBeat.i(148502);
    if (this.hxT == null)
    {
      AppMethodBeat.o(148502);
      return true;
    }
    try
    {
      this.hxT.stop();
      this.hxT.release();
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
  
  public final int aGI()
  {
    AppMethodBeat.i(148503);
    if (this.status == 1)
    {
      int i = this.hxT.aGI();
      if (i > hxV) {
        hxV = i;
      }
      i = i * 100 / hxV;
      AppMethodBeat.o(148503);
      return i;
    }
    AppMethodBeat.o(148503);
    return 0;
  }
  
  public final int aGJ()
  {
    b localb = this.hxT;
    if (((localb.hvJ == c.a.lQd) || (localb.hvJ == c.a.lQf)) && (localb.hvI != null)) {
      return localb.hvI.hwE;
    }
    return 1;
  }
  
  public final int getStatus()
  {
    return this.status;
  }
  
  public final boolean jL(String paramString)
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
      this.hxT.a(new b.b()
      {
        public final void atR()
        {
          AppMethodBeat.i(148499);
          if (v.a(v.this) != null) {
            v.a(v.this).atR();
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
      this.hxT.aGL();
      this.hxT.aGM();
      this.hxT.aGK();
      this.hxT.setOutputFile(this.fileName);
      this.hxT.oj(70000);
      this.hxT.prepare();
      this.hxT.start();
      Log.d("VoiceRecorder", "StartRecord File[" + this.fileName + "] start time:" + locala.aPY());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.modelvoice.v
 * JD-Core Version:    0.7.0.1
 */