package androidx.fragment.app;

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
  private a bDD;
  private final ArrayList<a> iT;
  private int mContainerId;
  private FragmentManager mFragmentManager;
  
  @Deprecated
  public FragmentTabHost(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(193881);
    this.iT = new ArrayList();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, new int[] { 16842995 }, 0, 0);
    this.mContainerId = paramContext.getResourceId(0, 0);
    paramContext.recycle();
    super.setOnTabChangedListener(this);
    AppMethodBeat.o(193881);
  }
  
  private a GB()
  {
    AppMethodBeat.i(193896);
    if (this.iT.size() > 0)
    {
      this.iT.get(0);
      AppMethodBeat.o(193896);
      throw null;
    }
    AppMethodBeat.o(193896);
    return null;
  }
  
  private r a(r paramr)
  {
    AppMethodBeat.i(193892);
    a locala = GB();
    if (this.bDD != locala)
    {
      paramr = this.mFragmentManager.beginTransaction();
      if (this.bDD != null)
      {
        AppMethodBeat.o(193892);
        throw null;
      }
      if (locala != null)
      {
        AppMethodBeat.o(193892);
        throw null;
      }
      this.bDD = locala;
    }
    AppMethodBeat.o(193892);
    return paramr;
  }
  
  @Deprecated
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(193920);
    super.onAttachedToWindow();
    getCurrentTabTag();
    if (this.iT.size() > 0)
    {
      this.iT.get(0);
      AppMethodBeat.o(193920);
      throw null;
    }
    this.NE = true;
    r localr = a(null);
    if (localr != null)
    {
      localr.FW();
      this.mFragmentManager.executePendingTransactions();
    }
    AppMethodBeat.o(193920);
  }
  
  @Deprecated
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(193928);
    super.onDetachedFromWindow();
    this.NE = false;
    AppMethodBeat.o(193928);
  }
  
  @Deprecated
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(193942);
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      AppMethodBeat.o(193942);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    setCurrentTabByTag(paramParcelable.bDE);
    AppMethodBeat.o(193942);
  }
  
  @Deprecated
  protected Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(193937);
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.bDE = getCurrentTabTag();
    AppMethodBeat.o(193937);
    return localSavedState;
  }
  
  @Deprecated
  public void onTabChanged(String paramString)
  {
    AppMethodBeat.i(193947);
    if (this.NE)
    {
      r localr = a(null);
      if (localr != null) {
        localr.FW();
      }
    }
    if (this.bDC != null) {
      this.bDC.onTabChanged(paramString);
    }
    AppMethodBeat.o(193947);
  }
  
  @Deprecated
  public void setOnTabChangedListener(TabHost.OnTabChangeListener paramOnTabChangeListener)
  {
    this.bDC = paramOnTabChangeListener;
  }
  
  @Deprecated
  public void setup()
  {
    AppMethodBeat.i(193903);
    IllegalStateException localIllegalStateException = new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    AppMethodBeat.o(193903);
    throw localIllegalStateException;
  }
  
  static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR;
    String bDE;
    
    static
    {
      AppMethodBeat.i(193895);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(193895);
    }
    
    SavedState(Parcel paramParcel)
    {
      super();
      AppMethodBeat.i(193891);
      this.bDE = paramParcel.readString();
      AppMethodBeat.o(193891);
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public String toString()
    {
      AppMethodBeat.i(193908);
      String str = "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.bDE + "}";
      AppMethodBeat.o(193908);
      return str;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(193901);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeString(this.bDE);
      AppMethodBeat.o(193901);
    }
  }
  
  static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.fragment.app.FragmentTabHost
 * JD-Core Version:    0.7.0.1
 */