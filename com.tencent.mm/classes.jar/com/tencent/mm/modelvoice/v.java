package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.j.a;
import com.tencent.mm.audio.b.a;
import com.tencent.mm.audio.b.b;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.compatible.b.c.a;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class v
  implements a
{
  private static int ckX = 100;
  private b ckV;
  String fileName;
  private j.a gaR;
  private int status;
  
  public v(c.a parama)
  {
    AppMethodBeat.i(116659);
    this.fileName = "";
    this.gaR = null;
    this.status = 0;
    this.ckV = new b(parama);
    AppMethodBeat.o(116659);
  }
  
  public final boolean Et()
  {
    AppMethodBeat.i(116661);
    if (this.ckV == null)
    {
      AppMethodBeat.o(116661);
      return true;
    }
    try
    {
      this.ckV.Ez();
      this.ckV.release();
      this.fileName = "";
      this.status = 0;
      AppMethodBeat.o(116661);
      return true;
    }
    catch (Exception localException)
    {
      ab.e("VoiceRecorder", "StopRecord File[" + this.fileName + "] ErrMsg[" + localException.getMessage() + "]");
      this.status = -1;
      AppMethodBeat.o(116661);
    }
    return false;
  }
  
  public final int Eu()
  {
    b localb = this.ckV;
    if (((localb.ciS == c.a.elO) || (localb.ciS == c.a.elQ)) && (localb.ciR != null)) {
      return localb.ciR.cjI;
    }
    return 1;
  }
  
  public final void a(j.a parama)
  {
    this.gaR = parama;
  }
  
  public final boolean eH(String paramString)
  {
    AppMethodBeat.i(116660);
    if (bo.isNullOrNil(paramString)) {}
    g.a locala;
    for (int i = 0;; i = paramString.length())
    {
      ab.i("VoiceRecorder", "[startRecord] fileName:%s size:%s", new Object[] { paramString, Integer.valueOf(i) });
      locala = new g.a();
      if ((bo.isNullOrNil(this.fileName)) || (this.fileName.length() <= 0)) {
        break;
      }
      ab.e("VoiceRecorder", "Duplicate Call startRecord , maybe Stop Fail Before");
      AppMethodBeat.o(116660);
      return false;
    }
    this.fileName = paramString;
    try
    {
      this.ckV.a(new v.1(this));
      this.ckV.Ew();
      this.ckV.Ex();
      this.ckV.Ev();
      this.ckV.setOutputFile(this.fileName);
      this.ckV.setMaxDuration(70000);
      this.ckV.prepare();
      this.ckV.start();
      ab.d("VoiceRecorder", "StartRecord File[" + this.fileName + "] start time:" + locala.Mm());
      this.status = 1;
      AppMethodBeat.o(116660);
      return true;
    }
    catch (Exception paramString)
    {
      ab.e("VoiceRecorder", "StartRecord File[" + this.fileName + "] ErrMsg[" + paramString.getMessage() + "]");
      this.status = -1;
      AppMethodBeat.o(116660);
    }
    return false;
  }
  
  public final int getMaxAmplitude()
  {
    AppMethodBeat.i(116662);
    if (this.status == 1)
    {
      int i = this.ckV.getMaxAmplitude();
      if (i > ckX) {
        ckX = i;
      }
      i = i * 100 / ckX;
      AppMethodBeat.o(116662);
      return i;
    }
    AppMethodBeat.o(116662);
    return 0;
  }
  
  public final int getStatus()
  {
    return this.status;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.modelvoice.v
 * JD-Core Version:    0.7.0.1
 */