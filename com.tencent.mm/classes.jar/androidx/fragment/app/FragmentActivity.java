package androidx.fragment.app;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory2;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.d;
import androidx.core.app.a.a;
import androidx.core.app.a.c;
import androidx.lifecycle.aj;
import androidx.lifecycle.ak;
import androidx.lifecycle.j;
import androidx.lifecycle.j.a;
import androidx.lifecycle.j.b;
import androidx.lifecycle.s;
import androidx.savedstate.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;

public class FragmentActivity
  extends ComponentActivity
  implements a.a, a.c
{
  static final String FRAGMENTS_TAG = "android:support:fragments";
  boolean mCreated;
  final s mFragmentLifecycleRegistry;
  final e mFragments;
  boolean mResumed;
  boolean mStopped;
  
  public FragmentActivity()
  {
    AppMethodBeat.i(193454);
    this.mFragments = e.a(new a());
    this.mFragmentLifecycleRegistry = new s(this);
    this.mStopped = true;
    init();
    AppMethodBeat.o(193454);
  }
  
  public FragmentActivity(int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(193462);
    this.mFragments = e.a(new a());
    this.mFragmentLifecycleRegistry = new s(this);
    this.mStopped = true;
    init();
    AppMethodBeat.o(193462);
  }
  
  private void init()
  {
    AppMethodBeat.i(193469);
    getSavedStateRegistry().a("android:support:fragments", new b.b()
    {
      public final Bundle saveState()
      {
        AppMethodBeat.i(193423);
        Bundle localBundle = new Bundle();
        FragmentActivity.this.markFragmentsCreated();
        FragmentActivity.this.mFragmentLifecycleRegistry.a(j.a.ON_STOP);
        Parcelable localParcelable = FragmentActivity.this.mFragments.mHost.mFragmentManager.saveAllState();
        if (localParcelable != null) {
          localBundle.putParcelable("android:support:fragments", localParcelable);
        }
        AppMethodBeat.o(193423);
        return localBundle;
      }
    });
    addOnContextAvailableListener(new androidx.activity.b.b()
    {
      public final void onContextAvailable(Context paramAnonymousContext)
      {
        AppMethodBeat.i(193418);
        paramAnonymousContext = FragmentActivity.this.mFragments;
        paramAnonymousContext.mHost.mFragmentManager.attachController(paramAnonymousContext.mHost, paramAnonymousContext.mHost, null);
        paramAnonymousContext = FragmentActivity.this.getSavedStateRegistry().aR("android:support:fragments");
        if (paramAnonymousContext != null)
        {
          paramAnonymousContext = paramAnonymousContext.getParcelable("android:support:fragments");
          e locale = FragmentActivity.this.mFragments;
          if (!(locale.mHost instanceof ak))
          {
            paramAnonymousContext = new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
            AppMethodBeat.o(193418);
            throw paramAnonymousContext;
          }
          locale.mHost.mFragmentManager.restoreSaveState(paramAnonymousContext);
        }
        AppMethodBeat.o(193418);
      }
    });
    AppMethodBeat.o(193469);
  }
  
  private static boolean markState(FragmentManager paramFragmentManager, j.b paramb)
  {
    AppMethodBeat.i(193476);
    paramFragmentManager = paramFragmentManager.getFragments().iterator();
    boolean bool2 = false;
    while (paramFragmentManager.hasNext())
    {
      Fragment localFragment = (Fragment)paramFragmentManager.next();
      if (localFragment != null)
      {
        bool1 = bool2;
        if (localFragment.getHost() != null) {
          bool1 = bool2 | markState(localFragment.getChildFragmentManager(), paramb);
        }
        bool2 = bool1;
        if (localFragment.mViewLifecycleOwner != null)
        {
          bool2 = bool1;
          if (localFragment.mViewLifecycleOwner.getLifecycle().getCurrentState().d(j.b.bHj))
          {
            localFragment.mViewLifecycleOwner.mLifecycleRegistry.f(paramb);
            bool2 = true;
          }
        }
        if (!localFragment.mLifecycleRegistry.getCurrentState().d(j.b.bHj)) {
          break label150;
        }
        localFragment.mLifecycleRegistry.f(paramb);
      }
    }
    label150:
    for (boolean bool1 = true;; bool1 = bool2)
    {
      bool2 = bool1;
      break;
      AppMethodBeat.o(193476);
      return bool2;
    }
  }
  
  final View dispatchFragmentsOnCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(193571);
    paramView = this.mFragments.mHost.mFragmentManager.getLayoutInflaterFactory().onCreateView(paramView, paramString, paramContext, paramAttributeSet);
    AppMethodBeat.o(193571);
    return paramView;
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    AppMethodBeat.i(193691);
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
      androidx.h.a.a.l(this).dump(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
    this.mFragments.mHost.mFragmentManager.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    AppMethodBeat.o(193691);
  }
  
  public FragmentManager getSupportFragmentManager()
  {
    return this.mFragments.mHost.mFragmentManager;
  }
  
  @Deprecated
  public androidx.h.a.a getSupportLoaderManager()
  {
    AppMethodBeat.i(193710);
    androidx.h.a.a locala = androidx.h.a.a.l(this);
    AppMethodBeat.o(193710);
    return locala;
  }
  
  void markFragmentsCreated()
  {
    AppMethodBeat.i(193754);
    while (markState(getSupportFragmentManager(), j.b.bHi)) {}
    AppMethodBeat.o(193754);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(193480);
    this.mFragments.noteStateNotSaved();
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(193480);
  }
  
  @Deprecated
  public void onAttachFragment(Fragment paramFragment) {}
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(193530);
    super.onConfigurationChanged(paramConfiguration);
    this.mFragments.noteStateNotSaved();
    this.mFragments.mHost.mFragmentManager.dispatchConfigurationChanged(paramConfiguration);
    AppMethodBeat.o(193530);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(193533);
    super.onCreate(paramBundle);
    this.mFragmentLifecycleRegistry.a(j.a.ON_CREATE);
    this.mFragments.mHost.mFragmentManager.dispatchCreate();
    AppMethodBeat.o(193533);
  }
  
  public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
  {
    AppMethodBeat.i(193542);
    if (paramInt == 0)
    {
      bool1 = super.onCreatePanelMenu(paramInt, paramMenu);
      e locale = this.mFragments;
      MenuInflater localMenuInflater = getMenuInflater();
      boolean bool2 = locale.mHost.mFragmentManager.dispatchCreateOptionsMenu(paramMenu, localMenuInflater);
      AppMethodBeat.o(193542);
      return bool1 | bool2;
    }
    boolean bool1 = super.onCreatePanelMenu(paramInt, paramMenu);
    AppMethodBeat.o(193542);
    return bool1;
  }
  
  public View onCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(193553);
    View localView = dispatchFragmentsOnCreateView(paramView, paramString, paramContext, paramAttributeSet);
    if (localView == null)
    {
      paramView = super.onCreateView(paramView, paramString, paramContext, paramAttributeSet);
      AppMethodBeat.o(193553);
      return paramView;
    }
    AppMethodBeat.o(193553);
    return localView;
  }
  
  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(193562);
    View localView = dispatchFragmentsOnCreateView(null, paramString, paramContext, paramAttributeSet);
    if (localView == null)
    {
      paramString = super.onCreateView(paramString, paramContext, paramAttributeSet);
      AppMethodBeat.o(193562);
      return paramString;
    }
    AppMethodBeat.o(193562);
    return localView;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(193579);
    super.onDestroy();
    this.mFragments.mHost.mFragmentManager.dispatchDestroy();
    this.mFragmentLifecycleRegistry.a(j.a.ON_DESTROY);
    AppMethodBeat.o(193579);
  }
  
  public void onLowMemory()
  {
    AppMethodBeat.i(193586);
    super.onLowMemory();
    this.mFragments.mHost.mFragmentManager.dispatchLowMemory();
    AppMethodBeat.o(193586);
  }
  
  public boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(193598);
    if (super.onMenuItemSelected(paramInt, paramMenuItem))
    {
      AppMethodBeat.o(193598);
      return true;
    }
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(193598);
      return false;
    case 0: 
      bool = this.mFragments.mHost.mFragmentManager.dispatchOptionsItemSelected(paramMenuItem);
      AppMethodBeat.o(193598);
      return bool;
    }
    boolean bool = this.mFragments.mHost.mFragmentManager.dispatchContextItemSelected(paramMenuItem);
    AppMethodBeat.o(193598);
    return bool;
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(193517);
    this.mFragments.mHost.mFragmentManager.dispatchMultiWindowModeChanged(paramBoolean);
    AppMethodBeat.o(193517);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(193624);
    super.onNewIntent(paramIntent);
    this.mFragments.noteStateNotSaved();
    AppMethodBeat.o(193624);
  }
  
  public void onPanelClosed(int paramInt, Menu paramMenu)
  {
    AppMethodBeat.i(193605);
    if (paramInt == 0) {
      this.mFragments.mHost.mFragmentManager.dispatchOptionsMenuClosed(paramMenu);
    }
    super.onPanelClosed(paramInt, paramMenu);
    AppMethodBeat.o(193605);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(193616);
    super.onPause();
    this.mResumed = false;
    this.mFragments.mHost.mFragmentManager.dispatchPause();
    this.mFragmentLifecycleRegistry.a(j.a.ON_PAUSE);
    AppMethodBeat.o(193616);
  }
  
  public void onPictureInPictureModeChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(193522);
    this.mFragments.mHost.mFragmentManager.dispatchPictureInPictureModeChanged(paramBoolean);
    AppMethodBeat.o(193522);
  }
  
  public void onPostResume()
  {
    AppMethodBeat.i(193643);
    super.onPostResume();
    onResumeFragments();
    AppMethodBeat.o(193643);
  }
  
  @Deprecated
  protected boolean onPrepareOptionsPanel(View paramView, Menu paramMenu)
  {
    AppMethodBeat.i(193666);
    boolean bool = super.onPreparePanel(0, paramView, paramMenu);
    AppMethodBeat.o(193666);
    return bool;
  }
  
  public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
  {
    AppMethodBeat.i(193656);
    if (paramInt == 0)
    {
      bool1 = onPrepareOptionsPanel(paramView, paramMenu);
      boolean bool2 = this.mFragments.mHost.mFragmentManager.dispatchPrepareOptionsMenu(paramMenu);
      AppMethodBeat.o(193656);
      return bool1 | bool2;
    }
    boolean bool1 = super.onPreparePanel(paramInt, paramView, paramMenu);
    AppMethodBeat.o(193656);
    return bool1;
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(193723);
    this.mFragments.noteStateNotSaved();
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(193723);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(193638);
    super.onResume();
    this.mResumed = true;
    this.mFragments.noteStateNotSaved();
    this.mFragments.Gk();
    AppMethodBeat.o(193638);
  }
  
  protected void onResumeFragments()
  {
    AppMethodBeat.i(193648);
    this.mFragmentLifecycleRegistry.a(j.a.ON_RESUME);
    this.mFragments.mHost.mFragmentManager.dispatchResume();
    AppMethodBeat.o(193648);
  }
  
  protected void onStart()
  {
    AppMethodBeat.i(193672);
    super.onStart();
    this.mStopped = false;
    if (!this.mCreated)
    {
      this.mCreated = true;
      this.mFragments.mHost.mFragmentManager.dispatchActivityCreated();
    }
    this.mFragments.noteStateNotSaved();
    this.mFragments.Gk();
    this.mFragmentLifecycleRegistry.a(j.a.ON_START);
    this.mFragments.mHost.mFragmentManager.dispatchStart();
    AppMethodBeat.o(193672);
  }
  
  public void onStateNotSaved()
  {
    AppMethodBeat.i(193635);
    this.mFragments.noteStateNotSaved();
    AppMethodBeat.o(193635);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(193676);
    super.onStop();
    this.mStopped = true;
    markFragmentsCreated();
    this.mFragments.mHost.mFragmentManager.dispatchStop();
    this.mFragmentLifecycleRegistry.a(j.a.ON_STOP);
    AppMethodBeat.o(193676);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void setEnterSharedElementCallback(androidx.core.app.l paraml)
  {
    AppMethodBeat.i(193490);
    androidx.core.app.a.a(this, paraml);
    AppMethodBeat.o(193490);
  }
  
  public void setExitSharedElementCallback(androidx.core.app.l paraml)
  {
    AppMethodBeat.i(193496);
    androidx.core.app.a.b(this, paraml);
    AppMethodBeat.o(193496);
  }
  
  public void startActivityFromFragment(Fragment paramFragment, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(193730);
    startActivityFromFragment(paramFragment, paramIntent, paramInt, null);
    AppMethodBeat.o(193730);
  }
  
  public void startActivityFromFragment(Fragment paramFragment, Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(193738);
    if (paramInt == -1)
    {
      androidx.core.app.a.a(this, paramIntent, -1, paramBundle);
      AppMethodBeat.o(193738);
      return;
    }
    paramFragment.startActivityForResult(paramIntent, paramInt, paramBundle);
    AppMethodBeat.o(193738);
  }
  
  @Deprecated
  public void startIntentSenderFromFragment(Fragment paramFragment, IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4, Bundle paramBundle)
  {
    AppMethodBeat.i(193747);
    if (paramInt1 == -1)
    {
      androidx.core.app.a.a(this, paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
      AppMethodBeat.o(193747);
      return;
    }
    paramFragment.startIntentSenderForResult(paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
    AppMethodBeat.o(193747);
  }
  
  public void supportFinishAfterTransition()
  {
    AppMethodBeat.i(193486);
    androidx.core.app.a.c(this);
    AppMethodBeat.o(193486);
  }
  
  @Deprecated
  public void supportInvalidateOptionsMenu()
  {
    AppMethodBeat.i(193681);
    invalidateOptionsMenu();
    AppMethodBeat.o(193681);
  }
  
  public void supportPostponeEnterTransition()
  {
    AppMethodBeat.i(193504);
    androidx.core.app.a.d(this);
    AppMethodBeat.o(193504);
  }
  
  public void supportStartPostponedEnterTransition()
  {
    AppMethodBeat.i(193511);
    androidx.core.app.a.e(this);
    AppMethodBeat.o(193511);
  }
  
  @Deprecated
  public final void validateRequestPermissionsRequestCode(int paramInt) {}
  
  final class a
    extends g<FragmentActivity>
    implements androidx.activity.c, d, l, ak
  {
    public a()
    {
      super();
    }
    
    public final boolean Gg()
    {
      AppMethodBeat.i(193939);
      if (!FragmentActivity.this.isFinishing())
      {
        AppMethodBeat.o(193939);
        return true;
      }
      AppMethodBeat.o(193939);
      return false;
    }
    
    public final LayoutInflater Gh()
    {
      AppMethodBeat.i(193943);
      LayoutInflater localLayoutInflater = FragmentActivity.this.getLayoutInflater().cloneInContext(FragmentActivity.this);
      AppMethodBeat.o(193943);
      return localLayoutInflater;
    }
    
    public final void Gi()
    {
      AppMethodBeat.i(193948);
      FragmentActivity.this.supportInvalidateOptionsMenu();
      AppMethodBeat.o(193948);
    }
    
    public final void a(String paramString, PrintWriter paramPrintWriter, String[] paramArrayOfString)
    {
      AppMethodBeat.i(193931);
      FragmentActivity.this.dump(paramString, null, paramPrintWriter, paramArrayOfString);
      AppMethodBeat.o(193931);
    }
    
    public final boolean aF(String paramString)
    {
      AppMethodBeat.i(193954);
      boolean bool = androidx.core.app.a.a(FragmentActivity.this, paramString);
      AppMethodBeat.o(193954);
      return bool;
    }
    
    public final void e(Fragment paramFragment)
    {
      AppMethodBeat.i(193965);
      FragmentActivity.this.onAttachFragment(paramFragment);
      AppMethodBeat.o(193965);
    }
    
    public final androidx.activity.result.c getActivityResultRegistry()
    {
      AppMethodBeat.i(193987);
      androidx.activity.result.c localc = FragmentActivity.this.getActivityResultRegistry();
      AppMethodBeat.o(193987);
      return localc;
    }
    
    public final j getLifecycle()
    {
      return FragmentActivity.this.mFragmentLifecycleRegistry;
    }
    
    public final OnBackPressedDispatcher getOnBackPressedDispatcher()
    {
      AppMethodBeat.i(193924);
      OnBackPressedDispatcher localOnBackPressedDispatcher = FragmentActivity.this.getOnBackPressedDispatcher();
      AppMethodBeat.o(193924);
      return localOnBackPressedDispatcher;
    }
    
    public final aj getViewModelStore()
    {
      AppMethodBeat.i(193916);
      aj localaj = FragmentActivity.this.getViewModelStore();
      AppMethodBeat.o(193916);
      return localaj;
    }
    
    public final View onFindViewById(int paramInt)
    {
      AppMethodBeat.i(193970);
      View localView = FragmentActivity.this.findViewById(paramInt);
      AppMethodBeat.o(193970);
      return localView;
    }
    
    public final boolean onHasView()
    {
      AppMethodBeat.i(193977);
      Window localWindow = FragmentActivity.this.getWindow();
      if ((localWindow != null) && (localWindow.peekDecorView() != null))
      {
        AppMethodBeat.o(193977);
        return true;
      }
      AppMethodBeat.o(193977);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.fragment.app.FragmentActivity
 * JD-Core Version:    0.7.0.1
 */