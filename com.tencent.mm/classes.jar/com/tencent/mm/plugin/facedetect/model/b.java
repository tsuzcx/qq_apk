package com.tencent.mm.plugin.facedetect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  static boolean vA(long paramLong)
  {
    AppMethodBeat.i(103685);
    if (System.currentTimeMillis() - paramLong > 200L)
    {
      AppMethodBeat.o(103685);
      return true;
    }
    AppMethodBeat.o(103685);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.b
 * JD-Core Version:    0.7.0.1
 */