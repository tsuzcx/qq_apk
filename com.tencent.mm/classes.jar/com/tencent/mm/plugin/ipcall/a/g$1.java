package com.tencent.mm.plugin.ipcall.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.n.a;
import com.tencent.mm.plugin.ipcall.a.c.a;
import com.tencent.mm.sdk.platformtools.ab;

final class g$1
  extends n.a
{
  g$1(g paramg) {}
  
  public final void onNetworkChange(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(21743);
    ab.i("MicroMsg.IPCallSvrLogic", "onNetworkChange, st: %d", new Object[] { Integer.valueOf(paramInt) });
    if (i.bJo().nOf)
    {
      f localf = i.bJr();
      if ((localf.mCurrentState == 4) || (localf.mCurrentState == 5)) {
        i = 1;
      }
      if ((i != 0) && (paramInt == 4) && (this.nMw.nMr != null)) {
        this.nMw.nMr.a(this.nMw.nMs);
      }
    }
    AppMethodBeat.o(21743);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.g.1
 * JD-Core Version:    0.7.0.1
 */