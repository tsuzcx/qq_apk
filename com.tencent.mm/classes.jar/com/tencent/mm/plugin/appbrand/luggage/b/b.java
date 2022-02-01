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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;

@Deprecated
public final class b
  implements com.tencent.luggage.sdk.customize.a
{
  public final com.tencent.mm.plugin.appbrand.appstorage.d El()
  {
    AppMethodBeat.i(47479);
    com.tencent.mm.plugin.appbrand.appstorage.d locald = j.El();
    AppMethodBeat.o(47479);
    return locald;
  }
  
  public final com.tencent.mm.plugin.appbrand.config.d Em()
  {
    AppMethodBeat.i(47481);
    com.tencent.mm.plugin.appbrand.config.d locald = j.Em();
    AppMethodBeat.o(47481);
    return locald;
  }
  
  public final void En()
  {
    AppMethodBeat.i(47482);
    if (ak.coh())
    {
      com.tencent.mm.pluginsdk.j.a.a.b localb = com.tencent.mm.pluginsdk.j.a.a.b.fes();
      com.tencent.mm.pluginsdk.j.a.a.b.fes();
      s locals = q.a.feQ().aNE(i.jr(38, 1));
      if (locals == null) {}
      for (int i = 0;; i = bu.getInt(locals.field_fileVersion, 0))
      {
        localb.f(38, 1, i, false);
        AppMethodBeat.o(47482);
        return;
      }
    }
    ae.i("MicroMsg.AppBrand.AppBrandGlobalSystemCon", "onConfigFileDeleted: not in main proc, ignore");
    AppMethodBeat.o(47482);
  }
  
  public final h dl(String paramString)
  {
    AppMethodBeat.i(47480);
    h.a locala = h.jPD;
    paramString = h.a.sS(new p(((com.tencent.mm.plugin.appbrand.appstorage.a.a)g.ab(com.tencent.mm.plugin.appbrand.appstorage.a.a.class)).Ng(paramString)).longValue());
    AppMethodBeat.o(47480);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.b.b
 * JD-Core Version:    0.7.0.1
 */