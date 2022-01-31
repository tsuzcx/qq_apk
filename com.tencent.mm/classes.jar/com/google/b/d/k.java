package com.google.b.d;

import com.google.b.a;
import com.google.b.b.b;
import com.google.b.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class k
  extends r
{
  public final b a(String paramString, a parama, int paramInt1, int paramInt2, Map<c, ?> paramMap)
  {
    AppMethodBeat.i(57227);
    if (parama != a.bhm)
    {
      paramString = new IllegalArgumentException("Can only encode EAN_8, but got ".concat(String.valueOf(parama)));
      AppMethodBeat.o(57227);
      throw paramString;
    }
    paramString = super.a(paramString, parama, paramInt1, paramInt2, paramMap);
    AppMethodBeat.o(57227);
    return paramString;
  }
  
  public final boolean[] bj(String paramString)
  {
    AppMethodBeat.i(57228);
    if (paramString.length() != 8)
    {
      paramString = new IllegalArgumentException("Requested contents should be 8 digits long, but got " + paramString.length());
      AppMethodBeat.o(57228);
      throw paramString;
    }
    boolean[] arrayOfBoolean = new boolean[67];
    int j = a(arrayOfBoolean, 0, q.bkh, true) + 0;
    int i = 0;
    int k;
    while (i <= 3)
    {
      k = Integer.parseInt(paramString.substring(i, i + 1));
      j += a(arrayOfBoolean, j, q.bkj[k], false);
      i += 1;
    }
    j += a(arrayOfBoolean, j, q.bki, false);
    i = 4;
    while (i <= 7)
    {
      k = Integer.parseInt(paramString.substring(i, i + 1));
      j += a(arrayOfBoolean, j, q.bkj[k], true);
      i += 1;
    }
    a(arrayOfBoolean, j, q.bkh, true);
    AppMethodBeat.o(57228);
    return arrayOfBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.b.d.k
 * JD-Core Version:    0.7.0.1
 */