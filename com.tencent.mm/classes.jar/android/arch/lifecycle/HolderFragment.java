package android.arch.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.g;
import android.support.v4.app.g.b;
import android.support.v4.app.k;
import java.util.HashMap;
import java.util.Map;

public class HolderFragment
  extends Fragment
  implements ViewModelStoreOwner
{
  public static final String HOLDER_TAG = "android.arch.lifecycle.state.StateProviderHolderFragment";
  private static final HolderFragmentManager cq = new HolderFragmentManager();
  private ViewModelStore mViewModelStore = new ViewModelStore();
  
  public HolderFragment()
  {
    setRetainInstance(true);
  }
  
  public static HolderFragment holderFragmentFor(Fragment paramFragment)
  {
    HolderFragmentManager localHolderFragmentManager = cq;
    g localg = paramFragment.getChildFragmentManager();
    Object localObject = HolderFragmentManager.a(localg);
    if (localObject != null) {}
    HolderFragment localHolderFragment;
    do
    {
      return localObject;
      localHolderFragment = (HolderFragment)localHolderFragmentManager.ct.get(paramFragment);
      localObject = localHolderFragment;
    } while (localHolderFragment != null);
    paramFragment.getFragmentManager().registerFragmentLifecycleCallbacks(localHolderFragmentManager.cw, false);
    localObject = HolderFragmentManager.b(localg);
    localHolderFragmentManager.ct.put(paramFragment, localObject);
    return localObject;
  }
  
  public static HolderFragment holderFragmentFor(FragmentActivity paramFragmentActivity)
  {
    HolderFragmentManager localHolderFragmentManager = cq;
    g localg = paramFragmentActivity.getSupportFragmentManager();
    Object localObject = HolderFragmentManager.a(localg);
    if (localObject != null) {}
    HolderFragment localHolderFragment;
    do
    {
      return localObject;
      localHolderFragment = (HolderFragment)localHolderFragmentManager.cs.get(paramFragmentActivity);
      localObject = localHolderFragment;
    } while (localHolderFragment != null);
    if (!localHolderFragmentManager.cv)
    {
      localHolderFragmentManager.cv = true;
      paramFragmentActivity.getApplication().registerActivityLifecycleCallbacks(localHolderFragmentManager.cu);
    }
    localObject = HolderFragmentManager.b(localg);
    localHolderFragmentManager.cs.put(paramFragmentActivity, localObject);
    return localObject;
  }
  
  public ViewModelStore getViewModelStore()
  {
    return this.mViewModelStore;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = cq;
    Fragment localFragment = getParentFragment();
    if (localFragment != null)
    {
      paramBundle.ct.remove(localFragment);
      localFragment.getFragmentManager().unregisterFragmentLifecycleCallbacks(paramBundle.cw);
      return;
    }
    paramBundle.cs.remove(getActivity());
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.mViewModelStore.clear();
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
  }
  
  static class HolderFragmentManager
  {
    Map<Activity, HolderFragment> cs = new HashMap();
    Map<Fragment, HolderFragment> ct = new HashMap();
    Application.ActivityLifecycleCallbacks cu = new EmptyActivityLifecycleCallbacks()
    {
      public void onActivityDestroyed(Activity paramAnonymousActivity)
      {
        if ((HolderFragment)HolderFragment.HolderFragmentManager.a(HolderFragment.HolderFragmentManager.this).remove(paramAnonymousActivity) != null) {
          new StringBuilder("Failed to save a ViewModel for ").append(paramAnonymousActivity);
        }
      }
    };
    boolean cv = false;
    g.b cw = new g.b()
    {
      public void onFragmentDestroyed(g paramAnonymousg, Fragment paramAnonymousFragment)
      {
        super.onFragmentDestroyed(paramAnonymousg, paramAnonymousFragment);
        if ((HolderFragment)HolderFragment.HolderFragmentManager.b(HolderFragment.HolderFragmentManager.this).remove(paramAnonymousFragment) != null) {
          new StringBuilder("Failed to save a ViewModel for ").append(paramAnonymousFragment);
        }
      }
    };
    
    static HolderFragment a(g paramg)
    {
      if (paramg.isDestroyed()) {
        throw new IllegalStateException("Can't access ViewModels from onDestroy");
      }
      paramg = paramg.findFragmentByTag("android.arch.lifecycle.state.StateProviderHolderFragment");
      if ((paramg != null) && (!(paramg instanceof HolderFragment))) {
        throw new IllegalStateException("Unexpected fragment instance was returned by HOLDER_TAG");
      }
      return (HolderFragment)paramg;
    }
    
    static HolderFragment b(g paramg)
    {
      HolderFragment localHolderFragment = new HolderFragment();
      paramg.beginTransaction().a(localHolderFragment, "android.arch.lifecycle.state.StateProviderHolderFragment").commitAllowingStateLoss();
      return localHolderFragment;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.arch.lifecycle.HolderFragment
 * JD-Core Version:    0.7.0.1
 */