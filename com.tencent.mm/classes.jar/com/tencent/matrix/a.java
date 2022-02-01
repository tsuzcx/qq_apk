package com.tencent.matrix;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.tencent.matrix.b.b;
import com.tencent.matrix.g.c;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public enum a
{
  private final Set<b> cqb = new HashSet();
  public boolean cqc = false;
  public String cqd = "default";
  a cqe = new a((byte)0);
  boolean cqf = false;
  public String cqg;
  Handler handler;
  
  private a() {}
  
  public static String Go()
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
        c.d("Matrix.AppActiveDelegate", "[getTopActivityName] Cost:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      }
    }
    finally
    {
      c.d("Matrix.AppActiveDelegate", "[getTopActivityName] Cost:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    }
    return null;
  }
  
  public final void a(b paramb)
  {
    synchronized (this.cqb)
    {
      this.cqb.add(paramb);
      return;
    }
  }
  
  public final void b(b paramb)
  {
    synchronized (this.cqb)
    {
      this.cqb.remove(paramb);
      return;
    }
  }
  
  public final void cF(String paramString)
  {
    c.i("Matrix.AppActiveDelegate", "[setCurrentFragmentName] fragmentName:%s", new Object[] { paramString });
    this.cqg = paramString;
    StringBuilder localStringBuilder = new StringBuilder();
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "?";
    }
    localStringBuilder.append(str);
    this.cqd = localStringBuilder.toString();
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
      a.a(a.this, a.this.cqd);
    }
    
    public final void onActivityStopped(Activity paramActivity)
    {
      if (a.Go() == null) {
        a.b(a.this, a.this.cqd);
      }
    }
    
    public final void onConfigurationChanged(Configuration paramConfiguration) {}
    
    public final void onLowMemory() {}
    
    public final void onTrimMemory(int paramInt)
    {
      c.i("Matrix.AppActiveDelegate", "[onTrimMemory] level:%s", new Object[] { Integer.valueOf(paramInt) });
      if ((paramInt == 20) && (a.b(a.this))) {
        a.b(a.this, a.c(a.this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.a
 * JD-Core Version:    0.7.0.1
 */