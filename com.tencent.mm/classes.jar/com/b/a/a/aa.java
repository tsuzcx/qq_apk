package com.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.TimeZone;

final class aa
{
  private static long aL(long paramLong)
  {
    AppMethodBeat.i(88041);
    long l = TimeZone.getDefault().getOffset(paramLong);
    AppMethodBeat.o(88041);
    return l + paramLong;
  }
  
  static long aM(long paramLong)
  {
    AppMethodBeat.i(88042);
    paramLong = aL(paramLong) / 1000L;
    AppMethodBeat.o(88042);
    return paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.b.a.a.aa
 * JD-Core Version:    0.7.0.1
 */