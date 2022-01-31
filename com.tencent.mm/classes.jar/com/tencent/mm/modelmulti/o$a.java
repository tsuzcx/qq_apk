package com.tencent.mm.modelmulti;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cb;
import com.tencent.mm.protocal.protobuf.bgj;
import com.tencent.mm.protocal.protobuf.ue;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.LinkedList;

final class o$a
{
  int fIo;
  boolean fJD;
  bgj fJE;
  o.b fJF;
  o.c fJG;
  ap fJH;
  
  private o$a(o paramo, o.c paramc, boolean paramBoolean, bgj parambgj, o.b paramb)
  {
    AppMethodBeat.i(58400);
    this.fIo = 0;
    this.fJD = false;
    this.fJE = null;
    this.fJF = null;
    this.fJH = new ap(g.RO().oNc.getLooper(), new o.a.1(this), true);
    this.fJF = paramb;
    this.fJG = paramc;
    this.fJD = paramBoolean;
    this.fJE = parambgj;
    this.fIo = 0;
    if ((this.fJF != null) && (this.fJG != null)) {}
    for (boolean bool = true;; bool = false)
    {
      o.K("", bool);
      if (this.fJE != null) {
        break;
      }
      o.K("resp Not null", false);
      ab.w("MicroMsg.SyncService", "CmdProcHandler %s NewSyncResponse is null", new Object[] { this.fJG });
      this.fJF.lM(0);
      AppMethodBeat.o(58400);
      return;
    }
    if ((g.RG()) && (!a.QP()))
    {
      g.RM();
      if (g.RL() != null)
      {
        g.RM();
        if (g.RL().Ru() != null) {
          break label274;
        }
      }
    }
    paramo = this.fJG;
    paramBoolean = g.RG();
    bool = a.QP();
    g.RM();
    ab.e("MicroMsg.SyncService", "CmdProcHandler %s accready:%s hold:%s accstg:%s ", new Object[] { paramo, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool), g.RL() });
    this.fJF.lM(0);
    AppMethodBeat.o(58400);
    return;
    label274:
    o.a(parambgj);
    long l2 = parambgj.xvI;
    long l1 = l2;
    if (String.valueOf(l2).length() == 10) {
      l1 = l2 * 1000L;
    }
    l2 = System.currentTimeMillis();
    long l3 = l2 - l1;
    ab.i("MicroMsg.SyncService", "[oneliang] client time is:%s,server time is:%s,diff time is:%s, diff second time is:%s,just save millisecond diff time", new Object[] { Long.valueOf(l2), Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(l3 / 1000L) });
    g.RM();
    g.RL().Ru().set(ac.a.yGn, Long.valueOf(l3));
    cb.gy(l1);
    g.RM();
    g.RJ().ci(this.fJE.jJS, this.fJE.xvH);
    g.RM();
    g.RJ();
    a.jL(this.fJE.jJS);
    if ((this.fJE.wFU == null) || (this.fJE.wFU.jJv == null) || (this.fJE.wFU.jJv.size() <= 0))
    {
      ab.w("MicroMsg.SyncService", "CmdProcHandler %s cmdlist is null.  synckey may be changed, I have to merge it.", new Object[] { this.fJG });
      o.a(paramBoolean, this.fJE, this.fJG);
      this.fJF.lM(0);
      AppMethodBeat.o(58400);
      return;
    }
    ab.i("MicroMsg.SyncService", "CmdProcHandler %s Start docmd:%s respStatus:%s respOnlineVer:%s", new Object[] { this.fJG, Integer.valueOf(this.fJE.wFU.jJv.size()), Integer.valueOf(this.fJE.jJS), Integer.valueOf(this.fJE.xvH) });
    this.fJH.ag(50L, 50L);
    AppMethodBeat.o(58400);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.modelmulti.o.a
 * JD-Core Version:    0.7.0.1
 */