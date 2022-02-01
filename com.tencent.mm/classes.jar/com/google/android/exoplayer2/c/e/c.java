package com.google.android.exoplayer2.c.e;

import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  implements com.google.android.exoplayer2.c.e
{
  public static final com.google.android.exoplayer2.c.h bio;
  private h boY;
  private com.google.android.exoplayer2.c.g bpm;
  private boolean bpn;
  
  static
  {
    AppMethodBeat.i(92154);
    bio = new com.google.android.exoplayer2.c.h()
    {
      public final com.google.android.exoplayer2.c.e[] us()
      {
        AppMethodBeat.i(92149);
        c localc = new c();
        AppMethodBeat.o(92149);
        return new com.google.android.exoplayer2.c.e[] { localc };
      }
    };
    AppMethodBeat.o(92154);
  }
  
  private boolean j(f paramf)
  {
    AppMethodBeat.i(92153);
    Object localObject = new e();
    if ((!((e)localObject).c(paramf, true)) || ((((e)localObject).type & 0x2) != 2))
    {
      AppMethodBeat.o(92153);
      return false;
    }
    int i = Math.min(((e)localObject).bpz, 8);
    localObject = new com.google.android.exoplayer2.i.m(i);
    paramf.b(((com.google.android.exoplayer2.i.m)localObject).data, 0, i);
    ((com.google.android.exoplayer2.i.m)localObject).setPosition(0);
    if (b.r((com.google.android.exoplayer2.i.m)localObject)) {
      this.boY = new b();
    }
    for (;;)
    {
      AppMethodBeat.o(92153);
      return true;
      ((com.google.android.exoplayer2.i.m)localObject).setPosition(0);
      if (j.r((com.google.android.exoplayer2.i.m)localObject))
      {
        this.boY = new j();
      }
      else
      {
        ((com.google.android.exoplayer2.i.m)localObject).setPosition(0);
        if (!g.r((com.google.android.exoplayer2.i.m)localObject)) {
          break;
        }
        this.boY = new g();
      }
    }
    AppMethodBeat.o(92153);
    return false;
  }
  
  public final int a(f paramf, k paramk)
  {
    AppMethodBeat.i(92152);
    if (this.boY == null)
    {
      if (!j(paramf))
      {
        paramf = new o("Failed to determine bitstream type");
        AppMethodBeat.o(92152);
        throw paramf;
      }
      paramf.uq();
    }
    if (!this.bpn)
    {
      localObject = this.bpm.eb(0);
      this.bpm.ut();
      this.boY.a(this.bpm, (com.google.android.exoplayer2.c.m)localObject);
      this.bpn = true;
    }
    Object localObject = this.boY;
    switch (((h)localObject).state)
    {
    default: 
      paramf = new IllegalStateException();
      AppMethodBeat.o(92152);
      throw paramf;
    case 0: 
      i = ((h)localObject).l(paramf);
      AppMethodBeat.o(92152);
      return i;
    case 1: 
      paramf.dU((int)((h)localObject).bpG);
      ((h)localObject).state = 2;
      AppMethodBeat.o(92152);
      return 0;
    }
    int i = ((h)localObject).b(paramf, paramk);
    AppMethodBeat.o(92152);
    return i;
  }
  
  public final void a(com.google.android.exoplayer2.c.g paramg)
  {
    this.bpm = paramg;
  }
  
  public final boolean a(f paramf)
  {
    AppMethodBeat.i(92150);
    try
    {
      boolean bool = j(paramf);
      AppMethodBeat.o(92150);
      return bool;
    }
    catch (o paramf)
    {
      AppMethodBeat.o(92150);
    }
    return false;
  }
  
  public final void f(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(92151);
    if (this.boY != null) {
      this.boY.f(paramLong1, paramLong2);
    }
    AppMethodBeat.o(92151);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.c.e.c
 * JD-Core Version:    0.7.0.1
 */