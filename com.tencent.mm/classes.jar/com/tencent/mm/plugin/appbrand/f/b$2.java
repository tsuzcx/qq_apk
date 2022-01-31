package com.tencent.mm.plugin.appbrand.f;

import com.tencent.luggage.xweb_ext.extendplugin.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.e.d;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;

final class b$2
  implements f.b
{
  b$2(b paramb, a.a parama) {}
  
  public final void onBackground()
  {
    AppMethodBeat.i(140012);
    e.d locald = e.xX(this.hrF.hrA.getAppId());
    int i = 6;
    if (locald == e.d.gPk) {
      i = 2;
    }
    for (;;)
    {
      if (this.hrE != null) {
        this.hrE.fx(i);
      }
      AppMethodBeat.o(140012);
      return;
      if (locald == e.d.gPg) {
        i = 1;
      } else if (locald == e.d.gPf) {
        i = 3;
      } else if (locald == e.d.gPe) {
        i = 4;
      } else if (locald == e.d.gPl) {
        i = 5;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.f.b.2
 * JD-Core Version:    0.7.0.1
 */