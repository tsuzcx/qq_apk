package androidx.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  static final int[] zF = new int[0];
  static final long[] zG = new long[0];
  static final Object[] zH = new Object[0];
  
  static int a(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    int i = paramInt1 - 1;
    paramInt1 = 0;
    while (paramInt1 <= i)
    {
      int j = paramInt1 + i >>> 1;
      int k = paramArrayOfInt[j];
      if (k < paramInt2)
      {
        paramInt1 = j + 1;
      }
      else
      {
        i = j;
        if (k <= paramInt2) {
          return i;
        }
        i = j - 1;
      }
    }
    i = paramInt1 ^ 0xFFFFFFFF;
    return i;
  }
  
  public static int a(long[] paramArrayOfLong, int paramInt, long paramLong)
  {
    int i = paramInt - 1;
    paramInt = 0;
    while (paramInt <= i)
    {
      int j = paramInt + i >>> 1;
      long l = paramArrayOfLong[j];
      if (l < paramLong)
      {
        paramInt = j + 1;
      }
      else
      {
        i = j;
        if (l <= paramLong) {
          break label67;
        }
        i = j - 1;
      }
    }
    i = paramInt ^ 0xFFFFFFFF;
    label67:
    return i;
  }
  
  public static int aI(int paramInt)
  {
    AppMethodBeat.i(210214);
    paramInt = aJ(paramInt * 8) / 8;
    AppMethodBeat.o(210214);
    return paramInt;
  }
  
  private static int aJ(int paramInt)
  {
    int i = 4;
    for (;;)
    {
      int j = paramInt;
      if (i < 32)
      {
        if (paramInt <= (1 << i) - 12) {
          j = (1 << i) - 12;
        }
      }
      else {
        return j;
      }
      i += 1;
    }
  }
  
  public static boolean equal(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(210215);
    if ((paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2))))
    {
      AppMethodBeat.o(210215);
      return true;
    }
    AppMethodBeat.o(210215);
    return false;
  }
  
  public static int idealIntArraySize(int paramInt)
  {
    AppMethodBeat.i(210213);
    paramInt = aJ(paramInt * 4) / 4;
    AppMethodBeat.o(210213);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.b.c
 * JD-Core Version:    0.7.0.1
 */