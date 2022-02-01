package com.bumptech.glide.e;

import android.support.v4.e.a;
import com.bumptech.glide.c.b.s;
import com.bumptech.glide.c.d.f.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

public final class c
{
  public static final s<?, ?, ?> aLf;
  public final a<com.bumptech.glide.h.h, s<?, ?, ?>> aLg;
  private final AtomicReference<com.bumptech.glide.h.h> aLh;
  
  static
  {
    AppMethodBeat.i(77606);
    aLf = new s(Object.class, Object.class, Object.class, Collections.singletonList(new com.bumptech.glide.c.b.h(Object.class, Object.class, Object.class, Collections.emptyList(), new g(), null)), null);
    AppMethodBeat.o(77606);
  }
  
  public c()
  {
    AppMethodBeat.i(77603);
    this.aLg = new a();
    this.aLh = new AtomicReference();
    AppMethodBeat.o(77603);
  }
  
  public static boolean a(s<?, ?, ?> params)
  {
    AppMethodBeat.i(77604);
    boolean bool = aLf.equals(params);
    AppMethodBeat.o(77604);
    return bool;
  }
  
  public final <Data, TResource, Transcode> s<Data, TResource, Transcode> c(Class<Data> arg1, Class<TResource> paramClass1, Class<Transcode> paramClass2)
  {
    AppMethodBeat.i(77605);
    com.bumptech.glide.h.h localh = (com.bumptech.glide.h.h)this.aLh.getAndSet(null);
    if (localh == null) {
      localh = new com.bumptech.glide.h.h();
    }
    for (;;)
    {
      localh.d(???, paramClass1, paramClass2);
      synchronized (this.aLg)
      {
        paramClass1 = (s)this.aLg.get(localh);
        this.aLh.set(localh);
        AppMethodBeat.o(77605);
        return paramClass1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.e.c
 * JD-Core Version:    0.7.0.1
 */