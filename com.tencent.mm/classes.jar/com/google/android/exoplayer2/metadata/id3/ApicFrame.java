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
  public final int aNR;
  public final byte[] aNS;
  public final String description;
  public final String mimeType;
  
  static
  {
    AppMethodBeat.i(95279);
    CREATOR = new ApicFrame.1();
    AppMethodBeat.o(95279);
  }
  
  ApicFrame(Parcel paramParcel)
  {
    super("APIC");
    AppMethodBeat.i(95275);
    this.mimeType = paramParcel.readString();
    this.description = paramParcel.readString();
    this.aNR = paramParcel.readInt();
    this.aNS = paramParcel.createByteArray();
    AppMethodBeat.o(95275);
  }
  
  public ApicFrame(String paramString1, String paramString2, int paramInt, byte[] paramArrayOfByte)
  {
    super("APIC");
    this.mimeType = paramString1;
    this.description = paramString2;
    this.aNR = paramInt;
    this.aNS = paramArrayOfByte;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(95276);
    if (this == paramObject)
    {
      AppMethodBeat.o(95276);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(95276);
      return false;
    }
    paramObject = (ApicFrame)paramObject;
    if ((this.aNR == paramObject.aNR) && (x.e(this.mimeType, paramObject.mimeType)) && (x.e(this.description, paramObject.description)) && (Arrays.equals(this.aNS, paramObject.aNS)))
    {
      AppMethodBeat.o(95276);
      return true;
    }
    AppMethodBeat.o(95276);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(95277);
    int k = this.aNR;
    if (this.mimeType != null) {}
    for (int i = this.mimeType.hashCode();; i = 0)
    {
      if (this.description != null) {
        j = this.description.hashCode();
      }
      int m = Arrays.hashCode(this.aNS);
      AppMethodBeat.o(95277);
      return ((i + (k + 527) * 31) * 31 + j) * 31 + m;
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(95278);
    paramParcel.writeString(this.mimeType);
    paramParcel.writeString(this.description);
    paramParcel.writeInt(this.aNR);
    paramParcel.writeByteArray(this.aNS);
    AppMethodBeat.o(95278);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.id3.ApicFrame
 * JD-Core Version:    0.7.0.1
 */