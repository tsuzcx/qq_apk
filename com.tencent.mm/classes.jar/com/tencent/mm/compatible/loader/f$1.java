package com.tencent.mm.compatible.loader;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.bo;

public final class f$1
  extends bj<String>
{
  public f$1(f paramf)
  {
    super(2000L, null, (byte)0);
  }
  
  private static String Mc()
  {
    AppMethodBeat.i(93036);
    for (;;)
    {
      String str = bo.az(ah.getContext(), Process.myPid());
      if (str != null) {
        break;
      }
      try
      {
        Thread.sleep(100L);
      }
      catch (InterruptedException localInterruptedException)
      {
        ab.printErrStackTrace("MicroMsg.ProfileFactoryImpl", localInterruptedException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(93036);
    return localInterruptedException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.compatible.loader.f.1
 * JD-Core Version:    0.7.0.1
 */