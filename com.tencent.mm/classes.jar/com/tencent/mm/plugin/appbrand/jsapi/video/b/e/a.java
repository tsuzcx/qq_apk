package com.tencent.mm.plugin.appbrand.jsapi.video.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public static void checkArgument(boolean paramBoolean)
  {
    AppMethodBeat.i(234832);
    if (!paramBoolean)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException();
      AppMethodBeat.o(234832);
      throw localIllegalArgumentException;
    }
    AppMethodBeat.o(234832);
  }
  
  public static <T> T checkNotNull(T paramT)
  {
    AppMethodBeat.i(234834);
    if (paramT == null)
    {
      paramT = new NullPointerException();
      AppMethodBeat.o(234834);
      throw paramT;
    }
    AppMethodBeat.o(234834);
    return paramT;
  }
  
  public static void checkState(boolean paramBoolean)
  {
    AppMethodBeat.i(234833);
    if (!paramBoolean)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException();
      AppMethodBeat.o(234833);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(234833);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.e.a
 * JD-Core Version:    0.7.0.1
 */