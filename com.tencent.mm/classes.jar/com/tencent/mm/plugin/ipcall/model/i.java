package com.tencent.mm.plugin.ipcall.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.lm;
import com.tencent.mm.model.be;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.ch;
import com.tencent.mm.model.ck;
import com.tencent.mm.model.ck.a;
import com.tencent.mm.plugin.ipcall.model.b.a.a;
import com.tencent.mm.plugin.ipcall.model.b.b.a;
import com.tencent.mm.plugin.ipcall.model.h.j;
import com.tencent.mm.plugin.ipcall.model.h.l;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class i
  implements be
{
  private static i DPe;
  private static HashMap<Integer, h.b> DPw;
  private g DPf;
  private com.tencent.mm.plugin.ipcall.model.d.a DPg;
  private com.tencent.mm.plugin.ipcall.model.d.b DPh;
  public com.tencent.mm.plugin.ipcall.model.c.b DPi;
  private f DPj;
  private com.tencent.mm.plugin.ipcall.c DPk;
  private com.tencent.mm.plugin.ipcall.model.h.d DPl;
  private l DPm;
  private j DPn;
  private com.tencent.mm.plugin.ipcall.model.h.h DPo;
  private com.tencent.mm.plugin.voip.video.c DPp;
  private Context DPq;
  private long DPr;
  private IListener DPs;
  private IListener DPt;
  private IListener DPu;
  private IListener DPv;
  private ck.a DPx;
  private ck.a DPy;
  private ck.a DPz;
  private com.tencent.mm.plugin.voip.video.e kHI;
  
  static
  {
    AppMethodBeat.i(25405);
    DPe = null;
    HashMap localHashMap = new HashMap();
    DPw = localHashMap;
    localHashMap.put(Integer.valueOf("IPCallAddressItem".hashCode()), new i.7());
    DPw.put(Integer.valueOf("IPCallRecord".hashCode()), new i.8());
    DPw.put(Integer.valueOf("IPCallPopularCountry".hashCode()), new i.9());
    DPw.put(Integer.valueOf("IPCallMsg".hashCode()), new i.10());
    AppMethodBeat.o(25405);
  }
  
  public i()
  {
    AppMethodBeat.i(25389);
    this.DPf = new g();
    this.DPg = new com.tencent.mm.plugin.ipcall.model.d.a();
    this.DPh = new com.tencent.mm.plugin.ipcall.model.d.b();
    this.DPj = new f();
    this.DPk = new com.tencent.mm.plugin.ipcall.c();
    this.DPs = new i.1(this);
    this.DPt = new i.4(this);
    this.DPu = new i.5(this);
    this.DPv = new IListener() {};
    this.DPx = new i.11(this);
    this.DPy = new i.2(this);
    this.DPz = new i.3(this);
    AppMethodBeat.o(25389);
  }
  
  public static com.tencent.mm.plugin.voip.video.e eJA()
  {
    AppMethodBeat.i(25401);
    if (eJo().kHI == null) {
      eJo().kHI = new com.tencent.mm.plugin.voip.video.e(MMApplicationContext.getContext());
    }
    com.tencent.mm.plugin.voip.video.e locale = eJo().kHI;
    AppMethodBeat.o(25401);
    return locale;
  }
  
  public static com.tencent.mm.plugin.voip.video.c eJB()
  {
    AppMethodBeat.i(25402);
    if (eJo().DPp == null) {
      eJo().DPp = new com.tencent.mm.plugin.voip.video.c(MMApplicationContext.getContext());
    }
    com.tencent.mm.plugin.voip.video.c localc = eJo().DPp;
    AppMethodBeat.o(25402);
    return localc;
  }
  
  public static i eJo()
  {
    AppMethodBeat.i(25390);
    if (DPe == null)
    {
      DPe = new i();
      bh.beC().a("plugin.ipcall", DPe);
    }
    i locali = DPe;
    AppMethodBeat.o(25390);
    return locali;
  }
  
  public static g eJq()
  {
    AppMethodBeat.i(25391);
    g localg = eJo().DPf;
    AppMethodBeat.o(25391);
    return localg;
  }
  
  public static com.tencent.mm.plugin.ipcall.model.d.a eJr()
  {
    AppMethodBeat.i(25392);
    com.tencent.mm.plugin.ipcall.model.d.a locala = eJo().DPg;
    AppMethodBeat.o(25392);
    return locala;
  }
  
  public static com.tencent.mm.plugin.ipcall.model.d.b eJs()
  {
    AppMethodBeat.i(25393);
    com.tencent.mm.plugin.ipcall.model.d.b localb = eJo().DPh;
    AppMethodBeat.o(25393);
    return localb;
  }
  
  public static com.tencent.mm.plugin.ipcall.model.c.b eJt()
  {
    AppMethodBeat.i(25394);
    com.tencent.mm.plugin.ipcall.model.c.b localb = eJo().DPi;
    AppMethodBeat.o(25394);
    return localb;
  }
  
  public static f eJu()
  {
    AppMethodBeat.i(25395);
    f localf = eJo().DPj;
    AppMethodBeat.o(25395);
    return localf;
  }
  
  public static com.tencent.mm.plugin.ipcall.c eJv()
  {
    AppMethodBeat.i(25396);
    com.tencent.mm.plugin.ipcall.c localc = eJo().DPk;
    AppMethodBeat.o(25396);
    return localc;
  }
  
  public static com.tencent.mm.plugin.ipcall.model.h.d eJw()
  {
    AppMethodBeat.i(25397);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (eJo().DPl == null)
    {
      localObject = eJo();
      bh.beI();
      ((i)localObject).DPl = new com.tencent.mm.plugin.ipcall.model.h.d(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = eJo().DPl;
    AppMethodBeat.o(25397);
    return localObject;
  }
  
  public static l eJx()
  {
    AppMethodBeat.i(25398);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (eJo().DPm == null)
    {
      localObject = eJo();
      bh.beI();
      ((i)localObject).DPm = new l(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = eJo().DPm;
    AppMethodBeat.o(25398);
    return localObject;
  }
  
  public static j eJy()
  {
    AppMethodBeat.i(25399);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (eJo().DPn == null)
    {
      localObject = eJo();
      bh.beI();
      ((i)localObject).DPn = new j(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = eJo().DPn;
    AppMethodBeat.o(25399);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.ipcall.model.h.h eJz()
  {
    AppMethodBeat.i(25400);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (eJo().DPo == null)
    {
      localObject = eJo();
      bh.beI();
      ((i)localObject).DPo = new com.tencent.mm.plugin.ipcall.model.h.h(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = eJo().DPo;
    AppMethodBeat.o(25400);
    return localObject;
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final void eJp()
  {
    AppMethodBeat.i(257940);
    this.DPi = new com.tencent.mm.plugin.ipcall.model.c.b();
    AppMethodBeat.o(257940);
  }
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return DPw;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(25403);
    Object localObject = this.DPf;
    ((g)localObject).DOQ.init();
    ((g)localObject).DOR.init();
    ((g)localObject).DOS.init();
    ((g)localObject).DOT.init();
    ((g)localObject).DOU.init();
    ((g)localObject).DOV.init();
    ((g)localObject).DOW.init();
    ((g)localObject).DOX.init();
    ((g)localObject).DOQ.a((a.a)localObject);
    ((g)localObject).DOS.a((a.a)localObject);
    ((g)localObject).DOT.a((a.a)localObject);
    ((g)localObject).DOV.a((a.a)localObject);
    ((g)localObject).DOX.a((a.a)localObject);
    ((g)localObject).DOR.DPH = ((b.a)localObject);
    ((g)localObject).DOU.DPH = ((b.a)localObject);
    bh.a(((g)localObject).DPb);
    b.init();
    localObject = d.eJf();
    EventCenter.instance.addListener(((d)localObject).DOD);
    localObject = e.eJi();
    EventCenter.instance.addListener(((e)localObject).mZZ);
    bh.getSysCmdMsgExtension().a("WeChatOut", this.DPx, true);
    bh.getSysCmdMsgExtension().a("WeChatOutMsg", this.DPy, true);
    bh.getSysCmdMsgExtension().a("WCONotify", this.DPz, true);
    EventCenter.instance.addListener(this.DPs);
    EventCenter.instance.addListener(this.DPt);
    EventCenter.instance.addListener(this.DPu);
    EventCenter.instance.addListener(this.DPv);
    AppMethodBeat.o(25403);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(25404);
    if (this.DPj.eJj()) {
      this.DPk.hT(0, 0);
    }
    Object localObject = this.DPf;
    ((g)localObject).DOQ.destroy();
    ((g)localObject).DOR.destroy();
    ((g)localObject).DOS.destroy();
    ((g)localObject).DOT.destroy();
    ((g)localObject).DOU.destroy();
    ((g)localObject).DOW.destroy();
    bh.b(((g)localObject).DPb);
    b.release();
    localObject = d.eJf();
    bh.aGY().b(159, (com.tencent.mm.an.i)localObject);
    bh.aGY().b(160, (com.tencent.mm.an.i)localObject);
    EventCenter.instance.removeListener(((d)localObject).DOD);
    localObject = e.eJi();
    EventCenter.instance.removeListener(((e)localObject).mZZ);
    bh.getSysCmdMsgExtension().b("WeChatOut", this.DPx, true);
    bh.getSysCmdMsgExtension().b("WeChatOutMsg", this.DPy, true);
    bh.getSysCmdMsgExtension().b("WCONotify", this.DPz, true);
    EventCenter.instance.removeListener(this.DPs);
    EventCenter.instance.removeListener(this.DPt);
    EventCenter.instance.removeListener(this.DPu);
    EventCenter.instance.removeListener(this.DPv);
    AppMethodBeat.o(25404);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.i
 * JD-Core Version:    0.7.0.1
 */