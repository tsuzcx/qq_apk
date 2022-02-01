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
  public final String bjG;
  public final byte[] bjH;
  
  static
  {
    AppMethodBeat.i(92449);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(92449);
  }
  
  PrivFrame(Parcel paramParcel)
  {
    super("PRIV");
    AppMethodBeat.i(92445);
    this.bjG = paramParcel.readString();
    this.bjH = paramParcel.createByteArray();
    AppMethodBeat.o(92445);
  }
  
  public PrivFrame(String paramString, byte[] paramArrayOfByte)
  {
    super("PRIV");
    this.bjG = paramString;
    this.bjH = paramArrayOfByte;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(92446);
    if (this == paramObject)
    {
      AppMethodBeat.o(92446);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(92446);
      return false;
    }
    paramObject = (PrivFrame)paramObject;
    if ((x.g(this.bjG, paramObject.bjG)) && (Arrays.equals(this.bjH, paramObject.bjH)))
    {
      AppMethodBeat.o(92446);
      return true;
    }
    AppMethodBeat.o(92446);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(92447);
    if (this.bjG != null) {}
    for (int i = this.bjG.hashCode();; i = 0)
    {
      int j = Arrays.hashCode(this.bjH);
      AppMethodBeat.o(92447);
      return (i + 527) * 31 + j;
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(92448);
    paramParcel.writeString(this.bjG);
    paramParcel.writeByteArray(this.bjH);
    AppMethodBeat.o(92448);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.id3.PrivFrame
 * JD-Core Version:    0.7.0.1
 */