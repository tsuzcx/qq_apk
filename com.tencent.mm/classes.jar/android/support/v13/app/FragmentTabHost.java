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
  private final ArrayList<a> Ep = new ArrayList();
  private FragmentManager Eq;
  private TabHost.OnTabChangeListener Er;
  private a Es;
  private boolean Et;
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
    if (i < this.Ep.size())
    {
      a locala = (a)this.Ep.get(i);
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
      if (this.Es != localObject)
      {
        paramString = paramFragmentTransaction;
        if (paramFragmentTransaction == null) {
          paramString = this.Eq.beginTransaction();
        }
        if ((this.Es != null) && (this.Es.Ex != null)) {
          paramString.detach(this.Es.Ex);
        }
        if (localObject != null)
        {
          if (localObject.Ex != null) {
            break label193;
          }
          localObject.Ex = Fragment.instantiate(this.mContext, localObject.Ev.getName(), localObject.Ew);
          paramString.add(this.mContainerId, localObject.Ex, localObject.tag);
        }
      }
      for (;;)
      {
        this.Es = localObject;
        return paramString;
        paramString.attach(localObject.Ex);
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
    if (i < this.Ep.size())
    {
      a locala = (a)this.Ep.get(i);
      locala.Ex = this.Eq.findFragmentByTag(locala.tag);
      Object localObject2 = localObject1;
      if (locala.Ex != null)
      {
        localObject2 = localObject1;
        if (!locala.Ex.isDetached())
        {
          if (!locala.tag.equals(str)) {
            break label108;
          }
          this.Es = locala;
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
          localObject2 = this.Eq.beginTransaction();
        }
        ((FragmentTransaction)localObject2).detach(locala.Ex);
      }
    }
    this.Et = true;
    localObject1 = a(str, (FragmentTransaction)localObject1);
    if (localObject1 != null)
    {
      ((FragmentTransaction)localObject1).commit();
      this.Eq.executePendingTransactions();
    }
  }
  
  @Deprecated
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.Et = false;
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
    setCurrentTabByTag(paramParcelable.Eu);
  }
  
  @Deprecated
  protected Parcelable onSaveInstanceState()
  {
    FragmentTabHost.SavedState localSavedState = new FragmentTabHost.SavedState(super.onSaveInstanceState());
    localSavedState.Eu = getCurrentTabTag();
    return localSavedState;
  }
  
  @Deprecated
  public void onTabChanged(String paramString)
  {
    if (this.Et)
    {
      FragmentTransaction localFragmentTransaction = a(paramString, null);
      if (localFragmentTransaction != null) {
        localFragmentTransaction.commit();
      }
    }
    if (this.Er != null) {
      this.Er.onTabChanged(paramString);
    }
  }
  
  @Deprecated
  public void setOnTabChangedListener(TabHost.OnTabChangeListener paramOnTabChangeListener)
  {
    this.Er = paramOnTabChangeListener;
  }
  
  @Deprecated
  public void setup()
  {
    throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
  }
  
  static final class a
  {
    final Class<?> Ev;
    final Bundle Ew;
    Fragment Ex;
    final String tag;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.v13.app.FragmentTabHost
 * JD-Core Version:    0.7.0.1
 */