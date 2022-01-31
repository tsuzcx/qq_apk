package com.tencent.mm.plugin.game.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class h$1$1
  implements Runnable
{
  h$1$1(h.1 param1) {}
  
  public final void run()
  {
    AppMethodBeat.i(111534);
    h.cancelDownload(this.npO.npM.field_appId);
    this.npO.npN.ig(false);
    AppMethodBeat.o(111534);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.a.h.1.1
 * JD-Core Version:    0.7.0.1
 */