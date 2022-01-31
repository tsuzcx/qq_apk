package com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal;

import com.tencent.mm.sdk.platformtools.y;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

final class a$b
  implements InvocationHandler
{
  a$b(a parama) {}
  
  public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    y.i("MicroMsg.WiFiConnector", "Method:" + paramMethod + " getName:" + paramMethod.getName() + " ,Args:" + paramArrayOfObject);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.a.b
 * JD-Core Version:    0.7.0.1
 */