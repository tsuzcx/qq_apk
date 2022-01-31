package android.arch.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

public class ViewModelProviders
{
  private static Activity a(Fragment paramFragment)
  {
    paramFragment = paramFragment.getActivity();
    if (paramFragment == null) {
      throw new IllegalStateException("Can't create ViewModelProvider for detached fragment");
    }
    return paramFragment;
  }
  
  private static Application c(Activity paramActivity)
  {
    paramActivity = paramActivity.getApplication();
    if (paramActivity == null) {
      throw new IllegalStateException("Your activity/fragment is not yet attached to Application. You can't request ViewModel before onCreate call.");
    }
    return paramActivity;
  }
  
  public static ViewModelProvider of(Fragment paramFragment)
  {
    ViewModelProvider.AndroidViewModelFactory localAndroidViewModelFactory = ViewModelProvider.AndroidViewModelFactory.getInstance(c(a(paramFragment)));
    return new ViewModelProvider(ViewModelStores.of(paramFragment), localAndroidViewModelFactory);
  }
  
  public static ViewModelProvider of(Fragment paramFragment, ViewModelProvider.Factory paramFactory)
  {
    c(a(paramFragment));
    return new ViewModelProvider(ViewModelStores.of(paramFragment), paramFactory);
  }
  
  public static ViewModelProvider of(FragmentActivity paramFragmentActivity)
  {
    ViewModelProvider.AndroidViewModelFactory localAndroidViewModelFactory = ViewModelProvider.AndroidViewModelFactory.getInstance(c(paramFragmentActivity));
    return new ViewModelProvider(ViewModelStores.of(paramFragmentActivity), localAndroidViewModelFactory);
  }
  
  public static ViewModelProvider of(FragmentActivity paramFragmentActivity, ViewModelProvider.Factory paramFactory)
  {
    c(paramFragmentActivity);
    return new ViewModelProvider(ViewModelStores.of(paramFragmentActivity), paramFactory);
  }
  
  @Deprecated
  public static class DefaultFactory
    extends ViewModelProvider.AndroidViewModelFactory
  {
    @Deprecated
    public DefaultFactory(Application paramApplication)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.arch.lifecycle.ViewModelProviders
 * JD-Core Version:    0.7.0.1
 */