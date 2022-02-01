package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.k.a;
import com.tencent.mm.audio.b.a;
import com.tencent.mm.audio.b.b;
import com.tencent.mm.audio.b.b.a;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.compatible.b.c.a;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class v
  implements a
{
  private static int cZR = 100;
  private b cZP;
  String fileName;
  private k.a hDD;
  private int status;
  
  public v(c.a parama)
  {
    AppMethodBeat.i(148500);
    this.fileName = "";
    this.hDD = null;
    this.status = 0;
    this.cZP = new b(parama);
    AppMethodBeat.o(148500);
  }
  
  public final boolean Ob()
  {
    AppMethodBeat.i(148502);
    if (this.cZP == null)
    {
      AppMethodBeat.o(148502);
      return true;
    }
    try
    {
      this.cZP.Ft();
      this.cZP.release();
      this.fileName = "";
      this.status = 0;
      AppMethodBeat.o(148502);
      return true;
    }
    catch (Exception localException)
    {
      ad.e("VoiceRecorder", "StopRecord File[" + this.fileName + "] ErrMsg[" + localException.getMessage() + "]");
      this.status = -1;
      AppMethodBeat.o(148502);
    }
    return false;
  }
  
  public final int Oc()
  {
    b localb = this.cZP;
    if (((localb.cXJ == c.a.fyF) || (localb.cXJ == c.a.fyH)) && (localb.cXI != null)) {
      return localb.cXI.cYA;
    }
    return 1;
  }
  
  public final void a(k.a parama)
  {
    this.hDD = parama;
  }
  
  public final boolean fO(String paramString)
  {
    AppMethodBeat.i(148501);
    if (bt.isNullOrNil(paramString)) {}
    f.a locala;
    for (int i = 0;; i = paramString.length())
    {
      ad.i("VoiceRecorder", "[startRecord] fileName:%s size:%s", new Object[] { paramString, Integer.valueOf(i) });
      locala = new f.a();
      if ((bt.isNullOrNil(this.fileName)) || (this.fileName.length() <= 0)) {
        break;
      }
      ad.e("VoiceRecorder", "Duplicate Call startRecord , maybe Stop Fail Before");
      AppMethodBeat.o(148501);
      return false;
    }
    this.fileName = paramString;
    try
    {
      this.cZP.a(new b.a()
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
            ad.e("VoiceRecorder", "setErrorListener File[" + v.this.fileName + "] ErrMsg[" + localException.getStackTrace() + "]");
            AppMethodBeat.o(148499);
          }
        }
      });
      this.cZP.Oe();
      this.cZP.Of();
      this.cZP.Od();
      this.cZP.setOutputFile(this.fileName);
      this.cZP.setMaxDuration(70000);
      this.cZP.prepare();
      this.cZP.start();
      ad.d("VoiceRecorder", "StartRecord File[" + this.fileName + "] start time:" + locala.XK());
      this.status = 1;
      AppMethodBeat.o(148501);
      return true;
    }
    catch (Exception paramString)
    {
      ad.e("VoiceRecorder", "StartRecord File[" + this.fileName + "] ErrMsg[" + paramString.getMessage() + "]");
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
      int i = this.cZP.getMaxAmplitude();
      if (i > cZR) {
        cZR = i;
      }
      i = i * 100 / cZR;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelvoice.v
 * JD-Core Version:    0.7.0.1
 */