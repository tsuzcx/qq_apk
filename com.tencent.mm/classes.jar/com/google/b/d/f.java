package com.google.b.d;

import com.google.b.a;
import com.google.b.b.b;
import com.google.b.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class f
  extends o
{
  private static void b(int paramInt, int[] paramArrayOfInt)
  {
    int i = 0;
    if (i < 9)
    {
      if ((1 << 8 - i & paramInt) == 0) {}
      for (int j = 1;; j = 2)
      {
        paramArrayOfInt[i] = j;
        i += 1;
        break;
      }
    }
  }
  
  public final b a(String paramString, a parama, int paramInt1, int paramInt2, Map<c, ?> paramMap)
  {
    AppMethodBeat.i(57225);
    if (parama != a.bhi)
    {
      paramString = new IllegalArgumentException("Can only encode CODE_39, but got ".concat(String.valueOf(parama)));
      AppMethodBeat.o(57225);
      throw paramString;
    }
    paramString = super.a(paramString, parama, paramInt1, paramInt2, paramMap);
    AppMethodBeat.o(57225);
    return paramString;
  }
  
  public final boolean[] bj(String paramString)
  {
    AppMethodBeat.i(57226);
    int m = paramString.length();
    if (m > 80)
    {
      paramString = new IllegalArgumentException("Requested contents should be less than 80 digits long, but got ".concat(String.valueOf(m)));
      AppMethodBeat.o(57226);
      throw paramString;
    }
    int[] arrayOfInt1 = new int[9];
    int j = m + 25;
    int i = 0;
    int k;
    while (i < m)
    {
      k = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%".indexOf(paramString.charAt(i));
      if (k < 0)
      {
        paramString = new IllegalArgumentException("Bad contents: ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(57226);
        throw paramString;
      }
      b(e.bjN[k], arrayOfInt1);
      k = 0;
      while (k < 9)
      {
        j += arrayOfInt1[k];
        k += 1;
      }
      i += 1;
    }
    boolean[] arrayOfBoolean = new boolean[j];
    b(e.bjZ, arrayOfInt1);
    i = a(arrayOfBoolean, 0, arrayOfInt1, true);
    int[] arrayOfInt2 = new int[1];
    arrayOfInt2[0] = 1;
    j = i + a(arrayOfBoolean, i, arrayOfInt2, false);
    i = 0;
    while (i < m)
    {
      k = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%".indexOf(paramString.charAt(i));
      b(e.bjN[k], arrayOfInt1);
      j += a(arrayOfBoolean, j, arrayOfInt1, true);
      j += a(arrayOfBoolean, j, arrayOfInt2, false);
      i += 1;
    }
    b(e.bjZ, arrayOfInt1);
    a(arrayOfBoolean, j, arrayOfInt1, true);
    AppMethodBeat.o(57226);
    return arrayOfBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.b.d.f
 * JD-Core Version:    0.7.0.1
 */