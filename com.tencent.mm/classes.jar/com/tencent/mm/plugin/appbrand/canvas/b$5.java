package com.tencent.mm.plugin.appbrand.canvas;

import com.tencent.mm.plugin.appbrand.canvas.widget.DrawCanvasArg;
import com.tencent.mm.plugin.appbrand.canvas.widget.a.a;

final class b$5
  implements Runnable
{
  b$5(b paramb, DrawCanvasArg paramDrawCanvasArg, a.a parama) {}
  
  public final void run()
  {
    DrawCanvasArg localDrawCanvasArg = this.fLj.fKR;
    this.fLj.fKR = this.fLm;
    this.fLj.fKP = true;
    this.fLj.fLh = false;
    if (this.fLl != null) {
      this.fLl.a(localDrawCanvasArg);
    }
    b.a(this.fLj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.b.5
 * JD-Core Version:    0.7.0.1
 */