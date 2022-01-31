package com.google.b.d;

import com.google.b.a;
import com.google.b.b.b;
import com.google.b.c;
import com.google.b.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class p
  implements g
{
  private final j bkg;
  
  public p()
  {
    AppMethodBeat.i(57328);
    this.bkg = new j();
    AppMethodBeat.o(57328);
  }
  
  private static String bk(String paramString)
  {
    AppMethodBeat.i(57330);
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
      AppMethodBeat.o(57330);
      return paramString;
      str = paramString;
    } while (i == 12);
    paramString = new IllegalArgumentException("Requested contents should be 11 or 12 digits long, but got " + paramString.length());
    AppMethodBeat.o(57330);
    throw paramString;
  }
  
  public final b a(String paramString, a parama, int paramInt1, int paramInt2, Map<c, ?> paramMap)
  {
    AppMethodBeat.i(57329);
    if (parama != a.bhu)
    {
      paramString = new IllegalArgumentException("Can only encode UPC-A, but got ".concat(String.valueOf(parama)));
      AppMethodBeat.o(57329);
      throw paramString;
    }
    paramString = this.bkg.a(bk(paramString), a.bhn, paramInt1, paramInt2, paramMap);
    AppMethodBeat.o(57329);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.b.d.p
 * JD-Core Version:    0.7.0.1
 */