package com.tencent.mm.plugin.location.model;

import com.tencent.mm.ah.e.d;
import com.tencent.mm.ah.f;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.h.a.oi;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.bx;
import com.tencent.mm.model.bx.a;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.plugin.location.ui.impl.d;
import com.tencent.mm.protocal.c.bmz;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bi.b;
import java.util.HashMap;
import java.util.HashSet;

public class l
  implements ar
{
  private int lDA = 0;
  private com.tencent.mm.model.e lDB = new b();
  private com.tencent.mm.model.e lDC = new n();
  private o lDD = null;
  private p lDE = null;
  private i lDF = null;
  private m lDG = null;
  private d lDH = new d();
  private k lDI = null;
  private j lDJ = null;
  private f lDK = new f()
  {
    public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ah.m paramAnonymousm)
    {
      if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
      {
        paramAnonymousString = (v)paramAnonymousm;
        paramAnonymousm = paramAnonymousString.QP();
        if (paramAnonymousm.hQR == 0) {
          l.o(paramAnonymousString.bIt, v.nf(paramAnonymousm.sDW));
        }
      }
    }
  };
  private c lDL = new l.2(this);
  private c lDM = new c() {};
  private c lDN = new l.4(this);
  private c lDO = new l.5(this);
  private bx.a lDP = new l.6(this);
  private l.c lDw = new l.c((byte)0);
  private l.a lDx = new l.a((byte)0);
  private l.b lDy = new l.b((byte)0);
  private a.a lDz;
  
  public static void R(bi parambi)
  {
    if ((parambi != null) && (parambi.field_msgId != 0L))
    {
      bi.b localb = bi.b.aca(parambi.field_content);
      parambi = new v((float)localb.lCK, (float)localb.lCJ, parambi.field_msgId);
      com.tencent.mm.kernel.g.Dk().a(parambi, 0);
    }
  }
  
  private static l bdT()
  {
    return (l)com.tencent.mm.model.p.B(l.class);
  }
  
  public static a.a bdU()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (bdT().lDz == null) {
      bdT().lDz = new a.a();
    }
    return bdT().lDz;
  }
  
  public static k bdV()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (bdT().lDI == null) {
      bdT().lDI = new k();
    }
    return bdT().lDI;
  }
  
  public static j bdW()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (bdT().lDJ == null) {
      bdT().lDJ = new j();
    }
    return bdT().lDJ;
  }
  
  public static o bdX()
  {
    if (bdT().lDD == null) {
      bdT().lDD = new o();
    }
    return bdT().lDD;
  }
  
  public static p bdY()
  {
    if (bdT().lDE == null) {
      bdT().lDE = new p();
    }
    return bdT().lDE;
  }
  
  public static i bdZ()
  {
    if (bdT().lDF == null) {
      bdT().lDF = new i();
    }
    return bdT().lDF;
  }
  
  public static m bea()
  {
    if (bdT().lDG == null) {
      bdT().lDG = new m();
    }
    return bdT().lDG;
  }
  
  public static String beb()
  {
    return com.tencent.mm.kernel.g.DP().cachePath + "trackroom/";
  }
  
  public static void o(long paramLong, String paramString)
  {
    bi localbi = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().fd(paramLong);
    if (localbi.aVM())
    {
      localbi.ee(paramString);
      ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().a(paramLong, localbi);
    }
  }
  
  public final void bh(boolean paramBoolean)
  {
    e.d.a(Integer.valueOf(48), this.lDB);
    e.d.a(Integer.valueOf(61), this.lDC);
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("trackmsg", this.lDP, true);
    com.tencent.mm.kernel.g.Dk().a(424, this.lDK);
    com.tencent.mm.sdk.b.a.udP.c(this.lDw);
    com.tencent.mm.sdk.b.a.udP.c(this.lDx);
    com.tencent.mm.sdk.b.a.udP.c(this.lDL);
    com.tencent.mm.sdk.b.a.udP.c(this.lDM);
    com.tencent.mm.sdk.b.a.udP.c(this.lDN);
    com.tencent.mm.sdk.b.a.udP.c(this.lDO);
    com.tencent.mm.sdk.b.a.udP.c(this.lDy);
    com.tencent.mm.bg.d.eEY = bdX();
    com.tencent.mm.bg.d.eEX = bdY();
    com.tencent.mm.bx.a.a.a.uay = bea();
    com.tencent.mm.kernel.g.DN().CX();
    if (bdT().lDH == null) {
      bdT().lDH = new d();
    }
    com.tencent.mm.plugin.p.c.a.lKH = bdT().lDH;
  }
  
  public final void bi(boolean paramBoolean) {}
  
  public final void gf(int paramInt) {}
  
  public final void onAccountRelease()
  {
    if (this.lDD != null)
    {
      this.lDD.lEe = null;
      this.lDD.stop();
      this.lDD.sY(1);
    }
    e.d.b(Integer.valueOf(48), this.lDB);
    e.d.b(Integer.valueOf(61), this.lDC);
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b("trackmsg", this.lDP, true);
    com.tencent.mm.kernel.g.Dk().b(424, this.lDK);
    com.tencent.mm.sdk.b.a.udP.d(this.lDw);
    com.tencent.mm.sdk.b.a.udP.d(this.lDx);
    com.tencent.mm.sdk.b.a.udP.d(this.lDL);
    com.tencent.mm.sdk.b.a.udP.d(this.lDM);
    com.tencent.mm.sdk.b.a.udP.d(this.lDN);
    com.tencent.mm.sdk.b.a.udP.d(this.lDO);
    com.tencent.mm.sdk.b.a.udP.d(this.lDy);
    Object localObject;
    if (this.lDF != null)
    {
      localObject = this.lDF;
      ((i)localObject).bdS();
      ((i)localObject).lDb.clear();
    }
    if (this.lDI != null) {
      this.lDI.stop();
    }
    if (this.lDJ != null)
    {
      localObject = this.lDJ;
      bdV().a((com.tencent.mm.pluginsdk.location.a)localObject);
    }
  }
  
  public final HashMap<Integer, h.d> xe()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.l
 * JD-Core Version:    0.7.0.1
 */