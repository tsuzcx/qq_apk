package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.u;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class TimeSignalCommand
  extends SpliceCommand
{
  public static final Parcelable.Creator<TimeSignalCommand> CREATOR;
  public final long aOE;
  public final long aOF;
  
  static
  {
    AppMethodBeat.i(95386);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(95386);
  }
  
  private TimeSignalCommand(long paramLong1, long paramLong2)
  {
    this.aOE = paramLong1;
    this.aOF = paramLong2;
  }
  
  static TimeSignalCommand b(m paramm, long paramLong, u paramu)
  {
    AppMethodBeat.i(95383);
    paramLong = c(paramm, paramLong);
    paramm = new TimeSignalCommand(paramLong, paramu.ah(paramLong));
    AppMethodBeat.o(95383);
    return paramm;
  }
  
  static long c(m paramm, long paramLong)
  {
    AppMethodBeat.i(95384);
    long l2 = paramm.readUnsignedByte();
    long l1 = -9223372036854775807L;
    if ((0x80 & l2) != 0L) {
      l1 = ((1L & l2) << 32 | paramm.cc()) + paramLong & 0xFFFFFFFF;
    }
    AppMethodBeat.o(95384);
    return l1;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(95385);
    paramParcel.writeLong(this.aOE);
    paramParcel.writeLong(this.aOF);
    AppMethodBeat.o(95385);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.scte35.TimeSignalCommand
 * JD-Core Version:    0.7.0.1
 */