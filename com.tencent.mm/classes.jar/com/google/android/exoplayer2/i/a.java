package com.google.android.exoplayer2.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public static int ba(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(95860);
    if ((paramInt1 < 0) || (paramInt1 >= paramInt2))
    {
      IndexOutOfBoundsException localIndexOutOfBoundsException = new IndexOutOfBoundsException();
      AppMethodBeat.o(95860);
      throw localIndexOutOfBoundsException;
    }
    AppMethodBeat.o(95860);
    return paramInt1;
  }
  
  public static void checkArgument(boolean paramBoolean)
  {
    AppMethodBeat.i(95858);
    if (!paramBoolean)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException();
      AppMethodBeat.o(95858);
      throw localIllegalArgumentException;
    }
    AppMethodBeat.o(95858);
  }
  
  public static void checkArgument(boolean paramBoolean, Object paramObject)
  {
    AppMethodBeat.i(95859);
    if (!paramBoolean)
    {
      paramObject = new IllegalArgumentException(String.valueOf(paramObject));
      AppMethodBeat.o(95859);
      throw paramObject;
    }
    AppMethodBeat.o(95859);
  }
  
  public static <T> T checkNotNull(T paramT)
  {
    AppMethodBeat.i(95863);
    if (paramT == null)
    {
      paramT = new NullPointerException();
      AppMethodBeat.o(95863);
      throw paramT;
    }
    AppMethodBeat.o(95863);
    return paramT;
  }
  
  public static void checkState(boolean paramBoolean)
  {
    AppMethodBeat.i(95861);
    if (!paramBoolean)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException();
      AppMethodBeat.o(95861);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(95861);
  }
  
  public static void checkState(boolean paramBoolean, Object paramObject)
  {
    AppMethodBeat.i(95862);
    if (!paramBoolean)
    {
      paramObject = new IllegalStateException(String.valueOf(paramObject));
      AppMethodBeat.o(95862);
      throw paramObject;
    }
    AppMethodBeat.o(95862);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.i.a
 * JD-Core Version:    0.7.0.1
 */