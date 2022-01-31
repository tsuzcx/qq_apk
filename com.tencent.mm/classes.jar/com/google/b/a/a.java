package com.google.b.a;

import com.google.b.b.b;
import com.google.b.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.charset.Charset;
import java.util.Map;

public final class a
  implements g
{
  private static final Charset bhO;
  
  static
  {
    AppMethodBeat.i(57191);
    bhO = Charset.forName("ISO-8859-1");
    AppMethodBeat.o(57191);
  }
  
  private static b a(com.google.b.a.a.a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(57190);
    parama = parama.bhS;
    if (parama == null)
    {
      parama = new IllegalStateException();
      AppMethodBeat.o(57190);
      throw parama;
    }
    int m = parama.width;
    int n = parama.height;
    paramInt1 = Math.max(paramInt1, m);
    int i = Math.max(paramInt2, n);
    int i1 = Math.min(paramInt1 / m, i / n);
    int k = (paramInt1 - m * i1) / 2;
    paramInt2 = (i - n * i1) / 2;
    b localb = new b(paramInt1, i);
    paramInt1 = 0;
    while (paramInt1 < n)
    {
      i = k;
      int j = 0;
      while (j < m)
      {
        if (parama.bu(j, paramInt1)) {
          localb.o(i, paramInt2, i1, i1);
        }
        j += 1;
        i += i1;
      }
      paramInt2 += i1;
      paramInt1 += 1;
    }
    AppMethodBeat.o(57190);
    return localb;
  }
  
  public final b a(String paramString, com.google.b.a parama, int paramInt1, int paramInt2, Map<com.google.b.c, ?> paramMap)
  {
    AppMethodBeat.i(57189);
    Charset localCharset1 = bhO;
    int i = 33;
    int m = 0;
    Charset localCharset2 = localCharset1;
    int j = i;
    int k = m;
    if (paramMap != null)
    {
      if (paramMap.containsKey(com.google.b.c.bhz)) {
        localCharset1 = Charset.forName(paramMap.get(com.google.b.c.bhz).toString());
      }
      if (paramMap.containsKey(com.google.b.c.bhy)) {
        i = Integer.parseInt(paramMap.get(com.google.b.c.bhy).toString());
      }
      localCharset2 = localCharset1;
      j = i;
      k = m;
      if (paramMap.containsKey(com.google.b.c.bhH))
      {
        k = Integer.parseInt(paramMap.get(com.google.b.c.bhH).toString());
        j = i;
        localCharset2 = localCharset1;
      }
    }
    if (parama != com.google.b.a.bhg)
    {
      paramString = new IllegalArgumentException("Can only encode AZTEC, but got ".concat(String.valueOf(parama)));
      AppMethodBeat.o(57189);
      throw paramString;
    }
    paramString = a(com.google.b.a.a.c.n(paramString.getBytes(localCharset2), j, k), paramInt1, paramInt2);
    AppMethodBeat.o(57189);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.b.a.a
 * JD-Core Version:    0.7.0.1
 */