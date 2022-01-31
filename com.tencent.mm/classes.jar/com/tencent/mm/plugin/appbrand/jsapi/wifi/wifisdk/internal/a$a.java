package com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal;

import android.os.Handler;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

final class a$a
  implements InvocationHandler
{
  a$a(a parama) {}
  
  public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    if (paramMethod.getName().compareTo("onSuccess") == 0) {}
    while (paramMethod.getName().compareTo("onFailure") != 0) {
      return null;
    }
    if ((paramArrayOfObject != null) && ((paramArrayOfObject[0] instanceof Integer))) {}
    for (int i = ((Integer)paramArrayOfObject[0]).intValue();; i = -1)
    {
      this.gHn.mHandler.post(new a.a.1(this, i));
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.a.a
 * JD-Core Version:    0.7.0.1
 */