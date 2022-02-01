package com.tencent.matrix.trace.f;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.ArrayMap;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public enum a
{
  private boolean eLx = false;
  String eLy = "default";
  private a fhc = new a((byte)0);
  public boolean isInit = false;
  
  private a() {}
  
  public static boolean aAc()
  {
    return aAd();
  }
  
  private static boolean aAd()
  {
    try
    {
      Object localObject2 = Class.forName("android.app.ActivityThread");
      Object localObject1 = ((Class)localObject2).getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
      localObject2 = ((Class)localObject2).getDeclaredField("mActivities");
      ((Field)localObject2).setAccessible(true);
      if (Build.VERSION.SDK_INT < 19) {}
      for (localObject1 = (HashMap)((Field)localObject2).get(localObject1); ((Map)localObject1).size() <= 0; localObject1 = (ArrayMap)((Field)localObject2).get(localObject1)) {
        return false;
      }
      localObject1 = ((Map)localObject1).values().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        Field localField = localObject2.getClass().getDeclaredField("paused");
        localField.setAccessible(true);
        boolean bool = localField.getBoolean(localObject2);
        if (!bool) {
          return true;
        }
      }
    }
    catch (Exception localException) {}
    return false;
  }
  
  public static String avV()
  {
    System.currentTimeMillis();
    try
    {
      Object localObject3 = Class.forName("android.app.ActivityThread");
      Object localObject1 = ((Class)localObject3).getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
      localObject3 = ((Class)localObject3).getDeclaredField("mActivities");
      ((Field)localObject3).setAccessible(true);
      if (Build.VERSION.SDK_INT < 19) {}
      for (localObject1 = (HashMap)((Field)localObject3).get(localObject1);; localObject1 = (ArrayMap)((Field)localObject3).get(localObject1))
      {
        int i = ((Map)localObject1).size();
        if (i > 0) {
          break;
        }
        return null;
      }
      localObject3 = ((Map)localObject1).values().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject1 = ((Iterator)localObject3).next();
        Class localClass = localObject1.getClass();
        Field localField = localClass.getDeclaredField("paused");
        localField.setAccessible(true);
        if (!localField.getBoolean(localObject1))
        {
          localObject3 = localClass.getDeclaredField("activity");
          ((Field)localObject3).setAccessible(true);
          localObject1 = ((Activity)((Field)localObject3).get(localObject1)).getClass().getName();
          return localObject1;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        System.currentTimeMillis();
      }
    }
    finally
    {
      System.currentTimeMillis();
    }
    return null;
  }
  
  final class a
    implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2
  {
    private a() {}
    
    public final void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
    
    public final void onActivityDestroyed(Activity paramActivity) {}
    
    public final void onActivityPaused(Activity paramActivity) {}
    
    public final void onActivityResumed(Activity paramActivity) {}
    
    public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
    
    public final void onActivityStarted(Activity paramActivity)
    {
      a.a(a.this, paramActivity);
      a.a(a.this);
    }
    
    public final void onActivityStopped(Activity paramActivity)
    {
      if (a.avV() == null) {
        a.b(a.this);
      }
    }
    
    public final void onConfigurationChanged(Configuration paramConfiguration) {}
    
    public final void onLowMemory() {}
    
    public final void onTrimMemory(int paramInt)
    {
      if ((paramInt == 20) && (a.c(a.this)))
      {
        a locala = a.this;
        a.d(a.this);
        a.b(locala);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.trace.f.a
 * JD-Core Version:    0.7.0.1
 */