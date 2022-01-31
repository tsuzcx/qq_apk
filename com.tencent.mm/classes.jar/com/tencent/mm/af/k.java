package com.tencent.mm.af;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.storage.bi;

public final class k
{
  public static int k(bi parambi)
  {
    AppMethodBeat.i(77793);
    if (parambi.bCn())
    {
      parambi = j.b.ab(parambi.field_content, parambi.field_reserved);
      if (parambi == null)
      {
        AppMethodBeat.o(77793);
        return 0;
      }
      int i = parambi.type;
      AppMethodBeat.o(77793);
      return i;
    }
    AppMethodBeat.o(77793);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.af.k
 * JD-Core Version:    0.7.0.1
 */