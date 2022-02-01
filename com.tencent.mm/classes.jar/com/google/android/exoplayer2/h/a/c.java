package com.google.android.exoplayer2.h.a;

import com.google.android.exoplayer2.h.f;
import com.google.android.exoplayer2.h.f.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  implements f.a
{
  private final int bufferSize;
  private final a bvo;
  private final long bvp;
  
  public c(a parama)
  {
    this(parama, (byte)0);
  }
  
  private c(a parama, byte paramByte)
  {
    this.bvo = parama;
    this.bvp = 10485760L;
    this.bufferSize = 20480;
  }
  
  public final f vb()
  {
    AppMethodBeat.i(92965);
    b localb = new b(this.bvo, this.bvp, this.bufferSize);
    AppMethodBeat.o(92965);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.h.a.c
 * JD-Core Version:    0.7.0.1
 */