package com.tencent.mm.bh;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.ax;
import com.tencent.mm.storage.ay;

public final class c
{
  public static void g(long paramLong, String paramString)
  {
    y.i("MicroMsg.FMessageLogic", "clearFMsgAndFConvByTalker, rowId: %d, talker: %s", new Object[] { Long.valueOf(paramLong), paramString });
    boolean bool = d.RY().p(paramLong, paramString);
    y.i("MicroMsg.FMessageLogic", "clearFMsgAndFConvByTalker, delete fconversation, ret = " + bool);
    bool = d.RX().Hr(paramString);
    y.i("MicroMsg.FMessageLogic", "clearFMsgAndFConvByTalker, delete fmsginfo, ret = " + bool);
  }
  
  public static long o(String paramString, long paramLong)
  {
    long l2 = 0L;
    long l1 = l2;
    if (paramString != null)
    {
      paramString = d.RX().abT(paramString);
      l1 = l2;
      if (paramString != null) {
        l1 = paramString.field_createTime + 1L;
      }
    }
    if (l1 > paramLong * 1000L) {
      return l1;
    }
    return paramLong * 1000L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.bh.c
 * JD-Core Version:    0.7.0.1
 */