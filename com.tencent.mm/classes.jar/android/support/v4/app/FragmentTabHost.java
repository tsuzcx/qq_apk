package android.support.v4.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View.BaseSavedState;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import java.util.ArrayList;

public class FragmentTabHost
  extends TabHost
  implements TabHost.OnTabChangeListener
{
  private final ArrayList<a> Bq = new ArrayList();
  private TabHost.OnTabChangeListener Bs;
  private boolean Bu;
  private a Di;
  private int mContainerId;
  private Context mContext;
  private g mFragmentManager;
  
  public FragmentTabHost(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, new int[] { 16842995 }, 0, 0);
    this.mContainerId = paramContext.getResourceId(0, 0);
    paramContext.recycle();
    super.setOnTabChangedListener(this);
  }
  
  private k a(String paramString, k paramk)
  {
    a locala = r(paramString);
    paramString = paramk;
    if (this.Di != locala)
    {
      paramString = paramk;
      if (paramk == null) {
        paramString = this.mFragmentManager.beginTransaction();
      }
      if ((this.Di != null) && (this.Di.fragment != null)) {
        paramString.d(this.Di.fragment);
      }
      if (locala != null)
      {
        if (locala.fragment != null) {
          break label116;
        }
        locala.fragment = Fragment.instantiate(this.mContext, locala.Bw.getName(), locala.Bx);
        paramString.a(this.mContainerId, locala.fragment, locala.tag);
      }
    }
    for (;;)
    {
      this.Di = locala;
      return paramString;
      label116:
      paramString.e(locala.fragment);
    }
  }
  
  private a r(String paramString)
  {
    int j = this.Bq.size();
    int i = 0;
    while (i < j)
    {
      a locala = (a)this.Bq.get(i);
      if (locala.tag.equals(paramString)) {
        return locala;
      }
      i += 1;
    }
    return null;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    String str = getCurrentTabTag();
    Object localObject1 = null;
    int j = this.Bq.size();
    int i = 0;
    if (i < j)
    {
      a locala = (a)this.Bq.get(i);
      locala.fragment = this.mFragmentManager.findFragmentByTag(locala.tag);
      Object localObject2 = localObject1;
      if (locala.fragment != null)
      {
        localObject2 = localObject1;
        if (!locala.fragment.isDetached())
        {
          if (!locala.tag.equals(str)) {
            break label114;
          }
          this.Di = locala;
          localObject2 = localObject1;
        }
      }
      for (;;)
      {
        i += 1;
        localObject1 = localObject2;
        break;
        label114:
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = this.mFragmentManager.beginTransaction();
        }
        ((k)localObject2).d(locala.fragment);
      }
    }
    this.Bu = true;
    localObject1 = a(str, (k)localObject1);
    if (localObject1 != null)
    {
      ((k)localObject1).commit();
      this.mFragmentManager.executePendingTransactions();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.Bu = false;
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    setCurrentTabByTag(paramParcelable.Bv);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.Bv = getCurrentTabTag();
    return localSavedState;
  }
  
  public void onTabChanged(String paramString)
  {
    if (this.Bu)
    {
      k localk = a(paramString, null);
      if (localk != null) {
        localk.commit();
      }
    }
    if (this.Bs != null) {
      this.Bs.onTabChanged(paramString);
    }
  }
  
  public void setOnTabChangedListener(TabHost.OnTabChangeListener paramOnTabChangeListener)
  {
    this.Bs = paramOnTabChangeListener;
  }
  
  @Deprecated
  public void setup()
  {
    throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
  }
  
  static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator() {};
    String Bv;
    
    SavedState(Parcel paramParcel)
    {
      super();
      this.Bv = paramParcel.readString();
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public String toString()
    {
      return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.Bv + "}";
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeString(this.Bv);
    }
  }
  
  static final class a
  {
    final Class<?> Bw;
    final Bundle Bx;
    Fragment fragment;
    final String tag;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v4.app.FragmentTabHost
 * JD-Core Version:    0.7.0.1
 */