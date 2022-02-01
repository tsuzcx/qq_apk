package com.tencent.mm.compatible.loader;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bp;
import com.tencent.mm.sdk.platformtools.bu;

public final class e$1
  extends bp<String>
{
  public e$1(e parame)
  {
    super(2000L, null, (byte)0);
  }
  
  private static String abi()
  {
    AppMethodBeat.i(155841);
    for (;;)
    {
      String str = bu.getProcessNameByPid(ak.getContext(), Process.myPid());
      if (str != null) {
        break;
      }
      try
      {
        Thread.sleep(100L);
      }
      catch (InterruptedException localInterruptedException)
      {
        ae.printErrStackTrace("MicroMsg.ProfileFactoryImpl", localInterruptedException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(155841);
    return localInterruptedException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.compatible.loader.e.1
 * JD-Core Version:    0.7.0.1
 */