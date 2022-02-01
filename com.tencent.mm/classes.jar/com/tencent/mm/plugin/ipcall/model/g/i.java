package com.tencent.mm.plugin.ipcall.model.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.ipcall.model.b.b;
import com.tencent.mm.plugin.ipcall.model.b.c;
import com.tencent.mm.plugin.ipcall.model.e.o;
import com.tencent.mm.sdk.platformtools.Log;

public final class i
  extends b
{
  private int hjw = 0;
  private o ysB = null;
  
  public final void MC() {}
  
  public final void b(c paramc)
  {
    boolean bool = true;
    AppMethodBeat.i(25527);
    if (paramc == null) {}
    for (;;)
    {
      Log.d("MicroMsg.IPCallSyncService", "serviceImpl, info==null: %b", new Object[] { Boolean.valueOf(bool) });
      if (this.yoW != null)
      {
        this.hjw = this.yoW.ypQ;
        this.ysB = new o(this.yoW.roomId, this.yoW.ypH, this.yoW.eaI(), this.yoW.ypI, false);
        bg.azz().a(this.ysB, 0);
      }
      AppMethodBeat.o(25527);
      return;
      bool = false;
    }
  }
  
  public final int[] eaF()
  {
    return new int[] { 819 };
  }
  
  public final void eaG()
  {
    AppMethodBeat.i(25528);
    Log.d("MicroMsg.IPCallSyncService", "onLoopSuccess");
    AppMethodBeat.o(25528);
  }
  
  public final void eaH()
  {
    AppMethodBeat.i(25529);
    Log.d("MicroMsg.IPCallSyncService", "onLoopFailed");
    AppMethodBeat.o(25529);
  }
  
  public final int getServiceType()
  {
    return 2;
  }
  
  public final int getTimerInterval()
  {
    return this.hjw;
  }
  
  public final void onDestroy() {}
  
  public final void onStop()
  {
    AppMethodBeat.i(25526);
    if (this.ysB != null) {
      bg.azz().a(this.ysB);
    }
    AppMethodBeat.o(25526);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.g.i
 * JD-Core Version:    0.7.0.1
 */