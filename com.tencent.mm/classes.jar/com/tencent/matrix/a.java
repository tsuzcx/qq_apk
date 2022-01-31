package com.tencent.matrix;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.tencent.matrix.g.c;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public enum a
{
  private Set<com.tencent.matrix.b.a> bLQ = Collections.synchronizedSet(new HashSet());
  public boolean bLR = false;
  public String bLS = "default";
  a bLT = new a((byte)0);
  public String bLU;
  boolean isInited = false;
  
  private a() {}
  
  public static String yC()
  {
    l = System.currentTimeMillis();
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
        c.d("Matrix.AppActiveMatrixDelegate", "[getTopActivityName] Cost:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      }
    }
    finally
    {
      c.d("Matrix.AppActiveMatrixDelegate", "[getTopActivityName] Cost:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    }
    return null;
  }
  
  public final void a(com.tencent.matrix.b.a parama)
  {
    this.bLQ.add(parama);
  }
  
  public final void cw(String paramString)
  {
    c.i("Matrix.AppActiveMatrixDelegate", "[setCurrentFragmentName] fragmentName:%s", new Object[] { paramString });
    this.bLU = paramString;
    StringBuilder localStringBuilder = new StringBuilder();
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "?";
    }
    localStringBuilder.append(str);
    this.bLS = localStringBuilder.toString();
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
      if (!a.a(a.this)) {
        a.a(a.this, a.this.bLS);
      }
    }
    
    public final void onActivityStopped(Activity paramActivity)
    {
      if (a.yC() == null) {
        a.b(a.this, a.this.bLS);
      }
    }
    
    public final void onConfigurationChanged(Configuration paramConfiguration) {}
    
    public final void onLowMemory() {}
    
    public final void onTrimMemory(int paramInt)
    {
      c.i("Matrix.AppActiveMatrixDelegate", "[onTrimMemory] level:%s", new Object[] { Integer.valueOf(paramInt) });
      if ((paramInt == 20) && (a.a(a.this))) {
        a.b(a.this, a.b(a.this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.a
 * JD-Core Version:    0.7.0.1
 */