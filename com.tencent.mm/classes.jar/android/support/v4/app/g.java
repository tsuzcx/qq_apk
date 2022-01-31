package android.support.v4.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

public abstract class g
{
  public static final int POP_BACK_STACK_INCLUSIVE = 1;
  
  public static void enableDebugLogging(boolean paramBoolean)
  {
    FragmentManagerImpl.DEBUG = paramBoolean;
  }
  
  public abstract void addOnBackStackChangedListener(c paramc);
  
  public abstract k beginTransaction();
  
  public abstract void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString);
  
  public abstract boolean executePendingTransactions();
  
  public abstract Fragment findFragmentById(int paramInt);
  
  public abstract Fragment findFragmentByTag(String paramString);
  
  public abstract a getBackStackEntryAt(int paramInt);
  
  public abstract int getBackStackEntryCount();
  
  public abstract Fragment getFragment(Bundle paramBundle, String paramString);
  
  public abstract List<Fragment> getFragments();
  
  public abstract Fragment getPrimaryNavigationFragment();
  
  public abstract boolean isDestroyed();
  
  public abstract boolean isStateSaved();
  
  @Deprecated
  public k openTransaction()
  {
    return beginTransaction();
  }
  
  public abstract void popBackStack();
  
  public abstract void popBackStack(int paramInt1, int paramInt2);
  
  public abstract void popBackStack(String paramString, int paramInt);
  
  public abstract boolean popBackStackImmediate();
  
  public abstract boolean popBackStackImmediate(int paramInt1, int paramInt2);
  
  public abstract boolean popBackStackImmediate(String paramString, int paramInt);
  
  public abstract void putFragment(Bundle paramBundle, String paramString, Fragment paramFragment);
  
  public abstract void registerFragmentLifecycleCallbacks(b paramb, boolean paramBoolean);
  
  public abstract void removeOnBackStackChangedListener(c paramc);
  
  public abstract Fragment.SavedState saveFragmentInstanceState(Fragment paramFragment);
  
  public abstract void unregisterFragmentLifecycleCallbacks(b paramb);
  
  public static abstract interface a {}
  
  public static abstract class b
  {
    public void onFragmentActivityCreated(g paramg, Fragment paramFragment, Bundle paramBundle) {}
    
    public void onFragmentAttached(g paramg, Fragment paramFragment, Context paramContext) {}
    
    public void onFragmentCreated(g paramg, Fragment paramFragment, Bundle paramBundle) {}
    
    public void onFragmentDestroyed(g paramg, Fragment paramFragment) {}
    
    public void onFragmentDetached(g paramg, Fragment paramFragment) {}
    
    public void onFragmentPaused(g paramg, Fragment paramFragment) {}
    
    public void onFragmentPreAttached(g paramg, Fragment paramFragment, Context paramContext) {}
    
    public void onFragmentPreCreated(g paramg, Fragment paramFragment, Bundle paramBundle) {}
    
    public void onFragmentResumed(g paramg, Fragment paramFragment) {}
    
    public void onFragmentSaveInstanceState(g paramg, Fragment paramFragment, Bundle paramBundle) {}
    
    public void onFragmentStarted(g paramg, Fragment paramFragment) {}
    
    public void onFragmentStopped(g paramg, Fragment paramFragment) {}
    
    public void onFragmentViewCreated(g paramg, Fragment paramFragment, View paramView, Bundle paramBundle) {}
    
    public void onFragmentViewDestroyed(g paramg, Fragment paramFragment) {}
  }
  
  public static abstract interface c {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.app.g
 * JD-Core Version:    0.7.0.1
 */