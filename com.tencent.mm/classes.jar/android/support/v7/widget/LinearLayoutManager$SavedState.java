package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class LinearLayoutManager$SavedState
  implements Parcelable
{
  public static final Parcelable.Creator<SavedState> CREATOR = new LinearLayoutManager.SavedState.1();
  int agJ;
  int agK;
  boolean agL;
  
  public LinearLayoutManager$SavedState() {}
  
  LinearLayoutManager$SavedState(Parcel paramParcel)
  {
    this.agJ = paramParcel.readInt();
    this.agK = paramParcel.readInt();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.agL = bool;
      return;
      bool = false;
    }
  }
  
  public LinearLayoutManager$SavedState(SavedState paramSavedState)
  {
    this.agJ = paramSavedState.agJ;
    this.agK = paramSavedState.agK;
    this.agL = paramSavedState.agL;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  final boolean iz()
  {
    return this.agJ >= 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.agJ);
    paramParcel.writeInt(this.agK);
    if (this.agL) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v7.widget.LinearLayoutManager.SavedState
 * JD-Core Version:    0.7.0.1
 */