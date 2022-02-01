package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/jsapi/file/WxaStorageSpaceStatisticsService$registerForStore$1", "Lcom/tencent/mm/plugin/appbrand/appstorage/FilePattern;", "accept", "", "path", "", "key", "plugin-appbrand-integration_release"})
public final class bm$c
  implements n
{
  bm$c(com.tencent.mm.plugin.appbrand.appstorage.p paramp) {}
  
  public final boolean acS(String paramString)
  {
    AppMethodBeat.i(275969);
    kotlin.g.b.p.k(paramString, "path");
    boolean bool = this.oST.adV(paramString);
    AppMethodBeat.o(275969);
    return bool;
  }
  
  public final String key()
  {
    return "saved_temp";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.bm.c
 * JD-Core Version:    0.7.0.1
 */