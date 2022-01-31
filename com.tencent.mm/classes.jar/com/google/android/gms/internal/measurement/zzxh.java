package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;

final class zzxh
  extends zzxe
{
  private final zzxf zzbod;
  
  zzxh()
  {
    AppMethodBeat.i(3543);
    this.zzbod = new zzxf();
    AppMethodBeat.o(3543);
  }
  
  public final void zza(Throwable paramThrowable, PrintStream paramPrintStream)
  {
    AppMethodBeat.i(3544);
    paramThrowable.printStackTrace(paramPrintStream);
    paramThrowable = this.zzbod.zza(paramThrowable, false);
    if (paramThrowable == null)
    {
      AppMethodBeat.o(3544);
      return;
    }
    try
    {
      Iterator localIterator = paramThrowable.iterator();
      while (localIterator.hasNext())
      {
        Throwable localThrowable = (Throwable)localIterator.next();
        paramPrintStream.print("Suppressed: ");
        localThrowable.printStackTrace(paramPrintStream);
      }
    }
    finally
    {
      AppMethodBeat.o(3544);
    }
    AppMethodBeat.o(3544);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzxh
 * JD-Core Version:    0.7.0.1
 */