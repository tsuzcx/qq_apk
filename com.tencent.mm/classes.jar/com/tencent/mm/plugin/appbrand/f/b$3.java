package com.tencent.mm.plugin.appbrand.f;

import com.tencent.luggage.xweb_ext.extendplugin.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;

final class b$3
  implements f.c
{
  b$3(b paramb, a.a parama) {}
  
  public final void onDestroy()
  {
    AppMethodBeat.i(140013);
    if (this.hrE != null) {
      this.hrE.onDestroy();
    }
    AppMethodBeat.o(140013);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.f.b.3
 * JD-Core Version:    0.7.0.1
 */