package com.tencent.mm.plugin.appbrand.canvas.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class DrawCanvasArg$1
  implements Runnable
{
  public DrawCanvasArg$1(DrawCanvasArg paramDrawCanvasArg) {}
  
  public final void run()
  {
    AppMethodBeat.i(103700);
    DrawCanvasArg.a(this.hfZ, DrawCanvasArg.b(this.hfZ));
    DrawCanvasArg.c(this.hfZ);
    DrawCanvasArg.d(this.hfZ);
    if (DrawCanvasArg.e(this.hfZ)) {
      DrawCanvasArg.f(this.hfZ);
    }
    ab.i("DrawCanvasArg", "async parse success");
    AppMethodBeat.o(103700);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.widget.DrawCanvasArg.1
 * JD-Core Version:    0.7.0.1
 */