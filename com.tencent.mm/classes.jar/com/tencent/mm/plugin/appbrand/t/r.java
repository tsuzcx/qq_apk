package com.tencent.mm.plugin.appbrand.t;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class r
{
  public static String Fq(String paramString)
  {
    AppMethodBeat.i(91185);
    if (paramString == null)
    {
      AppMethodBeat.o(91185);
      return null;
    }
    paramString = paramString.replace(' ', '\n').replace(' ', '\n');
    AppMethodBeat.o(91185);
    return paramString;
  }
  
  public static boolean x(String paramString1, String paramString2)
  {
    AppMethodBeat.i(91186);
    if ((paramString1 == null) || (paramString1.length() < 0) || (paramString2.length() < 0))
    {
      AppMethodBeat.o(91186);
      return false;
    }
    if (paramString2.length() > paramString1.length())
    {
      AppMethodBeat.o(91186);
      return false;
    }
    if (paramString2.equalsIgnoreCase(paramString1.substring(0, paramString2.length())))
    {
      AppMethodBeat.o(91186);
      return true;
    }
    AppMethodBeat.o(91186);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.t.r
 * JD-Core Version:    0.7.0.1
 */