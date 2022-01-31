package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzjo
  extends zzem
{
  zzjo(zzjn paramzzjn, zzhi paramzzhi, zzjr paramzzjr)
  {
    super(paramzzhi);
  }
  
  public final void run()
  {
    AppMethodBeat.i(69427);
    this.zzapz.cancel();
    this.zzapz.zzge().zzit().log("Starting upload from DelayedRunnable");
    this.zzapt.zzks();
    AppMethodBeat.o(69427);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzjo
 * JD-Core Version:    0.7.0.1
 */