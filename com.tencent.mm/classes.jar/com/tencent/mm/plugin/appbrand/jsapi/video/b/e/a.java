package com.tencent.mm.plugin.appbrand.jsapi.video.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public static void checkArgument(boolean paramBoolean)
  {
    AppMethodBeat.i(206136);
    if (!paramBoolean)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException();
      AppMethodBeat.o(206136);
      throw localIllegalArgumentException;
    }
    AppMethodBeat.o(206136);
  }
  
  public static <T> T checkNotNull(T paramT)
  {
    AppMethodBeat.i(206138);
    if (paramT == null)
    {
      paramT = new NullPointerException();
      AppMethodBeat.o(206138);
      throw paramT;
    }
    AppMethodBeat.o(206138);
    return paramT;
  }
  
  public static void checkState(boolean paramBoolean)
  {
    AppMethodBeat.i(206137);
    if (!paramBoolean)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException();
      AppMethodBeat.o(206137);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(206137);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.e.a
 * JD-Core Version:    0.7.0.1
 */