package com.tencent.mm.aj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.d;
import com.tencent.mm.aj.a.d;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.model.at;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.bz.a;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.be.a;
import com.tencent.mm.storage.r;
import com.tencent.mm.storage.t;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;

public class z
  implements at
{
  private static HashMap<Integer, h.d> baseDBFactories;
  private static long fwQ;
  private com.tencent.mm.model.e flW;
  private e fwR;
  private m.a fwS;
  private k fwT;
  private i fwU;
  private h fwV;
  private d fwW;
  private com.tencent.mm.aj.a.b fwX;
  private com.tencent.mm.aj.a.k fwY;
  private com.tencent.mm.aj.a.g fwZ;
  private com.tencent.mm.aj.a.i fxa;
  private com.tencent.mm.aj.a.h fxb;
  private c fxc;
  private r fxd;
  private t fxe;
  private a fxf;
  private bz.a fxg;
  private be.a fxh;
  private e.a fxi;
  
  static
  {
    AppMethodBeat.i(11488);
    fwQ = 0L;
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("BIZINFO_TABLE".hashCode()), new z.1());
    baseDBFactories.put(Integer.valueOf("BIZKF_TABLE".hashCode()), new z.3());
    baseDBFactories.put(Integer.valueOf("BIZCHAT_TABLE".hashCode()), new z.4());
    baseDBFactories.put(Integer.valueOf("BIZCHATUSER_TABLE".hashCode()), new z.5());
    baseDBFactories.put(Integer.valueOf("BIZCONVERSATION_TABLE".hashCode()), new z.6());
    baseDBFactories.put(Integer.valueOf("BIZCHAMYUSERINFO_TABLE".hashCode()), new z.7());
    baseDBFactories.put(Integer.valueOf("BIZENTERPRISE_TABLE".hashCode()), new z.8());
    AppMethodBeat.o(11488);
  }
  
  public z()
  {
    AppMethodBeat.i(11467);
    this.fwS = null;
    this.fwT = null;
    this.fwV = null;
    this.fwW = null;
    this.fwX = null;
    this.fwY = null;
    this.fwZ = null;
    this.fxa = null;
    this.fxb = null;
    this.fxc = null;
    this.fxd = null;
    this.fxe = null;
    this.flW = new com.tencent.mm.model.e();
    this.fxg = new z.9(this);
    this.fxh = new z.10(this);
    this.fxi = new z.2(this);
    AppMethodBeat.o(11467);
  }
  
  private static z afg()
  {
    try
    {
      AppMethodBeat.i(11468);
      z localz = (z)q.S(z.class);
      AppMethodBeat.o(11468);
      return localz;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static i afh()
  {
    AppMethodBeat.i(11469);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (afg().fwU == null) {
      afg().fwU = new i(com.tencent.mm.kernel.g.RL().eHS);
    }
    i locali = afg().fwU;
    AppMethodBeat.o(11469);
    return locali;
  }
  
  public static e afi()
  {
    AppMethodBeat.i(11470);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (afg().fwR == null) {
      afg().fwR = new e(com.tencent.mm.kernel.g.RL().eHS);
    }
    e locale = afg().fwR;
    AppMethodBeat.o(11470);
    return locale;
  }
  
  public static h afj()
  {
    AppMethodBeat.i(11471);
    com.tencent.mm.kernel.g.RJ().QQ();
    h localh;
    if (afg().fwV == null)
    {
      afg().fwV = new h();
      localh = afg().fwV;
      com.tencent.mm.kernel.g.RK().eHt.a(675, localh);
      com.tencent.mm.kernel.g.RK().eHt.a(672, localh);
      com.tencent.mm.kernel.g.RK().eHt.a(674, localh);
    }
    synchronized (localh.ceY)
    {
      localh.fwn.clear();
      ??? = afg().fwV;
      AppMethodBeat.o(11471);
      return ???;
    }
  }
  
  public static d afk()
  {
    AppMethodBeat.i(11472);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (afg().fwW == null) {
      afg().fwW = new d(com.tencent.mm.kernel.g.RL().eHS);
    }
    d locald = afg().fwW;
    AppMethodBeat.o(11472);
    return locald;
  }
  
  public static com.tencent.mm.aj.a.b afl()
  {
    AppMethodBeat.i(11473);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (afg().fwX == null) {
      afg().fwX = new com.tencent.mm.aj.a.b(com.tencent.mm.kernel.g.RL().eHS);
    }
    com.tencent.mm.aj.a.b localb = afg().fwX;
    AppMethodBeat.o(11473);
    return localb;
  }
  
  public static com.tencent.mm.aj.a.k afm()
  {
    AppMethodBeat.i(11474);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (afg().fwY == null) {
      afg().fwY = new com.tencent.mm.aj.a.k(com.tencent.mm.kernel.g.RL().eHS);
    }
    com.tencent.mm.aj.a.k localk = afg().fwY;
    AppMethodBeat.o(11474);
    return localk;
  }
  
  public static com.tencent.mm.aj.a.g afn()
  {
    AppMethodBeat.i(11475);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (afg().fwZ == null) {
      afg().fwZ = new com.tencent.mm.aj.a.g(com.tencent.mm.kernel.g.RL().eHS);
    }
    com.tencent.mm.aj.a.g localg = afg().fwZ;
    AppMethodBeat.o(11475);
    return localg;
  }
  
  public static r afo()
  {
    AppMethodBeat.i(11476);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (afg().fxd == null) {
      afg().fxd = new r(com.tencent.mm.kernel.g.RL().eHS);
    }
    r localr = afg().fxd;
    AppMethodBeat.o(11476);
    return localr;
  }
  
  public static t afp()
  {
    AppMethodBeat.i(11477);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (afg().fxe == null) {
      afg().fxe = new t(com.tencent.mm.kernel.g.RL().eHS);
    }
    t localt = afg().fxe;
    AppMethodBeat.o(11477);
    return localt;
  }
  
  public static com.tencent.mm.aj.a.h afq()
  {
    AppMethodBeat.i(11478);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (afg().fxb == null) {
      afg().fxb = new com.tencent.mm.aj.a.h();
    }
    com.tencent.mm.aj.a.h localh = afg().fxb;
    AppMethodBeat.o(11478);
    return localh;
  }
  
  public static c afr()
  {
    AppMethodBeat.i(11479);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (afg().fxc == null) {
      afg().fxc = new c(com.tencent.mm.kernel.g.RL().eHS);
    }
    c localc = afg().fxc;
    AppMethodBeat.o(11479);
    return localc;
  }
  
  public static m.a afs()
  {
    AppMethodBeat.i(11480);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (afg().fwS == null) {
      afg().fwS = new m.a();
    }
    m.a locala = afg().fwS;
    AppMethodBeat.o(11480);
    return locala;
  }
  
  public static k aft()
  {
    AppMethodBeat.i(11481);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (afg().fwT == null) {
      afg().fwT = new k();
    }
    k localk = afg().fwT;
    AppMethodBeat.o(11481);
    return localk;
  }
  
  public static a afu()
  {
    AppMethodBeat.i(11482);
    if (afg().fxf == null) {
      afg().fxf = new a();
    }
    a locala = afg().fxf;
    AppMethodBeat.o(11482);
    return locala;
  }
  
  public static com.tencent.mm.aj.a.i afv()
  {
    AppMethodBeat.i(11483);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (afg().fxa == null) {
      afg().fxa = new com.tencent.mm.aj.a.i();
    }
    com.tencent.mm.aj.a.i locali = afg().fxa;
    AppMethodBeat.o(11483);
    return locali;
  }
  
  public static long afw()
  {
    AppMethodBeat.i(11484);
    if (fwQ == 0L)
    {
      Object localObject = com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yyB, null);
      if ((localObject != null) && ((localObject instanceof Long)))
      {
        fwQ = ((Long)localObject).longValue();
        ab.i("MicroMsg.SubCoreBiz", "temp session needUpdateTime : %d.(get from ConfigStorage)", new Object[] { Long.valueOf(fwQ) });
      }
    }
    if (fwQ == 0L)
    {
      fwQ = System.currentTimeMillis();
      com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yyB, Long.valueOf(fwQ));
      ab.i("MicroMsg.SubCoreBiz", "temp session needUpdateTime is 0, so get current time : %d.", new Object[] { Long.valueOf(fwQ) });
    }
    long l = fwQ;
    AppMethodBeat.o(11484);
    return l;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.d> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(11485);
    e.d.a(Integer.valueOf(55), this.flW);
    e.d.a(Integer.valueOf(57), this.flW);
    ((j)com.tencent.mm.kernel.g.E(j.class)).YF().c(this.fxh);
    afi().a(this.fxi, null);
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("mmbizattrappsvr_BizAttrSync", this.fxg, true);
    AppMethodBeat.o(11485);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(11486);
    e.d.b(Integer.valueOf(55), this.flW);
    e.d.b(Integer.valueOf(57), this.flW);
    h localh;
    if (afg().fwV != null)
    {
      localh = afg().fwV;
      com.tencent.mm.kernel.g.RK().eHt.b(675, localh);
      com.tencent.mm.kernel.g.RK().eHt.b(672, localh);
      com.tencent.mm.kernel.g.RK().eHt.b(674, localh);
    }
    synchronized (localh.ceY)
    {
      localh.fwn.clear();
      localh.fwm.clear();
      if (com.tencent.mm.kernel.g.RJ().QU())
      {
        ((j)com.tencent.mm.kernel.g.E(j.class)).YF().d(this.fxh);
        afi().a(this.fxi);
      }
      ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b("mmbizattrappsvr_BizAttrSync", this.fxg, true);
      AppMethodBeat.o(11486);
      return;
    }
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.aj.z
 * JD-Core Version:    0.7.0.1
 */