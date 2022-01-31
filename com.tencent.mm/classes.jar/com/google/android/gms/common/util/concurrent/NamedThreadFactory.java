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
    AppMethodBeat.i(90301);
    this.zzaau = Executors.defaultThreadFactory();
    this.name = ((String)Preconditions.checkNotNull(paramString, "Name must not be null"));
    this.priority = paramInt;
    AppMethodBeat.o(90301);
  }
  
  public Thread newThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(90302);
    paramRunnable = this.zzaau.newThread(new zza(paramRunnable, this.priority));
    paramRunnable.setName(this.name);
    AppMethodBeat.o(90302);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.util.concurrent.NamedThreadFactory
 * JD-Core Version:    0.7.0.1
 */