package com.google.android.gms.common.providers;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

final class zza
  implements PooledExecutorsProvider.PooledExecutorFactory
{
  public final ScheduledExecutorService newSingleThreadScheduledExecutor()
  {
    AppMethodBeat.i(4956);
    ScheduledExecutorService localScheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
    AppMethodBeat.o(4956);
    return localScheduledExecutorService;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.common.providers.zza
 * JD-Core Version:    0.7.0.1
 */