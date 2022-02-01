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
  private final ArrayList<a> Eg = new ArrayList();
  private FragmentManager Eh;
  private TabHost.OnTabChangeListener Ei;
  private a Ej;
  private boolean Ek;
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
    if (i < this.Eg.size())
    {
      a locala = (a)this.Eg.get(i);
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
      if (this.Ej != localObject)
      {
        paramString = paramFragmentTransaction;
        if (paramFragmentTransaction == null) {
          paramString = this.Eh.beginTransaction();
        }
        if ((this.Ej != null) && (this.Ej.Eo != null)) {
          paramString.detach(this.Ej.Eo);
        }
        if (localObject != null)
        {
          if (localObject.Eo != null) {
            break label193;
          }
          localObject.Eo = Fragment.instantiate(this.mContext, localObject.Em.getName(), localObject.En);
          paramString.add(this.mContainerId, localObject.Eo, localObject.tag);
        }
      }
      for (;;)
      {
        this.Ej = localObject;
        return paramString;
        paramString.attach(localObject.Eo);
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
    if (i < this.Eg.size())
    {
      a locala = (a)this.Eg.get(i);
      locala.Eo = this.Eh.findFragmentByTag(locala.tag);
      Object localObject2 = localObject1;
      if (locala.Eo != null)
      {
        localObject2 = localObject1;
        if (!locala.Eo.isDetached())
        {
          if (!locala.tag.equals(str)) {
            break label108;
          }
          this.Ej = locala;
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
          localObject2 = this.Eh.beginTransaction();
        }
        ((FragmentTransaction)localObject2).detach(locala.Eo);
      }
    }
    this.Ek = true;
    localObject1 = a(str, (FragmentTransaction)localObject1);
    if (localObject1 != null)
    {
      ((FragmentTransaction)localObject1).commit();
      this.Eh.executePendingTransactions();
    }
  }
  
  @Deprecated
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.Ek = false;
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
    setCurrentTabByTag(paramParcelable.El);
  }
  
  @Deprecated
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.El = getCurrentTabTag();
    return localSavedState;
  }
  
  @Deprecated
  public void onTabChanged(String paramString)
  {
    if (this.Ek)
    {
      FragmentTransaction localFragmentTransaction = a(paramString, null);
      if (localFragmentTransaction != null) {
        localFragmentTransaction.commit();
      }
    }
    if (this.Ei != null) {
      this.Ei.onTabChanged(paramString);
    }
  }
  
  @Deprecated
  public void setOnTabChangedListener(TabHost.OnTabChangeListener paramOnTabChangeListener)
  {
    this.Ei = paramOnTabChangeListener;
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
    String El;
    
    SavedState(Parcel paramParcel)
    {
      super();
      this.El = paramParcel.readString();
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public String toString()
    {
      return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.El + "}";
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeString(this.El);
    }
  }
  
  static final class a
  {
    final Class<?> Em;
    final Bundle En;
    Fragment Eo;
    final String tag;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v13.app.FragmentTabHost
 * JD-Core Version:    0.7.0.1
 */