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

public class FragmentTabHost
  extends TabHost
  implements TabHost.OnTabChangeListener
{
  private TabHost.OnTabChangeListener Wn;
  private a Wo;
  private boolean Wp;
  private final ArrayList<a> hV;
  private int mContainerId;
  private e mFragmentManager;
  
  public FragmentTabHost(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(212881);
    this.hV = new ArrayList();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, new int[] { 16842995 }, 0, 0);
    this.mContainerId = paramContext.getResourceId(0, 0);
    paramContext.recycle();
    super.setOnTabChangedListener(this);
    AppMethodBeat.o(212881);
  }
  
  private i a(i parami)
  {
    AppMethodBeat.i(212892);
    iE();
    if (this.Wo != null)
    {
      parami = this.mFragmentManager.beginTransaction();
      if (this.Wo != null)
      {
        AppMethodBeat.o(212892);
        throw null;
      }
      this.Wo = null;
    }
    AppMethodBeat.o(212892);
    return parami;
  }
  
  private a iE()
  {
    AppMethodBeat.i(212894);
    if (this.hV.size() > 0)
    {
      this.hV.get(0);
      AppMethodBeat.o(212894);
      throw null;
    }
    AppMethodBeat.o(212894);
    return null;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(212884);
    super.onAttachedToWindow();
    getCurrentTabTag();
    if (this.hV.size() > 0)
    {
      this.hV.get(0);
      AppMethodBeat.o(212884);
      throw null;
    }
    this.Wp = true;
    i locali = a(null);
    if (locali != null)
    {
      locali.in();
      this.mFragmentManager.executePendingTransactions();
    }
    AppMethodBeat.o(212884);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(212886);
    super.onDetachedFromWindow();
    this.Wp = false;
    AppMethodBeat.o(212886);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(212888);
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      AppMethodBeat.o(212888);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    setCurrentTabByTag(paramParcelable.Wq);
    AppMethodBeat.o(212888);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(212887);
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.Wq = getCurrentTabTag();
    AppMethodBeat.o(212887);
    return localSavedState;
  }
  
  public void onTabChanged(String paramString)
  {
    AppMethodBeat.i(212890);
    if (this.Wp)
    {
      i locali = a(null);
      if (locali != null) {
        locali.in();
      }
    }
    if (this.Wn != null) {
      this.Wn.onTabChanged(paramString);
    }
    AppMethodBeat.o(212890);
  }
  
  public void setOnTabChangedListener(TabHost.OnTabChangeListener paramOnTabChangeListener)
  {
    this.Wn = paramOnTabChangeListener;
  }
  
  @Deprecated
  public void setup()
  {
    AppMethodBeat.i(212883);
    IllegalStateException localIllegalStateException = new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    AppMethodBeat.o(212883);
    throw localIllegalStateException;
  }
  
  static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR;
    String Wq;
    
    static
    {
      AppMethodBeat.i(212879);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(212879);
    }
    
    SavedState(Parcel paramParcel)
    {
      super();
      AppMethodBeat.i(212875);
      this.Wq = paramParcel.readString();
      AppMethodBeat.o(212875);
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public String toString()
    {
      AppMethodBeat.i(212878);
      String str = "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.Wq + "}";
      AppMethodBeat.o(212878);
      return str;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(212876);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeString(this.Wq);
      AppMethodBeat.o(212876);
    }
  }
  
  static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.fragment.app.FragmentTabHost
 * JD-Core Version:    0.7.0.1
 */