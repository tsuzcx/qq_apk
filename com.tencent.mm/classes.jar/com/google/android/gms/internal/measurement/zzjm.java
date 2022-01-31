package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzjm
{
  private long startTime;
  private final Clock zzro;
  
  public zzjm(Clock paramClock)
  {
    AppMethodBeat.i(69396);
    Preconditions.checkNotNull(paramClock);
    this.zzro = paramClock;
    AppMethodBeat.o(69396);
  }
  
  public final void clear()
  {
    this.startTime = 0L;
  }
  
  public final void start()
  {
    AppMethodBeat.i(69397);
    this.startTime = this.zzro.elapsedRealtime();
    AppMethodBeat.o(69397);
  }
  
  public final boolean zzj(long paramLong)
  {
    AppMethodBeat.i(69398);
    if (this.startTime == 0L)
    {
      AppMethodBeat.o(69398);
      return true;
    }
    if (this.zzro.elapsedRealtime() - this.startTime >= 3600000L)
    {
      AppMethodBeat.o(69398);
      return true;
    }
    AppMethodBeat.o(69398);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzjm
 * JD-Core Version:    0.7.0.1
 */