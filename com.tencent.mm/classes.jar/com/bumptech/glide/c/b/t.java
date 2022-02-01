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
  private static final l.a<t<?>> aIc;
  private final b aGq;
  private boolean aHT;
  private u<Z> aId;
  private boolean aIe;
  
  static
  {
    AppMethodBeat.i(77045);
    aIc = a.a(20, new a.a() {});
    AppMethodBeat.o(77045);
  }
  
  t()
  {
    AppMethodBeat.i(77039);
    this.aGq = new b.a();
    AppMethodBeat.o(77039);
  }
  
  static <Z> t<Z> d(u<Z> paramu)
  {
    AppMethodBeat.i(77038);
    t localt = (t)i.checkNotNull((t)aIc.acquire(), "Argument must not be null");
    localt.aHT = false;
    localt.aIe = true;
    localt.aId = paramu;
    AppMethodBeat.o(77038);
    return localt;
  }
  
  public final Z get()
  {
    AppMethodBeat.i(77042);
    Object localObject = this.aId.get();
    AppMethodBeat.o(77042);
    return localObject;
  }
  
  public final int getSize()
  {
    AppMethodBeat.i(77043);
    int i = this.aId.getSize();
    AppMethodBeat.o(77043);
    return i;
  }
  
  public final b oE()
  {
    return this.aGq;
  }
  
  public final Class<Z> oQ()
  {
    AppMethodBeat.i(77041);
    Class localClass = this.aId.oQ();
    AppMethodBeat.o(77041);
    return localClass;
  }
  
  public final void recycle()
  {
    try
    {
      AppMethodBeat.i(77044);
      this.aGq.qw();
      this.aHT = true;
      if (!this.aIe)
      {
        this.aId.recycle();
        this.aId = null;
        aIc.release(this);
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
      this.aGq.qw();
      if (!this.aIe)
      {
        IllegalStateException localIllegalStateException = new IllegalStateException("Already unlocked");
        AppMethodBeat.o(77040);
        throw localIllegalStateException;
      }
    }
    finally {}
    this.aIe = false;
    if (this.aHT) {
      recycle();
    }
    AppMethodBeat.o(77040);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.b.t
 * JD-Core Version:    0.7.0.1
 */