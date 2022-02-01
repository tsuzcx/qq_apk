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
  private int aHK;
  public final byte[] bHM;
  public final int bjW;
  public final int bjX;
  public final int bjY;
  
  static
  {
    AppMethodBeat.i(93258);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(93258);
  }
  
  public ColorInfo(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    this.bjW = paramInt1;
    this.bjY = paramInt2;
    this.bjX = paramInt3;
    this.bHM = paramArrayOfByte;
  }
  
  ColorInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(93253);
    this.bjW = paramParcel.readInt();
    this.bjY = paramParcel.readInt();
    this.bjX = paramParcel.readInt();
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
      this.bHM = paramParcel;
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
    if ((this.bjW != paramObject.bjW) || (this.bjY != paramObject.bjY) || (this.bjX != paramObject.bjX) || (!Arrays.equals(this.bHM, paramObject.bHM)))
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
    if (this.aHK == 0) {
      this.aHK = ((((this.bjW + 527) * 31 + this.bjY) * 31 + this.bjX) * 31 + Arrays.hashCode(this.bHM));
    }
    int i = this.aHK;
    AppMethodBeat.o(93256);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(93255);
    Object localObject = new StringBuilder("ColorInfo(").append(this.bjW).append(", ").append(this.bjY).append(", ").append(this.bjX).append(", ");
    if (this.bHM != null) {}
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
    paramParcel.writeInt(this.bjW);
    paramParcel.writeInt(this.bjY);
    paramParcel.writeInt(this.bjX);
    if (this.bHM != null) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      if (this.bHM != null) {
        paramParcel.writeByteArray(this.bHM);
      }
      AppMethodBeat.o(93257);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.video.ColorInfo
 * JD-Core Version:    0.7.0.1
 */