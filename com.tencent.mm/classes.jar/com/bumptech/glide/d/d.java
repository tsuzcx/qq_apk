package com.bumptech.glide.d;

import android.support.v4.e.a;
import com.bumptech.glide.g.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public final class d
{
  private final AtomicReference<i> aMQ;
  public final a<i, List<Class<?>>> aMR;
  
  public d()
  {
    AppMethodBeat.i(77607);
    this.aMQ = new AtomicReference();
    this.aMR = new a();
    AppMethodBeat.o(77607);
  }
  
  public final List<Class<?>> d(Class<?> paramClass1, Class<?> arg2, Class<?> paramClass3)
  {
    AppMethodBeat.i(204487);
    i locali = (i)this.aMQ.getAndSet(null);
    if (locali == null) {
      paramClass1 = new i(paramClass1, ???, paramClass3);
    }
    synchronized (this.aMR)
    {
      paramClass3 = (List)this.aMR.get(paramClass1);
      this.aMQ.set(paramClass1);
      AppMethodBeat.o(204487);
      return paramClass3;
      locali.e(paramClass1, ???, paramClass3);
      paramClass1 = locali;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.d.d
 * JD-Core Version:    0.7.0.1
 */