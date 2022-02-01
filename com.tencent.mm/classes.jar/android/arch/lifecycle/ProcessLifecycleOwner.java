package android.arch.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;

public class ProcessLifecycleOwner
  implements LifecycleOwner
{
  private static final ProcessLifecycleOwner dk = new ProcessLifecycleOwner();
  int dc = 0;
  int dd = 0;
  boolean de = true;
  boolean dg = true;
  final LifecycleRegistry dh = new LifecycleRegistry(this);
  Runnable di = new Runnable()
  {
    public void run()
    {
      ProcessLifecycleOwner.a(ProcessLifecycleOwner.this);
      ProcessLifecycleOwner.b(ProcessLifecycleOwner.this);
    }
  };
  private ReportFragment.ActivityInitializationListener dj = new ReportFragment.ActivityInitializationListener()
  {
    public void onCreate() {}
    
    public void onResume()
    {
      ProcessLifecycleOwner localProcessLifecycleOwner = ProcessLifecycleOwner.this;
      localProcessLifecycleOwner.dd += 1;
      if (localProcessLifecycleOwner.dd == 1)
      {
        if (localProcessLifecycleOwner.de)
        {
          localProcessLifecycleOwner.dh.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
          localProcessLifecycleOwner.de = false;
        }
      }
      else {
        return;
      }
      localProcessLifecycleOwner.mHandler.removeCallbacks(localProcessLifecycleOwner.di);
    }
    
    public void onStart()
    {
      ProcessLifecycleOwner localProcessLifecycleOwner = ProcessLifecycleOwner.this;
      localProcessLifecycleOwner.dc += 1;
      if ((localProcessLifecycleOwner.dc == 1) && (localProcessLifecycleOwner.dg))
      {
        localProcessLifecycleOwner.dh.handleLifecycleEvent(Lifecycle.Event.ON_START);
        localProcessLifecycleOwner.dg = false;
      }
    }
  };
  Handler mHandler;
  
  public static LifecycleOwner get()
  {
    return dk;
  }
  
  static void init(Context paramContext)
  {
    ProcessLifecycleOwner localProcessLifecycleOwner = dk;
    localProcessLifecycleOwner.mHandler = new Handler();
    localProcessLifecycleOwner.dh.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
    ((Application)paramContext.getApplicationContext()).registerActivityLifecycleCallbacks(new EmptyActivityLifecycleCallbacks()
    {
      public void onActivityCreated(Activity paramAnonymousActivity, Bundle paramAnonymousBundle)
      {
        ReportFragment.b(paramAnonymousActivity).jdField_do = ProcessLifecycleOwner.c(ProcessLifecycleOwner.this);
      }
      
      public void onActivityPaused(Activity paramAnonymousActivity)
      {
        paramAnonymousActivity = ProcessLifecycleOwner.this;
        paramAnonymousActivity.dd -= 1;
        if (paramAnonymousActivity.dd == 0) {
          paramAnonymousActivity.mHandler.postDelayed(paramAnonymousActivity.di, 700L);
        }
      }
      
      public void onActivityStopped(Activity paramAnonymousActivity)
      {
        paramAnonymousActivity = ProcessLifecycleOwner.this;
        paramAnonymousActivity.dc -= 1;
        paramAnonymousActivity.ac();
      }
    });
  }
  
  final void ac()
  {
    if ((this.dc == 0) && (this.de))
    {
      this.dh.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
      this.dg = true;
    }
  }
  
  public Lifecycle getLifecycle()
  {
    return this.dh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.arch.lifecycle.ProcessLifecycleOwner
 * JD-Core Version:    0.7.0.1
 */