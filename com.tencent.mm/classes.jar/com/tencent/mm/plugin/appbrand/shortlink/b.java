package com.tencent.mm.plugin.appbrand.shortlink;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.shortlink.cgi.WxaShortLinkInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.LruCache;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/shortlink/ShortLinkInfoCache;", "Lcom/tencent/mm/plugin/appbrand/shortlink/IShortLinkInfoCache;", "()V", "CACHE", "Lcom/tencent/mm/sdk/platformtools/LruCache;", "", "Lcom/tencent/mm/plugin/appbrand/shortlink/cgi/WxaShortLinkInfo;", "TAG", "clear", "", "shortLink", "clearAll", "get", "store", "info", "plugin-appbrand-integration_release"})
public final class b
  implements a
{
  private static final LruCache<String, WxaShortLinkInfo> fgq;
  public static final b qQj;
  
  static
  {
    AppMethodBeat.i(283001);
    qQj = new b();
    fgq = new LruCache(128);
    AppMethodBeat.o(283001);
  }
  
  public static void clearAll()
  {
    AppMethodBeat.i(283000);
    Log.i("MicroMsg.ShortLinkInfoCache", "clearAll");
    fgq.evictAll();
    AppMethodBeat.o(283000);
  }
  
  public final void a(String paramString, WxaShortLinkInfo paramWxaShortLinkInfo)
  {
    AppMethodBeat.i(282997);
    p.k(paramString, "shortLink");
    p.k(paramWxaShortLinkInfo, "info");
    fgq.put(paramString, paramWxaShortLinkInfo);
    AppMethodBeat.o(282997);
  }
  
  public final WxaShortLinkInfo amR(String paramString)
  {
    AppMethodBeat.i(282999);
    p.k(paramString, "shortLink");
    paramString = (WxaShortLinkInfo)fgq.get(paramString);
    AppMethodBeat.o(282999);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.shortlink.b
 * JD-Core Version:    0.7.0.1
 */