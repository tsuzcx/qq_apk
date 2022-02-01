package com.tencent.luggage.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bk;
import com.tencent.mm.plugin.appbrand.jsapi.bz;
import com.tencent.mm.plugin.appbrand.jsapi.camera.o;
import com.tencent.mm.plugin.appbrand.jsapi.cs;
import com.tencent.mm.plugin.appbrand.jsapi.ct;
import com.tencent.mm.plugin.appbrand.jsapi.cu;
import com.tencent.mm.plugin.appbrand.jsapi.de;
import com.tencent.mm.plugin.appbrand.jsapi.file.w;
import com.tencent.mm.plugin.appbrand.jsapi.k.aj;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.p.aa;
import com.tencent.mm.plugin.appbrand.jsapi.p.ab;
import com.tencent.mm.plugin.appbrand.jsapi.p.ac;
import com.tencent.mm.plugin.appbrand.jsapi.p.ah;
import com.tencent.mm.plugin.appbrand.jsapi.p.ai;
import com.tencent.mm.plugin.appbrand.jsapi.p.an;
import com.tencent.mm.plugin.appbrand.jsapi.p.ap;
import com.tencent.mm.plugin.appbrand.jsapi.p.u;
import com.tencent.mm.plugin.appbrand.jsapi.p.v;
import com.tencent.mm.plugin.appbrand.jsapi.p.z;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoWrapper;
import com.tencent.mm.plugin.appbrand.jsapi.video.i.1;
import com.tencent.mm.plugin.appbrand.jsapi.z.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class a
{
  protected Map<String, com.tencent.mm.plugin.appbrand.jsapi.p> cyc;
  protected Map<String, com.tencent.mm.plugin.appbrand.jsapi.p> cyd;
  
  static
  {
    AppMethodBeat.i(146678);
    de.bEv();
    Log.i("MicroMsg.Video.LuggageVideoNonSameLayerStrategy", "init, use ExoVideoView");
    AppBrandVideoWrapper.setVideoViewFactory(new i.1());
    c.a locala = com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c.miO;
    c.a.b(com.tencent.mm.plugin.appbrand.t.b.njP);
    com.tencent.mm.plugin.appbrand.jsapi.r.e.a(com.tencent.mm.plugin.appbrand.platform.window.h.nEx);
    AppMethodBeat.o(146678);
  }
  
  public a()
  {
    AppMethodBeat.i(146675);
    this.cyc = new HashMap();
    this.cyd = new HashMap();
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
    this.cyd.put(paramp.getName(), paramp);
    AppMethodBeat.o(146677);
  }
  
  public final Map<String, com.tencent.mm.plugin.appbrand.jsapi.p> Nt()
  {
    AppMethodBeat.i(146676);
    a(new bz());
    a(new com.tencent.mm.plugin.appbrand.jsapi.h.h());
    a(new com.tencent.mm.plugin.appbrand.jsapi.h.c());
    a(new com.tencent.mm.plugin.appbrand.jsapi.h.b());
    a(new com.tencent.mm.plugin.appbrand.jsapi.h.i());
    a(new com.tencent.mm.plugin.appbrand.jsapi.h.d());
    a(new com.tencent.mm.plugin.appbrand.jsapi.h.j());
    a(new com.tencent.mm.plugin.appbrand.jsapi.h.e());
    a(new com.tencent.mm.plugin.appbrand.jsapi.h.f());
    a(new k());
    a(new com.tencent.mm.plugin.appbrand.jsapi.z.l());
    a(new com.tencent.mm.plugin.appbrand.jsapi.z.j());
    a(new com.tencent.mm.plugin.appbrand.jsapi.p.h());
    a(new com.tencent.mm.plugin.appbrand.jsapi.p.n());
    a(new com.tencent.mm.plugin.appbrand.jsapi.p.m());
    a(new cs());
    a(new com.tencent.mm.plugin.appbrand.jsapi.r.f());
    a(new com.tencent.mm.plugin.appbrand.jsapi.r.h());
    a(new com.tencent.mm.plugin.appbrand.jsapi.p.c());
    a(new bk());
    a(new com.tencent.mm.plugin.appbrand.jsapi.video.d.a());
    a(new com.tencent.mm.plugin.appbrand.jsapi.video.d.e());
    a(new com.tencent.mm.plugin.appbrand.jsapi.video.d.d());
    a(new com.tencent.mm.plugin.appbrand.jsapi.video.d.c());
    a(new com.tencent.mm.plugin.appbrand.jsapi.video.d.b());
    a(new com.tencent.mm.plugin.appbrand.jsapi.b.f());
    a(new com.tencent.mm.plugin.appbrand.jsapi.b.g());
    a(new com.tencent.mm.plugin.appbrand.jsapi.b.j());
    a(new com.tencent.mm.plugin.appbrand.jsapi.b.l());
    a(new com.tencent.mm.plugin.appbrand.jsapi.p.b());
    a(new com.tencent.mm.plugin.appbrand.jsapi.autofill.e());
    a(new com.tencent.mm.plugin.appbrand.jsapi.autofill.h());
    a(new com.tencent.mm.plugin.appbrand.jsapi.autofill.b());
    a(new com.tencent.mm.plugin.appbrand.jsapi.autofill.g());
    a(new cu());
    a(new com.tencent.mm.plugin.appbrand.jsapi.z.t());
    a(new com.tencent.mm.plugin.appbrand.jsapi.container.a());
    a(new com.tencent.mm.plugin.appbrand.jsapi.container.c());
    a(new com.tencent.mm.plugin.appbrand.jsapi.container.b());
    a(new com.tencent.mm.plugin.appbrand.jsapi.autofill.d());
    a(new com.tencent.mm.plugin.appbrand.jsapi.r.g());
    a(new com.tencent.mm.plugin.appbrand.jsapi.r.i());
    a(new ct());
    a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.i());
    a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.r());
    a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.n());
    a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.g());
    a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.p());
    a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.l());
    a(new com.tencent.mm.plugin.appbrand.jsapi.camera.l());
    a(new com.tencent.mm.plugin.appbrand.jsapi.camera.p());
    a(new o());
    a(new com.tencent.mm.plugin.appbrand.debugger.f());
    a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.e());
    a(new com.tencent.mm.plugin.appbrand.jsapi.p.t());
    a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.h());
    a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.q());
    a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.m());
    a(new ab());
    a(new z());
    a(new ai());
    a(new com.tencent.mm.plugin.appbrand.jsapi.p.f());
    a(new v());
    a(new u());
    Object localObject = aj.bGR();
    if (((List)localObject).size() > 0)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        a((com.tencent.mm.plugin.appbrand.jsapi.p)((Iterator)localObject).next());
      }
    }
    a(new com.tencent.mm.plugin.appbrand.jsapi.ui.d());
    a(new com.tencent.mm.plugin.appbrand.jsapi.ui.b());
    a(new ah());
    a(new com.tencent.mm.plugin.appbrand.jsapi.p.e());
    a(new com.tencent.mm.plugin.appbrand.jsapi.ui.e());
    a(new com.tencent.mm.plugin.appbrand.jsapi.ui.c());
    a(new com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.h());
    a(new com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.g());
    a(new aa());
    a(new com.tencent.mm.plugin.appbrand.jsapi.storage.d());
    a(new com.tencent.mm.plugin.appbrand.jsapi.storage.j());
    a(new com.tencent.mm.plugin.appbrand.jsapi.storage.m());
    a(new com.tencent.mm.plugin.appbrand.jsapi.storage.e());
    a(new com.tencent.mm.plugin.appbrand.jsapi.z.h());
    a(new com.tencent.mm.plugin.appbrand.jsapi.z.q());
    a(new com.tencent.mm.plugin.appbrand.jsapi.z.n());
    a(new com.tencent.mm.plugin.appbrand.jsapi.z.r());
    a(new an());
    a(new com.tencent.mm.plugin.appbrand.jsapi.v.b());
    a(new w());
    a(new ap());
    a(new ac());
    a(new com.tencent.mm.plugin.appbrand.jsapi.p.p());
    localObject = this.cyd;
    AppMethodBeat.o(146676);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.sdk.a
 * JD-Core Version:    0.7.0.1
 */