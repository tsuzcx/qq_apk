package com.tencent.mm.modelmulti;

import android.os.HandlerThread;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bz;
import com.tencent.mm.protocal.c.azg;
import com.tencent.mm.protocal.c.qw;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.LinkedList;

final class o$a
{
  int esB = 0;
  boolean etQ = false;
  azg etR = null;
  o.b etS = null;
  o.c etT;
  am etU = new am(g.DS().mnU.getLooper(), new o.a.1(this), true);
  
  private o$a(o paramo, o.c paramc, boolean paramBoolean, azg paramazg, o.b paramb)
  {
    this.etS = paramb;
    this.etT = paramc;
    this.etQ = paramBoolean;
    this.etR = paramazg;
    this.esB = 0;
    if ((this.etS != null) && (this.etT != null)) {}
    for (boolean bool = true;; bool = false)
    {
      o.G("", bool);
      if (this.etR != null) {
        break;
      }
      o.G("resp Not null", false);
      y.w("MicroMsg.SyncService", "CmdProcHandler %s NewSyncResponse is null", new Object[] { this.etT });
      this.etS.iU(0);
      return;
    }
    if ((g.DK()) && (!a.CW()))
    {
      g.DQ();
      if (g.DP() != null)
      {
        g.DQ();
        if (g.DP().Dz() != null) {
          break label259;
        }
      }
    }
    paramo = this.etT;
    paramBoolean = g.DK();
    bool = a.CW();
    g.DQ();
    y.e("MicroMsg.SyncService", "CmdProcHandler %s accready:%s hold:%s accstg:%s ", new Object[] { paramo, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool), g.DP() });
    this.etS.iU(0);
    return;
    label259:
    o.a(paramazg);
    long l2 = paramazg.tvx;
    long l1 = l2;
    if (String.valueOf(l2).length() == 10) {
      l1 = l2 * 1000L;
    }
    l2 = System.currentTimeMillis();
    long l3 = l2 - l1;
    y.i("MicroMsg.SyncService", "[oneliang] client time is:%s,server time is:%s,diff time is:%s, diff second time is:%s,just save millisecond diff time", new Object[] { Long.valueOf(l2), Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(l3 / 1000L) });
    g.DQ();
    g.DP().Dz().c(ac.a.uwf, Long.valueOf(l3));
    bz.bE(l1);
    g.DQ();
    g.DN().be(this.etR.hQq, this.etR.tvw);
    g.DQ();
    g.DN();
    a.hv(this.etR.hQq);
    if ((this.etR.sIl == null) || (this.etR.sIl.hPT == null) || (this.etR.sIl.hPT.size() <= 0))
    {
      y.w("MicroMsg.SyncService", "CmdProcHandler %s cmdlist is null.  synckey may be changed, I have to merge it.", new Object[] { this.etT });
      o.a(paramBoolean, this.etR, this.etT);
      this.etS.iU(0);
      return;
    }
    y.i("MicroMsg.SyncService", "CmdProcHandler %s Start docmd:%s respStatus:%s respOnlineVer:%s", new Object[] { this.etT, Integer.valueOf(this.etR.sIl.hPT.size()), Integer.valueOf(this.etR.hQq), Integer.valueOf(this.etR.tvw) });
    this.etU.S(50L, 50L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.modelmulti.o.a
 * JD-Core Version:    0.7.0.1
 */