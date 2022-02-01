package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ax.c;
import com.tencent.mm.plugin.ax.c.a;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"BATCH_DELAY", "", "FETCH_PKG_TYPE_BY_APPID", "", "FETCH_PKG_TYPE_BY_HTTP", "HEADER_CACHE_TIME", "", "HEADER_CONTENT_TYPE", "HEADER_CORS_ORIGIN", "HEADER_CORS_REFERER", "HEADER_ETAG", "HEADER_FETCH_PKG_URL", "HEADER_IF_NONE_MATCH", "HEADER_LOCATION", "HEADER_MAX_CACHE", "HEADER_PREFETCH_HOST", "HEADER_PREFETCH_TYPE", "HEADER_PREFETCH_URL", "HEADER_PRETECH_CSS", "HEADER_PRETECH_JS", "HEADER_SET_COOKIE", "HEADER_STATUS", "HEADER_USER_AGENT", "HEADER_VERSION", "HEADER_WX_ETAG", "HEADER_WX_IF_NONE_MATCH", "HEADER_WX_MAX_CACHE", "TAG", "WEB_PREFECHER_INVALID_HEADERS", "", "kvWebPrefetch", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getKvWebPrefetch", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kvWebPrefetchTest", "getKvWebPrefetchTest", "plugin-brandservice_release"})
public final class v
{
  private static final Set<String> sPK;
  
  static
  {
    AppMethodBeat.i(264868);
    c.a locala = c.PwQ;
    sPK = c.gPT();
    AppMethodBeat.o(264868);
  }
  
  public static final MultiProcessMMKV cDa()
  {
    AppMethodBeat.i(264866);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("_webview_web_prefetcher_info");
    p.j(localMultiProcessMMKV, "MultiProcessMMKV.getMMKV…KV_WEBVIEW_PREFETCH_INFO)");
    AppMethodBeat.o(264866);
    return localMultiProcessMMKV;
  }
  
  public static final MultiProcessMMKV cDb()
  {
    AppMethodBeat.i(264867);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("_webview_web_prefetcher_test_info");
    p.j(localMultiProcessMMKV, "MultiProcessMMKV.getMMKV…BVIEW_PREFETCH_TEST_INFO)");
    AppMethodBeat.o(264867);
    return localMultiProcessMMKV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.v
 * JD-Core Version:    0.7.0.1
 */