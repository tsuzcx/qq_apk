package com.google.android.exoplayer2.c.b;

import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.i.m;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e
{
  final m biq;
  int bkv;
  
  public e()
  {
    AppMethodBeat.i(92030);
    this.biq = new m(8);
    AppMethodBeat.o(92030);
  }
  
  final long d(f paramf)
  {
    int k = 0;
    AppMethodBeat.i(92031);
    paramf.b(this.biq.data, 0, 1);
    int m = this.biq.data[0] & 0xFF;
    if (m == 0)
    {
      AppMethodBeat.o(92031);
      return -9223372036854775808L;
    }
    int i = 0;
    int j = 128;
    while ((m & j) == 0)
    {
      j >>= 1;
      i += 1;
    }
    m = (j ^ 0xFFFFFFFF) & m;
    paramf.b(this.biq.data, 1, i);
    j = k;
    k = m;
    while (j < i)
    {
      k = (k << 8) + (this.biq.data[(j + 1)] & 0xFF);
      j += 1;
    }
    this.bkv += i + 1;
    long l = k;
    AppMethodBeat.o(92031);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.b.e
 * JD-Core Version:    0.7.0.1
 */