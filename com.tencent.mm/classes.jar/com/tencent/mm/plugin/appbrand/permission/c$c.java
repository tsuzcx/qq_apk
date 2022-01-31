package com.tencent.mm.plugin.appbrand.permission;

import com.tencent.mm.plugin.appbrand.v.c;
import com.tencent.mm.sdk.platformtools.ai;

final class c$c
  implements c.b
{
  private final c.b gWR;
  
  private c$c(c.b paramb)
  {
    this.gWR = paramb;
  }
  
  private void anN()
  {
    c.DS().O(new c.c.1(this));
  }
  
  public final void anL()
  {
    if (this.gWR != null) {
      this.gWR.anL();
    }
    anN();
  }
  
  public final void anM()
  {
    if (this.gWR != null) {
      this.gWR.anM();
    }
    anN();
  }
  
  public final void onCancel()
  {
    if (this.gWR != null) {
      this.gWR.onCancel();
    }
    anN();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.c.c
 * JD-Core Version:    0.7.0.1
 */