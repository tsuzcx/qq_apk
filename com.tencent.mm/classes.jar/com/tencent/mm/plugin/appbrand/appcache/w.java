package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.abd;
import com.tencent.mm.g.a.abf;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/appcache/PkgDownloadCDNDownloaderQualityReporter;", "", "()V", "setup", "", "cronetProfile", "Lcom/tencent/mars/cdn/CdnLogic$WebPageProfile;", "Lcom/tencent/mm/pluginsdk/res/downloader/model/NetworkResponse;", "ConstantsIDKey", "plugin-appbrand-integration_release"})
public final class w
{
  public static final w kLe;
  
  static
  {
    AppMethodBeat.i(227989);
    kLe = new w();
    AppMethodBeat.o(227989);
  }
  
  public static final void setup()
  {
    AppMethodBeat.i(227988);
    EventCenter.instance.add((IListener)new a());
    EventCenter.instance.add((IListener)new b());
    AppMethodBeat.o(227988);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/appcache/PkgDownloadCDNDownloaderQualityReporter$setup$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/WxaPkgCDNDownloaderEventEvent;", "callback", "", "event", "plugin-appbrand-integration_release"})
  public static final class a
    extends IListener<abd>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/appcache/PkgDownloadCDNDownloaderQualityReporter$setup$2", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/WxaPkgPreConnectCDNEventEvent;", "callback", "", "event", "plugin-appbrand-integration_release"})
  public static final class b
    extends IListener<abf>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.w
 * JD-Core Version:    0.7.0.1
 */