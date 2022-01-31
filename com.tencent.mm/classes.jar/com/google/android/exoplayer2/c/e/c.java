package com.google.android.exoplayer2.c.e;

import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  implements com.google.android.exoplayer2.c.e
{
  public static final com.google.android.exoplayer2.c.h aBP;
  private com.google.android.exoplayer2.c.g aIN;
  private boolean aIO;
  private h aIz;
  
  static
  {
    AppMethodBeat.i(95038);
    aBP = new com.google.android.exoplayer2.c.h()
    {
      public final com.google.android.exoplayer2.c.e[] nY()
      {
        AppMethodBeat.i(95033);
        c localc = new c();
        AppMethodBeat.o(95033);
        return new com.google.android.exoplayer2.c.e[] { localc };
      }
    };
    AppMethodBeat.o(95038);
  }
  
  private boolean j(f paramf)
  {
    AppMethodBeat.i(95037);
    Object localObject = new e();
    if ((!((e)localObject).c(paramf, true)) || ((((e)localObject).type & 0x2) != 2))
    {
      AppMethodBeat.o(95037);
      return false;
    }
    int i = Math.min(((e)localObject).aIZ, 8);
    localObject = new com.google.android.exoplayer2.i.m(i);
    paramf.b(((com.google.android.exoplayer2.i.m)localObject).data, 0, i);
    ((com.google.android.exoplayer2.i.m)localObject).setPosition(0);
    if (b.r((com.google.android.exoplayer2.i.m)localObject)) {
      this.aIz = new b();
    }
    for (;;)
    {
      AppMethodBeat.o(95037);
      return true;
      ((com.google.android.exoplayer2.i.m)localObject).setPosition(0);
      if (j.r((com.google.android.exoplayer2.i.m)localObject))
      {
        this.aIz = new j();
      }
      else
      {
        ((com.google.android.exoplayer2.i.m)localObject).setPosition(0);
        if (!g.r((com.google.android.exoplayer2.i.m)localObject)) {
          break;
        }
        this.aIz = new g();
      }
    }
    AppMethodBeat.o(95037);
    return false;
  }
  
  public final int a(f paramf, k paramk)
  {
    AppMethodBeat.i(95036);
    if (this.aIz == null)
    {
      if (!j(paramf))
      {
        paramf = new o("Failed to determine bitstream type");
        AppMethodBeat.o(95036);
        throw paramf;
      }
      paramf.nW();
    }
    if (!this.aIO)
    {
      localObject = this.aIN.dm(0);
      this.aIN.nZ();
      this.aIz.a(this.aIN, (com.google.android.exoplayer2.c.m)localObject);
      this.aIO = true;
    }
    Object localObject = this.aIz;
    switch (((h)localObject).state)
    {
    default: 
      paramf = new IllegalStateException();
      AppMethodBeat.o(95036);
      throw paramf;
    case 0: 
      i = ((h)localObject).l(paramf);
      AppMethodBeat.o(95036);
      return i;
    case 1: 
      paramf.dg((int)((h)localObject).aJg);
      ((h)localObject).state = 2;
      AppMethodBeat.o(95036);
      return 0;
    }
    int i = ((h)localObject).b(paramf, paramk);
    AppMethodBeat.o(95036);
    return i;
  }
  
  public final void a(com.google.android.exoplayer2.c.g paramg)
  {
    this.aIN = paramg;
  }
  
  public final boolean a(f paramf)
  {
    AppMethodBeat.i(95034);
    try
    {
      boolean bool = j(paramf);
      AppMethodBeat.o(95034);
      return bool;
    }
    catch (o paramf)
    {
      AppMethodBeat.o(95034);
    }
    return false;
  }
  
  public final void g(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(95035);
    if (this.aIz != null) {
      this.aIz.g(paramLong1, paramLong2);
    }
    AppMethodBeat.o(95035);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.exoplayer2.c.e.c
 * JD-Core Version:    0.7.0.1
 */