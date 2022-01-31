package com.tencent.mm.plugin.appbrand.canvas;

import java.lang.ref.WeakReference;

final class b$a
  implements a
{
  private WeakReference<com.tencent.mm.plugin.appbrand.canvas.widget.a> fLn;
  
  b$a(com.tencent.mm.plugin.appbrand.canvas.widget.a parama)
  {
    this.fLn = new WeakReference(parama);
  }
  
  public final void invalidate()
  {
    com.tencent.mm.plugin.appbrand.canvas.widget.a locala = (com.tencent.mm.plugin.appbrand.canvas.widget.a)this.fLn.get();
    if (locala == null) {
      return;
    }
    locala.adB();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.b.a
 * JD-Core Version:    0.7.0.1
 */