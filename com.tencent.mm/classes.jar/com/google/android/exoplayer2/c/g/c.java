package com.google.android.exoplayer2.c.g;

import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c
{
  public static b m(f paramf)
  {
    AppMethodBeat.i(92313);
    a.checkNotNull(paramf);
    m localm = new m(16);
    if (a.a(paramf, localm).id != x.bJ("RIFF"))
    {
      AppMethodBeat.o(92313);
      return null;
    }
    paramf.b(localm.data, 0, 4);
    localm.setPosition(0);
    if (localm.readInt() != x.bJ("WAVE"))
    {
      AppMethodBeat.o(92313);
      return null;
    }
    a locala;
    for (;;)
    {
      locala = a.a(paramf, localm);
      if (locala.id == x.bJ("fmt ")) {
        break;
      }
      paramf.dV((int)locala.size);
    }
    if (locala.size >= 16L) {}
    int i;
    int j;
    int k;
    int m;
    int n;
    int i1;
    for (boolean bool = true;; bool = false)
    {
      a.checkState(bool);
      paramf.b(localm.data, 0, 16);
      localm.setPosition(0);
      i = localm.wW();
      j = localm.wW();
      k = localm.xd();
      m = localm.xd();
      n = localm.wW();
      i1 = localm.wW();
      i2 = j * i1 / 8;
      if (n == i2) {
        break;
      }
      paramf = new o("Expected block alignment: " + i2 + "; got: " + n);
      AppMethodBeat.o(92313);
      throw paramf;
    }
    int i2 = x.ff(i1);
    if (i2 == 0)
    {
      AppMethodBeat.o(92313);
      return null;
    }
    if ((i != 1) && (i != 65534))
    {
      AppMethodBeat.o(92313);
      return null;
    }
    paramf.dV((int)locala.size - 16);
    paramf = new b(j, k, m, n, i1, i2);
    AppMethodBeat.o(92313);
    return paramf;
  }
  
  static final class a
  {
    public final int id;
    public final long size;
    
    private a(int paramInt, long paramLong)
    {
      this.id = paramInt;
      this.size = paramLong;
    }
    
    public static a a(f paramf, m paramm)
    {
      AppMethodBeat.i(92312);
      paramf.b(paramm.data, 0, 8);
      paramm.setPosition(0);
      paramf = new a(paramm.readInt(), paramm.wY());
      AppMethodBeat.o(92312);
      return paramf;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.g.c
 * JD-Core Version:    0.7.0.1
 */