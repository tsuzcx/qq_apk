package com.tencent.mm.plugin.ipcall.model.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.ipcall.model.b.b;
import com.tencent.mm.plugin.ipcall.model.b.c;
import com.tencent.mm.plugin.ipcall.model.e.o;
import com.tencent.mm.sdk.platformtools.ad;

public final class i
  extends b
{
  private o sDT = null;
  private int sDU = 0;
  
  public final void Ca() {}
  
  public final void b(c paramc)
  {
    boolean bool = true;
    AppMethodBeat.i(25527);
    if (paramc == null) {}
    for (;;)
    {
      ad.d("MicroMsg.IPCallSyncService", "serviceImpl, info==null: %b", new Object[] { Boolean.valueOf(bool) });
      if (this.sAl != null)
      {
        this.sDU = this.sAl.sBh;
        this.sDT = new o(this.sAl.roomId, this.sAl.sAY, this.sAl.cHA(), this.sAl.sAZ, false);
        az.aeS().a(this.sDT, 0);
      }
      AppMethodBeat.o(25527);
      return;
      bool = false;
    }
  }
  
  public final int[] cHx()
  {
    return new int[] { 819 };
  }
  
  public final void cHy()
  {
    AppMethodBeat.i(25528);
    ad.d("MicroMsg.IPCallSyncService", "onLoopSuccess");
    AppMethodBeat.o(25528);
  }
  
  public final void cHz()
  {
    AppMethodBeat.i(25529);
    ad.d("MicroMsg.IPCallSyncService", "onLoopFailed");
    AppMethodBeat.o(25529);
  }
  
  public final int getServiceType()
  {
    return 2;
  }
  
  public final int getTimerInterval()
  {
    return this.sDU;
  }
  
  public final void onDestroy() {}
  
  public final void onStop()
  {
    AppMethodBeat.i(25526);
    if (this.sDT != null) {
      az.aeS().a(this.sDT);
    }
    AppMethodBeat.o(25526);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.g.i
 * JD-Core Version:    0.7.0.1
 */