package android.arch.lifecycle;

import android.os.Handler;

public class ServiceLifecycleDispatcher
{
  private final LifecycleRegistry dh;
  private DispatchRunnable dp;
  private final Handler mHandler;
  
  public ServiceLifecycleDispatcher(LifecycleOwner paramLifecycleOwner)
  {
    this.dh = new LifecycleRegistry(paramLifecycleOwner);
    this.mHandler = new Handler();
  }
  
  private void c(Lifecycle.Event paramEvent)
  {
    if (this.dp != null) {
      this.dp.run();
    }
    this.dp = new DispatchRunnable(this.dh, paramEvent);
    this.mHandler.postAtFrontOfQueue(this.dp);
  }
  
  public Lifecycle getLifecycle()
  {
    return this.dh;
  }
  
  public void onServicePreSuperOnBind()
  {
    c(Lifecycle.Event.ON_START);
  }
  
  public void onServicePreSuperOnCreate()
  {
    c(Lifecycle.Event.ON_CREATE);
  }
  
  public void onServicePreSuperOnDestroy()
  {
    c(Lifecycle.Event.ON_STOP);
    c(Lifecycle.Event.ON_DESTROY);
  }
  
  public void onServicePreSuperOnStart()
  {
    c(Lifecycle.Event.ON_START);
  }
  
  static class DispatchRunnable
    implements Runnable
  {
    private final LifecycleRegistry dh;
    final Lifecycle.Event dq;
    private boolean dr = false;
    
    DispatchRunnable(LifecycleRegistry paramLifecycleRegistry, Lifecycle.Event paramEvent)
    {
      this.dh = paramLifecycleRegistry;
      this.dq = paramEvent;
    }
    
    public void run()
    {
      if (!this.dr)
      {
        this.dh.handleLifecycleEvent(this.dq);
        this.dr = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.arch.lifecycle.ServiceLifecycleDispatcher
 * JD-Core Version:    0.7.0.1
 */