package com.tencent.mm.plugin.messenger.foundation.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ak;

public final class a
{
  public static long a(ak paramak, int paramInt, long paramLong)
  {
    AppMethodBeat.i(60016);
    if (paramak == null)
    {
      AppMethodBeat.o(60016);
      return 0L;
    }
    if (paramLong != 0L) {}
    for (;;)
    {
      switch (paramInt)
      {
      default: 
        paramLong = a(paramak, paramLong);
        AppMethodBeat.o(60016);
        return paramLong;
        paramLong = bo.aoy();
      }
    }
    paramLong = a(paramak, paramLong);
    AppMethodBeat.o(60016);
    return paramLong | 0x0;
    paramLong = a(paramak, paramLong);
    AppMethodBeat.o(60016);
    return paramLong & 0xFFFFFFFF;
    paramLong = a(paramak, paramLong);
    AppMethodBeat.o(60016);
    return paramLong & 0x0;
    paramLong = a(paramak, paramLong);
    AppMethodBeat.o(60016);
    return paramLong | 0x0;
    paramLong = a(paramak, paramLong);
    AppMethodBeat.o(60016);
    return paramLong & 0xFFFFFFFF;
    paramLong = a(paramak, paramLong);
    AppMethodBeat.o(60016);
    return paramLong & 0x0;
  }
  
  public static long a(ak paramak, long paramLong)
  {
    return paramak.field_flag & 0x0 | 0xFFFFFFFF & paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.a.a.a
 * JD-Core Version:    0.7.0.1
 */