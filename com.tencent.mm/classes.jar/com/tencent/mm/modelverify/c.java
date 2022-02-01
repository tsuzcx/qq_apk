package com.tencent.mm.modelverify;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;

public final class c
{
  public static long D(String paramString, long paramLong)
  {
    AppMethodBeat.i(20662);
    long l2 = 0L;
    long l1 = l2;
    if (paramString != null)
    {
      paramString = d.bNH().aLv(paramString);
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
  
  public static void h(long paramLong, String paramString)
  {
    AppMethodBeat.i(20663);
    Log.i("MicroMsg.FMessageLogic", "clearFMsgAndFConvByTalker, rowId: %d, talker: %s", new Object[] { Long.valueOf(paramLong), paramString });
    Log.i("MicroMsg.FMessageLogic", "clearFMsgAndFConvByTalker, delete fconversation, ret = ".concat(String.valueOf(d.bNI().S(paramLong, paramString))));
    Log.i("MicroMsg.FMessageLogic", "clearFMsgAndFConvByTalker, delete fmsginfo, ret = ".concat(String.valueOf(d.bNH().aLw(paramString))));
    AppMethodBeat.o(20663);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelverify.c
 * JD-Core Version:    0.7.0.1
 */