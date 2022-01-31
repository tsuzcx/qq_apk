package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.g.a.vt;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.at;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.bz.a;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.luckymoney.model.av;
import com.tencent.mm.plugin.luckymoney.model.j;
import com.tencent.mm.plugin.luckymoney.model.m;
import com.tencent.mm.plugin.luckymoney.model.o;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.pluginsdk.model.app.t;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.z;
import java.io.File;
import java.util.HashMap;

public class a
  implements at
{
  private static HashMap<Integer, h.d> baseDBFactories;
  private bz.a kMG;
  private j oie;
  private com.tencent.mm.plugin.luckymoney.model.p oif;
  private com.tencent.mm.plugin.luckymoney.model.h oig;
  private av oih;
  private com.tencent.mm.cm.h<o> oii;
  private m oij;
  private com.tencent.mm.sdk.b.c<vt> oik;
  
  static
  {
    AppMethodBeat.i(41979);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("LuckyMoneyEnvelopeResource".hashCode()), new a.2());
    AppMethodBeat.o(41979);
  }
  
  public a()
  {
    AppMethodBeat.i(41973);
    this.oig = new com.tencent.mm.plugin.luckymoney.model.h();
    this.oii = new com.tencent.mm.cm.h(new a.1(this));
    this.oij = new m();
    this.kMG = new a.3(this);
    this.oik = new a.4(this);
    File localFile = new File(bMI());
    if (!localFile.exists()) {
      localFile.mkdir();
    }
    AppMethodBeat.o(41973);
  }
  
  public static a bMG()
  {
    AppMethodBeat.i(41972);
    a locala = (a)q.S(a.class);
    AppMethodBeat.o(41972);
    return locala;
  }
  
  public static j bMH()
  {
    AppMethodBeat.i(41976);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (bMG().oie == null) {
      bMG().oie = new j();
    }
    j localj = bMG().oie;
    AppMethodBeat.o(41976);
    return localj;
  }
  
  public static String bMI()
  {
    AppMethodBeat.i(41977);
    if (com.tencent.mm.kernel.g.RG())
    {
      String str = com.tencent.mm.plugin.i.c.YK() + "luckymoney";
      AppMethodBeat.o(41977);
      return str;
    }
    AppMethodBeat.o(41977);
    return "";
  }
  
  public final o bMF()
  {
    AppMethodBeat.i(41971);
    o localo = (o)this.oii.get();
    AppMethodBeat.o(41971);
    return localo;
  }
  
  public final com.tencent.mm.plugin.luckymoney.model.p bMJ()
  {
    try
    {
      AppMethodBeat.i(41978);
      if (this.oif == null) {
        this.oif = new com.tencent.mm.plugin.luckymoney.model.p();
      }
      com.tencent.mm.plugin.luckymoney.model.p localp = this.oif;
      AppMethodBeat.o(41978);
      return localp;
    }
    finally {}
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.d> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(41974);
    am localam = am.dlO();
    if (com.tencent.mm.kernel.g.RG())
    {
      com.tencent.mm.plugin.s.a.caf().a(4, localam);
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RK().eHt.a(1060, localam);
    }
    this.oij.alive();
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("paymsg", this.kMG, true);
    boolean bool = false;
    com.tencent.mm.kernel.g.RM();
    long l = com.tencent.mm.kernel.g.RL().Ru().Ns(352276);
    if (System.currentTimeMillis() - l >= 43200000L) {
      bool = true;
    }
    ab.i("MicroMsg.SubCoreLuckyMoney", "isTime=" + bool + ", isUpdate=" + paramBoolean);
    if ((paramBoolean) || (bool))
    {
      ab.i("MicroMsg.SubCoreLuckyMoney", "get service applist");
      am.dlO().fT(ah.getContext());
    }
    com.tencent.mm.sdk.b.a.ymk.c(this.oig);
    com.tencent.mm.sdk.b.a.ymk.c(this.oik);
    this.oih = new av();
    com.tencent.mm.plugin.luckymoney.model.g.bNi();
    AppMethodBeat.o(41974);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(41975);
    Object localObject1 = am.dlO();
    if (com.tencent.mm.kernel.g.RG())
    {
      com.tencent.mm.plugin.s.a.caf().b(4, (t)localObject1);
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RK().eHt.b(1060, (f)localObject1);
      ((am)localObject1).vMe = false;
      ((am)localObject1).vMf = false;
    }
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b("paymsg", this.kMG, true);
    try
    {
      this.oif = null;
      com.tencent.mm.sdk.b.a.ymk.d(this.oig);
      com.tencent.mm.sdk.b.a.ymk.d(this.oik);
      if (this.oih != null)
      {
        localObject1 = this.oih;
        com.tencent.mm.sdk.b.a.ymk.d(((av)localObject1).opW);
        if (((av)localObject1).opT != null)
        {
          com.tencent.mm.kernel.g.RM();
          com.tencent.mm.kernel.g.RK().eHt.a(((av)localObject1).opT);
          ((av)localObject1).opT = null;
        }
        if (((av)localObject1).opU != null)
        {
          com.tencent.mm.kernel.g.RM();
          com.tencent.mm.kernel.g.RK().eHt.a(((av)localObject1).opU);
          ((av)localObject1).opU = null;
        }
      }
      com.tencent.mm.plugin.luckymoney.model.g.aoR();
      this.oij.dead();
      AppMethodBeat.o(41975);
      return;
    }
    finally
    {
      AppMethodBeat.o(41975);
    }
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.b.a
 * JD-Core Version:    0.7.0.1
 */