package com.tencent.mm.plugin.appbrand.page.c;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.z;
import java.lang.reflect.Proxy;

public abstract interface c
{
  public abstract void DN();
  
  public abstract void DO();
  
  public abstract b DP();
  
  public abstract void Dy();
  
  public static final class a
  {
    public static c t(z paramz)
    {
      AppMethodBeat.i(135317);
      if (paramz.jDa.getStatusBar() == null)
      {
        paramz = new c.a.1();
        paramz = (c)Proxy.newProxyInstance(c.class.getClassLoader(), new Class[] { c.class }, paramz);
        AppMethodBeat.o(135317);
        return paramz;
      }
      if ((Build.VERSION.SDK_INT >= 21) && (!((com.tencent.luggage.sdk.config.a)paramz.ar(com.tencent.luggage.sdk.config.a.class)).cmm))
      {
        paramz = new a(paramz);
        AppMethodBeat.o(135317);
        return paramz;
      }
      paramz = new b(paramz);
      AppMethodBeat.o(135317);
      return paramz;
    }
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(135320);
      mlB = new b("SHOWN", 0);
      mlC = new b("HIDDEN", 1);
      mlD = new b[] { mlB, mlC };
      AppMethodBeat.o(135320);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.c.c
 * JD-Core Version:    0.7.0.1
 */