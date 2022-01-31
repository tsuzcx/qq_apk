package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.bgj;
import com.tencent.mm.protocal.t.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.util.Queue;

final class o$f
  implements o.c
{
  int fHZ;
  bgj fJE;
  long fJQ;
  
  public o$f(o paramo, t.b paramb, int paramInt, long paramLong)
  {
    AppMethodBeat.i(58411);
    if (paramb == null) {}
    for (paramo = null;; paramo = paramb.wiN)
    {
      this.fJE = paramo;
      this.fJQ = paramLong;
      this.fHZ = paramInt;
      AppMethodBeat.o(58411);
      return;
    }
  }
  
  public final boolean c(Queue<o.c> paramQueue)
  {
    AppMethodBeat.i(58412);
    if (this.fJE == null)
    {
      e.qrI.idkeyStat(99L, 40L, 1L, false);
      ab.e("MicroMsg.SyncService", "%s run resp == null", new Object[] { this });
      AppMethodBeat.o(58412);
      return false;
    }
    if (10018 == ae.gkK)
    {
      ab.e("MicroMsg.SyncService", "%s Give up for test", new Object[] { this });
      AppMethodBeat.o(58412);
      return false;
    }
    new o.a(this.fJA, this, true, this.fJE, new o.f.1(this), (byte)0);
    g.RO().o(new o.f.2(this), 100L);
    e.qrI.idkeyStat(99L, 21L, 1L, false);
    AppMethodBeat.o(58412);
    return true;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(58413);
    String str = "NotifyData[" + hashCode() + "]";
    AppMethodBeat.o(58413);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelmulti.o.f
 * JD-Core Version:    0.7.0.1
 */