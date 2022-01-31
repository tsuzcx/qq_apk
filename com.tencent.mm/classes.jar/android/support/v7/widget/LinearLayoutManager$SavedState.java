package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class LinearLayoutManager$SavedState
  implements Parcelable
{
  public static final Parcelable.Creator<SavedState> CREATOR = new LinearLayoutManager.SavedState.1();
  int aew;
  int aex;
  boolean aey;
  
  public LinearLayoutManager$SavedState() {}
  
  LinearLayoutManager$SavedState(Parcel paramParcel)
  {
    this.aew = paramParcel.readInt();
    this.aex = paramParcel.readInt();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.aey = bool;
      return;
      bool = false;
    }
  }
  
  public LinearLayoutManager$SavedState(SavedState paramSavedState)
  {
    this.aew = paramSavedState.aew;
    this.aex = paramSavedState.aex;
    this.aey = paramSavedState.aey;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  final boolean hd()
  {
    return this.aew >= 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.aew);
    paramParcel.writeInt(this.aex);
    if (this.aey) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v7.widget.LinearLayoutManager.SavedState
 * JD-Core Version:    0.7.0.1
 */