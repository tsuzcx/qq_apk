package com.tencent.f.a;

import com.tencent.f.i.j;
import com.tencent.f.i.k;
import com.tencent.f.j.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public final class a
{
  private static long OD(long paramLong)
  {
    AppMethodBeat.i(183192);
    long l = System.nanoTime();
    if (paramLong < 4611686018427387903L) {}
    for (;;)
    {
      AppMethodBeat.o(183192);
      return l + paramLong;
      paramLong = 4611686018427387903L;
    }
  }
  
  public static long a(long paramLong, TimeUnit paramTimeUnit)
  {
    AppMethodBeat.i(183191);
    if (paramTimeUnit == null)
    {
      paramLong = System.nanoTime();
      AppMethodBeat.o(183191);
      return paramLong;
    }
    long l = paramLong;
    if (paramLong < 0L) {
      l = 0L;
    }
    paramLong = OD(paramTimeUnit.toNanos(l));
    AppMethodBeat.o(183191);
    return paramLong;
  }
  
  public static <E> k<E> a(Callable<E> paramCallable, long paramLong, String paramString)
  {
    AppMethodBeat.i(183190);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      paramCallable = new k(paramCallable, a(paramLong, TimeUnit.MILLISECONDS), eC(paramCallable));
      AppMethodBeat.o(183190);
      return paramCallable;
    }
    paramCallable = new e(paramCallable, a(paramLong, TimeUnit.MILLISECONDS), paramString, eC(paramCallable));
    AppMethodBeat.o(183190);
    return paramCallable;
  }
  
  public static k<?> d(Runnable paramRunnable, long paramLong, String paramString)
  {
    AppMethodBeat.i(183189);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      paramRunnable = new k(paramRunnable, a(paramLong, TimeUnit.MILLISECONDS), eC(paramRunnable));
      AppMethodBeat.o(183189);
      return paramRunnable;
    }
    paramRunnable = new e(paramRunnable, a(paramLong, TimeUnit.MILLISECONDS), paramString, eC(paramRunnable));
    AppMethodBeat.o(183189);
    return paramRunnable;
  }
  
  public static boolean eC(Object paramObject)
  {
    AppMethodBeat.i(183193);
    if ((paramObject instanceof j))
    {
      boolean bool = ((j)paramObject).axI();
      AppMethodBeat.o(183193);
      return bool;
    }
    AppMethodBeat.o(183193);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.f.a.a
 * JD-Core Version:    0.7.0.1
 */