package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

public final class zzbr
  extends zzej
{
  private final Object lock;
  @Nullable
  @GuardedBy("lock")
  private zzav zzcw;
  @Nullable
  @GuardedBy("lock")
  private zzbs zzda;
  
  public zzbr()
  {
    AppMethodBeat.i(101085);
    this.lock = new Object();
    AppMethodBeat.o(101085);
  }
  
  public final void zza(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(101087);
    synchronized (this.lock)
    {
      zzbs localzzbs = this.zzda;
      zzav localzzav = new zzav(paramInt1, paramInt2);
      this.zzcw = localzzav;
      if (localzzbs != null) {
        localzzbs.zzb(localzzav);
      }
      AppMethodBeat.o(101087);
      return;
    }
  }
  
  public final void zza(zzbs paramzzbs)
  {
    AppMethodBeat.i(101086);
    synchronized (this.lock)
    {
      this.zzda = ((zzbs)Preconditions.checkNotNull(paramzzbs));
      zzav localzzav = this.zzcw;
      if (localzzav != null) {
        paramzzbs.zzb(localzzav);
      }
      AppMethodBeat.o(101086);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzbr
 * JD-Core Version:    0.7.0.1
 */