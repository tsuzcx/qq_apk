package com.tencent.mm.plugin.crashfix.d.a;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.reflect.Proxy;

public final class c
{
  protected static Object nZP;
  
  public static Object cS(Object paramObject)
  {
    AppMethodBeat.i(145633);
    if (paramObject == null)
    {
      AppMethodBeat.o(145633);
      return null;
    }
    if (nZP == null) {}
    try
    {
      ClassLoader localClassLoader = paramObject.getClass().getClassLoader();
      Class[] arrayOfClass = paramObject.getClass().getInterfaces();
      if (Build.VERSION.SDK_INT == 25) {}
      for (nZP = Proxy.newProxyInstance(localClassLoader, arrayOfClass, new b(paramObject));; nZP = Proxy.newProxyInstance(localClassLoader, arrayOfClass, new a(paramObject)))
      {
        paramObject = nZP;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.crashfix.d.a.c
 * JD-Core Version:    0.7.0.1
 */