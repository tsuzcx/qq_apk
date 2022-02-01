package com.tencent.mm.plugin.appbrand.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.api.e;
import com.tencent.mm.plugin.appbrand.appcache.ao;
import com.tencent.mm.plugin.appbrand.appcache.bm;
import com.tencent.mm.plugin.appbrand.appcache.bp;
import com.tencent.mm.plugin.appbrand.appcache.g;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.appcache.s;
import kotlin.g.b.p;
import kotlin.n.n;

public final class o
  implements e
{
  public final bm bFb()
  {
    AppMethodBeat.i(44229);
    bm localbm = m.bFP();
    AppMethodBeat.o(44229);
    return localbm;
  }
  
  public final ao bFc()
  {
    AppMethodBeat.i(44230);
    ao localao = (ao)m.W(ao.class);
    AppMethodBeat.o(44230);
    return localao;
  }
  
  public final s<? extends g> n(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(281390);
    bp localbp = ((PluginAppBrand)h.ag(PluginAppBrand.class)).getWxaPkgStorageRouter();
    p.k(paramString1, "pkgKey");
    paramString2 = (CharSequence)paramString2;
    if ((paramString2 == null) || (paramString2.length() == 0)) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramString1 = (s)localbp.nHU;
      AppMethodBeat.o(281390);
      return paramString1;
    }
    if ((n.pu(paramString1, "$".concat(String.valueOf("__PLUGINCODE__")))) && (j.a.vB(paramInt)))
    {
      paramString1 = (s)localbp.nHU;
      AppMethodBeat.o(281390);
      return paramString1;
    }
    paramString1 = (s)localbp.nHT;
    AppMethodBeat.o(281390);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.o
 * JD-Core Version:    0.7.0.1
 */