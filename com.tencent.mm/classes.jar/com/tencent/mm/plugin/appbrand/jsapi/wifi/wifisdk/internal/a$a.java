package com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

final class a$a
  implements InvocationHandler
{
  a$a(a parama) {}
  
  public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(94390);
    if (paramMethod.getName().compareTo("onSuccess") == 0)
    {
      AppMethodBeat.o(94390);
      return null;
    }
    if (paramMethod.getName().compareTo("onFailure") == 0) {
      if ((paramArrayOfObject == null) || (!(paramArrayOfObject[0] instanceof Integer))) {
        break label88;
      }
    }
    label88:
    for (int i = ((Integer)paramArrayOfObject[0]).intValue();; i = -1)
    {
      this.ihW.mHandler.post(new a.a.1(this, i));
      AppMethodBeat.o(94390);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.a.a
 * JD-Core Version:    0.7.0.1
 */