package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class PrivFrame
  extends Id3Frame
{
  public static final Parcelable.Creator<PrivFrame> CREATOR;
  public final String aOg;
  public final byte[] aOh;
  
  static
  {
    AppMethodBeat.i(95327);
    CREATOR = new PrivFrame.1();
    AppMethodBeat.o(95327);
  }
  
  PrivFrame(Parcel paramParcel)
  {
    super("PRIV");
    AppMethodBeat.i(95323);
    this.aOg = paramParcel.readString();
    this.aOh = paramParcel.createByteArray();
    AppMethodBeat.o(95323);
  }
  
  public PrivFrame(String paramString, byte[] paramArrayOfByte)
  {
    super("PRIV");
    this.aOg = paramString;
    this.aOh = paramArrayOfByte;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(95324);
    if (this == paramObject)
    {
      AppMethodBeat.o(95324);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(95324);
      return false;
    }
    paramObject = (PrivFrame)paramObject;
    if ((x.e(this.aOg, paramObject.aOg)) && (Arrays.equals(this.aOh, paramObject.aOh)))
    {
      AppMethodBeat.o(95324);
      return true;
    }
    AppMethodBeat.o(95324);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(95325);
    if (this.aOg != null) {}
    for (int i = this.aOg.hashCode();; i = 0)
    {
      int j = Arrays.hashCode(this.aOh);
      AppMethodBeat.o(95325);
      return (i + 527) * 31 + j;
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(95326);
    paramParcel.writeString(this.aOg);
    paramParcel.writeByteArray(this.aOh);
    AppMethodBeat.o(95326);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.id3.PrivFrame
 * JD-Core Version:    0.7.0.1
 */