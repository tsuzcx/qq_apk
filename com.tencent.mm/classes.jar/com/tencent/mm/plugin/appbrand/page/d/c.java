package com.tencent.mm.plugin.appbrand.page.d;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.aa;
import java.lang.reflect.Proxy;

public abstract interface c
{
  public abstract void DK();
  
  public abstract void DL();
  
  public abstract b DM();
  
  public abstract void Dv();
  
  public static final class a
  {
    public static c s(aa paramaa)
    {
      AppMethodBeat.i(135317);
      if (paramaa.jzX.getStatusBar() == null)
      {
        paramaa = new c.a.1();
        paramaa = (c)Proxy.newProxyInstance(c.class.getClassLoader(), new Class[] { c.class }, paramaa);
        AppMethodBeat.o(135317);
        return paramaa;
      }
      if ((Build.VERSION.SDK_INT >= 21) && (!((com.tencent.luggage.sdk.config.a)paramaa.ar(com.tencent.luggage.sdk.config.a.class)).cmk))
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
      mgC = new b("SHOWN", 0);
      mgD = new b("HIDDEN", 1);
      mgE = new b[] { mgC, mgD };
      AppMethodBeat.o(135320);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.d.c
 * JD-Core Version:    0.7.0.1
 */