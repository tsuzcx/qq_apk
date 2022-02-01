package com.google.c.d;

import com.google.c.a;
import com.google.c.b.b;
import com.google.c.c;
import com.google.c.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class p
  implements g
{
  private final j cfY;
  
  public p()
  {
    AppMethodBeat.i(12393);
    this.cfY = new j();
    AppMethodBeat.o(12393);
  }
  
  private static String cO(String paramString)
  {
    AppMethodBeat.i(12395);
    int i = paramString.length();
    String str;
    if (i == 11)
    {
      i = 0;
      int j = 0;
      if (i < 11)
      {
        int m = paramString.charAt(i);
        if (i % 2 == 0) {}
        for (int k = 3;; k = 1)
        {
          j += k * (m - 48);
          i += 1;
          break;
        }
      }
      str = paramString + (1000 - j) % 10;
    }
    do
    {
      paramString = "0".concat(String.valueOf(str));
      AppMethodBeat.o(12395);
      return paramString;
      str = paramString;
    } while (i == 12);
    paramString = new IllegalArgumentException("Requested contents should be 11 or 12 digits long, but got " + paramString.length());
    AppMethodBeat.o(12395);
    throw paramString;
  }
  
  public final b a(String paramString, a parama, int paramInt1, int paramInt2, Map<c, ?> paramMap)
  {
    AppMethodBeat.i(12394);
    if (parama != a.cdm)
    {
      paramString = new IllegalArgumentException("Can only encode UPC-A, but got ".concat(String.valueOf(parama)));
      AppMethodBeat.o(12394);
      throw paramString;
    }
    paramString = this.cfY.a(cO(paramString), a.cdf, paramInt1, paramInt2, paramMap);
    AppMethodBeat.o(12394);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.c.d.p
 * JD-Core Version:    0.7.0.1
 */