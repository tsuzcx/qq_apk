package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.i.j;

public final class PrivateCommand
  extends SpliceCommand
{
  public static final Parcelable.Creator<PrivateCommand> CREATOR = new PrivateCommand.1();
  public final long aHo;
  public final long aHp;
  public final byte[] aHq;
  
  private PrivateCommand(long paramLong1, byte[] paramArrayOfByte, long paramLong2)
  {
    this.aHo = paramLong2;
    this.aHp = paramLong1;
    this.aHq = paramArrayOfByte;
  }
  
  private PrivateCommand(Parcel paramParcel)
  {
    this.aHo = paramParcel.readLong();
    this.aHp = paramParcel.readLong();
    this.aHq = new byte[paramParcel.readInt()];
    paramParcel.readByteArray(this.aHq);
  }
  
  static PrivateCommand a(j paramj, int paramInt, long paramLong)
  {
    long l = paramj.bp();
    byte[] arrayOfByte = new byte[paramInt - 4];
    paramj.readBytes(arrayOfByte, 0, arrayOfByte.length);
    return new PrivateCommand(l, arrayOfByte, paramLong);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.aHo);
    paramParcel.writeLong(this.aHp);
    paramParcel.writeInt(this.aHq.length);
    paramParcel.writeByteArray(this.aHq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.scte35.PrivateCommand
 * JD-Core Version:    0.7.0.1
 */