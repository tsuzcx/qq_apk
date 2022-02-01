package com.google.b.a.a;

import com.google.b.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public final class c
{
  private static final int[] cck = { 4, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12 };
  
  private static com.google.b.b.a a(com.google.b.b.a parama, int paramInt)
  {
    AppMethodBeat.i(12265);
    com.google.b.b.a locala = new com.google.b.b.a();
    int n = parama.size;
    int i1 = (1 << paramInt) - 2;
    int i = 0;
    if (i < n)
    {
      int j = 0;
      int m;
      for (int k = 0; j < paramInt; k = m)
      {
        if (i + j < n)
        {
          m = k;
          if (!parama.get(i + j)) {}
        }
        else
        {
          m = k | 1 << paramInt - 1 - j;
        }
        j += 1;
      }
      if ((k & i1) == i1)
      {
        locala.bH(k & i1, paramInt);
        i -= 1;
      }
      for (;;)
      {
        i += paramInt;
        break;
        if ((k & i1) == 0)
        {
          locala.bH(k | 0x1, paramInt);
          i -= 1;
        }
        else
        {
          locala.bH(k, paramInt);
        }
      }
    }
    AppMethodBeat.o(12265);
    return locala;
  }
  
  private static com.google.b.b.a a(com.google.b.b.a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(12263);
    int i = parama.size / paramInt2;
    Object localObject;
    switch (paramInt2)
    {
    case 5: 
    case 7: 
    case 9: 
    case 11: 
    default: 
      parama = new IllegalArgumentException("Unsupported word size ".concat(String.valueOf(paramInt2)));
      AppMethodBeat.o(12263);
      throw parama;
    case 4: 
      localObject = com.google.b.b.a.a.cdj;
    }
    for (;;)
    {
      localObject = new com.google.b.b.a.c((com.google.b.b.a.a)localObject);
      int j = paramInt1 / paramInt2;
      parama = b(parama, paramInt2, j);
      ((com.google.b.b.a.c)localObject).e(parama, j - i);
      localObject = new com.google.b.b.a();
      ((com.google.b.b.a)localObject).bH(0, paramInt1 % paramInt2);
      i = parama.length;
      paramInt1 = 0;
      while (paramInt1 < i)
      {
        ((com.google.b.b.a)localObject).bH(parama[paramInt1], paramInt2);
        paramInt1 += 1;
      }
      localObject = com.google.b.b.a.a.cdi;
      continue;
      localObject = com.google.b.b.a.a.cdm;
      continue;
      localObject = com.google.b.b.a.a.cdh;
      continue;
      localObject = com.google.b.b.a.a.cdg;
    }
    AppMethodBeat.o(12263);
    return localObject;
  }
  
  private static void a(b paramb, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(12261);
    int i = 0;
    while (i < paramInt2)
    {
      int j = paramInt1 - i;
      while (j <= paramInt1 + i)
      {
        paramb.set(j, paramInt1 - i);
        paramb.set(j, paramInt1 + i);
        paramb.set(paramInt1 - i, j);
        paramb.set(paramInt1 + i, j);
        j += 1;
      }
      i += 2;
    }
    paramb.set(paramInt1 - paramInt2, paramInt1 - paramInt2);
    paramb.set(paramInt1 - paramInt2 + 1, paramInt1 - paramInt2);
    paramb.set(paramInt1 - paramInt2, paramInt1 - paramInt2 + 1);
    paramb.set(paramInt1 + paramInt2, paramInt1 - paramInt2);
    paramb.set(paramInt1 + paramInt2, paramInt1 - paramInt2 + 1);
    paramb.set(paramInt1 + paramInt2, paramInt1 + paramInt2 - 1);
    AppMethodBeat.o(12261);
  }
  
  private static void a(b paramb, boolean paramBoolean, int paramInt, com.google.b.b.a parama)
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(12262);
    int k = paramInt / 2;
    paramInt = j;
    if (paramBoolean)
    {
      paramInt = i;
      while (paramInt < 7)
      {
        i = k - 3 + paramInt;
        if (parama.get(paramInt)) {
          paramb.set(i, k - 5);
        }
        if (parama.get(paramInt + 7)) {
          paramb.set(k + 5, i);
        }
        if (parama.get(20 - paramInt)) {
          paramb.set(i, k + 5);
        }
        if (parama.get(27 - paramInt)) {
          paramb.set(k - 5, i);
        }
        paramInt += 1;
      }
      AppMethodBeat.o(12262);
      return;
    }
    while (paramInt < 10)
    {
      i = k - 5 + paramInt + paramInt / 5;
      if (parama.get(paramInt)) {
        paramb.set(i, k - 7);
      }
      if (parama.get(paramInt + 10)) {
        paramb.set(k + 7, i);
      }
      if (parama.get(29 - paramInt)) {
        paramb.set(i, k + 7);
      }
      if (parama.get(39 - paramInt)) {
        paramb.set(k - 7, i);
      }
      paramInt += 1;
    }
    AppMethodBeat.o(12262);
  }
  
  private static int[] b(com.google.b.b.a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(12264);
    int[] arrayOfInt = new int[paramInt2];
    int m = parama.size / paramInt1;
    paramInt2 = 0;
    while (paramInt2 < m)
    {
      int i = 0;
      int j = 0;
      if (i < paramInt1)
      {
        if (parama.get(paramInt2 * paramInt1 + i)) {}
        for (int k = 1 << paramInt1 - i - 1;; k = 0)
        {
          j |= k;
          i += 1;
          break;
        }
      }
      arrayOfInt[paramInt2] = j;
      paramInt2 += 1;
    }
    AppMethodBeat.o(12264);
    return arrayOfInt;
  }
  
  private static int t(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 88;; i = 112) {
      return (i + (paramInt << 4)) * paramInt;
    }
  }
  
  public static a w(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(12260);
    Object localObject1 = new d(paramArrayOfByte);
    paramArrayOfByte = Collections.singletonList(f.ccs);
    int j = 0;
    int i;
    if (j < ((d)localObject1).ccp.length)
    {
      if (j + 1 < ((d)localObject1).ccp.length)
      {
        i = localObject1.ccp[(j + 1)];
        label61:
        switch (localObject1.ccp[j])
        {
        default: 
          i = 0;
          label114:
          if (i > 0) {
            paramArrayOfByte = d.a(paramArrayOfByte, j, i);
          }
          break;
        }
      }
      for (i = j + 1;; i = j)
      {
        j = i + 1;
        break;
        i = 0;
        break label61;
        if (i == 10)
        {
          i = 2;
          break label114;
        }
        i = 0;
        break label114;
        if (i == 32)
        {
          i = 3;
          break label114;
        }
        i = 0;
        break label114;
        if (i == 32)
        {
          i = 4;
          break label114;
        }
        i = 0;
        break label114;
        if (i == 32)
        {
          i = 5;
          break label114;
        }
        i = 0;
        break label114;
        localObject2 = new LinkedList();
        paramArrayOfByte = paramArrayOfByte.iterator();
        while (paramArrayOfByte.hasNext()) {
          ((d)localObject1).a((f)paramArrayOfByte.next(), j, (Collection)localObject2);
        }
        paramArrayOfByte = d.b((Iterable)localObject2);
      }
    }
    Object localObject2 = ((f)Collections.min(paramArrayOfByte, new d.1((d)localObject1))).J(((d)localObject1).ccp);
    int n = ((com.google.b.b.a)localObject2).size * paramInt1 / 100 + 11;
    int i1 = ((com.google.b.b.a)localObject2).size;
    boolean bool;
    if (paramInt2 != 0)
    {
      if (paramInt2 < 0)
      {
        bool = true;
        j = Math.abs(paramInt2);
        if (!bool) {
          break label382;
        }
      }
      label382:
      for (paramInt1 = 4;; paramInt1 = 32)
      {
        if (j <= paramInt1) {
          break label388;
        }
        paramArrayOfByte = new IllegalArgumentException(String.format("Illegal value %s for layers", new Object[] { Integer.valueOf(paramInt2) }));
        AppMethodBeat.o(12260);
        throw paramArrayOfByte;
        bool = false;
        break;
      }
      label388:
      paramInt2 = t(j, bool);
      paramInt1 = cck[j];
      paramArrayOfByte = a((com.google.b.b.a)localObject2, paramInt1);
      if (paramArrayOfByte.size + n > paramInt2 - paramInt2 % paramInt1)
      {
        paramArrayOfByte = new IllegalArgumentException("Data to large for user specified layer");
        AppMethodBeat.o(12260);
        throw paramArrayOfByte;
      }
      if ((bool) && (paramArrayOfByte.size > paramInt1 << 6))
      {
        paramArrayOfByte = new IllegalArgumentException("Data to large for user specified layer");
        AppMethodBeat.o(12260);
        throw paramArrayOfByte;
      }
    }
    for (;;)
    {
      localObject1 = a(paramArrayOfByte, paramInt2, paramInt1);
      i1 = paramArrayOfByte.size / paramInt1;
      paramArrayOfByte = new com.google.b.b.a();
      if (bool)
      {
        paramArrayOfByte.bH(j - 1, 2);
        paramArrayOfByte.bH(i1 - 1, 6);
        paramArrayOfByte = a(paramArrayOfByte, 28, 4);
        if (!bool) {
          break label780;
        }
      }
      int[] arrayOfInt;
      label619:
      int m;
      int k;
      label780:
      for (paramInt1 = 11;; paramInt1 = 14)
      {
        n = (j << 2) + paramInt1;
        arrayOfInt = new int[n];
        if (!bool) {
          break label1051;
        }
        paramInt1 = 0;
        while (paramInt1 < arrayOfInt.length)
        {
          arrayOfInt[paramInt1] = paramInt1;
          paramInt1 += 1;
        }
        i = 0;
        paramArrayOfByte = null;
        paramInt2 = 0;
        if (paramInt2 > 32)
        {
          paramArrayOfByte = new IllegalArgumentException("Data too large for an Aztec code");
          AppMethodBeat.o(12260);
          throw paramArrayOfByte;
        }
        if (paramInt2 <= 3)
        {
          bool = true;
          if (!bool) {
            break label744;
          }
        }
        label744:
        for (j = paramInt2 + 1;; j = paramInt2)
        {
          m = t(j, bool);
          localObject1 = paramArrayOfByte;
          k = i;
          if (i1 + n <= m)
          {
            paramInt1 = i;
            if (i != cck[j])
            {
              paramInt1 = cck[j];
              paramArrayOfByte = a((com.google.b.b.a)localObject2, paramInt1);
            }
            if (bool)
            {
              localObject1 = paramArrayOfByte;
              k = paramInt1;
              if (paramArrayOfByte.size > paramInt1 << 6) {}
            }
            else
            {
              if (paramArrayOfByte.size + n <= m - m % paramInt1) {
                break label1336;
              }
              k = paramInt1;
              localObject1 = paramArrayOfByte;
            }
          }
          paramInt2 += 1;
          paramArrayOfByte = (byte[])localObject1;
          i = k;
          break;
          bool = false;
          break label619;
        }
        paramArrayOfByte.bH(j - 1, 5);
        paramArrayOfByte.bH(i1 - 1, 11);
        paramArrayOfByte = a(paramArrayOfByte, 40, 4);
        break;
      }
      paramInt1 = n;
      localObject2 = new b(paramInt1);
      i = 0;
      paramInt2 = 0;
      for (;;)
      {
        if (i >= j) {
          break label1161;
        }
        int i2;
        if (bool)
        {
          k = 9;
          i2 = (j - i << 2) + k;
          k = 0;
        }
        for (;;)
        {
          if (k >= i2) {
            break label1147;
          }
          int i3 = k << 1;
          m = 0;
          for (;;)
          {
            if (m < 2)
            {
              if (((com.google.b.b.a)localObject1).get(paramInt2 + i3 + m)) {
                ((b)localObject2).set(arrayOfInt[((i << 1) + m)], arrayOfInt[((i << 1) + k)]);
              }
              if (((com.google.b.b.a)localObject1).get((i2 << 1) + paramInt2 + i3 + m)) {
                ((b)localObject2).set(arrayOfInt[((i << 1) + k)], arrayOfInt[(n - 1 - (i << 1) - m)]);
              }
              if (((com.google.b.b.a)localObject1).get((i2 << 2) + paramInt2 + i3 + m)) {
                ((b)localObject2).set(arrayOfInt[(n - 1 - (i << 1) - m)], arrayOfInt[(n - 1 - (i << 1) - k)]);
              }
              if (((com.google.b.b.a)localObject1).get(i2 * 6 + paramInt2 + i3 + m)) {
                ((b)localObject2).set(arrayOfInt[(n - 1 - (i << 1) - k)], arrayOfInt[((i << 1) + m)]);
              }
              m += 1;
              continue;
              label1051:
              i = n + 1 + (n / 2 - 1) / 15 * 2;
              k = n / 2;
              m = i / 2;
              paramInt2 = 0;
              for (;;)
              {
                paramInt1 = i;
                if (paramInt2 >= k) {
                  break;
                }
                paramInt1 = paramInt2 / 15 + paramInt2;
                arrayOfInt[(k - paramInt2 - 1)] = (m - paramInt1 - 1);
                arrayOfInt[(k + paramInt2)] = (paramInt1 + m + 1);
                paramInt2 += 1;
              }
              k = 12;
              break;
            }
          }
          k += 1;
        }
        label1147:
        i += 1;
        paramInt2 += (i2 << 3);
      }
      label1161:
      a((b)localObject2, bool, paramInt1, paramArrayOfByte);
      if (bool) {
        a((b)localObject2, paramInt1 / 2, 5);
      }
      for (;;)
      {
        paramArrayOfByte = new a();
        paramArrayOfByte.cce = bool;
        paramArrayOfByte.size = paramInt1;
        paramArrayOfByte.ccf = j;
        paramArrayOfByte.ccg = i1;
        paramArrayOfByte.cch = ((b)localObject2);
        AppMethodBeat.o(12260);
        return paramArrayOfByte;
        a((b)localObject2, paramInt1 / 2, 7);
        i = 0;
        paramInt2 = 0;
        while (i < n / 2 - 1)
        {
          k = paramInt1 / 2 & 0x1;
          while (k < paramInt1)
          {
            ((b)localObject2).set(paramInt1 / 2 - paramInt2, k);
            ((b)localObject2).set(paramInt1 / 2 + paramInt2, k);
            ((b)localObject2).set(k, paramInt1 / 2 - paramInt2);
            ((b)localObject2).set(k, paramInt1 / 2 + paramInt2);
            k += 2;
          }
          i += 15;
          paramInt2 += 16;
        }
      }
      label1336:
      paramInt2 = m;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.b.a.a.c
 * JD-Core Version:    0.7.0.1
 */