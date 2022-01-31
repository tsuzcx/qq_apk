package com.tencent.mm.plugin.ipcall.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ipcall.a.g.d;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.ipcall.b.a;
import com.tencent.mm.sdk.platformtools.al;

final class b$1
  implements Runnable
{
  b$1(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(21969);
    if (System.currentTimeMillis() - this.nQQ.nQJ >= 500L)
    {
      this.nQQ.nQH = a.aE(this.nQQ.cmc, this.nQQ.nQF + this.nQQ.nQG);
      al.d(new b.1.1(this, i.bJt().Ra(this.nQQ.nQH)));
      AppMethodBeat.o(21969);
      return;
    }
    al.d(new b.1.2(this));
    AppMethodBeat.o(21969);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.b.1
 * JD-Core Version:    0.7.0.1
 */