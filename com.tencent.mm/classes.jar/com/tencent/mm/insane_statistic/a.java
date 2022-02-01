package com.tencent.mm.insane_statistic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.l;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.modelstat.r.a;
import com.tencent.mm.storage.bv;

public final class a
  implements r.a
{
  public final void q(bv parambv)
  {
    AppMethodBeat.i(20219);
    if (parambv.cVH())
    {
      b.iqT.b(parambv, l.r(parambv));
      AppMethodBeat.o(20219);
      return;
    }
    b.iqT.q(parambv);
    AppMethodBeat.o(20219);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.insane_statistic.a
 * JD-Core Version:    0.7.0.1
 */