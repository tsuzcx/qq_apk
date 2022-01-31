package com.tencent.mm.plugin.appbrand.canvas;

import com.tencent.mm.plugin.appbrand.canvas.widget.a;
import com.tencent.mm.sdk.platformtools.y;

final class b$2
  implements Runnable
{
  b$2(b paramb) {}
  
  public final void run()
  {
    boolean bool = this.fLj.fKW;
    this.fLj.fKW = false;
    y.i("MicroMsg.DrawActionDelegateImpl", "preStae %b, hasChanged %b", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(this.fLj.fKP) });
    if ((bool) && (this.fLj.fKP)) {
      this.fLj.fKU.adB();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.b.2
 * JD-Core Version:    0.7.0.1
 */