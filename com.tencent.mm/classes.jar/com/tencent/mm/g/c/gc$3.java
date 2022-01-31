package com.tencent.mm.g.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.sdk.e.j;

final class gc$3
  implements h.d
{
  public final String[] getSQLs()
  {
    AppMethodBeat.i(51346);
    String str = j.getCreateSQLs(bo.Hm(), "FavEditInfo");
    AppMethodBeat.o(51346);
    return new String[] { str };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.c.gc.3
 * JD-Core Version:    0.7.0.1
 */