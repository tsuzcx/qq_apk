package com.google.android.exoplayer2.source.dash.manifest;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class RepresentationKey
  implements Parcelable, Comparable<RepresentationKey>
{
  public static final Parcelable.Creator<RepresentationKey> CREATOR;
  public final int cZS;
  public final int daM;
  public final int daN;
  
  static
  {
    AppMethodBeat.i(10570);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(10570);
  }
  
  public RepresentationKey(int paramInt1, int paramInt2, int paramInt3)
  {
    this.cZS = paramInt1;
    this.daM = paramInt2;
    this.daN = paramInt3;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(10568);
    String str = this.cZS + "." + this.daM + "." + this.daN;
    AppMethodBeat.o(10568);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(10569);
    paramParcel.writeInt(this.cZS);
    paramParcel.writeInt(this.daM);
    paramParcel.writeInt(this.daN);
    AppMethodBeat.o(10569);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.source.dash.manifest.RepresentationKey
 * JD-Core Version:    0.7.0.1
 */