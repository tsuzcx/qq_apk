package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.a.e;
import com.tencent.mm.plugin.appbrand.appcache.a.b.a.a;
import com.tencent.mm.plugin.appbrand.appcache.a.b.b;
import com.tencent.mm.pluginsdk.h.a.c.l;
import com.tencent.mm.pluginsdk.h.a.c.m;
import com.tencent.mm.sdk.platformtools.ac;

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
      ac.e("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "mergeDiffPkg e = %s, old[%s], new[%s], diff[%s]", new Object[] { localException, paramString1, paramString2, paramString3 });
      AppMethodBeat.o(90554);
    }
    return 1;
  }
  
  static void a(au paramau, m paramm, ac.a parama)
  {
    AppMethodBeat.i(90553);
    ac.e("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "onIncrementalPkgDownloadFail, request(%s %d->%d)", new Object[] { paramau.appId, Integer.valueOf(paramau.jnw), Integer.valueOf(paramau.jnx) });
    parama.a(paramm);
    paramm = ((e)g.ab(e.class)).aVa();
    if (paramm == null)
    {
      ac.e("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "onIncrementalPkgDownloadFail, before fallback full_pkg, nil storage");
      bh.a(paramau.Dkb, paramau.appId, b.a.a.jpJ, null);
      AppMethodBeat.o(90553);
      return;
    }
    bh.Iq(paramau.Dkb);
    paramm = paramm.a(paramau.appId, paramau.jnx, 0, new String[] { "downloadURL" });
    if (paramm == null)
    {
      ac.e("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "onIncrementalPkgDownloadFail, before fallback full_pkg, nil record(%s %d)", new Object[] { paramau.appId, Integer.valueOf(paramau.jnx) });
      AppMethodBeat.o(90553);
      return;
    }
    if ((paramau.jny instanceof b.b)) {
      ((b.b)paramau.jny).aXt();
    }
    bh.b(paramau.appId, 0, paramau.jnx, paramm.field_downloadURL, paramau.jny);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.s
 * JD-Core Version:    0.7.0.1
 */