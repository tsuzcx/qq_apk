package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.i.m;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class PrivateCommand
  extends SpliceCommand
{
  public static final Parcelable.Creator<PrivateCommand> CREATOR;
  public final long cXX;
  public final long cXY;
  public final byte[] cXZ;
  
  static
  {
    AppMethodBeat.i(92484);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(92484);
  }
  
  private PrivateCommand(long paramLong1, byte[] paramArrayOfByte, long paramLong2)
  {
    this.cXX = paramLong2;
    this.cXY = paramLong1;
    this.cXZ = paramArrayOfByte;
  }
  
  private PrivateCommand(Parcel paramParcel)
  {
    AppMethodBeat.i(92481);
    this.cXX = paramParcel.readLong();
    this.cXY = paramParcel.readLong();
    this.cXZ = new byte[paramParcel.readInt()];
    paramParcel.readByteArray(this.cXZ);
    AppMethodBeat.o(92481);
  }
  
  static PrivateCommand a(m paramm, int paramInt, long paramLong)
  {
    AppMethodBeat.i(92482);
    long l = paramm.FT();
    byte[] arrayOfByte = new byte[paramInt - 4];
    paramm.readBytes(arrayOfByte, 0, arrayOfByte.length);
    paramm = new PrivateCommand(l, arrayOfByte, paramLong);
    AppMethodBeat.o(92482);
    return paramm;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(92483);
    paramParcel.writeLong(this.cXX);
    paramParcel.writeLong(this.cXY);
    paramParcel.writeInt(this.cXZ.length);
    paramParcel.writeByteArray(this.cXZ);
    AppMethodBeat.o(92483);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.scte35.PrivateCommand
 * JD-Core Version:    0.7.0.1
 */