package com.tencent.mm.plugin.crashfix.d.a;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.reflect.Proxy;

public final class c
{
  protected static Object kTj;
  
  public static Object bF(Object paramObject)
  {
    AppMethodBeat.i(151904);
    if (paramObject == null)
    {
      AppMethodBeat.o(151904);
      return null;
    }
    if (kTj == null) {}
    try
    {
      ClassLoader localClassLoader = paramObject.getClass().getClassLoader();
      Class[] arrayOfClass = paramObject.getClass().getInterfaces();
      if (Build.VERSION.SDK_INT == 25) {}
      for (kTj = Proxy.newProxyInstance(localClassLoader, arrayOfClass, new b(paramObject));; kTj = Proxy.newProxyInstance(localClassLoader, arrayOfClass, new a(paramObject)))
      {
        paramObject = kTj;
        AppMethodBeat.o(151904);
        return paramObject;
      }
    }
    catch (Exception paramObject)
    {
      for (;;)
      {
        ab.e("MicroMsg.ProxyNotificationManager", paramObject.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.crashfix.d.a.c
 * JD-Core Version:    0.7.0.1
 */