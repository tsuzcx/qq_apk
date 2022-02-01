package com.google.c.f;

import com.google.c.f.b.f;
import com.google.c.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class a
  implements g
{
  private static com.google.c.b.b a(f paramf, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(12324);
    paramf = paramf.bLb;
    if (paramf == null)
    {
      paramf = new IllegalStateException();
      AppMethodBeat.o(12324);
      throw paramf;
    }
    int k = paramf.width;
    int m = paramf.height;
    int i = (paramInt3 << 1) + k;
    int j = (paramInt3 << 1) + m;
    paramInt1 = Math.max(paramInt1, i);
    paramInt3 = Math.max(paramInt2, j);
    int n = Math.min(paramInt1 / i, paramInt3 / j);
    j = (paramInt1 - k * n) / 2;
    paramInt2 = (paramInt3 - m * n) / 2;
    com.google.c.b.b localb = new com.google.c.b.b(paramInt1, paramInt3);
    paramInt1 = 0;
    while (paramInt1 < m)
    {
      i = 0;
      paramInt3 = j;
      while (i < k)
      {
        if (paramf.bM(i, paramInt1) == 1) {
          localb.p(paramInt3, paramInt2, n, n);
        }
        i += 1;
        paramInt3 += n;
      }
      paramInt2 += n;
      paramInt1 += 1;
    }
    AppMethodBeat.o(12324);
    return localb;
  }
  
  public final com.google.c.b.b a(String paramString, com.google.c.a parama, int paramInt1, int paramInt2, Map<com.google.c.c, ?> paramMap)
  {
    AppMethodBeat.i(12323);
    if (paramString.isEmpty())
    {
      paramString = new IllegalArgumentException("Found empty contents");
      AppMethodBeat.o(12323);
      throw paramString;
    }
    if (parama != com.google.c.a.bGT)
    {
      paramString = new IllegalArgumentException("Can only encode QR_CODE, but got ".concat(String.valueOf(parama)));
      AppMethodBeat.o(12323);
      throw paramString;
    }
    if ((paramInt1 < 0) || (paramInt2 < 0))
    {
      paramString = new IllegalArgumentException("Requested dimensions are too small: " + paramInt1 + 'x' + paramInt2);
      AppMethodBeat.o(12323);
      throw paramString;
    }
    parama = com.google.c.f.a.a.bKm;
    int j = 4;
    com.google.c.a locala = parama;
    int i = j;
    if (paramMap != null)
    {
      if (paramMap.containsKey(com.google.c.c.bHa)) {
        parama = com.google.c.f.a.a.valueOf(paramMap.get(com.google.c.c.bHa).toString());
      }
      locala = parama;
      i = j;
      if (paramMap.containsKey(com.google.c.c.bHf))
      {
        i = Integer.parseInt(paramMap.get(com.google.c.c.bHf).toString());
        locala = parama;
      }
    }
    paramString = a(com.google.c.f.b.c.a(paramString, locala, paramMap), paramInt1, paramInt2, i);
    AppMethodBeat.o(12323);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.c.f.a
 * JD-Core Version:    0.7.0.1
 */