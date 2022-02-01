package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.api.e;
import com.tencent.mm.plugin.appbrand.appcache.a.b.a.a;
import com.tencent.mm.plugin.appbrand.appcache.a.b.b;
import com.tencent.mm.pluginsdk.j.a.c.l;
import com.tencent.mm.pluginsdk.j.a.c.m;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;

public final class s
{
  static int B(String paramString1, String paramString2, String paramString3)
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
      Log.e("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "mergeDiffPkg e = %s, old[%s], new[%s], diff[%s]", new Object[] { localException, paramString1, paramString2, paramString3 });
      AppMethodBeat.o(90554);
    }
    return 1;
  }
  
  static void a(aw paramaw, m paramm, ae.a parama)
  {
    AppMethodBeat.i(90553);
    Log.e("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "onIncrementalPkgDownloadFail, request(%s %d->%d)", new Object[] { paramaw.appId, Integer.valueOf(paramaw.kMt), Integer.valueOf(paramaw.kMu) });
    parama.a(paramm);
    paramm = ((e)g.af(e.class)).bub();
    if (paramm == null)
    {
      Log.e("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "onIncrementalPkgDownloadFail, before fallback full_pkg, nil storage");
      bj.a(paramaw.JYs, paramaw.appId, b.a.a.kOJ, null);
      AppMethodBeat.o(90553);
      return;
    }
    bj.Vu(paramaw.JYs);
    paramm = paramm.a(paramaw.appId, paramaw.kMu, 0, new String[] { "downloadURL" });
    if (paramm == null)
    {
      Log.e("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "onIncrementalPkgDownloadFail, before fallback full_pkg, nil record(%s %d)", new Object[] { paramaw.appId, Integer.valueOf(paramaw.kMu) });
      AppMethodBeat.o(90553);
      return;
    }
    if ((paramaw.kMv instanceof b.b)) {
      ((b.b)paramaw.kMv).bwD();
    }
    bj.c(paramaw.appId, 0, paramaw.kMu, paramm.field_downloadURL, paramaw.kMv);
    AppMethodBeat.o(90553);
  }
  
  public static boolean a(String paramString1, int paramInt1, int paramInt2, String paramString2, bj.a parama)
  {
    AppMethodBeat.i(90552);
    boolean bool = bj.a(new aw(paramString1, paramInt1, paramInt2, paramString2, parama), parama);
    AppMethodBeat.o(90552);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.s
 * JD-Core Version:    0.7.0.1
 */