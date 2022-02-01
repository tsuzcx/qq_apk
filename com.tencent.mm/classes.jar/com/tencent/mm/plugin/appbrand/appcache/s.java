package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.a.e;
import com.tencent.mm.plugin.appbrand.appcache.a.b.a.a;
import com.tencent.mm.plugin.appbrand.appcache.a.b.b;
import com.tencent.mm.pluginsdk.h.a.c.l;
import com.tencent.mm.pluginsdk.h.a.c.m;
import com.tencent.mm.sdk.platformtools.ad;

public final class s
{
  static int A(String paramString1, String paramString2, String paramString3)
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
  
  static void a(au paramau, m paramm, ac.a parama)
  {
    AppMethodBeat.i(90553);
    ad.e("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "onIncrementalPkgDownloadFail, request(%s %d->%d)", new Object[] { paramau.appId, Integer.valueOf(paramau.iNo), Integer.valueOf(paramau.iNp) });
    parama.a(paramm);
    paramm = ((e)g.ab(e.class)).aOk();
    if (paramm == null)
    {
      ad.e("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "onIncrementalPkgDownloadFail, before fallback full_pkg, nil storage");
      bh.a(paramau.BRL, paramau.appId, b.a.a.iPA, null);
      AppMethodBeat.o(90553);
      return;
    }
    bh.En(paramau.BRL);
    paramm = paramm.a(paramau.appId, paramau.iNp, 0, new String[] { "downloadURL" });
    if (paramm == null)
    {
      ad.e("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "onIncrementalPkgDownloadFail, before fallback full_pkg, nil record(%s %d)", new Object[] { paramau.appId, Integer.valueOf(paramau.iNp) });
      AppMethodBeat.o(90553);
      return;
    }
    if ((paramau.iNq instanceof b.b)) {
      ((b.b)paramau.iNq).aQB();
    }
    bh.b(paramau.appId, 0, paramau.iNp, paramm.field_downloadURL, paramau.iNq);
    AppMethodBeat.o(90553);
  }
  
  public static boolean a(String paramString1, int paramInt1, int paramInt2, String paramString2, bh.a parama)
  {
    AppMethodBeat.i(90552);
    boolean bool = bh.a(new au(paramString1, paramInt1, paramInt2, paramString2, parama), parama);
    AppMethodBeat.o(90552);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.s
 * JD-Core Version:    0.7.0.1
 */