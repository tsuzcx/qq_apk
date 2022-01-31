package com.google.android.exoplayer2.c.d;

import com.google.android.exoplayer2.i.m;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$d
  implements b.b
{
  private final m aGh;
  private final int aGx;
  private final int sampleCount;
  
  public b$d(a.b paramb)
  {
    AppMethodBeat.i(94944);
    this.aGh = paramb.aGh;
    this.aGh.setPosition(12);
    this.aGx = this.aGh.qT();
    this.sampleCount = this.aGh.qT();
    AppMethodBeat.o(94944);
  }
  
  public final int getSampleCount()
  {
    return this.sampleCount;
  }
  
  public final int oe()
  {
    AppMethodBeat.i(94945);
    if (this.aGx == 0)
    {
      i = this.aGh.qT();
      AppMethodBeat.o(94945);
      return i;
    }
    int i = this.aGx;
    AppMethodBeat.o(94945);
    return i;
  }
  
  public final boolean of()
  {
    return this.aGx != 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.exoplayer2.c.d.b.d
 * JD-Core Version:    0.7.0.1
 */