package com.tencent.mm.plugin.collect.a;

import com.tencent.mm.cf.h.d;
import com.tencent.mm.h.a.k;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.bx;
import com.tencent.mm.model.bx.a;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.collect.b.d;
import com.tencent.mm.plugin.collect.b.o;
import com.tencent.mm.plugin.collect.b.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.c.axo;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class a
  implements ar
{
  private bx.a iGD = new a.1(this);
  private com.tencent.mm.plugin.collect.b.g iGE = new com.tencent.mm.plugin.collect.b.g();
  private u iGF = new u();
  public boolean iGG = false;
  private c<k> iGH = new a.3(this);
  
  public static a aEp()
  {
    return (a)com.tencent.mm.model.p.B(a.class);
  }
  
  public static d aEq()
  {
    com.tencent.mm.kernel.g.DN().CX();
    return d.iGN;
  }
  
  public static boolean aEr()
  {
    Object localObject = (String)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.uuM, "");
    long l = q.Go();
    if ((!bk.bl((String)localObject)) && (!((String)localObject).equals("in.caf")))
    {
      y.i("MicroMsg.SubCoreCollect", "old version switch is open, sync to new version");
      com.tencent.mm.kernel.g.DP().Dz().o(147457, Long.valueOf(l | 0x8000));
      localObject = new axo();
      ((axo)localObject).nFj = 1;
      ((j)com.tencent.mm.kernel.g.r(j.class)).Fv().b(new i.a(209, (com.tencent.mm.bv.a)localObject));
      return true;
    }
    return (l & 0x8000) != 0L;
  }
  
  private void zw(String paramString)
  {
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.a(304, new a.2(this));
    paramString = new o(bk.aM(paramString, ""));
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.a(paramString, 0);
  }
  
  public final void aEs()
  {
    zw("cash.caf");
    com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uuM, "cash.caf");
  }
  
  public final void aEt()
  {
    zw("in.caf");
    com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uuM, "in.caf");
  }
  
  public final void bh(boolean paramBoolean)
  {
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("paymsg", this.iGD, true);
    this.iGH.cqo();
    com.tencent.mm.plugin.collect.b.g localg = this.iGE;
    localg.cqo();
    localg.iGU = new ConcurrentLinkedQueue();
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.a(1384, localg);
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.a(1317, localg);
    this.iGF.cqo();
  }
  
  public final void bi(boolean paramBoolean) {}
  
  public final void gf(int paramInt) {}
  
  public final void onAccountRelease()
  {
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b("paymsg", this.iGD, true);
    com.tencent.mm.plugin.collect.b.g localg = this.iGE;
    localg.dead();
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.b(1384, localg);
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.b(1317, localg);
    com.tencent.mm.plugin.collect.b.g.aEv();
    this.iGF.dead();
    this.iGH.dead();
  }
  
  public final HashMap<Integer, h.d> xe()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.a.a
 * JD-Core Version:    0.7.0.1
 */