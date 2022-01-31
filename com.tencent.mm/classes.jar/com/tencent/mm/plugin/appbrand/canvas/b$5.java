package com.tencent.mm.plugin.appbrand.canvas;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.widget.DrawCanvasArg;
import com.tencent.mm.plugin.appbrand.canvas.widget.a.a;

final class b$5
  implements Runnable
{
  b$5(b paramb, DrawCanvasArg paramDrawCanvasArg, a.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(103144);
    DrawCanvasArg localDrawCanvasArg = this.hev.hef;
    this.hev.hef = this.hey;
    this.hev.hed = true;
    this.hev.het = false;
    if (this.hex != null) {
      this.hex.a(localDrawCanvasArg);
    }
    b.a(this.hev);
    AppMethodBeat.o(103144);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.b.5
 * JD-Core Version:    0.7.0.1
 */