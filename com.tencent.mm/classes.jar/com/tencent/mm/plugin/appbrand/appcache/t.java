package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.api.e;
import com.tencent.mm.plugin.appbrand.appcache.a.b.a.a;
import com.tencent.mm.pluginsdk.k.a.c.k;
import com.tencent.mm.pluginsdk.k.a.c.l;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;

public final class t
{
  static int C(String paramString1, String paramString2, String paramString3)
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
  
  static void a(az paramaz, l paraml, af.a parama)
  {
    AppMethodBeat.i(90553);
    Log.e("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "onIncrementalPkgDownloadFail, request(%s %d->%d)", new Object[] { paramaz.appId, Integer.valueOf(paramaz.nGn), Integer.valueOf(paramaz.nGo) });
    parama.a(paraml);
    paraml = ((e)h.ae(e.class)).bFb();
    if (paraml == null)
    {
      Log.e("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "onIncrementalPkgDownloadFail, before fallback full_pkg, nil storage");
      bq.a(paramaz.QYU, paramaz.appId, b.a.a.nIM, null);
      AppMethodBeat.o(90553);
      return;
    }
    bq.ade(paramaz.QYU);
    paraml = paraml.b(paramaz.appId, paramaz.nGo, 0, new String[] { "downloadURL" });
    if (paraml == null)
    {
      Log.e("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "onIncrementalPkgDownloadFail, before fallback full_pkg, nil record(%s %d)", new Object[] { paramaz.appId, Integer.valueOf(paramaz.nGo) });
      AppMethodBeat.o(90553);
      return;
    }
    bq.c(paramaz.appId, 0, paramaz.nGo, paraml.field_downloadURL, paramaz.nGp);
    AppMethodBeat.o(90553);
  }
  
  public static boolean a(String paramString1, int paramInt1, int paramInt2, String paramString2, bq.a parama)
  {
    AppMethodBeat.i(90552);
    boolean bool = bq.a(new az(paramString1, paramInt1, paramInt2, paramString2, parama), parama);
    AppMethodBeat.o(90552);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.t
 * JD-Core Version:    0.7.0.1
 */