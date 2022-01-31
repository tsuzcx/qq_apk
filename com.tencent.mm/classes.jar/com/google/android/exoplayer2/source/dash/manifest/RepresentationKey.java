package com.google.android.exoplayer2.source.dash.manifest;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class RepresentationKey
  implements Parcelable, Comparable<RepresentationKey>
{
  public static final Parcelable.Creator<RepresentationKey> CREATOR = new RepresentationKey.1();
  public final int aIm;
  public final int aJi;
  public final int aJj;
  
  public RepresentationKey(int paramInt1, int paramInt2, int paramInt3)
  {
    this.aIm = paramInt1;
    this.aJi = paramInt2;
    this.aJj = paramInt3;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    return this.aIm + "." + this.aJi + "." + this.aJj;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.aIm);
    paramParcel.writeInt(this.aJi);
    paramParcel.writeInt(this.aJj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.source.dash.manifest.RepresentationKey
 * JD-Core Version:    0.7.0.1
 */