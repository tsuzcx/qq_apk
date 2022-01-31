package com.tencent.mm.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class j
{
  public static int getInt(String paramString, int paramInt)
  {
    AppMethodBeat.i(125685);
    if (paramString != null) {}
    try
    {
      if (paramString.length() <= 0)
      {
        AppMethodBeat.o(125685);
        return paramInt;
      }
      int i = Integer.parseInt(paramString);
      AppMethodBeat.o(125685);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      AppMethodBeat.o(125685);
    }
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.c.j
 * JD-Core Version:    0.7.0.1
 */