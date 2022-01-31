package com.tencent.mm.network;

import com.tencent.mars.smc.SmcLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class y$1
  implements Runnable
{
  y$1(y paramy, boolean paramBoolean1, long paramLong, String paramString, boolean paramBoolean2) {}
  
  public final void run()
  {
    AppMethodBeat.i(72650);
    if (this.gen)
    {
      SmcLogic.writeImportKvData(this.geo, this.bBG, this.gep, false);
      AppMethodBeat.o(72650);
      return;
    }
    SmcLogic.writeKvData(this.geo, this.bBG, this.gep, false);
    AppMethodBeat.o(72650);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(72651);
    String str = super.toString() + "|reportKV";
    AppMethodBeat.o(72651);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.network.y.1
 * JD-Core Version:    0.7.0.1
 */