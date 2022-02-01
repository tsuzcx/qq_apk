package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import java.util.HashSet;
import java.util.Set;

public abstract interface p
{
  public abstract o c(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandRuntimeContainerWC paramAppBrandRuntimeContainerWC);
  
  public static final class a
  {
    private static final Set<p> jzU;
    
    static
    {
      AppMethodBeat.i(43958);
      jzU = new HashSet();
      AppMethodBeat.o(43958);
    }
    
    public static void a(p paramp)
    {
      AppMethodBeat.i(43956);
      if (paramp != null) {
        synchronized (jzU)
        {
          jzU.add(paramp);
          AppMethodBeat.o(43956);
          return;
        }
      }
      AppMethodBeat.o(43956);
    }
    
    static Set<p> aXs()
    {
      AppMethodBeat.i(43957);
      synchronized (jzU)
      {
        HashSet localHashSet = new HashSet(jzU);
        AppMethodBeat.o(43957);
        return localHashSet;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.p
 * JD-Core Version:    0.7.0.1
 */