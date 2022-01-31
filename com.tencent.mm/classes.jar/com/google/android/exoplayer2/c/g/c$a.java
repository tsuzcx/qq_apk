package com.google.android.exoplayer2.c.g;

import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.i.m;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$a
{
  public final int id;
  public final long size;
  
  private c$a(int paramInt, long paramLong)
  {
    this.id = paramInt;
    this.size = paramLong;
  }
  
  public static a a(f paramf, m paramm)
  {
    AppMethodBeat.i(95190);
    paramf.b(paramm.data, 0, 8);
    paramm.setPosition(0);
    paramf = new a(paramm.readInt(), paramm.qP());
    AppMethodBeat.o(95190);
    return paramf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.g.c.a
 * JD-Core Version:    0.7.0.1
 */