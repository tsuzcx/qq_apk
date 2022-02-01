package com.google.android.exoplayer2.h.a;

import com.google.android.exoplayer2.h.f;
import com.google.android.exoplayer2.h.f.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  implements f.a
{
  private final a bpx;
  private final long bpy;
  private final int bufferSize;
  
  public c(a parama, long paramLong)
  {
    this(parama, paramLong, (byte)0);
  }
  
  private c(a parama, long paramLong, byte paramByte)
  {
    this.bpx = parama;
    this.bpy = paramLong;
    this.bufferSize = 20480;
  }
  
  public final f uG()
  {
    AppMethodBeat.i(92965);
    b localb = new b(this.bpx, this.bpy, this.bufferSize);
    AppMethodBeat.o(92965);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.h.a.c
 * JD-Core Version:    0.7.0.1
 */