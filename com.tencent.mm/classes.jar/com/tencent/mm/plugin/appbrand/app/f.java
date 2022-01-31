package com.tencent.mm.plugin.appbrand.app;

import com.tencent.luggage.bridge.a.a.a;
import com.tencent.luggage.bridge.a.a.b;
import com.tencent.luggage.bridge.a.a.c;
import com.tencent.mm.plugin.appbrand.j.b.e;
import com.tencent.mm.plugin.appbrand.j.b.i;
import com.tencent.mm.plugin.appbrand.j.b.j;
import com.tencent.mm.plugin.appbrand.jsapi.video.m;
import com.tencent.mm.plugin.appbrand.u.q.a;
import com.tencent.mm.plugin.appbrand.ui.r;
import com.tencent.mm.plugin.appbrand.widget.input.panel.e.b;
import com.tencent.mm.sdk.platformtools.ae;

final class f
  extends com.tencent.luggage.g.a
{
  private a.b fBM = null;
  
  public f()
  {
    com.tencent.luggage.j.c.a(new f.a((byte)0));
    if ((ae.cqX()) || (ae.cqY()) || (PluginAppBrand.isAppBrandProcess()))
    {
      this.fBM = new com.tencent.mm.plugin.appbrand.j.a();
      return;
    }
    if (PluginAppBrand.isSupportProcess())
    {
      this.fBM = new com.tencent.mm.plugin.appbrand.j.b();
      return;
    }
    this.fBM = new f.1(this);
  }
  
  public final void a(a.a parama)
  {
    super.a(parama);
    this.fBM.a(parama);
  }
  
  public final void a(a.c paramc)
  {
    super.a(paramc);
    this.fBM.a(paramc);
    paramc.a(com.tencent.mm.plugin.appbrand.d.c.class, new e());
    paramc.a(r.class, new com.tencent.mm.plugin.appbrand.ui.h());
    paramc.a(com.tencent.luggage.d.a.a.class, new j());
    paramc.a(com.tencent.luggage.f.a.class, new com.tencent.mm.plugin.appbrand.j.b.h());
    paramc.a(q.a.class, new i(ae.getContext()));
    paramc.a(com.tencent.mm.plugin.appbrand.debugger.d.class, new com.tencent.mm.plugin.appbrand.j.b.a());
    paramc.a(com.tencent.mm.plugin.appbrand.jsapi.video.d.class, new m());
    paramc.a(com.tencent.mm.plugin.appbrand.p.a.class, new com.tencent.mm.plugin.appbrand.j.c.a());
    paramc.a(com.tencent.mm.plugin.appbrand.p.b.class, new com.tencent.mm.plugin.appbrand.j.c.b());
    paramc.a(com.tencent.mm.plugin.appbrand.widget.input.a.b.class, new com.tencent.mm.plugin.appbrand.j.b.d());
    paramc.a(e.b.class, new com.tencent.mm.plugin.appbrand.j.b.f());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.f
 * JD-Core Version:    0.7.0.1
 */