package com.tencent.mm.plugin.appbrand.canvas.action.arg.a;

import com.tencent.mm.plugin.appbrand.canvas.a.a;
import com.tencent.mm.sdk.platformtools.SimpleObjectPool;

public abstract class b
{
  private SimpleObjectPool<a> kZX = new SimpleObjectPool(100);
  
  public void a(a parama)
  {
    if (parama == null) {
      return;
    }
    this.kZX.release(parama);
  }
  
  public final a bzl()
  {
    a locala2 = (a)this.kZX.acquire();
    a locala1 = locala2;
    if (locala2 == null) {
      locala1 = bzm();
    }
    return locala1;
  }
  
  public abstract a bzm();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.a.b
 * JD-Core Version:    0.7.0.1
 */