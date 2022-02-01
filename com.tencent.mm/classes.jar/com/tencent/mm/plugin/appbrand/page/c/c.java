package com.tencent.mm.plugin.appbrand.page.c;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.utils.m;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public abstract interface c
{
  public abstract void MV();
  
  public abstract void Nj();
  
  public abstract void Nk();
  
  public abstract b Nl();
  
  public static final class a
  {
    public static c y(ac paramac)
    {
      AppMethodBeat.i(135317);
      if (paramac.kEb.getStatusBar() == null)
      {
        paramac = new m()
        {
          public final Object invoke(Object paramAnonymousObject, Method paramAnonymousMethod, Object[] paramAnonymousArrayOfObject)
          {
            AppMethodBeat.i(176696);
            Log.i("Luggage.WXA.IPageStatusBarHelper.Dummy", "dummy invoke method(%s) args(%s)", new Object[] { paramAnonymousMethod.getName(), org.apache.commons.b.a.toString(paramAnonymousArrayOfObject, "NULL") });
            paramAnonymousObject = super.invoke(paramAnonymousObject, paramAnonymousMethod, paramAnonymousArrayOfObject);
            AppMethodBeat.o(176696);
            return paramAnonymousObject;
          }
        };
        paramac = (c)Proxy.newProxyInstance(c.class.getClassLoader(), new Class[] { c.class }, paramac);
        AppMethodBeat.o(135317);
        return paramac;
      }
      if ((Build.VERSION.SDK_INT >= 21) && (!((com.tencent.luggage.sdk.config.a)paramac.av(com.tencent.luggage.sdk.config.a.class)).cyh))
      {
        paramac = new a(paramac);
        AppMethodBeat.o(135317);
        return paramac;
      }
      paramac = new b(paramac);
      AppMethodBeat.o(135317);
      return paramac;
    }
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(135320);
      nvZ = new b("SHOWN", 0);
      nwa = new b("HIDDEN", 1);
      nwb = new b[] { nvZ, nwa };
      AppMethodBeat.o(135320);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.c.c
 * JD-Core Version:    0.7.0.1
 */