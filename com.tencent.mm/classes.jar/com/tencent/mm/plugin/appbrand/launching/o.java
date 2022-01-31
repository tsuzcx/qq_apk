package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.j.a;

public abstract interface o
{
  public abstract void a(o.b paramb);
  
  public abstract void a(o.c paramc);
  
  public abstract void prepareAsync();
  
  public static final class a
  {
    static o f(String paramString1, String paramString2, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(131817);
      if (j.a.nk(paramInt1))
      {
        paramString1 = new w(paramString1, paramString2, paramInt2);
        AppMethodBeat.o(131817);
        return paramString1;
      }
      paramString1 = new x(paramString1, paramString2, paramInt1);
      AppMethodBeat.o(131817);
      return paramString1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.o
 * JD-Core Version:    0.7.0.1
 */