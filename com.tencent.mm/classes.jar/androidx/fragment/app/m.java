package androidx.fragment.app;

import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.j.b;
import androidx.viewpager.widget.a;

@Deprecated
public abstract class m
  extends a
{
  private final int mBehavior;
  private r mCurTransaction = null;
  private Fragment mCurrentPrimaryItem = null;
  private boolean mExecutingFinishUpdate;
  private final FragmentManager mFragmentManager;
  
  @Deprecated
  public m(FragmentManager paramFragmentManager)
  {
    this(paramFragmentManager, (byte)0);
  }
  
  private m(FragmentManager paramFragmentManager, byte paramByte)
  {
    this.mFragmentManager = paramFragmentManager;
    this.mBehavior = 0;
  }
  
  private static String c(int paramInt, long paramLong)
  {
    return "android:switcher:" + paramInt + ":" + paramLong;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup = (Fragment)paramObject;
    if (this.mCurTransaction == null) {
      this.mCurTransaction = this.mFragmentManager.beginTransaction();
    }
    this.mCurTransaction.d(paramViewGroup);
    if (paramViewGroup.equals(this.mCurrentPrimaryItem)) {
      this.mCurrentPrimaryItem = null;
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
    if (this.mCurTransaction == null) {
      this.mCurTransaction = this.mFragmentManager.beginTransaction();
    }
    long l = paramInt;
    Object localObject = c(paramViewGroup.getId(), l);
    localObject = this.mFragmentManager.findFragmentByTag((String)localObject);
    if (localObject != null) {
      this.mCurTransaction.r((Fragment)localObject);
    }
    for (paramViewGroup = (ViewGroup)localObject;; paramViewGroup = (ViewGroup)localObject)
    {
      if (paramViewGroup != this.mCurrentPrimaryItem)
      {
        paramViewGroup.setMenuVisibility(false);
        if (this.mBehavior != 1) {
          break;
        }
        this.mCurTransaction.a(paramViewGroup, j.b.bHj);
      }
      return paramViewGroup;
      localObject = getItem(paramInt);
      this.mCurTransaction.a(paramViewGroup.getId(), (Fragment)localObject, c(paramViewGroup.getId(), l));
    }
    paramViewGroup.setUserVisibleHint(false);
    return paramViewGroup;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return ((Fragment)paramObject).getView() == paramView;
  }
  
  public void restoreState(Parcelable paramParcelable, ClassLoader paramClassLoader) {}
  
  public Parcelable saveState()
  {
    return null;
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
 * Qualified Name:     androidx.fragment.app.m
 * JD-Core Version:    0.7.0.1
 */