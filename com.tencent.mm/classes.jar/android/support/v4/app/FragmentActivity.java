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
import android.support.v4.e.d;
import android.support.v4.e.o;
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
  extends SupportActivity
  implements ViewModelStoreOwner, a.a, a.c
{
  static final String ALLOCATED_REQUEST_INDICIES_TAG = "android:support:request_indicies";
  static final String FRAGMENTS_TAG = "android:support:fragments";
  static final int MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS = 65534;
  static final int MSG_RESUME_PENDING = 2;
  static final String NEXT_CANDIDATE_REQUEST_INDEX_TAG = "android:support:next_request_index";
  static final String REQUEST_FRAGMENT_WHO_TAG = "android:support:request_fragment_who";
  private static final String TAG = "FragmentActivity";
  boolean mCreated;
  final e mFragments = new e(new a());
  final Handler mHandler = new Handler()
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
        super.handleMessage(paramAnonymousMessage);
        return;
      }
      FragmentActivity.this.onResumeFragments();
      FragmentActivity.this.mFragments.execPendingActions();
    }
  };
  int mNextCandidateRequestIndex;
  o<String> mPendingFragmentActivityResults;
  boolean mRequestedPermissionsFromFragment;
  boolean mResumed;
  boolean mStartedActivityFromFragment;
  boolean mStartedIntentSenderFromFragment;
  boolean mStopped = true;
  private ViewModelStore mViewModelStore;
  
  private int allocateRequestIndex(Fragment paramFragment)
  {
    if (this.mPendingFragmentActivityResults.size() >= 65534) {
      throw new IllegalStateException("Too many pending Fragment activity results.");
    }
    for (;;)
    {
      o localo = this.mPendingFragmentActivityResults;
      i = this.mNextCandidateRequestIndex;
      if (localo.LT) {
        localo.gc();
      }
      if (d.b(localo.Mi, localo.mSize, i) < 0) {
        break;
      }
      this.mNextCandidateRequestIndex = ((this.mNextCandidateRequestIndex + 1) % 65534);
    }
    int i = this.mNextCandidateRequestIndex;
    this.mPendingFragmentActivityResults.put(i, paramFragment.mWho);
    this.mNextCandidateRequestIndex = ((this.mNextCandidateRequestIndex + 1) % 65534);
    return i;
  }
  
  static void checkForValidRequestCode(int paramInt)
  {
    if ((0xFFFF0000 & paramInt) != 0) {
      throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
    }
  }
  
  private void markFragmentsCreated()
  {
    while (markState(getSupportFragmentManager(), Lifecycle.State.CREATED)) {}
  }
  
  private static boolean markState(g paramg, Lifecycle.State paramState)
  {
    paramg = paramg.getFragments().iterator();
    boolean bool = false;
    while (paramg.hasNext())
    {
      Object localObject = (Fragment)paramg.next();
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
        bool = markState((g)localObject, paramState) | bool;
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
    paramPrintWriter.print(" mResumed=");
    paramPrintWriter.print(this.mResumed);
    paramPrintWriter.print(" mStopped=");
    paramPrintWriter.print(this.mStopped);
    if (getApplication() != null) {
      p.d(this).dump(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
    this.mFragments.mHost.mFragmentManager.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
  }
  
  public Object getLastCustomNonConfigurationInstance()
  {
    b localb = (b)getLastNonConfigurationInstance();
    if (localb != null) {
      return localb.CD;
    }
    return null;
  }
  
  public Lifecycle getLifecycle()
  {
    return super.getLifecycle();
  }
  
  public g getSupportFragmentManager()
  {
    return this.mFragments.mHost.mFragmentManager;
  }
  
  @Deprecated
  public p getSupportLoaderManager()
  {
    return p.d(this);
  }
  
  public ViewModelStore getViewModelStore()
  {
    if (getApplication() == null) {
      throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }
    if (this.mViewModelStore == null)
    {
      b localb = (b)getLastNonConfigurationInstance();
      if (localb != null) {
        this.mViewModelStore = localb.CE;
      }
      if (this.mViewModelStore == null) {
        this.mViewModelStore = new ViewModelStore();
      }
    }
    return this.mViewModelStore;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.mFragments.noteStateNotSaved();
    int i = paramInt1 >> 16;
    Object localObject;
    if (i != 0)
    {
      i -= 1;
      localObject = (String)this.mPendingFragmentActivityResults.get(i, null);
      this.mPendingFragmentActivityResults.delete(i);
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
      localObject = a.dv();
    } while ((localObject != null) && (((a.b)localObject).dx()));
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onAttachFragment(Fragment paramFragment) {}
  
  public void onBackPressed()
  {
    FragmentManagerImpl localFragmentManagerImpl = this.mFragments.mHost.mFragmentManager;
    boolean bool = localFragmentManagerImpl.isStateSaved();
    if ((bool) && (Build.VERSION.SDK_INT <= 25)) {}
    while ((!bool) && (localFragmentManagerImpl.popBackStackImmediate())) {
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
    ((e)localObject).mHost.mFragmentManager.attachController(((e)localObject).mHost, ((e)localObject).mHost, null);
    super.onCreate(paramBundle);
    localObject = (b)getLastNonConfigurationInstance();
    if ((localObject != null) && (((b)localObject).CE != null) && (this.mViewModelStore == null)) {
      this.mViewModelStore = ((b)localObject).CE;
    }
    if (paramBundle != null)
    {
      Parcelable localParcelable = paramBundle.getParcelable("android:support:fragments");
      e locale = this.mFragments;
      if (localObject == null) {
        break label189;
      }
      localObject = ((b)localObject).CF;
      locale.mHost.mFragmentManager.restoreAllState(localParcelable, (h)localObject);
      if (paramBundle.containsKey("android:support:next_request_index"))
      {
        this.mNextCandidateRequestIndex = paramBundle.getInt("android:support:next_request_index");
        localObject = paramBundle.getIntArray("android:support:request_indicies");
        paramBundle = paramBundle.getStringArray("android:support:request_fragment_who");
        if ((localObject != null) && (paramBundle != null) && (localObject.length == paramBundle.length)) {
          break label194;
        }
      }
    }
    for (;;)
    {
      if (this.mPendingFragmentActivityResults == null)
      {
        this.mPendingFragmentActivityResults = new o();
        this.mNextCandidateRequestIndex = 0;
      }
      this.mFragments.mHost.mFragmentManager.dispatchCreate();
      return;
      label189:
      localObject = null;
      break;
      label194:
      this.mPendingFragmentActivityResults = new o(localObject.length);
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
      e locale = this.mFragments;
      MenuInflater localMenuInflater = getMenuInflater();
      return bool | locale.mHost.mFragmentManager.dispatchCreateOptionsMenu(paramMenu, localMenuInflater);
    }
    return super.onCreatePanelMenu(paramInt, paramMenu);
  }
  
  public View onCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    View localView2 = dispatchFragmentsOnCreateView(paramView, paramString, paramContext, paramAttributeSet);
    View localView1 = localView2;
    if (localView2 == null) {
      localView1 = super.onCreateView(paramView, paramString, paramContext, paramAttributeSet);
    }
    return localView1;
  }
  
  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    View localView2 = dispatchFragmentsOnCreateView(null, paramString, paramContext, paramAttributeSet);
    View localView1 = localView2;
    if (localView2 == null) {
      localView1 = super.onCreateView(paramString, paramContext, paramAttributeSet);
    }
    return localView1;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((this.mViewModelStore != null) && (!isChangingConfigurations())) {
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
    this.mFragments.mHost.mFragmentManager.dispatchPause();
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
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.mFragments.noteStateNotSaved();
    int i = paramInt >> 16 & 0xFFFF;
    Object localObject;
    if (i != 0)
    {
      i -= 1;
      localObject = (String)this.mPendingFragmentActivityResults.get(i, null);
      this.mPendingFragmentActivityResults.delete(i);
      if (localObject != null) {
        break label58;
      }
    }
    label58:
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
    Object localObject = onRetainCustomNonConfigurationInstance();
    h localh = this.mFragments.mHost.mFragmentManager.retainNonConfig();
    if ((localh == null) && (this.mViewModelStore == null) && (localObject == null)) {
      return null;
    }
    b localb = new b();
    localb.CD = localObject;
    localb.CE = this.mViewModelStore;
    localb.CF = localh;
    return localb;
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
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
  
  protected void onStart()
  {
    super.onStart();
    this.mStopped = false;
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
  
  public void setEnterSharedElementCallback(z paramz)
  {
    a.a(this, paramz);
  }
  
  public void setExitSharedElementCallback(z paramz)
  {
    a.b(this, paramz);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    if ((!this.mStartedActivityFromFragment) && (paramInt != -1)) {
      checkForValidRequestCode(paramInt);
    }
    super.startActivityForResult(paramIntent, paramInt);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    if ((!this.mStartedActivityFromFragment) && (paramInt != -1)) {
      checkForValidRequestCode(paramInt);
    }
    super.startActivityForResult(paramIntent, paramInt, paramBundle);
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
  
  public void startIntentSenderForResult(IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((!this.mStartedIntentSenderFromFragment) && (paramInt1 != -1)) {
      checkForValidRequestCode(paramInt1);
    }
    super.startIntentSenderForResult(paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4);
  }
  
  public void startIntentSenderForResult(IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4, Bundle paramBundle)
  {
    if ((!this.mStartedIntentSenderFromFragment) && (paramInt1 != -1)) {
      checkForValidRequestCode(paramInt1);
    }
    super.startIntentSenderForResult(paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
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
    a.e(this);
  }
  
  @Deprecated
  public void supportInvalidateOptionsMenu()
  {
    invalidateOptionsMenu();
  }
  
  public void supportPostponeEnterTransition()
  {
    a.f(this);
  }
  
  public void supportStartPostponedEnterTransition()
  {
    a.g(this);
  }
  
  public final void validateRequestPermissionsRequestCode(int paramInt)
  {
    if ((!this.mRequestedPermissionsFromFragment) && (paramInt != -1)) {
      checkForValidRequestCode(paramInt);
    }
  }
  
  final class a
    extends f<FragmentActivity>
  {
    public a()
    {
      super();
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
    
    public final boolean dE()
    {
      return !FragmentActivity.this.isFinishing();
    }
    
    public final void dF()
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
    
    public final boolean q(String paramString)
    {
      return a.a(FragmentActivity.this, paramString);
    }
  }
  
  static final class b
  {
    Object CD;
    ViewModelStore CE;
    h CF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.app.FragmentActivity
 * JD-Core Version:    0.7.0.1
 */