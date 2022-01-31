package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.plugin.appbrand.appcache.a.a;
import java.util.Locale;

public final class au
  extends a
{
  au(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    super(b(paramString1, paramString2, paramInt1, paramInt2), ak.rc(b(paramString1, paramString2, paramInt1, paramInt2)), paramString1, paramString2, paramInt1, paramInt2);
  }
  
  private static String b(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    return String.format(Locale.US, "WxaPage_%s_%d_%d_%d", new Object[] { paramString2, Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Integer.valueOf(paramString1.hashCode()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.au
 * JD-Core Version:    0.7.0.1
 */