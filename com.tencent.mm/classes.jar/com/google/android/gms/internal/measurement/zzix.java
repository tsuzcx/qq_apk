package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzix
  implements Runnable
{
  zzix(zziw paramzziw, zzey paramzzey) {}
  
  public final void run()
  {
    AppMethodBeat.i(69342);
    synchronized (this.zzapn)
    {
      zziw.zza(this.zzapn, false);
      if (!this.zzapn.zzape.isConnected())
      {
        this.zzapn.zzape.zzge().zzit().log("Connected to service");
        this.zzapn.zzape.zza(this.zzapm);
      }
      AppMethodBeat.o(69342);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzix
 * JD-Core Version:    0.7.0.1
 */