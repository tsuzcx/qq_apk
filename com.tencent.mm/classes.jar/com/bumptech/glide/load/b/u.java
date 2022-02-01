package com.bumptech.glide.load.b;

import android.support.v4.e.l.a;
import com.bumptech.glide.g.a.a;
import com.bumptech.glide.g.a.a.a;
import com.bumptech.glide.g.a.a.c;
import com.bumptech.glide.g.a.b;
import com.bumptech.glide.g.a.b.a;
import com.bumptech.glide.g.j;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class u<Z>
  implements a.c, v<Z>
{
  private static final l.a<u<?>> aHW;
  private final b aGi;
  private boolean aHN;
  private v<Z> aHX;
  private boolean aHY;
  
  static
  {
    AppMethodBeat.i(77045);
    aHW = a.a(20, new a.a() {});
    AppMethodBeat.o(77045);
  }
  
  u()
  {
    AppMethodBeat.i(77039);
    this.aGi = new b.a();
    AppMethodBeat.o(77039);
  }
  
  static <Z> u<Z> d(v<Z> paramv)
  {
    AppMethodBeat.i(77038);
    u localu = (u)j.checkNotNull((u)aHW.acquire(), "Argument must not be null");
    localu.aHN = false;
    localu.aHY = true;
    localu.aHX = paramv;
    AppMethodBeat.o(77038);
    return localu;
  }
  
  public final Z get()
  {
    AppMethodBeat.i(77042);
    Object localObject = this.aHX.get();
    AppMethodBeat.o(77042);
    return localObject;
  }
  
  public final int getSize()
  {
    AppMethodBeat.i(77043);
    int i = this.aHX.getSize();
    AppMethodBeat.o(77043);
    return i;
  }
  
  public final b oK()
  {
    return this.aGi;
  }
  
  public final Class<Z> oV()
  {
    AppMethodBeat.i(77041);
    Class localClass = this.aHX.oV();
    AppMethodBeat.o(77041);
    return localClass;
  }
  
  public final void recycle()
  {
    try
    {
      AppMethodBeat.i(77044);
      this.aGi.qz();
      this.aHN = true;
      if (!this.aHY)
      {
        this.aHX.recycle();
        this.aHX = null;
        aHW.release(this);
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
      this.aGi.qz();
      if (!this.aHY)
      {
        IllegalStateException localIllegalStateException = new IllegalStateException("Already unlocked");
        AppMethodBeat.o(77040);
        throw localIllegalStateException;
      }
    }
    finally {}
    this.aHY = false;
    if (this.aHN) {
      recycle();
    }
    AppMethodBeat.o(77040);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.b.u
 * JD-Core Version:    0.7.0.1
 */