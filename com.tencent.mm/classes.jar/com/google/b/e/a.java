package com.google.b.e;

import com.google.b.b.b;
import com.google.b.e.a.d;
import com.google.b.e.a.e;
import com.google.b.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Map;

public final class a
  implements g
{
  private static b a(byte[][] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(57236);
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
    AppMethodBeat.o(57236);
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
  
  public final b a(String paramString, com.google.b.a parama, int paramInt1, int paramInt2, Map<com.google.b.c, ?> paramMap)
  {
    AppMethodBeat.i(57235);
    if (parama != com.google.b.a.bhq)
    {
      paramString = new IllegalArgumentException("Can only encode PDF_417, but got ".concat(String.valueOf(parama)));
      AppMethodBeat.o(57235);
      throw paramString;
    }
    parama = new e();
    int j = 2;
    int i;
    int k;
    if (paramMap != null)
    {
      if (paramMap.containsKey(com.google.b.c.bhE)) {
        parama.bhP = Boolean.valueOf(paramMap.get(com.google.b.c.bhE).toString()).booleanValue();
      }
      if (paramMap.containsKey(com.google.b.c.bhF)) {
        parama.bkC = com.google.b.e.a.c.valueOf(paramMap.get(com.google.b.c.bhF).toString());
      }
      if (paramMap.containsKey(com.google.b.c.bhG))
      {
        d locald = (d)paramMap.get(com.google.b.c.bhG);
        i = locald.bky;
        j = locald.bkx;
        k = locald.maxRows;
        int m = locald.bkz;
        parama.bky = i;
        parama.bkx = j;
        parama.maxRows = k;
        parama.bkz = m;
      }
      if (paramMap.containsKey(com.google.b.c.bhD))
      {
        i = Integer.parseInt(paramMap.get(com.google.b.c.bhD).toString());
        if (paramMap.containsKey(com.google.b.c.bhy))
        {
          j = Integer.parseInt(paramMap.get(com.google.b.c.bhy).toString());
          label263:
          if (paramMap.containsKey(com.google.b.c.bhz)) {
            parama.bkD = Charset.forName(paramMap.get(com.google.b.c.bhz).toString());
          }
        }
      }
    }
    for (;;)
    {
      parama.l(paramString, j);
      paramString = parama.bkB.bz(1, 4);
      if (paramInt2 > paramInt1)
      {
        j = 1;
        if (paramString[0].length >= paramString.length) {
          break label420;
        }
        k = 1;
        label334:
        if ((j ^ k) == 0) {
          break label446;
        }
        paramString = b(paramString);
      }
      label420:
      label440:
      label446:
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
            paramString = parama.bkB.bz(paramInt1, paramInt1 << 2);
            if (j == 0) {
              break label440;
            }
            paramString = b(paramString);
          }
          for (;;)
          {
            paramString = a(paramString, i);
            AppMethodBeat.o(57235);
            return paramString;
            j = 0;
            break;
            k = 0;
            break label334;
            paramString = a(paramString, i);
            AppMethodBeat.o(57235);
            return paramString;
          }
        }
      }
      j = 2;
      break label263;
      i = 30;
      break;
      i = 30;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.b.e.a
 * JD-Core Version:    0.7.0.1
 */