package com.google.android.exoplayer2.video;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Arrays;

public final class ColorInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ColorInfo> CREATOR = new ColorInfo.1();
  public final int aSY;
  public final int aSZ;
  public final int aTa;
  public final byte[] aTb;
  private int auK;
  
  ColorInfo(Parcel paramParcel)
  {
    this.aSY = paramParcel.readInt();
    this.aSZ = paramParcel.readInt();
    this.aTa = paramParcel.readInt();
    int i;
    if (paramParcel.readInt() != 0)
    {
      i = 1;
      if (i == 0) {
        break label57;
      }
    }
    label57:
    for (paramParcel = paramParcel.createByteArray();; paramParcel = null)
    {
      this.aTb = paramParcel;
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
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (ColorInfo)paramObject;
    } while ((this.aSY == paramObject.aSY) && (this.aSZ == paramObject.aSZ) && (this.aTa == paramObject.aTa) && (Arrays.equals(this.aTb, paramObject.aTb)));
    return false;
  }
  
  public final int hashCode()
  {
    if (this.auK == 0) {
      this.auK = ((((this.aSY + 527) * 31 + this.aSZ) * 31 + this.aTa) * 31 + Arrays.hashCode(this.aTb));
    }
    return this.auK;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("ColorInfo(").append(this.aSY).append(", ").append(this.aSZ).append(", ").append(this.aTa).append(", ");
    if (this.aTb != null) {}
    for (boolean bool = true;; bool = false) {
      return bool + ")";
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.aSY);
    paramParcel.writeInt(this.aSZ);
    paramParcel.writeInt(this.aTa);
    if (this.aTb != null) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      if (this.aTb != null) {
        paramParcel.writeByteArray(this.aTb);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.video.ColorInfo
 * JD-Core Version:    0.7.0.1
 */