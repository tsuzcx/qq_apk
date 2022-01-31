package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p.a;
import com.tencent.mm.g.a.z;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.b.a;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.network.n;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bd.a;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.be.a;
import com.tencent.mm.storage.y;
import junit.framework.Assert;

public final class aw
{
  private static aw flP;
  private static final bw flR;
  private final c flF;
  private final am flO;
  private com.tencent.mm.compatible.b.g flQ;
  private final int flS;
  final c.a flT;
  private ca flU;
  private bs flV;
  private e flW;
  private cd flX;
  private w flY;
  private bd.a flZ;
  private be.a fma;
  private be.a fmb;
  private f fmc;
  
  static
  {
    AppMethodBeat.i(16314);
    flP = null;
    flR = new bw();
    AppMethodBeat.o(16314);
  }
  
  private aw(am paramam, p.a parama)
  {
    AppMethodBeat.i(16295);
    this.flQ = null;
    this.flS = 1;
    this.flU = new ca();
    this.flV = new bs();
    this.flW = new e();
    this.flX = new cd();
    this.flY = new w();
    this.flZ = new bd.a()
    {
      public final void a(bd paramAnonymousbd, ad paramAnonymousad)
      {
        AppMethodBeat.i(16279);
        String str = paramAnonymousad.field_username;
        if (ad.nM(paramAnonymousad.field_username)) {
          paramAnonymousad.setUsername(ad.ark(paramAnonymousad.field_username));
        }
        if (bo.isNullOrNil(paramAnonymousad.Ht())) {
          paramAnonymousad.jq(com.tencent.mm.platformtools.g.wr(paramAnonymousad.field_nickname));
        }
        if (bo.isNullOrNil(paramAnonymousad.Hu())) {
          paramAnonymousad.jr(com.tencent.mm.platformtools.g.wq(paramAnonymousad.field_nickname));
        }
        if (bo.isNullOrNil(paramAnonymousad.field_conRemarkPYShort)) {
          paramAnonymousad.ju(com.tencent.mm.platformtools.g.wr(paramAnonymousad.field_conRemark));
        }
        if (bo.isNullOrNil(paramAnonymousad.field_conRemarkPYFull)) {
          paramAnonymousad.jt(com.tencent.mm.platformtools.g.wq(paramAnonymousad.field_conRemark));
        }
        if (t.e(paramAnonymousad))
        {
          paramAnonymousad.hs(43);
          paramAnonymousad.jq(com.tencent.mm.platformtools.g.wr(paramAnonymousad.Oe()));
          paramAnonymousad.jr(com.tencent.mm.platformtools.g.wq(paramAnonymousad.Oe()));
          paramAnonymousad.jt(com.tencent.mm.platformtools.g.wq(paramAnonymousad.Of()));
          paramAnonymousad.ju(paramAnonymousad.Of());
          AppMethodBeat.o(16279);
          return;
        }
        if (t.oD(str))
        {
          paramAnonymousad.Nx();
          paramAnonymousad.hx(4);
          paramAnonymousad.hs(33);
          if (paramAnonymousad != null) {
            break label336;
          }
        }
        label336:
        for (paramAnonymousbd = new ad();; paramAnonymousbd = paramAnonymousad)
        {
          paramAnonymousbd.setUsername(str);
          paramAnonymousbd.Nx();
          ab.y(paramAnonymousbd);
          paramAnonymousbd.NG();
          if (paramAnonymousad.NY()) {
            paramAnonymousad.hs(paramAnonymousad.Nu());
          }
          if (t.ot(str))
          {
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.MMCore", "update official account helper showhead %d", new Object[] { Integer.valueOf(31) });
            paramAnonymousad.hs(31);
          }
          if (paramAnonymousad.NW())
          {
            aw.aaz();
            c.YF().c(new String[] { str }, "@blacklist");
          }
          com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.MMCore", "onPreInsertContact2: %s, %s", new Object[] { paramAnonymousad.field_username, paramAnonymousad.Ht() });
          AppMethodBeat.o(16279);
          return;
        }
      }
    };
    this.fma = new aw.5(this);
    this.fmb = new aw.6(this);
    this.fmc = new f();
    this.flO = paramam;
    this.flT = new aw.1(this);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.b(aw.a.class, new aw.a(this));
    com.tencent.mm.kernel.g.RM().eIu.at(parama);
    this.flF = new c();
    h.qsU.idkeyStat(99L, 142L, 1L, false);
    com.tencent.mm.ai.t.a(new aw.2(this));
    com.tencent.mm.kernel.g.RM();
    paramam = com.tencent.mm.kernel.g.RK();
    parama = new aw.3(this);
    paramam.eHs.at(parama);
    AppMethodBeat.o(16295);
  }
  
  public static ae BY()
  {
    AppMethodBeat.i(16294);
    ae localae = aaw().flO.BY();
    AppMethodBeat.o(16294);
    return localae;
  }
  
  public static String QD()
  {
    AppMethodBeat.i(16310);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RJ();
    String str = com.tencent.mm.kernel.a.QD();
    AppMethodBeat.o(16310);
    return str;
  }
  
