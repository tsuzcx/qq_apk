package com.tencent.mm.ipcinvoker;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
{
  public static void ma(String paramString)
  {
    AppMethodBeat.i(114040);
    if (b.PK().lX(paramString))
    {
      AppMethodBeat.o(114040);
      return;
    }
    m.post(new g.3(paramString));
    AppMethodBeat.o(114040);
  }
  
  public static void mb(String paramString)
  {
    AppMethodBeat.i(114041);
    if (b.PK().lX(paramString))
    {
      AppMethodBeat.o(114041);
      return;
    }
    m.post(new g.4(paramString));
    AppMethodBeat.o(114041);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.g
 * JD-Core Version:    0.7.0.1
 */