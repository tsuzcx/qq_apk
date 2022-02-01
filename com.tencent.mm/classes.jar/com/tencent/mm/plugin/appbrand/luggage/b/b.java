package com.tencent.mm.plugin.appbrand.luggage.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appstorage.d;
import com.tencent.mm.plugin.appbrand.appstorage.h;
import com.tencent.mm.plugin.appbrand.appstorage.h.a;
import com.tencent.mm.plugin.appbrand.config.e;

@Deprecated
public final class b
  implements com.tencent.luggage.sdk.customize.a
{
  public final d NK()
  {
    AppMethodBeat.i(47479);
    d locald = n.NK();
    AppMethodBeat.o(47479);
    return locald;
  }
  
  public final e NL()
  {
    AppMethodBeat.i(47481);
    e locale = n.NL();
    AppMethodBeat.o(47481);
    return locale;
  }
  
  public final void NM()
  {
    AppMethodBeat.i(47482);
    com.tencent.mm.plugin.appbrand.config.g.bzQ();
    AppMethodBeat.o(47482);
  }
  
  public final h dD(String paramString)
  {
    AppMethodBeat.i(47480);
    h.a locala = h.kSl;
    paramString = h.a.AY(new p(((com.tencent.mm.plugin.appbrand.appstorage.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.appstorage.a.a.class)).Wp(paramString)).longValue());
    AppMethodBeat.o(47480);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.b.b
 * JD-Core Version:    0.7.0.1
 */