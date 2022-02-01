package com.tencent.liteapp.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
{
  public static int cL(String paramString)
  {
    AppMethodBeat.i(197813);
    if (paramString != null) {}
    try
    {
      if (paramString.length() <= 0)
      {
        AppMethodBeat.o(197813);
        return 0;
      }
      int i = Integer.decode(paramString).intValue();
      AppMethodBeat.o(197813);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      AppMethodBeat.o(197813);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.liteapp.d.f
 * JD-Core Version:    0.7.0.1
 */