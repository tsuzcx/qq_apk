package com.tencent.mm.audio.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.c.a;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class j
{
  public static int ckX = 100;
  private com.tencent.mm.compatible.util.b cih;
  public b ckV;
  public j.a ckW;
  String fileName;
  public int status;
  
  public j()
  {
    AppMethodBeat.i(116530);
    this.fileName = "";
    this.ckW = null;
    this.status = 0;
    this.ckV = new b(c.a.elP);
    this.cih = new com.tencent.mm.compatible.util.b(ah.getContext());
    AppMethodBeat.o(116530);
  }
  
  public final boolean Et()
  {
    AppMethodBeat.i(116532);
    this.cih.Mh();
    if (this.ckV == null)
    {
      AppMethodBeat.o(116532);
      return true;
    }
    try
    {
      this.ckV.Ez();
      this.ckV.release();
      this.fileName = "";
      this.status = 0;
      AppMethodBeat.o(116532);
      return true;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.SimpleVoiceRecorder", "StopRecord File[" + this.fileName + "] ErrMsg[" + localException.getMessage() + "]");
      this.status = -1;
      AppMethodBeat.o(116532);
    }
    return false;
  }
  
  public final boolean eJ(String paramString)
  {
    AppMethodBeat.i(116531);
    g.a locala = new g.a();
    if (this.fileName.length() > 0)
    {
      ab.e("MicroMsg.SimpleVoiceRecorder", "Duplicate Call startRecord , maybe Stop Fail Before");
      AppMethodBeat.o(116531);
      return false;
    }
    this.fileName = paramString;
    try
    {
      this.cih.requestFocus();
      this.ckV.a(new j.1(this));
      this.ckV.Ew();
      this.ckV.Ex();
      this.ckV.Ev();
      this.ckV.setOutputFile(this.fileName);
      this.ckV.setMaxDuration(3600010);
      this.ckV.prepare();
      this.ckV.start();
      ab.d("MicroMsg.SimpleVoiceRecorder", "StartRecord File[" + this.fileName + "] start time:" + locala.Mm());
      this.status = 1;
      AppMethodBeat.o(116531);
      return true;
    }
    catch (Exception paramString)
    {
      this.cih.Mh();
      ab.e("MicroMsg.SimpleVoiceRecorder", "StartRecord File[" + this.fileName + "] ErrMsg[" + paramString.getMessage() + "]");
      this.status = -1;
      AppMethodBeat.o(116531);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.b.j
 * JD-Core Version:    0.7.0.1
 */