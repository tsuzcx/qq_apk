package com.tencent.mm.insane_statistic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.l;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.modelstat.q.a;
import com.tencent.mm.storage.ca;

public final class a
  implements q.a
{
  public final void u(ca paramca)
  {
    AppMethodBeat.i(20219);
    if (paramca.erk())
    {
      b.mcf.d(paramca, l.v(paramca));
      AppMethodBeat.o(20219);
      return;
    }
    b.mcf.u(paramca);
    AppMethodBeat.o(20219);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.insane_statistic.a
 * JD-Core Version:    0.7.0.1
 */