package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.api.e;
import com.tencent.mm.plugin.appbrand.appcache.a.b.a.a;
import com.tencent.mm.pluginsdk.res.downloader.model.l;
import com.tencent.mm.protocal.protobuf.aeo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;

public final class v
{
  static int F(String paramString1, String paramString2, String paramString3)
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
  
  static void a(ba paramba, l paraml, ag.a parama)
  {
    AppMethodBeat.i(90553);
    Log.e("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "onIncrementalPkgDownloadFail, request(%s %d->%d)", new Object[] { paramba.appId, Integer.valueOf(paramba.qGg), Integer.valueOf(paramba.qGh) });
    parama.a(paraml);
    paraml = ((e)h.ax(e.class)).ceo();
    if (paraml == null)
    {
      Log.e("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "onIncrementalPkgDownloadFail, before fallback full_pkg, nil storage");
      bq.a(paramba.XUX, paramba.appId, b.a.a.qIC, null);
      AppMethodBeat.o(90553);
      return;
    }
    bq.VA(paramba.XUX);
    paraml = paraml.b(paramba.appId, paramba.qGh, 0, new String[] { "downloadURL" });
    if (paraml == null)
    {
      Log.e("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "onIncrementalPkgDownloadFail, before fallback full_pkg, nil record(%s %d)", new Object[] { paramba.appId, Integer.valueOf(paramba.qGh) });
      AppMethodBeat.o(90553);
      return;
    }
    bq.a(paramba.appId, 0, paramba.qGh, paraml.field_downloadURL, paramba.qGi);
    AppMethodBeat.o(90553);
  }
  
  public static boolean a(String paramString1, int paramInt1, int paramInt2, String paramString2, aeo paramaeo, bq.a parama)
  {
    AppMethodBeat.i(320297);
    paramString1 = new ba(paramString1, paramInt1, paramInt2, paramString2, parama);
    paramString1.qIv = paramaeo;
    boolean bool = bq.a(paramString1, parama);
    AppMethodBeat.o(320297);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.v
 * JD-Core Version:    0.7.0.1
 */