package com.tencent.mm.plugin.appbrand.page.c;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ad;
import java.lang.reflect.Proxy;

public abstract interface c
{
  public abstract void apW();
  
  public abstract void aql();
  
  public abstract void aqm();
  
  public abstract b aqn();
  
  public static final class a
  {
    public static c z(ad paramad)
    {
      AppMethodBeat.i(135317);
      if (paramad.qwF.getStatusBar() == null)
      {
        paramad = new c.a.1();
        paramad = (c)Proxy.newProxyInstance(c.class.getClassLoader(), new Class[] { c.class }, paramad);
        AppMethodBeat.o(135317);
        return paramad;
      }
      if ((Build.VERSION.SDK_INT >= 21) && (!((com.tencent.luggage.sdk.config.a)paramad.aN(com.tencent.luggage.sdk.config.a.class)).eoK))
      {
        paramad = new a(paramad);
        AppMethodBeat.o(135317);
        return paramad;
      }
      paramad = new b(paramad);
      AppMethodBeat.o(135317);
      return paramad;
    }
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(135320);
      tDb = new b("SHOWN", 0);
      tDc = new b("HIDDEN", 1);
      tDd = new b[] { tDb, tDc };
      AppMethodBeat.o(135320);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.c.c
 * JD-Core Version:    0.7.0.1
 */