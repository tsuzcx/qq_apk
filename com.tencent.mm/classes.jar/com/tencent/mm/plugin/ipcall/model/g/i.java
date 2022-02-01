package com.tencent.mm.plugin.ipcall.model.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.ipcall.model.b.b;
import com.tencent.mm.plugin.ipcall.model.b.c;
import com.tencent.mm.plugin.ipcall.model.e.o;
import com.tencent.mm.sdk.platformtools.ad;

public final class i
  extends b
{
  private int gub = 0;
  private o uOo = null;
  
  public final void Dd() {}
  
  public final void b(c paramc)
  {
    boolean bool = true;
    AppMethodBeat.i(25527);
    if (paramc == null) {}
    for (;;)
    {
      ad.d("MicroMsg.IPCallSyncService", "serviceImpl, info==null: %b", new Object[] { Boolean.valueOf(bool) });
      if (this.uKI != null)
      {
        this.gub = this.uKI.uLC;
        this.uOo = new o(this.uKI.roomId, this.uKI.uLt, this.uKI.ddW(), this.uKI.uLu, false);
        ba.aiU().a(this.uOo, 0);
      }
      AppMethodBeat.o(25527);
      return;
      bool = false;
    }
  }
  
  public final int[] ddT()
  {
    return new int[] { 819 };
  }
  
  public final void ddU()
  {
    AppMethodBeat.i(25528);
    ad.d("MicroMsg.IPCallSyncService", "onLoopSuccess");
    AppMethodBeat.o(25528);
  }
  
  public final void ddV()
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
    return this.gub;
  }
  
  public final void onDestroy() {}
  
  public final void onStop()
  {
    AppMethodBeat.i(25526);
    if (this.uOo != null) {
      ba.aiU().a(this.uOo);
    }
    AppMethodBeat.o(25526);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.g.i
 * JD-Core Version:    0.7.0.1
 */