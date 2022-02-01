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
  public final int bdN;
  public final byte[] bdO;
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
    this.bdN = paramParcel.readInt();
    this.bdO = paramParcel.createByteArray();
    AppMethodBeat.o(92397);
  }
  
  public ApicFrame(String paramString1, String paramString2, int paramInt, byte[] paramArrayOfByte)
  {
    super("APIC");
    this.mimeType = paramString1;
    this.description = paramString2;
    this.bdN = paramInt;
    this.bdO = paramArrayOfByte;
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
    if ((this.bdN == paramObject.bdN) && (x.h(this.mimeType, paramObject.mimeType)) && (x.h(this.description, paramObject.description)) && (Arrays.equals(this.bdO, paramObject.bdO)))
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
    int k = this.bdN;
    if (this.mimeType != null) {}
    for (int i = this.mimeType.hashCode();; i = 0)
    {
      if (this.description != null) {
        j = this.description.hashCode();
      }
      int m = Arrays.hashCode(this.bdO);
      AppMethodBeat.o(92399);
      return ((i + (k + 527) * 31) * 31 + j) * 31 + m;
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(92400);
    paramParcel.writeString(this.mimeType);
    paramParcel.writeString(this.description);
    paramParcel.writeInt(this.bdN);
    paramParcel.writeByteArray(this.bdO);
    AppMethodBeat.o(92400);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.id3.ApicFrame
 * JD-Core Version:    0.7.0.1
 */