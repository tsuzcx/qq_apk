package com.tencent.mm.app;

import android.app.Application;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

public final class k
{
  static boolean f(Application paramApplication)
  {
    AppMethodBeat.i(202653);
    try
    {
      Method localMethod = Class.forName("com.tencent.mm.sdcard_migrate.ExtStorageMigrateRoutine").getDeclaredMethod("triggerOnDemand", new Class[] { Application.class });
      localMethod.setAccessible(true);
      boolean bool = ((Boolean)localMethod.invoke(null, new Object[] { paramApplication })).booleanValue();
      AppMethodBeat.o(202653);
      return bool;
    }
    catch (Throwable paramApplication)
    {
      AppMethodBeat.o(202653);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.k
 * JD-Core Version:    0.7.0.1
 */