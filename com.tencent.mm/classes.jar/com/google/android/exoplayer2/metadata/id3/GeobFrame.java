package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class GeobFrame
  extends Id3Frame
{
  public static final Parcelable.Creator<GeobFrame> CREATOR;
  public final byte[] data;
  public final String description;
  public final String filename;
  public final String mimeType;
  
  static
  {
    AppMethodBeat.i(95309);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(95309);
  }
  
  GeobFrame(Parcel paramParcel)
  {
    super("GEOB");
    AppMethodBeat.i(95305);
    this.mimeType = paramParcel.readString();
    this.filename = paramParcel.readString();
    this.description = paramParcel.readString();
    this.data = paramParcel.createByteArray();
    AppMethodBeat.o(95305);
  }
  
  public GeobFrame(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte)
  {
    super("GEOB");
    this.mimeType = paramString1;
    this.filename = paramString2;
    this.description = paramString3;
    this.data = paramArrayOfByte;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(95306);
    if (this == paramObject)
    {
      AppMethodBeat.o(95306);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(95306);
      return false;
    }
    paramObject = (GeobFrame)paramObject;
    if ((x.e(this.mimeType, paramObject.mimeType)) && (x.e(this.filename, paramObject.filename)) && (x.e(this.description, paramObject.description)) && (Arrays.equals(this.data, paramObject.data)))
    {
      AppMethodBeat.o(95306);
      return true;
    }
    AppMethodBeat.o(95306);
    return false;
  }
  
  public final int hashCode()
  {
    int k = 0;
    AppMethodBeat.i(95307);
    int i;
    if (this.mimeType != null)
    {
      i = this.mimeType.hashCode();
      if (this.filename == null) {
        break label93;
      }
    }
    label93:
    for (int j = this.filename.hashCode();; j = 0)
    {
      if (this.description != null) {
        k = this.description.hashCode();
      }
      int m = Arrays.hashCode(this.data);
      AppMethodBeat.o(95307);
      return ((j + (i + 527) * 31) * 31 + k) * 31 + m;
      i = 0;
      break;
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(95308);
    paramParcel.writeString(this.mimeType);
    paramParcel.writeString(this.filename);
    paramParcel.writeString(this.description);
    paramParcel.writeByteArray(this.data);
    AppMethodBeat.o(95308);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.id3.GeobFrame
 * JD-Core Version:    0.7.0.1
 */