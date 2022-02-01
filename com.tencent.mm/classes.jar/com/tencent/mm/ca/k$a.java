package com.tencent.mm.ca;

import android.app.Application;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

final class k$a
{
  private static Application ELQ;
  
  public static Application eCK()
  {
    AppMethodBeat.i(189890);
    if (ELQ == null) {
      ELQ = getApplication();
    }
    Application localApplication = ELQ;
    AppMethodBeat.o(189890);
    return localApplication;
  }
  
  private static Application getApplication()
  {
    AppMethodBeat.i(189891);
    try
    {
      Object localObject1 = Class.forName("android.app.AppGlobals").getDeclaredMethod("getInitialApplication", new Class[0]);
      ((Method)localObject1).setAccessible(true);
      localObject1 = (Application)((Method)localObject1).invoke(null, new Object[0]);
      AppMethodBeat.o(189891);
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
 * Qualified Name:     com.tencent.mm.ca.k.a
 * JD-Core Version:    0.7.0.1
 */