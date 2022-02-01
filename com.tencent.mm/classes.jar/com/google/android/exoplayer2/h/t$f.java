package com.google.android.exoplayer2.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

public final class t$f
  extends IOException
{
  public t$f(Throwable paramThrowable)
  {
    super("Unexpected " + paramThrowable.getClass().getSimpleName() + ": " + paramThrowable.getMessage(), paramThrowable);
    AppMethodBeat.i(93095);
    AppMethodBeat.o(93095);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.h.t.f
 * JD-Core Version:    0.7.0.1
 */