package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.AbsSavedState;

public class RecyclerView$SavedState
  extends AbsSavedState
{
  public static final Parcelable.Creator<SavedState> CREATOR = new RecyclerView.SavedState.1();
  Parcelable ahz;
  
  RecyclerView$SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    super(paramParcel, paramClassLoader);
    if (paramClassLoader != null) {}
    for (;;)
    {
      this.ahz = paramParcel.readParcelable(paramClassLoader);
      return;
      paramClassLoader = RecyclerView.i.class.getClassLoader();
    }
  }
  
  RecyclerView$SavedState(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelable(this.ahz, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v7.widget.RecyclerView.SavedState
 * JD-Core Version:    0.7.0.1
 */