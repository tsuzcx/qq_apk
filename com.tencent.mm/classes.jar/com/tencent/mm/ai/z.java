package com.tencent.mm.ai;

import com.tencent.mm.ah.e.d;
import com.tencent.mm.ai.a.d;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.bx;
import com.tencent.mm.model.bx.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.be.a;
import com.tencent.mm.storage.r;
import com.tencent.mm.storage.t;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class z
  implements ar
{
  private static HashMap<Integer, h.d> dgp;
  private static long egM = 0L;
  private com.tencent.mm.model.e dVM = new com.tencent.mm.model.e();
  private e egN;
  private m.a egO = null;
  private k egP = null;
  private i egQ;
  private h egR = null;
  private d egS = null;
  private com.tencent.mm.ai.a.b egT = null;
  private com.tencent.mm.ai.a.k egU = null;
  private com.tencent.mm.ai.a.g egV = null;
  private com.tencent.mm.ai.a.i egW = null;
  private com.tencent.mm.ai.a.h egX = null;
  private c egY = null;
  private r egZ = null;
  private t eha = null;
  private a ehb;
  private bx.a ehc = new bx.a()
  {
    public final void a(com.tencent.mm.ah.e.a paramAnonymousa)
    {
      paramAnonymousa = paramAnonymousa.dBs;
      if (paramAnonymousa == null)
      {
        y.e("MicroMsg.SubCoreBiz", "AddMsg is null.");
        return;
      }
      paramAnonymousa = aa.a(paramAnonymousa.svH);
      if (bk.bl(paramAnonymousa))
      {
        y.e("MicroMsg.SubCoreBiz", "msg content is null");
        return;
      }
      paramAnonymousa = bn.s(paramAnonymousa, "sysmsg");
      if ((paramAnonymousa == null) || (paramAnonymousa.size() <= 0))
      {
        y.e("MicroMsg.SubCoreBiz", "receiveMessage, no sysmsg");
        return;
      }
      if (!"mmbizattrappsvr_BizAttrSync".equalsIgnoreCase((String)paramAnonymousa.get(".sysmsg.$type")))
      {
        y.e("MicroMsg.SubCoreBiz", "receiveMessage, type not BizAttrSync.");
        return;
      }
      int i = bk.getInt((String)paramAnonymousa.get(".sysmsg.mmbizattrappsvr_BizAttrSync.openflag"), 0);
      y.i("MicroMsg.SubCoreBiz", "BizAttrSync openFlag : %d.", new Object[] { Integer.valueOf(i) });
      com.tencent.mm.kernel.g.DP().Dz().c(ac.a.upO, Integer.valueOf(i));
      com.tencent.mm.kernel.g.DP().Dz().mC(true);
    }
  };
  private be.a ehd = new z.10(this);
  private e.a ehe = new z.2(this);
  
  static
  {
    HashMap localHashMap = new HashMap();
    dgp = localHashMap;
    localHashMap.put(Integer.valueOf("BIZINFO_TABLE".hashCode()), new z.1());
    dgp.put(Integer.valueOf("BIZKF_TABLE".hashCode()), new z.3());
    dgp.put(Integer.valueOf("BIZCHAT_TABLE".hashCode()), new z.4());
    dgp.put(Integer.valueOf("BIZCHATUSER_TABLE".hashCode()), new z.5());
    dgp.put(Integer.valueOf("BIZCONVERSATION_TABLE".hashCode()), new z.6());
    dgp.put(Integer.valueOf("BIZCHAMYUSERINFO_TABLE".hashCode()), new z.7());
    dgp.put(Integer.valueOf("BIZENTERPRISE_TABLE".hashCode()), new z.8());
  }
  
  public static d MA()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (Mw().egS == null) {
      Mw().egS = new d(com.tencent.mm.kernel.g.DP().dKu);
    }
    return Mw().egS;
  }
  
  public static com.tencent.mm.ai.a.b MB()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (Mw().egT == null) {
      Mw().egT = new com.tencent.mm.ai.a.b(com.tencent.mm.kernel.g.DP().dKu);
    }
    return Mw().egT;
  }
  
  public static com.tencent.mm.ai.a.k MC()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (Mw().egU == null) {
      Mw().egU = new com.tencent.mm.ai.a.k(com.tencent.mm.kernel.g.DP().dKu);
    }
    return Mw().egU;
  }
  
  public static com.tencent.mm.ai.a.g MD()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (Mw().egV == null) {
      Mw().egV = new com.tencent.mm.ai.a.g(com.tencent.mm.kernel.g.DP().dKu);
    }
    return Mw().egV;
  }
  
  public static r ME()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (Mw().egZ == null) {
      Mw().egZ = new r(com.tencent.mm.kernel.g.DP().dKu);
    }
    return Mw().egZ;
  }
  
  public static t MF()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (Mw().eha == null) {
      Mw().eha = new t(com.tencent.mm.kernel.g.DP().dKu);
    }
    return Mw().eha;
  }
  
  public static com.tencent.mm.ai.a.h MG()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (Mw().egX == null) {
      Mw().egX = new com.tencent.mm.ai.a.h();
    }
    return Mw().egX;
  }
  
  public static c MH()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (Mw().egY == null) {
      Mw().egY = new c(com.tencent.mm.kernel.g.DP().dKu);
    }
    return Mw().egY;
  }
  
  public static m.a MI()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (Mw().egO == null) {
      Mw().egO = new m.a();
    }
    return Mw().egO;
  }
  
  public static k MJ()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (Mw().egP == null) {
      Mw().egP = new k();
    }
    return Mw().egP;
  }
  
  public static a MK()
  {
    if (Mw().ehb == null) {
      Mw().ehb = new a();
    }
    return Mw().ehb;
  }
  
  public static com.tencent.mm.ai.a.i ML()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (Mw().egW == null) {
      Mw().egW = new com.tencent.mm.ai.a.i();
    }
    return Mw().egW;
  }
  
  public static long MM()
  {
    if (egM == 0L)
    {
      Object localObject = com.tencent.mm.kernel.g.DP().Dz().get(ac.a.uoF, null);
      if ((localObject != null) && ((localObject instanceof Long)))
      {
        egM = ((Long)localObject).longValue();
        y.i("MicroMsg.SubCoreBiz", "temp session needUpdateTime : %d.(get from ConfigStorage)", new Object[] { Long.valueOf(egM) });
      }
    }
    if (egM == 0L)
    {
      egM = System.currentTimeMillis();
      com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uoF, Long.valueOf(egM));
      y.i("MicroMsg.SubCoreBiz", "temp session needUpdateTime is 0, so get current time : %d.", new Object[] { Long.valueOf(egM) });
    }
    return egM;
  }
  
  private static z Mw()
  {
    try
    {
      z localz = (z)com.tencent.mm.model.p.B(z.class);
      return localz;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static i Mx()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (Mw().egQ == null) {
      Mw().egQ = new i(com.tencent.mm.kernel.g.DP().dKu);
    }
    return Mw().egQ;
  }
  
  public static e My()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (Mw().egN == null) {
      Mw().egN = new e(com.tencent.mm.kernel.g.DP().dKu);
    }
    return Mw().egN;
  }
  
  public static h Mz()
  {
    com.tencent.mm.kernel.g.DN().CX();
    h localh;
    if (Mw().egR == null)
    {
      Mw().egR = new h();
      localh = Mw().egR;
      com.tencent.mm.kernel.g.DO().dJT.a(675, localh);
      com.tencent.mm.kernel.g.DO().dJT.a(672, localh);
      com.tencent.mm.kernel.g.DO().dJT.a(674, localh);
    }
    synchronized (localh.bjn)
    {
      localh.egl.clear();
      return Mw().egR;
    }
  }
  
  public final void bh(boolean paramBoolean)
  {
    e.d.a(Integer.valueOf(55), this.dVM);
    e.d.a(Integer.valueOf(57), this.dVM);
    ((j)com.tencent.mm.kernel.g.r(j.class)).FB().c(this.ehd);
    My().a(this.ehe, null);
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("mmbizattrappsvr_BizAttrSync", this.ehc, true);
  }
  
  public final void bi(boolean paramBoolean) {}
  
  public final void gf(int paramInt) {}
  
  public final void onAccountRelease()
  {
    e.d.b(Integer.valueOf(55), this.dVM);
    e.d.b(Integer.valueOf(57), this.dVM);
    h localh;
    if (Mw().egR != null)
    {
      localh = Mw().egR;
      com.tencent.mm.kernel.g.DO().dJT.b(675, localh);
      com.tencent.mm.kernel.g.DO().dJT.b(672, localh);
      com.tencent.mm.kernel.g.DO().dJT.b(674, localh);
    }
    synchronized (localh.bjn)
    {
      localh.egl.clear();
      localh.egk.clear();
      if (com.tencent.mm.kernel.g.DN().Dc())
      {
        ((j)com.tencent.mm.kernel.g.r(j.class)).FB().d(this.ehd);
        My().a(this.ehe);
      }
      ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b("mmbizattrappsvr_BizAttrSync", this.ehc, true);
      return;
    }
  }
  
  public final HashMap<Integer, h.d> xe()
  {
    return dgp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ai.z
 * JD-Core Version:    0.7.0.1
 */