package com.google.android.exoplayer2.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class c
  extends i
{
  private final b bAg;
  
  public c(b paramb)
  {
    this.bAg = paramb;
  }
  
  public final void release()
  {
    AppMethodBeat.i(92803);
    this.bAg.a(this);
    AppMethodBeat.o(92803);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.f.c
 * JD-Core Version:    0.7.0.1
 */