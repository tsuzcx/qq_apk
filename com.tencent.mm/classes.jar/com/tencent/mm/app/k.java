package com.tencent.mm.app;

import android.app.Application;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

public final class k
{
  static boolean e(Application paramApplication)
  {
    AppMethodBeat.i(212149);
    try
    {
      Method localMethod = Class.forName("com.tencent.mm.sdcard_migrate.ExtStorageMigrateRoutine").getDeclaredMethod("triggerOnDemand", new Class[] { Application.class });
      localMethod.setAccessible(true);
      boolean bool = ((Boolean)localMethod.invoke(null, new Object[] { paramApplication })).booleanValue();
      AppMethodBeat.o(212149);
      return bool;
    }
    catch (Throwable paramApplication)
    {
      AppMethodBeat.o(212149);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.k
 * JD-Core Version:    0.7.0.1
 */