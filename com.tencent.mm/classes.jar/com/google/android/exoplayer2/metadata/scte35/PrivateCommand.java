package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.i.m;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class PrivateCommand
  extends SpliceCommand
{
  public static final Parcelable.Creator<PrivateCommand> CREATOR;
  public final long bjI;
  public final long bjJ;
  public final byte[] bjK;
  
  static
  {
    AppMethodBeat.i(92484);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(92484);
  }
  
  private PrivateCommand(long paramLong1, byte[] paramArrayOfByte, long paramLong2)
  {
    this.bjI = paramLong2;
    this.bjJ = paramLong1;
    this.bjK = paramArrayOfByte;
  }
  
  private PrivateCommand(Parcel paramParcel)
  {
    AppMethodBeat.i(92481);
    this.bjI = paramParcel.readLong();
    this.bjJ = paramParcel.readLong();
    this.bjK = new byte[paramParcel.readInt()];
    paramParcel.readByteArray(this.bjK);
    AppMethodBeat.o(92481);
  }
  
  static PrivateCommand a(m paramm, int paramInt, long paramLong)
  {
    AppMethodBeat.i(92482);
    long l = paramm.df();
    byte[] arrayOfByte = new byte[paramInt - 4];
    paramm.readBytes(arrayOfByte, 0, arrayOfByte.length);
    paramm = new PrivateCommand(l, arrayOfByte, paramLong);
    AppMethodBeat.o(92482);
    return paramm;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(92483);
    paramParcel.writeLong(this.bjI);
    paramParcel.writeLong(this.bjJ);
    paramParcel.writeInt(this.bjK.length);
    paramParcel.writeByteArray(this.bjK);
    AppMethodBeat.o(92483);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.scte35.PrivateCommand
 * JD-Core Version:    0.7.0.1
 */