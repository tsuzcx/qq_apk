package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.api.e;
import com.tencent.mm.plugin.appbrand.appcache.a.b.a.a;
import com.tencent.mm.plugin.appbrand.appcache.a.b.b;
import com.tencent.mm.plugin.appbrand.y.i;
import com.tencent.mm.pluginsdk.j.a.c.l;
import com.tencent.mm.pluginsdk.j.a.c.m;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Collection;

public final class s
{
  static void a(aw paramaw, m paramm, ae.a parama)
  {
    AppMethodBeat.i(90553);
    ae.e("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "onIncrementalPkgDownloadFail, request(%s %d->%d)", new Object[] { paramaw.appId, Integer.valueOf(paramaw.jKu), Integer.valueOf(paramaw.jKv) });
    parama.a(paramm);
    paramm = ((e)g.ab(e.class)).aYP();
    if (paramm == null)
    {
      ae.e("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "onIncrementalPkgDownloadFail, before fallback full_pkg, nil storage");
      bj.a(paramaw.Fhz, paramaw.appId, b.a.a.jMF, null);
      AppMethodBeat.o(90553);
      return;
    }
    bj.Ml(paramaw.Fhz);
    paramm = paramm.a(paramaw.appId, paramaw.jKv, 0, new String[] { "downloadURL" });
    if (paramm == null)
    {
      ae.e("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "onIncrementalPkgDownloadFail, before fallback full_pkg, nil record(%s %d)", new Object[] { paramaw.appId, Integer.valueOf(paramaw.jKv) });
      AppMethodBeat.o(90553);
      return;
    }
    if ((paramaw.jKw instanceof b.b)) {
      ((b.b)paramaw.jKw).bbq();
    }
    bj.b(paramaw.appId, 0, paramaw.jKv, paramm.field_downloadURL, paramaw.jKw);
    AppMethodBeat.o(90553);
  }
  
  public static boolean a(String paramString1, int paramInt1, int paramInt2, String paramString2, bj.a parama)
  {
    AppMethodBeat.i(90552);
    boolean bool = bj.a(new aw(paramString1, paramInt1, paramInt2, paramString2, parama), parama);
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
      ae.e("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "mergeDiffPkg e = %s, old[%s], new[%s], diff[%s]", new Object[] { localException, paramString1, paramString2, paramString3 });
      AppMethodBeat.o(90554);
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.s
 * JD-Core Version:    0.7.0.1
 */