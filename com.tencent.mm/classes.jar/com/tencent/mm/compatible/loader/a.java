package com.tencent.mm.compatible.loader;

public final class a
{
  private static Object[] dyV = new Object[0];
  private static Object[] dyW = new Object[73];
  
  public static <T> boolean a(T[] paramArrayOfT, T paramT)
  {
    int j = paramArrayOfT.length;
    int i = 0;
    while (i < j)
    {
      T ? = paramArrayOfT[i];
      if (? == null)
      {
        if (paramT != null) {}
      }
      else {
        while ((paramT != null) && (?.equals(paramT))) {
          return true;
        }
      }
      i += 1;
    }
    return false;
  }
  
  public static boolean d(int[] paramArrayOfInt, int paramInt)
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
  
  public static int idealIntArraySize(int paramInt)
  {
    int j = paramInt * 4;
    paramInt = 4;
    for (;;)
    {
      int i = j;
      if (paramInt < 32)
      {
        if (j <= (1 << paramInt) - 12) {
          i = (1 << paramInt) - 12;
        }
      }
      else {
        return i / 4;
      }
      paramInt += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.compatible.loader.a
 * JD-Core Version:    0.7.0.1
 */