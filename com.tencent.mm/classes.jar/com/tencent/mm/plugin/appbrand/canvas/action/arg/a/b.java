package com.tencent.mm.plugin.appbrand.canvas.action.arg.a;

import com.tencent.mm.plugin.appbrand.canvas.a.a;
import com.tencent.mm.sdk.platformtools.bl;

public abstract class b
{
  private bl<a> jTK = new bl(100);
  
  public void a(a parama)
  {
    if (parama == null) {
      return;
    }
    this.jTK.release(parama);
  }
  
  public final a bdp()
  {
    a locala2 = (a)this.jTK.acquire();
    a locala1 = locala2;
    if (locala2 == null) {
      locala1 = bdq();
    }
    return locala1;
  }
  
  public abstract a bdq();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.a.b
 * JD-Core Version:    0.7.0.1
 */