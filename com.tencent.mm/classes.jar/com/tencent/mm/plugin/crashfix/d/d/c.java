package com.tencent.mm.plugin.crashfix.d.d;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Proxy;

public final class c
{
  protected static Object qCW;
  
  public static Object dc(Object paramObject)
  {
    AppMethodBeat.i(145633);
    if (paramObject == null)
    {
      AppMethodBeat.o(145633);
      return null;
    }
    if (qCW == null) {}
    try
    {
      ClassLoader localClassLoader = paramObject.getClass().getClassLoader();
      Class[] arrayOfClass = paramObject.getClass().getInterfaces();
      if (Build.VERSION.SDK_INT == 25) {}
      for (qCW = Proxy.newProxyInstance(localClassLoader, arrayOfClass, new b(paramObject));; qCW = Proxy.newProxyInstance(localClassLoader, arrayOfClass, new a(paramObject)))
      {
        paramObject = qCW;
        AppMethodBeat.o(145633);
        return paramObject;
      }
    }
    catch (Exception paramObject)
    {
      for (;;)
      {
        Log.e("MicroMsg.ProxyNotificationManager", paramObject.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.crashfix.d.d.c
 * JD-Core Version:    0.7.0.1
 */