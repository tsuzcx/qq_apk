package com.tencent.mm.plugin.appbrand.jsapi.video.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public static void checkArgument(boolean paramBoolean)
  {
    AppMethodBeat.i(328331);
    if (!paramBoolean)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException();
      AppMethodBeat.o(328331);
      throw localIllegalArgumentException;
    }
    AppMethodBeat.o(328331);
  }
  
  public static <T> T checkNotNull(T paramT)
  {
    AppMethodBeat.i(328348);
    if (paramT == null)
    {
      paramT = new NullPointerException();
      AppMethodBeat.o(328348);
      throw paramT;
    }
    AppMethodBeat.o(328348);
    return paramT;
  }
  
  public static void checkState(boolean paramBoolean)
  {
    AppMethodBeat.i(328337);
    if (!paramBoolean)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException();
      AppMethodBeat.o(328337);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(328337);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.e.a
 * JD-Core Version:    0.7.0.1
 */