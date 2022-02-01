package com.tencent.mm.plugin.appbrand.platform.window.a;

import android.app.Activity;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.apache.commons.b.a;

public final class k$a
{
  public static k F(Activity paramActivity)
  {
    AppMethodBeat.i(176746);
    if (paramActivity == null)
    {
      paramActivity = new com.tencent.mm.plugin.appbrand.utils.m()
      {
        public final Object invoke(Object paramAnonymousObject, Method paramAnonymousMethod, Object[] paramAnonymousArrayOfObject)
        {
          AppMethodBeat.i(176745);
          ae.i("Luggage.WXA.WindowAndroidActivityCutoutHandler.Dummy", "dummy invoke method(%s) args(%s)", new Object[] { paramAnonymousMethod.getName(), a.toString(paramAnonymousArrayOfObject, "NULL") });
          paramAnonymousObject = super.invoke(paramAnonymousObject, paramAnonymousMethod, paramAnonymousArrayOfObject);
          AppMethodBeat.o(176745);
          return paramAnonymousObject;
        }
      };
      paramActivity = (k)Proxy.newProxyInstance(k.class.getClassLoader(), new Class[] { k.class }, paramActivity);
      AppMethodBeat.o(176746);
      return paramActivity;
    }
    if (Build.VERSION.SDK_INT >= 28)
    {
      paramActivity = new l(paramActivity);
      AppMethodBeat.o(176746);
      return paramActivity;
    }
    paramActivity = new m(paramActivity);
    AppMethodBeat.o(176746);
    return paramActivity;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.platform.window.a.k.a
 * JD-Core Version:    0.7.0.1
 */