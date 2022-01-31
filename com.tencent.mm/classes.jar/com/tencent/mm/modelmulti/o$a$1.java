package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.zero.c;
import com.tencent.mm.protocal.protobuf.bgj;
import com.tencent.mm.protocal.protobuf.ud;
import com.tencent.mm.protocal.protobuf.ue;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

final class o$a$1
  implements ap.a
{
  o$a$1(o.a parama) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(58399);
    if ((g.RG()) && (!a.QP()))
    {
      g.RM();
      if (g.RL() != null)
      {
        g.RM();
        if (g.RL().Ru() != null) {
          break label118;
        }
      }
    }
    Object localObject = this.fJI.fJG;
    boolean bool1 = g.RG();
    boolean bool2 = a.QP();
    g.RM();
    ab.e("MicroMsg.SyncService", "processResp %s accready:%s hold:%s accstg:%s ", new Object[] { localObject, Boolean.valueOf(bool1), Boolean.valueOf(bool2), g.RL() });
    this.fJI.fJF.lM(0);
    AppMethodBeat.o(58399);
    return false;
    label118:
    localObject = this.fJI.fJE.wFU.jJv;
    c localc = new c();
    localc.bT(this.fJI.fJG);
    long l1 = bo.aoy();
    long l2;
    do
    {
      if (this.fJI.fIo >= ((LinkedList)localObject).size()) {
        break;
      }
      ((LinkedList)localObject).size();
      if (!localc.a((ud)((LinkedList)localObject).get(this.fJI.fIo), false)) {
        com.tencent.mm.plugin.report.e.qrI.idkeyStat(99L, 46L, 1L, false);
      }
      o.a locala = this.fJI;
      locala.fIo += 1;
      l2 = bo.hl(l1);
      ab.i("MicroMsg.SyncService", "processResp %s time:%s size:%s index:%s", new Object[] { this.fJI.fJG, Long.valueOf(l2), Integer.valueOf(((LinkedList)localObject).size()), Integer.valueOf(this.fJI.fIo - 1) });
    } while (l2 < 500L);
    localc.bU(this.fJI.fJG);
    if (this.fJI.fIo < ((LinkedList)localObject).size())
    {
      ab.i("MicroMsg.SyncService", "processResp %s time:%s size:%s index:%s Shold Continue.", new Object[] { this.fJI.fJG, Long.valueOf(bo.hl(l1)), Integer.valueOf(((LinkedList)localObject).size()), Integer.valueOf(this.fJI.fIo - 1) });
      AppMethodBeat.o(58399);
      return true;
    }
    o.a(this.fJI.fJD, this.fJI.fJE, this.fJI.fJG);
    this.fJI.fJF.lM(((LinkedList)localObject).size());
    AppMethodBeat.o(58399);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelmulti.o.a.1
 * JD-Core Version:    0.7.0.1
 */