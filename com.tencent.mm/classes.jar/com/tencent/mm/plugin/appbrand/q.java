package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import java.util.HashSet;
import java.util.Set;

public abstract interface q
{
  public abstract p c(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandRuntimeContainerWC paramAppBrandRuntimeContainerWC);
  
  public static final class a
  {
    private static final Set<q> jCX;
    
    static
    {
      AppMethodBeat.i(43958);
      jCX = new HashSet();
      AppMethodBeat.o(43958);
    }
    
    public static void a(q paramq)
    {
      AppMethodBeat.i(43956);
      if (paramq != null) {
        synchronized (jCX)
        {
          jCX.add(paramq);
          AppMethodBeat.o(43956);
          return;
        }
      }
      AppMethodBeat.o(43956);
    }
    
    static Set<q> aXN()
    {
      AppMethodBeat.i(43957);
      synchronized (jCX)
      {
        HashSet localHashSet = new HashSet(jCX);
        AppMethodBeat.o(43957);
        return localHashSet;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.q
 * JD-Core Version:    0.7.0.1
 */