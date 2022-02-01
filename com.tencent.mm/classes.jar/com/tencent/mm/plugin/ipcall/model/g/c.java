package com.tencent.mm.plugin.ipcall.model.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.ipcall.model.b.b;
import com.tencent.mm.plugin.ipcall.model.e.h;
import com.tencent.mm.sdk.platformtools.ae;

public final class c
  extends b
{
  private h uZX;
  
  public final void Dg() {}
  
  public final void b(com.tencent.mm.plugin.ipcall.model.b.c paramc)
  {
    AppMethodBeat.i(25516);
    if (this.uWv != null)
    {
      this.uZX = new h(this.uWv.roomId, this.uWv.uXg, this.uWv.uXh);
      bc.ajj().a(this.uZX, 0);
    }
    AppMethodBeat.o(25516);
  }
  
  public final int[] dgL()
  {
    return new int[] { 824 };
  }
  
  public final void dgM()
  {
    AppMethodBeat.i(25517);
    ae.d("MicroMsg.IPCallHeartBeatService", "heartbeat, onLoopSuccess");
    AppMethodBeat.o(25517);
  }
  
  public final void dgN()
  {
    AppMethodBeat.i(25518);
    ae.d("MicroMsg.IPCallHeartBeatService", "heartbeat, onLoopFailed");
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
    if (this.uZX != null) {
      bc.ajj().a(this.uZX);
    }
    AppMethodBeat.o(25515);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.g.c
 * JD-Core Version:    0.7.0.1
 */