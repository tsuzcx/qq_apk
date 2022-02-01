package com.bumptech.glide.c.b;

import android.support.v4.e.l.a;
import com.bumptech.glide.h.a.a;
import com.bumptech.glide.h.a.a.a;
import com.bumptech.glide.h.a.a.c;
import com.bumptech.glide.h.a.b;
import com.bumptech.glide.h.a.b.a;
import com.bumptech.glide.h.i;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class t<Z>
  implements u<Z>, a.c
{
  private static final l.a<t<?>> aFv;
  private final b aDI;
  private boolean aFm;
  private u<Z> aFw;
  private boolean aFx;
  
  static
  {
    AppMethodBeat.i(77045);
    aFv = a.a(20, new a.a() {});
    AppMethodBeat.o(77045);
  }
  
  t()
  {
    AppMethodBeat.i(77039);
    this.aDI = new b.a();
    AppMethodBeat.o(77039);
  }
  
  static <Z> t<Z> d(u<Z> paramu)
  {
    AppMethodBeat.i(77038);
    t localt = (t)i.checkNotNull((t)aFv.acquire(), "Argument must not be null");
    localt.aFm = false;
    localt.aFx = true;
    localt.aFw = paramu;
    AppMethodBeat.o(77038);
    return localt;
  }
  
  public final Z get()
  {
    AppMethodBeat.i(77042);
    Object localObject = this.aFw.get();
    AppMethodBeat.o(77042);
    return localObject;
  }
  
  public final int getSize()
  {
    AppMethodBeat.i(77043);
    int i = this.aFw.getSize();
    AppMethodBeat.o(77043);
    return i;
  }
  
  public final b oc()
  {
    return this.aDI;
  }
  
  public final Class<Z> oo()
  {
    AppMethodBeat.i(77041);
    Class localClass = this.aFw.oo();
    AppMethodBeat.o(77041);
    return localClass;
  }
  
  public final void recycle()
  {
    try
    {
      AppMethodBeat.i(77044);
      this.aDI.pU();
      this.aFm = true;
      if (!this.aFx)
      {
        this.aFw.recycle();
        this.aFw = null;
        aFv.release(this);
      }
      AppMethodBeat.o(77044);
      return;
    }
    finally {}
  }
  
  final void unlock()
  {
    try
    {
      AppMethodBeat.i(77040);
      this.aDI.pU();
      if (!this.aFx)
      {
        IllegalStateException localIllegalStateException = new IllegalStateException("Already unlocked");
        AppMethodBeat.o(77040);
        throw localIllegalStateException;
      }
    }
    finally {}
    this.aFx = false;
    if (this.aFm) {
      recycle();
    }
    AppMethodBeat.o(77040);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.c.b.t
 * JD-Core Version:    0.7.0.1
 */