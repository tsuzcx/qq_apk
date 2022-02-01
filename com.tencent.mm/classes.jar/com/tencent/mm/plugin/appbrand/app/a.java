package com.tencent.mm.plugin.appbrand.app;

import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

final class a
{
  static boolean cet()
  {
    AppMethodBeat.i(317795);
    if ((a.hjc == null) || (a.qBf == null)) {}
    for (;;)
    {
      try
      {
        localObject3 = (Application)MMApplicationContext.getContext().getApplicationContext();
        localObject1 = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
        ((Method)localObject1).setAccessible(true);
        localObject1 = ((Method)localObject1).invoke(null, new Object[0]);
        if (localObject1 == null) {
          continue;
        }
        a.hjc = localObject1;
        localObject3 = localObject1.getClass().getDeclaredField("mH");
        ((Field)localObject3).setAccessible(true);
        a.qBf = (Handler)((Field)localObject3).get(localObject1);
      }
      finally
      {
        Object localObject3;
        Object localObject1;
        Log.e("MicroMsg.AppBrandProcessSuicideLogic.ActivityThreadHackDetector", "hack ActivityThread failed %s", new Object[] { localObject2 });
        continue;
        AppMethodBeat.o(317795);
        return false;
      }
      localObject1 = a.qBf;
      if (localObject1 == null) {
        break label223;
      }
      if ((!((Handler)localObject1).hasMessages(100)) && (!((Handler)localObject1).hasMessages(126)) && ((Build.VERSION.SDK_INT != 28) || (!((Handler)localObject1).hasMessages(160))) && (!((Handler)localObject1).hasMessages(159))) {
        continue;
      }
      AppMethodBeat.o(317795);
      return true;
      localObject1 = localObject3.getClass().getField("mLoadedApk");
      ((Field)localObject1).setAccessible(true);
      localObject1 = ((Field)localObject1).get(localObject3);
      localObject3 = localObject1.getClass().getDeclaredField("mActivityThread");
      ((Field)localObject3).setAccessible(true);
      localObject1 = ((Field)localObject3).get(localObject1);
    }
    label223:
    AppMethodBeat.o(317795);
    return false;
  }
  
  static final class a
  {
    public static Object hjc;
    public static Handler qBf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.a
 * JD-Core Version:    0.7.0.1
 */