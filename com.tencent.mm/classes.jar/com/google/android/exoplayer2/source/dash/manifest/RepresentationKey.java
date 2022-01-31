package com.google.android.exoplayer2.source.dash.manifest;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class RepresentationKey
  implements Parcelable, Comparable<RepresentationKey>
{
  public static final Parcelable.Creator<RepresentationKey> CREATOR;
  public final int aPX;
  public final int aQP;
  public final int aQQ;
  
  static
  {
    AppMethodBeat.i(94136);
    CREATOR = new RepresentationKey.1();
    AppMethodBeat.o(94136);
  }
  
  public RepresentationKey(int paramInt1, int paramInt2, int paramInt3)
  {
    this.aPX = paramInt1;
    this.aQP = paramInt2;
    this.aQQ = paramInt3;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(94134);
    String str = this.aPX + "." + this.aQP + "." + this.aQQ;
    AppMethodBeat.o(94134);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(94135);
    paramParcel.writeInt(this.aPX);
    paramParcel.writeInt(this.aQP);
    paramParcel.writeInt(this.aQQ);
    AppMethodBeat.o(94135);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.source.dash.manifest.RepresentationKey
 * JD-Core Version:    0.7.0.1
 */