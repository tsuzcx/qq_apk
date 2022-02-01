package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import androidx.core.app.ComponentActivity;
import androidx.core.app.a.a;
import androidx.core.app.a.b;
import androidx.core.app.a.c;
import androidx.core.app.k;
import androidx.lifecycle.aa;
import androidx.lifecycle.ab;
import androidx.lifecycle.h.b;
import androidx.lifecycle.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;

public class FragmentActivity
  extends ComponentActivity
  implements a.a, a.c, ab
{
  static final String ALLOCATED_REQUEST_INDICIES_TAG = "android:support:request_indicies";
  static final String FRAGMENTS_TAG = "android:support:fragments";
  static final int MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS = 65534;
  static final int MSG_RESUME_PENDING = 2;
  static final String NEXT_CANDIDATE_REQUEST_INDEX_TAG = "android:support:next_request_index";
  static final String REQUEST_FRAGMENT_WHO_TAG = "android:support:request_fragment_who";
  private static final String TAG = "FragmentActivity";
  boolean mCreated;
  final c mFragments;
  final Handler mHandler;
  int mNextCandidateRequestIndex;
  androidx.b.h<String> mPendingFragmentActivityResults;
  boolean mRequestedPermissionsFromFragment;
  boolean mResumed;
  boolean mStartedActivityFromFragment;
  boolean mStartedIntentSenderFromFragment;
  boolean mStopped;
  private aa mViewModelStore;
  
  public FragmentActivity()
  {
    AppMethodBeat.i(212330);
    this.mHandler = new Handler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(212280);
        switch (paramAnonymousMessage.what)
        {
        default: 
          super.handleMessage(paramAnonymousMessage);
          AppMethodBeat.o(212280);
          return;
        }
        FragmentActivity.this.onResumeFragments();
        FragmentActivity.this.mFragments.execPendingActions();
        AppMethodBeat.o(212280);
      }
    };
    this.mFragments = c.a(new a());
    this.mStopped = true;
    AppMethodBeat.o(212330);
  }
  
  private int allocateRequestIndex(Fragment paramFragment)
  {
    AppMethodBeat.i(212422);
    if (this.mPendingFragmentActivityResults.size() >= 65534)
    {
      paramFragment = new IllegalStateException("Too many pending Fragment activity results.");
      AppMethodBeat.o(212422);
      throw paramFragment;
    }
    while (this.mPendingFragmentActivityResults.aQ(this.mNextCandidateRequestIndex) >= 0) {
      this.mNextCandidateRequestIndex = ((this.mNextCandidateRequestIndex + 1) % 65534);
    }
    int i = this.mNextCandidateRequestIndex;
    this.mPendingFragmentActivityResults.put(i, paramFragment.mWho);
    this.mNextCandidateRequestIndex = ((this.mNextCandidateRequestIndex + 1) % 65534);
    AppMethodBeat.o(212422);
    return i;
  }
  
  static void checkForValidRequestCode(int paramInt)
  {
    AppMethodBeat.i(212413);
    if ((0xFFFF0000 & paramInt) != 0)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Can only use lower 16 bits for requestCode");
      AppMethodBeat.o(212413);
      throw localIllegalArgumentException;
    }
    AppMethodBeat.o(212413);
  }
  
  private void markFragmentsCreated()
  {
    AppMethodBeat.i(212424);
    while (markState(getSupportFragmentManager(), h.b.ZQ)) {}
    AppMethodBeat.o(212424);
  }
  
  private static boolean markState(e parame, h.b paramb)
  {
    AppMethodBeat.i(212427);
    parame = parame.getFragments().iterator();
    boolean bool = false;
    while (parame.hasNext())
    {
      Object localObject = (Fragment)parame.next();
      if (localObject != null)
      {
        if (((Fragment)localObject).getLifecycle().jc().a(h.b.ZR))
        {
          ((Fragment)localObject).mLifecycleRegistry.c(paramb);
          bool = true;
        }
        localObject = ((Fragment)localObject).peekChildFragmentManager();
        if (localObject == null) {
          break label93;
        }
        bool = markState((e)localObject, paramb) | bool;
      }
    }
    label93:
    for (;;)
    {
      break;
      AppMethodBeat.o(212427);
      return bool;
    }
  }
  
  final View dispatchFragmentsOnCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(212363);
    paramView = this.mFragments.mHost.mFragmentManager.onCreateView(paramView, paramString, paramContext, paramAttributeSet);
    AppMethodBeat.o(212363);
    return paramView;
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    AppMethodBeat.i(212402);
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
      androidx.g.a.a.e(this).dump(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
    this.mFragments.mHost.mFragmentManager.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    AppMethodBeat.o(212402);
  }
  
  public Object getLastCustomNonConfigurationInstance()
  {
    AppMethodBeat.i(212398);
    Object localObject = (b)getLastNonConfigurationInstance();
    if (localObject != null)
    {
      localObject = ((b)localObject).VJ;
      AppMethodBeat.o(212398);
      return localObject;
    }
    AppMethodBeat.o(212398);
    return null;
  }
  
  public androidx.lifecycle.h getLifecycle()
  {
    AppMethodBeat.i(212349);
    androidx.lifecycle.h localh = super.getLifecycle();
    AppMethodBeat.o(212349);
    return localh;
  }
  
  public e getSupportFragmentManager()
  {
    return this.mFragments.mHost.mFragmentManager;
  }
  
  @Deprecated
  public androidx.g.a.a getSupportLoaderManager()
  {
    AppMethodBeat.i(212406);
    androidx.g.a.a locala = androidx.g.a.a.e(this);
    AppMethodBeat.o(212406);
    return locala;
  }
  
  public aa getViewModelStore()
  {
    AppMethodBeat.i(212347);
    if (getApplication() == null)
    {
      localObject = new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
      AppMethodBeat.o(212347);
      throw ((Throwable)localObject);
    }
    if (this.mViewModelStore == null)
    {
      localObject = (b)getLastNonConfigurationInstance();
      if (localObject != null) {
        this.mViewModelStore = ((b)localObject).VK;
      }
      if (this.mViewModelStore == null) {
        this.mViewModelStore = new aa();
      }
    }
    Object localObject = this.mViewModelStore;
    AppMethodBeat.o(212347);
    return localObject;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(212332);
    this.mFragments.noteStateNotSaved();
    int i = paramInt1 >> 16;
    if (i != 0)
    {
      i -= 1;
      localObject = (String)this.mPendingFragmentActivityResults.b(i, null);
      this.mPendingFragmentActivityResults.remove(i);
      if (localObject == null)
      {
        AppMethodBeat.o(212332);
        return;
      }
      localObject = this.mFragments.findFragmentByWho((String)localObject);
      if (localObject == null)
      {
        AppMethodBeat.o(212332);
        return;
      }
      ((Fragment)localObject).onActivityResult(0xFFFF & paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(212332);
      return;
    }
    Object localObject = androidx.core.app.a.gi();
    if ((localObject != null) && (((a.b)localObject).gk()))
    {
      AppMethodBeat.o(212332);
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(212332);
  }
  
  public void onAttachFragment(Fragment paramFragment) {}
  
  public void onBackPressed()
  {
    AppMethodBeat.i(212334);
    FragmentManagerImpl localFragmentManagerImpl = this.mFragments.mHost.mFragmentManager;
    boolean bool = localFragmentManagerImpl.isStateSaved();
    if ((bool) && (Build.VERSION.SDK_INT <= 25))
    {
      AppMethodBeat.o(212334);
      return;
    }
    if ((bool) || (!localFragmentManagerImpl.popBackStackImmediate())) {
      super.onBackPressed();
    }
    AppMethodBeat.o(212334);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(212346);
    super.onConfigurationChanged(paramConfiguration);
    this.mFragments.noteStateNotSaved();
    this.mFragments.mHost.mFragmentManager.dispatchConfigurationChanged(paramConfiguration);
    AppMethodBeat.o(212346);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(212352);
    Object localObject = this.mFragments;
    ((c)localObject).mHost.mFragmentManager.attachController(((c)localObject).mHost, ((c)localObject).mHost, null);
    super.onCreate(paramBundle);
    localObject = (b)getLastNonConfigurationInstance();
    if ((localObject != null) && (((b)localObject).VK != null) && (this.mViewModelStore == null)) {
      this.mViewModelStore = ((b)localObject).VK;
    }
    if (paramBundle != null)
    {
      Parcelable localParcelable = paramBundle.getParcelable("android:support:fragments");
      c localc = this.mFragments;
      if (localObject == null) {
        break label201;
      }
      localObject = ((b)localObject).VL;
      localc.mHost.mFragmentManager.restoreAllState(localParcelable, (f)localObject);
      if (paramBundle.containsKey("android:support:next_request_index"))
      {
        this.mNextCandidateRequestIndex = paramBundle.getInt("android:support:next_request_index");
        localObject = paramBundle.getIntArray("android:support:request_indicies");
        paramBundle = paramBundle.getStringArray("android:support:request_fragment_who");
        if ((localObject != null) && (paramBundle != null) && (localObject.length == paramBundle.length)) {
          break label206;
        }
      }
    }
    for (;;)
    {
      if (this.mPendingFragmentActivityResults == null)
      {
        this.mPendingFragmentActivityResults = new androidx.b.h();
        this.mNextCandidateRequestIndex = 0;
      }
      this.mFragments.mHost.mFragmentManager.dispatchCreate();
      AppMethodBeat.o(212352);
      return;
      label201:
      localObject = null;
      break;
      label206:
      this.mPendingFragmentActivityResults = new androidx.b.h(localObject.length);
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
    AppMethodBeat.i(212354);
    if (paramInt == 0)
    {
      bool1 = super.onCreatePanelMenu(paramInt, paramMenu);
      c localc = this.mFragments;
      MenuInflater localMenuInflater = getMenuInflater();
      boolean bool2 = localc.mHost.mFragmentManager.dispatchCreateOptionsMenu(paramMenu, localMenuInflater);
      AppMethodBeat.o(212354);
      return bool1 | bool2;
    }
    boolean bool1 = super.onCreatePanelMenu(paramInt, paramMenu);
    AppMethodBeat.o(212354);
    return bool1;
  }
  
  public View onCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(212356);
    View localView = dispatchFragmentsOnCreateView(paramView, paramString, paramContext, paramAttributeSet);
    if (localView == null)
    {
      paramView = super.onCreateView(paramView, paramString, paramContext, paramAttributeSet);
      AppMethodBeat.o(212356);
      return paramView;
    }
    AppMethodBeat.o(212356);
    return localView;
  }
  
  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(212359);
    View localView = dispatchFragmentsOnCreateView(null, paramString, paramContext, paramAttributeSet);
    if (localView == null)
    {
      paramString = super.onCreateView(paramString, paramContext, paramAttributeSet);
      AppMethodBeat.o(212359);
      return paramString;
    }
    AppMethodBeat.o(212359);
    return localView;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(212364);
    super.onDestroy();
    if ((this.mViewModelStore != null) && (!isChangingConfigurations())) {
      this.mViewModelStore.clear();
    }
    this.mFragments.mHost.mFragmentManager.dispatchDestroy();
    AppMethodBeat.o(212364);
  }
  
  public void onLowMemory()
  {
    AppMethodBeat.i(212365);
    super.onLowMemory();
    this.mFragments.mHost.mFragmentManager.dispatchLowMemory();
    AppMethodBeat.o(212365);
  }
  
  public boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(212368);
    if (super.onMenuItemSelected(paramInt, paramMenuItem))
    {
      AppMethodBeat.o(212368);
      return true;
    }
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(212368);
      return false;
    case 0: 
      bool = this.mFragments.mHost.mFragmentManager.dispatchOptionsItemSelected(paramMenuItem);
      AppMethodBeat.o(212368);
      return bool;
    }
    boolean bool = this.mFragments.mHost.mFragmentManager.dispatchContextItemSelected(paramMenuItem);
    AppMethodBeat.o(212368);
    return bool;
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(212344);
    this.mFragments.mHost.mFragmentManager.dispatchMultiWindowModeChanged(paramBoolean);
    AppMethodBeat.o(212344);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(212375);
    super.onNewIntent(paramIntent);
    this.mFragments.noteStateNotSaved();
    AppMethodBeat.o(212375);
  }
  
  public void onPanelClosed(int paramInt, Menu paramMenu)
  {
    AppMethodBeat.i(212371);
    switch (paramInt)
    {
    }
    for (;;)
    {
      super.onPanelClosed(paramInt, paramMenu);
      AppMethodBeat.o(212371);
      return;
      this.mFragments.mHost.mFragmentManager.dispatchOptionsMenuClosed(paramMenu);
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(212373);
    super.onPause();
    this.mResumed = false;
    if (this.mHandler.hasMessages(2))
    {
      this.mHandler.removeMessages(2);
      onResumeFragments();
    }
    this.mFragments.mHost.mFragmentManager.dispatchPause();
    AppMethodBeat.o(212373);
  }
  
  public void onPictureInPictureModeChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(212345);
    this.mFragments.mHost.mFragmentManager.dispatchPictureInPictureModeChanged(paramBoolean);
    AppMethodBeat.o(212345);
  }
  
  public void onPostResume()
  {
    AppMethodBeat.i(212381);
    super.onPostResume();
    this.mHandler.removeMessages(2);
    onResumeFragments();
    this.mFragments.execPendingActions();
    AppMethodBeat.o(212381);
  }
  
  protected boolean onPrepareOptionsPanel(View paramView, Menu paramMenu)
  {
    AppMethodBeat.i(212387);
    boolean bool = super.onPreparePanel(0, paramView, paramMenu);
    AppMethodBeat.o(212387);
    return bool;
  }
  
  public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
  {
    AppMethodBeat.i(212385);
    if ((paramInt == 0) && (paramMenu != null))
    {
      bool1 = onPrepareOptionsPanel(paramView, paramMenu);
      boolean bool2 = this.mFragments.mHost.mFragmentManager.dispatchPrepareOptionsMenu(paramMenu);
      AppMethodBeat.o(212385);
      return bool1 | bool2;
    }
    boolean bool1 = super.onPreparePanel(paramInt, paramView, paramMenu);
    AppMethodBeat.o(212385);
    return bool1;
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(212417);
    this.mFragments.noteStateNotSaved();
    int i = paramInt >> 16 & 0xFFFF;
    if (i != 0)
    {
      i -= 1;
      Object localObject = (String)this.mPendingFragmentActivityResults.b(i, null);
      this.mPendingFragmentActivityResults.remove(i);
      if (localObject == null)
      {
        AppMethodBeat.o(212417);
        return;
      }
      localObject = this.mFragments.findFragmentByWho((String)localObject);
      if (localObject == null)
      {
        AppMethodBeat.o(212417);
        return;
      }
      ((Fragment)localObject).onRequestPermissionsResult(paramInt & 0xFFFF, paramArrayOfString, paramArrayOfInt);
    }
    AppMethodBeat.o(212417);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(212379);
    super.onResume();
    this.mHandler.sendEmptyMessage(2);
    this.mResumed = true;
    this.mFragments.execPendingActions();
    AppMethodBeat.o(212379);
  }
  
  protected void onResumeFragments()
  {
    AppMethodBeat.i(212382);
    this.mFragments.mHost.mFragmentManager.dispatchResume();
    AppMethodBeat.o(212382);
  }
  
  public Object onRetainCustomNonConfigurationInstance()
  {
    return null;
  }
  
  public final Object onRetainNonConfigurationInstance()
  {
    AppMethodBeat.i(212389);
    Object localObject = onRetainCustomNonConfigurationInstance();
    f localf = this.mFragments.mHost.mFragmentManager.retainNonConfig();
    if ((localf == null) && (this.mViewModelStore == null) && (localObject == null))
    {
      AppMethodBeat.o(212389);
      return null;
    }
    b localb = new b();
    localb.VJ = localObject;
    localb.VK = this.mViewModelStore;
    localb.VL = localf;
    AppMethodBeat.o(212389);
    return localb;
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(212393);
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
        localObject[i] = this.mPendingFragmentActivityResults.aP(i);
        arrayOfString[i] = ((String)this.mPendingFragmentActivityResults.aM(i));
        i += 1;
      }
      paramBundle.putIntArray("android:support:request_indicies", (int[])localObject);
      paramBundle.putStringArray("android:support:request_fragment_who", arrayOfString);
    }
    AppMethodBeat.o(212393);
  }
  
  protected void onStart()
  {
    AppMethodBeat.i(212394);
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
    AppMethodBeat.o(212394);
  }
  
  public void onStateNotSaved()
  {
    AppMethodBeat.i(212377);
    this.mFragments.noteStateNotSaved();
    AppMethodBeat.o(212377);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(212396);
    super.onStop();
    this.mStopped = true;
    markFragmentsCreated();
    this.mFragments.mHost.mFragmentManager.dispatchStop();
    AppMethodBeat.o(212396);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  void requestPermissionsFromFragment(Fragment paramFragment, String[] paramArrayOfString, int paramInt)
  {
    AppMethodBeat.i(212423);
    if (paramInt == -1)
    {
      androidx.core.app.a.a(this, paramArrayOfString, paramInt);
      AppMethodBeat.o(212423);
      return;
    }
    checkForValidRequestCode(paramInt);
    try
    {
      this.mRequestedPermissionsFromFragment = true;
      androidx.core.app.a.a(this, paramArrayOfString, (allocateRequestIndex(paramFragment) + 1 << 16) + (0xFFFF & paramInt));
      return;
    }
    finally
    {
      this.mRequestedPermissionsFromFragment = false;
      AppMethodBeat.o(212423);
    }
  }
  
  public void setEnterSharedElementCallback(k paramk)
  {
    AppMethodBeat.i(212337);
    androidx.core.app.a.a(this, paramk);
    AppMethodBeat.o(212337);
  }
  
  public void setExitSharedElementCallback(k paramk)
  {
    AppMethodBeat.i(212338);
    androidx.core.app.a.b(this, paramk);
    AppMethodBeat.o(212338);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(212407);
    if ((!this.mStartedActivityFromFragment) && (paramInt != -1)) {
      checkForValidRequestCode(paramInt);
    }
    super.startActivityForResult(paramIntent, paramInt);
    AppMethodBeat.o(212407);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(212408);
    if ((!this.mStartedActivityFromFragment) && (paramInt != -1)) {
      checkForValidRequestCode(paramInt);
    }
    super.startActivityForResult(paramIntent, paramInt, paramBundle);
    AppMethodBeat.o(212408);
  }
  
  public void startActivityFromFragment(Fragment paramFragment, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(212418);
    startActivityFromFragment(paramFragment, paramIntent, paramInt, null);
    AppMethodBeat.o(212418);
  }
  
  public void startActivityFromFragment(Fragment paramFragment, Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(212419);
    this.mStartedActivityFromFragment = true;
    if (paramInt == -1) {}
    try
    {
      androidx.core.app.a.a(this, paramIntent, -1, paramBundle);
      return;
    }
    finally
    {
      this.mStartedActivityFromFragment = false;
      AppMethodBeat.o(212419);
    }
    checkForValidRequestCode(paramInt);
    androidx.core.app.a.a(this, paramIntent, (allocateRequestIndex(paramFragment) + 1 << 16) + (0xFFFF & paramInt), paramBundle);
    this.mStartedActivityFromFragment = false;
    AppMethodBeat.o(212419);
  }
  
  public void startIntentSenderForResult(IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(212409);
    if ((!this.mStartedIntentSenderFromFragment) && (paramInt1 != -1)) {
      checkForValidRequestCode(paramInt1);
    }
    super.startIntentSenderForResult(paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(212409);
  }
  
  public void startIntentSenderForResult(IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4, Bundle paramBundle)
  {
    AppMethodBeat.i(212410);
    if ((!this.mStartedIntentSenderFromFragment) && (paramInt1 != -1)) {
      checkForValidRequestCode(paramInt1);
    }
    super.startIntentSenderForResult(paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
    AppMethodBeat.o(212410);
  }
  
  public void startIntentSenderFromFragment(Fragment paramFragment, IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4, Bundle paramBundle)
  {
    AppMethodBeat.i(212421);
    this.mStartedIntentSenderFromFragment = true;
    if (paramInt1 == -1) {}
    try
    {
      androidx.core.app.a.a(this, paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
      return;
    }
    finally
    {
      this.mStartedIntentSenderFromFragment = false;
      AppMethodBeat.o(212421);
    }
    checkForValidRequestCode(paramInt1);
    androidx.core.app.a.a(this, paramIntentSender, (allocateRequestIndex(paramFragment) + 1 << 16) + (0xFFFF & paramInt1), paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
    this.mStartedIntentSenderFromFragment = false;
    AppMethodBeat.o(212421);
  }
  
  public void supportFinishAfterTransition()
  {
    AppMethodBeat.i(212335);
    androidx.core.app.a.c(this);
    AppMethodBeat.o(212335);
  }
  
  @Deprecated
  public void supportInvalidateOptionsMenu()
  {
    AppMethodBeat.i(212400);
    invalidateOptionsMenu();
    AppMethodBeat.o(212400);
  }
  
  public void supportPostponeEnterTransition()
  {
    AppMethodBeat.i(212341);
    androidx.core.app.a.d(this);
    AppMethodBeat.o(212341);
  }
  
  public void supportStartPostponedEnterTransition()
  {
    AppMethodBeat.i(212342);
    androidx.core.app.a.e(this);
    AppMethodBeat.o(212342);
  }
  
  public final void validateRequestPermissionsRequestCode(int paramInt)
  {
    AppMethodBeat.i(212416);
    if ((!this.mRequestedPermissionsFromFragment) && (paramInt != -1)) {
      checkForValidRequestCode(paramInt);
    }
    AppMethodBeat.o(212416);
  }
  
  final class a
    extends d<FragmentActivity>
  {
    public a()
    {
      super();
    }
    
    public final boolean M(String paramString)
    {
      AppMethodBeat.i(212299);
      boolean bool = androidx.core.app.a.a(FragmentActivity.this, paramString);
      AppMethodBeat.o(212299);
      return bool;
    }
    
    public final void a(Fragment paramFragment, Intent paramIntent, int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(212293);
      FragmentActivity.this.startActivityFromFragment(paramFragment, paramIntent, paramInt, paramBundle);
      AppMethodBeat.o(212293);
    }
    
    public final void a(Fragment paramFragment, IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4, Bundle paramBundle)
    {
      AppMethodBeat.i(212295);
      FragmentActivity.this.startIntentSenderFromFragment(paramFragment, paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
      AppMethodBeat.o(212295);
    }
    
    public final void a(Fragment paramFragment, String[] paramArrayOfString, int paramInt)
    {
      AppMethodBeat.i(212298);
      FragmentActivity.this.requestPermissionsFromFragment(paramFragment, paramArrayOfString, paramInt);
      AppMethodBeat.o(212298);
    }
    
    public final void a(String paramString, PrintWriter paramPrintWriter, String[] paramArrayOfString)
    {
      AppMethodBeat.i(212284);
      FragmentActivity.this.dump(paramString, null, paramPrintWriter, paramArrayOfString);
      AppMethodBeat.o(212284);
    }
    
    public final View bZ(int paramInt)
    {
      AppMethodBeat.i(212305);
      View localView = FragmentActivity.this.findViewById(paramInt);
      AppMethodBeat.o(212305);
      return localView;
    }
    
    public final int iA()
    {
      AppMethodBeat.i(212302);
      Window localWindow = FragmentActivity.this.getWindow();
      if (localWindow == null)
      {
        AppMethodBeat.o(212302);
        return 0;
      }
      int i = localWindow.getAttributes().windowAnimations;
      AppMethodBeat.o(212302);
      return i;
    }
    
    public final boolean it()
    {
      AppMethodBeat.i(212307);
      Window localWindow = FragmentActivity.this.getWindow();
      if ((localWindow != null) && (localWindow.peekDecorView() != null))
      {
        AppMethodBeat.o(212307);
        return true;
      }
      AppMethodBeat.o(212307);
      return false;
    }
    
    public final boolean iw()
    {
      AppMethodBeat.i(212287);
      if (!FragmentActivity.this.isFinishing())
      {
        AppMethodBeat.o(212287);
        return true;
      }
      AppMethodBeat.o(212287);
      return false;
    }
    
    public final LayoutInflater ix()
    {
      AppMethodBeat.i(212289);
      LayoutInflater localLayoutInflater = FragmentActivity.this.getLayoutInflater().cloneInContext(FragmentActivity.this);
      AppMethodBeat.o(212289);
      return localLayoutInflater;
    }
    
    public final void iy()
    {
      AppMethodBeat.i(212291);
      FragmentActivity.this.supportInvalidateOptionsMenu();
      AppMethodBeat.o(212291);
    }
    
    public final boolean iz()
    {
      AppMethodBeat.i(212301);
      if (FragmentActivity.this.getWindow() != null)
      {
        AppMethodBeat.o(212301);
        return true;
      }
      AppMethodBeat.o(212301);
      return false;
    }
    
    public final void onAttachFragment(Fragment paramFragment)
    {
      AppMethodBeat.i(212304);
      FragmentActivity.this.onAttachFragment(paramFragment);
      AppMethodBeat.o(212304);
    }
  }
  
  static final class b
  {
    Object VJ;
    aa VK;
    f VL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.fragment.app.FragmentActivity
 * JD-Core Version:    0.7.0.1
 */