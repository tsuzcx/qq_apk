package com.tencent.luggage.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ba;
import com.tencent.mm.plugin.appbrand.jsapi.bm;
import com.tencent.mm.plugin.appbrand.jsapi.ce;
import com.tencent.mm.plugin.appbrand.jsapi.cf;
import com.tencent.mm.plugin.appbrand.jsapi.cg;
import com.tencent.mm.plugin.appbrand.jsapi.cn;
import com.tencent.mm.plugin.appbrand.jsapi.n.ad;
import com.tencent.mm.plugin.appbrand.jsapi.n.al;
import com.tencent.mm.plugin.appbrand.jsapi.n.r;
import com.tencent.mm.plugin.appbrand.jsapi.n.v;
import com.tencent.mm.plugin.appbrand.jsapi.n.x;
import com.tencent.mm.plugin.appbrand.jsapi.n.y;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoWrapper;
import com.tencent.mm.plugin.appbrand.jsapi.video.i.1;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class a
{
  protected Map<String, com.tencent.mm.plugin.appbrand.jsapi.m> cmh;
  protected Map<String, com.tencent.mm.plugin.appbrand.jsapi.m> cmi;
  
  static
  {
    AppMethodBeat.i(146678);
    cn.bjh();
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Video.LuggageVideoNonSameLayerStrategy", "init, use ExoVideoView");
    AppBrandVideoWrapper.setVideoViewFactory(new i.1());
    c.a locala = com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c.ldv;
    c.a.b(com.tencent.mm.plugin.appbrand.p.b.mce);
    com.tencent.mm.plugin.appbrand.jsapi.p.e.a(com.tencent.mm.plugin.appbrand.platform.window.h.mtP);
    AppMethodBeat.o(146678);
  }
  
  public a()
  {
    AppMethodBeat.i(146675);
    this.cmh = new HashMap();
    this.cmi = new HashMap();
    AppMethodBeat.o(146675);
  }
  
  private void a(com.tencent.mm.plugin.appbrand.jsapi.m paramm)
  {
    AppMethodBeat.i(146677);
    if ((paramm == null) || (bu.isNullOrNil(paramm.getName())))
    {
      AppMethodBeat.o(146677);
      return;
    }
    this.cmi.put(paramm.getName(), paramm);
    AppMethodBeat.o(146677);
  }
  
  public final Map<String, com.tencent.mm.plugin.appbrand.jsapi.m> DX()
  {
    AppMethodBeat.i(146676);
    a(new bm());
    a(new com.tencent.mm.plugin.appbrand.jsapi.f.h());
    a(new com.tencent.mm.plugin.appbrand.jsapi.f.c());
    a(new com.tencent.mm.plugin.appbrand.jsapi.f.b());
    a(new com.tencent.mm.plugin.appbrand.jsapi.f.i());
    a(new com.tencent.mm.plugin.appbrand.jsapi.f.d());
    a(new com.tencent.mm.plugin.appbrand.jsapi.f.j());
    a(new com.tencent.mm.plugin.appbrand.jsapi.f.e());
    a(new com.tencent.mm.plugin.appbrand.jsapi.f.f());
    a(new com.tencent.mm.plugin.appbrand.jsapi.x.j());
    a(new com.tencent.mm.plugin.appbrand.jsapi.n.g());
    a(new ce());
    a(new com.tencent.mm.plugin.appbrand.jsapi.p.f());
    a(new com.tencent.mm.plugin.appbrand.jsapi.p.h());
    a(new com.tencent.mm.plugin.appbrand.jsapi.n.c());
    a(new ba());
    a(new com.tencent.mm.plugin.appbrand.jsapi.video.d.a());
    a(new com.tencent.mm.plugin.appbrand.jsapi.video.d.e());
    a(new com.tencent.mm.plugin.appbrand.jsapi.video.d.d());
    a(new com.tencent.mm.plugin.appbrand.jsapi.video.d.c());
    a(new com.tencent.mm.plugin.appbrand.jsapi.video.d.b());
    a(new com.tencent.mm.plugin.appbrand.jsapi.a.f());
    a(new com.tencent.mm.plugin.appbrand.jsapi.a.g());
    a(new com.tencent.mm.plugin.appbrand.jsapi.a.j());
    a(new com.tencent.mm.plugin.appbrand.jsapi.a.l());
    a(new com.tencent.mm.plugin.appbrand.jsapi.n.b());
    a(new com.tencent.mm.plugin.appbrand.jsapi.autofill.e());
    a(new com.tencent.mm.plugin.appbrand.jsapi.autofill.h());
    a(new com.tencent.mm.plugin.appbrand.jsapi.autofill.b());
    a(new com.tencent.mm.plugin.appbrand.jsapi.autofill.g());
    a(new cg());
    a(new com.tencent.mm.plugin.appbrand.jsapi.x.q());
    a(new com.tencent.mm.plugin.appbrand.jsapi.container.a());
    a(new com.tencent.mm.plugin.appbrand.jsapi.container.c());
    a(new com.tencent.mm.plugin.appbrand.jsapi.container.b());
    a(new com.tencent.mm.plugin.appbrand.jsapi.autofill.d());
    a(new com.tencent.mm.plugin.appbrand.jsapi.p.g());
    a(new com.tencent.mm.plugin.appbrand.jsapi.p.i());
    a(new cf());
    a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.g());
    a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.o());
    a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.k());
    a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.e());
    a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.m());
    a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.i());
    a(new com.tencent.mm.plugin.appbrand.jsapi.camera.l());
    a(new com.tencent.mm.plugin.appbrand.jsapi.camera.p());
    a(new com.tencent.mm.plugin.appbrand.jsapi.camera.o());
    a(new com.tencent.mm.plugin.appbrand.debugger.f());
    a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.c());
    a(new com.tencent.mm.plugin.appbrand.jsapi.n.p());
    a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.f());
    a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.n());
    a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.j());
    a(new x());
    a(new v());
    a(new com.tencent.mm.plugin.appbrand.jsapi.n.ae());
    a(new com.tencent.mm.plugin.appbrand.jsapi.n.e());
    a(new r());
    a(new com.tencent.mm.plugin.appbrand.jsapi.n.q());
    Object localObject = com.tencent.mm.plugin.appbrand.jsapi.i.aj.blv();
    if (((List)localObject).size() > 0)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        a((com.tencent.mm.plugin.appbrand.jsapi.m)((Iterator)localObject).next());
      }
    }
    a(new com.tencent.mm.plugin.appbrand.jsapi.ui.e());
    a(new com.tencent.mm.plugin.appbrand.jsapi.ui.c());
    a(new ad());
    a(new com.tencent.mm.plugin.appbrand.jsapi.n.d());
    a(new com.tencent.mm.plugin.appbrand.jsapi.ui.f());
    a(new com.tencent.mm.plugin.appbrand.jsapi.ui.d());
    a(new com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.g());
    a(new com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.f());
    a(new com.tencent.mm.plugin.appbrand.jsapi.n.w());
    a(new com.tencent.mm.plugin.appbrand.jsapi.storage.d());
    a(new com.tencent.mm.plugin.appbrand.jsapi.storage.j());
    a(new com.tencent.mm.plugin.appbrand.jsapi.storage.m());
    a(new com.tencent.mm.plugin.appbrand.jsapi.storage.e());
    a(new com.tencent.mm.plugin.appbrand.jsapi.x.h());
    a(new com.tencent.mm.plugin.appbrand.jsapi.x.n());
    a(new com.tencent.mm.plugin.appbrand.jsapi.x.k());
    a(new com.tencent.mm.plugin.appbrand.jsapi.x.o());
    a(new com.tencent.mm.plugin.appbrand.jsapi.n.aj());
    a(new com.tencent.mm.plugin.appbrand.jsapi.t.b());
    a(new com.tencent.mm.plugin.appbrand.jsapi.file.w());
    a(new al());
    a(new y());
    localObject = this.cmi;
    AppMethodBeat.o(146676);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.sdk.a
 * JD-Core Version:    0.7.0.1
 */