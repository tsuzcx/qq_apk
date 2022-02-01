package android.arch.lifecycle;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class LifecycleService
  extends Service
  implements LifecycleOwner
{
  private final ServiceLifecycleDispatcher cJ = new ServiceLifecycleDispatcher(this);
  
  public Lifecycle getLifecycle()
  {
    return this.cJ.getLifecycle();
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    this.cJ.onServicePreSuperOnBind();
    return null;
  }
  
  public void onCreate()
  {
    this.cJ.onServicePreSuperOnCreate();
    super.onCreate();
  }
  
  public void onDestroy()
  {
    this.cJ.onServicePreSuperOnDestroy();
    super.onDestroy();
  }
  
  public void onStart(Intent paramIntent, int paramInt)
  {
    this.cJ.onServicePreSuperOnStart();
    super.onStart(paramIntent, paramInt);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.arch.lifecycle.LifecycleService
 * JD-Core Version:    0.7.0.1
 */