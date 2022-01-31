package com.tencent.mm.plugin.appbrand.appcache;

import a.n;
import com.tencent.mm.platformtools.t.a;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.sdk.platformtools.y;

public final class as
{
  public static final as fEH = new as();
  
  public static final void acq()
  {
    t.a locala = e.aaO();
    if (locala != null) {}
    try
    {
      locala.gk("AppBrandWxaPkgManifestRecord", "delete from AppBrandWxaPkgManifestRecord where debugType=0 and version=0");
      return;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MiroMsg.WxaPkgStorageInvalidRecordFixer", (Throwable)localException, " removeInvalidReleaseRecords", new Object[0]);
      n localn = n.xoh;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.as
 * JD-Core Version:    0.7.0.1
 */