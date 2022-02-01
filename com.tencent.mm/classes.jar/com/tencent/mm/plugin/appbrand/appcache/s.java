package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.api.e;
import com.tencent.mm.plugin.appbrand.appcache.a.b.a.a;
import com.tencent.mm.plugin.appbrand.appcache.a.b.b;
import com.tencent.mm.plugin.appbrand.z.i;
import com.tencent.mm.pluginsdk.j.a.c.l;
import com.tencent.mm.pluginsdk.j.a.c.m;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Collection;

public final class s
{
  static void a(av paramav, m paramm, ad.a parama)
  {
    AppMethodBeat.i(90553);
    ad.e("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "onIncrementalPkgDownloadFail, request(%s %d->%d)", new Object[] { paramav.appId, Integer.valueOf(paramav.jHt), Integer.valueOf(paramav.jHu) });
    parama.a(paramm);
    paramm = ((e)g.ab(e.class)).aYu();
    if (paramm == null)
    {
      ad.e("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "onIncrementalPkgDownloadFail, before fallback full_pkg, nil storage");
      bi.a(paramav.EPe, paramav.appId, b.a.a.jJD, null);
      AppMethodBeat.o(90553);
      return;
    }
    bi.LI(paramav.EPe);
    paramm = paramm.a(paramav.appId, paramav.jHu, 0, new String[] { "downloadURL" });
    if (paramm == null)
    {
      ad.e("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "onIncrementalPkgDownloadFail, before fallback full_pkg, nil record(%s %d)", new Object[] { paramav.appId, Integer.valueOf(paramav.jHu) });
      AppMethodBeat.o(90553);
      return;
    }
    if ((paramav.jHv instanceof b.b)) {
      ((b.b)paramav.jHv).baR();
    }
    bi.b(paramav.appId, 0, paramav.jHu, paramm.field_downloadURL, paramav.jHv);
    AppMethodBeat.o(90553);
  }
  
  public static boolean a(String paramString1, int paramInt1, int paramInt2, String paramString2, bi.a parama)
  {
    AppMethodBeat.i(90552);
    boolean bool = bi.a(new av(paramString1, paramInt1, paramInt2, paramString2, parama), parama);
    AppMethodBeat.o(90552);
    return bool;
  }
  
  static int z(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(90554);
    try
    {
      int i = WABSPatch.bspatch(paramString1, paramString2, paramString3);
      AppMethodBeat.o(90554);
      return i;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "mergeDiffPkg e = %s, old[%s], new[%s], diff[%s]", new Object[] { localException, paramString1, paramString2, paramString3 });
      AppMethodBeat.o(90554);
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.s
 * JD-Core Version:    0.7.0.1
 */