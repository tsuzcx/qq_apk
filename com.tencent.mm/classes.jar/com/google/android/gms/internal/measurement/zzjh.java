package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzjh
  extends zzhh
{
  private Handler handler;
  @VisibleForTesting
  private long zzapu;
  private final zzem zzapv;
  private final zzem zzapw;
  
  zzjh(zzgl paramzzgl)
  {
    super(paramzzgl);
    AppMethodBeat.i(1886);
    this.zzapv = new zzji(this, this.zzacw);
    this.zzapw = new zzjj(this, this.zzacw);
    this.zzapu = zzbt().elapsedRealtime();
    AppMethodBeat.o(1886);
  }
  
  private final void zzaf(long paramLong)
  {
    AppMethodBeat.i(1889);
    zzab();
    zzki();
    this.zzapv.cancel();
    this.zzapw.cancel();
    zzge().zzit().zzg("Activity resumed, time", Long.valueOf(paramLong));
    this.zzapu = paramLong;
    if (zzbt().currentTimeMillis() - zzgf().zzakj.get() > zzgf().zzakl.get())
    {
      zzgf().zzakk.set(true);
      zzgf().zzakm.set(0L);
    }
    if (zzgf().zzakk.get())
    {
      this.zzapv.zzh(Math.max(0L, zzgf().zzaki.get() - zzgf().zzakm.get()));
      AppMethodBeat.o(1889);
      return;
    }
    this.zzapw.zzh(Math.max(0L, 3600000L - zzgf().zzakm.get()));
    AppMethodBeat.o(1889);
  }
  
  private final void zzag(long paramLong)
  {
    AppMethodBeat.i(1890);
    zzab();
    zzki();
    this.zzapv.cancel();
    this.zzapw.cancel();
    zzge().zzit().zzg("Activity paused, time", Long.valueOf(paramLong));
    if (this.zzapu != 0L) {
      zzgf().zzakm.set(zzgf().zzakm.get() + (paramLong - this.zzapu));
    }
    AppMethodBeat.o(1890);
  }
  
  private final void zzki()
  {
    AppMethodBeat.i(1887);
    try
    {
      if (this.handler == null) {
        this.handler = new Handler(Looper.getMainLooper());
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(1887);
    }
  }
  
  private final void zzkk()
  {
    AppMethodBeat.i(1892);
    zzab();
    zzl(false);
    zzft().zzk(zzbt().elapsedRealtime());
    AppMethodBeat.o(1892);
  }
  
  protected final boolean zzhf()
  {
    return false;
  }
  
  final void zzkj()
  {
    AppMethodBeat.i(1888);
    this.zzapv.cancel();
    this.zzapw.cancel();
    this.zzapu = 0L;
    AppMethodBeat.o(1888);
  }
  
  public final boolean zzl(boolean paramBoolean)
  {
    AppMethodBeat.i(1891);
    zzab();
    zzch();
    long l1 = zzbt().elapsedRealtime();
    zzgf().zzakl.set(zzbt().currentTimeMillis());
    long l2 = l1 - this.zzapu;
    if ((!paramBoolean) && (l2 < 1000L))
    {
      zzge().zzit().zzg("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(l2));
      AppMethodBeat.o(1891);
      return false;
    }
    zzgf().zzakm.set(l2);
    zzge().zzit().zzg("Recording user engagement, ms", Long.valueOf(l2));
    Bundle localBundle = new Bundle();
    localBundle.putLong("_et", l2);
    zzif.zza(zzfy().zzkc(), localBundle, true);
    zzfu().logEvent("auto", "_e", localBundle);
    this.zzapu = l1;
    this.zzapw.cancel();
    this.zzapw.zzh(Math.max(0L, 3600000L - zzgf().zzakm.get()));
    AppMethodBeat.o(1891);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzjh
 * JD-Core Version:    0.7.0.1
 */