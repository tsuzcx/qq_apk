package com.tencent.mm.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i
{
  public static int ew(String paramString)
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
  
  public static String nullAsNil(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.d.i
 * JD-Core Version:    0.7.0.1
 */