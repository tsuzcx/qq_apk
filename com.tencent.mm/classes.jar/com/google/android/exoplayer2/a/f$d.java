package com.google.android.exoplayer2.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f$d
  extends Exception
{
  public final int bgq;
  
  public f$d(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super("AudioTrack init failed: " + paramInt1 + ", Config(" + paramInt2 + ", " + paramInt3 + ", " + paramInt4 + ")");
    AppMethodBeat.i(91783);
    this.bgq = paramInt1;
    AppMethodBeat.o(91783);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.a.f.d
 * JD-Core Version:    0.7.0.1
 */