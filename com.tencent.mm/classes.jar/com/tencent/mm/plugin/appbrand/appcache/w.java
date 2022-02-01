package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.zw;
import com.tencent.mm.g.a.zy;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/appcache/PkgDownloadCDNDownloaderQualityReporter;", "", "()V", "setup", "", "cronetProfile", "Lcom/tencent/mars/cdn/CdnLogic$WebPageProfile;", "Lcom/tencent/mm/pluginsdk/res/downloader/model/NetworkResponse;", "ConstantsIDKey", "plugin-appbrand-integration_release"})
public final class w
{
  public static final w jJh;
  
  static
  {
    AppMethodBeat.i(223210);
    jJh = new w();
    AppMethodBeat.o(223210);
  }
  
  public static final void setup()
  {
    AppMethodBeat.i(223209);
    a.IvT.b((c)new a());
    a.IvT.b((c)new b());
    AppMethodBeat.o(223209);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/appbrand/appcache/PkgDownloadCDNDownloaderQualityReporter$setup$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/WxaPkgCDNDownloaderEventEvent;", "callback", "", "event", "plugin-appbrand-integration_release"})
  public static final class a
    extends c<zw>
  {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/appbrand/appcache/PkgDownloadCDNDownloaderQualityReporter$setup$2", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/WxaPkgPreConnectCDNEventEvent;", "callback", "", "event", "plugin-appbrand-integration_release"})
  public static final class b
    extends c<zy>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.w
 * JD-Core Version:    0.7.0.1
 */