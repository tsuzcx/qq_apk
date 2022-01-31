package com.tencent.mm.plugin.ipcall.a;

import com.tencent.mm.network.n.a;
import com.tencent.mm.plugin.ipcall.a.c.a;
import com.tencent.mm.sdk.platformtools.y;

final class g$1
  extends n.a
{
  g$1(g paramg) {}
  
  public final void et(int paramInt)
  {
    int i = 0;
    y.i("MicroMsg.IPCallSvrLogic", "onNetworkChange, st: %d", new Object[] { Integer.valueOf(paramInt) });
    if (i.bch().lqJ)
    {
      f localf = i.bck();
      if ((localf.mCurrentState == 4) || (localf.mCurrentState == 5)) {
        i = 1;
      }
      if ((i != 0) && (paramInt == 4) && (this.lpa.loV != null)) {
        this.lpa.loV.a(this.lpa.loW);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.g.1
 * JD-Core Version:    0.7.0.1
 */