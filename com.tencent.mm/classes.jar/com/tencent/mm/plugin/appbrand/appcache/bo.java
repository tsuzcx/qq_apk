package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.o.a;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgStorageInvalidRecordFixer;", "", "()V", "TAG", "", "removeInvalidReleaseRecords", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bo
{
  public static final bo qHH;
  
  static
  {
    AppMethodBeat.i(50182);
    qHH = new bo();
    AppMethodBeat.o(50182);
  }
  
  public static final void chc()
  {
    AppMethodBeat.i(50181);
    o.a locala = n.ceY();
    if (locala != null) {
      try
      {
        locala.execSQL("AppBrandWxaPkgManifestRecord", "delete from AppBrandWxaPkgManifestRecord where debugType=0 and version=0");
        AppMethodBeat.o(50181);
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MiroMsg.WxaPkgStorageInvalidRecordFixer", (Throwable)localException, " removeInvalidReleaseRecords", new Object[0]);
        ah localah = ah.aiuX;
      }
    }
    AppMethodBeat.o(50181);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bo
 * JD-Core Version:    0.7.0.1
 */