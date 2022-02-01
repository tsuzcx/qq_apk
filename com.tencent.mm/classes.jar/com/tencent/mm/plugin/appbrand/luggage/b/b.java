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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;

@Deprecated
public final class b
  implements com.tencent.luggage.sdk.customize.a
{
  public final com.tencent.mm.plugin.appbrand.appstorage.d CJ()
  {
    AppMethodBeat.i(47479);
    com.tencent.mm.plugin.appbrand.appstorage.d locald = j.CJ();
    AppMethodBeat.o(47479);
    return locald;
  }
  
  public final com.tencent.mm.plugin.appbrand.config.d CK()
  {
    AppMethodBeat.i(47481);
    com.tencent.mm.plugin.appbrand.config.d locald = j.CK();
    AppMethodBeat.o(47481);
    return locald;
  }
  
  public final void CL()
  {
    AppMethodBeat.i(47482);
    if (ai.cin())
    {
      com.tencent.mm.pluginsdk.h.a.a.b localb = com.tencent.mm.pluginsdk.h.a.a.b.eLH();
      com.tencent.mm.pluginsdk.h.a.a.b.eLH();
      s locals = q.a.eMf().aGI(i.jb(38, 1));
      if (locals == null) {}
      for (int i = 0;; i = bs.getInt(locals.field_fileVersion, 0))
      {
        localb.f(38, 1, i, false);
        AppMethodBeat.o(47482);
        return;
      }
    }
    ac.i("MicroMsg.AppBrand.AppBrandGlobalSystemCon", "onConfigFileDeleted: not in main proc, ignore");
    AppMethodBeat.o(47482);
  }
  
  public final h ch(String paramString)
  {
    AppMethodBeat.i(47480);
    h.a locala = h.jsx;
    paramString = h.a.qH(new p(((com.tencent.mm.plugin.appbrand.appstorage.a.a)g.ab(com.tencent.mm.plugin.appbrand.appstorage.a.a.class)).Ji(paramString)).longValue());
    AppMethodBeat.o(47480);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.b.b
 * JD-Core Version:    0.7.0.1
 */