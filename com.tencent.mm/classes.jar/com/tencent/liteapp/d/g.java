package com.tencent.liteapp.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
{
  public static int ew(String paramString)
  {
    AppMethodBeat.i(219055);
    if (paramString != null) {}
    try
    {
      if (paramString.length() <= 0)
      {
        AppMethodBeat.o(219055);
        return 0;
      }
      int i = Integer.decode(paramString).intValue();
      AppMethodBeat.o(219055);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      AppMethodBeat.o(219055);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.liteapp.d.g
 * JD-Core Version:    0.7.0.1
 */