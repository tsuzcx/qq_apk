package com.tencent.mm.booter;

import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;

public final class h
{
  public static boolean we()
  {
    try
    {
      au.Hx();
      ah.d((Long)c.Dz().get(66817, null));
      if (ah.cn(0L) * 1000L > 1800000L) {
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.PostTaskMediaNoteStat", localException, "", new Object[0]);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.booter.h
 * JD-Core Version:    0.7.0.1
 */