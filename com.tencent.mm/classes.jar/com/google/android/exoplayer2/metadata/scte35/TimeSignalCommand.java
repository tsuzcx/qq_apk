package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.i.q;

public final class TimeSignalCommand
  extends SpliceCommand
{
  public static final Parcelable.Creator<TimeSignalCommand> CREATOR = new Parcelable.Creator() {};
  public final long aHK;
  public final long aHL;
  
  private TimeSignalCommand(long paramLong1, long paramLong2)
  {
    this.aHK = paramLong1;
    this.aHL = paramLong2;
  }
  
  static long a(j paramj, long paramLong)
  {
    long l2 = paramj.readUnsignedByte();
    long l1 = -9223372036854775807L;
    if ((0x80 & l2) != 0L) {
      l1 = ((1L & l2) << 32 | paramj.bp()) + paramLong & 0xFFFFFFFF;
    }
    return l1;
  }
  
  static TimeSignalCommand b(j paramj, long paramLong, q paramq)
  {
    paramLong = a(paramj, paramLong);
    return new TimeSignalCommand(paramLong, paramq.W(paramLong));
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.aHK);
    paramParcel.writeLong(this.aHL);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.scte35.TimeSignalCommand
 * JD-Core Version:    0.7.0.1
 */