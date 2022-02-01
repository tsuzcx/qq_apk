package com.bumptech.glide.e;

import android.support.v4.e.a;
import com.bumptech.glide.h.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public final class d
{
  private final AtomicReference<h> aLi;
  public final a<h, List<Class<?>>> aLj;
  
  public d()
  {
    AppMethodBeat.i(77607);
    this.aLi = new AtomicReference();
    this.aLj = new a();
    AppMethodBeat.o(77607);
  }
  
  public final List<Class<?>> f(Class<?> paramClass1, Class<?> arg2)
  {
    AppMethodBeat.i(77608);
    Object localObject = (h)this.aLi.getAndSet(null);
    if (localObject == null) {
      paramClass1 = new h(paramClass1, ???);
    }
    synchronized (this.aLj)
    {
      localObject = (List)this.aLj.get(paramClass1);
      this.aLi.set(paramClass1);
      AppMethodBeat.o(77608);
      return localObject;
      ((h)localObject).d(paramClass1, ???, null);
      paramClass1 = (Class<?>)localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.e.d
 * JD-Core Version:    0.7.0.1
 */