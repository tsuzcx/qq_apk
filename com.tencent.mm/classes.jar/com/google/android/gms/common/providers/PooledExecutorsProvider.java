package com.google.android.gms.common.providers;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ScheduledExecutorService;

public class PooledExecutorsProvider
{
  private static PooledExecutorFactory zzvs;
  
  public static PooledExecutorFactory createDefaultFactory()
  {
    AppMethodBeat.i(4955);
    zza localzza = new zza();
    AppMethodBeat.o(4955);
    return localzza;
  }
  
  public static PooledExecutorFactory getInstance()
  {
    try
    {
      AppMethodBeat.i(4954);
      if (zzvs == null) {
        zzvs = createDefaultFactory();
      }
      PooledExecutorFactory localPooledExecutorFactory = zzvs;
      AppMethodBeat.o(4954);
      return localPooledExecutorFactory;
    }
    finally {}
  }
  
  public static void setInstance(PooledExecutorFactory paramPooledExecutorFactory)
  {
    try
    {
      zzvs = paramPooledExecutorFactory;
      return;
    }
    finally
    {
      paramPooledExecutorFactory = finally;
      throw paramPooledExecutorFactory;
    }
  }
  
  public static abstract interface PooledExecutorFactory
  {
    public abstract ScheduledExecutorService newSingleThreadScheduledExecutor();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.common.providers.PooledExecutorsProvider
 * JD-Core Version:    0.7.0.1
 */