package com.tencent.luggage.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ae.o;
import com.tencent.mm.plugin.appbrand.jsapi.ae.s;
import com.tencent.mm.plugin.appbrand.jsapi.ae.x;
import com.tencent.mm.plugin.appbrand.jsapi.bi;
import com.tencent.mm.plugin.appbrand.jsapi.bj;
import com.tencent.mm.plugin.appbrand.jsapi.bk;
import com.tencent.mm.plugin.appbrand.jsapi.cc;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.r;
import com.tencent.mm.plugin.appbrand.jsapi.db;
import com.tencent.mm.plugin.appbrand.jsapi.dc;
import com.tencent.mm.plugin.appbrand.jsapi.dd;
import com.tencent.mm.plugin.appbrand.jsapi.do;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.g.a;
import com.tencent.mm.plugin.appbrand.jsapi.o.ap;
import com.tencent.mm.plugin.appbrand.jsapi.storage.k;
import com.tencent.mm.plugin.appbrand.jsapi.t.aa;
import com.tencent.mm.plugin.appbrand.jsapi.t.ab;
import com.tencent.mm.plugin.appbrand.jsapi.t.ac;
import com.tencent.mm.plugin.appbrand.jsapi.t.ai;
import com.tencent.mm.plugin.appbrand.jsapi.t.aj;
import com.tencent.mm.plugin.appbrand.jsapi.t.ao;
import com.tencent.mm.plugin.appbrand.jsapi.t.aq;
import com.tencent.mm.plugin.appbrand.jsapi.t.t;
import com.tencent.mm.plugin.appbrand.jsapi.t.u;
import com.tencent.mm.plugin.appbrand.jsapi.t.v;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoWrapper;
import com.tencent.mm.plugin.appbrand.jsapi.video.h.1;
import com.tencent.mm.plugin.appbrand.utils.au;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class a
{
  protected Map<String, com.tencent.mm.plugin.appbrand.jsapi.p> eoF;
  protected Map<String, com.tencent.mm.plugin.appbrand.jsapi.p> eoG;
  
  static
  {
    AppMethodBeat.i(146678);
    do.cpZ();
    Log.i("MicroMsg.Video.LuggageVideoNonSameLayerStrategy", "init, use ExoVideoView");
    AppBrandVideoWrapper.setVideoViewFactory(new h.1());
    g.a locala = com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.g.smq;
    g.a.b(com.tencent.mm.plugin.appbrand.u.c.tql);
    com.tencent.mm.plugin.appbrand.jsapi.v.e.a(com.tencent.mm.plugin.appbrand.platform.window.h.tLs);
    com.tencent.luggage.a.e.a(com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.f.class, com.tencent.luggage.sdk.customize.impl.b.eqx);
    com.tencent.luggage.a.e.a(com.tencent.mm.plugin.appbrand.jsapi.y.a.class, au.urR);
    AppMethodBeat.o(146678);
  }
  
  public a()
  {
    AppMethodBeat.i(146675);
    this.eoF = new HashMap();
    this.eoG = new HashMap();
    AppMethodBeat.o(146675);
  }
  
  private void a(com.tencent.mm.plugin.appbrand.jsapi.p paramp)
  {
    AppMethodBeat.i(146677);
    if ((paramp == null) || (Util.isNullOrNil(paramp.getName())))
    {
      AppMethodBeat.o(146677);
      return;
    }
    this.eoG.put(paramp.getName(), paramp);
    AppMethodBeat.o(146677);
  }
  
  public final Map<String, com.tencent.mm.plugin.appbrand.jsapi.p> aqy()
  {
    AppMethodBeat.i(146676);
    a(new cc());
    a(new com.tencent.mm.plugin.appbrand.jsapi.l.h());
    a(new com.tencent.mm.plugin.appbrand.jsapi.l.c());
    a(new com.tencent.mm.plugin.appbrand.jsapi.l.b());
    a(new com.tencent.mm.plugin.appbrand.jsapi.l.i());
    a(new com.tencent.mm.plugin.appbrand.jsapi.l.d());
    a(new com.tencent.mm.plugin.appbrand.jsapi.l.j());
    a(new com.tencent.mm.plugin.appbrand.jsapi.l.e());
    a(new com.tencent.mm.plugin.appbrand.jsapi.l.f());
    a(new com.tencent.mm.plugin.appbrand.jsapi.ae.p());
    a(new com.tencent.mm.plugin.appbrand.jsapi.ae.q());
    a(new o());
    a(new com.tencent.mm.plugin.appbrand.jsapi.ae.l());
    a(new com.tencent.mm.plugin.appbrand.jsapi.t.h());
    a(new com.tencent.mm.plugin.appbrand.jsapi.t.n());
    a(new com.tencent.mm.plugin.appbrand.jsapi.t.m());
    a(new db());
    a(new com.tencent.mm.plugin.appbrand.jsapi.v.f());
    a(new com.tencent.mm.plugin.appbrand.jsapi.v.h());
    a(new com.tencent.mm.plugin.appbrand.jsapi.t.c());
    a(new bk());
    a(new com.tencent.mm.plugin.appbrand.jsapi.video.d.a());
    a(new com.tencent.mm.plugin.appbrand.jsapi.video.d.e());
    a(new com.tencent.mm.plugin.appbrand.jsapi.video.d.d());
    a(new com.tencent.mm.plugin.appbrand.jsapi.video.d.c());
    a(new com.tencent.mm.plugin.appbrand.jsapi.video.d.b());
    a(new com.tencent.mm.plugin.appbrand.jsapi.c.f());
    a(new com.tencent.mm.plugin.appbrand.jsapi.c.g());
    a(new com.tencent.mm.plugin.appbrand.jsapi.c.j());
    a(new com.tencent.mm.plugin.appbrand.jsapi.c.l());
    a(new com.tencent.mm.plugin.appbrand.jsapi.t.b());
    a(new com.tencent.mm.plugin.appbrand.jsapi.autofill.f());
    a(new com.tencent.mm.plugin.appbrand.jsapi.autofill.i());
    a(new com.tencent.mm.plugin.appbrand.jsapi.autofill.b());
    a(new com.tencent.mm.plugin.appbrand.jsapi.autofill.h());
    a(new dd());
    a(new com.tencent.mm.plugin.appbrand.jsapi.ae.z());
    a(new com.tencent.mm.plugin.appbrand.jsapi.container.a());
    a(new com.tencent.mm.plugin.appbrand.jsapi.container.c());
    a(new com.tencent.mm.plugin.appbrand.jsapi.container.b());
    a(new com.tencent.mm.plugin.appbrand.jsapi.autofill.d());
    a(new com.tencent.mm.plugin.appbrand.jsapi.v.g());
    a(new com.tencent.mm.plugin.appbrand.jsapi.v.i());
    a(new dc());
    a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.i());
    a(new r());
    a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.n());
    a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.g());
    a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.p());
    a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.l());
    a(new com.tencent.mm.plugin.appbrand.jsapi.camera.l());
    a(new com.tencent.mm.plugin.appbrand.jsapi.camera.q());
    a(new com.tencent.mm.plugin.appbrand.jsapi.camera.p());
    a(new com.tencent.mm.plugin.appbrand.debugger.g());
    a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.e());
    a(new t());
    a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.h());
    a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.q());
    a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.m());
    a(new ab());
    a(new com.tencent.mm.plugin.appbrand.jsapi.t.z());
    a(new aj());
    a(new com.tencent.mm.plugin.appbrand.jsapi.t.f());
    a(new v());
    a(new u());
    Object localObject = ap.csG();
    if ((localObject == null) || (((List)localObject).size() <= 0)) {}
    for (;;)
    {
      a(new com.tencent.mm.plugin.appbrand.jsapi.ui.d());
      a(new com.tencent.mm.plugin.appbrand.jsapi.ui.b());
      a(new ai());
      a(new com.tencent.mm.plugin.appbrand.jsapi.t.e());
      a(new com.tencent.mm.plugin.appbrand.jsapi.ui.e());
      a(new com.tencent.mm.plugin.appbrand.jsapi.ui.c());
      a(new com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.h());
      a(new com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.g());
      a(new aa());
      a(new com.tencent.mm.plugin.appbrand.jsapi.storage.d());
      a(new k());
      a(new com.tencent.mm.plugin.appbrand.jsapi.storage.n());
      a(new com.tencent.mm.plugin.appbrand.jsapi.storage.e());
      a(new com.tencent.mm.plugin.appbrand.jsapi.ae.m());
      a(new com.tencent.mm.plugin.appbrand.jsapi.ae.w());
      a(new s());
      a(new x());
      a(new ao());
      a(new com.tencent.mm.plugin.appbrand.jsapi.z.b());
      a(new com.tencent.mm.plugin.appbrand.jsapi.file.w());
      a(new aq());
      a(new ac());
      a(new com.tencent.mm.plugin.appbrand.jsapi.t.p());
      a(new bi());
      a(new bj());
      localObject = this.eoG;
      AppMethodBeat.o(146676);
      return localObject;
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        a((com.tencent.mm.plugin.appbrand.jsapi.p)((Iterator)localObject).next());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.sdk.a
 * JD-Core Version:    0.7.0.1
 */