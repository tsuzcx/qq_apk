package com.google.b.f.b;

import com.google.b.f.a.c.b;
import com.google.b.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map<Lcom.google.b.c;*>;

public final class c
{
  private static final int[] blp = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1 };
  
  private static int a(com.google.b.b.a parama, com.google.b.f.a.a parama1, com.google.b.f.a.c paramc, b paramb)
  {
    AppMethodBeat.i(57252);
    int j = 2147483647;
    int k = -1;
    int i = 0;
    if (i < 8)
    {
      e.a(parama, parama1, paramc, i, paramb);
      int i5 = d.a(paramb, true);
      int i6 = d.a(paramb, false);
      int i1 = 0;
      byte[][] arrayOfByte = paramb.blo;
      int i3 = paramb.width;
      int i4 = paramb.height;
      int m = 0;
      while (m < i4 - 1)
      {
        n = 0;
        while (n < i3 - 1)
        {
          i7 = arrayOfByte[m][n];
          i2 = i1;
          if (i7 == arrayOfByte[m][(n + 1)])
          {
            i2 = i1;
            if (i7 == arrayOfByte[(m + 1)][n])
            {
              i2 = i1;
              if (i7 == arrayOfByte[(m + 1)][(n + 1)]) {
                i2 = i1 + 1;
              }
            }
          }
          n += 1;
          i1 = i2;
        }
        m += 1;
      }
      m = 0;
      arrayOfByte = paramb.blo;
      i4 = paramb.width;
      int i7 = paramb.height;
      int i2 = 0;
      byte[] arrayOfByte1;
      while (i2 < i7)
      {
        i3 = 0;
        while (i3 < i4)
        {
          arrayOfByte1 = arrayOfByte[i2];
          n = m;
          if (i3 + 6 < i4)
          {
            n = m;
            if (arrayOfByte1[i3] == 1)
            {
              n = m;
              if (arrayOfByte1[(i3 + 1)] == 0)
              {
                n = m;
                if (arrayOfByte1[(i3 + 2)] == 1)
                {
                  n = m;
                  if (arrayOfByte1[(i3 + 3)] == 1)
                  {
                    n = m;
                    if (arrayOfByte1[(i3 + 4)] == 1)
                    {
                      n = m;
                      if (arrayOfByte1[(i3 + 5)] == 0)
                      {
                        n = m;
                        if (arrayOfByte1[(i3 + 6)] == 1) {
                          if (!d.o(arrayOfByte1, i3 - 4, i3))
                          {
                            n = m;
                            if (!d.o(arrayOfByte1, i3 + 7, i3 + 11)) {}
                          }
                          else
                          {
                            n = m + 1;
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
          m = n;
          if (i2 + 6 < i7)
          {
            m = n;
            if (arrayOfByte[i2][i3] == 1)
            {
              m = n;
              if (arrayOfByte[(i2 + 1)][i3] == 0)
              {
                m = n;
                if (arrayOfByte[(i2 + 2)][i3] == 1)
                {
                  m = n;
                  if (arrayOfByte[(i2 + 3)][i3] == 1)
                  {
                    m = n;
                    if (arrayOfByte[(i2 + 4)][i3] == 1)
                    {
                      m = n;
                      if (arrayOfByte[(i2 + 5)][i3] == 0)
                      {
                        m = n;
                        if (arrayOfByte[(i2 + 6)][i3] == 1) {
                          if (!d.a(arrayOfByte, i3, i2 - 4, i2))
                          {
                            m = n;
                            if (!d.a(arrayOfByte, i3, i2 + 7, i2 + 11)) {}
                          }
                          else
                          {
                            m = n + 1;
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
          i3 += 1;
        }
        i2 += 1;
      }
      i2 = 0;
      arrayOfByte = paramb.blo;
      i7 = paramb.width;
      int i8 = paramb.height;
      int n = 0;
      while (n < i8)
      {
        arrayOfByte1 = arrayOfByte[n];
        i3 = 0;
        while (i3 < i7)
        {
          i4 = i2;
          if (arrayOfByte1[i3] == 1) {
            i4 = i2 + 1;
          }
          i3 += 1;
          i2 = i4;
        }
        n += 1;
      }
      n = paramb.height * paramb.width;
      m = i5 + i6 + i1 * 3 + m * 40 + Math.abs((i2 << 1) - n) * 10 / n * 10;
      if (m >= j) {
        break label764;
      }
      k = i;
      j = m;
    }
    label764:
    for (;;)
    {
      i += 1;
      break;
      AppMethodBeat.o(57252);
      return k;
    }
  }
  
  private static int a(com.google.b.f.a.b paramb, com.google.b.b.a parama1, com.google.b.b.a parama2, com.google.b.f.a.c paramc)
  {
    AppMethodBeat.i(57250);
    int i = parama1.size;
    int j = paramb.a(paramc);
    int k = parama2.size;
    AppMethodBeat.o(57250);
    return i + j + k;
  }
  
  private static com.google.b.b.a a(com.google.b.b.a parama, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(57256);
    if (parama.sB() != paramInt2)
    {
      parama = new h("Number of bits and data bytes does not match");
      AppMethodBeat.o(57256);
      throw parama;
    }
    int k = 0;
    int j = 0;
    ArrayList localArrayList = new ArrayList(paramInt3);
    int m = 0;
    int i = 0;
    Object localObject1;
    byte[] arrayOfByte;
    if (m < paramInt3)
    {
      localObject1 = new int[1];
      Object localObject2 = new int[1];
      if (m >= paramInt3)
      {
        parama = new h("Block ID too large");
        AppMethodBeat.o(57256);
        throw parama;
      }
      int n = paramInt1 % paramInt3;
      int i1 = paramInt3 - n;
      int i5 = paramInt1 / paramInt3;
      int i2 = paramInt2 / paramInt3;
      int i3 = i2 + 1;
      int i4 = i5 - i2;
      i5 = i5 + 1 - i3;
      if (i4 != i5)
      {
        parama = new h("EC bytes mismatch");
        AppMethodBeat.o(57256);
        throw parama;
      }
      if (paramInt3 != i1 + n)
      {
        parama = new h("RS blocks mismatch");
        AppMethodBeat.o(57256);
        throw parama;
      }
      if (paramInt1 != n * (i3 + i5) + (i2 + i4) * i1)
      {
        parama = new h("Total bytes mismatch");
        AppMethodBeat.o(57256);
        throw parama;
      }
      if (m < i1)
      {
        localObject1[0] = i2;
        localObject2[0] = i4;
      }
      for (;;)
      {
        n = localObject1[0];
        arrayOfByte = new byte[n];
        parama.a(k << 3, arrayOfByte, n);
        localObject2 = p(arrayOfByte, localObject2[0]);
        localArrayList.add(new a(arrayOfByte, (byte[])localObject2));
        j = Math.max(j, n);
        i = Math.max(i, localObject2.length);
        k += localObject1[0];
        m += 1;
        break;
        localObject1[0] = i3;
        localObject2[0] = i5;
      }
    }
    if (paramInt2 != k)
    {
      parama = new h("Data bytes does not match offset");
      AppMethodBeat.o(57256);
      throw parama;
    }
    parama = new com.google.b.b.a();
    paramInt2 = 0;
    while (paramInt2 < j)
    {
      localObject1 = localArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        arrayOfByte = ((a)((Iterator)localObject1).next()).blm;
        if (paramInt2 < arrayOfByte.length) {
          parama.bt(arrayOfByte[paramInt2], 8);
        }
      }
      paramInt2 += 1;
    }
    paramInt2 = 0;
    while (paramInt2 < i)
    {
      localObject1 = localArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        arrayOfByte = ((a)((Iterator)localObject1).next()).bln;
        if (paramInt2 < arrayOfByte.length) {
          parama.bt(arrayOfByte[paramInt2], 8);
        }
      }
      paramInt2 += 1;
    }
    if (paramInt1 != parama.sB())
    {
      parama = new h("Interleaving error: " + paramInt1 + " and " + parama.sB() + " differ.");
      AppMethodBeat.o(57256);
      throw parama;
    }
    AppMethodBeat.o(57256);
    return parama;
  }
  
  private static com.google.b.f.a.c a(int paramInt, com.google.b.f.a.a parama)
  {
    AppMethodBeat.i(57253);
    int i = 1;
    while (i <= 40)
    {
      com.google.b.f.a.c localc = com.google.b.f.a.c.fi(i);
      if (a(paramInt, localc, parama))
      {
        AppMethodBeat.o(57253);
        return localc;
      }
      i += 1;
    }
    parama = new h("Data too big");
    AppMethodBeat.o(57253);
    throw parama;
  }
  
  public static f a(String paramString, com.google.b.f.a.a parama, Map<com.google.b.c, ?> paramMap)
  {
    int n = 0;
    int i1 = 0;
    int i2 = 0;
    int m = 0;
    AppMethodBeat.i(57249);
    Object localObject1 = "ISO-8859-1";
    Object localObject2 = localObject1;
    if (paramMap != null)
    {
      localObject2 = localObject1;
      if (paramMap.containsKey(com.google.b.c.bhz)) {
        localObject2 = paramMap.get(com.google.b.c.bhz).toString();
      }
    }
    if (("Shift_JIS".equals(localObject2)) && (bl(paramString))) {
      localObject1 = com.google.b.f.a.b.bkX;
    }
    com.google.b.b.a locala;
    Object localObject3;
    int k;
    for (;;)
    {
      locala = new com.google.b.b.a();
      if ((localObject1 == com.google.b.f.a.b.bkV) && (!"ISO-8859-1".equals(localObject2)))
      {
        localObject3 = com.google.b.b.c.bh((String)localObject2);
        if (localObject3 != null)
        {
          locala.bt(com.google.b.f.a.b.bkW.bkP, 4);
          locala.bt(localObject3.biO[0], 8);
        }
      }
      locala.bt(((com.google.b.f.a.b)localObject1).bkP, 4);
      localObject3 = new com.google.b.b.a();
      switch (c.1.blq[localObject1.ordinal()])
      {
      default: 
        paramString = new h("Invalid mode: ".concat(String.valueOf(localObject1)));
        AppMethodBeat.o(57249);
        throw paramString;
        i = 0;
        k = 0;
        j = 0;
        if (i < paramString.length())
        {
          int i3 = paramString.charAt(i);
          if ((i3 >= 48) && (i3 <= 57)) {
            j = 1;
          }
          for (;;)
          {
            i += 1;
            break;
            if (fj(i3) == -1) {
              break label291;
            }
            k = 1;
          }
          label291:
          localObject1 = com.google.b.f.a.b.bkV;
        }
        else if (k != 0)
        {
          localObject1 = com.google.b.f.a.b.bkT;
        }
        else if (j != 0)
        {
          localObject1 = com.google.b.f.a.b.bkS;
        }
        else
        {
          localObject1 = com.google.b.f.a.b.bkV;
        }
        break;
      }
    }
    int j = paramString.length();
    int i = m;
    while (i < j)
    {
      k = paramString.charAt(i) - '0';
      if (i + 2 < j)
      {
        ((com.google.b.b.a)localObject3).bt(k * 100 + (paramString.charAt(i + 1) - '0') * 10 + (paramString.charAt(i + 2) - '0'), 10);
        i += 3;
      }
      else if (i + 1 < j)
      {
        ((com.google.b.b.a)localObject3).bt(k * 10 + (paramString.charAt(i + 1) - '0'), 7);
        i += 2;
      }
      else
      {
        ((com.google.b.b.a)localObject3).bt(k, 4);
        i += 1;
        continue;
        j = paramString.length();
        i = n;
        for (;;)
        {
          if (i < j)
          {
            k = fj(paramString.charAt(i));
            if (k == -1)
            {
              paramString = new h();
              AppMethodBeat.o(57249);
              throw paramString;
            }
            if (i + 1 < j)
            {
              m = fj(paramString.charAt(i + 1));
              if (m == -1)
              {
                paramString = new h();
                AppMethodBeat.o(57249);
                throw paramString;
              }
              ((com.google.b.b.a)localObject3).bt(k * 45 + m, 11);
              i += 2;
            }
            else
            {
              ((com.google.b.b.a)localObject3).bt(k, 6);
              i += 1;
              continue;
              try
              {
                localObject2 = paramString.getBytes((String)localObject2);
                j = localObject2.length;
                i = i1;
                for (;;)
                {
                  if (i < j)
                  {
                    ((com.google.b.b.a)localObject3).bt(localObject2[i], 8);
                    i += 1;
                    continue;
                    try
                    {
                      localObject2 = paramString.getBytes("Shift_JIS");
                      k = localObject2.length;
                      j = i2;
                      if (j < k)
                      {
                        i = (localObject2[j] & 0xFF) << 8 | localObject2[(j + 1)] & 0xFF;
                        if ((i >= 33088) && (i <= 40956))
                        {
                          i -= 33088;
                          if (i != -1) {
                            break label793;
                          }
                          paramString = new h("Invalid byte sequence");
                          AppMethodBeat.o(57249);
                          throw paramString;
                        }
                      }
                    }
                    catch (UnsupportedEncodingException paramString)
                    {
                      paramString = new h(paramString);
                      AppMethodBeat.o(57249);
                      throw paramString;
                    }
                  }
                }
              }
              catch (UnsupportedEncodingException paramString)
              {
                paramString = new h(paramString);
                AppMethodBeat.o(57249);
                throw paramString;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      if ((i >= 57408) && (i <= 60351))
      {
        i -= 49472;
        continue;
        label793:
        ((com.google.b.b.a)localObject3).bt((i & 0xFF) + (i >> 8) * 192, 13);
        j += 2;
        continue;
        if ((paramMap != null) && (paramMap.containsKey(com.google.b.c.bhI)))
        {
          localObject2 = com.google.b.f.a.c.fi(Integer.parseInt(paramMap.get(com.google.b.c.bhI).toString()));
          paramMap = (Map<com.google.b.c, ?>)localObject2;
          if (!a(a((com.google.b.f.a.b)localObject1, locala, (com.google.b.b.a)localObject3, (com.google.b.f.a.c)localObject2), (com.google.b.f.a.c)localObject2, parama))
          {
            paramString = new h("Data too big for requested version");
            AppMethodBeat.o(57249);
            throw paramString;
          }
        }
        else
        {
          paramMap = a(a((com.google.b.f.a.b)localObject1, locala, (com.google.b.b.a)localObject3, a(a((com.google.b.f.a.b)localObject1, locala, (com.google.b.b.a)localObject3, com.google.b.f.a.c.fi(1)), parama)), parama);
        }
        localObject2 = new com.google.b.b.a();
        ((com.google.b.b.a)localObject2).a(locala);
        if (localObject1 == com.google.b.f.a.b.bkV) {}
        for (i = ((com.google.b.b.a)localObject3).sB();; i = paramString.length())
        {
          j = ((com.google.b.f.a.b)localObject1).a(paramMap);
          if (i < 1 << j) {
            break;
          }
          paramString = new h(i + " is bigger than " + ((1 << j) - 1));
          AppMethodBeat.o(57249);
          throw paramString;
        }
        ((com.google.b.b.a)localObject2).bt(i, j);
        ((com.google.b.b.a)localObject2).a((com.google.b.b.a)localObject3);
        paramString = paramMap.a(parama);
        i = paramMap.bli - paramString.sU();
        a(i, (com.google.b.b.a)localObject2);
        paramString = a((com.google.b.b.a)localObject2, paramMap.bli, i, paramString.sT());
        localObject2 = new f();
        ((f)localObject2).blw = parama;
        ((f)localObject2).blv = ((com.google.b.f.a.b)localObject1);
        ((f)localObject2).blx = paramMap;
        i = paramMap.blf * 4 + 17;
        localObject1 = new b(i, i);
        i = a(paramString, parama, paramMap, (b)localObject1);
        ((f)localObject2).bly = i;
        e.a(paramString, parama, paramMap, i, (b)localObject1);
        ((f)localObject2).blz = ((b)localObject1);
        AppMethodBeat.o(57249);
        return localObject2;
      }
      else
      {
        i = -1;
      }
    }
  }
  
  private static void a(int paramInt, com.google.b.b.a parama)
  {
    AppMethodBeat.i(57255);
    int k = paramInt << 3;
    if (parama.size > k)
    {
      parama = new h("data bits cannot fit in the QR Code" + parama.size + " > " + k);
      AppMethodBeat.o(57255);
      throw parama;
    }
    int i = 0;
    while ((i < 4) && (parama.size < k))
    {
      parama.aS(false);
      i += 1;
    }
    i = parama.size & 0x7;
    if (i > 0) {
      while (i < 8)
      {
        parama.aS(false);
        i += 1;
      }
    }
    int m = parama.sB();
    i = 0;
    if (i < paramInt - m)
    {
      if ((i & 0x1) == 0) {}
      for (int j = 236;; j = 17)
      {
        parama.bt(j, 8);
        i += 1;
        break;
      }
    }
    if (parama.size != k)
    {
      parama = new h("Bits size does not equal capacity");
      AppMethodBeat.o(57255);
      throw parama;
    }
    AppMethodBeat.o(57255);
  }
  
  private static boolean a(int paramInt, com.google.b.f.a.c paramc, com.google.b.f.a.a parama)
  {
    AppMethodBeat.i(57254);
    if (paramc.bli - paramc.a(parama).sU() >= (paramInt + 7) / 8)
    {
      AppMethodBeat.o(57254);
      return true;
    }
    AppMethodBeat.o(57254);
    return false;
  }
  
  private static boolean bl(String paramString)
  {
    AppMethodBeat.i(57251);
    int j;
    try
    {
      paramString = paramString.getBytes("Shift_JIS");
      j = paramString.length;
      if (j % 2 != 0)
      {
        AppMethodBeat.o(57251);
        return false;
      }
    }
    catch (UnsupportedEncodingException paramString)
    {
      AppMethodBeat.o(57251);
      return false;
    }
    int i = 0;
    while (i < j)
    {
      int k = paramString[i] & 0xFF;
      if (((k < 129) || (k > 159)) && ((k < 224) || (k > 235)))
      {
        AppMethodBeat.o(57251);
        return false;
      }
      i += 2;
    }
    AppMethodBeat.o(57251);
    return true;
  }
  
  private static int fj(int paramInt)
  {
    if (paramInt < blp.length) {
      return blp[paramInt];
    }
    return -1;
  }
  
  private static byte[] p(byte[] paramArrayOfByte, int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(57257);
    int k = paramArrayOfByte.length;
    int[] arrayOfInt = new int[k + paramInt];
    int i = 0;
    while (i < k)
    {
      paramArrayOfByte[i] &= 0xFF;
      i += 1;
    }
    new com.google.b.b.a.c(com.google.b.b.a.a.biV).e(arrayOfInt, paramInt);
    paramArrayOfByte = new byte[paramInt];
    i = j;
    while (i < paramInt)
    {
      paramArrayOfByte[i] = ((byte)arrayOfInt[(k + i)]);
      i += 1;
    }
    AppMethodBeat.o(57257);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.b.f.b.c
 * JD-Core Version:    0.7.0.1
 */