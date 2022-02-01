package com.tencent.mm.plugin.appbrand.shortlink;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.shortlink.cgi.WxaShortLinkInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.LruCache;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/shortlink/ShortLinkInfoCache;", "Lcom/tencent/mm/plugin/appbrand/shortlink/IShortLinkInfoCache;", "()V", "CACHE", "Lcom/tencent/mm/sdk/platformtools/LruCache;", "", "Lcom/tencent/mm/plugin/appbrand/shortlink/cgi/WxaShortLinkInfo;", "TAG", "clear", "", "shortLink", "clearAll", "get", "store", "info", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements a
{
  private static final LruCache<String, WxaShortLinkInfo> hkA;
  public static final b tUW;
  
  static
  {
    AppMethodBeat.i(321859);
    tUW = new b();
    hkA = new LruCache(128);
    AppMethodBeat.o(321859);
  }
  
  public static void clearAll()
  {
    AppMethodBeat.i(321855);
    Log.i("MicroMsg.ShortLinkInfoCache", "clearAll");
    hkA.evictAll();
    AppMethodBeat.o(321855);
  }
  
  public final void a(String paramString, WxaShortLinkInfo paramWxaShortLinkInfo)
  {
    AppMethodBeat.i(321867);
    s.u(paramString, "shortLink");
    s.u(paramWxaShortLinkInfo, "info");
    hkA.put(paramString, paramWxaShortLinkInfo);
    AppMethodBeat.o(321867);
  }
  
  public final WxaShortLinkInfo agb(String paramString)
  {
    AppMethodBeat.i(321870);
    s.u(paramString, "shortLink");
    paramString = (WxaShortLinkInfo)hkA.get(paramString);
    AppMethodBeat.o(321870);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.shortlink.b
 * JD-Core Version:    0.7.0.1
 */