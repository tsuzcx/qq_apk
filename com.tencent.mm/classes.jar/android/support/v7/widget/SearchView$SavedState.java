package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.AbsSavedState;

class SearchView$SavedState
  extends AbsSavedState
{
  public static final Parcelable.Creator<SavedState> CREATOR = new SearchView.SavedState.1();
  boolean amn;
  
  public SearchView$SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    super(paramParcel, paramClassLoader);
    this.amn = ((Boolean)paramParcel.readValue(null)).booleanValue();
  }
  
  SearchView$SavedState(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  public String toString()
  {
    return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.amn + "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeValue(Boolean.valueOf(this.amn));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.v7.widget.SearchView.SavedState
 * JD-Core Version:    0.7.0.1
 */