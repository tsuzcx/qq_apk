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
    AppMethodBeat.i(95191);
    a.checkNotNull(paramf);
    m localm = new m(16);
    if (c.a.a(paramf, localm).id != x.aS("RIFF"))
    {
      AppMethodBeat.o(95191);
      return null;
    }
    paramf.b(localm.data, 0, 4);
    localm.setPosition(0);
    if (localm.readInt() != x.aS("WAVE"))
    {
      AppMethodBeat.o(95191);
      return null;
    }
    c.a locala;
    for (;;)
    {
      locala = c.a.a(paramf, localm);
      if (locala.id == x.aS("fmt ")) {
        break;
      }
      paramf.dh((int)locala.size);
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
      i = localm.qN();
      j = localm.qN();
      k = localm.qU();
      m = localm.qU();
      n = localm.qN();
      i1 = localm.qN();
      i2 = j * i1 / 8;
      if (n == i2) {
        break;
      }
      paramf = new o("Expected block alignment: " + i2 + "; got: " + n);
      AppMethodBeat.o(95191);
      throw paramf;
    }
    int i2 = x.es(i1);
    if (i2 == 0)
    {
      AppMethodBeat.o(95191);
      return null;
    }
    if ((i != 1) && (i != 65534))
    {
      AppMethodBeat.o(95191);
      return null;
    }
    paramf.dh((int)locala.size - 16);
    paramf = new b(j, k, m, n, i1, i2);
    AppMethodBeat.o(95191);
    return paramf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.c.g.c
 * JD-Core Version:    0.7.0.1
 */