package android.arch.lifecycle;

import android.os.Handler;

public class ServiceLifecycleDispatcher
{
  private final LifecycleRegistry dd;
  private DispatchRunnable dm;
  private final Handler mHandler;
  
  public ServiceLifecycleDispatcher(LifecycleOwner paramLifecycleOwner)
  {
    this.dd = new LifecycleRegistry(paramLifecycleOwner);
    this.mHandler = new Handler();
  }
  
  private void c(Lifecycle.Event paramEvent)
  {
    if (this.dm != null) {
      this.dm.run();
    }
    this.dm = new DispatchRunnable(this.dd, paramEvent);
    this.mHandler.postAtFrontOfQueue(this.dm);
  }
  
  public Lifecycle getLifecycle()
  {
    return this.dd;
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
    private final LifecycleRegistry dd;
    final Lifecycle.Event dn;
    private boolean jdField_do = false;
    
    DispatchRunnable(LifecycleRegistry paramLifecycleRegistry, Lifecycle.Event paramEvent)
    {
      this.dd = paramLifecycleRegistry;
      this.dn = paramEvent;
    }
    
    public void run()
    {
      if (!this.jdField_do)
      {
        this.dd.handleLifecycleEvent(this.dn);
        this.jdField_do = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.arch.lifecycle.ServiceLifecycleDispatcher
 * JD-Core Version:    0.7.0.1
 */