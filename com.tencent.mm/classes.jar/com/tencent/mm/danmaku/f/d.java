package com.tencent.mm.danmaku.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.HashSet;

public final class d
{
  private static HashSet<String> jBs;
  
  static
  {
    AppMethodBeat.i(274565);
    jBs = new HashSet();
    AppMethodBeat.o(274565);
  }
  
  public static boolean fK(String paramString)
  {
    AppMethodBeat.i(274563);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(274563);
      return true;
    }
    AppMethodBeat.o(274563);
    return false;
  }
  
  public static boolean isEmpty(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(274564);
    if ((paramCollection == null) || (paramCollection.size() <= 0))
    {
      AppMethodBeat.o(274564);
      return true;
    }
    AppMethodBeat.o(274564);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.danmaku.f.d
 * JD-Core Version:    0.7.0.1
 */