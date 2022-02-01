package com.tencent.mm.compatible.util;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n
{
  public static <T> T checkNotNull(T paramT)
  {
    AppMethodBeat.i(155910);
    if (paramT == null)
    {
      paramT = new NullPointerException();
      AppMethodBeat.o(155910);
      throw paramT;
    }
    AppMethodBeat.o(155910);
    return paramT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.util.n
 * JD-Core Version:    0.7.0.1
 */