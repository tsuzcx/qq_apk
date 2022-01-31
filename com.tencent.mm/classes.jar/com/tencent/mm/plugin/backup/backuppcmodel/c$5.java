package com.tencent.mm.plugin.backup.backuppcmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.c.a;

final class c$5
  implements Runnable
{
  c$5(c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(17503);
    b.aTX().aTs().stop();
    b.aTX().aSN();
    com.tencent.mm.plugin.backup.g.b.aUo();
    com.tencent.mm.plugin.backup.g.b.aUq();
    AppMethodBeat.o(17503);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.c.5
 * JD-Core Version:    0.7.0.1
 */