package com.tencent.mm.plugin.appbrand.launching.precondition;

import android.content.Context;
import android.os.Handler;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class j
{
  static int gMH = 112;
  private static Object gMI;
  private static Handler gMJ;
  
  private static Handler aS(Object paramObject)
  {
    if (gMJ != null) {
      return gMJ;
    }
    Field localField = paramObject.getClass().getDeclaredField("mH");
    localField.setAccessible(true);
    paramObject = (Handler)localField.get(paramObject);
    gMJ = paramObject;
    return paramObject;
  }
  
  public static void cs(Context paramContext)
  {
    try
    {
      paramContext = aS(ct(paramContext));
      Field localField = paramContext.getClass().getDeclaredField("NEW_INTENT");
      localField.setAccessible(true);
      gMH = ((Integer)localField.get(paramContext)).intValue();
      return;
    }
    catch (Exception paramContext)
    {
      y.printErrStackTrace("MicroMsg.AppBrand.PreconditionActivityThreadHack", paramContext, "hack constants in ActivityThread$H", new Object[0]);
    }
  }
  
  private static Object ct(Context paramContext)
  {
    if (gMI != null) {
      return gMI;
    }
    Object localObject = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
    ((Method)localObject).setAccessible(true);
    localObject = ((Method)localObject).invoke(null, new Object[0]);
    if (localObject != null)
    {
      gMI = localObject;
      return localObject;
    }
    localObject = paramContext.getClass().getField("mLoadedApk");
    ((Field)localObject).setAccessible(true);
    paramContext = ((Field)localObject).get(paramContext);
    localObject = paramContext.getClass().getDeclaredField("mActivityThread");
    ((Field)localObject).setAccessible(true);
    paramContext = ((Field)localObject).get(paramContext);
    gMI = paramContext;
    return paramContext;
  }
  
  static boolean lQ(int paramInt)
  {
    try
    {
      Handler localHandler = aS(ct(ae.getContext()));
      if (localHandler == null) {
        return false;
      }
    }
    catch (Exception localException)
    {
      Object localObject;
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.AppBrand.PreconditionActivityThreadHack", localException, "hasPendingMessageInQueue, hack mH", new Object[0]);
        localObject = null;
      }
      return localObject.hasMessages(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.precondition.j
 * JD-Core Version:    0.7.0.1
 */