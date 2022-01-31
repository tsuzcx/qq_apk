package com.tencent.luggage.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

public final class c
{
  public static <T> List<T> A(List<T> paramList)
  {
    AppMethodBeat.i(90874);
    if (paramList == null)
    {
      paramList = Collections.emptyList();
      AppMethodBeat.o(90874);
      return paramList;
    }
    AppMethodBeat.o(90874);
    return paramList;
  }
  
  public static <L extends List<T>, T> L c(L paramL, List<T> paramList)
  {
    AppMethodBeat.i(90873);
    if (paramList != null) {
      paramL.addAll(paramList);
    }
    AppMethodBeat.o(90873);
    return paramL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.g.c
 * JD-Core Version:    0.7.0.1
 */