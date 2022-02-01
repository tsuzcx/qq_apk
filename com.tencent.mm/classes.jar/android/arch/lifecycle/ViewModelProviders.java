package android.arch.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

public class ViewModelProviders
{
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
    return of(paramFragment, null);
  }
  
  public static ViewModelProvider of(Fragment paramFragment, ViewModelProvider.Factory paramFactory)
  {
    Object localObject = paramFragment.getActivity();
    if (localObject == null) {
      throw new IllegalStateException("Can't create ViewModelProvider for detached fragment");
    }
    Application localApplication = c((Activity)localObject);
    localObject = paramFactory;
    if (paramFactory == null) {
      localObject = ViewModelProvider.AndroidViewModelFactory.getInstance(localApplication);
    }
    return new ViewModelProvider(ViewModelStores.of(paramFragment), (ViewModelProvider.Factory)localObject);
  }
  
  public static ViewModelProvider of(FragmentActivity paramFragmentActivity)
  {
    return of(paramFragmentActivity, null);
  }
  
  public static ViewModelProvider of(FragmentActivity paramFragmentActivity, ViewModelProvider.Factory paramFactory)
  {
    Application localApplication = c(paramFragmentActivity);
    Object localObject = paramFactory;
    if (paramFactory == null) {
      localObject = ViewModelProvider.AndroidViewModelFactory.getInstance(localApplication);
    }
    return new ViewModelProvider(ViewModelStores.of(paramFragmentActivity), (ViewModelProvider.Factory)localObject);
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