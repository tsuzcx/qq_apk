package com.google.b.d;

import com.google.b.a;
import com.google.b.b.b;
import com.google.b.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class f
  extends o
{
  private static void a(int paramInt, int[] paramArrayOfInt)
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
    AppMethodBeat.i(12290);
    if (parama != a.cbx)
    {
      paramString = new IllegalArgumentException("Can only encode CODE_39, but got ".concat(String.valueOf(parama)));
      AppMethodBeat.o(12290);
      throw paramString;
    }
    paramString = super.a(paramString, parama, paramInt1, paramInt2, paramMap);
    AppMethodBeat.o(12290);
    return paramString;
  }
  
  public final boolean[] ct(String paramString)
  {
    AppMethodBeat.i(12291);
    int m = paramString.length();
    if (m > 80)
    {
      paramString = new IllegalArgumentException("Requested contents should be less than 80 digits long, but got ".concat(String.valueOf(m)));
      AppMethodBeat.o(12291);
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
        AppMethodBeat.o(12291);
        throw paramString;
      }
      a(e.ceb[k], arrayOfInt1);
      k = 0;
      while (k < 9)
      {
        j += arrayOfInt1[k];
        k += 1;
      }
      i += 1;
    }
    boolean[] arrayOfBoolean = new boolean[j];
    a(e.cen, arrayOfInt1);
    i = a(arrayOfBoolean, 0, arrayOfInt1, true);
    int[] arrayOfInt2 = new int[1];
    arrayOfInt2[0] = 1;
    j = i + a(arrayOfBoolean, i, arrayOfInt2, false);
    i = 0;
    while (i < m)
    {
      k = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%".indexOf(paramString.charAt(i));
      a(e.ceb[k], arrayOfInt1);
      j += a(arrayOfBoolean, j, arrayOfInt1, true);
      j += a(arrayOfBoolean, j, arrayOfInt2, false);
      i += 1;
    }
    a(e.cen, arrayOfInt1);
    a(arrayOfBoolean, j, arrayOfInt1, true);
    AppMethodBeat.o(12291);
    return arrayOfBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.b.d.f
 * JD-Core Version:    0.7.0.1
 */