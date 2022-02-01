package com.google.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public static <T> T checkNotNull(T paramT)
  {
    AppMethodBeat.i(208700);
    if (paramT == null)
    {
      paramT = new NullPointerException();
      AppMethodBeat.o(208700);
      throw paramT;
    }
    AppMethodBeat.o(208700);
    return paramT;
  }
  
  public static <T> T checkNotNull(T paramT, Object paramObject)
  {
    AppMethodBeat.i(208704);
    if (paramT == null)
    {
      paramT = new NullPointerException(String.valueOf(paramObject));
      AppMethodBeat.o(208704);
      throw paramT;
    }
    AppMethodBeat.o(208704);
    return paramT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.b.a.b
 * JD-Core Version:    0.7.0.1
 */