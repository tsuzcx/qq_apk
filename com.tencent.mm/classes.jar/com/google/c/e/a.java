package com.google.c.e;

import com.google.c.b.b;
import com.google.c.e.a.d;
import com.google.c.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Map;

public final class a
  implements g
{
  private static b a(byte[][] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(12301);
    b localb = new b(paramArrayOfByte[0].length + paramInt * 2, paramArrayOfByte.length + paramInt * 2);
    localb.clear();
    int i = localb.height - paramInt - 1;
    int j = 0;
    while (j < paramArrayOfByte.length)
    {
      int k = 0;
      while (k < paramArrayOfByte[0].length)
      {
        if (paramArrayOfByte[j][k] == 1) {
          localb.ca(k + paramInt, i);
        }
        k += 1;
      }
      j += 1;
      i -= 1;
    }
    AppMethodBeat.o(12301);
    return localb;
  }
  
  private static byte[][] b(byte[][] paramArrayOfByte)
  {
    int i = paramArrayOfByte[0].length;
    int j = paramArrayOfByte.length;
    byte[][] arrayOfByte = (byte[][])Array.newInstance(Byte.TYPE, new int[] { i, j });
    i = 0;
    while (i < paramArrayOfByte.length)
    {
      int k = paramArrayOfByte.length;
      j = 0;
      while (j < paramArrayOfByte[0].length)
      {
        arrayOfByte[j][(k - i - 1)] = paramArrayOfByte[i][j];
        j += 1;
      }
      i += 1;
    }
    return arrayOfByte;
  }
  
  public final b a(String paramString, com.google.c.a parama, int paramInt1, int paramInt2, Map<com.google.c.c, ?> paramMap)
  {
    AppMethodBeat.i(12300);
    if (parama != com.google.c.a.cdi)
    {
      paramString = new IllegalArgumentException("Can only encode PDF_417, but got ".concat(String.valueOf(parama)));
      AppMethodBeat.o(12300);
      throw paramString;
    }
    parama = new d();
    int i = 30;
    int j = 2;
    int k = i;
    int m = j;
    if (paramMap != null)
    {
      if (paramMap.containsKey(com.google.c.c.cdw)) {
        parama.cdH = Boolean.valueOf(paramMap.get(com.google.c.c.cdw).toString()).booleanValue();
      }
      if (paramMap.containsKey(com.google.c.c.cdx)) {
        parama.cgs = com.google.c.e.a.c.valueOf(paramMap.get(com.google.c.c.cdx).toString());
      }
      if (paramMap.containsKey(com.google.c.c.cdy))
      {
        paramMap.get(com.google.c.c.cdy);
        AppMethodBeat.o(12300);
        throw null;
      }
      if (paramMap.containsKey(com.google.c.c.cdv)) {
        i = Integer.parseInt(paramMap.get(com.google.c.c.cdv).toString());
      }
      if (paramMap.containsKey(com.google.c.c.cdq)) {
        j = Integer.parseInt(paramMap.get(com.google.c.c.cdq).toString());
      }
      k = i;
      m = j;
      if (paramMap.containsKey(com.google.c.c.cdr))
      {
        parama.cgt = Charset.forName(paramMap.get(com.google.c.c.cdr).toString());
        m = j;
        k = i;
      }
    }
    parama.s(paramString, m);
    paramString = parama.cgr.cf(1, 4);
    if (paramInt2 > paramInt1)
    {
      i = 1;
      if (paramString[0].length >= paramString.length) {
        break label403;
      }
      j = 1;
      label316:
      if ((i ^ j) == 0) {
        break label430;
      }
      paramString = b(paramString);
    }
    label403:
    label424:
    label430:
    for (i = 1;; i = 0)
    {
      paramInt1 /= paramString[0].length;
      paramInt2 /= paramString.length;
      if (paramInt1 >= paramInt2) {
        paramInt1 = paramInt2;
      }
      for (;;)
      {
        if (paramInt1 > 1)
        {
          paramString = parama.cgr.cf(paramInt1, paramInt1 << 2);
          if (i == 0) {
            break label424;
          }
          paramString = b(paramString);
        }
        for (;;)
        {
          paramString = a(paramString, k);
          AppMethodBeat.o(12300);
          return paramString;
          i = 0;
          break;
          j = 0;
          break label316;
          paramString = a(paramString, k);
          AppMethodBeat.o(12300);
          return paramString;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.c.e.a
 * JD-Core Version:    0.7.0.1
 */