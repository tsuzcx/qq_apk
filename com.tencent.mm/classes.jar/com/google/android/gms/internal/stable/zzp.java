package com.google.android.gms.internal.stable;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzp
  extends zzl
{
  public final void zza(Throwable paramThrowable1, Throwable paramThrowable2)
  {
    AppMethodBeat.i(5523);
    paramThrowable1.addSuppressed(paramThrowable2);
    AppMethodBeat.o(5523);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.internal.stable.zzp
 * JD-Core Version:    0.7.0.1
 */