package com.google.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public static void checkArgument(boolean paramBoolean)
  {
    AppMethodBeat.i(107938);
    if (!paramBoolean)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException();
      AppMethodBeat.o(107938);
      throw localIllegalArgumentException;
    }
    AppMethodBeat.o(107938);
  }
  
  public static <T> T checkNotNull(T paramT)
  {
    AppMethodBeat.i(107937);
    if (paramT == null)
    {
      paramT = new NullPointerException();
      AppMethodBeat.o(107937);
      throw paramT;
    }
    AppMethodBeat.o(107937);
    return paramT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.a.b.a
 * JD-Core Version:    0.7.0.1
 */