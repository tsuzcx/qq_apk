package com.tencent.mm.app;

import android.app.Application;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

public final class m
{
  static boolean g(Application paramApplication)
  {
    AppMethodBeat.i(239300);
    try
    {
      Method localMethod = Class.forName("com.tencent.mm.sdcard_migrate.ExtStorageMigrateRoutine").getDeclaredMethod("triggerOnDemand", new Class[] { Application.class });
      localMethod.setAccessible(true);
      boolean bool = ((Boolean)localMethod.invoke(null, new Object[] { paramApplication })).booleanValue();
      return bool;
    }
    finally
    {
      AppMethodBeat.o(239300);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.m
 * JD-Core Version:    0.7.0.1
 */