package com.tencent.mm.plugin.appbrand.dynamic.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.widget.DrawCanvasArg;
import com.tencent.mm.sdk.platformtools.ab;

final class b$a$1$1
  implements Runnable
{
  b$a$1$1(b.a.1 param1, DrawCanvasArg paramDrawCanvasArg) {}
  
  public final void run()
  {
    AppMethodBeat.i(10884);
    ab.v("DrawCanvasRunnable", "running release");
    if (this.hpD != null) {
      this.hpD.reset();
    }
    AppMethodBeat.o(10884);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.b.b.a.1.1
 * JD-Core Version:    0.7.0.1
 */