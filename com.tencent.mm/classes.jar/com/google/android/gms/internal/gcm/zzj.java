package com.google.android.gms.internal.gcm;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

final class zzj
  extends zzg
{
  private final zzh zzdi;
  
  zzj()
  {
    AppMethodBeat.i(2584);
    this.zzdi = new zzh();
    AppMethodBeat.o(2584);
  }
  
  public final void zzd(Throwable paramThrowable1, Throwable paramThrowable2)
  {
    AppMethodBeat.i(2585);
    if (paramThrowable2 == paramThrowable1)
    {
      paramThrowable1 = new IllegalArgumentException("Self suppression is not allowed.", paramThrowable2);
      AppMethodBeat.o(2585);
      throw paramThrowable1;
    }
    if (paramThrowable2 == null)
    {
      paramThrowable1 = new NullPointerException("The suppressed exception cannot be null.");
      AppMethodBeat.o(2585);
      throw paramThrowable1;
    }
    this.zzdi.zzd(paramThrowable1, true).add(paramThrowable2);
    AppMethodBeat.o(2585);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.internal.gcm.zzj
 * JD-Core Version:    0.7.0.1
 */