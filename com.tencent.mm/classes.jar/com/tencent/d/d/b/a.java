package com.tencent.d.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;

public final class a
{
  public static boolean isEmpty(Collection paramCollection)
  {
    AppMethodBeat.i(233096);
    if ((paramCollection == null) || (paramCollection.isEmpty()))
    {
      AppMethodBeat.o(233096);
      return true;
    }
    AppMethodBeat.o(233096);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.d.d.b.a
 * JD-Core Version:    0.7.0.1
 */