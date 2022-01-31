package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.i.m;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class PrivateCommand
  extends SpliceCommand
{
  public static final Parcelable.Creator<PrivateCommand> CREATOR;
  public final long aOi;
  public final long aOj;
  public final byte[] aOk;
  
  static
  {
    AppMethodBeat.i(95362);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(95362);
  }
  
  private PrivateCommand(long paramLong1, byte[] paramArrayOfByte, long paramLong2)
  {
    this.aOi = paramLong2;
    this.aOj = paramLong1;
    this.aOk = paramArrayOfByte;
  }
  
  private PrivateCommand(Parcel paramParcel)
  {
    AppMethodBeat.i(95359);
    this.aOi = paramParcel.readLong();
    this.aOj = paramParcel.readLong();
    this.aOk = new byte[paramParcel.readInt()];
    paramParcel.readByteArray(this.aOk);
    AppMethodBeat.o(95359);
  }
  
  static PrivateCommand a(m paramm, int paramInt, long paramLong)
  {
    AppMethodBeat.i(95360);
    long l = paramm.cc();
    byte[] arrayOfByte = new byte[paramInt - 4];
    paramm.readBytes(arrayOfByte, 0, arrayOfByte.length);
    paramm = new PrivateCommand(l, arrayOfByte, paramLong);
    AppMethodBeat.o(95360);
    return paramm;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(95361);
    paramParcel.writeLong(this.aOi);
    paramParcel.writeLong(this.aOj);
    paramParcel.writeInt(this.aOk.length);
    paramParcel.writeByteArray(this.aOk);
    AppMethodBeat.o(95361);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.scte35.PrivateCommand
 * JD-Core Version:    0.7.0.1
 */