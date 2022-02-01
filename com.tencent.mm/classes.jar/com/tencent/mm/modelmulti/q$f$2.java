package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vg;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.cdm;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;

final class q$f$2
  implements Runnable
{
  q$f$2(q.f paramf) {}
  
  public final void run()
  {
    AppMethodBeat.i(132601);
    ae.i("MicroMsg.SyncService", "%s onFinishCmd ContinueFlag[%s]", new Object[] { this.ijE, Integer.valueOf(this.ijE.ijs.GeQ) });
    g.ajS();
    g.ajR().ajA().set(8196, Long.valueOf(this.ijE.ijs.GeQ));
    if ((this.ijE.ijs.GeQ & 0x100) != 0)
    {
      vg localvg = new vg();
      localvg.dKB.sourceType = 2;
      a.IvT.l(localvg);
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(99L, 22L, 1L, false);
      ae.i("MicroMsg.SyncService", "%s onFinishCmd publish SnsSyncEvent", new Object[] { this.ijE });
    }
    AppMethodBeat.o(132601);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelmulti.q.f.2
 * JD-Core Version:    0.7.0.1
 */