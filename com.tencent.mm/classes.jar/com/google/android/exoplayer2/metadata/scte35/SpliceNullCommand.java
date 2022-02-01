package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class SpliceNullCommand
  extends SpliceCommand
{
  public static final Parcelable.Creator<SpliceNullCommand> CREATOR;
  
  static
  {
    AppMethodBeat.i(92494);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(92494);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.scte35.SpliceNullCommand
 * JD-Core Version:    0.7.0.1
 */