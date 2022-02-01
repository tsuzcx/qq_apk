package com.tencent.mm.plugin.finder.view.adapter;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.Fragment.SavedState;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.r;
import androidx.viewpager.widget.a;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/adapter/StatePagerAdapterCp;", "Landroidx/viewpager/widget/PagerAdapter;", "fm", "Landroidx/fragment/app/FragmentManager;", "(Landroidx/fragment/app/FragmentManager;)V", "getFm", "()Landroidx/fragment/app/FragmentManager;", "mCurTransaction", "Landroidx/fragment/app/FragmentTransaction;", "getMCurTransaction", "()Landroidx/fragment/app/FragmentTransaction;", "setMCurTransaction", "(Landroidx/fragment/app/FragmentTransaction;)V", "mCurrentPrimaryItem", "Landroidx/fragment/app/Fragment;", "mFragmentManager", "mFragments", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getMFragments", "()Ljava/util/ArrayList;", "mSavedState", "Landroidx/fragment/app/Fragment$SavedState;", "getMSavedState", "destroyItem", "", "container", "Landroid/view/ViewGroup;", "position", "", "object", "", "finishUpdate", "getItem", "index", "instantiateItem", "isViewFromObject", "", "view", "Landroid/view/View;", "restoreState", "state", "Landroid/os/Parcelable;", "loader", "Ljava/lang/ClassLoader;", "saveState", "setPrimaryItem", "startUpdate", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class d
  extends a
{
  private final FragmentManager GGi;
  private r mCurTransaction;
  private Fragment mCurrentPrimaryItem;
  private FragmentManager mFragmentManager;
  private final ArrayList<Fragment> mFragments;
  private final ArrayList<Fragment.SavedState> mSavedState;
  
  public d(FragmentManager paramFragmentManager)
  {
    this.GGi = paramFragmentManager;
    this.mSavedState = new ArrayList();
    this.mFragments = new ArrayList();
    this.mFragmentManager = this.GGi;
  }
  
  public final void b(r paramr)
  {
    this.mCurTransaction = paramr;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    s.u(paramViewGroup, "container");
    s.u(paramObject, "object");
    paramObject = (Fragment)paramObject;
    if (this.mCurTransaction == null)
    {
      paramViewGroup = this.mFragmentManager;
      s.checkNotNull(paramViewGroup);
      this.mCurTransaction = paramViewGroup.beginTransaction();
    }
    while (this.mSavedState.size() <= paramInt) {
      this.mSavedState.add(null);
    }
    ArrayList localArrayList = this.mSavedState;
    if (paramObject.isAdded())
    {
      paramViewGroup = this.mFragmentManager;
      s.checkNotNull(paramViewGroup);
    }
    for (paramViewGroup = paramViewGroup.saveFragmentInstanceState(paramObject);; paramViewGroup = null)
    {
      localArrayList.set(paramInt, paramViewGroup);
      this.mFragments.set(paramInt, null);
      paramViewGroup = this.mCurTransaction;
      s.checkNotNull(paramViewGroup);
      paramViewGroup.a(paramObject);
      return;
    }
  }
  
  public void finishUpdate(ViewGroup paramViewGroup)
  {
    s.u(paramViewGroup, "container");
    if (this.mCurTransaction != null)
    {
      paramViewGroup = this.mCurTransaction;
      s.checkNotNull(paramViewGroup);
      paramViewGroup.FZ();
      this.mCurTransaction = null;
    }
  }
  
  public final FragmentManager flI()
  {
    return this.GGi;
  }
  
  public final r flJ()
  {
    return this.mCurTransaction;
  }
  
  public final ArrayList<Fragment.SavedState> flK()
  {
    return this.mSavedState;
  }
  
  public final ArrayList<Fragment> flL()
  {
    return this.mFragments;
  }
  
  public abstract Fragment getItem(int paramInt);
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    s.u(paramViewGroup, "container");
    if (this.mFragments.size() > paramInt)
    {
      localObject1 = (Fragment)this.mFragments.get(paramInt);
      if (localObject1 != null) {
        return localObject1;
      }
    }
    if (this.mCurTransaction == null)
    {
      localObject1 = this.mFragmentManager;
      s.checkNotNull(localObject1);
      this.mCurTransaction = ((FragmentManager)localObject1).beginTransaction();
    }
    Object localObject1 = getItem(paramInt);
    if (this.mSavedState.size() > paramInt)
    {
      localObject2 = (Fragment.SavedState)this.mSavedState.get(paramInt);
      if (localObject2 != null) {
        ((Fragment)localObject1).setInitialSavedState((Fragment.SavedState)localObject2);
      }
    }
    while (this.mFragments.size() <= paramInt) {
      this.mFragments.add(null);
    }
    ((Fragment)localObject1).setMenuVisibility(false);
    ((Fragment)localObject1).setUserVisibleHint(false);
    this.mFragments.set(paramInt, localObject1);
    Object localObject2 = this.mCurTransaction;
    s.checkNotNull(localObject2);
    ((r)localObject2).a(paramViewGroup.getId(), (Fragment)localObject1);
    paramViewGroup = new StringBuilder("instantiateItem: title:");
    if (localObject1 == null) {
      throw new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment");
    }
    paramViewGroup = paramViewGroup.append(((FinderHomeTabFragment)localObject1).title).append(" tabType:");
    if (localObject1 == null) {
      throw new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment");
    }
    Log.i("Finder.DynamicAdapter", ((FinderHomeTabFragment)localObject1).hJx);
    return localObject1;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    s.u(paramView, "view");
    s.u(paramObject, "object");
    return ((Fragment)paramObject).getView() == paramView;
  }
  
  public void restoreState(Parcelable paramParcelable, ClassLoader paramClassLoader)
  {
    int k;
    if (paramParcelable != null)
    {
      paramParcelable = (Bundle)paramParcelable;
      paramParcelable.setClassLoader(paramClassLoader);
      paramClassLoader = paramParcelable.getParcelableArray("states");
      this.mSavedState.clear();
      this.mFragments.clear();
      if (paramClassLoader != null)
      {
        k = paramClassLoader.length - 1;
        if (k < 0) {}
      }
    }
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      Object localObject1 = this.mSavedState;
      Object localObject2 = paramClassLoader[i];
      if (localObject2 == null) {
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.Fragment.SavedState");
      }
      ((ArrayList)localObject1).add((Fragment.SavedState)localObject2);
      if (j > k)
      {
        paramClassLoader = paramParcelable.keySet();
        s.s(paramClassLoader, "bundle.keySet()");
        paramClassLoader = ((Iterable)paramClassLoader).iterator();
        for (;;)
        {
          if (!paramClassLoader.hasNext()) {
            return;
          }
          localObject1 = paramClassLoader.next();
          if (localObject1 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
          }
          localObject1 = (String)localObject1;
          if (n.U((String)localObject1, "f", false))
          {
            localObject2 = ((String)localObject1).substring(1);
            s.s(localObject2, "(this as java.lang.String).substring(startIndex)");
            i = Integer.parseInt((String)localObject2);
            localObject2 = this.mFragmentManager;
            s.checkNotNull(localObject2);
            localObject2 = ((FragmentManager)localObject2).getFragment(paramParcelable, (String)localObject1);
            if (localObject2 != null)
            {
              while (this.mFragments.size() <= i) {
                this.mFragments.add(null);
              }
              ((Fragment)localObject2).setMenuVisibility(false);
              this.mFragments.set(i, localObject2);
            }
            else
            {
              Log.w("FragmentStatePagerAdapt", s.X("Bad fragment at key ", localObject1));
            }
          }
        }
      }
    }
  }
  
  public Parcelable saveState()
  {
    Object localObject1 = null;
    if (this.mSavedState.size() > 0)
    {
      localObject1 = new Bundle();
      localObject2 = new Fragment.SavedState[this.mSavedState.size()];
      this.mSavedState.toArray((Object[])localObject2);
      ((Bundle)localObject1).putParcelableArray("states", (Parcelable[])localObject2);
    }
    int i = 0;
    int k = this.mFragments.size() - 1;
    Object localObject2 = localObject1;
    if (k >= 0) {}
    for (;;)
    {
      int j = i + 1;
      Fragment localFragment = (Fragment)this.mFragments.get(i);
      localObject2 = localObject1;
      if (localFragment != null)
      {
        localObject2 = localObject1;
        if (localFragment.isAdded())
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new Bundle();
          }
          localObject1 = s.X("f", Integer.valueOf(i));
          FragmentManager localFragmentManager = this.mFragmentManager;
          s.checkNotNull(localFragmentManager);
          localFragmentManager.putFragment((Bundle)localObject2, (String)localObject1, localFragment);
        }
      }
      if (j > k) {
        return (Parcelable)localObject2;
      }
      i = j;
      localObject1 = localObject2;
    }
  }
  
  public void setPrimaryItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    s.u(paramViewGroup, "container");
    s.u(paramObject, "object");
    paramViewGroup = (Fragment)paramObject;
    if (paramViewGroup != this.mCurrentPrimaryItem)
    {
      if (this.mCurrentPrimaryItem != null)
      {
        paramObject = this.mCurrentPrimaryItem;
        s.checkNotNull(paramObject);
        paramObject.setMenuVisibility(false);
        paramObject = this.mCurrentPrimaryItem;
        s.checkNotNull(paramObject);
        paramObject.setUserVisibleHint(false);
      }
      paramViewGroup.setMenuVisibility(true);
      paramViewGroup.setUserVisibleHint(true);
      this.mCurrentPrimaryItem = paramViewGroup;
    }
  }
  
  public void startUpdate(ViewGroup paramViewGroup)
  {
    s.u(paramViewGroup, "container");
    if (paramViewGroup.getId() != -1) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalStateException(("ViewPager with adapter " + this + " requires a view id").toString()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.adapter.d
 * JD-Core Version:    0.7.0.1
 */