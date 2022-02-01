package com.tencent.mm.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class j
{
  public static int fe(String paramString)
  {
    AppMethodBeat.i(945);
    if (paramString != null) {}
    try
    {
      if (paramString.length() <= 0)
      {
        AppMethodBeat.o(945);
        return 0;
      }
      int i = Integer.parseInt(paramString);
      AppMethodBeat.o(945);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      AppMethodBeat.o(945);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.d.j
 * JD-Core Version:    0.7.0.1
 */