package com.google.android.exoplayer2.i;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class t
  implements c
{
  public final long elapsedRealtime()
  {
    AppMethodBeat.i(95940);
    long l = SystemClock.elapsedRealtime();
    AppMethodBeat.o(95940);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.i.t
 * JD-Core Version:    0.7.0.1
 */