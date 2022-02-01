package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.k.a;
import com.tencent.mm.audio.b.a;
import com.tencent.mm.audio.b.b;
import com.tencent.mm.audio.b.b.a;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.compatible.b.c.a;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class v
  implements a
{
  private static int cXn = 100;
  private b cXl;
  String fileName;
  private k.a ief;
  private int status;
  
  public v(c.a parama)
  {
    AppMethodBeat.i(148500);
    this.fileName = "";
    this.ief = null;
    this.status = 0;
    this.cXl = new b(parama);
    AppMethodBeat.o(148500);
  }
  
  public final boolean NX()
  {
    AppMethodBeat.i(148502);
    if (this.cXl == null)
    {
      AppMethodBeat.o(148502);
      return true;
    }
    try
    {
      this.cXl.Fb();
      this.cXl.release();
      this.fileName = "";
      this.status = 0;
      AppMethodBeat.o(148502);
      return true;
    }
    catch (Exception localException)
    {
      ac.e("VoiceRecorder", "StopRecord File[" + this.fileName + "] ErrMsg[" + localException.getMessage() + "]");
      this.status = -1;
      AppMethodBeat.o(148502);
    }
    return false;
  }
  
  public final int NY()
  {
    b localb = this.cXl;
    if (((localb.cVf == c.a.fCm) || (localb.cVf == c.a.fCo)) && (localb.cVe != null)) {
      return localb.cVe.cVW;
    }
    return 1;
  }
  
  public final void a(k.a parama)
  {
    this.ief = parama;
  }
  
  public final boolean fE(String paramString)
  {
    AppMethodBeat.i(148501);
    if (bs.isNullOrNil(paramString)) {}
    f.a locala;
    for (int i = 0;; i = paramString.length())
    {
      ac.i("VoiceRecorder", "[startRecord] fileName:%s size:%s", new Object[] { paramString, Integer.valueOf(i) });
      locala = new f.a();
      if ((bs.isNullOrNil(this.fileName)) || (this.fileName.length() <= 0)) {
        break;
      }
      ac.e("VoiceRecorder", "Duplicate Call startRecord , maybe Stop Fail Before");
      AppMethodBeat.o(148501);
      return false;
    }
    this.fileName = paramString;
    try
    {
      this.cXl.a(new b.a()
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
            ac.e("VoiceRecorder", "setErrorListener File[" + v.this.fileName + "] ErrMsg[" + localException.getStackTrace() + "]");
            AppMethodBeat.o(148499);
          }
        }
      });
      this.cXl.Oa();
      this.cXl.Ob();
      this.cXl.NZ();
      this.cXl.setOutputFile(this.fileName);
      this.cXl.setMaxDuration(70000);
      this.cXl.prepare();
      this.cXl.start();
      ac.d("VoiceRecorder", "StartRecord File[" + this.fileName + "] start time:" + locala.YH());
      this.status = 1;
      AppMethodBeat.o(148501);
      return true;
    }
    catch (Exception paramString)
    {
      ac.e("VoiceRecorder", "StartRecord File[" + this.fileName + "] ErrMsg[" + paramString.getMessage() + "]");
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
      int i = this.cXl.getMaxAmplitude();
      if (i > cXn) {
        cXn = i;
      }
      i = i * 100 / cXn;
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