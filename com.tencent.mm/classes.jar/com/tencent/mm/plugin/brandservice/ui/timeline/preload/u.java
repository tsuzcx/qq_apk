package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.az.c;
import com.tencent.mm.plugin.az.c.a;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"BATCH_DELAY", "", "FETCH_PKG_TYPE_BY_APPID", "", "FETCH_PKG_TYPE_BY_HTTP", "HEADER_CACHE_TIME", "", "HEADER_CONTENT_TYPE", "HEADER_CORS_ORIGIN", "HEADER_CORS_REFERER", "HEADER_ETAG", "HEADER_FETCH_PKG_URL", "HEADER_IF_NONE_MATCH", "HEADER_LOCATION", "HEADER_MAX_CACHE", "HEADER_PREFETCH_FULL_VERSION_IN_USE", "HEADER_PREFETCH_FULL_VERSION_LIST", "HEADER_PREFETCH_HOST", "HEADER_PREFETCH_PKG_BASE_FULL_VERSION", "HEADER_PREFETCH_PKG_BASE_VERSION", "HEADER_PREFETCH_PKG_FULL_MD5", "HEADER_PREFETCH_PKG_PATCH_MD5", "HEADER_PREFETCH_PKG_VERSION", "HEADER_PREFETCH_TYPE", "HEADER_PREFETCH_URL", "HEADER_PRETECH_CSS", "HEADER_PRETECH_JS", "HEADER_SET_COOKIE", "HEADER_STATUS", "HEADER_USER_AGENT", "HEADER_VERSION", "HEADER_WX_ETAG", "HEADER_WX_IF_NONE_MATCH", "HEADER_WX_MAX_CACHE", "TAG", "WEB_PREFECHER_INVALID_HEADERS", "", "kvWebPrefetch", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getKvWebPrefetch", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kvWebPrefetchTest", "getKvWebPrefetchTest", "plugin-brandservice_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class u
{
  private static final Set<String> vUV;
  
  static
  {
    AppMethodBeat.i(303267);
    c.a locala = c.WmU;
    vUV = c.ipj();
    AppMethodBeat.o(303267);
  }
  
  public static final MultiProcessMMKV dgw()
  {
    AppMethodBeat.i(303252);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("_webview_web_prefetcher_info");
    s.s(localMultiProcessMMKV, "getMMKV(ConstantsPreload…KV_WEBVIEW_PREFETCH_INFO)");
    AppMethodBeat.o(303252);
    return localMultiProcessMMKV;
  }
  
  public static final MultiProcessMMKV dgx()
  {
    AppMethodBeat.i(303258);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("_webview_web_prefetcher_test_info");
    s.s(localMultiProcessMMKV, "getMMKV(ConstantsPreload…BVIEW_PREFETCH_TEST_INFO)");
    AppMethodBeat.o(303258);
    return localMultiProcessMMKV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.u
 * JD-Core Version:    0.7.0.1
 */