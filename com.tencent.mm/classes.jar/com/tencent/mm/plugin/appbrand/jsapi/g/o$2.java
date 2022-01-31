package com.tencent.mm.plugin.appbrand.jsapi.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f.d;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b;
import com.tencent.mm.sdk.platformtools.ab;

final class o$2
  implements f.d
{
  o$2(o paramo, b paramb) {}
  
  public final void onForeground()
  {
    AppMethodBeat.i(93853);
    ab.i("MicroMsg.JsApiInsertMap", "onForeground");
    if (this.hNX != null) {
      this.hNX.onResume();
    }
    AppMethodBeat.o(93853);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.o.2
 * JD-Core Version:    0.7.0.1
 */