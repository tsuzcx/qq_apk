package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;
import d.y;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgStorageInvalidRecordFixer;", "", "()V", "TAG", "", "removeInvalidReleaseRecords", "", "plugin-appbrand-integration_release"})
public final class bg
{
  public static final bg joU;
  
  static
  {
    AppMethodBeat.i(50182);
    joU = new bg();
    AppMethodBeat.o(50182);
  }
  
  public static final void aXp()
  {
    AppMethodBeat.i(50181);
    r.a locala = j.aVq();
    if (locala != null) {
      try
      {
        locala.execSQL("AppBrandWxaPkgManifestRecord", "delete from AppBrandWxaPkgManifestRecord where debugType=0 and version=0");
        AppMethodBeat.o(50181);
        return;
      }
      catch (Exception localException)
      {
        ac.printErrStackTrace("MiroMsg.WxaPkgStorageInvalidRecordFixer", (Throwable)localException, " removeInvalidReleaseRecords", new Object[0]);
        y localy = y.KTp;
        AppMethodBeat.o(50181);
        return;
      }
    }
    AppMethodBeat.o(50181);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bg
 * JD-Core Version:    0.7.0.1
 */