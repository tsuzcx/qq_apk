package com.tencent.mm.plugin.appbrand.luggage.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainerWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.q;

public final class b
  implements q
{
  public static final b lUU;
  
  static
  {
    AppMethodBeat.i(47551);
    lUU = new b();
    AppMethodBeat.o(47551);
  }
  
  public final p c(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandRuntimeContainerWC paramAppBrandRuntimeContainerWC)
  {
    AppMethodBeat.i(47550);
    int i;
    if (!paramAppBrandInitConfigWC.kaG)
    {
      String str = paramAppBrandInitConfigWC.username;
      if (str != null) {
        str.length();
      }
      i = 0;
    }
    while (i != 0)
    {
      paramAppBrandInitConfigWC = j.a(paramAppBrandInitConfigWC, paramAppBrandRuntimeContainerWC);
      if ((paramAppBrandInitConfigWC instanceof f))
      {
        AppMethodBeat.o(47550);
        return paramAppBrandInitConfigWC;
        i = 1;
      }
      else
      {
        if (paramAppBrandInitConfigWC != null) {
          paramAppBrandInitConfigWC.aXB();
        }
        paramAppBrandInitConfigWC = new f(paramAppBrandRuntimeContainerWC);
        AppMethodBeat.o(47550);
        return paramAppBrandInitConfigWC;
      }
    }
    AppMethodBeat.o(47550);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.c.b
 * JD-Core Version:    0.7.0.1
 */