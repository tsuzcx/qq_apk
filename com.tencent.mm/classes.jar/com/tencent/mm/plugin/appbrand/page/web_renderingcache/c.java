package com.tencent.mm.plugin.appbrand.page.web_renderingcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.f;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheAccessStatsStorage;", "Lcom/tencent/mm/plugin/appbrand/storage/MAutoStorageWithMultiKey;", "Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheAccessRecord;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabaseEx;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabaseEx;)V", "getDb$plugin_appbrand_integration_release", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabaseEx;", "Companion", "plugin-appbrand-integration_release"})
public final class c
  extends com.tencent.mm.plugin.appbrand.x.c<b>
{
  @Deprecated
  public static final a mlE;
  final f kch;
  
  static
  {
    AppMethodBeat.i(50954);
    mlE = new a((byte)0);
    AppMethodBeat.o(50954);
  }
  
  public c(f paramf)
  {
    super((e)paramf, b.hGW, "WxaAppWebRenderingCacheAccessStatsTable", null);
    AppMethodBeat.i(50953);
    this.kch = paramf;
    AppMethodBeat.o(50953);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheAccessStatsStorage$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.web_renderingcache.c
 * JD-Core Version:    0.7.0.1
 */