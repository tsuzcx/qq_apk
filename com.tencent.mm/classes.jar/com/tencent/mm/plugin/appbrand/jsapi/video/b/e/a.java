package com.tencent.mm.plugin.appbrand.jsapi.video.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public static void checkArgument(boolean paramBoolean)
  {
    AppMethodBeat.i(194324);
    if (!paramBoolean)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException();
      AppMethodBeat.o(194324);
      throw localIllegalArgumentException;
    }
    AppMethodBeat.o(194324);
  }
  
  public static <T> T checkNotNull(T paramT)
  {
    AppMethodBeat.i(194326);
    if (paramT == null)
    {
      paramT = new NullPointerException();
      AppMethodBeat.o(194326);
      throw paramT;
    }
    AppMethodBeat.o(194326);
    return paramT;
  }
  
  public static void checkState(boolean paramBoolean)
  {
    AppMethodBeat.i(194325);
    if (!paramBoolean)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException();
      AppMethodBeat.o(194325);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(194325);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.e.a
 * JD-Core Version:    0.7.0.1
 */