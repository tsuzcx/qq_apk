package com.google.c.c;

import com.google.c.c;
import com.google.c.c.a.e;
import com.google.c.c.a.i;
import com.google.c.c.a.j;
import com.google.c.c.a.k;
import com.google.c.c.a.l;
import com.google.c.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class a
  implements g
{
  private static com.google.c.b.b a(e parame, k paramk)
  {
    AppMethodBeat.i(12340);
    int i1 = paramk.JT();
    int i2 = paramk.JU();
    com.google.c.f.b.b localb = new com.google.c.f.b.b(paramk.JV(), paramk.JW());
    int j = 0;
    int i = 0;
    int m;
    boolean bool;
    if (j < i2)
    {
      if (j % paramk.cfw != 0) {
        break label414;
      }
      k = 0;
      m = 0;
      if (k < paramk.JV())
      {
        if (k % 2 == 0) {}
        for (bool = true;; bool = false)
        {
          localb.i(m, i, bool);
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
        if (m % paramk.cfv == 0)
        {
          localb.i(i, k, true);
          n = i + 1;
        }
        if (parame.cfd[(parame.cfc * j + m)] == 1)
        {
          bool = true;
          localb.i(n, k, bool);
          i = n + 1;
          if (m % paramk.cfv != paramk.cfv - 1) {
            break label411;
          }
          if (j % 2 != 0) {
            break label245;
          }
          bool = true;
          localb.i(i, k, bool);
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
        if (j % paramk.cfw == paramk.cfw - 1)
        {
          i = 0;
          k = 0;
          while (i < paramk.JV())
          {
            localb.i(k, m, true);
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
          parame = new com.google.c.b.b(k, m);
          parame.clear();
          i = 0;
          while (i < k)
          {
            j = 0;
            while (j < m)
            {
              if (localb.cg(i, j) == 1) {
                parame.ca(i, j);
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
  
  public final com.google.c.b.b a(String paramString, com.google.c.a parama, int paramInt1, int paramInt2, Map<c, ?> paramMap)
  {
    AppMethodBeat.i(12339);
    if (paramString.isEmpty())
    {
      paramString = new IllegalArgumentException("Found empty contents");
      AppMethodBeat.o(12339);
      throw paramString;
    }
    if (parama != com.google.c.a.cdd)
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
    parama = l.cfA;
    Object localObject;
    if (paramMap != null)
    {
      localObject = (l)paramMap.get(c.cds);
      if (localObject != null) {
        parama = (com.google.c.a)localObject;
      }
      localObject = (com.google.c.b)paramMap.get(c.cdt);
      if (localObject != null)
      {
        paramMap = (com.google.c.b)paramMap.get(c.cdu);
        if (paramMap == null) {}
      }
    }
    for (;;)
    {
      paramString = j.a(paramString, parama, (com.google.c.b)localObject, paramMap);
      parama = k.a(paramString.length(), parama, (com.google.c.b)localObject, paramMap);
      paramString = new e(i.a(paramString, parama), parama.JT(), parama.JU());
      paramString.JL();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.c.c.a
 * JD-Core Version:    0.7.0.1
 */