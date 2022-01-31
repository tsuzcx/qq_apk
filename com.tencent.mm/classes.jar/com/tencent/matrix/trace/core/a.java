package com.tencent.matrix.trace.core;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import com.tencent.matrix.d.b;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
  implements Application.ActivityLifecycleCallbacks
{
  private static a bqT;
  private final LinkedList<a> bqU;
  private boolean bqV;
  private String bqW;
  private Runnable bqX;
  private boolean mIsPaused;
  private final Handler mMainHandler;
  
  private a(Application paramApplication)
  {
    if (paramApplication != null)
    {
      paramApplication.unregisterActivityLifecycleCallbacks(this);
      paramApplication.registerActivityLifecycleCallbacks(this);
    }
    this.bqU = new LinkedList();
    this.mMainHandler = new Handler(Looper.getMainLooper());
  }
  
  public static void b(Application paramApplication)
  {
    if (bqT == null) {
      bqT = new a(paramApplication);
    }
  }
  
  private static String i(Activity paramActivity)
  {
    return paramActivity.getClass().getName() + paramActivity.hashCode();
  }
  
  public static a rn()
  {
    return bqT;
  }
  
  public final void a(a parama)
  {
    if (this.bqU != null) {
      this.bqU.add(parama);
    }
  }
  
  public final void b(a parama)
  {
    if (this.bqU != null) {
      this.bqU.remove(parama);
    }
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    paramBundle = this.bqU.iterator();
    while (paramBundle.hasNext()) {
      ((a)paramBundle.next()).onActivityCreated(paramActivity);
    }
  }
  
  public final void onActivityDestroyed(Activity paramActivity)
  {
    if (i(paramActivity).equals(this.bqW)) {
      this.bqW = null;
    }
  }
  
  public final void onActivityPaused(Activity paramActivity)
  {
    Object localObject = this.bqU.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((a)((Iterator)localObject).next()).onActivityPause(paramActivity);
    }
    this.mIsPaused = true;
    if (this.bqX != null) {
      this.mMainHandler.removeCallbacks(this.bqX);
    }
    localObject = new WeakReference(paramActivity);
    paramActivity = this.mMainHandler;
    localObject = new Runnable()
    {
      public final void run()
      {
        Activity localActivity;
        if ((a.b(a.this)) && (a.c(a.this)))
        {
          a.d(a.this);
          localActivity = (Activity)this.bqZ.get();
          if (localActivity != null) {
            break label55;
          }
          b.w("Matrix.ApplicationLifeObserver", "onBackground ac is null!", new Object[0]);
        }
        for (;;)
        {
          return;
          label55:
          Iterator localIterator = a.a(a.this).iterator();
          while (localIterator.hasNext()) {
            ((a.a)localIterator.next()).onBackground(localActivity);
          }
        }
      }
    };
    this.bqX = ((Runnable)localObject);
    paramActivity.postDelayed((Runnable)localObject, 600L);
  }
  
  public final void onActivityResumed(final Activity paramActivity)
  {
    final boolean bool = false;
    Object localObject1 = this.bqU.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((a)((Iterator)localObject1).next()).onActivityResume(paramActivity);
    }
    this.mIsPaused = false;
    if (!this.bqV) {
      bool = true;
    }
    this.bqV = true;
    localObject1 = i(paramActivity);
    if (!((String)localObject1).equals(this.bqW))
    {
      localObject2 = this.bqU.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((a)((Iterator)localObject2).next()).onChange(paramActivity, null);
      }
      this.bqW = ((String)localObject1);
    }
    Object localObject2 = new WeakReference(paramActivity);
    localObject1 = this.mMainHandler;
    paramActivity = new Runnable()
    {
      public final void run()
      {
        if (bool)
        {
          if ((Activity)this.bqZ.get() != null) {
            break label32;
          }
          b.w("Matrix.ApplicationLifeObserver", "onFront ac is null!", new Object[0]);
        }
        for (;;)
        {
          return;
          label32:
          Iterator localIterator = a.a(a.this).iterator();
          while (localIterator.hasNext()) {
            ((a.a)localIterator.next()).onFront(paramActivity);
          }
        }
      }
    };
    this.bqX = paramActivity;
    ((Handler)localObject1).postDelayed(paramActivity, 600L);
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity)
  {
    Iterator localIterator = this.bqU.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).onActivityStarted(paramActivity);
    }
  }
  
  public final void onActivityStopped(Activity paramActivity) {}
  
  public static abstract interface a
  {
    public abstract void onActivityCreated(Activity paramActivity);
    
    public abstract void onActivityPause(Activity paramActivity);
    
    public abstract void onActivityResume(Activity paramActivity);
    
    public abstract void onActivityStarted(Activity paramActivity);
    
    public abstract void onBackground(Activity paramActivity);
    
    public abstract void onChange(Activity paramActivity, Fragment paramFragment);
    
    public abstract void onFront(Activity paramActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.trace.core.a
 * JD-Core Version:    0.7.0.1
 */