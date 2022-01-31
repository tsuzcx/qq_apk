package com.tencent.mm.plugin.appbrand.appcache;

import a.l;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.t.a;
import com.tencent.mm.plugin.appbrand.app.g;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgStorageInvalidRecordFixer;", "", "()V", "TAG", "", "removeInvalidReleaseRecords", "", "plugin-appbrand-integration_release"})
public final class az
{
  public static final az gWZ;
  
  static
  {
    AppMethodBeat.i(134468);
    gWZ = new az();
    AppMethodBeat.o(134468);
  }
  
  public static final void awh()
  {
    AppMethodBeat.i(134467);
    t.a locala = g.auB();
    if (locala != null) {
      try
      {
        locala.execSQL("AppBrandWxaPkgManifestRecord", "delete from AppBrandWxaPkgManifestRecord where debugType=0 and version=0");
        AppMethodBeat.o(134467);
        return;
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("MiroMsg.WxaPkgStorageInvalidRecordFixer", (Throwable)localException, " removeInvalidReleaseRecords", new Object[0]);
        y localy = y.BMg;
        AppMethodBeat.o(134467);
        return;
      }
    }
    AppMethodBeat.o(134467);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.az
 * JD-Core Version:    0.7.0.1
 */