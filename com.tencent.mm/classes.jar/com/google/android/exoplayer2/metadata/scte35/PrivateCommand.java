package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.i.m;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class PrivateCommand
  extends SpliceCommand
{
  public static final Parcelable.Creator<PrivateCommand> CREATOR;
  public final long buC;
  public final long buD;
  public final byte[] buE;
  
  static
  {
    AppMethodBeat.i(92484);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(92484);
  }
  
  private PrivateCommand(long paramLong1, byte[] paramArrayOfByte, long paramLong2)
  {
    this.buC = paramLong2;
    this.buD = paramLong1;
    this.buE = paramArrayOfByte;
  }
  
  private PrivateCommand(Parcel paramParcel)
  {
    AppMethodBeat.i(92481);
    this.buC = paramParcel.readLong();
    this.buD = paramParcel.readLong();
    this.buE = new byte[paramParcel.readInt()];
    paramParcel.readByteArray(this.buE);
    AppMethodBeat.o(92481);
  }
  
  static PrivateCommand a(m paramm, int paramInt, long paramLong)
  {
    AppMethodBeat.i(92482);
    long l = paramm.dE();
    byte[] arrayOfByte = new byte[paramInt - 4];
    paramm.readBytes(arrayOfByte, 0, arrayOfByte.length);
    paramm = new PrivateCommand(l, arrayOfByte, paramLong);
    AppMethodBeat.o(92482);
    return paramm;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(92483);
    paramParcel.writeLong(this.buC);
    paramParcel.writeLong(this.buD);
    paramParcel.writeInt(this.buE.length);
    paramParcel.writeByteArray(this.buE);
    AppMethodBeat.o(92483);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.scte35.PrivateCommand
 * JD-Core Version:    0.7.0.1
 */