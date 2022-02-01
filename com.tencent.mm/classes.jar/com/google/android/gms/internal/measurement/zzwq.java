package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzwq
  extends ContentObserver
{
  zzwq(zzwp paramzzwp, Handler paramHandler)
  {
    super(null);
  }
  
  public final void onChange(boolean paramBoolean)
  {
    AppMethodBeat.i(2283);
    this.zzbnb.zzru();
    zzwp.zza(this.zzbnb);
    AppMethodBeat.o(2283);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzwq
 * JD-Core Version:    0.7.0.1
 */