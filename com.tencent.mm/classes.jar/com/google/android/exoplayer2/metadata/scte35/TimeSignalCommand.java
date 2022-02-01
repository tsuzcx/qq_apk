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
  public final long buY;
  public final long buZ;
  
  static
  {
    AppMethodBeat.i(92508);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(92508);
  }
  
  private TimeSignalCommand(long paramLong1, long paramLong2)
  {
    this.buY = paramLong1;
    this.buZ = paramLong2;
  }
  
  static TimeSignalCommand b(m paramm, long paramLong, u paramu)
  {
    AppMethodBeat.i(92505);
    paramLong = c(paramm, paramLong);
    paramm = new TimeSignalCommand(paramLong, paramu.ao(paramLong));
    AppMethodBeat.o(92505);
    return paramm;
  }
  
  static long c(m paramm, long paramLong)
  {
    AppMethodBeat.i(92506);
    long l2 = paramm.readUnsignedByte();
    long l1 = -9223372036854775807L;
    if ((0x80 & l2) != 0L) {
      l1 = ((1L & l2) << 32 | paramm.dE()) + paramLong & 0xFFFFFFFF;
    }
    AppMethodBeat.o(92506);
    return l1;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(92507);
    paramParcel.writeLong(this.buY);
    paramParcel.writeLong(this.buZ);
    AppMethodBeat.o(92507);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.scte35.TimeSignalCommand
 * JD-Core Version:    0.7.0.1
 */