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
  private int cHb;
  public final int cNw;
  public final int colorRange;
  public final int colorTransfer;
  public final byte[] dkY;
  
  static
  {
    AppMethodBeat.i(93258);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(93258);
  }
  
  public ColorInfo(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    this.cNw = paramInt1;
    this.colorRange = paramInt2;
    this.colorTransfer = paramInt3;
    this.dkY = paramArrayOfByte;
  }
  
  ColorInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(93253);
    this.cNw = paramParcel.readInt();
    this.colorRange = paramParcel.readInt();
    this.colorTransfer = paramParcel.readInt();
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
      this.dkY = paramParcel;
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
    if ((this.cNw != paramObject.cNw) || (this.colorRange != paramObject.colorRange) || (this.colorTransfer != paramObject.colorTransfer) || (!Arrays.equals(this.dkY, paramObject.dkY)))
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
    if (this.cHb == 0) {
      this.cHb = ((((this.cNw + 527) * 31 + this.colorRange) * 31 + this.colorTransfer) * 31 + Arrays.hashCode(this.dkY));
    }
    int i = this.cHb;
    AppMethodBeat.o(93256);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(93255);
    Object localObject = new StringBuilder("ColorInfo(").append(this.cNw).append(", ").append(this.colorRange).append(", ").append(this.colorTransfer).append(", ");
    if (this.dkY != null) {}
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
    paramParcel.writeInt(this.cNw);
    paramParcel.writeInt(this.colorRange);
    paramParcel.writeInt(this.colorTransfer);
    if (this.dkY != null) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      if (this.dkY != null) {
        paramParcel.writeByteArray(this.dkY);
      }
      AppMethodBeat.o(93257);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.video.ColorInfo
 * JD-Core Version:    0.7.0.1
 */