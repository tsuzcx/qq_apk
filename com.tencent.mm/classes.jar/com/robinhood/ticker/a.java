package com.robinhood.ticker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class a
{
  private static int a(char[] paramArrayOfChar, int paramInt, Set<Character> paramSet)
  {
    AppMethodBeat.i(39839);
    while (paramInt < paramArrayOfChar.length)
    {
      if (!paramSet.contains(Character.valueOf(paramArrayOfChar[paramInt])))
      {
        AppMethodBeat.o(39839);
        return paramInt;
      }
      paramInt += 1;
    }
    paramInt = paramArrayOfChar.length;
    AppMethodBeat.o(39839);
    return paramInt;
  }
  
  private static void a(List<Integer> paramList, char[] paramArrayOfChar1, char[] paramArrayOfChar2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(39841);
    paramInt2 -= paramInt1;
    paramInt4 -= paramInt3;
    int j = Math.max(paramInt2, paramInt4);
    if (paramInt2 == paramInt4)
    {
      b(paramList, j, 0);
      AppMethodBeat.o(39841);
      return;
    }
    int k = paramInt2 + 1;
    int m = paramInt4 + 1;
    int[][] arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, new int[] { k, m });
    paramInt2 = 0;
    while (paramInt2 < k)
    {
      arrayOfInt[paramInt2][0] = paramInt2;
      paramInt2 += 1;
    }
    paramInt2 = 0;
    while (paramInt2 < m)
    {
      arrayOfInt[0][paramInt2] = paramInt2;
      paramInt2 += 1;
    }
    paramInt2 = 1;
    int i;
    while (paramInt2 < k)
    {
      paramInt4 = 1;
      if (paramInt4 < m)
      {
        if (paramArrayOfChar1[(paramInt2 - 1 + paramInt1)] == paramArrayOfChar2[(paramInt4 - 1 + paramInt3)]) {}
        for (i = 0;; i = 1)
        {
          arrayOfInt[paramInt2][paramInt4] = Math.min(arrayOfInt[(paramInt2 - 1)][paramInt4] + 1, Math.min(arrayOfInt[paramInt2][(paramInt4 - 1)] + 1, i + arrayOfInt[(paramInt2 - 1)][(paramInt4 - 1)]));
          paramInt4 += 1;
          break;
        }
      }
      paramInt2 += 1;
    }
    paramArrayOfChar1 = new ArrayList(j * 2);
    paramInt2 = k - 1;
    paramInt1 = m - 1;
    while ((paramInt2 > 0) || (paramInt1 > 0)) {
      if (paramInt2 == 0)
      {
        paramArrayOfChar1.add(Integer.valueOf(1));
        paramInt1 -= 1;
      }
      else if (paramInt1 == 0)
      {
        paramArrayOfChar1.add(Integer.valueOf(2));
        paramInt2 -= 1;
      }
      else
      {
        paramInt3 = arrayOfInt[paramInt2][(paramInt1 - 1)];
        paramInt4 = arrayOfInt[(paramInt2 - 1)][paramInt1];
        i = arrayOfInt[(paramInt2 - 1)][(paramInt1 - 1)];
        if ((paramInt3 < paramInt4) && (paramInt3 < i))
        {
          paramArrayOfChar1.add(Integer.valueOf(1));
          paramInt1 -= 1;
        }
        else if (paramInt4 < i)
        {
          paramArrayOfChar1.add(Integer.valueOf(2));
          paramInt2 -= 1;
        }
        else
        {
          paramArrayOfChar1.add(Integer.valueOf(0));
          paramInt2 -= 1;
          paramInt1 -= 1;
        }
      }
    }
    paramInt1 = paramArrayOfChar1.size() - 1;
    while (paramInt1 >= 0)
    {
      paramList.add(paramArrayOfChar1.get(paramInt1));
      paramInt1 -= 1;
    }
    AppMethodBeat.o(39841);
  }
  
  public static int[] a(char[] paramArrayOfChar1, char[] paramArrayOfChar2, Set<Character> paramSet)
  {
    int n = 0;
    AppMethodBeat.i(39838);
    ArrayList localArrayList = new ArrayList();
    int j = 0;
    int i = 0;
    for (;;)
    {
      int k;
      int m;
      if (i == paramArrayOfChar1.length)
      {
        k = 1;
        if (j != paramArrayOfChar2.length) {
          break label121;
        }
        m = 1;
        label41:
        if ((k == 0) || (m == 0))
        {
          if (k == 0) {
            break label127;
          }
          b(localArrayList, paramArrayOfChar2.length - j, 1);
        }
      }
      for (;;)
      {
        paramArrayOfChar1 = new int[localArrayList.size()];
        i = n;
        while (i < localArrayList.size())
        {
          paramArrayOfChar1[i] = ((Integer)localArrayList.get(i)).intValue();
          i += 1;
        }
        k = 0;
        break;
        label121:
        m = 0;
        break label41;
        label127:
        if (m == 0) {
          break label145;
        }
        b(localArrayList, paramArrayOfChar1.length - i, 2);
      }
      label145:
      boolean bool1 = paramSet.contains(Character.valueOf(paramArrayOfChar1[i]));
      boolean bool2 = paramSet.contains(Character.valueOf(paramArrayOfChar2[j]));
      if ((bool1) && (bool2))
      {
        k = a(paramArrayOfChar1, i + 1, paramSet);
        m = a(paramArrayOfChar2, j + 1, paramSet);
        a(localArrayList, paramArrayOfChar1, paramArrayOfChar2, i, k, j, m);
        j = m;
        i = k;
      }
      else if (bool1)
      {
        localArrayList.add(Integer.valueOf(1));
        j += 1;
      }
      else if (bool2)
      {
        localArrayList.add(Integer.valueOf(2));
        i += 1;
      }
      else
      {
        localArrayList.add(Integer.valueOf(0));
        i += 1;
        j += 1;
      }
    }
    AppMethodBeat.o(39838);
    return paramArrayOfChar1;
  }
  
  private static void b(List<Integer> paramList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(39840);
    int i = 0;
    while (i < paramInt1)
    {
      paramList.add(Integer.valueOf(paramInt2));
      i += 1;
    }
    AppMethodBeat.o(39840);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.robinhood.ticker.a
 * JD-Core Version:    0.7.0.1
 */