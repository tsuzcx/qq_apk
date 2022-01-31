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
  public final int aDC;
  public final int aDD;
  public final int aDE;
  private int axc;
  public final byte[] bbz;
  
  static
  {
    AppMethodBeat.i(95987);
    CREATOR = new ColorInfo.1();
    AppMethodBeat.o(95987);
  }
  
  public ColorInfo(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    this.aDC = paramInt1;
    this.aDE = paramInt2;
    this.aDD = paramInt3;
    this.bbz = paramArrayOfByte;
  }
  
  ColorInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(95982);
    this.aDC = paramParcel.readInt();
    this.aDE = paramParcel.readInt();
    this.aDD = paramParcel.readInt();
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
      this.bbz = paramParcel;
      AppMethodBeat.o(95982);
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
    AppMethodBeat.i(95983);
    if (this == paramObject)
    {
      AppMethodBeat.o(95983);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(95983);
      return false;
    }
    paramObject = (ColorInfo)paramObject;
    if ((this.aDC != paramObject.aDC) || (this.aDE != paramObject.aDE) || (this.aDD != paramObject.aDD) || (!Arrays.equals(this.bbz, paramObject.bbz)))
    {
      AppMethodBeat.o(95983);
      return false;
    }
    AppMethodBeat.o(95983);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(95985);
    if (this.axc == 0) {
      this.axc = ((((this.aDC + 527) * 31 + this.aDE) * 31 + this.aDD) * 31 + Arrays.hashCode(this.bbz));
    }
    int i = this.axc;
    AppMethodBeat.o(95985);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(95984);
    Object localObject = new StringBuilder("ColorInfo(").append(this.aDC).append(", ").append(this.aDE).append(", ").append(this.aDD).append(", ");
    if (this.bbz != null) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = bool + ")";
      AppMethodBeat.o(95984);
      return localObject;
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(95986);
    paramParcel.writeInt(this.aDC);
    paramParcel.writeInt(this.aDE);
    paramParcel.writeInt(this.aDD);
    if (this.bbz != null) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      if (this.bbz != null) {
        paramParcel.writeByteArray(this.bbz);
      }
      AppMethodBeat.o(95986);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.video.ColorInfo
 * JD-Core Version:    0.7.0.1
 */