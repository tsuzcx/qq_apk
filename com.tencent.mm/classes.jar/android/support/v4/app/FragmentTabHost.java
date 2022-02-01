package android.support.v4.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import java.util.ArrayList;

public class FragmentTabHost
  extends TabHost
  implements TabHost.OnTabChangeListener
{
  private final ArrayList<a> Eg = new ArrayList();
  private TabHost.OnTabChangeListener Ei;
  private boolean Ek;
  private a FX;
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
    if (this.FX != locala)
    {
      paramString = paramk;
      if (paramk == null) {
        paramString = this.mFragmentManager.beginTransaction();
      }
      if ((this.FX != null) && (this.FX.fragment != null)) {
        paramString.c(this.FX.fragment);
      }
      if (locala != null)
      {
        if (locala.fragment != null) {
          break label116;
        }
        locala.fragment = Fragment.instantiate(this.mContext, locala.Em.getName(), locala.En);
        paramString.a(this.mContainerId, locala.fragment, locala.tag);
      }
    }
    for (;;)
    {
      this.FX = locala;
      return paramString;
      label116:
      paramString.d(locala.fragment);
    }
  }
  
  private a r(String paramString)
  {
    int j = this.Eg.size();
    int i = 0;
    while (i < j)
    {
      a locala = (a)this.Eg.get(i);
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
    int j = this.Eg.size();
    int i = 0;
    if (i < j)
    {
      a locala = (a)this.Eg.get(i);
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
          this.FX = locala;
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
        ((k)localObject2).c(locala.fragment);
      }
    }
    this.Ek = true;
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
    this.Ek = false;
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof FragmentTabHost.SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (FragmentTabHost.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    setCurrentTabByTag(paramParcelable.El);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    FragmentTabHost.SavedState localSavedState = new FragmentTabHost.SavedState(super.onSaveInstanceState());
    localSavedState.El = getCurrentTabTag();
    return localSavedState;
  }
  
  public void onTabChanged(String paramString)
  {
    if (this.Ek)
    {
      k localk = a(paramString, null);
      if (localk != null) {
        localk.commit();
      }
    }
    if (this.Ei != null) {
      this.Ei.onTabChanged(paramString);
    }
  }
  
  public void setOnTabChangedListener(TabHost.OnTabChangeListener paramOnTabChangeListener)
  {
    this.Ei = paramOnTabChangeListener;
  }
  
  @Deprecated
  public void setup()
  {
    throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
  }
  
  static final class a
  {
    final Class<?> Em;
    final Bundle En;
    Fragment fragment;
    final String tag;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v4.app.FragmentTabHost
 * JD-Core Version:    0.7.0.1
 */