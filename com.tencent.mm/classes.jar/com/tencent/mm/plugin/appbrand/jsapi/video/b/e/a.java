package com.tencent.mm.plugin.appbrand.jsapi.video.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public static void checkArgument(boolean paramBoolean)
  {
    AppMethodBeat.i(211163);
    if (!paramBoolean)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException();
      AppMethodBeat.o(211163);
      throw localIllegalArgumentException;
    }
    AppMethodBeat.o(211163);
  }
  
  public static <T> T checkNotNull(T paramT)
  {
    AppMethodBeat.i(211165);
    if (paramT == null)
    {
      paramT = new NullPointerException();
      AppMethodBeat.o(211165);
      throw paramT;
    }
    AppMethodBeat.o(211165);
    return paramT;
  }
  
  public static void checkState(boolean paramBoolean)
  {
    AppMethodBeat.i(211164);
    if (!paramBoolean)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException();
      AppMethodBeat.o(211164);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(211164);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.e.a
 * JD-Core Version:    0.7.0.1
 */