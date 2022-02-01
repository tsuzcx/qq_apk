package com.bumptech.glide.d;

import android.support.v4.e.a;
import com.bumptech.glide.load.b.t;
import com.bumptech.glide.load.d.f.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

public final class c
{
  public static final t<?, ?, ?> aMN;
  public final a<com.bumptech.glide.g.i, t<?, ?, ?>> aMO;
  private final AtomicReference<com.bumptech.glide.g.i> aMP;
  
  static
  {
    AppMethodBeat.i(77606);
    aMN = new t(Object.class, Object.class, Object.class, Collections.singletonList(new com.bumptech.glide.load.b.i(Object.class, Object.class, Object.class, Collections.emptyList(), new g(), null)), null);
    AppMethodBeat.o(77606);
  }
  
  public c()
  {
    AppMethodBeat.i(77603);
    this.aMO = new a();
    this.aMP = new AtomicReference();
    AppMethodBeat.o(77603);
  }
  
  public static boolean a(t<?, ?, ?> paramt)
  {
    AppMethodBeat.i(77604);
    boolean bool = aMN.equals(paramt);
    AppMethodBeat.o(77604);
    return bool;
  }
  
  public final <Data, TResource, Transcode> t<Data, TResource, Transcode> c(Class<Data> arg1, Class<TResource> paramClass1, Class<Transcode> paramClass2)
  {
    AppMethodBeat.i(77605);
    com.bumptech.glide.g.i locali = (com.bumptech.glide.g.i)this.aMP.getAndSet(null);
    if (locali == null) {
      locali = new com.bumptech.glide.g.i();
    }
    for (;;)
    {
      locali.e(???, paramClass1, paramClass2);
      synchronized (this.aMO)
      {
        paramClass1 = (t)this.aMO.get(locali);
        this.aMP.set(locali);
        AppMethodBeat.o(77605);
        return paramClass1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.d.c
 * JD-Core Version:    0.7.0.1
 */