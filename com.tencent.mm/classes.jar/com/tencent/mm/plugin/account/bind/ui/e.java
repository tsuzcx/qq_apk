package com.tencent.mm.plugin.account.bind.ui;

import com.tencent.mm.h.a.jz;
import com.tencent.mm.h.a.jz.a;
import com.tencent.mm.sdk.b.c;

public final class e
  extends c<jz>
  implements f.a
{
  private jz fet;
  
  public e()
  {
    this.udX = jz.class.getName().hashCode();
  }
  
  public final void Wq()
  {
    if ((this.fet != null) && (this.fet.bSE.bSG != null))
    {
      this.fet.bSF.bIe = false;
      this.fet.bSE.bSG.run();
      this.fet = null;
    }
  }
  
  public final boolean bG(int paramInt1, int paramInt2)
  {
    if (this.fet == null) {
      return false;
    }
    if (this.fet.bSE.bSG == null)
    {
      this.fet = null;
      return false;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.fet.bSF.bIe = true;
      this.fet.bSE.bSG.run();
      this.fet = null;
      return true;
    }
    this.fet.bSF.bIe = false;
    this.fet.bSE.bSG.run();
    this.fet = null;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.e
 * JD-Core Version:    0.7.0.1
 */