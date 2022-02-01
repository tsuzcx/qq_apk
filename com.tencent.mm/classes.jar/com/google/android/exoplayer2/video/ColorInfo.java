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
  private int aFZ;
  public final int aZG;
  public final int aZH;
  public final int aZI;
  public final byte[] bxi;
  
  static
  {
    AppMethodBeat.i(93258);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(93258);
  }
  
  public ColorInfo(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    this.aZG = paramInt1;
    this.aZI = paramInt2;
    this.aZH = paramInt3;
    this.bxi = paramArrayOfByte;
  }
  
  ColorInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(93253);
    this.aZG = paramParcel.readInt();
    this.aZI = paramParcel.readInt();
    this.aZH = paramParcel.readInt();
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
      this.bxi = paramParcel;
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
    if ((this.aZG != paramObject.aZG) || (this.aZI != paramObject.aZI) || (this.aZH != paramObject.aZH) || (!Arrays.equals(this.bxi, paramObject.bxi)))
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
    if (this.aFZ == 0) {
      this.aFZ = ((((this.aZG + 527) * 31 + this.aZI) * 31 + this.aZH) * 31 + Arrays.hashCode(this.bxi));
    }
    int i = this.aFZ;
    AppMethodBeat.o(93256);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(93255);
    Object localObject = new StringBuilder("ColorInfo(").append(this.aZG).append(", ").append(this.aZI).append(", ").append(this.aZH).append(", ");
    if (this.bxi != null) {}
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
    paramParcel.writeInt(this.aZG);
    paramParcel.writeInt(this.aZI);
    paramParcel.writeInt(this.aZH);
    if (this.bxi != null) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      if (this.bxi != null) {
        paramParcel.writeByteArray(this.bxi);
      }
      AppMethodBeat.o(93257);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.video.ColorInfo
 * JD-Core Version:    0.7.0.1
 */