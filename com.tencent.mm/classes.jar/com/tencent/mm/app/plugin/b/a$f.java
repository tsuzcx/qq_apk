package com.tencent.mm.app.plugin.b;

import com.tencent.mm.h.a.fl;
import com.tencent.mm.modelvoice.k;
import com.tencent.mm.sdk.platformtools.am;

public final class a$f
  extends com.tencent.mm.sdk.b.c<fl>
{
  k byP;
  am byQ;
  boolean byR;
  boolean byS;
  boolean byT;
  fl byU;
  Runnable byV;
  String fileName = "";
  
  public a$f()
  {
    this.udX = fl.class.getName().hashCode();
  }
  
  final void stopRecord()
  {
    if (this.byP != null)
    {
      this.byS = this.byP.uh();
      if (this.byV != null)
      {
        if (this.byU != null)
        {
          this.byU.bMk.bMl = this.byP.bCc.bCU;
          this.byU = null;
        }
        if (this.byT) {
          this.byV.run();
        }
        this.byV = null;
      }
      this.byR = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.app.plugin.b.a.f
 * JD-Core Version:    0.7.0.1
 */