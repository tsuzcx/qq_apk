package com.tencent.mm.modelvoiceaddr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.sdk.platformtools.ab;

final class g$2$1
  implements Runnable
{
  g$2$1(g.2 param2) {}
  
  public final void run()
  {
    AppMethodBeat.i(116706);
    ab.i("MicroMsg.SceneVoiceInputAddr", "run NetSceneNewVoiceInput mWroteBytesCnt %s time %s", new Object[] { Integer.valueOf(g.h(this.gbK.gbI)), Long.valueOf(System.currentTimeMillis()) });
    if ((g.i(this.gbK.gbI)) || (g.k(this.gbK.gbI) == null) || (g.h(this.gbK.gbI) == 0))
    {
      ab.w("MicroMsg.SceneVoiceInputAddr", "WorkerThread too busy can not do work");
      AppMethodBeat.o(116706);
      return;
    }
    com.tencent.mm.kernel.g.Rc().a(235, this.gbK.gbI);
    if ((!((c)g.k(this.gbK.gbI)).amG()) || (!com.tencent.mm.kernel.g.Rc().a(g.k(this.gbK.gbI), 0))) {
      this.gbK.gbI.cL(13, 131);
    }
    AppMethodBeat.o(116706);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.g.2.1
 * JD-Core Version:    0.7.0.1
 */