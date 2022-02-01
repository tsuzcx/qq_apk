package com.tencent.mm.plugin.ipcall.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.kf;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.ca;
import com.tencent.mm.model.cd;
import com.tencent.mm.model.cd.a;
import com.tencent.mm.plugin.ipcall.model.b.a.a;
import com.tencent.mm.plugin.ipcall.model.b.b.a;
import com.tencent.mm.plugin.ipcall.model.h.j;
import com.tencent.mm.plugin.ipcall.model.h.l;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class i
  implements ax
{
  private static i uKO;
  private static HashMap<Integer, h.b> uLg;
  private com.tencent.mm.plugin.voip.video.i gXE;
  private g uKP;
  private com.tencent.mm.plugin.ipcall.model.d.a uKQ;
  private com.tencent.mm.plugin.ipcall.model.d.b uKR;
  public com.tencent.mm.plugin.ipcall.model.c.b uKS;
  private f uKT;
  private com.tencent.mm.plugin.ipcall.c uKU;
  private com.tencent.mm.plugin.ipcall.model.h.d uKV;
  private l uKW;
  private j uKX;
  private com.tencent.mm.plugin.ipcall.model.h.h uKY;
  private com.tencent.mm.plugin.voip.video.d uKZ;
  private Context uLa;
  private long uLb;
  private com.tencent.mm.sdk.b.c uLc;
  private com.tencent.mm.sdk.b.c uLd;
  private com.tencent.mm.sdk.b.c uLe;
  private com.tencent.mm.sdk.b.c uLf;
  private cd.a uLh;
  private cd.a uLi;
  private cd.a uLj;
  
  static
  {
    AppMethodBeat.i(25405);
    uKO = null;
    HashMap localHashMap = new HashMap();
    uLg = localHashMap;
    localHashMap.put(Integer.valueOf("IPCallAddressItem".hashCode()), new i.7());
    uLg.put(Integer.valueOf("IPCallRecord".hashCode()), new i.8());
    uLg.put(Integer.valueOf("IPCallPopularCountry".hashCode()), new i.9());
    uLg.put(Integer.valueOf("IPCallMsg".hashCode()), new i.10());
    AppMethodBeat.o(25405);
  }
  
  public i()
  {
    AppMethodBeat.i(25389);
    this.uKP = new g();
    this.uKQ = new com.tencent.mm.plugin.ipcall.model.d.a();
    this.uKR = new com.tencent.mm.plugin.ipcall.model.d.b();
    this.uKT = new f();
    this.uKU = new com.tencent.mm.plugin.ipcall.c();
    this.uLc = new i.1(this);
    this.uLd = new i.4(this);
    this.uLe = new i.5(this);
    this.uLf = new com.tencent.mm.sdk.b.c() {};
    this.uLh = new i.11(this);
    this.uLi = new i.2(this);
    this.uLj = new i.3(this);
    AppMethodBeat.o(25389);
  }
  
  public static i ddE()
  {
    AppMethodBeat.i(25390);
    if (uKO == null)
    {
      uKO = new i();
      ba.aBK().a("plugin.ipcall", uKO);
    }
    i locali = uKO;
    AppMethodBeat.o(25390);
    return locali;
  }
  
  public static g ddG()
  {
    AppMethodBeat.i(25391);
    g localg = ddE().uKP;
    AppMethodBeat.o(25391);
    return localg;
  }
  
  public static com.tencent.mm.plugin.ipcall.model.d.a ddH()
  {
    AppMethodBeat.i(25392);
    com.tencent.mm.plugin.ipcall.model.d.a locala = ddE().uKQ;
    AppMethodBeat.o(25392);
    return locala;
  }
  
  public static com.tencent.mm.plugin.ipcall.model.d.b ddI()
  {
    AppMethodBeat.i(25393);
    com.tencent.mm.plugin.ipcall.model.d.b localb = ddE().uKR;
    AppMethodBeat.o(25393);
    return localb;
  }
  
  public static com.tencent.mm.plugin.ipcall.model.c.b ddJ()
  {
    AppMethodBeat.i(25394);
    com.tencent.mm.plugin.ipcall.model.c.b localb = ddE().uKS;
    AppMethodBeat.o(25394);
    return localb;
  }
  
  public static f ddK()
  {
    AppMethodBeat.i(25395);
    f localf = ddE().uKT;
    AppMethodBeat.o(25395);
    return localf;
  }
  
  public static com.tencent.mm.plugin.ipcall.c ddL()
  {
    AppMethodBeat.i(25396);
    com.tencent.mm.plugin.ipcall.c localc = ddE().uKU;
    AppMethodBeat.o(25396);
    return localc;
  }
  
  public static com.tencent.mm.plugin.ipcall.model.h.d ddM()
  {
    AppMethodBeat.i(25397);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (ddE().uKV == null)
    {
      localObject = ddE();
      ba.aBQ();
      ((i)localObject).uKV = new com.tencent.mm.plugin.ipcall.model.h.d(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = ddE().uKV;
    AppMethodBeat.o(25397);
    return localObject;
  }
  
  public static l ddN()
  {
    AppMethodBeat.i(25398);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (ddE().uKW == null)
    {
      localObject = ddE();
      ba.aBQ();
      ((i)localObject).uKW = new l(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = ddE().uKW;
    AppMethodBeat.o(25398);
    return localObject;
  }
  
  public static j ddO()
  {
    AppMethodBeat.i(25399);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (ddE().uKX == null)
    {
      localObject = ddE();
      ba.aBQ();
      ((i)localObject).uKX = new j(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = ddE().uKX;
    AppMethodBeat.o(25399);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.ipcall.model.h.h ddP()
  {
    AppMethodBeat.i(25400);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (ddE().uKY == null)
    {
      localObject = ddE();
      ba.aBQ();
      ((i)localObject).uKY = new com.tencent.mm.plugin.ipcall.model.h.h(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = ddE().uKY;
    AppMethodBeat.o(25400);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.voip.video.i ddQ()
  {
    AppMethodBeat.i(25401);
    if (ddE().gXE == null) {
      ddE().gXE = new com.tencent.mm.plugin.voip.video.i(aj.getContext());
    }
    com.tencent.mm.plugin.voip.video.i locali = ddE().gXE;
    AppMethodBeat.o(25401);
    return locali;
  }
  
  public static com.tencent.mm.plugin.voip.video.d ddR()
  {
    AppMethodBeat.i(25402);
    if (ddE().uKZ == null) {
      ddE().uKZ = new com.tencent.mm.plugin.voip.video.d(aj.getContext());
    }
    com.tencent.mm.plugin.voip.video.d locald = ddE().uKZ;
    AppMethodBeat.o(25402);
    return locald;
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final void ddF()
  {
    AppMethodBeat.i(193220);
    this.uKS = new com.tencent.mm.plugin.ipcall.model.c.b();
    AppMethodBeat.o(193220);
  }
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return uLg;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(25403);
    Object localObject = this.uKP;
    ((g)localObject).uKA.init();
    ((g)localObject).uKB.init();
    ((g)localObject).uKC.init();
    ((g)localObject).uKD.init();
    ((g)localObject).uKE.init();
    ((g)localObject).uKF.init();
    ((g)localObject).uKG.init();
    ((g)localObject).uKH.init();
    ((g)localObject).uKA.a((a.a)localObject);
    ((g)localObject).uKC.a((a.a)localObject);
    ((g)localObject).uKD.a((a.a)localObject);
    ((g)localObject).uKF.a((a.a)localObject);
    ((g)localObject).uKH.a((a.a)localObject);
    ((g)localObject).uKB.uLr = ((b.a)localObject);
    ((g)localObject).uKE.uLr = ((b.a)localObject);
    ba.a(((g)localObject).uKL);
    b.init();
    localObject = d.ddv();
    com.tencent.mm.sdk.b.a.IbL.c(((d)localObject).uKn);
    localObject = e.ddy();
    com.tencent.mm.sdk.b.a.IbL.c(((e)localObject).jhE);
    ba.getSysCmdMsgExtension().a("WeChatOut", this.uLh, true);
    ba.getSysCmdMsgExtension().a("WeChatOutMsg", this.uLi, true);
    ba.getSysCmdMsgExtension().a("WCONotify", this.uLj, true);
    com.tencent.mm.sdk.b.a.IbL.c(this.uLc);
    com.tencent.mm.sdk.b.a.IbL.c(this.uLd);
    com.tencent.mm.sdk.b.a.IbL.c(this.uLe);
    com.tencent.mm.sdk.b.a.IbL.c(this.uLf);
    AppMethodBeat.o(25403);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(25404);
    if (this.uKT.ddz()) {
      this.uKU.gr(0, 0);
    }
    Object localObject = this.uKP;
    ((g)localObject).uKA.destroy();
    ((g)localObject).uKB.destroy();
    ((g)localObject).uKC.destroy();
    ((g)localObject).uKD.destroy();
    ((g)localObject).uKE.destroy();
    ((g)localObject).uKG.destroy();
    ba.b(((g)localObject).uKL);
    b.release();
    localObject = d.ddv();
    ba.aiU().b(159, (com.tencent.mm.al.f)localObject);
    ba.aiU().b(160, (com.tencent.mm.al.f)localObject);
    com.tencent.mm.sdk.b.a.IbL.d(((d)localObject).uKn);
    localObject = e.ddy();
    com.tencent.mm.sdk.b.a.IbL.d(((e)localObject).jhE);
    ba.getSysCmdMsgExtension().b("WeChatOut", this.uLh, true);
    ba.getSysCmdMsgExtension().b("WeChatOutMsg", this.uLi, true);
    ba.getSysCmdMsgExtension().b("WCONotify", this.uLj, true);
    com.tencent.mm.sdk.b.a.IbL.d(this.uLc);
    com.tencent.mm.sdk.b.a.IbL.d(this.uLd);
    com.tencent.mm.sdk.b.a.IbL.d(this.uLe);
    com.tencent.mm.sdk.b.a.IbL.d(this.uLf);
    AppMethodBeat.o(25404);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.i
 * JD-Core Version:    0.7.0.1
 */