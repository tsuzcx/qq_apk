package com.google.android.exoplayer2.c.d;

import com.google.android.exoplayer2.i.m;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$e
  implements b.b
{
  private int aGA;
  private final m aGh;
  private final int aGy;
  private int aGz;
  private final int sampleCount;
  
  public b$e(a.b paramb)
  {
    AppMethodBeat.i(94946);
    this.aGh = paramb.aGh;
    this.aGh.setPosition(12);
    this.aGy = (this.aGh.qT() & 0xFF);
    this.sampleCount = this.aGh.qT();
    AppMethodBeat.o(94946);
  }
  
  public final int getSampleCount()
  {
    return this.sampleCount;
  }
  
  public final int oe()
  {
    AppMethodBeat.i(94947);
    if (this.aGy == 8)
    {
      i = this.aGh.readUnsignedByte();
      AppMethodBeat.o(94947);
      return i;
    }
    if (this.aGy == 16)
    {
      i = this.aGh.readUnsignedShort();
      AppMethodBeat.o(94947);
      return i;
    }
    int i = this.aGz;
    this.aGz = (i + 1);
    if (i % 2 == 0)
    {
      this.aGA = this.aGh.readUnsignedByte();
      i = this.aGA;
      AppMethodBeat.o(94947);
      return (i & 0xF0) >> 4;
    }
    i = this.aGA;
    AppMethodBeat.o(94947);
    return i & 0xF;
  }
  
  public final boolean of()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.c.d.b.e
 * JD-Core Version:    0.7.0.1
 */