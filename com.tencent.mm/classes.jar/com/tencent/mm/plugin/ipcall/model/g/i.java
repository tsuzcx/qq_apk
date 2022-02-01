package com.tencent.mm.plugin.ipcall.model.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.ipcall.model.b.b;
import com.tencent.mm.plugin.ipcall.model.b.c;
import com.tencent.mm.plugin.ipcall.model.e.o;
import com.tencent.mm.sdk.platformtools.ae;

public final class i
  extends b
{
  private int gwI = 0;
  private o vab = null;
  
  public final void Dg() {}
  
  public final void b(c paramc)
  {
    boolean bool = true;
    AppMethodBeat.i(25527);
    if (paramc == null) {}
    for (;;)
    {
      ae.d("MicroMsg.IPCallSyncService", "serviceImpl, info==null: %b", new Object[] { Boolean.valueOf(bool) });
      if (this.uWv != null)
      {
        this.gwI = this.uWv.uXp;
        this.vab = new o(this.uWv.roomId, this.uWv.uXg, this.uWv.dgO(), this.uWv.uXh, false);
        bc.ajj().a(this.vab, 0);
      }
      AppMethodBeat.o(25527);
      return;
      bool = false;
    }
  }
  
  public final int[] dgL()
  {
    return new int[] { 819 };
  }
  
  public final void dgM()
  {
    AppMethodBeat.i(25528);
    ae.d("MicroMsg.IPCallSyncService", "onLoopSuccess");
    AppMethodBeat.o(25528);
  }
  
  public final void dgN()
  {
    AppMethodBeat.i(25529);
    ae.d("MicroMsg.IPCallSyncService", "onLoopFailed");
    AppMethodBeat.o(25529);
  }
  
  public final int getServiceType()
  {
    return 2;
  }
  
  public final int getTimerInterval()
  {
    return this.gwI;
  }
  
  public final void onDestroy() {}
  
  public final void onStop()
  {
    AppMethodBeat.i(25526);
    if (this.vab != null) {
      bc.ajj().a(this.vab);
    }
    AppMethodBeat.o(25526);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.g.i
 * JD-Core Version:    0.7.0.1
 */