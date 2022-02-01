package com.tencent.mm.plugin.expt.hellhound.a.f.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
{
  public static long ayJ(String paramString)
  {
    AppMethodBeat.i(122150);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(122150);
      return 0L;
    }
    if ("-1".equals(paramString))
    {
      AppMethodBeat.o(122150);
      return -1L;
    }
    long l = Long.valueOf(paramString.split("@")[0]).longValue();
    AppMethodBeat.o(122150);
    return l;
  }
  
  public static String ayK(String paramString)
  {
    AppMethodBeat.i(122151);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(122151);
      return null;
    }
    if ("-1".equals(paramString))
    {
      AppMethodBeat.o(122151);
      return "-1";
    }
    paramString = paramString.split("@");
    if (paramString.length <= 1)
    {
      AppMethodBeat.o(122151);
      return null;
    }
    paramString = paramString[1];
    AppMethodBeat.o(122151);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.c.d
 * JD-Core Version:    0.7.0.1
 */