package com.google.android.exoplayer2.drm;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.UUID;

public final class DrmInitData$SchemeData
  implements Parcelable
{
  public static final Parcelable.Creator<SchemeData> CREATOR;
  public final boolean aBh;
  private int axc;
  public final byte[] data;
  public final String mimeType;
  public final String type;
  final UUID uuid;
  
  static
  {
    AppMethodBeat.i(94761);
    CREATOR = new DrmInitData.SchemeData.1();
    AppMethodBeat.o(94761);
  }
  
  DrmInitData$SchemeData(Parcel paramParcel)
  {
    AppMethodBeat.i(94757);
    this.uuid = new UUID(paramParcel.readLong(), paramParcel.readLong());
    this.type = paramParcel.readString();
    this.mimeType = paramParcel.readString();
    this.data = paramParcel.createByteArray();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.aBh = bool;
      AppMethodBeat.o(94757);
      return;
    }
  }
  
  public DrmInitData$SchemeData(UUID paramUUID, String paramString1, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    AppMethodBeat.i(94756);
    this.uuid = ((UUID)a.checkNotNull(paramUUID));
    this.type = paramString1;
    this.mimeType = ((String)a.checkNotNull(paramString2));
    this.data = ((byte[])a.checkNotNull(paramArrayOfByte));
    this.aBh = paramBoolean;
    AppMethodBeat.o(94756);
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
    AppMethodBeat.i(94758);
    if (!(paramObject instanceof SchemeData))
    {
      AppMethodBeat.o(94758);
      return false;
    }
    if (paramObject == this)
    {
      AppMethodBeat.o(94758);
      return true;
    }
    paramObject = (SchemeData)paramObject;
    if ((this.mimeType.equals(paramObject.mimeType)) && (x.e(this.uuid, paramObject.uuid)) && (x.e(this.type, paramObject.type)) && (Arrays.equals(this.data, paramObject.data)))
    {
      AppMethodBeat.o(94758);
      return true;
    }
    AppMethodBeat.o(94758);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(94759);
    int j;
    if (this.axc == 0)
    {
      j = this.uuid.hashCode();
      if (this.type != null) {
        break label73;
      }
    }
    label73:
    for (int i = 0;; i = this.type.hashCode())
    {
      this.axc = (((i + j * 31) * 31 + this.mimeType.hashCode()) * 31 + Arrays.hashCode(this.data));
      i = this.axc;
      AppMethodBeat.o(94759);
      return i;
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(94760);
    paramParcel.writeLong(this.uuid.getMostSignificantBits());
    paramParcel.writeLong(this.uuid.getLeastSignificantBits());
    paramParcel.writeString(this.type);
    paramParcel.writeString(this.mimeType);
    paramParcel.writeByteArray(this.data);
    if (this.aBh) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      AppMethodBeat.o(94760);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.drm.DrmInitData.SchemeData
 * JD-Core Version:    0.7.0.1
 */