package com.tencent.mm.plugin.clean.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class d$1
  implements Runnable
{
  public final void run()
  {
    AppMethodBeat.i(18694);
    if (d.access$000() == 0)
    {
      ab.i("MicroMsg.CleanLogic", "clean data");
      d.iq(0L);
      d.u(null);
      AppMethodBeat.o(18694);
      return;
    }
    ab.i("MicroMsg.CleanLogic", "clean data is using");
    AppMethodBeat.o(18694);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.c.d.1
 * JD-Core Version:    0.7.0.1
 */