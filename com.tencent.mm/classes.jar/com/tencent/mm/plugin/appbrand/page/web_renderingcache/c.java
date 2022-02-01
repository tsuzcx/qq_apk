package com.tencent.mm.plugin.appbrand.page.web_renderingcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.ISQLiteDatabaseEx;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheAccessStatsStorage;", "Lcom/tencent/mm/plugin/appbrand/storage/MAutoStorageWithMultiKey;", "Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheAccessRecord;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabaseEx;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabaseEx;)V", "getDb$plugin_appbrand_integration_release", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabaseEx;", "Companion", "plugin-appbrand-integration_release"})
public final class c
  extends com.tencent.mm.plugin.appbrand.ab.c<b>
{
  @Deprecated
  public static final a nwc;
  final ISQLiteDatabaseEx kOg;
  
  static
  {
    AppMethodBeat.i(50954);
    nwc = new a((byte)0);
    AppMethodBeat.o(50954);
  }
  
  public c(ISQLiteDatabaseEx paramISQLiteDatabaseEx)
  {
    super((ISQLiteDatabase)paramISQLiteDatabaseEx, b.iBg, "WxaAppWebRenderingCacheAccessStatsTable", null);
    AppMethodBeat.i(50953);
    this.kOg = paramISQLiteDatabaseEx;
    AppMethodBeat.o(50953);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheAccessStatsStorage$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.web_renderingcache.c
 * JD-Core Version:    0.7.0.1
 */