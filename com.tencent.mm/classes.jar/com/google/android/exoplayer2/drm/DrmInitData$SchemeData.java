package com.google.android.exoplayer2.drm;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.i.t;
import java.util.Arrays;
import java.util.UUID;

public final class DrmInitData$SchemeData
  implements Parcelable
{
  public static final Parcelable.Creator<SchemeData> CREATOR = new DrmInitData.SchemeData.1();
  private int auK;
  public final boolean ayS;
  public final byte[] data;
  public final String mimeType;
  public final String type;
  final UUID uuid;
  
  DrmInitData$SchemeData(Parcel paramParcel)
  {
    this.uuid = new UUID(paramParcel.readLong(), paramParcel.readLong());
    this.type = paramParcel.readString();
    this.mimeType = paramParcel.readString();
    this.data = paramParcel.createByteArray();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.ayS = bool;
      return;
    }
  }
  
  public DrmInitData$SchemeData(UUID paramUUID, String paramString1, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    this.uuid = ((UUID)a.E(paramUUID));
    this.type = paramString1;
    this.mimeType = ((String)a.E(paramString2));
    this.data = ((byte[])a.E(paramArrayOfByte));
    this.ayS = paramBoolean;
  }
  
  public DrmInitData$SchemeData(UUID paramUUID, String paramString, byte[] paramArrayOfByte)
  {
    this(paramUUID, null, paramString, paramArrayOfByte, false);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof SchemeData)) {}
    do
    {
      return false;
      if (paramObject == this) {
        return true;
      }
      paramObject = (SchemeData)paramObject;
    } while ((!this.mimeType.equals(paramObject.mimeType)) || (!t.e(this.uuid, paramObject.uuid)) || (!t.e(this.type, paramObject.type)) || (!Arrays.equals(this.data, paramObject.data)));
    return true;
  }
  
  public final int hashCode()
  {
    int j;
    if (this.auK == 0)
    {
      j = this.uuid.hashCode();
      if (this.type != null) {
        break label61;
      }
    }
    label61:
    for (int i = 0;; i = this.type.hashCode())
    {
      this.auK = (((i + j * 31) * 31 + this.mimeType.hashCode()) * 31 + Arrays.hashCode(this.data));
      return this.auK;
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.uuid.getMostSignificantBits());
    paramParcel.writeLong(this.uuid.getLeastSignificantBits());
    paramParcel.writeString(this.type);
    paramParcel.writeString(this.mimeType);
    paramParcel.writeByteArray(this.data);
    if (this.ayS) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.drm.DrmInitData.SchemeData
 * JD-Core Version:    0.7.0.1
 */