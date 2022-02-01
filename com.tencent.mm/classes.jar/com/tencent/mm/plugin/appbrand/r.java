package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import java.util.HashSet;
import java.util.Set;

public abstract interface r
{
  public abstract q b(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandRuntimeContainerWC paramAppBrandRuntimeContainerWC);
  
  public static final class a
  {
    private static final Set<r> kDY;
    
    static
    {
      AppMethodBeat.i(43958);
      kDY = new HashSet();
      AppMethodBeat.o(43958);
    }
    
    public static void a(r paramr)
    {
      AppMethodBeat.i(43956);
      if (paramr != null) {
        synchronized (kDY)
        {
          kDY.add(paramr);
          AppMethodBeat.o(43956);
          return;
        }
      }
      AppMethodBeat.o(43956);
    }
    
    static Set<r> bsU()
    {
      AppMethodBeat.i(43957);
      synchronized (kDY)
      {
        HashSet localHashSet = new HashSet(kDY);
        AppMethodBeat.o(43957);
        return localHashSet;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.r
 * JD-Core Version:    0.7.0.1
 */