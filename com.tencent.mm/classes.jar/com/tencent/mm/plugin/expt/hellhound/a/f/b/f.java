package com.tencent.mm.plugin.expt.hellhound.a.f.b;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class f
{
  public static boolean ae(Activity paramActivity)
  {
    AppMethodBeat.i(177389);
    if (paramActivity == null)
    {
      AppMethodBeat.o(177389);
      return false;
    }
    try
    {
      Object localObject = Class.forName("com.tencent.mm.plugin.appbrand.ui.AppBrandUI").getDeclaredField("mRuntimeContainer");
      ((Field)localObject).setAccessible(true);
      paramActivity = ((Field)localObject).get(paramActivity);
      ad.d("LazySessionId", "HABBYGE-MALI, mRuntimeContainer: %s", new Object[] { paramActivity.getClass().getCanonicalName() });
      localObject = Class.forName("com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainer").getDeclaredMethod("getActiveRuntime", new Class[0]);
      ((Method)localObject).setAccessible(true);
      paramActivity = ((Method)localObject).invoke(paramActivity, new Object[0]);
      ad.d("LazySessionId", "HABBYGE-MALI, appBrandRuntime: %s", new Object[] { paramActivity.getClass().getCanonicalName() });
      localObject = Class.forName("com.tencent.mm.plugin.appbrand.AppBrandRuntimeWCAccessible").getDeclaredMethod("isGame", new Class[] { Class.forName("com.tencent.mm.plugin.appbrand.AppBrandRuntime") });
      ((Method)localObject).setAccessible(true);
      boolean bool = ((Boolean)((Method)localObject).invoke(null, new Object[] { paramActivity })).booleanValue();
      AppMethodBeat.o(177389);
      return bool;
    }
    catch (Exception paramActivity)
    {
      ad.printErrStackTrace("LazySessionId", paramActivity, "HABBYGE-MALI, isAppBrandGame, crash: %s", new Object[] { paramActivity.getMessage() });
      AppMethodBeat.o(177389);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.b.f
 * JD-Core Version:    0.7.0.1
 */