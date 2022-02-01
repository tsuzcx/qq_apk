package com.tencent.mm.plugin.appbrand.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.api.e;
import com.tencent.mm.plugin.appbrand.appcache.ap;
import com.tencent.mm.plugin.appbrand.appcache.bm;
import com.tencent.mm.plugin.appbrand.appcache.bp;
import com.tencent.mm.plugin.appbrand.appcache.g;
import com.tencent.mm.plugin.appbrand.appcache.k.a;
import com.tencent.mm.plugin.appbrand.appcache.u;
import kotlin.g.b.s;

public final class p
  implements e
{
  public final bm ceo()
  {
    AppMethodBeat.i(44229);
    bm localbm = n.cfm();
    AppMethodBeat.o(44229);
    return localbm;
  }
  
  public final ap cep()
  {
    AppMethodBeat.i(44230);
    ap localap = (ap)n.ag(ap.class);
    AppMethodBeat.o(44230);
    return localap;
  }
  
  public final u<? extends g> p(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(317738);
    bp localbp = ((PluginAppBrand)h.az(PluginAppBrand.class)).getWxaPkgStorageRouter();
    s.u(paramString1, "pkgKey");
    paramString2 = (CharSequence)paramString2;
    if ((paramString2 == null) || (paramString2.length() == 0)) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramString1 = (u)localbp.qHJ;
      AppMethodBeat.o(317738);
      return paramString1;
    }
    if ((kotlin.n.n.rs(paramString1, "$".concat(String.valueOf("__PLUGINCODE__")))) && (k.a.vK(paramInt)))
    {
      paramString1 = (u)localbp.qHJ;
      AppMethodBeat.o(317738);
      return paramString1;
    }
    paramString1 = (u)localbp.qHI;
    AppMethodBeat.o(317738);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.p
 * JD-Core Version:    0.7.0.1
 */