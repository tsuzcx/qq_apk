package com.tencent.mm.modelvoice;

import com.tencent.mm.ah.j.a;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.f.b.a;
import com.tencent.mm.f.b.c;
import com.tencent.mm.f.b.c.a;
import com.tencent.mm.f.c.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class k
  implements a
{
  private static int eKN = 100;
  private int bBN = 0;
  c.a bCP = new k.1(this);
  public c bCc;
  private d eKO;
  private String mFileName = null;
  public int mStatus = 0;
  
  private void clean()
  {
    if (this.bCc != null)
    {
      this.bCc.uh();
      this.bCc = null;
    }
    if (this.eKO != null)
    {
      this.eKO.uE();
      this.eKO = null;
    }
  }
  
  public final void a(j.a parama) {}
  
  public final boolean cD(String paramString)
  {
    if (!bk.bl(this.mFileName))
    {
      y.e("MicroMsg.SpeexRecorder", "Duplicate Call startRecord , maybe Stop Fail Before");
      return false;
    }
    y.i("MicroMsg.SpeexRecorder", "[startRecord] fileName:%s", new Object[] { paramString });
    this.mStatus = 1;
    this.bBN = 0;
    this.bCc = new c(16000, 1, 0);
    this.bCc.bCE = -19;
    if (q.dyn.dwY > 0) {
      this.bCc.t(q.dyn.dwY, true);
    }
    for (;;)
    {
      this.bCc.aX(false);
      this.bCc.bCP = this.bCP;
      this.eKO = new d();
      if (this.eKO.cG(paramString)) {
        break;
      }
      y.e("MicroMsg.SpeexRecorder", "init speex writer failed");
      clean();
      this.mStatus = -1;
      return false;
      this.bCc.t(5, false);
    }
    if (!this.bCc.uq())
    {
      y.e("MicroMsg.SpeexRecorder", "start record failed");
      clean();
      this.mStatus = -1;
      return false;
    }
    this.mFileName = paramString;
    return true;
  }
  
  public final int getMaxAmplitude()
  {
    int i = this.bBN;
    this.bBN = 0;
    if (i > eKN) {
      eKN = i;
    }
    return i * 100 / eKN;
  }
  
  public final int getStatus()
  {
    return this.mStatus;
  }
  
  public final boolean uh()
  {
    this.mFileName = null;
    this.mStatus = 0;
    clean();
    return true;
  }
  
  public final int ui()
  {
    return this.bCc.bCU;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelvoice.k
 * JD-Core Version:    0.7.0.1
 */