package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ld;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

final class aw$b
  implements Runnable
{
  private final ld npC;
  
  public aw$b(aw paramaw, ld paramld)
  {
    this.npC = paramld;
  }
  
  public final void run()
  {
    AppMethodBeat.i(111475);
    ab.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "time out, turn page");
    aw.a(this.npt, this.npC, null);
    h.qsU.j(939L, 2L, 1L);
    AppMethodBeat.o(111475);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.aw.b
 * JD-Core Version:    0.7.0.1
 */