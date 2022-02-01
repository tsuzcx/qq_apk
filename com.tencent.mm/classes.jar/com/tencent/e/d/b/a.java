package com.tencent.e.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;

public final class a
{
  public static boolean isEmpty(Collection paramCollection)
  {
    AppMethodBeat.i(224040);
    if ((paramCollection == null) || (paramCollection.isEmpty()))
    {
      AppMethodBeat.o(224040);
      return true;
    }
    AppMethodBeat.o(224040);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.e.d.b.a
 * JD-Core Version:    0.7.0.1
 */