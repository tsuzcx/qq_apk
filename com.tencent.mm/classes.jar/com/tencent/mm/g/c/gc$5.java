package com.tencent.mm.g.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.sdk.e.j;

final class gc$5
  implements h.d
{
  public final String[] getSQLs()
  {
    AppMethodBeat.i(51348);
    String str = j.getCreateSQLs(bn.Hm(), "FavConfigInfo");
    AppMethodBeat.o(51348);
    return new String[] { str };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.c.gc.5
 * JD-Core Version:    0.7.0.1
 */