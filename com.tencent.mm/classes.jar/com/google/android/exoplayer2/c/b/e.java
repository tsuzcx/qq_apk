package com.google.android.exoplayer2.c.b;

import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.i.m;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e
{
  final m aBR;
  int aDW;
  
  public e()
  {
    AppMethodBeat.i(94915);
    this.aBR = new m(8);
    AppMethodBeat.o(94915);
  }
  
  final long d(f paramf)
  {
    int k = 0;
    AppMethodBeat.i(94916);
    paramf.b(this.aBR.data, 0, 1);
    int m = this.aBR.data[0] & 0xFF;
    if (m == 0)
    {
      AppMethodBeat.o(94916);
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
    paramf.b(this.aBR.data, 1, i);
    j = k;
    k = m;
    while (j < i)
    {
      k = (k << 8) + (this.aBR.data[(j + 1)] & 0xFF);
      j += 1;
    }
    this.aDW += i + 1;
    long l = k;
    AppMethodBeat.o(94916);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.c.b.e
 * JD-Core Version:    0.7.0.1
 */