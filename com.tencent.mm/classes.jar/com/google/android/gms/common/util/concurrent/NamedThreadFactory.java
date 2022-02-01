package com.google.android.gms.common.util.concurrent;

import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class NamedThreadFactory
  implements ThreadFactory
{
  private final String name;
  private final int priority;
  private final ThreadFactory zzaau;
  
  public NamedThreadFactory(String paramString)
  {
    this(paramString, 0);
  }
  
  public NamedThreadFactory(String paramString, int paramInt)
  {
    AppMethodBeat.i(5322);
    this.zzaau = Executors.defaultThreadFactory();
    this.name = ((String)Preconditions.checkNotNull(paramString, "Name must not be null"));
    this.priority = paramInt;
    AppMethodBeat.o(5322);
  }
  
  public Thread newThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(5323);
    paramRunnable = this.zzaau.newThread(new zza(paramRunnable, this.priority));
    paramRunnable.setName(this.name);
    AppMethodBeat.o(5323);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.common.util.concurrent.NamedThreadFactory
 * JD-Core Version:    0.7.0.1
 */