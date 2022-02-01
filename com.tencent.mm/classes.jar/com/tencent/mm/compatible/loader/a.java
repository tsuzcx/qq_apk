package com.tencent.mm.compatible.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private static Object[] lYp = new Object[0];
  private static Object[] lYq = new Object[73];
  
  public static boolean contains(int[] paramArrayOfInt, int paramInt)
  {
    boolean bool2 = false;
    int j = paramArrayOfInt.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (paramArrayOfInt[i] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static <T> boolean contains(T[] paramArrayOfT, T paramT)
  {
    AppMethodBeat.i(157476);
    int j = paramArrayOfT.length;
    int i = 0;
    while (i < j)
    {
      T ? = paramArrayOfT[i];
      if (? == null)
      {
        if (paramT == null)
        {
          AppMethodBeat.o(157476);
          return true;
        }
      }
      else if ((paramT != null) && (?.equals(paramT)))
      {
        AppMethodBeat.o(157476);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(157476);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.compatible.loader.a
 * JD-Core Version:    0.7.0.1
 */