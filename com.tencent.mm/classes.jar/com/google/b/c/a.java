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
    AppMethodBeat.i(12340);
    int i1 = paramk.It();
    int i2 = paramk.Iu();
    com.google.b.f.b.b localb = new com.google.b.f.b.b(paramk.Iv(), paramk.Iw());
    int j = 0;
    int i = 0;
    int m;
    boolean bool;
    if (j < i2)
    {
      if (j % paramk.cdS != 0) {
        break label414;
      }
      k = 0;
      m = 0;
      if (k < paramk.Iv())
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
    label411:
    label414:
    for (int k = i + 1;; k = i)
    {
      m = 0;
      i = 0;
      label120:
      if (m < i1)
      {
        int n = i;
        if (m % paramk.cdR == 0)
        {
          localb.set(i, k, true);
          n = i + 1;
        }
        if (parame.cdA[(parame.cdz * j + m)] == 1)
        {
          bool = true;
          localb.set(n, k, bool);
          i = n + 1;
          if (m % paramk.cdR != paramk.cdR - 1) {
            break label411;
          }
          if (j % 2 != 0) {
            break label245;
          }
          bool = true;
          localb.set(i, k, bool);
          i += 1;
        }
      }
      for (;;)
      {
        label175:
        label216:
        m += 1;
        break label120;
        bool = false;
        break label175;
        label245:
        bool = false;
        break label216;
        m = k + 1;
        if (j % paramk.cdS == paramk.cdS - 1)
        {
          i = 0;
          k = 0;
          while (i < paramk.Iv())
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
              if (localb.bO(i, j) == 1) {
                parame.set(i, j);
              }
              j += 1;
            }
            i += 1;
          }
          AppMethodBeat.o(12340);
          return parame;
        }
      }
    }
  }
  
  public final com.google.b.b.b a(String paramString, com.google.b.a parama, int paramInt1, int paramInt2, Map<c, ?> paramMap)
  {
    AppMethodBeat.i(12339);
    if (paramString.isEmpty())
    {
      paramString = new IllegalArgumentException("Found empty contents");
      AppMethodBeat.o(12339);
      throw paramString;
    }
    if (parama != com.google.b.a.cbA)
    {
      paramString = new IllegalArgumentException("Can only encode DATA_MATRIX, but got ".concat(String.valueOf(parama)));
      AppMethodBeat.o(12339);
      throw paramString;
    }
    if ((paramInt1 < 0) || (paramInt2 < 0))
    {
      paramString = new IllegalArgumentException("Requested dimensions are too small: " + paramInt1 + 'x' + paramInt2);
      AppMethodBeat.o(12339);
      throw paramString;
    }
    parama = l.cdW;
    Object localObject;
    if (paramMap != null)
    {
      localObject = (l)paramMap.get(c.cbP);
      if (localObject != null) {
        parama = (com.google.b.a)localObject;
      }
      localObject = (com.google.b.b)paramMap.get(c.cbQ);
      if (localObject != null)
      {
        paramMap = (com.google.b.b)paramMap.get(c.cbR);
        if (paramMap == null) {}
      }
    }
    for (;;)
    {
      paramString = j.a(paramString, parama, (com.google.b.b)localObject, paramMap);
      parama = k.a(paramString.length(), parama, (com.google.b.b)localObject, paramMap);
      paramString = new e(i.a(paramString, parama), parama.It(), parama.Iu());
      paramString.Il();
      paramString = a(paramString, parama);
      AppMethodBeat.o(12339);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.b.c.a
 * JD-Core Version:    0.7.0.1
 */