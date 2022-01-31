package com.tencent.mm.plugin.card.model;

import android.app.Application;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.g.a.il;
import com.tencent.mm.model.at;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.bz.a;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.card.PluginCard;
import com.tencent.mm.plugin.card.b.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class am
  implements at
{
  private static HashMap<Integer, h.d> baseDBFactories;
  private com.tencent.mm.plugin.card.b.b koL;
  private c koM;
  private al koN;
  private h koO;
  private com.tencent.mm.plugin.card.b.m koP;
  private com.tencent.mm.plugin.card.sharecard.a.a koQ;
  private com.tencent.mm.plugin.card.sharecard.model.k koR;
  private com.tencent.mm.plugin.card.sharecard.model.o koS;
  private com.tencent.mm.plugin.card.sharecard.a.c koT;
  private com.tencent.mm.plugin.card.b.k koU;
  private com.tencent.mm.plugin.card.b.e koV;
  private com.tencent.mm.plugin.card.b.l koW;
  private com.tencent.mm.plugin.card.b.d koX;
  private com.tencent.mm.plugin.card.b.j koY;
  private com.tencent.mm.plugin.card.b.c koZ;
  private com.tencent.mm.plugin.card.b.g kpa;
  private l kpb;
  private j kpc;
  private com.tencent.mm.sdk.b.c kpd;
  private com.tencent.mm.sdk.b.c kpe;
  private com.tencent.mm.sdk.b.c kpf;
  private com.tencent.mm.plugin.card.ui.b kpg;
  private com.tencent.mm.sdk.b.c kph;
  private com.tencent.mm.sdk.b.c kpi;
  private bz.a kpj;
  private bz.a kpk;
  private com.tencent.mm.sdk.b.c<il> kpl;
  private ak mHandler;
  
  static
  {
    AppMethodBeat.i(87964);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("USERCARDINFO_TABLE".hashCode()), new h.d()
    {
      public final String[] getSQLs()
      {
        return c.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("PENDINGCARDIDINFO_TABLE".hashCode()), new h.d()
    {
      public final String[] getSQLs()
      {
        return al.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("CARDMSGINFO_TABLE".hashCode()), new am.10());
    baseDBFactories.put(Integer.valueOf("SHARECARDINFO_TABLE".hashCode()), new h.d()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.card.sharecard.model.k.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("SHARECARDSYNCITEMINFO_TABLE".hashCode()), new am.12());
    baseDBFactories.put(Integer.valueOf("CARDQRCODECONFI_TABLE".hashCode()), new am.2());
    baseDBFactories.put(Integer.valueOf("CARDQRCODEDATAINFO_TABLE".hashCode()), new am.3());
    AppMethodBeat.o(87964);
  }
  
  public am()
  {
    AppMethodBeat.i(87942);
    this.koU = null;
    this.koV = null;
    this.koW = null;
    this.koX = null;
    this.koY = null;
    this.mHandler = new ak(Looper.getMainLooper());
    this.kpd = new n();
    this.kpe = new com.tencent.mm.plugin.card.b.o();
    this.kpf = new com.tencent.mm.plugin.card.b.a();
    this.kpg = new com.tencent.mm.plugin.card.ui.b();
    this.kph = new am.1(this);
    this.kpi = new am.5(this);
    this.kpj = new am.6(this);
    this.kpk = new am.7(this);
    this.kpl = new am.4(this);
    File localFile = new File(m.knX);
    if (!localFile.exists()) {
      localFile.mkdir();
    }
    localFile = new File(m.knY);
    if (!localFile.exists()) {
      localFile.mkdir();
    }
    AppMethodBeat.o(87942);
  }
  
  public static com.tencent.mm.plugin.card.b.b bcc()
  {
    AppMethodBeat.i(87946);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (getCore().koL == null) {
      getCore().koL = new com.tencent.mm.plugin.card.b.b();
    }
    com.tencent.mm.plugin.card.b.b localb = getCore().koL;
    AppMethodBeat.o(87946);
    return localb;
  }
  
  public static c bcd()
  {
    AppMethodBeat.i(87947);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (getCore().koM == null) {
      getCore().koM = new c(com.tencent.mm.kernel.g.RL().eHS);
    }
    c localc = getCore().koM;
    AppMethodBeat.o(87947);
    return localc;
  }
  
  public static al bce()
  {
    AppMethodBeat.i(87948);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (getCore().koN == null) {
      getCore().koN = new al(com.tencent.mm.kernel.g.RL().eHS);
    }
    al localal = getCore().koN;
    AppMethodBeat.o(87948);
    return localal;
  }
  
  public static h bcf()
  {
    AppMethodBeat.i(87949);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (getCore().koO == null) {
      getCore().koO = new h(com.tencent.mm.kernel.g.RL().eHS);
    }
    h localh = getCore().koO;
    AppMethodBeat.o(87949);
    return localh;
  }
  
  public static com.tencent.mm.plugin.card.b.m bcg()
  {
    AppMethodBeat.i(87950);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (getCore().koP == null) {
      getCore().koP = new com.tencent.mm.plugin.card.b.m();
    }
    com.tencent.mm.plugin.card.b.m localm = getCore().koP;
    AppMethodBeat.o(87950);
    return localm;
  }
  
  public static com.tencent.mm.plugin.card.b.k bch()
  {
    AppMethodBeat.i(87951);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (getCore().koU == null) {
      getCore().koU = new com.tencent.mm.plugin.card.b.k();
    }
    com.tencent.mm.plugin.card.b.k localk = getCore().koU;
    AppMethodBeat.o(87951);
    return localk;
  }
  
  public static com.tencent.mm.plugin.card.b.e bci()
  {
    AppMethodBeat.i(87952);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (getCore().koV == null) {
      getCore().koV = new com.tencent.mm.plugin.card.b.e();
    }
    com.tencent.mm.plugin.card.b.e locale = getCore().koV;
    AppMethodBeat.o(87952);
    return locale;
  }
  
  public static com.tencent.mm.plugin.card.b.l bcj()
  {
    AppMethodBeat.i(87953);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (getCore().koW == null) {
      getCore().koW = new com.tencent.mm.plugin.card.b.l();
    }
    com.tencent.mm.plugin.card.b.l locall = getCore().koW;
    AppMethodBeat.o(87953);
    return locall;
  }
  
  public static com.tencent.mm.plugin.card.sharecard.a.a bck()
  {
    AppMethodBeat.i(87954);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (getCore().koQ == null) {
      getCore().koQ = new com.tencent.mm.plugin.card.sharecard.a.a();
    }
    com.tencent.mm.plugin.card.sharecard.a.a locala = getCore().koQ;
    AppMethodBeat.o(87954);
    return locala;
  }
  
  public static com.tencent.mm.plugin.card.sharecard.model.k bcl()
  {
    AppMethodBeat.i(87955);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (getCore().koR == null) {
      getCore().koR = new com.tencent.mm.plugin.card.sharecard.model.k(com.tencent.mm.kernel.g.RL().eHS);
    }
    com.tencent.mm.plugin.card.sharecard.model.k localk = getCore().koR;
    AppMethodBeat.o(87955);
    return localk;
  }
  
  public static com.tencent.mm.plugin.card.sharecard.model.o bcm()
  {
    AppMethodBeat.i(87956);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (getCore().koS == null) {
      getCore().koS = new com.tencent.mm.plugin.card.sharecard.model.o(com.tencent.mm.kernel.g.RL().eHS);
    }
    com.tencent.mm.plugin.card.sharecard.model.o localo = getCore().koS;
    AppMethodBeat.o(87956);
    return localo;
  }
  
  public static com.tencent.mm.plugin.card.sharecard.a.c bcn()
  {
    AppMethodBeat.i(87957);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (getCore().koT == null) {
      getCore().koT = new com.tencent.mm.plugin.card.sharecard.a.c();
    }
    com.tencent.mm.plugin.card.sharecard.a.c localc = getCore().koT;
    AppMethodBeat.o(87957);
    return localc;
  }
  
  public static com.tencent.mm.plugin.card.b.d bco()
  {
    AppMethodBeat.i(87958);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (getCore().koX == null) {
      getCore().koX = new com.tencent.mm.plugin.card.b.d();
    }
    com.tencent.mm.plugin.card.b.d locald = getCore().koX;
    AppMethodBeat.o(87958);
    return locald;
  }
  
  public static com.tencent.mm.plugin.card.b.j bcp()
  {
    AppMethodBeat.i(87959);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (getCore().koY == null) {
      getCore().koY = new com.tencent.mm.plugin.card.b.j();
    }
    com.tencent.mm.plugin.card.b.j localj = getCore().koY;
    AppMethodBeat.o(87959);
    return localj;
  }
  
  public static com.tencent.mm.plugin.card.b.c bcq()
  {
    AppMethodBeat.i(87960);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (getCore().koZ == null) {
      getCore().koZ = new com.tencent.mm.plugin.card.b.c();
    }
    com.tencent.mm.plugin.card.b.c localc = getCore().koZ;
    AppMethodBeat.o(87960);
    return localc;
  }
  
  public static l bcr()
  {
    AppMethodBeat.i(87961);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (getCore().kpb == null) {
      getCore().kpb = new l(com.tencent.mm.kernel.g.RL().eHS);
    }
    l locall = getCore().kpb;
    AppMethodBeat.o(87961);
    return locall;
  }
  
  public static j bcs()
  {
    AppMethodBeat.i(87962);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (getCore().kpc == null) {
      getCore().kpc = new j(com.tencent.mm.kernel.g.RL().eHS);
    }
    j localj = getCore().kpc;
    AppMethodBeat.o(87962);
    return localj;
  }
  
  public static com.tencent.mm.plugin.card.b.g bct()
  {
    AppMethodBeat.i(87963);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (getCore().kpa == null) {
      getCore().kpa = new com.tencent.mm.plugin.card.b.g();
    }
    com.tencent.mm.plugin.card.b.g localg = getCore().kpa;
    AppMethodBeat.o(87963);
    return localg;
  }
  
  private static am getCore()
  {
    AppMethodBeat.i(87943);
    Object localObject = (com.tencent.mm.plugin.card.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.card.a.a.class);
    if (localObject != null) {}
    for (localObject = ((PluginCard)localObject).getCore();; localObject = null)
    {
      AppMethodBeat.o(87943);
      return localObject;
    }
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.d> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(87944);
    ab.i("MicroMsg.SubCoreCard", "onAccountPostReset, updated = %b", new Object[] { Boolean.valueOf(paramBoolean) });
    com.tencent.mm.sdk.b.a.ymk.c(this.kph);
    com.tencent.mm.sdk.b.a.ymk.c(this.kpi);
    com.tencent.mm.sdk.b.a.ymk.c(this.kpd);
    com.tencent.mm.sdk.b.a.ymk.c(this.kpe);
    com.tencent.mm.sdk.b.a.ymk.c(this.kpf);
    com.tencent.mm.sdk.b.a.ymk.c(this.kpl);
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("carditemmsg", this.kpj, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("notifysharecard", this.kpk, true);
    this.koU = null;
    if (this.koV != null)
    {
      this.koV.kln.clear();
      this.koV = null;
    }
    if (this.koP != null) {
      ??? = this.koP;
    }
    synchronized (((com.tencent.mm.plugin.card.b.m)???).kmf)
    {
      ((com.tencent.mm.plugin.card.b.m)???).kmf.clear();
      synchronized (((com.tencent.mm.plugin.card.b.m)???).kmg)
      {
        ((com.tencent.mm.plugin.card.b.m)???).kmg.clear();
        com.tencent.mm.kernel.g.RK().eHt.b(563, (f)???);
        ??? = com.tencent.mm.modelgeo.d.agQ();
        if (??? != null) {
          ((com.tencent.mm.modelgeo.b)???).c((b.a)???);
        }
        if (((com.tencent.mm.plugin.card.b.m)???).kmi != null) {
          com.tencent.mm.kernel.g.RK().eHt.a(((com.tencent.mm.plugin.card.b.m)???).kmi);
        }
        this.koP = null;
        if (this.koL != null)
        {
          this.koL.detach();
          this.koL = null;
        }
        if (this.koQ != null) {
          ??? = this.koQ;
        }
      }
    }
    synchronized (((com.tencent.mm.plugin.card.sharecard.a.a)???).eKs)
    {
      ((com.tencent.mm.plugin.card.sharecard.a.a)???).pendingList.clear();
      ((com.tencent.mm.plugin.card.sharecard.a.a)???).kkT.clear();
      if (((com.tencent.mm.plugin.card.sharecard.a.a)???).kpD != null) {
        com.tencent.mm.kernel.g.RK().eHt.a(((com.tencent.mm.plugin.card.sharecard.a.a)???).kpD);
      }
      com.tencent.mm.kernel.g.RK().eHt.b(903, (f)???);
      this.koQ = null;
      if (this.koX != null)
      {
        this.koX.release();
        ??? = this.koX;
        ((com.tencent.mm.plugin.card.b.d)???).kkV.clear();
        ((com.tencent.mm.plugin.card.b.d)???).klh.clear();
        ((com.tencent.mm.plugin.card.b.d)???).kli.clear();
        ((com.tencent.mm.plugin.card.b.d)???).klj.clear();
        ((com.tencent.mm.plugin.card.b.d)???).kll = false;
        this.koX = null;
      }
      if (this.koY == null) {
        break label573;
      }
      ??? = this.koY;
      com.tencent.mm.kernel.g.RK().eHt.b(907, (f)???);
      ??? = ((com.tencent.mm.plugin.card.b.j)???).klR.iterator();
      while (((Iterator)???).hasNext())
      {
        String str = (String)((Iterator)???).next();
        Runnable localRunnable = (Runnable)((com.tencent.mm.plugin.card.b.j)???).klT.get(str);
        ((com.tencent.mm.plugin.card.b.j)???).klT.remove(str);
        ((com.tencent.mm.plugin.card.b.j)???).klS.removeCallbacks(localRunnable);
        continue;
        localObject2 = finally;
        AppMethodBeat.o(87944);
        throw localObject2;
        localObject3 = finally;
        AppMethodBeat.o(87944);
        throw localObject3;
      }
    }
    localObject3.klQ.clear();
    localObject3.klR.clear();
    localObject3.klT.clear();
    this.koY = null;
    label573:
    if (this.koZ != null)
    {
      this.koZ.release();
      this.koZ = null;
    }
    if (this.kpa != null)
    {
      this.kpa.release();
      this.kpa = null;
    }
    this.koW = null;
    com.tencent.mm.plugin.card.ui.b localb = this.kpg;
    com.tencent.mm.plugin.card.ui.b.aMc().registerActivityLifecycleCallbacks(localb);
    AppMethodBeat.o(87944);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(87945);
    if (getCore().koL != null) {
      getCore().koL.detach();
    }
    com.tencent.mm.sdk.b.a.ymk.d(this.kph);
    com.tencent.mm.sdk.b.a.ymk.d(this.kpi);
    com.tencent.mm.sdk.b.a.ymk.d(this.kpd);
    com.tencent.mm.sdk.b.a.ymk.d(this.kpe);
    com.tencent.mm.sdk.b.a.ymk.d(this.kpf);
    com.tencent.mm.sdk.b.a.ymk.d(this.kpl);
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b("carditemmsg", this.kpj, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b("notifysharecard", this.kpk, true);
    com.tencent.mm.plugin.card.ui.b localb = this.kpg;
    com.tencent.mm.plugin.card.ui.b.aMc().unregisterActivityLifecycleCallbacks(localb);
    AppMethodBeat.o(87945);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.am
 * JD-Core Version:    0.7.0.1
 */