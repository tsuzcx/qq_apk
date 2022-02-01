package com.bumptech.glide.e;

import android.support.v4.e.a;
import com.bumptech.glide.h.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public final class d
{
  private final AtomicReference<h> aMZ;
  public final a<h, List<Class<?>>> aNa;
  
  public d()
  {
    AppMethodBeat.i(77607);
    this.aMZ = new AtomicReference();
    this.aNa = new a();
    AppMethodBeat.o(77607);
  }
  
  public final List<Class<?>> f(Class<?> paramClass1, Class<?> arg2)
  {
    AppMethodBeat.i(77608);
    Object localObject = (h)this.aMZ.getAndSet(null);
    if (localObject == null) {
      paramClass1 = new h(paramClass1, ???);
    }
    synchronized (this.aNa)
    {
      localObject = (List)this.aNa.get(paramClass1);
      this.aMZ.set(paramClass1);
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