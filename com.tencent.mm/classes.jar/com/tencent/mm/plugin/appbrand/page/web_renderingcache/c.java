package com.tencent.mm.plugin.appbrand.page.web_renderingcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.ISQLiteDatabaseEx;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheAccessStatsStorage;", "Lcom/tencent/mm/plugin/appbrand/storage/MAutoStorageWithMultiKey;", "Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheAccessRecord;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabaseEx;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabaseEx;)V", "getDb$plugin_appbrand_integration_release", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabaseEx;", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends com.tencent.mm.plugin.appbrand.ae.c<b>
{
  private static final a tDg;
  final ISQLiteDatabaseEx qGR;
  
  static
  {
    AppMethodBeat.i(50954);
    tDg = new a((byte)0);
    AppMethodBeat.o(50954);
  }
  
  public c(ISQLiteDatabaseEx paramISQLiteDatabaseEx)
  {
    super((ISQLiteDatabase)paramISQLiteDatabaseEx, b.nVV, "WxaAppWebRenderingCacheAccessStatsTable", null);
    AppMethodBeat.i(50953);
    this.qGR = paramISQLiteDatabaseEx;
    AppMethodBeat.o(50953);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheAccessStatsStorage$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.web_renderingcache.c
 * JD-Core Version:    0.7.0.1
 */