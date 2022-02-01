package com.google.b.a;

import com.google.b.b.b;
import com.google.b.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.charset.Charset;
import java.util.Map;

public final class a
  implements g
{
  private static final Charset ccd;
  
  static
  {
    AppMethodBeat.i(12256);
    ccd = Charset.forName("ISO-8859-1");
    AppMethodBeat.o(12256);
  }
  
  private static b a(com.google.b.a.a.a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(12255);
    parama = parama.cch;
    if (parama == null)
    {
      parama = new IllegalStateException();
      AppMethodBeat.o(12255);
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
        if (parama.bI(j, paramInt1)) {
          localb.p(i, paramInt2, i1, i1);
        }
        j += 1;
        i += i1;
      }
      paramInt2 += i1;
      paramInt1 += 1;
    }
    AppMethodBeat.o(12255);
    return localb;
  }
  
  public final b a(String paramString, com.google.b.a parama, int paramInt1, int paramInt2, Map<com.google.b.c, ?> paramMap)
  {
    AppMethodBeat.i(12254);
    Charset localCharset1 = ccd;
    int i = 33;
    int m = 0;
    Charset localCharset2 = localCharset1;
    int j = i;
    int k = m;
    if (paramMap != null)
    {
      if (paramMap.containsKey(com.google.b.c.cbO)) {
        localCharset1 = Charset.forName(paramMap.get(com.google.b.c.cbO).toString());
      }
      if (paramMap.containsKey(com.google.b.c.cbN)) {
        i = Integer.parseInt(paramMap.get(com.google.b.c.cbN).toString());
      }
      localCharset2 = localCharset1;
      j = i;
      k = m;
      if (paramMap.containsKey(com.google.b.c.cbW))
      {
        k = Integer.parseInt(paramMap.get(com.google.b.c.cbW).toString());
        j = i;
        localCharset2 = localCharset1;
      }
    }
    if (parama != com.google.b.a.cbv)
    {
      paramString = new IllegalArgumentException("Can only encode AZTEC, but got ".concat(String.valueOf(parama)));
      AppMethodBeat.o(12254);
      throw paramString;
    }
    paramString = a(com.google.b.a.a.c.w(paramString.getBytes(localCharset2), j, k), paramInt1, paramInt2);
    AppMethodBeat.o(12254);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.b.a.a
 * JD-Core Version:    0.7.0.1
 */