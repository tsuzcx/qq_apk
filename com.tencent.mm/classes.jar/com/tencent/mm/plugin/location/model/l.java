package com.tencent.mm.plugin.location.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.d;
import com.tencent.mm.ai.f;
import com.tencent.mm.app.j.a;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.bz.a;
import com.tencent.mm.model.q;
import com.tencent.mm.modelsimple.w;
import com.tencent.mm.plugin.location.ui.impl.d;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.protocal.protobuf.bws;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bi.b;
import java.util.HashMap;
import java.util.HashSet;

public class l
  implements at
{
  private static j.a appForegroundListener;
  private l.c oaI;
  private l.a oaJ;
  private l.b oaK;
  private a.a oaL;
  private int oaM;
  private com.tencent.mm.model.e oaN;
  private com.tencent.mm.model.e oaO;
  private o oaP;
  private p oaQ;
  private i oaR;
  private m oaS;
  private d oaT;
  private k oaU;
  private j oaV;
  private f oaW;
  private c oaX;
  private c oaY;
  private c oaZ;
  private c oba;
  private bz.a obb;
  
  static
  {
    AppMethodBeat.i(145797);
    appForegroundListener = new l.4();
    AppMethodBeat.o(145797);
  }
  
  public l()
  {
    AppMethodBeat.i(113362);
    this.oaI = new l.c((byte)0);
    this.oaJ = new l.a((byte)0);
    this.oaK = new l.b((byte)0);
    this.oaM = 0;
    this.oaN = new b();
    this.oaO = new n();
    this.oaP = null;
    this.oaQ = null;
    this.oaR = null;
    this.oaS = null;
    this.oaT = new d();
    this.oaU = null;
    this.oaV = null;
    this.oaW = new f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ai.m paramAnonymousm)
      {
        AppMethodBeat.i(113343);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          paramAnonymousString = (w)paramAnonymousm;
          paramAnonymousm = paramAnonymousString.ajW();
          if (paramAnonymousm.jKs == 0) {
            l.o(paramAnonymousString.cpO, w.us(paramAnonymousm.wzV));
          }
        }
        AppMethodBeat.o(113343);
      }
    };
    this.oaX = new l.2(this);
    this.oaY = new l.3(this);
    this.oaZ = new l.5(this);
    this.oba = new l.6(this);
    this.obb = new l.7(this);
    AppMethodBeat.o(113362);
  }
  
  public static void X(bi parambi)
  {
    AppMethodBeat.i(113370);
    if ((parambi != null) && (parambi.field_msgId != 0L))
    {
      bi.b localb = bi.b.ask(parambi.field_content);
      parambi = new w((float)localb.nZW, (float)localb.nZV, parambi.field_msgId);
      g.Rc().a(parambi, 0);
    }
    AppMethodBeat.o(113370);
  }
  
  private static l bLn()
  {
    AppMethodBeat.i(113363);
    l locall = (l)q.S(l.class);
    AppMethodBeat.o(113363);
    return locall;
  }
  
  public static a.a bLo()
  {
    AppMethodBeat.i(113364);
    g.RJ().QQ();
    if (bLn().oaL == null) {
      bLn().oaL = new a.a();
    }
    a.a locala = bLn().oaL;
    AppMethodBeat.o(113364);
    return locala;
  }
  
  public static k bLp()
  {
    AppMethodBeat.i(113365);
    g.RJ().QQ();
    if (bLn().oaU == null) {
      bLn().oaU = new k();
    }
    k localk = bLn().oaU;
    AppMethodBeat.o(113365);
    return localk;
  }
  
  public static j bLq()
  {
    AppMethodBeat.i(113366);
    g.RJ().QQ();
    if (bLn().oaV == null) {
      bLn().oaV = new j();
    }
    j localj = bLn().oaV;
    AppMethodBeat.o(113366);
    return localj;
  }
  
  public static o bLr()
  {
    AppMethodBeat.i(113367);
    if (bLn().oaP == null) {
      bLn().oaP = new o();
    }
    o localo = bLn().oaP;
    AppMethodBeat.o(113367);
    return localo;
  }
  
  public static p bLs()
  {
    AppMethodBeat.i(113368);
    if (bLn().oaQ == null) {
      bLn().oaQ = new p();
    }
    p localp = bLn().oaQ;
    AppMethodBeat.o(113368);
    return localp;
  }
  
  public static i bLt()
  {
    AppMethodBeat.i(113369);
    if (bLn().oaR == null) {
      bLn().oaR = new i();
    }
    i locali = bLn().oaR;
    AppMethodBeat.o(113369);
    return locali;
  }
  
  public static String bLu()
  {
    AppMethodBeat.i(113371);
    String str = g.RL().cachePath + "trackroom/";
    AppMethodBeat.o(113371);
    return str;
  }
  
  public static void o(long paramLong, String paramString)
  {
    AppMethodBeat.i(113374);
    bi localbi = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().kB(paramLong);
    if (localbi.bCp())
    {
      localbi.kl(paramString);
      ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().a(paramLong, localbi);
    }
    AppMethodBeat.o(113374);
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.d> getBaseDBFactories()
  {
    return null;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(113372);
    e.d.a(Integer.valueOf(48), this.oaN);
    e.d.a(Integer.valueOf(61), this.oaO);
    ((com.tencent.mm.plugin.messenger.foundation.a.p)g.G(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("trackmsg", this.obb, true);
    g.Rc().a(424, this.oaW);
    com.tencent.mm.sdk.b.a.ymk.c(this.oaI);
    com.tencent.mm.sdk.b.a.ymk.c(this.oaJ);
    com.tencent.mm.sdk.b.a.ymk.c(this.oaX);
    com.tencent.mm.sdk.b.a.ymk.c(this.oaY);
    com.tencent.mm.sdk.b.a.ymk.c(this.oaZ);
    com.tencent.mm.sdk.b.a.ymk.c(this.oba);
    com.tencent.mm.sdk.b.a.ymk.c(this.oaK);
    appForegroundListener.alive();
    com.tencent.mm.bh.d.fUP = bLr();
    com.tencent.mm.bh.d.fUO = bLs();
    if (bLn().oaS == null) {
      bLn().oaS = new m();
    }
    com.tencent.mm.bx.a.a.a.yio = bLn().oaS;
    g.RJ().QQ();
    if (bLn().oaT == null) {
      bLn().oaT = new d();
    }
    com.tencent.mm.plugin.k.c.a.ohZ = bLn().oaT;
    AppMethodBeat.o(113372);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(113373);
    appForegroundListener.dead();
    if (this.oaP != null)
    {
      this.oaP.obr = null;
      this.oaP.stop();
      this.oaP.yb(1);
    }
    e.d.b(Integer.valueOf(48), this.oaN);
    e.d.b(Integer.valueOf(61), this.oaO);
    ((com.tencent.mm.plugin.messenger.foundation.a.p)g.G(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b("trackmsg", this.obb, true);
    g.Rc().b(424, this.oaW);
    com.tencent.mm.sdk.b.a.ymk.d(this.oaI);
    com.tencent.mm.sdk.b.a.ymk.d(this.oaJ);
    com.tencent.mm.sdk.b.a.ymk.d(this.oaX);
    com.tencent.mm.sdk.b.a.ymk.d(this.oaY);
    com.tencent.mm.sdk.b.a.ymk.d(this.oaZ);
    com.tencent.mm.sdk.b.a.ymk.d(this.oba);
    com.tencent.mm.sdk.b.a.ymk.d(this.oaK);
    Object localObject;
    if (this.oaR != null)
    {
      localObject = this.oaR;
      ((i)localObject).bLm();
      ((i)localObject).oan.clear();
    }
    if (this.oaU != null) {
      this.oaU.stop();
    }
    if (this.oaV != null)
    {
      localObject = this.oaV;
      bLp().b((com.tencent.mm.pluginsdk.location.a)localObject);
    }
    AppMethodBeat.o(113373);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.l
 * JD-Core Version:    0.7.0.1
 */