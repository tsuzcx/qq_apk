package com.google.android.exoplayer2.i;

import android.os.Trace;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class v
{
  public static void beginSection(String paramString)
  {
    AppMethodBeat.i(95946);
    if (x.SDK_INT >= 18) {
      Trace.beginSection(paramString);
    }
    AppMethodBeat.o(95946);
  }
  
  public static void endSection()
  {
    AppMethodBeat.i(95947);
    if (x.SDK_INT >= 18) {
      Trace.endSection();
    }
    AppMethodBeat.o(95947);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.exoplayer2.i.v
 * JD-Core Version:    0.7.0.1
 */