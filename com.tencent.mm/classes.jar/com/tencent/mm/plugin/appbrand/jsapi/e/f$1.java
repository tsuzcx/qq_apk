package com.tencent.mm.plugin.appbrand.jsapi.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.b.b;
import com.tencent.mm.plugin.appbrand.b.c.a;

final class f$1
  implements c.a
{
  f$1(f paramf) {}
  
  public final void a(String paramString, b paramb)
  {
    AppMethodBeat.i(74740);
    if (paramb == b.gYh)
    {
      this.hNc.hMZ.quit();
      AppMethodBeat.o(74740);
      return;
    }
    if (paramb == b.gYg)
    {
      this.hNc.hMZ.sendMessage(3);
      AppMethodBeat.o(74740);
      return;
    }
    if (paramb == b.gYe) {
      this.hNc.hMZ.sendMessage(4);
    }
    AppMethodBeat.o(74740);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.e.f.1
 * JD-Core Version:    0.7.0.1
 */