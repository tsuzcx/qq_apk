package com.tencent.luggage.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

public final class b
{
  public static <T> List<T> C(List<T> paramList)
  {
    AppMethodBeat.i(140483);
    if (paramList == null)
    {
      paramList = Collections.emptyList();
      AppMethodBeat.o(140483);
      return paramList;
    }
    AppMethodBeat.o(140483);
    return paramList;
  }
  
  public static <L extends List<T>, T> L c(L paramL, List<T> paramList)
  {
    AppMethodBeat.i(140482);
    if (paramList != null) {
      paramL.addAll(paramList);
    }
    AppMethodBeat.o(140482);
    return paramL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.h.b
 * JD-Core Version:    0.7.0.1
 */