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
  private boolean NE;
  private TabHost.OnTabChangeListener bDC;
  private FragmentManager bGO;
  private final ArrayList<Object> iT;
  private int mContainerId;
  
  @Deprecated
  public FragmentTabHost(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(192920);
    this.iT = new ArrayList();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, new int[] { 16842995 }, 0, 0);
    this.mContainerId = paramContext.getResourceId(0, 0);
    paramContext.recycle();
    super.setOnTabChangedListener(this);
    AppMethodBeat.o(192920);
  }
  
  private FragmentTransaction aK(String paramString)
  {
    AppMethodBeat.i(192930);
    if (this.iT.size() > 0)
    {
      this.iT.get(0);
      AppMethodBeat.o(192930);
      throw null;
    }
    paramString = new IllegalStateException("No tab known for tag ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(192930);
    throw paramString;
  }
  
  @Deprecated
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(193002);
    super.onAttachedToWindow();
    Object localObject = getCurrentTabTag();
    if (this.iT.size() > 0)
    {
      this.iT.get(0);
      AppMethodBeat.o(193002);
      throw null;
    }
    this.NE = true;
    localObject = aK((String)localObject);
    if (localObject != null)
    {
      ((FragmentTransaction)localObject).commit();
      this.bGO.executePendingTransactions();
    }
    AppMethodBeat.o(193002);
  }
  
  @Deprecated
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(193048);
    super.onDetachedFromWindow();
    this.NE = false;
    AppMethodBeat.o(193048);
  }
  
  @Deprecated
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(193062);
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      AppMethodBeat.o(193062);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    setCurrentTabByTag(paramParcelable.bDE);
    AppMethodBeat.o(193062);
  }
  
  @Deprecated
  protected Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(193055);
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.bDE = getCurrentTabTag();
    AppMethodBeat.o(193055);
    return localSavedState;
  }
  
  @Deprecated
  public void onTabChanged(String paramString)
  {
    AppMethodBeat.i(193072);
    if (this.NE)
    {
      FragmentTransaction localFragmentTransaction = aK(paramString);
      if (localFragmentTransaction != null) {
        localFragmentTransaction.commit();
      }
    }
    if (this.bDC != null) {
      this.bDC.onTabChanged(paramString);
    }
    AppMethodBeat.o(193072);
  }
  
  @Deprecated
  public void setOnTabChangedListener(TabHost.OnTabChangeListener paramOnTabChangeListener)
  {
    this.bDC = paramOnTabChangeListener;
  }
  
  @Deprecated
  public void setup()
  {
    AppMethodBeat.i(192940);
    IllegalStateException localIllegalStateException = new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    AppMethodBeat.o(192940);
    throw localIllegalStateException;
  }
  
  static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR;
    String bDE;
    
    static
    {
      AppMethodBeat.i(192933);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(192933);
    }
    
    SavedState(Parcel paramParcel)
    {
      super();
      AppMethodBeat.i(192924);
      this.bDE = paramParcel.readString();
      AppMethodBeat.o(192924);
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public String toString()
    {
      AppMethodBeat.i(192948);
      String str = "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.bDE + "}";
      AppMethodBeat.o(192948);
      return str;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(192943);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeString(this.bDE);
      AppMethodBeat.o(192943);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.legacy.app.FragmentTabHost
 * JD-Core Version:    0.7.0.1
 */