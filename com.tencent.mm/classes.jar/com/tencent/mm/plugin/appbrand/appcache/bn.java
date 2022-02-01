package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.a.a;
import java.util.Locale;

public final class bn
  extends a
{
  bn(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    super(b(paramString1, paramString2, paramInt1, paramInt2), ay.Ea(b(paramString1, paramString2, paramInt1, paramInt2)), paramString1, paramString2, paramInt1, paramInt2);
    AppMethodBeat.i(90664);
    AppMethodBeat.o(90664);
  }
  
  private static String b(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(90663);
    paramString1 = String.format(Locale.US, "WxaPage_%s_%d_%d_%d", new Object[] { paramString2, Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Integer.valueOf(paramString1.hashCode()) });
    AppMethodBeat.o(90663);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bn
 * JD-Core Version:    0.7.0.1
 */