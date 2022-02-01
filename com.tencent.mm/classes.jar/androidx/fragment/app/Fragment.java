package androidx.fragment.app;

import android.animation.Animator;
import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.content.res.Resources;
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
import androidx.core.app.k;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.aa;
import androidx.lifecycle.ab;
import androidx.lifecycle.h;
import androidx.lifecycle.h.a;
import androidx.lifecycle.l;
import androidx.lifecycle.m;
import androidx.lifecycle.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Fragment
  implements ComponentCallbacks, View.OnCreateContextMenuListener, ab, l
{
  static final int ACTIVITY_CREATED = 2;
  static final int CREATED = 1;
  static final int INITIALIZING = 0;
  static final int RESUMED = 4;
  static final int STARTED = 3;
  static final Object USE_DEFAULT_TRANSITION;
  private static final androidx.b.g<String, Class<?>> sClassMap;
  private byte _hellAccFlag_;
  boolean mAdded;
  a mAnimationInfo;
  Bundle mArguments;
  int mBackStackNesting;
  boolean mCalled;
  FragmentManagerImpl mChildFragmentManager;
  f mChildNonConfig;
  ViewGroup mContainer;
  int mContainerId;
  boolean mDeferStart;
  boolean mDetached;
  int mFragmentId;
  FragmentManagerImpl mFragmentManager;
  boolean mFromLayout;
  boolean mHasMenu;
  boolean mHidden;
  boolean mHiddenChanged;
  d mHost;
  boolean mInLayout;
  int mIndex;
  View mInnerView;
  boolean mIsCreated;
  boolean mIsNewlyAdded;
  LayoutInflater mLayoutInflater;
  m mLifecycleRegistry;
  boolean mMenuVisible;
  Fragment mParentFragment;
  boolean mPerformedCreateView;
  float mPostponedAlpha;
  boolean mRemoving;
  boolean mRestored;
  boolean mRetainInstance;
  boolean mRetaining;
  Bundle mSavedFragmentState;
  Boolean mSavedUserVisibleHint;
  SparseArray<Parcelable> mSavedViewState;
  int mState;
  String mTag;
  Fragment mTarget;
  int mTargetIndex;
  int mTargetRequestCode;
  boolean mUserVisibleHint;
  View mView;
  l mViewLifecycleOwner;
  r<l> mViewLifecycleOwnerLiveData;
  m mViewLifecycleRegistry;
  aa mViewModelStore;
  String mWho;
  
  static
  {
    AppMethodBeat.i(212275);
    sClassMap = new androidx.b.g();
    USE_DEFAULT_TRANSITION = new Object();
    AppMethodBeat.o(212275);
  }
  
  public Fragment()
  {
    AppMethodBeat.i(212004);
    this.mState = 0;
    this.mIndex = -1;
    this.mTargetIndex = -1;
    this.mMenuVisible = true;
    this.mUserVisibleHint = true;
    this.mLifecycleRegistry = new m(this);
    this.mViewLifecycleOwnerLiveData = new r();
    AppMethodBeat.o(212004);
  }
  
  private a ensureAnimationInfo()
  {
    AppMethodBeat.i(212251);
    if (this.mAnimationInfo == null) {
      this.mAnimationInfo = new a();
    }
    a locala = this.mAnimationInfo;
    AppMethodBeat.o(212251);
    return locala;
  }
  
  public static Fragment instantiate(Context paramContext, String paramString)
  {
    AppMethodBeat.i(212006);
    paramContext = instantiate(paramContext, paramString, null);
    AppMethodBeat.o(212006);
    return paramContext;
  }
  
  public static Fragment instantiate(Context paramContext, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(212011);
    try
    {
      Class localClass2 = (Class)sClassMap.get(paramString);
      Class localClass1 = localClass2;
      if (localClass2 == null)
      {
        localClass1 = paramContext.getClassLoader().loadClass(paramString);
        sClassMap.put(paramString, localClass1);
      }
      paramContext = (Fragment)localClass1.getConstructor(new Class[0]).newInstance(new Object[0]);
      if (paramBundle != null)
      {
        paramBundle.setClassLoader(paramContext.getClass().getClassLoader());
        paramContext.setArguments(paramBundle);
      }
      AppMethodBeat.o(212011);
      return paramContext;
    }
    catch (ClassNotFoundException paramContext)
    {
      paramContext = new b("Unable to instantiate fragment " + paramString + ": make sure class name exists, is public, and has an empty constructor that is public", paramContext);
      AppMethodBeat.o(212011);
      throw paramContext;
    }
    catch (InstantiationException paramContext)
    {
      paramContext = new b("Unable to instantiate fragment " + paramString + ": make sure class name exists, is public, and has an empty constructor that is public", paramContext);
      AppMethodBeat.o(212011);
      throw paramContext;
    }
    catch (IllegalAccessException paramContext)
    {
      paramContext = new b("Unable to instantiate fragment " + paramString + ": make sure class name exists, is public, and has an empty constructor that is public", paramContext);
      AppMethodBeat.o(212011);
      throw paramContext;
    }
    catch (NoSuchMethodException paramContext)
    {
      paramContext = new b("Unable to instantiate fragment " + paramString + ": could not find Fragment constructor", paramContext);
      AppMethodBeat.o(212011);
      throw paramContext;
    }
    catch (InvocationTargetException paramContext)
    {
      paramContext = new b("Unable to instantiate fragment " + paramString + ": calling Fragment constructor caused an exception", paramContext);
      AppMethodBeat.o(212011);
      throw paramContext;
    }
  }
  
  static boolean isSupportFragmentClass(Context paramContext, String paramString)
  {
    AppMethodBeat.i(212015);
    try
    {
      Class localClass2 = (Class)sClassMap.get(paramString);
      Class localClass1 = localClass2;
      if (localClass2 == null)
      {
        localClass1 = paramContext.getClassLoader().loadClass(paramString);
        sClassMap.put(paramString, localClass1);
      }
      boolean bool = Fragment.class.isAssignableFrom(localClass1);
      AppMethodBeat.o(212015);
      return bool;
    }
    catch (ClassNotFoundException paramContext)
    {
      AppMethodBeat.o(212015);
    }
    return false;
  }
  
  void callStartTransitionListener()
  {
    c localc = null;
    AppMethodBeat.i(212213);
    if (this.mAnimationInfo == null) {}
    for (;;)
    {
      if (localc != null) {
        localc.iu();
      }
      AppMethodBeat.o(212213);
      return;
      this.mAnimationInfo.VE = false;
      localc = this.mAnimationInfo.VF;
      this.mAnimationInfo.VF = null;
    }
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    AppMethodBeat.i(212215);
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
    paramPrintWriter.print(" mIndex=");
    paramPrintWriter.print(this.mIndex);
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
    paramPrintWriter.print(" mRetaining=");
    paramPrintWriter.print(this.mRetaining);
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
    if (this.mTarget != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mTarget=");
      paramPrintWriter.print(this.mTarget);
      paramPrintWriter.print(" mTargetRequestCode=");
      paramPrintWriter.println(this.mTargetRequestCode);
    }
    if (getNextAnim() != 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mNextAnim=");
      paramPrintWriter.println(getNextAnim());
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
    if (this.mInnerView != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mInnerView=");
      paramPrintWriter.println(this.mView);
    }
    if (getAnimatingAway() != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mAnimatingAway=");
      paramPrintWriter.println(getAnimatingAway());
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mStateAfterAnimating=");
      paramPrintWriter.println(getStateAfterAnimating());
    }
    if (getContext() != null) {
      androidx.g.a.a.e(this).dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
    if (this.mChildFragmentManager != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Child " + this.mChildFragmentManager + ":");
      this.mChildFragmentManager.dump(paramString + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
    AppMethodBeat.o(212215);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(212029);
    boolean bool = super.equals(paramObject);
    AppMethodBeat.o(212029);
    return bool;
  }
  
  Fragment findFragmentByWho(String paramString)
  {
    AppMethodBeat.i(212217);
    if (paramString.equals(this.mWho))
    {
      AppMethodBeat.o(212217);
      return this;
    }
    if (this.mChildFragmentManager != null)
    {
      paramString = this.mChildFragmentManager.findFragmentByWho(paramString);
      AppMethodBeat.o(212217);
      return paramString;
    }
    AppMethodBeat.o(212217);
    return null;
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
    AppMethodBeat.i(212204);
    if ((this.mAnimationInfo == null) || (this.mAnimationInfo.VB == null))
    {
      AppMethodBeat.o(212204);
      return true;
    }
    boolean bool = this.mAnimationInfo.VB.booleanValue();
    AppMethodBeat.o(212204);
    return bool;
  }
  
  public boolean getAllowReturnTransitionOverlap()
  {
    AppMethodBeat.i(212209);
    if ((this.mAnimationInfo == null) || (this.mAnimationInfo.VA == null))
    {
      AppMethodBeat.o(212209);
      return true;
    }
    boolean bool = this.mAnimationInfo.VA.booleanValue();
    AppMethodBeat.o(212209);
    return bool;
  }
  
  View getAnimatingAway()
  {
    if (this.mAnimationInfo == null) {
      return null;
    }
    return this.mAnimationInfo.Vo;
  }
  
  Animator getAnimator()
  {
    if (this.mAnimationInfo == null) {
      return null;
    }
    return this.mAnimationInfo.Vp;
  }
  
  public final Bundle getArguments()
  {
    return this.mArguments;
  }
  
  public final e getChildFragmentManager()
  {
    AppMethodBeat.i(212078);
    if (this.mChildFragmentManager == null)
    {
      instantiateChildFragmentManager();
      if (this.mState < 4) {
        break label45;
      }
      this.mChildFragmentManager.dispatchResume();
    }
    for (;;)
    {
      FragmentManagerImpl localFragmentManagerImpl = this.mChildFragmentManager;
      AppMethodBeat.o(212078);
      return localFragmentManagerImpl;
      label45:
      if (this.mState >= 3) {
        this.mChildFragmentManager.dispatchStart();
      } else if (this.mState >= 2) {
        this.mChildFragmentManager.dispatchActivityCreated();
      } else if (this.mState > 0) {
        this.mChildFragmentManager.dispatchCreate();
      }
    }
  }
  
  public Context getContext()
  {
    if (this.mHost == null) {
      return null;
    }
    return this.mHost.mContext;
  }
  
  public Object getEnterTransition()
  {
    if (this.mAnimationInfo == null) {
      return null;
    }
    return this.mAnimationInfo.Vu;
  }
  
  k getEnterTransitionCallback()
  {
    if (this.mAnimationInfo == null) {
      return null;
    }
    return this.mAnimationInfo.VC;
  }
  
  public Object getExitTransition()
  {
    if (this.mAnimationInfo == null) {
      return null;
    }
    return this.mAnimationInfo.Vw;
  }
  
  k getExitTransitionCallback()
  {
    if (this.mAnimationInfo == null) {
      return null;
    }
    return this.mAnimationInfo.VD;
  }
  
  public final e getFragmentManager()
  {
    return this.mFragmentManager;
  }
  
  public final Object getHost()
  {
    AppMethodBeat.i(212059);
    if (this.mHost == null)
    {
      AppMethodBeat.o(212059);
      return null;
    }
    Object localObject = this.mHost.iB();
    AppMethodBeat.o(212059);
    return localObject;
  }
  
  public final int getId()
  {
    return this.mFragmentId;
  }
  
  public final LayoutInflater getLayoutInflater()
  {
    AppMethodBeat.i(212130);
    if (this.mLayoutInflater == null)
    {
      localLayoutInflater = performGetLayoutInflater(null);
      AppMethodBeat.o(212130);
      return localLayoutInflater;
    }
    LayoutInflater localLayoutInflater = this.mLayoutInflater;
    AppMethodBeat.o(212130);
    return localLayoutInflater;
  }
  
  @Deprecated
  public LayoutInflater getLayoutInflater(Bundle paramBundle)
  {
    AppMethodBeat.i(212132);
    if (this.mHost == null)
    {
      paramBundle = new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
      AppMethodBeat.o(212132);
      throw paramBundle;
    }
    paramBundle = this.mHost.ix();
    getChildFragmentManager();
    androidx.core.g.g.b(paramBundle, this.mChildFragmentManager.getLayoutInflaterFactory());
    AppMethodBeat.o(212132);
    return paramBundle;
  }
  
  public h getLifecycle()
  {
    return this.mLifecycleRegistry;
  }
  
  @Deprecated
  public androidx.g.a.a getLoaderManager()
  {
    AppMethodBeat.i(212112);
    androidx.g.a.a locala = androidx.g.a.a.e(this);
    AppMethodBeat.o(212112);
    return locala;
  }
  
  int getNextAnim()
  {
    if (this.mAnimationInfo == null) {
      return 0;
    }
    return this.mAnimationInfo.Vr;
  }
  
  int getNextTransition()
  {
    if (this.mAnimationInfo == null) {
      return 0;
    }
    return this.mAnimationInfo.Vs;
  }
  
  int getNextTransitionStyle()
  {
    if (this.mAnimationInfo == null) {
      return 0;
    }
    return this.mAnimationInfo.Vt;
  }
  
  public final Fragment getParentFragment()
  {
    return this.mParentFragment;
  }
  
  public Object getReenterTransition()
  {
    AppMethodBeat.i(212191);
    if (this.mAnimationInfo == null)
    {
      AppMethodBeat.o(212191);
      return null;
    }
    if (this.mAnimationInfo.Vx == USE_DEFAULT_TRANSITION)
    {
      localObject = getExitTransition();
      AppMethodBeat.o(212191);
      return localObject;
    }
    Object localObject = this.mAnimationInfo.Vx;
    AppMethodBeat.o(212191);
    return localObject;
  }
  
  public final Resources getResources()
  {
    AppMethodBeat.i(212063);
    Resources localResources = requireContext().getResources();
    AppMethodBeat.o(212063);
    return localResources;
  }
  
  public final boolean getRetainInstance()
  {
    return this.mRetainInstance;
  }
  
  public Object getReturnTransition()
  {
    AppMethodBeat.i(212183);
    if (this.mAnimationInfo == null)
    {
      AppMethodBeat.o(212183);
      return null;
    }
    if (this.mAnimationInfo.Vv == USE_DEFAULT_TRANSITION)
    {
      localObject = getEnterTransition();
      AppMethodBeat.o(212183);
      return localObject;
    }
    Object localObject = this.mAnimationInfo.Vv;
    AppMethodBeat.o(212183);
    return localObject;
  }
  
  public Object getSharedElementEnterTransition()
  {
    if (this.mAnimationInfo == null) {
      return null;
    }
    return this.mAnimationInfo.Vy;
  }
  
  public Object getSharedElementReturnTransition()
  {
    AppMethodBeat.i(212200);
    if (this.mAnimationInfo == null)
    {
      AppMethodBeat.o(212200);
      return null;
    }
    if (this.mAnimationInfo.Vz == USE_DEFAULT_TRANSITION)
    {
      localObject = getSharedElementEnterTransition();
      AppMethodBeat.o(212200);
      return localObject;
    }
    Object localObject = this.mAnimationInfo.Vz;
    AppMethodBeat.o(212200);
    return localObject;
  }
  
  int getStateAfterAnimating()
  {
    if (this.mAnimationInfo == null) {
      return 0;
    }
    return this.mAnimationInfo.Vq;
  }
  
  public final String getString(int paramInt)
  {
    AppMethodBeat.i(212070);
    String str = getResources().getString(paramInt);
    AppMethodBeat.o(212070);
    return str;
  }
  
  public final String getString(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(212072);
    paramVarArgs = getResources().getString(paramInt, paramVarArgs);
    AppMethodBeat.o(212072);
    return paramVarArgs;
  }
  
  public final String getTag()
  {
    return this.mTag;
  }
  
  public final Fragment getTargetFragment()
  {
    return this.mTarget;
  }
  
  public final int getTargetRequestCode()
  {
    return this.mTargetRequestCode;
  }
  
  public final CharSequence getText(int paramInt)
  {
    AppMethodBeat.i(212066);
    CharSequence localCharSequence = getResources().getText(paramInt);
    AppMethodBeat.o(212066);
    return localCharSequence;
  }
  
  public boolean getUserVisibleHint()
  {
    return this.mUserVisibleHint;
  }
  
  public View getView()
  {
    return this.mView;
  }
  
  public l getViewLifecycleOwner()
  {
    AppMethodBeat.i(211995);
    if (this.mViewLifecycleOwner == null)
    {
      localObject = new IllegalStateException("Can't access the Fragment View's LifecycleOwner when getView() is null i.e., before onCreateView() or after onDestroyView()");
      AppMethodBeat.o(211995);
      throw ((Throwable)localObject);
    }
    Object localObject = this.mViewLifecycleOwner;
    AppMethodBeat.o(211995);
    return localObject;
  }
  
  public LiveData<l> getViewLifecycleOwnerLiveData()
  {
    return this.mViewLifecycleOwnerLiveData;
  }
  
  public aa getViewModelStore()
  {
    AppMethodBeat.i(212000);
    if (getContext() == null)
    {
      localObject = new IllegalStateException("Can't access ViewModels from detached fragment");
      AppMethodBeat.o(212000);
      throw ((Throwable)localObject);
    }
    if (this.mViewModelStore == null) {
      this.mViewModelStore = new aa();
    }
    Object localObject = this.mViewModelStore;
    AppMethodBeat.o(212000);
    return localObject;
  }
  
  public final boolean hasOptionsMenu()
  {
    return this.mHasMenu;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(212031);
    int i = super.hashCode();
    AppMethodBeat.o(212031);
    return i;
  }
  
  void initState()
  {
    this.mIndex = -1;
    this.mWho = null;
    this.mAdded = false;
    this.mRemoving = false;
    this.mFromLayout = false;
    this.mInLayout = false;
    this.mRestored = false;
    this.mBackStackNesting = 0;
    this.mFragmentManager = null;
    this.mChildFragmentManager = null;
    this.mHost = null;
    this.mFragmentId = 0;
    this.mContainerId = 0;
    this.mTag = null;
    this.mHidden = false;
    this.mDetached = false;
    this.mRetaining = false;
  }
  
  void instantiateChildFragmentManager()
  {
    AppMethodBeat.i(212218);
    if (this.mHost == null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Fragment has not been attached yet.");
      AppMethodBeat.o(212218);
      throw localIllegalStateException;
    }
    this.mChildFragmentManager = new FragmentManagerImpl();
    this.mChildFragmentManager.attachController(this.mHost, new b()
    {
      public final View bZ(int paramAnonymousInt)
      {
        AppMethodBeat.i(211944);
        if (Fragment.this.mView == null)
        {
          localObject = new IllegalStateException("Fragment does not have a view");
          AppMethodBeat.o(211944);
          throw ((Throwable)localObject);
        }
        Object localObject = Fragment.this.mView.findViewById(paramAnonymousInt);
        AppMethodBeat.o(211944);
        return localObject;
      }
      
      public final Fragment instantiate(Context paramAnonymousContext, String paramAnonymousString, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(211945);
        paramAnonymousContext = Fragment.this.mHost.instantiate(paramAnonymousContext, paramAnonymousString, paramAnonymousBundle);
        AppMethodBeat.o(211945);
        return paramAnonymousContext;
      }
      
      public final boolean it()
      {
        return Fragment.this.mView != null;
      }
    }, this);
    AppMethodBeat.o(212218);
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
    return this.mAnimationInfo.VG;
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
    return this.mMenuVisible;
  }
  
  boolean isPostponed()
  {
    if (this.mAnimationInfo == null) {
      return false;
    }
    return this.mAnimationInfo.VE;
  }
  
  public final boolean isRemoving()
  {
    return this.mRemoving;
  }
  
  public final boolean isResumed()
  {
    return this.mState >= 4;
  }
  
  public final boolean isStateSaved()
  {
    AppMethodBeat.i(212043);
    if (this.mFragmentManager == null)
    {
      AppMethodBeat.o(212043);
      return false;
    }
    boolean bool = this.mFragmentManager.isStateSaved();
    AppMethodBeat.o(212043);
    return bool;
  }
  
  public final boolean isVisible()
  {
    AppMethodBeat.i(212092);
    if ((isAdded()) && (!isHidden()) && (this.mView != null) && (this.mView.getWindowToken() != null) && (this.mView.getVisibility() == 0))
    {
      AppMethodBeat.o(212092);
      return true;
    }
    AppMethodBeat.o(212092);
    return false;
  }
  
  void noteStateNotSaved()
  {
    AppMethodBeat.i(212226);
    if (this.mChildFragmentManager != null) {
      this.mChildFragmentManager.noteStateNotSaved();
    }
    AppMethodBeat.o(212226);
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    this.mCalled = true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  @Deprecated
  public void onAttach(Activity paramActivity)
  {
    this.mCalled = true;
  }
  
  public void onAttach(Context paramContext)
  {
    AppMethodBeat.i(212135);
    this.mCalled = true;
    if (this.mHost == null) {}
    for (paramContext = null;; paramContext = this.mHost.mActivity)
    {
      if (paramContext != null)
      {
        this.mCalled = false;
        onAttach(paramContext);
      }
      AppMethodBeat.o(212135);
      return;
    }
  }
  
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
    AppMethodBeat.i(212138);
    this.mCalled = true;
    restoreChildFragmentState(paramBundle);
    if ((this.mChildFragmentManager != null) && (!this.mChildFragmentManager.isStateAtLeast(1))) {
      this.mChildFragmentManager.dispatchCreate();
    }
    AppMethodBeat.o(212138);
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
    AppMethodBeat.i(212168);
    getActivity().onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    AppMethodBeat.o(212168);
  }
  
  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater) {}
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return null;
  }
  
  public void onDestroy()
  {
    int i = 1;
    AppMethodBeat.i(212159);
    this.mCalled = true;
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity != null) && (localFragmentActivity.isChangingConfigurations())) {}
    for (;;)
    {
      if ((this.mViewModelStore != null) && (i == 0)) {
        this.mViewModelStore.clear();
      }
      AppMethodBeat.o(212159);
      return;
      i = 0;
    }
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
    AppMethodBeat.i(212129);
    paramBundle = getLayoutInflater(paramBundle);
    AppMethodBeat.o(212129);
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
    AppMethodBeat.i(212133);
    this.mCalled = true;
    if (this.mHost == null) {}
    for (paramContext = null;; paramContext = this.mHost.mActivity)
    {
      if (paramContext != null)
      {
        this.mCalled = false;
        onInflate(paramContext, paramAttributeSet, paramBundle);
      }
      AppMethodBeat.o(212133);
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
  
  e peekChildFragmentManager()
  {
    return this.mChildFragmentManager;
  }
  
  void performActivityCreated(Bundle paramBundle)
  {
    AppMethodBeat.i(212221);
    if (this.mChildFragmentManager != null) {
      this.mChildFragmentManager.noteStateNotSaved();
    }
    this.mState = 2;
    this.mCalled = false;
    onActivityCreated(paramBundle);
    if (!this.mCalled)
    {
      paramBundle = new n("Fragment " + this + " did not call through to super.onActivityCreated()");
      AppMethodBeat.o(212221);
      throw paramBundle;
    }
    if (this.mChildFragmentManager != null) {
      this.mChildFragmentManager.dispatchActivityCreated();
    }
    AppMethodBeat.o(212221);
  }
  
  void performConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(212231);
    onConfigurationChanged(paramConfiguration);
    if (this.mChildFragmentManager != null) {
      this.mChildFragmentManager.dispatchConfigurationChanged(paramConfiguration);
    }
    AppMethodBeat.o(212231);
  }
  
  boolean performContextItemSelected(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(212237);
    if (!this.mHidden)
    {
      if (onContextItemSelected(paramMenuItem))
      {
        AppMethodBeat.o(212237);
        return true;
      }
      if ((this.mChildFragmentManager != null) && (this.mChildFragmentManager.dispatchContextItemSelected(paramMenuItem)))
      {
        AppMethodBeat.o(212237);
        return true;
      }
    }
    AppMethodBeat.o(212237);
    return false;
  }
  
  void performCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(212219);
    if (this.mChildFragmentManager != null) {
      this.mChildFragmentManager.noteStateNotSaved();
    }
    this.mState = 1;
    this.mCalled = false;
    onCreate(paramBundle);
    this.mIsCreated = true;
    if (!this.mCalled)
    {
      paramBundle = new n("Fragment " + this + " did not call through to super.onCreate()");
      AppMethodBeat.o(212219);
      throw paramBundle;
    }
    this.mLifecycleRegistry.a(h.a.ON_CREATE);
    AppMethodBeat.o(212219);
  }
  
  boolean performCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    AppMethodBeat.i(212233);
    boolean bool2 = false;
    boolean bool3 = false;
    if (!this.mHidden)
    {
      boolean bool1 = bool3;
      if (this.mHasMenu)
      {
        bool1 = bool3;
        if (this.mMenuVisible)
        {
          bool1 = true;
          onCreateOptionsMenu(paramMenu, paramMenuInflater);
        }
      }
      bool2 = bool1;
      if (this.mChildFragmentManager != null) {
        bool2 = bool1 | this.mChildFragmentManager.dispatchCreateOptionsMenu(paramMenu, paramMenuInflater);
      }
    }
    AppMethodBeat.o(212233);
    return bool2;
  }
  
  void performCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(212220);
    if (this.mChildFragmentManager != null) {
      this.mChildFragmentManager.noteStateNotSaved();
    }
    this.mPerformedCreateView = true;
    this.mViewLifecycleOwner = new l()
    {
      public final h getLifecycle()
      {
        AppMethodBeat.i(211948);
        if (Fragment.this.mViewLifecycleRegistry == null) {
          Fragment.this.mViewLifecycleRegistry = new m(Fragment.this.mViewLifecycleOwner);
        }
        m localm = Fragment.this.mViewLifecycleRegistry;
        AppMethodBeat.o(211948);
        return localm;
      }
    };
    this.mViewLifecycleRegistry = null;
    this.mView = onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (this.mView != null)
    {
      this.mViewLifecycleOwner.getLifecycle();
      this.mViewLifecycleOwnerLiveData.setValue(this.mViewLifecycleOwner);
      AppMethodBeat.o(212220);
      return;
    }
    if (this.mViewLifecycleRegistry != null)
    {
      paramLayoutInflater = new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
      AppMethodBeat.o(212220);
      throw paramLayoutInflater;
    }
    this.mViewLifecycleOwner = null;
    AppMethodBeat.o(212220);
  }
  
  void performDestroy()
  {
    AppMethodBeat.i(212246);
    this.mLifecycleRegistry.a(h.a.ON_DESTROY);
    if (this.mChildFragmentManager != null) {
      this.mChildFragmentManager.dispatchDestroy();
    }
    this.mState = 0;
    this.mCalled = false;
    this.mIsCreated = false;
    onDestroy();
    if (!this.mCalled)
    {
      n localn = new n("Fragment " + this + " did not call through to super.onDestroy()");
      AppMethodBeat.o(212246);
      throw localn;
    }
    this.mChildFragmentManager = null;
    AppMethodBeat.o(212246);
  }
  
  void performDestroyView()
  {
    AppMethodBeat.i(212244);
    if (this.mView != null) {
      this.mViewLifecycleRegistry.a(h.a.ON_DESTROY);
    }
    if (this.mChildFragmentManager != null) {
      this.mChildFragmentManager.dispatchDestroyView();
    }
    this.mState = 1;
    this.mCalled = false;
    onDestroyView();
    if (!this.mCalled)
    {
      n localn = new n("Fragment " + this + " did not call through to super.onDestroyView()");
      AppMethodBeat.o(212244);
      throw localn;
    }
    androidx.g.a.a.e(this).jn();
    this.mPerformedCreateView = false;
    AppMethodBeat.o(212244);
  }
  
  void performDetach()
  {
    AppMethodBeat.i(212248);
    this.mCalled = false;
    onDetach();
    this.mLayoutInflater = null;
    Object localObject;
    if (!this.mCalled)
    {
      localObject = new n("Fragment " + this + " did not call through to super.onDetach()");
      AppMethodBeat.o(212248);
      throw ((Throwable)localObject);
    }
    if (this.mChildFragmentManager != null)
    {
      if (!this.mRetaining)
      {
        localObject = new IllegalStateException("Child FragmentManager of " + this + " was not  destroyed and this fragment is not retaining instance");
        AppMethodBeat.o(212248);
        throw ((Throwable)localObject);
      }
      this.mChildFragmentManager.dispatchDestroy();
      this.mChildFragmentManager = null;
    }
    AppMethodBeat.o(212248);
  }
  
  LayoutInflater performGetLayoutInflater(Bundle paramBundle)
  {
    AppMethodBeat.i(212131);
    this.mLayoutInflater = onGetLayoutInflater(paramBundle);
    paramBundle = this.mLayoutInflater;
    AppMethodBeat.o(212131);
    return paramBundle;
  }
  
  void performLowMemory()
  {
    AppMethodBeat.i(212232);
    onLowMemory();
    if (this.mChildFragmentManager != null) {
      this.mChildFragmentManager.dispatchLowMemory();
    }
    AppMethodBeat.o(212232);
  }
  
  void performMultiWindowModeChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(212228);
    onMultiWindowModeChanged(paramBoolean);
    if (this.mChildFragmentManager != null) {
      this.mChildFragmentManager.dispatchMultiWindowModeChanged(paramBoolean);
    }
    AppMethodBeat.o(212228);
  }
  
  boolean performOptionsItemSelected(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(212236);
    if (!this.mHidden)
    {
      if ((this.mHasMenu) && (this.mMenuVisible) && (onOptionsItemSelected(paramMenuItem)))
      {
        AppMethodBeat.o(212236);
        return true;
      }
      if ((this.mChildFragmentManager != null) && (this.mChildFragmentManager.dispatchOptionsItemSelected(paramMenuItem)))
      {
        AppMethodBeat.o(212236);
        return true;
      }
    }
    AppMethodBeat.o(212236);
    return false;
  }
  
  void performOptionsMenuClosed(Menu paramMenu)
  {
    AppMethodBeat.i(212238);
    if (!this.mHidden)
    {
      if ((this.mHasMenu) && (this.mMenuVisible)) {
        onOptionsMenuClosed(paramMenu);
      }
      if (this.mChildFragmentManager != null) {
        this.mChildFragmentManager.dispatchOptionsMenuClosed(paramMenu);
      }
    }
    AppMethodBeat.o(212238);
  }
  
  void performPause()
  {
    AppMethodBeat.i(212241);
    if (this.mView != null) {
      this.mViewLifecycleRegistry.a(h.a.ON_PAUSE);
    }
    this.mLifecycleRegistry.a(h.a.ON_PAUSE);
    if (this.mChildFragmentManager != null) {
      this.mChildFragmentManager.dispatchPause();
    }
    this.mState = 3;
    this.mCalled = false;
    onPause();
    if (!this.mCalled)
    {
      n localn = new n("Fragment " + this + " did not call through to super.onPause()");
      AppMethodBeat.o(212241);
      throw localn;
    }
    AppMethodBeat.o(212241);
  }
  
  void performPictureInPictureModeChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(212230);
    onPictureInPictureModeChanged(paramBoolean);
    if (this.mChildFragmentManager != null) {
      this.mChildFragmentManager.dispatchPictureInPictureModeChanged(paramBoolean);
    }
    AppMethodBeat.o(212230);
  }
  
  boolean performPrepareOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(212235);
    boolean bool2 = false;
    boolean bool3 = false;
    if (!this.mHidden)
    {
      boolean bool1 = bool3;
      if (this.mHasMenu)
      {
        bool1 = bool3;
        if (this.mMenuVisible)
        {
          bool1 = true;
          onPrepareOptionsMenu(paramMenu);
        }
      }
      bool2 = bool1;
      if (this.mChildFragmentManager != null) {
        bool2 = bool1 | this.mChildFragmentManager.dispatchPrepareOptionsMenu(paramMenu);
      }
    }
    AppMethodBeat.o(212235);
    return bool2;
  }
  
  void performResume()
  {
    AppMethodBeat.i(212224);
    if (this.mChildFragmentManager != null)
    {
      this.mChildFragmentManager.noteStateNotSaved();
      this.mChildFragmentManager.execPendingActions();
    }
    this.mState = 4;
    this.mCalled = false;
    onResume();
    if (!this.mCalled)
    {
      n localn = new n("Fragment " + this + " did not call through to super.onResume()");
      AppMethodBeat.o(212224);
      throw localn;
    }
    if (this.mChildFragmentManager != null)
    {
      this.mChildFragmentManager.dispatchResume();
      this.mChildFragmentManager.execPendingActions();
    }
    this.mLifecycleRegistry.a(h.a.ON_RESUME);
    if (this.mView != null) {
      this.mViewLifecycleRegistry.a(h.a.ON_RESUME);
    }
    AppMethodBeat.o(212224);
  }
  
  void performSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(212239);
    onSaveInstanceState(paramBundle);
    if (this.mChildFragmentManager != null)
    {
      Parcelable localParcelable = this.mChildFragmentManager.saveAllState();
      if (localParcelable != null) {
        paramBundle.putParcelable("android:support:fragments", localParcelable);
      }
    }
    AppMethodBeat.o(212239);
  }
  
  void performStart()
  {
    AppMethodBeat.i(212222);
    if (this.mChildFragmentManager != null)
    {
      this.mChildFragmentManager.noteStateNotSaved();
      this.mChildFragmentManager.execPendingActions();
    }
    this.mState = 3;
    this.mCalled = false;
    onStart();
    if (!this.mCalled)
    {
      n localn = new n("Fragment " + this + " did not call through to super.onStart()");
      AppMethodBeat.o(212222);
      throw localn;
    }
    if (this.mChildFragmentManager != null) {
      this.mChildFragmentManager.dispatchStart();
    }
    this.mLifecycleRegistry.a(h.a.ON_START);
    if (this.mView != null) {
      this.mViewLifecycleRegistry.a(h.a.ON_START);
    }
    AppMethodBeat.o(212222);
  }
  
  void performStop()
  {
    AppMethodBeat.i(212242);
    if (this.mView != null) {
      this.mViewLifecycleRegistry.a(h.a.ON_STOP);
    }
    this.mLifecycleRegistry.a(h.a.ON_STOP);
    if (this.mChildFragmentManager != null) {
      this.mChildFragmentManager.dispatchStop();
    }
    this.mState = 2;
    this.mCalled = false;
    onStop();
    if (!this.mCalled)
    {
      n localn = new n("Fragment " + this + " did not call through to super.onStop()");
      AppMethodBeat.o(212242);
      throw localn;
    }
    AppMethodBeat.o(212242);
  }
  
  public void postponeEnterTransition()
  {
    AppMethodBeat.i(212210);
    ensureAnimationInfo().VE = true;
    AppMethodBeat.o(212210);
  }
  
  public void registerForContextMenu(View paramView)
  {
    AppMethodBeat.i(212171);
    paramView.setOnCreateContextMenuListener(this);
    AppMethodBeat.o(212171);
  }
  
  public final void requestPermissions(String[] paramArrayOfString, int paramInt)
  {
    AppMethodBeat.i(212127);
    if (this.mHost == null)
    {
      paramArrayOfString = new IllegalStateException("Fragment " + this + " not attached to Activity");
      AppMethodBeat.o(212127);
      throw paramArrayOfString;
    }
    this.mHost.a(this, paramArrayOfString, paramInt);
    AppMethodBeat.o(212127);
  }
  
  public final FragmentActivity requireActivity()
  {
    AppMethodBeat.i(212056);
    Object localObject = getActivity();
    if (localObject == null)
    {
      localObject = new IllegalStateException("Fragment " + this + " not attached to an activity.");
      AppMethodBeat.o(212056);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(212056);
    return localObject;
  }
  
  public final Context requireContext()
  {
    AppMethodBeat.i(212052);
    Object localObject = getContext();
    if (localObject == null)
    {
      localObject = new IllegalStateException("Fragment " + this + " not attached to a context.");
      AppMethodBeat.o(212052);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(212052);
    return localObject;
  }
  
  public final e requireFragmentManager()
  {
    AppMethodBeat.i(212075);
    Object localObject = getFragmentManager();
    if (localObject == null)
    {
      localObject = new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
      AppMethodBeat.o(212075);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(212075);
    return localObject;
  }
  
  public final Object requireHost()
  {
    AppMethodBeat.i(212061);
    Object localObject = getHost();
    if (localObject == null)
    {
      localObject = new IllegalStateException("Fragment " + this + " not attached to a host.");
      AppMethodBeat.o(212061);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(212061);
    return localObject;
  }
  
  void restoreChildFragmentState(Bundle paramBundle)
  {
    AppMethodBeat.i(212139);
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getParcelable("android:support:fragments");
      if (paramBundle != null)
      {
        if (this.mChildFragmentManager == null) {
          instantiateChildFragmentManager();
        }
        this.mChildFragmentManager.restoreAllState(paramBundle, this.mChildNonConfig);
        this.mChildNonConfig = null;
        this.mChildFragmentManager.dispatchCreate();
      }
    }
    AppMethodBeat.o(212139);
  }
  
  final void restoreViewState(Bundle paramBundle)
  {
    AppMethodBeat.i(212020);
    if (this.mSavedViewState != null)
    {
      this.mInnerView.restoreHierarchyState(this.mSavedViewState);
      this.mSavedViewState = null;
    }
    this.mCalled = false;
    onViewStateRestored(paramBundle);
    if (!this.mCalled)
    {
      paramBundle = new n("Fragment " + this + " did not call through to super.onViewStateRestored()");
      AppMethodBeat.o(212020);
      throw paramBundle;
    }
    if (this.mView != null) {
      this.mViewLifecycleRegistry.a(h.a.ON_CREATE);
    }
    AppMethodBeat.o(212020);
  }
  
  public void setAllowEnterTransitionOverlap(boolean paramBoolean)
  {
    AppMethodBeat.i(212202);
    ensureAnimationInfo().VB = Boolean.valueOf(paramBoolean);
    AppMethodBeat.o(212202);
  }
  
  public void setAllowReturnTransitionOverlap(boolean paramBoolean)
  {
    AppMethodBeat.i(212206);
    ensureAnimationInfo().VA = Boolean.valueOf(paramBoolean);
    AppMethodBeat.o(212206);
  }
  
  void setAnimatingAway(View paramView)
  {
    AppMethodBeat.i(212261);
    ensureAnimationInfo().Vo = paramView;
    AppMethodBeat.o(212261);
  }
  
  void setAnimator(Animator paramAnimator)
  {
    AppMethodBeat.i(212264);
    ensureAnimationInfo().Vp = paramAnimator;
    AppMethodBeat.o(212264);
  }
  
  public void setArguments(Bundle paramBundle)
  {
    AppMethodBeat.i(212039);
    if ((this.mIndex >= 0) && (isStateSaved()))
    {
      paramBundle = new IllegalStateException("Fragment already active and state has been saved");
      AppMethodBeat.o(212039);
      throw paramBundle;
    }
    this.mArguments = paramBundle;
    AppMethodBeat.o(212039);
  }
  
  public void setEnterSharedElementCallback(k paramk)
  {
    AppMethodBeat.i(212174);
    ensureAnimationInfo().VC = paramk;
    AppMethodBeat.o(212174);
  }
  
  public void setEnterTransition(Object paramObject)
  {
    AppMethodBeat.i(212178);
    ensureAnimationInfo().Vu = paramObject;
    AppMethodBeat.o(212178);
  }
  
  public void setExitSharedElementCallback(k paramk)
  {
    AppMethodBeat.i(212176);
    ensureAnimationInfo().VD = paramk;
    AppMethodBeat.o(212176);
  }
  
  public void setExitTransition(Object paramObject)
  {
    AppMethodBeat.i(212185);
    ensureAnimationInfo().Vw = paramObject;
    AppMethodBeat.o(212185);
  }
  
  public void setHasOptionsMenu(boolean paramBoolean)
  {
    AppMethodBeat.i(212103);
    if (this.mHasMenu != paramBoolean)
    {
      this.mHasMenu = paramBoolean;
      if ((isAdded()) && (!isHidden())) {
        this.mHost.iy();
      }
    }
    AppMethodBeat.o(212103);
  }
  
  void setHideReplaced(boolean paramBoolean)
  {
    AppMethodBeat.i(212274);
    ensureAnimationInfo().VG = paramBoolean;
    AppMethodBeat.o(212274);
  }
  
  final void setIndex(int paramInt, Fragment paramFragment)
  {
    AppMethodBeat.i(212024);
    this.mIndex = paramInt;
    if (paramFragment != null)
    {
      this.mWho = (paramFragment.mWho + ":" + this.mIndex);
      AppMethodBeat.o(212024);
      return;
    }
    this.mWho = ("android:fragment:" + this.mIndex);
    AppMethodBeat.o(212024);
  }
  
  public void setInitialSavedState(SavedState paramSavedState)
  {
    AppMethodBeat.i(212045);
    if (this.mIndex >= 0)
    {
      paramSavedState = new IllegalStateException("Fragment already active");
      AppMethodBeat.o(212045);
      throw paramSavedState;
    }
    if ((paramSavedState != null) && (paramSavedState.VH != null)) {}
    for (paramSavedState = paramSavedState.VH;; paramSavedState = null)
    {
      this.mSavedFragmentState = paramSavedState;
      AppMethodBeat.o(212045);
      return;
    }
  }
  
  public void setMenuVisibility(boolean paramBoolean)
  {
    AppMethodBeat.i(212105);
    if (this.mMenuVisible != paramBoolean)
    {
      this.mMenuVisible = paramBoolean;
      if ((this.mHasMenu) && (isAdded()) && (!isHidden())) {
        this.mHost.iy();
      }
    }
    AppMethodBeat.o(212105);
  }
  
  void setNextAnim(int paramInt)
  {
    AppMethodBeat.i(212253);
    if ((this.mAnimationInfo == null) && (paramInt == 0))
    {
      AppMethodBeat.o(212253);
      return;
    }
    ensureAnimationInfo().Vr = paramInt;
    AppMethodBeat.o(212253);
  }
  
  void setNextTransition(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(212256);
    if ((this.mAnimationInfo == null) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      AppMethodBeat.o(212256);
      return;
    }
    ensureAnimationInfo();
    this.mAnimationInfo.Vs = paramInt1;
    this.mAnimationInfo.Vt = paramInt2;
    AppMethodBeat.o(212256);
  }
  
  void setOnStartEnterTransitionListener(c paramc)
  {
    AppMethodBeat.i(212250);
    ensureAnimationInfo();
    if (paramc == this.mAnimationInfo.VF)
    {
      AppMethodBeat.o(212250);
      return;
    }
    if ((paramc != null) && (this.mAnimationInfo.VF != null))
    {
      paramc = new IllegalStateException("Trying to set a replacement startPostponedEnterTransition on ".concat(String.valueOf(this)));
      AppMethodBeat.o(212250);
      throw paramc;
    }
    if (this.mAnimationInfo.VE) {
      this.mAnimationInfo.VF = paramc;
    }
    if (paramc != null) {
      paramc.iv();
    }
    AppMethodBeat.o(212250);
  }
  
  public void setReenterTransition(Object paramObject)
  {
    AppMethodBeat.i(212188);
    ensureAnimationInfo().Vx = paramObject;
    AppMethodBeat.o(212188);
  }
  
  public void setRetainInstance(boolean paramBoolean)
  {
    this.mRetainInstance = paramBoolean;
  }
  
  public void setReturnTransition(Object paramObject)
  {
    AppMethodBeat.i(212181);
    ensureAnimationInfo().Vv = paramObject;
    AppMethodBeat.o(212181);
  }
  
  public void setSharedElementEnterTransition(Object paramObject)
  {
    AppMethodBeat.i(212193);
    ensureAnimationInfo().Vy = paramObject;
    AppMethodBeat.o(212193);
  }
  
  public void setSharedElementReturnTransition(Object paramObject)
  {
    AppMethodBeat.i(212198);
    ensureAnimationInfo().Vz = paramObject;
    AppMethodBeat.o(212198);
  }
  
  void setStateAfterAnimating(int paramInt)
  {
    AppMethodBeat.i(212268);
    ensureAnimationInfo().Vq = paramInt;
    AppMethodBeat.o(212268);
  }
  
  public void setTargetFragment(Fragment paramFragment, int paramInt)
  {
    AppMethodBeat.i(212047);
    e locale = getFragmentManager();
    if (paramFragment != null) {}
    for (Object localObject = paramFragment.getFragmentManager(); (locale != null) && (localObject != null) && (locale != localObject); localObject = null)
    {
      paramFragment = new IllegalArgumentException("Fragment " + paramFragment + " must share the same FragmentManager to be set as a target fragment");
      AppMethodBeat.o(212047);
      throw paramFragment;
    }
    for (localObject = paramFragment; localObject != null; localObject = ((Fragment)localObject).getTargetFragment()) {
      if (localObject == this)
      {
        paramFragment = new IllegalArgumentException("Setting " + paramFragment + " as the target of " + this + " would create a target cycle");
        AppMethodBeat.o(212047);
        throw paramFragment;
      }
    }
    this.mTarget = paramFragment;
    this.mTargetRequestCode = paramInt;
    AppMethodBeat.o(212047);
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    AppMethodBeat.i(212107);
    if ((!this.mUserVisibleHint) && (paramBoolean) && (this.mState < 3) && (this.mFragmentManager != null) && (isAdded()) && (this.mIsCreated)) {
      this.mFragmentManager.performPendingDeferredStart(this);
    }
    this.mUserVisibleHint = paramBoolean;
    if ((this.mState < 3) && (!paramBoolean)) {}
    for (boolean bool = true;; bool = false)
    {
      this.mDeferStart = bool;
      if (this.mSavedFragmentState != null) {
        this.mSavedUserVisibleHint = Boolean.valueOf(paramBoolean);
      }
      AppMethodBeat.o(212107);
      return;
    }
  }
  
  public boolean shouldShowRequestPermissionRationale(String paramString)
  {
    AppMethodBeat.i(212128);
    if (this.mHost != null)
    {
      boolean bool = this.mHost.M(paramString);
      AppMethodBeat.o(212128);
      return bool;
    }
    AppMethodBeat.o(212128);
    return false;
  }
  
  public void startActivity(Intent paramIntent)
  {
    AppMethodBeat.i(212115);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(null).bm(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.b(this, paramIntent.aFh(), "androidx/fragment/app/Fragment", "startActivity", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
    startActivity((Intent)paramIntent.sf(0), (Bundle)paramIntent.sf(1));
    com.tencent.mm.hellhoundlib.a.a.c(this, "androidx/fragment/app/Fragment", "startActivity", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
    AppMethodBeat.o(212115);
  }
  
  public void startActivity(Intent paramIntent, Bundle paramBundle)
  {
    AppMethodBeat.i(212118);
    if (this.mHost == null)
    {
      paramIntent = new IllegalStateException("Fragment " + this + " not attached to Activity");
      AppMethodBeat.o(212118);
      throw paramIntent;
    }
    this.mHost.a(this, paramIntent, -1, paramBundle);
    AppMethodBeat.o(212118);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(212120);
    startActivityForResult(paramIntent, paramInt, null);
    AppMethodBeat.o(212120);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(212122);
    if (this.mHost == null)
    {
      paramIntent = new IllegalStateException("Fragment " + this + " not attached to Activity");
      AppMethodBeat.o(212122);
      throw paramIntent;
    }
    this.mHost.a(this, paramIntent, paramInt, paramBundle);
    AppMethodBeat.o(212122);
  }
  
  public void startIntentSenderForResult(IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4, Bundle paramBundle)
  {
    AppMethodBeat.i(212124);
    if (this.mHost == null)
    {
      paramIntentSender = new IllegalStateException("Fragment " + this + " not attached to Activity");
      AppMethodBeat.o(212124);
      throw paramIntentSender;
    }
    this.mHost.a(this, paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
    AppMethodBeat.o(212124);
  }
  
  public void startPostponedEnterTransition()
  {
    AppMethodBeat.i(212212);
    if ((this.mFragmentManager == null) || (this.mFragmentManager.mHost == null))
    {
      ensureAnimationInfo().VE = false;
      AppMethodBeat.o(212212);
      return;
    }
    if (Looper.myLooper() != this.mFragmentManager.mHost.mHandler.getLooper())
    {
      this.mFragmentManager.mHost.mHandler.postAtFrontOfQueue(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(211941);
          Fragment.this.callStartTransitionListener();
          AppMethodBeat.o(211941);
        }
      });
      AppMethodBeat.o(212212);
      return;
    }
    callStartTransitionListener();
    AppMethodBeat.o(212212);
  }
  
  public String toString()
  {
    AppMethodBeat.i(212035);
    Object localObject = new StringBuilder(128);
    androidx.core.f.b.a(this, (StringBuilder)localObject);
    if (this.mIndex >= 0)
    {
      ((StringBuilder)localObject).append(" #");
      ((StringBuilder)localObject).append(this.mIndex);
    }
    if (this.mFragmentId != 0)
    {
      ((StringBuilder)localObject).append(" id=0x");
      ((StringBuilder)localObject).append(Integer.toHexString(this.mFragmentId));
    }
    if (this.mTag != null)
    {
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(this.mTag);
    }
    ((StringBuilder)localObject).append('}');
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(212035);
    return localObject;
  }
  
  public void unregisterForContextMenu(View paramView)
  {
    AppMethodBeat.i(212172);
    paramView.setOnCreateContextMenuListener(null);
    AppMethodBeat.o(212172);
  }
  
  public static class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<SavedState> CREATOR;
    final Bundle VH;
    
    static
    {
      AppMethodBeat.i(211965);
      CREATOR = new Parcelable.ClassLoaderCreator() {};
      AppMethodBeat.o(211965);
    }
    
    SavedState(Bundle paramBundle)
    {
      this.VH = paramBundle;
    }
    
    SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      AppMethodBeat.i(211961);
      this.VH = paramParcel.readBundle();
      if ((paramClassLoader != null) && (this.VH != null)) {
        this.VH.setClassLoader(paramClassLoader);
      }
      AppMethodBeat.o(211961);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(211963);
      paramParcel.writeBundle(this.VH);
      AppMethodBeat.o(211963);
    }
  }
  
  static class a
  {
    Boolean VA;
    Boolean VB;
    k VC = null;
    k VD = null;
    boolean VE;
    Fragment.c VF;
    boolean VG;
    View Vo;
    Animator Vp;
    int Vq;
    int Vr;
    int Vs;
    int Vt;
    Object Vu = null;
    Object Vv = Fragment.USE_DEFAULT_TRANSITION;
    Object Vw = null;
    Object Vx = Fragment.USE_DEFAULT_TRANSITION;
    Object Vy = null;
    Object Vz = Fragment.USE_DEFAULT_TRANSITION;
  }
  
  public static final class b
    extends RuntimeException
  {
    public b(String paramString, Exception paramException)
    {
      super(paramException);
    }
  }
  
  static abstract interface c
  {
    public abstract void iu();
    
    public abstract void iv();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.fragment.app.Fragment
 * JD-Core Version:    0.7.0.1
 */