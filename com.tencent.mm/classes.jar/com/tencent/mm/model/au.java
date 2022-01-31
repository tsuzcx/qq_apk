package com.tencent.mm.model;

import com.tencent.mm.ah.p.a;
import com.tencent.mm.ah.t;
import com.tencent.mm.h.a.z;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.b.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.network.n;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.storage.bd.a;
import com.tencent.mm.storage.be.a;
import com.tencent.mm.storage.y;
import junit.framework.Assert;

public final class au
{
  private static au dVF = null;
  private static final bu dVH = new bu();
  private final ak dVE;
  private com.tencent.mm.compatible.b.f dVG = null;
  private final int dVI = 1;
  final c.a dVJ;
  private by dVK = new by();
  private bq dVL = new bq();
  private e dVM = new e();
  private cb dVN = new cb();
  private v dVO = new v();
  private bd.a dVP = new au.4(this);
  private be.a dVQ = new au.5(this);
  private be.a dVR = new au.6(this);
  private f dVS = new f();
  private final c dVv;
  
  private au(ak paramak, p.a parama)
  {
    this.dVE = paramak;
    this.dVJ = new au.1(this);
    g.DQ();
    g.a(au.a.class, new au.a(this));
    g.DQ().dKW.aj(parama);
    this.dVv = new c();
    h.nFQ.a(99L, 142L, 1L, false);
    t.a(new au.2(this));
    g.DQ();
    paramak = g.DO();
    parama = new au.3(this);
    paramak.dJS.aj(parama);
  }
  
  public static String CM()
  {
    g.DQ();
    g.DN();
    return com.tencent.mm.kernel.a.CM();
  }
  
  public static boolean CW()
  {
    return com.tencent.mm.kernel.a.CW();
  }
  
  public static boolean DK()
  {
    if (!ae.cqV()) {
      return false;
    }
    return g.DK();
  }
  
  public static ai DS()
  {
    return g.DS();
  }
  
  public static String Df()
  {
    return com.tencent.mm.kernel.a.Df();
  }
  
  public static com.tencent.mm.ah.p Dk()
  {
    g.DQ();
    return g.DO().dJT;
  }
  
  public static f HA()
  {
    return Hu().dVS;
  }
  
  public static boolean Hp()
  {
    return dVF == null;
  }
  
  public static bu Hq()
  {
    Hu();
    return dVH;
  }
  
  public static boolean Hr()
  {
    return com.tencent.mm.kernel.a.CV();
  }
  
  public static void Hs()
  {
    com.tencent.mm.kernel.a.bF(false);
  }
  
  public static void Ht() {}
  
  private static au Hu()
  {
    Assert.assertNotNull("MMCore not initialized by MMApplication", dVF);
    return dVF;
  }
  
  public static y Hv()
  {
    g.DQ();
    return g.DP().dKo;
  }
  
  public static void Hw()
  {
    z localz = new z();
    com.tencent.mm.sdk.b.a.udP.m(localz);
  }
  
  public static c Hx()
  {
    c localc = Hu().dVv;
    if (localc != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("MMCore has not been initialize ?", bool);
      return localc;
    }
  }
  
  public static com.tencent.mm.compatible.b.f Hy()
  {
    return com.tencent.mm.compatible.b.f.yi();
  }
  
  public static boolean Hz()
  {
    g.DN();
    return com.tencent.mm.kernel.a.Db();
  }
  
  public static void a(aj paramaj)
  {
    b.a(paramaj);
  }
  
  public static void a(ak paramak, p.a parama)
  {
    dVF = new au(paramak, parama);
    o.bE(ae.getContext());
  }
  
  public static void a(n paramn)
  {
    g.DQ();
    g.DO().a(paramn);
  }
  
  public static void b(n paramn)
  {
    g.DQ();
    g.DO().b(paramn);
  }
  
  public static void gc(String paramString)
  {
    com.tencent.mm.kernel.a.gc(paramString);
  }
  
  public static al getNotification()
  {
    return Hu().dVE.getNotification();
  }
  
  public static bx getSysCmdMsgExtension()
  {
    return ((com.tencent.mm.plugin.messenger.foundation.a.p)g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension();
  }
  
  public static void hold() {}
  
  public static ad tu()
  {
    return Hu().dVE.tu();
  }
  
  public static void unhold() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.au
 * JD-Core Version:    0.7.0.1
 */