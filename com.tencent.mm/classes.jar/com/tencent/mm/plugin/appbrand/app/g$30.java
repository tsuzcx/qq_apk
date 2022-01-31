package com.tencent.mm.plugin.appbrand.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;

final class g$30
  implements k.a
{
  g$30(g paramg) {}
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(129283);
    if ((paramString != null) && (paramString.length() > 0) && ("event_updated".equals(paramString)))
    {
      g.auX();
      g.auY();
      g.auZ();
      g.ava();
      g.avb();
    }
    AppMethodBeat.o(129283);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.g.30
 * JD-Core Version:    0.7.0.1
 */