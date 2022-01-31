package android.support.design.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

class BottomNavigationPresenter$SavedState
  implements Parcelable
{
  public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator() {};
  int dq;
  
  BottomNavigationPresenter$SavedState() {}
  
  BottomNavigationPresenter$SavedState(Parcel paramParcel)
  {
    this.dq = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.dq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.internal.BottomNavigationPresenter.SavedState
 * JD-Core Version:    0.7.0.1
 */