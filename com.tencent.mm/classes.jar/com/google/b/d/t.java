package com.google.b.d;

import com.google.b.a;
import com.google.b.b.b;
import com.google.b.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class t
  extends r
{
  public final b a(String paramString, a parama, int paramInt1, int paramInt2, Map<c, ?> paramMap)
  {
    AppMethodBeat.i(57155);
    if (parama != a.bhv)
    {
      paramString = new IllegalArgumentException("Can only encode UPC_E, but got ".concat(String.valueOf(parama)));
      AppMethodBeat.o(57155);
      throw paramString;
    }
    paramString = super.a(paramString, parama, paramInt1, paramInt2, paramMap);
    AppMethodBeat.o(57155);
    return paramString;
  }
  
  public final boolean[] bj(String paramString)
  {
    AppMethodBeat.i(57156);
    if (paramString.length() != 8)
    {
      paramString = new IllegalArgumentException("Requested contents should be 8 digits long, but got " + paramString.length());
      AppMethodBeat.o(57156);
      throw paramString;
    }
    int i = Integer.parseInt(paramString.substring(7, 8));
    int n = s.bkl[i];
    boolean[] arrayOfBoolean = new boolean[51];
    int j = a(arrayOfBoolean, 0, q.bkh, true);
    i = 1;
    j += 0;
    while (i <= 6)
    {
      int m = Integer.parseInt(paramString.substring(i, i + 1));
      int k = m;
      if ((n >> 6 - i & 0x1) == 1) {
        k = m + 10;
      }
      j += a(arrayOfBoolean, j, q.bkk[k], false);
      i += 1;
    }
    a(arrayOfBoolean, j, q.bkf, false);
    AppMethodBeat.o(57156);
    return arrayOfBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.b.d.t
 * JD-Core Version:    0.7.0.1
 */