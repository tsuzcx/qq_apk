package com.tencent.mm.plugin.appbrand.canvas.action.arg.a;

import com.tencent.mm.plugin.appbrand.canvas.a.a;
import com.tencent.mm.sdk.platformtools.bc;

public abstract class b
{
  private bc<a> fMh = new bc(100);
  
  public void a(a parama)
  {
    if (parama == null) {
      return;
    }
    this.fMh.D(parama);
  }
  
  public final a adG()
  {
    a locala2 = (a)this.fMh.de();
    a locala1 = locala2;
    if (locala2 == null) {
      locala1 = adH();
    }
    return locala1;
  }
  
  public abstract a adH();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.a.b
 * JD-Core Version:    0.7.0.1
 */