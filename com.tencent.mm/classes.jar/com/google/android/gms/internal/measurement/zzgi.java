package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzgi
  implements Thread.UncaughtExceptionHandler
{
  private final String zzaly;
  
  public zzgi(zzgg paramzzgg, String paramString)
  {
    AppMethodBeat.i(1576);
    Preconditions.checkNotNull(paramString);
    this.zzaly = paramString;
    AppMethodBeat.o(1576);
  }
  
  public final void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    try
    {
      AppMethodBeat.i(1577);
      this.zzalz.zzge().zzim().zzg(this.zzaly, paramThrowable);
      AppMethodBeat.o(1577);
      return;
    }
    finally
    {
      paramThread = finally;
      throw paramThread;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzgi
 * JD-Core Version:    0.7.0.1
 */