package com.google.android.exoplayer2.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public static int bl(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(93109);
    if ((paramInt1 < 0) || (paramInt1 >= paramInt2))
    {
      IndexOutOfBoundsException localIndexOutOfBoundsException = new IndexOutOfBoundsException();
      AppMethodBeat.o(93109);
      throw localIndexOutOfBoundsException;
    }
    AppMethodBeat.o(93109);
    return paramInt1;
  }
  
  public static void checkArgument(boolean paramBoolean)
  {
    AppMethodBeat.i(93107);
    if (!paramBoolean)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException();
      AppMethodBeat.o(93107);
      throw localIllegalArgumentException;
    }
    AppMethodBeat.o(93107);
  }
  
  public static void checkArgument(boolean paramBoolean, Object paramObject)
  {
    AppMethodBeat.i(93108);
    if (!paramBoolean)
    {
      paramObject = new IllegalArgumentException(String.valueOf(paramObject));
      AppMethodBeat.o(93108);
      throw paramObject;
    }
    AppMethodBeat.o(93108);
  }
  
  public static <T> T checkNotNull(T paramT)
  {
    AppMethodBeat.i(93112);
    if (paramT == null)
    {
      paramT = new NullPointerException();
      AppMethodBeat.o(93112);
      throw paramT;
    }
    AppMethodBeat.o(93112);
    return paramT;
  }
  
  public static void checkState(boolean paramBoolean)
  {
    AppMethodBeat.i(93110);
    if (!paramBoolean)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException();
      AppMethodBeat.o(93110);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(93110);
  }
  
  public static void checkState(boolean paramBoolean, Object paramObject)
  {
    AppMethodBeat.i(93111);
    if (!paramBoolean)
    {
      paramObject = new IllegalStateException(String.valueOf(paramObject));
      AppMethodBeat.o(93111);
      throw paramObject;
    }
    AppMethodBeat.o(93111);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.i.a
 * JD-Core Version:    0.7.0.1
 */