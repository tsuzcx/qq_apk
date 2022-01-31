package com.tencent.mm.f.b;

import com.tencent.mm.compatible.b.b.a;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

public final class j
{
  public static int bEl = 100;
  private com.tencent.mm.compatible.util.b bBs = new com.tencent.mm.compatible.util.b(ae.getContext());
  public b bEj = new b(b.a.dub);
  public j.a bEk = null;
  String fileName = "";
  public int status = 0;
  
  public final boolean cF(String paramString)
  {
    g.a locala = new g.a();
    if (this.fileName.length() > 0)
    {
      y.e("MicroMsg.SimpleVoiceRecorder", "Duplicate Call startRecord , maybe Stop Fail Before");
      return false;
    }
    this.fileName = paramString;
    try
    {
      this.bBs.requestFocus();
      this.bEj.a(new j.1(this));
      this.bEj.uk();
      this.bEj.ul();
      this.bEj.uj();
      this.bEj.setOutputFile(this.fileName);
      this.bEj.setMaxDuration(3600010);
      this.bEj.prepare();
      this.bEj.start();
      y.d("MicroMsg.SimpleVoiceRecorder", "StartRecord File[" + this.fileName + "] start time:" + locala.zJ());
      this.status = 1;
      return true;
    }
    catch (Exception paramString)
    {
      this.bBs.zE();
      y.e("MicroMsg.SimpleVoiceRecorder", "StartRecord File[" + this.fileName + "] ErrMsg[" + paramString.getMessage() + "]");
      this.status = -1;
    }
    return false;
  }
  
  public final boolean uh()
  {
    this.bBs.zE();
    if (this.bEj == null) {
      return true;
    }
    try
    {
      this.bEj.un();
      this.bEj.release();
      this.fileName = "";
      this.status = 0;
      return true;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.SimpleVoiceRecorder", "StopRecord File[" + this.fileName + "] ErrMsg[" + localException.getMessage() + "]");
      this.status = -1;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.b.j
 * JD-Core Version:    0.7.0.1
 */