package android.support.v4.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModelStore;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.e.e;
import android.support.v4.view.t;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater.Factory2;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

final class FragmentManagerImpl
  extends g
  implements LayoutInflater.Factory2
{
  static final Interpolator ACCELERATE_CUBIC = new AccelerateInterpolator(1.5F);
  static final Interpolator ACCELERATE_QUINT;
  static final int ANIM_DUR = 220;
  public static final int ANIM_STYLE_CLOSE_ENTER = 3;
  public static final int ANIM_STYLE_CLOSE_EXIT = 4;
  public static final int ANIM_STYLE_FADE_ENTER = 5;
  public static final int ANIM_STYLE_FADE_EXIT = 6;
  public static final int ANIM_STYLE_OPEN_ENTER = 1;
  public static final int ANIM_STYLE_OPEN_EXIT = 2;
  static boolean DEBUG = false;
  static final Interpolator DECELERATE_CUBIC;
  static final Interpolator DECELERATE_QUINT;
  static final String TAG = "FragmentManager";
  static final String TARGET_REQUEST_CODE_STATE_TAG = "android:target_req_state";
  static final String TARGET_STATE_TAG = "android:target_state";
  static final String USER_VISIBLE_HINT_TAG = "android:user_visible_hint";
  static final String VIEW_STATE_TAG = "android:view_state";
  static Field sAnimationListenerField = null;
  SparseArray<Fragment> mActive;
  final ArrayList<Fragment> mAdded = new ArrayList();
  ArrayList<Integer> mAvailBackStackIndices;
  ArrayList<b> mBackStack;
  ArrayList<g.c> mBackStackChangeListeners;
  ArrayList<b> mBackStackIndices;
  d mContainer;
  ArrayList<Fragment> mCreatedMenus;
  int mCurState = 0;
  boolean mDestroyed;
  Runnable mExecCommit = new Runnable()
  {
    public final void run()
    {
      FragmentManagerImpl.this.execPendingActions();
    }
  };
  boolean mExecutingActions;
  boolean mHavePendingDeferredStart;
  f mHost;
  private final CopyOnWriteArrayList<f> mLifecycleCallbacks = new CopyOnWriteArrayList();
  boolean mNeedMenuInvalidate;
  int mNextFragmentIndex = 0;
  String mNoTransactionsBecause;
  Fragment mParent;
  ArrayList<h> mPendingActions;
  ArrayList<j> mPostponedTransactions;
  Fragment mPrimaryNav;
  h mSavedNonConfig;
  SparseArray<Parcelable> mStateArray = null;
  Bundle mStateBundle = null;
  boolean mStateSaved;
  boolean mStopped;
  ArrayList<Fragment> mTmpAddedFragments;
  ArrayList<Boolean> mTmpIsPop;
  ArrayList<b> mTmpRecords;
  
  static
  {
    DECELERATE_QUINT = new DecelerateInterpolator(2.5F);
    DECELERATE_CUBIC = new DecelerateInterpolator(1.5F);
    ACCELERATE_QUINT = new AccelerateInterpolator(2.5F);
  }
  
  private void addAddedFragments(android.support.v4.e.b<Fragment> paramb)
  {
    if (this.mCurState <= 0) {}
    for (;;)
    {
      return;
      int j = Math.min(this.mCurState, 3);
      int k = this.mAdded.size();
      int i = 0;
      while (i < k)
      {
        Fragment localFragment = (Fragment)this.mAdded.get(i);
        if (localFragment.mState < j)
        {
          moveToState(localFragment, j, localFragment.getNextAnim(), localFragment.getNextTransition(), false);
          if ((localFragment.mView != null) && (!localFragment.mHidden) && (localFragment.mIsNewlyAdded)) {
            paramb.add(localFragment);
          }
        }
        i += 1;
      }
    }
  }
  
  private void animateRemoveFragment(final Fragment paramFragment, c paramc, int paramInt)
  {
    final View localView = paramFragment.mView;
    final ViewGroup localViewGroup = paramFragment.mContainer;
    localViewGroup.startViewTransition(localView);
    paramFragment.setStateAfterAnimating(paramInt);
    if (paramc.CN != null)
    {
      localObject = new e(paramc.CN, localViewGroup, localView);
      paramFragment.setAnimatingAway(paramFragment.mView);
      ((Animation)localObject).setAnimationListener(new b(getAnimationListener((Animation)localObject))
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          super.onAnimationEnd(paramAnonymousAnimation);
          localViewGroup.post(new Runnable()
          {
            public final void run()
            {
              if (FragmentManagerImpl.2.this.val$fragment.getAnimatingAway() != null)
              {
                FragmentManagerImpl.2.this.val$fragment.setAnimatingAway(null);
                FragmentManagerImpl.this.moveToState(FragmentManagerImpl.2.this.val$fragment, FragmentManagerImpl.2.this.val$fragment.getStateAfterAnimating(), 0, 0, false);
              }
            }
          });
        }
      });
      setHWLayerAnimListenerIfAlpha(localView, paramc);
      paramFragment.mView.startAnimation((Animation)localObject);
      return;
    }
    Object localObject = paramc.CO;
    paramFragment.setAnimator(paramc.CO);
    ((Animator)localObject).addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        localViewGroup.endViewTransition(localView);
        paramAnonymousAnimator = paramFragment.getAnimator();
        paramFragment.setAnimator(null);
        if ((paramAnonymousAnimator != null) && (localViewGroup.indexOfChild(localView) < 0)) {
          FragmentManagerImpl.this.moveToState(paramFragment, paramFragment.getStateAfterAnimating(), 0, 0, false);
        }
      }
    });
    ((Animator)localObject).setTarget(paramFragment.mView);
    setHWLayerAnimListenerIfAlpha(paramFragment.mView, paramc);
    ((Animator)localObject).start();
  }
  
  private void burpActive()
  {
    if (this.mActive != null)
    {
      int i = this.mActive.size() - 1;
      while (i >= 0)
      {
        if (this.mActive.valueAt(i) == null) {
          this.mActive.delete(this.mActive.keyAt(i));
        }
        i -= 1;
      }
    }
  }
  
  private void checkStateLoss()
  {
    if (isStateSaved()) {
      throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
    }
    if (this.mNoTransactionsBecause != null) {
      throw new IllegalStateException("Can not perform this action inside of " + this.mNoTransactionsBecause);
    }
  }
  
  private void cleanupExec()
  {
    this.mExecutingActions = false;
    this.mTmpIsPop.clear();
    this.mTmpRecords.clear();
  }
  
  private void dispatchStateChange(int paramInt)
  {
    try
    {
      this.mExecutingActions = true;
      moveToState(paramInt, false);
      this.mExecutingActions = false;
      execPendingActions();
      return;
    }
    finally
    {
      this.mExecutingActions = false;
    }
  }
  
  private void endAnimatingAwayFragments()
  {
    int i;
    int j;
    label11:
    Fragment localFragment;
    if (this.mActive == null)
    {
      i = 0;
      j = 0;
      if (j >= i) {
        return;
      }
      localFragment = (Fragment)this.mActive.valueAt(j);
      if (localFragment != null)
      {
        if (localFragment.getAnimatingAway() == null) {
          break label111;
        }
        int k = localFragment.getStateAfterAnimating();
        View localView = localFragment.getAnimatingAway();
        Animation localAnimation = localView.getAnimation();
        if (localAnimation != null)
        {
          localAnimation.cancel();
          localView.clearAnimation();
        }
        localFragment.setAnimatingAway(null);
        moveToState(localFragment, k, 0, 0, false);
      }
    }
    for (;;)
    {
      j += 1;
      break label11;
      i = this.mActive.size();
      break;
      label111:
      if (localFragment.getAnimator() != null) {
        localFragment.getAnimator().end();
      }
    }
  }
  
  private void ensureExecReady(boolean paramBoolean)
  {
    if (this.mExecutingActions) {
      throw new IllegalStateException("FragmentManager is already executing transactions");
    }
    if (this.mHost == null) {
      throw new IllegalStateException("Fragment host has been destroyed");
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
  
  private static void executeOps(ArrayList<b> paramArrayList, ArrayList<Boolean> paramArrayList1, int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2)
    {
      b localb = (b)paramArrayList.get(paramInt1);
      boolean bool;
      if (((Boolean)paramArrayList1.get(paramInt1)).booleanValue())
      {
        localb.aq(-1);
        if (paramInt1 == paramInt2 - 1)
        {
          bool = true;
          label45:
          localb.E(bool);
        }
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        bool = false;
        break label45;
        localb.aq(1);
        localb.dB();
      }
    }
  }
  
  private void executeOpsTogether(ArrayList<b> paramArrayList, ArrayList<Boolean> paramArrayList1, int paramInt1, int paramInt2)
  {
    boolean bool = ((b)paramArrayList.get(paramInt1)).BV;
    Object localObject;
    int j;
    label55:
    b localb;
    if (this.mTmpAddedFragments == null)
    {
      this.mTmpAddedFragments = new ArrayList();
      this.mTmpAddedFragments.addAll(this.mAdded);
      localObject = getPrimaryNavigationFragment();
      j = paramInt1;
      i = 0;
      if (j >= paramInt2) {
        break label158;
      }
      localb = (b)paramArrayList.get(j);
      if (((Boolean)paramArrayList1.get(j)).booleanValue()) {
        break label136;
      }
      localObject = localb.a(this.mTmpAddedFragments, (Fragment)localObject);
      label101:
      if ((i == 0) && (!localb.BM)) {
        break label152;
      }
    }
    label136:
    label152:
    for (int i = 1;; i = 0)
    {
      j += 1;
      break label55;
      this.mTmpAddedFragments.clear();
      break;
      localObject = localb.b(this.mTmpAddedFragments, (Fragment)localObject);
      break label101;
    }
    label158:
    this.mTmpAddedFragments.clear();
    if (!bool) {
      l.a(this, paramArrayList, paramArrayList1, paramInt1, paramInt2, false);
    }
    executeOps(paramArrayList, paramArrayList1, paramInt1, paramInt2);
    if (bool)
    {
      localObject = new android.support.v4.e.b();
      addAddedFragments((android.support.v4.e.b)localObject);
      j = postponePostponableTransactions(paramArrayList, paramArrayList1, paramInt1, paramInt2, (android.support.v4.e.b)localObject);
      makeRemovedFragmentsInvisible((android.support.v4.e.b)localObject);
    }
    for (;;)
    {
      int k = paramInt1;
      if (j != paramInt1)
      {
        k = paramInt1;
        if (bool)
        {
          l.a(this, paramArrayList, paramArrayList1, paramInt1, j, true);
          moveToState(this.mCurState, true);
          k = paramInt1;
        }
      }
      while (k < paramInt2)
      {
        localObject = (b)paramArrayList.get(k);
        if ((((Boolean)paramArrayList1.get(k)).booleanValue()) && (((b)localObject).mIndex >= 0))
        {
          freeBackStackIndex(((b)localObject).mIndex);
          ((b)localObject).mIndex = -1;
        }
        ((b)localObject).dA();
        k += 1;
      }
      if (i != 0) {
        reportBackStackChanged();
      }
      return;
      j = paramInt2;
    }
  }
  
  private void executePostponedTransaction(ArrayList<b> paramArrayList, ArrayList<Boolean> paramArrayList1)
  {
    int i;
    int j;
    label12:
    j localj;
    int k;
    if (this.mPostponedTransactions == null)
    {
      i = 0;
      j = 0;
      if (j >= i) {
        return;
      }
      localj = (j)this.mPostponedTransactions.get(j);
      if ((paramArrayList == null) || (localj.CX)) {
        break label101;
      }
      k = paramArrayList.indexOf(localj.CY);
      if ((k == -1) || (!((Boolean)paramArrayList1.get(k)).booleanValue())) {
        break label101;
      }
      localj.dH();
    }
    for (;;)
    {
      j += 1;
      break label12;
      i = this.mPostponedTransactions.size();
      break;
      label101:
      if (localj.CZ == 0) {}
      int m;
      for (k = 1;; k = 0)
      {
        if (k == 0)
        {
          m = j;
          k = i;
          if (paramArrayList == null) {
            break label240;
          }
          m = j;
          k = i;
          if (!localj.CY.a(paramArrayList, 0, paramArrayList.size())) {
            break label240;
          }
        }
        this.mPostponedTransactions.remove(j);
        m = j - 1;
        k = i - 1;
        if ((paramArrayList == null) || (localj.CX)) {
          break label235;
        }
        i = paramArrayList.indexOf(localj.CY);
        if ((i == -1) || (!((Boolean)paramArrayList1.get(i)).booleanValue())) {
          break label235;
        }
        localj.dH();
        j = m;
        i = k;
        break;
      }
      label235:
      localj.dG();
      label240:
      j = m;
      i = k;
    }
  }
  
  private Fragment findFragmentUnder(Fragment paramFragment)
  {
    ViewGroup localViewGroup = paramFragment.mContainer;
    Object localObject = paramFragment.mView;
    if ((localViewGroup == null) || (localObject == null))
    {
      paramFragment = null;
      return paramFragment;
    }
    int i = this.mAdded.indexOf(paramFragment) - 1;
    for (;;)
    {
      if (i < 0) {
        break label76;
      }
      localObject = (Fragment)this.mAdded.get(i);
      if (((Fragment)localObject).mContainer == localViewGroup)
      {
        paramFragment = (Fragment)localObject;
        if (((Fragment)localObject).mView != null) {
          break;
        }
      }
      i -= 1;
    }
    label76:
    return null;
  }
  
  private void forcePostponedTransactions()
  {
    if (this.mPostponedTransactions != null) {
      while (!this.mPostponedTransactions.isEmpty()) {
        ((j)this.mPostponedTransactions.remove(0)).dG();
      }
    }
  }
  
  private boolean generateOpsForPendingActions(ArrayList<b> paramArrayList, ArrayList<Boolean> paramArrayList1)
  {
    try
    {
      if ((this.mPendingActions == null) || (this.mPendingActions.size() == 0)) {
        return false;
      }
      int j = this.mPendingActions.size();
      int i = 0;
      boolean bool = false;
      while (i < j)
      {
        bool |= ((h)this.mPendingActions.get(i)).a(paramArrayList, paramArrayList1);
        i += 1;
      }
      this.mPendingActions.clear();
      this.mHost.mHandler.removeCallbacks(this.mExecCommit);
      return bool;
    }
    finally {}
  }
  
  private static Animation.AnimationListener getAnimationListener(Animation paramAnimation)
  {
    try
    {
      if (sAnimationListenerField == null)
      {
        Field localField = Animation.class.getDeclaredField("mListener");
        sAnimationListenerField = localField;
        localField.setAccessible(true);
      }
      paramAnimation = (Animation.AnimationListener)sAnimationListenerField.get(paramAnimation);
      return paramAnimation;
    }
    catch (NoSuchFieldException paramAnimation)
    {
      return null;
    }
    catch (IllegalAccessException paramAnimation) {}
    return null;
  }
  
  static c makeFadeAnimation(Context paramContext, float paramFloat1, float paramFloat2)
  {
    paramContext = new AlphaAnimation(paramFloat1, paramFloat2);
    paramContext.setInterpolator(DECELERATE_CUBIC);
    paramContext.setDuration(220L);
    return new c(paramContext);
  }
  
  static c makeOpenCloseAnimation(Context paramContext, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramContext = new AnimationSet(false);
    Object localObject = new ScaleAnimation(paramFloat1, paramFloat2, paramFloat1, paramFloat2, 1, 0.5F, 1, 0.5F);
    ((ScaleAnimation)localObject).setInterpolator(DECELERATE_QUINT);
    ((ScaleAnimation)localObject).setDuration(220L);
    paramContext.addAnimation((Animation)localObject);
    localObject = new AlphaAnimation(paramFloat3, paramFloat4);
    ((AlphaAnimation)localObject).setInterpolator(DECELERATE_CUBIC);
    ((AlphaAnimation)localObject).setDuration(220L);
    paramContext.addAnimation((Animation)localObject);
    return new c(paramContext);
  }
  
  private void makeRemovedFragmentsInvisible(android.support.v4.e.b<Fragment> paramb)
  {
    int j = paramb.size();
    int i = 0;
    while (i < j)
    {
      Fragment localFragment = (Fragment)paramb.LN[i];
      if (!localFragment.mAdded)
      {
        View localView = localFragment.getView();
        localFragment.mPostponedAlpha = localView.getAlpha();
        localView.setAlpha(0.0F);
      }
      i += 1;
    }
  }
  
  static boolean modifiesAlpha(Animator paramAnimator)
  {
    if (paramAnimator == null) {}
    for (;;)
    {
      return false;
      int i;
      if ((paramAnimator instanceof ValueAnimator))
      {
        paramAnimator = ((ValueAnimator)paramAnimator).getValues();
        i = 0;
        while (i < paramAnimator.length)
        {
          if ("alpha".equals(paramAnimator[i].getPropertyName())) {
            return true;
          }
          i += 1;
        }
      }
      else if ((paramAnimator instanceof AnimatorSet))
      {
        paramAnimator = ((AnimatorSet)paramAnimator).getChildAnimations();
        i = 0;
        while (i < paramAnimator.size())
        {
          if (modifiesAlpha((Animator)paramAnimator.get(i))) {
            return true;
          }
          i += 1;
        }
      }
    }
  }
  
  static boolean modifiesAlpha(c paramc)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramc.CN instanceof AlphaAnimation))
    {
      bool1 = true;
      return bool1;
    }
    if ((paramc.CN instanceof AnimationSet))
    {
      paramc = ((AnimationSet)paramc.CN).getAnimations();
      int i = 0;
      for (;;)
      {
        bool1 = bool2;
        if (i >= paramc.size()) {
          break;
        }
        if ((paramc.get(i) instanceof AlphaAnimation)) {
          return true;
        }
        i += 1;
      }
    }
    return modifiesAlpha(paramc.CO);
  }
  
  private boolean popBackStackImmediate(String paramString, int paramInt1, int paramInt2)
  {
    execPendingActions();
    ensureExecReady(true);
    if ((this.mPrimaryNav != null) && (paramInt1 < 0) && (paramString == null))
    {
      g localg = this.mPrimaryNav.peekChildFragmentManager();
      if ((localg != null) && (localg.popBackStackImmediate())) {
        return true;
      }
    }
    boolean bool = popBackStackState(this.mTmpRecords, this.mTmpIsPop, paramString, paramInt1, paramInt2);
    if (bool) {
      this.mExecutingActions = true;
    }
    try
    {
      removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);
      cleanupExec();
      doPendingDeferredStart();
      return bool;
    }
    finally
    {
      cleanupExec();
    }
  }
  
  private int postponePostponableTransactions(ArrayList<b> paramArrayList, ArrayList<Boolean> paramArrayList1, int paramInt1, int paramInt2, android.support.v4.e.b<Fragment> paramb)
  {
    int j = paramInt2 - 1;
    int i = paramInt2;
    b localb;
    int k;
    label165:
    if (j >= paramInt1)
    {
      localb = (b)paramArrayList.get(j);
      boolean bool = ((Boolean)paramArrayList1.get(j)).booleanValue();
      k = 0;
      label44:
      if (k < localb.BF.size()) {
        if (b.b((b.a)localb.BF.get(k)))
        {
          k = 1;
          label79:
          if ((k == 0) || (localb.a(paramArrayList, j + 1, paramInt2))) {
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
          j localj = new j(localb, bool);
          this.mPostponedTransactions.add(localj);
          localb.a(localj);
          if (!bool) {
            break label229;
          }
          localb.dB();
          i -= 1;
          if (j != i)
          {
            paramArrayList.remove(j);
            paramArrayList.add(i, localb);
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
      localb.E(false);
      break label165;
      return i;
    }
  }
  
  private void removeRedundantOperationsAndExecute(ArrayList<b> paramArrayList, ArrayList<Boolean> paramArrayList1)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
      return;
    }
    if ((paramArrayList1 == null) || (paramArrayList.size() != paramArrayList1.size())) {
      throw new IllegalStateException("Internal error with the back stack records");
    }
    executePostponedTransaction(paramArrayList, paramArrayList1);
    int m = paramArrayList.size();
    int i = 0;
    int j = 0;
    label55:
    int k;
    if (i < m)
    {
      if (((b)paramArrayList.get(i)).BV) {
        break label222;
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
          if (((b)paramArrayList.get(k)).BV) {
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
      break label55;
      if (j == m) {
        break;
      }
      executeOpsTogether(paramArrayList, paramArrayList1, j, m);
      return;
      label222:
      k = i;
    }
  }
  
  public static int reverseTransit(int paramInt)
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
  
  private static void setHWLayerAnimListenerIfAlpha(View paramView, c paramc)
  {
    if ((paramView == null) || (paramc == null)) {}
    while (!shouldRunOnHWLayer(paramView, paramc)) {
      return;
    }
    if (paramc.CO != null)
    {
      paramc.CO.addListener(new d(paramView));
      return;
    }
    Animation.AnimationListener localAnimationListener = getAnimationListener(paramc.CN);
    paramView.setLayerType(2, null);
    paramc.CN.setAnimationListener(new a(paramView, localAnimationListener));
  }
  
  private static void setRetaining(h paramh)
  {
    if (paramh == null) {}
    for (;;)
    {
      return;
      Object localObject = paramh.Da;
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((Fragment)((Iterator)localObject).next()).mRetaining = true;
        }
      }
      paramh = paramh.Db;
      if (paramh != null)
      {
        paramh = paramh.iterator();
        while (paramh.hasNext()) {
          setRetaining((h)paramh.next());
        }
      }
    }
  }
  
  static boolean shouldRunOnHWLayer(View paramView, c paramc)
  {
    if ((paramView == null) || (paramc == null)) {}
    while ((Build.VERSION.SDK_INT < 19) || (paramView.getLayerType() != 0) || (!t.ar(paramView)) || (!modifiesAlpha(paramc))) {
      return false;
    }
    return true;
  }
  
  private void throwException(RuntimeException paramRuntimeException)
  {
    paramRuntimeException.getMessage();
    PrintWriter localPrintWriter = new PrintWriter(new android.support.v4.e.f("FragmentManager"));
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
  
  public static int transitToStyleIndex(int paramInt, boolean paramBoolean)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 4097: 
      if (paramBoolean) {
        return 1;
      }
      return 2;
    case 8194: 
      if (paramBoolean) {
        return 3;
      }
      return 4;
    }
    if (paramBoolean) {
      return 5;
    }
    return 6;
  }
  
  final void addBackStackState(b paramb)
  {
    if (this.mBackStack == null) {
      this.mBackStack = new ArrayList();
    }
    this.mBackStack.add(paramb);
  }
  
  public final void addFragment(Fragment paramFragment, boolean paramBoolean)
  {
    if (DEBUG) {
      new StringBuilder("add: ").append(paramFragment);
    }
    makeActive(paramFragment);
    if (!paramFragment.mDetached) {
      if (this.mAdded.contains(paramFragment)) {
        throw new IllegalStateException("Fragment already added: ".concat(String.valueOf(paramFragment)));
      }
    }
    synchronized (this.mAdded)
    {
      this.mAdded.add(paramFragment);
      paramFragment.mAdded = true;
      paramFragment.mRemoving = false;
      if (paramFragment.mView == null) {
        paramFragment.mHiddenChanged = false;
      }
      if ((paramFragment.mHasMenu) && (paramFragment.mMenuVisible)) {
        this.mNeedMenuInvalidate = true;
      }
      if (paramBoolean) {
        moveToState(paramFragment);
      }
      return;
    }
  }
  
  public final void addOnBackStackChangedListener(g.c paramc)
  {
    if (this.mBackStackChangeListeners == null) {
      this.mBackStackChangeListeners = new ArrayList();
    }
    this.mBackStackChangeListeners.add(paramc);
  }
  
  public final int allocBackStackIndex(b paramb)
  {
    try
    {
      if ((this.mAvailBackStackIndices == null) || (this.mAvailBackStackIndices.size() <= 0))
      {
        if (this.mBackStackIndices == null) {
          this.mBackStackIndices = new ArrayList();
        }
        i = this.mBackStackIndices.size();
        if (DEBUG) {
          new StringBuilder("Setting back stack index ").append(i).append(" to ").append(paramb);
        }
        this.mBackStackIndices.add(paramb);
        return i;
      }
      int i = ((Integer)this.mAvailBackStackIndices.remove(this.mAvailBackStackIndices.size() - 1)).intValue();
      if (DEBUG) {
        new StringBuilder("Adding back stack index ").append(i).append(" with ").append(paramb);
      }
      this.mBackStackIndices.set(i, paramb);
      return i;
    }
    finally {}
  }
  
  public final void attachController(f paramf, d paramd, Fragment paramFragment)
  {
    if (this.mHost != null) {
      throw new IllegalStateException("Already attached");
    }
    this.mHost = paramf;
    this.mContainer = paramd;
    this.mParent = paramFragment;
  }
  
  public final void attachFragment(Fragment paramFragment)
  {
    if (DEBUG) {
      new StringBuilder("attach: ").append(paramFragment);
    }
    if (paramFragment.mDetached)
    {
      paramFragment.mDetached = false;
      if (!paramFragment.mAdded)
      {
        if (this.mAdded.contains(paramFragment)) {
          throw new IllegalStateException("Fragment already added: ".concat(String.valueOf(paramFragment)));
        }
        if (DEBUG) {
          new StringBuilder("add from attach: ").append(paramFragment);
        }
      }
    }
    synchronized (this.mAdded)
    {
      this.mAdded.add(paramFragment);
      paramFragment.mAdded = true;
      if ((paramFragment.mHasMenu) && (paramFragment.mMenuVisible)) {
        this.mNeedMenuInvalidate = true;
      }
      return;
    }
  }
  
  public final k beginTransaction()
  {
    return new b(this);
  }
  
  final void completeExecute(b paramb, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject;
    int i;
    if (paramBoolean1)
    {
      paramb.E(paramBoolean3);
      localObject = new ArrayList(1);
      ArrayList localArrayList = new ArrayList(1);
      ((ArrayList)localObject).add(paramb);
      localArrayList.add(Boolean.valueOf(paramBoolean1));
      if (paramBoolean2) {
        l.a(this, (ArrayList)localObject, localArrayList, 0, 1, true);
      }
      if (paramBoolean3) {
        moveToState(this.mCurState, true);
      }
      if (this.mActive == null) {
        return;
      }
      int j = this.mActive.size();
      i = 0;
      label95:
      if (i >= j) {
        return;
      }
      localObject = (Fragment)this.mActive.valueAt(i);
      if ((localObject != null) && (((Fragment)localObject).mView != null) && (((Fragment)localObject).mIsNewlyAdded) && (paramb.ar(((Fragment)localObject).mContainerId)))
      {
        if (((Fragment)localObject).mPostponedAlpha > 0.0F) {
          ((Fragment)localObject).mView.setAlpha(((Fragment)localObject).mPostponedAlpha);
        }
        if (!paramBoolean3) {
          break label199;
        }
        ((Fragment)localObject).mPostponedAlpha = 0.0F;
      }
    }
    for (;;)
    {
      i += 1;
      break label95;
      paramb.dB();
      break;
      label199:
      ((Fragment)localObject).mPostponedAlpha = -1.0F;
      ((Fragment)localObject).mIsNewlyAdded = false;
    }
  }
  
  final void completeShowHideFragment(final Fragment paramFragment)
  {
    boolean bool;
    c localc;
    if (paramFragment.mView != null)
    {
      i = paramFragment.getNextTransition();
      if (paramFragment.mHidden) {
        break label135;
      }
      bool = true;
      localc = loadAnimation(paramFragment, i, bool, paramFragment.getNextTransitionStyle());
      if ((localc == null) || (localc.CO == null)) {
        break label194;
      }
      localc.CO.setTarget(paramFragment.mView);
      if (!paramFragment.mHidden) {
        break label183;
      }
      if (!paramFragment.isHideReplaced()) {
        break label140;
      }
      paramFragment.setHideReplaced(false);
    }
    for (;;)
    {
      setHWLayerAnimListenerIfAlpha(paramFragment.mView, localc);
      localc.CO.start();
      if ((paramFragment.mAdded) && (paramFragment.mHasMenu) && (paramFragment.mMenuVisible)) {
        this.mNeedMenuInvalidate = true;
      }
      paramFragment.mHiddenChanged = false;
      paramFragment.onHiddenChanged(paramFragment.mHidden);
      return;
      label135:
      bool = false;
      break;
      label140:
      final ViewGroup localViewGroup = paramFragment.mContainer;
      final View localView = paramFragment.mView;
      localViewGroup.startViewTransition(localView);
      localc.CO.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          localViewGroup.endViewTransition(localView);
          paramAnonymousAnimator.removeListener(this);
          if (paramFragment.mView != null) {
            paramFragment.mView.setVisibility(8);
          }
        }
      });
      continue;
      label183:
      paramFragment.mView.setVisibility(0);
    }
    label194:
    if (localc != null)
    {
      setHWLayerAnimListenerIfAlpha(paramFragment.mView, localc);
      paramFragment.mView.startAnimation(localc.CN);
      localc.CN.start();
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
  
  public final void detachFragment(Fragment paramFragment)
  {
    if (DEBUG) {
      new StringBuilder("detach: ").append(paramFragment);
    }
    if (!paramFragment.mDetached)
    {
      paramFragment.mDetached = true;
      if (paramFragment.mAdded) {
        if (DEBUG) {
          new StringBuilder("remove from detach: ").append(paramFragment);
        }
      }
    }
    synchronized (this.mAdded)
    {
      this.mAdded.remove(paramFragment);
      if ((paramFragment.mHasMenu) && (paramFragment.mMenuVisible)) {
        this.mNeedMenuInvalidate = true;
      }
      paramFragment.mAdded = false;
      return;
    }
  }
  
  public final void dispatchActivityCreated()
  {
    this.mStateSaved = false;
    this.mStopped = false;
    dispatchStateChange(2);
  }
  
  public final void dispatchConfigurationChanged(Configuration paramConfiguration)
  {
    int i = 0;
    while (i < this.mAdded.size())
    {
      Fragment localFragment = (Fragment)this.mAdded.get(i);
      if (localFragment != null) {
        localFragment.performConfigurationChanged(paramConfiguration);
      }
      i += 1;
    }
  }
  
  public final boolean dispatchContextItemSelected(MenuItem paramMenuItem)
  {
    if (this.mCurState <= 0) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i < this.mAdded.size())
      {
        Fragment localFragment = (Fragment)this.mAdded.get(i);
        if ((localFragment != null) && (localFragment.performContextItemSelected(paramMenuItem))) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public final void dispatchCreate()
  {
    this.mStateSaved = false;
    this.mStopped = false;
    dispatchStateChange(1);
  }
  
  public final boolean dispatchCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    int j = 0;
    if (this.mCurState <= 0) {
      return false;
    }
    Object localObject1 = null;
    int i = 0;
    boolean bool1 = false;
    while (i < this.mAdded.size())
    {
      Fragment localFragment = (Fragment)this.mAdded.get(i);
      Object localObject2 = localObject1;
      boolean bool2 = bool1;
      if (localFragment != null)
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
      i += 1;
      bool1 = bool2;
      localObject1 = localObject2;
    }
    if (this.mCreatedMenus != null)
    {
      i = j;
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
  
  public final void dispatchDestroy()
  {
    this.mDestroyed = true;
    execPendingActions();
    dispatchStateChange(0);
    this.mHost = null;
    this.mContainer = null;
    this.mParent = null;
  }
  
  public final void dispatchDestroyView()
  {
    dispatchStateChange(1);
  }
  
  public final void dispatchLowMemory()
  {
    int i = 0;
    while (i < this.mAdded.size())
    {
      Fragment localFragment = (Fragment)this.mAdded.get(i);
      if (localFragment != null) {
        localFragment.performLowMemory();
      }
      i += 1;
    }
  }
  
  public final void dispatchMultiWindowModeChanged(boolean paramBoolean)
  {
    int i = this.mAdded.size() - 1;
    while (i >= 0)
    {
      Fragment localFragment = (Fragment)this.mAdded.get(i);
      if (localFragment != null) {
        localFragment.performMultiWindowModeChanged(paramBoolean);
      }
      i -= 1;
    }
  }
  
  final void dispatchOnFragmentActivityCreated(Fragment paramFragment, Bundle paramBundle, boolean paramBoolean)
  {
    if (this.mParent != null)
    {
      localObject = this.mParent.getFragmentManager();
      if ((localObject instanceof FragmentManagerImpl)) {
        ((FragmentManagerImpl)localObject).dispatchOnFragmentActivityCreated(paramFragment, paramBundle, true);
      }
    }
    Object localObject = this.mLifecycleCallbacks.iterator();
    while (((Iterator)localObject).hasNext())
    {
      f localf = (f)((Iterator)localObject).next();
      if ((!paramBoolean) || (localf.CU)) {
        localf.CT.onFragmentActivityCreated(this, paramFragment, paramBundle);
      }
    }
  }
  
  final void dispatchOnFragmentAttached(Fragment paramFragment, Context paramContext, boolean paramBoolean)
  {
    if (this.mParent != null)
    {
      localObject = this.mParent.getFragmentManager();
      if ((localObject instanceof FragmentManagerImpl)) {
        ((FragmentManagerImpl)localObject).dispatchOnFragmentAttached(paramFragment, paramContext, true);
      }
    }
    Object localObject = this.mLifecycleCallbacks.iterator();
    while (((Iterator)localObject).hasNext())
    {
      f localf = (f)((Iterator)localObject).next();
      if ((!paramBoolean) || (localf.CU)) {
        localf.CT.onFragmentAttached(this, paramFragment, paramContext);
      }
    }
  }
  
  final void dispatchOnFragmentCreated(Fragment paramFragment, Bundle paramBundle, boolean paramBoolean)
  {
    if (this.mParent != null)
    {
      localObject = this.mParent.getFragmentManager();
      if ((localObject instanceof FragmentManagerImpl)) {
        ((FragmentManagerImpl)localObject).dispatchOnFragmentCreated(paramFragment, paramBundle, true);
      }
    }
    Object localObject = this.mLifecycleCallbacks.iterator();
    while (((Iterator)localObject).hasNext())
    {
      f localf = (f)((Iterator)localObject).next();
      if ((!paramBoolean) || (localf.CU)) {
        localf.CT.onFragmentCreated(this, paramFragment, paramBundle);
      }
    }
  }
  
  final void dispatchOnFragmentDestroyed(Fragment paramFragment, boolean paramBoolean)
  {
    if (this.mParent != null)
    {
      localObject = this.mParent.getFragmentManager();
      if ((localObject instanceof FragmentManagerImpl)) {
        ((FragmentManagerImpl)localObject).dispatchOnFragmentDestroyed(paramFragment, true);
      }
    }
    Object localObject = this.mLifecycleCallbacks.iterator();
    while (((Iterator)localObject).hasNext())
    {
      f localf = (f)((Iterator)localObject).next();
      if ((!paramBoolean) || (localf.CU)) {
        localf.CT.onFragmentDestroyed(this, paramFragment);
      }
    }
  }
  
  final void dispatchOnFragmentDetached(Fragment paramFragment, boolean paramBoolean)
  {
    if (this.mParent != null)
    {
      localObject = this.mParent.getFragmentManager();
      if ((localObject instanceof FragmentManagerImpl)) {
        ((FragmentManagerImpl)localObject).dispatchOnFragmentDetached(paramFragment, true);
      }
    }
    Object localObject = this.mLifecycleCallbacks.iterator();
    while (((Iterator)localObject).hasNext())
    {
      f localf = (f)((Iterator)localObject).next();
      if ((!paramBoolean) || (localf.CU)) {
        localf.CT.onFragmentDetached(this, paramFragment);
      }
    }
  }
  
  final void dispatchOnFragmentPaused(Fragment paramFragment, boolean paramBoolean)
  {
    if (this.mParent != null)
    {
      localObject = this.mParent.getFragmentManager();
      if ((localObject instanceof FragmentManagerImpl)) {
        ((FragmentManagerImpl)localObject).dispatchOnFragmentPaused(paramFragment, true);
      }
    }
    Object localObject = this.mLifecycleCallbacks.iterator();
    while (((Iterator)localObject).hasNext())
    {
      f localf = (f)((Iterator)localObject).next();
      if ((!paramBoolean) || (localf.CU)) {
        localf.CT.onFragmentPaused(this, paramFragment);
      }
    }
  }
  
  final void dispatchOnFragmentPreAttached(Fragment paramFragment, Context paramContext, boolean paramBoolean)
  {
    if (this.mParent != null)
    {
      localObject = this.mParent.getFragmentManager();
      if ((localObject instanceof FragmentManagerImpl)) {
        ((FragmentManagerImpl)localObject).dispatchOnFragmentPreAttached(paramFragment, paramContext, true);
      }
    }
    Object localObject = this.mLifecycleCallbacks.iterator();
    while (((Iterator)localObject).hasNext())
    {
      f localf = (f)((Iterator)localObject).next();
      if ((!paramBoolean) || (localf.CU)) {
        localf.CT.onFragmentPreAttached(this, paramFragment, paramContext);
      }
    }
  }
  
  final void dispatchOnFragmentPreCreated(Fragment paramFragment, Bundle paramBundle, boolean paramBoolean)
  {
    if (this.mParent != null)
    {
      localObject = this.mParent.getFragmentManager();
      if ((localObject instanceof FragmentManagerImpl)) {
        ((FragmentManagerImpl)localObject).dispatchOnFragmentPreCreated(paramFragment, paramBundle, true);
      }
    }
    Object localObject = this.mLifecycleCallbacks.iterator();
    while (((Iterator)localObject).hasNext())
    {
      f localf = (f)((Iterator)localObject).next();
      if ((!paramBoolean) || (localf.CU)) {
        localf.CT.onFragmentPreCreated(this, paramFragment, paramBundle);
      }
    }
  }
  
  final void dispatchOnFragmentResumed(Fragment paramFragment, boolean paramBoolean)
  {
    if (this.mParent != null)
    {
      localObject = this.mParent.getFragmentManager();
      if ((localObject instanceof FragmentManagerImpl)) {
        ((FragmentManagerImpl)localObject).dispatchOnFragmentResumed(paramFragment, true);
      }
    }
    Object localObject = this.mLifecycleCallbacks.iterator();
    while (((Iterator)localObject).hasNext())
    {
      f localf = (f)((Iterator)localObject).next();
      if ((!paramBoolean) || (localf.CU)) {
        localf.CT.onFragmentResumed(this, paramFragment);
      }
    }
  }
  
  final void dispatchOnFragmentSaveInstanceState(Fragment paramFragment, Bundle paramBundle, boolean paramBoolean)
  {
    if (this.mParent != null)
    {
      localObject = this.mParent.getFragmentManager();
      if ((localObject instanceof FragmentManagerImpl)) {
        ((FragmentManagerImpl)localObject).dispatchOnFragmentSaveInstanceState(paramFragment, paramBundle, true);
      }
    }
    Object localObject = this.mLifecycleCallbacks.iterator();
    while (((Iterator)localObject).hasNext())
    {
      f localf = (f)((Iterator)localObject).next();
      if ((!paramBoolean) || (localf.CU)) {
        localf.CT.onFragmentSaveInstanceState(this, paramFragment, paramBundle);
      }
    }
  }
  
  final void dispatchOnFragmentStarted(Fragment paramFragment, boolean paramBoolean)
  {
    if (this.mParent != null)
    {
      localObject = this.mParent.getFragmentManager();
      if ((localObject instanceof FragmentManagerImpl)) {
        ((FragmentManagerImpl)localObject).dispatchOnFragmentStarted(paramFragment, true);
      }
    }
    Object localObject = this.mLifecycleCallbacks.iterator();
    while (((Iterator)localObject).hasNext())
    {
      f localf = (f)((Iterator)localObject).next();
      if ((!paramBoolean) || (localf.CU)) {
        localf.CT.onFragmentStarted(this, paramFragment);
      }
    }
  }
  
  final void dispatchOnFragmentStopped(Fragment paramFragment, boolean paramBoolean)
  {
    if (this.mParent != null)
    {
      localObject = this.mParent.getFragmentManager();
      if ((localObject instanceof FragmentManagerImpl)) {
        ((FragmentManagerImpl)localObject).dispatchOnFragmentStopped(paramFragment, true);
      }
    }
    Object localObject = this.mLifecycleCallbacks.iterator();
    while (((Iterator)localObject).hasNext())
    {
      f localf = (f)((Iterator)localObject).next();
      if ((!paramBoolean) || (localf.CU)) {
        localf.CT.onFragmentStopped(this, paramFragment);
      }
    }
  }
  
  final void dispatchOnFragmentViewCreated(Fragment paramFragment, View paramView, Bundle paramBundle, boolean paramBoolean)
  {
    if (this.mParent != null)
    {
      localObject = this.mParent.getFragmentManager();
      if ((localObject instanceof FragmentManagerImpl)) {
        ((FragmentManagerImpl)localObject).dispatchOnFragmentViewCreated(paramFragment, paramView, paramBundle, true);
      }
    }
    Object localObject = this.mLifecycleCallbacks.iterator();
    while (((Iterator)localObject).hasNext())
    {
      f localf = (f)((Iterator)localObject).next();
      if ((!paramBoolean) || (localf.CU)) {
        localf.CT.onFragmentViewCreated(this, paramFragment, paramView, paramBundle);
      }
    }
  }
  
  final void dispatchOnFragmentViewDestroyed(Fragment paramFragment, boolean paramBoolean)
  {
    if (this.mParent != null)
    {
      localObject = this.mParent.getFragmentManager();
      if ((localObject instanceof FragmentManagerImpl)) {
        ((FragmentManagerImpl)localObject).dispatchOnFragmentViewDestroyed(paramFragment, true);
      }
    }
    Object localObject = this.mLifecycleCallbacks.iterator();
    while (((Iterator)localObject).hasNext())
    {
      f localf = (f)((Iterator)localObject).next();
      if ((!paramBoolean) || (localf.CU)) {
        localf.CT.onFragmentViewDestroyed(this, paramFragment);
      }
    }
  }
  
  public final boolean dispatchOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (this.mCurState <= 0) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i < this.mAdded.size())
      {
        Fragment localFragment = (Fragment)this.mAdded.get(i);
        if ((localFragment != null) && (localFragment.performOptionsItemSelected(paramMenuItem))) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public final void dispatchOptionsMenuClosed(Menu paramMenu)
  {
    if (this.mCurState <= 0) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.mAdded.size())
      {
        Fragment localFragment = (Fragment)this.mAdded.get(i);
        if (localFragment != null) {
          localFragment.performOptionsMenuClosed(paramMenu);
        }
        i += 1;
      }
    }
  }
  
  public final void dispatchPause()
  {
    dispatchStateChange(3);
  }
  
  public final void dispatchPictureInPictureModeChanged(boolean paramBoolean)
  {
    int i = this.mAdded.size() - 1;
    while (i >= 0)
    {
      Fragment localFragment = (Fragment)this.mAdded.get(i);
      if (localFragment != null) {
        localFragment.performPictureInPictureModeChanged(paramBoolean);
      }
      i -= 1;
    }
  }
  
  public final boolean dispatchPrepareOptionsMenu(Menu paramMenu)
  {
    if (this.mCurState <= 0) {
      return false;
    }
    int i = 0;
    boolean bool2;
    for (boolean bool1 = false; i < this.mAdded.size(); bool1 = bool2)
    {
      Fragment localFragment = (Fragment)this.mAdded.get(i);
      bool2 = bool1;
      if (localFragment != null)
      {
        bool2 = bool1;
        if (localFragment.performPrepareOptionsMenu(paramMenu)) {
          bool2 = true;
        }
      }
      i += 1;
    }
    return bool1;
  }
  
  public final void dispatchResume()
  {
    this.mStateSaved = false;
    this.mStopped = false;
    dispatchStateChange(4);
  }
  
  public final void dispatchStart()
  {
    this.mStateSaved = false;
    this.mStopped = false;
    dispatchStateChange(3);
  }
  
  public final void dispatchStop()
  {
    this.mStopped = true;
    dispatchStateChange(2);
  }
  
  final void doPendingDeferredStart()
  {
    if (this.mHavePendingDeferredStart)
    {
      this.mHavePendingDeferredStart = false;
      startPendingDeferredFragments();
    }
  }
  
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    int j = 0;
    String str = paramString + "    ";
    int i;
    if (this.mActive != null)
    {
      k = this.mActive.size();
      if (k > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("Active Fragments in ");
        paramPrintWriter.print(Integer.toHexString(System.identityHashCode(this)));
        paramPrintWriter.println(":");
        i = 0;
        while (i < k)
        {
          Fragment localFragment = (Fragment)this.mActive.valueAt(i);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(localFragment);
          if (localFragment != null) {
            localFragment.dump(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
          }
          i += 1;
        }
      }
    }
    int k = this.mAdded.size();
    if (k > 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Added Fragments:");
      i = 0;
      while (i < k)
      {
        paramFileDescriptor = (Fragment)this.mAdded.get(i);
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  #");
        paramPrintWriter.print(i);
        paramPrintWriter.print(": ");
        paramPrintWriter.println(paramFileDescriptor.toString());
        i += 1;
      }
    }
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
          paramFileDescriptor = (Fragment)this.mCreatedMenus.get(i);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(paramFileDescriptor.toString());
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
          paramFileDescriptor = (b)this.mBackStack.get(i);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(paramFileDescriptor.toString());
          paramFileDescriptor.a(str, paramPrintWriter);
          i += 1;
        }
      }
    }
    try
    {
      if (this.mBackStackIndices != null)
      {
        k = this.mBackStackIndices.size();
        if (k > 0)
        {
          paramPrintWriter.print(paramString);
          paramPrintWriter.println("Back Stack Indices:");
          i = 0;
          while (i < k)
          {
            paramFileDescriptor = (b)this.mBackStackIndices.get(i);
            paramPrintWriter.print(paramString);
            paramPrintWriter.print("  #");
            paramPrintWriter.print(i);
            paramPrintWriter.print(": ");
            paramPrintWriter.println(paramFileDescriptor);
            i += 1;
          }
        }
      }
      if ((this.mAvailBackStackIndices != null) && (this.mAvailBackStackIndices.size() > 0))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mAvailBackStackIndices: ");
        paramPrintWriter.println(Arrays.toString(this.mAvailBackStackIndices.toArray()));
      }
      if (this.mPendingActions != null)
      {
        k = this.mPendingActions.size();
        if (k > 0)
        {
          paramPrintWriter.print(paramString);
          paramPrintWriter.println("Pending Actions:");
          i = j;
          while (i < k)
          {
            paramFileDescriptor = (h)this.mPendingActions.get(i);
            paramPrintWriter.print(paramString);
            paramPrintWriter.print("  #");
            paramPrintWriter.print(i);
            paramPrintWriter.print(": ");
            paramPrintWriter.println(paramFileDescriptor);
            i += 1;
          }
        }
      }
      paramPrintWriter.print(paramString);
    }
    finally {}
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
    if (this.mNoTransactionsBecause != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  mNoTransactionsBecause=");
      paramPrintWriter.println(this.mNoTransactionsBecause);
    }
  }
  
  public final void enqueueAction(h paramh, boolean paramBoolean)
  {
    if (!paramBoolean) {
      checkStateLoss();
    }
    try
    {
      if ((this.mDestroyed) || (this.mHost == null))
      {
        if (paramBoolean) {
          return;
        }
        throw new IllegalStateException("Activity has been destroyed");
      }
    }
    finally {}
    if (this.mPendingActions == null) {
      this.mPendingActions = new ArrayList();
    }
    this.mPendingActions.add(paramh);
    scheduleCommit();
  }
  
  final void ensureInflatedFragmentView(Fragment paramFragment)
  {
    if ((paramFragment.mFromLayout) && (!paramFragment.mPerformedCreateView))
    {
      paramFragment.performCreateView(paramFragment.performGetLayoutInflater(paramFragment.mSavedFragmentState), null, paramFragment.mSavedFragmentState);
      if (paramFragment.mView != null)
      {
        paramFragment.mInnerView = paramFragment.mView;
        paramFragment.mView.setSaveFromParentEnabled(false);
        if (paramFragment.mHidden) {
          paramFragment.mView.setVisibility(8);
        }
        paramFragment.onViewCreated(paramFragment.mView, paramFragment.mSavedFragmentState);
        dispatchOnFragmentViewCreated(paramFragment, paramFragment.mView, paramFragment.mSavedFragmentState, false);
      }
    }
    else
    {
      return;
    }
    paramFragment.mInnerView = null;
  }
  
  public final boolean execPendingActions()
  {
    ensureExecReady(true);
    boolean bool = false;
    for (;;)
    {
      if (generateOpsForPendingActions(this.mTmpRecords, this.mTmpIsPop)) {
        this.mExecutingActions = true;
      }
      try
      {
        removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);
        cleanupExec();
        bool = true;
      }
      finally
      {
        cleanupExec();
      }
    }
    burpActive();
    return bool;
  }
  
  public final void execSingleAction(h paramh, boolean paramBoolean)
  {
    if ((paramBoolean) && ((this.mHost == null) || (this.mDestroyed))) {
      return;
    }
    ensureExecReady(paramBoolean);
    if (paramh.a(this.mTmpRecords, this.mTmpIsPop)) {
      this.mExecutingActions = true;
    }
    try
    {
      removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);
      cleanupExec();
      doPendingDeferredStart();
      return;
    }
    finally
    {
      cleanupExec();
    }
  }
  
  public final boolean executePendingTransactions()
  {
    boolean bool = execPendingActions();
    forcePostponedTransactions();
    return bool;
  }
  
  public final Fragment findFragmentById(int paramInt)
  {
    int i = this.mAdded.size() - 1;
    Object localObject;
    while (i >= 0)
    {
      localObject = (Fragment)this.mAdded.get(i);
      if ((localObject != null) && (((Fragment)localObject).mFragmentId == paramInt)) {
        return localObject;
      }
      i -= 1;
    }
    if (this.mActive != null)
    {
      i = this.mActive.size() - 1;
      for (;;)
      {
        if (i < 0) {
          break label105;
        }
        Fragment localFragment = (Fragment)this.mActive.valueAt(i);
        if (localFragment != null)
        {
          localObject = localFragment;
          if (localFragment.mFragmentId == paramInt) {
            break;
          }
        }
        i -= 1;
      }
    }
    label105:
    return null;
  }
  
  public final Fragment findFragmentByTag(String paramString)
  {
    int i;
    Object localObject;
    if (paramString != null)
    {
      i = this.mAdded.size() - 1;
      while (i >= 0)
      {
        localObject = (Fragment)this.mAdded.get(i);
        if ((localObject != null) && (paramString.equals(((Fragment)localObject).mTag))) {
          return localObject;
        }
        i -= 1;
      }
    }
    if ((this.mActive != null) && (paramString != null))
    {
      i = this.mActive.size() - 1;
      for (;;)
      {
        if (i < 0) {
          break label119;
        }
        Fragment localFragment = (Fragment)this.mActive.valueAt(i);
        if (localFragment != null)
        {
          localObject = localFragment;
          if (paramString.equals(localFragment.mTag)) {
            break;
          }
        }
        i -= 1;
      }
    }
    label119:
    return null;
  }
  
  public final Fragment findFragmentByWho(String paramString)
  {
    if ((this.mActive != null) && (paramString != null))
    {
      int i = this.mActive.size() - 1;
      while (i >= 0)
      {
        Fragment localFragment = (Fragment)this.mActive.valueAt(i);
        if (localFragment != null)
        {
          localFragment = localFragment.findFragmentByWho(paramString);
          if (localFragment != null) {
            return localFragment;
          }
        }
        i -= 1;
      }
    }
    return null;
  }
  
  public final void freeBackStackIndex(int paramInt)
  {
    try
    {
      this.mBackStackIndices.set(paramInt, null);
      if (this.mAvailBackStackIndices == null) {
        this.mAvailBackStackIndices = new ArrayList();
      }
      this.mAvailBackStackIndices.add(Integer.valueOf(paramInt));
      return;
    }
    finally {}
  }
  
  final int getActiveFragmentCount()
  {
    if (this.mActive == null) {
      return 0;
    }
    return this.mActive.size();
  }
  
  final List<Fragment> getActiveFragments()
  {
    Object localObject;
    if (this.mActive == null)
    {
      localObject = null;
      return localObject;
    }
    int j = this.mActive.size();
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    for (;;)
    {
      localObject = localArrayList;
      if (i >= j) {
        break;
      }
      localArrayList.add(this.mActive.valueAt(i));
      i += 1;
    }
  }
  
  public final g.a getBackStackEntryAt(int paramInt)
  {
    return (g.a)this.mBackStack.get(paramInt);
  }
  
  public final int getBackStackEntryCount()
  {
    if (this.mBackStack != null) {
      return this.mBackStack.size();
    }
    return 0;
  }
  
  public final Fragment getFragment(Bundle paramBundle, String paramString)
  {
    int i = paramBundle.getInt(paramString, -1);
    if (i == -1) {
      paramBundle = null;
    }
    Fragment localFragment;
    do
    {
      return paramBundle;
      localFragment = (Fragment)this.mActive.get(i);
      paramBundle = localFragment;
    } while (localFragment != null);
    throwException(new IllegalStateException("Fragment no longer exists for key " + paramString + ": index " + i));
    return localFragment;
  }
  
  public final List<Fragment> getFragments()
  {
    if (this.mAdded.isEmpty()) {
      return Collections.emptyList();
    }
    synchronized (this.mAdded)
    {
      List localList = (List)this.mAdded.clone();
      return localList;
    }
  }
  
  final LayoutInflater.Factory2 getLayoutInflaterFactory()
  {
    return this;
  }
  
  public final Fragment getPrimaryNavigationFragment()
  {
    return this.mPrimaryNav;
  }
  
  public final void hideFragment(Fragment paramFragment)
  {
    boolean bool = true;
    if (DEBUG) {
      new StringBuilder("hide: ").append(paramFragment);
    }
    if (!paramFragment.mHidden)
    {
      paramFragment.mHidden = true;
      if (paramFragment.mHiddenChanged) {
        break label48;
      }
    }
    for (;;)
    {
      paramFragment.mHiddenChanged = bool;
      return;
      label48:
      bool = false;
    }
  }
  
  public final boolean isDestroyed()
  {
    return this.mDestroyed;
  }
  
  final boolean isStateAtLeast(int paramInt)
  {
    return this.mCurState >= paramInt;
  }
  
  public final boolean isStateSaved()
  {
    return (this.mStateSaved) || (this.mStopped);
  }
  
  final c loadAnimation(Fragment paramFragment, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    int j = paramFragment.getNextAnim();
    Animation localAnimation = paramFragment.onCreateAnimation(paramInt1, paramBoolean, j);
    if (localAnimation != null) {
      return new c(localAnimation);
    }
    paramFragment = paramFragment.onCreateAnimator(paramInt1, paramBoolean, j);
    if (paramFragment != null) {
      return new c(paramFragment);
    }
    if (j != 0)
    {
      boolean bool = "anim".equals(this.mHost.mContext.getResources().getResourceTypeName(j));
      if (bool) {}
      for (;;)
      {
        try
        {
          paramFragment = AnimationUtils.loadAnimation(this.mHost.mContext, j);
          if (paramFragment != null)
          {
            paramFragment = new c(paramFragment);
            return paramFragment;
          }
        }
        catch (Resources.NotFoundException paramFragment)
        {
          throw paramFragment;
          i = 1;
          if (i != 0) {
            break label194;
          }
          try
          {
            paramFragment = AnimatorInflater.loadAnimator(this.mHost.mContext, j);
            if (paramFragment == null) {
              break label194;
            }
            paramFragment = new c(paramFragment);
            return paramFragment;
          }
          catch (RuntimeException paramFragment)
          {
            if (!bool) {
              break;
            }
          }
          throw paramFragment;
        }
        catch (RuntimeException paramFragment) {}
        int i = 0;
      }
      paramFragment = AnimationUtils.loadAnimation(this.mHost.mContext, j);
      if (paramFragment != null) {
        return new c(paramFragment);
      }
    }
    label194:
    if (paramInt1 == 0) {
      return null;
    }
    paramInt1 = transitToStyleIndex(paramInt1, paramBoolean);
    if (paramInt1 < 0) {
      return null;
    }
    switch (paramInt1)
    {
    default: 
      paramInt1 = paramInt2;
      if (paramInt2 == 0)
      {
        paramInt1 = paramInt2;
        if (this.mHost.onHasWindowAnimations()) {
          paramInt1 = this.mHost.onGetWindowAnimations();
        }
      }
      if (paramInt1 == 0) {
        return null;
      }
      break;
    case 1: 
      return makeOpenCloseAnimation(this.mHost.mContext, 1.125F, 1.0F, 0.0F, 1.0F);
    case 2: 
      return makeOpenCloseAnimation(this.mHost.mContext, 1.0F, 0.975F, 1.0F, 0.0F);
    case 3: 
      return makeOpenCloseAnimation(this.mHost.mContext, 0.975F, 1.0F, 0.0F, 1.0F);
    case 4: 
      return makeOpenCloseAnimation(this.mHost.mContext, 1.0F, 1.075F, 1.0F, 0.0F);
    case 5: 
      return makeFadeAnimation(this.mHost.mContext, 0.0F, 1.0F);
    case 6: 
      return makeFadeAnimation(this.mHost.mContext, 1.0F, 0.0F);
    }
    return null;
  }
  
  final void makeActive(Fragment paramFragment)
  {
    if (paramFragment.mIndex >= 0) {}
    do
    {
      return;
      int i = this.mNextFragmentIndex;
      this.mNextFragmentIndex = (i + 1);
      paramFragment.setIndex(i, this.mParent);
      if (this.mActive == null) {
        this.mActive = new SparseArray();
      }
      this.mActive.put(paramFragment.mIndex, paramFragment);
    } while (!DEBUG);
    new StringBuilder("Allocated fragment index ").append(paramFragment);
  }
  
  final void makeInactive(Fragment paramFragment)
  {
    if (paramFragment.mIndex < 0) {
      return;
    }
    if (DEBUG) {
      new StringBuilder("Freeing fragment index ").append(paramFragment);
    }
    this.mActive.put(paramFragment.mIndex, null);
    paramFragment.initState();
  }
  
  final void moveFragmentToExpectedState(Fragment paramFragment)
  {
    if (paramFragment == null) {}
    label234:
    label255:
    for (;;)
    {
      return;
      int j = this.mCurState;
      int i = j;
      Object localObject;
      if (paramFragment.mRemoving)
      {
        if (paramFragment.isInBackStack()) {
          i = Math.min(j, 1);
        }
      }
      else
      {
        moveToState(paramFragment, i, paramFragment.getNextTransition(), paramFragment.getNextTransitionStyle(), false);
        if (paramFragment.mView != null)
        {
          localObject = findFragmentUnder(paramFragment);
          if (localObject != null)
          {
            localObject = ((Fragment)localObject).mView;
            ViewGroup localViewGroup = paramFragment.mContainer;
            i = localViewGroup.indexOfChild((View)localObject);
            j = localViewGroup.indexOfChild(paramFragment.mView);
            if (j < i)
            {
              localViewGroup.removeViewAt(j);
              localViewGroup.addView(paramFragment.mView, i);
            }
          }
          if ((paramFragment.mIsNewlyAdded) && (paramFragment.mContainer != null))
          {
            if (paramFragment.mPostponedAlpha > 0.0F) {
              paramFragment.mView.setAlpha(paramFragment.mPostponedAlpha);
            }
            paramFragment.mPostponedAlpha = 0.0F;
            paramFragment.mIsNewlyAdded = false;
            localObject = loadAnimation(paramFragment, paramFragment.getNextTransition(), true, paramFragment.getNextTransitionStyle());
            if (localObject != null)
            {
              setHWLayerAnimListenerIfAlpha(paramFragment.mView, (c)localObject);
              if (((c)localObject).CN == null) {
                break label234;
              }
              paramFragment.mView.startAnimation(((c)localObject).CN);
            }
          }
        }
      }
      for (;;)
      {
        if (!paramFragment.mHiddenChanged) {
          break label255;
        }
        completeShowHideFragment(paramFragment);
        return;
        i = Math.min(j, 0);
        break;
        ((c)localObject).CO.setTarget(paramFragment.mView);
        ((c)localObject).CO.start();
      }
    }
  }
  
  final void moveToState(int paramInt, boolean paramBoolean)
  {
    if ((this.mHost == null) && (paramInt != 0)) {
      throw new IllegalStateException("No activity");
    }
    if ((!paramBoolean) && (paramInt == this.mCurState)) {}
    do
    {
      do
      {
        return;
        this.mCurState = paramInt;
      } while (this.mActive == null);
      int i = this.mAdded.size();
      paramInt = 0;
      while (paramInt < i)
      {
        moveFragmentToExpectedState((Fragment)this.mAdded.get(paramInt));
        paramInt += 1;
      }
      i = this.mActive.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Fragment localFragment = (Fragment)this.mActive.valueAt(paramInt);
        if ((localFragment != null) && ((localFragment.mRemoving) || (localFragment.mDetached)) && (!localFragment.mIsNewlyAdded)) {
          moveFragmentToExpectedState(localFragment);
        }
        paramInt += 1;
      }
      startPendingDeferredFragments();
    } while ((!this.mNeedMenuInvalidate) || (this.mHost == null) || (this.mCurState != 4));
    this.mHost.dF();
    this.mNeedMenuInvalidate = false;
  }
  
  final void moveToState(Fragment paramFragment)
  {
    moveToState(paramFragment, this.mCurState, 0, 0, false);
  }
  
  final void moveToState(Fragment paramFragment, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    boolean bool = true;
    int j;
    if (paramFragment.mAdded)
    {
      j = paramInt1;
      if (!paramFragment.mDetached) {}
    }
    else
    {
      j = paramInt1;
      if (paramInt1 > 1) {
        j = 1;
      }
    }
    int i = j;
    if (paramFragment.mRemoving)
    {
      i = j;
      if (j > paramFragment.mState)
      {
        if ((paramFragment.mState != 0) || (!paramFragment.isInBackStack())) {
          break label127;
        }
        i = 1;
      }
    }
    paramInt1 = i;
    if (paramFragment.mDeferStart)
    {
      paramInt1 = i;
      if (paramFragment.mState < 3)
      {
        paramInt1 = i;
        if (i > 2) {
          paramInt1 = 2;
        }
      }
    }
    label127:
    Object localObject1;
    label536:
    label565:
    label587:
    ViewGroup localViewGroup;
    if (paramFragment.mState <= paramInt1)
    {
      if ((paramFragment.mFromLayout) && (!paramFragment.mInLayout)) {}
      do
      {
        return;
        i = paramFragment.mState;
        break;
        if ((paramFragment.getAnimatingAway() != null) || (paramFragment.getAnimator() != null))
        {
          paramFragment.setAnimatingAway(null);
          paramFragment.setAnimator(null);
          moveToState(paramFragment, paramFragment.getStateAfterAnimating(), 0, 0, true);
        }
        paramInt3 = paramInt1;
        i = paramInt1;
        paramInt2 = paramInt1;
        switch (paramFragment.mState)
        {
        default: 
          i = paramInt1;
        }
      } while (paramFragment.mState == i);
      new StringBuilder("moveToState: Fragment state for ").append(paramFragment).append(" not updated inline; expected state ").append(i).append(" found ").append(paramFragment.mState);
      paramFragment.mState = i;
      return;
      paramInt3 = paramInt1;
      if (paramInt1 > 0)
      {
        if (DEBUG) {
          new StringBuilder("moveto CREATED: ").append(paramFragment);
        }
        paramInt3 = paramInt1;
        if (paramFragment.mSavedFragmentState != null)
        {
          paramFragment.mSavedFragmentState.setClassLoader(this.mHost.mContext.getClassLoader());
          paramFragment.mSavedViewState = paramFragment.mSavedFragmentState.getSparseParcelableArray("android:view_state");
          paramFragment.mTarget = getFragment(paramFragment.mSavedFragmentState, "android:target_state");
          if (paramFragment.mTarget != null) {
            paramFragment.mTargetRequestCode = paramFragment.mSavedFragmentState.getInt("android:target_req_state", 0);
          }
          if (paramFragment.mSavedUserVisibleHint == null) {
            break label536;
          }
          paramFragment.mUserVisibleHint = paramFragment.mSavedUserVisibleHint.booleanValue();
          paramFragment.mSavedUserVisibleHint = null;
          paramInt3 = paramInt1;
          if (!paramFragment.mUserVisibleHint)
          {
            paramFragment.mDeferStart = true;
            paramInt3 = paramInt1;
            if (paramInt1 > 2) {
              paramInt3 = 2;
            }
          }
        }
        paramFragment.mHost = this.mHost;
        paramFragment.mParentFragment = this.mParent;
        if (this.mParent != null) {}
        for (localObject1 = this.mParent.mChildFragmentManager;; localObject1 = this.mHost.mFragmentManager)
        {
          paramFragment.mFragmentManager = ((FragmentManagerImpl)localObject1);
          if (paramFragment.mTarget == null) {
            break label587;
          }
          if (this.mActive.get(paramFragment.mTarget.mIndex) == paramFragment.mTarget) {
            break label565;
          }
          throw new IllegalStateException("Fragment " + paramFragment + " declared target fragment " + paramFragment.mTarget + " that does not belong to this FragmentManager!");
          paramFragment.mUserVisibleHint = paramFragment.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
          break;
        }
        if (paramFragment.mTarget.mState <= 0) {
          moveToState(paramFragment.mTarget, 1, 0, 0, true);
        }
        dispatchOnFragmentPreAttached(paramFragment, this.mHost.mContext, false);
        paramFragment.mCalled = false;
        paramFragment.onAttach(this.mHost.mContext);
        if (!paramFragment.mCalled) {
          throw new aa("Fragment " + paramFragment + " did not call through to super.onAttach()");
        }
        if (paramFragment.mParentFragment == null)
        {
          this.mHost.onAttachFragment(paramFragment);
          label669:
          dispatchOnFragmentAttached(paramFragment, this.mHost.mContext, false);
          if (paramFragment.mIsCreated) {
            break label1203;
          }
          dispatchOnFragmentPreCreated(paramFragment, paramFragment.mSavedFragmentState, false);
          paramFragment.performCreate(paramFragment.mSavedFragmentState);
          dispatchOnFragmentCreated(paramFragment, paramFragment.mSavedFragmentState, false);
          paramFragment.mRetaining = false;
        }
      }
      else
      {
        ensureInflatedFragmentView(paramFragment);
        i = paramInt3;
        if (paramInt3 > 1)
        {
          if (DEBUG) {
            new StringBuilder("moveto ACTIVITY_CREATED: ").append(paramFragment);
          }
          if (!paramFragment.mFromLayout)
          {
            if (paramFragment.mContainerId == 0) {
              break label1769;
            }
            if (paramFragment.mContainerId == -1) {
              throwException(new IllegalArgumentException("Cannot create fragment " + paramFragment + " for a container view with no id"));
            }
            localViewGroup = (ViewGroup)this.mContainer.onFindViewById(paramFragment.mContainerId);
            localObject1 = localViewGroup;
            if (localViewGroup == null)
            {
              localObject1 = localViewGroup;
              if (paramFragment.mRestored) {}
            }
          }
        }
      }
    }
    for (;;)
    {
      label1203:
      Object localObject2;
      try
      {
        localObject1 = paramFragment.getResources().getResourceName(paramFragment.mContainerId);
        throwException(new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(paramFragment.mContainerId) + " (" + (String)localObject1 + ") for fragment " + paramFragment));
        localObject1 = localViewGroup;
        paramFragment.mContainer = ((ViewGroup)localObject1);
        paramFragment.performCreateView(paramFragment.performGetLayoutInflater(paramFragment.mSavedFragmentState), (ViewGroup)localObject1, paramFragment.mSavedFragmentState);
        if (paramFragment.mView != null)
        {
          paramFragment.mInnerView = paramFragment.mView;
          paramFragment.mView.setSaveFromParentEnabled(false);
          if (localObject1 != null) {
            ((ViewGroup)localObject1).addView(paramFragment.mView);
          }
          if (paramFragment.mHidden) {
            paramFragment.mView.setVisibility(8);
          }
          paramFragment.onViewCreated(paramFragment.mView, paramFragment.mSavedFragmentState);
          dispatchOnFragmentViewCreated(paramFragment, paramFragment.mView, paramFragment.mSavedFragmentState, false);
          if ((paramFragment.mView.getVisibility() == 0) && (paramFragment.mContainer != null))
          {
            paramBoolean = bool;
            paramFragment.mIsNewlyAdded = paramBoolean;
            paramFragment.performActivityCreated(paramFragment.mSavedFragmentState);
            dispatchOnFragmentActivityCreated(paramFragment, paramFragment.mSavedFragmentState, false);
            if (paramFragment.mView != null) {
              paramFragment.restoreViewState(paramFragment.mSavedFragmentState);
            }
            paramFragment.mSavedFragmentState = null;
            i = paramInt3;
            paramInt2 = i;
            if (i > 2)
            {
              if (DEBUG) {
                new StringBuilder("moveto STARTED: ").append(paramFragment);
              }
              paramFragment.performStart();
              dispatchOnFragmentStarted(paramFragment, false);
              paramInt2 = i;
            }
            i = paramInt2;
            if (paramInt2 <= 3) {
              break;
            }
            if (DEBUG) {
              new StringBuilder("moveto RESUMED: ").append(paramFragment);
            }
            paramFragment.performResume();
            dispatchOnFragmentResumed(paramFragment, false);
            paramFragment.mSavedFragmentState = null;
            paramFragment.mSavedViewState = null;
            i = paramInt2;
            break;
            paramFragment.mParentFragment.onAttachFragment(paramFragment);
            break label669;
            paramFragment.restoreChildFragmentState(paramFragment.mSavedFragmentState);
            paramFragment.mState = 1;
          }
        }
      }
      catch (Resources.NotFoundException localNotFoundException)
      {
        localObject2 = "unknown";
        continue;
        paramBoolean = false;
        continue;
        paramFragment.mInnerView = null;
        continue;
      }
      i = paramInt1;
      if (paramFragment.mState <= paramInt1) {
        break;
      }
      switch (paramFragment.mState)
      {
      default: 
        i = paramInt1;
        break;
      case 1: 
      case 4: 
      case 3: 
      case 2: 
        label1294:
        label1331:
        do
        {
          i = paramInt1;
          if (paramInt1 > 0) {
            break;
          }
          if (this.mDestroyed)
          {
            if (paramFragment.getAnimatingAway() == null) {
              break label1634;
            }
            localObject2 = paramFragment.getAnimatingAway();
            paramFragment.setAnimatingAway(null);
            ((View)localObject2).clearAnimation();
          }
          if ((paramFragment.getAnimatingAway() == null) && (paramFragment.getAnimator() == null)) {
            break label1660;
          }
          paramFragment.setStateAfterAnimating(paramInt1);
          i = 1;
          break;
          if (paramInt1 < 4)
          {
            if (DEBUG) {
              new StringBuilder("movefrom RESUMED: ").append(paramFragment);
            }
            paramFragment.performPause();
            dispatchOnFragmentPaused(paramFragment, false);
          }
          if (paramInt1 < 3)
          {
            if (DEBUG) {
              new StringBuilder("movefrom STARTED: ").append(paramFragment);
            }
            paramFragment.performStop();
            dispatchOnFragmentStopped(paramFragment, false);
          }
        } while (paramInt1 >= 2);
        if (DEBUG) {
          new StringBuilder("movefrom ACTIVITY_CREATED: ").append(paramFragment);
        }
        if ((paramFragment.mView != null) && (this.mHost.dE()) && (paramFragment.mSavedViewState == null)) {
          saveFragmentViewState(paramFragment);
        }
        paramFragment.performDestroyView();
        dispatchOnFragmentViewDestroyed(paramFragment, false);
        if ((paramFragment.mView != null) && (paramFragment.mContainer != null))
        {
          paramFragment.mContainer.endViewTransition(paramFragment.mView);
          paramFragment.mView.clearAnimation();
          if ((this.mCurState <= 0) || (this.mDestroyed) || (paramFragment.mView.getVisibility() != 0) || (paramFragment.mPostponedAlpha < 0.0F)) {
            break label1763;
          }
        }
        label1634:
        label1763:
        for (localObject2 = loadAnimation(paramFragment, paramInt2, false, paramInt3);; localObject2 = null)
        {
          paramFragment.mPostponedAlpha = 0.0F;
          if (localObject2 != null) {
            animateRemoveFragment(paramFragment, (c)localObject2, paramInt1);
          }
          paramFragment.mContainer.removeView(paramFragment.mView);
          paramFragment.mContainer = null;
          paramFragment.mView = null;
          paramFragment.mViewLifecycleOwner = null;
          paramFragment.mViewLifecycleOwnerLiveData.setValue(null);
          paramFragment.mInnerView = null;
          paramFragment.mInLayout = false;
          break label1294;
          if (paramFragment.getAnimator() == null) {
            break label1331;
          }
          localObject2 = paramFragment.getAnimator();
          paramFragment.setAnimator(null);
          ((Animator)localObject2).cancel();
          break label1331;
          label1660:
          if (DEBUG) {
            new StringBuilder("movefrom CREATED: ").append(paramFragment);
          }
          if (!paramFragment.mRetaining)
          {
            paramFragment.performDestroy();
            dispatchOnFragmentDestroyed(paramFragment, false);
          }
          for (;;)
          {
            paramFragment.performDetach();
            dispatchOnFragmentDetached(paramFragment, false);
            i = paramInt1;
            if (paramBoolean) {
              break;
            }
            if (paramFragment.mRetaining) {
              break label1742;
            }
            makeInactive(paramFragment);
            i = paramInt1;
            break;
            paramFragment.mState = 0;
          }
          paramFragment.mHost = null;
          paramFragment.mParentFragment = null;
          paramFragment.mFragmentManager = null;
          i = paramInt1;
          break;
        }
        label1742:
        label1769:
        localObject2 = null;
      }
    }
  }
  
  public final void noteStateNotSaved()
  {
    this.mSavedNonConfig = null;
    this.mStateSaved = false;
    this.mStopped = false;
    int j = this.mAdded.size();
    int i = 0;
    while (i < j)
    {
      Fragment localFragment = (Fragment)this.mAdded.get(i);
      if (localFragment != null) {
        localFragment.noteStateNotSaved();
      }
      i += 1;
    }
  }
  
  public final View onCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    if (!"fragment".equals(paramString)) {
      return null;
    }
    String str1 = paramAttributeSet.getAttributeValue(null, "class");
    paramString = paramContext.obtainStyledAttributes(paramAttributeSet, g.CV);
    if (str1 == null) {
      str1 = paramString.getString(0);
    }
    for (;;)
    {
      int k = paramString.getResourceId(1, -1);
      String str2 = paramString.getString(2);
      paramString.recycle();
      if (!Fragment.isSupportFragmentClass(this.mHost.mContext, str1)) {
        return null;
      }
      if (paramView != null) {}
      for (int i = paramView.getId(); (i == -1) && (k == -1) && (str2 == null); i = 0) {
        throw new IllegalArgumentException(paramAttributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + str1);
      }
      int j;
      if (k != -1)
      {
        paramString = findFragmentById(k);
        paramView = paramString;
        if (paramString == null)
        {
          paramView = paramString;
          if (str2 != null) {
            paramView = findFragmentByTag(str2);
          }
        }
        paramString = paramView;
        if (paramView == null)
        {
          paramString = paramView;
          if (i != -1) {
            paramString = findFragmentById(i);
          }
        }
        if (DEBUG) {
          new StringBuilder("onCreateView: id=0x").append(Integer.toHexString(k)).append(" fname=").append(str1).append(" existing=").append(paramString);
        }
        if (paramString != null) {
          break label418;
        }
        paramView = this.mContainer.instantiate(paramContext, str1, null);
        paramView.mFromLayout = true;
        if (k == 0) {
          break label411;
        }
        j = k;
        label285:
        paramView.mFragmentId = j;
        paramView.mContainerId = i;
        paramView.mTag = str2;
        paramView.mInLayout = true;
        paramView.mFragmentManager = this;
        paramView.mHost = this.mHost;
        paramView.onInflate(this.mHost.mContext, paramAttributeSet, paramView.mSavedFragmentState);
        addFragment(paramView, true);
        label344:
        if ((this.mCurState > 0) || (!paramView.mFromLayout)) {
          break label545;
        }
        moveToState(paramView, 1, 0, 0, false);
      }
      for (;;)
      {
        if (paramView.mView != null) {
          break label553;
        }
        throw new IllegalStateException("Fragment " + str1 + " did not create a view.");
        paramString = null;
        break;
        label411:
        j = i;
        break label285;
        label418:
        if (paramString.mInLayout) {
          throw new IllegalArgumentException(paramAttributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(k) + ", tag " + str2 + ", or parent id 0x" + Integer.toHexString(i) + " with another fragment for " + str1);
        }
        paramString.mInLayout = true;
        paramString.mHost = this.mHost;
        if (!paramString.mRetaining) {
          paramString.onInflate(this.mHost.mContext, paramAttributeSet, paramString.mSavedFragmentState);
        }
        paramView = paramString;
        break label344;
        label545:
        moveToState(paramView);
      }
      label553:
      if (k != 0) {
        paramView.mView.setId(k);
      }
      if (paramView.mView.getTag() == null) {
        paramView.mView.setTag(str2);
      }
      return paramView.mView;
    }
  }
  
  public final View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return onCreateView(null, paramString, paramContext, paramAttributeSet);
  }
  
  public final void performPendingDeferredStart(Fragment paramFragment)
  {
    if (paramFragment.mDeferStart)
    {
      if (this.mExecutingActions) {
        this.mHavePendingDeferredStart = true;
      }
    }
    else {
      return;
    }
    paramFragment.mDeferStart = false;
    moveToState(paramFragment, this.mCurState, 0, 0, false);
  }
  
  public final void popBackStack()
  {
    enqueueAction(new i(null, -1, 0), false);
  }
  
  public final void popBackStack(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {
      throw new IllegalArgumentException("Bad id: ".concat(String.valueOf(paramInt1)));
    }
    enqueueAction(new i(null, paramInt1, paramInt2), false);
  }
  
  public final void popBackStack(String paramString, int paramInt)
  {
    enqueueAction(new i(paramString, -1, paramInt), false);
  }
  
  public final boolean popBackStackImmediate()
  {
    checkStateLoss();
    return popBackStackImmediate(null, -1, 0);
  }
  
  public final boolean popBackStackImmediate(int paramInt1, int paramInt2)
  {
    checkStateLoss();
    execPendingActions();
    if (paramInt1 < 0) {
      throw new IllegalArgumentException("Bad id: ".concat(String.valueOf(paramInt1)));
    }
    return popBackStackImmediate(null, paramInt1, paramInt2);
  }
  
  public final boolean popBackStackImmediate(String paramString, int paramInt)
  {
    checkStateLoss();
    return popBackStackImmediate(paramString, -1, paramInt);
  }
  
  final boolean popBackStackState(ArrayList<b> paramArrayList, ArrayList<Boolean> paramArrayList1, String paramString, int paramInt1, int paramInt2)
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
        b localb;
        while (j >= 0)
        {
          localb = (b)this.mBackStack.get(j);
          if (((paramString != null) && (paramString.equals(localb.mName))) || ((paramInt1 >= 0) && (paramInt1 == localb.mIndex))) {
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
            localb = (b)this.mBackStack.get(paramInt2);
            if ((paramString == null) || (!paramString.equals(localb.mName)))
            {
              i = paramInt2;
              if (paramInt1 < 0) {
                break;
              }
              i = paramInt2;
              if (paramInt1 != localb.mIndex) {
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
  
  public final void putFragment(Bundle paramBundle, String paramString, Fragment paramFragment)
  {
    if (paramFragment.mIndex < 0) {
      throwException(new IllegalStateException("Fragment " + paramFragment + " is not currently in the FragmentManager"));
    }
    paramBundle.putInt(paramString, paramFragment.mIndex);
  }
  
  public final void registerFragmentLifecycleCallbacks(g.b paramb, boolean paramBoolean)
  {
    this.mLifecycleCallbacks.add(new f(paramb, paramBoolean));
  }
  
  public final void removeFragment(Fragment paramFragment)
  {
    if (DEBUG) {
      new StringBuilder("remove: ").append(paramFragment).append(" nesting=").append(paramFragment.mBackStackNesting);
    }
    int i;
    if (!paramFragment.isInBackStack()) {
      i = 1;
    }
    for (;;)
    {
      if ((!paramFragment.mDetached) || (i != 0)) {}
      synchronized (this.mAdded)
      {
        this.mAdded.remove(paramFragment);
        if ((paramFragment.mHasMenu) && (paramFragment.mMenuVisible)) {
          this.mNeedMenuInvalidate = true;
        }
        paramFragment.mAdded = false;
        paramFragment.mRemoving = true;
        return;
        i = 0;
      }
    }
  }
  
  public final void removeOnBackStackChangedListener(g.c paramc)
  {
    if (this.mBackStackChangeListeners != null) {
      this.mBackStackChangeListeners.remove(paramc);
    }
  }
  
  final void reportBackStackChanged()
  {
    if (this.mBackStackChangeListeners != null)
    {
      int i = 0;
      while (i < this.mBackStackChangeListeners.size())
      {
        ((g.c)this.mBackStackChangeListeners.get(i)).onBackStackChanged();
        i += 1;
      }
    }
  }
  
  final void restoreAllState(Parcelable arg1, h paramh)
  {
    if (??? == null) {}
    FragmentManagerState localFragmentManagerState;
    do
    {
      return;
      localFragmentManagerState = (FragmentManagerState)???;
    } while (localFragmentManagerState.Dd == null);
    List localList = null;
    Object localObject1;
    int i;
    int j;
    Object localObject2;
    Object localObject3;
    if (paramh != null)
    {
      localObject1 = paramh.Da;
      localList = paramh.Db;
      ??? = paramh.Dc;
      if (localObject1 != null)
      {
        i = ((List)localObject1).size();
        j = 0;
      }
      for (;;)
      {
        if (j >= i) {
          break label298;
        }
        localObject2 = (Fragment)((List)localObject1).get(j);
        if (DEBUG) {
          new StringBuilder("restoreAllState: re-attaching retained ").append(localObject2);
        }
        int k = 0;
        for (;;)
        {
          if ((k < localFragmentManagerState.Dd.length) && (localFragmentManagerState.Dd[k].mIndex != ((Fragment)localObject2).mIndex))
          {
            k += 1;
            continue;
            i = 0;
            break;
          }
        }
        if (k == localFragmentManagerState.Dd.length) {
          throwException(new IllegalStateException("Could not find active fragment with index " + ((Fragment)localObject2).mIndex));
        }
        localObject3 = localFragmentManagerState.Dd[k];
        ((FragmentState)localObject3).Dh = ((Fragment)localObject2);
        ((Fragment)localObject2).mSavedViewState = null;
        ((Fragment)localObject2).mBackStackNesting = 0;
        ((Fragment)localObject2).mInLayout = false;
        ((Fragment)localObject2).mAdded = false;
        ((Fragment)localObject2).mTarget = null;
        if (((FragmentState)localObject3).mSavedFragmentState != null)
        {
          ((FragmentState)localObject3).mSavedFragmentState.setClassLoader(this.mHost.mContext.getClassLoader());
          ((Fragment)localObject2).mSavedViewState = ((FragmentState)localObject3).mSavedFragmentState.getSparseParcelableArray("android:view_state");
          ((Fragment)localObject2).mSavedFragmentState = ((FragmentState)localObject3).mSavedFragmentState;
        }
        j += 1;
      }
    }
    for (;;)
    {
      label298:
      this.mActive = new SparseArray(localFragmentManagerState.Dd.length);
      i = 0;
      FragmentState localFragmentState;
      if (i < localFragmentManagerState.Dd.length)
      {
        localFragmentState = localFragmentManagerState.Dd[i];
        if (localFragmentState != null) {
          if ((localList == null) || (i >= localList.size())) {
            break label1267;
          }
        }
      }
      label1267:
      for (localObject1 = (h)localList.get(i);; localObject1 = null)
      {
        localObject3 = null;
        localObject2 = localObject3;
        if (??? != null)
        {
          localObject2 = localObject3;
          if (i < ???.size()) {
            localObject2 = (ViewModelStore)???.get(i);
          }
        }
        localObject3 = this.mHost;
        d locald = this.mContainer;
        Fragment localFragment = this.mParent;
        Context localContext;
        if (localFragmentState.Dh == null)
        {
          localContext = ((f)localObject3).mContext;
          if (localFragmentState.mArguments != null) {
            localFragmentState.mArguments.setClassLoader(localContext.getClassLoader());
          }
          if (locald == null) {
            break label761;
          }
        }
        label761:
        for (localFragmentState.Dh = locald.instantiate(localContext, localFragmentState.mClassName, localFragmentState.mArguments);; localFragmentState.Dh = Fragment.instantiate(localContext, localFragmentState.mClassName, localFragmentState.mArguments))
        {
          if (localFragmentState.mSavedFragmentState != null)
          {
            localFragmentState.mSavedFragmentState.setClassLoader(localContext.getClassLoader());
            localFragmentState.Dh.mSavedFragmentState = localFragmentState.mSavedFragmentState;
          }
          localFragmentState.Dh.setIndex(localFragmentState.mIndex, localFragment);
          localFragmentState.Dh.mFromLayout = localFragmentState.mFromLayout;
          localFragmentState.Dh.mRestored = true;
          localFragmentState.Dh.mFragmentId = localFragmentState.mFragmentId;
          localFragmentState.Dh.mContainerId = localFragmentState.mContainerId;
          localFragmentState.Dh.mTag = localFragmentState.mTag;
          localFragmentState.Dh.mRetainInstance = localFragmentState.mRetainInstance;
          localFragmentState.Dh.mDetached = localFragmentState.mDetached;
          localFragmentState.Dh.mHidden = localFragmentState.mHidden;
          localFragmentState.Dh.mFragmentManager = ((f)localObject3).mFragmentManager;
          if (DEBUG) {
            new StringBuilder("Instantiated fragment ").append(localFragmentState.Dh);
          }
          localFragmentState.Dh.mChildNonConfig = ((h)localObject1);
          localFragmentState.Dh.mViewModelStore = ((ViewModelStore)localObject2);
          localObject1 = localFragmentState.Dh;
          if (DEBUG) {
            new StringBuilder("restoreAllState: active #").append(i).append(": ").append(localObject1);
          }
          this.mActive.put(((Fragment)localObject1).mIndex, localObject1);
          localFragmentState.Dh = null;
          i += 1;
          break;
        }
        if (paramh != null)
        {
          ??? = paramh.Da;
          if (??? != null) {}
          for (i = ???.size();; i = 0)
          {
            j = 0;
            while (j < i)
            {
              paramh = (Fragment)???.get(j);
              if (paramh.mTargetIndex >= 0)
              {
                paramh.mTarget = ((Fragment)this.mActive.get(paramh.mTargetIndex));
                if (paramh.mTarget == null) {
                  new StringBuilder("Re-attaching retained fragment ").append(paramh).append(" target no longer exists: ").append(paramh.mTargetIndex);
                }
              }
              j += 1;
            }
          }
        }
        this.mAdded.clear();
        if (localFragmentManagerState.De != null)
        {
          i = 0;
          while (i < localFragmentManagerState.De.length)
          {
            paramh = (Fragment)this.mActive.get(localFragmentManagerState.De[i]);
            if (paramh == null) {
              throwException(new IllegalStateException("No instantiated fragment for index #" + localFragmentManagerState.De[i]));
            }
            paramh.mAdded = true;
            if (DEBUG) {
              new StringBuilder("restoreAllState: added #").append(i).append(": ").append(paramh);
            }
            if (this.mAdded.contains(paramh)) {
              throw new IllegalStateException("Already added!");
            }
            synchronized (this.mAdded)
            {
              this.mAdded.add(paramh);
              i += 1;
            }
          }
        }
        if (localFragmentManagerState.Df != null)
        {
          this.mBackStack = new ArrayList(localFragmentManagerState.Df.length);
          i = 0;
          while (i < localFragmentManagerState.Df.length)
          {
            ??? = localFragmentManagerState.Df[i].a(this);
            if (DEBUG)
            {
              new StringBuilder("restoreAllState: back stack #").append(i).append(" (index ").append(???.mIndex).append("): ").append(???);
              paramh = new PrintWriter(new android.support.v4.e.f("FragmentManager"));
              ???.a("  ", paramh, false);
              paramh.close();
            }
            this.mBackStack.add(???);
            if (???.mIndex >= 0) {
              setBackStackIndex(???.mIndex, ???);
            }
            i += 1;
          }
        }
        this.mBackStack = null;
        if (localFragmentManagerState.Dg >= 0) {
          this.mPrimaryNav = ((Fragment)this.mActive.get(localFragmentManagerState.Dg));
        }
        this.mNextFragmentIndex = localFragmentManagerState.mNextFragmentIndex;
        return;
      }
      ??? = null;
    }
  }
  
  final h retainNonConfig()
  {
    setRetaining(this.mSavedNonConfig);
    return this.mSavedNonConfig;
  }
  
  final Parcelable saveAllState()
  {
    Object localObject3 = null;
    forcePostponedTransactions();
    endAnimatingAwayFragments();
    execPendingActions();
    this.mStateSaved = true;
    this.mSavedNonConfig = null;
    if ((this.mActive == null) || (this.mActive.size() <= 0)) {
      return null;
    }
    int k = this.mActive.size();
    FragmentState[] arrayOfFragmentState = new FragmentState[k];
    int j = 0;
    int i = 0;
    label63:
    Object localObject1;
    Object localObject2;
    if (j < k)
    {
      localObject1 = (Fragment)this.mActive.valueAt(j);
      if (localObject1 == null) {
        break label689;
      }
      if (((Fragment)localObject1).mIndex < 0) {
        throwException(new IllegalStateException("Failure saving state: active " + localObject1 + " has cleared index: " + ((Fragment)localObject1).mIndex));
      }
      localObject2 = new FragmentState((Fragment)localObject1);
      arrayOfFragmentState[j] = localObject2;
      if ((((Fragment)localObject1).mState > 0) && (((FragmentState)localObject2).mSavedFragmentState == null))
      {
        ((FragmentState)localObject2).mSavedFragmentState = saveFragmentBasicState((Fragment)localObject1);
        if (((Fragment)localObject1).mTarget != null)
        {
          if (((Fragment)localObject1).mTarget.mIndex < 0) {
            throwException(new IllegalStateException("Failure saving state: " + localObject1 + " has target not in fragment manager: " + ((Fragment)localObject1).mTarget));
          }
          if (((FragmentState)localObject2).mSavedFragmentState == null) {
            ((FragmentState)localObject2).mSavedFragmentState = new Bundle();
          }
          putFragment(((FragmentState)localObject2).mSavedFragmentState, "android:target_state", ((Fragment)localObject1).mTarget);
          if (((Fragment)localObject1).mTargetRequestCode != 0) {
            ((FragmentState)localObject2).mSavedFragmentState.putInt("android:target_req_state", ((Fragment)localObject1).mTargetRequestCode);
          }
        }
        label302:
        if (DEBUG) {
          new StringBuilder("Saved state of ").append(localObject1).append(": ").append(((FragmentState)localObject2).mSavedFragmentState);
        }
        i = 1;
      }
    }
    label689:
    for (;;)
    {
      j += 1;
      break label63;
      ((FragmentState)localObject2).mSavedFragmentState = ((Fragment)localObject1).mSavedFragmentState;
      break label302;
      if (i == 0) {
        break;
      }
      j = this.mAdded.size();
      if (j > 0)
      {
        localObject2 = new int[j];
        i = 0;
        for (;;)
        {
          localObject1 = localObject2;
          if (i >= j) {
            break;
          }
          localObject2[i] = ((Fragment)this.mAdded.get(i)).mIndex;
          if (localObject2[i] < 0) {
            throwException(new IllegalStateException("Failure saving state: active " + this.mAdded.get(i) + " has cleared index: " + localObject2[i]));
          }
          if (DEBUG) {
            new StringBuilder("saveAllState: adding fragment #").append(i).append(": ").append(this.mAdded.get(i));
          }
          i += 1;
        }
      }
      localObject1 = null;
      localObject2 = localObject3;
      if (this.mBackStack != null)
      {
        j = this.mBackStack.size();
        localObject2 = localObject3;
        if (j > 0)
        {
          localObject3 = new BackStackState[j];
          i = 0;
          for (;;)
          {
            localObject2 = localObject3;
            if (i >= j) {
              break;
            }
            localObject3[i] = new BackStackState((b)this.mBackStack.get(i));
            if (DEBUG) {
              new StringBuilder("saveAllState: adding back stack #").append(i).append(": ").append(this.mBackStack.get(i));
            }
            i += 1;
          }
        }
      }
      localObject3 = new FragmentManagerState();
      ((FragmentManagerState)localObject3).Dd = arrayOfFragmentState;
      ((FragmentManagerState)localObject3).De = ((int[])localObject1);
      ((FragmentManagerState)localObject3).Df = ((BackStackState[])localObject2);
      if (this.mPrimaryNav != null) {
        ((FragmentManagerState)localObject3).Dg = this.mPrimaryNav.mIndex;
      }
      ((FragmentManagerState)localObject3).mNextFragmentIndex = this.mNextFragmentIndex;
      saveNonConfig();
      return localObject3;
    }
  }
  
  final Bundle saveFragmentBasicState(Fragment paramFragment)
  {
    if (this.mStateBundle == null) {
      this.mStateBundle = new Bundle();
    }
    paramFragment.performSaveInstanceState(this.mStateBundle);
    dispatchOnFragmentSaveInstanceState(paramFragment, this.mStateBundle, false);
    Object localObject2;
    if (!this.mStateBundle.isEmpty())
    {
      localObject2 = this.mStateBundle;
      this.mStateBundle = null;
    }
    for (;;)
    {
      if (paramFragment.mView != null) {
        saveFragmentViewState(paramFragment);
      }
      Object localObject1 = localObject2;
      if (paramFragment.mSavedViewState != null)
      {
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new Bundle();
        }
        ((Bundle)localObject1).putSparseParcelableArray("android:view_state", paramFragment.mSavedViewState);
      }
      localObject2 = localObject1;
      if (!paramFragment.mUserVisibleHint)
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new Bundle();
        }
        ((Bundle)localObject2).putBoolean("android:user_visible_hint", paramFragment.mUserVisibleHint);
      }
      return localObject2;
      localObject2 = null;
    }
  }
  
  public final Fragment.SavedState saveFragmentInstanceState(Fragment paramFragment)
  {
    Object localObject2 = null;
    if (paramFragment.mIndex < 0) {
      throwException(new IllegalStateException("Fragment " + paramFragment + " is not currently in the FragmentManager"));
    }
    Object localObject1 = localObject2;
    if (paramFragment.mState > 0)
    {
      paramFragment = saveFragmentBasicState(paramFragment);
      localObject1 = localObject2;
      if (paramFragment != null) {
        localObject1 = new Fragment.SavedState(paramFragment);
      }
    }
    return localObject1;
  }
  
  final void saveFragmentViewState(Fragment paramFragment)
  {
    if (paramFragment.mInnerView == null) {
      return;
    }
    if (this.mStateArray == null) {
      this.mStateArray = new SparseArray();
    }
    for (;;)
    {
      paramFragment.mInnerView.saveHierarchyState(this.mStateArray);
      if (this.mStateArray.size() <= 0) {
        break;
      }
      paramFragment.mSavedViewState = this.mStateArray;
      this.mStateArray = null;
      return;
      this.mStateArray.clear();
    }
  }
  
  final void saveNonConfig()
  {
    if (this.mActive != null)
    {
      int i = 0;
      Object localObject1 = null;
      Object localObject3 = null;
      Object localObject7;
      for (Object localObject2 = null;; localObject2 = localObject7)
      {
        localObject6 = localObject1;
        localObject5 = localObject3;
        localObject4 = localObject2;
        if (i >= this.mActive.size()) {
          break;
        }
        Fragment localFragment = (Fragment)this.mActive.valueAt(i);
        localObject5 = localObject1;
        localObject6 = localObject3;
        localObject7 = localObject2;
        if (localFragment != null)
        {
          localObject4 = localObject2;
          int j;
          if (localFragment.mRetainInstance)
          {
            localObject5 = localObject2;
            if (localObject2 == null) {
              localObject5 = new ArrayList();
            }
            ((ArrayList)localObject5).add(localFragment);
            if (localFragment.mTarget == null) {
              break label244;
            }
            j = localFragment.mTarget.mIndex;
            localFragment.mTargetIndex = j;
            localObject4 = localObject5;
            if (DEBUG)
            {
              new StringBuilder("retainNonConfig: keeping retained ").append(localFragment);
              localObject4 = localObject5;
            }
          }
          if (localFragment.mChildFragmentManager != null) {
            localFragment.mChildFragmentManager.saveNonConfig();
          }
          for (localObject5 = localFragment.mChildFragmentManager.mSavedNonConfig;; localObject5 = localFragment.mChildNonConfig)
          {
            localObject2 = localObject3;
            if (localObject3 != null) {
              break label259;
            }
            localObject2 = localObject3;
            if (localObject5 == null) {
              break label259;
            }
            localObject3 = new ArrayList(this.mActive.size());
            j = 0;
            for (;;)
            {
              localObject2 = localObject3;
              if (j >= i) {
                break;
              }
              ((ArrayList)localObject3).add(null);
              j += 1;
            }
            label244:
            j = -1;
            break;
          }
          label259:
          if (localObject2 != null) {
            localObject2.add(localObject5);
          }
          localObject3 = localObject1;
          if (localObject1 == null)
          {
            localObject3 = localObject1;
            if (localFragment.mViewModelStore != null)
            {
              localObject1 = new ArrayList(this.mActive.size());
              j = 0;
              for (;;)
              {
                localObject3 = localObject1;
                if (j >= i) {
                  break;
                }
                ((ArrayList)localObject1).add(null);
                j += 1;
              }
            }
          }
          localObject5 = localObject3;
          localObject6 = localObject2;
          localObject7 = localObject4;
          if (localObject3 != null)
          {
            ((ArrayList)localObject3).add(localFragment.mViewModelStore);
            localObject7 = localObject4;
            localObject6 = localObject2;
            localObject5 = localObject3;
          }
        }
        i += 1;
        localObject1 = localObject5;
        localObject3 = localObject6;
      }
    }
    Object localObject6 = null;
    Object localObject5 = null;
    Object localObject4 = null;
    if ((localObject4 == null) && (localObject5 == null) && (localObject6 == null))
    {
      this.mSavedNonConfig = null;
      return;
    }
    this.mSavedNonConfig = new h(localObject4, (List)localObject5, localObject6);
  }
  
  final void scheduleCommit()
  {
    int j = 1;
    label44:
    label73:
    label92:
    label97:
    label100:
    for (;;)
    {
      int i;
      try
      {
        if ((this.mPostponedTransactions == null) || (this.mPostponedTransactions.isEmpty())) {
          break label92;
        }
        i = 1;
        if ((this.mPendingActions == null) || (this.mPendingActions.size() != 1)) {
          break label97;
        }
      }
      finally {}
      this.mHost.mHandler.removeCallbacks(this.mExecCommit);
      this.mHost.mHandler.post(this.mExecCommit);
      return;
      for (;;)
      {
        if (i != 0) {
          break label100;
        }
        if (j == 0) {
          break label73;
        }
        break label44;
        i = 0;
        break;
        j = 0;
      }
    }
  }
  
  /* Error */
  public final void setBackStackIndex(int paramInt, b paramb)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 853	android/support/v4/app/FragmentManagerImpl:mBackStackIndices	Ljava/util/ArrayList;
    //   6: ifnonnull +14 -> 20
    //   9: aload_0
    //   10: new 170	java/util/ArrayList
    //   13: dup
    //   14: invokespecial 171	java/util/ArrayList:<init>	()V
    //   17: putfield 853	android/support/v4/app/FragmentManagerImpl:mBackStackIndices	Ljava/util/ArrayList;
    //   20: aload_0
    //   21: getfield 853	android/support/v4/app/FragmentManagerImpl:mBackStackIndices	Ljava/util/ArrayList;
    //   24: invokevirtual 201	java/util/ArrayList:size	()I
    //   27: istore 4
    //   29: iload 4
    //   31: istore_3
    //   32: iload_1
    //   33: iload 4
    //   35: if_icmpge +47 -> 82
    //   38: getstatic 142	android/support/v4/app/FragmentManagerImpl:DEBUG	Z
    //   41: ifeq +28 -> 69
    //   44: new 342	java/lang/StringBuilder
    //   47: dup
    //   48: ldc_w 855
    //   51: invokespecial 345	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   54: iload_1
    //   55: invokevirtual 858	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   58: ldc_w 860
    //   61: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: aload_2
    //   65: invokevirtual 807	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload_0
    //   70: getfield 853	android/support/v4/app/FragmentManagerImpl:mBackStackIndices	Ljava/util/ArrayList;
    //   73: iload_1
    //   74: aload_2
    //   75: invokevirtual 873	java/util/ArrayList:set	(ILjava/lang/Object;)Ljava/lang/Object;
    //   78: pop
    //   79: aload_0
    //   80: monitorexit
    //   81: return
    //   82: iload_3
    //   83: iload_1
    //   84: if_icmpge +49 -> 133
    //   87: aload_0
    //   88: getfield 853	android/support/v4/app/FragmentManagerImpl:mBackStackIndices	Ljava/util/ArrayList;
    //   91: aconst_null
    //   92: invokevirtual 698	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   95: pop
    //   96: aload_0
    //   97: getfield 851	android/support/v4/app/FragmentManagerImpl:mAvailBackStackIndices	Ljava/util/ArrayList;
    //   100: ifnonnull +14 -> 114
    //   103: aload_0
    //   104: new 170	java/util/ArrayList
    //   107: dup
    //   108: invokespecial 171	java/util/ArrayList:<init>	()V
    //   111: putfield 851	android/support/v4/app/FragmentManagerImpl:mAvailBackStackIndices	Ljava/util/ArrayList;
    //   114: aload_0
    //   115: getfield 851	android/support/v4/app/FragmentManagerImpl:mAvailBackStackIndices	Ljava/util/ArrayList;
    //   118: iload_3
    //   119: invokestatic 1241	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   122: invokevirtual 698	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   125: pop
    //   126: iload_3
    //   127: iconst_1
    //   128: iadd
    //   129: istore_3
    //   130: goto -48 -> 82
    //   133: getstatic 142	android/support/v4/app/FragmentManagerImpl:DEBUG	Z
    //   136: ifeq +28 -> 164
    //   139: new 342	java/lang/StringBuilder
    //   142: dup
    //   143: ldc_w 867
    //   146: invokespecial 345	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   149: iload_1
    //   150: invokevirtual 858	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   153: ldc_w 869
    //   156: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: aload_2
    //   160: invokevirtual 807	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   163: pop
    //   164: aload_0
    //   165: getfield 853	android/support/v4/app/FragmentManagerImpl:mBackStackIndices	Ljava/util/ArrayList;
    //   168: aload_2
    //   169: invokevirtual 698	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   172: pop
    //   173: goto -94 -> 79
    //   176: astore_2
    //   177: aload_0
    //   178: monitorexit
    //   179: aload_2
    //   180: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	181	0	this	FragmentManagerImpl
    //   0	181	1	paramInt	int
    //   0	181	2	paramb	b
    //   31	99	3	i	int
    //   27	9	4	j	int
    // Exception table:
    //   from	to	target	type
    //   2	20	176	finally
    //   20	29	176	finally
    //   38	69	176	finally
    //   69	79	176	finally
    //   79	81	176	finally
    //   87	114	176	finally
    //   114	126	176	finally
    //   133	164	176	finally
    //   164	173	176	finally
    //   177	179	176	finally
  }
  
  public final void setPrimaryNavigationFragment(Fragment paramFragment)
  {
    if ((paramFragment != null) && ((this.mActive.get(paramFragment.mIndex) != paramFragment) || ((paramFragment.mHost != null) && (paramFragment.getFragmentManager() != this)))) {
      throw new IllegalArgumentException("Fragment " + paramFragment + " is not an active fragment of FragmentManager " + this);
    }
    this.mPrimaryNav = paramFragment;
  }
  
  public final void showFragment(Fragment paramFragment)
  {
    boolean bool = false;
    if (DEBUG) {
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
  
  final void startPendingDeferredFragments()
  {
    if (this.mActive == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.mActive.size())
      {
        Fragment localFragment = (Fragment)this.mActive.valueAt(i);
        if (localFragment != null) {
          performPendingDeferredStart(localFragment);
        }
        i += 1;
      }
    }
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("FragmentManager{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" in ");
    if (this.mParent != null) {
      e.a(this.mParent, localStringBuilder);
    }
    for (;;)
    {
      localStringBuilder.append("}}");
      return localStringBuilder.toString();
      e.a(this.mHost, localStringBuilder);
    }
  }
  
  public final void unregisterFragmentLifecycleCallbacks(g.b paramb)
  {
    for (;;)
    {
      int i;
      synchronized (this.mLifecycleCallbacks)
      {
        int j = this.mLifecycleCallbacks.size();
        i = 0;
        if (i < j)
        {
          if (((f)this.mLifecycleCallbacks.get(i)).CT == paramb) {
            this.mLifecycleCallbacks.remove(i);
          }
        }
        else {
          return;
        }
      }
      i += 1;
    }
  }
  
  static final class a
    extends FragmentManagerImpl.b
  {
    View mView;
    
    a(View paramView, Animation.AnimationListener paramAnimationListener)
    {
      super();
      this.mView = paramView;
    }
    
    public final void onAnimationEnd(Animation paramAnimation)
    {
      if ((t.aC(this.mView)) || (Build.VERSION.SDK_INT >= 24)) {
        this.mView.post(new Runnable()
        {
          public final void run()
          {
            FragmentManagerImpl.a.this.mView.setLayerType(0, null);
          }
        });
      }
      for (;;)
      {
        super.onAnimationEnd(paramAnimation);
        return;
        this.mView.setLayerType(0, null);
      }
    }
  }
  
  static class b
    implements Animation.AnimationListener
  {
    private final Animation.AnimationListener CM;
    
    b(Animation.AnimationListener paramAnimationListener)
    {
      this.CM = paramAnimationListener;
    }
    
    public void onAnimationEnd(Animation paramAnimation)
    {
      if (this.CM != null) {
        this.CM.onAnimationEnd(paramAnimation);
      }
    }
    
    public void onAnimationRepeat(Animation paramAnimation)
    {
      if (this.CM != null) {
        this.CM.onAnimationRepeat(paramAnimation);
      }
    }
    
    public void onAnimationStart(Animation paramAnimation)
    {
      if (this.CM != null) {
        this.CM.onAnimationStart(paramAnimation);
      }
    }
  }
  
  static final class c
  {
    public final Animation CN;
    public final Animator CO;
    
    c(Animator paramAnimator)
    {
      this.CN = null;
      this.CO = paramAnimator;
      if (paramAnimator == null) {
        throw new IllegalStateException("Animator cannot be null");
      }
    }
    
    c(Animation paramAnimation)
    {
      this.CN = paramAnimation;
      this.CO = null;
      if (paramAnimation == null) {
        throw new IllegalStateException("Animation cannot be null");
      }
    }
  }
  
  static final class d
    extends AnimatorListenerAdapter
  {
    View mView;
    
    d(View paramView)
    {
      this.mView = paramView;
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      this.mView.setLayerType(0, null);
      paramAnimator.removeListener(this);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      this.mView.setLayerType(2, null);
    }
  }
  
  static final class e
    extends AnimationSet
    implements Runnable
  {
    private final ViewGroup Bf;
    private final View CQ;
    private boolean CR;
    private boolean CS = true;
    private boolean zF;
    
    e(Animation paramAnimation, ViewGroup paramViewGroup, View paramView)
    {
      super();
      this.Bf = paramViewGroup;
      this.CQ = paramView;
      addAnimation(paramAnimation);
      this.Bf.post(this);
    }
    
    public final boolean getTransformation(long paramLong, Transformation paramTransformation)
    {
      this.CS = true;
      if (this.zF) {
        if (this.CR) {}
      }
      while (super.getTransformation(paramLong, paramTransformation))
      {
        return true;
        return false;
      }
      this.zF = true;
      w.a(this.Bf, this);
      return true;
    }
    
    public final boolean getTransformation(long paramLong, Transformation paramTransformation, float paramFloat)
    {
      this.CS = true;
      if (this.zF) {
        if (this.CR) {}
      }
      while (super.getTransformation(paramLong, paramTransformation, paramFloat))
      {
        return true;
        return false;
      }
      this.zF = true;
      w.a(this.Bf, this);
      return true;
    }
    
    public final void run()
    {
      if ((!this.zF) && (this.CS))
      {
        this.CS = false;
        this.Bf.post(this);
        return;
      }
      this.Bf.endViewTransition(this.CQ);
      this.CR = true;
    }
  }
  
  static final class f
  {
    final g.b CT;
    final boolean CU;
    
    f(g.b paramb, boolean paramBoolean)
    {
      this.CT = paramb;
      this.CU = paramBoolean;
    }
  }
  
  static final class g
  {
    public static final int[] CV = { 16842755, 16842960, 16842961 };
  }
  
  static abstract interface h
  {
    public abstract boolean a(ArrayList<b> paramArrayList, ArrayList<Boolean> paramArrayList1);
  }
  
  final class i
    implements FragmentManagerImpl.h
  {
    final int CW;
    final int mId;
    final String mName;
    
    i(String paramString, int paramInt1, int paramInt2)
    {
      this.mName = paramString;
      this.mId = paramInt1;
      this.CW = paramInt2;
    }
    
    public final boolean a(ArrayList<b> paramArrayList, ArrayList<Boolean> paramArrayList1)
    {
      if ((FragmentManagerImpl.this.mPrimaryNav != null) && (this.mId < 0) && (this.mName == null))
      {
        g localg = FragmentManagerImpl.this.mPrimaryNav.peekChildFragmentManager();
        if ((localg != null) && (localg.popBackStackImmediate())) {
          return false;
        }
      }
      return FragmentManagerImpl.this.popBackStackState(paramArrayList, paramArrayList1, this.mName, this.mId, this.CW);
    }
  }
  
  static final class j
    implements Fragment.c
  {
    final boolean CX;
    final b CY;
    int CZ;
    
    j(b paramb, boolean paramBoolean)
    {
      this.CX = paramBoolean;
      this.CY = paramb;
    }
    
    public final void dD()
    {
      this.CZ -= 1;
      if (this.CZ != 0) {
        return;
      }
      this.CY.BE.scheduleCommit();
    }
    
    public final void dG()
    {
      boolean bool1 = false;
      if (this.CZ > 0) {}
      for (int i = 1;; i = 0)
      {
        localFragmentManagerImpl = this.CY.BE;
        int k = localFragmentManagerImpl.mAdded.size();
        int j = 0;
        while (j < k)
        {
          localObject = (Fragment)localFragmentManagerImpl.mAdded.get(j);
          ((Fragment)localObject).setOnStartEnterTransitionListener(null);
          if ((i != 0) && (((Fragment)localObject).isPostponed())) {
            ((Fragment)localObject).startPostponedEnterTransition();
          }
          j += 1;
        }
      }
      FragmentManagerImpl localFragmentManagerImpl = this.CY.BE;
      Object localObject = this.CY;
      boolean bool2 = this.CX;
      if (i == 0) {
        bool1 = true;
      }
      localFragmentManagerImpl.completeExecute((b)localObject, bool2, bool1, true);
    }
    
    public final void dH()
    {
      this.CY.BE.completeExecute(this.CY, this.CX, false, false);
    }
    
    public final void startListening()
    {
      this.CZ += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.app.FragmentManagerImpl
 * JD-Core Version:    0.7.0.1
 */