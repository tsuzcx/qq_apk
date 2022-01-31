package com.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.TimeZone;

final class aa
{
  private static long aq(long paramLong)
  {
    AppMethodBeat.i(55696);
    long l = TimeZone.getDefault().getOffset(paramLong);
    AppMethodBeat.o(55696);
    return l + paramLong;
  }
  
  static long ar(long paramLong)
  {
    AppMethodBeat.i(55697);
    paramLong = aq(paramLong) / 1000L;
    AppMethodBeat.o(55697);
    return paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.b.a.a.aa
 * JD-Core Version:    0.7.0.1
 */