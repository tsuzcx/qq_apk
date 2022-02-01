package androidx.fragment.app;

import android.animation.Animator;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.core.app.l;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ad;
import androidx.lifecycle.ah.b;
import androidx.lifecycle.aj;
import androidx.lifecycle.ak;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import androidx.lifecycle.j;
import androidx.lifecycle.j.a;
import androidx.lifecycle.j.b;
import androidx.lifecycle.o;
import androidx.lifecycle.q;
import androidx.lifecycle.s;
import androidx.savedstate.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Fragment
  implements ComponentCallbacks, View.OnCreateContextMenuListener, ak, q, androidx.savedstate.d
{
  static final int ACTIVITY_CREATED = 4;
  static final int ATTACHED = 0;
  static final int AWAITING_ENTER_EFFECTS = 6;
  static final int AWAITING_EXIT_EFFECTS = 3;
  static final int CREATED = 1;
  static final int INITIALIZING = -1;
  static final int RESUMED = 7;
  static final int STARTED = 5;
  static final Object USE_DEFAULT_TRANSITION;
  static final int VIEW_CREATED = 2;
  private byte _hellAccFlag_;
  boolean mAdded;
  a mAnimationInfo;
  Bundle mArguments;
  int mBackStackNesting;
  private boolean mCalled;
  FragmentManager mChildFragmentManager;
  ViewGroup mContainer;
  int mContainerId;
  private int mContentLayoutId;
  private ah.b mDefaultFactory;
  boolean mDeferStart;
  boolean mDetached;
  int mFragmentId;
  FragmentManager mFragmentManager;
  boolean mFromLayout;
  boolean mHasMenu;
  boolean mHidden;
  boolean mHiddenChanged;
  g<?> mHost;
  boolean mInLayout;
  boolean mIsCreated;
  boolean mIsNewlyAdded;
  private Boolean mIsPrimaryNavigationFragment;
  LayoutInflater mLayoutInflater;
  s mLifecycleRegistry;
  j.b mMaxState;
  boolean mMenuVisible;
  private final AtomicInteger mNextLocalRequestCode;
  private final ArrayList<c> mOnPreAttachedListeners;
  Fragment mParentFragment;
  boolean mPerformedCreateView;
  float mPostponedAlpha;
  Runnable mPostponedDurationRunnable;
  boolean mRemoving;
  boolean mRestored;
  boolean mRetainInstance;
  boolean mRetainInstanceChangedWhileDetached;
  Bundle mSavedFragmentState;
  androidx.savedstate.c mSavedStateRegistryController;
  Boolean mSavedUserVisibleHint;
  Bundle mSavedViewRegistryState;
  SparseArray<Parcelable> mSavedViewState;
  int mState;
  String mTag;
  Fragment mTarget;
  int mTargetRequestCode;
  String mTargetWho;
  boolean mUserVisibleHint;
  View mView;
  v mViewLifecycleOwner;
  androidx.lifecycle.x<q> mViewLifecycleOwnerLiveData;
  String mWho;
  
  static
  {
    AppMethodBeat.i(193626);
    USE_DEFAULT_TRANSITION = new Object();
    AppMethodBeat.o(193626);
  }
  
  public Fragment()
  {
    AppMethodBeat.i(193541);
    this.mState = -1;
    this.mWho = UUID.randomUUID().toString();
    this.mTargetWho = null;
    this.mIsPrimaryNavigationFragment = null;
    this.mChildFragmentManager = new FragmentManagerImpl();
    this.mMenuVisible = true;
    this.mUserVisibleHint = true;
    this.mPostponedDurationRunnable = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(193628);
        Fragment.this.startPostponedEnterTransition();
        AppMethodBeat.o(193628);
      }
    };
    this.mMaxState = j.b.bHk;
    this.mViewLifecycleOwnerLiveData = new androidx.lifecycle.x();
    this.mNextLocalRequestCode = new AtomicInteger();
    this.mOnPreAttachedListeners = new ArrayList();
    initLifecycle();
    AppMethodBeat.o(193541);
  }
  
  public Fragment(int paramInt)
  {
    this();
    this.mContentLayoutId = paramInt;
  }
  
  private a ensureAnimationInfo()
  {
    AppMethodBeat.i(193599);
    if (this.mAnimationInfo == null) {
      this.mAnimationInfo = new a();
    }
    a locala = this.mAnimationInfo;
    AppMethodBeat.o(193599);
    return locala;
  }
  
  private int getMinimumMaxLifecycleState()
  {
    AppMethodBeat.i(193535);
    if ((this.mMaxState == j.b.bHh) || (this.mParentFragment == null))
    {
      i = this.mMaxState.ordinal();
      AppMethodBeat.o(193535);
      return i;
    }
    int i = Math.min(this.mMaxState.ordinal(), this.mParentFragment.getMinimumMaxLifecycleState());
    AppMethodBeat.o(193535);
    return i;
  }
  
  private void initLifecycle()
  {
    AppMethodBeat.i(193556);
    this.mLifecycleRegistry = new s(this);
    this.mSavedStateRegistryController = androidx.savedstate.c.b(this);
    this.mDefaultFactory = null;
    AppMethodBeat.o(193556);
  }
  
  @Deprecated
  public static Fragment instantiate(Context paramContext, String paramString)
  {
    AppMethodBeat.i(193566);
    paramContext = instantiate(paramContext, paramString, null);
    AppMethodBeat.o(193566);
    return paramContext;
  }
  
  @Deprecated
  public static Fragment instantiate(Context paramContext, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(193582);
    try
    {
      paramContext = (Fragment)f.c(paramContext.getClassLoader(), paramString).getConstructor(new Class[0]).newInstance(new Object[0]);
      if (paramBundle != null)
      {
        paramBundle.setClassLoader(paramContext.getClass().getClassLoader());
        paramContext.setArguments(paramBundle);
      }
      AppMethodBeat.o(193582);
      return paramContext;
    }
    catch (InstantiationException paramContext)
    {
      paramContext = new b("Unable to instantiate fragment " + paramString + ": make sure class name exists, is public, and has an empty constructor that is public", paramContext);
      AppMethodBeat.o(193582);
      throw paramContext;
    }
    catch (IllegalAccessException paramContext)
    {
      paramContext = new b("Unable to instantiate fragment " + paramString + ": make sure class name exists, is public, and has an empty constructor that is public", paramContext);
      AppMethodBeat.o(193582);
      throw paramContext;
    }
    catch (NoSuchMethodException paramContext)
    {
      paramContext = new b("Unable to instantiate fragment " + paramString + ": could not find Fragment constructor", paramContext);
      AppMethodBeat.o(193582);
      throw paramContext;
    }
    catch (InvocationTargetException paramContext)
    {
      paramContext = new b("Unable to instantiate fragment " + paramString + ": calling Fragment constructor caused an exception", paramContext);
      AppMethodBeat.o(193582);
      throw paramContext;
    }
  }
  
  private <I, O> androidx.activity.result.b<I> prepareCallInternal(final androidx.activity.result.a.a<I, O> parama, final androidx.a.a.c.a<Void, androidx.activity.result.c> parama1, final androidx.activity.result.a<O> parama2)
  {
    AppMethodBeat.i(193609);
    if (this.mState > 1)
    {
      parama = new IllegalStateException("Fragment " + this + " is attempting to registerForActivityResult after being created. Fragments must call registerForActivityResult() before they are created (i.e. initialization, onAttach(), or onCreate()).");
      AppMethodBeat.o(193609);
      throw parama;
    }
    final AtomicReference localAtomicReference = new AtomicReference();
    registerOnPreAttachListener(new c(parama1)
    {
      final void Gd()
      {
        AppMethodBeat.i(193540);
        String str = Fragment.this.generateActivityResultKey();
        androidx.activity.result.c localc = (androidx.activity.result.c)parama1.apply(null);
        localAtomicReference.set(localc.a(str, Fragment.this, parama, parama2));
        AppMethodBeat.o(193540);
      }
    });
    parama = new androidx.activity.result.b()
    {
      public final void a(I paramAnonymousI, androidx.core.app.b paramAnonymousb)
      {
        AppMethodBeat.i(193558);
        androidx.activity.result.b localb = (androidx.activity.result.b)localAtomicReference.get();
        if (localb == null)
        {
          paramAnonymousI = new IllegalStateException("Operation cannot be started before fragment is in created state");
          AppMethodBeat.o(193558);
          throw paramAnonymousI;
        }
        localb.a(paramAnonymousI, paramAnonymousb);
        AppMethodBeat.o(193558);
      }
      
      public final void unregister()
      {
        AppMethodBeat.i(193567);
        androidx.activity.result.b localb = (androidx.activity.result.b)localAtomicReference.getAndSet(null);
        if (localb != null) {
          localb.unregister();
        }
        AppMethodBeat.o(193567);
      }
    };
    AppMethodBeat.o(193609);
    return parama;
  }
  
  private void registerOnPreAttachListener(c paramc)
  {
    AppMethodBeat.i(193617);
    if (this.mState >= 0)
    {
      paramc.Gd();
      AppMethodBeat.o(193617);
      return;
    }
    this.mOnPreAttachedListeners.add(paramc);
    AppMethodBeat.o(193617);
  }
  
  private void restoreViewState()
  {
    AppMethodBeat.i(193592);
    if (FragmentManager.isLoggingEnabled(3)) {
      new StringBuilder("moveto RESTORE_VIEW_STATE: ").append(this);
    }
    if (this.mView != null) {
      restoreViewState(this.mSavedFragmentState);
    }
    this.mSavedFragmentState = null;
    AppMethodBeat.o(193592);
  }
  
  void callStartTransitionListener(boolean paramBoolean)
  {
    Object localObject = null;
    AppMethodBeat.i(194475);
    if (this.mAnimationInfo == null) {}
    while (localObject != null)
    {
      ((d)localObject).Ge();
      AppMethodBeat.o(194475);
      return;
      this.mAnimationInfo.bCr = false;
      localObject = this.mAnimationInfo.bCs;
      this.mAnimationInfo.bCs = null;
    }
    if ((FragmentManager.USE_STATE_MANAGER) && (this.mView != null) && (this.mContainer != null) && (this.mFragmentManager != null))
    {
      localObject = x.a(this.mContainer, this.mFragmentManager);
      ((x)localObject).GG();
      if (paramBoolean)
      {
        this.mHost.mHandler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(193651);
            this.bBU.GH();
            AppMethodBeat.o(193651);
          }
        });
        AppMethodBeat.o(194475);
        return;
      }
      ((x)localObject).GH();
    }
    AppMethodBeat.o(194475);
  }
  
  d createFragmentContainer()
  {
    AppMethodBeat.i(194503);
    d local4 = new d()
    {
      public final View onFindViewById(int paramAnonymousInt)
      {
        AppMethodBeat.i(193646);
        if (Fragment.this.mView == null)
        {
          localObject = new IllegalStateException("Fragment " + Fragment.this + " does not have a view");
          AppMethodBeat.o(193646);
          throw ((Throwable)localObject);
        }
        Object localObject = Fragment.this.mView.findViewById(paramAnonymousInt);
        AppMethodBeat.o(193646);
        return localObject;
      }
      
      public final boolean onHasView()
      {
        return Fragment.this.mView != null;
      }
    };
    AppMethodBeat.o(194503);
    return local4;
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    AppMethodBeat.i(194493);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mFragmentId=#");
    paramPrintWriter.print(Integer.toHexString(this.mFragmentId));
    paramPrintWriter.print(" mContainerId=#");
    paramPrintWriter.print(Integer.toHexString(this.mContainerId));
    paramPrintWriter.print(" mTag=");
    paramPrintWriter.println(this.mTag);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mState=");
    paramPrintWriter.print(this.mState);
    paramPrintWriter.print(" mWho=");
    paramPrintWriter.print(this.mWho);
    paramPrintWriter.print(" mBackStackNesting=");
    paramPrintWriter.println(this.mBackStackNesting);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mAdded=");
    paramPrintWriter.print(this.mAdded);
    paramPrintWriter.print(" mRemoving=");
    paramPrintWriter.print(this.mRemoving);
    paramPrintWriter.print(" mFromLayout=");
    paramPrintWriter.print(this.mFromLayout);
    paramPrintWriter.print(" mInLayout=");
    paramPrintWriter.println(this.mInLayout);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mHidden=");
    paramPrintWriter.print(this.mHidden);
    paramPrintWriter.print(" mDetached=");
    paramPrintWriter.print(this.mDetached);
    paramPrintWriter.print(" mMenuVisible=");
    paramPrintWriter.print(this.mMenuVisible);
    paramPrintWriter.print(" mHasMenu=");
    paramPrintWriter.println(this.mHasMenu);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mRetainInstance=");
    paramPrintWriter.print(this.mRetainInstance);
    paramPrintWriter.print(" mUserVisibleHint=");
    paramPrintWriter.println(this.mUserVisibleHint);
    if (this.mFragmentManager != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mFragmentManager=");
      paramPrintWriter.println(this.mFragmentManager);
    }
    if (this.mHost != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mHost=");
      paramPrintWriter.println(this.mHost);
    }
    if (this.mParentFragment != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mParentFragment=");
      paramPrintWriter.println(this.mParentFragment);
    }
    if (this.mArguments != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mArguments=");
      paramPrintWriter.println(this.mArguments);
    }
    if (this.mSavedFragmentState != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mSavedFragmentState=");
      paramPrintWriter.println(this.mSavedFragmentState);
    }
    if (this.mSavedViewState != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mSavedViewState=");
      paramPrintWriter.println(this.mSavedViewState);
    }
    if (this.mSavedViewRegistryState != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mSavedViewRegistryState=");
      paramPrintWriter.println(this.mSavedViewRegistryState);
    }
    Fragment localFragment = getTargetFragment();
    if (localFragment != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mTarget=");
      paramPrintWriter.print(localFragment);
      paramPrintWriter.print(" mTargetRequestCode=");
      paramPrintWriter.println(this.mTargetRequestCode);
    }
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mPopDirection=");
    paramPrintWriter.println(getPopDirection());
    if (getEnterAnim() != 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("getEnterAnim=");
      paramPrintWriter.println(getEnterAnim());
    }
    if (getExitAnim() != 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("getExitAnim=");
      paramPrintWriter.println(getExitAnim());
    }
    if (getPopEnterAnim() != 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("getPopEnterAnim=");
      paramPrintWriter.println(getPopEnterAnim());
    }
    if (getPopExitAnim() != 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("getPopExitAnim=");
      paramPrintWriter.println(getPopExitAnim());
    }
    if (this.mContainer != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mContainer=");
      paramPrintWriter.println(this.mContainer);
    }
    if (this.mView != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mView=");
      paramPrintWriter.println(this.mView);
    }
    if (getAnimatingAway() != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mAnimatingAway=");
      paramPrintWriter.println(getAnimatingAway());
    }
    if (getContext() != null) {
      androidx.h.a.a.l(this).dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
    paramPrintWriter.print(paramString);
    paramPrintWriter.println("Child " + this.mChildFragmentManager + ":");
    this.mChildFragmentManager.dump(paramString + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    AppMethodBeat.o(194493);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(193685);
    boolean bool = super.equals(paramObject);
    AppMethodBeat.o(193685);
    return bool;
  }
  
  Fragment findFragmentByWho(String paramString)
  {
    AppMethodBeat.i(194499);
    if (paramString.equals(this.mWho))
    {
      AppMethodBeat.o(194499);
      return this;
    }
    paramString = this.mChildFragmentManager.findFragmentByWho(paramString);
    AppMethodBeat.o(194499);
    return paramString;
  }
  
  String generateActivityResultKey()
  {
    AppMethodBeat.i(194957);
    String str = "fragment_" + this.mWho + "_rq#" + this.mNextLocalRequestCode.getAndIncrement();
    AppMethodBeat.o(194957);
    return str;
  }
  
  public final FragmentActivity getActivity()
  {
    if (this.mHost == null) {
      return null;
    }
    return (FragmentActivity)this.mHost.mActivity;
  }
  
  public boolean getAllowEnterTransitionOverlap()
  {
    AppMethodBeat.i(194426);
    if ((this.mAnimationInfo == null) || (this.mAnimationInfo.bCm == null))
    {
      AppMethodBeat.o(194426);
      return true;
    }
    boolean bool = this.mAnimationInfo.bCm.booleanValue();
    AppMethodBeat.o(194426);
    return bool;
  }
  
  public boolean getAllowReturnTransitionOverlap()
  {
    AppMethodBeat.i(194440);
    if ((this.mAnimationInfo == null) || (this.mAnimationInfo.bCl == null))
    {
      AppMethodBeat.o(194440);
      return true;
    }
    boolean bool = this.mAnimationInfo.bCl.booleanValue();
    AppMethodBeat.o(194440);
    return bool;
  }
  
  View getAnimatingAway()
  {
    if (this.mAnimationInfo == null) {
      return null;
    }
    return this.mAnimationInfo.bBY;
  }
  
  Animator getAnimator()
  {
    if (this.mAnimationInfo == null) {
      return null;
    }
    return this.mAnimationInfo.bBZ;
  }
  
  public final Bundle getArguments()
  {
    return this.mArguments;
  }
  
  public final FragmentManager getChildFragmentManager()
  {
    AppMethodBeat.i(193874);
    if (this.mHost == null)
    {
      localObject = new IllegalStateException("Fragment " + this + " has not been attached yet.");
      AppMethodBeat.o(193874);
      throw ((Throwable)localObject);
    }
    Object localObject = this.mChildFragmentManager;
    AppMethodBeat.o(193874);
    return localObject;
  }
  
  public Context getContext()
  {
    if (this.mHost == null) {
      return null;
    }
    return this.mHost.mContext;
  }
  
  public ah.b getDefaultViewModelProviderFactory()
  {
    AppMethodBeat.i(193662);
    if (this.mFragmentManager == null)
    {
      localObject = new IllegalStateException("Can't access ViewModels from detached fragment");
      AppMethodBeat.o(193662);
      throw ((Throwable)localObject);
    }
    if (this.mDefaultFactory == null)
    {
      localObject = requireContext().getApplicationContext();
      if (!(localObject instanceof ContextWrapper)) {
        break label145;
      }
      if (!(localObject instanceof Application)) {
        break label134;
      }
    }
    label134:
    label145:
    for (Object localObject = (Application)localObject;; localObject = null)
    {
      if ((localObject == null) && (FragmentManager.isLoggingEnabled(3))) {
        new StringBuilder("Could not find Application instance from Context ").append(requireContext().getApplicationContext()).append(", you will not be able to use AndroidViewModel with the default ViewModelProvider.Factory");
      }
      this.mDefaultFactory = new ad((Application)localObject, this, getArguments());
      localObject = this.mDefaultFactory;
      AppMethodBeat.o(193662);
      return localObject;
      localObject = ((ContextWrapper)localObject).getBaseContext();
      break;
    }
  }
  
  int getEnterAnim()
  {
    if (this.mAnimationInfo == null) {
      return 0;
    }
    return this.mAnimationInfo.bCa;
  }
  
  public Object getEnterTransition()
  {
    if (this.mAnimationInfo == null) {
      return null;
    }
    return this.mAnimationInfo.bCf;
  }
  
  l getEnterTransitionCallback()
  {
    if (this.mAnimationInfo == null) {
      return null;
    }
    return this.mAnimationInfo.bCn;
  }
  
  int getExitAnim()
  {
    if (this.mAnimationInfo == null) {
      return 0;
    }
    return this.mAnimationInfo.bCb;
  }
  
  public Object getExitTransition()
  {
    if (this.mAnimationInfo == null) {
      return null;
    }
    return this.mAnimationInfo.bCh;
  }
  
  l getExitTransitionCallback()
  {
    if (this.mAnimationInfo == null) {
      return null;
    }
    return this.mAnimationInfo.bCo;
  }
  
  View getFocusedView()
  {
    if (this.mAnimationInfo == null) {
      return null;
    }
    return this.mAnimationInfo.bCq;
  }
  
  @Deprecated
  public final FragmentManager getFragmentManager()
  {
    return this.mFragmentManager;
  }
  
  public final Object getHost()
  {
    AppMethodBeat.i(193817);
    if (this.mHost == null)
    {
      AppMethodBeat.o(193817);
      return null;
    }
    Object localObject = this.mHost.Gj();
    AppMethodBeat.o(193817);
    return localObject;
  }
  
  public final int getId()
  {
    return this.mFragmentId;
  }
  
  public final LayoutInflater getLayoutInflater()
  {
    AppMethodBeat.i(194103);
    if (this.mLayoutInflater == null)
    {
      localLayoutInflater = performGetLayoutInflater(null);
      AppMethodBeat.o(194103);
      return localLayoutInflater;
    }
    LayoutInflater localLayoutInflater = this.mLayoutInflater;
    AppMethodBeat.o(194103);
    return localLayoutInflater;
  }
  
  @Deprecated
  public LayoutInflater getLayoutInflater(Bundle paramBundle)
  {
    AppMethodBeat.i(194124);
    if (this.mHost == null)
    {
      paramBundle = new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
      AppMethodBeat.o(194124);
      throw paramBundle;
    }
    paramBundle = this.mHost.Gh();
    androidx.core.g.g.b(paramBundle, this.mChildFragmentManager.getLayoutInflaterFactory());
    AppMethodBeat.o(194124);
    return paramBundle;
  }
  
  public j getLifecycle()
  {
    return this.mLifecycleRegistry;
  }
  
  @Deprecated
  public androidx.h.a.a getLoaderManager()
  {
    AppMethodBeat.i(194013);
    androidx.h.a.a locala = androidx.h.a.a.l(this);
    AppMethodBeat.o(194013);
    return locala;
  }
  
  int getNextTransition()
  {
    if (this.mAnimationInfo == null) {
      return 0;
    }
    return this.mAnimationInfo.bCe;
  }
  
  public final Fragment getParentFragment()
  {
    return this.mParentFragment;
  }
  
  public final FragmentManager getParentFragmentManager()
  {
    AppMethodBeat.i(193866);
    Object localObject = this.mFragmentManager;
    if (localObject == null)
    {
      localObject = new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
      AppMethodBeat.o(193866);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(193866);
    return localObject;
  }
  
  boolean getPopDirection()
  {
    if (this.mAnimationInfo == null) {
      return false;
    }
    return this.mAnimationInfo.bBJ;
  }
  
  int getPopEnterAnim()
  {
    if (this.mAnimationInfo == null) {
      return 0;
    }
    return this.mAnimationInfo.bCc;
  }
  
  int getPopExitAnim()
  {
    if (this.mAnimationInfo == null) {
      return 0;
    }
    return this.mAnimationInfo.bCd;
  }
  
  float getPostOnViewCreatedAlpha()
  {
    if (this.mAnimationInfo == null) {
      return 1.0F;
    }
    return this.mAnimationInfo.bCp;
  }
  
  public Object getReenterTransition()
  {
    AppMethodBeat.i(194389);
    if (this.mAnimationInfo == null)
    {
      AppMethodBeat.o(194389);
      return null;
    }
    if (this.mAnimationInfo.bCi == USE_DEFAULT_TRANSITION)
    {
      localObject = getExitTransition();
      AppMethodBeat.o(194389);
      return localObject;
    }
    Object localObject = this.mAnimationInfo.bCi;
    AppMethodBeat.o(194389);
    return localObject;
  }
  
  public final Resources getResources()
  {
    AppMethodBeat.i(193833);
    Resources localResources = requireContext().getResources();
    AppMethodBeat.o(193833);
    return localResources;
  }
  
  @Deprecated
  public final boolean getRetainInstance()
  {
    return this.mRetainInstance;
  }
  
  public Object getReturnTransition()
  {
    AppMethodBeat.i(194364);
    if (this.mAnimationInfo == null)
    {
      AppMethodBeat.o(194364);
      return null;
    }
    if (this.mAnimationInfo.bCg == USE_DEFAULT_TRANSITION)
    {
      localObject = getEnterTransition();
      AppMethodBeat.o(194364);
      return localObject;
    }
    Object localObject = this.mAnimationInfo.bCg;
    AppMethodBeat.o(194364);
    return localObject;
  }
  
  public final androidx.savedstate.b getSavedStateRegistry()
  {
    return this.mSavedStateRegistryController.ccj;
  }
  
  public Object getSharedElementEnterTransition()
  {
    if (this.mAnimationInfo == null) {
      return null;
    }
    return this.mAnimationInfo.bCj;
  }
  
  public Object getSharedElementReturnTransition()
  {
    AppMethodBeat.i(194412);
    if (this.mAnimationInfo == null)
    {
      AppMethodBeat.o(194412);
      return null;
    }
    if (this.mAnimationInfo.bCk == USE_DEFAULT_TRANSITION)
    {
      localObject = getSharedElementEnterTransition();
      AppMethodBeat.o(194412);
      return localObject;
    }
    Object localObject = this.mAnimationInfo.bCk;
    AppMethodBeat.o(194412);
    return localObject;
  }
  
  ArrayList<String> getSharedElementSourceNames()
  {
    AppMethodBeat.i(194817);
    if ((this.mAnimationInfo == null) || (this.mAnimationInfo.bBo == null))
    {
      localArrayList = new ArrayList();
      AppMethodBeat.o(194817);
      return localArrayList;
    }
    ArrayList localArrayList = this.mAnimationInfo.bBo;
    AppMethodBeat.o(194817);
    return localArrayList;
  }
  
  ArrayList<String> getSharedElementTargetNames()
  {
    AppMethodBeat.i(194828);
    if ((this.mAnimationInfo == null) || (this.mAnimationInfo.bBp == null))
    {
      localArrayList = new ArrayList();
      AppMethodBeat.o(194828);
      return localArrayList;
    }
    ArrayList localArrayList = this.mAnimationInfo.bBp;
    AppMethodBeat.o(194828);
    return localArrayList;
  }
  
  public final String getString(int paramInt)
  {
    AppMethodBeat.i(193845);
    String str = getResources().getString(paramInt);
    AppMethodBeat.o(193845);
    return str;
  }
  
  public final String getString(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(193850);
    paramVarArgs = getResources().getString(paramInt, paramVarArgs);
    AppMethodBeat.o(193850);
    return paramVarArgs;
  }
  
  public final String getTag()
  {
    return this.mTag;
  }
  
  @Deprecated
  public final Fragment getTargetFragment()
  {
    AppMethodBeat.i(193773);
    Fragment localFragment;
    if (this.mTarget != null)
    {
      localFragment = this.mTarget;
      AppMethodBeat.o(193773);
      return localFragment;
    }
    if ((this.mFragmentManager != null) && (this.mTargetWho != null))
    {
      localFragment = this.mFragmentManager.findActiveFragment(this.mTargetWho);
      AppMethodBeat.o(193773);
      return localFragment;
    }
    AppMethodBeat.o(193773);
    return null;
  }
  
  @Deprecated
  public final int getTargetRequestCode()
  {
    return this.mTargetRequestCode;
  }
  
  public final CharSequence getText(int paramInt)
  {
    AppMethodBeat.i(193841);
    CharSequence localCharSequence = getResources().getText(paramInt);
    AppMethodBeat.o(193841);
    return localCharSequence;
  }
  
  @Deprecated
  public boolean getUserVisibleHint()
  {
    return this.mUserVisibleHint;
  }
  
  public View getView()
  {
    return this.mView;
  }
  
  public q getViewLifecycleOwner()
  {
    AppMethodBeat.i(193640);
    if (this.mViewLifecycleOwner == null)
    {
      localObject = new IllegalStateException("Can't access the Fragment View's LifecycleOwner when getView() is null i.e., before onCreateView() or after onDestroyView()");
      AppMethodBeat.o(193640);
      throw ((Throwable)localObject);
    }
    Object localObject = this.mViewLifecycleOwner;
    AppMethodBeat.o(193640);
    return localObject;
  }
  
  public LiveData<q> getViewLifecycleOwnerLiveData()
  {
    return this.mViewLifecycleOwnerLiveData;
  }
  
  public aj getViewModelStore()
  {
    AppMethodBeat.i(193654);
    if (this.mFragmentManager == null)
    {
      localObject = new IllegalStateException("Can't access ViewModels from detached fragment");
      AppMethodBeat.o(193654);
      throw ((Throwable)localObject);
    }
    if (getMinimumMaxLifecycleState() == j.b.bHh.ordinal())
    {
      localObject = new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
      AppMethodBeat.o(193654);
      throw ((Throwable)localObject);
    }
    Object localObject = this.mFragmentManager.getViewModelStore(this);
    AppMethodBeat.o(193654);
    return localObject;
  }
  
  public final boolean hasOptionsMenu()
  {
    return this.mHasMenu;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(193697);
    int i = super.hashCode();
    AppMethodBeat.o(193697);
    return i;
  }
  
  void initState()
  {
    AppMethodBeat.i(194290);
    initLifecycle();
    this.mWho = UUID.randomUUID().toString();
    this.mAdded = false;
    this.mRemoving = false;
    this.mFromLayout = false;
    this.mInLayout = false;
    this.mRestored = false;
    this.mBackStackNesting = 0;
    this.mFragmentManager = null;
    this.mChildFragmentManager = new FragmentManagerImpl();
    this.mHost = null;
    this.mFragmentId = 0;
    this.mContainerId = 0;
    this.mTag = null;
    this.mHidden = false;
    this.mDetached = false;
    AppMethodBeat.o(194290);
  }
  
  public final boolean isAdded()
  {
    return (this.mHost != null) && (this.mAdded);
  }
  
  public final boolean isDetached()
  {
    return this.mDetached;
  }
  
  public final boolean isHidden()
  {
    return this.mHidden;
  }
  
  boolean isHideReplaced()
  {
    if (this.mAnimationInfo == null) {
      return false;
    }
    return this.mAnimationInfo.bCt;
  }
  
  final boolean isInBackStack()
  {
    return this.mBackStackNesting > 0;
  }
  
  public final boolean isInLayout()
  {
    return this.mInLayout;
  }
  
  public final boolean isMenuVisible()
  {
    AppMethodBeat.i(193946);
    if ((this.mMenuVisible) && ((this.mFragmentManager == null) || (this.mFragmentManager.isParentMenuVisible(this.mParentFragment))))
    {
      AppMethodBeat.o(193946);
      return true;
    }
    AppMethodBeat.o(193946);
    return false;
  }
  
  boolean isPostponed()
  {
    if (this.mAnimationInfo == null) {
      return false;
    }
    return this.mAnimationInfo.bCr;
  }
  
  public final boolean isRemoving()
  {
    return this.mRemoving;
  }
  
  final boolean isRemovingParent()
  {
    AppMethodBeat.i(193906);
    Fragment localFragment = getParentFragment();
    if ((localFragment != null) && ((localFragment.isRemoving()) || (localFragment.isRemovingParent())))
    {
      AppMethodBeat.o(193906);
      return true;
    }
    AppMethodBeat.o(193906);
    return false;
  }
  
  public final boolean isResumed()
  {
    return this.mState >= 7;
  }
  
  public final boolean isStateSaved()
  {
    AppMethodBeat.i(193749);
    if (this.mFragmentManager == null)
    {
      AppMethodBeat.o(193749);
      return false;
    }
    boolean bool = this.mFragmentManager.isStateSaved();
    AppMethodBeat.o(193749);
    return bool;
  }
  
  public final boolean isVisible()
  {
    AppMethodBeat.i(193929);
    if ((isAdded()) && (!isHidden()) && (this.mView != null) && (this.mView.getWindowToken() != null) && (this.mView.getVisibility() == 0))
    {
      AppMethodBeat.o(193929);
      return true;
    }
    AppMethodBeat.o(193929);
    return false;
  }
  
  void noteStateNotSaved()
  {
    AppMethodBeat.i(194570);
    this.mChildFragmentManager.noteStateNotSaved();
    AppMethodBeat.o(194570);
  }
  
  @Deprecated
  public void onActivityCreated(Bundle paramBundle)
  {
    this.mCalled = true;
  }
  
  @Deprecated
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(194067);
    if (FragmentManager.isLoggingEnabled(2)) {
      new StringBuilder("Fragment ").append(this).append(" received the following in onActivityResult(): requestCode: ").append(paramInt1).append(" resultCode: ").append(paramInt2).append(" data: ").append(paramIntent);
    }
    AppMethodBeat.o(194067);
  }
  
  @Deprecated
  public void onAttach(Activity paramActivity)
  {
    this.mCalled = true;
  }
  
  public void onAttach(Context paramContext)
  {
    AppMethodBeat.i(194147);
    this.mCalled = true;
    if (this.mHost == null) {}
    for (paramContext = null;; paramContext = this.mHost.mActivity)
    {
      if (paramContext != null)
      {
        this.mCalled = false;
        onAttach(paramContext);
      }
      AppMethodBeat.o(194147);
      return;
    }
  }
  
  @Deprecated
  public void onAttachFragment(Fragment paramFragment) {}
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    this.mCalled = true;
  }
  
  public boolean onContextItemSelected(MenuItem paramMenuItem)
  {
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(194175);
    this.mCalled = true;
    restoreChildFragmentState(paramBundle);
    if (!this.mChildFragmentManager.isStateAtLeast(1)) {
      this.mChildFragmentManager.dispatchCreate();
    }
    AppMethodBeat.o(194175);
  }
  
  public Animation onCreateAnimation(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    return null;
  }
  
  public Animator onCreateAnimator(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    return null;
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(194320);
    requireActivity().onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    AppMethodBeat.o(194320);
  }
  
  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater) {}
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(194189);
    if (this.mContentLayoutId != 0)
    {
      paramLayoutInflater = paramLayoutInflater.inflate(this.mContentLayoutId, paramViewGroup, false);
      AppMethodBeat.o(194189);
      return paramLayoutInflater;
    }
    AppMethodBeat.o(194189);
    return null;
  }
  
  public void onDestroy()
  {
    this.mCalled = true;
  }
  
  public void onDestroyOptionsMenu() {}
  
  public void onDestroyView()
  {
    this.mCalled = true;
  }
  
  public void onDetach()
  {
    this.mCalled = true;
  }
  
  public LayoutInflater onGetLayoutInflater(Bundle paramBundle)
  {
    AppMethodBeat.i(194097);
    paramBundle = getLayoutInflater(paramBundle);
    AppMethodBeat.o(194097);
    return paramBundle;
  }
  
  public void onHiddenChanged(boolean paramBoolean) {}
  
  @Deprecated
  public void onInflate(Activity paramActivity, AttributeSet paramAttributeSet, Bundle paramBundle)
  {
    this.mCalled = true;
  }
  
  public void onInflate(Context paramContext, AttributeSet paramAttributeSet, Bundle paramBundle)
  {
    AppMethodBeat.i(194129);
    this.mCalled = true;
    if (this.mHost == null) {}
    for (paramContext = null;; paramContext = this.mHost.mActivity)
    {
      if (paramContext != null)
      {
        this.mCalled = false;
        onInflate(paramContext, paramAttributeSet, paramBundle);
      }
      AppMethodBeat.o(194129);
      return;
    }
  }
  
  public void onLowMemory()
  {
    this.mCalled = true;
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean) {}
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    return false;
  }
  
  public void onOptionsMenuClosed(Menu paramMenu) {}
  
  public void onPause()
  {
    this.mCalled = true;
  }
  
  public void onPictureInPictureModeChanged(boolean paramBoolean) {}
  
  public void onPrepareOptionsMenu(Menu paramMenu) {}
  
  public void onPrimaryNavigationFragmentChanged(boolean paramBoolean) {}
  
  @Deprecated
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt) {}
  
  public void onResume()
  {
    this.mCalled = true;
  }
  
  public void onSaveInstanceState(Bundle paramBundle) {}
  
  public void onStart()
  {
    this.mCalled = true;
  }
  
  public void onStop()
  {
    this.mCalled = true;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle) {}
  
  public void onViewStateRestored(Bundle paramBundle)
  {
    this.mCalled = true;
  }
  
  void performActivityCreated(Bundle paramBundle)
  {
    AppMethodBeat.i(194537);
    this.mChildFragmentManager.noteStateNotSaved();
    this.mState = 3;
    this.mCalled = false;
    onActivityCreated(paramBundle);
    if (!this.mCalled)
    {
      paramBundle = new z("Fragment " + this + " did not call through to super.onActivityCreated()");
      AppMethodBeat.o(194537);
      throw paramBundle;
    }
    restoreViewState();
    this.mChildFragmentManager.dispatchActivityCreated();
    AppMethodBeat.o(194537);
  }
  
  void performAttach()
  {
    AppMethodBeat.i(194510);
    Object localObject = this.mOnPreAttachedListeners.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((c)((Iterator)localObject).next()).Gd();
    }
    this.mOnPreAttachedListeners.clear();
    this.mChildFragmentManager.attachController(this.mHost, createFragmentContainer(), this);
    this.mState = 0;
    this.mCalled = false;
    onAttach(this.mHost.mContext);
    if (!this.mCalled)
    {
      localObject = new z("Fragment " + this + " did not call through to super.onAttach()");
      AppMethodBeat.o(194510);
      throw ((Throwable)localObject);
    }
    this.mFragmentManager.dispatchOnAttachFragment(this);
    this.mChildFragmentManager.dispatchAttach();
    AppMethodBeat.o(194510);
  }
  
  void performConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(194605);
    onConfigurationChanged(paramConfiguration);
    this.mChildFragmentManager.dispatchConfigurationChanged(paramConfiguration);
    AppMethodBeat.o(194605);
  }
  
  boolean performContextItemSelected(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(194658);
    if (!this.mHidden)
    {
      if (onContextItemSelected(paramMenuItem))
      {
        AppMethodBeat.o(194658);
        return true;
      }
      boolean bool = this.mChildFragmentManager.dispatchContextItemSelected(paramMenuItem);
      AppMethodBeat.o(194658);
      return bool;
    }
    AppMethodBeat.o(194658);
    return false;
  }
  
  void performCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(194516);
    this.mChildFragmentManager.noteStateNotSaved();
    this.mState = 1;
    this.mCalled = false;
    if (Build.VERSION.SDK_INT >= 19) {
      this.mLifecycleRegistry.addObserver(new o()
      {
        public void onStateChanged(q paramAnonymousq, j.a paramAnonymousa)
        {
          AppMethodBeat.i(193658);
          if ((paramAnonymousa == j.a.ON_STOP) && (Fragment.this.mView != null)) {
            Fragment.this.mView.cancelPendingInputEvents();
          }
          AppMethodBeat.o(193658);
        }
      });
    }
    this.mSavedStateRegistryController.n(paramBundle);
    onCreate(paramBundle);
    this.mIsCreated = true;
    if (!this.mCalled)
    {
      paramBundle = new z("Fragment " + this + " did not call through to super.onCreate()");
      AppMethodBeat.o(194516);
      throw paramBundle;
    }
    this.mLifecycleRegistry.a(j.a.ON_CREATE);
    AppMethodBeat.o(194516);
  }
  
  boolean performCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    AppMethodBeat.i(194624);
    boolean bool = false;
    int j = 0;
    if (!this.mHidden)
    {
      int i = j;
      if (this.mHasMenu)
      {
        i = j;
        if (this.mMenuVisible)
        {
          i = 1;
          onCreateOptionsMenu(paramMenu, paramMenuInflater);
        }
      }
      bool = i | this.mChildFragmentManager.dispatchCreateOptionsMenu(paramMenu, paramMenuInflater);
    }
    AppMethodBeat.o(194624);
    return bool;
  }
  
  void performCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    int i = 1;
    AppMethodBeat.i(194524);
    this.mChildFragmentManager.noteStateNotSaved();
    this.mPerformedCreateView = true;
    this.mViewLifecycleOwner = new v();
    this.mView = onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (this.mView != null)
    {
      this.mViewLifecycleOwner.initialize();
      al.a(this.mView, this.mViewLifecycleOwner);
      am.a(this.mView, this);
      e.b(this.mView, this.mViewLifecycleOwner);
      this.mViewLifecycleOwnerLiveData.setValue(this.mViewLifecycleOwner);
      AppMethodBeat.o(194524);
      return;
    }
    if (this.mViewLifecycleOwner.mLifecycleRegistry != null) {}
    while (i != 0)
    {
      paramLayoutInflater = new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
      AppMethodBeat.o(194524);
      throw paramLayoutInflater;
      i = 0;
    }
    this.mViewLifecycleOwner = null;
    AppMethodBeat.o(194524);
  }
  
  void performDestroy()
  {
    AppMethodBeat.i(194718);
    this.mChildFragmentManager.dispatchDestroy();
    this.mLifecycleRegistry.a(j.a.ON_DESTROY);
    this.mState = 0;
    this.mCalled = false;
    this.mIsCreated = false;
    onDestroy();
    if (!this.mCalled)
    {
      z localz = new z("Fragment " + this + " did not call through to super.onDestroy()");
      AppMethodBeat.o(194718);
      throw localz;
    }
    AppMethodBeat.o(194718);
  }
  
  void performDestroyView()
  {
    AppMethodBeat.i(194708);
    this.mChildFragmentManager.dispatchDestroyView();
    if ((this.mView != null) && (this.mViewLifecycleOwner.getLifecycle().getCurrentState().d(j.b.bHi))) {
      this.mViewLifecycleOwner.a(j.a.ON_DESTROY);
    }
    this.mState = 1;
    this.mCalled = false;
    onDestroyView();
    if (!this.mCalled)
    {
      z localz = new z("Fragment " + this + " did not call through to super.onDestroyView()");
      AppMethodBeat.o(194708);
      throw localz;
    }
    androidx.h.a.a.l(this).Hr();
    this.mPerformedCreateView = false;
    AppMethodBeat.o(194708);
  }
  
  void performDetach()
  {
    AppMethodBeat.i(194728);
    this.mState = -1;
    this.mCalled = false;
    onDetach();
    this.mLayoutInflater = null;
    if (!this.mCalled)
    {
      z localz = new z("Fragment " + this + " did not call through to super.onDetach()");
      AppMethodBeat.o(194728);
      throw localz;
    }
    if (!this.mChildFragmentManager.isDestroyed())
    {
      this.mChildFragmentManager.dispatchDestroy();
      this.mChildFragmentManager = new FragmentManagerImpl();
    }
    AppMethodBeat.o(194728);
  }
  
  LayoutInflater performGetLayoutInflater(Bundle paramBundle)
  {
    AppMethodBeat.i(194113);
    this.mLayoutInflater = onGetLayoutInflater(paramBundle);
    paramBundle = this.mLayoutInflater;
    AppMethodBeat.o(194113);
    return paramBundle;
  }
  
  void performLowMemory()
  {
    AppMethodBeat.i(194613);
    onLowMemory();
    this.mChildFragmentManager.dispatchLowMemory();
    AppMethodBeat.o(194613);
  }
  
  void performMultiWindowModeChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(194588);
    onMultiWindowModeChanged(paramBoolean);
    this.mChildFragmentManager.dispatchMultiWindowModeChanged(paramBoolean);
    AppMethodBeat.o(194588);
  }
  
  boolean performOptionsItemSelected(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(194648);
    if (!this.mHidden)
    {
      if ((this.mHasMenu) && (this.mMenuVisible) && (onOptionsItemSelected(paramMenuItem)))
      {
        AppMethodBeat.o(194648);
        return true;
      }
      boolean bool = this.mChildFragmentManager.dispatchOptionsItemSelected(paramMenuItem);
      AppMethodBeat.o(194648);
      return bool;
    }
    AppMethodBeat.o(194648);
    return false;
  }
  
  void performOptionsMenuClosed(Menu paramMenu)
  {
    AppMethodBeat.i(194668);
    if (!this.mHidden)
    {
      if ((this.mHasMenu) && (this.mMenuVisible)) {
        onOptionsMenuClosed(paramMenu);
      }
      this.mChildFragmentManager.dispatchOptionsMenuClosed(paramMenu);
    }
    AppMethodBeat.o(194668);
  }
  
  void performPause()
  {
    AppMethodBeat.i(194689);
    this.mChildFragmentManager.dispatchPause();
    if (this.mView != null) {
      this.mViewLifecycleOwner.a(j.a.ON_PAUSE);
    }
    this.mLifecycleRegistry.a(j.a.ON_PAUSE);
    this.mState = 6;
    this.mCalled = false;
    onPause();
    if (!this.mCalled)
    {
      z localz = new z("Fragment " + this + " did not call through to super.onPause()");
      AppMethodBeat.o(194689);
      throw localz;
    }
    AppMethodBeat.o(194689);
  }
  
  void performPictureInPictureModeChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(194597);
    onPictureInPictureModeChanged(paramBoolean);
    this.mChildFragmentManager.dispatchPictureInPictureModeChanged(paramBoolean);
    AppMethodBeat.o(194597);
  }
  
  boolean performPrepareOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(194635);
    boolean bool = false;
    int j = 0;
    if (!this.mHidden)
    {
      int i = j;
      if (this.mHasMenu)
      {
        i = j;
        if (this.mMenuVisible)
        {
          i = 1;
          onPrepareOptionsMenu(paramMenu);
        }
      }
      bool = i | this.mChildFragmentManager.dispatchPrepareOptionsMenu(paramMenu);
    }
    AppMethodBeat.o(194635);
    return bool;
  }
  
  void performPrimaryNavigationFragmentChanged()
  {
    AppMethodBeat.i(194578);
    boolean bool = this.mFragmentManager.isPrimaryNavigation(this);
    if ((this.mIsPrimaryNavigationFragment == null) || (this.mIsPrimaryNavigationFragment.booleanValue() != bool))
    {
      this.mIsPrimaryNavigationFragment = Boolean.valueOf(bool);
      onPrimaryNavigationFragmentChanged(bool);
      this.mChildFragmentManager.dispatchPrimaryNavigationFragmentChanged();
    }
    AppMethodBeat.o(194578);
  }
  
  void performResume()
  {
    AppMethodBeat.i(194558);
    this.mChildFragmentManager.noteStateNotSaved();
    this.mChildFragmentManager.execPendingActions(true);
    this.mState = 7;
    this.mCalled = false;
    onResume();
    if (!this.mCalled)
    {
      z localz = new z("Fragment " + this + " did not call through to super.onResume()");
      AppMethodBeat.o(194558);
      throw localz;
    }
    this.mLifecycleRegistry.a(j.a.ON_RESUME);
    if (this.mView != null) {
      this.mViewLifecycleOwner.a(j.a.ON_RESUME);
    }
    this.mChildFragmentManager.dispatchResume();
    AppMethodBeat.o(194558);
  }
  
  void performSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(194676);
    onSaveInstanceState(paramBundle);
    this.mSavedStateRegistryController.m(paramBundle);
    Parcelable localParcelable = this.mChildFragmentManager.saveAllState();
    if (localParcelable != null) {
      paramBundle.putParcelable("android:support:fragments", localParcelable);
    }
    AppMethodBeat.o(194676);
  }
  
  void performStart()
  {
    AppMethodBeat.i(194550);
    this.mChildFragmentManager.noteStateNotSaved();
    this.mChildFragmentManager.execPendingActions(true);
    this.mState = 5;
    this.mCalled = false;
    onStart();
    if (!this.mCalled)
    {
      z localz = new z("Fragment " + this + " did not call through to super.onStart()");
      AppMethodBeat.o(194550);
      throw localz;
    }
    this.mLifecycleRegistry.a(j.a.ON_START);
    if (this.mView != null) {
      this.mViewLifecycleOwner.a(j.a.ON_START);
    }
    this.mChildFragmentManager.dispatchStart();
    AppMethodBeat.o(194550);
  }
  
  void performStop()
  {
    AppMethodBeat.i(194699);
    this.mChildFragmentManager.dispatchStop();
    if (this.mView != null) {
      this.mViewLifecycleOwner.a(j.a.ON_STOP);
    }
    this.mLifecycleRegistry.a(j.a.ON_STOP);
    this.mState = 4;
    this.mCalled = false;
    onStop();
    if (!this.mCalled)
    {
      z localz = new z("Fragment " + this + " did not call through to super.onStop()");
      AppMethodBeat.o(194699);
      throw localz;
    }
    AppMethodBeat.o(194699);
  }
  
  void performViewCreated()
  {
    AppMethodBeat.i(194533);
    onViewCreated(this.mView, this.mSavedFragmentState);
    this.mChildFragmentManager.dispatchViewCreated();
    AppMethodBeat.o(194533);
  }
  
  public void postponeEnterTransition()
  {
    AppMethodBeat.i(194447);
    ensureAnimationInfo().bCr = true;
    AppMethodBeat.o(194447);
  }
  
  public final void postponeEnterTransition(long paramLong, TimeUnit paramTimeUnit)
  {
    AppMethodBeat.i(194457);
    ensureAnimationInfo().bCr = true;
    if (this.mFragmentManager != null) {}
    for (Handler localHandler = this.mFragmentManager.getHost().mHandler;; localHandler = new Handler(Looper.getMainLooper()))
    {
      localHandler.removeCallbacks(this.mPostponedDurationRunnable);
      localHandler.postDelayed(this.mPostponedDurationRunnable, paramTimeUnit.toMillis(paramLong));
      AppMethodBeat.o(194457);
      return;
    }
  }
  
  public final <I, O> androidx.activity.result.b<I> registerForActivityResult(androidx.activity.result.a.a<I, O> parama, androidx.activity.result.a<O> parama1)
  {
    AppMethodBeat.i(194940);
    parama = prepareCallInternal(parama, new androidx.a.a.c.a() {}, parama1);
    AppMethodBeat.o(194940);
    return parama;
  }
  
  public final <I, O> androidx.activity.result.b<I> registerForActivityResult(androidx.activity.result.a.a<I, O> parama, final androidx.activity.result.c paramc, androidx.activity.result.a<O> parama1)
  {
    AppMethodBeat.i(194951);
    parama = prepareCallInternal(parama, new androidx.a.a.c.a() {}, parama1);
    AppMethodBeat.o(194951);
    return parama;
  }
  
  public void registerForContextMenu(View paramView)
  {
    AppMethodBeat.i(194325);
    paramView.setOnCreateContextMenuListener(this);
    AppMethodBeat.o(194325);
  }
  
  @Deprecated
  public final void requestPermissions(String[] paramArrayOfString, int paramInt)
  {
    AppMethodBeat.i(194074);
    if (this.mHost == null)
    {
      paramArrayOfString = new IllegalStateException("Fragment " + this + " not attached to Activity");
      AppMethodBeat.o(194074);
      throw paramArrayOfString;
    }
    getParentFragmentManager().launchRequestPermissions(this, paramArrayOfString, paramInt);
    AppMethodBeat.o(194074);
  }
  
  public final FragmentActivity requireActivity()
  {
    AppMethodBeat.i(193811);
    Object localObject = getActivity();
    if (localObject == null)
    {
      localObject = new IllegalStateException("Fragment " + this + " not attached to an activity.");
      AppMethodBeat.o(193811);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(193811);
    return localObject;
  }
  
  public final Bundle requireArguments()
  {
    AppMethodBeat.i(193739);
    Object localObject = getArguments();
    if (localObject == null)
    {
      localObject = new IllegalStateException("Fragment " + this + " does not have any arguments.");
      AppMethodBeat.o(193739);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(193739);
    return localObject;
  }
  
  public final Context requireContext()
  {
    AppMethodBeat.i(193795);
    Object localObject = getContext();
    if (localObject == null)
    {
      localObject = new IllegalStateException("Fragment " + this + " not attached to a context.");
      AppMethodBeat.o(193795);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(193795);
    return localObject;
  }
  
  @Deprecated
  public final FragmentManager requireFragmentManager()
  {
    AppMethodBeat.i(193871);
    FragmentManager localFragmentManager = getParentFragmentManager();
    AppMethodBeat.o(193871);
    return localFragmentManager;
  }
  
  public final Object requireHost()
  {
    AppMethodBeat.i(193824);
    Object localObject = getHost();
    if (localObject == null)
    {
      localObject = new IllegalStateException("Fragment " + this + " not attached to a host.");
      AppMethodBeat.o(193824);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(193824);
    return localObject;
  }
  
  public final Fragment requireParentFragment()
  {
    AppMethodBeat.i(193884);
    Object localObject = getParentFragment();
    if (localObject == null)
    {
      if (getContext() == null)
      {
        localObject = new IllegalStateException("Fragment " + this + " is not attached to any Fragment or host");
        AppMethodBeat.o(193884);
        throw ((Throwable)localObject);
      }
      localObject = new IllegalStateException("Fragment " + this + " is not a child Fragment, it is directly attached to " + getContext());
      AppMethodBeat.o(193884);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(193884);
    return localObject;
  }
  
  public final View requireView()
  {
    AppMethodBeat.i(194197);
    Object localObject = getView();
    if (localObject == null)
    {
      localObject = new IllegalStateException("Fragment " + this + " did not return a View from onCreateView() or this was called before onCreateView().");
      AppMethodBeat.o(194197);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(194197);
    return localObject;
  }
  
  void restoreChildFragmentState(Bundle paramBundle)
  {
    AppMethodBeat.i(194181);
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getParcelable("android:support:fragments");
      if (paramBundle != null)
      {
        this.mChildFragmentManager.restoreSaveState(paramBundle);
        this.mChildFragmentManager.dispatchCreate();
      }
    }
    AppMethodBeat.o(194181);
  }
  
  final void restoreViewState(Bundle paramBundle)
  {
    AppMethodBeat.i(193674);
    if (this.mSavedViewState != null)
    {
      this.mView.restoreHierarchyState(this.mSavedViewState);
      this.mSavedViewState = null;
    }
    if (this.mView != null)
    {
      v localv = this.mViewLifecycleOwner;
      Bundle localBundle = this.mSavedViewRegistryState;
      localv.mSavedStateRegistryController.n(localBundle);
      this.mSavedViewRegistryState = null;
    }
    this.mCalled = false;
    onViewStateRestored(paramBundle);
    if (!this.mCalled)
    {
      paramBundle = new z("Fragment " + this + " did not call through to super.onViewStateRestored()");
      AppMethodBeat.o(193674);
      throw paramBundle;
    }
    if (this.mView != null) {
      this.mViewLifecycleOwner.a(j.a.ON_CREATE);
    }
    AppMethodBeat.o(193674);
  }
  
  public void setAllowEnterTransitionOverlap(boolean paramBoolean)
  {
    AppMethodBeat.i(194419);
    ensureAnimationInfo().bCm = Boolean.valueOf(paramBoolean);
    AppMethodBeat.o(194419);
  }
  
  public void setAllowReturnTransitionOverlap(boolean paramBoolean)
  {
    AppMethodBeat.i(194433);
    ensureAnimationInfo().bCl = Boolean.valueOf(paramBoolean);
    AppMethodBeat.o(194433);
  }
  
  void setAnimatingAway(View paramView)
  {
    AppMethodBeat.i(194868);
    ensureAnimationInfo().bBY = paramView;
    AppMethodBeat.o(194868);
  }
  
  void setAnimations(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(194748);
    if ((this.mAnimationInfo == null) && (paramInt1 == 0) && (paramInt2 == 0) && (paramInt3 == 0) && (paramInt4 == 0))
    {
      AppMethodBeat.o(194748);
      return;
    }
    ensureAnimationInfo().bCa = paramInt1;
    ensureAnimationInfo().bCb = paramInt2;
    ensureAnimationInfo().bCc = paramInt3;
    ensureAnimationInfo().bCd = paramInt4;
    AppMethodBeat.o(194748);
  }
  
  void setAnimator(Animator paramAnimator)
  {
    AppMethodBeat.i(194878);
    ensureAnimationInfo().bBZ = paramAnimator;
    AppMethodBeat.o(194878);
  }
  
  public void setArguments(Bundle paramBundle)
  {
    AppMethodBeat.i(193724);
    if ((this.mFragmentManager != null) && (isStateSaved()))
    {
      paramBundle = new IllegalStateException("Fragment already added and state has been saved");
      AppMethodBeat.o(193724);
      throw paramBundle;
    }
    this.mArguments = paramBundle;
    AppMethodBeat.o(193724);
  }
  
  public void setEnterSharedElementCallback(l paraml)
  {
    AppMethodBeat.i(194340);
    ensureAnimationInfo().bCn = paraml;
    AppMethodBeat.o(194340);
  }
  
  public void setEnterTransition(Object paramObject)
  {
    AppMethodBeat.i(194347);
    ensureAnimationInfo().bCf = paramObject;
    AppMethodBeat.o(194347);
  }
  
  public void setExitSharedElementCallback(l paraml)
  {
    AppMethodBeat.i(194343);
    ensureAnimationInfo().bCo = paraml;
    AppMethodBeat.o(194343);
  }
  
  public void setExitTransition(Object paramObject)
  {
    AppMethodBeat.i(194370);
    ensureAnimationInfo().bCh = paramObject;
    AppMethodBeat.o(194370);
  }
  
  void setFocusedView(View paramView)
  {
    AppMethodBeat.i(194901);
    ensureAnimationInfo().bCq = paramView;
    AppMethodBeat.o(194901);
  }
  
  public void setHasOptionsMenu(boolean paramBoolean)
  {
    AppMethodBeat.i(193975);
    if (this.mHasMenu != paramBoolean)
    {
      this.mHasMenu = paramBoolean;
      if ((isAdded()) && (!isHidden())) {
        this.mHost.Gi();
      }
    }
    AppMethodBeat.o(193975);
  }
  
  void setHideReplaced(boolean paramBoolean)
  {
    AppMethodBeat.i(194928);
    ensureAnimationInfo().bCt = paramBoolean;
    AppMethodBeat.o(194928);
  }
  
  public void setInitialSavedState(SavedState paramSavedState)
  {
    AppMethodBeat.i(193756);
    if (this.mFragmentManager != null)
    {
      paramSavedState = new IllegalStateException("Fragment already added");
      AppMethodBeat.o(193756);
      throw paramSavedState;
    }
    if ((paramSavedState != null) && (paramSavedState.bCu != null)) {}
    for (paramSavedState = paramSavedState.bCu;; paramSavedState = null)
    {
      this.mSavedFragmentState = paramSavedState;
      AppMethodBeat.o(193756);
      return;
    }
  }
  
  public void setMenuVisibility(boolean paramBoolean)
  {
    AppMethodBeat.i(193983);
    if (this.mMenuVisible != paramBoolean)
    {
      this.mMenuVisible = paramBoolean;
      if ((this.mHasMenu) && (isAdded()) && (!isHidden())) {
        this.mHost.Gi();
      }
    }
    AppMethodBeat.o(193983);
  }
  
  void setNextTransition(int paramInt)
  {
    AppMethodBeat.i(194810);
    if ((this.mAnimationInfo == null) && (paramInt == 0))
    {
      AppMethodBeat.o(194810);
      return;
    }
    ensureAnimationInfo();
    this.mAnimationInfo.bCe = paramInt;
    AppMethodBeat.o(194810);
  }
  
  void setOnStartEnterTransitionListener(d paramd)
  {
    AppMethodBeat.i(194737);
    ensureAnimationInfo();
    if (paramd == this.mAnimationInfo.bCs)
    {
      AppMethodBeat.o(194737);
      return;
    }
    if ((paramd != null) && (this.mAnimationInfo.bCs != null))
    {
      paramd = new IllegalStateException("Trying to set a replacement startPostponedEnterTransition on ".concat(String.valueOf(this)));
      AppMethodBeat.o(194737);
      throw paramd;
    }
    if (this.mAnimationInfo.bCr) {
      this.mAnimationInfo.bCs = paramd;
    }
    if (paramd != null) {
      paramd.Gf();
    }
    AppMethodBeat.o(194737);
  }
  
  void setPopDirection(boolean paramBoolean)
  {
    AppMethodBeat.i(194789);
    if (this.mAnimationInfo == null)
    {
      AppMethodBeat.o(194789);
      return;
    }
    ensureAnimationInfo().bBJ = paramBoolean;
    AppMethodBeat.o(194789);
  }
  
  void setPostOnViewCreatedAlpha(float paramFloat)
  {
    AppMethodBeat.i(194889);
    ensureAnimationInfo().bCp = paramFloat;
    AppMethodBeat.o(194889);
  }
  
  public void setReenterTransition(Object paramObject)
  {
    AppMethodBeat.i(194381);
    ensureAnimationInfo().bCi = paramObject;
    AppMethodBeat.o(194381);
  }
  
  @Deprecated
  public void setRetainInstance(boolean paramBoolean)
  {
    AppMethodBeat.i(193957);
    this.mRetainInstance = paramBoolean;
    if (this.mFragmentManager != null)
    {
      if (paramBoolean)
      {
        this.mFragmentManager.addRetainedFragment(this);
        AppMethodBeat.o(193957);
        return;
      }
      this.mFragmentManager.removeRetainedFragment(this);
      AppMethodBeat.o(193957);
      return;
    }
    this.mRetainInstanceChangedWhileDetached = true;
    AppMethodBeat.o(193957);
  }
  
  public void setReturnTransition(Object paramObject)
  {
    AppMethodBeat.i(194356);
    ensureAnimationInfo().bCg = paramObject;
    AppMethodBeat.o(194356);
  }
  
  public void setSharedElementEnterTransition(Object paramObject)
  {
    AppMethodBeat.i(194393);
    ensureAnimationInfo().bCj = paramObject;
    AppMethodBeat.o(194393);
  }
  
  void setSharedElementNames(ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2)
  {
    AppMethodBeat.i(194839);
    ensureAnimationInfo();
    this.mAnimationInfo.bBo = paramArrayList1;
    this.mAnimationInfo.bBp = paramArrayList2;
    AppMethodBeat.o(194839);
  }
  
  public void setSharedElementReturnTransition(Object paramObject)
  {
    AppMethodBeat.i(194405);
    ensureAnimationInfo().bCk = paramObject;
    AppMethodBeat.o(194405);
  }
  
  @Deprecated
  public void setTargetFragment(Fragment paramFragment, int paramInt)
  {
    AppMethodBeat.i(193767);
    FragmentManager localFragmentManager = this.mFragmentManager;
    if (paramFragment != null) {}
    for (Object localObject = paramFragment.mFragmentManager; (localFragmentManager != null) && (localObject != null) && (localFragmentManager != localObject); localObject = null)
    {
      paramFragment = new IllegalArgumentException("Fragment " + paramFragment + " must share the same FragmentManager to be set as a target fragment");
      AppMethodBeat.o(193767);
      throw paramFragment;
    }
    for (localObject = paramFragment; localObject != null; localObject = ((Fragment)localObject).getTargetFragment()) {
      if (((Fragment)localObject).equals(this))
      {
        paramFragment = new IllegalArgumentException("Setting " + paramFragment + " as the target of " + this + " would create a target cycle");
        AppMethodBeat.o(193767);
        throw paramFragment;
      }
    }
    if (paramFragment == null)
    {
      this.mTargetWho = null;
      this.mTarget = null;
    }
    for (;;)
    {
      this.mTargetRequestCode = paramInt;
      AppMethodBeat.o(193767);
      return;
      if ((this.mFragmentManager != null) && (paramFragment.mFragmentManager != null))
      {
        this.mTargetWho = paramFragment.mWho;
        this.mTarget = null;
      }
      else
      {
        this.mTargetWho = null;
        this.mTarget = paramFragment;
      }
    }
  }
  
  @Deprecated
  public void setUserVisibleHint(boolean paramBoolean)
  {
    AppMethodBeat.i(193994);
    if ((!this.mUserVisibleHint) && (paramBoolean) && (this.mState < 5) && (this.mFragmentManager != null) && (isAdded()) && (this.mIsCreated)) {
      this.mFragmentManager.performPendingDeferredStart(this.mFragmentManager.createOrGetFragmentStateManager(this));
    }
    this.mUserVisibleHint = paramBoolean;
    if ((this.mState < 5) && (!paramBoolean)) {}
    for (boolean bool = true;; bool = false)
    {
      this.mDeferStart = bool;
      if (this.mSavedFragmentState != null) {
        this.mSavedUserVisibleHint = Boolean.valueOf(paramBoolean);
      }
      AppMethodBeat.o(193994);
      return;
    }
  }
  
  public boolean shouldShowRequestPermissionRationale(String paramString)
  {
    AppMethodBeat.i(194087);
    if (this.mHost != null)
    {
      boolean bool = this.mHost.aF(paramString);
      AppMethodBeat.o(194087);
      return bool;
    }
    AppMethodBeat.o(194087);
    return false;
  }
  
  public void startActivity(Intent paramIntent)
  {
    AppMethodBeat.i(194020);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(null).cG(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.b(this, paramIntent.aYi(), "androidx/fragment/app/Fragment", "startActivity", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
    startActivity((Intent)paramIntent.sb(0), (Bundle)paramIntent.sb(1));
    com.tencent.mm.hellhoundlib.a.a.c(this, "androidx/fragment/app/Fragment", "startActivity", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
    AppMethodBeat.o(194020);
  }
  
  public void startActivity(Intent paramIntent, Bundle paramBundle)
  {
    AppMethodBeat.i(194028);
    if (this.mHost == null)
    {
      paramIntent = new IllegalStateException("Fragment " + this + " not attached to Activity");
      AppMethodBeat.o(194028);
      throw paramIntent;
    }
    this.mHost.a(paramIntent, -1, paramBundle);
    AppMethodBeat.o(194028);
  }
  
  @Deprecated
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(194041);
    startActivityForResult(paramIntent, paramInt, null);
    AppMethodBeat.o(194041);
  }
  
  @Deprecated
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(194049);
    if (this.mHost == null)
    {
      paramIntent = new IllegalStateException("Fragment " + this + " not attached to Activity");
      AppMethodBeat.o(194049);
      throw paramIntent;
    }
    getParentFragmentManager().launchStartActivityForResult(this, paramIntent, paramInt, paramBundle);
    AppMethodBeat.o(194049);
  }
  
  @Deprecated
  public void startIntentSenderForResult(IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4, Bundle paramBundle)
  {
    AppMethodBeat.i(194059);
    if (this.mHost == null)
    {
      paramIntentSender = new IllegalStateException("Fragment " + this + " not attached to Activity");
      AppMethodBeat.o(194059);
      throw paramIntentSender;
    }
    if (FragmentManager.isLoggingEnabled(2)) {
      new StringBuilder("Fragment ").append(this).append(" received the following in startIntentSenderForResult() requestCode: ").append(paramInt1).append(" IntentSender: ").append(paramIntentSender).append(" fillInIntent: ").append(paramIntent).append(" options: ").append(paramBundle);
    }
    getParentFragmentManager().launchStartIntentSenderForResult(this, paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
    AppMethodBeat.o(194059);
  }
  
  public void startPostponedEnterTransition()
  {
    AppMethodBeat.i(194465);
    if ((this.mAnimationInfo == null) || (!ensureAnimationInfo().bCr))
    {
      AppMethodBeat.o(194465);
      return;
    }
    if (this.mHost == null)
    {
      ensureAnimationInfo().bCr = false;
      AppMethodBeat.o(194465);
      return;
    }
    if (Looper.myLooper() != this.mHost.mHandler.getLooper())
    {
      this.mHost.mHandler.postAtFrontOfQueue(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(193625);
          Fragment.this.callStartTransitionListener(false);
          AppMethodBeat.o(193625);
        }
      });
      AppMethodBeat.o(194465);
      return;
    }
    callStartTransitionListener(true);
    AppMethodBeat.o(194465);
  }
  
  public String toString()
  {
    AppMethodBeat.i(193705);
    Object localObject = new StringBuilder(128);
    ((StringBuilder)localObject).append(getClass().getSimpleName());
    ((StringBuilder)localObject).append("{");
    ((StringBuilder)localObject).append(Integer.toHexString(System.identityHashCode(this)));
    ((StringBuilder)localObject).append("}");
    ((StringBuilder)localObject).append(" (");
    ((StringBuilder)localObject).append(this.mWho);
    if (this.mFragmentId != 0)
    {
      ((StringBuilder)localObject).append(" id=0x");
      ((StringBuilder)localObject).append(Integer.toHexString(this.mFragmentId));
    }
    if (this.mTag != null)
    {
      ((StringBuilder)localObject).append(" tag=");
      ((StringBuilder)localObject).append(this.mTag);
    }
    ((StringBuilder)localObject).append(")");
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(193705);
    return localObject;
  }
  
  public void unregisterForContextMenu(View paramView)
  {
    AppMethodBeat.i(194330);
    paramView.setOnCreateContextMenuListener(null);
    AppMethodBeat.o(194330);
  }
  
  public static class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<SavedState> CREATOR;
    final Bundle bCu;
    
    static
    {
      AppMethodBeat.i(193623);
      CREATOR = new Parcelable.ClassLoaderCreator() {};
      AppMethodBeat.o(193623);
    }
    
    SavedState(Bundle paramBundle)
    {
      this.bCu = paramBundle;
    }
    
    SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      AppMethodBeat.i(193611);
      this.bCu = paramParcel.readBundle();
      if ((paramClassLoader != null) && (this.bCu != null)) {
        this.bCu.setClassLoader(paramClassLoader);
      }
      AppMethodBeat.o(193611);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(193652);
      paramParcel.writeBundle(this.bCu);
      AppMethodBeat.o(193652);
    }
  }
  
  static class a
  {
    boolean bBJ;
    View bBY;
    Animator bBZ;
    ArrayList<String> bBo;
    ArrayList<String> bBp;
    int bCa;
    int bCb;
    int bCc;
    int bCd;
    int bCe;
    Object bCf = null;
    Object bCg = Fragment.USE_DEFAULT_TRANSITION;
    Object bCh = null;
    Object bCi = Fragment.USE_DEFAULT_TRANSITION;
    Object bCj = null;
    Object bCk = Fragment.USE_DEFAULT_TRANSITION;
    Boolean bCl;
    Boolean bCm;
    l bCn = null;
    l bCo = null;
    float bCp = 1.0F;
    View bCq = null;
    boolean bCr;
    Fragment.d bCs;
    boolean bCt;
  }
  
  public static final class b
    extends RuntimeException
  {
    public b(String paramString, Exception paramException)
    {
      super(paramException);
    }
  }
  
  static abstract class c
  {
    abstract void Gd();
  }
  
  static abstract interface d
  {
    public abstract void Ge();
    
    public abstract void Gf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.fragment.app.Fragment
 * JD-Core Version:    0.7.0.1
 */