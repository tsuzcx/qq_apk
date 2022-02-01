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
  private int aHQ;
  public final byte[] bHw;
  public final int bkb;
  public final int bkc;
  public final int bkd;
  
  static
  {
    AppMethodBeat.i(93258);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(93258);
  }
  
  public ColorInfo(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    this.bkb = paramInt1;
    this.bkd = paramInt2;
    this.bkc = paramInt3;
    this.bHw = paramArrayOfByte;
  }
  
  ColorInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(93253);
    this.bkb = paramParcel.readInt();
    this.bkd = paramParcel.readInt();
    this.bkc = paramParcel.readInt();
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
      this.bHw = paramParcel;
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
    if ((this.bkb != paramObject.bkb) || (this.bkd != paramObject.bkd) || (this.bkc != paramObject.bkc) || (!Arrays.equals(this.bHw, paramObject.bHw)))
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
    if (this.aHQ == 0) {
      this.aHQ = ((((this.bkb + 527) * 31 + this.bkd) * 31 + this.bkc) * 31 + Arrays.hashCode(this.bHw));
    }
    int i = this.aHQ;
    AppMethodBeat.o(93256);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(93255);
    Object localObject = new StringBuilder("ColorInfo(").append(this.bkb).append(", ").append(this.bkd).append(", ").append(this.bkc).append(", ");
    if (this.bHw != null) {}
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
    paramParcel.writeInt(this.bkb);
    paramParcel.writeInt(this.bkd);
    paramParcel.writeInt(this.bkc);
    if (this.bHw != null) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      if (this.bHw != null) {
        paramParcel.writeByteArray(this.bHw);
      }
      AppMethodBeat.o(93257);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.video.ColorInfo
 * JD-Core Version:    0.7.0.1
 */