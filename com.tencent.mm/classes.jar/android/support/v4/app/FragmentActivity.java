package android.support.v4.app;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.Lifecycle.State;
import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.ViewModelStore;
import android.arch.lifecycle.ViewModelStoreOwner;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.support.v4.f.c;
import android.support.v4.f.n;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;

public class FragmentActivity
  extends d
  implements ViewModelStoreOwner, a.a, a.c
{
  static final String ALLOCATED_REQUEST_INDICIES_TAG = "android:support:request_indicies";
  static final String FRAGMENTS_TAG = "android:support:fragments";
  static final int MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS = 65534;
  static final int MSG_REALLY_STOPPED = 1;
  static final int MSG_RESUME_PENDING = 2;
  static final String NEXT_CANDIDATE_REQUEST_INDEX_TAG = "android:support:next_request_index";
  static final String REQUEST_FRAGMENT_WHO_TAG = "android:support:request_fragment_who";
  private static final String TAG = "FragmentActivity";
  boolean mCreated;
  final h mFragments = new h(new a());
  final Handler mHandler = new Handler()
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
        super.handleMessage(paramAnonymousMessage);
      case 1: 
        do
        {
          return;
        } while (!FragmentActivity.this.mStopped);
        FragmentActivity.this.doReallyStop(false);
        return;
      }
      FragmentActivity.this.onResumeFragments();
      FragmentActivity.this.mFragments.execPendingActions();
    }
  };
  t mLoaderManager;
  int mNextCandidateRequestIndex;
  n<String> mPendingFragmentActivityResults;
  boolean mReallyStopped = true;
  boolean mRequestedPermissionsFromFragment;
  boolean mResumed;
  boolean mRetaining;
  boolean mStopped = true;
  private ViewModelStore mViewModelStore;
  
  private int allocateRequestIndex(Fragment paramFragment)
  {
    if (this.mPendingFragmentActivityResults.size() >= 65534) {
      throw new IllegalStateException("Too many pending Fragment activity results.");
    }
    for (;;)
    {
      n localn = this.mPendingFragmentActivityResults;
      i = this.mNextCandidateRequestIndex;
      if (localn.Ef) {
        localn.gc();
      }
      if (c.a(localn.Ew, localn.mSize, i) < 0) {
        break;
      }
      this.mNextCandidateRequestIndex = ((this.mNextCandidateRequestIndex + 1) % 65534);
    }
    int i = this.mNextCandidateRequestIndex;
    this.mPendingFragmentActivityResults.put(i, paramFragment.mWho);
    this.mNextCandidateRequestIndex = ((this.mNextCandidateRequestIndex + 1) % 65534);
    return i;
  }
  
  private void markFragmentsCreated()
  {
    while (markState(getSupportFragmentManager(), Lifecycle.State.CREATED)) {}
  }
  
  private static boolean markState(j paramj, Lifecycle.State paramState)
  {
    paramj = paramj.getFragments().iterator();
    boolean bool = false;
    while (paramj.hasNext())
    {
      Object localObject = (Fragment)paramj.next();
      if (localObject != null)
      {
        if (((Fragment)localObject).getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED))
        {
          ((Fragment)localObject).mLifecycleRegistry.markState(paramState);
          bool = true;
        }
        localObject = ((Fragment)localObject).peekChildFragmentManager();
        if (localObject == null) {
          break label83;
        }
        bool = markState((j)localObject, paramState) | bool;
      }
    }
    label83:
    for (;;)
    {
      break;
      return bool;
    }
  }
  
  final View dispatchFragmentsOnCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return this.mFragments.mHost.mFragmentManager.onCreateView(paramView, paramString, paramContext, paramAttributeSet);
  }
  
  void doReallyStop(boolean paramBoolean)
  {
    if (!this.mReallyStopped)
    {
      this.mReallyStopped = true;
      this.mRetaining = paramBoolean;
      this.mHandler.removeMessages(1);
      onReallyStop();
    }
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    super.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("Local FragmentActivity ");
    paramPrintWriter.print(Integer.toHexString(System.identityHashCode(this)));
    paramPrintWriter.println(" State:");
    String str = paramString + "  ";
    paramPrintWriter.print(str);
    paramPrintWriter.print("mCreated=");
    paramPrintWriter.print(this.mCreated);
    paramPrintWriter.print("mResumed=");
    paramPrintWriter.print(this.mResumed);
    paramPrintWriter.print(" mStopped=");
    paramPrintWriter.print(this.mStopped);
    paramPrintWriter.print(" mReallyStopped=");
    paramPrintWriter.println(this.mReallyStopped);
    if (this.mLoaderManager != null) {
      this.mLoaderManager.dump(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
    this.mFragments.mHost.mFragmentManager.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
  }
  
  public Object getLastCustomNonConfigurationInstance()
  {
    b localb = (b)getLastNonConfigurationInstance();
    if (localb != null) {
      return localb.vj;
    }
    return null;
  }
  
  public Lifecycle getLifecycle()
  {
    return super.getLifecycle();
  }
  
  public j getSupportFragmentManager()
  {
    return this.mFragments.mHost.mFragmentManager;
  }
  
  public t getSupportLoaderManager()
  {
    if (this.mLoaderManager != null) {
      return this.mLoaderManager;
    }
    this.mLoaderManager = new u(this, getViewModelStore());
    return this.mLoaderManager;
  }
  
  public ViewModelStore getViewModelStore()
  {
    if (getApplication() == null) {
      throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }
    if (this.mViewModelStore == null) {
      this.mViewModelStore = new ViewModelStore();
    }
    return this.mViewModelStore;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.mFragments.noteStateNotSaved();
    int i = paramInt1 >> 16;
    Object localObject;
    if (i != 0)
    {
      i -= 1;
      localObject = (String)this.mPendingFragmentActivityResults.get(i);
      this.mPendingFragmentActivityResults.remove(i);
      if (localObject != null) {}
    }
    do
    {
      do
      {
        return;
        localObject = this.mFragments.findFragmentByWho((String)localObject);
      } while (localObject == null);
      ((Fragment)localObject).onActivityResult(0xFFFF & paramInt1, paramInt2, paramIntent);
      return;
      localObject = a.bF();
    } while ((localObject != null) && (((a.b)localObject).bH()));
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onAttachFragment(Fragment paramFragment) {}
  
  public void onBackPressed()
  {
    k localk = this.mFragments.mHost.mFragmentManager;
    boolean bool = localk.isStateSaved();
    if ((bool) && (Build.VERSION.SDK_INT <= 25)) {}
    while ((!bool) && (localk.popBackStackImmediate())) {
      return;
    }
    super.onBackPressed();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.mFragments.noteStateNotSaved();
    this.mFragments.mHost.mFragmentManager.dispatchConfigurationChanged(paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Object localObject = this.mFragments;
    ((h)localObject).mHost.mFragmentManager.a(((h)localObject).mHost, ((h)localObject).mHost, null);
    super.onCreate(paramBundle);
    localObject = (b)getLastNonConfigurationInstance();
    if (localObject != null) {
      this.mViewModelStore = ((b)localObject).vk;
    }
    if (paramBundle != null)
    {
      Parcelable localParcelable = paramBundle.getParcelable("android:support:fragments");
      h localh = this.mFragments;
      if (localObject == null) {
        break label175;
      }
      localObject = ((b)localObject).vl;
      localh.mHost.mFragmentManager.a(localParcelable, (l)localObject);
      if (paramBundle.containsKey("android:support:next_request_index"))
      {
        this.mNextCandidateRequestIndex = paramBundle.getInt("android:support:next_request_index");
        localObject = paramBundle.getIntArray("android:support:request_indicies");
        paramBundle = paramBundle.getStringArray("android:support:request_fragment_who");
        if ((localObject != null) && (paramBundle != null) && (localObject.length == paramBundle.length)) {
          break label180;
        }
      }
    }
    for (;;)
    {
      if (this.mPendingFragmentActivityResults == null)
      {
        this.mPendingFragmentActivityResults = new n();
        this.mNextCandidateRequestIndex = 0;
      }
      this.mFragments.mHost.mFragmentManager.dispatchCreate();
      return;
      label175:
      localObject = null;
      break;
      label180:
      this.mPendingFragmentActivityResults = new n(localObject.length);
      int i = 0;
      while (i < localObject.length)
      {
        this.mPendingFragmentActivityResults.put(localObject[i], paramBundle[i]);
        i += 1;
      }
    }
  }
  
  public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
  {
    if (paramInt == 0)
    {
      boolean bool = super.onCreatePanelMenu(paramInt, paramMenu);
      h localh = this.mFragments;
      MenuInflater localMenuInflater = getMenuInflater();
      return bool | localh.mHost.mFragmentManager.dispatchCreateOptionsMenu(paramMenu, localMenuInflater);
    }
    return super.onCreatePanelMenu(paramInt, paramMenu);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    doReallyStop(false);
    if ((this.mViewModelStore != null) && (!this.mRetaining)) {
      this.mViewModelStore.clear();
    }
    this.mFragments.mHost.mFragmentManager.dispatchDestroy();
  }
  
  public void onLowMemory()
  {
    super.onLowMemory();
    this.mFragments.mHost.mFragmentManager.dispatchLowMemory();
  }
  
  public boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    if (super.onMenuItemSelected(paramInt, paramMenuItem)) {
      return true;
    }
    switch (paramInt)
    {
    default: 
      return false;
    case 0: 
      return this.mFragments.mHost.mFragmentManager.dispatchOptionsItemSelected(paramMenuItem);
    }
    return this.mFragments.mHost.mFragmentManager.dispatchContextItemSelected(paramMenuItem);
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    this.mFragments.mHost.mFragmentManager.dispatchMultiWindowModeChanged(paramBoolean);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    this.mFragments.noteStateNotSaved();
  }
  
  public void onPanelClosed(int paramInt, Menu paramMenu)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      super.onPanelClosed(paramInt, paramMenu);
      return;
      this.mFragments.mHost.mFragmentManager.dispatchOptionsMenuClosed(paramMenu);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    this.mResumed = false;
    if (this.mHandler.hasMessages(2))
    {
      this.mHandler.removeMessages(2);
      onResumeFragments();
    }
    this.mFragments.mHost.mFragmentManager.ac(4);
  }
  
  public void onPictureInPictureModeChanged(boolean paramBoolean)
  {
    this.mFragments.mHost.mFragmentManager.dispatchPictureInPictureModeChanged(paramBoolean);
  }
  
  public void onPostResume()
  {
    super.onPostResume();
    this.mHandler.removeMessages(2);
    onResumeFragments();
    this.mFragments.execPendingActions();
  }
  
  protected boolean onPrepareOptionsPanel(View paramView, Menu paramMenu)
  {
    return super.onPreparePanel(0, paramView, paramMenu);
  }
  
  public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
  {
    if ((paramInt == 0) && (paramMenu != null)) {
      return onPrepareOptionsPanel(paramView, paramMenu) | this.mFragments.mHost.mFragmentManager.dispatchPrepareOptionsMenu(paramMenu);
    }
    return super.onPreparePanel(paramInt, paramView, paramMenu);
  }
  
  void onReallyStop()
  {
    this.mFragments.mHost.mFragmentManager.ac(2);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.mFragments.noteStateNotSaved();
    int i = paramInt >> 16 & 0xFFFF;
    Object localObject;
    if (i != 0)
    {
      i -= 1;
      localObject = (String)this.mPendingFragmentActivityResults.get(i);
      this.mPendingFragmentActivityResults.remove(i);
      if (localObject != null) {
        break label57;
      }
    }
    label57:
    do
    {
      return;
      localObject = this.mFragments.findFragmentByWho((String)localObject);
    } while (localObject == null);
    ((Fragment)localObject).onRequestPermissionsResult(paramInt & 0xFFFF, paramArrayOfString, paramArrayOfInt);
  }
  
  public void onResume()
  {
    super.onResume();
    this.mHandler.sendEmptyMessage(2);
    this.mResumed = true;
    this.mFragments.execPendingActions();
  }
  
  protected void onResumeFragments()
  {
    this.mFragments.mHost.mFragmentManager.dispatchResume();
  }
  
  public Object onRetainCustomNonConfigurationInstance()
  {
    return null;
  }
  
  public final Object onRetainNonConfigurationInstance()
  {
    if (this.mStopped) {
      doReallyStop(true);
    }
    Object localObject1 = onRetainCustomNonConfigurationInstance();
    Object localObject2 = this.mFragments.mHost.mFragmentManager;
    k.a(((k)localObject2).vO);
    localObject2 = ((k)localObject2).vO;
    if ((localObject2 == null) && (this.mViewModelStore == null) && (localObject1 == null)) {
      return null;
    }
    b localb = new b();
    localb.vj = localObject1;
    localb.vk = this.mViewModelStore;
    localb.vl = ((l)localObject2);
    return localb;
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    markFragmentsCreated();
    Object localObject = this.mFragments.mHost.mFragmentManager.saveAllState();
    if (localObject != null) {
      paramBundle.putParcelable("android:support:fragments", (Parcelable)localObject);
    }
    if (this.mPendingFragmentActivityResults.size() > 0)
    {
      paramBundle.putInt("android:support:next_request_index", this.mNextCandidateRequestIndex);
      localObject = new int[this.mPendingFragmentActivityResults.size()];
      String[] arrayOfString = new String[this.mPendingFragmentActivityResults.size()];
      int i = 0;
      while (i < this.mPendingFragmentActivityResults.size())
      {
        localObject[i] = this.mPendingFragmentActivityResults.keyAt(i);
        arrayOfString[i] = ((String)this.mPendingFragmentActivityResults.valueAt(i));
        i += 1;
      }
      paramBundle.putIntArray("android:support:request_indicies", (int[])localObject);
      paramBundle.putStringArray("android:support:request_fragment_who", arrayOfString);
    }
  }
  
  public void onStart()
  {
    super.onStart();
    this.mStopped = false;
    this.mReallyStopped = false;
    this.mHandler.removeMessages(1);
    if (!this.mCreated)
    {
      this.mCreated = true;
      this.mFragments.mHost.mFragmentManager.dispatchActivityCreated();
    }
    this.mFragments.noteStateNotSaved();
    this.mFragments.execPendingActions();
    this.mFragments.mHost.mFragmentManager.dispatchStart();
  }
  
  public void onStateNotSaved()
  {
    this.mFragments.noteStateNotSaved();
  }
  
  public void onStop()
  {
    super.onStop();
    this.mStopped = true;
    markFragmentsCreated();
    this.mHandler.sendEmptyMessage(1);
    this.mFragments.mHost.mFragmentManager.dispatchStop();
  }
  
  void requestPermissionsFromFragment(Fragment paramFragment, String[] paramArrayOfString, int paramInt)
  {
    if (paramInt == -1)
    {
      a.a(this, paramArrayOfString, paramInt);
      return;
    }
    checkForValidRequestCode(paramInt);
    try
    {
      this.mRequestedPermissionsFromFragment = true;
      a.a(this, paramArrayOfString, (allocateRequestIndex(paramFragment) + 1 << 16) + (0xFFFF & paramInt));
      return;
    }
    finally
    {
      this.mRequestedPermissionsFromFragment = false;
    }
  }
  
  public void setEnterSharedElementCallback(ad paramad)
  {
    a.a(this, paramad);
  }
  
  public void setExitSharedElementCallback(ad paramad)
  {
    a.b(this, paramad);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    if ((!this.mStartedActivityFromFragment) && (paramInt != -1)) {
      checkForValidRequestCode(paramInt);
    }
    super.startActivityForResult(paramIntent, paramInt);
  }
  
  public void startActivityFromFragment(Fragment paramFragment, Intent paramIntent, int paramInt)
  {
    startActivityFromFragment(paramFragment, paramIntent, paramInt, null);
  }
  
  public void startActivityFromFragment(Fragment paramFragment, Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    this.mStartedActivityFromFragment = true;
    if (paramInt == -1) {}
    try
    {
      a.a(this, paramIntent, -1, paramBundle);
      return;
    }
    finally
    {
      this.mStartedActivityFromFragment = false;
    }
    checkForValidRequestCode(paramInt);
    a.a(this, paramIntent, (allocateRequestIndex(paramFragment) + 1 << 16) + (0xFFFF & paramInt), paramBundle);
    this.mStartedActivityFromFragment = false;
  }
  
  public void startIntentSenderFromFragment(Fragment paramFragment, IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4, Bundle paramBundle)
  {
    this.mStartedIntentSenderFromFragment = true;
    if (paramInt1 == -1) {}
    try
    {
      a.a(this, paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
      return;
    }
    finally
    {
      this.mStartedIntentSenderFromFragment = false;
    }
    checkForValidRequestCode(paramInt1);
    a.a(this, paramIntentSender, (allocateRequestIndex(paramFragment) + 1 << 16) + (0xFFFF & paramInt1), paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
    this.mStartedIntentSenderFromFragment = false;
  }
  
  public void supportFinishAfterTransition()
  {
    a.c(this);
  }
  
  @Deprecated
  public void supportInvalidateOptionsMenu()
  {
    invalidateOptionsMenu();
  }
  
  public void supportPostponeEnterTransition()
  {
    a.d(this);
  }
  
  public void supportStartPostponedEnterTransition()
  {
    a.e(this);
  }
  
  public final void validateRequestPermissionsRequestCode(int paramInt)
  {
    if ((!this.mRequestedPermissionsFromFragment) && (paramInt != -1)) {
      checkForValidRequestCode(paramInt);
    }
  }
  
  final class a
    extends i<FragmentActivity>
  {
    public a()
    {
      super();
    }
    
    public final boolean F(String paramString)
    {
      return a.a(FragmentActivity.this, paramString);
    }
    
    public final void a(Fragment paramFragment, Intent paramIntent, int paramInt, Bundle paramBundle)
    {
      FragmentActivity.this.startActivityFromFragment(paramFragment, paramIntent, paramInt, paramBundle);
    }
    
    public final void a(Fragment paramFragment, IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4, Bundle paramBundle)
    {
      FragmentActivity.this.startIntentSenderFromFragment(paramFragment, paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
    }
    
    public final void a(Fragment paramFragment, String[] paramArrayOfString, int paramInt)
    {
      FragmentActivity.this.requestPermissionsFromFragment(paramFragment, paramArrayOfString, paramInt);
    }
    
    public final void a(String paramString, PrintWriter paramPrintWriter, String[] paramArrayOfString)
    {
      FragmentActivity.this.dump(paramString, null, paramPrintWriter, paramArrayOfString);
    }
    
    public final boolean bN()
    {
      return !FragmentActivity.this.isFinishing();
    }
    
    public final void bO()
    {
      FragmentActivity.this.supportInvalidateOptionsMenu();
    }
    
    public final void onAttachFragment(Fragment paramFragment)
    {
      FragmentActivity.this.onAttachFragment(paramFragment);
    }
    
    public final View onFindViewById(int paramInt)
    {
      return FragmentActivity.this.findViewById(paramInt);
    }
    
    public final LayoutInflater onGetLayoutInflater()
    {
      return FragmentActivity.this.getLayoutInflater().cloneInContext(FragmentActivity.this);
    }
    
    public final int onGetWindowAnimations()
    {
      Window localWindow = FragmentActivity.this.getWindow();
      if (localWindow == null) {
        return 0;
      }
      return localWindow.getAttributes().windowAnimations;
    }
    
    public final boolean onHasView()
    {
      Window localWindow = FragmentActivity.this.getWindow();
      return (localWindow != null) && (localWindow.peekDecorView() != null);
    }
    
    public final boolean onHasWindowAnimations()
    {
      return FragmentActivity.this.getWindow() != null;
    }
  }
  
  static final class b
  {
    Object vj;
    ViewModelStore vk;
    l vl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.app.FragmentActivity
 * JD-Core Version:    0.7.0.1
 */