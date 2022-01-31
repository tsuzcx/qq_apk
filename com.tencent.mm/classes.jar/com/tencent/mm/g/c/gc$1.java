package com.tencent.mm.g.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.sdk.e.j;

final class gc$1
  implements h.d
{
  public final String[] getSQLs()
  {
    AppMethodBeat.i(51344);
    String str = j.getCreateSQLs(bp.Hm(), "FavItemInfo");
    AppMethodBeat.o(51344);
    return new String[] { str };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.c.gc.1
 * JD-Core Version:    0.7.0.1
 */