package com.tencent.mm.ak;

import com.tencent.mm.h.a.lf;
import com.tencent.mm.j.g;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.sdk.b.a;
import java.util.Map;

final class e$7
  implements Runnable
{
  e$7(e parame, String paramString, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    g localg = (g)this.ejo.eiI.get(this.BF);
    if (localg != null)
    {
      lf locallf = new lf();
      locallf.bUh.bNb = 3;
      locallf.bUh.retCode = 0;
      locallf.bUh.bUi = this.BF;
      locallf.bUh.offset = this.ejr;
      locallf.bUh.length = this.ejs;
      a.udP.m(locallf);
      if ((this.ejr == 0) && (this.ejs >= localg.dmf)) {
        e.a(u.oe(localg.filename), localg.dmf, localg.dme);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ak.e.7
 * JD-Core Version:    0.7.0.1
 */