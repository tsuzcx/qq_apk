package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;
import android.view.LayoutInflater.Factory2;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.IntentSenderRequest.a;
import androidx.activity.result.a.b.a;
import androidx.activity.result.a.b.b;
import androidx.fragment.a.b;
import androidx.lifecycle.aj;
import androidx.lifecycle.ak;
import androidx.lifecycle.j.a;
import androidx.lifecycle.j.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class FragmentManager
{
  private static boolean DEBUG = false;
  private static final String EXTRA_CREATED_FILLIN_INTENT = "androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE";
  public static final int POP_BACK_STACK_INCLUSIVE = 1;
  static final String TAG = "FragmentManager";
  static boolean USE_STATE_MANAGER = true;
  ArrayList<a> mBackStack;
  private ArrayList<FragmentManager.e> mBackStackChangeListeners;
  private final AtomicInteger mBackStackIndex = new AtomicInteger();
  private d mContainer;
  private ArrayList<Fragment> mCreatedMenus;
  int mCurState = -1;
  private y mDefaultSpecialEffectsControllerFactory = new y()
  {
    public final x e(ViewGroup paramAnonymousViewGroup)
    {
      AppMethodBeat.i(193858);
      paramAnonymousViewGroup = new b(paramAnonymousViewGroup);
      AppMethodBeat.o(193858);
      return paramAnonymousViewGroup;
    }
  };
  private boolean mDestroyed;
  private Runnable mExecCommit = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(193857);
      FragmentManager.this.execPendingActions(true);
      AppMethodBeat.o(193857);
    }
  };
  private boolean mExecutingActions;
  private Map<Fragment, HashSet<androidx.core.c.b>> mExitAnimationCancellationSignals = Collections.synchronizedMap(new HashMap());
  private f mFragmentFactory = null;
  private final q mFragmentStore = new q();
  private final s.a mFragmentTransitionCallback = new s.a()
  {
    public final void a(Fragment paramAnonymousFragment, androidx.core.c.b paramAnonymousb)
    {
      AppMethodBeat.i(193873);
      FragmentManager.this.addCancellationSignal(paramAnonymousFragment, paramAnonymousb);
      AppMethodBeat.o(193873);
    }
    
    public final void b(Fragment paramAnonymousFragment, androidx.core.c.b paramAnonymousb)
    {
      AppMethodBeat.i(193877);
      if (!paramAnonymousb.isCanceled()) {
        FragmentManager.this.removeCancellationSignal(paramAnonymousFragment, paramAnonymousb);
      }
      AppMethodBeat.o(193877);
    }
  };
  private boolean mHavePendingDeferredStart;
  private g<?> mHost;
  private f mHostFragmentFactory = new f()
  {
    public final Fragment d(ClassLoader paramAnonymousClassLoader, String paramAnonymousString)
    {
      AppMethodBeat.i(193864);
      FragmentManager.this.getHost();
      paramAnonymousClassLoader = g.i(FragmentManager.this.getHost().mContext, paramAnonymousString);
      AppMethodBeat.o(193864);
      return paramAnonymousClassLoader;
    }
  };
  ArrayDeque<LaunchedFragmentInfo> mLaunchedFragments = new ArrayDeque();
  private final h mLayoutInflaterFactory = new h(this);
  private final i mLifecycleCallbacksDispatcher = new i(this);
  private boolean mNeedMenuInvalidate;
  private k mNonConfig;
  private final CopyOnWriteArrayList<l> mOnAttachListeners = new CopyOnWriteArrayList();
  private final androidx.activity.b mOnBackPressedCallback = new FragmentManager.1(this);
  private OnBackPressedDispatcher mOnBackPressedDispatcher;
  private Fragment mParent;
  private final ArrayList<f> mPendingActions = new ArrayList();
  private ArrayList<h> mPostponedTransactions;
  Fragment mPrimaryNav;
  private androidx.activity.result.b<String[]> mRequestPermissions;
  private final Map<String, d> mResultListeners = Collections.synchronizedMap(new HashMap());
  private final Map<String, Bundle> mResults = Collections.synchronizedMap(new HashMap());
  private y mSpecialEffectsControllerFactory = null;
  private androidx.activity.result.b<Intent> mStartActivityForResult;
  private androidx.activity.result.b<IntentSenderRequest> mStartIntentSenderForResult;
  private boolean mStateSaved;
  private boolean mStopped;
  private ArrayList<Fragment> mTmpAddedFragments;
  private ArrayList<Boolean> mTmpIsPop;
  private ArrayList<a> mTmpRecords;
  
  private void addAddedFragments(androidx.b.b<Fragment> paramb)
  {
    if (this.mCurState <= 0) {}
    for (;;)
    {
      return;
      int i = Math.min(this.mCurState, 5);
      Iterator localIterator = this.mFragmentStore.getFragments().iterator();
      while (localIterator.hasNext())
      {
        Fragment localFragment = (Fragment)localIterator.next();
        if (localFragment.mState < i)
        {
          moveToState(localFragment, i);
          if ((localFragment.mView != null) && (!localFragment.mHidden) && (localFragment.mIsNewlyAdded)) {
            paramb.add(localFragment);
          }
        }
      }
    }
  }
  
  private void cancelExitAnimation(Fragment paramFragment)
  {
    HashSet localHashSet = (HashSet)this.mExitAnimationCancellationSignals.get(paramFragment);
    if (localHashSet != null)
    {
      Iterator localIterator = localHashSet.iterator();
      while (localIterator.hasNext()) {
        ((androidx.core.c.b)localIterator.next()).cancel();
      }
      localHashSet.clear();
      destroyFragmentView(paramFragment);
      this.mExitAnimationCancellationSignals.remove(paramFragment);
    }
  }
  
  private void checkStateLoss()
  {
    if (isStateSaved()) {
      throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
    }
  }
  
  private void cleanupExec()
  {
    this.mExecutingActions = false;
    this.mTmpIsPop.clear();
    this.mTmpRecords.clear();
  }
  
  private Set<x> collectAllSpecialEffectsController()
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.mFragmentStore.GA().iterator();
    while (localIterator.hasNext())
    {
      ViewGroup localViewGroup = ((o)localIterator.next()).bDv.mContainer;
      if (localViewGroup != null) {
        localHashSet.add(x.a(localViewGroup, getSpecialEffectsControllerFactory()));
      }
    }
    return localHashSet;
  }
  
  private Set<x> collectChangedControllers(ArrayList<a> paramArrayList, int paramInt1, int paramInt2)
  {
    HashSet localHashSet = new HashSet();
    while (paramInt1 < paramInt2)
    {
      Iterator localIterator = ((a)paramArrayList.get(paramInt1)).bDF.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = ((r.a)localIterator.next()).bDv;
        if (localObject != null)
        {
          localObject = ((Fragment)localObject).mContainer;
          if (localObject != null) {
            localHashSet.add(x.a((ViewGroup)localObject, this));
          }
        }
      }
      paramInt1 += 1;
    }
    return localHashSet;
  }
  
  private void completeShowHideFragment(final Fragment paramFragment)
  {
    Object localObject;
    boolean bool;
    if (paramFragment.mView != null)
    {
      localObject = this.mHost.mContext;
      if (paramFragment.mHidden) {
        break label109;
      }
      bool = true;
      localObject = c.a((Context)localObject, paramFragment, bool, paramFragment.getPopDirection());
      if ((localObject == null) || (((c.a)localObject).bCA == null)) {
        break label168;
      }
      ((c.a)localObject).bCA.setTarget(paramFragment.mView);
      if (!paramFragment.mHidden) {
        break label157;
      }
      if (!paramFragment.isHideReplaced()) {
        break label114;
      }
      paramFragment.setHideReplaced(false);
    }
    for (;;)
    {
      ((c.a)localObject).bCA.start();
      invalidateMenuForFragment(paramFragment);
      paramFragment.mHiddenChanged = false;
      paramFragment.onHiddenChanged(paramFragment.mHidden);
      return;
      label109:
      bool = false;
      break;
      label114:
      final ViewGroup localViewGroup = paramFragment.mContainer;
      final View localView = paramFragment.mView;
      localViewGroup.startViewTransition(localView);
      ((c.a)localObject).bCA.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(193872);
          localViewGroup.endViewTransition(localView);
          paramAnonymousAnimator.removeListener(this);
          if ((paramFragment.mView != null) && (paramFragment.mHidden)) {
            paramFragment.mView.setVisibility(8);
          }
          AppMethodBeat.o(193872);
        }
      });
      continue;
      label157:
      paramFragment.mView.setVisibility(0);
    }
    label168:
    if (localObject != null)
    {
      paramFragment.mView.startAnimation(((c.a)localObject).bCz);
      ((c.a)localObject).bCz.start();
    }
    if ((paramFragment.mHidden) && (!paramFragment.isHideReplaced())) {}
    for (int i = 8;; i = 0)
    {
      paramFragment.mView.setVisibility(i);
      if (!paramFragment.isHideReplaced()) {
        break;
      }
      paramFragment.setHideReplaced(false);
      break;
    }
  }
  
  private void destroyFragmentView(Fragment paramFragment)
  {
    paramFragment.performDestroyView();
    this.mLifecycleCallbacksDispatcher.l(paramFragment);
    paramFragment.mContainer = null;
    paramFragment.mView = null;
    paramFragment.mViewLifecycleOwner = null;
    paramFragment.mViewLifecycleOwnerLiveData.setValue(null);
    paramFragment.mInLayout = false;
  }
  
  private void dispatchParentPrimaryNavigationFragmentChanged(Fragment paramFragment)
  {
    if ((paramFragment != null) && (paramFragment.equals(findActiveFragment(paramFragment.mWho)))) {
      paramFragment.performPrimaryNavigationFragmentChanged();
    }
  }
  
  private void dispatchStateChange(int paramInt)
  {
    try
    {
      this.mExecutingActions = true;
      Iterator localIterator1 = this.mFragmentStore.bDB.values().iterator();
      while (localIterator1.hasNext())
      {
        o localo = (o)localIterator1.next();
        if (localo != null) {
          localo.bDx = paramInt;
        }
      }
      moveToState(paramInt, false);
    }
    finally
    {
      this.mExecutingActions = false;
    }
    if (USE_STATE_MANAGER)
    {
      Iterator localIterator2 = collectAllSpecialEffectsController().iterator();
      while (localIterator2.hasNext()) {
        ((x)localIterator2.next()).GI();
      }
    }
    this.mExecutingActions = false;
    execPendingActions(true);
  }
  
  private void doPendingDeferredStart()
  {
    if (this.mHavePendingDeferredStart)
    {
      this.mHavePendingDeferredStart = false;
      startPendingDeferredFragments();
    }
  }
  
  @Deprecated
  public static void enableDebugLogging(boolean paramBoolean)
  {
    DEBUG = paramBoolean;
  }
  
  public static void enableNewStateManager(boolean paramBoolean)
  {
    USE_STATE_MANAGER = paramBoolean;
  }
  
  private void endAnimatingAwayFragments()
  {
    Iterator localIterator;
    if (USE_STATE_MANAGER)
    {
      localIterator = collectAllSpecialEffectsController().iterator();
      while (localIterator.hasNext()) {
        ((x)localIterator.next()).GI();
      }
    }
    if (!this.mExitAnimationCancellationSignals.isEmpty())
    {
      localIterator = this.mExitAnimationCancellationSignals.keySet().iterator();
      while (localIterator.hasNext())
      {
        Fragment localFragment = (Fragment)localIterator.next();
        cancelExitAnimation(localFragment);
        moveToState(localFragment);
      }
    }
  }
  
  private void ensureExecReady(boolean paramBoolean)
  {
    if (this.mExecutingActions) {
      throw new IllegalStateException("FragmentManager is already executing transactions");
    }
    if (this.mHost == null)
    {
      if (this.mDestroyed) {
        throw new IllegalStateException("FragmentManager has been destroyed");
      }
      throw new IllegalStateException("FragmentManager has not been attached to a host.");
    }
    if (Looper.myLooper() != this.mHost.mHandler.getLooper()) {
      throw new IllegalStateException("Must be called from main thread of fragment host");
    }
    if (!paramBoolean) {
      checkStateLoss();
    }
    if (this.mTmpRecords == null)
    {
      this.mTmpRecords = new ArrayList();
      this.mTmpIsPop = new ArrayList();
    }
    this.mExecutingActions = true;
    try
    {
      executePostponedTransaction(null, null);
      return;
    }
    finally
    {
      this.mExecutingActions = false;
    }
  }
  
  private static void executeOps(ArrayList<a> paramArrayList, ArrayList<Boolean> paramArrayList1, int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2)
    {
      a locala = (a)paramArrayList.get(paramInt1);
      boolean bool;
      if (((Boolean)paramArrayList1.get(paramInt1)).booleanValue())
      {
        locala.eS(-1);
        if (paramInt1 == paramInt2 - 1)
        {
          bool = true;
          label45:
          locala.aQ(bool);
        }
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        bool = false;
        break label45;
        locala.eS(1);
        locala.Ga();
      }
    }
  }
  
  private void executeOpsTogether(ArrayList<a> paramArrayList, ArrayList<Boolean> paramArrayList1, int paramInt1, int paramInt2)
  {
    boolean bool = ((a)paramArrayList.get(paramInt1)).bBq;
    Object localObject1;
    int j;
    label58:
    Object localObject2;
    if (this.mTmpAddedFragments == null)
    {
      this.mTmpAddedFragments = new ArrayList();
      this.mTmpAddedFragments.addAll(this.mFragmentStore.getFragments());
      localObject1 = getPrimaryNavigationFragment();
      j = paramInt1;
      i = 0;
      if (j >= paramInt2) {
        break label161;
      }
      localObject2 = (a)paramArrayList.get(j);
      if (((Boolean)paramArrayList1.get(j)).booleanValue()) {
        break label139;
      }
      localObject1 = ((a)localObject2).a(this.mTmpAddedFragments, (Fragment)localObject1);
      label104:
      if ((i == 0) && (!((a)localObject2).bDG)) {
        break label155;
      }
    }
    label139:
    label155:
    for (int i = 1;; i = 0)
    {
      j += 1;
      break label58;
      this.mTmpAddedFragments.clear();
      break;
      localObject1 = ((a)localObject2).b(this.mTmpAddedFragments, (Fragment)localObject1);
      break label104;
    }
    label161:
    this.mTmpAddedFragments.clear();
    if ((!bool) && (this.mCurState > 0))
    {
      if (USE_STATE_MANAGER)
      {
        j = paramInt1;
        while (j < paramInt2)
        {
          localObject1 = ((a)paramArrayList.get(j)).bDF.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = ((r.a)((Iterator)localObject1).next()).bDv;
            if ((localObject2 != null) && (((Fragment)localObject2).mFragmentManager != null))
            {
              localObject2 = createOrGetFragmentStateManager((Fragment)localObject2);
              this.mFragmentStore.a((o)localObject2);
            }
          }
          j += 1;
        }
      }
      s.a(this.mHost.mContext, this.mContainer, paramArrayList, paramArrayList1, paramInt1, paramInt2, false, this.mFragmentTransitionCallback);
    }
    executeOps(paramArrayList, paramArrayList1, paramInt1, paramInt2);
    int k;
    if (USE_STATE_MANAGER)
    {
      bool = ((Boolean)paramArrayList1.get(paramInt2 - 1)).booleanValue();
      j = paramInt1;
      while (j < paramInt2)
      {
        localObject1 = (a)paramArrayList.get(j);
        if (bool)
        {
          k = ((a)localObject1).bDF.size() - 1;
          while (k >= 0)
          {
            localObject2 = ((r.a)((a)localObject1).bDF.get(k)).bDv;
            if (localObject2 != null) {
              createOrGetFragmentStateManager((Fragment)localObject2).Gq();
            }
            k -= 1;
          }
        }
        localObject1 = ((a)localObject1).bDF.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = ((r.a)((Iterator)localObject1).next()).bDv;
          if (localObject2 != null) {
            createOrGetFragmentStateManager((Fragment)localObject2).Gq();
          }
        }
        j += 1;
      }
      moveToState(this.mCurState, true);
      localObject1 = collectChangedControllers(paramArrayList, paramInt1, paramInt2).iterator();
      for (;;)
      {
        k = paramInt1;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (x)((Iterator)localObject1).next();
        ((x)localObject2).bEG = bool;
        ((x)localObject2).GG();
        ((x)localObject2).GH();
      }
    }
    if (bool)
    {
      localObject1 = new androidx.b.b();
      addAddedFragments((androidx.b.b)localObject1);
      j = postponePostponableTransactions(paramArrayList, paramArrayList1, paramInt1, paramInt2, (androidx.b.b)localObject1);
      makeRemovedFragmentsInvisible((androidx.b.b)localObject1);
    }
    for (;;)
    {
      k = paramInt1;
      if (j != paramInt1)
      {
        k = paramInt1;
        if (bool)
        {
          if (this.mCurState > 0) {
            s.a(this.mHost.mContext, this.mContainer, paramArrayList, paramArrayList1, paramInt1, j, true, this.mFragmentTransitionCallback);
          }
          moveToState(this.mCurState, true);
          k = paramInt1;
        }
      }
      while (k < paramInt2)
      {
        localObject1 = (a)paramArrayList.get(k);
        if ((((Boolean)paramArrayList1.get(k)).booleanValue()) && (((a)localObject1).mIndex >= 0)) {
          ((a)localObject1).mIndex = -1;
        }
        ((a)localObject1).FV();
        k += 1;
      }
      if (i != 0) {
        reportBackStackChanged();
      }
      return;
      j = paramInt2;
    }
  }
  
  private void executePostponedTransaction(ArrayList<a> paramArrayList, ArrayList<Boolean> paramArrayList1)
  {
    int i;
    int j;
    label12:
    h localh;
    int k;
    if (this.mPostponedTransactions == null)
    {
      i = 0;
      j = 0;
      if (j >= i) {
        return;
      }
      localh = (h)this.mPostponedTransactions.get(j);
      if ((paramArrayList == null) || (localh.bCX)) {
        break label125;
      }
      k = paramArrayList.indexOf(localh.bCY);
      if ((k == -1) || (paramArrayList1 == null) || (!((Boolean)paramArrayList1.get(k)).booleanValue())) {
        break label125;
      }
      this.mPostponedTransactions.remove(j);
      localh.Gn();
      j -= 1;
      i -= 1;
    }
    for (;;)
    {
      j += 1;
      break label12;
      i = this.mPostponedTransactions.size();
      break;
      label125:
      if (localh.bCZ == 0) {}
      int m;
      for (k = 1;; k = 0)
      {
        if (k == 0)
        {
          m = j;
          k = i;
          if (paramArrayList == null) {
            break label270;
          }
          m = j;
          k = i;
          if (!localh.bCY.d(paramArrayList, 0, paramArrayList.size())) {
            break label270;
          }
        }
        this.mPostponedTransactions.remove(j);
        m = j - 1;
        i -= 1;
        if ((paramArrayList == null) || (localh.bCX)) {
          break label262;
        }
        j = paramArrayList.indexOf(localh.bCY);
        if ((j == -1) || (paramArrayList1 == null) || (!((Boolean)paramArrayList1.get(j)).booleanValue())) {
          break label262;
        }
        localh.Gn();
        j = m;
        break;
      }
      label262:
      localh.Gm();
      k = i;
      label270:
      j = m;
      i = k;
    }
  }
  
  public static <F extends Fragment> F findFragment(View paramView)
  {
    Fragment localFragment = findViewFragment(paramView);
    if (localFragment == null) {
      throw new IllegalStateException("View " + paramView + " does not have a Fragment set");
    }
    return localFragment;
  }
  
  static FragmentManager findFragmentManager(View paramView)
  {
    Object localObject = findViewFragment(paramView);
    if (localObject != null)
    {
      if (!((Fragment)localObject).isAdded()) {
        throw new IllegalStateException("The Fragment " + localObject + " that owns View " + paramView + " has already been destroyed. Nested fragments should always use the child FragmentManager.");
      }
      return ((Fragment)localObject).getChildFragmentManager();
    }
    localObject = paramView.getContext();
    if ((localObject instanceof ContextWrapper)) {
      if (!(localObject instanceof FragmentActivity)) {}
    }
    for (localObject = (FragmentActivity)localObject;; localObject = null)
    {
      if (localObject != null)
      {
        return ((FragmentActivity)localObject).getSupportFragmentManager();
        localObject = ((ContextWrapper)localObject).getBaseContext();
        break;
      }
      throw new IllegalStateException("View " + paramView + " is not within a subclass of FragmentActivity.");
    }
  }
  
  private static Fragment findViewFragment(View paramView)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramView != null)
    {
      localObject1 = getViewFragment(paramView);
      if (localObject1 == null) {}
    }
    else
    {
      return localObject1;
    }
    paramView = paramView.getParent();
    if ((paramView instanceof View)) {}
    for (paramView = (View)paramView;; paramView = null) {
      break;
    }
  }
  
  private void forcePostponedTransactions()
  {
    if (USE_STATE_MANAGER)
    {
      Iterator localIterator = collectAllSpecialEffectsController().iterator();
      while (localIterator.hasNext())
      {
        x localx = (x)localIterator.next();
        if (localx.bEH)
        {
          localx.bEH = false;
          localx.GH();
        }
      }
    }
    if (this.mPostponedTransactions != null) {
      while (!this.mPostponedTransactions.isEmpty()) {
        ((h)this.mPostponedTransactions.remove(0)).Gm();
      }
    }
  }
  
  private boolean generateOpsForPendingActions(ArrayList<a> paramArrayList, ArrayList<Boolean> paramArrayList1)
  {
    synchronized (this.mPendingActions)
    {
      if (this.mPendingActions.isEmpty()) {
        return false;
      }
      int j = this.mPendingActions.size();
      int i = 0;
      boolean bool = false;
      while (i < j)
      {
        bool |= ((f)this.mPendingActions.get(i)).a(paramArrayList, paramArrayList1);
        i += 1;
      }
      this.mPendingActions.clear();
      this.mHost.mHandler.removeCallbacks(this.mExecCommit);
      return bool;
    }
  }
  
  private k getChildNonConfig(Fragment paramFragment)
  {
    k localk3 = this.mNonConfig;
    k localk2 = (k)localk3.bDn.get(paramFragment.mWho);
    k localk1 = localk2;
    if (localk2 == null)
    {
      localk1 = new k(localk3.bDp);
      localk3.bDn.put(paramFragment.mWho, localk1);
    }
    return localk1;
  }
  
  private ViewGroup getFragmentContainer(Fragment paramFragment)
  {
    if (paramFragment.mContainer != null) {
      return paramFragment.mContainer;
    }
    if (paramFragment.mContainerId <= 0) {
      return null;
    }
    if (this.mContainer.onHasView())
    {
      paramFragment = this.mContainer.onFindViewById(paramFragment.mContainerId);
      if ((paramFragment instanceof ViewGroup)) {
        return (ViewGroup)paramFragment;
      }
    }
    return null;
  }
  
  static Fragment getViewFragment(View paramView)
  {
    paramView = paramView.getTag(a.b.fragment_container_view_tag);
    if ((paramView instanceof Fragment)) {
      return (Fragment)paramView;
    }
    return null;
  }
  
  static boolean isLoggingEnabled(int paramInt)
  {
    return (DEBUG) || (Log.isLoggable("FragmentManager", paramInt));
  }
  
  private boolean isMenuAvailable(Fragment paramFragment)
  {
    return ((paramFragment.mHasMenu) && (paramFragment.mMenuVisible)) || (paramFragment.mChildFragmentManager.checkForMenus());
  }
  
  private void makeRemovedFragmentsInvisible(androidx.b.b<Fragment> paramb)
  {
    int j = paramb.size();
    int i = 0;
    while (i < j)
    {
      Fragment localFragment = (Fragment)paramb.RQ[i];
      if (!localFragment.mAdded)
      {
        View localView = localFragment.requireView();
        localFragment.mPostponedAlpha = localView.getAlpha();
        localView.setAlpha(0.0F);
      }
      i += 1;
    }
  }
  
  private boolean popBackStackImmediate(String paramString, int paramInt1, int paramInt2)
  {
    execPendingActions(false);
    ensureExecReady(true);
    if ((this.mPrimaryNav != null) && (paramInt1 < 0) && (paramString == null) && (this.mPrimaryNav.getChildFragmentManager().popBackStackImmediate())) {
      return true;
    }
    boolean bool = popBackStackState(this.mTmpRecords, this.mTmpIsPop, paramString, paramInt1, paramInt2);
    if (bool) {
      this.mExecutingActions = true;
    }
    try
    {
      removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);
      cleanupExec();
      updateOnBackPressedCallbackEnabled();
      doPendingDeferredStart();
      this.mFragmentStore.Gy();
      return bool;
    }
    finally
    {
      cleanupExec();
    }
  }
  
  private int postponePostponableTransactions(ArrayList<a> paramArrayList, ArrayList<Boolean> paramArrayList1, int paramInt1, int paramInt2, androidx.b.b<Fragment> paramb)
  {
    int j = paramInt2 - 1;
    int i = paramInt2;
    a locala;
    int k;
    label165:
    if (j >= paramInt1)
    {
      locala = (a)paramArrayList.get(j);
      boolean bool = ((Boolean)paramArrayList1.get(j)).booleanValue();
      k = 0;
      label44:
      if (k < locala.bDF.size()) {
        if (a.a((r.a)locala.bDF.get(k)))
        {
          k = 1;
          label79:
          if ((k == 0) || (locala.d(paramArrayList, j + 1, paramInt2))) {
            break label223;
          }
          k = 1;
          label102:
          if (k == 0) {
            break label241;
          }
          if (this.mPostponedTransactions == null) {
            this.mPostponedTransactions = new ArrayList();
          }
          h localh = new h(locala, bool);
          this.mPostponedTransactions.add(localh);
          locala.a(localh);
          if (!bool) {
            break label229;
          }
          locala.Ga();
          i -= 1;
          if (j != i)
          {
            paramArrayList.remove(j);
            paramArrayList.add(i, locala);
          }
          addAddedFragments(paramb);
        }
      }
    }
    label223:
    label229:
    label241:
    for (;;)
    {
      j -= 1;
      break;
      k += 1;
      break label44;
      k = 0;
      break label79;
      k = 0;
      break label102;
      locala.aQ(false);
      break label165;
      return i;
    }
  }
  
  private void removeRedundantOperationsAndExecute(ArrayList<a> paramArrayList, ArrayList<Boolean> paramArrayList1)
  {
    if (paramArrayList.isEmpty()) {
      return;
    }
    if (paramArrayList.size() != paramArrayList1.size()) {
      throw new IllegalStateException("Internal error with the back stack records");
    }
    executePostponedTransaction(paramArrayList, paramArrayList1);
    int m = paramArrayList.size();
    int i = 0;
    int j = 0;
    label47:
    int k;
    if (i < m)
    {
      if (((a)paramArrayList.get(i)).bBq) {
        break label214;
      }
      if (j != i) {
        executeOpsTogether(paramArrayList, paramArrayList1, j, i);
      }
      k = i + 1;
      j = k;
      if (((Boolean)paramArrayList1.get(i)).booleanValue()) {
        for (;;)
        {
          j = k;
          if (k >= m) {
            break;
          }
          j = k;
          if (!((Boolean)paramArrayList1.get(k)).booleanValue()) {
            break;
          }
          j = k;
          if (((a)paramArrayList.get(k)).bBq) {
            break;
          }
          k += 1;
        }
      }
      executeOpsTogether(paramArrayList, paramArrayList1, i, j);
      k = j - 1;
    }
    for (i = j;; i = j)
    {
      k += 1;
      j = i;
      i = k;
      break label47;
      if (j == m) {
        break;
      }
      executeOpsTogether(paramArrayList, paramArrayList1, j, m);
      return;
      label214:
      k = i;
    }
  }
  
  private void reportBackStackChanged()
  {
    if (this.mBackStackChangeListeners != null)
    {
      int i = 0;
      while (i < this.mBackStackChangeListeners.size())
      {
        ((FragmentManager.e)this.mBackStackChangeListeners.get(i)).onBackStackChanged();
        i += 1;
      }
    }
  }
  
  static int reverseTransit(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 4097: 
      return 8194;
    case 8194: 
      return 4097;
    }
    return 4099;
  }
  
  private void setVisibleRemovingFragment(Fragment paramFragment)
  {
    ViewGroup localViewGroup = getFragmentContainer(paramFragment);
    if ((localViewGroup != null) && (paramFragment.getEnterAnim() + paramFragment.getExitAnim() + paramFragment.getPopEnterAnim() + paramFragment.getPopExitAnim() > 0))
    {
      if (localViewGroup.getTag(a.b.visible_removing_fragment_view_tag) == null) {
        localViewGroup.setTag(a.b.visible_removing_fragment_view_tag, paramFragment);
      }
      ((Fragment)localViewGroup.getTag(a.b.visible_removing_fragment_view_tag)).setPopDirection(paramFragment.getPopDirection());
    }
  }
  
  private void startPendingDeferredFragments()
  {
    Iterator localIterator = this.mFragmentStore.GA().iterator();
    while (localIterator.hasNext()) {
      performPendingDeferredStart((o)localIterator.next());
    }
  }
  
  private void throwException(RuntimeException paramRuntimeException)
  {
    paramRuntimeException.getMessage();
    PrintWriter localPrintWriter = new PrintWriter(new w("FragmentManager"));
    if (this.mHost != null) {}
    try
    {
      this.mHost.a("  ", localPrintWriter, new String[0]);
      for (;;)
      {
        label44:
        throw paramRuntimeException;
        try
        {
          dump("  ", null, localPrintWriter, new String[0]);
        }
        catch (Exception localException1) {}
      }
    }
    catch (Exception localException2)
    {
      break label44;
    }
  }
  
  private void updateOnBackPressedCallbackEnabled()
  {
    for (boolean bool = true;; bool = false) {
      synchronized (this.mPendingActions)
      {
        if (!this.mPendingActions.isEmpty())
        {
          this.mOnBackPressedCallback.setEnabled(true);
          return;
        }
        ??? = this.mOnBackPressedCallback;
        if ((getBackStackEntryCount() > 0) && (isPrimaryNavigation(this.mParent)))
        {
          ((androidx.activity.b)???).setEnabled(bool);
          return;
        }
      }
    }
  }
  
  void addBackStackState(a parama)
  {
    if (this.mBackStack == null) {
      this.mBackStack = new ArrayList();
    }
    this.mBackStack.add(parama);
  }
  
  void addCancellationSignal(Fragment paramFragment, androidx.core.c.b paramb)
  {
    if (this.mExitAnimationCancellationSignals.get(paramFragment) == null) {
      this.mExitAnimationCancellationSignals.put(paramFragment, new HashSet());
    }
    ((HashSet)this.mExitAnimationCancellationSignals.get(paramFragment)).add(paramb);
  }
  
  o addFragment(Fragment paramFragment)
  {
    if (isLoggingEnabled(2)) {
      new StringBuilder("add: ").append(paramFragment);
    }
    o localo = createOrGetFragmentStateManager(paramFragment);
    paramFragment.mFragmentManager = this;
    this.mFragmentStore.a(localo);
    if (!paramFragment.mDetached)
    {
      this.mFragmentStore.p(paramFragment);
      paramFragment.mRemoving = false;
      if (paramFragment.mView == null) {
        paramFragment.mHiddenChanged = false;
      }
      if (isMenuAvailable(paramFragment)) {
        this.mNeedMenuInvalidate = true;
      }
    }
    return localo;
  }
  
  public void addFragmentOnAttachListener(l paraml)
  {
    this.mOnAttachListeners.add(paraml);
  }
  
  public void addOnBackStackChangedListener(FragmentManager.e parame)
  {
    if (this.mBackStackChangeListeners == null) {
      this.mBackStackChangeListeners = new ArrayList();
    }
    this.mBackStackChangeListeners.add(parame);
  }
  
  void addRetainedFragment(Fragment paramFragment)
  {
    this.mNonConfig.addRetainedFragment(paramFragment);
  }
  
  int allocBackStackIndex()
  {
    return this.mBackStackIndex.getAndIncrement();
  }
  
  void attachController(g<?> paramg, d paramd, final Fragment paramFragment)
  {
    if (this.mHost != null) {
      throw new IllegalStateException("Already attached");
    }
    this.mHost = paramg;
    this.mContainer = paramd;
    this.mParent = paramFragment;
    if (this.mParent != null)
    {
      addFragmentOnAttachListener(new l()
      {
        public final void e(Fragment paramAnonymousFragment)
        {
          AppMethodBeat.i(193830);
          paramFragment.onAttachFragment(paramAnonymousFragment);
          AppMethodBeat.o(193830);
        }
      });
      if (this.mParent != null) {
        updateOnBackPressedCallbackEnabled();
      }
      if ((paramg instanceof androidx.activity.c))
      {
        paramd = (androidx.activity.c)paramg;
        this.mOnBackPressedDispatcher = paramd.getOnBackPressedDispatcher();
        if (paramFragment != null) {
          paramd = paramFragment;
        }
        this.mOnBackPressedDispatcher.a(paramd, this.mOnBackPressedCallback);
      }
      if (paramFragment == null) {
        break label352;
      }
      this.mNonConfig = paramFragment.mFragmentManager.getChildNonConfig(paramFragment);
      label120:
      this.mNonConfig.bDs = isStateSaved();
      this.mFragmentStore.mNonConfig = this.mNonConfig;
      if ((this.mHost instanceof androidx.activity.result.d))
      {
        paramd = ((androidx.activity.result.d)this.mHost).getActivityResultRegistry();
        if (paramFragment == null) {
          break label393;
        }
      }
    }
    label393:
    for (paramg = paramFragment.mWho + ":";; paramg = "")
    {
      paramg = "FragmentManager:".concat(String.valueOf(paramg));
      this.mStartActivityForResult = paramd.a(paramg + "StartActivityForResult", new b.b(), new androidx.activity.result.a() {});
      this.mStartIntentSenderForResult = paramd.a(paramg + "StartIntentSenderForResult", new b(), new androidx.activity.result.a() {});
      this.mRequestPermissions = paramd.a(paramg + "RequestPermissions", new b.a(), new androidx.activity.result.a() {});
      return;
      if (!(paramg instanceof l)) {
        break;
      }
      addFragmentOnAttachListener((l)paramg);
      break;
      label352:
      if ((paramg instanceof ak))
      {
        this.mNonConfig = k.a(((ak)paramg).getViewModelStore());
        break label120;
      }
      this.mNonConfig = new k(false);
      break label120;
    }
  }
  
  void attachFragment(Fragment paramFragment)
  {
    if (isLoggingEnabled(2)) {
      new StringBuilder("attach: ").append(paramFragment);
    }
    if (paramFragment.mDetached)
    {
      paramFragment.mDetached = false;
      if (!paramFragment.mAdded)
      {
        this.mFragmentStore.p(paramFragment);
        if (isLoggingEnabled(2)) {
          new StringBuilder("add from attach: ").append(paramFragment);
        }
        if (isMenuAvailable(paramFragment)) {
          this.mNeedMenuInvalidate = true;
        }
      }
    }
  }
  
  public r beginTransaction()
  {
    return new a(this);
  }
  
  boolean checkForMenus()
  {
    boolean bool3 = false;
    Iterator localIterator = this.mFragmentStore.getActiveFragments().iterator();
    boolean bool1 = false;
    boolean bool2 = bool3;
    if (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)localIterator.next();
      if (localFragment == null) {
        break label65;
      }
      bool1 = isMenuAvailable(localFragment);
    }
    label65:
    for (;;)
    {
      if (bool1)
      {
        bool2 = true;
        return bool2;
      }
      break;
    }
  }
  
  public final void clearFragmentResult(String paramString)
  {
    this.mResults.remove(paramString);
  }
  
  public final void clearFragmentResultListener(String paramString)
  {
    paramString = (d)this.mResultListeners.remove(paramString);
    if (paramString != null) {
      paramString.Gl();
    }
  }
  
  void completeExecute(a parama, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject1;
    Object localObject2;
    if (paramBoolean1)
    {
      parama.aQ(paramBoolean3);
      localObject1 = new ArrayList(1);
      localObject2 = new ArrayList(1);
      ((ArrayList)localObject1).add(parama);
      ((ArrayList)localObject2).add(Boolean.valueOf(paramBoolean1));
      if ((paramBoolean2) && (this.mCurState > 0)) {
        s.a(this.mHost.mContext, this.mContainer, (ArrayList)localObject1, (ArrayList)localObject2, 0, 1, true, this.mFragmentTransitionCallback);
      }
      if (paramBoolean3) {
        moveToState(this.mCurState, true);
      }
      localObject1 = this.mFragmentStore.getActiveFragments().iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext()) {
        return;
      }
      localObject2 = (Fragment)((Iterator)localObject1).next();
      if ((localObject2 != null) && (((Fragment)localObject2).mView != null) && (((Fragment)localObject2).mIsNewlyAdded) && (parama.eT(((Fragment)localObject2).mContainerId)))
      {
        if (((Fragment)localObject2).mPostponedAlpha > 0.0F) {
          ((Fragment)localObject2).mView.setAlpha(((Fragment)localObject2).mPostponedAlpha);
        }
        if (paramBoolean3)
        {
          ((Fragment)localObject2).mPostponedAlpha = 0.0F;
          continue;
          parama.Ga();
          break;
        }
        ((Fragment)localObject2).mPostponedAlpha = -1.0F;
        ((Fragment)localObject2).mIsNewlyAdded = false;
      }
    }
  }
  
  o createOrGetFragmentStateManager(Fragment paramFragment)
  {
    o localo = this.mFragmentStore.aH(paramFragment.mWho);
    if (localo != null) {
      return localo;
    }
    paramFragment = new o(this.mLifecycleCallbacksDispatcher, this.mFragmentStore, paramFragment);
    paramFragment.a(this.mHost.mContext.getClassLoader());
    paramFragment.bDx = this.mCurState;
    return paramFragment;
  }
  
  void detachFragment(Fragment paramFragment)
  {
    if (isLoggingEnabled(2)) {
      new StringBuilder("detach: ").append(paramFragment);
    }
    if (!paramFragment.mDetached)
    {
      paramFragment.mDetached = true;
      if (paramFragment.mAdded)
      {
        if (isLoggingEnabled(2)) {
          new StringBuilder("remove from detach: ").append(paramFragment);
        }
        this.mFragmentStore.removeFragment(paramFragment);
        if (isMenuAvailable(paramFragment)) {
          this.mNeedMenuInvalidate = true;
        }
        setVisibleRemovingFragment(paramFragment);
      }
    }
  }
  
  void dispatchActivityCreated()
  {
    this.mStateSaved = false;
    this.mStopped = false;
    this.mNonConfig.bDs = false;
    dispatchStateChange(4);
  }
  
  void dispatchAttach()
  {
    this.mStateSaved = false;
    this.mStopped = false;
    this.mNonConfig.bDs = false;
    dispatchStateChange(0);
  }
  
  void dispatchConfigurationChanged(Configuration paramConfiguration)
  {
    Iterator localIterator = this.mFragmentStore.getFragments().iterator();
    while (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)localIterator.next();
      if (localFragment != null) {
        localFragment.performConfigurationChanged(paramConfiguration);
      }
    }
  }
  
  boolean dispatchContextItemSelected(MenuItem paramMenuItem)
  {
    if (this.mCurState <= 0) {
      return false;
    }
    Iterator localIterator = this.mFragmentStore.getFragments().iterator();
    while (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)localIterator.next();
      if ((localFragment != null) && (localFragment.performContextItemSelected(paramMenuItem))) {
        return true;
      }
    }
    return false;
  }
  
  void dispatchCreate()
  {
    this.mStateSaved = false;
    this.mStopped = false;
    this.mNonConfig.bDs = false;
    dispatchStateChange(1);
  }
  
  boolean dispatchCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    int i = 0;
    if (this.mCurState <= 0) {
      return false;
    }
    Object localObject1 = null;
    Iterator localIterator = this.mFragmentStore.getFragments().iterator();
    boolean bool1 = false;
    while (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)localIterator.next();
      Object localObject2 = localObject1;
      boolean bool2 = bool1;
      if (localFragment != null)
      {
        localObject2 = localObject1;
        bool2 = bool1;
        if (isParentMenuVisible(localFragment))
        {
          localObject2 = localObject1;
          bool2 = bool1;
          if (localFragment.performCreateOptionsMenu(paramMenu, paramMenuInflater))
          {
            bool2 = true;
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = new ArrayList();
            }
            ((ArrayList)localObject2).add(localFragment);
          }
        }
      }
      bool1 = bool2;
      localObject1 = localObject2;
    }
    if (this.mCreatedMenus != null) {
      while (i < this.mCreatedMenus.size())
      {
        paramMenu = (Fragment)this.mCreatedMenus.get(i);
        if ((localObject1 == null) || (!localObject1.contains(paramMenu))) {
          paramMenu.onDestroyOptionsMenu();
        }
        i += 1;
      }
    }
    this.mCreatedMenus = localObject1;
    return bool1;
  }
  
  void dispatchDestroy()
  {
    this.mDestroyed = true;
    execPendingActions(true);
    endAnimatingAwayFragments();
    dispatchStateChange(-1);
    this.mHost = null;
    this.mContainer = null;
    this.mParent = null;
    if (this.mOnBackPressedDispatcher != null)
    {
      this.mOnBackPressedCallback.remove();
      this.mOnBackPressedDispatcher = null;
    }
    if (this.mStartActivityForResult != null)
    {
      this.mStartActivityForResult.unregister();
      this.mStartIntentSenderForResult.unregister();
      this.mRequestPermissions.unregister();
    }
  }
  
  void dispatchDestroyView()
  {
    dispatchStateChange(1);
  }
  
  void dispatchLowMemory()
  {
    Iterator localIterator = this.mFragmentStore.getFragments().iterator();
    while (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)localIterator.next();
      if (localFragment != null) {
        localFragment.performLowMemory();
      }
    }
  }
  
  void dispatchMultiWindowModeChanged(boolean paramBoolean)
  {
    Iterator localIterator = this.mFragmentStore.getFragments().iterator();
    while (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)localIterator.next();
      if (localFragment != null) {
        localFragment.performMultiWindowModeChanged(paramBoolean);
      }
    }
  }
  
  void dispatchOnAttachFragment(Fragment paramFragment)
  {
    Iterator localIterator = this.mOnAttachListeners.iterator();
    while (localIterator.hasNext()) {
      ((l)localIterator.next()).e(paramFragment);
    }
  }
  
  boolean dispatchOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (this.mCurState <= 0) {
      return false;
    }
    Iterator localIterator = this.mFragmentStore.getFragments().iterator();
    while (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)localIterator.next();
      if ((localFragment != null) && (localFragment.performOptionsItemSelected(paramMenuItem))) {
        return true;
      }
    }
    return false;
  }
  
  void dispatchOptionsMenuClosed(Menu paramMenu)
  {
    if (this.mCurState <= 0) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.mFragmentStore.getFragments().iterator();
      while (localIterator.hasNext())
      {
        Fragment localFragment = (Fragment)localIterator.next();
        if (localFragment != null) {
          localFragment.performOptionsMenuClosed(paramMenu);
        }
      }
    }
  }
  
  void dispatchPause()
  {
    dispatchStateChange(5);
  }
  
  void dispatchPictureInPictureModeChanged(boolean paramBoolean)
  {
    Iterator localIterator = this.mFragmentStore.getFragments().iterator();
    while (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)localIterator.next();
      if (localFragment != null) {
        localFragment.performPictureInPictureModeChanged(paramBoolean);
      }
    }
  }
  
  boolean dispatchPrepareOptionsMenu(Menu paramMenu)
  {
    if (this.mCurState <= 0) {
      return false;
    }
    Iterator localIterator = this.mFragmentStore.getFragments().iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)localIterator.next();
      if ((localFragment == null) || (!isParentMenuVisible(localFragment)) || (!localFragment.performPrepareOptionsMenu(paramMenu))) {
        break label74;
      }
      bool = true;
    }
    label74:
    for (;;)
    {
      break;
      return bool;
    }
  }
  
  void dispatchPrimaryNavigationFragmentChanged()
  {
    updateOnBackPressedCallbackEnabled();
    dispatchParentPrimaryNavigationFragmentChanged(this.mPrimaryNav);
  }
  
  void dispatchResume()
  {
    this.mStateSaved = false;
    this.mStopped = false;
    this.mNonConfig.bDs = false;
    dispatchStateChange(7);
  }
  
  void dispatchStart()
  {
    this.mStateSaved = false;
    this.mStopped = false;
    this.mNonConfig.bDs = false;
    dispatchStateChange(5);
  }
  
  void dispatchStop()
  {
    this.mStopped = true;
    this.mNonConfig.bDs = true;
    dispatchStateChange(4);
  }
  
  void dispatchViewCreated()
  {
    dispatchStateChange(2);
  }
  
  public void dump(String paramString, FileDescriptor arg2, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    int j = 0;
    String str = paramString + "    ";
    this.mFragmentStore.dump(paramString, ???, paramPrintWriter, paramArrayOfString);
    int k;
    int i;
    if (this.mCreatedMenus != null)
    {
      k = this.mCreatedMenus.size();
      if (k > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.println("Fragments Created Menus:");
        i = 0;
        while (i < k)
        {
          ??? = (Fragment)this.mCreatedMenus.get(i);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(???.toString());
          i += 1;
        }
      }
    }
    if (this.mBackStack != null)
    {
      k = this.mBackStack.size();
      if (k > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.println("Back Stack:");
        i = 0;
        while (i < k)
        {
          ??? = (a)this.mBackStack.get(i);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(???.toString());
          ???.a(str, paramPrintWriter);
          i += 1;
        }
      }
    }
    paramPrintWriter.print(paramString);
    paramPrintWriter.println("Back Stack Index: " + this.mBackStackIndex.get());
    synchronized (this.mPendingActions)
    {
      k = this.mPendingActions.size();
      if (k > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.println("Pending Actions:");
        i = j;
        while (i < k)
        {
          paramArrayOfString = (f)this.mPendingActions.get(i);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(paramArrayOfString);
          i += 1;
        }
      }
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("FragmentManager misc state:");
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  mHost=");
      paramPrintWriter.println(this.mHost);
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  mContainer=");
      paramPrintWriter.println(this.mContainer);
      if (this.mParent != null)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  mParent=");
        paramPrintWriter.println(this.mParent);
      }
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  mCurState=");
      paramPrintWriter.print(this.mCurState);
      paramPrintWriter.print(" mStateSaved=");
      paramPrintWriter.print(this.mStateSaved);
      paramPrintWriter.print(" mStopped=");
      paramPrintWriter.print(this.mStopped);
      paramPrintWriter.print(" mDestroyed=");
      paramPrintWriter.println(this.mDestroyed);
      if (this.mNeedMenuInvalidate)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  mNeedMenuInvalidate=");
        paramPrintWriter.println(this.mNeedMenuInvalidate);
      }
      return;
    }
  }
  
  void enqueueAction(f paramf, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      if (this.mHost == null)
      {
        if (this.mDestroyed) {
          throw new IllegalStateException("FragmentManager has been destroyed");
        }
        throw new IllegalStateException("FragmentManager has not been attached to a host.");
      }
      checkStateLoss();
    }
    synchronized (this.mPendingActions)
    {
      if (this.mHost == null)
      {
        if (paramBoolean) {
          return;
        }
        throw new IllegalStateException("Activity has been destroyed");
      }
    }
    this.mPendingActions.add(paramf);
    scheduleCommit();
  }
  
  boolean execPendingActions(boolean paramBoolean)
  {
    ensureExecReady(paramBoolean);
    paramBoolean = false;
    for (;;)
    {
      if (generateOpsForPendingActions(this.mTmpRecords, this.mTmpIsPop)) {
        this.mExecutingActions = true;
      }
      try
      {
        removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);
        cleanupExec();
        paramBoolean = true;
      }
      finally
      {
        cleanupExec();
      }
    }
    doPendingDeferredStart();
    this.mFragmentStore.Gy();
    return paramBoolean;
  }
  
  void execSingleAction(f paramf, boolean paramBoolean)
  {
    if ((paramBoolean) && ((this.mHost == null) || (this.mDestroyed))) {
      return;
    }
    ensureExecReady(paramBoolean);
    if (paramf.a(this.mTmpRecords, this.mTmpIsPop)) {
      this.mExecutingActions = true;
    }
    try
    {
      removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);
      cleanupExec();
      updateOnBackPressedCallbackEnabled();
      doPendingDeferredStart();
      this.mFragmentStore.Gy();
      return;
    }
    finally
    {
      cleanupExec();
    }
  }
  
  public boolean executePendingTransactions()
  {
    boolean bool = execPendingActions(true);
    forcePostponedTransactions();
    return bool;
  }
  
  Fragment findActiveFragment(String paramString)
  {
    return this.mFragmentStore.findActiveFragment(paramString);
  }
  
  public Fragment findFragmentById(int paramInt)
  {
    Object localObject1 = this.mFragmentStore;
    int i = ((q)localObject1).bDe.size() - 1;
    Object localObject2;
    while (i >= 0)
    {
      localObject2 = (Fragment)((q)localObject1).bDe.get(i);
      if ((localObject2 != null) && (((Fragment)localObject2).mFragmentId == paramInt)) {
        return localObject2;
      }
      i -= 1;
    }
    localObject1 = ((q)localObject1).bDB.values().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (o)((Iterator)localObject1).next();
      if (localObject2 != null)
      {
        localObject2 = ((o)localObject2).bDv;
        if (((Fragment)localObject2).mFragmentId == paramInt) {
          return localObject2;
        }
      }
    }
    return null;
  }
  
  public Fragment findFragmentByTag(String paramString)
  {
    Object localObject1 = this.mFragmentStore;
    Object localObject2;
    if (paramString != null)
    {
      int i = ((q)localObject1).bDe.size() - 1;
      while (i >= 0)
      {
        localObject2 = (Fragment)((q)localObject1).bDe.get(i);
        if ((localObject2 != null) && (paramString.equals(((Fragment)localObject2).mTag))) {
          return localObject2;
        }
        i -= 1;
      }
    }
    if (paramString != null)
    {
      localObject1 = ((q)localObject1).bDB.values().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (o)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          localObject2 = ((o)localObject2).bDv;
          if (paramString.equals(((Fragment)localObject2).mTag)) {
            return localObject2;
          }
        }
      }
    }
    return null;
  }
  
  Fragment findFragmentByWho(String paramString)
  {
    return this.mFragmentStore.findFragmentByWho(paramString);
  }
  
  int getActiveFragmentCount()
  {
    return this.mFragmentStore.bDB.size();
  }
  
  List<Fragment> getActiveFragments()
  {
    return this.mFragmentStore.getActiveFragments();
  }
  
  public a getBackStackEntryAt(int paramInt)
  {
    return (a)this.mBackStack.get(paramInt);
  }
  
  public int getBackStackEntryCount()
  {
    if (this.mBackStack != null) {
      return this.mBackStack.size();
    }
    return 0;
  }
  
  d getContainer()
  {
    return this.mContainer;
  }
  
  public Fragment getFragment(Bundle paramBundle, String paramString)
  {
    String str = paramBundle.getString(paramString);
    if (str == null) {
      paramBundle = null;
    }
    Fragment localFragment;
    do
    {
      return paramBundle;
      localFragment = findActiveFragment(str);
      paramBundle = localFragment;
    } while (localFragment != null);
    throwException(new IllegalStateException("Fragment no longer exists for key " + paramString + ": unique id " + str));
    return localFragment;
  }
  
  public f getFragmentFactory()
  {
    if (this.mFragmentFactory != null) {
      return this.mFragmentFactory;
    }
    if (this.mParent != null) {
      return this.mParent.mFragmentManager.getFragmentFactory();
    }
    return this.mHostFragmentFactory;
  }
  
  q getFragmentStore()
  {
    return this.mFragmentStore;
  }
  
  public List<Fragment> getFragments()
  {
    return this.mFragmentStore.getFragments();
  }
  
  g<?> getHost()
  {
    return this.mHost;
  }
  
  LayoutInflater.Factory2 getLayoutInflaterFactory()
  {
    return this.mLayoutInflaterFactory;
  }
  
  i getLifecycleCallbacksDispatcher()
  {
    return this.mLifecycleCallbacksDispatcher;
  }
  
  Fragment getParent()
  {
    return this.mParent;
  }
  
  public Fragment getPrimaryNavigationFragment()
  {
    return this.mPrimaryNav;
  }
  
  y getSpecialEffectsControllerFactory()
  {
    if (this.mSpecialEffectsControllerFactory != null) {
      return this.mSpecialEffectsControllerFactory;
    }
    if (this.mParent != null) {
      return this.mParent.mFragmentManager.getSpecialEffectsControllerFactory();
    }
    return this.mDefaultSpecialEffectsControllerFactory;
  }
  
  aj getViewModelStore(Fragment paramFragment)
  {
    k localk = this.mNonConfig;
    aj localaj2 = (aj)localk.bDo.get(paramFragment.mWho);
    aj localaj1 = localaj2;
    if (localaj2 == null)
    {
      localaj1 = new aj();
      localk.bDo.put(paramFragment.mWho, localaj1);
    }
    return localaj1;
  }
  
  void handleOnBackPressed()
  {
    execPendingActions(true);
    if (this.mOnBackPressedCallback.isEnabled())
    {
      popBackStackImmediate();
      return;
    }
    this.mOnBackPressedDispatcher.onBackPressed();
  }
  
  void hideFragment(Fragment paramFragment)
  {
    boolean bool = true;
    if (isLoggingEnabled(2)) {
      new StringBuilder("hide: ").append(paramFragment);
    }
    if (!paramFragment.mHidden)
    {
      paramFragment.mHidden = true;
      if (paramFragment.mHiddenChanged) {
        break label54;
      }
    }
    for (;;)
    {
      paramFragment.mHiddenChanged = bool;
      setVisibleRemovingFragment(paramFragment);
      return;
      label54:
      bool = false;
    }
  }
  
  void invalidateMenuForFragment(Fragment paramFragment)
  {
    if ((paramFragment.mAdded) && (isMenuAvailable(paramFragment))) {
      this.mNeedMenuInvalidate = true;
    }
  }
  
  public boolean isDestroyed()
  {
    return this.mDestroyed;
  }
  
  boolean isParentMenuVisible(Fragment paramFragment)
  {
    if (paramFragment == null) {
      return true;
    }
    return paramFragment.isMenuVisible();
  }
  
  boolean isPrimaryNavigation(Fragment paramFragment)
  {
    if (paramFragment == null) {}
    FragmentManager localFragmentManager;
    do
    {
      return true;
      localFragmentManager = paramFragment.mFragmentManager;
    } while ((paramFragment.equals(localFragmentManager.getPrimaryNavigationFragment())) && (isPrimaryNavigation(localFragmentManager.mParent)));
    return false;
  }
  
  boolean isStateAtLeast(int paramInt)
  {
    return this.mCurState >= paramInt;
  }
  
  public boolean isStateSaved()
  {
    return (this.mStateSaved) || (this.mStopped);
  }
  
  void launchRequestPermissions(Fragment paramFragment, String[] paramArrayOfString, int paramInt)
  {
    if (this.mRequestPermissions != null)
    {
      paramFragment = new LaunchedFragmentInfo(paramFragment.mWho, paramInt);
      this.mLaunchedFragments.addLast(paramFragment);
      this.mRequestPermissions.m(paramArrayOfString);
    }
  }
  
  void launchStartActivityForResult(Fragment paramFragment, Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    if (this.mStartActivityForResult != null)
    {
      paramFragment = new LaunchedFragmentInfo(paramFragment.mWho, paramInt);
      this.mLaunchedFragments.addLast(paramFragment);
      if ((paramIntent != null) && (paramBundle != null)) {
        paramIntent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", paramBundle);
      }
      this.mStartActivityForResult.m(paramIntent);
      return;
    }
    this.mHost.a(paramIntent, paramInt, paramBundle);
  }
  
  void launchStartIntentSenderForResult(Fragment paramFragment, IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4, Bundle paramBundle)
  {
    if (this.mStartIntentSenderForResult != null)
    {
      Intent localIntent = paramIntent;
      if (paramBundle != null)
      {
        localIntent = paramIntent;
        if (paramIntent == null)
        {
          localIntent = new Intent();
          localIntent.putExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", true);
        }
        if (isLoggingEnabled(2)) {
          new StringBuilder("ActivityOptions ").append(paramBundle).append(" were added to fillInIntent ").append(localIntent).append(" for fragment ").append(paramFragment);
        }
        localIntent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", paramBundle);
      }
      paramIntentSender = new IntentSenderRequest.a(paramIntentSender).b(localIntent).j(paramInt3, paramInt2).bt();
      paramIntent = new LaunchedFragmentInfo(paramFragment.mWho, paramInt1);
      this.mLaunchedFragments.addLast(paramIntent);
      if (isLoggingEnabled(2)) {
        new StringBuilder("Fragment ").append(paramFragment).append("is launching an IntentSender for result ");
      }
      this.mStartIntentSenderForResult.m(paramIntentSender);
      return;
    }
    paramFragment = this.mHost;
    if (paramInt1 != -1) {
      throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
    }
    androidx.core.app.a.a(paramFragment.mActivity, paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
  }
  
  void moveFragmentToExpectedState(Fragment paramFragment)
  {
    if (!this.mFragmentStore.aG(paramFragment.mWho)) {
      if (isLoggingEnabled(3)) {
        new StringBuilder("Ignoring moving ").append(paramFragment).append(" to state ").append(this.mCurState).append("since it is not added to ").append(this);
      }
    }
    for (;;)
    {
      return;
      moveToState(paramFragment);
      c.a locala;
      if ((paramFragment.mView != null) && (paramFragment.mIsNewlyAdded) && (paramFragment.mContainer != null))
      {
        if (paramFragment.mPostponedAlpha > 0.0F) {
          paramFragment.mView.setAlpha(paramFragment.mPostponedAlpha);
        }
        paramFragment.mPostponedAlpha = 0.0F;
        paramFragment.mIsNewlyAdded = false;
        locala = c.a(this.mHost.mContext, paramFragment, true, paramFragment.getPopDirection());
        if (locala != null)
        {
          if (locala.bCz == null) {
            break label168;
          }
          paramFragment.mView.startAnimation(locala.bCz);
        }
      }
      while (paramFragment.mHiddenChanged)
      {
        completeShowHideFragment(paramFragment);
        return;
        label168:
        locala.bCA.setTarget(paramFragment.mView);
        locala.bCA.start();
      }
    }
  }
  
  void moveToState(int paramInt, boolean paramBoolean)
  {
    if ((this.mHost == null) && (paramInt != -1)) {
      throw new IllegalStateException("No activity");
    }
    if ((!paramBoolean) && (paramInt == this.mCurState)) {}
    do
    {
      return;
      this.mCurState = paramInt;
      if (!USE_STATE_MANAGER) {
        break;
      }
      this.mFragmentStore.Gq();
      startPendingDeferredFragments();
    } while ((!this.mNeedMenuInvalidate) || (this.mHost == null) || (this.mCurState != 7));
    this.mHost.Gi();
    this.mNeedMenuInvalidate = false;
    return;
    Iterator localIterator = this.mFragmentStore.getFragments().iterator();
    while (localIterator.hasNext()) {
      moveFragmentToExpectedState((Fragment)localIterator.next());
    }
    localIterator = this.mFragmentStore.GA().iterator();
    label145:
    label220:
    label223:
    for (;;)
    {
      o localo;
      if (localIterator.hasNext())
      {
        localo = (o)localIterator.next();
        Fragment localFragment = localo.bDv;
        if (!localFragment.mIsNewlyAdded) {
          moveFragmentToExpectedState(localFragment);
        }
        if ((!localFragment.mRemoving) || (localFragment.isInBackStack())) {
          break label220;
        }
      }
      for (paramInt = 1;; paramInt = 0)
      {
        if (paramInt == 0) {
          break label223;
        }
        this.mFragmentStore.b(localo);
        break label145;
        break;
      }
    }
  }
  
  void moveToState(Fragment paramFragment)
  {
    moveToState(paramFragment, this.mCurState);
  }
  
  void moveToState(Fragment paramFragment, int paramInt)
  {
    o localo = this.mFragmentStore.aH(paramFragment.mWho);
    if (localo == null)
    {
      localo = new o(this.mLifecycleCallbacksDispatcher, this.mFragmentStore, paramFragment);
      localo.bDx = 1;
    }
    for (;;)
    {
      int i = paramInt;
      if (paramFragment.mFromLayout)
      {
        i = paramInt;
        if (paramFragment.mInLayout)
        {
          i = paramInt;
          if (paramFragment.mState == 2) {
            i = Math.max(paramInt, 2);
          }
        }
      }
      paramInt = Math.min(i, localo.Gp());
      if (paramFragment.mState <= paramInt)
      {
        if ((paramFragment.mState < paramInt) && (!this.mExitAnimationCancellationSignals.isEmpty())) {
          cancelExitAnimation(paramFragment);
        }
        switch (paramFragment.mState)
        {
        case 3: 
        default: 
          if (paramFragment.mState != paramInt)
          {
            if (isLoggingEnabled(3)) {
              new StringBuilder("moveToState: Fragment state for ").append(paramFragment).append(" not updated inline; expected state ").append(paramInt).append(" found ").append(paramFragment.mState);
            }
            paramFragment.mState = paramInt;
          }
          break;
        }
      }
      ViewGroup localViewGroup1;
      Object localObject;
      s.a locala;
      View localView2;
      ViewGroup localViewGroup2;
      androidx.core.c.b localb;
      label687:
      do
      {
        return;
        if (paramInt >= 0) {
          localo.vX();
        }
        if (paramInt > 0) {
          localo.create();
        }
        if (paramInt >= 0) {
          localo.Gr();
        }
        if (paramInt > 1) {
          localo.Gs();
        }
        if (paramInt > 2) {
          localo.Gt();
        }
        if (paramInt > 4) {
          localo.start();
        }
        if (paramInt <= 5) {
          break;
        }
        localo.resume();
        break;
        if (paramFragment.mState > paramInt) {}
        switch (paramFragment.mState)
        {
        case 3: 
        case 6: 
        default: 
          break;
        case 7: 
          if (paramInt < 7) {
            localo.pause();
          }
        case 5: 
          if (paramInt < 5) {
            localo.stop();
          }
        case 4: 
          if (paramInt < 4)
          {
            if (isLoggingEnabled(3)) {
              new StringBuilder("movefrom ACTIVITY_CREATED: ").append(paramFragment);
            }
            if ((paramFragment.mView != null) && (this.mHost.Gg()) && (paramFragment.mSavedViewState == null)) {
              localo.Gv();
            }
          }
        case 2: 
          if (paramInt >= 2) {
            break label765;
          }
          localViewGroup1 = null;
          if ((paramFragment.mView == null) || (paramFragment.mContainer == null)) {
            break label747;
          }
          paramFragment.mContainer.endViewTransition(paramFragment.mView);
          paramFragment.mView.clearAnimation();
          if (paramFragment.isRemovingParent()) {
            break label747;
          }
          localObject = localViewGroup1;
          if (this.mCurState >= 0)
          {
            localObject = localViewGroup1;
            if (!this.mDestroyed)
            {
              localObject = localViewGroup1;
              if (paramFragment.mView.getVisibility() == 0)
              {
                localObject = localViewGroup1;
                if (paramFragment.mPostponedAlpha >= 0.0F) {
                  localObject = c.a(this.mHost.mContext, paramFragment, false, paramFragment.getPopDirection());
                }
              }
            }
          }
          paramFragment.mPostponedAlpha = 0.0F;
          localViewGroup1 = paramFragment.mContainer;
          View localView1 = paramFragment.mView;
          if (localObject != null)
          {
            locala = this.mFragmentTransitionCallback;
            localView2 = paramFragment.mView;
            localViewGroup2 = paramFragment.mContainer;
            localViewGroup2.startViewTransition(localView2);
            localb = new androidx.core.c.b();
            localb.a(new c.1(paramFragment));
            locala.a(paramFragment, localb);
            if (((c.a)localObject).bCz == null) {
              break label800;
            }
            localObject = new c.b(((c.a)localObject).bCz, localViewGroup2, localView2);
            paramFragment.setAnimatingAway(paramFragment.mView);
            ((Animation)localObject).setAnimationListener(new c.2(localViewGroup2, paramFragment, locala, localb));
            paramFragment.mView.startAnimation((Animation)localObject);
          }
          localViewGroup1.removeView(localView1);
          if (isLoggingEnabled(2)) {
            new StringBuilder("Removing view ").append(localView1).append(" for fragment ").append(paramFragment).append(" from container ").append(localViewGroup1);
          }
          break;
        }
      } while (localViewGroup1 != paramFragment.mContainer);
      label747:
      if (this.mExitAnimationCancellationSignals.get(paramFragment) == null) {
        localo.Gw();
      }
      label765:
      if (paramInt <= 0) {
        if (this.mExitAnimationCancellationSignals.get(paramFragment) == null) {}
      }
      for (i = 1;; i = paramInt)
      {
        paramInt = i;
        if (i >= 0) {
          break;
        }
        localo.detach();
        paramInt = i;
        break;
        label800:
        Animator localAnimator = ((c.a)localObject).bCA;
        paramFragment.setAnimator(((c.a)localObject).bCA);
        localAnimator.addListener(new c.3(localViewGroup2, localView2, paramFragment, locala, localb));
        localAnimator.setTarget(paramFragment.mView);
        localAnimator.start();
        break label687;
        localo.destroy();
      }
    }
  }
  
  void noteStateNotSaved()
  {
    if (this.mHost == null) {}
    for (;;)
    {
      return;
      this.mStateSaved = false;
      this.mStopped = false;
      this.mNonConfig.bDs = false;
      Iterator localIterator = this.mFragmentStore.getFragments().iterator();
      while (localIterator.hasNext())
      {
        Fragment localFragment = (Fragment)localIterator.next();
        if (localFragment != null) {
          localFragment.noteStateNotSaved();
        }
      }
    }
  }
  
  void onContainerAvailable(FragmentContainerView paramFragmentContainerView)
  {
    Iterator localIterator = this.mFragmentStore.GA().iterator();
    while (localIterator.hasNext())
    {
      o localo = (o)localIterator.next();
      Fragment localFragment = localo.bDv;
      if ((localFragment.mContainerId == paramFragmentContainerView.getId()) && (localFragment.mView != null) && (localFragment.mView.getParent() == null))
      {
        localFragment.mContainer = paramFragmentContainerView;
        localo.Gx();
      }
    }
  }
  
  @Deprecated
  public r openTransaction()
  {
    return beginTransaction();
  }
  
  void performPendingDeferredStart(o paramo)
  {
    Fragment localFragment = paramo.bDv;
    if (localFragment.mDeferStart)
    {
      if (this.mExecutingActions) {
        this.mHavePendingDeferredStart = true;
      }
    }
    else {
      return;
    }
    localFragment.mDeferStart = false;
    if (USE_STATE_MANAGER)
    {
      paramo.Gq();
      return;
    }
    moveToState(localFragment);
  }
  
  public void popBackStack()
  {
    enqueueAction(new g(null, -1, 0), false);
  }
  
  public void popBackStack(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {
      throw new IllegalArgumentException("Bad id: ".concat(String.valueOf(paramInt1)));
    }
    enqueueAction(new g(null, paramInt1, paramInt2), false);
  }
  
  public void popBackStack(String paramString, int paramInt)
  {
    enqueueAction(new g(paramString, -1, paramInt), false);
  }
  
  public boolean popBackStackImmediate()
  {
    return popBackStackImmediate(null, -1, 0);
  }
  
  public boolean popBackStackImmediate(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {
      throw new IllegalArgumentException("Bad id: ".concat(String.valueOf(paramInt1)));
    }
    return popBackStackImmediate(null, paramInt1, paramInt2);
  }
  
  public boolean popBackStackImmediate(String paramString, int paramInt)
  {
    return popBackStackImmediate(paramString, -1, paramInt);
  }
  
  boolean popBackStackState(ArrayList<a> paramArrayList, ArrayList<Boolean> paramArrayList1, String paramString, int paramInt1, int paramInt2)
  {
    if (this.mBackStack == null) {
      return false;
    }
    if ((paramString == null) && (paramInt1 < 0) && ((paramInt2 & 0x1) == 0))
    {
      paramInt1 = this.mBackStack.size() - 1;
      if (paramInt1 < 0) {
        return false;
      }
      paramArrayList.add(this.mBackStack.remove(paramInt1));
      paramArrayList1.add(Boolean.TRUE);
    }
    for (;;)
    {
      return true;
      int i = -1;
      if ((paramString != null) || (paramInt1 >= 0))
      {
        int j = this.mBackStack.size() - 1;
        a locala;
        while (j >= 0)
        {
          locala = (a)this.mBackStack.get(j);
          if (((paramString != null) && (paramString.equals(locala.mName))) || ((paramInt1 >= 0) && (paramInt1 == locala.mIndex))) {
            break;
          }
          j -= 1;
        }
        if (j < 0) {
          return false;
        }
        i = j;
        if ((paramInt2 & 0x1) != 0)
        {
          paramInt2 = j - 1;
          for (;;)
          {
            i = paramInt2;
            if (paramInt2 < 0) {
              break;
            }
            locala = (a)this.mBackStack.get(paramInt2);
            if ((paramString == null) || (!paramString.equals(locala.mName)))
            {
              i = paramInt2;
              if (paramInt1 < 0) {
                break;
              }
              i = paramInt2;
              if (paramInt1 != locala.mIndex) {
                break;
              }
            }
            paramInt2 -= 1;
          }
        }
      }
      if (i == this.mBackStack.size() - 1) {
        return false;
      }
      paramInt1 = this.mBackStack.size() - 1;
      while (paramInt1 > i)
      {
        paramArrayList.add(this.mBackStack.remove(paramInt1));
        paramArrayList1.add(Boolean.TRUE);
        paramInt1 -= 1;
      }
    }
  }
  
  public void putFragment(Bundle paramBundle, String paramString, Fragment paramFragment)
  {
    if (paramFragment.mFragmentManager != this) {
      throwException(new IllegalStateException("Fragment " + paramFragment + " is not currently in the FragmentManager"));
    }
    paramBundle.putString(paramString, paramFragment.mWho);
  }
  
  public void registerFragmentLifecycleCallbacks(c paramc, boolean paramBoolean)
  {
    this.mLifecycleCallbacksDispatcher.bCM.add(new i.a(paramc, paramBoolean));
  }
  
  void removeCancellationSignal(Fragment paramFragment, androidx.core.c.b paramb)
  {
    HashSet localHashSet = (HashSet)this.mExitAnimationCancellationSignals.get(paramFragment);
    if ((localHashSet != null) && (localHashSet.remove(paramb)) && (localHashSet.isEmpty()))
    {
      this.mExitAnimationCancellationSignals.remove(paramFragment);
      if (paramFragment.mState < 5)
      {
        destroyFragmentView(paramFragment);
        moveToState(paramFragment);
      }
    }
  }
  
  void removeFragment(Fragment paramFragment)
  {
    if (isLoggingEnabled(2)) {
      new StringBuilder("remove: ").append(paramFragment).append(" nesting=").append(paramFragment.mBackStackNesting);
    }
    if (!paramFragment.isInBackStack()) {}
    for (int i = 1;; i = 0)
    {
      if ((!paramFragment.mDetached) || (i != 0))
      {
        this.mFragmentStore.removeFragment(paramFragment);
        if (isMenuAvailable(paramFragment)) {
          this.mNeedMenuInvalidate = true;
        }
        paramFragment.mRemoving = true;
        setVisibleRemovingFragment(paramFragment);
      }
      return;
    }
  }
  
  public void removeFragmentOnAttachListener(l paraml)
  {
    this.mOnAttachListeners.remove(paraml);
  }
  
  public void removeOnBackStackChangedListener(FragmentManager.e parame)
  {
    if (this.mBackStackChangeListeners != null) {
      this.mBackStackChangeListeners.remove(parame);
    }
  }
  
  void removeRetainedFragment(Fragment paramFragment)
  {
    this.mNonConfig.removeRetainedFragment(paramFragment);
  }
  
  void restoreAllState(Parcelable paramParcelable, j paramj)
  {
    if ((this.mHost instanceof ak)) {
      throwException(new IllegalStateException("You must use restoreSaveState when your FragmentHostCallback implements ViewModelStoreOwner"));
    }
    this.mNonConfig.a(paramj);
    restoreSaveState(paramParcelable);
  }
  
  void restoreSaveState(Parcelable paramParcelable)
  {
    int j = 0;
    if (paramParcelable == null) {}
    FragmentManagerState localFragmentManagerState;
    do
    {
      return;
      localFragmentManagerState = (FragmentManagerState)paramParcelable;
    } while (localFragmentManagerState.bDd == null);
    this.mFragmentStore.bDB.clear();
    Object localObject1 = localFragmentManagerState.bDd.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      paramParcelable = (FragmentState)((Iterator)localObject1).next();
      if (paramParcelable != null)
      {
        localObject2 = this.mNonConfig;
        String str = paramParcelable.mWho;
        localObject2 = (Fragment)((k)localObject2).bDm.get(str);
        if (localObject2 != null) {
          if (isLoggingEnabled(2)) {
            new StringBuilder("restoreSaveState: re-attaching retained ").append(localObject2);
          }
        }
        for (paramParcelable = new o(this.mLifecycleCallbacksDispatcher, this.mFragmentStore, (Fragment)localObject2, paramParcelable);; paramParcelable = new o(this.mLifecycleCallbacksDispatcher, this.mFragmentStore, this.mHost.mContext.getClassLoader(), getFragmentFactory(), paramParcelable))
        {
          localObject2 = paramParcelable.bDv;
          ((Fragment)localObject2).mFragmentManager = this;
          if (isLoggingEnabled(2)) {
            new StringBuilder("restoreSaveState: active (").append(((Fragment)localObject2).mWho).append("): ").append(localObject2);
          }
          paramParcelable.a(this.mHost.mContext.getClassLoader());
          this.mFragmentStore.a(paramParcelable);
          paramParcelable.bDx = this.mCurState;
          break;
        }
      }
    }
    paramParcelable = new ArrayList(this.mNonConfig.bDm.values()).iterator();
    while (paramParcelable.hasNext())
    {
      localObject1 = (Fragment)paramParcelable.next();
      if (!this.mFragmentStore.aG(((Fragment)localObject1).mWho))
      {
        if (isLoggingEnabled(2)) {
          new StringBuilder("Discarding retained Fragment ").append(localObject1).append(" that was not found in the set of active Fragments ").append(localFragmentManagerState.bDd);
        }
        this.mNonConfig.removeRetainedFragment((Fragment)localObject1);
        ((Fragment)localObject1).mFragmentManager = this;
        localObject2 = new o(this.mLifecycleCallbacksDispatcher, this.mFragmentStore, (Fragment)localObject1);
        ((o)localObject2).bDx = 1;
        ((o)localObject2).Gq();
        ((Fragment)localObject1).mRemoving = true;
        ((o)localObject2).Gq();
      }
    }
    this.mFragmentStore.X(localFragmentManagerState.bDe);
    int i;
    if (localFragmentManagerState.bDf != null)
    {
      this.mBackStack = new ArrayList(localFragmentManagerState.bDf.length);
      i = 0;
      while (i < localFragmentManagerState.bDf.length)
      {
        paramParcelable = localFragmentManagerState.bDf[i].a(this);
        if (isLoggingEnabled(2))
        {
          new StringBuilder("restoreAllState: back stack #").append(i).append(" (index ").append(paramParcelable.mIndex).append("): ").append(paramParcelable);
          localObject1 = new PrintWriter(new w("FragmentManager"));
          paramParcelable.a("  ", (PrintWriter)localObject1, false);
          ((PrintWriter)localObject1).close();
        }
        this.mBackStack.add(paramParcelable);
        i += 1;
      }
    }
    this.mBackStack = null;
    this.mBackStackIndex.set(localFragmentManagerState.bDg);
    if (localFragmentManagerState.bDh != null)
    {
      this.mPrimaryNav = findActiveFragment(localFragmentManagerState.bDh);
      dispatchParentPrimaryNavigationFragmentChanged(this.mPrimaryNav);
    }
    paramParcelable = localFragmentManagerState.bDi;
    if (paramParcelable != null)
    {
      i = j;
      while (i < paramParcelable.size())
      {
        this.mResults.put(paramParcelable.get(i), localFragmentManagerState.bDj.get(i));
        i += 1;
      }
    }
    this.mLaunchedFragments = new ArrayDeque(localFragmentManagerState.bDk);
  }
  
  @Deprecated
  j retainNonConfig()
  {
    if ((this.mHost instanceof ak)) {
      throwException(new IllegalStateException("You cannot use retainNonConfig when your FragmentHostCallback implements ViewModelStoreOwner."));
    }
    return this.mNonConfig.Go();
  }
  
  Parcelable saveAllState()
  {
    forcePostponedTransactions();
    endAnimatingAwayFragments();
    execPendingActions(true);
    this.mStateSaved = true;
    this.mNonConfig.bDs = true;
    Object localObject1 = this.mFragmentStore;
    ArrayList localArrayList = new ArrayList(((q)localObject1).bDB.size());
    localObject1 = ((q)localObject1).bDB.values().iterator();
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (o)((Iterator)localObject1).next();
      if (localObject2 != null)
      {
        localObject3 = ((o)localObject2).bDv;
        FragmentState localFragmentState = new FragmentState(((o)localObject2).bDv);
        if ((((o)localObject2).bDv.mState >= 0) && (localFragmentState.mSavedFragmentState == null))
        {
          localFragmentState.mSavedFragmentState = ((o)localObject2).Gu();
          if (((o)localObject2).bDv.mTargetWho != null)
          {
            if (localFragmentState.mSavedFragmentState == null) {
              localFragmentState.mSavedFragmentState = new Bundle();
            }
            localFragmentState.mSavedFragmentState.putString("android:target_state", ((o)localObject2).bDv.mTargetWho);
            if (((o)localObject2).bDv.mTargetRequestCode != 0) {
              localFragmentState.mSavedFragmentState.putInt("android:target_req_state", ((o)localObject2).bDv.mTargetRequestCode);
            }
          }
        }
        for (;;)
        {
          localArrayList.add(localFragmentState);
          if (!isLoggingEnabled(2)) {
            break;
          }
          new StringBuilder("Saved state of ").append(localObject3).append(": ").append(localFragmentState.mSavedFragmentState);
          break;
          localFragmentState.mSavedFragmentState = ((o)localObject2).bDv.mSavedFragmentState;
        }
      }
    }
    if (localArrayList.isEmpty())
    {
      isLoggingEnabled(2);
      return null;
    }
    Object localObject2 = this.mFragmentStore.Gz();
    if (this.mBackStack != null)
    {
      int j = this.mBackStack.size();
      if (j > 0)
      {
        localObject1 = new BackStackState[j];
        int i = 0;
        while (i < j)
        {
          localObject1[i] = new BackStackState((a)this.mBackStack.get(i));
          if (isLoggingEnabled(2)) {
            new StringBuilder("saveAllState: adding back stack #").append(i).append(": ").append(this.mBackStack.get(i));
          }
          i += 1;
        }
      }
    }
    for (;;)
    {
      localObject3 = new FragmentManagerState();
      ((FragmentManagerState)localObject3).bDd = localArrayList;
      ((FragmentManagerState)localObject3).bDe = ((ArrayList)localObject2);
      ((FragmentManagerState)localObject3).bDf = ((BackStackState[])localObject1);
      ((FragmentManagerState)localObject3).bDg = this.mBackStackIndex.get();
      if (this.mPrimaryNav != null) {
        ((FragmentManagerState)localObject3).bDh = this.mPrimaryNav.mWho;
      }
      ((FragmentManagerState)localObject3).bDi.addAll(this.mResults.keySet());
      ((FragmentManagerState)localObject3).bDj.addAll(this.mResults.values());
      ((FragmentManagerState)localObject3).bDk = new ArrayList(this.mLaunchedFragments);
      return localObject3;
      localObject1 = null;
    }
  }
  
  public Fragment.SavedState saveFragmentInstanceState(Fragment paramFragment)
  {
    Object localObject1 = null;
    Object localObject2 = this.mFragmentStore.aH(paramFragment.mWho);
    if ((localObject2 == null) || (!((o)localObject2).bDv.equals(paramFragment))) {
      throwException(new IllegalStateException("Fragment " + paramFragment + " is not currently in the FragmentManager"));
    }
    paramFragment = localObject1;
    if (((o)localObject2).bDv.mState >= 0)
    {
      localObject2 = ((o)localObject2).Gu();
      paramFragment = localObject1;
      if (localObject2 != null) {
        paramFragment = new Fragment.SavedState((Bundle)localObject2);
      }
    }
    return paramFragment;
  }
  
  void scheduleCommit()
  {
    int j = 1;
    for (;;)
    {
      int i;
      synchronized (this.mPendingActions)
      {
        if ((this.mPostponedTransactions != null) && (!this.mPostponedTransactions.isEmpty()))
        {
          i = 1;
          if (this.mPendingActions.size() == 1)
          {
            break label95;
            this.mHost.mHandler.removeCallbacks(this.mExecCommit);
            this.mHost.mHandler.post(this.mExecCommit);
            updateOnBackPressedCallbackEnabled();
          }
        }
        else
        {
          i = 0;
          continue;
        }
        j = 0;
      }
      label95:
      if (i == 0) {
        if (j == 0) {}
      }
    }
  }
  
  void setExitAnimationOrder(Fragment paramFragment, boolean paramBoolean)
  {
    paramFragment = getFragmentContainer(paramFragment);
    if ((paramFragment != null) && ((paramFragment instanceof FragmentContainerView)))
    {
      paramFragment = (FragmentContainerView)paramFragment;
      if (paramBoolean) {
        break label34;
      }
    }
    label34:
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramFragment.setDrawDisappearingViewsLast(paramBoolean);
      return;
    }
  }
  
  public void setFragmentFactory(f paramf)
  {
    this.mFragmentFactory = paramf;
  }
  
  public final void setFragmentResult(String paramString, Bundle paramBundle)
  {
    d locald = (d)this.mResultListeners.get(paramString);
    if (locald != null)
    {
      j.b localb = j.b.bHj;
      if (locald.ez.getCurrentState().d(localb)) {}
    }
    else
    {
      this.mResults.put(paramString, paramBundle);
    }
  }
  
  public final void setFragmentResultListener(final String paramString, final androidx.lifecycle.q paramq, final n paramn)
  {
    paramq = paramq.getLifecycle();
    if (paramq.getCurrentState() == j.b.bHg) {}
    do
    {
      return;
      androidx.lifecycle.o local6 = new androidx.lifecycle.o()
      {
        public void onStateChanged(androidx.lifecycle.q paramAnonymousq, j.a paramAnonymousa)
        {
          AppMethodBeat.i(193865);
          if ((paramAnonymousa == j.a.ON_START) && ((Bundle)FragmentManager.this.mResults.get(paramString) != null)) {
            FragmentManager.this.clearFragmentResult(paramString);
          }
          if (paramAnonymousa == j.a.ON_DESTROY)
          {
            paramq.removeObserver(this);
            FragmentManager.this.mResultListeners.remove(paramString);
          }
          AppMethodBeat.o(193865);
        }
      };
      paramq.addObserver(local6);
      paramString = (d)this.mResultListeners.put(paramString, new d(paramq, paramn, local6));
    } while (paramString == null);
    paramString.Gl();
  }
  
  void setMaxLifecycle(Fragment paramFragment, j.b paramb)
  {
    if ((!paramFragment.equals(findActiveFragment(paramFragment.mWho))) || ((paramFragment.mHost != null) && (paramFragment.mFragmentManager != this))) {
      throw new IllegalArgumentException("Fragment " + paramFragment + " is not an active fragment of FragmentManager " + this);
    }
    paramFragment.mMaxState = paramb;
  }
  
  void setPrimaryNavigationFragment(Fragment paramFragment)
  {
    if ((paramFragment != null) && ((!paramFragment.equals(findActiveFragment(paramFragment.mWho))) || ((paramFragment.mHost != null) && (paramFragment.mFragmentManager != this)))) {
      throw new IllegalArgumentException("Fragment " + paramFragment + " is not an active fragment of FragmentManager " + this);
    }
    Fragment localFragment = this.mPrimaryNav;
    this.mPrimaryNav = paramFragment;
    dispatchParentPrimaryNavigationFragmentChanged(localFragment);
    dispatchParentPrimaryNavigationFragmentChanged(this.mPrimaryNav);
  }
  
  void setSpecialEffectsControllerFactory(y paramy)
  {
    this.mSpecialEffectsControllerFactory = paramy;
  }
  
  void showFragment(Fragment paramFragment)
  {
    boolean bool = false;
    if (isLoggingEnabled(2)) {
      new StringBuilder("show: ").append(paramFragment);
    }
    if (paramFragment.mHidden)
    {
      paramFragment.mHidden = false;
      if (!paramFragment.mHiddenChanged) {
        bool = true;
      }
      paramFragment.mHiddenChanged = bool;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("FragmentManager{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" in ");
    if (this.mParent != null)
    {
      localStringBuilder.append(this.mParent.getClass().getSimpleName());
      localStringBuilder.append("{");
      localStringBuilder.append(Integer.toHexString(System.identityHashCode(this.mParent)));
      localStringBuilder.append("}");
    }
    for (;;)
    {
      localStringBuilder.append("}}");
      return localStringBuilder.toString();
      if (this.mHost != null)
      {
        localStringBuilder.append(this.mHost.getClass().getSimpleName());
        localStringBuilder.append("{");
        localStringBuilder.append(Integer.toHexString(System.identityHashCode(this.mHost)));
        localStringBuilder.append("}");
      }
      else
      {
        localStringBuilder.append("null");
      }
    }
  }
  
  public void unregisterFragmentLifecycleCallbacks(c paramc)
  {
    i locali = this.mLifecycleCallbacksDispatcher;
    synchronized (locali.bCM)
    {
      int j = locali.bCM.size();
      int i = 0;
      if (i < j)
      {
        if (((i.a)locali.bCM.get(i)).bCN == paramc) {
          locali.bCM.remove(i);
        }
      }
      else {
        return;
      }
      i += 1;
    }
  }
  
  static class LaunchedFragmentInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<LaunchedFragmentInfo> CREATOR;
    int mRequestCode;
    String mWho;
    
    static
    {
      AppMethodBeat.i(193510);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(193510);
    }
    
    LaunchedFragmentInfo(Parcel paramParcel)
    {
      AppMethodBeat.i(193502);
      this.mWho = paramParcel.readString();
      this.mRequestCode = paramParcel.readInt();
      AppMethodBeat.o(193502);
    }
    
    LaunchedFragmentInfo(String paramString, int paramInt)
    {
      this.mWho = paramString;
      this.mRequestCode = paramInt;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(193524);
      paramParcel.writeString(this.mWho);
      paramParcel.writeInt(this.mRequestCode);
      AppMethodBeat.o(193524);
    }
  }
  
  public static abstract interface a
  {
    public abstract String getName();
  }
  
  static final class b
    extends androidx.activity.result.a.a<IntentSenderRequest, ActivityResult>
  {}
  
  public static abstract class c {}
  
  static final class d
    implements n
  {
    private final n bCV;
    private final androidx.lifecycle.o bCW;
    final androidx.lifecycle.j ez;
    
    d(androidx.lifecycle.j paramj, n paramn, androidx.lifecycle.o paramo)
    {
      this.ez = paramj;
      this.bCV = paramn;
      this.bCW = paramo;
    }
    
    public final void Gl()
    {
      AppMethodBeat.i(193834);
      this.ez.removeObserver(this.bCW);
      AppMethodBeat.o(193834);
    }
  }
  
  static abstract interface f
  {
    public abstract boolean a(ArrayList<a> paramArrayList, ArrayList<Boolean> paramArrayList1);
  }
  
  final class g
    implements FragmentManager.f
  {
    final int cN;
    final int mId;
    final String mName;
    
    g(String paramString, int paramInt1, int paramInt2)
    {
      this.mName = paramString;
      this.mId = paramInt1;
      this.cN = paramInt2;
    }
    
    public final boolean a(ArrayList<a> paramArrayList, ArrayList<Boolean> paramArrayList1)
    {
      AppMethodBeat.i(193835);
      if ((FragmentManager.this.mPrimaryNav != null) && (this.mId < 0) && (this.mName == null) && (FragmentManager.this.mPrimaryNav.getChildFragmentManager().popBackStackImmediate()))
      {
        AppMethodBeat.o(193835);
        return false;
      }
      boolean bool = FragmentManager.this.popBackStackState(paramArrayList, paramArrayList1, this.mName, this.mId, this.cN);
      AppMethodBeat.o(193835);
      return bool;
    }
  }
  
  static final class h
    implements Fragment.d
  {
    final boolean bCX;
    final a bCY;
    int bCZ;
    
    h(a parama, boolean paramBoolean)
    {
      this.bCX = paramBoolean;
      this.bCY = parama;
    }
    
    public final void Ge()
    {
      AppMethodBeat.i(193692);
      this.bCZ -= 1;
      if (this.bCZ != 0)
      {
        AppMethodBeat.o(193692);
        return;
      }
      this.bCY.bBd.scheduleCommit();
      AppMethodBeat.o(193692);
    }
    
    public final void Gf()
    {
      this.bCZ += 1;
    }
    
    final void Gm()
    {
      boolean bool1 = false;
      AppMethodBeat.i(193706);
      if (this.bCZ > 0) {}
      for (int i = 1;; i = 0)
      {
        localObject1 = this.bCY.bBd.getFragments().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Fragment)((Iterator)localObject1).next();
          ((Fragment)localObject2).setOnStartEnterTransitionListener(null);
          if ((i != 0) && (((Fragment)localObject2).isPostponed())) {
            ((Fragment)localObject2).startPostponedEnterTransition();
          }
        }
      }
      Object localObject1 = this.bCY.bBd;
      Object localObject2 = this.bCY;
      boolean bool2 = this.bCX;
      if (i == 0) {
        bool1 = true;
      }
      ((FragmentManager)localObject1).completeExecute((a)localObject2, bool2, bool1, true);
      AppMethodBeat.o(193706);
    }
    
    final void Gn()
    {
      AppMethodBeat.i(193713);
      this.bCY.bBd.completeExecute(this.bCY, this.bCX, false, false);
      AppMethodBeat.o(193713);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.fragment.app.FragmentManager
 * JD-Core Version:    0.7.0.1
 */