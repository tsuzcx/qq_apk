package com.tencent.mm.plugin.appbrand.r.a.a;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.apache.commons.b.a;

public abstract interface k
{
  public abstract int bsP();
  
  public abstract void c(Configuration paramConfiguration);
  
  public abstract boolean ch();
  
  public static final class a
  {
    public static k E(Activity paramActivity)
    {
      AppMethodBeat.i(176746);
      if (paramActivity == null)
      {
        paramActivity = new com.tencent.mm.plugin.appbrand.utils.l()
        {
          public final Object invoke(Object paramAnonymousObject, Method paramAnonymousMethod, Object[] paramAnonymousArrayOfObject)
          {
            AppMethodBeat.i(176745);
            ac.i("Luggage.WXA.WindowAndroidActivityCutoutHandler.Dummy", "dummy invoke method(%s) args(%s)", new Object[] { paramAnonymousMethod.getName(), a.toString(paramAnonymousArrayOfObject, "NULL") });
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.r.a.a.k
 * JD-Core Version:    0.7.0.1
 */