package com.google.android.flexbox;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

class FlexboxLayoutManager$SavedState
  implements Parcelable
{
  public static final Parcelable.Creator<SavedState> CREATOR;
  private int aqP;
  private int aqQ;
  
  static
  {
    AppMethodBeat.i(62329);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(62329);
  }
  
  FlexboxLayoutManager$SavedState() {}
  
  private FlexboxLayoutManager$SavedState(Parcel paramParcel)
  {
    AppMethodBeat.i(62327);
    this.aqP = paramParcel.readInt();
    this.aqQ = paramParcel.readInt();
    AppMethodBeat.o(62327);
  }
  
  private FlexboxLayoutManager$SavedState(SavedState paramSavedState)
  {
    this.aqP = paramSavedState.aqP;
    this.aqQ = paramSavedState.aqQ;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(62328);
    String str = "SavedState{mAnchorPosition=" + this.aqP + ", mAnchorOffset=" + this.aqQ + '}';
    AppMethodBeat.o(62328);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(62326);
    paramParcel.writeInt(this.aqP);
    paramParcel.writeInt(this.aqQ);
    AppMethodBeat.o(62326);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.flexbox.FlexboxLayoutManager.SavedState
 * JD-Core Version:    0.7.0.1
 */