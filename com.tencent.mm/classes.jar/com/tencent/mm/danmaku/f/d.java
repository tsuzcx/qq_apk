package com.tencent.mm.danmaku.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.HashSet;

public final class d
{
  private static HashSet<String> gQZ;
  
  static
  {
    AppMethodBeat.i(241785);
    gQZ = new HashSet();
    AppMethodBeat.o(241785);
  }
  
  public static boolean isEmpty(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(241784);
    if ((paramCollection == null) || (paramCollection.size() <= 0))
    {
      AppMethodBeat.o(241784);
      return true;
    }
    AppMethodBeat.o(241784);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.danmaku.f.d
 * JD-Core Version:    0.7.0.1
 */