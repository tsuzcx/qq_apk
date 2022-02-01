package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public final class jw$f<T>
  implements jw.d<T>
{
  T a;
  
  public jw$f(T paramT)
  {
    this.a = paramT;
  }
  
  public final Future<T> a(jw.g<T> paramg)
  {
    AppMethodBeat.i(223179);
    paramg = hb.b().submit(paramg, this.a);
    AppMethodBeat.o(223179);
    return paramg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.internal.jw.f
 * JD-Core Version:    0.7.0.1
 */