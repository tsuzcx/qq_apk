package android.support.v13.app;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import java.util.ArrayList;

@Deprecated
public class FragmentTabHost
  extends TabHost
  implements TabHost.OnTabChangeListener
{
  private final ArrayList<a> Co = new ArrayList();
  private FragmentManager Cp;
  private TabHost.OnTabChangeListener Cq;
  private a Cr;
  private boolean Cs;
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
    if (i < this.Co.size())
    {
      a locala = (a)this.Co.get(i);
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
      if (this.Cr != localObject)
      {
        paramString = paramFragmentTransaction;
        if (paramFragmentTransaction == null) {
          paramString = this.Cp.beginTransaction();
        }
        if ((this.Cr != null) && (this.Cr.Cw != null)) {
          paramString.detach(this.Cr.Cw);
        }
        if (localObject != null)
        {
          if (localObject.Cw != null) {
            break label193;
          }
          localObject.Cw = Fragment.instantiate(this.mContext, localObject.Cu.getName(), localObject.Cv);
          paramString.add(this.mContainerId, localObject.Cw, localObject.tag);
        }
      }
      for (;;)
      {
        this.Cr = localObject;
        return paramString;
        paramString.attach(localObject.Cw);
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
    if (i < this.Co.size())
    {
      a locala = (a)this.Co.get(i);
      locala.Cw = this.Cp.findFragmentByTag(locala.tag);
      Object localObject2 = localObject1;
      if (locala.Cw != null)
      {
        localObject2 = localObject1;
        if (!locala.Cw.isDetached())
        {
          if (!locala.tag.equals(str)) {
            break label108;
          }
          this.Cr = locala;
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
          localObject2 = this.Cp.beginTransaction();
        }
        ((FragmentTransaction)localObject2).detach(locala.Cw);
      }
    }
    this.Cs = true;
    localObject1 = a(str, (FragmentTransaction)localObject1);
    if (localObject1 != null)
    {
      ((FragmentTransaction)localObject1).commit();
      this.Cp.executePendingTransactions();
    }
  }
  
  @Deprecated
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.Cs = false;
  }
  
  @Deprecated
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof FragmentTabHost.SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (FragmentTabHost.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    setCurrentTabByTag(paramParcelable.Ct);
  }
  
  @Deprecated
  protected Parcelable onSaveInstanceState()
  {
    FragmentTabHost.SavedState localSavedState = new FragmentTabHost.SavedState(super.onSaveInstanceState());
    localSavedState.Ct = getCurrentTabTag();
    return localSavedState;
  }
  
  @Deprecated
  public void onTabChanged(String paramString)
  {
    if (this.Cs)
    {
      FragmentTransaction localFragmentTransaction = a(paramString, null);
      if (localFragmentTransaction != null) {
        localFragmentTransaction.commit();
      }
    }
    if (this.Cq != null) {
      this.Cq.onTabChanged(paramString);
    }
  }
  
  @Deprecated
  public void setOnTabChangedListener(TabHost.OnTabChangeListener paramOnTabChangeListener)
  {
    this.Cq = paramOnTabChangeListener;
  }
  
  @Deprecated
  public void setup()
  {
    throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
  }
  
  static final class a
  {
    final Class<?> Cu;
    final Bundle Cv;
    Fragment Cw;
    final String tag;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v13.app.FragmentTabHost
 * JD-Core Version:    0.7.0.1
 */