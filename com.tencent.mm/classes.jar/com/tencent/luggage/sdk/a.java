package com.tencent.luggage.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ay;
import com.tencent.mm.plugin.appbrand.jsapi.bj;
import com.tencent.mm.plugin.appbrand.jsapi.cb;
import com.tencent.mm.plugin.appbrand.jsapi.cc;
import com.tencent.mm.plugin.appbrand.jsapi.cd;
import com.tencent.mm.plugin.appbrand.jsapi.ck;
import com.tencent.mm.plugin.appbrand.jsapi.f.ad;
import com.tencent.mm.plugin.appbrand.jsapi.k.ab;
import com.tencent.mm.plugin.appbrand.jsapi.k.ah;
import com.tencent.mm.plugin.appbrand.jsapi.k.aj;
import com.tencent.mm.plugin.appbrand.jsapi.k.t;
import com.tencent.mm.plugin.appbrand.jsapi.k.u;
import com.tencent.mm.plugin.appbrand.jsapi.k.v;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoWrapper;
import com.tencent.mm.plugin.appbrand.jsapi.video.m.1;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class a
{
  protected Map<String, com.tencent.mm.plugin.appbrand.jsapi.m> cbO;
  protected Map<String, com.tencent.mm.plugin.appbrand.jsapi.m> cbP;
  
  static
  {
    AppMethodBeat.i(146678);
    ck.beU();
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Video.LuggageVideoNonSameLayerStrategy", "init, use ExoVideoView");
    AppBrandVideoWrapper.setVideoViewFactory(new m.1());
    AppMethodBeat.o(146678);
  }
  
  public a()
  {
    AppMethodBeat.i(146675);
    this.cbO = new HashMap();
    this.cbP = new HashMap();
    AppMethodBeat.o(146675);
  }
  
  private void a(com.tencent.mm.plugin.appbrand.jsapi.m paramm)
  {
    AppMethodBeat.i(146677);
    if ((paramm == null) || (bs.isNullOrNil(paramm.getName())))
    {
      AppMethodBeat.o(146677);
      return;
    }
    this.cbP.put(paramm.getName(), paramm);
    AppMethodBeat.o(146677);
  }
  
  public final Map<String, com.tencent.mm.plugin.appbrand.jsapi.m> Cv()
  {
    AppMethodBeat.i(146676);
    a(new bj());
    a(new com.tencent.mm.plugin.appbrand.jsapi.c.h());
    a(new com.tencent.mm.plugin.appbrand.jsapi.c.c());
    a(new com.tencent.mm.plugin.appbrand.jsapi.c.b());
    a(new com.tencent.mm.plugin.appbrand.jsapi.c.i());
    a(new com.tencent.mm.plugin.appbrand.jsapi.c.d());
    a(new com.tencent.mm.plugin.appbrand.jsapi.c.j());
    a(new com.tencent.mm.plugin.appbrand.jsapi.c.e());
    a(new com.tencent.mm.plugin.appbrand.jsapi.c.f());
    a(new com.tencent.mm.plugin.appbrand.jsapi.u.j());
    a(new com.tencent.mm.plugin.appbrand.jsapi.k.f());
    a(new cb());
    a(new com.tencent.mm.plugin.appbrand.jsapi.m.f());
    a(new com.tencent.mm.plugin.appbrand.jsapi.m.h());
    a(new com.tencent.mm.plugin.appbrand.jsapi.k.b());
    a(new ay());
    a(new com.tencent.mm.plugin.appbrand.jsapi.video.d.a());
    a(new com.tencent.mm.plugin.appbrand.jsapi.video.d.e());
    a(new com.tencent.mm.plugin.appbrand.jsapi.video.d.d());
    a(new com.tencent.mm.plugin.appbrand.jsapi.video.d.c());
    a(new com.tencent.mm.plugin.appbrand.jsapi.video.d.b());
    a(new com.tencent.mm.plugin.appbrand.jsapi.a.f());
    a(new com.tencent.mm.plugin.appbrand.jsapi.a.g());
    a(new com.tencent.mm.plugin.appbrand.jsapi.a.j());
    a(new com.tencent.mm.plugin.appbrand.jsapi.a.l());
    a(new com.tencent.mm.plugin.appbrand.jsapi.k.a());
    a(new com.tencent.mm.plugin.appbrand.jsapi.autofill.e());
    a(new com.tencent.mm.plugin.appbrand.jsapi.autofill.h());
    a(new com.tencent.mm.plugin.appbrand.jsapi.autofill.b());
    a(new com.tencent.mm.plugin.appbrand.jsapi.autofill.g());
    a(new cd());
    a(new com.tencent.mm.plugin.appbrand.jsapi.u.q());
    a(new com.tencent.mm.plugin.appbrand.jsapi.container.a());
    a(new com.tencent.mm.plugin.appbrand.jsapi.container.c());
    a(new com.tencent.mm.plugin.appbrand.jsapi.container.b());
    a(new com.tencent.mm.plugin.appbrand.jsapi.autofill.d());
    a(new com.tencent.mm.plugin.appbrand.jsapi.m.g());
    a(new com.tencent.mm.plugin.appbrand.jsapi.m.i());
    a(new cc());
    a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.g());
    a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.o());
    a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.k());
    a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.e());
    a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.m());
    a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.i());
    a(new com.tencent.mm.plugin.appbrand.jsapi.camera.l());
    a(new com.tencent.mm.plugin.appbrand.jsapi.camera.p());
    a(new com.tencent.mm.plugin.appbrand.jsapi.camera.o());
    a(new com.tencent.mm.plugin.appbrand.debugger.e());
    a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.c());
    a(new com.tencent.mm.plugin.appbrand.jsapi.k.o());
    a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.f());
    a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.n());
    a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.j());
    a(new v());
    a(new t());
    a(new com.tencent.mm.plugin.appbrand.jsapi.k.ac());
    a(new com.tencent.mm.plugin.appbrand.jsapi.k.d());
    a(new com.tencent.mm.plugin.appbrand.jsapi.k.q());
    a(new com.tencent.mm.plugin.appbrand.jsapi.k.p());
    Object localObject = ad.bhg();
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
    a(new com.tencent.mm.plugin.appbrand.jsapi.k.c());
    a(new com.tencent.mm.plugin.appbrand.jsapi.ui.f());
    a(new com.tencent.mm.plugin.appbrand.jsapi.ui.d());
    a(new com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.g());
    a(new com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.f());
    a(new u());
    a(new com.tencent.mm.plugin.appbrand.jsapi.storage.d());
    a(new com.tencent.mm.plugin.appbrand.jsapi.storage.j());
    a(new com.tencent.mm.plugin.appbrand.jsapi.storage.m());
    a(new com.tencent.mm.plugin.appbrand.jsapi.storage.e());
    a(new com.tencent.mm.plugin.appbrand.jsapi.u.h());
    a(new com.tencent.mm.plugin.appbrand.jsapi.u.n());
    a(new com.tencent.mm.plugin.appbrand.jsapi.u.k());
    a(new com.tencent.mm.plugin.appbrand.jsapi.u.o());
    a(new ah());
    a(new com.tencent.mm.plugin.appbrand.jsapi.q.b());
    a(new com.tencent.mm.plugin.appbrand.jsapi.file.w());
    a(new aj());
    a(new com.tencent.mm.plugin.appbrand.jsapi.k.w());
    localObject = this.cbP;
    AppMethodBeat.o(146676);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.sdk.a
 * JD-Core Version:    0.7.0.1
 */