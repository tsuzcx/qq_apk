package com.tencent.mm.plugin.appbrand.canvas;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.widget.a.a;
import org.json.JSONArray;

final class b$4
  implements Runnable
{
  b$4(b paramb, JSONArray paramJSONArray, a.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(103143);
    this.hev.het = true;
    if (this.hev.hee == null) {
      this.hev.hee = this.hew;
    }
    for (;;)
    {
      this.hev.hed = true;
      if (this.hex != null) {
        this.hex.a(null);
      }
      AppMethodBeat.o(103143);
      return;
      int i = 0;
      while (i < this.hew.length())
      {
        this.hev.hee.put(this.hew.opt(i));
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.b.4
 * JD-Core Version:    0.7.0.1
 */