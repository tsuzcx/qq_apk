package com.tencent.mm.plugin.appbrand.s.a.a;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Proxy;

public abstract interface k
{
  public abstract int blT();
  
  public abstract void c(Configuration paramConfiguration);
  
  public abstract boolean ca();
  
  public static final class a
  {
    public static k E(Activity paramActivity)
    {
      AppMethodBeat.i(176746);
      if (paramActivity == null)
      {
        paramActivity = new k.a.1();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.s.a.a.k
 * JD-Core Version:    0.7.0.1
 */