package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicLong;

final class zzgj<V>
  extends FutureTask<V>
  implements Comparable<zzgj>
{
  private final String zzaly;
  private final long zzama;
  final boolean zzamb;
  
  zzgj(zzgg paramzzgg, Runnable paramRunnable, boolean paramBoolean, String paramString)
  {
    super(paramRunnable, null);
    AppMethodBeat.i(1579);
    Preconditions.checkNotNull(paramString);
    this.zzama = zzgg.zzjm().getAndIncrement();
    this.zzaly = paramString;
    this.zzamb = false;
    if (this.zzama == 9223372036854775807L) {
      paramzzgg.zzge().zzim().log("Tasks index overflow");
    }
    AppMethodBeat.o(1579);
  }
  
  zzgj(Callable<V> paramCallable, boolean paramBoolean, String paramString)
  {
    super(paramBoolean);
    AppMethodBeat.i(1578);
    Object localObject;
    Preconditions.checkNotNull(localObject);
    this.zzama = zzgg.zzjm().getAndIncrement();
    this.zzaly = localObject;
    this.zzamb = paramString;
    if (this.zzama == 9223372036854775807L) {
      paramCallable.zzge().zzim().log("Tasks index overflow");
    }
    AppMethodBeat.o(1578);
  }
  
  protected final void setException(Throwable paramThrowable)
  {
    AppMethodBeat.i(1580);
    this.zzalz.zzge().zzim().zzg(this.zzaly, paramThrowable);
    if ((paramThrowable instanceof zzgh)) {
      Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), paramThrowable);
    }
    super.setException(paramThrowable);
    AppMethodBeat.o(1580);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzgj
 * JD-Core Version:    0.7.0.1
 */