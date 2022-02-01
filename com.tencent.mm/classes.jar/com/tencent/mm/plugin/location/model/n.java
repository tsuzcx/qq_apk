package com.tencent.mm.plugin.location.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.ak.f.c;
import com.tencent.mm.ak.f.d;
import com.tencent.mm.g.a.bt;
import com.tencent.mm.g.a.fh;
import com.tencent.mm.g.a.hc;
import com.tencent.mm.g.a.ji;
import com.tencent.mm.g.a.kw;
import com.tencent.mm.g.a.ky;
import com.tencent.mm.g.a.rk;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.cc;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.model.t;
import com.tencent.mm.modelsimple.w;
import com.tencent.mm.plugin.location.ui.impl.d;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.protocal.protobuf.csc;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.bo.b;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.HashSet;

public class n
  implements aw
{
  private static com.tencent.mm.app.n.a appForegroundListener;
  private int tXA;
  private com.tencent.mm.model.e tXB;
  private com.tencent.mm.model.e tXC;
  private q tXD;
  private r tXE;
  private k tXF;
  private o tXG;
  private d tXH;
  private m tXI;
  private l tXJ;
  private com.tencent.mm.ak.g tXK;
  private c tXL;
  private c tXM;
  private c tXN;
  private c tXO;
  private cc.a tXP;
  private c tXw;
  private a tXx;
  private b tXy;
  private a.a tXz;
  
  static
  {
    AppMethodBeat.i(55749);
    appForegroundListener = new com.tencent.mm.app.n.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(55729);
        if ((com.tencent.mm.kernel.g.agM()) && (com.tencent.mm.kernel.g.agP().ggT))
        {
          com.tencent.mm.kernel.g.agP();
          if (!com.tencent.mm.kernel.a.afS())
          {
            paramAnonymousString = new rk();
            paramAnonymousString.dus.active = false;
            com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousString);
          }
        }
        AppMethodBeat.o(55729);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(55728);
        if ((com.tencent.mm.kernel.g.agM()) && (com.tencent.mm.kernel.g.agP().ggT))
        {
          com.tencent.mm.kernel.g.agP();
          if (!com.tencent.mm.kernel.a.afS())
          {
            paramAnonymousString = new rk();
            paramAnonymousString.dus.active = true;
            com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousString);
          }
        }
        AppMethodBeat.o(55728);
      }
    };
    AppMethodBeat.o(55749);
  }
  
  public n()
  {
    AppMethodBeat.i(55736);
    this.tXw = new c((byte)0);
    this.tXx = new a((byte)0);
    this.tXy = new b((byte)0);
    this.tXA = 0;
    this.tXB = new b();
    this.tXC = new p();
    this.tXD = null;
    this.tXE = null;
    this.tXF = null;
    this.tXG = null;
    this.tXH = new d();
    this.tXI = null;
    this.tXJ = null;
    this.tXK = new com.tencent.mm.ak.g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
      {
        AppMethodBeat.i(55725);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          paramAnonymousString = (w)paramAnonymousn;
          paramAnonymousn = paramAnonymousString.aHQ();
          if (paramAnonymousn.ndI == 0) {
            n.r(paramAnonymousString.msgId, w.Dk(paramAnonymousn.EUm));
          }
        }
        AppMethodBeat.o(55725);
      }
    };
    this.tXL = new c() {};
    this.tXM = new c() {};
    this.tXN = new c() {};
    this.tXO = new c() {};
    this.tXP = new cc.a()
    {
      public final void a(f.a paramAnonymousa)
      {
        AppMethodBeat.i(55732);
        new p().b(paramAnonymousa);
        AppMethodBeat.o(55732);
      }
      
      public final void a(f.c paramAnonymousc) {}
    };
    AppMethodBeat.o(55736);
  }
  
  public static void an(bo parambo)
  {
    AppMethodBeat.i(55744);
    if ((parambo != null) && (parambo.field_msgId != 0L))
    {
      bo.b localb = bo.b.aOl(parambo.field_content);
      parambo = new w((float)localb.tWJ, (float)localb.tWI, parambo.field_msgId);
      com.tencent.mm.kernel.g.agi().a(parambo, 0);
    }
    AppMethodBeat.o(55744);
  }
  
  private static n cWR()
  {
    AppMethodBeat.i(55737);
    n localn = (n)t.ap(n.class);
    AppMethodBeat.o(55737);
    return localn;
  }
  
  public static a.a cWS()
  {
    AppMethodBeat.i(55738);
    com.tencent.mm.kernel.g.agP().afT();
    if (cWR().tXz == null) {
      cWR().tXz = new a.a();
    }
    a.a locala = cWR().tXz;
    AppMethodBeat.o(55738);
    return locala;
  }
  
  public static m cWT()
  {
    AppMethodBeat.i(55739);
    com.tencent.mm.kernel.g.agP().afT();
    if (cWR().tXI == null) {
      cWR().tXI = new m();
    }
    m localm = cWR().tXI;
    AppMethodBeat.o(55739);
    return localm;
  }
  
  public static l cWU()
  {
    AppMethodBeat.i(55740);
    com.tencent.mm.kernel.g.agP().afT();
    if (cWR().tXJ == null) {
      cWR().tXJ = new l();
    }
    l locall = cWR().tXJ;
    AppMethodBeat.o(55740);
    return locall;
  }
  
  public static q cWV()
  {
    AppMethodBeat.i(55741);
    if (cWR().tXD == null) {
      cWR().tXD = new q();
    }
    q localq = cWR().tXD;
    AppMethodBeat.o(55741);
    return localq;
  }
  
  public static r cWW()
  {
    AppMethodBeat.i(55742);
    if (cWR().tXE == null) {
      cWR().tXE = new r();
    }
    r localr = cWR().tXE;
    AppMethodBeat.o(55742);
    return localr;
  }
  
  public static k cWX()
  {
    AppMethodBeat.i(55743);
    if (cWR().tXF == null) {
      cWR().tXF = new k();
    }
    k localk = cWR().tXF;
    AppMethodBeat.o(55743);
    return localk;
  }
  
  public static String cWY()
  {
    AppMethodBeat.i(55745);
    String str = com.tencent.mm.kernel.g.agR().cachePath + "trackroom/";
    AppMethodBeat.o(55745);
    return str;
  }
  
  public static void r(long paramLong, String paramString)
  {
    AppMethodBeat.i(55748);
    bo localbo = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().vP(paramLong);
    if (localbo.cKP())
    {
      localbo.rg(paramString);
      ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().a(paramLong, localbo);
    }
    AppMethodBeat.o(55748);
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(55746);
    f.d.a(Integer.valueOf(48), this.tXB);
    f.d.a(Integer.valueOf(61), this.tXC);
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().a("trackmsg", this.tXP, true);
    com.tencent.mm.kernel.g.agi().a(424, this.tXK);
    com.tencent.mm.sdk.b.a.GpY.c(this.tXw);
    com.tencent.mm.sdk.b.a.GpY.c(this.tXx);
    com.tencent.mm.sdk.b.a.GpY.c(this.tXL);
    com.tencent.mm.sdk.b.a.GpY.c(this.tXM);
    com.tencent.mm.sdk.b.a.GpY.c(this.tXN);
    com.tencent.mm.sdk.b.a.GpY.c(this.tXO);
    com.tencent.mm.sdk.b.a.GpY.c(this.tXy);
    appForegroundListener.alive();
    com.tencent.mm.bi.d.hXZ = cWV();
    r localr = cWW();
    com.tencent.mm.bi.d.hXY = localr;
    localr.aIK();
    if (cWR().tXG == null) {
      cWR().tXG = new o();
    }
    com.tencent.mm.bx.a.a.a.Gik = cWR().tXG;
    com.tencent.mm.kernel.g.agP().afT();
    if (cWR().tXH == null) {
      cWR().tXH = new d();
    }
    com.tencent.mm.plugin.k.c.a.ufP = cWR().tXH;
    AppMethodBeat.o(55746);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(55747);
    appForegroundListener.dead();
    if (this.tXD != null)
    {
      this.tXD.tYe = null;
      this.tXD.stop();
      this.tXD.HA(1);
    }
    f.d.b(Integer.valueOf(48), this.tXB);
    f.d.b(Integer.valueOf(61), this.tXC);
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().b("trackmsg", this.tXP, true);
    com.tencent.mm.kernel.g.agi().b(424, this.tXK);
    com.tencent.mm.sdk.b.a.GpY.d(this.tXw);
    com.tencent.mm.sdk.b.a.GpY.d(this.tXx);
    com.tencent.mm.sdk.b.a.GpY.d(this.tXL);
    com.tencent.mm.sdk.b.a.GpY.d(this.tXM);
    com.tencent.mm.sdk.b.a.GpY.d(this.tXN);
    com.tencent.mm.sdk.b.a.GpY.d(this.tXO);
    com.tencent.mm.sdk.b.a.GpY.d(this.tXy);
    Object localObject;
    if (this.tXF != null)
    {
      localObject = this.tXF;
      ((k)localObject).cWQ();
      ((k)localObject).tXb.clear();
    }
    if (this.tXI != null) {
      this.tXI.stop();
    }
    if (this.tXJ != null)
    {
      localObject = this.tXJ;
      cWT().b((com.tencent.mm.pluginsdk.location.b)localObject);
    }
    AppMethodBeat.o(55747);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
  
  static final class a
    extends c<hc>
  {
    private a()
    {
      AppMethodBeat.i(160947);
      this.__eventId = hc.class.getName().hashCode();
      AppMethodBeat.o(160947);
    }
  }
  
  static final class b
    extends c<kw>
  {
    private b()
    {
      AppMethodBeat.i(160949);
      this.__eventId = kw.class.getName().hashCode();
      AppMethodBeat.o(160949);
    }
  }
  
  static final class c
    extends c<ky>
  {
    private volatile boolean mIsStarted;
    
    private c()
    {
      AppMethodBeat.i(160951);
      this.mIsStarted = false;
      this.__eventId = ky.class.getName().hashCode();
      AppMethodBeat.o(160951);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.n
 * JD-Core Version:    0.7.0.1
 */