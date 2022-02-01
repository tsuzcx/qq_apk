package com.tencent.mm.insane_statistic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.l;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.modelstat.r.a;
import com.tencent.mm.storage.ca;

public final class a
  implements r.a
{
  public final void s(ca paramca)
  {
    AppMethodBeat.i(20219);
    if (paramca.dOQ())
    {
      b.jmd.b(paramca, l.t(paramca));
      AppMethodBeat.o(20219);
      return;
    }
    b.jmd.s(paramca);
    AppMethodBeat.o(20219);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.insane_statistic.a
 * JD-Core Version:    0.7.0.1
 */