package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
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
import androidx.core.f.c;
import androidx.core.g.w;
import androidx.lifecycle.aa;
import androidx.lifecycle.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
  extends e
  implements LayoutInflater.Factory2
{
  static final Interpolator ACCELERATE_CUBIC;
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
  static Field sAnimationListenerField;
  SparseArray<Fragment> mActive;
  final ArrayList<Fragment> mAdded;
  ArrayList<Integer> mAvailBackStackIndices;
  ArrayList<a> mBackStack;
  ArrayList<e.c> mBackStackChangeListeners;
  ArrayList<a> mBackStackIndices;
  b mContainer;
  ArrayList<Fragment> mCreatedMenus;
  int mCurState;
  boolean mDestroyed;
  Runnable mExecCommit;
  boolean mExecutingActions;
  boolean mHavePendingDeferredStart;
  d mHost;
  private final CopyOnWriteArrayList<f> mLifecycleCallbacks;
  boolean mNeedMenuInvalidate;
  int mNextFragmentIndex;
  String mNoTransactionsBecause;
  Fragment mParent;
  ArrayList<h> mPendingActions;
  ArrayList<j> mPostponedTransactions;
  Fragment mPrimaryNav;
  f mSavedNonConfig;
  SparseArray<Parcelable> mStateArray;
  Bundle mStateBundle;
  boolean mStateSaved;
  boolean mStopped;
  ArrayList<Fragment> mTmpAddedFragments;
  ArrayList<Boolean> mTmpIsPop;
  ArrayList<a> mTmpRecords;
  
  static
  {
    AppMethodBeat.i(212822);
    DEBUG = false;
    sAnimationListenerField = null;
    DECELERATE_QUINT = new DecelerateInterpolator(2.5F);
    DECELERATE_CUBIC = new DecelerateInterpolator(1.5F);
    ACCELERATE_QUINT = new AccelerateInterpolator(2.5F);
    ACCELERATE_CUBIC = new AccelerateInterpolator(1.5F);
    AppMethodBeat.o(212822);
  }
  
  FragmentManagerImpl()
  {
    AppMethodBeat.i(212557);
    this.mNextFragmentIndex = 0;
    this.mAdded = new ArrayList();
    this.mLifecycleCallbacks = new CopyOnWriteArrayList();
    this.mCurState = 0;
    this.mStateBundle = null;
    this.mStateArray = null;
    this.mExecCommit = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(212452);
        FragmentManagerImpl.this.execPendingActions();
        AppMethodBeat.o(212452);
      }
    };
    AppMethodBeat.o(212557);
  }
  
  private void addAddedFragments(androidx.b.b<Fragment> paramb)
  {
    AppMethodBeat.i(212728);
    if (this.mCurState <= 0)
    {
      AppMethodBeat.o(212728);
      return;
    }
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
    AppMethodBeat.o(212728);
  }
  
  private void animateRemoveFragment(final Fragment paramFragment, c paramc, int paramInt)
  {
    AppMethodBeat.i(212654);
    final View localView = paramFragment.mView;
    final ViewGroup localViewGroup = paramFragment.mContainer;
    localViewGroup.startViewTransition(localView);
    paramFragment.setStateAfterAnimating(paramInt);
    if (paramc.VT != null)
    {
      localObject = new e(paramc.VT, localViewGroup, localView);
      paramFragment.setAnimatingAway(paramFragment.mView);
      ((Animation)localObject).setAnimationListener(new FragmentManagerImpl.b(getAnimationListener((Animation)localObject))
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(212456);
          super.onAnimationEnd(paramAnonymousAnimation);
          localViewGroup.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(212453);
              if (FragmentManagerImpl.2.this.val$fragment.getAnimatingAway() != null)
              {
                FragmentManagerImpl.2.this.val$fragment.setAnimatingAway(null);
                FragmentManagerImpl.this.moveToState(FragmentManagerImpl.2.this.val$fragment, FragmentManagerImpl.2.this.val$fragment.getStateAfterAnimating(), 0, 0, false);
              }
              AppMethodBeat.o(212453);
            }
          });
          AppMethodBeat.o(212456);
        }
      });
      setHWLayerAnimListenerIfAlpha(localView, paramc);
      paramFragment.mView.startAnimation((Animation)localObject);
      AppMethodBeat.o(212654);
      return;
    }
    Object localObject = paramc.VU;
    paramFragment.setAnimator(paramc.VU);
    ((Animator)localObject).addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(212459);
        localViewGroup.endViewTransition(localView);
        paramAnonymousAnimator = paramFragment.getAnimator();
        paramFragment.setAnimator(null);
        if ((paramAnonymousAnimator != null) && (localViewGroup.indexOfChild(localView) < 0)) {
          FragmentManagerImpl.this.moveToState(paramFragment, paramFragment.getStateAfterAnimating(), 0, 0, false);
        }
        AppMethodBeat.o(212459);
      }
    });
    ((Animator)localObject).setTarget(paramFragment.mView);
    setHWLayerAnimListenerIfAlpha(paramFragment.mView, paramc);
    ((Animator)localObject).start();
    AppMethodBeat.o(212654);
  }
  
  private void burpActive()
  {
    AppMethodBeat.i(212756);
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
    AppMethodBeat.o(212756);
  }
  
  private void checkStateLoss()
  {
    AppMethodBeat.i(212697);
    IllegalStateException localIllegalStateException;
    if (isStateSaved())
    {
      localIllegalStateException = new IllegalStateException("Can not perform this action after onSaveInstanceState");
      AppMethodBeat.o(212697);
      throw localIllegalStateException;
    }
    if (this.mNoTransactionsBecause != null)
    {
      localIllegalStateException = new IllegalStateException("Can not perform this action inside of " + this.mNoTransactionsBecause);
      AppMethodBeat.o(212697);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(212697);
  }
  
  private void cleanupExec()
  {
    AppMethodBeat.i(212712);
    this.mExecutingActions = false;
    this.mTmpIsPop.clear();
    this.mTmpRecords.clear();
    AppMethodBeat.o(212712);
  }
  
  private void dispatchStateChange(int paramInt)
  {
    AppMethodBeat.i(212769);
    try
    {
      this.mExecutingActions = true;
      moveToState(paramInt, false);
      this.mExecutingActions = false;
      execPendingActions();
      AppMethodBeat.o(212769);
      return;
    }
    finally
    {
      this.mExecutingActions = false;
      AppMethodBeat.o(212769);
    }
  }
  
  private void endAnimatingAwayFragments()
  {
    AppMethodBeat.i(212731);
    int i;
    int j;
    label17:
    Fragment localFragment;
    if (this.mActive == null)
    {
      i = 0;
      j = 0;
      if (j >= i) {
        break label136;
      }
      localFragment = (Fragment)this.mActive.valueAt(j);
      if (localFragment != null)
      {
        if (localFragment.getAnimatingAway() == null) {
          break label117;
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
      break label17;
      i = this.mActive.size();
      break;
      label117:
      if (localFragment.getAnimator() != null) {
        localFragment.getAnimator().end();
      }
    }
    label136:
    AppMethodBeat.o(212731);
  }
  
  private void ensureExecReady(boolean paramBoolean)
  {
    AppMethodBeat.i(212710);
    IllegalStateException localIllegalStateException;
    if (this.mExecutingActions)
    {
      localIllegalStateException = new IllegalStateException("FragmentManager is already executing transactions");
      AppMethodBeat.o(212710);
      throw localIllegalStateException;
    }
    if (this.mHost == null)
    {
      localIllegalStateException = new IllegalStateException("Fragment host has been destroyed");
      AppMethodBeat.o(212710);
      throw localIllegalStateException;
    }
    if (Looper.myLooper() != this.mHost.mHandler.getLooper())
    {
      localIllegalStateException = new IllegalStateException("Must be called from main thread of fragment host");
      AppMethodBeat.o(212710);
      throw localIllegalStateException;
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
      AppMethodBeat.o(212710);
    }
  }
  
  private static void executeOps(ArrayList<a> paramArrayList, ArrayList<Boolean> paramArrayList1, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(212726);
    if (paramInt1 < paramInt2)
    {
      a locala = (a)paramArrayList.get(paramInt1);
      boolean bool;
      if (((Boolean)paramArrayList1.get(paramInt1)).booleanValue())
      {
        locala.bX(-1);
        if (paramInt1 == paramInt2 - 1)
        {
          bool = true;
          label51:
          locala.ah(bool);
        }
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        bool = false;
        break label51;
        locala.bX(1);
        locala.is();
      }
    }
    AppMethodBeat.o(212726);
  }
  
  private void executeOpsTogether(ArrayList<a> paramArrayList, ArrayList<Boolean> paramArrayList1, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(212718);
    boolean bool = ((a)paramArrayList.get(paramInt1)).Vf;
    Object localObject;
    int j;
    label61:
    a locala;
    if (this.mTmpAddedFragments == null)
    {
      this.mTmpAddedFragments = new ArrayList();
      this.mTmpAddedFragments.addAll(this.mAdded);
      localObject = getPrimaryNavigationFragment();
      j = paramInt1;
      i = 0;
      if (j >= paramInt2) {
        break label164;
      }
      locala = (a)paramArrayList.get(j);
      if (((Boolean)paramArrayList1.get(j)).booleanValue()) {
        break label142;
      }
      localObject = locala.a(this.mTmpAddedFragments, (Fragment)localObject);
      label107:
      if ((i == 0) && (!locala.UW)) {
        break label158;
      }
    }
    label142:
    label158:
    for (int i = 1;; i = 0)
    {
      j += 1;
      break label61;
      this.mTmpAddedFragments.clear();
      break;
      localObject = locala.b(this.mTmpAddedFragments, (Fragment)localObject);
      break label107;
    }
    label164:
    this.mTmpAddedFragments.clear();
    if (!bool) {
      j.a(this, paramArrayList, paramArrayList1, paramInt1, paramInt2, false);
    }
    executeOps(paramArrayList, paramArrayList1, paramInt1, paramInt2);
    if (bool)
    {
      localObject = new androidx.b.b();
      addAddedFragments((androidx.b.b)localObject);
      j = postponePostponableTransactions(paramArrayList, paramArrayList1, paramInt1, paramInt2, (androidx.b.b)localObject);
      makeRemovedFragmentsInvisible((androidx.b.b)localObject);
    }
    for (;;)
    {
      int k = paramInt1;
      if (j != paramInt1)
      {
        k = paramInt1;
        if (bool)
        {
          j.a(this, paramArrayList, paramArrayList1, paramInt1, j, true);
          moveToState(this.mCurState, true);
          k = paramInt1;
        }
      }
      while (k < paramInt2)
      {
        localObject = (a)paramArrayList.get(k);
        if ((((Boolean)paramArrayList1.get(k)).booleanValue()) && (((a)localObject).mIndex >= 0))
        {
          freeBackStackIndex(((a)localObject).mIndex);
          ((a)localObject).mIndex = -1;
        }
        ((a)localObject).im();
        k += 1;
      }
      if (i != 0) {
        reportBackStackChanged();
      }
      AppMethodBeat.o(212718);
      return;
      j = paramInt2;
    }
  }
  
  private void executePostponedTransaction(ArrayList<a> paramArrayList, ArrayList<Boolean> paramArrayList1)
  {
    AppMethodBeat.i(212716);
    int i;
    int j;
    label18:
    j localj;
    int k;
    if (this.mPostponedTransactions == null)
    {
      i = 0;
      j = 0;
      if (j >= i) {
        break label256;
      }
      localj = (j)this.mPostponedTransactions.get(j);
      if ((paramArrayList == null) || (localj.Wc)) {
        break label107;
      }
      k = paramArrayList.indexOf(localj.Wd);
      if ((k == -1) || (!((Boolean)paramArrayList1.get(k)).booleanValue())) {
        break label107;
      }
      localj.iD();
    }
    for (;;)
    {
      j += 1;
      break label18;
      i = this.mPostponedTransactions.size();
      break;
      label107:
      if (localj.We == 0) {}
      int m;
      for (k = 1;; k = 0)
      {
        if (k == 0)
        {
          m = j;
          k = i;
          if (paramArrayList == null) {
            break label246;
          }
          m = j;
          k = i;
          if (!localj.Wd.a(paramArrayList, 0, paramArrayList.size())) {
            break label246;
          }
        }
        this.mPostponedTransactions.remove(j);
        m = j - 1;
        k = i - 1;
        if ((paramArrayList == null) || (localj.Wc)) {
          break label241;
        }
        i = paramArrayList.indexOf(localj.Wd);
        if ((i == -1) || (!((Boolean)paramArrayList1.get(i)).booleanValue())) {
          break label241;
        }
        localj.iD();
        j = m;
        i = k;
        break;
      }
      label241:
      localj.iC();
      label246:
      j = m;
      i = k;
    }
    label256:
    AppMethodBeat.o(212716);
  }
  
  private Fragment findFragmentUnder(Fragment paramFragment)
  {
    AppMethodBeat.i(212724);
    ViewGroup localViewGroup = paramFragment.mContainer;
    View localView = paramFragment.mView;
    if ((localViewGroup == null) || (localView == null))
    {
      AppMethodBeat.o(212724);
      return null;
    }
    int i = this.mAdded.indexOf(paramFragment) - 1;
    while (i >= 0)
    {
      paramFragment = (Fragment)this.mAdded.get(i);
      if ((paramFragment.mContainer == localViewGroup) && (paramFragment.mView != null))
      {
        AppMethodBeat.o(212724);
        return paramFragment;
      }
      i -= 1;
    }
    AppMethodBeat.o(212724);
    return null;
  }
  
  private void forcePostponedTransactions()
  {
    AppMethodBeat.i(212730);
    if (this.mPostponedTransactions != null) {
      while (!this.mPostponedTransactions.isEmpty()) {
        ((j)this.mPostponedTransactions.remove(0)).iC();
      }
    }
    AppMethodBeat.o(212730);
  }
  
  private boolean generateOpsForPendingActions(ArrayList<a> paramArrayList, ArrayList<Boolean> paramArrayList1)
  {
    AppMethodBeat.i(212733);
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
    finally
    {
      AppMethodBeat.o(212733);
    }
  }
  
  private static Animation.AnimationListener getAnimationListener(Animation paramAnimation)
  {
    AppMethodBeat.i(212646);
    try
    {
      if (sAnimationListenerField == null)
      {
        Field localField = Animation.class.getDeclaredField("mListener");
        sAnimationListenerField = localField;
        localField.setAccessible(true);
      }
      paramAnimation = (Animation.AnimationListener)sAnimationListenerField.get(paramAnimation);
    }
    catch (NoSuchFieldException paramAnimation)
    {
      for (;;)
      {
        paramAnimation = null;
      }
    }
    catch (IllegalAccessException paramAnimation)
    {
      for (;;)
      {
        paramAnimation = null;
      }
    }
    AppMethodBeat.o(212646);
    return paramAnimation;
  }
  
  static c makeFadeAnimation(Context paramContext, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(212634);
    paramContext = new AlphaAnimation(paramFloat1, paramFloat2);
    paramContext.setInterpolator(DECELERATE_CUBIC);
    paramContext.setDuration(220L);
    paramContext = new c(paramContext);
    AppMethodBeat.o(212634);
    return paramContext;
  }
  
  static c makeOpenCloseAnimation(Context paramContext, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(212633);
    paramContext = new AnimationSet(false);
    Object localObject = new ScaleAnimation(paramFloat1, paramFloat2, paramFloat1, paramFloat2, 1, 0.5F, 1, 0.5F);
    ((ScaleAnimation)localObject).setInterpolator(DECELERATE_QUINT);
    ((ScaleAnimation)localObject).setDuration(220L);
    paramContext.addAnimation((Animation)localObject);
    localObject = new AlphaAnimation(paramFloat3, paramFloat4);
    ((AlphaAnimation)localObject).setInterpolator(DECELERATE_CUBIC);
    ((AlphaAnimation)localObject).setDuration(220L);
    paramContext.addAnimation((Animation)localObject);
    paramContext = new c(paramContext);
    AppMethodBeat.o(212633);
    return paramContext;
  }
  
  private void makeRemovedFragmentsInvisible(androidx.b.b<Fragment> paramb)
  {
    AppMethodBeat.i(212719);
    int j = paramb.size();
    int i = 0;
    while (i < j)
    {
      Fragment localFragment = (Fragment)paramb.zD[i];
      if (!localFragment.mAdded)
      {
        View localView = localFragment.getView();
        localFragment.mPostponedAlpha = localView.getAlpha();
        localView.setAlpha(0.0F);
      }
      i += 1;
    }
    AppMethodBeat.o(212719);
  }
  
  static boolean modifiesAlpha(Animator paramAnimator)
  {
    AppMethodBeat.i(212561);
    if (paramAnimator == null)
    {
      AppMethodBeat.o(212561);
      return false;
    }
    int i;
    if ((paramAnimator instanceof ValueAnimator))
    {
      paramAnimator = ((ValueAnimator)paramAnimator).getValues();
      i = 0;
      while (i < paramAnimator.length)
      {
        if ("alpha".equals(paramAnimator[i].getPropertyName()))
        {
          AppMethodBeat.o(212561);
          return true;
        }
        i += 1;
      }
    }
    if ((paramAnimator instanceof AnimatorSet))
    {
      paramAnimator = ((AnimatorSet)paramAnimator).getChildAnimations();
      i = 0;
      while (i < paramAnimator.size())
      {
        if (modifiesAlpha((Animator)paramAnimator.get(i)))
        {
          AppMethodBeat.o(212561);
          return true;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(212561);
    return false;
  }
  
  static boolean modifiesAlpha(c paramc)
  {
    AppMethodBeat.i(212559);
    if ((paramc.VT instanceof AlphaAnimation))
    {
      AppMethodBeat.o(212559);
      return true;
    }
    if ((paramc.VT instanceof AnimationSet))
    {
      paramc = ((AnimationSet)paramc.VT).getAnimations();
      int i = 0;
      while (i < paramc.size())
      {
        if ((paramc.get(i) instanceof AlphaAnimation))
        {
          AppMethodBeat.o(212559);
          return true;
        }
        i += 1;
      }
      AppMethodBeat.o(212559);
      return false;
    }
    boolean bool = modifiesAlpha(paramc.VU);
    AppMethodBeat.o(212559);
    return bool;
  }
  
  private boolean popBackStackImmediate(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(212587);
    execPendingActions();
    ensureExecReady(true);
    if ((this.mPrimaryNav != null) && (paramInt1 < 0) && (paramString == null))
    {
      e locale = this.mPrimaryNav.peekChildFragmentManager();
      if ((locale != null) && (locale.popBackStackImmediate()))
      {
        AppMethodBeat.o(212587);
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
      AppMethodBeat.o(212587);
    }
  }
  
  private int postponePostponableTransactions(ArrayList<a> paramArrayList, ArrayList<Boolean> paramArrayList1, int paramInt1, int paramInt2, androidx.b.b<Fragment> paramb)
  {
    AppMethodBeat.i(212721);
    int j = paramInt2 - 1;
    int i = paramInt2;
    a locala;
    int k;
    label171:
    if (j >= paramInt1)
    {
      locala = (a)paramArrayList.get(j);
      boolean bool = ((Boolean)paramArrayList1.get(j)).booleanValue();
      k = 0;
      label50:
      if (k < locala.UO.size()) {
        if (a.b((a.a)locala.UO.get(k)))
        {
          k = 1;
          label85:
          if ((k == 0) || (locala.a(paramArrayList, j + 1, paramInt2))) {
            break label229;
          }
          k = 1;
          label108:
          if (k == 0) {
            break label253;
          }
          if (this.mPostponedTransactions == null) {
            this.mPostponedTransactions = new ArrayList();
          }
          j localj = new j(locala, bool);
          this.mPostponedTransactions.add(localj);
          locala.a(localj);
          if (!bool) {
            break label235;
          }
          locala.is();
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
    label229:
    label235:
    label253:
    for (;;)
    {
      j -= 1;
      break;
      k += 1;
      break label50;
      k = 0;
      break label85;
      k = 0;
      break label108;
      locala.ah(false);
      break label171;
      AppMethodBeat.o(212721);
      return i;
    }
  }
  
  private void removeRedundantOperationsAndExecute(ArrayList<a> paramArrayList, ArrayList<Boolean> paramArrayList1)
  {
    AppMethodBeat.i(212717);
    if ((paramArrayList == null) || (paramArrayList.isEmpty()))
    {
      AppMethodBeat.o(212717);
      return;
    }
    if ((paramArrayList1 == null) || (paramArrayList.size() != paramArrayList1.size()))
    {
      paramArrayList = new IllegalStateException("Internal error with the back stack records");
      AppMethodBeat.o(212717);
      throw paramArrayList;
    }
    executePostponedTransaction(paramArrayList, paramArrayList1);
    int m = paramArrayList.size();
    int i = 0;
    int j = 0;
    int k;
    if (i < m)
    {
      if (((a)paramArrayList.get(i)).Vf) {
        break label248;
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
          if (((a)paramArrayList.get(k)).Vf) {
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
      break;
      if (j != m) {
        executeOpsTogether(paramArrayList, paramArrayList1, j, m);
      }
      AppMethodBeat.o(212717);
      return;
      label248:
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
    AppMethodBeat.i(212642);
    if ((paramView == null) || (paramc == null))
    {
      AppMethodBeat.o(212642);
      return;
    }
    if (shouldRunOnHWLayer(paramView, paramc))
    {
      if (paramc.VU != null)
      {
        paramc.VU.addListener(new FragmentManagerImpl.d(paramView));
        AppMethodBeat.o(212642);
        return;
      }
      Animation.AnimationListener localAnimationListener = getAnimationListener(paramc.VT);
      paramView.setLayerType(2, null);
      paramc.VT.setAnimationListener(new FragmentManagerImpl.a(paramView, localAnimationListener));
    }
    AppMethodBeat.o(212642);
  }
  
  private static void setRetaining(f paramf)
  {
    AppMethodBeat.i(212743);
    if (paramf == null)
    {
      AppMethodBeat.o(212743);
      return;
    }
    Object localObject = paramf.Wf;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Fragment)((Iterator)localObject).next()).mRetaining = true;
      }
    }
    paramf = paramf.Wg;
    if (paramf != null)
    {
      paramf = paramf.iterator();
      while (paramf.hasNext()) {
        setRetaining((f)paramf.next());
      }
    }
    AppMethodBeat.o(212743);
  }
  
  static boolean shouldRunOnHWLayer(View paramView, c paramc)
  {
    AppMethodBeat.i(212563);
    if ((paramView == null) || (paramc == null))
    {
      AppMethodBeat.o(212563);
      return false;
    }
    if ((Build.VERSION.SDK_INT >= 19) && (paramView.getLayerType() == 0) && (w.aa(paramView)) && (modifiesAlpha(paramc)))
    {
      AppMethodBeat.o(212563);
      return true;
    }
    AppMethodBeat.o(212563);
    return false;
  }
  
  private void throwException(RuntimeException paramRuntimeException)
  {
    AppMethodBeat.i(212566);
    paramRuntimeException.getMessage();
    PrintWriter localPrintWriter = new PrintWriter(new c("FragmentManager"));
    if (this.mHost != null) {}
    try
    {
      this.mHost.a("  ", localPrintWriter, new String[0]);
      for (;;)
      {
        label50:
        AppMethodBeat.o(212566);
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
      break label50;
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
  
  final void addBackStackState(a parama)
  {
    AppMethodBeat.i(212738);
    if (this.mBackStack == null) {
      this.mBackStack = new ArrayList();
    }
    this.mBackStack.add(parama);
    AppMethodBeat.o(212738);
  }
  
  public final void addFragment(Fragment paramFragment, boolean paramBoolean)
  {
    AppMethodBeat.i(212676);
    if (DEBUG) {
      new StringBuilder("add: ").append(paramFragment);
    }
    makeActive(paramFragment);
    if (!paramFragment.mDetached) {
      if (this.mAdded.contains(paramFragment))
      {
        paramFragment = new IllegalStateException("Fragment already added: ".concat(String.valueOf(paramFragment)));
        AppMethodBeat.o(212676);
        throw paramFragment;
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
      AppMethodBeat.o(212676);
      return;
    }
  }
  
  public final void addOnBackStackChangedListener(e.c paramc)
  {
    AppMethodBeat.i(212596);
    if (this.mBackStackChangeListeners == null) {
      this.mBackStackChangeListeners = new ArrayList();
    }
    this.mBackStackChangeListeners.add(paramc);
    AppMethodBeat.o(212596);
  }
  
  public final int allocBackStackIndex(a parama)
  {
    AppMethodBeat.i(212704);
    try
    {
      if ((this.mAvailBackStackIndices == null) || (this.mAvailBackStackIndices.size() <= 0))
      {
        if (this.mBackStackIndices == null) {
          this.mBackStackIndices = new ArrayList();
        }
        i = this.mBackStackIndices.size();
        if (DEBUG) {
          new StringBuilder("Setting back stack index ").append(i).append(" to ").append(parama);
        }
        this.mBackStackIndices.add(parama);
        return i;
      }
      int i = ((Integer)this.mAvailBackStackIndices.remove(this.mAvailBackStackIndices.size() - 1)).intValue();
      if (DEBUG) {
        new StringBuilder("Adding back stack index ").append(i).append(" with ").append(parama);
      }
      this.mBackStackIndices.set(i, parama);
      return i;
    }
    finally
    {
      AppMethodBeat.o(212704);
    }
  }
  
  public final void attachController(d paramd, b paramb, Fragment paramFragment)
  {
    AppMethodBeat.i(212757);
    if (this.mHost != null)
    {
      paramd = new IllegalStateException("Already attached");
      AppMethodBeat.o(212757);
      throw paramd;
    }
    this.mHost = paramd;
    this.mContainer = paramb;
    this.mParent = paramFragment;
    AppMethodBeat.o(212757);
  }
  
  public final void attachFragment(Fragment paramFragment)
  {
    AppMethodBeat.i(212689);
    if (DEBUG) {
      new StringBuilder("attach: ").append(paramFragment);
    }
    if (paramFragment.mDetached)
    {
      paramFragment.mDetached = false;
      if (!paramFragment.mAdded)
      {
        if (this.mAdded.contains(paramFragment))
        {
          paramFragment = new IllegalStateException("Fragment already added: ".concat(String.valueOf(paramFragment)));
          AppMethodBeat.o(212689);
          throw paramFragment;
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
      AppMethodBeat.o(212689);
      return;
    }
  }
  
  public final i beginTransaction()
  {
    AppMethodBeat.i(212568);
    a locala = new a(this);
    AppMethodBeat.o(212568);
    return locala;
  }
  
  final void completeExecute(a parama, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(212722);
    Object localObject;
    int i;
    if (paramBoolean1)
    {
      parama.ah(paramBoolean3);
      localObject = new ArrayList(1);
      ArrayList localArrayList = new ArrayList(1);
      ((ArrayList)localObject).add(parama);
      localArrayList.add(Boolean.valueOf(paramBoolean1));
      if (paramBoolean2) {
        j.a(this, (ArrayList)localObject, localArrayList, 0, 1, true);
      }
      if (paramBoolean3) {
        moveToState(this.mCurState, true);
      }
      if (this.mActive == null) {
        break label222;
      }
      int j = this.mActive.size();
      i = 0;
      label101:
      if (i >= j) {
        break label222;
      }
      localObject = (Fragment)this.mActive.valueAt(i);
      if ((localObject != null) && (((Fragment)localObject).mView != null) && (((Fragment)localObject).mIsNewlyAdded) && (parama.bY(((Fragment)localObject).mContainerId)))
      {
        if (((Fragment)localObject).mPostponedAlpha > 0.0F) {
          ((Fragment)localObject).mView.setAlpha(((Fragment)localObject).mPostponedAlpha);
        }
        if (!paramBoolean3) {
          break label205;
        }
        ((Fragment)localObject).mPostponedAlpha = 0.0F;
      }
    }
    for (;;)
    {
      i += 1;
      break label101;
      parama.is();
      break;
      label205:
      ((Fragment)localObject).mPostponedAlpha = -1.0F;
      ((Fragment)localObject).mIsNewlyAdded = false;
    }
    label222:
    AppMethodBeat.o(212722);
  }
  
  final void completeShowHideFragment(final Fragment paramFragment)
  {
    AppMethodBeat.i(212660);
    boolean bool;
    c localc;
    if (paramFragment.mView != null)
    {
      i = paramFragment.getNextTransition();
      if (paramFragment.mHidden) {
        break label147;
      }
      bool = true;
      localc = loadAnimation(paramFragment, i, bool, paramFragment.getNextTransitionStyle());
      if ((localc == null) || (localc.VU == null)) {
        break label206;
      }
      localc.VU.setTarget(paramFragment.mView);
      if (!paramFragment.mHidden) {
        break label195;
      }
      if (!paramFragment.isHideReplaced()) {
        break label152;
      }
      paramFragment.setHideReplaced(false);
    }
    for (;;)
    {
      setHWLayerAnimListenerIfAlpha(paramFragment.mView, localc);
      localc.VU.start();
      if ((paramFragment.mAdded) && (paramFragment.mHasMenu) && (paramFragment.mMenuVisible)) {
        this.mNeedMenuInvalidate = true;
      }
      paramFragment.mHiddenChanged = false;
      paramFragment.onHiddenChanged(paramFragment.mHidden);
      AppMethodBeat.o(212660);
      return;
      label147:
      bool = false;
      break;
      label152:
      final ViewGroup localViewGroup = paramFragment.mContainer;
      final View localView = paramFragment.mView;
      localViewGroup.startViewTransition(localView);
      localc.VU.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(212465);
          localViewGroup.endViewTransition(localView);
          paramAnonymousAnimator.removeListener(this);
          if (paramFragment.mView != null) {
            paramFragment.mView.setVisibility(8);
          }
          AppMethodBeat.o(212465);
        }
      });
      continue;
      label195:
      paramFragment.mView.setVisibility(0);
    }
    label206:
    if (localc != null)
    {
      setHWLayerAnimListenerIfAlpha(paramFragment.mView, localc);
      paramFragment.mView.startAnimation(localc.VT);
      localc.VT.start();
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
    AppMethodBeat.i(212686);
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
      AppMethodBeat.o(212686);
      return;
    }
  }
  
  public final void dispatchActivityCreated()
  {
    AppMethodBeat.i(212760);
    this.mStateSaved = false;
    this.mStopped = false;
    dispatchStateChange(2);
    AppMethodBeat.o(212760);
  }
  
  public final void dispatchConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(212773);
    int i = 0;
    while (i < this.mAdded.size())
    {
      Fragment localFragment = (Fragment)this.mAdded.get(i);
      if (localFragment != null) {
        localFragment.performConfigurationChanged(paramConfiguration);
      }
      i += 1;
    }
    AppMethodBeat.o(212773);
  }
  
  public final boolean dispatchContextItemSelected(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(212783);
    if (this.mCurState <= 0)
    {
      AppMethodBeat.o(212783);
      return false;
    }
    int i = 0;
    while (i < this.mAdded.size())
    {
      Fragment localFragment = (Fragment)this.mAdded.get(i);
      if ((localFragment != null) && (localFragment.performContextItemSelected(paramMenuItem)))
      {
        AppMethodBeat.o(212783);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(212783);
    return false;
  }
  
  public final void dispatchCreate()
  {
    AppMethodBeat.i(212759);
    this.mStateSaved = false;
    this.mStopped = false;
    dispatchStateChange(1);
    AppMethodBeat.o(212759);
  }
  
  public final boolean dispatchCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    int j = 0;
    AppMethodBeat.i(212776);
    if (this.mCurState <= 0)
    {
      AppMethodBeat.o(212776);
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
    AppMethodBeat.o(212776);
    return bool1;
  }
  
  public final void dispatchDestroy()
  {
    AppMethodBeat.i(212766);
    this.mDestroyed = true;
    execPendingActions();
    dispatchStateChange(0);
    this.mHost = null;
    this.mContainer = null;
    this.mParent = null;
    AppMethodBeat.o(212766);
  }
  
  public final void dispatchDestroyView()
  {
    AppMethodBeat.i(212765);
    dispatchStateChange(1);
    AppMethodBeat.o(212765);
  }
  
  public final void dispatchLowMemory()
  {
    AppMethodBeat.i(212774);
    int i = 0;
    while (i < this.mAdded.size())
    {
      Fragment localFragment = (Fragment)this.mAdded.get(i);
      if (localFragment != null) {
        localFragment.performLowMemory();
      }
      i += 1;
    }
    AppMethodBeat.o(212774);
  }
  
  public final void dispatchMultiWindowModeChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(212771);
    int i = this.mAdded.size() - 1;
    while (i >= 0)
    {
      Fragment localFragment = (Fragment)this.mAdded.get(i);
      if (localFragment != null) {
        localFragment.performMultiWindowModeChanged(paramBoolean);
      }
      i -= 1;
    }
    AppMethodBeat.o(212771);
  }
  
  final void dispatchOnFragmentActivityCreated(Fragment paramFragment, Bundle paramBundle, boolean paramBoolean)
  {
    AppMethodBeat.i(212802);
    if (this.mParent != null)
    {
      e locale = this.mParent.getFragmentManager();
      if ((locale instanceof FragmentManagerImpl)) {
        ((FragmentManagerImpl)locale).dispatchOnFragmentActivityCreated(paramFragment, paramBundle, true);
      }
    }
    paramFragment = this.mLifecycleCallbacks.iterator();
    while (paramFragment.hasNext()) {
      paramFragment.next();
    }
    AppMethodBeat.o(212802);
  }
  
  final void dispatchOnFragmentAttached(Fragment paramFragment, Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(212794);
    if (this.mParent != null)
    {
      e locale = this.mParent.getFragmentManager();
      if ((locale instanceof FragmentManagerImpl)) {
        ((FragmentManagerImpl)locale).dispatchOnFragmentAttached(paramFragment, paramContext, true);
      }
    }
    paramFragment = this.mLifecycleCallbacks.iterator();
    while (paramFragment.hasNext()) {
      paramFragment.next();
    }
    AppMethodBeat.o(212794);
  }
  
  final void dispatchOnFragmentCreated(Fragment paramFragment, Bundle paramBundle, boolean paramBoolean)
  {
    AppMethodBeat.i(212800);
    if (this.mParent != null)
    {
      e locale = this.mParent.getFragmentManager();
      if ((locale instanceof FragmentManagerImpl)) {
        ((FragmentManagerImpl)locale).dispatchOnFragmentCreated(paramFragment, paramBundle, true);
      }
    }
    paramFragment = this.mLifecycleCallbacks.iterator();
    while (paramFragment.hasNext()) {
      paramFragment.next();
    }
    AppMethodBeat.o(212800);
  }
  
  final void dispatchOnFragmentDestroyed(Fragment paramFragment, boolean paramBoolean)
  {
    AppMethodBeat.i(212816);
    if (this.mParent != null)
    {
      e locale = this.mParent.getFragmentManager();
      if ((locale instanceof FragmentManagerImpl)) {
        ((FragmentManagerImpl)locale).dispatchOnFragmentDestroyed(paramFragment, true);
      }
    }
    paramFragment = this.mLifecycleCallbacks.iterator();
    while (paramFragment.hasNext()) {
      paramFragment.next();
    }
    AppMethodBeat.o(212816);
  }
  
  final void dispatchOnFragmentDetached(Fragment paramFragment, boolean paramBoolean)
  {
    AppMethodBeat.i(212817);
    if (this.mParent != null)
    {
      e locale = this.mParent.getFragmentManager();
      if ((locale instanceof FragmentManagerImpl)) {
        ((FragmentManagerImpl)locale).dispatchOnFragmentDetached(paramFragment, true);
      }
    }
    paramFragment = this.mLifecycleCallbacks.iterator();
    while (paramFragment.hasNext()) {
      paramFragment.next();
    }
    AppMethodBeat.o(212817);
  }
  
  final void dispatchOnFragmentPaused(Fragment paramFragment, boolean paramBoolean)
  {
    AppMethodBeat.i(212812);
    if (this.mParent != null)
    {
      e locale = this.mParent.getFragmentManager();
      if ((locale instanceof FragmentManagerImpl)) {
        ((FragmentManagerImpl)locale).dispatchOnFragmentPaused(paramFragment, true);
      }
    }
    paramFragment = this.mLifecycleCallbacks.iterator();
    while (paramFragment.hasNext()) {
      paramFragment.next();
    }
    AppMethodBeat.o(212812);
  }
  
  final void dispatchOnFragmentPreAttached(Fragment paramFragment, Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(212793);
    if (this.mParent != null)
    {
      e locale = this.mParent.getFragmentManager();
      if ((locale instanceof FragmentManagerImpl)) {
        ((FragmentManagerImpl)locale).dispatchOnFragmentPreAttached(paramFragment, paramContext, true);
      }
    }
    paramFragment = this.mLifecycleCallbacks.iterator();
    while (paramFragment.hasNext()) {
      paramFragment.next();
    }
    AppMethodBeat.o(212793);
  }
  
  final void dispatchOnFragmentPreCreated(Fragment paramFragment, Bundle paramBundle, boolean paramBoolean)
  {
    AppMethodBeat.i(212798);
    if (this.mParent != null)
    {
      e locale = this.mParent.getFragmentManager();
      if ((locale instanceof FragmentManagerImpl)) {
        ((FragmentManagerImpl)locale).dispatchOnFragmentPreCreated(paramFragment, paramBundle, true);
      }
    }
    paramFragment = this.mLifecycleCallbacks.iterator();
    while (paramFragment.hasNext()) {
      paramFragment.next();
    }
    AppMethodBeat.o(212798);
  }
  
  final void dispatchOnFragmentResumed(Fragment paramFragment, boolean paramBoolean)
  {
    AppMethodBeat.i(212810);
    if (this.mParent != null)
    {
      e locale = this.mParent.getFragmentManager();
      if ((locale instanceof FragmentManagerImpl)) {
        ((FragmentManagerImpl)locale).dispatchOnFragmentResumed(paramFragment, true);
      }
    }
    paramFragment = this.mLifecycleCallbacks.iterator();
    while (paramFragment.hasNext()) {
      paramFragment.next();
    }
    AppMethodBeat.o(212810);
  }
  
  final void dispatchOnFragmentSaveInstanceState(Fragment paramFragment, Bundle paramBundle, boolean paramBoolean)
  {
    AppMethodBeat.i(212814);
    if (this.mParent != null)
    {
      e locale = this.mParent.getFragmentManager();
      if ((locale instanceof FragmentManagerImpl)) {
        ((FragmentManagerImpl)locale).dispatchOnFragmentSaveInstanceState(paramFragment, paramBundle, true);
      }
    }
    paramFragment = this.mLifecycleCallbacks.iterator();
    while (paramFragment.hasNext()) {
      paramFragment.next();
    }
    AppMethodBeat.o(212814);
  }
  
  final void dispatchOnFragmentStarted(Fragment paramFragment, boolean paramBoolean)
  {
    AppMethodBeat.i(212807);
    if (this.mParent != null)
    {
      e locale = this.mParent.getFragmentManager();
      if ((locale instanceof FragmentManagerImpl)) {
        ((FragmentManagerImpl)locale).dispatchOnFragmentStarted(paramFragment, true);
      }
    }
    paramFragment = this.mLifecycleCallbacks.iterator();
    while (paramFragment.hasNext()) {
      paramFragment.next();
    }
    AppMethodBeat.o(212807);
  }
  
  final void dispatchOnFragmentStopped(Fragment paramFragment, boolean paramBoolean)
  {
    AppMethodBeat.i(212813);
    if (this.mParent != null)
    {
      e locale = this.mParent.getFragmentManager();
      if ((locale instanceof FragmentManagerImpl)) {
        ((FragmentManagerImpl)locale).dispatchOnFragmentStopped(paramFragment, true);
      }
    }
    paramFragment = this.mLifecycleCallbacks.iterator();
    while (paramFragment.hasNext()) {
      paramFragment.next();
    }
    AppMethodBeat.o(212813);
  }
  
  final void dispatchOnFragmentViewCreated(Fragment paramFragment, View paramView, Bundle paramBundle, boolean paramBoolean)
  {
    AppMethodBeat.i(212805);
    if (this.mParent != null)
    {
      e locale = this.mParent.getFragmentManager();
      if ((locale instanceof FragmentManagerImpl)) {
        ((FragmentManagerImpl)locale).dispatchOnFragmentViewCreated(paramFragment, paramView, paramBundle, true);
      }
    }
    paramFragment = this.mLifecycleCallbacks.iterator();
    while (paramFragment.hasNext()) {
      paramFragment.next();
    }
    AppMethodBeat.o(212805);
  }
  
  final void dispatchOnFragmentViewDestroyed(Fragment paramFragment, boolean paramBoolean)
  {
    AppMethodBeat.i(212815);
    if (this.mParent != null)
    {
      e locale = this.mParent.getFragmentManager();
      if ((locale instanceof FragmentManagerImpl)) {
        ((FragmentManagerImpl)locale).dispatchOnFragmentViewDestroyed(paramFragment, true);
      }
    }
    paramFragment = this.mLifecycleCallbacks.iterator();
    while (paramFragment.hasNext()) {
      paramFragment.next();
    }
    AppMethodBeat.o(212815);
  }
  
  public final boolean dispatchOptionsItemSelected(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(212780);
    if (this.mCurState <= 0)
    {
      AppMethodBeat.o(212780);
      return false;
    }
    int i = 0;
    while (i < this.mAdded.size())
    {
      Fragment localFragment = (Fragment)this.mAdded.get(i);
      if ((localFragment != null) && (localFragment.performOptionsItemSelected(paramMenuItem)))
      {
        AppMethodBeat.o(212780);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(212780);
    return false;
  }
  
  public final void dispatchOptionsMenuClosed(Menu paramMenu)
  {
    AppMethodBeat.i(212785);
    if (this.mCurState <= 0)
    {
      AppMethodBeat.o(212785);
      return;
    }
    int i = 0;
    while (i < this.mAdded.size())
    {
      Fragment localFragment = (Fragment)this.mAdded.get(i);
      if (localFragment != null) {
        localFragment.performOptionsMenuClosed(paramMenu);
      }
      i += 1;
    }
    AppMethodBeat.o(212785);
  }
  
  public final void dispatchPause()
  {
    AppMethodBeat.i(212763);
    dispatchStateChange(3);
    AppMethodBeat.o(212763);
  }
  
  public final void dispatchPictureInPictureModeChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(212772);
    int i = this.mAdded.size() - 1;
    while (i >= 0)
    {
      Fragment localFragment = (Fragment)this.mAdded.get(i);
      if (localFragment != null) {
        localFragment.performPictureInPictureModeChanged(paramBoolean);
      }
      i -= 1;
    }
    AppMethodBeat.o(212772);
  }
  
  public final boolean dispatchPrepareOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(212778);
    if (this.mCurState <= 0)
    {
      AppMethodBeat.o(212778);
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
    AppMethodBeat.o(212778);
    return bool1;
  }
  
  public final void dispatchResume()
  {
    AppMethodBeat.i(212762);
    this.mStateSaved = false;
    this.mStopped = false;
    dispatchStateChange(4);
    AppMethodBeat.o(212762);
  }
  
  public final void dispatchStart()
  {
    AppMethodBeat.i(212761);
    this.mStateSaved = false;
    this.mStopped = false;
    dispatchStateChange(3);
    AppMethodBeat.o(212761);
  }
  
  public final void dispatchStop()
  {
    AppMethodBeat.i(212764);
    this.mStopped = true;
    dispatchStateChange(2);
    AppMethodBeat.o(212764);
  }
  
  final void doPendingDeferredStart()
  {
    AppMethodBeat.i(212734);
    if (this.mHavePendingDeferredStart)
    {
      this.mHavePendingDeferredStart = false;
      startPendingDeferredFragments();
    }
    AppMethodBeat.o(212734);
  }
  
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    int j = 0;
    AppMethodBeat.i(212629);
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
          paramFileDescriptor = (a)this.mBackStack.get(i);
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
            paramFileDescriptor = (a)this.mBackStackIndices.get(i);
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
    finally
    {
      AppMethodBeat.o(212629);
    }
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
    AppMethodBeat.o(212629);
  }
  
  public final void enqueueAction(h paramh, boolean paramBoolean)
  {
    AppMethodBeat.i(212701);
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
        paramh = new IllegalStateException("Activity has been destroyed");
        AppMethodBeat.o(212701);
        throw paramh;
      }
    }
    finally
    {
      AppMethodBeat.o(212701);
    }
    if (this.mPendingActions == null) {
      this.mPendingActions = new ArrayList();
    }
    this.mPendingActions.add(paramh);
    scheduleCommit();
    AppMethodBeat.o(212701);
  }
  
  final void ensureInflatedFragmentView(Fragment paramFragment)
  {
    AppMethodBeat.i(212658);
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
        AppMethodBeat.o(212658);
        return;
      }
      paramFragment.mInnerView = null;
    }
    AppMethodBeat.o(212658);
  }
  
  public final boolean execPendingActions()
  {
    AppMethodBeat.i(212714);
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
        AppMethodBeat.o(212714);
      }
    }
    AppMethodBeat.o(212714);
    return bool;
  }
  
  public final void execSingleAction(h paramh, boolean paramBoolean)
  {
    AppMethodBeat.i(212711);
    if ((paramBoolean) && ((this.mHost == null) || (this.mDestroyed)))
    {
      AppMethodBeat.o(212711);
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
      AppMethodBeat.o(212711);
    }
  }
  
  public final boolean executePendingTransactions()
  {
    AppMethodBeat.i(212570);
    boolean bool = execPendingActions();
    forcePostponedTransactions();
    AppMethodBeat.o(212570);
    return bool;
  }
  
  public final Fragment findFragmentById(int paramInt)
  {
    AppMethodBeat.i(212691);
    int i = this.mAdded.size() - 1;
    Fragment localFragment;
    while (i >= 0)
    {
      localFragment = (Fragment)this.mAdded.get(i);
      if ((localFragment != null) && (localFragment.mFragmentId == paramInt))
      {
        AppMethodBeat.o(212691);
        return localFragment;
      }
      i -= 1;
    }
    if (this.mActive != null)
    {
      i = this.mActive.size() - 1;
      while (i >= 0)
      {
        localFragment = (Fragment)this.mActive.valueAt(i);
        if ((localFragment != null) && (localFragment.mFragmentId == paramInt))
        {
          AppMethodBeat.o(212691);
          return localFragment;
        }
        i -= 1;
      }
    }
    AppMethodBeat.o(212691);
    return null;
  }
  
  public final Fragment findFragmentByTag(String paramString)
  {
    AppMethodBeat.i(212693);
    int i;
    Fragment localFragment;
    if (paramString != null)
    {
      i = this.mAdded.size() - 1;
      while (i >= 0)
      {
        localFragment = (Fragment)this.mAdded.get(i);
        if ((localFragment != null) && (paramString.equals(localFragment.mTag)))
        {
          AppMethodBeat.o(212693);
          return localFragment;
        }
        i -= 1;
      }
    }
    if ((this.mActive != null) && (paramString != null))
    {
      i = this.mActive.size() - 1;
      while (i >= 0)
      {
        localFragment = (Fragment)this.mActive.valueAt(i);
        if ((localFragment != null) && (paramString.equals(localFragment.mTag)))
        {
          AppMethodBeat.o(212693);
          return localFragment;
        }
        i -= 1;
      }
    }
    AppMethodBeat.o(212693);
    return null;
  }
  
  public final Fragment findFragmentByWho(String paramString)
  {
    AppMethodBeat.i(212695);
    if ((this.mActive != null) && (paramString != null))
    {
      int i = this.mActive.size() - 1;
      while (i >= 0)
      {
        Fragment localFragment = (Fragment)this.mActive.valueAt(i);
        if (localFragment != null)
        {
          localFragment = localFragment.findFragmentByWho(paramString);
          if (localFragment != null)
          {
            AppMethodBeat.o(212695);
            return localFragment;
          }
        }
        i -= 1;
      }
    }
    AppMethodBeat.o(212695);
    return null;
  }
  
  public final void freeBackStackIndex(int paramInt)
  {
    AppMethodBeat.i(212708);
    try
    {
      this.mBackStackIndices.set(paramInt, null);
      if (this.mAvailBackStackIndices == null) {
        this.mAvailBackStackIndices = new ArrayList();
      }
      this.mAvailBackStackIndices.add(Integer.valueOf(paramInt));
      return;
    }
    finally
    {
      AppMethodBeat.o(212708);
    }
  }
  
  final int getActiveFragmentCount()
  {
    AppMethodBeat.i(212615);
    if (this.mActive == null)
    {
      AppMethodBeat.o(212615);
      return 0;
    }
    int i = this.mActive.size();
    AppMethodBeat.o(212615);
    return i;
  }
  
  final List<Fragment> getActiveFragments()
  {
    AppMethodBeat.i(212612);
    if (this.mActive == null)
    {
      AppMethodBeat.o(212612);
      return null;
    }
    int j = this.mActive.size();
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(this.mActive.valueAt(i));
      i += 1;
    }
    AppMethodBeat.o(212612);
    return localArrayList;
  }
  
  public final e.a getBackStackEntryAt(int paramInt)
  {
    AppMethodBeat.i(212593);
    e.a locala = (e.a)this.mBackStack.get(paramInt);
    AppMethodBeat.o(212593);
    return locala;
  }
  
  public final int getBackStackEntryCount()
  {
    AppMethodBeat.i(212590);
    if (this.mBackStack != null)
    {
      int i = this.mBackStack.size();
      AppMethodBeat.o(212590);
      return i;
    }
    AppMethodBeat.o(212590);
    return 0;
  }
  
  public final Fragment getFragment(Bundle paramBundle, String paramString)
  {
    AppMethodBeat.i(212605);
    int i = paramBundle.getInt(paramString, -1);
    if (i == -1)
    {
      AppMethodBeat.o(212605);
      return null;
    }
    paramBundle = (Fragment)this.mActive.get(i);
    if (paramBundle == null) {
      throwException(new IllegalStateException("Fragment no longer exists for key " + paramString + ": index " + i));
    }
    AppMethodBeat.o(212605);
    return paramBundle;
  }
  
  public final List<Fragment> getFragments()
  {
    AppMethodBeat.i(212609);
    if (this.mAdded.isEmpty())
    {
      ??? = Collections.emptyList();
      AppMethodBeat.o(212609);
      return ???;
    }
    synchronized (this.mAdded)
    {
      List localList = (List)this.mAdded.clone();
      AppMethodBeat.o(212609);
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
    AppMethodBeat.i(212681);
    if (DEBUG) {
      new StringBuilder("hide: ").append(paramFragment);
    }
    if (!paramFragment.mHidden)
    {
      paramFragment.mHidden = true;
      if (paramFragment.mHiddenChanged) {
        break label60;
      }
    }
    for (;;)
    {
      paramFragment.mHiddenChanged = bool;
      AppMethodBeat.o(212681);
      return;
      label60:
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
    AppMethodBeat.i(212637);
    int j = paramFragment.getNextAnim();
    Animation localAnimation = paramFragment.onCreateAnimation(paramInt1, paramBoolean, j);
    if (localAnimation != null)
    {
      paramFragment = new c(localAnimation);
      AppMethodBeat.o(212637);
      return paramFragment;
    }
    paramFragment = paramFragment.onCreateAnimator(paramInt1, paramBoolean, j);
    if (paramFragment != null)
    {
      paramFragment = new c(paramFragment);
      AppMethodBeat.o(212637);
      return paramFragment;
    }
    boolean bool;
    if (j != 0)
    {
      bool = "anim".equals(this.mHost.mContext.getResources().getResourceTypeName(j));
      if (bool) {}
      for (;;)
      {
        try
        {
          paramFragment = AnimationUtils.loadAnimation(this.mHost.mContext, j);
          if (paramFragment != null)
          {
            paramFragment = new c(paramFragment);
            AppMethodBeat.o(212637);
            return paramFragment;
          }
          int i = 1;
          if (i != 0) {
            break label248;
          }
          i = 0;
        }
        catch (Resources.NotFoundException paramFragment)
        {
          try
          {
            paramFragment = AnimatorInflater.loadAnimator(this.mHost.mContext, j);
            if (paramFragment == null) {
              break label248;
            }
            paramFragment = new c(paramFragment);
            AppMethodBeat.o(212637);
            return paramFragment;
          }
          catch (RuntimeException paramFragment)
          {
            if (!bool) {
              break;
            }
            AppMethodBeat.o(212637);
            throw paramFragment;
            paramFragment = AnimationUtils.loadAnimation(this.mHost.mContext, j);
            if (paramFragment == null) {
              break label248;
            }
            paramFragment = new c(paramFragment);
            AppMethodBeat.o(212637);
            return paramFragment;
          }
          paramFragment = paramFragment;
          AppMethodBeat.o(212637);
          throw paramFragment;
        }
        catch (RuntimeException paramFragment) {}
      }
    }
    label248:
    if (paramInt1 == 0)
    {
      AppMethodBeat.o(212637);
      return null;
    }
    paramInt1 = transitToStyleIndex(paramInt1, paramBoolean);
    if (paramInt1 < 0)
    {
      AppMethodBeat.o(212637);
      return null;
    }
    switch (paramInt1)
    {
    default: 
      paramInt1 = paramInt2;
      if (paramInt2 == 0)
      {
        paramInt1 = paramInt2;
        if (this.mHost.iz()) {
          paramInt1 = this.mHost.iA();
        }
      }
      if (paramInt1 == 0)
      {
        AppMethodBeat.o(212637);
        return null;
      }
      break;
    case 1: 
      paramFragment = makeOpenCloseAnimation(this.mHost.mContext, 1.125F, 1.0F, 0.0F, 1.0F);
      AppMethodBeat.o(212637);
      return paramFragment;
    case 2: 
      paramFragment = makeOpenCloseAnimation(this.mHost.mContext, 1.0F, 0.975F, 1.0F, 0.0F);
      AppMethodBeat.o(212637);
      return paramFragment;
    case 3: 
      paramFragment = makeOpenCloseAnimation(this.mHost.mContext, 0.975F, 1.0F, 0.0F, 1.0F);
      AppMethodBeat.o(212637);
      return paramFragment;
    case 4: 
      paramFragment = makeOpenCloseAnimation(this.mHost.mContext, 1.0F, 1.075F, 1.0F, 0.0F);
      AppMethodBeat.o(212637);
      return paramFragment;
    case 5: 
      paramFragment = makeFadeAnimation(this.mHost.mContext, 0.0F, 1.0F);
      AppMethodBeat.o(212637);
      return paramFragment;
    case 6: 
      paramFragment = makeFadeAnimation(this.mHost.mContext, 1.0F, 0.0F);
      AppMethodBeat.o(212637);
      return paramFragment;
    }
    AppMethodBeat.o(212637);
    return null;
  }
  
  final void makeActive(Fragment paramFragment)
  {
    AppMethodBeat.i(212670);
    if (paramFragment.mIndex >= 0)
    {
      AppMethodBeat.o(212670);
      return;
    }
    int i = this.mNextFragmentIndex;
    this.mNextFragmentIndex = (i + 1);
    paramFragment.setIndex(i, this.mParent);
    if (this.mActive == null) {
      this.mActive = new SparseArray();
    }
    this.mActive.put(paramFragment.mIndex, paramFragment);
    if (DEBUG) {
      new StringBuilder("Allocated fragment index ").append(paramFragment);
    }
    AppMethodBeat.o(212670);
  }
  
  final void makeInactive(Fragment paramFragment)
  {
    AppMethodBeat.i(212673);
    if (paramFragment.mIndex < 0)
    {
      AppMethodBeat.o(212673);
      return;
    }
    if (DEBUG) {
      new StringBuilder("Freeing fragment index ").append(paramFragment);
    }
    this.mActive.put(paramFragment.mIndex, null);
    paramFragment.initState();
    AppMethodBeat.o(212673);
  }
  
  final void moveFragmentToExpectedState(Fragment paramFragment)
  {
    AppMethodBeat.i(212662);
    if (paramFragment == null)
    {
      AppMethodBeat.o(212662);
      return;
    }
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
            if (((c)localObject).VT == null) {
              break label252;
            }
            paramFragment.mView.startAnimation(((c)localObject).VT);
          }
        }
      }
    }
    for (;;)
    {
      if (paramFragment.mHiddenChanged) {
        completeShowHideFragment(paramFragment);
      }
      AppMethodBeat.o(212662);
      return;
      i = Math.min(j, 0);
      break;
      label252:
      ((c)localObject).VU.setTarget(paramFragment.mView);
      ((c)localObject).VU.start();
    }
  }
  
  final void moveToState(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(212666);
    Object localObject;
    if ((this.mHost == null) && (paramInt != 0))
    {
      localObject = new IllegalStateException("No activity");
      AppMethodBeat.o(212666);
      throw ((Throwable)localObject);
    }
    if ((!paramBoolean) && (paramInt == this.mCurState))
    {
      AppMethodBeat.o(212666);
      return;
    }
    this.mCurState = paramInt;
    if (this.mActive != null)
    {
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
        localObject = (Fragment)this.mActive.valueAt(paramInt);
        if ((localObject != null) && ((((Fragment)localObject).mRemoving) || (((Fragment)localObject).mDetached)) && (!((Fragment)localObject).mIsNewlyAdded)) {
          moveFragmentToExpectedState((Fragment)localObject);
        }
        paramInt += 1;
      }
      startPendingDeferredFragments();
      if ((this.mNeedMenuInvalidate) && (this.mHost != null) && (this.mCurState == 4))
      {
        this.mHost.iy();
        this.mNeedMenuInvalidate = false;
      }
    }
    AppMethodBeat.o(212666);
  }
  
  final void moveToState(Fragment paramFragment)
  {
    AppMethodBeat.i(212656);
    moveToState(paramFragment, this.mCurState, 0, 0, false);
    AppMethodBeat.o(212656);
  }
  
  final void moveToState(Fragment paramFragment, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(212652);
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
      if (j > paramFragment.mState) {
        if ((paramFragment.mState != 0) || (!paramFragment.isInBackStack())) {
          break label139;
        }
      }
    }
    label139:
    for (i = 1;; i = paramFragment.mState)
    {
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
      if (paramFragment.mState > paramInt1) {
        break label1277;
      }
      if ((!paramFragment.mFromLayout) || (paramFragment.mInLayout)) {
        break;
      }
      AppMethodBeat.o(212652);
      return;
    }
    if ((paramFragment.getAnimatingAway() != null) || (paramFragment.getAnimator() != null))
    {
      paramFragment.setAnimatingAway(null);
      paramFragment.setAnimator(null);
      moveToState(paramFragment, paramFragment.getStateAfterAnimating(), 0, 0, true);
    }
    paramInt3 = paramInt1;
    i = paramInt1;
    paramInt2 = paramInt1;
    Object localObject1;
    label562:
    label591:
    label613:
    ViewGroup localViewGroup;
    switch (paramFragment.mState)
    {
    default: 
      i = paramInt1;
      if (paramFragment.mState != i)
      {
        new StringBuilder("moveToState: Fragment state for ").append(paramFragment).append(" not updated inline; expected state ").append(i).append(" found ").append(paramFragment.mState);
        paramFragment.mState = i;
      }
      AppMethodBeat.o(212652);
      return;
    case 0: 
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
            break label562;
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
            break label613;
          }
          if (this.mActive.get(paramFragment.mTarget.mIndex) == paramFragment.mTarget) {
            break label591;
          }
          paramFragment = new IllegalStateException("Fragment " + paramFragment + " declared target fragment " + paramFragment.mTarget + " that does not belong to this FragmentManager!");
          AppMethodBeat.o(212652);
          throw paramFragment;
          paramFragment.mUserVisibleHint = paramFragment.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
          break;
        }
        if (paramFragment.mTarget.mState <= 0) {
          moveToState(paramFragment.mTarget, 1, 0, 0, true);
        }
        dispatchOnFragmentPreAttached(paramFragment, this.mHost.mContext, false);
        paramFragment.mCalled = false;
        paramFragment.onAttach(this.mHost.mContext);
        if (!paramFragment.mCalled)
        {
          paramFragment = new n("Fragment " + paramFragment + " did not call through to super.onAttach()");
          AppMethodBeat.o(212652);
          throw paramFragment;
        }
        if (paramFragment.mParentFragment != null) {
          break label1226;
        }
        this.mHost.onAttachFragment(paramFragment);
        dispatchOnFragmentAttached(paramFragment, this.mHost.mContext, false);
        if (paramFragment.mIsCreated) {
          break label1237;
        }
        dispatchOnFragmentPreCreated(paramFragment, paramFragment.mSavedFragmentState, false);
        paramFragment.performCreate(paramFragment.mSavedFragmentState);
        dispatchOnFragmentCreated(paramFragment, paramFragment.mSavedFragmentState, false);
        paramFragment.mRetaining = false;
      }
    case 1: 
      label703:
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
            break label1805;
          }
          if (paramFragment.mContainerId == -1) {
            throwException(new IllegalArgumentException("Cannot create fragment " + paramFragment + " for a container view with no id"));
          }
          localViewGroup = (ViewGroup)this.mContainer.bZ(paramFragment.mContainerId);
          localObject1 = localViewGroup;
          if (localViewGroup == null)
          {
            localObject1 = localViewGroup;
            if (paramFragment.mRestored) {}
          }
        }
      }
      break;
    }
    for (;;)
    {
      label1226:
      label1237:
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
            break label703;
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
      label1277:
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
        label1330:
        label1367:
        do
        {
          i = paramInt1;
          if (paramInt1 > 0) {
            break;
          }
          if (this.mDestroyed)
          {
            if (paramFragment.getAnimatingAway() == null) {
              break label1670;
            }
            localObject2 = paramFragment.getAnimatingAway();
            paramFragment.setAnimatingAway(null);
            ((View)localObject2).clearAnimation();
          }
          if ((paramFragment.getAnimatingAway() == null) && (paramFragment.getAnimator() == null)) {
            break label1696;
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
        if ((paramFragment.mView != null) && (this.mHost.iw()) && (paramFragment.mSavedViewState == null)) {
          saveFragmentViewState(paramFragment);
        }
        paramFragment.performDestroyView();
        dispatchOnFragmentViewDestroyed(paramFragment, false);
        if ((paramFragment.mView != null) && (paramFragment.mContainer != null))
        {
          paramFragment.mContainer.endViewTransition(paramFragment.mView);
          paramFragment.mView.clearAnimation();
          if ((this.mCurState <= 0) || (this.mDestroyed) || (paramFragment.mView.getVisibility() != 0) || (paramFragment.mPostponedAlpha < 0.0F)) {
            break label1799;
          }
        }
        label1670:
        label1799:
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
          break label1330;
          if (paramFragment.getAnimator() == null) {
            break label1367;
          }
          localObject2 = paramFragment.getAnimator();
          paramFragment.setAnimator(null);
          ((Animator)localObject2).cancel();
          break label1367;
          label1696:
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
              break label1778;
            }
            makeInactive(paramFragment);
            i = paramInt1;
            break;
            paramFragment.mState = 0;
          }
          label1778:
          paramFragment.mHost = null;
          paramFragment.mParentFragment = null;
          paramFragment.mFragmentManager = null;
          i = paramInt1;
          break;
        }
        label1805:
        localObject2 = null;
      }
    }
  }
  
  public final void noteStateNotSaved()
  {
    AppMethodBeat.i(212758);
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
    AppMethodBeat.o(212758);
  }
  
  public final View onCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(212818);
    if (!"fragment".equals(paramString))
    {
      AppMethodBeat.o(212818);
      return null;
    }
    String str1 = paramAttributeSet.getAttributeValue(null, "class");
    paramString = paramContext.obtainStyledAttributes(paramAttributeSet, g.Wb);
    if (str1 == null) {
      str1 = paramString.getString(0);
    }
    for (;;)
    {
      int k = paramString.getResourceId(1, -1);
      String str2 = paramString.getString(2);
      paramString.recycle();
      if (!Fragment.isSupportFragmentClass(this.mHost.mContext, str1))
      {
        AppMethodBeat.o(212818);
        return null;
      }
      if (paramView != null) {}
      for (int i = paramView.getId(); (i == -1) && (k == -1) && (str2 == null); i = 0)
      {
        paramView = new IllegalArgumentException(paramAttributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + str1);
        AppMethodBeat.o(212818);
        throw paramView;
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
          break label452;
        }
        paramView = this.mContainer.instantiate(paramContext, str1, null);
        paramView.mFromLayout = true;
        if (k == 0) {
          break label445;
        }
        j = k;
        label311:
        paramView.mFragmentId = j;
        paramView.mContainerId = i;
        paramView.mTag = str2;
        paramView.mInLayout = true;
        paramView.mFragmentManager = this;
        paramView.mHost = this.mHost;
        paramView.onInflate(this.mHost.mContext, paramAttributeSet, paramView.mSavedFragmentState);
        addFragment(paramView, true);
        label370:
        if ((this.mCurState > 0) || (!paramView.mFromLayout)) {
          break label587;
        }
        moveToState(paramView, 1, 0, 0, false);
      }
      for (;;)
      {
        if (paramView.mView != null) {
          break label595;
        }
        paramView = new IllegalStateException("Fragment " + str1 + " did not create a view.");
        AppMethodBeat.o(212818);
        throw paramView;
        paramString = null;
        break;
        label445:
        j = i;
        break label311;
        label452:
        if (paramString.mInLayout)
        {
          paramView = new IllegalArgumentException(paramAttributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(k) + ", tag " + str2 + ", or parent id 0x" + Integer.toHexString(i) + " with another fragment for " + str1);
          AppMethodBeat.o(212818);
          throw paramView;
        }
        paramString.mInLayout = true;
        paramString.mHost = this.mHost;
        if (!paramString.mRetaining) {
          paramString.onInflate(this.mHost.mContext, paramAttributeSet, paramString.mSavedFragmentState);
        }
        paramView = paramString;
        break label370;
        label587:
        moveToState(paramView);
      }
      label595:
      if (k != 0) {
        paramView.mView.setId(k);
      }
      if (paramView.mView.getTag() == null) {
        paramView.mView.setTag(str2);
      }
      paramView = paramView.mView;
      AppMethodBeat.o(212818);
      return paramView;
    }
  }
  
  public final View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(212820);
    paramString = onCreateView(null, paramString, paramContext, paramAttributeSet);
    AppMethodBeat.o(212820);
    return paramString;
  }
  
  public final void performPendingDeferredStart(Fragment paramFragment)
  {
    AppMethodBeat.i(212640);
    if (paramFragment.mDeferStart)
    {
      if (this.mExecutingActions)
      {
        this.mHavePendingDeferredStart = true;
        AppMethodBeat.o(212640);
        return;
      }
      paramFragment.mDeferStart = false;
      moveToState(paramFragment, this.mCurState, 0, 0, false);
    }
    AppMethodBeat.o(212640);
  }
  
  public final void popBackStack()
  {
    AppMethodBeat.i(212571);
    enqueueAction(new i(null, -1, 0), false);
    AppMethodBeat.o(212571);
  }
  
  public final void popBackStack(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(212581);
    if (paramInt1 < 0)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Bad id: ".concat(String.valueOf(paramInt1)));
      AppMethodBeat.o(212581);
      throw localIllegalArgumentException;
    }
    enqueueAction(new i(null, paramInt1, paramInt2), false);
    AppMethodBeat.o(212581);
  }
  
  public final void popBackStack(String paramString, int paramInt)
  {
    AppMethodBeat.i(212575);
    enqueueAction(new i(paramString, -1, paramInt), false);
    AppMethodBeat.o(212575);
  }
  
  public final boolean popBackStackImmediate()
  {
    AppMethodBeat.i(212573);
    checkStateLoss();
    boolean bool = popBackStackImmediate(null, -1, 0);
    AppMethodBeat.o(212573);
    return bool;
  }
  
  public final boolean popBackStackImmediate(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(212585);
    checkStateLoss();
    execPendingActions();
    if (paramInt1 < 0)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Bad id: ".concat(String.valueOf(paramInt1)));
      AppMethodBeat.o(212585);
      throw localIllegalArgumentException;
    }
    boolean bool = popBackStackImmediate(null, paramInt1, paramInt2);
    AppMethodBeat.o(212585);
    return bool;
  }
  
  public final boolean popBackStackImmediate(String paramString, int paramInt)
  {
    AppMethodBeat.i(212579);
    checkStateLoss();
    boolean bool = popBackStackImmediate(paramString, -1, paramInt);
    AppMethodBeat.o(212579);
    return bool;
  }
  
  final boolean popBackStackState(ArrayList<a> paramArrayList, ArrayList<Boolean> paramArrayList1, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(212739);
    if (this.mBackStack == null)
    {
      AppMethodBeat.o(212739);
      return false;
    }
    if ((paramString == null) && (paramInt1 < 0) && ((paramInt2 & 0x1) == 0))
    {
      paramInt1 = this.mBackStack.size() - 1;
      if (paramInt1 < 0)
      {
        AppMethodBeat.o(212739);
        return false;
      }
      paramArrayList.add(this.mBackStack.remove(paramInt1));
      paramArrayList1.add(Boolean.TRUE);
    }
    for (;;)
    {
      AppMethodBeat.o(212739);
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
        if (j < 0)
        {
          AppMethodBeat.o(212739);
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
      if (i == this.mBackStack.size() - 1)
      {
        AppMethodBeat.o(212739);
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
    AppMethodBeat.i(212602);
    if (paramFragment.mIndex < 0) {
      throwException(new IllegalStateException("Fragment " + paramFragment + " is not currently in the FragmentManager"));
    }
    paramBundle.putInt(paramString, paramFragment.mIndex);
    AppMethodBeat.o(212602);
  }
  
  public final void registerFragmentLifecycleCallbacks(e.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(212790);
    this.mLifecycleCallbacks.add(new f(paramb, paramBoolean));
    AppMethodBeat.o(212790);
  }
  
  public final void removeFragment(Fragment paramFragment)
  {
    AppMethodBeat.i(212678);
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
        AppMethodBeat.o(212678);
        return;
        i = 0;
      }
    }
  }
  
  public final void removeOnBackStackChangedListener(e.c paramc)
  {
    AppMethodBeat.i(212600);
    if (this.mBackStackChangeListeners != null) {
      this.mBackStackChangeListeners.remove(paramc);
    }
    AppMethodBeat.o(212600);
  }
  
  final void reportBackStackChanged()
  {
    AppMethodBeat.i(212737);
    if (this.mBackStackChangeListeners != null)
    {
      int i = 0;
      while (i < this.mBackStackChangeListeners.size())
      {
        ((e.c)this.mBackStackChangeListeners.get(i)).onBackStackChanged();
        i += 1;
      }
    }
    AppMethodBeat.o(212737);
  }
  
  final void restoreAllState(Parcelable arg1, f paramf)
  {
    AppMethodBeat.i(212754);
    if (??? == null)
    {
      AppMethodBeat.o(212754);
      return;
    }
    FragmentManagerState localFragmentManagerState = (FragmentManagerState)???;
    if (localFragmentManagerState.Wi == null)
    {
      AppMethodBeat.o(212754);
      return;
    }
    List localList = null;
    Object localObject1;
    int i;
    int j;
    Object localObject2;
    Object localObject3;
    if (paramf != null)
    {
      localObject1 = paramf.Wf;
      localList = paramf.Wg;
      ??? = paramf.Wh;
      if (localObject1 != null)
      {
        i = ((List)localObject1).size();
        j = 0;
      }
      for (;;)
      {
        if (j >= i) {
          break label317;
        }
        localObject2 = (Fragment)((List)localObject1).get(j);
        if (DEBUG) {
          new StringBuilder("restoreAllState: re-attaching retained ").append(localObject2);
        }
        int k = 0;
        for (;;)
        {
          if ((k < localFragmentManagerState.Wi.length) && (localFragmentManagerState.Wi[k].mIndex != ((Fragment)localObject2).mIndex))
          {
            k += 1;
            continue;
            i = 0;
            break;
          }
        }
        if (k == localFragmentManagerState.Wi.length) {
          throwException(new IllegalStateException("Could not find active fragment with index " + ((Fragment)localObject2).mIndex));
        }
        localObject3 = localFragmentManagerState.Wi[k];
        ((FragmentState)localObject3).Wm = ((Fragment)localObject2);
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
      label317:
      this.mActive = new SparseArray(localFragmentManagerState.Wi.length);
      i = 0;
      FragmentState localFragmentState;
      if (i < localFragmentManagerState.Wi.length)
      {
        localFragmentState = localFragmentManagerState.Wi[i];
        if (localFragmentState != null) {
          if ((localList == null) || (i >= localList.size())) {
            break label1306;
          }
        }
      }
      label780:
      label1306:
      for (localObject1 = (f)localList.get(i);; localObject1 = null)
      {
        localObject3 = null;
        localObject2 = localObject3;
        if (??? != null)
        {
          localObject2 = localObject3;
          if (i < ???.size()) {
            localObject2 = (aa)???.get(i);
          }
        }
        localObject3 = this.mHost;
        b localb = this.mContainer;
        Fragment localFragment = this.mParent;
        Context localContext;
        if (localFragmentState.Wm == null)
        {
          localContext = ((d)localObject3).mContext;
          if (localFragmentState.mArguments != null) {
            localFragmentState.mArguments.setClassLoader(localContext.getClassLoader());
          }
          if (localb == null) {
            break label780;
          }
        }
        for (localFragmentState.Wm = localb.instantiate(localContext, localFragmentState.mClassName, localFragmentState.mArguments);; localFragmentState.Wm = Fragment.instantiate(localContext, localFragmentState.mClassName, localFragmentState.mArguments))
        {
          if (localFragmentState.mSavedFragmentState != null)
          {
            localFragmentState.mSavedFragmentState.setClassLoader(localContext.getClassLoader());
            localFragmentState.Wm.mSavedFragmentState = localFragmentState.mSavedFragmentState;
          }
          localFragmentState.Wm.setIndex(localFragmentState.mIndex, localFragment);
          localFragmentState.Wm.mFromLayout = localFragmentState.mFromLayout;
          localFragmentState.Wm.mRestored = true;
          localFragmentState.Wm.mFragmentId = localFragmentState.mFragmentId;
          localFragmentState.Wm.mContainerId = localFragmentState.mContainerId;
          localFragmentState.Wm.mTag = localFragmentState.mTag;
          localFragmentState.Wm.mRetainInstance = localFragmentState.mRetainInstance;
          localFragmentState.Wm.mDetached = localFragmentState.mDetached;
          localFragmentState.Wm.mHidden = localFragmentState.mHidden;
          localFragmentState.Wm.mFragmentManager = ((d)localObject3).mFragmentManager;
          if (DEBUG) {
            new StringBuilder("Instantiated fragment ").append(localFragmentState.Wm);
          }
          localFragmentState.Wm.mChildNonConfig = ((f)localObject1);
          localFragmentState.Wm.mViewModelStore = ((aa)localObject2);
          localObject1 = localFragmentState.Wm;
          if (DEBUG) {
            new StringBuilder("restoreAllState: active #").append(i).append(": ").append(localObject1);
          }
          this.mActive.put(((Fragment)localObject1).mIndex, localObject1);
          localFragmentState.Wm = null;
          i += 1;
          break;
        }
        if (paramf != null)
        {
          ??? = paramf.Wf;
          if (??? != null) {}
          for (i = ???.size();; i = 0)
          {
            j = 0;
            while (j < i)
            {
              paramf = (Fragment)???.get(j);
              if (paramf.mTargetIndex >= 0)
              {
                paramf.mTarget = ((Fragment)this.mActive.get(paramf.mTargetIndex));
                if (paramf.mTarget == null) {
                  new StringBuilder("Re-attaching retained fragment ").append(paramf).append(" target no longer exists: ").append(paramf.mTargetIndex);
                }
              }
              j += 1;
            }
          }
        }
        this.mAdded.clear();
        if (localFragmentManagerState.Wj != null) {
          i = 0;
        }
        for (;;)
        {
          if (i < localFragmentManagerState.Wj.length)
          {
            paramf = (Fragment)this.mActive.get(localFragmentManagerState.Wj[i]);
            if (paramf == null) {
              throwException(new IllegalStateException("No instantiated fragment for index #" + localFragmentManagerState.Wj[i]));
            }
            paramf.mAdded = true;
            if (DEBUG) {
              new StringBuilder("restoreAllState: added #").append(i).append(": ").append(paramf);
            }
            if (this.mAdded.contains(paramf))
            {
              ??? = new IllegalStateException("Already added!");
              AppMethodBeat.o(212754);
              throw ???;
            }
          }
          synchronized (this.mAdded)
          {
            this.mAdded.add(paramf);
            i += 1;
          }
        }
        i = 0;
        while (i < localFragmentManagerState.Wk.length)
        {
          ??? = localFragmentManagerState.Wk[i].a(this);
          if (DEBUG)
          {
            new StringBuilder("restoreAllState: back stack #").append(i).append(" (index ").append(???.mIndex).append("): ").append(???);
            paramf = new PrintWriter(new c("FragmentManager"));
            ???.a("  ", paramf, false);
            paramf.close();
          }
          this.mBackStack.add(???);
          if (???.mIndex >= 0) {
            setBackStackIndex(???.mIndex, ???);
          }
          i += 1;
          continue;
          this.mBackStack = null;
        }
        if (localFragmentManagerState.Wl >= 0) {
          this.mPrimaryNav = ((Fragment)this.mActive.get(localFragmentManagerState.Wl));
        }
        this.mNextFragmentIndex = localFragmentManagerState.mNextFragmentIndex;
        AppMethodBeat.o(212754);
        return;
      }
      ??? = null;
    }
  }
  
  final f retainNonConfig()
  {
    AppMethodBeat.i(212740);
    setRetaining(this.mSavedNonConfig);
    f localf = this.mSavedNonConfig;
    AppMethodBeat.o(212740);
    return localf;
  }
  
  final Parcelable saveAllState()
  {
    Object localObject3 = null;
    AppMethodBeat.i(212753);
    forcePostponedTransactions();
    endAnimatingAwayFragments();
    execPendingActions();
    this.mStateSaved = true;
    this.mSavedNonConfig = null;
    if ((this.mActive == null) || (this.mActive.size() <= 0))
    {
      AppMethodBeat.o(212753);
      return null;
    }
    int k = this.mActive.size();
    FragmentState[] arrayOfFragmentState = new FragmentState[k];
    int j = 0;
    int i = 0;
    Object localObject1;
    Object localObject2;
    if (j < k)
    {
      localObject1 = (Fragment)this.mActive.valueAt(j);
      if (localObject1 == null) {
        break label715;
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
        label314:
        if (DEBUG) {
          new StringBuilder("Saved state of ").append(localObject1).append(": ").append(((FragmentState)localObject2).mSavedFragmentState);
        }
        i = 1;
      }
    }
    label715:
    for (;;)
    {
      j += 1;
      break;
      ((FragmentState)localObject2).mSavedFragmentState = ((Fragment)localObject1).mSavedFragmentState;
      break label314;
      if (i == 0)
      {
        AppMethodBeat.o(212753);
        return null;
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
            localObject3[i] = new BackStackState((a)this.mBackStack.get(i));
            if (DEBUG) {
              new StringBuilder("saveAllState: adding back stack #").append(i).append(": ").append(this.mBackStack.get(i));
            }
            i += 1;
          }
        }
      }
      localObject3 = new FragmentManagerState();
      ((FragmentManagerState)localObject3).Wi = arrayOfFragmentState;
      ((FragmentManagerState)localObject3).Wj = ((int[])localObject1);
      ((FragmentManagerState)localObject3).Wk = ((BackStackState[])localObject2);
      if (this.mPrimaryNav != null) {
        ((FragmentManagerState)localObject3).Wl = this.mPrimaryNav.mIndex;
      }
      ((FragmentManagerState)localObject3).mNextFragmentIndex = this.mNextFragmentIndex;
      saveNonConfig();
      AppMethodBeat.o(212753);
      return localObject3;
    }
  }
  
  final Bundle saveFragmentBasicState(Fragment paramFragment)
  {
    AppMethodBeat.i(212748);
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
      AppMethodBeat.o(212748);
      return localObject2;
      localObject2 = null;
    }
  }
  
  public final Fragment.SavedState saveFragmentInstanceState(Fragment paramFragment)
  {
    AppMethodBeat.i(212617);
    if (paramFragment.mIndex < 0) {
      throwException(new IllegalStateException("Fragment " + paramFragment + " is not currently in the FragmentManager"));
    }
    if (paramFragment.mState > 0)
    {
      paramFragment = saveFragmentBasicState(paramFragment);
      if (paramFragment != null)
      {
        paramFragment = new Fragment.SavedState(paramFragment);
        AppMethodBeat.o(212617);
        return paramFragment;
      }
      AppMethodBeat.o(212617);
      return null;
    }
    AppMethodBeat.o(212617);
    return null;
  }
  
  final void saveFragmentViewState(Fragment paramFragment)
  {
    AppMethodBeat.i(212747);
    if (paramFragment.mInnerView == null)
    {
      AppMethodBeat.o(212747);
      return;
    }
    if (this.mStateArray == null) {
      this.mStateArray = new SparseArray();
    }
    for (;;)
    {
      paramFragment.mInnerView.saveHierarchyState(this.mStateArray);
      if (this.mStateArray.size() > 0)
      {
        paramFragment.mSavedViewState = this.mStateArray;
        this.mStateArray = null;
      }
      AppMethodBeat.o(212747);
      return;
      this.mStateArray.clear();
    }
  }
  
  final void saveNonConfig()
  {
    AppMethodBeat.i(212745);
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
              break label250;
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
              break label265;
            }
            localObject2 = localObject3;
            if (localObject5 == null) {
              break label265;
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
            label250:
            j = -1;
            break;
          }
          label265:
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
      AppMethodBeat.o(212745);
      return;
    }
    this.mSavedNonConfig = new f(localObject4, (List)localObject5, localObject6);
    AppMethodBeat.o(212745);
  }
  
  final void scheduleCommit()
  {
    int j = 1;
    AppMethodBeat.i(212702);
    for (;;)
    {
      int i;
      try
      {
        if ((this.mPostponedTransactions != null) && (!this.mPostponedTransactions.isEmpty()))
        {
          i = 1;
          if ((this.mPendingActions != null) && (this.mPendingActions.size() == 1))
          {
            break label109;
            this.mHost.mHandler.removeCallbacks(this.mExecCommit);
            this.mHost.mHandler.post(this.mExecCommit);
          }
        }
        else
        {
          i = 0;
          continue;
        }
        j = 0;
      }
      finally
      {
        AppMethodBeat.o(212702);
      }
      label109:
      if (i == 0) {
        if (j == 0) {}
      }
    }
  }
  
  /* Error */
  public final void setBackStackIndex(int paramInt, a parama)
  {
    // Byte code:
    //   0: ldc_w 1951
    //   3: invokestatic 141	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: monitorenter
    //   8: aload_0
    //   9: getfield 890	androidx/fragment/app/FragmentManagerImpl:mBackStackIndices	Ljava/util/ArrayList;
    //   12: ifnonnull +14 -> 26
    //   15: aload_0
    //   16: new 175	java/util/ArrayList
    //   19: dup
    //   20: invokespecial 176	java/util/ArrayList:<init>	()V
    //   23: putfield 890	androidx/fragment/app/FragmentManagerImpl:mBackStackIndices	Ljava/util/ArrayList;
    //   26: aload_0
    //   27: getfield 890	androidx/fragment/app/FragmentManagerImpl:mBackStackIndices	Ljava/util/ArrayList;
    //   30: invokevirtual 207	java/util/ArrayList:size	()I
    //   33: istore 4
    //   35: iload 4
    //   37: istore_3
    //   38: iload_1
    //   39: iload 4
    //   41: if_icmpge +53 -> 94
    //   44: getstatic 143	androidx/fragment/app/FragmentManagerImpl:DEBUG	Z
    //   47: ifeq +28 -> 75
    //   50: new 350	java/lang/StringBuilder
    //   53: dup
    //   54: ldc_w 892
    //   57: invokespecial 353	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   60: iload_1
    //   61: invokevirtual 895	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   64: ldc_w 897
    //   67: invokevirtual 357	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: aload_2
    //   71: invokevirtual 842	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   74: pop
    //   75: aload_0
    //   76: getfield 890	androidx/fragment/app/FragmentManagerImpl:mBackStackIndices	Ljava/util/ArrayList;
    //   79: iload_1
    //   80: aload_2
    //   81: invokevirtual 910	java/util/ArrayList:set	(ILjava/lang/Object;)Ljava/lang/Object;
    //   84: pop
    //   85: aload_0
    //   86: monitorexit
    //   87: ldc_w 1951
    //   90: invokestatic 167	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: return
    //   94: iload_3
    //   95: iload_1
    //   96: if_icmpge +49 -> 145
    //   99: aload_0
    //   100: getfield 890	androidx/fragment/app/FragmentManagerImpl:mBackStackIndices	Ljava/util/ArrayList;
    //   103: aconst_null
    //   104: invokevirtual 726	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   107: pop
    //   108: aload_0
    //   109: getfield 888	androidx/fragment/app/FragmentManagerImpl:mAvailBackStackIndices	Ljava/util/ArrayList;
    //   112: ifnonnull +14 -> 126
    //   115: aload_0
    //   116: new 175	java/util/ArrayList
    //   119: dup
    //   120: invokespecial 176	java/util/ArrayList:<init>	()V
    //   123: putfield 888	androidx/fragment/app/FragmentManagerImpl:mAvailBackStackIndices	Ljava/util/ArrayList;
    //   126: aload_0
    //   127: getfield 888	androidx/fragment/app/FragmentManagerImpl:mAvailBackStackIndices	Ljava/util/ArrayList;
    //   130: iload_3
    //   131: invokestatic 1272	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   134: invokevirtual 726	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   137: pop
    //   138: iload_3
    //   139: iconst_1
    //   140: iadd
    //   141: istore_3
    //   142: goto -48 -> 94
    //   145: getstatic 143	androidx/fragment/app/FragmentManagerImpl:DEBUG	Z
    //   148: ifeq +28 -> 176
    //   151: new 350	java/lang/StringBuilder
    //   154: dup
    //   155: ldc_w 904
    //   158: invokespecial 353	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   161: iload_1
    //   162: invokevirtual 895	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   165: ldc_w 906
    //   168: invokevirtual 357	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: aload_2
    //   172: invokevirtual 842	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   175: pop
    //   176: aload_0
    //   177: getfield 890	androidx/fragment/app/FragmentManagerImpl:mBackStackIndices	Ljava/util/ArrayList;
    //   180: aload_2
    //   181: invokevirtual 726	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   184: pop
    //   185: goto -100 -> 85
    //   188: astore_2
    //   189: aload_0
    //   190: monitorexit
    //   191: ldc_w 1951
    //   194: invokestatic 167	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   197: aload_2
    //   198: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	199	0	this	FragmentManagerImpl
    //   0	199	1	paramInt	int
    //   0	199	2	parama	a
    //   37	105	3	i	int
    //   33	9	4	j	int
    // Exception table:
    //   from	to	target	type
    //   8	26	188	finally
    //   26	35	188	finally
    //   44	75	188	finally
    //   75	85	188	finally
    //   85	87	188	finally
    //   99	126	188	finally
    //   126	138	188	finally
    //   145	176	188	finally
    //   176	185	188	finally
  }
  
  public final void setPrimaryNavigationFragment(Fragment paramFragment)
  {
    AppMethodBeat.i(212787);
    if ((paramFragment != null) && ((this.mActive.get(paramFragment.mIndex) != paramFragment) || ((paramFragment.mHost != null) && (paramFragment.getFragmentManager() != this))))
    {
      paramFragment = new IllegalArgumentException("Fragment " + paramFragment + " is not an active fragment of FragmentManager " + this);
      AppMethodBeat.o(212787);
      throw paramFragment;
    }
    this.mPrimaryNav = paramFragment;
    AppMethodBeat.o(212787);
  }
  
  public final void showFragment(Fragment paramFragment)
  {
    boolean bool = false;
    AppMethodBeat.i(212683);
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
    AppMethodBeat.o(212683);
  }
  
  final void startPendingDeferredFragments()
  {
    AppMethodBeat.i(212667);
    if (this.mActive == null)
    {
      AppMethodBeat.o(212667);
      return;
    }
    int i = 0;
    while (i < this.mActive.size())
    {
      Fragment localFragment = (Fragment)this.mActive.valueAt(i);
      if (localFragment != null) {
        performPendingDeferredStart(localFragment);
      }
      i += 1;
    }
    AppMethodBeat.o(212667);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(212621);
    Object localObject = new StringBuilder(128);
    ((StringBuilder)localObject).append("FragmentManager{");
    ((StringBuilder)localObject).append(Integer.toHexString(System.identityHashCode(this)));
    ((StringBuilder)localObject).append(" in ");
    if (this.mParent != null) {
      androidx.core.f.b.a(this.mParent, (StringBuilder)localObject);
    }
    for (;;)
    {
      ((StringBuilder)localObject).append("}}");
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(212621);
      return localObject;
      androidx.core.f.b.a(this.mHost, (StringBuilder)localObject);
    }
  }
  
  public final void unregisterFragmentLifecycleCallbacks(e.b paramb)
  {
    AppMethodBeat.i(212791);
    synchronized (this.mLifecycleCallbacks)
    {
      int j = this.mLifecycleCallbacks.size();
      int i = 0;
      if (i < j)
      {
        if (((f)this.mLifecycleCallbacks.get(i)).VZ == paramb) {
          this.mLifecycleCallbacks.remove(i);
        }
      }
      else
      {
        AppMethodBeat.o(212791);
        return;
      }
      i += 1;
    }
  }
  
  static class c
  {
    public final Animation VT;
    public final Animator VU;
    
    c(Animator paramAnimator)
    {
      AppMethodBeat.i(212489);
      this.VT = null;
      this.VU = paramAnimator;
      if (paramAnimator == null)
      {
        paramAnimator = new IllegalStateException("Animator cannot be null");
        AppMethodBeat.o(212489);
        throw paramAnimator;
      }
      AppMethodBeat.o(212489);
    }
    
    c(Animation paramAnimation)
    {
      AppMethodBeat.i(212487);
      this.VT = paramAnimation;
      this.VU = null;
      if (paramAnimation == null)
      {
        paramAnimation = new IllegalStateException("Animation cannot be null");
        AppMethodBeat.o(212487);
        throw paramAnimation;
      }
      AppMethodBeat.o(212487);
    }
  }
  
  static final class e
    extends AnimationSet
    implements Runnable
  {
    private boolean PJ;
    private final ViewGroup VV;
    private final View VW;
    private boolean VX;
    private boolean VY;
    
    e(Animation paramAnimation, ViewGroup paramViewGroup, View paramView)
    {
      super();
      AppMethodBeat.i(212497);
      this.PJ = true;
      this.VV = paramViewGroup;
      this.VW = paramView;
      addAnimation(paramAnimation);
      this.VV.post(this);
      AppMethodBeat.o(212497);
    }
    
    public final boolean getTransformation(long paramLong, Transformation paramTransformation)
    {
      AppMethodBeat.i(212499);
      this.PJ = true;
      if (this.VX)
      {
        if (!this.VY)
        {
          AppMethodBeat.o(212499);
          return true;
        }
        AppMethodBeat.o(212499);
        return false;
      }
      if (!super.getTransformation(paramLong, paramTransformation))
      {
        this.VX = true;
        m.b(this.VV, this);
      }
      AppMethodBeat.o(212499);
      return true;
    }
    
    public final boolean getTransformation(long paramLong, Transformation paramTransformation, float paramFloat)
    {
      AppMethodBeat.i(212501);
      this.PJ = true;
      if (this.VX)
      {
        if (!this.VY)
        {
          AppMethodBeat.o(212501);
          return true;
        }
        AppMethodBeat.o(212501);
        return false;
      }
      if (!super.getTransformation(paramLong, paramTransformation, paramFloat))
      {
        this.VX = true;
        m.b(this.VV, this);
      }
      AppMethodBeat.o(212501);
      return true;
    }
    
    public final void run()
    {
      AppMethodBeat.i(212503);
      if ((!this.VX) && (this.PJ))
      {
        this.PJ = false;
        this.VV.post(this);
        AppMethodBeat.o(212503);
        return;
      }
      this.VV.endViewTransition(this.VW);
      this.VY = true;
      AppMethodBeat.o(212503);
    }
  }
  
  static final class f
  {
    final e.b VZ;
    final boolean Wa;
    
    f(e.b paramb, boolean paramBoolean)
    {
      this.VZ = paramb;
      this.Wa = paramBoolean;
    }
  }
  
  static final class g
  {
    public static final int[] Wb = { 16842755, 16842960, 16842961 };
  }
  
  static abstract interface h
  {
    public abstract boolean a(ArrayList<a> paramArrayList, ArrayList<Boolean> paramArrayList1);
  }
  
  final class i
    implements FragmentManagerImpl.h
  {
    final int cN;
    final int mId;
    final String mName;
    
    i(String paramString, int paramInt1, int paramInt2)
    {
      this.mName = paramString;
      this.mId = paramInt1;
      this.cN = paramInt2;
    }
    
    public final boolean a(ArrayList<a> paramArrayList, ArrayList<Boolean> paramArrayList1)
    {
      AppMethodBeat.i(212519);
      if ((FragmentManagerImpl.this.mPrimaryNav != null) && (this.mId < 0) && (this.mName == null))
      {
        e locale = FragmentManagerImpl.this.mPrimaryNav.peekChildFragmentManager();
        if ((locale != null) && (locale.popBackStackImmediate()))
        {
          AppMethodBeat.o(212519);
          return false;
        }
      }
      boolean bool = FragmentManagerImpl.this.popBackStackState(paramArrayList, paramArrayList1, this.mName, this.mId, this.cN);
      AppMethodBeat.o(212519);
      return bool;
    }
  }
  
  static final class j
    implements Fragment.c
  {
    final boolean Wc;
    final a Wd;
    int We;
    
    j(a parama, boolean paramBoolean)
    {
      this.Wc = paramBoolean;
      this.Wd = parama;
    }
    
    public final void iC()
    {
      boolean bool1 = false;
      AppMethodBeat.i(212535);
      if (this.We > 0) {}
      for (int i = 1;; i = 0)
      {
        localFragmentManagerImpl = this.Wd.UN;
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
      FragmentManagerImpl localFragmentManagerImpl = this.Wd.UN;
      Object localObject = this.Wd;
      boolean bool2 = this.Wc;
      if (i == 0) {
        bool1 = true;
      }
      localFragmentManagerImpl.completeExecute((a)localObject, bool2, bool1, true);
      AppMethodBeat.o(212535);
    }
    
    public final void iD()
    {
      AppMethodBeat.i(212536);
      this.Wd.UN.completeExecute(this.Wd, this.Wc, false, false);
      AppMethodBeat.o(212536);
    }
    
    public final void iu()
    {
      AppMethodBeat.i(212531);
      this.We -= 1;
      if (this.We != 0)
      {
        AppMethodBeat.o(212531);
        return;
      }
      this.Wd.UN.scheduleCommit();
      AppMethodBeat.o(212531);
    }
    
    public final void iv()
    {
      this.We += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.fragment.app.FragmentManagerImpl
 * JD-Core Version:    0.7.0.1
 */