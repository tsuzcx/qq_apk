package com.tencent.mm.plugin.ipcall.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.bj;
import com.tencent.mm.g.a.kg;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.cc;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.cf.a;
import com.tencent.mm.plugin.ipcall.model.b.a.a;
import com.tencent.mm.plugin.ipcall.model.b.b.a;
import com.tencent.mm.plugin.ipcall.model.h.j;
import com.tencent.mm.plugin.ipcall.model.h.l;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class i
  implements az
{
  private static i uWB;
  private static HashMap<Integer, h.b> uWT;
  private com.tencent.mm.plugin.voip.video.i haq;
  private g uWC;
  private com.tencent.mm.plugin.ipcall.model.d.a uWD;
  private com.tencent.mm.plugin.ipcall.model.d.b uWE;
  public com.tencent.mm.plugin.ipcall.model.c.b uWF;
  private f uWG;
  private com.tencent.mm.plugin.ipcall.c uWH;
  private com.tencent.mm.plugin.ipcall.model.h.d uWI;
  private l uWJ;
  private j uWK;
  private com.tencent.mm.plugin.ipcall.model.h.h uWL;
  private com.tencent.mm.plugin.voip.video.d uWM;
  private Context uWN;
  private long uWO;
  private com.tencent.mm.sdk.b.c uWP;
  private com.tencent.mm.sdk.b.c uWQ;
  private com.tencent.mm.sdk.b.c uWR;
  private com.tencent.mm.sdk.b.c uWS;
  private cf.a uWU;
  private cf.a uWV;
  private cf.a uWW;
  
  static
  {
    AppMethodBeat.i(25405);
    uWB = null;
    HashMap localHashMap = new HashMap();
    uWT = localHashMap;
    localHashMap.put(Integer.valueOf("IPCallAddressItem".hashCode()), new i.7());
    uWT.put(Integer.valueOf("IPCallRecord".hashCode()), new i.8());
    uWT.put(Integer.valueOf("IPCallPopularCountry".hashCode()), new i.9());
    uWT.put(Integer.valueOf("IPCallMsg".hashCode()), new i.10());
    AppMethodBeat.o(25405);
  }
  
  public i()
  {
    AppMethodBeat.i(25389);
    this.uWC = new g();
    this.uWD = new com.tencent.mm.plugin.ipcall.model.d.a();
    this.uWE = new com.tencent.mm.plugin.ipcall.model.d.b();
    this.uWG = new f();
    this.uWH = new com.tencent.mm.plugin.ipcall.c();
    this.uWP = new i.1(this);
    this.uWQ = new com.tencent.mm.sdk.b.c() {};
    this.uWR = new i.5(this);
    this.uWS = new com.tencent.mm.sdk.b.c() {};
    this.uWU = new i.11(this);
    this.uWV = new i.2(this);
    this.uWW = new i.3(this);
    AppMethodBeat.o(25389);
  }
  
  public static com.tencent.mm.plugin.ipcall.model.d.b dgA()
  {
    AppMethodBeat.i(25393);
    com.tencent.mm.plugin.ipcall.model.d.b localb = dgw().uWE;
    AppMethodBeat.o(25393);
    return localb;
  }
  
  public static com.tencent.mm.plugin.ipcall.model.c.b dgB()
  {
    AppMethodBeat.i(25394);
    com.tencent.mm.plugin.ipcall.model.c.b localb = dgw().uWF;
    AppMethodBeat.o(25394);
    return localb;
  }
  
  public static f dgC()
  {
    AppMethodBeat.i(25395);
    f localf = dgw().uWG;
    AppMethodBeat.o(25395);
    return localf;
  }
  
  public static com.tencent.mm.plugin.ipcall.c dgD()
  {
    AppMethodBeat.i(25396);
    com.tencent.mm.plugin.ipcall.c localc = dgw().uWH;
    AppMethodBeat.o(25396);
    return localc;
  }
  
  public static com.tencent.mm.plugin.ipcall.model.h.d dgE()
  {
    AppMethodBeat.i(25397);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (dgw().uWI == null)
    {
      localObject = dgw();
      bc.aCg();
      ((i)localObject).uWI = new com.tencent.mm.plugin.ipcall.model.h.d(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = dgw().uWI;
    AppMethodBeat.o(25397);
    return localObject;
  }
  
  public static l dgF()
  {
    AppMethodBeat.i(25398);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (dgw().uWJ == null)
    {
      localObject = dgw();
      bc.aCg();
      ((i)localObject).uWJ = new l(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = dgw().uWJ;
    AppMethodBeat.o(25398);
    return localObject;
  }
  
  public static j dgG()
  {
    AppMethodBeat.i(25399);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (dgw().uWK == null)
    {
      localObject = dgw();
      bc.aCg();
      ((i)localObject).uWK = new j(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = dgw().uWK;
    AppMethodBeat.o(25399);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.ipcall.model.h.h dgH()
  {
    AppMethodBeat.i(25400);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (dgw().uWL == null)
    {
      localObject = dgw();
      bc.aCg();
      ((i)localObject).uWL = new com.tencent.mm.plugin.ipcall.model.h.h(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = dgw().uWL;
    AppMethodBeat.o(25400);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.voip.video.i dgI()
  {
    AppMethodBeat.i(25401);
    if (dgw().haq == null) {
      dgw().haq = new com.tencent.mm.plugin.voip.video.i(ak.getContext());
    }
    com.tencent.mm.plugin.voip.video.i locali = dgw().haq;
    AppMethodBeat.o(25401);
    return locali;
  }
  
  public static com.tencent.mm.plugin.voip.video.d dgJ()
  {
    AppMethodBeat.i(25402);
    if (dgw().uWM == null) {
      dgw().uWM = new com.tencent.mm.plugin.voip.video.d(ak.getContext());
    }
    com.tencent.mm.plugin.voip.video.d locald = dgw().uWM;
    AppMethodBeat.o(25402);
    return locald;
  }
  
  public static i dgw()
  {
    AppMethodBeat.i(25390);
    if (uWB == null)
    {
      uWB = new i();
      bc.aCa().a("plugin.ipcall", uWB);
    }
    i locali = uWB;
    AppMethodBeat.o(25390);
    return locali;
  }
  
  public static g dgy()
  {
    AppMethodBeat.i(25391);
    g localg = dgw().uWC;
    AppMethodBeat.o(25391);
    return localg;
  }
  
  public static com.tencent.mm.plugin.ipcall.model.d.a dgz()
  {
    AppMethodBeat.i(25392);
    com.tencent.mm.plugin.ipcall.model.d.a locala = dgw().uWD;
    AppMethodBeat.o(25392);
    return locala;
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final void dgx()
  {
    AppMethodBeat.i(186480);
    this.uWF = new com.tencent.mm.plugin.ipcall.model.c.b();
    AppMethodBeat.o(186480);
  }
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return uWT;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(25403);
    Object localObject = this.uWC;
    ((g)localObject).uWn.init();
    ((g)localObject).uWo.init();
    ((g)localObject).uWp.init();
    ((g)localObject).uWq.init();
    ((g)localObject).uWr.init();
    ((g)localObject).uWs.init();
    ((g)localObject).uWt.init();
    ((g)localObject).uWu.init();
    ((g)localObject).uWn.a((a.a)localObject);
    ((g)localObject).uWp.a((a.a)localObject);
    ((g)localObject).uWq.a((a.a)localObject);
    ((g)localObject).uWs.a((a.a)localObject);
    ((g)localObject).uWu.a((a.a)localObject);
    ((g)localObject).uWo.uXe = ((b.a)localObject);
    ((g)localObject).uWr.uXe = ((b.a)localObject);
    bc.a(((g)localObject).uWy);
    b.init();
    localObject = d.dgn();
    com.tencent.mm.sdk.b.a.IvT.c(((d)localObject).uWa);
    localObject = e.dgq();
    com.tencent.mm.sdk.b.a.IvT.c(((e)localObject).jkx);
    bc.getSysCmdMsgExtension().a("WeChatOut", this.uWU, true);
    bc.getSysCmdMsgExtension().a("WeChatOutMsg", this.uWV, true);
    bc.getSysCmdMsgExtension().a("WCONotify", this.uWW, true);
    com.tencent.mm.sdk.b.a.IvT.c(this.uWP);
    com.tencent.mm.sdk.b.a.IvT.c(this.uWQ);
    com.tencent.mm.sdk.b.a.IvT.c(this.uWR);
    com.tencent.mm.sdk.b.a.IvT.c(this.uWS);
    AppMethodBeat.o(25403);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(25404);
    if (this.uWG.dgr()) {
      this.uWH.gr(0, 0);
    }
    Object localObject = this.uWC;
    ((g)localObject).uWn.destroy();
    ((g)localObject).uWo.destroy();
    ((g)localObject).uWp.destroy();
    ((g)localObject).uWq.destroy();
    ((g)localObject).uWr.destroy();
    ((g)localObject).uWt.destroy();
    bc.b(((g)localObject).uWy);
    b.release();
    localObject = d.dgn();
    bc.ajj().b(159, (com.tencent.mm.ak.f)localObject);
    bc.ajj().b(160, (com.tencent.mm.ak.f)localObject);
    com.tencent.mm.sdk.b.a.IvT.d(((d)localObject).uWa);
    localObject = e.dgq();
    com.tencent.mm.sdk.b.a.IvT.d(((e)localObject).jkx);
    bc.getSysCmdMsgExtension().b("WeChatOut", this.uWU, true);
    bc.getSysCmdMsgExtension().b("WeChatOutMsg", this.uWV, true);
    bc.getSysCmdMsgExtension().b("WCONotify", this.uWW, true);
    com.tencent.mm.sdk.b.a.IvT.d(this.uWP);
    com.tencent.mm.sdk.b.a.IvT.d(this.uWQ);
    com.tencent.mm.sdk.b.a.IvT.d(this.uWR);
    com.tencent.mm.sdk.b.a.IvT.d(this.uWS);
    AppMethodBeat.o(25404);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.i
 * JD-Core Version:    0.7.0.1
 */