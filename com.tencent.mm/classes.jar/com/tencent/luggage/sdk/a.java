package com.tencent.luggage.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ab.k;
import com.tencent.mm.plugin.appbrand.jsapi.ab.s;
import com.tencent.mm.plugin.appbrand.jsapi.bh;
import com.tencent.mm.plugin.appbrand.jsapi.by;
import com.tencent.mm.plugin.appbrand.jsapi.ct;
import com.tencent.mm.plugin.appbrand.jsapi.cu;
import com.tencent.mm.plugin.appbrand.jsapi.cv;
import com.tencent.mm.plugin.appbrand.jsapi.dg;
import com.tencent.mm.plugin.appbrand.jsapi.file.w;
import com.tencent.mm.plugin.appbrand.jsapi.l.ak;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.q.aa;
import com.tencent.mm.plugin.appbrand.jsapi.q.ab;
import com.tencent.mm.plugin.appbrand.jsapi.q.ac;
import com.tencent.mm.plugin.appbrand.jsapi.q.ah;
import com.tencent.mm.plugin.appbrand.jsapi.q.ai;
import com.tencent.mm.plugin.appbrand.jsapi.q.ap;
import com.tencent.mm.plugin.appbrand.jsapi.q.t;
import com.tencent.mm.plugin.appbrand.jsapi.q.v;
import com.tencent.mm.plugin.appbrand.jsapi.q.z;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoWrapper;
import com.tencent.mm.plugin.appbrand.jsapi.video.h.1;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class a
{
  protected Map<String, com.tencent.mm.plugin.appbrand.jsapi.o> cwF;
  protected Map<String, com.tencent.mm.plugin.appbrand.jsapi.o> cwG;
  
  static
  {
    AppMethodBeat.i(146678);
    dg.bPV();
    Log.i("MicroMsg.Video.LuggageVideoNonSameLayerStrategy", "init, use ExoVideoView");
    AppBrandVideoWrapper.setVideoViewFactory(new h.1());
    c.a locala = com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c.pgQ;
    c.a.b(com.tencent.mm.plugin.appbrand.t.b.qln);
    com.tencent.mm.plugin.appbrand.jsapi.s.e.a(com.tencent.mm.plugin.appbrand.platform.window.h.qGH);
    com.tencent.luggage.a.e.a(com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.f.class, com.tencent.luggage.sdk.customize.impl.b.cya);
    com.tencent.luggage.a.e.a(com.tencent.mm.plugin.appbrand.jsapi.v.a.class, com.tencent.mm.plugin.appbrand.utils.an.rjy);
    AppMethodBeat.o(146678);
  }
  
  public a()
  {
    AppMethodBeat.i(146675);
    this.cwF = new HashMap();
    this.cwG = new HashMap();
    AppMethodBeat.o(146675);
  }
  
  private void a(com.tencent.mm.plugin.appbrand.jsapi.o paramo)
  {
    AppMethodBeat.i(146677);
    if ((paramo == null) || (Util.isNullOrNil(paramo.getName())))
    {
      AppMethodBeat.o(146677);
      return;
    }
    this.cwG.put(paramo.getName(), paramo);
    AppMethodBeat.o(146677);
  }
  
  public final Map<String, com.tencent.mm.plugin.appbrand.jsapi.o> Qo()
  {
    AppMethodBeat.i(146676);
    a(new by());
    a(new com.tencent.mm.plugin.appbrand.jsapi.i.h());
    a(new com.tencent.mm.plugin.appbrand.jsapi.i.c());
    a(new com.tencent.mm.plugin.appbrand.jsapi.i.b());
    a(new com.tencent.mm.plugin.appbrand.jsapi.i.i());
    a(new com.tencent.mm.plugin.appbrand.jsapi.i.d());
    a(new com.tencent.mm.plugin.appbrand.jsapi.i.j());
    a(new com.tencent.mm.plugin.appbrand.jsapi.i.e());
    a(new com.tencent.mm.plugin.appbrand.jsapi.i.f());
    a(new com.tencent.mm.plugin.appbrand.jsapi.ab.l());
    a(new com.tencent.mm.plugin.appbrand.jsapi.ab.m());
    a(new k());
    a(new com.tencent.mm.plugin.appbrand.jsapi.q.h());
    a(new com.tencent.mm.plugin.appbrand.jsapi.q.n());
    a(new com.tencent.mm.plugin.appbrand.jsapi.q.m());
    a(new ct());
    a(new com.tencent.mm.plugin.appbrand.jsapi.s.f());
    a(new com.tencent.mm.plugin.appbrand.jsapi.s.h());
    a(new com.tencent.mm.plugin.appbrand.jsapi.q.c());
    a(new bh());
    a(new com.tencent.mm.plugin.appbrand.jsapi.video.d.a());
    a(new com.tencent.mm.plugin.appbrand.jsapi.video.d.e());
    a(new com.tencent.mm.plugin.appbrand.jsapi.video.d.d());
    a(new com.tencent.mm.plugin.appbrand.jsapi.video.d.c());
    a(new com.tencent.mm.plugin.appbrand.jsapi.video.d.b());
    a(new com.tencent.mm.plugin.appbrand.jsapi.b.f());
    a(new com.tencent.mm.plugin.appbrand.jsapi.b.g());
    a(new com.tencent.mm.plugin.appbrand.jsapi.b.j());
    a(new com.tencent.mm.plugin.appbrand.jsapi.b.l());
    a(new com.tencent.mm.plugin.appbrand.jsapi.q.b());
    a(new com.tencent.mm.plugin.appbrand.jsapi.autofill.f());
    a(new com.tencent.mm.plugin.appbrand.jsapi.autofill.i());
    a(new com.tencent.mm.plugin.appbrand.jsapi.autofill.b());
    a(new com.tencent.mm.plugin.appbrand.jsapi.autofill.h());
    a(new cv());
    a(new com.tencent.mm.plugin.appbrand.jsapi.ab.u());
    a(new com.tencent.mm.plugin.appbrand.jsapi.container.a());
    a(new com.tencent.mm.plugin.appbrand.jsapi.container.c());
    a(new com.tencent.mm.plugin.appbrand.jsapi.container.b());
    a(new com.tencent.mm.plugin.appbrand.jsapi.autofill.d());
    a(new com.tencent.mm.plugin.appbrand.jsapi.s.g());
    a(new com.tencent.mm.plugin.appbrand.jsapi.s.i());
    a(new cu());
    a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.i());
    a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.r());
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
    a(new z());
    a(new ai());
    a(new com.tencent.mm.plugin.appbrand.jsapi.q.f());
    a(new v());
    a(new com.tencent.mm.plugin.appbrand.jsapi.q.u());
    Object localObject = ak.bSz();
    if (((List)localObject).size() > 0)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        a((com.tencent.mm.plugin.appbrand.jsapi.o)((Iterator)localObject).next());
      }
    }
    a(new com.tencent.mm.plugin.appbrand.jsapi.ui.d());
    a(new com.tencent.mm.plugin.appbrand.jsapi.ui.b());
    a(new ah());
    a(new com.tencent.mm.plugin.appbrand.jsapi.q.e());
    a(new com.tencent.mm.plugin.appbrand.jsapi.ui.e());
    a(new com.tencent.mm.plugin.appbrand.jsapi.ui.c());
    a(new com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.h());
    a(new com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.g());
    a(new aa());
    a(new com.tencent.mm.plugin.appbrand.jsapi.storage.d());
    a(new com.tencent.mm.plugin.appbrand.jsapi.storage.j());
    a(new com.tencent.mm.plugin.appbrand.jsapi.storage.m());
    a(new com.tencent.mm.plugin.appbrand.jsapi.storage.e());
    a(new com.tencent.mm.plugin.appbrand.jsapi.ab.i());
    a(new com.tencent.mm.plugin.appbrand.jsapi.ab.r());
    a(new com.tencent.mm.plugin.appbrand.jsapi.ab.o());
    a(new s());
    a(new com.tencent.mm.plugin.appbrand.jsapi.q.an());
    a(new com.tencent.mm.plugin.appbrand.jsapi.w.b());
    a(new w());
    a(new ap());
    a(new ac());
    a(new com.tencent.mm.plugin.appbrand.jsapi.q.p());
    localObject = this.cwG;
    AppMethodBeat.o(146676);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.sdk.a
 * JD-Core Version:    0.7.0.1
 */