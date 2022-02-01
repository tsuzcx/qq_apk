package com.tencent.mm.plugin.appbrand.luggage.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appstorage.h;
import com.tencent.mm.plugin.appbrand.appstorage.h.a;
import com.tencent.mm.pluginsdk.h.a.a.i;
import com.tencent.mm.pluginsdk.h.a.c.q;
import com.tencent.mm.pluginsdk.h.a.c.q.a;
import com.tencent.mm.pluginsdk.h.a.c.s;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;

@Deprecated
public final class b
  implements com.tencent.luggage.sdk.customize.a
{
  public final com.tencent.mm.plugin.appbrand.appstorage.d Dg()
  {
    AppMethodBeat.i(47479);
    com.tencent.mm.plugin.appbrand.appstorage.d locald = j.Dg();
    AppMethodBeat.o(47479);
    return locald;
  }
  
  public final com.tencent.mm.plugin.appbrand.config.d Dh()
  {
    AppMethodBeat.i(47481);
    com.tencent.mm.plugin.appbrand.config.d locald = j.Dh();
    AppMethodBeat.o(47481);
    return locald;
  }
  
  public final void Di()
  {
    AppMethodBeat.i(47482);
    if (aj.cbe())
    {
      com.tencent.mm.pluginsdk.h.a.a.b localb = com.tencent.mm.pluginsdk.h.a.a.b.ewn();
      com.tencent.mm.pluginsdk.h.a.a.b.ewn();
      s locals = q.a.ewL().aBq(i.iO(38, 1));
      if (locals == null) {}
      for (int i = 0;; i = bt.getInt(locals.field_fileVersion, 0))
      {
        localb.e(38, 1, i, false);
        AppMethodBeat.o(47482);
        return;
      }
    }
    ad.i("MicroMsg.AppBrand.AppBrandGlobalSystemCon", "onConfigFileDeleted: not in main proc, ignore");
    AppMethodBeat.o(47482);
  }
  
  public final h cs(String paramString)
  {
    AppMethodBeat.i(47480);
    h.a locala = h.iSm;
    paramString = h.a.mS(new p(((com.tencent.mm.plugin.appbrand.appstorage.a.a)g.ab(com.tencent.mm.plugin.appbrand.appstorage.a.a.class)).Ff(paramString)).longValue());
    AppMethodBeat.o(47480);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.b.b
 * JD-Core Version:    0.7.0.1
 */