package com.google.c.d;

import com.google.c.a;
import com.google.c.b.b;
import com.google.c.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class k
  extends r
{
  public final b a(String paramString, a parama, int paramInt1, int paramInt2, Map<c, ?> paramMap)
  {
    AppMethodBeat.i(12292);
    if (parama != a.cde)
    {
      paramString = new IllegalArgumentException("Can only encode EAN_8, but got ".concat(String.valueOf(parama)));
      AppMethodBeat.o(12292);
      throw paramString;
    }
    paramString = super.a(paramString, parama, paramInt1, paramInt2, paramMap);
    AppMethodBeat.o(12292);
    return paramString;
  }
  
  public final boolean[] cN(String paramString)
  {
    AppMethodBeat.i(12293);
    if (paramString.length() != 8)
    {
      paramString = new IllegalArgumentException("Requested contents should be 8 digits long, but got " + paramString.length());
      AppMethodBeat.o(12293);
      throw paramString;
    }
    boolean[] arrayOfBoolean = new boolean[67];
    int j = a(arrayOfBoolean, 0, q.cfZ, true) + 0;
    int i = 0;
    int k;
    while (i <= 3)
    {
      k = Integer.parseInt(paramString.substring(i, i + 1));
      j += a(arrayOfBoolean, j, q.cgb[k], false);
      i += 1;
    }
    j += a(arrayOfBoolean, j, q.cga, false);
    i = 4;
    while (i <= 7)
    {
      k = Integer.parseInt(paramString.substring(i, i + 1));
      j += a(arrayOfBoolean, j, q.cgb[k], true);
      i += 1;
    }
    a(arrayOfBoolean, j, q.cfZ, true);
    AppMethodBeat.o(12293);
    return arrayOfBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.c.d.k
 * JD-Core Version:    0.7.0.1
 */