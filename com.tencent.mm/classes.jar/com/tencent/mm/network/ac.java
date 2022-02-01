package com.tencent.mm.network;

import com.tencent.mars.smc.SmcLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public final class ac
  extends q.a
{
  public final void a(final long paramLong, String paramString, final boolean paramBoolean1, final boolean paramBoolean2)
  {
    AppMethodBeat.i(143768);
    h.aHJ().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(143766);
        if (paramBoolean1)
        {
          SmcLogic.writeImportKvData(paramLong, paramBoolean2, this.mvZ, false);
          AppMethodBeat.o(143766);
          return;
        }
        SmcLogic.writeKvData(paramLong, paramBoolean2, this.mvZ, false);
        AppMethodBeat.o(143766);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(143767);
        String str = super.toString() + "|reportKV";
        AppMethodBeat.o(143767);
        return str;
      }
    });
    AppMethodBeat.o(143768);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.network.ac
 * JD-Core Version:    0.7.0.1
 */