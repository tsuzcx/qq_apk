package com.tencent.mm.plugin.appbrand.app;

import com.tencent.luggage.bridge.a.a.b;
import com.tencent.luggage.bridge.a.a.c;
import com.tencent.luggage.sdk.b.a.c.b.a;
import com.tencent.luggage.xweb_ext.extendplugin.component.video.cache.VideoCacheServiceIPC;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.debugger.r;
import com.tencent.mm.plugin.appbrand.jsapi.x;
import com.tencent.mm.plugin.appbrand.luggage.b.i;
import com.tencent.mm.plugin.appbrand.luggage.b.l;
import com.tencent.mm.plugin.appbrand.s.q.a;
import com.tencent.mm.plugin.appbrand.ui.s;
import com.tencent.mm.plugin.appbrand.widget.input.panel.e.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

final class h
  extends com.tencent.luggage.sdk.b
{
  private a.b gTI;
  
  public h(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(154853);
    this.gTI = null;
    com.tencent.luggage.g.d.a(new h.a((byte)0));
    ab.i("MicroMsg.WeChatMultiProcessInitDelegateImpl", "<init> %s", new Object[] { paramg.mProcessName });
    if ((ah.dsW()) || (ah.dsX()) || (PluginAppBrand.isAppBrandProcess()))
    {
      this.gTI = new com.tencent.mm.plugin.appbrand.luggage.a();
      com.tencent.luggage.a.e.a(p.class, new com.tencent.mm.plugin.appbrand.jsapi.file.a.a());
      AppMethodBeat.o(154853);
      return;
    }
    if (PluginAppBrand.isSupportProcess())
    {
      this.gTI = new com.tencent.mm.plugin.appbrand.luggage.b();
      AppMethodBeat.o(154853);
      return;
    }
    this.gTI = new h.1(this);
    AppMethodBeat.o(154853);
  }
  
  public final void a(com.tencent.luggage.bridge.a.a.a parama)
  {
    AppMethodBeat.i(129313);
    ab.i("MicroMsg.WeChatMultiProcessInitDelegateImpl", "onInitComponent %s", new Object[] { ah.getProcessName() });
    super.a(parama);
    this.gTI.a(parama);
    AppMethodBeat.o(129313);
  }
  
  public final void a(a.c paramc)
  {
    AppMethodBeat.i(129312);
    ab.i("MicroMsg.WeChatMultiProcessInitDelegateImpl", "onInitialize %s", new Object[] { ah.getProcessName() });
    super.a(paramc);
    this.gTI.a(paramc);
    paramc.a(s.class, new com.tencent.mm.plugin.appbrand.ui.j());
    paramc.a(com.tencent.luggage.c.a.a.class, new i());
    paramc.a(q.a.class, new com.tencent.mm.plugin.appbrand.luggage.b.h(ah.getContext()));
    paramc.a(com.tencent.mm.plugin.appbrand.jsapi.video.e.class, new com.tencent.mm.plugin.appbrand.jsapi.video.n());
    paramc.a(com.tencent.mm.plugin.appbrand.t.b.a.class, new com.tencent.luggage.f.a.a());
    paramc.a(com.tencent.mm.plugin.appbrand.o.a.class, new com.tencent.mm.plugin.appbrand.luggage.c.a());
    paramc.a(com.tencent.mm.plugin.appbrand.o.b.class, new com.tencent.mm.plugin.appbrand.luggage.c.b());
    paramc.a(com.tencent.luggage.xweb_ext.extendplugin.component.video.cache.b.class, VideoCacheServiceIPC.bId);
    paramc.a(com.tencent.mm.plugin.appbrand.widget.input.a.b.class, new com.tencent.mm.plugin.appbrand.luggage.b.e());
    paramc.a(e.b.class, new com.tencent.mm.plugin.appbrand.luggage.b.f());
    paramc.a(com.tencent.mm.plugin.appbrand.jsapi.q.a.class, new com.tencent.mm.plugin.appbrand.jsapi.q.j());
    paramc.a(com.tencent.luggage.sdk.customize.b.class, new com.tencent.mm.plugin.appbrand.luggage.b.c());
    paramc.a(com.tencent.luggage.sdk.customize.a.class, com.tencent.mm.plugin.appbrand.launching.precondition.f.ioc);
    paramc.a(x.class, new com.tencent.mm.plugin.appbrand.luggage.b.b());
    paramc.a(com.tencent.mm.plugin.appbrand.jsapi.g.a.c.class, new com.tencent.mm.plugin.appbrand.luggage.b.n());
    paramc.a(com.tencent.mm.plugin.appbrand.appstorage.n.class, com.tencent.mm.plugin.appbrand.luggage.b.a.iom);
    paramc.a(com.tencent.mm.plugin.appbrand.widget.c.b.class, new l());
    paramc.a(com.tencent.mm.plugin.appbrand.networking.a.class, com.tencent.mm.plugin.appbrand.networking.f.itR);
    AppMethodBeat.o(129312);
  }
  
  public final void vU()
  {
    AppMethodBeat.i(143061);
    super.vU();
    com.tencent.luggage.sdk.b.a.c.d.wL().a(new b.a(), com.tencent.mm.plugin.appbrand.service.b.class);
    com.tencent.luggage.sdk.b.a.c.d.wL().a(new com.tencent.luggage.game.e.a.a.a.a(), com.tencent.mm.plugin.appbrand.game.a.class);
    com.tencent.luggage.sdk.b.a.c.d.wL().a(com.tencent.luggage.sdk.b.a.c.g.bEQ, r.class);
    AppMethodBeat.o(143061);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.h
 * JD-Core Version:    0.7.0.1
 */