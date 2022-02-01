package com.tencent.mm.compatible.util;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f$a
{
  public long gfF;
  
  public f$a()
  {
    AppMethodBeat.i(155878);
    this.gfF = SystemClock.elapsedRealtime();
    AppMethodBeat.o(155878);
  }
  
  public final long abs()
  {
    AppMethodBeat.i(155880);
    long l1 = SystemClock.elapsedRealtime();
    long l2 = this.gfF;
    AppMethodBeat.o(155880);
    return l1 - l2;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(224219);
    this.gfF = SystemClock.elapsedRealtime();
    AppMethodBeat.o(224219);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.util.f.a
 * JD-Core Version:    0.7.0.1
 */