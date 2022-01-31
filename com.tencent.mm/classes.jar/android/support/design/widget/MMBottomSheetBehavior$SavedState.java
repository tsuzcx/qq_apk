package android.support.design.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.AbsSavedState;

public class MMBottomSheetBehavior$SavedState
  extends AbsSavedState
{
  public static final Parcelable.Creator<SavedState> CREATOR = new MMBottomSheetBehavior.SavedState.1();
  final int state;
  
  public MMBottomSheetBehavior$SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    super(paramParcel, paramClassLoader);
    this.state = paramParcel.readInt();
  }
  
  public MMBottomSheetBehavior$SavedState(Parcelable paramParcelable, int paramInt)
  {
    super(paramParcelable);
    this.state = paramInt;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.state);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.widget.MMBottomSheetBehavior.SavedState
 * JD-Core Version:    0.7.0.1
 */