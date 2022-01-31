package com.tencent.mm.plugin.appbrand.jsapi.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b;
import com.tencent.mm.sdk.platformtools.ab;

final class o$1
  implements f.b
{
  o$1(o paramo, b paramb) {}
  
  public final void onBackground()
  {
    AppMethodBeat.i(93852);
    ab.i("MicroMsg.JsApiInsertMap", "onBackground");
    if (this.hNX != null) {
      this.hNX.onPause();
    }
    AppMethodBeat.o(93852);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.o.1
 * JD-Core Version:    0.7.0.1
 */