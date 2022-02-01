package com.google.c.d;

import com.google.c.a;
import com.google.c.b.b;
import com.google.c.c;
import com.google.c.g;
import java.util.Map;

public abstract class o
  implements g
{
  protected static int a(boolean[] paramArrayOfBoolean, int paramInt, int[] paramArrayOfInt, boolean paramBoolean)
  {
    int m = paramArrayOfInt.length;
    int k = 0;
    int i = 0;
    int j = paramInt;
    paramInt = k;
    if (paramInt < m)
    {
      int n = paramArrayOfInt[paramInt];
      k = 0;
      while (k < n)
      {
        paramArrayOfBoolean[j] = paramBoolean;
        k += 1;
        j += 1;
      }
      i += n;
      if (!paramBoolean) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramInt += 1;
        break;
      }
    }
    return i;
  }
  
  private static b a(boolean[] paramArrayOfBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramArrayOfBoolean.length;
    int j = i + paramInt3;
    int k = Math.max(paramInt1, j);
    paramInt3 = Math.max(1, paramInt2);
    j = k / j;
    paramInt1 = (k - i * j) / 2;
    b localb = new b(k, paramInt3);
    paramInt2 = 0;
    while (paramInt2 < i)
    {
      if (paramArrayOfBoolean[paramInt2] != 0) {
        localb.p(paramInt1, 0, j, paramInt3);
      }
      paramInt2 += 1;
      paramInt1 += j;
    }
    return localb;
  }
  
  public b a(String paramString, a parama, int paramInt1, int paramInt2, Map<c, ?> paramMap)
  {
    if (paramString.isEmpty()) {
      throw new IllegalArgumentException("Found empty contents");
    }
    if ((paramInt1 < 0) || (paramInt2 < 0)) {
      throw new IllegalArgumentException("Negative size is not allowed. Input: " + paramInt1 + 'x' + paramInt2);
    }
    int j = yx();
    int i = j;
    if (paramMap != null)
    {
      i = j;
      if (paramMap.containsKey(c.bJx)) {
        i = Integer.parseInt(paramMap.get(c.bJx).toString());
      }
    }
    return a(bw(paramString), paramInt1, paramInt2, i);
  }
  
  public abstract boolean[] bw(String paramString);
  
  public int yx()
  {
    return 10;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.c.d.o
 * JD-Core Version:    0.7.0.1
 */