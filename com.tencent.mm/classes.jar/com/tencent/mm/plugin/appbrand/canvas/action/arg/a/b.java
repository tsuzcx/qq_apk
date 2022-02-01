package com.tencent.mm.plugin.appbrand.canvas.action.arg.a;

import com.tencent.mm.plugin.appbrand.canvas.a.a;
import com.tencent.mm.sdk.platformtools.bl;

public abstract class b
{
  private bl<a> iZC = new bl(100);
  
  public void a(a parama)
  {
    if (parama == null) {
      return;
    }
    this.iZC.release(parama);
  }
  
  public final a aSR()
  {
    a locala2 = (a)this.iZC.acquire();
    a locala1 = locala2;
    if (locala2 == null) {
      locala1 = aSS();
    }
    return locala1;
  }
  
  public abstract a aSS();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.a.b
 * JD-Core Version:    0.7.0.1
 */