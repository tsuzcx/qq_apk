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
    AppMethodBeat.i(12220);
    if (parama != a.cbK)
    {
      paramString = new IllegalArgumentException("Can only encode UPC_E, but got ".concat(String.valueOf(parama)));
      AppMethodBeat.o(12220);
      throw paramString;
    }
    paramString = super.a(paramString, parama, paramInt1, paramInt2, paramMap);
    AppMethodBeat.o(12220);
    return paramString;
  }
  
  public final boolean[] ct(String paramString)
  {
    AppMethodBeat.i(12221);
    if (paramString.length() != 8)
    {
      paramString = new IllegalArgumentException("Requested contents should be 8 digits long, but got " + paramString.length());
      AppMethodBeat.o(12221);
      throw paramString;
    }
    int i = Integer.parseInt(paramString.substring(7, 8));
    int n = s.cez[i];
    boolean[] arrayOfBoolean = new boolean[51];
    int j = a(arrayOfBoolean, 0, q.cev, true);
    i = 1;
    j += 0;
    while (i <= 6)
    {
      int m = Integer.parseInt(paramString.substring(i, i + 1));
      int k = m;
      if ((n >> 6 - i & 0x1) == 1) {
        k = m + 10;
      }
      j += a(arrayOfBoolean, j, q.cey[k], false);
      i += 1;
    }
    a(arrayOfBoolean, j, q.cet, false);
    AppMethodBeat.o(12221);
    return arrayOfBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.b.d.t
 * JD-Core Version:    0.7.0.1
 */