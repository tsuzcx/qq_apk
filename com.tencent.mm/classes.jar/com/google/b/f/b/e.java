package com.google.b.f.b;

import com.google.b.f.a.c;
import com.google.b.h;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e
{
  private static final int[][] blr;
  private static final int[][] bls;
  private static final int[][] blt;
  private static final int[][] blu = { { 8, 0 }, { 8, 1 }, { 8, 2 }, { 8, 3 }, { 8, 4 }, { 8, 5 }, { 8, 7 }, { 8, 8 }, { 7, 8 }, { 5, 8 }, { 4, 8 }, { 3, 8 }, { 2, 8 }, { 1, 8 }, { 0, 8 } };
  
  static
  {
    int[] arrayOfInt1 = { 1, 1, 1, 1, 1, 1, 1 };
    int[] arrayOfInt2 = { 1, 0, 1, 1, 1, 0, 1 };
    int[] arrayOfInt3 = { 1, 0, 1, 1, 1, 0, 1 };
    int[] arrayOfInt4 = { 1, 0, 1, 1, 1, 0, 1 };
    int[] arrayOfInt5 = { 1, 0, 0, 0, 0, 0, 1 };
    int[] arrayOfInt6 = { 1, 1, 1, 1, 1, 1, 1 };
    blr = new int[][] { arrayOfInt1, { 1, 0, 0, 0, 0, 0, 1 }, arrayOfInt2, arrayOfInt3, arrayOfInt4, arrayOfInt5, arrayOfInt6 };
    bls = new int[][] { { 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 0, 0, 1 }, { 1, 1, 1, 1, 1 } };
    arrayOfInt1 = new int[] { -1, -1, -1, -1, -1, -1, -1 };
    arrayOfInt2 = new int[] { 6, 22, -1, -1, -1, -1, -1 };
    arrayOfInt3 = new int[] { 6, 26, -1, -1, -1, -1, -1 };
    arrayOfInt4 = new int[] { 6, 34, -1, -1, -1, -1, -1 };
    arrayOfInt5 = new int[] { 6, 22, 38, -1, -1, -1, -1 };
    arrayOfInt6 = new int[] { 6, 24, 42, -1, -1, -1, -1 };
    int[] arrayOfInt7 = { 6, 26, 46, -1, -1, -1, -1 };
    int[] arrayOfInt8 = { 6, 28, 50, -1, -1, -1, -1 };
    int[] arrayOfInt9 = { 6, 32, 58, -1, -1, -1, -1 };
    int[] arrayOfInt10 = { 6, 34, 62, -1, -1, -1, -1 };
    int[] arrayOfInt11 = { 6, 26, 46, 66, -1, -1, -1 };
    int[] arrayOfInt12 = { 6, 30, 56, 82, -1, -1, -1 };
    int[] arrayOfInt13 = { 6, 30, 58, 86, -1, -1, -1 };
    int[] arrayOfInt14 = { 6, 34, 62, 90, -1, -1, -1 };
    int[] arrayOfInt15 = { 6, 26, 50, 74, 98, -1, -1 };
    int[] arrayOfInt16 = { 6, 30, 54, 78, 102, -1, -1 };
    int[] arrayOfInt17 = { 6, 28, 54, 80, 106, -1, -1 };
    int[] arrayOfInt18 = { 6, 32, 58, 84, 110, -1, -1 };
    int[] arrayOfInt19 = { 6, 34, 62, 90, 118, -1, -1 };
    int[] arrayOfInt20 = { 6, 30, 54, 78, 102, 126, -1 };
    int[] arrayOfInt21 = { 6, 30, 56, 82, 108, 134, -1 };
    int[] arrayOfInt22 = { 6, 34, 60, 86, 112, 138, -1 };
    int[] arrayOfInt23 = { 6, 30, 58, 86, 114, 142, -1 };
    int[] arrayOfInt24 = { 6, 34, 62, 90, 118, 146, -1 };
    int[] arrayOfInt25 = { 6, 30, 54, 78, 102, 126, 150 };
    int[] arrayOfInt26 = { 6, 26, 54, 82, 110, 138, 166 };
    int[] arrayOfInt27 = { 6, 30, 58, 86, 114, 142, 170 };
    blt = new int[][] { arrayOfInt1, { 6, 18, -1, -1, -1, -1, -1 }, arrayOfInt2, arrayOfInt3, { 6, 30, -1, -1, -1, -1, -1 }, arrayOfInt4, arrayOfInt5, arrayOfInt6, arrayOfInt7, arrayOfInt8, { 6, 30, 54, -1, -1, -1, -1 }, arrayOfInt9, arrayOfInt10, arrayOfInt11, { 6, 26, 48, 70, -1, -1, -1 }, { 6, 26, 50, 74, -1, -1, -1 }, { 6, 30, 54, 78, -1, -1, -1 }, arrayOfInt12, arrayOfInt13, arrayOfInt14, { 6, 28, 50, 72, 94, -1, -1 }, arrayOfInt15, arrayOfInt16, arrayOfInt17, arrayOfInt18, { 6, 30, 58, 86, 114, -1, -1 }, arrayOfInt19, { 6, 26, 50, 74, 98, 122, -1 }, arrayOfInt20, { 6, 26, 52, 78, 104, 130, -1 }, arrayOfInt21, arrayOfInt22, arrayOfInt23, arrayOfInt24, arrayOfInt25, { 6, 24, 50, 76, 102, 128, 154 }, { 6, 28, 54, 80, 106, 132, 158 }, { 6, 32, 58, 84, 110, 136, 162 }, arrayOfInt26, arrayOfInt27 };
  }
  
  private static void a(int paramInt1, int paramInt2, b paramb)
  {
    AppMethodBeat.i(57186);
    int i = 0;
    while (i < 8)
    {
      if (!fk(paramb.bA(paramInt1 + i, paramInt2)))
      {
        paramb = new h();
        AppMethodBeat.o(57186);
        throw paramb;
      }
      paramb.set(paramInt1 + i, paramInt2, 0);
      i += 1;
    }
    AppMethodBeat.o(57186);
  }
  
  private static void a(com.google.b.b.a parama, int paramInt, b paramb)
  {
    AppMethodBeat.i(57184);
    int j = paramb.width - 1;
    int i = paramb.height - 1;
    int m = -1;
    int k = 0;
    int n;
    if (j > 0)
    {
      if (j != 6) {
        break label459;
      }
      n = j - 1;
      j = i;
    }
    for (;;)
    {
      if ((j >= 0) && (j < paramb.height))
      {
        int i1 = 0;
        i = k;
        if (i1 < 2)
        {
          int i2 = n - i1;
          k = i;
          if (fk(paramb.bA(i2, j)))
          {
            boolean bool1;
            if (i < parama.size) {
              bool1 = parama.get(i);
            }
            for (k = i + 1;; k = i)
            {
              bool2 = bool1;
              if (paramInt == -1) {
                break;
              }
              switch (paramInt)
              {
              default: 
                parama = new IllegalArgumentException("Invalid mask pattern: ".concat(String.valueOf(paramInt)));
                AppMethodBeat.o(57184);
                throw parama;
                bool1 = false;
              }
            }
            i = j + i2 & 0x1;
            label213:
            if (i != 0) {
              break label356;
            }
            i = 1;
            label219:
            bool2 = bool1;
            if (i != 0) {
              if (bool1) {
                break label361;
              }
            }
          }
          label356:
          label361:
          for (boolean bool2 = true;; bool2 = false)
          {
            paramb.set(i2, j, bool2);
            i1 += 1;
            i = k;
            break;
            i = j & 0x1;
            break label213;
            i = i2 % 3;
            break label213;
            i = (j + i2) % 3;
            break label213;
            i = j / 2 + i2 / 3 & 0x1;
            break label213;
            i = j * i2;
            i = i % 3 + (i & 0x1);
            break label213;
            i = j * i2;
            i = i % 3 + (i & 0x1) & 0x1;
            break label213;
            i = j * i2 % 3 + (j + i2 & 0x1) & 0x1;
            break label213;
            i = 0;
            break label219;
          }
        }
        j += m;
        k = i;
      }
      else
      {
        m = -m;
        i = j + m;
        j = n - 2;
        break;
        if (k != parama.size)
        {
          parama = new h("Not all bits consumed: " + k + '/' + parama.size);
          AppMethodBeat.o(57184);
          throw parama;
        }
        AppMethodBeat.o(57184);
        return;
        label459:
        n = j;
        j = i;
      }
    }
  }
  
  static void a(com.google.b.b.a parama, com.google.b.f.a.a parama1, c paramc, int paramInt, b paramb)
  {
    AppMethodBeat.i(57182);
    int i = 0;
    int j;
    while (i < paramb.height)
    {
      j = 0;
      while (j < paramb.width)
      {
        paramb.blo[i][j] = -1;
        j += 1;
      }
      i += 1;
    }
    i = blr[0].length;
    c(0, 0, paramb);
    c(paramb.width - i, 0, paramb);
    c(0, paramb.width - i, paramb);
    a(0, 7, paramb);
    a(paramb.width - 8, 7, paramb);
    a(0, paramb.width - 8, paramb);
    b(7, 0, paramb);
    b(paramb.height - 7 - 1, 0, paramb);
    b(7, paramb.height - 7, paramb);
    if (paramb.bA(8, paramb.height - 8) == 0)
    {
      parama = new h();
      AppMethodBeat.o(57182);
      throw parama;
    }
    paramb.set(8, paramb.height - 8, 1);
    if (paramc.blf >= 2)
    {
      i = paramc.blf - 1;
      localObject = blt[i];
      int n = blt[i].length;
      i = 0;
      while (i < n)
      {
        j = 0;
        while (j < n)
        {
          int i1 = localObject[i];
          int i2 = localObject[j];
          if ((i2 != -1) && (i1 != -1) && (fk(paramb.bA(i2, i1))))
          {
            int k = 0;
            while (k < 5)
            {
              int m = 0;
              while (m < 5)
              {
                paramb.set(i2 - 2 + m, i1 - 2 + k, bls[k][m]);
                m += 1;
              }
              k += 1;
            }
          }
          j += 1;
        }
        i += 1;
      }
    }
    i = 8;
    while (i < paramb.width - 8)
    {
      j = (i + 1) % 2;
      if (fk(paramb.bA(i, 6))) {
        paramb.set(i, 6, j);
      }
      if (fk(paramb.bA(6, i))) {
        paramb.set(6, i, j);
      }
      i += 1;
    }
    Object localObject = new com.google.b.b.a();
    if ((paramInt >= 0) && (paramInt < 8)) {}
    for (i = 1; i == 0; i = 0)
    {
      parama = new h("Invalid mask pattern");
      AppMethodBeat.o(57182);
      throw parama;
    }
    i = parama1.bkP << 3 | paramInt;
    ((com.google.b.b.a)localObject).bt(i, 5);
    ((com.google.b.b.a)localObject).bt(bB(i, 1335), 10);
    parama1 = new com.google.b.b.a();
    parama1.bt(21522, 15);
    if (((com.google.b.b.a)localObject).size != parama1.size)
    {
      parama = new IllegalArgumentException("Sizes don't match");
      AppMethodBeat.o(57182);
      throw parama;
    }
    i = 0;
    while (i < ((com.google.b.b.a)localObject).bij.length)
    {
      int[] arrayOfInt = ((com.google.b.b.a)localObject).bij;
      arrayOfInt[i] ^= parama1.bij[i];
      i += 1;
    }
    if (((com.google.b.b.a)localObject).size != 15)
    {
      parama = new h("should not happen but we got: " + ((com.google.b.b.a)localObject).size);
      AppMethodBeat.o(57182);
      throw parama;
    }
    i = 0;
    if (i < ((com.google.b.b.a)localObject).size)
    {
      boolean bool = ((com.google.b.b.a)localObject).get(((com.google.b.b.a)localObject).size - 1 - i);
      paramb.set(blu[i][0], blu[i][1], bool);
      if (i < 8) {
        paramb.set(paramb.width - i - 1, 8, bool);
      }
      for (;;)
      {
        i += 1;
        break;
        paramb.set(8, paramb.height - 7 + (i - 8), bool);
      }
    }
    a(paramc, paramb);
    a(parama, paramInt, paramb);
    AppMethodBeat.o(57182);
  }
  
  private static void a(c paramc, b paramb)
  {
    AppMethodBeat.i(57183);
    if (paramc.blf < 7)
    {
      AppMethodBeat.o(57183);
      return;
    }
    com.google.b.b.a locala = new com.google.b.b.a();
    locala.bt(paramc.blf, 6);
    locala.bt(bB(paramc.blf, 7973), 12);
    if (locala.size != 18)
    {
      paramc = new h("should not happen but we got: " + locala.size);
      AppMethodBeat.o(57183);
      throw paramc;
    }
    int j = 17;
    int i = 0;
    while (i < 6)
    {
      int k = 0;
      while (k < 3)
      {
        boolean bool = locala.get(j);
        j -= 1;
        paramb.set(i, paramb.height - 11 + k, bool);
        paramb.set(paramb.height - 11 + k, i, bool);
        k += 1;
      }
      i += 1;
    }
    AppMethodBeat.o(57183);
  }
  
  private static void b(int paramInt1, int paramInt2, b paramb)
  {
    AppMethodBeat.i(57187);
    int i = 0;
    while (i < 7)
    {
      if (!fk(paramb.bA(paramInt1, paramInt2 + i)))
      {
        paramb = new h();
        AppMethodBeat.o(57187);
        throw paramb;
      }
      paramb.set(paramInt1, paramInt2 + i, 0);
      i += 1;
    }
    AppMethodBeat.o(57187);
  }
  
  private static int bB(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(57185);
    if (paramInt2 == 0)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("0 polynomial");
      AppMethodBeat.o(57185);
      throw localIllegalArgumentException;
    }
    int i = 32 - Integer.numberOfLeadingZeros(paramInt2);
    paramInt1 <<= i - 1;
    while (32 - Integer.numberOfLeadingZeros(paramInt1) >= i) {
      paramInt1 ^= paramInt2 << 32 - Integer.numberOfLeadingZeros(paramInt1) - i;
    }
    AppMethodBeat.o(57185);
    return paramInt1;
  }
  
  private static void c(int paramInt1, int paramInt2, b paramb)
  {
    AppMethodBeat.i(57188);
    int i = 0;
    while (i < 7)
    {
      int j = 0;
      while (j < 7)
      {
        paramb.set(paramInt1 + j, paramInt2 + i, blr[i][j]);
        j += 1;
      }
      i += 1;
    }
    AppMethodBeat.o(57188);
  }
  
  private static boolean fk(int paramInt)
  {
    return paramInt == -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.b.f.b.e
 * JD-Core Version:    0.7.0.1
 */