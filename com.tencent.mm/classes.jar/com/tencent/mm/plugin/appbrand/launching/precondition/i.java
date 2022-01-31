package com.tencent.mm.plugin.appbrand.launching.precondition;

import android.content.Context;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class i
{
  static int ioe = 112;
  private static Object iof;
  private static Handler iog;
  
  private static Handler bm(Object paramObject)
  {
    AppMethodBeat.i(132079);
    if (iog != null)
    {
      paramObject = iog;
      AppMethodBeat.o(132079);
      return paramObject;
    }
    Field localField = paramObject.getClass().getDeclaredField("mH");
    localField.setAccessible(true);
    paramObject = (Handler)localField.get(paramObject);
    iog = paramObject;
    AppMethodBeat.o(132079);
    return paramObject;
  }
  
  public static void cT(Context paramContext)
  {
    AppMethodBeat.i(132078);
    try
    {
      paramContext = bm(cU(paramContext));
      Field localField = paramContext.getClass().getDeclaredField("NEW_INTENT");
      localField.setAccessible(true);
      ioe = ((Integer)localField.get(paramContext)).intValue();
      AppMethodBeat.o(132078);
      return;
    }
    catch (Exception paramContext)
    {
      ab.printErrStackTrace("MicroMsg.AppBrand.PreconditionActivityThreadHack", paramContext, "hack constants in ActivityThread$H", new Object[0]);
      AppMethodBeat.o(132078);
    }
  }
  
  private static Object cU(Context paramContext)
  {
    AppMethodBeat.i(132080);
    if (iof != null)
    {
      paramContext = iof;
      AppMethodBeat.o(132080);
      return paramContext;
    }
    Object localObject = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
    ((Method)localObject).setAccessible(true);
    localObject = ((Method)localObject).invoke(null, new Object[0]);
    if (localObject != null)
    {
      iof = localObject;
      AppMethodBeat.o(132080);
      return localObject;
    }
    localObject = paramContext.getClass().getField("mLoadedApk");
    ((Field)localObject).setAccessible(true);
    paramContext = ((Field)localObject).get(paramContext);
    localObject = paramContext.getClass().getDeclaredField("mActivityThread");
    ((Field)localObject).setAccessible(true);
    paramContext = ((Field)localObject).get(paramContext);
    iof = paramContext;
    AppMethodBeat.o(132080);
    return paramContext;
  }
  
  static boolean oJ(int paramInt)
  {
    AppMethodBeat.i(132081);
    try
    {
      Handler localHandler = bm(cU(ah.getContext()));
      if (localHandler == null)
      {
        AppMethodBeat.o(132081);
        return false;
      }
    }
    catch (Exception localException)
    {
      Object localObject;
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.AppBrand.PreconditionActivityThreadHack", localException, "hasPendingMessageInQueue, hack mH", new Object[0]);
        localObject = null;
      }
      boolean bool = localObject.hasMessages(paramInt);
      AppMethodBeat.o(132081);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.precondition.i
 * JD-Core Version:    0.7.0.1
 */