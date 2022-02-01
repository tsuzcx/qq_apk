package com.google.android.exoplayer2.i;

import android.os.Trace;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class v
{
  public static void beginSection(String paramString)
  {
    AppMethodBeat.i(93210);
    if (x.SDK_INT >= 18) {
      Trace.beginSection(paramString);
    }
    AppMethodBeat.o(93210);
  }
  
  public static void endSection()
  {
    AppMethodBeat.i(93211);
    if (x.SDK_INT >= 18) {
      Trace.endSection();
    }
    AppMethodBeat.o(93211);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.i.v
 * JD-Core Version:    0.7.0.1
 */