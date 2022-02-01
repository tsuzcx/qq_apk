package com.tencent.mm.plugin.finder.view.adapter;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.Fragment.SavedState;
import androidx.fragment.app.e;
import androidx.fragment.app.i;
import androidx.viewpager.widget.a;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/adapter/StatePagerAdapterCp;", "Landroidx/viewpager/widget/PagerAdapter;", "fm", "Landroidx/fragment/app/FragmentManager;", "(Landroidx/fragment/app/FragmentManager;)V", "getFm", "()Landroidx/fragment/app/FragmentManager;", "mCurTransaction", "Landroidx/fragment/app/FragmentTransaction;", "getMCurTransaction", "()Landroidx/fragment/app/FragmentTransaction;", "setMCurTransaction", "(Landroidx/fragment/app/FragmentTransaction;)V", "mCurrentPrimaryItem", "Landroidx/fragment/app/Fragment;", "mFragmentManager", "mFragments", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getMFragments", "()Ljava/util/ArrayList;", "mSavedState", "Landroidx/fragment/app/Fragment$SavedState;", "getMSavedState", "destroyItem", "", "container", "Landroid/view/ViewGroup;", "position", "", "object", "", "finishUpdate", "getItem", "index", "instantiateItem", "isViewFromObject", "", "view", "Landroid/view/View;", "restoreState", "state", "Landroid/os/Parcelable;", "loader", "Ljava/lang/ClassLoader;", "saveState", "setPrimaryItem", "startUpdate", "plugin-finder_release"})
public abstract class d
  extends a
{
  private final e Bdx;
  private i mCurTransaction;
  private Fragment mCurrentPrimaryItem;
  private e mFragmentManager;
  private final ArrayList<Fragment> mFragments;
  private final ArrayList<Fragment.SavedState> mSavedState;
  
  public d(e parame)
  {
    this.Bdx = parame;
    this.mSavedState = new ArrayList();
    this.mFragments = new ArrayList();
    this.mFragmentManager = this.Bdx;
  }
  
  public final void b(i parami)
  {
    this.mCurTransaction = parami;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    p.k(paramViewGroup, "container");
    p.k(paramObject, "object");
    paramObject = (Fragment)paramObject;
    if (this.mCurTransaction == null)
    {
      paramViewGroup = this.mFragmentManager;
      if (paramViewGroup == null) {
        p.iCn();
      }
      this.mCurTransaction = paramViewGroup.beginTransaction();
    }
    while (this.mSavedState.size() <= paramInt) {
      this.mSavedState.add(null);
    }
    ArrayList localArrayList = this.mSavedState;
    if (paramObject.isAdded())
    {
      paramViewGroup = this.mFragmentManager;
      if (paramViewGroup == null) {
        p.iCn();
      }
    }
    for (paramViewGroup = paramViewGroup.saveFragmentInstanceState(paramObject);; paramViewGroup = null)
    {
      localArrayList.set(paramInt, paramViewGroup);
      this.mFragments.set(paramInt, null);
      paramViewGroup = this.mCurTransaction;
      if (paramViewGroup == null) {
        p.iCn();
      }
      paramViewGroup.a(paramObject);
      return;
    }
  }
  
  public final i ejv()
  {
    return this.mCurTransaction;
  }
  
  public final ArrayList<Fragment.SavedState> ejw()
  {
    return this.mSavedState;
  }
  
  public final ArrayList<Fragment> ejx()
  {
    return this.mFragments;
  }
  
  public final e ejy()
  {
    return this.Bdx;
  }
  
  public void finishUpdate(ViewGroup paramViewGroup)
  {
    p.k(paramViewGroup, "container");
    if (this.mCurTransaction != null)
    {
      paramViewGroup = this.mCurTransaction;
      if (paramViewGroup == null) {
        p.iCn();
      }
      paramViewGroup.ir();
      this.mCurTransaction = null;
    }
  }
  
  public abstract Fragment getItem(int paramInt);
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    p.k(paramViewGroup, "container");
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
      if (localObject1 == null) {
        p.iCn();
      }
      this.mCurTransaction = ((e)localObject1).beginTransaction();
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
    if (localObject2 == null) {
      p.iCn();
    }
    ((i)localObject2).a(paramViewGroup.getId(), (Fragment)localObject1);
    paramViewGroup = new StringBuilder("instantiateItem: title:");
    if (localObject1 == null) {
      throw new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment");
    }
    Log.i("Finder.DynamicAdapter", ((FinderHomeTabFragment)localObject1).title + " tabType:" + ((FinderHomeTabFragment)localObject1).fEH);
    return localObject1;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    p.k(paramView, "view");
    p.k(paramObject, "object");
    return ((Fragment)paramObject).getView() == paramView;
  }
  
  public void restoreState(Parcelable paramParcelable, ClassLoader paramClassLoader)
  {
    int i;
    Object localObject1;
    Object localObject2;
    if (paramParcelable != null)
    {
      paramParcelable = (Bundle)paramParcelable;
      paramParcelable.setClassLoader(paramClassLoader);
      paramClassLoader = paramParcelable.getParcelableArray("states");
      this.mSavedState.clear();
      this.mFragments.clear();
      if (paramClassLoader != null)
      {
        int j = paramClassLoader.length;
        i = 0;
        while (i < j)
        {
          localObject1 = this.mSavedState;
          localObject2 = paramClassLoader[i];
          if (localObject2 == null) {
            throw new t("null cannot be cast to non-null type androidx.fragment.app.Fragment.SavedState");
          }
          ((ArrayList)localObject1).add((Fragment.SavedState)localObject2);
          i += 1;
        }
      }
      paramClassLoader = paramParcelable.keySet();
      p.j(paramClassLoader, "bundle.keySet()");
      paramClassLoader = ((Iterable)paramClassLoader).iterator();
    }
    for (;;)
    {
      if (!paramClassLoader.hasNext()) {
        return;
      }
      localObject1 = paramClassLoader.next();
      if (localObject1 == null) {
        throw new t("null cannot be cast to non-null type kotlin.String");
      }
      localObject1 = (String)localObject1;
      if (n.M((String)localObject1, "f", false))
      {
        if (localObject1 == null) {
          throw new t("null cannot be cast to non-null type java.lang.String");
        }
        localObject2 = ((String)localObject1).substring(1);
        p.j(localObject2, "(this as java.lang.String).substring(startIndex)");
        i = Integer.parseInt((String)localObject2);
        localObject2 = this.mFragmentManager;
        if (localObject2 == null) {
          p.iCn();
        }
        localObject2 = ((e)localObject2).getFragment(paramParcelable, (String)localObject1);
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
          Log.w("FragmentStatePagerAdapt", "Bad fragment at key ".concat(String.valueOf(localObject1)));
        }
      }
    }
  }
  
  public Parcelable saveState()
  {
    Object localObject2;
    Object localObject1;
    if (this.mSavedState.size() > 0)
    {
      localObject2 = new Bundle();
      localObject1 = new Fragment.SavedState[this.mSavedState.size()];
      this.mSavedState.toArray((Object[])localObject1);
      ((Bundle)localObject2).putParcelableArray("states", (Parcelable[])localObject1);
    }
    for (;;)
    {
      int i = 0;
      int j = ((Collection)this.mFragments).size();
      while (i < j)
      {
        Fragment localFragment = (Fragment)this.mFragments.get(i);
        localObject1 = localObject2;
        if (localFragment != null)
        {
          localObject1 = localObject2;
          if (localFragment.isAdded())
          {
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = new Bundle();
            }
            localObject2 = "f".concat(String.valueOf(i));
            e locale = this.mFragmentManager;
            if (locale == null) {
              p.iCn();
            }
            locale.putFragment((Bundle)localObject1, (String)localObject2, localFragment);
          }
        }
        i += 1;
        localObject2 = localObject1;
      }
      return (Parcelable)localObject2;
      localObject2 = null;
    }
  }
  
  public void setPrimaryItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    p.k(paramViewGroup, "container");
    p.k(paramObject, "object");
    paramViewGroup = (Fragment)paramObject;
    if (paramViewGroup != this.mCurrentPrimaryItem)
    {
      if (this.mCurrentPrimaryItem != null)
      {
        paramObject = this.mCurrentPrimaryItem;
        if (paramObject == null) {
          p.iCn();
        }
        paramObject.setMenuVisibility(false);
        paramObject = this.mCurrentPrimaryItem;
        if (paramObject == null) {
          p.iCn();
        }
        paramObject.setUserVisibleHint(false);
      }
      paramViewGroup.setMenuVisibility(true);
      paramViewGroup.setUserVisibleHint(true);
      this.mCurrentPrimaryItem = paramViewGroup;
    }
  }
  
  public void startUpdate(ViewGroup paramViewGroup)
  {
    p.k(paramViewGroup, "container");
    if (paramViewGroup.getId() != -1) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalStateException(("ViewPager with adapter " + this + " requires a view id").toString()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.adapter.d
 * JD-Core Version:    0.7.0.1
 */