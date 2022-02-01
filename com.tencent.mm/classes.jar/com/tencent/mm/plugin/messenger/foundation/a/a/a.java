package com.tencent.mm.plugin.messenger.foundation.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bb;

public final class a
{
  public static long a(bb parambb, int paramInt, long paramLong)
  {
    AppMethodBeat.i(43075);
    if (parambb == null)
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
        paramLong = a(parambb, paramLong);
        AppMethodBeat.o(43075);
        return paramLong;
        paramLong = Util.nowMilliSecond();
      }
    }
    paramLong = a(parambb, paramLong);
    AppMethodBeat.o(43075);
    return paramLong | 0x0;
    paramLong = a(parambb, paramLong);
    AppMethodBeat.o(43075);
    return paramLong & 0xFFFFFFFF;
    paramLong = a(parambb, paramLong);
    AppMethodBeat.o(43075);
    return paramLong & 0x0;
    paramLong = a(parambb, paramLong);
    AppMethodBeat.o(43075);
    return paramLong | 0x0;
    paramLong = a(parambb, paramLong);
    AppMethodBeat.o(43075);
    return paramLong & 0xFFFFFFFF;
    paramLong = a(parambb, paramLong);
    AppMethodBeat.o(43075);
    return paramLong & 0x0;
  }
  
  public static long a(bb parambb, long paramLong)
  {
    return parambb.field_flag & 0x0 | 0xFFFFFFFF & paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.a.a.a
 * JD-Core Version:    0.7.0.1
 */