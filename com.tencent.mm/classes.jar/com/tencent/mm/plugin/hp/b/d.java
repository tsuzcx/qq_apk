package com.tencent.mm.plugin.hp.b;

import com.tencent.mm.cf.h.d;
import com.tencent.mm.h.a.ay;
import com.tencent.mm.h.a.bh;
import com.tencent.mm.h.a.co;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bx;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.HashMap;

public final class d
  implements ar
{
  private final com.tencent.mm.sdk.b.c<ay> jaR = new d.1(this);
  boolean lmN = true;
  private final h lmO = new h();
  private final com.tencent.mm.sdk.b.c<co> lmP = new d.2(this);
  private final f lmQ = new f();
  private final com.tencent.mm.sdk.b.c<bh> lmR = new d.3(this);
  
  public final void bh(boolean paramBoolean)
  {
    b.a(new g(), new String[] { "//tinker" });
    au.getSysCmdMsgExtension().a("checktinkerupdate", this.lmO, true);
    com.tencent.mm.sdk.b.a.udP.c(this.jaR);
    this.lmP.cqo();
    com.tencent.mm.sdk.b.a.udP.c(this.lmQ);
    com.tencent.mm.sdk.b.a.udP.c(this.lmR);
    y.d("Tinker.SubCoreHotpatch", "onAccountPostReset");
    com.tencent.mm.plugin.hp.tinker.g.dE(ae.getContext());
    try
    {
      au.Hx();
      long l1 = ((Long)com.tencent.mm.model.c.Dz().get(ac.a.uxj, Long.valueOf(0L))).longValue();
      long l2 = System.currentTimeMillis();
      if (l2 - l1 >= 3600000L)
      {
        com.tinkerboots.sdk.a.cTY().oy(true);
        au.Hx();
        com.tencent.mm.model.c.Dz().c(ac.a.uxj, Long.valueOf(l2));
        y.i("Tinker.SubCoreHotpatch", "try to fetch patch update true when onAccountPostReset. current:%d lastUpdate:%d", new Object[] { Long.valueOf(System.currentTimeMillis()), Long.valueOf(l1) });
      }
      for (;;)
      {
        f.eT(l2);
        return;
        com.tinkerboots.sdk.a.cTY().oy(false);
        y.i("Tinker.SubCoreHotpatch", "try to fetch patch update false when onAccountPostReset.");
      }
      return;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("Tinker.SubCoreHotpatch", localException, "", new Object[0]);
    }
  }
  
  public final void bi(boolean paramBoolean) {}
  
  public final void gf(int paramInt) {}
  
  public final void onAccountRelease()
  {
    b.E(new String[] { "//tinker" });
    au.getSysCmdMsgExtension().b("checktinkerupdate", this.lmO, true);
    com.tencent.mm.sdk.b.a.udP.d(this.jaR);
    this.lmP.dead();
    com.tencent.mm.sdk.b.a.udP.d(this.lmQ);
    com.tencent.mm.sdk.b.a.udP.d(this.lmR);
    y.d("Tinker.SubCoreHotpatch", "onAccountRelease");
  }
  
  public final HashMap<Integer, h.d> xe()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.b.d
 * JD-Core Version:    0.7.0.1
 */