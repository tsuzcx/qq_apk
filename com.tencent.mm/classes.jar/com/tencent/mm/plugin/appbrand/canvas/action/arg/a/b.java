package com.tencent.mm.plugin.appbrand.canvas.action.arg.a;

import com.tencent.mm.plugin.appbrand.canvas.a.a;
import com.tencent.mm.sdk.platformtools.bg;

public abstract class b
{
  private bg<a> hfr = new bg(100);
  
  public void a(a parama)
  {
    if (parama == null) {
      return;
    }
    this.hfr.release(parama);
  }
  
  public final a axY()
  {
    a locala2 = (a)this.hfr.acquire();
    a locala1 = locala2;
    if (locala2 == null) {
      locala1 = axZ();
    }
    return locala1;
  }
  
  public abstract a axZ();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.a.b
 * JD-Core Version:    0.7.0.1
 */