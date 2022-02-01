package com.google.android.exoplayer2.source.dash.manifest;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class RepresentationKey
  implements Parcelable, Comparable<RepresentationKey>
{
  public static final Parcelable.Creator<RepresentationKey> CREATOR;
  public final int bmU;
  public final int bmV;
  public final int bmb;
  
  static
  {
    AppMethodBeat.i(10570);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(10570);
  }
  
  public RepresentationKey(int paramInt1, int paramInt2, int paramInt3)
  {
    this.bmb = paramInt1;
    this.bmU = paramInt2;
    this.bmV = paramInt3;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(10568);
    String str = this.bmb + "." + this.bmU + "." + this.bmV;
    AppMethodBeat.o(10568);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(10569);
    paramParcel.writeInt(this.bmb);
    paramParcel.writeInt(this.bmU);
    paramParcel.writeInt(this.bmV);
    AppMethodBeat.o(10569);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.source.dash.manifest.RepresentationKey
 * JD-Core Version:    0.7.0.1
 */