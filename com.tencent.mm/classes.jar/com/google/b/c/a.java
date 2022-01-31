package com.google.b.c;

import com.google.b.c;
import com.google.b.c.a.e;
import com.google.b.c.a.i;
import com.google.b.c.a.j;
import com.google.b.c.a.k;
import com.google.b.c.a.l;
import com.google.b.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class a
  implements g
{
  private static com.google.b.b.b a(e parame, k paramk)
  {
    AppMethodBeat.i(57275);
    int i1 = paramk.sM();
    int i2 = paramk.sN();
    com.google.b.f.b.b localb = new com.google.b.f.b.b(paramk.sO(), paramk.sP());
    int j = 0;
    int i = 0;
    int m;
    boolean bool;
    if (j < i2)
    {
      if (j % paramk.bjE != 0) {
        break label412;
      }
      k = 0;
      m = 0;
      if (k < paramk.sO())
      {
        if (k % 2 == 0) {}
        for (bool = true;; bool = false)
        {
          localb.set(m, i, bool);
          m += 1;
          k += 1;
          break;
        }
      }
    }
    label409:
    label412:
    for (int k = i + 1;; k = i)
    {
      m = 0;
      i = 0;
      label119:
      if (m < i1)
      {
        int n = i;
        if (m % paramk.bjD == 0)
        {
          localb.set(i, k, true);
          n = i + 1;
        }
        if (parame.bjl[(parame.bjk * j + m)] == 1)
        {
          bool = true;
          localb.set(n, k, bool);
          i = n + 1;
          if (m % paramk.bjD != paramk.bjD - 1) {
            break label409;
          }
          if (j % 2 != 0) {
            break label244;
          }
          bool = true;
          localb.set(i, k, bool);
          i += 1;
        }
      }
      for (;;)
      {
        label174:
        label215:
        m += 1;
        break label119;
        bool = false;
        break label174;
        label244:
        bool = false;
        break label215;
        m = k + 1;
        if (j % paramk.bjE == paramk.bjE - 1)
        {
          i = 0;
          k = 0;
          while (i < paramk.sO())
          {
            localb.set(k, m, true);
            k += 1;
            i += 1;
          }
        }
        for (i = m + 1;; i = m)
        {
          j += 1;
          break;
          k = localb.width;
          m = localb.height;
          parame = new com.google.b.b.b(k, m);
          parame.clear();
          i = 0;
          while (i < k)
          {
            j = 0;
            while (j < m)
            {
              if (localb.bA(i, j) == 1) {
                parame.set(i, j);
              }
              j += 1;
            }
            i += 1;
          }
          AppMethodBeat.o(57275);
          return parame;
        }
      }
    }
  }
  
  public final com.google.b.b.b a(String paramString, com.google.b.a parama, int paramInt1, int paramInt2, Map<c, ?> paramMap)
  {
    AppMethodBeat.i(57274);
    if (paramString.isEmpty())
    {
      paramString = new IllegalArgumentException("Found empty contents");
      AppMethodBeat.o(57274);
      throw paramString;
    }
    if (parama != com.google.b.a.bhl)
    {
      paramString = new IllegalArgumentException("Can only encode DATA_MATRIX, but got ".concat(String.valueOf(parama)));
      AppMethodBeat.o(57274);
      throw paramString;
    }
    if ((paramInt1 < 0) || (paramInt2 < 0))
    {
      paramString = new IllegalArgumentException("Requested dimensions are too small: " + paramInt1 + 'x' + paramInt2);
      AppMethodBeat.o(57274);
      throw paramString;
    }
    parama = l.bjI;
    Object localObject;
    if (paramMap != null)
    {
      localObject = (l)paramMap.get(c.bhA);
      if (localObject != null) {
        parama = (com.google.b.a)localObject;
      }
      localObject = (com.google.b.b)paramMap.get(c.bhB);
      if (localObject != null)
      {
        paramMap = (com.google.b.b)paramMap.get(c.bhC);
        if (paramMap == null) {}
      }
    }
    for (;;)
    {
      paramString = j.a(paramString, parama, (com.google.b.b)localObject, paramMap);
      parama = k.a(paramString.length(), parama, (com.google.b.b)localObject, paramMap);
      paramString = new e(i.a(paramString, parama), parama.sM(), parama.sN());
      paramString.sE();
      paramString = a(paramString, parama);
      AppMethodBeat.o(57274);
      return paramString;
      paramMap = null;
      continue;
      localObject = null;
      break;
      paramMap = null;
      localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.b.c.a
 * JD-Core Version:    0.7.0.1
 */