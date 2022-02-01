package com.tencent.mm.plugin.appbrand.canvas.action.arg.a;

import com.tencent.mm.plugin.appbrand.canvas.a.a;
import com.tencent.mm.sdk.platformtools.bk;

public abstract class b
{
  private bk<a> jzP = new bk(100);
  
  public void a(a parama)
  {
    if (parama == null) {
      return;
    }
    this.jzP.release(parama);
  }
  
  public final a aZQ()
  {
    a locala2 = (a)this.jzP.acquire();
    a locala1 = locala2;
    if (locala2 == null) {
      locala1 = aZR();
    }
    return locala1;
  }
  
  public abstract a aZR();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.a.b
 * JD-Core Version:    0.7.0.1
 */