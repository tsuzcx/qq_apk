package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.a.d;
import com.tencent.mm.plugin.appbrand.appcache.a.b.a.a;
import com.tencent.mm.pluginsdk.g.a.c.l;
import com.tencent.mm.pluginsdk.g.a.c.m;
import com.tencent.mm.sdk.platformtools.ab;

public final class p
{
  static int B(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(59441);
    try
    {
      int i = WABSPatch.bspatch(paramString1, paramString2, paramString3);
      AppMethodBeat.o(59441);
      return i;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "mergeDiffPkg e = %s, old[%s], new[%s], diff[%s]", new Object[] { localException, paramString1, paramString2, paramString3 });
      AppMethodBeat.o(59441);
    }
    return 1;
  }
  
  static void a(al paramal, m paramm, z.a parama)
  {
    AppMethodBeat.i(59440);
    ab.e("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "onIncrementalPkgDownloadFail, request(%s %d->%d)", new Object[] { paramal.appId, Integer.valueOf(paramal.gVy), Integer.valueOf(paramal.gVz) });
    parama.a(paramm);
    paramm = ((d)g.E(d.class)).we();
    if (paramm == null)
    {
      ab.e("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "onIncrementalPkgDownloadFail, before fallback full_pkg, nil storage");
      ba.a(paramal.vMK, paramal.appId, b.a.a.gXs, null);
      AppMethodBeat.o(59440);
      return;
    }
    ba.yI(paramal.vMK);
    paramm = paramm.a(paramal.appId, paramal.gVz, 0, new String[] { "downloadURL" });
    if (paramm == null)
    {
      ab.e("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "onIncrementalPkgDownloadFail, before fallback full_pkg, nil record(%s %d)", new Object[] { paramal.appId, Integer.valueOf(paramal.gVz) });
      AppMethodBeat.o(59440);
      return;
    }
    ba.b(paramal.appId, 0, paramal.gVz, paramm.field_downloadURL, paramal.gVA);
    AppMethodBeat.o(59440);
  }
  
  public static boolean a(String paramString1, int paramInt1, int paramInt2, String paramString2, ba.a parama)
  {
    AppMethodBeat.i(59439);
    boolean bool = ba.a(new al(paramString1, paramInt1, paramInt2, paramString2, parama), parama);
    AppMethodBeat.o(59439);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.p
 * JD-Core Version:    0.7.0.1
 */