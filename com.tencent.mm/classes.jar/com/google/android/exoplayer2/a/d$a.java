package com.google.android.exoplayer2.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d$a
  extends Exception
{
  public d$a(int paramInt1, int paramInt2, int paramInt3)
  {
    super("Unhandled format: " + paramInt1 + " Hz, " + paramInt2 + " channels in encoding " + paramInt3);
    AppMethodBeat.i(91762);
    AppMethodBeat.o(91762);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.a.d.a
 * JD-Core Version:    0.7.0.1
 */