package com.tencent.luggage.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ay;
import com.tencent.mm.plugin.appbrand.jsapi.bj;
import com.tencent.mm.plugin.appbrand.jsapi.cb;
import com.tencent.mm.plugin.appbrand.jsapi.cc;
import com.tencent.mm.plugin.appbrand.jsapi.cd;
import com.tencent.mm.plugin.appbrand.jsapi.ck;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.k;
import com.tencent.mm.plugin.appbrand.jsapi.l.ab;
import com.tencent.mm.plugin.appbrand.jsapi.l.ah;
import com.tencent.mm.plugin.appbrand.jsapi.l.aj;
import com.tencent.mm.plugin.appbrand.jsapi.l.q;
import com.tencent.mm.plugin.appbrand.jsapi.l.t;
import com.tencent.mm.plugin.appbrand.jsapi.l.u;
import com.tencent.mm.plugin.appbrand.jsapi.l.v;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoWrapper;
import com.tencent.mm.plugin.appbrand.jsapi.video.i.1;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class a
{
  protected Map<String, com.tencent.mm.plugin.appbrand.jsapi.m> ceR;
  protected Map<String, com.tencent.mm.plugin.appbrand.jsapi.m> ceS;
  
  static
  {
    AppMethodBeat.i(146678);
    ck.aXX();
    ad.i("MicroMsg.Video.LuggageVideoNonSameLayerStrategy", "init, use ExoVideoView");
    AppBrandVideoWrapper.setVideoViewFactory(new i.1());
    AppMethodBeat.o(146678);
  }
  
  public a()
  {
    AppMethodBeat.i(146675);
    this.ceR = new HashMap();
    this.ceS = new HashMap();
    AppMethodBeat.o(146675);
  }
  
  private void a(com.tencent.mm.plugin.appbrand.jsapi.m paramm)
  {
    AppMethodBeat.i(146677);
    if ((paramm == null) || (bt.isNullOrNil(paramm.getName())))
    {
      AppMethodBeat.o(146677);
      return;
    }
    this.ceS.put(paramm.getName(), paramm);
    AppMethodBeat.o(146677);
  }
  
  public final Map<String, com.tencent.mm.plugin.appbrand.jsapi.m> CS()
  {
    AppMethodBeat.i(146676);
    a(new bj());
    a(new com.tencent.mm.plugin.appbrand.jsapi.d.h());
    a(new com.tencent.mm.plugin.appbrand.jsapi.d.c());
    a(new com.tencent.mm.plugin.appbrand.jsapi.d.b());
    a(new com.tencent.mm.plugin.appbrand.jsapi.d.i());
    a(new com.tencent.mm.plugin.appbrand.jsapi.d.d());
    a(new com.tencent.mm.plugin.appbrand.jsapi.d.j());
    a(new com.tencent.mm.plugin.appbrand.jsapi.d.e());
    a(new com.tencent.mm.plugin.appbrand.jsapi.d.f());
    a(new com.tencent.mm.plugin.appbrand.jsapi.v.i());
    a(new com.tencent.mm.plugin.appbrand.jsapi.l.f());
    a(new cb());
    a(new com.tencent.mm.plugin.appbrand.jsapi.n.f());
    a(new com.tencent.mm.plugin.appbrand.jsapi.n.h());
    a(new com.tencent.mm.plugin.appbrand.jsapi.l.b());
    a(new ay());
    a(new com.tencent.mm.plugin.appbrand.jsapi.video.d.a());
    a(new com.tencent.mm.plugin.appbrand.jsapi.video.d.e());
    a(new com.tencent.mm.plugin.appbrand.jsapi.video.d.d());
    a(new com.tencent.mm.plugin.appbrand.jsapi.video.d.c());
    a(new com.tencent.mm.plugin.appbrand.jsapi.video.d.b());
    a(new com.tencent.mm.plugin.appbrand.jsapi.b.f());
    a(new com.tencent.mm.plugin.appbrand.jsapi.b.g());
    a(new com.tencent.mm.plugin.appbrand.jsapi.b.j());
    a(new com.tencent.mm.plugin.appbrand.jsapi.b.l());
    a(new com.tencent.mm.plugin.appbrand.jsapi.l.a());
    a(new com.tencent.mm.plugin.appbrand.jsapi.a.d());
    a(new com.tencent.mm.plugin.appbrand.jsapi.a.g());
    a(new com.tencent.mm.plugin.appbrand.jsapi.a.b());
    a(new com.tencent.mm.plugin.appbrand.jsapi.a.f());
    a(new cd());
    a(new com.tencent.mm.plugin.appbrand.jsapi.v.p());
    a(new com.tencent.mm.plugin.appbrand.jsapi.container.a());
    a(new com.tencent.mm.plugin.appbrand.jsapi.container.c());
    a(new com.tencent.mm.plugin.appbrand.jsapi.container.b());
    a(new com.tencent.mm.plugin.appbrand.jsapi.a.c());
    a(new com.tencent.mm.plugin.appbrand.jsapi.n.g());
    a(new com.tencent.mm.plugin.appbrand.jsapi.n.i());
    a(new cc());
    a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.g());
    a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.o());
    a(new k());
    a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.e());
    a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.m());
    a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.i());
    a(new com.tencent.mm.plugin.appbrand.jsapi.camera.l());
    a(new com.tencent.mm.plugin.appbrand.jsapi.camera.p());
    a(new com.tencent.mm.plugin.appbrand.jsapi.camera.o());
    a(new com.tencent.mm.plugin.appbrand.debugger.e());
    a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.c());
    a(new com.tencent.mm.plugin.appbrand.jsapi.l.o());
    a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.f());
    a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.n());
    a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.j());
    a(new v());
    a(new t());
    a(new com.tencent.mm.plugin.appbrand.jsapi.l.ac());
    a(new com.tencent.mm.plugin.appbrand.jsapi.l.d());
    a(new q());
    a(new com.tencent.mm.plugin.appbrand.jsapi.l.p());
    Object localObject = com.tencent.mm.plugin.appbrand.jsapi.g.ac.ban();
    if (((List)localObject).size() > 0)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        a((com.tencent.mm.plugin.appbrand.jsapi.m)((Iterator)localObject).next());
      }
    }
    a(new com.tencent.mm.plugin.appbrand.jsapi.ui.e());
    a(new com.tencent.mm.plugin.appbrand.jsapi.ui.c());
    a(new ab());
    a(new com.tencent.mm.plugin.appbrand.jsapi.l.c());
    a(new com.tencent.mm.plugin.appbrand.jsapi.ui.f());
    a(new com.tencent.mm.plugin.appbrand.jsapi.ui.d());
    a(new com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.g());
    a(new com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.f());
    a(new u());
    a(new com.tencent.mm.plugin.appbrand.jsapi.storage.d());
    a(new com.tencent.mm.plugin.appbrand.jsapi.storage.j());
    a(new com.tencent.mm.plugin.appbrand.jsapi.storage.m());
    a(new com.tencent.mm.plugin.appbrand.jsapi.storage.e());
    a(new com.tencent.mm.plugin.appbrand.jsapi.v.g());
    a(new com.tencent.mm.plugin.appbrand.jsapi.v.m());
    a(new com.tencent.mm.plugin.appbrand.jsapi.v.j());
    a(new com.tencent.mm.plugin.appbrand.jsapi.v.n());
    a(new ah());
    a(new com.tencent.mm.plugin.appbrand.jsapi.r.b());
    a(new com.tencent.mm.plugin.appbrand.jsapi.file.w());
    a(new aj());
    a(new com.tencent.mm.plugin.appbrand.jsapi.l.w());
    localObject = this.ceS;
    AppMethodBeat.o(146676);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.sdk.a
 * JD-Core Version:    0.7.0.1
 */