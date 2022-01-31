package com.google.b.d;

import com.google.b.a;
import com.google.b.b.b;
import com.google.b.c;
import com.google.b.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class j
  extends r
{
  public final b a(String paramString, a parama, int paramInt1, int paramInt2, Map<c, ?> paramMap)
  {
    AppMethodBeat.i(57326);
    if (parama != a.bhn)
    {
      paramString = new IllegalArgumentException("Can only encode EAN_13, but got ".concat(String.valueOf(parama)));
      AppMethodBeat.o(57326);
      throw paramString;
    }
    paramString = super.a(paramString, parama, paramInt1, paramInt2, paramMap);
    AppMethodBeat.o(57326);
    return paramString;
  }
  
  public final boolean[] bj(String paramString)
  {
    AppMethodBeat.i(57327);
    if (paramString.length() != 13)
    {
      paramString = new IllegalArgumentException("Requested contents should be 13 digits long, but got " + paramString.length());
      AppMethodBeat.o(57327);
      throw paramString;
    }
    try
    {
      if (!q.q(paramString))
      {
        paramString = new IllegalArgumentException("Contents do not pass checksum");
        AppMethodBeat.o(57327);
        throw paramString;
      }
    }
    catch (d paramString)
    {
      paramString = new IllegalArgumentException("Illegal contents");
      AppMethodBeat.o(57327);
      throw paramString;
    }
    int i = Integer.parseInt(paramString.substring(0, 1));
    int n = i.bka[i];
    boolean[] arrayOfBoolean = new boolean[95];
    int j = a(arrayOfBoolean, 0, q.bkh, true);
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
      j += a(arrayOfBoolean, j, q.bkk[k], false);
      i += 1;
    }
    j += a(arrayOfBoolean, j, q.bki, false);
    i = 7;
    while (i <= 12)
    {
      k = Integer.parseInt(paramString.substring(i, i + 1));
      j += a(arrayOfBoolean, j, q.bkj[k], true);
      i += 1;
    }
    a(arrayOfBoolean, j, q.bkh, true);
    AppMethodBeat.o(57327);
    return arrayOfBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.b.d.j
 * JD-Core Version:    0.7.0.1
 */