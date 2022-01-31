package android.support.v7.h;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class c
{
  private static final Comparator<c.e> Tm = new c.1();
  
  public static c.b a(c.a parama)
  {
    return a(parama, true);
  }
  
  public static c.b a(c.a parama, boolean paramBoolean)
  {
    int i = parama.fv();
    int j = parama.fw();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.add(new c.d(i, j));
    i = i + j + Math.abs(i - j);
    int[] arrayOfInt1 = new int[i * 2];
    int[] arrayOfInt2 = new int[i * 2];
    ArrayList localArrayList3 = new ArrayList();
    while (!localArrayList2.isEmpty())
    {
      c.d locald2 = (c.d)localArrayList2.remove(localArrayList2.size() - 1);
      c.e locale = a(parama, locald2.Tx, locald2.Ty, locald2.Tz, locald2.TA, arrayOfInt1, arrayOfInt2, i);
      if (locale != null)
      {
        if (locale.size > 0) {
          localArrayList1.add(locale);
        }
        locale.x += locald2.Tx;
        locale.y += locald2.Tz;
        c.d locald1;
        if (localArrayList3.isEmpty())
        {
          locald1 = new c.d();
          label215:
          locald1.Tx = locald2.Tx;
          locald1.Tz = locald2.Tz;
          if (!locale.TB) {
            break label360;
          }
          locald1.Ty = locale.x;
          locald1.TA = locale.y;
          label263:
          localArrayList2.add(locald1);
          if (!locale.TB) {
            break label455;
          }
          if (!locale.Tw) {
            break label418;
          }
          locald2.Tx = (locale.x + locale.size + 1);
          locald2.Tz = (locale.y + locale.size);
        }
        for (;;)
        {
          localArrayList2.add(locald2);
          break;
          locald1 = (c.d)localArrayList3.remove(localArrayList3.size() - 1);
          break label215;
          label360:
          if (locale.Tw)
          {
            locald1.Ty = (locale.x - 1);
            locald1.TA = locale.y;
            break label263;
          }
          locald1.Ty = locale.x;
          locald1.TA = (locale.y - 1);
          break label263;
          label418:
          locald2.Tx = (locale.x + locale.size);
          locald2.Tz = (locale.y + locale.size + 1);
          continue;
          label455:
          locald2.Tx = (locale.x + locale.size);
          locald2.Tz = (locale.y + locale.size);
        }
      }
      localArrayList3.add(locald2);
    }
    Collections.sort(localArrayList1, Tm);
    return new c.b(parama, localArrayList1, arrayOfInt1, arrayOfInt2, paramBoolean);
  }
  
  private static c.e a(c.a parama, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt5)
  {
    int n = paramInt2 - paramInt1;
    int i1 = paramInt4 - paramInt3;
    if ((paramInt2 - paramInt1 <= 0) || (paramInt4 - paramInt3 <= 0)) {
      return null;
    }
    int i2 = n - i1;
    int i3 = (n + i1 + 1) / 2;
    Arrays.fill(paramArrayOfInt1, paramInt5 - i3 - 1, paramInt5 + i3 + 1, 0);
    Arrays.fill(paramArrayOfInt2, paramInt5 - i3 - 1 + i2, paramInt5 + i3 + 1 + i2, n);
    int i;
    if (i2 % 2 != 0)
    {
      paramInt4 = 1;
      i = 0;
    }
    for (;;)
    {
      if (i > i3) {
        break label670;
      }
      int j = -i;
      boolean bool;
      int m;
      int k;
      for (;;)
      {
        if (j > i) {
          break label384;
        }
        if ((j == -i) || ((j != i) && (paramArrayOfInt1[(paramInt5 + j - 1)] < paramArrayOfInt1[(paramInt5 + j + 1)]))) {
          paramInt2 = paramArrayOfInt1[(paramInt5 + j + 1)];
        }
        for (bool = false;; bool = true)
        {
          m = paramInt2 - j;
          k = paramInt2;
          paramInt2 = m;
          while ((k < n) && (paramInt2 < i1) && (parama.F(paramInt1 + k, paramInt3 + paramInt2)))
          {
            k += 1;
            paramInt2 += 1;
          }
          paramInt4 = 0;
          break;
          paramInt2 = paramArrayOfInt1[(paramInt5 + j - 1)] + 1;
        }
        paramArrayOfInt1[(paramInt5 + j)] = k;
        if ((paramInt4 != 0) && (j >= i2 - i + 1) && (j <= i2 + i - 1) && (paramArrayOfInt1[(paramInt5 + j)] >= paramArrayOfInt2[(paramInt5 + j)]))
        {
          parama = new c.e();
          parama.x = paramArrayOfInt2[(paramInt5 + j)];
          parama.y = (parama.x - j);
          parama.size = (paramArrayOfInt1[(paramInt5 + j)] - paramArrayOfInt2[(paramInt5 + j)]);
          parama.Tw = bool;
          parama.TB = false;
          return parama;
        }
        j += 2;
      }
      label384:
      j = -i;
      while (j <= i)
      {
        int i4 = j + i2;
        if ((i4 == i + i2) || ((i4 != -i + i2) && (paramArrayOfInt2[(paramInt5 + i4 - 1)] < paramArrayOfInt2[(paramInt5 + i4 + 1)]))) {
          paramInt2 = paramArrayOfInt2[(paramInt5 + i4 - 1)];
        }
        for (bool = false;; bool = true)
        {
          m = paramInt2 - i4;
          k = paramInt2;
          paramInt2 = m;
          while ((k > 0) && (paramInt2 > 0) && (parama.F(paramInt1 + k - 1, paramInt3 + paramInt2 - 1)))
          {
            k -= 1;
            paramInt2 -= 1;
          }
          paramInt2 = paramArrayOfInt2[(paramInt5 + i4 + 1)] - 1;
        }
        paramArrayOfInt2[(paramInt5 + i4)] = k;
        if ((paramInt4 == 0) && (j + i2 >= -i) && (j + i2 <= i) && (paramArrayOfInt1[(paramInt5 + i4)] >= paramArrayOfInt2[(paramInt5 + i4)]))
        {
          parama = new c.e();
          parama.x = paramArrayOfInt2[(paramInt5 + i4)];
          parama.y = (parama.x - i4);
          parama.size = (paramArrayOfInt1[(paramInt5 + i4)] - paramArrayOfInt2[(paramInt5 + i4)]);
          parama.Tw = bool;
          parama.TB = true;
          return parama;
        }
        j += 2;
      }
      i += 1;
    }
    label670:
    throw new IllegalStateException("DiffUtil hit an unexpected case while trying to calculate the optimal path. Please make sure your data is not changing during the diff calculation.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.h.c
 * JD-Core Version:    0.7.0.1
 */