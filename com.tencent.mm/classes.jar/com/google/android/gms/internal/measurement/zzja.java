package com.google.android.gms.internal.measurement;

import android.content.ComponentName;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzja
  implements Runnable
{
  zzja(zziw paramzziw) {}
  
  public final void run()
  {
    AppMethodBeat.i(1868);
    zzii.zza(this.zzapn.zzape, new ComponentName(this.zzapn.zzape.getContext(), "com.google.android.gms.measurement.AppMeasurementService"));
    AppMethodBeat.o(1868);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzja
 * JD-Core Version:    0.7.0.1
 */