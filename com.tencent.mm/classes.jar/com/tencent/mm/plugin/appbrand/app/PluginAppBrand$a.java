package com.tencent.mm.plugin.appbrand.app;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a.b.a.a;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.appbrand.appusage.af;
import com.tencent.mm.plugin.appbrand.appusage.ag;
import com.tencent.mm.plugin.appbrand.backgroundfetch.h;
import com.tencent.mm.plugin.appbrand.backgroundfetch.k;
import com.tencent.mm.plugin.appbrand.backgroundfetch.l;
import com.tencent.mm.plugin.appbrand.debugger.j;
import com.tencent.mm.plugin.appbrand.service.m;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ah;
import java.io.File;

final class PluginAppBrand$a
  extends q
  implements com.tencent.mm.kernel.a.b.b
{
  private com.tencent.mm.plugin.appbrand.jsapi.appdownload.a gSI;
  private final com.tencent.mm.sdk.b.c gSJ;
  private j gSK;
  
  PluginAppBrand$a()
  {
    super(g.class);
    AppMethodBeat.i(129222);
    this.gSJ = new PluginAppBrand.a.1(this);
    this.gSK = new j();
    AppMethodBeat.o(129222);
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(129223);
    super.onAccountInitialized(paramc);
    if (com.tencent.mm.sdk.platformtools.f.IS_FLAVOR_RED)
    {
      paramc = new com.tencent.mm.plugin.appbrand.appusage.e();
      if (paramc.kv(com.tencent.mm.protocal.d.whH)) {
        paramc.transfer(com.tencent.mm.protocal.d.whH);
      }
    }
    com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.appusage.c.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.appusage.c()));
    com.tencent.mm.plugin.appbrand.dynamic.widget.b.initialize();
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.a.e.class)).a("link_view_wxapp", new com.tencent.mm.plugin.appbrand.j.d());
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.a.e.class)).a("link_view_wxapp", new com.tencent.mm.plugin.appbrand.j.c());
    com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.a.b.class, new com.tencent.mm.kernel.c.e(com.tencent.mm.plugin.appbrand.appcache.t.gUT));
    com.tencent.mm.kernel.g.a(ag.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.appusage.p()));
    com.tencent.mm.kernel.g.a(af.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.appusage.f()));
    com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.widget.recentview.d.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.widget.c()));
    com.tencent.mm.kernel.g.a(com.tencent.mm.modelappbrand.b.a.class, new com.tencent.mm.kernel.c.e(com.tencent.mm.plugin.appbrand.t.auj()));
    com.tencent.mm.kernel.g.a(k.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.backgroundfetch.e()));
    com.tencent.mm.kernel.g.a(l.class, new com.tencent.mm.kernel.c.e(new h()));
    com.tencent.mm.kernel.g.b(com.tencent.luggage.xweb_ext.extendplugin.component.video.cache.b.class, com.tencent.luggage.xweb_ext.extendplugin.component.video.cache.c.bIc);
    com.tencent.mm.kernel.g.a(m.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.appcache.b.c()));
    com.tencent.mm.vfs.e.O(ah.getContext().getFilesDir().getParent() + File.separator + "voice_split_joint/", true);
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("WeAppSyncCommand", com.tencent.mm.plugin.appbrand.appcache.b.e.gXz);
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("subscribesysmsg", com.tencent.mm.plugin.appbrand.j.b.irz);
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("WeAppPushCommand", com.tencent.mm.plugin.appbrand.j.f.irL);
    this.gSI = new com.tencent.mm.plugin.appbrand.jsapi.appdownload.a();
    com.tencent.mm.plugin.downloader.model.f.bjl();
    com.tencent.mm.plugin.downloader.model.c.a(this.gSI);
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("DebugAppCodeUpdated", this.gSK);
    com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.service.d.class, new com.tencent.mm.kernel.c.e(new b()));
    AppMethodBeat.o(129223);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(129225);
    com.tencent.mm.kernel.g.F(ag.class);
    com.tencent.mm.kernel.g.F(af.class);
    com.tencent.mm.kernel.g.F(com.tencent.mm.plugin.appbrand.widget.recentview.d.class);
    com.tencent.mm.kernel.g.F(k.class);
    com.tencent.mm.kernel.g.F(l.class);
    com.tencent.mm.kernel.g.F(com.tencent.luggage.xweb_ext.extendplugin.component.video.cache.b.class);
    com.tencent.mm.kernel.g.F(com.tencent.mm.plugin.appbrand.appusage.c.class);
    super.onAccountRelease();
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.a.e.class)).SM("link_view_wxapp");
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.a.e.class)).SN("link_view_wxapp");
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b("WeAppSyncCommand", com.tencent.mm.plugin.appbrand.appcache.b.e.gXz);
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b("subscribesysmsg", com.tencent.mm.plugin.appbrand.j.b.irz);
    com.tencent.mm.plugin.downloader.model.f.bjl();
    com.tencent.mm.plugin.downloader.model.c.b(this.gSI);
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b("DebugAppCodeUpdated", this.gSK);
    AppMethodBeat.o(129225);
  }
  
  public final void parallelsDependency()
  {
    AppMethodBeat.i(129224);
    com.tencent.mm.kernel.a.b.a.a(this, com.tencent.mm.kernel.api.c.class).az(com.tencent.mm.kernel.g.G(n.class));
    com.tencent.mm.kernel.a.b.a.a(this, com.tencent.mm.kernel.api.c.class).az(com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.appbrand.a.c.class));
    AppMethodBeat.o(129224);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.PluginAppBrand.a
 * JD-Core Version:    0.7.0.1
 */