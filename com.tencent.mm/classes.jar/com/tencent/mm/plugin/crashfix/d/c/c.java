package com.tencent.mm.plugin.crashfix.d.c;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.reflect.Proxy;

public final class c
{
  protected static Object pgK;
  
  public static Object cU(Object paramObject)
  {
    AppMethodBeat.i(145633);
    if (paramObject == null)
    {
      AppMethodBeat.o(145633);
      return null;
    }
    if (pgK == null) {}
    try
    {
      ClassLoader localClassLoader = paramObject.getClass().getClassLoader();
      Class[] arrayOfClass = paramObject.getClass().getInterfaces();
      if (Build.VERSION.SDK_INT == 25) {}
      for (pgK = Proxy.newProxyInstance(localClassLoader, arrayOfClass, new b(paramObject));; pgK = Proxy.newProxyInstance(localClassLoader, arrayOfClass, new a(paramObject)))
      {
        paramObject = pgK;
        AppMethodBeat.o(145633);
        return paramObject;
      }
    }
    catch (Exception paramObject)
    {
      for (;;)
      {
        ad.e("MicroMsg.ProxyNotificationManager", paramObject.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.crashfix.d.c.c
 * JD-Core Version:    0.7.0.1
 */