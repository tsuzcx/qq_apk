package com.tencent.mm.plugin.appbrand.canvas.action.arg.a;

import com.tencent.mm.plugin.appbrand.canvas.a.a;
import com.tencent.mm.sdk.platformtools.bm;

public abstract class b
{
  private bm<a> jXb = new bm(100);
  
  public void a(a parama)
  {
    if (parama == null) {
      return;
    }
    this.jXb.release(parama);
  }
  
  public final a bdU()
  {
    a locala2 = (a)this.jXb.acquire();
    a locala1 = locala2;
    if (locala2 == null) {
      locala1 = bdV();
    }
    return locala1;
  }
  
  public abstract a bdV();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.a.b
 * JD-Core Version:    0.7.0.1
 */