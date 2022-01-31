package com.tencent.mm.insane_statistic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.k;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.modelstat.r.a;
import com.tencent.mm.storage.bi;

public final class a
  implements r.a
{
  public final void j(bi parambi)
  {
    AppMethodBeat.i(16174);
    if (parambi.bCn())
    {
      b.fRu.a(parambi, k.k(parambi));
      AppMethodBeat.o(16174);
      return;
    }
    b.fRu.j(parambi);
    AppMethodBeat.o(16174);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.insane_statistic.a
 * JD-Core Version:    0.7.0.1
 */