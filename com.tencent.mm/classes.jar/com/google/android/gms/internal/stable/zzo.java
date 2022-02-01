package com.google.android.gms.internal.stable;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

final class zzo
  extends zzl
{
  private final zzm zzahm;
  
  zzo()
  {
    AppMethodBeat.i(5521);
    this.zzahm = new zzm();
    AppMethodBeat.o(5521);
  }
  
  public final void zza(Throwable paramThrowable1, Throwable paramThrowable2)
  {
    AppMethodBeat.i(5522);
    if (paramThrowable2 == paramThrowable1)
    {
      paramThrowable1 = new IllegalArgumentException("Self suppression is not allowed.", paramThrowable2);
      AppMethodBeat.o(5522);
      throw paramThrowable1;
    }
    if (paramThrowable2 == null)
    {
      paramThrowable1 = new NullPointerException("The suppressed exception cannot be null.");
      AppMethodBeat.o(5522);
      throw paramThrowable1;
    }
    this.zzahm.zza(paramThrowable1, true).add(paramThrowable2);
    AppMethodBeat.o(5522);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.stable.zzo
 * JD-Core Version:    0.7.0.1
 */