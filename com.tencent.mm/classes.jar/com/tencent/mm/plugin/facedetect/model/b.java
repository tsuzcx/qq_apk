package com.tencent.mm.plugin.facedetect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  static boolean jH(long paramLong)
  {
    AppMethodBeat.i(160);
    if (System.currentTimeMillis() - paramLong > 200L)
    {
      AppMethodBeat.o(160);
      return true;
    }
    AppMethodBeat.o(160);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.b
 * JD-Core Version:    0.7.0.1
 */