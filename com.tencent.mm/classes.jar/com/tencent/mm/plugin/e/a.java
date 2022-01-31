package com.tencent.mm.plugin.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends com.tencent.mm.kernel.a.c.a
{
  public final void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(18521);
    if (!com.tencent.mm.kernel.a.QP())
    {
      com.tencent.mm.kernel.g.RJ().eGY = true;
      com.tencent.mm.kernel.g.RJ().initialize();
      com.tencent.mm.kernel.g.RJ().eGY = false;
    }
    AppMethodBeat.o(18521);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.e.a
 * JD-Core Version:    0.7.0.1
 */