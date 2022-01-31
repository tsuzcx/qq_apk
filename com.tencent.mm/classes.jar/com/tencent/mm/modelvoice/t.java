package com.tencent.mm.modelvoice;

import com.tencent.mm.ah.j.a;
import com.tencent.mm.compatible.b.b.a;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.f.b.a;
import com.tencent.mm.f.b.b;
import com.tencent.mm.f.b.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class t
  implements a
{
  private static int bEl = 100;
  private b bEj;
  private j.a eLk = null;
  String fileName = "";
  private int status = 0;
  
  public t(b.a parama)
  {
    this.bEj = new b(parama);
  }
  
  public final void a(j.a parama)
  {
    this.eLk = parama;
  }
  
  public final boolean cD(String paramString)
  {
    if (bk.bl(paramString)) {}
    g.a locala;
    for (int i = 0;; i = paramString.length())
    {
      y.i("VoiceRecorder", "[startRecord] fileName:%s size:%s", new Object[] { paramString, Integer.valueOf(i) });
      locala = new g.a();
      if (this.fileName.length() <= 0) {
        break;
      }
      y.e("VoiceRecorder", "Duplicate Call startRecord , maybe Stop Fail Before");
      return false;
    }
    this.fileName = paramString;
    try
    {
      this.bEj.a(new t.1(this));
      this.bEj.uk();
      this.bEj.ul();
      this.bEj.uj();
      this.bEj.setOutputFile(this.fileName);
      this.bEj.setMaxDuration(70000);
      this.bEj.prepare();
      this.bEj.start();
      y.d("VoiceRecorder", "StartRecord File[" + this.fileName + "] start time:" + locala.zJ());
      this.status = 1;
      return true;
    }
    catch (Exception paramString)
    {
      y.e("VoiceRecorder", "StartRecord File[" + this.fileName + "] ErrMsg[" + paramString.getMessage() + "]");
      this.status = -1;
    }
    return false;
  }
  
  public final int getMaxAmplitude()
  {
    if (this.status == 1)
    {
      int i = this.bEj.getMaxAmplitude();
      if (i > bEl) {
        bEl = i;
      }
      return i * 100 / bEl;
    }
    return 0;
  }
  
  public final int getStatus()
  {
    return this.status;
  }
  
  public final boolean uh()
  {
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
      y.e("VoiceRecorder", "StopRecord File[" + this.fileName + "] ErrMsg[" + localException.getMessage() + "]");
      this.status = -1;
    }
    return false;
  }
  
  public final int ui()
  {
    b localb = this.bEj;
    if (((localb.bCd == b.a.dua) || (localb.bCd == b.a.duc)) && (localb.bCc != null)) {
      return localb.bCc.bCU;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelvoice.t
 * JD-Core Version:    0.7.0.1
 */