package android.arch.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;

public class ProcessLifecycleOwner
  implements LifecycleOwner
{
  private static final ProcessLifecycleOwner dh = new ProcessLifecycleOwner();
  int cY = 0;
  int cZ = 0;
  boolean da = true;
  boolean dc = true;
  final LifecycleRegistry dd = new LifecycleRegistry(this);
  Runnable de = new Runnable()
  {
    public void run()
    {
      ProcessLifecycleOwner.a(ProcessLifecycleOwner.this);
      ProcessLifecycleOwner.b(ProcessLifecycleOwner.this);
    }
  };
  private ReportFragment.ActivityInitializationListener dg = new ReportFragment.ActivityInitializationListener()
  {
    public void onCreate() {}
    
    public void onResume()
    {
      ProcessLifecycleOwner localProcessLifecycleOwner = ProcessLifecycleOwner.this;
      localProcessLifecycleOwner.cZ += 1;
      if (localProcessLifecycleOwner.cZ == 1)
      {
        if (localProcessLifecycleOwner.da)
        {
          localProcessLifecycleOwner.dd.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
          localProcessLifecycleOwner.da = false;
        }
      }
      else {
        return;
      }
      localProcessLifecycleOwner.mHandler.removeCallbacks(localProcessLifecycleOwner.de);
    }
    
    public void onStart()
    {
      ProcessLifecycleOwner localProcessLifecycleOwner = ProcessLifecycleOwner.this;
      localProcessLifecycleOwner.cY += 1;
      if ((localProcessLifecycleOwner.cY == 1) && (localProcessLifecycleOwner.dc))
      {
        localProcessLifecycleOwner.dd.handleLifecycleEvent(Lifecycle.Event.ON_START);
        localProcessLifecycleOwner.dc = false;
      }
    }
  };
  Handler mHandler;
  
  public static LifecycleOwner get()
  {
    return dh;
  }
  
  static void init(Context paramContext)
  {
    ProcessLifecycleOwner localProcessLifecycleOwner = dh;
    localProcessLifecycleOwner.mHandler = new Handler();
    localProcessLifecycleOwner.dd.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
    ((Application)paramContext.getApplicationContext()).registerActivityLifecycleCallbacks(new EmptyActivityLifecycleCallbacks()
    {
      public void onActivityCreated(Activity paramAnonymousActivity, Bundle paramAnonymousBundle)
      {
        ReportFragment.b(paramAnonymousActivity).dl = ProcessLifecycleOwner.c(ProcessLifecycleOwner.this);
      }
      
      public void onActivityPaused(Activity paramAnonymousActivity)
      {
        paramAnonymousActivity = ProcessLifecycleOwner.this;
        paramAnonymousActivity.cZ -= 1;
        if (paramAnonymousActivity.cZ == 0) {
          paramAnonymousActivity.mHandler.postDelayed(paramAnonymousActivity.de, 700L);
        }
      }
      
      public void onActivityStopped(Activity paramAnonymousActivity)
      {
        paramAnonymousActivity = ProcessLifecycleOwner.this;
        paramAnonymousActivity.cY -= 1;
        paramAnonymousActivity.at();
      }
    });
  }
  
  final void at()
  {
    if ((this.cY == 0) && (this.da))
    {
      this.dd.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
      this.dc = true;
    }
  }
  
  public Lifecycle getLifecycle()
  {
    return this.dd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.arch.lifecycle.ProcessLifecycleOwner
 * JD-Core Version:    0.7.0.1
 */