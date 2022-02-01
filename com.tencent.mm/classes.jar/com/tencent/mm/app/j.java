package com.tencent.mm.app;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

public final class j
{
  static boolean bo(Context paramContext)
  {
    AppMethodBeat.i(192563);
    try
    {
      Method localMethod = Class.forName("com.tencent.mm.sdcard_migrate.ExtStorageMigrateRoutine").getDeclaredMethod("triggerOnDemand", new Class[] { Context.class });
      localMethod.setAccessible(true);
      boolean bool = ((Boolean)localMethod.invoke(null, new Object[] { paramContext })).booleanValue();
      AppMethodBeat.o(192563);
      return bool;
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(192563);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.j
 * JD-Core Version:    0.7.0.1
 */