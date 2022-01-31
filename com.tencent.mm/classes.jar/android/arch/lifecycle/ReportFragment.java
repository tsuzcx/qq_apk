package android.arch.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class ReportFragment
  extends Fragment
{
  private ActivityInitializationListener cF;
  
  private void b(Lifecycle.Event paramEvent)
  {
    Object localObject = getActivity();
    if ((localObject instanceof LifecycleRegistryOwner)) {
      ((LifecycleRegistryOwner)localObject).getLifecycle().handleLifecycleEvent(paramEvent);
    }
    do
    {
      do
      {
        return;
      } while (!(localObject instanceof LifecycleOwner));
      localObject = ((LifecycleOwner)localObject).getLifecycle();
    } while (!(localObject instanceof LifecycleRegistry));
    ((LifecycleRegistry)localObject).handleLifecycleEvent(paramEvent);
  }
  
  public static void injectIfNeededIn(Activity paramActivity)
  {
    paramActivity = paramActivity.getFragmentManager();
    if (paramActivity.findFragmentByTag("android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag") == null)
    {
      paramActivity.beginTransaction().add(new ReportFragment(), "android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
      paramActivity.executePendingTransactions();
    }
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    paramBundle = this.cF;
    if (paramBundle != null) {
      paramBundle.onCreate();
    }
    b(Lifecycle.Event.ON_CREATE);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    b(Lifecycle.Event.ON_DESTROY);
    this.cF = null;
  }
  
  public void onPause()
  {
    super.onPause();
    b(Lifecycle.Event.ON_PAUSE);
  }
  
  public void onResume()
  {
    super.onResume();
    ActivityInitializationListener localActivityInitializationListener = this.cF;
    if (localActivityInitializationListener != null) {
      localActivityInitializationListener.onResume();
    }
    b(Lifecycle.Event.ON_RESUME);
  }
  
  public void onStart()
  {
    super.onStart();
    ActivityInitializationListener localActivityInitializationListener = this.cF;
    if (localActivityInitializationListener != null) {
      localActivityInitializationListener.onStart();
    }
    b(Lifecycle.Event.ON_START);
  }
  
  public void onStop()
  {
    super.onStop();
    b(Lifecycle.Event.ON_STOP);
  }
  
  static abstract interface ActivityInitializationListener
  {
    public abstract void onCreate();
    
    public abstract void onResume();
    
    public abstract void onStart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.arch.lifecycle.ReportFragment
 * JD-Core Version:    0.7.0.1
 */