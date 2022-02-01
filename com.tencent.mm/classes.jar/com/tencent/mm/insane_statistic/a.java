package com.tencent.mm.insane_statistic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.l;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.modelstat.r.a;
import com.tencent.mm.storage.bo;

public final class a
  implements r.a
{
  public final void q(bo parambo)
  {
    AppMethodBeat.i(20219);
    if (parambo.cKN())
    {
      b.hUE.b(parambo, l.r(parambo));
      AppMethodBeat.o(20219);
      return;
    }
    b.hUE.q(parambo);
    AppMethodBeat.o(20219);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.insane_statistic.a
 * JD-Core Version:    0.7.0.1
 */