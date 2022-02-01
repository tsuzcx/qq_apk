package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appcache/PkgDownloadCDNDownloaderQualityReporter;", "", "()V", "setup", "", "cronetProfile", "Lcom/tencent/mars/cdn/CdnLogic$WebPageProfile;", "Lcom/tencent/mm/pluginsdk/res/downloader/model/NetworkResponse;", "ConstantsIDKey", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class z
{
  public static final z qET;
  
  static
  {
    AppMethodBeat.i(320336);
    qET = new z();
    AppMethodBeat.o(320336);
  }
  
  public static final void setup()
  {
    AppMethodBeat.i(320328);
    new PkgDownloadCDNDownloaderQualityReporter.setup.1(f.hfK).alive();
    new PkgDownloadCDNDownloaderQualityReporter.setup.2(f.hfK).alive();
    AppMethodBeat.o(320328);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.z
 * JD-Core Version:    0.7.0.1
 */