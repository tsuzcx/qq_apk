package android.arch.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.g;
import android.support.v4.app.g.b;
import android.support.v4.app.k;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

class LifecycleDispatcher
{
  private static AtomicBoolean cy = new AtomicBoolean(false);
  
  private static void a(g paramg, Lifecycle.State paramState)
  {
    paramg = paramg.getFragments();
    if (paramg == null) {}
    for (;;)
    {
      return;
      paramg = paramg.iterator();
      while (paramg.hasNext())
      {
        Fragment localFragment = (Fragment)paramg.next();
        if (localFragment != null)
        {
          a(localFragment, paramState);
          if (localFragment.isAdded()) {
            a(localFragment.getChildFragmentManager(), paramState);
          }
        }
      }
    }
  }
  
  private static void a(Object paramObject, Lifecycle.State paramState)
  {
    if ((paramObject instanceof LifecycleRegistryOwner)) {
      ((LifecycleRegistryOwner)paramObject).getLifecycle().markState(paramState);
    }
  }
  
  static void init(Context paramContext)
  {
    if (cy.getAndSet(true)) {
      return;
    }
    ((Application)paramContext.getApplicationContext()).registerActivityLifecycleCallbacks(new DispatcherActivityCallback());
  }
  
  public static class DestructionReportFragment
    extends Fragment
  {
    private void a(Lifecycle.Event paramEvent)
    {
      LifecycleDispatcher.a(getParentFragment(), paramEvent);
    }
    
    public void onDestroy()
    {
      super.onDestroy();
      a(Lifecycle.Event.ON_DESTROY);
    }
    
    public void onPause()
    {
      super.onPause();
      a(Lifecycle.Event.ON_PAUSE);
    }
    
    public void onStop()
    {
      super.onStop();
      a(Lifecycle.Event.ON_STOP);
    }
  }
  
  static class DispatcherActivityCallback
    extends EmptyActivityLifecycleCallbacks
  {
    private final LifecycleDispatcher.FragmentCallback cz = new LifecycleDispatcher.FragmentCallback();
    
    public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
    {
      if ((paramActivity instanceof FragmentActivity)) {
        ((FragmentActivity)paramActivity).getSupportFragmentManager().registerFragmentLifecycleCallbacks(this.cz, true);
      }
      ReportFragment.injectIfNeededIn(paramActivity);
    }
    
    public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle)
    {
      if ((paramActivity instanceof FragmentActivity)) {
        LifecycleDispatcher.a((FragmentActivity)paramActivity, Lifecycle.State.CREATED);
      }
    }
    
    public void onActivityStopped(Activity paramActivity)
    {
      if ((paramActivity instanceof FragmentActivity)) {
        LifecycleDispatcher.a((FragmentActivity)paramActivity, Lifecycle.State.CREATED);
      }
    }
  }
  
  static class FragmentCallback
    extends g.b
  {
    public void onFragmentCreated(g paramg, Fragment paramFragment, Bundle paramBundle)
    {
      LifecycleDispatcher.a(paramFragment, Lifecycle.Event.ON_CREATE);
      if (!(paramFragment instanceof LifecycleRegistryOwner)) {}
      while (paramFragment.getChildFragmentManager().findFragmentByTag("android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag") != null) {
        return;
      }
      paramFragment.getChildFragmentManager().beginTransaction().a(new LifecycleDispatcher.DestructionReportFragment(), "android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
    }
    
    public void onFragmentResumed(g paramg, Fragment paramFragment)
    {
      LifecycleDispatcher.a(paramFragment, Lifecycle.Event.ON_RESUME);
    }
    
    public void onFragmentStarted(g paramg, Fragment paramFragment)
    {
      LifecycleDispatcher.a(paramFragment, Lifecycle.Event.ON_START);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.arch.lifecycle.LifecycleDispatcher
 * JD-Core Version:    0.7.0.1
 */