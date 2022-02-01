package com.tencent.mm.bj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bj;

public final class c
{
  public static long B(String paramString, long paramLong)
  {
    AppMethodBeat.i(20662);
    long l2 = 0L;
    long l1 = l2;
    if (paramString != null)
    {
      paramString = d.aML().aqR(paramString);
      l1 = l2;
      if (paramString != null) {
        l1 = paramString.field_createTime + 1L;
      }
    }
    if (l1 > paramLong * 1000L)
    {
      AppMethodBeat.o(20662);
      return l1;
    }
    AppMethodBeat.o(20662);
    return paramLong * 1000L;
  }
  
  public static void f(long paramLong, String paramString)
  {
    AppMethodBeat.i(20663);
    ae.i("MicroMsg.FMessageLogic", "clearFMsgAndFConvByTalker, rowId: %d, talker: %s", new Object[] { Long.valueOf(paramLong), paramString });
    ae.i("MicroMsg.FMessageLogic", "clearFMsgAndFConvByTalker, delete fconversation, ret = ".concat(String.valueOf(d.aMM().t(paramLong, paramString))));
    ae.i("MicroMsg.FMessageLogic", "clearFMsgAndFConvByTalker, delete fmsginfo, ret = ".concat(String.valueOf(d.aML().aqS(paramString))));
    AppMethodBeat.o(20663);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.bj.c
 * JD-Core Version:    0.7.0.1
 */