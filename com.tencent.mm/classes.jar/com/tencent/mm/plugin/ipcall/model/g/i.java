package com.tencent.mm.plugin.ipcall.model.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.ipcall.model.b.b;
import com.tencent.mm.plugin.ipcall.model.b.c;
import com.tencent.mm.plugin.ipcall.model.e.o;
import com.tencent.mm.sdk.platformtools.ac;

public final class i
  extends b
{
  private int gaC = 0;
  private o tLB = null;
  
  public final void BE() {}
  
  public final void b(c paramc)
  {
    boolean bool = true;
    AppMethodBeat.i(25527);
    if (paramc == null) {}
    for (;;)
    {
      ac.d("MicroMsg.IPCallSyncService", "serviceImpl, info==null: %b", new Object[] { Boolean.valueOf(bool) });
      if (this.tHV != null)
      {
        this.gaC = this.tHV.tIP;
        this.tLB = new o(this.tHV.roomId, this.tHV.tIG, this.tHV.cUL(), this.tHV.tIH, false);
        az.agi().a(this.tLB, 0);
      }
      AppMethodBeat.o(25527);
      return;
      bool = false;
    }
  }
  
  public final int[] cUI()
  {
    return new int[] { 819 };
  }
  
  public final void cUJ()
  {
    AppMethodBeat.i(25528);
    ac.d("MicroMsg.IPCallSyncService", "onLoopSuccess");
    AppMethodBeat.o(25528);
  }
  
  public final void cUK()
  {
    AppMethodBeat.i(25529);
    ac.d("MicroMsg.IPCallSyncService", "onLoopFailed");
    AppMethodBeat.o(25529);
  }
  
  public final int getServiceType()
  {
    return 2;
  }
  
  public final int getTimerInterval()
  {
    return this.gaC;
  }
  
  public final void onDestroy() {}
  
  public final void onStop()
  {
    AppMethodBeat.i(25526);
    if (this.tLB != null) {
      az.agi().a(this.tLB);
    }
    AppMethodBeat.o(25526);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.g.i
 * JD-Core Version:    0.7.0.1
 */