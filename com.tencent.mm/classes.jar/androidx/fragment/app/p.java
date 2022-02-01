package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.j.b;
import androidx.viewpager.widget.a;
import java.util.ArrayList;
import java.util.Iterator;

@Deprecated
public abstract class p
  extends a
{
  public static final int BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT = 1;
  @Deprecated
  public static final int BEHAVIOR_SET_USER_VISIBLE_HINT = 0;
  private static final boolean DEBUG = false;
  private static final String TAG = "FragmentStatePagerAdapt";
  private final int mBehavior;
  private r mCurTransaction = null;
  private Fragment mCurrentPrimaryItem = null;
  private boolean mExecutingFinishUpdate;
  private final FragmentManager mFragmentManager;
  private ArrayList<Fragment> mFragments = new ArrayList();
  private ArrayList<Fragment.SavedState> mSavedState = new ArrayList();
  
  @Deprecated
  public p(FragmentManager paramFragmentManager)
  {
    this(paramFragmentManager, 0);
  }
  
  public p(FragmentManager paramFragmentManager, int paramInt)
  {
    this.mFragmentManager = paramFragmentManager;
    this.mBehavior = paramInt;
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
      if (paramObject.equals(this.mCurrentPrimaryItem)) {
        this.mCurrentPrimaryItem = null;
      }
      return;
    }
  }
  
  public void finishUpdate(ViewGroup paramViewGroup)
  {
    if ((this.mCurTransaction == null) || (!this.mExecutingFinishUpdate)) {}
    try
    {
      this.mExecutingFinishUpdate = true;
      this.mCurTransaction.FZ();
      this.mExecutingFinishUpdate = false;
      this.mCurTransaction = null;
      return;
    }
    finally
    {
      this.mExecutingFinishUpdate = false;
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
    if (this.mBehavior == 0) {
      localFragment.setUserVisibleHint(false);
    }
    this.mFragments.set(paramInt, localFragment);
    this.mCurTransaction.a(paramViewGroup.getId(), localFragment);
    if (this.mBehavior == 1) {
      this.mCurTransaction.a(localFragment, j.b.bHj);
    }
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
        if (this.mBehavior != 1) {
          break label118;
        }
        if (this.mCurTransaction == null) {
          this.mCurTransaction = this.mFragmentManager.beginTransaction();
        }
        this.mCurTransaction.a(this.mCurrentPrimaryItem, j.b.bHj);
      }
      paramViewGroup.setMenuVisibility(true);
      if (this.mBehavior != 1) {
        break label129;
      }
      if (this.mCurTransaction == null) {
        this.mCurTransaction = this.mFragmentManager.beginTransaction();
      }
      this.mCurTransaction.a(paramViewGroup, j.b.bHk);
    }
    for (;;)
    {
      this.mCurrentPrimaryItem = paramViewGroup;
      return;
      label118:
      this.mCurrentPrimaryItem.setUserVisibleHint(false);
      break;
      label129:
      paramViewGroup.setUserVisibleHint(true);
    }
  }
  
  public void startUpdate(ViewGroup paramViewGroup)
  {
    if (paramViewGroup.getId() == -1) {
      throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.fragment.app.p
 * JD-Core Version:    0.7.0.1
 */