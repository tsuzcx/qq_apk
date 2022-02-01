package com.tencent.mm.plugin.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends com.tencent.mm.kernel.a.c.a
{
  public final void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(22632);
    if (!com.tencent.mm.kernel.a.azj())
    {
      com.tencent.mm.kernel.g.aAf().hpQ = true;
      com.tencent.mm.kernel.g.aAf().initialize();
      com.tencent.mm.kernel.g.aAf().hpQ = false;
    }
    AppMethodBeat.o(22632);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.e.a
 * JD-Core Version:    0.7.0.1
 */