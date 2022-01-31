package com.tencent.mm.bi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.ax;
import com.tencent.mm.storage.ay;

public final class c
{
  public static void e(long paramLong, String paramString)
  {
    AppMethodBeat.i(16619);
    ab.i("MicroMsg.FMessageLogic", "clearFMsgAndFConvByTalker, rowId: %d, talker: %s", new Object[] { Long.valueOf(paramLong), paramString });
    ab.i("MicroMsg.FMessageLogic", "clearFMsgAndFConvByTalker, delete fconversation, ret = ".concat(String.valueOf(d.ali().p(paramLong, paramString))));
    ab.i("MicroMsg.FMessageLogic", "clearFMsgAndFConvByTalker, delete fmsginfo, ret = ".concat(String.valueOf(d.alh().Td(paramString))));
    AppMethodBeat.o(16619);
  }
  
  public static long x(String paramString, long paramLong)
  {
    AppMethodBeat.i(16618);
    long l2 = 0L;
    long l1 = l2;
    if (paramString != null)
    {
      paramString = d.alh().asd(paramString);
      l1 = l2;
      if (paramString != null) {
        l1 = paramString.field_createTime + 1L;
      }
    }
    if (l1 > paramLong * 1000L)
    {
      AppMethodBeat.o(16618);
      return l1;
    }
    AppMethodBeat.o(16618);
    return paramLong * 1000L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.bi.c
 * JD-Core Version:    0.7.0.1
 */