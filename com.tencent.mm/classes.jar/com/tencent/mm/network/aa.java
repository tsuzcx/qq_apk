package com.tencent.mm.network;

import com.tencent.mars.smc.SmcLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.aq;

public final class aa
  extends o.a
{
  public final void reportKV(final long paramLong, String paramString, final boolean paramBoolean1, final boolean paramBoolean2)
  {
    AppMethodBeat.i(143768);
    g.afE().ax(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(143766);
        if (paramBoolean1)
        {
          SmcLogic.writeImportKvData(paramLong, paramBoolean2, this.hMl, false);
          AppMethodBeat.o(143766);
          return;
        }
        SmcLogic.writeKvData(paramLong, paramBoolean2, this.hMl, false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.network.aa
 * JD-Core Version:    0.7.0.1
 */