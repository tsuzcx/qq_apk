package com.tencent.mm.plugin.appbrand.jsapi.video.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public static void checkArgument(boolean paramBoolean)
  {
    AppMethodBeat.i(227158);
    if (!paramBoolean)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException();
      AppMethodBeat.o(227158);
      throw localIllegalArgumentException;
    }
    AppMethodBeat.o(227158);
  }
  
  public static <T> T checkNotNull(T paramT)
  {
    AppMethodBeat.i(227163);
    if (paramT == null)
    {
      paramT = new NullPointerException();
      AppMethodBeat.o(227163);
      throw paramT;
    }
    AppMethodBeat.o(227163);
    return paramT;
  }
  
  public static void checkState(boolean paramBoolean)
  {
    AppMethodBeat.i(227161);
    if (!paramBoolean)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException();
      AppMethodBeat.o(227161);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(227161);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.e.a
 * JD-Core Version:    0.7.0.1
 */