package com.tencent.mm.plugin.appbrand.jsapi.video.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public static void checkArgument(boolean paramBoolean)
  {
    AppMethodBeat.i(193977);
    if (!paramBoolean)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException();
      AppMethodBeat.o(193977);
      throw localIllegalArgumentException;
    }
    AppMethodBeat.o(193977);
  }
  
  public static <T> T checkNotNull(T paramT)
  {
    AppMethodBeat.i(193979);
    if (paramT == null)
    {
      paramT = new NullPointerException();
      AppMethodBeat.o(193979);
      throw paramT;
    }
    AppMethodBeat.o(193979);
    return paramT;
  }
  
  public static void checkState(boolean paramBoolean)
  {
    AppMethodBeat.i(193978);
    if (!paramBoolean)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException();
      AppMethodBeat.o(193978);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(193978);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.e.a
 * JD-Core Version:    0.7.0.1
 */