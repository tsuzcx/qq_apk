package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.b.c.a;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.r;

final class b$2
  implements c.a
{
  b$2(b paramb, r paramr) {}
  
  public final void a(String paramString, com.tencent.mm.plugin.appbrand.b.b paramb)
  {
    AppMethodBeat.i(143271);
    if (paramb == com.tencent.mm.plugin.appbrand.b.b.gYh)
    {
      MMToClientEvent.b(this.bAW.getAppId(), b.a(this.hAT));
      b.k(this.bAW);
    }
    AppMethodBeat.o(143271);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.b.2
 * JD-Core Version:    0.7.0.1
 */