package com.google.firebase.components;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class r
{
  public static void b(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(4098);
    if (!paramBoolean)
    {
      paramString = new IllegalStateException(paramString);
      AppMethodBeat.o(4098);
      throw paramString;
    }
    AppMethodBeat.o(4098);
  }
  
  public static <T> T zza(T paramT, String paramString)
  {
    AppMethodBeat.i(4097);
    if (paramT == null)
    {
      paramT = new NullPointerException(paramString);
      AppMethodBeat.o(4097);
      throw paramT;
    }
    AppMethodBeat.o(4097);
    return paramT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.firebase.components.r
 * JD-Core Version:    0.7.0.1
 */