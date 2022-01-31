package com.google.android.exoplayer2.metadata.emsg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.i.t;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import java.util.Arrays;

public final class EventMessage
  implements Metadata.Entry
{
  public static final Parcelable.Creator<EventMessage> CREATOR = new EventMessage.1();
  public final String aGT;
  public final long aGU;
  public final byte[] aGV;
  private int auK;
  public final long id;
  public final String value;
  
  EventMessage(Parcel paramParcel)
  {
    this.aGT = paramParcel.readString();
    this.value = paramParcel.readString();
    this.aGU = paramParcel.readLong();
    this.id = paramParcel.readLong();
    this.aGV = paramParcel.createByteArray();
  }
  
  public EventMessage(String paramString1, String paramString2, long paramLong1, long paramLong2, byte[] paramArrayOfByte)
  {
    this.aGT = paramString1;
    this.value = paramString2;
    this.aGU = paramLong1;
    this.id = paramLong2;
    this.aGV = paramArrayOfByte;
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
      paramObject = (EventMessage)paramObject;
    } while ((this.aGU == paramObject.aGU) && (this.id == paramObject.id) && (t.e(this.aGT, paramObject.aGT)) && (t.e(this.value, paramObject.value)) && (Arrays.equals(this.aGV, paramObject.aGV)));
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (this.auK == 0) {
      if (this.aGT == null) {
        break label103;
      }
    }
    label103:
    for (int i = this.aGT.hashCode();; i = 0)
    {
      if (this.value != null) {
        j = this.value.hashCode();
      }
      this.auK = (((((i + 527) * 31 + j) * 31 + (int)(this.aGU ^ this.aGU >>> 32)) * 31 + (int)(this.id ^ this.id >>> 32)) * 31 + Arrays.hashCode(this.aGV));
      return this.auK;
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.aGT);
    paramParcel.writeString(this.value);
    paramParcel.writeLong(this.aGU);
    paramParcel.writeLong(this.id);
    paramParcel.writeByteArray(this.aGV);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.emsg.EventMessage
 * JD-Core Version:    0.7.0.1
 */