package com.tencent.mm.plugin.appbrand.page.d;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.aa;
import java.lang.reflect.Proxy;

public abstract interface c
{
  public abstract void CH();
  
  public abstract void CI();
  
  public abstract b CJ();
  
  public abstract void Cs();
  
  public static final class a
  {
    public static c t(aa paramaa)
    {
      AppMethodBeat.i(135317);
      if (paramaa.iGU.getStatusBar() == null)
      {
        paramaa = new c.a.1();
        paramaa = (c)Proxy.newProxyInstance(c.class.getClassLoader(), new Class[] { c.class }, paramaa);
        AppMethodBeat.o(135317);
        return paramaa;
      }
      if ((Build.VERSION.SDK_INT >= 21) && (!((com.tencent.luggage.sdk.config.a)paramaa.ar(com.tencent.luggage.sdk.config.a.class)).ceW))
      {
        paramaa = new a(paramaa);
        AppMethodBeat.o(135317);
        return paramaa;
      }
      paramaa = new b(paramaa);
      AppMethodBeat.o(135317);
      return paramaa;
    }
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(135320);
      lgW = new b("SHOWN", 0);
      lgX = new b("HIDDEN", 1);
      lgY = new b[] { lgW, lgX };
      AppMethodBeat.o(135320);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.d.c
 * JD-Core Version:    0.7.0.1
 */