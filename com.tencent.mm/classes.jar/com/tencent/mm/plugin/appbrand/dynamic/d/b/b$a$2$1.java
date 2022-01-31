package com.tencent.mm.plugin.appbrand.dynamic.d.b;

import com.tencent.mm.plugin.appbrand.canvas.widget.DrawCanvasArg;
import com.tencent.mm.sdk.platformtools.y;

final class b$a$2$1
  implements Runnable
{
  b$a$2$1(b.a.2 param2, DrawCanvasArg paramDrawCanvasArg) {}
  
  public final void run()
  {
    y.v("DrawCanvasRunnable", "running release");
    if (this.fWa != null) {
      this.fWa.reset();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.b.b.a.2.1
 * JD-Core Version:    0.7.0.1
 */