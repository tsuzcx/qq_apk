package com.google.android.exoplayer2.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f$h
  extends Exception
{
  public final int errorCode;
  
  public f$h(int paramInt)
  {
    super("AudioTrack write failed: ".concat(String.valueOf(paramInt)));
    AppMethodBeat.i(94673);
    this.errorCode = paramInt;
    AppMethodBeat.o(94673);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.a.f.h
 * JD-Core Version:    0.7.0.1
 */