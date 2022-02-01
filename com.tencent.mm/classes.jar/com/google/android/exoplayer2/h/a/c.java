package com.google.android.exoplayer2.h.a;

import com.google.android.exoplayer2.h.f;
import com.google.android.exoplayer2.h.f.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  implements f.a
{
  private final int bufferSize;
  private final a dja;
  private final long djb;
  
  public c(a parama, long paramLong)
  {
    this(parama, paramLong, (byte)0);
  }
  
  private c(a parama, long paramLong, byte paramByte)
  {
    this.dja = parama;
    this.djb = paramLong;
    this.bufferSize = 20480;
  }
  
  public final f Uj()
  {
    AppMethodBeat.i(92965);
    b localb = new b(this.dja, this.djb, this.bufferSize);
    AppMethodBeat.o(92965);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.h.a.c
 * JD-Core Version:    0.7.0.1
 */