package com.tencent.mm.plugin.messenger.foundation.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;

public final class a
{
  public static long a(am paramam, int paramInt, long paramLong)
  {
    AppMethodBeat.i(43075);
    if (paramam == null)
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
        paramLong = a(paramam, paramLong);
        AppMethodBeat.o(43075);
        return paramLong;
        paramLong = bt.eGO();
      }
    }
    paramLong = a(paramam, paramLong);
    AppMethodBeat.o(43075);
    return paramLong | 0x0;
    paramLong = a(paramam, paramLong);
    AppMethodBeat.o(43075);
    return paramLong & 0xFFFFFFFF;
    paramLong = a(paramam, paramLong);
    AppMethodBeat.o(43075);
    return paramLong & 0x0;
    paramLong = a(paramam, paramLong);
    AppMethodBeat.o(43075);
    return paramLong | 0x0;
    paramLong = a(paramam, paramLong);
    AppMethodBeat.o(43075);
    return paramLong & 0xFFFFFFFF;
    paramLong = a(paramam, paramLong);
    AppMethodBeat.o(43075);
    return paramLong & 0x0;
  }
  
  public static long a(am paramam, long paramLong)
  {
    return paramam.field_flag & 0x0 | 0xFFFFFFFF & paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.a.a.a
 * JD-Core Version:    0.7.0.1
 */