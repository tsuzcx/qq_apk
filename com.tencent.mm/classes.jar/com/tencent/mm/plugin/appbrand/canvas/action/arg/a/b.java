package com.tencent.mm.plugin.appbrand.canvas.action.arg.a;

import com.tencent.mm.plugin.appbrand.canvas.a.a;
import com.tencent.mm.sdk.platformtools.SimpleObjectPool;

public abstract class b
{
  private SimpleObjectPool<a> qTS = new SimpleObjectPool(100);
  
  public void a(a parama)
  {
    if (parama == null) {
      return;
    }
    this.qTS.release(parama);
  }
  
  public final a cka()
  {
    a locala2 = (a)this.qTS.acquire();
    a locala1 = locala2;
    if (locala2 == null) {
      locala1 = ckb();
    }
    return locala1;
  }
  
  public abstract a ckb();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.a.b
 * JD-Core Version:    0.7.0.1
 */