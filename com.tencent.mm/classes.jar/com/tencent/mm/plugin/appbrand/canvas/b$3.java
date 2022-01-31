package com.tencent.mm.plugin.appbrand.canvas;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.widget.DrawCanvasArg;
import com.tencent.mm.plugin.appbrand.canvas.widget.a.a;
import org.json.JSONArray;

final class b$3
  implements Runnable
{
  b$3(b paramb, JSONArray paramJSONArray, a.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(103142);
    DrawCanvasArg localDrawCanvasArg = this.hev.hef;
    this.hev.hef = null;
    this.hev.hee = this.hew;
    this.hev.het = true;
    this.hev.hed = true;
    if (this.hex != null) {
      this.hex.a(localDrawCanvasArg);
    }
    b.a(this.hev);
    AppMethodBeat.o(103142);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.b.3
 * JD-Core Version:    0.7.0.1
 */