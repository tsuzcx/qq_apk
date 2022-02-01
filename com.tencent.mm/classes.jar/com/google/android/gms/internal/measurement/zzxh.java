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
    AppMethodBeat.i(40333);
    this.zzbod = new zzxf();
    AppMethodBeat.o(40333);
  }
  
  public final void zza(Throwable paramThrowable, PrintStream paramPrintStream)
  {
    AppMethodBeat.i(40334);
    paramThrowable.printStackTrace(paramPrintStream);
    paramThrowable = this.zzbod.zza(paramThrowable, false);
    if (paramThrowable == null)
    {
      AppMethodBeat.o(40334);
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
      AppMethodBeat.o(40334);
    }
    AppMethodBeat.o(40334);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzxh
 * JD-Core Version:    0.7.0.1
 */