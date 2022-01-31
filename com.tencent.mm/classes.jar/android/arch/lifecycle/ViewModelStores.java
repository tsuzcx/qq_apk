package android.arch.lifecycle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

public class ViewModelStores
{
  public static ViewModelStore of(Fragment paramFragment)
  {
    if ((paramFragment instanceof ViewModelStoreOwner)) {
      return ((ViewModelStoreOwner)paramFragment).getViewModelStore();
    }
    return HolderFragment.holderFragmentFor(paramFragment).getViewModelStore();
  }
  
  public static ViewModelStore of(FragmentActivity paramFragmentActivity)
  {
    if ((paramFragmentActivity instanceof ViewModelStoreOwner)) {
      return ((ViewModelStoreOwner)paramFragmentActivity).getViewModelStore();
    }
    return HolderFragment.holderFragmentFor(paramFragmentActivity).getViewModelStore();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.arch.lifecycle.ViewModelStores
 * JD-Core Version:    0.7.0.1
 */