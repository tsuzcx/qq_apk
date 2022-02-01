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
  private static final l.a<t<?>> aGl;
  private final b aEz;
  private boolean aGc;
  private u<Z> aGm;
  private boolean aGn;
  
  static
  {
    AppMethodBeat.i(77045);
    aGl = a.a(20, new a.a() {});
    AppMethodBeat.o(77045);
  }
  
  t()
  {
    AppMethodBeat.i(77039);
    this.aEz = new b.a();
    AppMethodBeat.o(77039);
  }
  
  static <Z> t<Z> d(u<Z> paramu)
  {
    AppMethodBeat.i(77038);
    t localt = (t)i.checkNotNull((t)aGl.acquire(), "Argument must not be null");
    localt.aGc = false;
    localt.aGn = true;
    localt.aGm = paramu;
    AppMethodBeat.o(77038);
    return localt;
  }
  
  public final Z get()
  {
    AppMethodBeat.i(77042);
    Object localObject = this.aGm.get();
    AppMethodBeat.o(77042);
    return localObject;
  }
  
  public final int getSize()
  {
    AppMethodBeat.i(77043);
    int i = this.aGm.getSize();
    AppMethodBeat.o(77043);
    return i;
  }
  
  public final b om()
  {
    return this.aEz;
  }
  
  public final Class<Z> oy()
  {
    AppMethodBeat.i(77041);
    Class localClass = this.aGm.oy();
    AppMethodBeat.o(77041);
    return localClass;
  }
  
  public final void recycle()
  {
    try
    {
      AppMethodBeat.i(77044);
      this.aEz.qe();
      this.aGc = true;
      if (!this.aGn)
      {
        this.aGm.recycle();
        this.aGm = null;
        aGl.release(this);
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
      this.aEz.qe();
      if (!this.aGn)
      {
        IllegalStateException localIllegalStateException = new IllegalStateException("Already unlocked");
        AppMethodBeat.o(77040);
        throw localIllegalStateException;
      }
    }
    finally {}
    this.aGn = false;
    if (this.aGc) {
      recycle();
    }
    AppMethodBeat.o(77040);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.b.t
 * JD-Core Version:    0.7.0.1
 */