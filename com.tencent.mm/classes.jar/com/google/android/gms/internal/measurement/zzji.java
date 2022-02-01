package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.common.util.Clock;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzji
  extends zzem
{
  zzji(zzjh paramzzjh, zzhi paramzzhi)
  {
    super(paramzzhi);
  }
  
  public final void run()
  {
    AppMethodBeat.i(1915);
    zzjh localzzjh = this.zzapx;
    localzzjh.zzab();
    long l = localzzjh.zzbt().elapsedRealtime();
    localzzjh.zzge().zzit().zzg("Session started, time", Long.valueOf(l));
    localzzjh.zzgf().zzakk.set(false);
    localzzjh.zzfu().zza("auto", "_s", new Bundle());
    localzzjh.zzgf().zzakl.set(localzzjh.zzbt().currentTimeMillis());
    AppMethodBeat.o(1915);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzji
 * JD-Core Version:    0.7.0.1
 */