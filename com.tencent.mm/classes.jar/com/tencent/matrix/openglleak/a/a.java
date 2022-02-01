package com.tencent.matrix.openglleak.a;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class a
  implements Application.ActivityLifecycleCallbacks
{
  private static final a eXX = new a();
  private final List<a.a> eXW = new LinkedList();
  public a.a eXY = null;
  
  public static a ayS()
  {
    return eXX;
  }
  
  public static Activity getActivity()
  {
    try
    {
      Object localObject2 = Class.forName("android.app.ActivityThread");
      Object localObject1 = ((Class)localObject2).getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
      localObject2 = ((Class)localObject2).getDeclaredField("mActivities");
      ((Field)localObject2).setAccessible(true);
      localObject2 = ((Map)((Field)localObject2).get(localObject1)).values().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = ((Iterator)localObject2).next();
        Class localClass = localObject1.getClass();
        Field localField = localClass.getDeclaredField("paused");
        localField.setAccessible(true);
        if (!localField.getBoolean(localObject1))
        {
          localObject2 = localClass.getDeclaredField("activity");
          ((Field)localObject2).setAccessible(true);
          localObject1 = (Activity)((Field)localObject2).get(localObject1);
          return localObject1;
        }
      }
    }
    catch (Exception localException) {}
    return null;
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    this.eXY = new a.a(paramActivity.hashCode(), paramActivity.getLocalClassName());
    this.eXW.add(this.eXY);
  }
  
  public final void onActivityDestroyed(Activity paramActivity)
  {
    this.eXW.remove(new a.a(paramActivity.hashCode(), paramActivity.getLocalClassName()));
  }
  
  public final void onActivityPaused(Activity paramActivity) {}
  
  public final void onActivityResumed(Activity paramActivity)
  {
    this.eXY = new a.a(paramActivity.hashCode(), paramActivity.getLocalClassName());
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.openglleak.a.a
 * JD-Core Version:    0.7.0.1
 */