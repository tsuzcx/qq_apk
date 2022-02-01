package com.tencent.mm.ipcinvoker.h;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  public static final String ao(String paramString1, String paramString2)
  {
    AppMethodBeat.i(158840);
    if ((!paramString1.contains(":")) && (paramString1.length() > 0))
    {
      AppMethodBeat.o(158840);
      return paramString1;
    }
    paramString1 = paramString1.split(":");
    if ((paramString1[0] != null) && (paramString1[0].length() > 0))
    {
      paramString1 = paramString1[0];
      AppMethodBeat.o(158840);
      return paramString1;
    }
    AppMethodBeat.o(158840);
    return paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.h.c
 * JD-Core Version:    0.7.0.1
 */