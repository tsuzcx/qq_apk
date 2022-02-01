package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class BinaryFrame
  extends Id3Frame
{
  public static final Parcelable.Creator<BinaryFrame> CREATOR;
  public final byte[] data;
  
  static
  {
    AppMethodBeat.i(92407);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(92407);
  }
  
  BinaryFrame(Parcel paramParcel)
  {
    super(paramParcel.readString());
    AppMethodBeat.i(92403);
    this.data = paramParcel.createByteArray();
    AppMethodBeat.o(92403);
  }
  
  public BinaryFrame(String paramString, byte[] paramArrayOfByte)
  {
    super(paramString);
    this.data = paramArrayOfByte;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(92404);
    if (this == paramObject)
    {
      AppMethodBeat.o(92404);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(92404);
      return false;
    }
    paramObject = (BinaryFrame)paramObject;
    if ((this.id.equals(paramObject.id)) && (Arrays.equals(this.data, paramObject.data)))
    {
      AppMethodBeat.o(92404);
      return true;
    }
    AppMethodBeat.o(92404);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(92405);
    int i = this.id.hashCode();
    int j = Arrays.hashCode(this.data);
    AppMethodBeat.o(92405);
    return (i + 527) * 31 + j;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(92406);
    paramParcel.writeString(this.id);
    paramParcel.writeByteArray(this.data);
    AppMethodBeat.o(92406);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.id3.BinaryFrame
 * JD-Core Version:    0.7.0.1
 */