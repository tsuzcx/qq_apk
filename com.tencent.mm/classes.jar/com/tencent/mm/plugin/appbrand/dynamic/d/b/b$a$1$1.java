package com.tencent.mm.plugin.appbrand.dynamic.d.b;

import com.tencent.mm.plugin.appbrand.canvas.widget.DrawCanvasArg;
import com.tencent.mm.sdk.platformtools.y;

final class b$a$1$1
  implements Runnable
{
  b$a$1$1(b.a.1 param1, DrawCanvasArg paramDrawCanvasArg) {}
  
  public final void run()
  {
    y.v("DrawCanvasRunnable", "running release");
    if (this.fWa != null) {
      this.fWa.reset();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.b.b.a.1.1
 * JD-Core Version:    0.7.0.1
 */