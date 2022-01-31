package com.tencent.mm.compatible.loader;

import android.os.Process;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class f$1
  extends bf<String>
{
  public f$1(f paramf)
  {
    super(2000L, null, (byte)0);
  }
  
  private static String zz()
  {
    for (;;)
    {
      String str = bk.am(ae.getContext(), Process.myPid());
      if (str != null) {
        break;
      }
      try
      {
        Thread.sleep(100L);
      }
      catch (InterruptedException localInterruptedException)
      {
        y.printErrStackTrace("MicroMsg.ProfileFactoryImpl", localInterruptedException, "", new Object[0]);
      }
    }
    return localInterruptedException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.compatible.loader.f.1
 * JD-Core Version:    0.7.0.1
 */