package android.support.v7.c.a;

import java.lang.reflect.Array;

final class c
{
  static
  {
    if (!c.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public static <T> T[] a(T[] paramArrayOfT, int paramInt, T paramT)
  {
    assert (paramInt <= paramArrayOfT.length);
    if (paramInt + 1 > paramArrayOfT.length)
    {
      Object[] arrayOfObject = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), aY(paramInt));
      System.arraycopy(paramArrayOfT, 0, arrayOfObject, 0, paramInt);
      paramArrayOfT = arrayOfObject;
    }
    for (;;)
    {
      paramArrayOfT[paramInt] = paramT;
      return paramArrayOfT;
    }
  }
  
  private static int aY(int paramInt)
  {
    if (paramInt <= 4) {
      return 8;
    }
    return paramInt * 2;
  }
  
  public static int[] c(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    assert (paramInt1 <= paramArrayOfInt.length);
    int[] arrayOfInt = paramArrayOfInt;
    if (paramInt1 + 1 > paramArrayOfInt.length)
    {
      arrayOfInt = new int[aY(paramInt1)];
      System.arraycopy(paramArrayOfInt, 0, arrayOfInt, 0, paramInt1);
    }
    arrayOfInt[paramInt1] = paramInt2;
    return arrayOfInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.c.a.c
 * JD-Core Version:    0.7.0.1
 */