package com.tencent.mm.bz;

import android.app.Application;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

final class k$a
{
  private static Application Gjc;
  
  public static Application eSe()
  {
    AppMethodBeat.i(194831);
    if (Gjc == null) {
      Gjc = getApplication();
    }
    Application localApplication = Gjc;
    AppMethodBeat.o(194831);
    return localApplication;
  }
  
  private static Application getApplication()
  {
    AppMethodBeat.i(194832);
    try
    {
      Object localObject1 = Class.forName("android.app.AppGlobals").getDeclaredMethod("getInitialApplication", new Class[0]);
      ((Method)localObject1).setAccessible(true);
      localObject1 = (Application)((Method)localObject1).invoke(null, new Object[0]);
      AppMethodBeat.o(194832);
      return localObject1;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          Object localObject2 = Class.forName("android.app.ActivityThread").getDeclaredMethod("currentApplication", new Class[0]);
          ((Method)localObject2).setAccessible(true);
          localObject2 = (Application)((Method)localObject2).invoke(null, new Object[0]);
        }
        catch (Exception localException2)
        {
          Object localObject3 = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.bz.k.a
 * JD-Core Version:    0.7.0.1
 */