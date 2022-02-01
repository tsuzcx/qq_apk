package com.google.android.gms.internal.firebase_messaging;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

final class zzl
  extends zzi
{
  private final zzj zzk;
  
  zzl()
  {
    AppMethodBeat.i(4121);
    this.zzk = new zzj();
    AppMethodBeat.o(4121);
  }
  
  public final void zza(Throwable paramThrowable1, Throwable paramThrowable2)
  {
    AppMethodBeat.i(4122);
    if (paramThrowable2 == paramThrowable1)
    {
      paramThrowable1 = new IllegalArgumentException("Self suppression is not allowed.", paramThrowable2);
      AppMethodBeat.o(4122);
      throw paramThrowable1;
    }
    if (paramThrowable2 == null)
    {
      paramThrowable1 = new NullPointerException("The suppressed exception cannot be null.");
      AppMethodBeat.o(4122);
      throw paramThrowable1;
    }
    this.zzk.zza(paramThrowable1, true).add(paramThrowable2);
    AppMethodBeat.o(4122);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.firebase_messaging.zzl
 * JD-Core Version:    0.7.0.1
 */