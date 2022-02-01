package androidx.legacy.app;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View.BaseSavedState;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

@Deprecated
public class FragmentTabHost
  extends TabHost
  implements TabHost.OnTabChangeListener
{
  private TabHost.OnTabChangeListener Wn;
  private boolean Wp;
  private FragmentManager Zv;
  private final ArrayList<Object> hV;
  private int mContainerId;
  
  @Deprecated
  public FragmentTabHost(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(186241);
    this.hV = new ArrayList();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, new int[] { 16842995 }, 0, 0);
    this.mContainerId = paramContext.getResourceId(0, 0);
    paramContext.recycle();
    super.setOnTabChangedListener(this);
    AppMethodBeat.o(186241);
  }
  
  private FragmentTransaction O(String paramString)
  {
    AppMethodBeat.i(186278);
    if (this.hV.size() > 0)
    {
      this.hV.get(0);
      AppMethodBeat.o(186278);
      throw null;
    }
    paramString = new IllegalStateException("No tab known for tag ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(186278);
    throw paramString;
  }
  
  @Deprecated
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(186245);
    super.onAttachedToWindow();
    Object localObject = getCurrentTabTag();
    if (this.hV.size() > 0)
    {
      this.hV.get(0);
      AppMethodBeat.o(186245);
      throw null;
    }
    this.Wp = true;
    localObject = O((String)localObject);
    if (localObject != null)
    {
      ((FragmentTransaction)localObject).commit();
      this.Zv.executePendingTransactions();
    }
    AppMethodBeat.o(186245);
  }
  
  @Deprecated
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(186267);
    super.onDetachedFromWindow();
    this.Wp = false;
    AppMethodBeat.o(186267);
  }
  
  @Deprecated
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(186275);
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      AppMethodBeat.o(186275);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    setCurrentTabByTag(paramParcelable.Wq);
    AppMethodBeat.o(186275);
  }
  
  @Deprecated
  protected Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(186273);
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.Wq = getCurrentTabTag();
    AppMethodBeat.o(186273);
    return localSavedState;
  }
  
  @Deprecated
  public void onTabChanged(String paramString)
  {
    AppMethodBeat.i(186277);
    if (this.Wp)
    {
      FragmentTransaction localFragmentTransaction = O(paramString);
      if (localFragmentTransaction != null) {
        localFragmentTransaction.commit();
      }
    }
    if (this.Wn != null) {
      this.Wn.onTabChanged(paramString);
    }
    AppMethodBeat.o(186277);
  }
  
  @Deprecated
  public void setOnTabChangedListener(TabHost.OnTabChangeListener paramOnTabChangeListener)
  {
    this.Wn = paramOnTabChangeListener;
  }
  
  @Deprecated
  public void setup()
  {
    AppMethodBeat.i(186242);
    IllegalStateException localIllegalStateException = new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    AppMethodBeat.o(186242);
    throw localIllegalStateException;
  }
  
  static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR;
    String Wq;
    
    static
    {
      AppMethodBeat.i(186237);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(186237);
    }
    
    SavedState(Parcel paramParcel)
    {
      super();
      AppMethodBeat.i(186231);
      this.Wq = paramParcel.readString();
      AppMethodBeat.o(186231);
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public String toString()
    {
      AppMethodBeat.i(186236);
      String str = "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.Wq + "}";
      AppMethodBeat.o(186236);
      return str;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(186233);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeString(this.Wq);
      AppMethodBeat.o(186233);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.legacy.app.FragmentTabHost
 * JD-Core Version:    0.7.0.1
 */