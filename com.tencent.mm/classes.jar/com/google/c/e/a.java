package com.google.c.e;

import com.google.c.b.b;
import com.google.c.e.a.d;
import com.google.c.e.a.e;
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
          localb.set(k + paramInt, i);
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
    if (parama != com.google.c.a.bRg)
    {
      paramString = new IllegalArgumentException("Can only encode PDF_417, but got ".concat(String.valueOf(parama)));
      AppMethodBeat.o(12300);
      throw paramString;
    }
    parama = new e();
    int j = 2;
    int i;
    int k;
    if (paramMap != null)
    {
      if (paramMap.containsKey(com.google.c.c.bRu)) {
        parama.bRF = Boolean.valueOf(paramMap.get(com.google.c.c.bRu).toString()).booleanValue();
      }
      if (paramMap.containsKey(com.google.c.c.bRv)) {
        parama.bUr = com.google.c.e.a.c.valueOf(paramMap.get(com.google.c.c.bRv).toString());
      }
      if (paramMap.containsKey(com.google.c.c.bRw))
      {
        d locald = (d)paramMap.get(com.google.c.c.bRw);
        i = locald.bUn;
        j = locald.bUm;
        k = locald.maxRows;
        int m = locald.bUo;
        parama.bUn = i;
        parama.bUm = j;
        parama.maxRows = k;
        parama.bUo = m;
      }
      if (paramMap.containsKey(com.google.c.c.bRt))
      {
        i = Integer.parseInt(paramMap.get(com.google.c.c.bRt).toString());
        if (paramMap.containsKey(com.google.c.c.bRo))
        {
          j = Integer.parseInt(paramMap.get(com.google.c.c.bRo).toString());
          label265:
          if (paramMap.containsKey(com.google.c.c.bRp)) {
            parama.bUs = Charset.forName(paramMap.get(com.google.c.c.bRp).toString());
          }
        }
      }
    }
    for (;;)
    {
      parama.m(paramString, j);
      paramString = parama.bUq.bN(1, 4);
      if (paramInt2 > paramInt1)
      {
        j = 1;
        if (paramString[0].length >= paramString.length) {
          break label423;
        }
        k = 1;
        label336:
        if ((j ^ k) == 0) {
          break label450;
        }
        paramString = b(paramString);
      }
      label423:
      label444:
      label450:
      for (j = 1;; j = 0)
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
            paramString = parama.bUq.bN(paramInt1, paramInt1 << 2);
            if (j == 0) {
              break label444;
            }
            paramString = b(paramString);
          }
          for (;;)
          {
            paramString = a(paramString, i);
            AppMethodBeat.o(12300);
            return paramString;
            j = 0;
            break;
            k = 0;
            break label336;
            paramString = a(paramString, i);
            AppMethodBeat.o(12300);
            return paramString;
          }
        }
      }
      j = 2;
      break label265;
      i = 30;
      break;
      i = 30;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.c.e.a
 * JD-Core Version:    0.7.0.1
 */