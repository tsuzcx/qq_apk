package com.tencent.mm.plugin.card.model;

import android.app.Application;
import android.os.Looper;
import com.tencent.mm.ah.f;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.bx;
import com.tencent.mm.model.bx.a;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.plugin.card.PluginCard;
import com.tencent.mm.plugin.card.b.d;
import com.tencent.mm.plugin.card.b.n;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class am
  implements ar
{
  private static HashMap<Integer, h.d> dgp;
  private com.tencent.mm.plugin.card.b.b inR;
  private c inS;
  private al inT;
  private h inU;
  private com.tencent.mm.plugin.card.b.m inV;
  private com.tencent.mm.plugin.card.sharecard.a.a inW;
  private com.tencent.mm.plugin.card.sharecard.model.k inX;
  private com.tencent.mm.plugin.card.sharecard.model.o inY;
  private com.tencent.mm.plugin.card.sharecard.a.c inZ;
  private com.tencent.mm.plugin.card.b.k ioa = null;
  private com.tencent.mm.plugin.card.b.e iob = null;
  private com.tencent.mm.plugin.card.b.l ioc = null;
  private d iod = null;
  private com.tencent.mm.plugin.card.b.j ioe = null;
  private com.tencent.mm.plugin.card.b.c iof;
  private com.tencent.mm.plugin.card.b.g iog;
  private l ioh;
  private j ioi;
  private com.tencent.mm.sdk.b.c ioj = new n();
  private com.tencent.mm.sdk.b.c iok = new com.tencent.mm.plugin.card.b.o();
  private com.tencent.mm.sdk.b.c iol = new com.tencent.mm.plugin.card.b.a();
  private com.tencent.mm.plugin.card.ui.b iom = new com.tencent.mm.plugin.card.ui.b();
  private com.tencent.mm.sdk.b.c ion = new am.1(this);
  private com.tencent.mm.sdk.b.c ioo = new am.4(this);
  private bx.a iop = new am.5(this);
  private bx.a ioq = new am.6(this);
  private ah mHandler = new ah(Looper.getMainLooper());
  
  static
  {
    HashMap localHashMap = new HashMap();
    dgp = localHashMap;
    localHashMap.put(Integer.valueOf("USERCARDINFO_TABLE".hashCode()), new am.7());
    dgp.put(Integer.valueOf("PENDINGCARDIDINFO_TABLE".hashCode()), new am.8());
    dgp.put(Integer.valueOf("CARDMSGINFO_TABLE".hashCode()), new am.9());
    dgp.put(Integer.valueOf("SHARECARDINFO_TABLE".hashCode()), new am.10());
    dgp.put(Integer.valueOf("SHARECARDSYNCITEMINFO_TABLE".hashCode()), new h.d()
    {
      public final String[] rK()
      {
        return com.tencent.mm.plugin.card.sharecard.model.o.dXp;
      }
    });
    dgp.put(Integer.valueOf("CARDQRCODECONFI_TABLE".hashCode()), new am.2());
    dgp.put(Integer.valueOf("CARDQRCODEDATAINFO_TABLE".hashCode()), new am.3());
  }
  
  public am()
  {
    File localFile = new File(m.inc);
    if (!localFile.exists()) {
      localFile.mkdir();
    }
    localFile = new File(m.ind);
    if (!localFile.exists()) {
      localFile.mkdir();
    }
  }
  
  public static com.tencent.mm.plugin.card.sharecard.model.k aAA()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (getCore().inX == null) {
      getCore().inX = new com.tencent.mm.plugin.card.sharecard.model.k(com.tencent.mm.kernel.g.DP().dKu);
    }
    return getCore().inX;
  }
  
  public static com.tencent.mm.plugin.card.sharecard.model.o aAB()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (getCore().inY == null) {
      getCore().inY = new com.tencent.mm.plugin.card.sharecard.model.o(com.tencent.mm.kernel.g.DP().dKu);
    }
    return getCore().inY;
  }
  
  public static com.tencent.mm.plugin.card.sharecard.a.c aAC()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (getCore().inZ == null) {
      getCore().inZ = new com.tencent.mm.plugin.card.sharecard.a.c();
    }
    return getCore().inZ;
  }
  
  public static d aAD()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (getCore().iod == null) {
      getCore().iod = new d();
    }
    return getCore().iod;
  }
  
  public static com.tencent.mm.plugin.card.b.j aAE()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (getCore().ioe == null) {
      getCore().ioe = new com.tencent.mm.plugin.card.b.j();
    }
    return getCore().ioe;
  }
  
  public static com.tencent.mm.plugin.card.b.c aAF()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (getCore().iof == null) {
      getCore().iof = new com.tencent.mm.plugin.card.b.c();
    }
    return getCore().iof;
  }
  
  public static l aAG()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (getCore().ioh == null) {
      getCore().ioh = new l(com.tencent.mm.kernel.g.DP().dKu);
    }
    return getCore().ioh;
  }
  
  public static j aAH()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (getCore().ioi == null) {
      getCore().ioi = new j(com.tencent.mm.kernel.g.DP().dKu);
    }
    return getCore().ioi;
  }
  
  public static com.tencent.mm.plugin.card.b.g aAI()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (getCore().iog == null) {
      getCore().iog = new com.tencent.mm.plugin.card.b.g();
    }
    return getCore().iog;
  }
  
  public static com.tencent.mm.plugin.card.b.b aAr()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (getCore().inR == null) {
      getCore().inR = new com.tencent.mm.plugin.card.b.b();
    }
    return getCore().inR;
  }
  
  public static c aAs()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (getCore().inS == null) {
      getCore().inS = new c(com.tencent.mm.kernel.g.DP().dKu);
    }
    return getCore().inS;
  }
  
  public static al aAt()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (getCore().inT == null) {
      getCore().inT = new al(com.tencent.mm.kernel.g.DP().dKu);
    }
    return getCore().inT;
  }
  
  public static h aAu()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (getCore().inU == null) {
      getCore().inU = new h(com.tencent.mm.kernel.g.DP().dKu);
    }
    return getCore().inU;
  }
  
  public static com.tencent.mm.plugin.card.b.m aAv()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (getCore().inV == null) {
      getCore().inV = new com.tencent.mm.plugin.card.b.m();
    }
    return getCore().inV;
  }
  
  public static com.tencent.mm.plugin.card.b.k aAw()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (getCore().ioa == null) {
      getCore().ioa = new com.tencent.mm.plugin.card.b.k();
    }
    return getCore().ioa;
  }
  
  public static com.tencent.mm.plugin.card.b.e aAx()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (getCore().iob == null) {
      getCore().iob = new com.tencent.mm.plugin.card.b.e();
    }
    return getCore().iob;
  }
  
  public static com.tencent.mm.plugin.card.b.l aAy()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (getCore().ioc == null) {
      getCore().ioc = new com.tencent.mm.plugin.card.b.l();
    }
    return getCore().ioc;
  }
  
  public static com.tencent.mm.plugin.card.sharecard.a.a aAz()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (getCore().inW == null) {
      getCore().inW = new com.tencent.mm.plugin.card.sharecard.a.a();
    }
    return getCore().inW;
  }
  
  private static am getCore()
  {
    com.tencent.mm.plugin.card.a.a locala = (com.tencent.mm.plugin.card.a.a)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.card.a.a.class);
    if (locala != null) {
      return ((PluginCard)locala).getCore();
    }
    return null;
  }
  
  public final void bh(boolean paramBoolean)
  {
    y.i("MicroMsg.SubCoreCard", "onAccountPostReset, updated = %b", new Object[] { Boolean.valueOf(paramBoolean) });
    com.tencent.mm.sdk.b.a.udP.c(this.ion);
    com.tencent.mm.sdk.b.a.udP.c(this.ioo);
    com.tencent.mm.sdk.b.a.udP.c(this.ioj);
    com.tencent.mm.sdk.b.a.udP.c(this.iok);
    com.tencent.mm.sdk.b.a.udP.c(this.iol);
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("carditemmsg", this.iop, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("notifysharecard", this.ioq, true);
    this.ioa = null;
    if (this.iob != null)
    {
      this.iob.ikn.clear();
      this.iob = null;
    }
    if (this.inV != null) {
      ??? = this.inV;
    }
    synchronized (((com.tencent.mm.plugin.card.b.m)???).ilh)
    {
      ((com.tencent.mm.plugin.card.b.m)???).ilh.clear();
      synchronized (((com.tencent.mm.plugin.card.b.m)???).ili)
      {
        ((com.tencent.mm.plugin.card.b.m)???).ili.clear();
        com.tencent.mm.kernel.g.DO().dJT.b(563, (f)???);
        ??? = com.tencent.mm.modelgeo.c.Ob();
        if (??? != null) {
          ((com.tencent.mm.modelgeo.a)???).c((a.a)???);
        }
        if (((com.tencent.mm.plugin.card.b.m)???).ilk != null) {
          com.tencent.mm.kernel.g.DO().dJT.c(((com.tencent.mm.plugin.card.b.m)???).ilk);
        }
        this.inV = null;
        if (this.inR != null)
        {
          this.inR.detach();
          this.inR = null;
        }
        if (this.inW != null) {
          ??? = this.inW;
        }
      }
    }
    synchronized (((com.tencent.mm.plugin.card.sharecard.a.a)???).dMQ)
    {
      ((com.tencent.mm.plugin.card.sharecard.a.a)???).ijT.clear();
      ((com.tencent.mm.plugin.card.sharecard.a.a)???).ijU.clear();
      if (((com.tencent.mm.plugin.card.sharecard.a.a)???).iow != null) {
        com.tencent.mm.kernel.g.DO().dJT.c(((com.tencent.mm.plugin.card.sharecard.a.a)???).iow);
      }
      com.tencent.mm.kernel.g.DO().dJT.b(903, (f)???);
      this.inW = null;
      if (this.iod != null)
      {
        this.iod.release();
        ??? = this.iod;
        ((d)???).fKm.clear();
        ((d)???).ikh.clear();
        ((d)???).iki.clear();
        ((d)???).ikj.clear();
        ((d)???).ikl = false;
        this.iod = null;
      }
      if (this.ioe == null) {
        break label538;
      }
      ??? = this.ioe;
      com.tencent.mm.kernel.g.DO().dJT.b(907, (f)???);
      ??? = ((com.tencent.mm.plugin.card.b.j)???).ikT.iterator();
      while (((Iterator)???).hasNext())
      {
        String str = (String)((Iterator)???).next();
        Runnable localRunnable = (Runnable)((com.tencent.mm.plugin.card.b.j)???).ikV.get(str);
        ((com.tencent.mm.plugin.card.b.j)???).ikV.remove(str);
        ((com.tencent.mm.plugin.card.b.j)???).ikU.removeCallbacks(localRunnable);
        continue;
        localObject2 = finally;
        throw localObject2;
        localObject3 = finally;
        throw localObject3;
      }
    }
    localObject3.ikS.clear();
    localObject3.ikT.clear();
    localObject3.ikV.clear();
    this.ioe = null;
    label538:
    if (this.iof != null)
    {
      this.iof.release();
      this.iof = null;
    }
    if (this.iog != null)
    {
      this.iog.release();
      this.iog = null;
    }
    this.ioc = null;
    com.tencent.mm.plugin.card.ui.b localb = this.iom;
    com.tencent.mm.plugin.card.ui.b.aoU().registerActivityLifecycleCallbacks(localb);
  }
  
  public final void bi(boolean paramBoolean) {}
  
  public final void gf(int paramInt) {}
  
  public final void onAccountRelease()
  {
    if (getCore().inR != null) {
      getCore().inR.detach();
    }
    com.tencent.mm.sdk.b.a.udP.d(this.ion);
    com.tencent.mm.sdk.b.a.udP.d(this.ioo);
    com.tencent.mm.sdk.b.a.udP.d(this.ioj);
    com.tencent.mm.sdk.b.a.udP.d(this.iok);
    com.tencent.mm.sdk.b.a.udP.d(this.iol);
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b("carditemmsg", this.iop, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b("notifysharecard", this.ioq, true);
    com.tencent.mm.plugin.card.ui.b localb = this.iom;
    com.tencent.mm.plugin.card.ui.b.aoU().unregisterActivityLifecycleCallbacks(localb);
  }
  
  public final HashMap<Integer, h.d> xe()
  {
    return dgp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.am
 * JD-Core Version:    0.7.0.1
 */