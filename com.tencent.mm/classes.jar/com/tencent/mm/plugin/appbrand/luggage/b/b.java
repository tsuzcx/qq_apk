package com.tencent.mm.plugin.appbrand.luggage.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.app.m;
import com.tencent.mm.plugin.appbrand.appstorage.d;
import com.tencent.mm.plugin.appbrand.appstorage.g.a;
import com.tencent.mm.plugin.appbrand.config.e;

@Deprecated
public final class b
  implements com.tencent.luggage.sdk.customize.a
{
  public final d QF()
  {
    AppMethodBeat.i(47479);
    d locald = m.QF();
    AppMethodBeat.o(47479);
    return locald;
  }
  
  public final e QG()
  {
    AppMethodBeat.i(47481);
    e locale = m.QG();
    AppMethodBeat.o(47481);
    return locale;
  }
  
  public final void QH()
  {
    AppMethodBeat.i(47482);
    com.tencent.mm.plugin.appbrand.config.g.bLf();
    AppMethodBeat.o(47482);
  }
  
  public final com.tencent.mm.plugin.appbrand.appstorage.g dX(String paramString)
  {
    AppMethodBeat.i(47480);
    g.a locala = com.tencent.mm.plugin.appbrand.appstorage.g.nMp;
    paramString = g.a.Hk(new p(((com.tencent.mm.plugin.appbrand.appstorage.a.a)h.ae(com.tencent.mm.plugin.appbrand.appstorage.a.a.class)).aee(paramString)).longValue());
    AppMethodBeat.o(47480);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.b.b
 * JD-Core Version:    0.7.0.1
 */