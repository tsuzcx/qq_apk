package androidx.fragment.app;

import android.app.Activity;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.g.z;
import androidx.fragment.a.b;
import androidx.lifecycle.aj;
import androidx.lifecycle.ak;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class o
{
  private final i bDu;
  final Fragment bDv;
  private boolean bDw;
  int bDx;
  private final q mFragmentStore;
  
  o(i parami, q paramq, Fragment paramFragment)
  {
    this.bDw = false;
    this.bDx = -1;
    this.bDu = parami;
    this.mFragmentStore = paramq;
    this.bDv = paramFragment;
  }
  
  o(i parami, q paramq, Fragment paramFragment, FragmentState paramFragmentState)
  {
    AppMethodBeat.i(193757);
    this.bDw = false;
    this.bDx = -1;
    this.bDu = parami;
    this.mFragmentStore = paramq;
    this.bDv = paramFragment;
    this.bDv.mSavedViewState = null;
    this.bDv.mSavedViewRegistryState = null;
    this.bDv.mBackStackNesting = 0;
    this.bDv.mInLayout = false;
    this.bDv.mAdded = false;
    paramq = this.bDv;
    if (this.bDv.mTarget != null) {}
    for (parami = this.bDv.mTarget.mWho;; parami = null)
    {
      paramq.mTargetWho = parami;
      this.bDv.mTarget = null;
      if (paramFragmentState.mSavedFragmentState == null) {
        break;
      }
      this.bDv.mSavedFragmentState = paramFragmentState.mSavedFragmentState;
      AppMethodBeat.o(193757);
      return;
    }
    this.bDv.mSavedFragmentState = new Bundle();
    AppMethodBeat.o(193757);
  }
  
  o(i parami, q paramq, ClassLoader paramClassLoader, f paramf, FragmentState paramFragmentState)
  {
    AppMethodBeat.i(193742);
    this.bDw = false;
    this.bDx = -1;
    this.bDu = parami;
    this.mFragmentStore = paramq;
    this.bDv = paramf.d(paramClassLoader, paramFragmentState.mClassName);
    if (paramFragmentState.mArguments != null) {
      paramFragmentState.mArguments.setClassLoader(paramClassLoader);
    }
    this.bDv.setArguments(paramFragmentState.mArguments);
    this.bDv.mWho = paramFragmentState.mWho;
    this.bDv.mFromLayout = paramFragmentState.mFromLayout;
    this.bDv.mRestored = true;
    this.bDv.mFragmentId = paramFragmentState.mFragmentId;
    this.bDv.mContainerId = paramFragmentState.mContainerId;
    this.bDv.mTag = paramFragmentState.mTag;
    this.bDv.mRetainInstance = paramFragmentState.mRetainInstance;
    this.bDv.mRemoving = paramFragmentState.mRemoving;
    this.bDv.mDetached = paramFragmentState.mDetached;
    this.bDv.mHidden = paramFragmentState.mHidden;
    this.bDv.mMaxState = androidx.lifecycle.j.b.values()[paramFragmentState.bDt];
    if (paramFragmentState.mSavedFragmentState != null) {}
    for (this.bDv.mSavedFragmentState = paramFragmentState.mSavedFragmentState;; this.bDv.mSavedFragmentState = new Bundle())
    {
      if (FragmentManager.isLoggingEnabled(2)) {
        new StringBuilder("Instantiated fragment ").append(this.bDv);
      }
      AppMethodBeat.o(193742);
      return;
    }
  }
  
  private boolean ba(View paramView)
  {
    AppMethodBeat.i(193765);
    if (paramView == this.bDv.mView)
    {
      AppMethodBeat.o(193765);
      return true;
    }
    for (paramView = paramView.getParent(); paramView != null; paramView = paramView.getParent()) {
      if (paramView == this.bDv.mView)
      {
        AppMethodBeat.o(193765);
        return true;
      }
    }
    AppMethodBeat.o(193765);
    return false;
  }
  
  final int Gp()
  {
    AppMethodBeat.i(193784);
    if (this.bDv.mFragmentManager == null)
    {
      i = this.bDv.mState;
      AppMethodBeat.o(193784);
      return i;
    }
    int i = this.bDx;
    int j = i;
    label150:
    Object localObject1;
    switch (o.2.bDA[this.bDv.mMaxState.ordinal()])
    {
    default: 
      j = Math.min(i, -1);
    case 1: 
      i = j;
      if (this.bDv.mFromLayout)
      {
        if (!this.bDv.mInLayout) {
          break;
        }
        j = Math.max(this.bDx, 2);
        i = j;
        if (this.bDv.mView != null)
        {
          i = j;
          if (this.bDv.mView.getParent() == null) {
            i = Math.min(j, 2);
          }
        }
      }
      j = i;
      if (!this.bDv.mAdded) {
        j = Math.min(i, 1);
      }
      Object localObject2 = null;
      localObject1 = localObject2;
      if (FragmentManager.USE_STATE_MANAGER)
      {
        localObject1 = localObject2;
        if (this.bDv.mContainer != null) {
          localObject1 = x.a(this.bDv.mContainer, this.bDv.getParentFragmentManager()).c(this);
        }
      }
      if (localObject1 == x.b.a.bET) {
        i = Math.min(j, 6);
      }
      break;
    }
    for (;;)
    {
      j = i;
      if (this.bDv.mDeferStart)
      {
        j = i;
        if (this.bDv.mState < 5) {
          j = Math.min(i, 4);
        }
      }
      if (FragmentManager.isLoggingEnabled(2)) {
        new StringBuilder("computeExpectedState() of ").append(j).append(" for ").append(this.bDv);
      }
      AppMethodBeat.o(193784);
      return j;
      j = Math.min(i, 5);
      break;
      j = Math.min(i, 1);
      break;
      j = Math.min(i, 0);
      break;
      if (this.bDx < 4)
      {
        i = Math.min(j, this.bDv.mState);
        break label150;
      }
      i = Math.min(j, 1);
      break label150;
      if (localObject1 == x.b.a.bEU)
      {
        i = Math.max(j, 3);
      }
      else
      {
        i = j;
        if (this.bDv.mRemoving) {
          if (this.bDv.isInBackStack()) {
            i = Math.min(j, 1);
          } else {
            i = Math.min(j, -1);
          }
        }
      }
    }
  }
  
  final void Gq()
  {
    AppMethodBeat.i(193805);
    if (this.bDw)
    {
      if (FragmentManager.isLoggingEnabled(2)) {
        new StringBuilder("Ignoring re-entrant call to moveToExpectedState() for ").append(this.bDv);
      }
      AppMethodBeat.o(193805);
      return;
    }
    for (;;)
    {
      try
      {
        this.bDw = true;
        int i = Gp();
        if (i == this.bDv.mState) {
          break label498;
        }
        if (i <= this.bDv.mState) {
          break label269;
        }
        switch (this.bDv.mState + 1)
        {
        case 0: 
          vX();
          break;
        case 1: 
          create();
        }
      }
      finally
      {
        this.bDw = false;
        AppMethodBeat.o(193805);
      }
      continue;
      Gr();
      Gs();
      continue;
      Gt();
      continue;
      if ((this.bDv.mView != null) && (this.bDv.mContainer != null)) {
        x.a(this.bDv.mContainer, this.bDv.getParentFragmentManager()).a(x.b.b.eU(this.bDv.mView.getVisibility()), this);
      }
      this.bDv.mState = 4;
      continue;
      start();
      continue;
      this.bDv.mState = 6;
      continue;
      resume();
      continue;
      label269:
      switch (this.bDv.mState - 1)
      {
      case -1: 
        detach();
        break;
      case 6: 
        pause();
        break;
      case 5: 
        this.bDv.mState = 5;
        break;
      case 4: 
        stop();
        break;
      case 3: 
        if (FragmentManager.isLoggingEnabled(3)) {
          new StringBuilder("movefrom ACTIVITY_CREATED: ").append(this.bDv);
        }
        if ((this.bDv.mView != null) && (this.bDv.mSavedViewState == null)) {
          Gv();
        }
        if ((this.bDv.mView != null) && (this.bDv.mContainer != null)) {
          x.a(this.bDv.mContainer, this.bDv.getParentFragmentManager()).f(this);
        }
        this.bDv.mState = 3;
        break;
      case 2: 
        this.bDv.mInLayout = false;
        this.bDv.mState = 2;
        break;
      case 1: 
        Gw();
        this.bDv.mState = 1;
        break;
      case 0: 
        destroy();
        continue;
        label498:
        x localx;
        if ((FragmentManager.USE_STATE_MANAGER) && (this.bDv.mHiddenChanged)) {
          if ((this.bDv.mView != null) && (this.bDv.mContainer != null))
          {
            localx = x.a(this.bDv.mContainer, this.bDv.getParentFragmentManager());
            if (!this.bDv.mHidden) {
              break label625;
            }
            localx.e(this);
          }
        }
        for (;;)
        {
          if (this.bDv.mFragmentManager != null) {
            this.bDv.mFragmentManager.invalidateMenuForFragment(this.bDv);
          }
          this.bDv.mHiddenChanged = false;
          this.bDv.onHiddenChanged(this.bDv.mHidden);
          this.bDw = false;
          AppMethodBeat.o(193805);
          return;
          label625:
          localx.d(this);
        }
      }
    }
  }
  
  final void Gr()
  {
    AppMethodBeat.i(193818);
    if ((this.bDv.mFromLayout) && (this.bDv.mInLayout) && (!this.bDv.mPerformedCreateView))
    {
      if (FragmentManager.isLoggingEnabled(3)) {
        new StringBuilder("moveto CREATE_VIEW: ").append(this.bDv);
      }
      this.bDv.performCreateView(this.bDv.performGetLayoutInflater(this.bDv.mSavedFragmentState), null, this.bDv.mSavedFragmentState);
      if (this.bDv.mView != null)
      {
        this.bDv.mView.setSaveFromParentEnabled(false);
        this.bDv.mView.setTag(a.b.fragment_container_view_tag, this.bDv);
        if (this.bDv.mHidden) {
          this.bDv.mView.setVisibility(8);
        }
        this.bDv.performViewCreated();
        this.bDu.a(this.bDv, this.bDv.mView, this.bDv.mSavedFragmentState);
        this.bDv.mState = 2;
      }
    }
    AppMethodBeat.o(193818);
  }
  
  final void Gs()
  {
    AppMethodBeat.i(193878);
    if (this.bDv.mFromLayout)
    {
      AppMethodBeat.o(193878);
      return;
    }
    if (FragmentManager.isLoggingEnabled(3)) {
      new StringBuilder("moveto CREATE_VIEW: ").append(this.bDv);
    }
    LayoutInflater localLayoutInflater = this.bDv.performGetLayoutInflater(this.bDv.mSavedFragmentState);
    Object localObject1 = null;
    if (this.bDv.mContainer != null)
    {
      localObject1 = this.bDv.mContainer;
      this.bDv.mContainer = ((ViewGroup)localObject1);
      this.bDv.performCreateView(localLayoutInflater, (ViewGroup)localObject1, this.bDv.mSavedFragmentState);
      if (this.bDv.mView != null)
      {
        this.bDv.mView.setSaveFromParentEnabled(false);
        this.bDv.mView.setTag(a.b.fragment_container_view_tag, this.bDv);
        if (localObject1 != null) {
          Gx();
        }
        if (this.bDv.mHidden) {
          this.bDv.mView.setVisibility(8);
        }
        if (!z.ay(this.bDv.mView)) {
          break label585;
        }
        z.ak(this.bDv.mView);
      }
    }
    int i;
    for (;;)
    {
      this.bDv.performViewCreated();
      this.bDu.a(this.bDv, this.bDv.mView, this.bDv.mSavedFragmentState);
      i = this.bDv.mView.getVisibility();
      float f = this.bDv.mView.getAlpha();
      if (!FragmentManager.USE_STATE_MANAGER) {
        break label612;
      }
      this.bDv.setPostOnViewCreatedAlpha(f);
      if ((this.bDv.mContainer != null) && (i == 0))
      {
        localObject1 = this.bDv.mView.findFocus();
        if (localObject1 != null)
        {
          this.bDv.setFocusedView((View)localObject1);
          if (FragmentManager.isLoggingEnabled(2)) {
            new StringBuilder("requestFocus: Saved focused view ").append(localObject1).append(" for Fragment ").append(this.bDv);
          }
        }
        this.bDv.mView.setAlpha(0.0F);
      }
      this.bDv.mState = 2;
      AppMethodBeat.o(193878);
      return;
      if (this.bDv.mContainerId == 0) {
        break;
      }
      if (this.bDv.mContainerId == -1)
      {
        localObject1 = new IllegalArgumentException("Cannot create fragment " + this.bDv + " for a container view with no id");
        AppMethodBeat.o(193878);
        throw ((Throwable)localObject1);
      }
      ViewGroup localViewGroup = (ViewGroup)this.bDv.mFragmentManager.getContainer().onFindViewById(this.bDv.mContainerId);
      localObject1 = localViewGroup;
      if (localViewGroup != null) {
        break;
      }
      localObject1 = localViewGroup;
      if (this.bDv.mRestored) {
        break;
      }
      try
      {
        localObject1 = this.bDv.getResources().getResourceName(this.bDv.mContainerId);
        localObject1 = new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(this.bDv.mContainerId) + " (" + (String)localObject1 + ") for fragment " + this.bDv);
        AppMethodBeat.o(193878);
        throw ((Throwable)localObject1);
      }
      catch (Resources.NotFoundException localNotFoundException)
      {
        for (;;)
        {
          localObject2 = "unknown";
        }
      }
      label585:
      localObject2 = this.bDv.mView;
      ((View)localObject2).addOnAttachStateChangeListener(new View.OnAttachStateChangeListener()
      {
        public final void onViewAttachedToWindow(View paramAnonymousView)
        {
          AppMethodBeat.i(193495);
          this.bDy.removeOnAttachStateChangeListener(this);
          z.ak(this.bDy);
          AppMethodBeat.o(193495);
        }
        
        public final void onViewDetachedFromWindow(View paramAnonymousView) {}
      });
    }
    label612:
    Object localObject2 = this.bDv;
    if ((i == 0) && (this.bDv.mContainer != null)) {}
    for (boolean bool = true;; bool = false)
    {
      ((Fragment)localObject2).mIsNewlyAdded = bool;
      break;
    }
  }
  
  final void Gt()
  {
    AppMethodBeat.i(193888);
    if (FragmentManager.isLoggingEnabled(3)) {
      new StringBuilder("moveto ACTIVITY_CREATED: ").append(this.bDv);
    }
    this.bDv.performActivityCreated(this.bDv.mSavedFragmentState);
    this.bDu.c(this.bDv, this.bDv.mSavedFragmentState);
    AppMethodBeat.o(193888);
  }
  
  final Bundle Gu()
  {
    AppMethodBeat.i(193950);
    Object localObject2 = new Bundle();
    this.bDv.performSaveInstanceState((Bundle)localObject2);
    this.bDu.d(this.bDv, (Bundle)localObject2);
    Object localObject1 = localObject2;
    if (((Bundle)localObject2).isEmpty()) {
      localObject1 = null;
    }
    if (this.bDv.mView != null) {
      Gv();
    }
    localObject2 = localObject1;
    if (this.bDv.mSavedViewState != null)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new Bundle();
      }
      ((Bundle)localObject2).putSparseParcelableArray("android:view_state", this.bDv.mSavedViewState);
    }
    localObject1 = localObject2;
    if (this.bDv.mSavedViewRegistryState != null)
    {
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new Bundle();
      }
      ((Bundle)localObject1).putBundle("android:view_registry_state", this.bDv.mSavedViewRegistryState);
    }
    localObject2 = localObject1;
    if (!this.bDv.mUserVisibleHint)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new Bundle();
      }
      ((Bundle)localObject2).putBoolean("android:user_visible_hint", this.bDv.mUserVisibleHint);
    }
    AppMethodBeat.o(193950);
    return localObject2;
  }
  
  final void Gv()
  {
    AppMethodBeat.i(193963);
    if (this.bDv.mView == null)
    {
      AppMethodBeat.o(193963);
      return;
    }
    Object localObject = new SparseArray();
    this.bDv.mView.saveHierarchyState((SparseArray)localObject);
    if (((SparseArray)localObject).size() > 0) {
      this.bDv.mSavedViewState = ((SparseArray)localObject);
    }
    localObject = new Bundle();
    this.bDv.mViewLifecycleOwner.m((Bundle)localObject);
    if (!((Bundle)localObject).isEmpty()) {
      this.bDv.mSavedViewRegistryState = ((Bundle)localObject);
    }
    AppMethodBeat.o(193963);
  }
  
  final void Gw()
  {
    AppMethodBeat.i(193979);
    if (FragmentManager.isLoggingEnabled(3)) {
      new StringBuilder("movefrom CREATE_VIEW: ").append(this.bDv);
    }
    if ((this.bDv.mContainer != null) && (this.bDv.mView != null)) {
      this.bDv.mContainer.removeView(this.bDv.mView);
    }
    this.bDv.performDestroyView();
    this.bDu.l(this.bDv);
    this.bDv.mContainer = null;
    this.bDv.mView = null;
    this.bDv.mViewLifecycleOwner = null;
    this.bDv.mViewLifecycleOwnerLiveData.setValue(null);
    this.bDv.mInLayout = false;
    AppMethodBeat.o(193979);
  }
  
  final void Gx()
  {
    AppMethodBeat.i(194029);
    int i = this.mFragmentStore.q(this.bDv);
    this.bDv.mContainer.addView(this.bDv.mView, i);
    AppMethodBeat.o(194029);
  }
  
  final void a(ClassLoader paramClassLoader)
  {
    AppMethodBeat.i(193837);
    if (this.bDv.mSavedFragmentState == null)
    {
      AppMethodBeat.o(193837);
      return;
    }
    this.bDv.mSavedFragmentState.setClassLoader(paramClassLoader);
    this.bDv.mSavedViewState = this.bDv.mSavedFragmentState.getSparseParcelableArray("android:view_state");
    this.bDv.mSavedViewRegistryState = this.bDv.mSavedFragmentState.getBundle("android:view_registry_state");
    this.bDv.mTargetWho = this.bDv.mSavedFragmentState.getString("android:target_state");
    if (this.bDv.mTargetWho != null) {
      this.bDv.mTargetRequestCode = this.bDv.mSavedFragmentState.getInt("android:target_req_state", 0);
    }
    if (this.bDv.mSavedUserVisibleHint != null)
    {
      this.bDv.mUserVisibleHint = this.bDv.mSavedUserVisibleHint.booleanValue();
      this.bDv.mSavedUserVisibleHint = null;
    }
    for (;;)
    {
      if (!this.bDv.mUserVisibleHint) {
        this.bDv.mDeferStart = true;
      }
      AppMethodBeat.o(193837);
      return;
      this.bDv.mUserVisibleHint = this.bDv.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
    }
  }
  
  final void create()
  {
    AppMethodBeat.i(193863);
    if (FragmentManager.isLoggingEnabled(3)) {
      new StringBuilder("moveto CREATED: ").append(this.bDv);
    }
    if (!this.bDv.mIsCreated)
    {
      this.bDu.a(this.bDv, this.bDv.mSavedFragmentState);
      this.bDv.performCreate(this.bDv.mSavedFragmentState);
      this.bDu.b(this.bDv, this.bDv.mSavedFragmentState);
      AppMethodBeat.o(193863);
      return;
    }
    this.bDv.restoreChildFragmentState(this.bDv.mSavedFragmentState);
    this.bDv.mState = 1;
    AppMethodBeat.o(193863);
  }
  
  final void destroy()
  {
    AppMethodBeat.i(194006);
    if (FragmentManager.isLoggingEnabled(3)) {
      new StringBuilder("movefrom CREATED: ").append(this.bDv);
    }
    int i;
    int j;
    label76:
    Object localObject1;
    boolean bool;
    if ((this.bDv.mRemoving) && (!this.bDv.isInBackStack()))
    {
      i = 1;
      if ((i == 0) && (!this.mFragmentStore.mNonConfig.o(this.bDv))) {
        break label345;
      }
      j = 1;
      if (j == 0) {
        break label436;
      }
      localObject1 = this.bDv.mHost;
      if (!(localObject1 instanceof ak)) {
        break label350;
      }
      bool = this.mFragmentStore.mNonConfig.bDq;
    }
    for (;;)
    {
      Object localObject2;
      if ((i != 0) || (bool))
      {
        localObject1 = this.mFragmentStore.mNonConfig;
        localObject2 = this.bDv;
        if (FragmentManager.isLoggingEnabled(3)) {
          new StringBuilder("Clearing non-config state for ").append(localObject2);
        }
        Object localObject3 = (k)((k)localObject1).bDn.get(((Fragment)localObject2).mWho);
        if (localObject3 != null)
        {
          ((k)localObject3).onCleared();
          ((k)localObject1).bDn.remove(((Fragment)localObject2).mWho);
        }
        localObject3 = (aj)((k)localObject1).bDo.get(((Fragment)localObject2).mWho);
        if (localObject3 != null)
        {
          ((aj)localObject3).clear();
          ((k)localObject1).bDo.remove(((Fragment)localObject2).mWho);
        }
      }
      this.bDv.performDestroy();
      this.bDu.m(this.bDv);
      localObject1 = this.mFragmentStore.GA().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (o)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          localObject2 = ((o)localObject2).bDv;
          if (this.bDv.mWho.equals(((Fragment)localObject2).mTargetWho))
          {
            ((Fragment)localObject2).mTarget = this.bDv;
            ((Fragment)localObject2).mTargetWho = null;
          }
        }
      }
      i = 0;
      break;
      label345:
      j = 0;
      break label76;
      label350:
      if ((((g)localObject1).mContext instanceof Activity))
      {
        if (!((Activity)((g)localObject1).mContext).isChangingConfigurations()) {
          bool = true;
        } else {
          bool = false;
        }
      }
      else {
        bool = true;
      }
    }
    if (this.bDv.mTargetWho != null) {
      this.bDv.mTarget = this.mFragmentStore.findActiveFragment(this.bDv.mTargetWho);
    }
    this.mFragmentStore.b(this);
    AppMethodBeat.o(194006);
    return;
    label436:
    if (this.bDv.mTargetWho != null)
    {
      localObject1 = this.mFragmentStore.findActiveFragment(this.bDv.mTargetWho);
      if ((localObject1 != null) && (((Fragment)localObject1).mRetainInstance)) {
        this.bDv.mTarget = ((Fragment)localObject1);
      }
    }
    this.bDv.mState = 0;
    AppMethodBeat.o(194006);
  }
  
  final void detach()
  {
    AppMethodBeat.i(194018);
    if (FragmentManager.isLoggingEnabled(3)) {
      new StringBuilder("movefrom ATTACHED: ").append(this.bDv);
    }
    this.bDv.performDetach();
    this.bDu.n(this.bDv);
    this.bDv.mState = -1;
    this.bDv.mHost = null;
    this.bDv.mParentFragment = null;
    this.bDv.mFragmentManager = null;
    if ((this.bDv.mRemoving) && (!this.bDv.isInBackStack())) {}
    for (int i = 1;; i = 0)
    {
      if ((i != 0) || (this.mFragmentStore.mNonConfig.o(this.bDv)))
      {
        if (FragmentManager.isLoggingEnabled(3)) {
          new StringBuilder("initState called for fragment: ").append(this.bDv);
        }
        this.bDv.initState();
      }
      AppMethodBeat.o(194018);
      return;
    }
  }
  
  final void pause()
  {
    AppMethodBeat.i(193922);
    if (FragmentManager.isLoggingEnabled(3)) {
      new StringBuilder("movefrom RESUMED: ").append(this.bDv);
    }
    this.bDv.performPause();
    this.bDu.j(this.bDv);
    AppMethodBeat.o(193922);
  }
  
  final void resume()
  {
    AppMethodBeat.i(193912);
    if (FragmentManager.isLoggingEnabled(3)) {
      new StringBuilder("moveto RESUMED: ").append(this.bDv);
    }
    Object localObject = this.bDv.getFocusedView();
    StringBuilder localStringBuilder;
    if ((localObject != null) && (ba((View)localObject)))
    {
      boolean bool = ((View)localObject).requestFocus();
      if (FragmentManager.isLoggingEnabled(2))
      {
        localStringBuilder = new StringBuilder("requestFocus: Restoring focused view ").append(localObject).append(" ");
        if (!bool) {
          break label187;
        }
      }
    }
    label187:
    for (localObject = "succeeded";; localObject = "failed")
    {
      localStringBuilder.append((String)localObject).append(" on Fragment ").append(this.bDv).append(" resulting in focused view ").append(this.bDv.mView.findFocus());
      this.bDv.setFocusedView(null);
      this.bDv.performResume();
      this.bDu.i(this.bDv);
      this.bDv.mSavedFragmentState = null;
      this.bDv.mSavedViewState = null;
      this.bDv.mSavedViewRegistryState = null;
      AppMethodBeat.o(193912);
      return;
    }
  }
  
  final void start()
  {
    AppMethodBeat.i(193897);
    if (FragmentManager.isLoggingEnabled(3)) {
      new StringBuilder("moveto STARTED: ").append(this.bDv);
    }
    this.bDv.performStart();
    this.bDu.h(this.bDv);
    AppMethodBeat.o(193897);
  }
  
  final void stop()
  {
    AppMethodBeat.i(193935);
    if (FragmentManager.isLoggingEnabled(3)) {
      new StringBuilder("movefrom STARTED: ").append(this.bDv);
    }
    this.bDv.performStop();
    this.bDu.k(this.bDv);
    AppMethodBeat.o(193935);
  }
  
  final void vX()
  {
    AppMethodBeat.i(193852);
    if (FragmentManager.isLoggingEnabled(3)) {
      new StringBuilder("moveto ATTACHED: ").append(this.bDv);
    }
    Object localObject;
    if (this.bDv.mTarget != null)
    {
      localObject = this.mFragmentStore.aH(this.bDv.mTarget.mWho);
      if (localObject == null)
      {
        localObject = new IllegalStateException("Fragment " + this.bDv + " declared target fragment " + this.bDv.mTarget + " that does not belong to this FragmentManager!");
        AppMethodBeat.o(193852);
        throw ((Throwable)localObject);
      }
      this.bDv.mTargetWho = this.bDv.mTarget.mWho;
      this.bDv.mTarget = null;
    }
    for (;;)
    {
      if ((localObject != null) && ((FragmentManager.USE_STATE_MANAGER) || (((o)localObject).bDv.mState <= 0))) {
        ((o)localObject).Gq();
      }
      this.bDv.mHost = this.bDv.mFragmentManager.getHost();
      this.bDv.mParentFragment = this.bDv.mFragmentManager.getParent();
      this.bDu.f(this.bDv);
      this.bDv.performAttach();
      this.bDu.g(this.bDv);
      AppMethodBeat.o(193852);
      return;
      if (this.bDv.mTargetWho != null)
      {
        o localo = this.mFragmentStore.aH(this.bDv.mTargetWho);
        localObject = localo;
        if (localo == null)
        {
          localObject = new IllegalStateException("Fragment " + this.bDv + " declared target fragment " + this.bDv.mTargetWho + " that does not belong to this FragmentManager!");
          AppMethodBeat.o(193852);
          throw ((Throwable)localObject);
        }
      }
      else
      {
        localObject = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.fragment.app.o
 * JD-Core Version:    0.7.0.1
 */