package com.tencent.mm.plugin.appbrand.shortlink;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.shortlink.cgi.WxaShortLinkInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.LruCache;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/shortlink/ShortLinkInfoCache;", "Lcom/tencent/mm/plugin/appbrand/shortlink/IShortLinkInfoCache;", "()V", "CACHE", "Lcom/tencent/mm/sdk/platformtools/LruCache;", "", "Lcom/tencent/mm/plugin/appbrand/shortlink/cgi/WxaShortLinkInfo;", "TAG", "clear", "", "shortLink", "clearAll", "get", "store", "info", "plugin-appbrand-integration_release"})
public final class b
  implements a
{
  private static final LruCache<String, WxaShortLinkInfo> nNM;
  public static final b nNN;
  
  static
  {
    AppMethodBeat.i(229344);
    nNN = new b();
    nNM = new LruCache(128);
    AppMethodBeat.o(229344);
  }
  
  public static void clearAll()
  {
    AppMethodBeat.i(229343);
    Log.i("MicroMsg.ShortLinkInfoCache", "clearAll");
    nNM.evictAll();
    AppMethodBeat.o(229343);
  }
  
  public final void a(String paramString, WxaShortLinkInfo paramWxaShortLinkInfo)
  {
    AppMethodBeat.i(229341);
    p.h(paramString, "shortLink");
    p.h(paramWxaShortLinkInfo, "info");
    nNM.put(paramString, paramWxaShortLinkInfo);
    AppMethodBeat.o(229341);
  }
  
  public final WxaShortLinkInfo aeX(String paramString)
  {
    AppMethodBeat.i(229342);
    p.h(paramString, "shortLink");
    paramString = (WxaShortLinkInfo)nNM.get(paramString);
    AppMethodBeat.o(229342);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.shortlink.b
 * JD-Core Version:    0.7.0.1
 */