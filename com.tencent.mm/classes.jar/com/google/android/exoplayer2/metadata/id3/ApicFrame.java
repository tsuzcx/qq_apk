package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.i.t;
import java.util.Arrays;

public final class ApicFrame
  extends Id3Frame
{
  public static final Parcelable.Creator<ApicFrame> CREATOR = new ApicFrame.1();
  public final int aGW;
  public final byte[] aGX;
  public final String description;
  public final String mimeType;
  
  ApicFrame(Parcel paramParcel)
  {
    super("APIC");
    this.mimeType = paramParcel.readString();
    this.description = paramParcel.readString();
    this.aGW = paramParcel.readInt();
    this.aGX = paramParcel.createByteArray();
  }
  
  public ApicFrame(String paramString1, String paramString2, int paramInt, byte[] paramArrayOfByte)
  {
    super("APIC");
    this.mimeType = paramString1;
    this.description = paramString2;
    this.aGW = paramInt;
    this.aGX = paramArrayOfByte;
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
      paramObject = (ApicFrame)paramObject;
    } while ((this.aGW == paramObject.aGW) && (t.e(this.mimeType, paramObject.mimeType)) && (t.e(this.description, paramObject.description)) && (Arrays.equals(this.aGX, paramObject.aGX)));
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    int k = this.aGW;
    if (this.mimeType != null) {}
    for (int i = this.mimeType.hashCode();; i = 0)
    {
      if (this.description != null) {
        j = this.description.hashCode();
      }
      return ((i + (k + 527) * 31) * 31 + j) * 31 + Arrays.hashCode(this.aGX);
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mimeType);
    paramParcel.writeString(this.description);
    paramParcel.writeInt(this.aGW);
    paramParcel.writeByteArray(this.aGX);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.id3.ApicFrame
 * JD-Core Version:    0.7.0.1
 */