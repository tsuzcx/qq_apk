package com.tencent.mm.plugin.messenger.foundation.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.au;

public final class a
{
  public static long a(au paramau, int paramInt, long paramLong)
  {
    AppMethodBeat.i(43075);
    if (paramau == null)
    {
      AppMethodBeat.o(43075);
      return 0L;
    }
    if (paramLong != 0L) {}
    for (;;)
    {
      switch (paramInt)
      {
      default: 
        paramLong = a(paramau, paramLong);
        AppMethodBeat.o(43075);
        return paramLong;
        paramLong = bu.fpO();
      }
    }
    paramLong = a(paramau, paramLong);
    AppMethodBeat.o(43075);
    return paramLong | 0x0;
    paramLong = a(paramau, paramLong);
    AppMethodBeat.o(43075);
    return paramLong & 0xFFFFFFFF;
    paramLong = a(paramau, paramLong);
    AppMethodBeat.o(43075);
    return paramLong & 0x0;
    paramLong = a(paramau, paramLong);
    AppMethodBeat.o(43075);
    return paramLong | 0x0;
    paramLong = a(paramau, paramLong);
    AppMethodBeat.o(43075);
    return paramLong & 0xFFFFFFFF;
    paramLong = a(paramau, paramLong);
    AppMethodBeat.o(43075);
    return paramLong & 0x0;
  }
  
  public static long a(au paramau, long paramLong)
  {
    return paramau.field_flag & 0x0 | 0xFFFFFFFF & paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.a.a.a
 * JD-Core Version:    0.7.0.1
 */