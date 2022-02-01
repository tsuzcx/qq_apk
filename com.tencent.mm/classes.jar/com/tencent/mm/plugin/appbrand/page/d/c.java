package com.tencent.mm.plugin.appbrand.page.d;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.utils.l;
import com.tencent.mm.sdk.platformtools.ac;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public abstract interface c
{
  public abstract void BW();
  
  public abstract void Cl();
  
  public abstract void Cm();
  
  public abstract b Cn();
  
  public static final class a
  {
    public static c s(aa paramaa)
    {
      AppMethodBeat.i(135317);
      if (paramaa.jgX.getStatusBar() == null)
      {
        paramaa = new l()
        {
          public final Object invoke(Object paramAnonymousObject, Method paramAnonymousMethod, Object[] paramAnonymousArrayOfObject)
          {
            AppMethodBeat.i(176696);
            ac.i("Luggage.WXA.IPageStatusBarHelper.Dummy", "dummy invoke method(%s) args(%s)", new Object[] { paramAnonymousMethod.getName(), org.apache.commons.b.a.toString(paramAnonymousArrayOfObject, "NULL") });
            paramAnonymousObject = super.invoke(paramAnonymousObject, paramAnonymousMethod, paramAnonymousArrayOfObject);
            AppMethodBeat.o(176696);
            return paramAnonymousObject;
          }
        };
        paramaa = (c)Proxy.newProxyInstance(c.class.getClassLoader(), new Class[] { c.class }, paramaa);
        AppMethodBeat.o(135317);
        return paramaa;
      }
      if ((Build.VERSION.SDK_INT >= 21) && (!((com.tencent.luggage.sdk.config.a)paramaa.ar(com.tencent.luggage.sdk.config.a.class)).cbT))
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
      lGP = new b("SHOWN", 0);
      lGQ = new b("HIDDEN", 1);
      lGR = new b[] { lGP, lGQ };
      AppMethodBeat.o(135320);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.d.c
 * JD-Core Version:    0.7.0.1
 */