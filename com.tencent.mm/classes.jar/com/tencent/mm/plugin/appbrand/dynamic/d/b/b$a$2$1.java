package com.tencent.mm.plugin.appbrand.dynamic.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.widget.DrawCanvasArg;
import com.tencent.mm.sdk.platformtools.ab;

final class b$a$2$1
  implements Runnable
{
  b$a$2$1(b.a.2 param2, DrawCanvasArg paramDrawCanvasArg) {}
  
  public final void run()
  {
    AppMethodBeat.i(10886);
    ab.v("DrawCanvasRunnable", "running release");
    if (this.hpD != null) {
      this.hpD.reset();
    }
    AppMethodBeat.o(10886);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.b.b.a.2.1
 * JD-Core Version:    0.7.0.1
 */