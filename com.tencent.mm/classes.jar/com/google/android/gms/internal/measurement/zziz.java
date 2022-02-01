package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zziz
  implements Runnable
{
  zziz(zziw paramzziw, zzey paramzzey) {}
  
  public final void run()
  {
    AppMethodBeat.i(1867);
    synchronized (this.zzapn)
    {
      zziw.zza(this.zzapn, false);
      if (!this.zzapn.zzape.isConnected())
      {
        this.zzapn.zzape.zzge().zzis().log("Connected to remote service");
        this.zzapn.zzape.zza(this.zzapo);
      }
      AppMethodBeat.o(1867);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zziz
 * JD-Core Version:    0.7.0.1
 */