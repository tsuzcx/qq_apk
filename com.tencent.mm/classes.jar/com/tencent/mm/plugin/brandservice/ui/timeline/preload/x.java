package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"BATCH_DELAY", "", "HEADER_CACHE_TIME", "", "HEADER_CONTENT_TYPE", "HEADER_ETAG", "HEADER_IF_NONE_MATCH", "HEADER_LOCATION", "HEADER_MAX_CACHE", "HEADER_PREFETCH_HOST", "HEADER_PREFETCH_TYPE", "HEADER_PREFETCH_URL", "HEADER_PRETECH_CSS", "HEADER_PRETECH_JS", "HEADER_SET_COOKIE", "HEADER_STATUS", "HEADER_TRANSFER_ENCODING", "HEADER_USER_AGENT", "HEADER_VERSION", "HEADER_WX_ETAG", "HEADER_WX_IF_NONE_MATCH", "HEADER_WX_MAX_CACHE", "TAG", "WEB_PREFECHER_INVALID_HEADERS", "", "kvWebPrefetch", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getKvWebPrefetch", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "plugin-brandservice_release"})
public final class x
{
  private static final Set<String> pFb;
  
  static
  {
    AppMethodBeat.i(195746);
    pFb = ak.setOf("transfer-encoding");
    AppMethodBeat.o(195746);
  }
  
  public static final MultiProcessMMKV coM()
  {
    AppMethodBeat.i(195745);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("_webview_web_prefetcher_info");
    p.g(localMultiProcessMMKV, "MultiProcessMMKV.getMMKV…KV_WEBVIEW_PREFETCH_INFO)");
    AppMethodBeat.o(195745);
    return localMultiProcessMMKV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.x
 * JD-Core Version:    0.7.0.1
 */