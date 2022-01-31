package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Set;

final class aw$3
  implements Runnable
{
  aw$3(aw paramaw, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(111465);
    if (aw.aBJ().contains(this.npu))
    {
      ab.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "preload webcore, time out");
      aw.aBJ().remove(this.npu);
      h.qsU.j(939L, 3L, 1L);
    }
    AppMethodBeat.o(111465);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.aw.3
 * JD-Core Version:    0.7.0.1
 */