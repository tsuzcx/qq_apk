package com.tencent.mm.plugin.expansions;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

final class e$c<T>
  implements Future<T>
{
  private final T result;
  
  public e$c(T paramT)
  {
    this.result = paramT;
  }
  
  public final boolean cancel(boolean paramBoolean)
  {
    return false;
  }
  
  public final T get()
  {
    return this.result;
  }
  
  public final T get(long paramLong, TimeUnit paramTimeUnit)
  {
    AppMethodBeat.i(273662);
    paramTimeUnit = get();
    AppMethodBeat.o(273662);
    return paramTimeUnit;
  }
  
  public final boolean isCancelled()
  {
    return false;
  }
  
  public final boolean isDone()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.expansions.e.c
 * JD-Core Version:    0.7.0.1
 */