package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.zq;
import com.tencent.mm.g.a.zs;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/appcache/PkgDownloadCDNDownloaderQualityReporter;", "", "()V", "setup", "", "cronetProfile", "Lcom/tencent/mars/cdn/CdnLogic$WebPageProfile;", "Lcom/tencent/mm/pluginsdk/res/downloader/model/NetworkResponse;", "ConstantsIDKey", "plugin-appbrand-integration_release"})
public final class v
{
  public static final v jGh;
  
  static
  {
    AppMethodBeat.i(188965);
    jGh = new v();
    AppMethodBeat.o(188965);
  }
  
  public static final void setup()
  {
    AppMethodBeat.i(188964);
    a.IbL.b((c)new a());
    a.IbL.b((c)new b());
    AppMethodBeat.o(188964);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/appbrand/appcache/PkgDownloadCDNDownloaderQualityReporter$setup$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/WxaPkgCDNDownloaderEventEvent;", "callback", "", "event", "plugin-appbrand-integration_release"})
  public static final class a
    extends c<zq>
  {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/appbrand/appcache/PkgDownloadCDNDownloaderQualityReporter$setup$2", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/WxaPkgPreConnectCDNEventEvent;", "callback", "", "event", "plugin-appbrand-integration_release"})
  public static final class b
    extends c<zs>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.v
 * JD-Core Version:    0.7.0.1
 */