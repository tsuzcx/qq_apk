package com.tencent.mm.plugin.ipcall.model.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.ipcall.model.b.b;
import com.tencent.mm.plugin.ipcall.model.e.h;
import com.tencent.mm.sdk.platformtools.ac;

public final class c
  extends b
{
  private h tLx;
  
  public final void BE() {}
  
  public final void b(com.tencent.mm.plugin.ipcall.model.b.c paramc)
  {
    AppMethodBeat.i(25516);
    if (this.tHV != null)
    {
      this.tLx = new h(this.tHV.roomId, this.tHV.tIG, this.tHV.tIH);
      az.agi().a(this.tLx, 0);
    }
    AppMethodBeat.o(25516);
  }
  
  public final int[] cUI()
  {
    return new int[] { 824 };
  }
  
  public final void cUJ()
  {
    AppMethodBeat.i(25517);
    ac.d("MicroMsg.IPCallHeartBeatService", "heartbeat, onLoopSuccess");
    AppMethodBeat.o(25517);
  }
  
  public final void cUK()
  {
    AppMethodBeat.i(25518);
    ac.d("MicroMsg.IPCallHeartBeatService", "heartbeat, onLoopFailed");
    AppMethodBeat.o(25518);
  }
  
  public final int getServiceType()
  {
    return 5;
  }
  
  public final int getTimerInterval()
  {
    return 50000;
  }
  
  public final void onDestroy() {}
  
  public final void onStop()
  {
    AppMethodBeat.i(25515);
    if (this.tLx != null) {
      az.agi().a(this.tLx);
    }
    AppMethodBeat.o(25515);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.g.c
 * JD-Core Version:    0.7.0.1
 */