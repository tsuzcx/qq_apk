package com.tencent.luggage.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiWriteCommData;
import com.tencent.mm.plugin.appbrand.jsapi.an;
import com.tencent.mm.plugin.appbrand.jsapi.ao;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiGetInstallState;
import com.tencent.mm.plugin.appbrand.jsapi.aq;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.plugin.appbrand.jsapi.at;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetMusicPlayerState;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateBackgroundAudio;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.ba;
import com.tencent.mm.plugin.appbrand.jsapi.be;
import com.tencent.mm.plugin.appbrand.jsapi.bio.soter.JsApiLuggageCheckBioEnrollment;
import com.tencent.mm.plugin.appbrand.jsapi.bio.soter.JsApiLuggageCheckIsSupportSoterAuthentication;
import com.tencent.mm.plugin.appbrand.jsapi.bj;
import com.tencent.mm.plugin.appbrand.jsapi.bn;
import com.tencent.mm.plugin.appbrand.jsapi.bp;
import com.tencent.mm.plugin.appbrand.jsapi.bq;
import com.tencent.mm.plugin.appbrand.jsapi.br;
import com.tencent.mm.plugin.appbrand.jsapi.bv;
import com.tencent.mm.plugin.appbrand.jsapi.file.ah;
import com.tencent.mm.plugin.appbrand.jsapi.file.ai;
import com.tencent.mm.plugin.appbrand.jsapi.file.aj;
import com.tencent.mm.plugin.appbrand.jsapi.file.al;
import com.tencent.mm.plugin.appbrand.jsapi.file.am;
import com.tencent.mm.plugin.soter.ui.SoterAuthenticationUI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class a
{
  protected Map<String, com.tencent.mm.plugin.appbrand.jsapi.m> bCN;
  protected Map<String, com.tencent.mm.plugin.appbrand.jsapi.m> bCO;
  
  static
  {
    AppMethodBeat.i(140674);
    bv.aBH();
    AppMethodBeat.o(140674);
  }
  
  public a()
  {
    AppMethodBeat.i(140669);
    this.bCN = new HashMap();
    this.bCO = new HashMap();
    AppMethodBeat.o(140669);
  }
  
  private void a(com.tencent.mm.plugin.appbrand.jsapi.m paramm)
  {
    AppMethodBeat.i(140672);
    if ((paramm == null) || (com.tencent.mm.sdk.platformtools.bo.isNullOrNil(paramm.getName())))
    {
      AppMethodBeat.o(140672);
      return;
    }
    this.bCN.put(paramm.getName(), paramm);
    AppMethodBeat.o(140672);
  }
  
  private void b(com.tencent.mm.plugin.appbrand.jsapi.m paramm)
  {
    AppMethodBeat.i(140673);
    if ((paramm == null) || (com.tencent.mm.sdk.platformtools.bo.isNullOrNil(paramm.getName())))
    {
      AppMethodBeat.o(140673);
      return;
    }
    this.bCO.put(paramm.getName(), paramm);
    AppMethodBeat.o(140673);
  }
  
  public final Map<String, com.tencent.mm.plugin.appbrand.jsapi.m> vS()
  {
    AppMethodBeat.i(140670);
    a(new com.tencent.mm.plugin.appbrand.jsapi.storage.a());
    a(new com.tencent.mm.plugin.appbrand.jsapi.storage.f());
    a(new com.tencent.mm.plugin.appbrand.jsapi.storage.n());
    a(new com.tencent.mm.plugin.appbrand.jsapi.storage.b());
    a(new com.tencent.mm.plugin.appbrand.jsapi.storage.i());
    a(new com.tencent.mm.plugin.appbrand.jsapi.storage.o());
    a(new com.tencent.mm.plugin.appbrand.jsapi.l.s());
    a(new com.tencent.mm.plugin.appbrand.jsapi.l.h());
    a(new com.tencent.mm.plugin.appbrand.jsapi.l.l());
    a(new com.tencent.mm.plugin.appbrand.jsapi.l.g());
    a(new bj());
    a(new com.tencent.mm.plugin.appbrand.jsapi.media.g());
    a(new com.tencent.mm.plugin.appbrand.jsapi.t.a.h());
    a(new com.tencent.mm.plugin.appbrand.jsapi.t.a.i());
    a(new com.tencent.mm.plugin.appbrand.jsapi.t.e());
    a(new com.tencent.mm.plugin.appbrand.jsapi.t.d());
    a(new com.tencent.mm.plugin.appbrand.jsapi.t.f());
    a(new com.tencent.mm.plugin.appbrand.jsapi.e.i());
    a(new com.tencent.mm.plugin.appbrand.jsapi.r.e());
    a(new JsApiGetMusicPlayerState());
    a(new com.tencent.mm.plugin.appbrand.jsapi.contact.c());
    a(new com.tencent.mm.plugin.appbrand.jsapi.contact.g());
    a(new com.tencent.mm.plugin.appbrand.jsapi.l.ac());
    a(new com.tencent.mm.plugin.appbrand.jsapi.l.z());
    a(new com.tencent.mm.plugin.appbrand.jsapi.l.d());
    a(new com.tencent.mm.plugin.appbrand.jsapi.l.y());
    a(new com.tencent.mm.plugin.appbrand.jsapi.l.c());
    a(new com.tencent.mm.plugin.appbrand.jsapi.b.e());
    a(new ar());
    a(new com.tencent.mm.plugin.appbrand.jsapi.bo());
    a(new com.tencent.mm.plugin.appbrand.jsapi.d.g());
    a(new ao());
    a(new com.tencent.mm.plugin.appbrand.jsapi.d.c());
    a(new com.tencent.mm.plugin.appbrand.jsapi.q.b());
    a(new com.tencent.mm.plugin.appbrand.jsapi.q.c());
    a(new com.tencent.mm.plugin.appbrand.jsapi.q.f());
    a(new com.tencent.mm.plugin.appbrand.jsapi.q.d());
    a(new com.tencent.mm.plugin.appbrand.jsapi.q.e());
    a(new com.tencent.mm.plugin.appbrand.jsapi.storage.k());
    a(new com.tencent.mm.plugin.appbrand.jsapi.storage.l());
    a(new com.tencent.mm.plugin.appbrand.jsapi.b.c());
    a(new com.tencent.mm.plugin.appbrand.jsapi.b.d());
    a(new com.tencent.mm.plugin.appbrand.jsapi.o.c());
    a(new com.tencent.mm.plugin.appbrand.jsapi.o.b());
    a(new com.tencent.mm.plugin.appbrand.jsapi.o.d());
    a(new com.tencent.mm.plugin.appbrand.jsapi.o.a());
    a(new at());
    a(new com.tencent.mm.plugin.appbrand.jsapi.storage.g());
    a(new com.tencent.mm.plugin.appbrand.jsapi.storage.h());
    a(new com.tencent.mm.plugin.appbrand.jsapi.media.h());
    a(new com.tencent.mm.plugin.appbrand.jsapi.l.ad());
    a(new com.tencent.mm.plugin.appbrand.jsapi.share.g());
    a(new com.tencent.mm.plugin.appbrand.jsapi.r.c());
    a(new com.tencent.mm.plugin.appbrand.jsapi.r.i());
    a(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.m());
    a(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.e());
    a(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.i());
    a(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.o());
    a(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.p());
    a(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.j());
    a(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.f());
    a(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.d());
    a(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.h());
    a(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.g());
    a(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.n());
    a(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.q());
    a(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.l());
    a(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.k());
    a(new com.tencent.mm.plugin.appbrand.jsapi.l.k());
    a(new com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.d());
    a(new bq());
    a(new JsApiGetBackgroundAudioState());
    a(new JsApiSetBackgroundAudioState());
    a(new JsApiOperateBackgroundAudio());
    a(new com.tencent.mm.plugin.appbrand.jsapi.share.h());
    a(new com.tencent.mm.plugin.appbrand.jsapi.share.b());
    a(new be());
    a(new com.tencent.mm.plugin.appbrand.jsapi.contact.b());
    a(new com.tencent.mm.plugin.appbrand.jsapi.r.f());
    a(new com.tencent.mm.plugin.appbrand.jsapi.r.k());
    a(new com.tencent.mm.plugin.appbrand.jsapi.r.m());
    a(new com.tencent.mm.plugin.appbrand.jsapi.r.n());
    a(new com.tencent.mm.plugin.appbrand.jsapi.share.j());
    a(new com.tencent.mm.plugin.appbrand.jsapi.share.i());
    a(new com.tencent.mm.plugin.appbrand.jsapi.share.k());
    a(new com.tencent.mm.plugin.appbrand.jsapi.c.b());
    a(new com.tencent.mm.plugin.appbrand.jsapi.c.c());
    a(new com.tencent.mm.plugin.appbrand.jsapi.c.d());
    a(new com.tencent.mm.plugin.appbrand.jsapi.video.h());
    a(new com.tencent.mm.plugin.appbrand.jsapi.media.j());
    a(new com.tencent.mm.plugin.appbrand.jsapi.media.k());
    a(new aq());
    a(new com.tencent.mm.plugin.appbrand.jsapi.r.j());
    a(new com.tencent.mm.plugin.appbrand.jsapi.ad());
    a(new com.tencent.mm.plugin.appbrand.jsapi.b.h());
    a(new com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.f());
    a(new com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.e());
    a(new com.tencent.mm.plugin.appbrand.jsapi.op_report.b());
    a(new com.tencent.mm.plugin.appbrand.jsapi.l.r());
    a(new com.tencent.mm.plugin.appbrand.jsapi.l.af());
    a(new bn());
    a(new com.tencent.mm.plugin.appbrand.jsapi.l.u());
    a(new bp());
    a(new com.tencent.mm.plugin.appbrand.jsapi.l.q());
    a(new JsApiLuggageCheckIsSupportSoterAuthentication());
    a(new com.tencent.mm.plugin.appbrand.jsapi.bio.soter.b(SoterAuthenticationUI.class));
    a(new com.tencent.mm.plugin.appbrand.jsapi.j.e());
    a(new com.tencent.mm.plugin.appbrand.jsapi.j.j());
    a(new com.tencent.mm.plugin.appbrand.jsapi.j.d());
    a(new com.tencent.mm.plugin.appbrand.jsapi.j.h());
    a(new com.tencent.mm.plugin.appbrand.jsapi.j.g());
    a(new com.tencent.mm.plugin.appbrand.jsapi.j.l());
    a(new br());
    a(new com.tencent.mm.plugin.appbrand.jsapi.camera.l());
    a(new com.tencent.mm.plugin.appbrand.jsapi.l.ab());
    a(new com.tencent.mm.plugin.appbrand.jsapi.t.a.g());
    a(new com.tencent.mm.plugin.appbrand.jsapi.t.a.f());
    a(new com.tencent.mm.plugin.appbrand.jsapi.audio.d());
    a(new com.tencent.mm.plugin.appbrand.jsapi.audio.k());
    a(new com.tencent.mm.plugin.appbrand.jsapi.audio.f());
    a(new com.tencent.mm.plugin.appbrand.jsapi.audio.g());
    a(new com.tencent.mm.plugin.appbrand.jsapi.audio.e());
    a(new com.tencent.mm.plugin.appbrand.jsapi.e.f());
    a(new JsApiLuggageCheckBioEnrollment());
    a(new com.tencent.mm.plugin.appbrand.jsapi.wifi.d());
    a(new com.tencent.mm.plugin.appbrand.jsapi.wifi.e());
    a(new com.tencent.mm.plugin.appbrand.jsapi.wifi.c());
    a(new com.tencent.mm.plugin.appbrand.jsapi.wifi.b());
    a(new com.tencent.mm.plugin.appbrand.jsapi.wifi.a());
    a(new com.tencent.mm.plugin.appbrand.jsapi.nfc.d(null));
    a(new com.tencent.mm.plugin.appbrand.jsapi.nfc.e());
    a(new com.tencent.mm.plugin.appbrand.jsapi.nfc.c());
    a(new com.tencent.mm.plugin.appbrand.jsapi.nfc.b());
    a(new com.tencent.mm.plugin.appbrand.jsapi.l.v());
    a(new com.tencent.mm.plugin.appbrand.jsapi.l.x());
    a(new com.tencent.mm.plugin.appbrand.jsapi.l.w());
    a(new com.tencent.mm.plugin.appbrand.jsapi.l.e());
    a(new com.tencent.mm.plugin.appbrand.jsapi.l.aa());
    a(new com.tencent.mm.plugin.appbrand.jsapi.ui.d());
    a(new com.tencent.mm.plugin.appbrand.jsapi.ui.a());
    a(new com.tencent.mm.plugin.appbrand.jsapi.ui.e());
    a(new com.tencent.mm.plugin.appbrand.jsapi.ui.b());
    a(new com.tencent.mm.plugin.appbrand.jsapi.j.f(com.tencent.mm.plugin.appbrand.jsapi.j.f.hTT, null));
    a(new com.tencent.mm.plugin.appbrand.jsapi.j.k(null));
    a(new com.tencent.mm.plugin.appbrand.jsapi.l.p());
    a(new com.tencent.mm.plugin.appbrand.jsapi.file.ag());
    a(new ah());
    a(new com.tencent.mm.plugin.appbrand.jsapi.file.q());
    a(new com.tencent.mm.plugin.appbrand.jsapi.file.r());
    a(new com.tencent.mm.plugin.appbrand.jsapi.file.s());
    a(new com.tencent.mm.plugin.appbrand.jsapi.file.ab());
    a(new com.tencent.mm.plugin.appbrand.jsapi.file.aa());
    a(new am());
    a(new com.tencent.mm.plugin.appbrand.jsapi.file.w());
    a(new com.tencent.mm.plugin.appbrand.jsapi.file.y());
    a(new com.tencent.mm.plugin.appbrand.jsapi.file.af());
    a(new com.tencent.mm.plugin.appbrand.jsapi.file.j());
    a(new aj());
    a(new com.tencent.mm.plugin.appbrand.jsapi.file.u());
    a(new com.tencent.mm.plugin.appbrand.jsapi.file.p());
    a(new com.tencent.mm.plugin.appbrand.jsapi.file.z());
    a(new al());
    a(new com.tencent.mm.plugin.appbrand.jsapi.file.v());
    a(new com.tencent.mm.plugin.appbrand.jsapi.file.x());
    a(new com.tencent.mm.plugin.appbrand.jsapi.file.ae());
    a(new com.tencent.mm.plugin.appbrand.jsapi.file.i());
    a(new ai());
    a(new com.tencent.mm.plugin.appbrand.jsapi.file.t());
    a(new com.tencent.mm.plugin.appbrand.jsapi.file.o());
    a(new com.tencent.mm.plugin.appbrand.jsapi.file.ak());
    a(new com.tencent.mm.plugin.appbrand.jsapi.file.m());
    a(new com.tencent.mm.plugin.appbrand.jsapi.file.n());
    a(new com.tencent.mm.plugin.appbrand.jsapi.file.ac());
    a(new com.tencent.mm.plugin.appbrand.jsapi.file.ad());
    a(new com.tencent.mm.plugin.appbrand.jsapi.file.k());
    a(new com.tencent.mm.plugin.appbrand.jsapi.file.l());
    a(new com.tencent.mm.plugin.appbrand.jsapi.b.a());
    a(new com.tencent.mm.plugin.appbrand.jsapi.b.b());
    a(new com.tencent.mm.plugin.appbrand.jsapi.r.b());
    a(new JsApiGetInstallState());
    a(new JsApiWriteCommData());
    a(new com.tencent.mm.plugin.appbrand.jsapi.ak());
    a(new com.tencent.mm.plugin.appbrand.jsapi.l.n());
    a(new com.tencent.mm.plugin.appbrand.jsapi.l.o());
    Object localObject = com.tencent.mm.plugin.appbrand.jsapi.g.w.aDp();
    if (((List)localObject).size() > 0)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        a((com.tencent.mm.plugin.appbrand.jsapi.m)((Iterator)localObject).next());
      }
    }
    a(new com.tencent.mm.plugin.appbrand.jsapi.h.a());
    a(new an());
    a(new com.tencent.mm.plugin.appbrand.jsapi.r.h());
    a(new com.tencent.mm.plugin.appbrand.jsapi.r.l());
    a(new com.tencent.mm.plugin.appbrand.jsapi.l.ae());
    a(new com.tencent.mm.plugin.appbrand.jsapi.j.i());
    a(new com.tencent.mm.plugin.appbrand.jsapi.audio.l());
    a(new com.tencent.mm.plugin.appbrand.jsapi.l.ag());
    a(new com.tencent.mm.plugin.appbrand.jsapi.l.t());
    localObject = this.bCN;
    AppMethodBeat.o(140670);
    return localObject;
  }
  
  public final Map<String, com.tencent.mm.plugin.appbrand.jsapi.m> vT()
  {
    AppMethodBeat.i(140671);
    b(new ba());
    b(new com.tencent.mm.plugin.appbrand.jsapi.d.h());
    b(new com.tencent.mm.plugin.appbrand.jsapi.d.c());
    b(new com.tencent.mm.plugin.appbrand.jsapi.d.i());
    b(new com.tencent.mm.plugin.appbrand.jsapi.d.d());
    b(new com.tencent.mm.plugin.appbrand.jsapi.d.j());
    b(new com.tencent.mm.plugin.appbrand.jsapi.d.e());
    b(new com.tencent.mm.plugin.appbrand.jsapi.d.f());
    b(new com.tencent.mm.plugin.appbrand.jsapi.l.f());
    b(new com.tencent.mm.plugin.appbrand.jsapi.bo());
    b(new com.tencent.mm.plugin.appbrand.jsapi.n.e());
    b(new com.tencent.mm.plugin.appbrand.jsapi.n.g());
    b(new com.tencent.mm.plugin.appbrand.jsapi.l.b());
    b(new ao());
    b(new com.tencent.mm.plugin.appbrand.jsapi.video.f());
    b(new com.tencent.mm.plugin.appbrand.jsapi.video.j());
    b(new com.tencent.mm.plugin.appbrand.jsapi.video.i());
    b(new com.tencent.mm.plugin.appbrand.jsapi.video.h());
    b(new com.tencent.mm.plugin.appbrand.jsapi.video.g());
    b(new com.tencent.mm.plugin.appbrand.jsapi.b.e());
    b(new com.tencent.mm.plugin.appbrand.jsapi.b.f());
    b(new com.tencent.mm.plugin.appbrand.jsapi.b.i());
    b(new com.tencent.mm.plugin.appbrand.jsapi.b.k());
    b(new com.tencent.mm.plugin.appbrand.jsapi.l.a());
    b(new com.tencent.mm.plugin.appbrand.jsapi.a.d());
    b(new com.tencent.mm.plugin.appbrand.jsapi.a.g());
    b(new com.tencent.mm.plugin.appbrand.jsapi.a.b());
    b(new com.tencent.mm.plugin.appbrand.jsapi.a.f());
    b(new bq());
    b(new com.tencent.mm.plugin.appbrand.jsapi.r.n());
    b(new com.tencent.mm.plugin.appbrand.jsapi.container.a());
    b(new com.tencent.mm.plugin.appbrand.jsapi.container.c());
    b(new com.tencent.mm.plugin.appbrand.jsapi.container.b());
    b(new com.tencent.mm.plugin.appbrand.jsapi.n.f());
    b(new com.tencent.mm.plugin.appbrand.jsapi.n.h());
    b(new bp());
    b(new com.tencent.mm.plugin.appbrand.jsapi.coverview.e());
    b(new com.tencent.mm.plugin.appbrand.jsapi.coverview.k());
    b(new com.tencent.mm.plugin.appbrand.jsapi.coverview.h());
    b(new com.tencent.mm.plugin.appbrand.jsapi.coverview.c());
    b(new com.tencent.mm.plugin.appbrand.jsapi.coverview.i());
    b(new com.tencent.mm.plugin.appbrand.jsapi.coverview.f());
    b(new com.tencent.mm.plugin.appbrand.jsapi.camera.j());
    b(new com.tencent.mm.plugin.appbrand.jsapi.camera.n());
    b(new com.tencent.mm.plugin.appbrand.jsapi.camera.m());
    b(new com.tencent.mm.plugin.appbrand.debugger.e());
    b(new com.tencent.mm.plugin.appbrand.jsapi.coverview.b());
    b(new com.tencent.mm.plugin.appbrand.jsapi.l.m());
    b(new com.tencent.mm.plugin.appbrand.jsapi.coverview.d());
    b(new com.tencent.mm.plugin.appbrand.jsapi.coverview.j());
    b(new com.tencent.mm.plugin.appbrand.jsapi.coverview.g());
    Object localObject = com.tencent.mm.plugin.appbrand.jsapi.g.w.aDo();
    if (((List)localObject).size() > 0)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        b((com.tencent.mm.plugin.appbrand.jsapi.m)((Iterator)localObject).next());
      }
    }
    b(new com.tencent.mm.plugin.appbrand.jsapi.ui.d());
    b(new com.tencent.mm.plugin.appbrand.jsapi.ui.a());
    b(new com.tencent.mm.plugin.appbrand.jsapi.l.y());
    b(new com.tencent.mm.plugin.appbrand.jsapi.l.c());
    b(new com.tencent.mm.plugin.appbrand.jsapi.ui.e());
    b(new com.tencent.mm.plugin.appbrand.jsapi.ui.b());
    b(new com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.f());
    b(new com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.e());
    b(new com.tencent.mm.plugin.appbrand.jsapi.l.r());
    b(new com.tencent.mm.plugin.appbrand.jsapi.storage.d());
    b(new com.tencent.mm.plugin.appbrand.jsapi.storage.j());
    b(new com.tencent.mm.plugin.appbrand.jsapi.storage.m());
    b(new com.tencent.mm.plugin.appbrand.jsapi.storage.e());
    b(new com.tencent.mm.plugin.appbrand.jsapi.r.f());
    b(new com.tencent.mm.plugin.appbrand.jsapi.r.k());
    b(new com.tencent.mm.plugin.appbrand.jsapi.r.h());
    b(new com.tencent.mm.plugin.appbrand.jsapi.r.l());
    b(new com.tencent.mm.plugin.appbrand.jsapi.l.ae());
    localObject = this.bCO;
    AppMethodBeat.o(140671);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.sdk.a
 * JD-Core Version:    0.7.0.1
 */