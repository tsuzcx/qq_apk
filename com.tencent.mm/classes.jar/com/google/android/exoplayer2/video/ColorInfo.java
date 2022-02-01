package com.google.android.exoplayer2.video;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class ColorInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ColorInfo> CREATOR;
  private int aFj;
  public final int aYU;
  public final int aYV;
  public final int aYW;
  public final byte[] bzA;
  
  static
  {
    AppMethodBeat.i(93258);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(93258);
  }
  
  public ColorInfo(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    this.aYU = paramInt1;
    this.aYW = paramInt2;
    this.aYV = paramInt3;
    this.bzA = paramArrayOfByte;
  }
  
  ColorInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(93253);
    this.aYU = paramParcel.readInt();
    this.aYW = paramParcel.readInt();
    this.aYV = paramParcel.readInt();
    int i;
    if (paramParcel.readInt() != 0)
    {
      i = 1;
      if (i == 0) {
        break label67;
      }
    }
    label67:
    for (paramParcel = paramParcel.createByteArray();; paramParcel = null)
    {
      this.bzA = paramParcel;
      AppMethodBeat.o(93253);
      return;
      i = 0;
      break;
    }
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(93254);
    if (this == paramObject)
    {
      AppMethodBeat.o(93254);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(93254);
      return false;
    }
    paramObject = (ColorInfo)paramObject;
    if ((this.aYU != paramObject.aYU) || (this.aYW != paramObject.aYW) || (this.aYV != paramObject.aYV) || (!Arrays.equals(this.bzA, paramObject.bzA)))
    {
      AppMethodBeat.o(93254);
      return false;
    }
    AppMethodBeat.o(93254);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(93256);
    if (this.aFj == 0) {
      this.aFj = ((((this.aYU + 527) * 31 + this.aYW) * 31 + this.aYV) * 31 + Arrays.hashCode(this.bzA));
    }
    int i = this.aFj;
    AppMethodBeat.o(93256);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(93255);
    Object localObject = new StringBuilder("ColorInfo(").append(this.aYU).append(", ").append(this.aYW).append(", ").append(this.aYV).append(", ");
    if (this.bzA != null) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = bool + ")";
      AppMethodBeat.o(93255);
      return localObject;
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(93257);
    paramParcel.writeInt(this.aYU);
    paramParcel.writeInt(this.aYW);
    paramParcel.writeInt(this.aYV);
    if (this.bzA != null) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      if (this.bzA != null) {
        paramParcel.writeByteArray(this.bzA);
      }
      AppMethodBeat.o(93257);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.video.ColorInfo
 * JD-Core Version:    0.7.0.1
 */