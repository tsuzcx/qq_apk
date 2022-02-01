package com.google.c.d;

import com.google.c.a;
import com.google.c.b.b;
import com.google.c.c;
import com.google.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class j
  extends r
{
  public final b a(String paramString, a parama, int paramInt1, int paramInt2, Map<c, ?> paramMap)
  {
    AppMethodBeat.i(12391);
    if (parama != a.cdf)
    {
      paramString = new IllegalArgumentException("Can only encode EAN_13, but got ".concat(String.valueOf(parama)));
      AppMethodBeat.o(12391);
      throw paramString;
    }
    paramString = super.a(paramString, parama, paramInt1, paramInt2, paramMap);
    AppMethodBeat.o(12391);
    return paramString;
  }
  
  public final boolean[] cN(String paramString)
  {
    AppMethodBeat.i(12392);
    if (paramString.length() != 13)
    {
      paramString = new IllegalArgumentException("Requested contents should be 13 digits long, but got " + paramString.length());
      AppMethodBeat.o(12392);
      throw paramString;
    }
    try
    {
      if (!q.D(paramString))
      {
        paramString = new IllegalArgumentException("Contents do not pass checksum");
        AppMethodBeat.o(12392);
        throw paramString;
      }
    }
    catch (d paramString)
    {
      paramString = new IllegalArgumentException("Illegal contents");
      AppMethodBeat.o(12392);
      throw paramString;
    }
    int i = Integer.parseInt(paramString.substring(0, 1));
    int n = i.cfS[i];
    boolean[] arrayOfBoolean = new boolean[95];
    int j = a(arrayOfBoolean, 0, q.cfZ, true);
    i = 1;
    j += 0;
    int k;
    while (i <= 6)
    {
      int m = Integer.parseInt(paramString.substring(i, i + 1));
      k = m;
      if ((n >> 6 - i & 0x1) == 1) {
        k = m + 10;
      }
      j += a(arrayOfBoolean, j, q.cgc[k], false);
      i += 1;
    }
    j += a(arrayOfBoolean, j, q.cga, false);
    i = 7;
    while (i <= 12)
    {
      k = Integer.parseInt(paramString.substring(i, i + 1));
      j += a(arrayOfBoolean, j, q.cgb[k], true);
      i += 1;
    }
    a(arrayOfBoolean, j, q.cfZ, true);
    AppMethodBeat.o(12392);
    return arrayOfBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.c.d.j
 * JD-Core Version:    0.7.0.1
 */