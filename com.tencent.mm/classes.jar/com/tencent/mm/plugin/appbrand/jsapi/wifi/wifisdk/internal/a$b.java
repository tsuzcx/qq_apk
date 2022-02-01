package com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

final class a$b
  implements InvocationHandler
{
  a$b(a parama) {}
  
  public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(144706);
    ae.i("MicroMsg.WiFiConnector", "Method:" + paramMethod + " getName:" + paramMethod.getName() + " ,Args:" + paramArrayOfObject);
    AppMethodBeat.o(144706);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.a.b
 * JD-Core Version:    0.7.0.1
 */