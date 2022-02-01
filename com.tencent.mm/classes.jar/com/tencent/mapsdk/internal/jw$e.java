package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public final class jw$e<T>
  implements jw.d<T>
{
  T a;
  
  public jw$e(T paramT)
  {
    this.a = paramT;
  }
  
  public final Future<T> a(jw.g<T> paramg)
  {
    AppMethodBeat.i(223352);
    paramg = hb.a().submit(paramg, this.a);
    AppMethodBeat.o(223352);
    return paramg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.internal.jw.e
 * JD-Core Version:    0.7.0.1
 */