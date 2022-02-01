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
  static boolean bFg()
  {
    AppMethodBeat.i(283006);
    if ((a.feV == null) || (a.nBO == null)) {}
    for (;;)
    {
      try
      {
        localObject2 = (Application)MMApplicationContext.getContext().getApplicationContext();
        localObject1 = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
        ((Method)localObject1).setAccessible(true);
        localObject1 = ((Method)localObject1).invoke(null, new Object[0]);
        if (localObject1 == null) {
          continue;
        }
        a.feV = localObject1;
        localObject2 = localObject1.getClass().getDeclaredField("mH");
        ((Field)localObject2).setAccessible(true);
        a.nBO = (Handler)((Field)localObject2).get(localObject1);
      }
      catch (Throwable localThrowable)
      {
        Object localObject2;
        Object localObject1;
        Log.e("MicroMsg.AppBrandProcessSuicideLogic.ActivityThreadHackDetector", "hack ActivityThread failed %s", new Object[] { localThrowable });
        continue;
        AppMethodBeat.o(283006);
        return false;
      }
      localObject1 = a.nBO;
      if (localObject1 == null) {
        break label223;
      }
      if ((!((Handler)localObject1).hasMessages(100)) && (!((Handler)localObject1).hasMessages(126)) && ((Build.VERSION.SDK_INT != 28) || (!((Handler)localObject1).hasMessages(160))) && (!((Handler)localObject1).hasMessages(159))) {
        continue;
      }
      AppMethodBeat.o(283006);
      return true;
      localObject1 = localObject2.getClass().getField("mLoadedApk");
      ((Field)localObject1).setAccessible(true);
      localObject1 = ((Field)localObject1).get(localObject2);
      localObject2 = localObject1.getClass().getDeclaredField("mActivityThread");
      ((Field)localObject2).setAccessible(true);
      localObject1 = ((Field)localObject2).get(localObject1);
    }
    label223:
    AppMethodBeat.o(283006);
    return false;
  }
  
  static final class a
  {
    public static Object feV;
    public static Handler nBO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.a
 * JD-Core Version:    0.7.0.1
 */