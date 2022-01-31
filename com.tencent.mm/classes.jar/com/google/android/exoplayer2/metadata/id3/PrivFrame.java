package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.i.t;
import java.util.Arrays;

public final class PrivFrame
  extends Id3Frame
{
  public static final Parcelable.Creator<PrivFrame> CREATOR = new PrivFrame.1();
  public final String aHm;
  public final byte[] aHn;
  
  PrivFrame(Parcel paramParcel)
  {
    super("PRIV");
    this.aHm = paramParcel.readString();
    this.aHn = paramParcel.createByteArray();
  }
  
  public PrivFrame(String paramString, byte[] paramArrayOfByte)
  {
    super("PRIV");
    this.aHm = paramString;
    this.aHn = paramArrayOfByte;
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
      paramObject = (PrivFrame)paramObject;
    } while ((t.e(this.aHm, paramObject.aHm)) && (Arrays.equals(this.aHn, paramObject.aHn)));
    return false;
  }
  
  public final int hashCode()
  {
    if (this.aHm != null) {}
    for (int i = this.aHm.hashCode();; i = 0) {
      return (i + 527) * 31 + Arrays.hashCode(this.aHn);
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.aHm);
    paramParcel.writeByteArray(this.aHn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.id3.PrivFrame
 * JD-Core Version:    0.7.0.1
 */