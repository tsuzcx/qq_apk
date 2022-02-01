package com.tencent.mm.plugin.appbrand.luggage.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appstorage.h;
import com.tencent.mm.plugin.appbrand.appstorage.h.a;
import com.tencent.mm.pluginsdk.j.a.a.i;
import com.tencent.mm.pluginsdk.j.a.c.q;
import com.tencent.mm.pluginsdk.j.a.c.q.a;
import com.tencent.mm.pluginsdk.j.a.c.s;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;

@Deprecated
public final class b
  implements com.tencent.luggage.sdk.customize.a
{
  public final com.tencent.mm.plugin.appbrand.appstorage.d Ei()
  {
    AppMethodBeat.i(47479);
    com.tencent.mm.plugin.appbrand.appstorage.d locald = j.Ei();
    AppMethodBeat.o(47479);
    return locald;
  }
  
  public final com.tencent.mm.plugin.appbrand.config.d Ej()
  {
    AppMethodBeat.i(47481);
    com.tencent.mm.plugin.appbrand.config.d locald = j.Ej();
    AppMethodBeat.o(47481);
    return locald;
  }
  
  public final void Ek()
  {
    AppMethodBeat.i(47482);
    if (aj.cmR())
    {
      com.tencent.mm.pluginsdk.j.a.a.b localb = com.tencent.mm.pluginsdk.j.a.a.b.faE();
      com.tencent.mm.pluginsdk.j.a.a.b.faE();
      s locals = q.a.fbc().aMi(i.jn(38, 1));
      if (locals == null) {}
      for (int i = 0;; i = bt.getInt(locals.field_fileVersion, 0))
      {
        localb.f(38, 1, i, false);
        AppMethodBeat.o(47482);
        return;
      }
    }
    ad.i("MicroMsg.AppBrand.AppBrandGlobalSystemCon", "onConfigFileDeleted: not in main proc, ignore");
    AppMethodBeat.o(47482);
  }
  
  public final h dg(String paramString)
  {
    AppMethodBeat.i(47480);
    h.a locala = h.jMr;
    paramString = h.a.sF(new p(((com.tencent.mm.plugin.appbrand.appstorage.a.a)g.ab(com.tencent.mm.plugin.appbrand.appstorage.a.a.class)).Mz(paramString)).longValue());
    AppMethodBeat.o(47480);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.b.b
 * JD-Core Version:    0.7.0.1
 */