package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.m.a;
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
  private static int dAR = 100;
  private b dAP;
  String fileName;
  private m.a jvI;
  private int status;
  
  public v(c.a parama)
  {
    AppMethodBeat.i(148500);
    this.fileName = "";
    this.jvI = null;
    this.status = 0;
    this.dAP = new b(parama);
    AppMethodBeat.o(148500);
  }
  
  public final boolean ZZ()
  {
    AppMethodBeat.i(148502);
    if (this.dAP == null)
    {
      AppMethodBeat.o(148502);
      return true;
    }
    try
    {
      this.dAP.Qt();
      this.dAP.release();
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
  
  public final void a(m.a parama)
  {
    this.jvI = parama;
  }
  
  public final int aaa()
  {
    b localb = this.dAP;
    if (((localb.dyJ == c.a.gCM) || (localb.dyJ == c.a.gCO)) && (localb.dyI != null)) {
      return localb.dyI.dzA;
    }
    return 1;
  }
  
  public final int getMaxAmplitude()
  {
    AppMethodBeat.i(148503);
    if (this.status == 1)
    {
      int i = this.dAP.getMaxAmplitude();
      if (i > dAR) {
        dAR = i;
      }
      i = i * 100 / dAR;
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
  
  public final boolean hw(String paramString)
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
      this.dAP.a(new b.a()
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
      this.dAP.aac();
      this.dAP.aad();
      this.dAP.aab();
      this.dAP.setOutputFile(this.fileName);
      this.dAP.setMaxDuration(70000);
      this.dAP.prepare();
      this.dAP.start();
      Log.d("VoiceRecorder", "StartRecord File[" + this.fileName + "] start time:" + locala.apr());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelvoice.v
 * JD-Core Version:    0.7.0.1
 */