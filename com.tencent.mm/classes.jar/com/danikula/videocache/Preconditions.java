package com.danikula.videocache;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class Preconditions
{
  public static void checkAllNotNull(Object... paramVarArgs)
  {
    AppMethodBeat.i(195157);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      if (paramVarArgs[i] == null)
      {
        paramVarArgs = new NullPointerException();
        AppMethodBeat.o(195157);
        throw paramVarArgs;
      }
      i += 1;
    }
    AppMethodBeat.o(195157);
  }
  
  static void checkArgument(boolean paramBoolean)
  {
    AppMethodBeat.i(195159);
    if (!paramBoolean)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException();
      AppMethodBeat.o(195159);
      throw localIllegalArgumentException;
    }
    AppMethodBeat.o(195159);
  }
  
  static void checkArgument(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(183601);
    if (!paramBoolean)
    {
      paramString = new IllegalArgumentException(paramString);
      AppMethodBeat.o(183601);
      throw paramString;
    }
    AppMethodBeat.o(183601);
  }
  
  public static <T> T checkNotNull(T paramT)
  {
    AppMethodBeat.i(183600);
    if (paramT == null)
    {
      paramT = new NullPointerException();
      AppMethodBeat.o(183600);
      throw paramT;
    }
    AppMethodBeat.o(183600);
    return paramT;
  }
  
  public static <T> T checkNotNull(T paramT, String paramString)
  {
    AppMethodBeat.i(195158);
    if (paramT == null)
    {
      paramT = new NullPointerException(paramString);
      AppMethodBeat.o(195158);
      throw paramT;
    }
    AppMethodBeat.o(195158);
    return paramT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.danikula.videocache.Preconditions
 * JD-Core Version:    0.7.0.1
 */