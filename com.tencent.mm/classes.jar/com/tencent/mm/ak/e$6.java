package com.tencent.mm.ak;

import com.tencent.mm.h.a.lf;
import com.tencent.mm.j.g;
import com.tencent.mm.j.g.a;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import java.util.Map;

final class e$6
  implements Runnable
{
  e$6(e parame, String paramString, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    Object localObject = (g)this.ejo.eiI.get(this.BF);
    if (localObject != null)
    {
      if (((g)localObject).dmn != null) {
        ((g)localObject).dmn.onDataAvailable(this.BF, this.ejr, this.ejs);
      }
      localObject = new lf();
      ((lf)localObject).bUh.bNb = 2;
      ((lf)localObject).bUh.retCode = 0;
      ((lf)localObject).bUh.bUi = this.BF;
      ((lf)localObject).bUh.offset = this.ejr;
      ((lf)localObject).bUh.length = this.ejs;
      a.udP.m((b)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ak.e.6
 * JD-Core Version:    0.7.0.1
 */