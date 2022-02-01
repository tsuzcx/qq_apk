package android.support.v4.app;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.q;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class j
  extends q
{
  private static final boolean DEBUG = false;
  private static final String TAG = "FragmentStatePagerAdapt";
  private k mCurTransaction = null;
  private Fragment mCurrentPrimaryItem = null;
  private final g mFragmentManager;
  private ArrayList<Fragment> mFragments = new ArrayList();
  private ArrayList<Fragment.SavedState> mSavedState = new ArrayList();
  
  public j(g paramg)
  {
    this.mFragmentManager = paramg;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramObject = (Fragment)paramObject;
    if (this.mCurTransaction == null) {
      this.mCurTransaction = this.mFragmentManager.beginTransaction();
    }
    while (this.mSavedState.size() <= paramInt) {
      this.mSavedState.add(null);
    }
    ArrayList localArrayList = this.mSavedState;
    if (paramObject.isAdded()) {}
    for (paramViewGroup = this.mFragmentManager.saveFragmentInstanceState(paramObject);; paramViewGroup = null)
    {
      localArrayList.set(paramInt, paramViewGroup);
      this.mFragments.set(paramInt, null);
      this.mCurTransaction.a(paramObject);
      return;
    }
  }
  
  public void finishUpdate(ViewGroup paramViewGroup)
  {
    if (this.mCurTransaction != null)
    {
      this.mCurTransaction.commitNowAllowingStateLoss();
      this.mCurTransaction = null;
    }
  }
  
  public abstract Fragment getItem(int paramInt);
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.mFragments.size() > paramInt)
    {
      localFragment = (Fragment)this.mFragments.get(paramInt);
      if (localFragment != null) {
        return localFragment;
      }
    }
    if (this.mCurTransaction == null) {
      this.mCurTransaction = this.mFragmentManager.beginTransaction();
    }
    Fragment localFragment = getItem(paramInt);
    if (this.mSavedState.size() > paramInt)
    {
      Fragment.SavedState localSavedState = (Fragment.SavedState)this.mSavedState.get(paramInt);
      if (localSavedState != null) {
        localFragment.setInitialSavedState(localSavedState);
      }
    }
    while (this.mFragments.size() <= paramInt) {
      this.mFragments.add(null);
    }
    localFragment.setMenuVisibility(false);
    localFragment.setUserVisibleHint(false);
    this.mFragments.set(paramInt, localFragment);
    this.mCurTransaction.a(paramViewGroup.getId(), localFragment);
    return localFragment;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return ((Fragment)paramObject).getView() == paramView;
  }
  
  public void restoreState(Parcelable paramParcelable, ClassLoader paramClassLoader)
  {
    if (paramParcelable != null)
    {
      paramParcelable = (Bundle)paramParcelable;
      paramParcelable.setClassLoader(paramClassLoader);
      paramClassLoader = paramParcelable.getParcelableArray("states");
      this.mSavedState.clear();
      this.mFragments.clear();
      int i;
      if (paramClassLoader != null)
      {
        i = 0;
        while (i < paramClassLoader.length)
        {
          this.mSavedState.add((Fragment.SavedState)paramClassLoader[i]);
          i += 1;
        }
      }
      paramClassLoader = paramParcelable.keySet().iterator();
      while (paramClassLoader.hasNext())
      {
        Object localObject = (String)paramClassLoader.next();
        if (((String)localObject).startsWith("f"))
        {
          i = Integer.parseInt(((String)localObject).substring(1));
          localObject = this.mFragmentManager.getFragment(paramParcelable, (String)localObject);
          if (localObject != null)
          {
            while (this.mFragments.size() <= i) {
              this.mFragments.add(null);
            }
            ((Fragment)localObject).setMenuVisibility(false);
            this.mFragments.set(i, localObject);
          }
        }
      }
    }
  }
  
  public Parcelable saveState()
  {
    Object localObject1 = null;
    Object localObject2;
    if (this.mSavedState.size() > 0)
    {
      localObject1 = new Bundle();
      localObject2 = new Fragment.SavedState[this.mSavedState.size()];
      this.mSavedState.toArray((Object[])localObject2);
      ((Bundle)localObject1).putParcelableArray("states", (Parcelable[])localObject2);
    }
    int i = 0;
    while (i < this.mFragments.size())
    {
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
          localObject1 = "f".concat(String.valueOf(i));
          this.mFragmentManager.putFragment((Bundle)localObject2, (String)localObject1, localFragment);
        }
      }
      i += 1;
      localObject1 = localObject2;
    }
    return localObject1;
  }
  
  public void setPrimaryItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup = (Fragment)paramObject;
    if (paramViewGroup != this.mCurrentPrimaryItem)
    {
      if (this.mCurrentPrimaryItem != null)
      {
        this.mCurrentPrimaryItem.setMenuVisibility(false);
        this.mCurrentPrimaryItem.setUserVisibleHint(false);
      }
      paramViewGroup.setMenuVisibility(true);
      paramViewGroup.setUserVisibleHint(true);
      this.mCurrentPrimaryItem = paramViewGroup;
    }
  }
  
  public void startUpdate(ViewGroup paramViewGroup)
  {
    if (paramViewGroup.getId() == -1) {
      throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v4.app.j
 * JD-Core Version:    0.7.0.1
 */