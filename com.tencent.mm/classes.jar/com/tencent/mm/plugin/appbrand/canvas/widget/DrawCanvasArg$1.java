package com.tencent.mm.plugin.appbrand.canvas.widget;

import com.tencent.mm.sdk.platformtools.y;

public final class DrawCanvasArg$1
  implements Runnable
{
  public DrawCanvasArg$1(DrawCanvasArg paramDrawCanvasArg) {}
  
  public final void run()
  {
    DrawCanvasArg.a(this.fMP, DrawCanvasArg.b(this.fMP));
    DrawCanvasArg.c(this.fMP);
    DrawCanvasArg.d(this.fMP);
    if (DrawCanvasArg.e(this.fMP)) {
      DrawCanvasArg.f(this.fMP);
    }
    y.i("DrawCanvasArg", "async parse success");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.widget.DrawCanvasArg.1
 * JD-Core Version:    0.7.0.1
 */