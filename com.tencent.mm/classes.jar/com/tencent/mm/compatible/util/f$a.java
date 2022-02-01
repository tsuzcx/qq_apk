package com.tencent.mm.compatible.util;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f$a
{
  public long gLm;
  
  public f$a()
  {
    AppMethodBeat.i(155878);
    this.gLm = SystemClock.elapsedRealtime();
    AppMethodBeat.o(155878);
  }
  
  public final long apr()
  {
    AppMethodBeat.i(155880);
    long l1 = SystemClock.elapsedRealtime();
    long l2 = this.gLm;
    AppMethodBeat.o(155880);
    return l1 - l2;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(258697);
    this.gLm = SystemClock.elapsedRealtime();
    AppMethodBeat.o(258697);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.util.f.a
 * JD-Core Version:    0.7.0.1
 */