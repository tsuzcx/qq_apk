package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ay;
import d.a.ak;
import d.g.b.p;
import d.l;
import java.util.Set;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"BATCH_DELAY", "", "HEADER_CACHE_TIME", "", "HEADER_CONTENT_TYPE", "HEADER_ETAG", "HEADER_IF_NONE_MATCH", "HEADER_LOCATION", "HEADER_MAX_CACHE", "HEADER_PREFETCH_HOST", "HEADER_PREFETCH_TYPE", "HEADER_PREFETCH_URL", "HEADER_PRETECH_CSS", "HEADER_PRETECH_JS", "HEADER_SET_COOKIE", "HEADER_STATUS", "HEADER_TRANSFER_ENCODING", "HEADER_USER_AGENT", "HEADER_VERSION", "HEADER_WX_ETAG", "HEADER_WX_IF_NONE_MATCH", "HEADER_WX_MAX_CACHE", "TAG", "WEB_PREFECHER_INVALID_HEADERS", "", "kvWebPrefetch", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getKvWebPrefetch", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "plugin-brandservice_release"})
public final class w
{
  private static final Set<String> orr;
  
  static
  {
    AppMethodBeat.i(208935);
    orr = ak.setOf("transfer-encoding");
    AppMethodBeat.o(208935);
  }
  
  public static final ay bRc()
  {
    AppMethodBeat.i(208934);
    ay localay = ay.aRW("_webview_web_prefetcher_info");
    p.g(localay, "MultiProcessMMKV.getMMKV…KV_WEBVIEW_PREFETCH_INFO)");
    AppMethodBeat.o(208934);
    return localay;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.w
 * JD-Core Version:    0.7.0.1
 */