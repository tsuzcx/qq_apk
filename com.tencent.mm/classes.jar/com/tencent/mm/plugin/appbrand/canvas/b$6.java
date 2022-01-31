package com.tencent.mm.plugin.appbrand.canvas;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.widget.DrawCanvasArg;
import com.tencent.mm.plugin.appbrand.canvas.widget.a.a;
import java.util.List;

final class b$6
  implements Runnable
{
  b$6(b paramb, DrawCanvasArg paramDrawCanvasArg, a.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(103145);
    if (this.hev.hef == null)
    {
      AppMethodBeat.o(103145);
      return;
    }
    this.hev.hef.hfq.addAll(this.hey.hfq);
    this.hev.hed = true;
    this.hev.het = false;
    if (this.hex != null) {
      this.hex.a(null);
    }
    AppMethodBeat.o(103145);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.b.6
 * JD-Core Version:    0.7.0.1
 */