package android.support.v13.app;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
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

@Deprecated
public class FragmentTabHost
  extends TabHost
  implements TabHost.OnTabChangeListener
{
  private final ArrayList<a> Bq = new ArrayList();
  private FragmentManager Br;
  private TabHost.OnTabChangeListener Bs;
  private a Bt;
  private boolean Bu;
  private int mContainerId;
  private Context mContext;
  
  @Deprecated
  public FragmentTabHost(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, new int[] { 16842995 }, 0, 0);
    this.mContainerId = paramContext.getResourceId(0, 0);
    paramContext.recycle();
    super.setOnTabChangedListener(this);
  }
  
  private FragmentTransaction a(String paramString, FragmentTransaction paramFragmentTransaction)
  {
    Object localObject = null;
    int i = 0;
    if (i < this.Bq.size())
    {
      a locala = (a)this.Bq.get(i);
      if (!locala.tag.equals(paramString)) {
        break label206;
      }
      localObject = locala;
    }
    label193:
    label206:
    for (;;)
    {
      i += 1;
      break;
      if (localObject == null) {
        throw new IllegalStateException("No tab known for tag ".concat(String.valueOf(paramString)));
      }
      paramString = paramFragmentTransaction;
      if (this.Bt != localObject)
      {
        paramString = paramFragmentTransaction;
        if (paramFragmentTransaction == null) {
          paramString = this.Br.beginTransaction();
        }
        if ((this.Bt != null) && (this.Bt.By != null)) {
          paramString.detach(this.Bt.By);
        }
        if (localObject != null)
        {
          if (localObject.By != null) {
            break label193;
          }
          localObject.By = Fragment.instantiate(this.mContext, localObject.Bw.getName(), localObject.Bx);
          paramString.add(this.mContainerId, localObject.By, localObject.tag);
        }
      }
      for (;;)
      {
        this.Bt = localObject;
        return paramString;
        paramString.attach(localObject.By);
      }
    }
  }
  
  @Deprecated
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    String str = getCurrentTabTag();
    Object localObject1 = null;
    int i = 0;
    if (i < this.Bq.size())
    {
      a locala = (a)this.Bq.get(i);
      locala.By = this.Br.findFragmentByTag(locala.tag);
      Object localObject2 = localObject1;
      if (locala.By != null)
      {
        localObject2 = localObject1;
        if (!locala.By.isDetached())
        {
          if (!locala.tag.equals(str)) {
            break label108;
          }
          this.Bt = locala;
          localObject2 = localObject1;
        }
      }
      for (;;)
      {
        i += 1;
        localObject1 = localObject2;
        break;
        label108:
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = this.Br.beginTransaction();
        }
        ((FragmentTransaction)localObject2).detach(locala.By);
      }
    }
    this.Bu = true;
    localObject1 = a(str, (FragmentTransaction)localObject1);
    if (localObject1 != null)
    {
      ((FragmentTransaction)localObject1).commit();
      this.Br.executePendingTransactions();
    }
  }
  
  @Deprecated
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.Bu = false;
  }
  
  @Deprecated
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
  
  @Deprecated
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.Bv = getCurrentTabTag();
    return localSavedState;
  }
  
  @Deprecated
  public void onTabChanged(String paramString)
  {
    if (this.Bu)
    {
      FragmentTransaction localFragmentTransaction = a(paramString, null);
      if (localFragmentTransaction != null) {
        localFragmentTransaction.commit();
      }
    }
    if (this.Bs != null) {
      this.Bs.onTabChanged(paramString);
    }
  }
  
  @Deprecated
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
    Fragment By;
    final String tag;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v13.app.FragmentTabHost
 * JD-Core Version:    0.7.0.1
 */