  public static boolean QP()
  {
    AppMethodBeat.i(16307);
    boolean bool = com.tencent.mm.kernel.a.QP();
    AppMethodBeat.o(16307);
    return bool;
  }
  
  public static String QX()
  {
    AppMethodBeat.i(16300);
    String str = com.tencent.mm.kernel.a.QX();
    AppMethodBeat.o(16300);
    return str;
  }
  
  public static boolean RG()
  {
    AppMethodBeat.i(16306);
    if (!ah.brt())
    {
      AppMethodBeat.o(16306);
      return false;
    }
    boolean bool = com.tencent.mm.kernel.g.RG();
    AppMethodBeat.o(16306);
    return bool;
  }
  
  @Deprecated
  public static com.tencent.mm.sdk.platformtools.al RO()
  {
    AppMethodBeat.i(16298);
    com.tencent.mm.sdk.platformtools.al localal = com.tencent.mm.kernel.g.RO();
    AppMethodBeat.o(16298);
    return localal;
  }
  
  public static com.tencent.mm.ai.p Rc()
  {
    AppMethodBeat.i(16303);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.ai.p localp = com.tencent.mm.kernel.g.RK().eHt;
    AppMethodBeat.o(16303);
    return localp;
  }
  
  public static void a(al paramal)
  {
    AppMethodBeat.i(16287);
    b.a(paramal);
    AppMethodBeat.o(16287);
  }
  
  public static void a(am paramam, p.a parama)
  {
    AppMethodBeat.i(16292);
    flP = new aw(paramam, parama);
    o.cj(ah.getContext());
    AppMethodBeat.o(16292);
  }
  
  public static void a(n paramn)
  {
    AppMethodBeat.i(16285);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().a(paramn);
    AppMethodBeat.o(16285);
  }
  
  public static com.tencent.mm.compatible.b.g aaA()
  {
    AppMethodBeat.i(16304);
    com.tencent.mm.compatible.b.g localg = com.tencent.mm.compatible.b.g.KC();
    AppMethodBeat.o(16304);
    return localg;
  }
  
  public static boolean aaB()
  {
    AppMethodBeat.i(16305);
    com.tencent.mm.kernel.g.RJ();
    boolean bool = com.tencent.mm.kernel.a.QT();
    AppMethodBeat.o(16305);
    return bool;
  }
  
  public static f aaC()
  {
    AppMethodBeat.i(16311);
    f localf = aaw().fmc;
    AppMethodBeat.o(16311);
    return localf;
  }
  
  public static boolean aas()
  {
    return flP == null;
  }
  
  public static bw aat()
  {
    AppMethodBeat.i(16289);
    aaw();
    bw localbw = flR;
    AppMethodBeat.o(16289);
    return localbw;
  }
  
  public static boolean aau()
  {
    AppMethodBeat.i(16290);
    boolean bool = com.tencent.mm.kernel.a.QO();
    AppMethodBeat.o(16290);
    return bool;
  }
  
  public static void aav()
  {
    AppMethodBeat.i(16291);
    com.tencent.mm.kernel.a.cv(false);
    AppMethodBeat.o(16291);
  }
  
  private static aw aaw()
  {
    AppMethodBeat.i(16296);
    Assert.assertNotNull("MMCore not initialized by MMApplication", flP);
    aw localaw = flP;
    AppMethodBeat.o(16296);
    return localaw;
  }
  
  public static y aax()
  {
    AppMethodBeat.i(16297);
    com.tencent.mm.kernel.g.RM();
    y localy = com.tencent.mm.kernel.g.RL().eHM;
    AppMethodBeat.o(16297);
    return localy;
  }
  
  public static void aay()
  {
    AppMethodBeat.i(16301);
    z localz = new z();
    com.tencent.mm.sdk.b.a.ymk.l(localz);
    AppMethodBeat.o(16301);
  }
  
  public static c aaz()
  {
    AppMethodBeat.i(16302);
    c localc = aaw().flF;
    if (localc != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("MMCore has not been initialize ?", bool);
      AppMethodBeat.o(16302);
      return localc;
    }
  }
  
  public static void b(n paramn)
  {
    AppMethodBeat.i(16286);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().b(paramn);
    AppMethodBeat.o(16286);
  }
  
  public static an getNotification()
  {
    AppMethodBeat.i(16293);
    an localan = aaw().flO.getNotification();
    AppMethodBeat.o(16293);
    return localan;
  }
  
  public static bz getSysCmdMsgExtension()
  {
    AppMethodBeat.i(16299);
    bz localbz = ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension();
    AppMethodBeat.o(16299);
    return localbz;
  }
  
  public static void hold()
  {
    AppMethodBeat.i(16308);
    com.tencent.mm.kernel.a.hold();
    AppMethodBeat.o(16308);
  }
  
  public static void mw(String paramString)
  {
    AppMethodBeat.i(16288);
    com.tencent.mm.kernel.a.mw(paramString);
    AppMethodBeat.o(16288);
  }
  
  public static void unhold()
  {
    AppMethodBeat.i(16309);
    com.tencent.mm.kernel.a.unhold();
    AppMethodBeat.o(16309);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.aw
 * JD-Core Version:    0.7.0.1
 */