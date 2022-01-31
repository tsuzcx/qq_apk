package com.google.android.flexbox;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

class FlexboxLayoutManager$SavedState
  implements Parcelable
{
  public static final Parcelable.Creator<SavedState> CREATOR;
  private int agJ;
  private int agK;
  
  static
  {
    AppMethodBeat.i(54792);
    CREATOR = new FlexboxLayoutManager.SavedState.1();
    AppMethodBeat.o(54792);
  }
  
  FlexboxLayoutManager$SavedState() {}
  
  private FlexboxLayoutManager$SavedState(Parcel paramParcel)
  {
    AppMethodBeat.i(54790);
    this.agJ = paramParcel.readInt();
    this.agK = paramParcel.readInt();
    AppMethodBeat.o(54790);
  }
  
  private FlexboxLayoutManager$SavedState(SavedState paramSavedState)
  {
    this.agJ = paramSavedState.agJ;
    this.agK = paramSavedState.agK;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(54791);
    String str = "SavedState{mAnchorPosition=" + this.agJ + ", mAnchorOffset=" + this.agK + '}';
    AppMethodBeat.o(54791);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(54789);
    paramParcel.writeInt(this.agJ);
    paramParcel.writeInt(this.agK);
    AppMethodBeat.o(54789);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.flexbox.FlexboxLayoutManager.SavedState
 * JD-Core Version:    0.7.0.1
 */