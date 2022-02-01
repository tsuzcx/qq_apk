package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class ApicFrame
  extends Id3Frame
{
  public static final Parcelable.Creator<ApicFrame> CREATOR;
  public final int bjr;
  public final byte[] bjs;
  public final String description;
  public final String mimeType;
  
  static
  {
    AppMethodBeat.i(92401);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(92401);
  }
  
  ApicFrame(Parcel paramParcel)
  {
    super("APIC");
    AppMethodBeat.i(92397);
    this.mimeType = paramParcel.readString();
    this.description = paramParcel.readString();
    this.bjr = paramParcel.readInt();
    this.bjs = paramParcel.createByteArray();
    AppMethodBeat.o(92397);
  }
  
  public ApicFrame(String paramString1, String paramString2, int paramInt, byte[] paramArrayOfByte)
  {
    super("APIC");
    this.mimeType = paramString1;
    this.description = paramString2;
    this.bjr = paramInt;
    this.bjs = paramArrayOfByte;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(92398);
    if (this == paramObject)
    {
      AppMethodBeat.o(92398);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(92398);
      return false;
    }
    paramObject = (ApicFrame)paramObject;
    if ((this.bjr == paramObject.bjr) && (x.g(this.mimeType, paramObject.mimeType)) && (x.g(this.description, paramObject.description)) && (Arrays.equals(this.bjs, paramObject.bjs)))
    {
      AppMethodBeat.o(92398);
      return true;
    }
    AppMethodBeat.o(92398);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(92399);
    int k = this.bjr;
    if (this.mimeType != null) {}
    for (int i = this.mimeType.hashCode();; i = 0)
    {
      if (this.description != null) {
        j = this.description.hashCode();
      }
      int m = Arrays.hashCode(this.bjs);
      AppMethodBeat.o(92399);
      return ((i + (k + 527) * 31) * 31 + j) * 31 + m;
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(92400);
    paramParcel.writeString(this.mimeType);
    paramParcel.writeString(this.description);
    paramParcel.writeInt(this.bjr);
    paramParcel.writeByteArray(this.bjs);
    AppMethodBeat.o(92400);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.id3.ApicFrame
 * JD-Core Version:    0.7.0.1
 */