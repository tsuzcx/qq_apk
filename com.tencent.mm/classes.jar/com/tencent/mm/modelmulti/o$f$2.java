package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.sf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.bgj;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.z;

final class o$f$2
  implements Runnable
{
  o$f$2(o.f paramf) {}
  
  public final void run()
  {
    AppMethodBeat.i(58410);
    ab.i("MicroMsg.SyncService", "%s onFinishCmd ContinueFlag[%s]", new Object[] { this.fJR, Integer.valueOf(this.fJR.fJE.wBX) });
    g.RM();
    g.RL().Ru().set(8196, Long.valueOf(this.fJR.fJE.wBX));
    if ((this.fJR.fJE.wBX & 0x100) != 0)
    {
      sf localsf = new sf();
      localsf.cIz.cpG = 2;
      a.ymk.l(localsf);
      com.tencent.mm.plugin.report.e.qrI.idkeyStat(99L, 22L, 1L, false);
      ab.i("MicroMsg.SyncService", "%s onFinishCmd publish SnsSyncEvent", new Object[] { this.fJR });
    }
    AppMethodBeat.o(58410);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelmulti.o.f.2
 * JD-Core Version:    0.7.0.1
 */